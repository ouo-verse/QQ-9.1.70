package com.tencent.nativepreview;

import android.app.Activity;
import android.graphics.RectF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.nativepreview.base.primitive.FileLoadCallback;
import com.tencent.nativepreview.biz.i;
import com.tencent.nativepreview.render.TdfAndroidView;
import com.tencent.nativepreview.render.a;
import com.tencent.nativepreview.service.Log;
import com.tencent.nativepreview.wrapper.base.Editor;
import com.tencent.nativepreview.wrapper.base.ImageExportCallback;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.nativepreview.wrapper.model.PageMode;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001=B\u0017\u0012\u0006\u0010A\u001a\u00020<\u0012\u0006\u0010G\u001a\u00020B\u00a2\u0006\u0004\bO\u0010PJ(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J&\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0006J\b\u0010'\u001a\u0004\u0018\u00010&J\u0018\u0010*\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020\tJ\u0018\u0010,\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020\u0005J\u0010\u0010-\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010&J\u0015\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.\u00a2\u0006\u0004\b0\u00101J\u000e\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\tJ\u0006\u00104\u001a\u00020\u0006J0\u0010;\u001a\u00020\u00062\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010:R\u0017\u0010A\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010G\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010M\u00a8\u0006Q"}, d2 = {"Lcom/tencent/nativepreview/d;", "Lcom/tencent/nativepreview/base/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "", "", "onInitSuccess", "o", "", "shell", "viewContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", ReportConstant.COSTREPORT_PREFIX, "", "path", NotificationActivity.PASSWORD, "Lcom/tencent/nativepreview/base/primitive/FileLoadCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "ratio", "w", "", "scale", "maxScale", "minScale", HippyTKDListViewAdapter.X, "Lcom/tencent/nativepreview/wrapper/model/PageMode;", "j", "mode", "v", SQLiteDatabase.OPERATE_TYPE_REPLACE, "y", "r", "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", h.F, "searchState", "offset", "f", "all", "t", "d", "", "Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "i", "()[Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", "paragraphNodePtr", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "startPage", "count", "pixelRatio", "saveFolder", "Lcom/tencent/nativepreview/wrapper/base/ImageExportCallback;", "e", "Lcom/tencent/nativepreview/a;", "a", "Lcom/tencent/nativepreview/a;", "g", "()Lcom/tencent/nativepreview/a;", DownloadInfo.spKey_Config, "Lcom/tencent/nativepreview/NativeEngineView;", "b", "Lcom/tencent/nativepreview/NativeEngineView;", "k", "()Lcom/tencent/nativepreview/NativeEngineView;", "view", "Lcom/tencent/nativepreview/render/a;", "c", "Lcom/tencent/nativepreview/render/a;", "tdfAndroidEngine", "Lcom/tencent/nativepreview/wrapper/base/Editor;", "Lcom/tencent/nativepreview/wrapper/base/Editor;", "nativeEditor", "<init>", "(Lcom/tencent/nativepreview/a;Lcom/tencent/nativepreview/NativeEngineView;)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class d extends com.tencent.nativepreview.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NativeEngineView view;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.nativepreview.render.a tdfAndroidEngine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Editor nativeEditor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/nativepreview/d$a;", "", "", "TAG", "Ljava/lang/String;", "", "defaultMaxScale", "D", "defaultMinScale", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.d$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/nativepreview/d$b", "Lcom/tencent/nativepreview/render/a$b;", "", "shell", "viewContext", "", "a", "(Ljava/lang/Long;Ljava/lang/Long;)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f337857a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f337858b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f337859c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1, d dVar, Activity activity) {
            this.f337857a = function1;
            this.f337858b = dVar;
            this.f337859c = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, function1, dVar, activity);
            }
        }

        @Override // com.tencent.nativepreview.render.a.b
        public void a(@Nullable Long shell, @Nullable Long viewContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) shell, (Object) viewContext);
                return;
            }
            if (shell != null && viewContext != null) {
                this.f337858b.m(this.f337859c, shell.longValue(), viewContext.longValue());
                Log.INSTANCE.i("NativeEngineController", "NativeEditor inited.");
                Function1<Boolean, Unit> function1 = this.f337857a;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            Log.INSTANCE.w("NativeEngineController", "NativeEditor init error.");
            Function1<Boolean, Unit> function12 = this.f337857a;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/nativepreview/d$c", "Lcom/tencent/nativepreview/biz/i;", "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "getCurrentState", "searchState", "", "offset", "", "c", "all", "b", "", "a", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes21.dex */
    public static final class c implements i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.nativepreview.biz.i
        public void a(@Nullable DocSearchState searchState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) searchState);
            } else {
                d.this.d(searchState);
                d.this.k().f();
            }
        }

        @Override // com.tencent.nativepreview.biz.i
        public boolean b(@Nullable DocSearchState searchState, boolean all) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, searchState, Boolean.valueOf(all))).booleanValue();
            }
            return d.this.t(searchState, all);
        }

        @Override // com.tencent.nativepreview.biz.i
        public boolean c(@Nullable DocSearchState searchState, long offset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, searchState, Long.valueOf(offset))).booleanValue();
            }
            return d.this.f(searchState, offset);
        }

        @Override // com.tencent.nativepreview.biz.i
        @Nullable
        public DocSearchState getCurrentState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DocSearchState) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return d.this.h();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14463);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull a config, @NotNull NativeEngineView view) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) config, (Object) view);
            return;
        }
        this.config = config;
        this.view = view;
        view.setController(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final Activity activity, final long shell, final long viewContext) {
        if (this.nativeEditor != null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.nativepreview.c
            @Override // java.lang.Runnable
            public final void run() {
                d.n(d.this, shell, viewContext, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, long j3, long j16, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.nativeEditor = Editor.INSTANCE.a(this$0.g().b(), j3, j16, this$0.g().a());
        com.tencent.nativepreview.util.a aVar = com.tencent.nativepreview.util.a.f337875a;
        this$0.w(new RectF(0.0f, 0.0f, aVar.b(this$0.k().getWidth(), activity.getResources().getDisplayMetrics().density), aVar.b(this$0.k().getHeight(), activity.getResources().getDisplayMetrics().density)), activity.getResources().getDisplayMetrics().density);
        this$0.x(1.0d, 3.0d, 1.0d);
    }

    private final void o(final Activity activity, Function1<? super Boolean, Unit> onInitSuccess) {
        final com.tencent.nativepreview.render.a a16 = com.tencent.nativepreview.render.a.INSTANCE.a(activity, new b(onInitSuccess, this, activity));
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.nativepreview.b
            @Override // java.lang.Runnable
            public final void run() {
                d.p(com.tencent.nativepreview.render.a.this, activity, this);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.tdfAndroidEngine = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(com.tencent.nativepreview.render.a this_apply, Activity activity, d this$0) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TdfAndroidView tdfAndroidView = new TdfAndroidView(this_apply, activity);
        tdfAndroidView.setAttachActivity(activity);
        this$0.k().c(tdfAndroidView);
    }

    public final void d(@Nullable DocSearchState searchState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) searchState);
            return;
        }
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.cancelFind(searchState);
        }
    }

    public final void e(int startPage, int count, double pixelRatio, @NotNull String saveFolder, @Nullable ImageExportCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(startPage), Integer.valueOf(count), Double.valueOf(pixelRatio), saveFolder, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(saveFolder, "saveFolder");
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.exportImage(startPage, count, pixelRatio, saveFolder, callback);
        }
    }

    public final boolean f(@Nullable DocSearchState searchState, long offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, searchState, Long.valueOf(offset))).booleanValue();
        }
        Editor editor = this.nativeEditor;
        if (editor == null) {
            return false;
        }
        return editor.findNext(searchState, offset);
    }

    @NotNull
    public final a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.config;
    }

    @Nullable
    public final DocSearchState h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (DocSearchState) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Editor editor = this.nativeEditor;
        if (editor == null) {
            return null;
        }
        return editor.getCurrentFindState();
    }

    @Nullable
    public final DocOutlineItem[] i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (DocOutlineItem[]) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        Editor editor = this.nativeEditor;
        if (editor == null) {
            return null;
        }
        return editor.getOutlines();
    }

    @NotNull
    public final PageMode j() {
        Integer valueOf;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PageMode) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Editor editor = this.nativeEditor;
        if (editor == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(editor.getPageMode());
        }
        if (valueOf == null) {
            intValue = PageMode.FLOW.getValue();
        } else {
            intValue = valueOf.intValue();
        }
        Log.INSTANCE.d("NativeEngineController", Intrinsics.stringPlus("getPageMode: ", Integer.valueOf(intValue)));
        return PageMode.INSTANCE.a(intValue);
    }

    @NotNull
    public final NativeEngineView k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NativeEngineView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.view;
    }

    public void l(@NotNull Activity activity, @Nullable Function1<? super Boolean, Unit> onInitSuccess) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) onInitSuccess);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.INSTANCE.i("NativeEngineController", "EngineViewController init.");
        o(activity, onInitSuccess);
    }

    public final void q(@NotNull String path, @NotNull String password, @NotNull FileLoadCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, path, password, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.INSTANCE.d("NativeEngineController", "loadFile path: " + path + ", password: " + password);
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.loadFileAsync(path, password, this.config.a(), callback);
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.refreshView();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Log.INSTANCE.i("NativeEngineController", "EngineViewController release.");
        this.view.g();
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.destroy();
        }
        Editor editor2 = this.nativeEditor;
        if (editor2 != null) {
            editor2.dispose();
        }
        this.nativeEditor = null;
        com.tencent.nativepreview.render.a aVar = this.tdfAndroidEngine;
        if (aVar != null) {
            aVar.a();
        }
        this.tdfAndroidEngine = null;
    }

    public final boolean t(@Nullable DocSearchState searchState, boolean all) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, searchState, Boolean.valueOf(all))).booleanValue();
        }
        Editor editor = this.nativeEditor;
        if (editor == null) {
            return false;
        }
        return editor.replace(searchState, all);
    }

    public final void u(long paragraphNodePtr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, paragraphNodePtr);
            return;
        }
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.scrollTo(paragraphNodePtr);
        }
    }

    public final void v(@NotNull PageMode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) mode);
            return;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Log.INSTANCE.d("NativeEngineController", Intrinsics.stringPlus("setPageMode: ", mode));
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.setPageMode(mode.getValue());
        }
    }

    public final void w(@NotNull RectF rect, float ratio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, rect, Float.valueOf(ratio));
            return;
        }
        Intrinsics.checkNotNullParameter(rect, "rect");
        Log.INSTANCE.d("NativeEngineController", "setPageSize rect: " + rect + ", ratio: " + ratio);
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.setPageSize(rect, ratio);
        }
    }

    public final void x(double scale, double maxScale, double minScale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Double.valueOf(scale), Double.valueOf(maxScale), Double.valueOf(minScale));
            return;
        }
        Log.INSTANCE.d("NativeEngineController", "setScale scale: " + scale + ", maxScale: " + maxScale + ", minScale: " + minScale);
        Editor editor = this.nativeEditor;
        if (editor != null) {
            editor.setScale(scale, maxScale, minScale);
        }
    }

    public final void y(boolean replace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, replace);
        } else {
            Log.INSTANCE.d("NativeEngineController", Intrinsics.stringPlus("showFindReplaceView replace: ", Boolean.valueOf(replace)));
            this.view.h(replace, new c());
        }
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            Log.INSTANCE.d("NativeEngineController", "showOutlineView");
        }
    }
}
