package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0003012B\u0013\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)B\u001d\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b(\u0010,B%\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010.J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0018\u00010\u0019R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/widget/PicProgressView;", "Lcom/tencent/mobileqq/widget/MessageProgressView;", "", "inCurrentProgress", "addProgress", "", "v", "", "key", "setProgressKey", "Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "provider", "setProgressProvider", "", "showProgress", "setShowProgress", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, tl.h.F, "L0", "Z", "pause", "Lcom/tencent/qqnt/aio/widget/PicProgressView$RefreshProgressRunnable;", "M0", "Lcom/tencent/qqnt/aio/widget/PicProgressView$RefreshProgressRunnable;", "refreshProgressRunnable", "N0", "Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "progressProvider", "O0", "Ljava/lang/String;", "P0", "Q0", "I", "lastRealProgress", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "R0", "b", "c", "RefreshProgressRunnable", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PicProgressView extends MessageProgressView {
    static IPatchRedirector $redirector_;

    /* renamed from: R0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final a S0;

    /* renamed from: L0, reason: from kotlin metadata */
    private boolean pause;

    /* renamed from: M0, reason: from kotlin metadata */
    @Nullable
    private RefreshProgressRunnable refreshProgressRunnable;

    /* renamed from: N0, reason: from kotlin metadata */
    private c progressProvider;

    /* renamed from: O0, reason: from kotlin metadata */
    @Nullable
    private String key;

    /* renamed from: P0, reason: from kotlin metadata */
    private boolean showProgress;

    /* renamed from: Q0, reason: from kotlin metadata */
    private int lastRealProgress;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/widget/PicProgressView$RefreshProgressRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", "getCurrentProgress", "()I", "setCurrentProgress", "(I)V", "currentProgress", "e", "getAddProgress", "a", "addProgress", "<init>", "(Lcom/tencent/qqnt/aio/widget/PicProgressView;II)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class RefreshProgressRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int currentProgress;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int addProgress;

        public RefreshProgressRunnable(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PicProgressView.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.currentProgress = i3;
                this.addProgress = i16;
            }
        }

        public final void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.addProgress = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                PicProgressView.this.refreshProgressRunnable = null;
                if (!PicProgressView.this.pause) {
                    int i3 = this.currentProgress;
                    int i16 = this.addProgress;
                    PicProgressView.this.v(i3 + i16, i16);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/widget/PicProgressView$a", "Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "", "d", "progress", "", "b", "c", "", "a", "I", "currentProgress", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int currentProgress;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
        public void b(int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, progress);
            } else {
                this.currentProgress = progress;
            }
        }

        @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 100;
        }

        @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.currentProgress;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/widget/PicProgressView$b;", "", "com/tencent/qqnt/aio/widget/PicProgressView$a", "EMPTY_PROGRESS_PROVIDER", "Lcom/tencent/qqnt/aio/widget/PicProgressView$a;", "", "FAKE_PROGRESS", "I", "MAX_PROGRESS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.PicProgressView$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "", "", "d", "progress", "", "b", "c", "", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface c {
        boolean a();

        void b(int progress);

        int c();

        int d();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            S0 = new a();
        }
    }

    public PicProgressView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int inCurrentProgress, int addProgress) {
        int coerceAtLeast;
        long j3;
        c cVar = this.progressProvider;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar = null;
        }
        a aVar = S0;
        if (cVar == aVar) {
            return;
        }
        c cVar3 = this.progressProvider;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar3 = null;
        }
        if (cVar3.d() < 100 && inCurrentProgress >= 100) {
            inCurrentProgress = 100;
        } else if (inCurrentProgress >= 100) {
            this.progressProvider = aVar;
            return;
        }
        c cVar4 = this.progressProvider;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar4 = null;
        }
        cVar4.b(inCurrentProgress);
        c cVar5 = this.progressProvider;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar5 = null;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(cVar5.c(), 0);
        c cVar6 = this.progressProvider;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar6 = null;
        }
        if (cVar6.c() < 0) {
            j3 = 1000;
        } else {
            j3 = 25;
        }
        c cVar7 = this.progressProvider;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar7 = null;
        }
        if (cVar7.d() <= coerceAtLeast) {
            if (QLog.isColorLevel()) {
                String str = this.f315820d;
                c cVar8 = this.progressProvider;
                if (cVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
                } else {
                    cVar2 = cVar8;
                }
                QLog.d(str, 2, "currentProgress=" + inCurrentProgress + ", realProgress=" + coerceAtLeast + ", addProgress=" + addProgress + ", progressProvider=" + cVar2);
            }
            setProgress(inCurrentProgress);
            RefreshProgressRunnable refreshProgressRunnable = this.refreshProgressRunnable;
            if (refreshProgressRunnable == null) {
                RefreshProgressRunnable refreshProgressRunnable2 = new RefreshProgressRunnable(inCurrentProgress, addProgress);
                this.refreshProgressRunnable = refreshProgressRunnable2;
                postDelayed(refreshProgressRunnable2, j3);
                return;
            } else {
                if (addProgress != 1) {
                    Intrinsics.checkNotNull(refreshProgressRunnable);
                    refreshProgressRunnable.a(addProgress);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            String str2 = this.f315820d;
            c cVar9 = this.progressProvider;
            if (cVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            } else {
                cVar2 = cVar9;
            }
            QLog.d(str2, 2, "currentProgress=" + inCurrentProgress + ", realProgress=" + coerceAtLeast + ", addProgress=" + addProgress + ", progressProvider=" + cVar2);
        }
        if (coerceAtLeast >= this.lastRealProgress) {
            setProgress(coerceAtLeast);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.MessageProgressView
    public void h(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c cVar = this.progressProvider;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
            cVar = null;
        }
        if (!cVar.a()) {
            return;
        }
        super.h(canvas);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            removeCallbacks(this.refreshProgressRunnable);
            super.onDetachedFromWindow();
        }
    }

    public final void setProgress(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, progress);
            return;
        }
        if (progress == 100) {
            setProgressProvider(S0);
        }
        this.lastRealProgress = progress;
        setDrawStatus(1);
        setAnimProgress(progress, this.key);
    }

    public final void setProgressKey(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
        } else {
            this.key = key;
            a(key);
        }
    }

    public final void setProgressProvider(@NotNull c provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        c cVar = this.progressProvider;
        if (cVar != null) {
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressProvider");
                cVar = null;
            }
            if (cVar == provider) {
                return;
            }
        }
        RefreshProgressRunnable refreshProgressRunnable = this.refreshProgressRunnable;
        if (refreshProgressRunnable != null) {
            removeCallbacks(refreshProgressRunnable);
            this.refreshProgressRunnable = null;
        }
        this.progressProvider = provider;
    }

    public final void setShowProgress(boolean showProgress) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, showProgress);
            return;
        }
        if (!this.showProgress && showProgress) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.showProgress = showProgress;
        if (z16) {
            invalidate();
        }
    }

    public PicProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PicProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
