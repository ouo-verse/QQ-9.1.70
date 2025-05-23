package com.tencent.halley.downloader.task;

import android.text.TextUtils;
import com.tencent.halley.NotProguard;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public class TaskDivider {
    static IPatchRedirector $redirector_;
    public volatile long costTime;
    private String etag;
    public volatile long flow;
    private List<DataSection> hijackSectionList;
    private String httpLastModified;
    public volatile long lastModified;
    private volatile int lastPercentage;
    private volatile long lastReceivedLength;
    public boolean parseOk;
    private List<DataSection> sectionList;
    public long startSize;
    public long totalLen;

    public TaskDivider(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.totalLen = -1L;
        this.startSize = 0L;
        this.lastModified = 0L;
        this.parseOk = false;
        this.costTime = 0L;
        this.flow = 0L;
        this.sectionList = new LinkedList();
        this.hijackSectionList = new LinkedList();
        this.etag = "";
        this.httpLastModified = "";
        this.lastReceivedLength = 0L;
        this.lastPercentage = 0;
        this.parseOk = false;
        init(str);
    }

    private long countReceivedLen() {
        long j3;
        long j16;
        long j17;
        synchronized (this.sectionList) {
            j3 = 0;
            for (DataSection dataSection : this.sectionList) {
                j3 += dataSection.save - dataSection.start;
            }
        }
        synchronized (this.hijackSectionList) {
            j16 = 0;
            for (DataSection dataSection2 : this.hijackSectionList) {
                j16 += dataSection2.end - dataSection2.start;
            }
            j17 = 0;
            for (DataSection dataSection3 : this.hijackSectionList) {
                j17 += dataSection3.save - dataSection3.start;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 <= 0) {
            return 0L;
        }
        return j18;
    }

    private long countReceivedLenAll() {
        long j3;
        synchronized (this.sectionList) {
            j3 = 0;
            for (DataSection dataSection : this.sectionList) {
                j3 += dataSection.save - dataSection.start;
            }
        }
        synchronized (this.hijackSectionList) {
            for (DataSection dataSection2 : this.hijackSectionList) {
                j3 += dataSection2.save - dataSection2.start;
            }
        }
        return j3;
    }

    private DataSection getSectionFromSectionList() {
        DataSection dataSection;
        DataSection dataSection2;
        synchronized (this.sectionList) {
            if (this.sectionList.size() == 0) {
                dataSection2 = new DataSection(this, 0L, 0L, 0L, -1L);
            } else {
                DataSection dataSection3 = this.sectionList.get(0);
                Iterator<DataSection> it = this.sectionList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        dataSection = it.next();
                        if (!dataSection.isRunning && dataSection.getRemain(this.totalLen) > 0) {
                            break;
                        }
                        if (dataSection.getRemain(this.totalLen) > dataSection3.getRemain(this.totalLen)) {
                            dataSection3 = dataSection;
                        }
                    } else {
                        dataSection = null;
                        break;
                    }
                }
                if (dataSection == null) {
                    long remain = dataSection3.getRemain(this.totalLen);
                    long j3 = dataSection3.read;
                    if (remain > com.tencent.halley.downloader.a.a.c() * 2) {
                        long j16 = j3 + (remain / 2);
                        DataSection dataSection4 = new DataSection(this, j16, j16, j16, dataSection3.end);
                        dataSection4.parentId = dataSection3.sectionId;
                        dataSection2 = dataSection4;
                    } else {
                        dataSection2 = null;
                    }
                } else {
                    dataSection2 = dataSection;
                }
            }
            if (dataSection2 != null) {
                dataSection2.isRunning = true;
            }
        }
        return dataSection2;
    }

    private void init(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.startSize = countReceivedLenAll();
                this.parseOk = true;
                return;
            }
            try {
                String[] split = str.split("\\|");
                if (split == null || split.length == 0 || !split[0].equals("3.0") || split.length < 7) {
                    return;
                }
                try {
                    this.totalLen = Long.parseLong(split[1]);
                    this.lastModified = Long.parseLong(split[2]);
                    this.costTime = Long.parseLong(split[3]);
                    this.flow = Long.parseLong(split[4]);
                    if (initSectionList(split)) {
                        return;
                    }
                    if (split.length >= 9) {
                        setEtag(split[7]);
                        setHttpLastModified(split[8]);
                    }
                    if (split.length >= 11 && initHijackSections(split)) {
                        return;
                    }
                    this.startSize = countReceivedLenAll();
                    this.parseOk = true;
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    d.b("TaskDivider", "parseLong for totalLen fail.", e16);
                }
            } catch (Exception unused) {
            }
        } catch (Exception e17) {
            this.parseOk = false;
            e17.printStackTrace();
        }
    }

    private boolean initHijackSections(String[] strArr) {
        for (String str : strArr[9].split(";")) {
            DataSection dataSection = new DataSection(this, str);
            if (dataSection.parseOk) {
                this.hijackSectionList.add(dataSection);
            } else {
                this.hijackSectionList.clear();
            }
        }
        try {
            String[] split = strArr[10].split(";");
            this.lastReceivedLength = Long.parseLong(split[0]);
            this.lastPercentage = Integer.parseInt(split[1]);
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return true;
        }
    }

    private boolean initSectionList(String[] strArr) {
        for (String str : strArr[5].split(";")) {
            DataSection dataSection = new DataSection(this, str);
            if (dataSection.parseOk) {
                this.sectionList.add(dataSection);
            } else {
                this.sectionList.clear();
                return true;
            }
        }
        return false;
    }

    public boolean addRealSection(DataSection dataSection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) dataSection)).booleanValue();
        }
        if (dataSection.sectionId != -1) {
            d.e("TaskDivider", "addRealSection of id " + dataSection.sectionId + " should not happen!!!");
            return false;
        }
        synchronized (this.sectionList) {
            int i3 = dataSection.parentId;
            if (i3 == -1) {
                if (this.sectionList.size() != 0) {
                    d.d("TaskDivider", "first section, list size should be 0!!!");
                    return false;
                }
                dataSection.sectionId = 0;
                dataSection.end = this.totalLen;
                this.sectionList.add(dataSection);
                return true;
            }
            if (i3 >= this.sectionList.size()) {
                d.e("TaskDivider", "parent id:" + dataSection.parentId + " wrong!!!");
                return false;
            }
            DataSection dataSection2 = null;
            for (DataSection dataSection3 : this.sectionList) {
                if (dataSection3.sectionId == dataSection.parentId) {
                    if (dataSection3.read >= dataSection3.end) {
                        return false;
                    }
                    if (dataSection3.read + com.tencent.halley.downloader.a.a.c() > dataSection.start) {
                        return false;
                    }
                    dataSection2 = dataSection3;
                } else if (dataSection3.end > dataSection.start && dataSection3.start < dataSection.end) {
                    return false;
                }
            }
            if (dataSection2 == null) {
                return false;
            }
            dataSection.sectionId = this.sectionList.size();
            dataSection2.end = dataSection.start;
            this.sectionList.add(dataSection);
            return true;
        }
    }

    public void addRedownloadSection(DataSection dataSection) {
        DataSection dataSection2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dataSection);
            return;
        }
        if (dataSection.end == -1 || dataSection.start >= dataSection.end) {
            return;
        }
        synchronized (this.hijackSectionList) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i17 < this.hijackSectionList.size()) {
                    dataSection2 = this.hijackSectionList.get(i17);
                    if (dataSection2.start == dataSection.start) {
                        i16 = i17;
                        break;
                    }
                    i17++;
                } else {
                    dataSection2 = null;
                    break;
                }
            }
            if (dataSection2 != null) {
                if (dataSection.end <= dataSection2.end) {
                    dataSection = dataSection2;
                }
                dataSection.sectionId = dataSection2.sectionId;
                dataSection.parentId = dataSection2.parentId;
                this.hijackSectionList.remove(i16);
                this.hijackSectionList.add(i16, dataSection);
                return;
            }
            int size = this.hijackSectionList.size();
            if (size > 0) {
                i3 = this.hijackSectionList.get(size - 1).sectionId + 1;
            } else {
                i3 = 10000;
            }
            dataSection.parentId = i3;
            dataSection.sectionId = i3;
            this.hijackSectionList.add(dataSection);
        }
    }

    public boolean checkAlreadyCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        long j3 = this.totalLen;
        if (j3 > 0 && j3 == countReceivedLen()) {
            return true;
        }
        return false;
    }

    public long getDownSizeThisTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return countReceivedLenAll() - this.startSize;
    }

    public int getHijackRollbackFlow() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        synchronized (this.hijackSectionList) {
            i3 = 0;
            for (DataSection dataSection : this.hijackSectionList) {
                i3 = (int) (i3 + (dataSection.save - dataSection.start));
            }
        }
        return i3;
    }

    public int getLastPercentage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.lastPercentage;
    }

    public long getLastReceivedLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.lastReceivedLength;
    }

    public DataSection getNextSection() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DataSection) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        DataSection sectionFromSectionList = getSectionFromSectionList();
        StringBuilder sb5 = new StringBuilder("nextSection: ");
        if (sectionFromSectionList != null) {
            str = sectionFromSectionList.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        d.b("TaskDivider", sb5.toString());
        if (sectionFromSectionList != null) {
            return sectionFromSectionList;
        }
        return getSectionFromHijackSectionList();
    }

    public long getReadLen() {
        long j3;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        synchronized (this.sectionList) {
            j3 = 0;
            for (DataSection dataSection : this.sectionList) {
                j3 += dataSection.read - dataSection.start;
            }
        }
        synchronized (this.hijackSectionList) {
            j16 = 0;
            for (DataSection dataSection2 : this.hijackSectionList) {
                j16 += dataSection2.end - dataSection2.start;
            }
            j17 = 0;
            for (DataSection dataSection3 : this.hijackSectionList) {
                j17 += dataSection3.read - dataSection3.start;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 <= 0) {
            return 0L;
        }
        return j18;
    }

    public long getReceivedLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return countReceivedLen();
    }

    public DataSection getSection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (DataSection) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        synchronized (this.sectionList) {
            try {
                try {
                    for (DataSection dataSection : this.sectionList) {
                        if (dataSection.sectionId == i3) {
                            return dataSection;
                        }
                    }
                } finally {
                }
            } catch (Exception e16) {
                d.a("TaskDivider", e16);
            }
            synchronized (this.hijackSectionList) {
                try {
                    try {
                        for (DataSection dataSection2 : this.hijackSectionList) {
                            if (dataSection2.sectionId == i3) {
                                return dataSection2;
                            }
                        }
                    } catch (Exception e17) {
                        d.a("TaskDivider", e17);
                    }
                    d.e("TaskDivider", "getSection fail. sectionId:" + i3 + ", divider:" + toDbText());
                    return null;
                } finally {
                }
            }
        }
    }

    public DataSection getSectionFromHijackSectionList() {
        DataSection dataSection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DataSection) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        synchronized (this.hijackSectionList) {
            Iterator<DataSection> it = this.hijackSectionList.iterator();
            while (true) {
                if (it.hasNext()) {
                    dataSection = it.next();
                    if (!dataSection.isRunning && dataSection.read != dataSection.end) {
                        break;
                    }
                } else {
                    dataSection = null;
                    break;
                }
            }
            if (dataSection != null) {
                dataSection.isRunning = true;
            }
        }
        return dataSection;
    }

    public boolean isReadFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        long readLen = getReadLen();
        if (readLen > 0 && readLen == this.totalLen) {
            return true;
        }
        return false;
    }

    public boolean isSelfSection(DataSection dataSection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataSection)).booleanValue();
        }
        if (dataSection.divider == this) {
            return true;
        }
        return false;
    }

    public void recordLastProgress(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (this.lastReceivedLength != 0 && this.lastReceivedLength > j3) {
            j3 = this.lastReceivedLength;
        }
        this.lastReceivedLength = j3;
        if (this.lastPercentage != 0 && this.lastPercentage > i3) {
            i3 = this.lastPercentage;
        }
        this.lastPercentage = i3;
    }

    public void releaseSection(DataSection dataSection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dataSection);
        } else {
            dataSection.isRunning = false;
        }
    }

    public void setEtag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && !str.equals("null")) {
            this.etag = str.replace("|", "");
        } else {
            this.etag = "";
        }
    }

    public void setHttpLastModified(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && !str.equals("null")) {
            this.httpLastModified = str.replace("|", "");
        } else {
            this.httpLastModified = "";
        }
    }

    public String toDbText() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("3.0");
        sb5.append("|");
        sb5.append(this.totalLen);
        sb5.append("|");
        sb5.append(this.lastModified);
        sb5.append("|");
        sb5.append(this.costTime);
        sb5.append("|");
        sb5.append(this.flow);
        sb5.append("|");
        synchronized (this.sectionList) {
            Iterator<DataSection> it = this.sectionList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toDbText());
                sb5.append(";");
            }
            if (this.sectionList.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append("null");
        sb5.append("|");
        if (TextUtils.isEmpty(this.etag)) {
            str = "null";
        } else {
            str = this.etag;
        }
        sb5.append(str);
        sb5.append("|");
        if (TextUtils.isEmpty(this.httpLastModified)) {
            str2 = "null";
        } else {
            str2 = this.httpLastModified;
        }
        sb5.append(str2);
        sb5.append("|");
        synchronized (this.hijackSectionList) {
            Iterator<DataSection> it5 = this.hijackSectionList.iterator();
            while (it5.hasNext()) {
                sb5.append(it5.next().toDbText());
                sb5.append(";");
            }
            if (this.hijackSectionList.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append(this.lastReceivedLength + ";" + this.lastPercentage);
        return sb5.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return toDbText();
    }
}
