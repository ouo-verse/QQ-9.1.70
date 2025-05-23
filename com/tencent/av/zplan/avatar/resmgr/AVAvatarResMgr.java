package com.tencent.av.zplan.avatar.resmgr;

import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.zplan.avatar.resmgr.b;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVAvatarResMgr {

    /* renamed from: n, reason: collision with root package name */
    private static volatile AVAvatarResMgr f77301n;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<AVAvatarResInfo> f77302a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f77303b = false;

    /* renamed from: c, reason: collision with root package name */
    private b f77304c = null;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b.c> f77305d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private int f77306e = 0;

    /* renamed from: f, reason: collision with root package name */
    private b.d f77307f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.av.zplan.avatar.resmgr.c f77308g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f77309h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f77310i;

    /* renamed from: j, reason: collision with root package name */
    boolean f77311j;

    /* renamed from: k, reason: collision with root package name */
    boolean f77312k;

    /* renamed from: l, reason: collision with root package name */
    c f77313l;

    /* renamed from: m, reason: collision with root package name */
    Runnable f77314m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements b.d {
        a() {
        }

        @Override // com.tencent.av.zplan.avatar.resmgr.b.d
        public void a(AVAvatarResInfo aVAvatarResInfo, int i3, int i16) {
            AVAvatarResMgr.this.J(aVAvatarResInfo.f77300id, i3);
        }

        @Override // com.tencent.av.zplan.avatar.resmgr.b.d
        public void b(AVAvatarResInfo aVAvatarResInfo, int i3, int i16) {
            QLog.i("AVAvatarResMgr", 1, "onDownloadStateChanged. state: " + i3 + ". " + aVAvatarResInfo);
            if (i3 == 1 && AVAvatarResMgr.A(aVAvatarResInfo.f77300id) && aVAvatarResInfo.f77300id.equalsIgnoreCase("LightSDKSettings") && TextUtils.isEmpty(AVAvatarResMgr.this.x(aVAvatarResInfo.f77300id).url)) {
                for (int i17 = 0; i17 < AVAvatarResMgr.this.f77302a.size(); i17++) {
                    if (((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).f77300id.equalsIgnoreCase(aVAvatarResInfo.f77300id)) {
                        ((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).url = aVAvatarResInfo.url;
                        ((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).md5 = aVAvatarResInfo.md5;
                        ((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).dir = aVAvatarResInfo.dir;
                        ((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).fileName = aVAvatarResInfo.fileName;
                        ((AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i17)).isZip = aVAvatarResInfo.isZip;
                    }
                }
            }
            AVAvatarResMgr.this.K(aVAvatarResInfo.f77300id, i3);
            AVAvatarResMgr.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void onDownloadFinish(boolean z16);

        void onDownloadProgress(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void onRequestFinish(boolean z16);
    }

    AVAvatarResMgr() {
        a aVar = new a();
        this.f77307f = aVar;
        this.f77308g = new com.tencent.av.zplan.avatar.resmgr.c(aVar);
        this.f77309h = null;
        this.f77310i = false;
        this.f77311j = false;
        this.f77312k = false;
        this.f77313l = null;
        this.f77314m = null;
        y();
    }

    public static boolean A(String str) {
        if (!str.equalsIgnoreCase("LightFaceModelLowVersion") && !str.equalsIgnoreCase("AEKit3DMMLowVersion") && !str.equalsIgnoreCase("LightSDKSettings")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        BaseApplicationImpl.getApplication();
        return BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
    }

    private boolean E(String str) {
        ArrayList<AVAvatarResInfo> b16 = AVAvatarLightSDKSettingsResJsonConfig.b();
        boolean z16 = false;
        for (int i3 = 0; i3 < b16.size(); i3++) {
            AVAvatarResInfo aVAvatarResInfo = b16.get(i3);
            int i16 = 0;
            while (true) {
                if (i16 >= this.f77302a.size()) {
                    break;
                }
                if (this.f77302a.get(i16).f77300id.equalsIgnoreCase(aVAvatarResInfo.f77300id)) {
                    this.f77302a.get(i16).url = aVAvatarResInfo.url;
                    this.f77302a.get(i16).md5 = aVAvatarResInfo.md5;
                    this.f77302a.get(i16).dir = aVAvatarResInfo.dir;
                    this.f77302a.get(i16).fileName = aVAvatarResInfo.fileName;
                    this.f77302a.get(i16).isZip = aVAvatarResInfo.isZip;
                    if (str.equalsIgnoreCase(aVAvatarResInfo.f77300id)) {
                        z16 = o(str);
                    }
                } else {
                    i16++;
                }
            }
        }
        return z16;
    }

    private void H() {
        for (int i3 = 0; i3 < this.f77305d.size(); i3++) {
            this.f77305d.get(i3).f77328b = 0;
            this.f77305d.get(i3).f77329c = 0;
        }
        this.f77306e = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, int i3) {
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= this.f77305d.size()) {
                break;
            }
            if (this.f77305d.get(i17).f77327a.f77300id.equalsIgnoreCase(str)) {
                this.f77305d.get(i17).f77329c = i3;
                break;
            }
            i17++;
        }
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < this.f77305d.size(); i26++) {
            if (this.f77305d.get(i26).f77328b != 0) {
                i18++;
                i19 += this.f77305d.get(i26).f77329c;
            }
        }
        if (i18 > 0) {
            i16 = i19 / i18;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVAvatarResMgr", 1, "updateDownloadInfoProgressList. resId: " + str + ", progress: " + i3);
        }
        if (this.f77304c != null && i16 > this.f77306e) {
            this.f77306e = i16;
            QLog.i("AVAvatarResMgr", 1, "updateDownloadInfoProgressList. globalProgress: " + i16);
            this.f77304c.onDownloadProgress(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, int i3) {
        for (int i16 = 0; i16 < this.f77305d.size(); i16++) {
            if (this.f77305d.get(i16).f77327a.f77300id.equalsIgnoreCase(str)) {
                this.f77305d.get(i16).f77328b = i3;
                if (i3 == 1) {
                    QLog.i("AVAvatarResMgr", 1, "updateDownloadInfoStateList. resId: " + str + ", checkResValid: " + o(str) + ".");
                }
                if (i3 != 2 && !B()) {
                    AVAvatarResInfo x16 = x(str);
                    QLog.i("AVAvatarResMgr", 1, "ResDownloadReport.sendData. state: " + i3 + ". " + x16);
                    com.tencent.av.so.b.c("QAV_RES_DOWNLOAD_EVENT", x16.f77300id, x16.url, x16.md5, i3);
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        boolean z16;
        boolean z17;
        int i3 = 0;
        while (true) {
            if (i3 < this.f77305d.size()) {
                if (this.f77305d.get(i3).f77328b == 2) {
                    z16 = false;
                    break;
                }
                i3++;
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            int i16 = 0;
            while (true) {
                if (i16 < this.f77305d.size()) {
                    int i17 = this.f77305d.get(i16).f77328b;
                    if (i17 != 0 && i17 != 1) {
                        z17 = false;
                        break;
                    }
                    i16++;
                } else {
                    z17 = true;
                    break;
                }
            }
            QLog.i("AVAvatarResMgr", 1, "checkDownloadInfoList. isAllResDownloadSuccess: " + z17);
            Runnable runnable = this.f77309h;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
                this.f77309h = null;
            }
            this.f77303b = false;
            b bVar = this.f77304c;
            if (bVar != null) {
                bVar.onDownloadFinish(z17);
                this.f77304c = null;
            }
        }
    }

    private static boolean m(AVAvatarResInfo aVAvatarResInfo) {
        File file = new File(aVAvatarResInfo.dir);
        if (!file.exists()) {
            QLog.e("AVAvatarResMgr", 1, "checkResValid failed. res id[" + aVAvatarResInfo.f77300id + "] res dir[" + aVAvatarResInfo.dir + "] not exist.");
            return false;
        }
        if (file.list().length != 0) {
            return true;
        }
        QLog.e("AVAvatarResMgr", 1, "checkResValid failed. res id[" + aVAvatarResInfo.f77300id + "] res dir[" + aVAvatarResInfo.dir + "] is empty.");
        return false;
    }

    private static boolean n(AVAvatarResInfo aVAvatarResInfo) {
        if (A(aVAvatarResInfo.f77300id)) {
            return m(aVAvatarResInfo);
        }
        boolean p16 = p(aVAvatarResInfo);
        if (!p16) {
            QLog.e("AVAvatarResMgr", 1, "checkResValid failed. res id[" + aVAvatarResInfo.f77300id + "].");
        }
        return p16;
    }

    private static boolean p(AVAvatarResInfo aVAvatarResInfo) {
        if (aVAvatarResInfo.f77300id.equalsIgnoreCase("LightResBody3DModel")) {
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
        }
        if (aVAvatarResInfo.f77300id.equalsIgnoreCase("LightResBasePackage")) {
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
        }
        if (aVAvatarResInfo.f77300id.equalsIgnoreCase("LightResPag")) {
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_PAG.agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
        }
        if (aVAvatarResInfo.f77300id.equalsIgnoreCase("LightResFilament")) {
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_FILAMENT.agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
        }
        return false;
    }

    public static void q() {
        if (f77301n != null) {
            synchronized (AVAvatarResMgr.class) {
                f77301n.I();
                f77301n = null;
            }
        }
    }

    private boolean r(AVAvatarResInfo aVAvatarResInfo) {
        QLog.i("AVAvatarResMgr", 1, "download. " + aVAvatarResInfo);
        return this.f77308g.c(aVAvatarResInfo);
    }

    public static String t() {
        return AVSoUtils.y() + "qavAvatarRes";
    }

    public static String u(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(t());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        sb5.append(str3);
        sb5.append(str2);
        return sb5.toString();
    }

    public static AVAvatarResMgr v() {
        if (f77301n == null) {
            synchronized (AVAvatarResMgr.class) {
                if (f77301n == null) {
                    f77301n = new AVAvatarResMgr();
                }
            }
        }
        return f77301n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVAvatarResInfo x(String str) {
        for (int i3 = 0; i3 < this.f77302a.size(); i3++) {
            if (this.f77302a.get(i3).f77300id.equalsIgnoreCase(str)) {
                return this.f77302a.get(i3);
            }
        }
        return null;
    }

    public void C(boolean z16) {
        if (!this.f77312k) {
            return;
        }
        QLog.i("AVAvatarResMgr", 1, "onRequestCDNServerUseState. isCDNOverload: " + z16);
        this.f77311j = z16;
        Runnable runnable = this.f77314m;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.f77314m = null;
        }
        this.f77312k = false;
        c cVar = this.f77313l;
        if (cVar != null) {
            cVar.onRequestFinish(this.f77311j);
            this.f77313l = null;
        }
    }

    public void D(int i3) {
        AVAvatarResInfo x16 = x("LightSDKSettings");
        if (i3 == 0) {
            ArrayList<AVAvatarResInfo> b16 = AVAvatarLightSDKSettingsResJsonConfig.b();
            if (b16.size() == 0) {
                if (x16 != null && TextUtils.isEmpty(x16.url)) {
                    K("LightSDKSettings", -1);
                    l();
                    return;
                }
                return;
            }
            if (x16 != null && TextUtils.isEmpty(x16.url)) {
                r(b16.get(0));
                return;
            } else {
                if (x16 != null) {
                    if (!b16.get(0).url.equalsIgnoreCase(x16.url) || !b16.get(0).md5.equalsIgnoreCase(x16.md5)) {
                        r(b16.get(0));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (x16 != null && TextUtils.isEmpty(x16.url)) {
            K("LightSDKSettings", -1);
            l();
        }
    }

    public void F(c cVar, int i3) {
        if (this.f77312k) {
            return;
        }
        QLog.i("AVAvatarResMgr", 1, "requestCDNServerUseState. timeoutMs: " + i3);
        this.f77312k = true;
        this.f77313l = cVar;
        if (i3 > 0) {
            Runnable runnable = new Runnable() { // from class: com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.3
                @Override // java.lang.Runnable
                public void run() {
                    AVAvatarResMgr aVAvatarResMgr = AVAvatarResMgr.this;
                    if (!aVAvatarResMgr.f77312k) {
                        return;
                    }
                    aVAvatarResMgr.f77311j = true;
                    QLog.e("AVAvatarResMgr", 1, "requestCDNServerUseState failed. timeout. mIsCDNOverload: " + AVAvatarResMgr.this.f77311j);
                    AVAvatarResMgr aVAvatarResMgr2 = AVAvatarResMgr.this;
                    aVAvatarResMgr2.f77312k = false;
                    c cVar2 = aVAvatarResMgr2.f77313l;
                    if (cVar2 != null) {
                        cVar2.onRequestFinish(aVAvatarResMgr2.f77311j);
                        AVAvatarResMgr.this.f77313l = null;
                    }
                }
            };
            this.f77314m = runnable;
            ThreadManagerV2.executeDelay(runnable, 16, null, true, i3);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("shadow_qqcamera");
        arrayList.add("xmaterial");
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (appInterface != null) {
            ((RequestCDNServerUseStateHandler) appInterface.getBusinessHandler(RequestCDNServerUseStateHandler.class.getName())).F2(arrayList);
        }
    }

    public void G(b bVar, int i3, boolean z16) {
        if (this.f77303b) {
            return;
        }
        this.f77303b = true;
        QLog.i("AVAvatarResMgr", 1, "requestUpdateAndDownloadResIfNeed. timeoutMs: " + i3 + ", isRequestUpdateJsonConfig: " + z16);
        this.f77304c = bVar;
        H();
        if (z16) {
            AVAvatarLightSDKSettingsResJsonConfig.d();
        }
        for (int i16 = 0; i16 < this.f77302a.size(); i16++) {
            String str = this.f77302a.get(i16).f77300id;
            int i17 = -1;
            if (str.equalsIgnoreCase("LightSDKSettings")) {
                if (!o(str) && !E(str)) {
                    AVAvatarResInfo x16 = x(str);
                    if (TextUtils.isEmpty(x16.url)) {
                        QLog.i("AVAvatarResMgr", 1, str + " url is empty.");
                        K(str, 2);
                    } else {
                        if (r(x16)) {
                            i17 = 2;
                        }
                        K(str, i17);
                    }
                }
            } else if (!o(str)) {
                if (r(x(str))) {
                    i17 = 2;
                }
                K(str, i17);
            }
        }
        if (i3 > 0) {
            Runnable runnable = new Runnable() { // from class: com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AVAvatarResMgr.this.f77303b) {
                        return;
                    }
                    QLog.e("AVAvatarResMgr", 1, "requestUpdateAndDownloadResIfNeed failed. timeout.");
                    AVAvatarResMgr.this.f77303b = false;
                    for (int i18 = 0; i18 < AVAvatarResMgr.this.f77302a.size(); i18++) {
                        AVAvatarResInfo aVAvatarResInfo = (AVAvatarResInfo) AVAvatarResMgr.this.f77302a.get(i18);
                        if (!AVAvatarResMgr.this.o(aVAvatarResInfo.f77300id) && !AVAvatarResMgr.this.B()) {
                            QLog.i("AVAvatarResMgr", 1, "ResDownloadReport.sendData. state: -5. " + aVAvatarResInfo);
                            com.tencent.av.so.b.c("QAV_RES_DOWNLOAD_EVENT", aVAvatarResInfo.f77300id, aVAvatarResInfo.url, aVAvatarResInfo.md5, -5);
                        }
                    }
                    if (AVAvatarResMgr.this.f77304c != null) {
                        AVAvatarResMgr.this.f77304c.onDownloadFinish(false);
                        AVAvatarResMgr.this.f77304c = null;
                    }
                }
            };
            this.f77309h = runnable;
            ThreadManagerV2.executeDelay(runnable, 16, null, true, i3);
        }
        l();
    }

    public void I() {
        if (!this.f77310i) {
            return;
        }
        this.f77308g.h();
        this.f77310i = false;
    }

    public boolean k() {
        for (int i3 = 0; i3 < this.f77302a.size(); i3++) {
            if (!n(this.f77302a.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public boolean o(String str) {
        return n(x(str));
    }

    public String s(String str) {
        if (!"LightFaceModelLowVersion".equalsIgnoreCase(str) && !"AEKit3DMMLowVersion".equalsIgnoreCase(str)) {
            return "";
        }
        return com.tencent.av.zplan.avatar.resmgr.a.a(str);
    }

    public String w(String str) {
        if (A(str)) {
            return x(str).dir;
        }
        return "";
    }

    public void y() {
        if (this.f77310i) {
            return;
        }
        ArrayList<AVAvatarResInfo> c16 = com.tencent.av.zplan.avatar.resmgr.a.c();
        if (c16.size() == 0) {
            QLog.e("AVAvatarResMgr", 1, "AVAvatarAIModelResInfo loadResInfoList failed. resInfoList.size() == 0.");
            this.f77302a.add(new AVAvatarResInfo("LightFaceModelLowVersion", "", ""));
            this.f77302a.add(new AVAvatarResInfo("AEKit3DMMLowVersion", "", ""));
        } else if (c16.size() < 2) {
            QLog.e("AVAvatarResMgr", 1, "AVAvatarAIModelResInfo loadResInfoList failed. resInfoList.size(): " + c16.size());
            if (!c16.get(0).f77300id.equalsIgnoreCase("LightFaceModelLowVersion")) {
                this.f77302a.add(new AVAvatarResInfo("LightFaceModelLowVersion", "", ""));
            } else {
                this.f77302a.add(new AVAvatarResInfo("AEKit3DMMLowVersion", "", ""));
            }
        } else {
            this.f77302a.add(c16.get(0));
            this.f77302a.add(c16.get(1));
        }
        ArrayList<AVAvatarResInfo> b16 = AVAvatarLightSDKSettingsResJsonConfig.b();
        if (b16.size() == 0) {
            QLog.e("AVAvatarResMgr", 1, "AVAvatarLightSDKSettingsResInfo loadResInfoList failed. resInfoList.size() == 0.");
            this.f77302a.add(new AVAvatarResInfo("LightSDKSettings", "", ""));
        } else {
            this.f77302a.add(b16.get(0));
        }
        this.f77302a.add(new AVAvatarResInfo("LightResBody3DModel", "", ""));
        this.f77302a.add(new AVAvatarResInfo("LightResBasePackage", "", ""));
        this.f77302a.add(new AVAvatarResInfo("LightResPag", "", ""));
        this.f77302a.add(new AVAvatarResInfo("LightResFilament", "", ""));
        for (int i3 = 0; i3 < this.f77302a.size(); i3++) {
            QLog.i("AVAvatarResMgr", 1, "loadResInfoList. " + this.f77302a.get(i3));
        }
        for (int i16 = 0; i16 < this.f77302a.size(); i16++) {
            n(this.f77302a.get(i16));
        }
        for (int i17 = 0; i17 < this.f77302a.size(); i17++) {
            b.c cVar = new b.c();
            cVar.f77327a = this.f77302a.get(i17);
            this.f77305d.add(cVar);
        }
        this.f77308g.e();
        this.f77310i = true;
    }

    public boolean z() {
        return this.f77311j;
    }
}
