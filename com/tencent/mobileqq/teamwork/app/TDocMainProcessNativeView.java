package com.tencent.mobileqq.teamwork.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;
import com.tencent.mobileqq.teamwork.app.v;
import com.tencent.nativepreview.service.drive.DriveUploadCallback;
import com.tencent.nativepreview.service.drive.DriveUploadRequest;
import com.tencent.nativepreview.wrapper.model.DocInfo;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes18.dex */
public class TDocMainProcessNativeView extends TextureView {
    private static Surface E;
    private OpenDocsPerformanceRecorder C;
    com.tencent.mobileqq.remoteweb.a D;

    /* renamed from: d, reason: collision with root package name */
    private Surface f291883d;

    /* renamed from: e, reason: collision with root package name */
    private final String f291884e;

    /* renamed from: f, reason: collision with root package name */
    private final String f291885f;

    /* renamed from: h, reason: collision with root package name */
    private final int f291886h;

    /* renamed from: i, reason: collision with root package name */
    INativeEngineFileBrowserWrapper.c f291887i;

    /* renamed from: m, reason: collision with root package name */
    private v.a f291888m;

    /* loaded from: classes18.dex */
    class a implements Function1<Boolean, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [setScale] aBoolean \uff1a" + bool + ", mViewId:" + TDocMainProcessNativeView.this.f291884e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements Function1<Boolean, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [loadUrl] aBoolean \uff1a" + bool + ", webID:" + TDocMainProcessNativeView.this.f291884e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c implements Function1<Boolean, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [clearMemory][destroyRemoteWebView] webPageId:" + TDocMainProcessNativeView.this.t() + ", isSucceed:" + bool);
            return null;
        }
    }

    /* loaded from: classes18.dex */
    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteWebRenderIPCServer.J().G(TDocMainProcessNativeView.this.t(), motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class g implements v.a {
        g() {
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void a(String str, int i3, String str2) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onOpenFileResult] " + i3 + " " + str2);
            TDocMainProcessNativeView tDocMainProcessNativeView = TDocMainProcessNativeView.this;
            if (tDocMainProcessNativeView.f291887i != null && TextUtils.equals(str, tDocMainProcessNativeView.f291884e)) {
                TDocMainProcessNativeView.this.f291887i.b(i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void b(String str, ProcessOpenDocsPerformanceData processOpenDocsPerformanceData) {
            if (TDocMainProcessNativeView.this.C != null && processOpenDocsPerformanceData != null) {
                TDocMainProcessNativeView.this.C.f291499d = processOpenDocsPerformanceData.f291499d;
                TDocMainProcessNativeView.this.C.f291500e = processOpenDocsPerformanceData.f291500e;
            }
        }

        @Override // com.tencent.mobileqq.teamwork.app.v.a
        public void c(String str, String str2, String str3) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onJsApiCall] " + str + " " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class h implements Function1<Boolean, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class a implements EIPCResultCallback {
            a() {
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (eIPCResult.isSuccess()) {
                    TDocMainProcessNativeView.E = TDocMainProcessNativeView.this.f291883d;
                    QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [updateSurface] succeed webPageId:" + TDocMainProcessNativeView.this.t() + ",mPath:" + TDocMainProcessNativeView.this.f291885f);
                    TDocMainProcessNativeView tDocMainProcessNativeView = TDocMainProcessNativeView.this;
                    tDocMainProcessNativeView.y(tDocMainProcessNativeView.f291885f);
                    return;
                }
                QLog.e("TDocMainProcessNativeView", 1, "tDoc_local_edit [updateSurface] error " + eIPCResult.f396321e);
            }
        }

        h() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                TDocMainProcessNativeView.this.p();
                TDocMainProcessNativeView.E = TDocMainProcessNativeView.this.f291883d;
                return null;
            }
            if (!TDocMainProcessNativeView.this.v() && TDocMainProcessNativeView.E != TDocMainProcessNativeView.this.f291883d) {
                RemoteWebRenderIPCServer.J().j0(TDocMainProcessNativeView.this.t(), TDocMainProcessNativeView.this.f291883d, TDocMainProcessNativeView.this.getMeasuredWidth(), TDocMainProcessNativeView.this.getMeasuredHeight(), new a());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes18.dex */
    class i implements Function1<Boolean, Unit> {
        i() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [loadFile] aBoolean \uff1a" + bool + ", mViewId:" + TDocMainProcessNativeView.this.f291884e);
            return null;
        }
    }

    /* loaded from: classes18.dex */
    class j implements Function1<Boolean, Unit> {
        j() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [setFrame] aBoolean \uff1a" + bool + ", mViewId:" + TDocMainProcessNativeView.this.f291884e);
            return null;
        }
    }

    public TDocMainProcessNativeView(@NonNull Context context, String str, int i3) {
        this(context, null, str, i3);
    }

    private void C() {
        RemoteWebRenderIPCServer.J().f0(this.D);
        v.f().l(this.f291888m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.f291883d == null) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [updateOrCreateSurface] mCurrentSurface is null, webID:" + t());
            return;
        }
        RemoteWebRenderIPCServer.J().x(t(), new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f291883d != null && !TextUtils.isEmpty(this.f291885f)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", v());
            bundle.putString("docs_path", this.f291885f);
            bundle.putInt("docs_type", this.f291886h);
            bundle.putString("key_remote_service_type", "tDocService");
            bundle.putString("key_remote_view_type", "NativeTencentDoc");
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_step tDoc_local_edit [createSurface] webPageId:" + t() + ",mPath:" + this.f291885f);
            RemoteWebRenderIPCServer.J().h0(this.f291885f, this.f291883d, t(), getContext(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t() {
        return this.f291884e;
    }

    private void u() {
        RemoteWebRenderIPCServer.J().w(this.D);
        this.f291888m = new g();
        v.f().e(this.f291888m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(DriveUploadCallback driveUploadCallback, EIPCResult eIPCResult) {
        Bundle bundle = eIPCResult.data;
        if (bundle == null) {
            QLog.e("TDocMainProcessNativeView", 1, "drive upload result data is empty. code=" + eIPCResult.code);
            if (driveUploadCallback != null) {
                driveUploadCallback.onCallback(-1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED, null);
                return;
            }
            return;
        }
        int i3 = bundle.getInt("ret");
        String string = eIPCResult.data.getString("msg");
        eIPCResult.data.setClassLoader(DocInfo.class.getClassLoader());
        DocInfo docInfo = (DocInfo) eIPCResult.data.getParcelable("docInfo");
        QLog.d("TDocMainProcessNativeView", 1, "drive upload result. ret=" + i3 + " msg=" + string);
        if (driveUploadCallback != null) {
            driveUploadCallback.onCallback(i3, string, docInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
        if (this.f291883d != null && !TextUtils.isEmpty(this.f291885f)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", v());
            bundle.putString("docs_path", this.f291885f);
            bundle.putInt("docs_type", this.f291886h);
            bundle.putString("key_remote_view_type", "NativeTencentDoc");
            RemoteWebRenderIPCServer.J().R(str, this.f291883d, t(), bundle, new b());
        }
    }

    public void A() {
        if (TextUtils.isEmpty(this.f291885f)) {
            return;
        }
        B(getContext());
        QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onResume] webPageId:" + t());
        G();
        RemoteWebRenderIPCServer.J().U(t(), true);
    }

    public void B(Context context) {
        QLog.d("TDocMainProcessNativeView", 1, "[preLoadWebView]");
        try {
            context.startService(new Intent(context, (Class<?>) PreloadWebService.class));
        } catch (Throwable th5) {
            QLog.e("TDocMainProcessNativeView", 1, "tDoc_local_edit [preLoadWebView], error=", th5);
        }
    }

    public boolean D(DocSearchState docSearchState, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE, docSearchState);
        bundle.putBoolean(ITDocWebIPCModuleApi.KEY_REPLACE_ALL, z16);
        return QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_REPLACE, bundle).isSuccess();
    }

    public void E(long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong(ITDocWebIPCModuleApi.KEY_PARAGTAPH_NODE, j3);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_SCROLL_TO, bundle);
    }

    public void F(Context context) {
        QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [stopWebView]");
    }

    public void H(DriveUploadRequest driveUploadRequest, final DriveUploadCallback driveUploadCallback) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_UPLOAD_REQUEST, driveUploadRequest);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_DRIVE_UPLOAD, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.teamwork.app.n
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                TDocMainProcessNativeView.w(DriveUploadCallback.this, eIPCResult);
            }
        });
    }

    public boolean n(DocSearchState docSearchState) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE, docSearchState);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_FIND_CANCEL, bundle);
        return true;
    }

    public void o() {
        if (v()) {
            RemoteWebRenderIPCServer.J().C(t(), new c());
        }
    }

    public boolean q(DocSearchState docSearchState, long j3) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE, docSearchState);
        bundle.putLong(ITDocWebIPCModuleApi.KEY_FIND_OFFSET, j3);
        return QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_FIND, bundle).isSuccess();
    }

    public DocSearchState r() {
        Bundle bundle;
        EIPCResult callClient = QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_GET_FIND_STATE, null);
        if (callClient == null || (bundle = callClient.data) == null) {
            return null;
        }
        bundle.setClassLoader(DocSearchState.class.getClassLoader());
        return (DocSearchState) callClient.data.getParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE);
    }

    public DocOutlineItem[] s() {
        Bundle bundle;
        EIPCResult callClient = QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_GET_OUTLINE, null);
        if (callClient != null && (bundle = callClient.data) != null) {
            bundle.setClassLoader(DocOutlineItem.class.getClassLoader());
            Parcelable[] parcelableArray = callClient.data.getParcelableArray(ITDocWebIPCModuleApi.KEY_OUTLINE_ITEMS);
            if (parcelableArray != null && parcelableArray.length != 0) {
                int length = parcelableArray.length;
                DocOutlineItem[] docOutlineItemArr = new DocOutlineItem[length];
                for (int i3 = 0; i3 < length; i3++) {
                    docOutlineItemArr[i3] = (DocOutlineItem) parcelableArray[i3];
                }
                return docOutlineItemArr;
            }
        }
        return null;
    }

    public void setFrame(RectF rectF) {
        if (this.f291883d != null && !TextUtils.isEmpty(this.f291885f)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", v());
            bundle.putString("docs_path", this.f291885f);
            bundle.putParcelable("key_tencent_doc_frame_size", rectF);
            bundle.putInt("docs_type", this.f291886h);
            bundle.putString("key_remote_view_type", "NativeTencentDoc");
            RemoteWebRenderIPCServer.J().R("url_key_set_frame", this.f291883d, t(), bundle, new j());
        }
    }

    public void setNativeLoadCallback(INativeEngineFileBrowserWrapper.c cVar) {
        this.f291887i = cVar;
    }

    public void setOpenDocsPerformanceRecorder(OpenDocsPerformanceRecorder openDocsPerformanceRecorder) {
        this.C = openDocsPerformanceRecorder;
    }

    public void setPageMode(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(ITDocWebIPCModuleApi.KEY_PAGE_MODE, i3);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_SET_PAGE_MODE, bundle);
    }

    public void setPageSize(RectF rectF, float f16) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_RECT, rectF);
        bundle.putFloat("ratio", f16);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, ITDocWebIPCModuleApi.ACTION_SET_PAGE_SIZE, bundle);
    }

    public void setScale(double d16, double d17, double d18) {
        if (this.f291883d != null && !TextUtils.isEmpty(this.f291885f)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", v());
            bundle.putString("docs_path", this.f291885f);
            bundle.putDouble("key_tencent_doc_scale", d16);
            bundle.putDouble("key_tencent_doc_min_scale", d17);
            bundle.putDouble("key_tencent_doc_max_scale", d18);
            bundle.putInt("docs_type", this.f291886h);
            bundle.putString("key_remote_view_type", "NativeTencentDoc");
            RemoteWebRenderIPCServer.J().R("url_key_set_scale", this.f291883d, t(), bundle, new a());
        }
    }

    public void x(String str) {
        if (this.f291883d != null && !TextUtils.isEmpty(this.f291885f)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", v());
            bundle.putString("docs_path", this.f291885f);
            bundle.putString("key_tencent_doc_password", str);
            bundle.putInt("docs_type", this.f291886h);
            bundle.putString("key_remote_view_type", "NativeTencentDoc");
            RemoteWebRenderIPCServer.J().R("url_key_load_file", this.f291883d, t(), bundle, new i());
        }
    }

    public void z() {
        QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onDestroy] webPageId:" + t());
        RemoteWebRenderIPCServer.J().C(t(), null);
        C();
    }

    public TDocMainProcessNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, String str, int i3) {
        super(context, attributeSet);
        this.D = new d();
        if (v()) {
            this.f291884e = "NativeTencentDoc" + hashCode();
        } else {
            this.f291884e = "NativeTencentDoc" + hashCode();
        }
        QLog.i("TDocMainProcessNativeView", 1, "tDoc_step TDocMainProcessNativeView create");
        this.f291885f = str;
        this.f291886h = i3;
        setSurfaceTextureListener(new e());
        setOnTouchListener(new f());
        u();
    }

    /* loaded from: classes18.dex */
    class e implements TextureView.SurfaceTextureListener {
        e() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_step tDoc_local_edit [onSurfaceTextureAvailable]");
            TDocMainProcessNativeView.this.f291883d = new Surface(surfaceTexture);
            TDocMainProcessNativeView.this.G();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onSurfaceTextureDestroyed]");
            if (TDocMainProcessNativeView.E == TDocMainProcessNativeView.this.f291883d) {
                TDocMainProcessNativeView.E = null;
                TDocMainProcessNativeView tDocMainProcessNativeView = TDocMainProcessNativeView.this;
                tDocMainProcessNativeView.F(tDocMainProcessNativeView.getContext());
                QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit set sCurrentAttachSurface = null");
            }
            TDocMainProcessNativeView.this.f291883d = null;
            TDocMainProcessNativeView.this.o();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }

    /* loaded from: classes18.dex */
    class d extends ad {
        d() {
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onFailed(@NotNull String str, int i3, @org.jetbrains.annotations.Nullable String str2) {
            INativeEngineFileBrowserWrapper.c cVar;
            if (TextUtils.equals(str, TDocMainProcessNativeView.this.f291884e) && (cVar = TDocMainProcessNativeView.this.f291887i) != null) {
                cVar.b(i3, str2);
            }
            QLog.d("TDocMainProcessNativeView", 2, "tDoc_local_edit [onFailed]" + TDocMainProcessNativeView.this.t() + " code: " + i3 + " msg: " + str2);
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onServiceConnected]" + TDocMainProcessNativeView.this.t());
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long j3) {
            QLog.d("TDocMainProcessNativeView", 1, "tDoc_local_edit [onServiceDisconnected]" + TDocMainProcessNativeView.this.t());
            INativeEngineFileBrowserWrapper.c cVar = TDocMainProcessNativeView.this.f291887i;
            if (cVar != null) {
                cVar.d(-104);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent) {
            if (TextUtils.equals(str, TDocMainProcessNativeView.this.f291884e)) {
                if (remoteWebViewEvent.status() == RemoteWebViewEvent.ON_PAGE_FINISH.status()) {
                    QLog.d("TDocMainProcessNativeView", 2, "tDoc_local_edit [onWebViewEvent] load succeed:" + TDocMainProcessNativeView.this.t());
                }
                if (remoteWebViewEvent.status() == RemoteWebViewEvent.ON_BEFORE_LOAD_URL.status()) {
                    QLog.d("TDocMainProcessNativeView", 2, "tDoc_local_edit [onWebViewEvent] load start:" + TDocMainProcessNativeView.this.t());
                    INativeEngineFileBrowserWrapper.c cVar = TDocMainProcessNativeView.this.f291887i;
                    if (cVar != null) {
                        cVar.c();
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@NotNull String str, @NotNull RemoteWebTimeCost remoteWebTimeCost, long j3) {
        }
    }
}
