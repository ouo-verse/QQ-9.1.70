package com.tencent.mobileqq.teamwork.app;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.app.i;
import com.tencent.mobileqq.teamwork.menu.FileTabMenuView;
import com.tencent.mobileqq.teamwork.menu.FindReplaceView;
import com.tencent.mobileqq.teamwork.menu.MenuConfigImpl;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.teamwork.menu.aj;
import com.tencent.mobileqq.teamwork.menu.au;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nativepreview.NativeEngineView;
import com.tencent.nativepreview.base.primitive.FileLoadCallback;
import com.tencent.nativepreview.base.primitive.NativeEngineJNI;
import com.tencent.nativepreview.service.drive.DriveUploadCallback;
import com.tencent.nativepreview.service.drive.DriveUploadRequest;
import com.tencent.nativepreview.wrapper.model.DocInfo;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.nativepreview.wrapper.model.PageMode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i implements INativeEngineFileBrowserWrapper {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.nativepreview.d f291931a;

    /* renamed from: b, reason: collision with root package name */
    private INativeEngineFileBrowserWrapper.c f291932b;

    /* renamed from: c, reason: collision with root package name */
    private TDocMainProcessNativeView f291933c;

    /* renamed from: d, reason: collision with root package name */
    private final INativeEngineFileBrowserWrapper.OpenMode f291934d;

    /* renamed from: e, reason: collision with root package name */
    private String f291935e;

    /* renamed from: f, reason: collision with root package name */
    private int f291936f;

    /* renamed from: g, reason: collision with root package name */
    private int f291937g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f291938h;

    /* renamed from: i, reason: collision with root package name */
    private FindReplaceView f291939i;

    /* renamed from: j, reason: collision with root package name */
    private final FileLoadCallback f291940j = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements FileLoadCallback {
        a() {
        }

        @Override // com.tencent.nativepreview.base.primitive.FileLoadCallback
        public void onCallback(int i3, String str) {
            Log.d("NativeEngineFileBrowserWrapperImpl", "FileLoadCallback onCallback " + i3 + " message:" + str);
            if (i.this.f291932b != null) {
                i.this.f291932b.b(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements INativeEngineFileBrowserWrapper.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f291942a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ INativeEngineFileBrowserWrapper.c f291943b;

        b(Activity activity, INativeEngineFileBrowserWrapper.c cVar) {
            this.f291942a = activity;
            this.f291943b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(DialogInterface dialogInterface, int i3) {
            i.this.s(((QQCustomDialog) dialogInterface).getEditString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(DialogInterface dialogInterface, int i3) {
            i.this.s(((QQCustomDialog) dialogInterface).getEditString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(int i3, Activity activity, INativeEngineFileBrowserWrapper.c cVar, String str) {
            if (i3 != 14014) {
                if (i3 == 14015) {
                    QQToast.makeText(activity, 1, "\u5bc6\u7801\u8f93\u5165\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                    com.tencent.mobileqq.teamwork.d.a(activity, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.app.l
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            i.b.this.h(dialogInterface, i16);
                        }
                    });
                }
            } else {
                com.tencent.mobileqq.teamwork.d.a(activity, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.app.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        i.b.this.g(dialogInterface, i16);
                    }
                });
            }
            cVar.b(i3, str);
            if (i3 == 0) {
                i.this.e(0);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void b(final int i3, final String str) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Activity activity = this.f291942a;
            final INativeEngineFileBrowserWrapper.c cVar = this.f291943b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.j
                @Override // java.lang.Runnable
                public final void run() {
                    i.b.this.i(i3, activity, cVar, str);
                }
            });
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void c() {
            this.f291943b.c();
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void d(int i3) {
            this.f291943b.d(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements FindReplaceView.b {
        c() {
        }

        @Override // com.tencent.mobileqq.teamwork.menu.FindReplaceView.b
        public void a(DocSearchState docSearchState) {
            if (i.this.f291931a != null) {
                i.this.f291931a.d(docSearchState);
            } else if (i.this.f291933c != null) {
                i.this.f291933c.n(docSearchState);
            }
            i.this.f291939i.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.teamwork.menu.FindReplaceView.b
        public boolean b(DocSearchState docSearchState, boolean z16) {
            if (i.this.f291931a != null) {
                return i.this.f291931a.t(docSearchState, z16);
            }
            if (i.this.f291933c != null) {
                return i.this.f291933c.D(docSearchState, z16);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.teamwork.menu.FindReplaceView.b
        public boolean c(DocSearchState docSearchState, long j3) {
            if (i.this.f291931a != null) {
                return i.this.f291931a.f(docSearchState, j3);
            }
            if (i.this.f291933c != null) {
                return i.this.f291933c.q(docSearchState, j3);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.teamwork.menu.FindReplaceView.b
        public DocSearchState getCurrentState() {
            if (i.this.f291931a != null) {
                return i.this.f291931a.h();
            }
            if (i.this.f291933c != null) {
                return i.this.f291933c.r();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DriveUploadCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ INativeEngineFileBrowserWrapper.b f291946a;

        d(INativeEngineFileBrowserWrapper.b bVar) {
            this.f291946a = bVar;
        }

        @Override // com.tencent.nativepreview.service.drive.DriveUploadCallback
        public void onCallback(int i3, @Nullable String str, @Nullable DocInfo docInfo) {
            ir2.b bVar = new ir2.b();
            if (docInfo != null) {
                bVar.f408435c = docInfo.getDocId();
                bVar.f408433a = docInfo.getPadType();
                bVar.f408434b = docInfo.getLocalPadId();
                bVar.f408436d = docInfo.getFolderId();
                bVar.f408437e = docInfo.getTitle();
                bVar.f408438f = docInfo.getDomainId();
                bVar.f408439g = docInfo.getUrl();
                bVar.f408440h = docInfo.getDocType();
            }
            INativeEngineFileBrowserWrapper.b bVar2 = this.f291946a;
            if (bVar2 != null) {
                bVar2.a(i3, str, bVar);
            }
        }
    }

    public i(Activity activity, final String str, int i3, INativeEngineFileBrowserWrapper.OpenMode openMode, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, INativeEngineFileBrowserWrapper.c cVar) {
        this.f291935e = str;
        this.f291934d = openMode;
        this.f291932b = new b(activity, cVar);
        this.f291938h = new FrameLayout(activity);
        FindReplaceView findReplaceView = new FindReplaceView(activity);
        this.f291939i = findReplaceView;
        findReplaceView.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (openMode == INativeEngineFileBrowserWrapper.OpenMode.MAIN_PROCESS) {
            System.loadLibrary("binding");
            com.tencent.nativepreview.d dVar = new com.tencent.nativepreview.d(new com.tencent.nativepreview.a(i3, MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/localEdit/offline"), new NativeEngineView(activity));
            this.f291931a = dVar;
            dVar.l(activity, new Function1() { // from class: com.tencent.mobileqq.teamwork.app.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p16;
                    p16 = i.this.p(str, (Boolean) obj);
                    return p16;
                }
            });
            this.f291938h.addView(this.f291931a.k(), layoutParams);
        } else if (openMode == INativeEngineFileBrowserWrapper.OpenMode.CHILD_PROCESS) {
            TDocMainProcessNativeView tDocMainProcessNativeView = new TDocMainProcessNativeView(activity, str, i3);
            this.f291933c = tDocMainProcessNativeView;
            tDocMainProcessNativeView.setNativeLoadCallback(this.f291932b);
            this.f291933c.setOpenDocsPerformanceRecorder(openDocsPerformanceRecorder);
            this.f291938h.addView(this.f291933c, layoutParams);
        }
        this.f291938h.addView(this.f291939i, new LinearLayout.LayoutParams(-1, -2));
    }

    private DocOutlineItem[] o() {
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            return dVar.i();
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            return tDocMainProcessNativeView.s();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit p(String str, Boolean bool) {
        this.f291931a.q(str, "", this.f291940j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f291939i.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(DocOutlineItem docOutlineItem) {
        t(docOutlineItem.getNodePtr());
        return Unit.INSTANCE;
    }

    private void t(long j3) {
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            dVar.u(j3);
            return;
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.E(j3);
        }
    }

    private void u(int i3, INativeEngineFileBrowserWrapper.a aVar, INativeEngineFileBrowserWrapper.b bVar) {
        String str;
        DriveUploadRequest driveUploadRequest = new DriveUploadRequest();
        driveUploadRequest.setFilePath(this.f291935e);
        driveUploadRequest.setUid(aVar.f291658a);
        driveUploadRequest.setDomain(aVar.f291659b);
        if (!TextUtils.isEmpty(aVar.f291660c)) {
            str = aVar.f291660c;
        } else {
            str = "";
        }
        driveUploadRequest.setCookie(str);
        driveUploadRequest.setDriveFolder("/\u6765\u81eaQQ\u6587\u4ef6");
        driveUploadRequest.setConvertType(i3);
        d dVar = new d(bVar);
        if (this.f291931a != null) {
            NativeEngineJNI.uploadToDrive(driveUploadRequest, dVar);
            return;
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.H(driveUploadRequest, dVar);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public MenuTabViewBase a(Context context) {
        FileTabMenuView fileTabMenuView = new FileTabMenuView(context);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = MenuConfigImpl.f292180b.iterator();
        while (it.hasNext()) {
            au auVar = MenuConfigImpl.f292179a.get(Integer.valueOf(it.next().intValue()));
            if (auVar != null) {
                arrayList.add(auVar.clone());
            }
        }
        fileTabMenuView.d(arrayList, MenuConfigImpl.f292181c);
        fileTabMenuView.c();
        return fileTabMenuView;
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void b(boolean z16) {
        this.f291939i.setVisibility(0);
        DocSearchState docSearchState = new DocSearchState();
        docSearchState.setReplace(z16);
        this.f291939i.setSearchOptions(docSearchState);
        this.f291939i.setSearchHandler(new c());
        this.f291938h.requestLayout();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.g
            @Override // java.lang.Runnable
            public final void run() {
                i.this.q();
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void c(RectF rectF) {
        this.f291936f = (int) (rectF.right - rectF.left);
        this.f291937g = (int) (rectF.bottom - rectF.top);
        int height = this.f291939i.getHeight();
        float f16 = this.f291939i.getResources().getDisplayMetrics().density;
        if (this.f291939i.getVisibility() == 0) {
            rectF.top += height / this.f291939i.getResources().getDisplayMetrics().density;
        }
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            dVar.w(rectF, f16);
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.setFrame(rectF);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void d() {
        aj.INSTANCE.d((Activity) this.f291938h.getContext(), o(), new Function1() { // from class: com.tencent.mobileqq.teamwork.app.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r16;
                r16 = i.this.r((DocOutlineItem) obj);
                return r16;
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void e(int i3) {
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            dVar.v(PageMode.INSTANCE.a(i3));
            return;
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.setPageMode(i3);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void f(INativeEngineFileBrowserWrapper.a aVar, INativeEngineFileBrowserWrapper.b bVar) {
        u(10, aVar, bVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void g(int i3, INativeEngineFileBrowserWrapper.a aVar, INativeEngineFileBrowserWrapper.b bVar) {
        u(i3, aVar, bVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public View getView() {
        return this.f291938h;
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void onDestroy() {
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            dVar.s();
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.z();
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper
    public void onResume() {
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.A();
        }
    }

    public void s(String str) {
        com.tencent.nativepreview.d dVar = this.f291931a;
        if (dVar != null) {
            dVar.q(this.f291935e, str, this.f291940j);
        }
        TDocMainProcessNativeView tDocMainProcessNativeView = this.f291933c;
        if (tDocMainProcessNativeView != null) {
            tDocMainProcessNativeView.x(str);
        }
    }
}
