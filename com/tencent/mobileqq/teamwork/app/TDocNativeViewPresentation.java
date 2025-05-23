package com.tencent.mobileqq.teamwork.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;
import com.tencent.mobileqq.teamwork.app.r;
import com.tencent.nativepreview.NativeEngineView;
import com.tencent.nativepreview.base.primitive.FileLoadCallback;
import com.tencent.nativepreview.base.primitive.NativeEngineJNI;
import com.tencent.nativepreview.service.ILogger;
import com.tencent.nativepreview.service.IReporter;
import com.tencent.nativepreview.service.drive.DriveUploadCallback;
import com.tencent.nativepreview.service.drive.DriveUploadRequest;
import com.tencent.nativepreview.wrapper.model.DocInfo;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.nativepreview.wrapper.model.PageMode;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes18.dex */
public class TDocNativeViewPresentation extends com.tencent.mobileqq.remoteweb.view.g implements r.b {
    private com.tencent.nativepreview.d J;
    private String K;
    private int L;
    private int M;
    private int N;
    private String P;
    private ProcessOpenDocsPerformanceData Q;
    private final FileLoadCallback R;

    /* loaded from: classes18.dex */
    class a implements FileLoadCallback {
        a() {
        }

        @Override // com.tencent.nativepreview.base.primitive.FileLoadCallback
        public void onCallback(int i3, String str) {
            QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit FileLoadCallback onCallback " + i3 + " message:" + str);
            r.b().c(TDocNativeViewPresentation.this.P, i3, str);
        }
    }

    public TDocNativeViewPresentation(@NonNull Context context, @NonNull Display display, @NonNull Bundle bundle) {
        super(context, display, bundle);
        this.M = 360;
        this.N = 800;
        this.Q = new ProcessOpenDocsPerformanceData();
        this.R = new a();
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit TDocNativeViewPresentation create ");
        Activity b16 = RemoteWebRenderIPCClient.INSTANCE.b();
        if (b16 == null) {
            QLog.e("TDocNativeViewPresentation", 1, "TDocNativeViewPresentation activity is null");
            return;
        }
        this.Q.f291499d = System.currentTimeMillis();
        this.K = bundle.getString("docs_path", "");
        this.L = bundle.getInt("docs_type", 0);
        this.P = bundle.getString("key_web_page_id", "");
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit loadLibrary start ");
        K(this.L);
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit loadLibrary end ");
        r.b().register();
        r.b().e(this);
        NativeEngineJNI.Companion companion = NativeEngineJNI.INSTANCE;
        companion.setLogger(new b());
        companion.setLoggerLevel(QLog.isDevelopLevel() ? 0 : 3);
        companion.setReporter(new IReporter() { // from class: com.tencent.mobileqq.teamwork.app.o
            @Override // com.tencent.nativepreview.service.IReporter
            public final void report(String str, String str2, long j3, long j16, String str3) {
                TDocNativeViewPresentation.H(str, str2, j3, j16, str3);
            }
        });
        com.tencent.nativepreview.d dVar = new com.tencent.nativepreview.d(new com.tencent.nativepreview.a(this.L, MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/localEdit/offline"), new NativeEngineView(b16));
        this.J = dVar;
        dVar.l(b16, new Function1() { // from class: com.tencent.mobileqq.teamwork.app.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I;
                I = TDocNativeViewPresentation.this.I((Boolean) obj);
                return I;
            }
        });
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit TDocNativeViewPresentation end ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(String str, String str2, long j3, long j16, String str3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("TDocNativeViewPresentation", 2, "report :" + str + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str3 + APLogFileUtil.SEPARATOR_LOG + j3 + APLogFileUtil.SEPARATOR_LOG + j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit I(Boolean bool) {
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit TDocNativeViewPresentation loadFile ");
        this.J.q(this.K, "", this.R);
        this.Q.f291500e = System.currentTimeMillis();
        r.b().d(this.P, this.Q);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(int i3, QIPCModule qIPCModule, int i16, String str, DocInfo docInfo) {
        QLog.d("TDocNativeViewPresentation", 1, "upload drive ret=" + i16 + " msg=" + str + " callbackId=" + i3);
        Bundle bundle = new Bundle();
        bundle.putInt("ret", i16);
        bundle.putString("msg", str);
        bundle.putParcelable("docInfo", docInfo);
        qIPCModule.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private boolean K(int i3) {
        try {
            LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(ITDocFileBrowserFacade.NATIVE_ENGINE_SO_NAME);
            QLog.i("TDocNativeViewPresentation", 1, "[loadLibrary] ooXmlResult:" + loadSync.isSucc() + "docsType:" + i3);
            String relatedFilesFolder = loadSync.getRelatedFilesFolder();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(relatedFilesFolder);
            String str = File.separator;
            sb5.append(str);
            sb5.append("binding");
            sb5.append(str);
            sb5.append("libbinding.so");
            System.load(sb5.toString());
            NativeEngineJNI.Companion companion = NativeEngineJNI.INSTANCE;
            companion.initJNI();
            companion.loadICUData(relatedFilesFolder + str + "binding" + str + "icudt70l.dat");
            return true;
        } catch (Exception | UnsatisfiedLinkError e16) {
            QLog.e("TDocNativeViewPresentation", 1, "[loadLibrary] webResult false:" + e16);
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.teamwork.app.r.b
    public EIPCResult a(final QIPCModule qIPCModule, String str, Bundle bundle, final int i3) {
        char c16;
        QLog.i("TDocNativeViewPresentation", 1, "onCall action:" + str + " callbackId:" + i3);
        str.hashCode();
        switch (str.hashCode()) {
            case -2028657422:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_REFRESH_VIEW)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1818679034:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_DRIVE_UPLOAD)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -955137072:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_GET_OUTLINE)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case -821214805:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_REPLACE)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 70050145:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_GET_PAGE_MODE)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 586694455:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_FIND_CANCEL)) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 844181357:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_SET_PAGE_MODE)) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 844355019:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_SET_PAGE_SIZE)) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 994910269:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_GET_FIND_STATE)) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            case 1583325730:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_FIND)) {
                    c16 = '\t';
                    break;
                }
                c16 = '\uffff';
                break;
            case 1959766628:
                if (str.equals(ITDocWebIPCModuleApi.ACTION_SCROLL_TO)) {
                    c16 = '\n';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                com.tencent.nativepreview.d dVar = this.J;
                if (dVar != null) {
                    dVar.r();
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
            case 1:
                if (this.J != null && bundle != null) {
                    bundle.setClassLoader(DriveUploadRequest.class.getClassLoader());
                    NativeEngineJNI.INSTANCE.uploadToDrive((DriveUploadRequest) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_UPLOAD_REQUEST), new DriveUploadCallback() { // from class: com.tencent.mobileqq.teamwork.app.q
                        @Override // com.tencent.nativepreview.service.drive.DriveUploadCallback
                        public final void onCallback(int i16, String str2, DocInfo docInfo) {
                            TDocNativeViewPresentation.J(i3, qIPCModule, i16, str2, docInfo);
                        }
                    });
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
            case 2:
                com.tencent.nativepreview.d dVar2 = this.J;
                if (dVar2 != null) {
                    DocOutlineItem[] i16 = dVar2.i();
                    if (i16 == null) {
                        return EIPCResult.createResult(-1, new Bundle());
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelableArray(ITDocWebIPCModuleApi.KEY_OUTLINE_ITEMS, i16);
                    return EIPCResult.createSuccessResult(bundle2);
                }
                break;
            case 3:
                if (this.J != null) {
                    bundle.setClassLoader(DocSearchState.class.getClassLoader());
                    if (this.J.t((DocSearchState) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE), bundle.getBoolean(ITDocWebIPCModuleApi.KEY_REPLACE_ALL, false))) {
                        return EIPCResult.createSuccessResult(new Bundle());
                    }
                    return EIPCResult.createResult(-1, new Bundle());
                }
                break;
            case 4:
                if (this.J != null) {
                    int value = this.J.j().getValue();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(ITDocWebIPCModuleApi.KEY_PAGE_MODE, value);
                    return EIPCResult.createSuccessResult(bundle3);
                }
                break;
            case 5:
                if (this.J != null) {
                    bundle.setClassLoader(DocSearchState.class.getClassLoader());
                    this.J.d((DocSearchState) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE));
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
            case 6:
                if (this.J != null && bundle != null) {
                    this.J.v(PageMode.INSTANCE.a(bundle.getInt(ITDocWebIPCModuleApi.KEY_PAGE_MODE, 1)));
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
            case 7:
                if (this.J != null && bundle != null) {
                    this.J.w((RectF) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_RECT), bundle.getFloat("ratio", 1.5f));
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
            case '\b':
                com.tencent.nativepreview.d dVar3 = this.J;
                if (dVar3 != null) {
                    DocSearchState h16 = dVar3.h();
                    if (h16 != null) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE, h16);
                        return EIPCResult.createSuccessResult(bundle4);
                    }
                    return EIPCResult.createResult(-1, new Bundle());
                }
                break;
            case '\t':
                if (this.J != null && bundle != null) {
                    bundle.setClassLoader(DocSearchState.class.getClassLoader());
                    if (this.J.f((DocSearchState) bundle.getParcelable(ITDocWebIPCModuleApi.KEY_FIND_STATE), bundle.getLong(ITDocWebIPCModuleApi.KEY_FIND_OFFSET))) {
                        return EIPCResult.createSuccessResult(new Bundle());
                    }
                    return EIPCResult.createResult(-1, new Bundle());
                }
                break;
            case '\n':
                if (this.J != null && bundle != null) {
                    long j3 = bundle.getLong(ITDocWebIPCModuleApi.KEY_PARAGTAPH_NODE, -1L);
                    if (j3 == -1) {
                        return EIPCResult.createResult(-1, new Bundle());
                    }
                    this.J.u(j3);
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                break;
        }
        return EIPCResult.UNKNOW_RESULT;
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    @Nullable
    public View c(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        NativeEngineView k3 = this.J.k();
        if (k3 != null) {
            k3.setLayoutParams(layoutParams);
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void d() {
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_local_edit destroy currentPath= " + this.K + "docsType= " + this.L);
        com.tencent.nativepreview.d dVar = this.J;
        if (dVar != null) {
            dVar.s();
        }
        r.b().g(this);
        super.d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005e, code lost:
    
        if (r12.equals("url_key_set_scale") == false) goto L4;
     */
    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(@NonNull String str, @NonNull Bundle bundle) {
        char c16 = 1;
        QLog.d("TDocNativeViewPresentation", 1, "tDoc_step tDoc_local_edit TDocNativeViewPresentation loadUrl: " + str);
        str.hashCode();
        switch (str.hashCode()) {
            case 41930400:
                if (str.equals("url_key_set_frame")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 53489277:
                break;
            case 466023314:
                if (str.equals("url_key_outline")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 511074437:
                if (str.equals("url_key_load_file")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 808398784:
                if (str.equals("url_key_export_image")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1511481718:
                if (str.equals("url_key_find_and_replace")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                if (this.J != null) {
                    RectF rectF = (RectF) bundle.getParcelable("key_tencent_doc_frame_size");
                    com.tencent.nativepreview.d dVar = this.J;
                    dVar.w(rectF, dVar.k().getResources().getDisplayMetrics().density);
                    return;
                }
                return;
            case 1:
                if (this.J != null) {
                    this.J.x(bundle.getFloat("key_tencent_doc_scale"), bundle.getFloat("key_tencent_doc_max_scale"), bundle.getFloat("key_tencent_doc_min_scale"));
                    return;
                }
                return;
            case 2:
                com.tencent.nativepreview.d dVar2 = this.J;
                if (dVar2 != null) {
                    dVar2.z();
                    return;
                }
                return;
            case 3:
                if (this.J != null) {
                    this.J.q(this.K, bundle.getString("key_tencent_doc_password", ""), this.R);
                    return;
                }
                return;
            case 4:
                if (this.J != null) {
                    this.J.e(bundle.getInt("start", 0), bundle.getInt("count", -1), bundle.getDouble("pixelRatio", 0.5d), bundle.getString("saveFold", ""), null);
                    return;
                }
                return;
            case 5:
                if (this.J != null) {
                    this.J.y(bundle.getBoolean("key_tencent_doc_enable_replace", false));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* loaded from: classes18.dex */
    class b implements ILogger {
        b() {
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void d(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2, th5);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void e(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2, th5);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void i(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.i("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2, th5);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void v(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2, th5);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void w(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.w("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2, th5);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void d(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void e(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.e("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void i(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.i("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void v(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2);
            }
        }

        @Override // com.tencent.nativepreview.service.ILogger
        public void w(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.w("TDocNativeViewPresentation", 2, str + APLogFileUtil.SEPARATOR_LOG + str2);
            }
        }
    }
}
