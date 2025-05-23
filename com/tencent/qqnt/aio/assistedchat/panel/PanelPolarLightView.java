package com.tencent.qqnt.aio.assistedchat.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.PanelPolarLightView;
import com.tencent.theme.SkinnableView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R*\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00138\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tencent/theme/SkinnableView;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "stopAnimation", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "o", "()Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "polarLightRender", "com/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView$b;", "renderCallback", "", "D", "Z", "isAnimation", "value", "E", "getRenderEnable", "()Z", "p", "(Z)V", "renderEnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PanelPolarLightView extends AppCompatImageView implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final List<Integer> G;

    @NotNull
    private static final List<Integer> H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b renderCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isAnimation;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean renderEnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy polarLightRender;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView$a;", "", "Landroid/content/Context;", "context", "", "", "b", "", "TAG", "Ljava/lang/String;", "renderColorsLight", "Ljava/util/List;", "renderColorsNight", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.PanelPolarLightView$a, reason: from kotlin metadata */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Integer> b(Context context) {
            return com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(context, R.color.qui_common_bg_nav_bottom_aio)) ? PanelPolarLightView.H : PanelPolarLightView.G;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView$b", "Lcom/tencent/biz/qui/quipolarlight/render/d;", "", "errorMsg", "", "onFailed", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onSuccess", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.biz.qui.quipolarlight.render.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PanelPolarLightView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PanelPolarLightView this$0, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setImageBitmap(bitmap);
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onFailed(@Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) errorMsg);
                return;
            }
            QLog.e("PanelPolarLightView", 1, "render onFailed " + errorMsg);
        }

        @Override // com.tencent.biz.qui.quipolarlight.render.d
        public void onSuccess(@Nullable final Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
            } else {
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    PanelPolarLightView.this.setImageBitmap(bitmap);
                    return;
                }
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final PanelPolarLightView panelPolarLightView = PanelPolarLightView.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.panel.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        PanelPolarLightView.b.b(PanelPolarLightView.this, bitmap);
                    }
                });
            }
        }
    }

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59033);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{13483263, 14078975, 16766458, 16768980, 13555199});
        G = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{6312074, 6249597, 9134725, 9003089, 6777728});
        H = listOf2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelPolarLightView(@NotNull final Context context) {
        super(context, null, 0);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        setScaleType(ImageView.ScaleType.FIT_XY);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PolarImageRender>(context) { // from class: com.tencent.qqnt.aio.assistedchat.panel.PanelPolarLightView$polarLightRender$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PolarImageRender invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (PolarImageRender) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                PolarImageRender polarImageRender = new PolarImageRender();
                Context context2 = this.$context;
                polarImageRender.p(0.025f);
                polarImageRender.r(0.4f);
                polarImageRender.q(new a.b(0.7f, 0.5f, 0.7f, 0.5f, 0.0f));
                polarImageRender.s(PanelPolarLightView.INSTANCE.b(context2));
                return polarImageRender;
            }
        });
        this.polarLightRender = lazy;
        this.renderCallback = new b();
    }

    private final PolarImageRender o() {
        return (PolarImageRender) this.polarLightRender.getValue();
    }

    private final void q() {
        if (!this.isAnimation) {
            this.isAnimation = true;
            o().u(this.renderCallback);
        }
    }

    private final void stopAnimation() {
        if (this.isAnimation) {
            this.isAnimation = false;
            o().v();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.renderEnable) {
            q();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDetachedFromWindow();
            stopAnimation();
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PolarImageRender o16 = o();
        Companion companion = INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        o16.s(companion.b(context));
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (isAttachedToWindow()) {
            if (z16) {
                q();
            } else {
                stopAnimation();
            }
        }
        this.renderEnable = z16;
    }
}
