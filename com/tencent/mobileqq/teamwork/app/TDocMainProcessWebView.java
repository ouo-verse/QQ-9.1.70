package com.tencent.mobileqq.teamwork.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.teamwork.app.v;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes18.dex */
public class TDocMainProcessWebView extends TextureView {
    private static Surface G;
    private b.a C;
    private v.a D;
    private com.tencent.mobileqq.remoteweb.a E;
    private OpenDocsPerformanceRecorder F;

    /* renamed from: d, reason: collision with root package name */
    private String f291900d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f291901e;

    /* renamed from: f, reason: collision with root package name */
    private final String f291902f;

    /* renamed from: h, reason: collision with root package name */
    private final int f291903h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f291904i;

    /* renamed from: m, reason: collision with root package name */
    private b.InterfaceC8637b f291905m;

    /* loaded from: classes18.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteWebRenderIPCServer.J().G(TDocMainProcessWebView.this.q(), motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d implements v.a {
        d() {
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void a(String str, int i3, String str2) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_step tDoc_local_edit [onOpenFileResult] " + i3 + " " + str2);
            if (TDocMainProcessWebView.this.f291905m != null && TextUtils.equals(str, TDocMainProcessWebView.this.f291902f)) {
                TDocMainProcessWebView.this.f291905m.b(i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void b(String str, ProcessOpenDocsPerformanceData processOpenDocsPerformanceData) {
            if (TDocMainProcessWebView.this.F != null && processOpenDocsPerformanceData != null) {
                TDocMainProcessWebView.this.F.f291499d = processOpenDocsPerformanceData.f291499d;
                TDocMainProcessWebView.this.F.f291500e = processOpenDocsPerformanceData.f291500e;
            }
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void c(String str, String str2, String str3) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onJsApiCall] " + str + " " + str2);
            if (TDocMainProcessWebView.this.C != null) {
                TDocMainProcessWebView.this.C.a(str, str2, str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class e implements Function1<Boolean, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class a implements EIPCResultCallback {
            a() {
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (TDocMainProcessWebView.this.f291904i) {
                    QLog.e("TDocMainProcessWebView", 1, "tDoc_local_edit [updateSurface] callback view isDestroy");
                    return;
                }
                if (eIPCResult.isSuccess()) {
                    TDocMainProcessWebView.G = TDocMainProcessWebView.this.f291901e;
                    QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [updateSurface] succeed webPageId:" + TDocMainProcessWebView.this.q() + ",mUrl:" + TDocMainProcessWebView.this.f291900d);
                    TDocMainProcessWebView tDocMainProcessWebView = TDocMainProcessWebView.this;
                    tDocMainProcessWebView.x(tDocMainProcessWebView.f291900d);
                    return;
                }
                QLog.e("TDocMainProcessWebView", 1, "tDoc_local_edit [updateSurface] error " + eIPCResult.f396321e);
            }
        }

        e() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                TDocMainProcessWebView.this.p();
                TDocMainProcessWebView.G = TDocMainProcessWebView.this.f291901e;
                return null;
            }
            if (!TDocMainProcessWebView.this.s() && TDocMainProcessWebView.G != TDocMainProcessWebView.this.f291901e) {
                RemoteWebRenderIPCServer.J().j0(TDocMainProcessWebView.this.q(), TDocMainProcessWebView.this.f291901e, TDocMainProcessWebView.this.getMeasuredWidth(), TDocMainProcessWebView.this.getMeasuredHeight(), new a());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class f implements Function1<Boolean, Unit> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [loadUrl] aBoolean \uff1a" + bool + ", webID:" + TDocMainProcessWebView.this.f291902f);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class g implements Function1<Boolean, Unit> {
        g() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [clearMemory][destroyRemoteWebView] webPageId:" + TDocMainProcessWebView.this.q() + ", isSucceed:" + bool);
            return null;
        }
    }

    public TDocMainProcessWebView(@NonNull Context context, int i3) {
        this(context, null, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f291901e != null && !TextUtils.isEmpty(this.f291900d)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", s());
            bundle.putString("key_remote_service_type", "tDocService");
            bundle.putString("key_remote_view_type", "WebTencentDoc");
            bundle.putInt("docs_type", this.f291903h);
            QLog.d("TDocMainProcessWebView", 1, "tDoc_Step [createSurface] webPageId:" + q() + ",mUrl:" + this.f291900d);
            RemoteWebRenderIPCServer.J().h0(this.f291900d, this.f291901e, q(), getContext(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q() {
        return this.f291902f;
    }

    private void r() {
        this.E = new c();
        RemoteWebRenderIPCServer.J().w(this.E);
        this.D = new d();
        v.f().e(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.f291901e == null) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [updateOrCreateSurface] mCurrentSurface is null, webID:" + q());
            return;
        }
        RemoteWebRenderIPCServer.J().x(q(), new e());
    }

    public void o() {
        if (s()) {
            RemoteWebRenderIPCServer.J().C(q(), new g());
        }
    }

    public void setJsApiCallHandler(b.a aVar) {
        this.C = aVar;
    }

    public void setOpenDocsPerformanceRecorder(OpenDocsPerformanceRecorder openDocsPerformanceRecorder) {
        this.F = openDocsPerformanceRecorder;
    }

    public void setStatusListener(b.InterfaceC8637b interfaceC8637b) {
        this.f291905m = interfaceC8637b;
    }

    public void t(String str) {
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [initConfig] url\uff1a" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f291900d = str;
        z();
    }

    public void u() {
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onDestroy] webPageId:" + q());
        RemoteWebRenderIPCServer.J().C(q(), null);
        RemoteWebRenderIPCServer.J().f0(this.E);
        v.f().l(this.D);
        this.f291904i = true;
    }

    public void v() {
        if (TextUtils.isEmpty(this.f291900d)) {
            return;
        }
        w(getContext());
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onResume] webPageId:" + q());
        z();
        RemoteWebRenderIPCServer.J().U(q(), true);
    }

    public void w(Context context) {
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [preLoadWebView]");
        try {
            context.startService(new Intent(context, (Class<?>) PreloadWebService.class));
        } catch (Throwable th5) {
            QLog.e("TDocMainProcessWebView", 1, "tDoc_local_edit [preLoadWebView], error=", th5);
        }
    }

    public void x(String str) {
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [reloadUrl] url\uff1a" + str);
        if (this.f291901e != null && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", s());
            bundle.putString("key_remote_view_type", "WebTencentDoc");
            RemoteWebRenderIPCServer.J().R(str, this.f291901e, q(), bundle, new f());
        }
    }

    public void y(Context context) {
        QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [stopWebView]");
    }

    public TDocMainProcessWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f291904i = false;
        this.f291902f = "WebTencentDoc_" + hashCode();
        this.f291903h = i3;
        setSurfaceTextureListener(new a());
        setOnTouchListener(new b());
        r();
    }

    /* loaded from: classes18.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onSurfaceTextureAvailable]");
            TDocMainProcessWebView.this.f291901e = new Surface(surfaceTexture);
            TDocMainProcessWebView.this.z();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onSurfaceTextureDestroyed]");
            if (TDocMainProcessWebView.G == TDocMainProcessWebView.this.f291901e) {
                TDocMainProcessWebView.G = null;
                TDocMainProcessWebView tDocMainProcessWebView = TDocMainProcessWebView.this;
                tDocMainProcessWebView.y(tDocMainProcessWebView.getContext());
                QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit set sCurrentAttachSurface = null");
            }
            TDocMainProcessWebView.this.f291901e = null;
            TDocMainProcessWebView.this.o();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c extends ad {
        c() {
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onFailed(@NotNull String str, int i3, @org.jetbrains.annotations.Nullable String str2) {
            if (TDocMainProcessWebView.this.f291905m != null && TextUtils.equals(str, TDocMainProcessWebView.this.f291902f)) {
                TDocMainProcessWebView.this.f291905m.b(i3, str2);
            }
            QLog.d("TDocMainProcessWebView", 2, "tDoc_local_edit [onFailed]" + TDocMainProcessWebView.this.q() + " code: " + i3 + " msg: " + str2);
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onServiceConnected]" + TDocMainProcessWebView.this.q());
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long j3) {
            QLog.d("TDocMainProcessWebView", 1, "tDoc_local_edit [onServiceDisconnected]" + TDocMainProcessWebView.this.q());
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent) {
            if (TextUtils.equals(str, TDocMainProcessWebView.this.f291902f)) {
                if (remoteWebViewEvent.status() == RemoteWebViewEvent.ON_PAGE_FINISH.status()) {
                    if (TDocMainProcessWebView.this.f291905m != null) {
                        TDocMainProcessWebView.this.f291905m.d();
                    }
                    QLog.d("TDocMainProcessWebView", 2, "tDoc_local_edit [onWebViewEvent] load succeed:" + TDocMainProcessWebView.this.q());
                }
                if (remoteWebViewEvent.status() == RemoteWebViewEvent.ON_PAGE_STARTED.status()) {
                    if (TDocMainProcessWebView.this.f291905m != null) {
                        TDocMainProcessWebView.this.f291905m.a();
                    }
                    QLog.d("TDocMainProcessWebView", 2, "tDoc_step tDoc_local_edit [onWebViewEvent] load start:" + TDocMainProcessWebView.this.q());
                }
                if (remoteWebViewEvent.status() == RemoteWebViewEvent.ON_BEFORE_LOAD_URL.status()) {
                    if (TDocMainProcessWebView.this.f291905m != null) {
                        TDocMainProcessWebView.this.f291905m.c();
                    }
                    QLog.d("TDocMainProcessWebView", 2, "tDoc_step tDoc_local_edit [onWebViewEvent] beforeLoadUrl:" + TDocMainProcessWebView.this.q());
                }
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@NotNull String str, @NotNull RemoteWebTimeCost remoteWebTimeCost, long j3) {
        }
    }
}
