package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J@\u0010\u000e\u001a\u00020\f2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J(\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002J\u0019\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR \u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarLayerImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/qqnt/avatar/layer/d;", "", "layer", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lkotlin/Function0;", "", "invoke", "g", CanvasView.ACTION_RECT, "resourceRect", tl.h.F, "curLayer", "setCurLayer", "f", "()Lcom/tencent/qqnt/avatar/layer/d;", "Lcom/tencent/qqnt/avatar/layer/c;", DownloadInfo.spKey_Config, "setResourceDrawConfig", "onDraw", "d", "Landroid/graphics/Rect;", "viewRect", "e", "Lcom/tencent/qqnt/avatar/layer/c;", "drawConfig", "Lcom/tencent/qqnt/avatar/layer/d;", "i", "Landroid/graphics/Paint;", "bitmapPaint", "Lcom/tencent/mobileqq/proavatar/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/proavatar/k;", "getViewConfig$qqavatar_api_release", "()Lcom/tencent/mobileqq/proavatar/k;", "setViewConfig$qqavatar_api_release", "(Lcom/tencent/mobileqq/proavatar/k;)V", "viewConfig", "Lcom/tencent/mobileqq/proavatar/utils/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/proavatar/utils/b;", "drawableBoundsChecker", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQProAvatarLayerImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.proavatar.utils.b drawableBoundsChecker;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect viewRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.layer.c drawConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect resourceRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint bitmapPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k viewConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarLayerImageView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.QQProAvatarLayerImageView$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQProAvatarLayerImageView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    private final void g(com.tencent.qqnt.avatar.layer.d<? extends Object> layer, Canvas canvas, Rect bounds, Paint paint, Function0<Unit> invoke) {
        if (!i.f259610a.b(layer, canvas, bounds, paint, this.viewConfig, invoke, new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarLayerImageView$maskLayer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarLayerImageView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQProAvatarLayerImageView.this.invalidate();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        })) {
            invoke.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Canvas canvas, Rect bounds, Rect rect, Rect resourceRect) {
        canvas.scale(resourceRect.width() / rect.width(), resourceRect.height() / rect.height());
        canvas.translate(-((bounds.width() * (rect.left - resourceRect.left)) / resourceRect.width()), -((bounds.height() * (rect.top - resourceRect.top)) / resourceRect.height()));
    }

    @Nullable
    public final com.tencent.qqnt.avatar.layer.d<? extends Object> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.avatar.layer.d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.curLayer;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable final Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Rect rect = null;
        try {
            if (canvas == null) {
                super.onDraw(null);
                return;
            }
            if (getWidth() != 0 && getHeight() != 0) {
                com.tencent.qqnt.avatar.layer.c cVar = this.drawConfig;
                if (cVar != null) {
                    rect = cVar.b();
                }
                final Rect rect2 = rect;
                if (getDrawable() != null && rect2 != null && rect2.width() > 0 && rect2.height() > 0) {
                    final Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = getDrawable().getIntrinsicWidth();
                    final Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = getDrawable().getIntrinsicHeight();
                    if (getDrawable() instanceof BitmapDrawable) {
                        Drawable drawable = getDrawable();
                        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                        intRef.element = ((BitmapDrawable) drawable).getBitmap().getWidth();
                        Drawable drawable2 = getDrawable();
                        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                        intRef2.element = ((BitmapDrawable) drawable2).getBitmap().getHeight();
                    }
                    if (intRef.element > 0 && intRef2.element > 0) {
                        this.viewRect.set(0, 0, getWidth(), getHeight());
                        com.tencent.qqnt.avatar.layer.d<? extends Object> dVar = this.curLayer;
                        if (dVar != null) {
                            Intrinsics.checkNotNull(dVar);
                            g(dVar, canvas, this.viewRect, this.bitmapPaint, new Function0<Unit>(canvas, intRef, intRef2, rect2) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarLayerImageView$onDraw$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Canvas $canvas;
                                final /* synthetic */ Rect $rect;
                                final /* synthetic */ Ref.IntRef $tHeight;
                                final /* synthetic */ Ref.IntRef $tWidth;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$canvas = canvas;
                                    this.$tWidth = intRef;
                                    this.$tHeight = intRef2;
                                    this.$rect = rect2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, QQProAvatarLayerImageView.this, canvas, intRef, intRef2, rect2);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    com.tencent.qqnt.avatar.layer.c cVar2;
                                    Rect rect3;
                                    Rect rect4;
                                    Rect rect5;
                                    Rect rect6;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    com.tencent.mobileqq.proavatar.utils.a.c(QQProAvatarLayerImageView.this);
                                    this.$canvas.save();
                                    cVar2 = QQProAvatarLayerImageView.this.drawConfig;
                                    Rect c16 = cVar2 != null ? cVar2.c() : null;
                                    if (c16 == null) {
                                        rect6 = QQProAvatarLayerImageView.this.resourceRect;
                                        rect6.set(0, 0, this.$tWidth.element, this.$tHeight.element);
                                    } else {
                                        rect3 = QQProAvatarLayerImageView.this.resourceRect;
                                        rect3.set(c16);
                                    }
                                    QQProAvatarLayerImageView qQProAvatarLayerImageView = QQProAvatarLayerImageView.this;
                                    Canvas canvas2 = this.$canvas;
                                    rect4 = qQProAvatarLayerImageView.viewRect;
                                    Rect rect7 = this.$rect;
                                    rect5 = QQProAvatarLayerImageView.this.resourceRect;
                                    qQProAvatarLayerImageView.h(canvas2, rect4, rect7, rect5);
                                    super/*android.widget.ImageView*/.onDraw(this.$canvas);
                                    this.$canvas.restore();
                                }
                            });
                        } else {
                            super.onDraw(canvas);
                        }
                    }
                    super.onDraw(canvas);
                    return;
                }
                if (this.curLayer != null) {
                    this.viewRect.set(0, 0, getWidth(), getHeight());
                    com.tencent.qqnt.avatar.layer.d<? extends Object> dVar2 = this.curLayer;
                    Intrinsics.checkNotNull(dVar2);
                    g(dVar2, canvas, this.viewRect, this.bitmapPaint, new Function0<Unit>(canvas) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarLayerImageView$onDraw$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Canvas $canvas;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$canvas = canvas;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarLayerImageView.this, (Object) canvas);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                super/*android.widget.ImageView*/.onDraw(this.$canvas);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else {
                    super.onDraw(canvas);
                }
                this.drawableBoundsChecker.a("QQProAvatarLayerImageView", this, getDrawable());
                return;
            }
            super.onDraw(canvas);
        } catch (Throwable th5) {
            QLog.e("QQProAvatarLayerImageView", 1, "onDraw catch exception ", th5);
        }
    }

    public final void setCurLayer(@NotNull com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) curLayer);
        } else {
            Intrinsics.checkNotNullParameter(curLayer, "curLayer");
            this.curLayer = curLayer;
        }
    }

    public final void setResourceDrawConfig(@Nullable com.tencent.qqnt.avatar.layer.c config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) config);
        } else {
            this.drawConfig = config;
        }
    }

    public final void setViewConfig$qqavatar_api_release(@Nullable k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) kVar);
        } else {
            this.viewConfig = kVar;
        }
    }

    public /* synthetic */ QQProAvatarLayerImageView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQProAvatarLayerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.viewRect = new Rect();
        this.resourceRect = new Rect();
        this.bitmapPaint = new Paint();
        this.drawableBoundsChecker = new com.tencent.mobileqq.proavatar.utils.b();
        setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
