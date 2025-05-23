package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class FileBrowserModelBase {
    protected cc1.a C;
    protected cc1.d D;
    protected f E;
    protected cc1.c F;
    protected e G;
    protected Bundle I;
    protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> K;
    protected String L;
    protected c M;

    /* renamed from: d, reason: collision with root package name */
    protected Activity f208346d;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.fileviewer.g f208348f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.core.f f208349h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.core.b f208350i;

    /* renamed from: m, reason: collision with root package name */
    protected g f208351m;

    /* renamed from: e, reason: collision with root package name */
    protected int f208347e = 0;
    protected HashMap<String, com.tencent.mobileqq.filemanager.fileviewer.data.d> J = new HashMap<>();
    protected int H = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements cc1.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f208355a;

        a(String str) {
            this.f208355a = str;
        }

        @Override // cc1.b
        public void a(com.tencent.mobileqq.filemanager.fileviewer.data.d dVar) {
            if (dVar != null) {
                FileBrowserModelBase.this.J.put(this.f208355a, dVar);
                FileBrowserModelBase.this.f208348f.K1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(String str);

        boolean b();

        boolean c(String str);

        String d();

        String e();

        void f(String str);

        int getImageType();

        URL getImageUrl();

        int getOrientation();

        boolean isLoading();

        void setState(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void h(int i3, String str, String str2, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void b();

        void n();

        void o();

        void s(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void k(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void a(float f16);

        void e();

        void f();

        void j();

        void l();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void c(long j3);

        void g(List<ZipFilePresenter.f> list, String str, String str2, String str3, String str4, boolean z16, String str5, short s16);

        void i(String str, String str2);
    }

    public FileBrowserModelBase(Activity activity) {
        this.f208346d = activity;
    }

    private boolean r0() {
        int G = G();
        if (G != 15 && G != 16 && G != 5 && G != 3 && G != 17) {
            return false;
        }
        return true;
    }

    public int A() {
        int V = V();
        if (r0() && ah.b1(N()) && R() != 16) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getCreateFileType: fileType" + V);
            if (V != 0) {
                if (V == 1) {
                    return 4;
                }
                int i3 = 2;
                if (V != 2) {
                    i3 = 5;
                    if (V != 4) {
                        if (V != 5) {
                            return 1;
                        }
                        return 3;
                    }
                    if (!e()) {
                        return 1;
                    }
                }
                return i3;
            }
            return 6;
        }
        if (QLog.isColorLevel()) {
            QLog.i(AppConstants.NEW_MY_COMPUTER, 1, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
        }
        return 0;
    }

    protected void A0() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.5
            @Override // java.lang.Runnable
            public void run() {
                ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniCode_FileBrowser");
            }
        });
    }

    public String B() {
        return "";
    }

    protected abstract void B0();

    public int C() {
        int i3 = this.f208347e;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public abstract cc1.a D();

    /* JADX INFO: Access modifiers changed from: protected */
    public void D0(int i3) {
        if (i3 != 52) {
            if (i3 != 118) {
                if (i3 != 55) {
                    if (i3 == 56) {
                        ReportController.o(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                ReportController.o(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
    }

    public String E() {
        return null;
    }

    public abstract void E0(int i3);

    public int F() {
        return this.H;
    }

    public abstract void F0(d dVar);

    public abstract int G();

    public boolean G0(d dVar) {
        if (dVar != null) {
            dVar.b();
            return false;
        }
        return false;
    }

    public com.tencent.mobileqq.colornote.f H() {
        return new bc1.c();
    }

    public void H0(Bundle bundle) {
        this.I = bundle;
        if (bundle != null && bundle.getInt("file_enter_file_browser_type", -1) != -1) {
            J0(bundle.getInt("file_enter_file_browser_type"));
        }
    }

    public abstract String I();

    public void I0(com.tencent.mobileqq.filemanager.fileviewer.g gVar) {
        this.f208348f = gVar;
    }

    public abstract String J();

    public void J0(int i3) {
        this.H = i3;
    }

    public String K() {
        return "";
    }

    public abstract void K0(int i3);

    public abstract String L();

    public abstract void L0(int i3);

    public abstract int M();

    public void M0(c cVar) {
        this.M = cVar;
    }

    public abstract String N();

    public void N0(e eVar) {
        this.G = eVar;
    }

    public abstract int O();

    public void O0(f fVar) {
        this.E = fVar;
    }

    public abstract long P();

    public void P0(g gVar) {
        this.f208351m = gVar;
    }

    public abstract long Q();

    public abstract void Q0(boolean z16);

    public abstract int R();

    public abstract float S();

    public abstract int T();

    public abstract int U();

    public abstract int V();

    public abstract List<b> W();

    public Intent X() {
        return null;
    }

    public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y();

    public abstract String Z();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull List<ShareActionSheetBuilder.ActionSheetItem> list, boolean z16) {
        if (!z16) {
            return;
        }
        if (V() == 0) {
            com.tencent.mobileqq.filemanager.fileviewer.data.d dVar = this.J.get(b0());
            if (dVar != null && dVar.c()) {
                return;
            }
        }
        String N = N();
        if (!((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported(N)) {
            return;
        }
        list.add(QFileUtils.c(166, com.tencent.mobileqq.filemanager.fileviewer.c.k(this.f208346d, N)));
    }

    public boolean a0() {
        return true;
    }

    public void b(@NonNull List<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.tencent.mobileqq.filemanager.fileviewer.data.d dVar;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> R;
        String b06 = b0();
        if (FileUtils.fileExistsAndNotEmpty(b06) && (dVar = this.J.get(b06)) != null && (R = QFileUtils.R(dVar)) != null && !R.isEmpty()) {
            list.addAll(R);
        }
    }

    public String b0() {
        return "";
    }

    public void c(final Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> action1) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.1
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] i06 = FileBrowserModelBase.this.i0();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        action1.call(i06);
                    }
                });
            }
        }, 16, null, true);
    }

    public abstract TeamWorkFileImportInfo c0();

    public abstract boolean d();

    public abstract cc1.c d0();

    public abstract boolean e();

    public int e0() {
        return this.f208346d.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public void f(List<ShareActionSheetBuilder.ActionSheetItem> list) {
        if (list == null) {
            return;
        }
        b(list);
        g();
    }

    public abstract long f0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        if (V() != 0) {
            return;
        }
        String b06 = b0();
        if (this.J.get(b06) != null) {
            return;
        }
        QFileUtils.g(this.f208346d, b06, new a(b06));
    }

    public abstract cc1.d g0();

    public boolean h() {
        return false;
    }

    public abstract String h0();

    public void i(List<ShareActionSheetBuilder.ActionSheetItem> list) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = this.K;
        if (arrayList != null && !arrayList.isEmpty()) {
            list.addAll(this.K);
        }
        this.K = null;
    }

    public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] i0();

    public abstract boolean j();

    public com.tencent.mobileqq.filemanager.fileviewer.data.b j0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void l0();

    public void m() {
        QLog.d("FileBrowserModelBase", 1, "doOnFinish");
        B0();
        if (this.E != null) {
            this.E = null;
        }
        if (this.G != null) {
            this.G = null;
        }
        if (this.f208351m != null) {
            this.f208351m = null;
        }
        A0();
    }

    protected void m0() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.4
            @Override // java.lang.Runnable
            public void run() {
                ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).init(FileBrowserModelBase.this.f208346d, hashCode(), "MiniCode_FileBrowser");
            }
        });
    }

    public void n() {
        if (this.E != null) {
            this.E = null;
        }
        if (this.G != null) {
            this.G = null;
        }
        if (this.f208351m != null) {
            this.f208351m = null;
        }
    }

    public abstract boolean n0();

    public void o() {
        l0();
        m0();
    }

    public abstract boolean o0();

    public abstract boolean p();

    public boolean p0() {
        Bundle bundle = this.I;
        if (bundle == null || bundle.getInt("key_source", 0) != 1) {
            return false;
        }
        return true;
    }

    public abstract void q(int i3);

    public abstract boolean q0();

    public String r() {
        return "";
    }

    public abstract String s();

    public abstract boolean s0();

    public String t() {
        return "";
    }

    public boolean t0() {
        Bundle bundle = this.I;
        if ((bundle == null || bundle.getInt("key_source", 0) != 1) && this.H != 12) {
            return true;
        }
        return false;
    }

    public int u() {
        return 0;
    }

    public abstract boolean u0();

    public String v() {
        return "";
    }

    public abstract void v0();

    public String w() {
        return "";
    }

    public abstract void w0(int i3, b bVar);

    public String x() {
        return "";
    }

    public abstract void x0(int i3, String str);

    public int y() {
        return 0;
    }

    public abstract void y0();

    public String z() {
        return null;
    }

    public abstract void z0();

    public void l() {
    }

    public void C0(FileManagerEntity fileManagerEntity) {
    }

    public void k0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
    }

    public void k(String str, Bundle bundle) {
    }
}
