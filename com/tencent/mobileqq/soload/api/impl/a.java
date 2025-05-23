package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, Object> f288547j;

    /* renamed from: a, reason: collision with root package name */
    LoadParam f288548a;

    /* renamed from: b, reason: collision with root package name */
    LoadParam.LoadItem f288549b;

    /* renamed from: c, reason: collision with root package name */
    int f288550c;

    /* renamed from: d, reason: collision with root package name */
    boolean f288551d;

    /* renamed from: e, reason: collision with root package name */
    boolean f288552e;

    /* renamed from: f, reason: collision with root package name */
    String f288553f;

    /* renamed from: g, reason: collision with root package name */
    String f288554g;

    /* renamed from: h, reason: collision with root package name */
    SoDetailInfo f288555h;

    /* renamed from: i, reason: collision with root package name */
    String f288556i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f288547j = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoadParam loadParam, LoadParam.LoadItem loadItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadParam, (Object) loadItem);
            return;
        }
        this.f288551d = false;
        this.f288552e = true;
        this.f288548a = loadParam;
        this.f288549b = loadItem;
    }

    private static boolean a(String str, long j3, LoadParam.LoadItem loadItem, SoDetailInfo soDetailInfo, int i3) {
        long j16;
        boolean z16;
        if (j3 == -1 && soDetailInfo.crc == -1) {
            QLog.i("SoLoadWidget.AbsGetSoTask", 1, "[checkCRCAndUnzip] skip crc valid");
            return true;
        }
        long j17 = soDetailInfo.crc;
        if (j17 != -1) {
            z16 = true;
            j16 = j17;
        } else {
            j16 = j3;
            z16 = false;
        }
        long cRC32Value = IOUtil.getCRC32Value(new File(str));
        QLog.i("SoLoadWidget.AbsGetSoTask", 1, "[checkCRCAndUnzip] correctCRC=" + j16 + ",curCRC:" + cRC32Value + ",configSoFilePath:" + str + ",from:" + i3);
        if (j16 == cRC32Value) {
            return true;
        }
        com.tencent.mobileqq.soload.util.f.K(loadItem.name);
        return com.tencent.mobileqq.soload.util.f.w().getResPathSyncWithUnZip(loadItem.soFileName, soDetailInfo.url, soDetailInfo.md5, z16, j16, cRC32Value, loadItem.name + "_" + soDetailInfo.ver, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str, long j3, LoadParam.LoadItem loadItem, SoDetailInfo soDetailInfo, int i3) {
        Object obj;
        boolean a16;
        if ((loadItem.lops.flag & 8) != 0) {
            return true;
        }
        Map<String, Object> map = f288547j;
        synchronized (map) {
            obj = map.get(loadItem.name);
            if (obj == null) {
                obj = new byte[0];
                map.put(loadItem.name, obj);
            }
        }
        synchronized (obj) {
            a16 = a(str, j3, loadItem, soDetailInfo, i3);
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d() {
        if (!com.tencent.mobileqq.soload.util.f.H()) {
            return 0;
        }
        try {
            return am.s().f(526, com.tencent.mobileqq.soload.util.f.f());
        } catch (Throwable th5) {
            QLog.e("SoLoadWidget.AbsGetSoTask", 1, th5, new Object[0]);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean f(@NonNull SoLocalInfo soLocalInfo, @NonNull SoDetailInfo soDetailInfo) {
        if (soDetailInfo.relatedFileInfo != null) {
            if (TextUtils.isEmpty(soLocalInfo.mRFileFolder) || !new File(soLocalInfo.mRFileFolder).exists()) {
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SoLoadInfo c(int i3) {
        SoLoadInfo soLoadInfo = new SoLoadInfo();
        soLoadInfo.curCode = i3;
        soLoadInfo.soPathToLoad = this.f288553f;
        soLoadInfo.subErrCode = this.f288550c;
        soLoadInfo.isFinishDownload = this.f288551d;
        soLoadInfo.isNeedDownload = this.f288552e;
        soLoadInfo.soDetailInfo = this.f288555h;
        soLoadInfo.rFileFolder = this.f288554g;
        soLoadInfo.failDetail = this.f288556i;
        return soLoadInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(SoInfo soInfo) {
        boolean z16;
        SoDetailInfo soDetailInfo;
        if (soInfo != null) {
            if (com.tencent.mobileqq.soload.util.e.d()) {
                soDetailInfo = soInfo.arm64Info;
            } else {
                soDetailInfo = soInfo.arm32Info;
            }
            this.f288555h = soDetailInfo;
        }
        SoDetailInfo soDetailInfo2 = this.f288555h;
        if (soDetailInfo2 != null && !TextUtils.isEmpty(soDetailInfo2.url)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.AbsGetSoTask", 2, "[initConfig] isConfValid=" + z16 + ",info:" + soInfo + ",is64:" + com.tencent.mobileqq.soload.util.e.d());
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(@NonNull SoLocalInfo soLocalInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) soLocalInfo)).booleanValue();
        }
        if (!TextUtils.isEmpty(soLocalInfo.mSoPath) && new File(soLocalInfo.mSoPath).exists()) {
            return true;
        }
        return false;
    }
}
