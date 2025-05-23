package com.tencent.qui.quiblurview;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\u00020\u0001:\u0003/0\u0003B\u0019\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\b\u0010+\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "c", "", "onPreDraw", "Lcom/tencent/qui/quiblurview/QQNativeBlurView;", "qqNativeBlurView", "Lcom/tencent/qui/quiblurview/f$b;", "childDirtyState", "d", "e", "", "J", "lastPreDrawTime", "preDrawInterval", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mainHandler", "", "Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$b;", tl.h.F, "Ljava/util/Map;", "onPreDrawMap", "", "Landroid/view/View;", "i", "Ljava/util/List;", "targetViewList", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "onPreDrawRunnable", "Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$c;", "viewDirtyState", "D", "Landroid/view/View;", "blurSource", "E", "Lcom/tencent/qui/quiblurview/f$b;", "parentSourceDirtyState", "<init>", "(Landroid/view/View;Lcom/tencent/qui/quiblurview/f$b;)V", "G", "a", "b", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QQBlurPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    static IPatchRedirector $redirector_;
    private static final HashMap<Integer, QQBlurPreDrawListener> F;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final c viewDirtyState;

    /* renamed from: D, reason: from kotlin metadata */
    private final View blurSource;

    /* renamed from: E, reason: from kotlin metadata */
    private final f.b parentSourceDirtyState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastPreDrawTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long preDrawInterval;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<QQNativeBlurView, b> onPreDrawMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<View> targetViewList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Runnable onPreDrawRunnable;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$a;", "", "Landroid/view/View;", "blurSourceView", "Lcom/tencent/qui/quiblurview/f$b;", "parentSourceDirtyState", "Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener;", "a", "", "b", "", "PRE_DRAW_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "blurSourceMap", "Ljava/util/HashMap;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.QQBlurPreDrawListener$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final QQBlurPreDrawListener a(@NotNull View blurSourceView, @Nullable f.b parentSourceDirtyState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (QQBlurPreDrawListener) iPatchRedirector.redirect((short) 1, (Object) this, (Object) blurSourceView, (Object) parentSourceDirtyState);
            }
            Intrinsics.checkNotNullParameter(blurSourceView, "blurSourceView");
            int hashCode = blurSourceView.hashCode();
            QQBlurPreDrawListener qQBlurPreDrawListener = (QQBlurPreDrawListener) QQBlurPreDrawListener.F.get(Integer.valueOf(hashCode));
            if (qQBlurPreDrawListener != null) {
                return qQBlurPreDrawListener;
            }
            QQBlurPreDrawListener qQBlurPreDrawListener2 = new QQBlurPreDrawListener(blurSourceView, parentSourceDirtyState);
            QQBlurPreDrawListener.F.put(Integer.valueOf(hashCode), qQBlurPreDrawListener2);
            return qQBlurPreDrawListener2;
        }

        public final void b(@NotNull View blurSourceView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) blurSourceView);
                return;
            }
            Intrinsics.checkNotNullParameter(blurSourceView, "blurSourceView");
            QQBlurPreDrawListener.F.remove(Integer.valueOf(blurSourceView.hashCode()));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$b;", "", "", "a", "Z", "b", "()Z", "d", "(Z)V", "isDirty", "Lcom/tencent/qui/quiblurview/f$b;", "Lcom/tencent/qui/quiblurview/f$b;", "()Lcom/tencent/qui/quiblurview/f$b;", "c", "(Lcom/tencent/qui/quiblurview/f$b;)V", "childDirtyState", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isDirty;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private f.b childDirtyState;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Nullable
        public final f.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f.b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.childDirtyState;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            return this.isDirty;
        }

        public final void c(@Nullable f.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            } else {
                this.childDirtyState = bVar;
            }
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.isDirty = z16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurPreDrawListener$c;", "", "", "a", "", UserInfo.SEX_FEMALE, "transitionX", "b", "transitionY", "c", BasicAnimation.KeyPath.SCALE_X, "d", BasicAnimation.KeyPath.SCALE_Y, "Landroid/view/View;", "e", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float transitionX;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float transitionY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float scaleX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float scaleY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            try {
                if (this.transitionX == this.view.getTranslationX() && this.transitionY == this.view.getTranslationY() && this.scaleX == this.view.getScaleX() && this.scaleY == this.view.getScaleY()) {
                    return this.view.isDirty();
                }
                return true;
            } finally {
                this.transitionX = this.view.getTranslationX();
                this.transitionY = this.view.getTranslationY();
                this.scaleX = this.view.getScaleX();
                this.scaleY = this.view.getScaleY();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8721);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            F = new HashMap<>();
        }
    }

    public QQBlurPreDrawListener(@NotNull View blurSource, @Nullable f.b bVar) {
        Intrinsics.checkNotNullParameter(blurSource, "blurSource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) blurSource, (Object) bVar);
            return;
        }
        this.blurSource = blurSource;
        this.parentSourceDirtyState = bVar;
        this.preDrawInterval = 4L;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.onPreDrawMap = new LinkedHashMap();
        this.targetViewList = new ArrayList();
        this.onPreDrawRunnable = new Runnable() { // from class: com.tencent.qui.quiblurview.QQBlurPreDrawListener$onPreDrawRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) QQBlurPreDrawListener.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    QQBlurPreDrawListener.this.c();
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }
        };
        this.viewDirtyState = new c(blurSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        boolean z16;
        boolean z17;
        boolean z18;
        f.b bVar;
        this.lastPreDrawTime = SystemClock.elapsedRealtime();
        if (this.viewDirtyState.a() && ((bVar = this.parentSourceDirtyState) == null || bVar.a())) {
            z16 = true;
        } else {
            z16 = false;
        }
        Iterator<Map.Entry<QQNativeBlurView, b>> it = this.onPreDrawMap.entrySet().iterator();
        while (it.hasNext()) {
            b value = it.next().getValue();
            if (!z16) {
                f.b a16 = value.a();
                if (a16 != null) {
                    z18 = a16.a();
                } else {
                    z18 = false;
                }
                if (!z18) {
                    z17 = false;
                    value.d(z17);
                }
            }
            z17 = true;
            value.d(z17);
        }
        for (Map.Entry<QQNativeBlurView, b> entry : this.onPreDrawMap.entrySet()) {
            entry.getKey().j(entry.getValue().b());
        }
    }

    public final void d(@NotNull QQNativeBlurView qqNativeBlurView, @Nullable f.b childDirtyState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qqNativeBlurView, (Object) childDirtyState);
            return;
        }
        Intrinsics.checkNotNullParameter(qqNativeBlurView, "qqNativeBlurView");
        if (this.targetViewList.isEmpty()) {
            if (QQNativeBlurView.INSTANCE.e()) {
                ud0.d.g("BlurPreDrawListener", ud0.d.f438810d, "[onAttachedToWindow] addOnPreDrawListener, view=" + qqNativeBlurView.hashCode());
            }
            qqNativeBlurView.getViewTreeObserver().addOnPreDrawListener(this);
        }
        if (!this.targetViewList.contains(qqNativeBlurView)) {
            this.targetViewList.add(qqNativeBlurView);
            b bVar = new b();
            bVar.c(childDirtyState);
            this.onPreDrawMap.put(qqNativeBlurView, bVar);
        }
    }

    public final void e(@NotNull QQNativeBlurView qqNativeBlurView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqNativeBlurView);
            return;
        }
        Intrinsics.checkNotNullParameter(qqNativeBlurView, "qqNativeBlurView");
        this.targetViewList.remove(qqNativeBlurView);
        this.onPreDrawMap.remove(qqNativeBlurView);
        if (this.targetViewList.isEmpty()) {
            qqNativeBlurView.getViewTreeObserver().removeOnPreDrawListener(this);
            INSTANCE.b(this.blurSource);
            if (QQNativeBlurView.INSTANCE.e()) {
                ud0.d.g("BlurPreDrawListener", ud0.d.f438810d, "[onDetachedFromWindow] removeOnPreDrawListener, view=" + qqNativeBlurView.hashCode());
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.lastPreDrawTime;
        if (elapsedRealtime <= this.preDrawInterval) {
            this.mainHandler.removeCallbacks(this.onPreDrawRunnable);
            this.mainHandler.postDelayed(this.onPreDrawRunnable, this.preDrawInterval - elapsedRealtime);
            return true;
        }
        this.mainHandler.removeCallbacks(this.onPreDrawRunnable);
        this.onPreDrawRunnable.run();
        return true;
    }
}
