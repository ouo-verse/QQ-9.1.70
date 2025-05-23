package com.qzone.personalize;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.widget.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import yo.d;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ArchiveMemorySettingGuide {

    /* renamed from: k, reason: collision with root package name */
    private static h<ArchiveMemorySettingGuide, Void> f49143k = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f49144a;

    /* renamed from: b, reason: collision with root package name */
    private int f49145b;

    /* renamed from: c, reason: collision with root package name */
    private long f49146c;

    /* renamed from: d, reason: collision with root package name */
    private long f49147d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Long> f49148e = Collections.synchronizedSet(new TreeSet(new b()));

    /* renamed from: f, reason: collision with root package name */
    final CountDownLatch f49149f = new CountDownLatch(1);

    /* renamed from: g, reason: collision with root package name */
    private String f49150g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Blog", "\u65e5\u5fd7");

    /* renamed from: h, reason: collision with root package name */
    private String f49151h = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ShuoShuo", "\u8bf4\u8bf4");

    /* renamed from: i, reason: collision with root package name */
    private String f49152i = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SetMemorySealOff", "\u8bbe\u7f6e\u5c01\u5b58\u65e5\u671f\uff0c\u5219\u6307\u5b9a\u65e5\u671f\u4e4b\u524d\u7684");

    /* renamed from: j, reason: collision with root package name */
    private String f49153j = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "OnlySelfAccess", "\u4ec5\u5bf9\u81ea\u5df1\u53ef\u89c1");

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends h<ArchiveMemorySettingGuide, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.proxy.feedcomponent.widget.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ArchiveMemorySettingGuide a(Void r16) {
            return new ArchiveMemorySettingGuide();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Comparator<Long> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Long l3, Long l16) {
            return l3.compareTo(l16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void D4(CharSequence charSequence);
    }

    ArchiveMemorySettingGuide() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.qzone.personalize.ArchiveMemorySettingGuide.3
            @Override // java.lang.Runnable
            public void run() {
                ArchiveMemorySettingGuide.this.f49145b = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_OPERATE_TIMES, 5);
                ArchiveMemorySettingGuide.this.f49146c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMORY_COLD_TIME, 7776000000L);
                ArchiveMemorySettingGuide.this.f49147d = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDAY_MEMOEY_OPERATE_FREQUENCY, 3600000L);
                ArchiveMemorySettingGuide.this.f49144a = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_CAN_ARCHIVE_INTERVAL, 172800000L);
                ArchiveMemorySettingGuide.this.A();
                ArchiveMemorySettingGuide.this.f49149f.countDown();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        QZLog.d("ArchiveMemorySettingGuide", 2, "readJournalFile");
        File p16 = p();
        File q16 = q();
        if (p16 != null && p16.exists() && p16.isFile()) {
            if (q16.exists()) {
                q16.delete();
            }
            B(p16, this.f49148e);
            return;
        }
        if (q16 != null && q16.exists() && q16.isFile()) {
            B(q16, this.f49148e);
        }
        QZLog.i("ArchiveMemorySettingGuide", 2, "readJournalFile:" + l(this.f49148e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0084 -> B:16:0x0093). Please report as a decompilation issue!!! */
    private void B(File file, Set<Long> set) {
        boolean isEmpty;
        if (file == null || !file.exists() || !file.isFile()) {
            return;
        }
        QZLog.d("ArchiveMemorySettingGuide", 2, "readList:" + file.getAbsolutePath());
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        BufferedReader bufferedReader4 = null;
        bufferedReader = null;
        try {
        } catch (IOException e16) {
            QZLog.w("ArchiveMemorySettingGuide", "", e16);
            bufferedReader = bufferedReader;
        }
        try {
            try {
                BufferedReader bufferedReader5 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader5.readLine();
                        isEmpty = TextUtils.isEmpty(readLine);
                        if (isEmpty != 0) {
                            break;
                        } else {
                            set.add(Long.valueOf(Long.parseLong(readLine.trim())));
                        }
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        bufferedReader2 = bufferedReader5;
                        QZLog.w("ArchiveMemorySettingGuide", "", e);
                        bufferedReader = bufferedReader2;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                            bufferedReader = bufferedReader2;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        bufferedReader3 = bufferedReader5;
                        QZLog.w("ArchiveMemorySettingGuide", "", e);
                        bufferedReader = bufferedReader3;
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                            bufferedReader = bufferedReader3;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        bufferedReader4 = bufferedReader5;
                        QZLog.w("ArchiveMemorySettingGuide", "", e);
                        bufferedReader = bufferedReader4;
                        if (bufferedReader4 != null) {
                            bufferedReader4.close();
                            bufferedReader = bufferedReader4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader5;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e26) {
                                QZLog.w("ArchiveMemorySettingGuide", "", e26);
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader5.close();
                bufferedReader = isEmpty;
            } catch (FileNotFoundException e27) {
                e = e27;
            } catch (IOException e28) {
                e = e28;
            } catch (Exception e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void C() {
        u5.b.s0("ArchiveMemorySettingGuide_dialog_cancel_time", n());
    }

    private void D(int i3, Set<Long> set) {
        if (set.size() < i3) {
            return;
        }
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < size - i3; i16++) {
            arrayList2.add((Long) arrayList.get(i16));
        }
        set.removeAll(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    File p16 = p();
                    if (p16 != null && p16.exists()) {
                        p16.delete();
                    }
                    p16.createNewFile();
                    File q16 = q();
                    if (q16 != null && q16.exists()) {
                        q16.renameTo(p16);
                    }
                    if (q16.exists()) {
                        q16.delete();
                    }
                    q16.createNewFile();
                    ArrayList arrayList = new ArrayList(this.f49148e);
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(q16));
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            bufferedWriter2.write(String.valueOf((Long) it.next()));
                            bufferedWriter2.newLine();
                        }
                        bufferedWriter2.flush();
                        p16.delete();
                        bufferedWriter2.close();
                    } catch (IOException e16) {
                        e = e16;
                        bufferedWriter = bufferedWriter2;
                        QZLog.w("ArchiveMemorySettingGuide", "", e);
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e17) {
                                QZLog.w("ArchiveMemorySettingGuide", "", e17);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e19) {
            QZLog.w("ArchiveMemorySettingGuide", "", e19);
        }
    }

    private void i() {
        File q16 = q();
        if (q16 != null && q16.exists()) {
            q16.delete();
        }
        File p16 = p();
        if (p16 != null && p16.exists()) {
            p16.delete();
        }
        this.f49148e.clear();
    }

    private void j(boolean z16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 622;
        if (z16) {
            lpReportInfo_pf00064.subactionType = 3;
        } else {
            lpReportInfo_pf00064.subactionType = 2;
        }
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void k() {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 622;
        lpReportInfo_pf00064.subactionType = 1;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private long n() {
        return System.currentTimeMillis();
    }

    public static ArchiveMemorySettingGuide o() {
        return f49143k.b(null);
    }

    private File p() {
        return new File(BaseApplicationImpl.getApplication().getFilesDir(), "deleteFeeds_jounal_backup_" + LoginData.getInstance().getUin());
    }

    private File q() {
        return new File(BaseApplicationImpl.getApplication().getFilesDir(), "deleteFeeds_jounal_" + LoginData.getInstance().getUin());
    }

    private String r(long j3) {
        return f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.ArchiveMemory_URL, "https://h5.qzone.qq.com/mood/keepmemos?_wv=3&uin={uin}&refer=guide"), j3);
    }

    private boolean s() {
        return LocalMultiProcConfig.getInt4Uin("qzone_memory_seal_key", 0, LoginData.getInstance().getUin()) != 0;
    }

    private boolean t() {
        if (this.f49148e.size() < this.f49145b) {
            return false;
        }
        ArrayList arrayList = new ArrayList(this.f49148e);
        long n3 = n();
        QZLog.i("ArchiveMemorySettingGuide", 2, "hitCount:" + l(this.f49148e));
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (n3 - ((Long) it.next()).longValue() <= this.f49147d) {
                i3++;
            }
        }
        return i3 >= this.f49145b;
    }

    private boolean u() {
        return n() - u5.b.I("ArchiveMemorySettingGuide_dialog_cancel_time", 0L) <= this.f49146c;
    }

    private void v() {
        d.d(r(LoginData.getInstance().getUin()), BaseApplicationImpl.sApplication, null);
    }

    private boolean E() {
        try {
            try {
                return this.f49149f.await(500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                QZLog.d("ArchiveMemorySettingGuide", 2, "", e16);
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public void w() {
        QZLog.d("ArchiveMemorySettingGuide", 2, "onCancel");
        C();
        j(false);
    }

    public void x() {
        QZLog.d("ArchiveMemorySettingGuide", 2, "onConfirm");
        v();
        j(true);
    }

    public boolean y(BusinessFeedData businessFeedData, c cVar) {
        if (businessFeedData == null) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "businessFeedData==null");
            return false;
        }
        if (businessFeedData.getFeedCommInfoV2() == null) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "businessFeedData.getFeedCommInfoV2()==null");
            return false;
        }
        if (s()) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "\u5df2\u7ecf\u4f7f\u7528\u8fc7\u8bb0\u5fc6\u5c01\u5b58");
            return false;
        }
        if (!h(businessFeedData)) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "\u6b64feeds\u4e0d\u80fd\u5c01\u5b58");
            return false;
        }
        if (u()) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "\u8ddd\u79bb\u4e0a\u4e00\u6b21\u51fa\u73b0\u5f15\u5bfc\u5f39\u7a97\u4e0d\u8d85\u8fc790\u5929");
            return false;
        }
        if (E()) {
            this.f49148e.add(Long.valueOf(n()));
            if (t()) {
                if (cVar == null) {
                    return false;
                }
                cVar.D4(m(businessFeedData.getFeedCommInfoV2().appid));
                return true;
            }
            D(this.f49145b, this.f49148e);
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.qzone.personalize.ArchiveMemorySettingGuide.4
                @Override // java.lang.Runnable
                public void run() {
                    ArchiveMemorySettingGuide.this.F();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("writeJournalFile:");
                    ArchiveMemorySettingGuide archiveMemorySettingGuide = ArchiveMemorySettingGuide.this;
                    sb5.append(archiveMemorySettingGuide.l(archiveMemorySettingGuide.f49148e));
                    QZLog.i("ArchiveMemorySettingGuide", 2, sb5.toString());
                }
            });
        }
        return false;
    }

    public void z() {
        QZLog.d("ArchiveMemorySettingGuide", 2, "onShow");
        i();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(Collection collection) {
        if (collection == null) {
            QZLog.d("ArchiveMemorySettingGuide", 2, "collection=null");
            return null;
        }
        return Arrays.toString(collection.toArray());
    }

    private CharSequence m(int i3) {
        SpannableString spannableString;
        if (i3 == 2) {
            spannableString = new SpannableString(this.f49150g);
        } else {
            spannableString = new SpannableString(this.f49151h);
        }
        return new SpannableStringBuilder(this.f49152i).append((CharSequence) spannableString).append((CharSequence) this.f49153j);
    }

    private boolean h(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && n() - businessFeedData.getFeedCommInfo().time > this.f49144a) {
            if (businessFeedData.getFeedCommInfo().appid != 311 && businessFeedData.getFeedCommInfo().appid != 2) {
                QZLog.d("ArchiveMemorySettingGuide", 2, "can not Archieve appid: " + businessFeedData.getFeedCommInfo().appid);
            } else {
                QZLog.d("ArchiveMemorySettingGuide", 2, "canArchieve appid: " + businessFeedData.getFeedCommInfo().appid);
                return true;
            }
        }
        return false;
    }
}
