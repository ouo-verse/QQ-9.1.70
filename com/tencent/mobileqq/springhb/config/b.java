package com.tencent.mobileqq.springhb.config;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile EntryConfigBean f288991a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f288992b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f288993c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288992b = new byte[0];
            this.f288993c = false;
        }
    }

    private void a() {
        try {
            synchronized (this.f288992b) {
                String str = "2024_spring_festival_redpacket_entry_config_" + b();
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("deleteLocalEntryConfig fileName=%s", str));
                File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                if (fileStreamPath.exists()) {
                    fileStreamPath.delete();
                }
            }
            v(0, 0, "");
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "deleteLocalEntryConfig fail.", e16);
        }
    }

    private String b() {
        QQAppInterface j3 = j();
        if (j3 != null) {
            return j3.getCurrentAccountUin();
        }
        return "";
    }

    private String d() {
        try {
            String str = "config_md5_" + b();
            return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("2024_spring_festival_redpacket_entry_config_" + str, "");
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "getLocalConfigMD5FromSP fail.", e16);
            return null;
        }
    }

    private int f() {
        int i3 = 0;
        try {
            String str = "config_version_" + b();
            i3 = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("2024_spring_festival_redpacket_entry_config_" + str, 0);
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, "getLocalConfigVersionFromSP version: " + i3);
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "getLocalConfigVersionFromSP fail.", e16);
        }
        return i3;
    }

    private int i() {
        int i3 = 0;
        try {
            String str = "peak_version_" + b();
            i3 = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("2024_spring_festival_redpacket_entry_config_" + str, 0);
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, "getLocalPeakVersionFromSP version: " + i3);
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "getLocalPeakVersionFromSP fail.", e16);
        }
        return i3;
    }

    private QQAppInterface j() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return null;
    }

    private String m(List<Integer> list) {
        if (list == null) {
            return "null";
        }
        return Arrays.toString(list.toArray());
    }

    @Nullable
    private EntryConfigBean o() {
        QLog.d("SpringHb_SpringHbEntranceConfProcessor", 1, "handleEmptyOrExceptionConfig !!!");
        a();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private EntryConfigBean p(int i3, int i16, int i17, String str, List<Integer> list) {
        Exception e16;
        EntryConfigBean entryConfigBean;
        JSONException e17;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, String.format("handleGetEntryConfig ver=%d pVer=%d delayList=%s", Integer.valueOf(i3), Integer.valueOf(i16), m(list)));
        }
        EntryConfigBean entryConfigBean2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
                entryConfigBean = new EntryConfigBean();
            } catch (JSONException e18) {
                e17 = e18;
                entryConfigBean = null;
            } catch (Exception e19) {
                e16 = e19;
                entryConfigBean = null;
            }
            try {
                entryConfigBean.parseJson(jSONObject);
                entryConfigBean.validate();
            } catch (JSONException e26) {
                e17 = e26;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(308, e17, new String[0]);
                }
                QLog.d("SpringHb_SpringHbEntranceConfProcessor", 1, e17.getMessage(), e17);
                entryConfigBean2 = entryConfigBean;
                if (entryConfigBean2 != null) {
                }
                return entryConfigBean2;
            } catch (Exception e27) {
                e16 = e27;
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 != null) {
                    ((ISpringHbReportApi) peekAppRuntime2.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(309, e16, new String[0]);
                }
                QLog.d("SpringHb_SpringHbEntranceConfProcessor", 1, e16.getMessage(), e16);
                entryConfigBean2 = entryConfigBean;
                if (entryConfigBean2 != null) {
                }
                return entryConfigBean2;
            }
            entryConfigBean2 = entryConfigBean;
            if (entryConfigBean2 != null) {
                entryConfigBean2.version = i3;
                entryConfigBean2.taskId = i17;
                entryConfigBean2.peakVersion = i16;
                entryConfigBean2.delayList.clear();
                if (list != null) {
                    entryConfigBean2.delayList.addAll(list);
                }
            }
        }
        return entryConfigBean2;
    }

    private EntryConfigBean q(EntryConfigBean entryConfigBean, int i3, List<Integer> list) {
        if (entryConfigBean == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, String.format("handleUpdatePeakDelay pVer=%d delayList=%s", Integer.valueOf(i3), m(list)));
        }
        entryConfigBean.peakVersion = i3;
        entryConfigBean.delayList.clear();
        if (list != null) {
            entryConfigBean.delayList.addAll(list);
        }
        return entryConfigBean;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00c8: MOVE (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:201), block:B:72:0x00c8 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private EntryConfigBean r() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Exception e16;
        EntryConfigBean entryConfigBean;
        ObjectInputStream objectInputStream2;
        synchronized (this.f288992b) {
            ObjectInputStream objectInputStream3 = null;
            try {
                try {
                    String str = "2024_spring_festival_redpacket_entry_config_" + b();
                    File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                    if (fileStreamPath.exists()) {
                        if (TextUtils.equals(d(), MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()))) {
                            fileInputStream = new FileInputStream(fileStreamPath);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream);
                                try {
                                    objectInputStream2 = new ObjectInputStream(bufferedInputStream);
                                } catch (Exception e17) {
                                    e = e17;
                                    e16 = e;
                                    QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "loadLocalEntryConfig fail.", e16);
                                    a();
                                    throw new RuntimeException("load local entry config ex." + e16.getMessage());
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (objectInputStream3 != null) {
                                        try {
                                            objectInputStream3.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                            throw th;
                                        } catch (Exception unused3) {
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e18) {
                                e = e18;
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedInputStream = null;
                            }
                            try {
                                entryConfigBean = (EntryConfigBean) objectInputStream2.readObject();
                                objectInputStream3 = objectInputStream2;
                                if (objectInputStream3 != null) {
                                    try {
                                        objectInputStream3.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused6) {
                                    }
                                }
                                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("loadLocalEntryConfig fileName=%s", str));
                            } catch (Exception e19) {
                                e16 = e19;
                                QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "loadLocalEntryConfig fail.", e16);
                                a();
                                throw new RuntimeException("load local entry config ex." + e16.getMessage());
                            }
                        } else {
                            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "loadLocalEntryConfig local config md5 not match.");
                            a();
                        }
                    }
                    bufferedInputStream = null;
                    fileInputStream = null;
                    entryConfigBean = null;
                    if (objectInputStream3 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("loadLocalEntryConfig fileName=%s", str));
                } catch (Exception e26) {
                    e = e26;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = null;
                    fileInputStream = null;
                }
            } catch (Throwable th8) {
                th = th8;
                objectInputStream3 = objectInputStream;
            }
        }
        return entryConfigBean;
    }

    private EntryConfigBean s() {
        try {
            return r();
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "loadLocalEntryConfigQuiet load local config ex.", th5);
            return null;
        }
    }

    private void v(int i3, int i16, String str) {
        QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("saveLocalConfigVersionToSP version=%s peakVersion=%s md5=%s", Integer.valueOf(i3), Integer.valueOf(i16), str));
        try {
            String str2 = "config_version_" + b();
            String str3 = "peak_version_" + b();
            String str4 = "config_md5_" + b();
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeInt("2024_spring_festival_redpacket_entry_config_" + str2, i3).encodeInt("2024_spring_festival_redpacket_entry_config_" + str3, i16).encodeString("2024_spring_festival_redpacket_entry_config_" + str4, str);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(311, e16, new String[0]);
            }
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "saveLocalConfigInfoToSP fail.", e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
    
        if (r8 == null) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[Catch: all -> 0x00ef, SYNTHETIC, TRY_ENTER, TryCatch #7 {, blocks: (B:22:0x008e, B:24:0x0091, B:27:0x0094, B:30:0x00e6, B:72:0x00eb, B:68:0x00f3, B:61:0x00f8, B:62:0x00fb, B:52:0x00db, B:48:0x00e0), top: B:4:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w(EntryConfigBean entryConfigBean) {
        BufferedOutputStream bufferedOutputStream;
        ObjectOutputStream objectOutputStream;
        synchronized (this.f288992b) {
            FileOutputStream fileOutputStream = null;
            try {
                String str = "2024_spring_festival_redpacket_entry_config_" + b();
                File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                File fileStreamPath2 = BaseApplication.getContext().getFileStreamPath(str + ".tmp");
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("saveLocalEntryConfig fileName=%s", str));
                if (fileStreamPath2.exists()) {
                    fileStreamPath2.delete();
                }
                fileStreamPath2.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileStreamPath2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                        try {
                            objectOutputStream.writeObject(entryConfigBean);
                            objectOutputStream.flush();
                            fileOutputStream2.flush();
                            if (fileStreamPath.exists()) {
                                fileStreamPath.delete();
                            }
                            fileStreamPath2.renameTo(fileStreamPath);
                            v(entryConfigBean.version, entryConfigBean.peakVersion, MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()));
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused) {
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            try {
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(310, e, new String[0]);
                                }
                                QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "saveLocalEntryConfig fail.", e);
                                a();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused6) {
                                    }
                                }
                                if (objectOutputStream == null) {
                                    try {
                                        objectOutputStream.close();
                                        throw th;
                                    } catch (Exception unused7) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                            if (objectOutputStream == null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        objectOutputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        objectOutputStream = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    bufferedOutputStream = null;
                    objectOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    bufferedOutputStream = null;
                    objectOutputStream = null;
                }
            } catch (Exception e19) {
                e = e19;
                bufferedOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                bufferedOutputStream = null;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.close();
            } catch (Exception unused8) {
            }
        }
    }

    private void x(EntryConfigBean entryConfigBean) {
        int size;
        QQAppInterface j3 = j();
        if (j3 == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("update entry config, activity size = ");
        boolean z16 = false;
        if (this.f288991a == null) {
            size = 0;
        } else {
            size = this.f288991a.activities.size();
        }
        sb5.append(size);
        QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, sb5.toString());
        this.f288991a = entryConfigBean;
        SpringFestivalEntryManager springFestivalEntryManager = (SpringFestivalEntryManager) j3.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (springFestivalEntryManager != null) {
            springFestivalEntryManager.c0(entryConfigBean);
        }
        if (this.f288991a != null) {
            z16 = true;
        }
        y(z16);
    }

    private void y(boolean z16) {
        ea.Q2(b(), z16);
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        long j3 = 0;
        try {
            String str = "last_req_adcode_" + b();
            j3 = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong("2024_spring_festival_redpacket_entry_config_" + str, 0L);
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, "getLastReqAdcodeFromSP adcode: " + j3);
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "getLastReqAdcodeFromSP fail.", e16);
        }
        return j3;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        k();
        if (this.f288991a != null) {
            return this.f288991a.version;
        }
        return f();
    }

    public EntryConfigBean g(boolean z16) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        if (this.f288991a == null && z16) {
            try {
                EntryConfigBean r16 = r();
                if (r16 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("update entry config, activity size = ");
                    if (this.f288991a == null) {
                        size = 0;
                    } else {
                        size = this.f288991a.activities.size();
                    }
                    sb5.append(size);
                    QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, sb5.toString());
                    this.f288991a = r16;
                }
            } catch (Exception e16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(305, e16, new String[0]);
                }
                QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "getLocalEntryConfig fail.", e16);
            }
        }
        return this.f288991a;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.f288991a != null) {
            return this.f288991a.peakVersion;
        }
        return i();
    }

    public EntryConfigBean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return g(true);
    }

    public EntryConfigBean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f288991a;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.f288991a != null) {
            return this.f288991a.taskId;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0147 A[Catch: all -> 0x019b, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x001f, B:13:0x0063, B:15:0x0069, B:16:0x007a, B:19:0x0084, B:22:0x00d2, B:24:0x00e3, B:26:0x00ea, B:28:0x00f0, B:33:0x0134, B:40:0x0176, B:42:0x0181, B:44:0x0194, B:49:0x00fb, B:53:0x010b, B:36:0x013f, B:38:0x0147, B:39:0x0159, B:58:0x0127, B:62:0x00ce, B:64:0x0082), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181 A[Catch: all -> 0x019b, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x0019, B:8:0x001f, B:13:0x0063, B:15:0x0069, B:16:0x007a, B:19:0x0084, B:22:0x00d2, B:24:0x00e3, B:26:0x00ea, B:28:0x00f0, B:33:0x0134, B:40:0x0176, B:42:0x0181, B:44:0x0194, B:49:0x00fb, B:53:0x010b, B:36:0x013f, B:38:0x0147, B:39:0x0159, B:58:0x0127, B:62:0x00ce, B:64:0x0082), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean t(boolean z16, boolean z17, int i3, int i16, int i17, String str, List<Integer> list, int i18, boolean z18, long j3) {
        EntryConfigBean entryConfigBean;
        boolean z19;
        QQAppInterface j16;
        AppRuntime peekAppRuntime;
        List<Integer> list2;
        int length;
        boolean z26;
        List<Integer> list3;
        EntryConfigBean o16;
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, list, Integer.valueOf(i18), Boolean.valueOf(z18), Long.valueOf(j3))).booleanValue();
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfProcessor", 2, String.format("onGetEntryConfig configContent:%s", str));
            }
            EntryConfigBean s16 = s();
            if (s16 == null) {
                list2 = null;
            } else {
                try {
                    list2 = s16.delayList;
                } catch (Exception e16) {
                    e = e16;
                    entryConfigBean = s16;
                    peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(307, e, new String[0]);
                    }
                    QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "onGetEntryConfig fail." + e.getMessage(), e);
                    z19 = false;
                    x(entryConfigBean);
                    this.f288993c = true;
                    j16 = j();
                    if (j16 != null) {
                    }
                    return z19;
                }
            }
            Object[] objArr = new Object[11];
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Boolean.valueOf(z17);
            objArr[3] = Integer.valueOf(i16);
            objArr[4] = Integer.valueOf(i17);
            objArr[5] = Integer.valueOf(i18);
            objArr[6] = m(list);
            objArr[7] = m(list2);
            objArr[8] = Boolean.valueOf(z18);
            objArr[9] = Long.valueOf(j3);
            if (str == null) {
                length = 0;
            } else {
                length = str.length();
            }
            objArr[10] = Integer.valueOf(length);
            QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("onGetEntryConfig() update=%s remoteVersion=%s peakUpdate=%s remotePeakVersion=%s taskId=%s reqOccasion=%s remoteDelayList=%s localDelayList=%s respSuc=%b adcode=%d, configContent length=%d", objArr));
            if (z18) {
                u(j3);
            }
            if (z16) {
                if (TextUtils.isEmpty(str)) {
                    o16 = o();
                } else {
                    if (z17) {
                        list3 = list;
                    } else {
                        list3 = list2;
                    }
                    entryConfigBean = p(i3, i16, i17, str, list3);
                    if (entryConfigBean == null) {
                        try {
                            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "onGetEntryConfig parse config fail.");
                            o16 = o();
                            z27 = false;
                            z26 = true;
                            boolean z28 = z27;
                            entryConfigBean = o16;
                            z19 = z28;
                        } catch (Exception e17) {
                            e = e17;
                            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime != null) {
                            }
                            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "onGetEntryConfig fail." + e.getMessage(), e);
                            z19 = false;
                            x(entryConfigBean);
                            this.f288993c = true;
                            j16 = j();
                            if (j16 != null) {
                            }
                            return z19;
                        }
                    } else {
                        o16 = entryConfigBean;
                    }
                }
                z27 = true;
                z26 = true;
                boolean z282 = z27;
                entryConfigBean = o16;
                z19 = z282;
            } else {
                if (z17) {
                    q(s16, i16, list);
                    z19 = true;
                    z26 = true;
                } else {
                    z26 = false;
                    z19 = true;
                }
                entryConfigBean = s16;
            }
            if (entryConfigBean != null && z26) {
                w(entryConfigBean);
            }
        } catch (Exception e18) {
            e = e18;
            entryConfigBean = null;
        }
        x(entryConfigBean);
        this.f288993c = true;
        j16 = j();
        if (j16 != null) {
            QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, "requestPreloadConfig");
            Manager manager = j16.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER);
            if (manager instanceof SpringHbPreloadManager) {
                ((SpringHbPreloadManager) manager).v(false, 3);
            }
        }
        return z19;
    }

    public void u(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        QLog.i("SpringHb_SpringHbEntranceConfProcessor", 1, String.format("saveLastReqAdcodeToSP adcode=%s", Long.valueOf(j3)));
        try {
            String str = "last_req_adcode_" + b();
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong("2024_spring_festival_redpacket_entry_config_" + str, j3);
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfProcessor", 1, "saveLastReqAdcodeToSP fail.", e16);
        }
    }
}
