package com.tencent.mobileqq.aio.msglist.holder.component.markdown.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.d;
import com.tencent.qqnt.markdown.QQMarkdownView;
import com.tencent.qqnt.markdown.data.quote.e;
import com.tencent.qqnt.markdown.data.quote.g;
import com.tencent.qqnt.markdown.data.quote.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\bL\u0010MJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\u0003J\u0016\u0010*\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00101R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00101R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010=R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u001b\u0010D\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bA\u0010CR\u001b\u0010G\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\bE\u0010FR\u001b\u0010K\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010B\u001a\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/RichBubbleContentViewBinding;", "Landroidx/viewbinding/ViewBinding;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "t", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "skinInfo", "", "useToken", "", "bubbleType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "l", h.F, "Landroid/graphics/Rect;", "outPadding", "i", "Lcom/tencent/qqnt/markdown/QQMarkdownView;", "p", "D", "j", "fixedWidth", "v", "isCenterTemplate", "u", "isWideScreen", "y", "needExpandWidth", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "B", BdhLogUtil.LogTag.Tag_Conn, "", "processMsg", "state", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "actionView", NodeProps.MIN_WIDTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Z", "c", "d", "e", "f", "Landroid/graphics/Rect;", "g", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "loadingView", "", "mainFontSize", "k", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/markdown/QQMarkdownView;", "constraintRoot", "o", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "processContainer", "Lcom/tencent/qqnt/markdown/data/quote/e;", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/markdown/data/quote/e;", "processComponent", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RichBubbleContentViewBinding implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final float[] f191114o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean fixedWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isCenterTemplate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isWideScreen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needExpandWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect outPadding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOBubbleSkinInfo skinInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable loadingDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView loadingView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mainFontSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy constraintRoot;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processComponent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/RichBubbleContentViewBinding$a;", "", "", "HEADER_SIZE", "[F", "a", "()[F", "", "MARGIN_CENTER_TEMPLATE", UserInfo.SEX_FEMALE, "MARGIN_CENTER_TEMPLATE_WIDE", "MARGIN_WIDE_SCREEN", "", "TAG", "Ljava/lang/String;", "TEXT_LINE_HEIGHT_ADD", "TEXT_SIZE_MAIN_BODY_SP", "TEXT_SIZE_MAIN_BODY_SP_SMALL", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.RichBubbleContentViewBinding$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final float[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return RichBubbleContentViewBinding.f191114o;
            }
            return (float[]) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
            f191114o = new float[]{22.0f, 20.0f, 18.0f, 18.0f, 18.0f, 18.0f};
        }
    }

    public RichBubbleContentViewBinding(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.outPadding = new Rect();
        this.mainFontSize = 16.0f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQMarkdownView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.RichBubbleContentViewBinding$constraintRoot$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RichBubbleContentViewBinding.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQMarkdownView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QQMarkdownView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = RichBubbleContentViewBinding.this.context;
                QQMarkdownView qQMarkdownView = new QQMarkdownView(context2, null, 0, 0, 14, null);
                RichBubbleContentViewBinding.this.t(qQMarkdownView);
                return qQMarkdownView;
            }
        });
        this.constraintRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.RichBubbleContentViewBinding$processContainer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RichBubbleContentViewBinding.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConstraintLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = RichBubbleContentViewBinding.this.context;
                ConstraintLayout constraintLayout = new ConstraintLayout(context2);
                constraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(RichBubbleContentViewBinding.this.m(), -2));
                return constraintLayout;
            }
        });
        this.processContainer = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.RichBubbleContentViewBinding$processComponent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RichBubbleContentViewBinding.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = RichBubbleContentViewBinding.this.context;
                return new e(context2);
            }
        });
        this.processComponent = lazy3;
    }

    private final void E() {
        int l3 = l();
        if (k().getLayoutParams() == null) {
            k().setLayoutParams(new Constraints.LayoutParams(l3, -2));
        } else {
            QQMarkdownView k3 = k();
            ViewGroup.LayoutParams layoutParams = k().getLayoutParams();
            layoutParams.width = l3;
            layoutParams.height = -2;
            k3.setLayoutParams(layoutParams);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichBubbleContentViewBinding", 2, "updateLayoutParams width=" + k().getLayoutParams().width);
        }
    }

    private final void h(AIOBubbleSkinInfo skinInfo) {
        AIOBubbleSkinInfo.BackgroundImageInfo a16 = skinInfo.a();
        if (a16 != null) {
            getMRv().setMinWidth(a16.g());
            getMRv().setMinHeight(a16.f());
            getMRv().setBackground(a16.a());
        }
        AIOBubbleSkinInfo.b c16 = skinInfo.c();
        if (c16 != null) {
            getMRv().setForeground(c16.a());
        }
    }

    private final void i(AIOBubbleSkinInfo skinInfo, Rect outPadding) {
        a aVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = skinInfo.b();
        if (b16 instanceof a) {
            aVar = (a) b16;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            outPadding.set(aVar.c(), aVar.e(), aVar.d(), aVar.b());
        }
        getMRv().setPadding(outPadding.left, outPadding.top, outPadding.right, outPadding.bottom);
        E();
    }

    private final QQMarkdownView k() {
        return (QQMarkdownView) this.constraintRoot.getValue();
    }

    private final int l() {
        float f16;
        if (this.isCenterTemplate) {
            if (this.isWideScreen) {
                f16 = 4.0f;
            } else {
                f16 = 16.0f;
            }
            return com.tencent.mobileqq.aio.utils.e.f194142a.d() - (ViewUtils.dpToPx(f16) * 2);
        }
        if (this.fixedWidth) {
            if (this.isWideScreen) {
                return com.tencent.mobileqq.aio.utils.e.f194142a.d() - ViewUtils.dpToPx(6.0f);
            }
            if (this.needExpandWidth) {
                return ViewUtils.dpToPx(36.0f) + a.C7329a.g(a.C7329a.f192417a, false, 1, null);
            }
            return a.C7329a.g(a.C7329a.f192417a, false, 1, null);
        }
        return -2;
    }

    private final e n() {
        return (e) this.processComponent.getValue();
    }

    private final ConstraintLayout o() {
        return (ConstraintLayout) this.processContainer.getValue();
    }

    private final void q(AIOBubbleSkinInfo skinInfo, boolean useToken, int bubbleType) {
        AIOBubbleSkinInfo.c e16 = skinInfo.e();
        if (e16 != null) {
            e16.l(2);
            e16.k(Float.valueOf(this.mainFontSize));
            if (useToken) {
                e16.j(ResourcesCompat.getColorStateList(this.context.getResources(), R.color.qui_common_text_link, null));
            }
        }
        if (bubbleType == 1) {
            AIOBubbleSkinInfo.BackgroundImageInfo a16 = skinInfo.a();
            if (a16 != null) {
                a16.b(null);
            }
            AIOBubbleSkinInfo.b c16 = skinInfo.c();
            if (c16 != null) {
                c16.b(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(ConstraintLayout constraintLayout) {
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setLayoutParams(new Constraints.LayoutParams(l(), -2));
        constraintLayout.setClickable(true);
        constraintLayout.setLongClickable(true);
    }

    public final void A(@NotNull String processMsg, int state) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) processMsg, state);
            return;
        }
        Intrinsics.checkNotNullParameter(processMsg, "processMsg");
        n().f(new j(new g(state, processMsg), null), m());
        boolean z17 = true;
        if (getMRv().indexOfChild(o()) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            getMRv().addView(o());
        }
        ConstraintLayout c16 = n().c();
        if (o().indexOfChild(c16) == -1) {
            z17 = false;
        }
        if (!z17) {
            o().addView(c16);
        }
    }

    public final void B() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.loadingView == null) {
            ImageView imageView = new ImageView(this.context);
            int dpToPx = ViewUtils.dpToPx(24.0f);
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(dpToPx, dpToPx);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            imageView.setLayoutParams(layoutParams);
            Drawable a16 = d.f352294a.a();
            if (a16 != null) {
                this.loadingDrawable = a16;
                imageView.setBackground(a16);
                a16.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getColor(R.color.qui_common_bubble_guest_text_primary), PorterDuff.Mode.SRC_IN));
            }
            k().addView(imageView);
            this.loadingView = imageView;
        }
        Drawable drawable2 = this.loadingDrawable;
        ApngDrawable apngDrawable = null;
        if (drawable2 != null) {
            drawable = drawable2.getCurrent();
        } else {
            drawable = null;
        }
        if (drawable instanceof ApngDrawable) {
            apngDrawable = (ApngDrawable) drawable;
        }
        if (apngDrawable != null) {
            try {
                apngDrawable.resume();
            } catch (Exception e16) {
                QLog.e("RichBubbleContentViewBinding", 1, "[startLoadingAnim]: " + e16);
            }
        }
    }

    public final void C() {
        Drawable drawable;
        ApngDrawable apngDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.loadingView == null) {
            return;
        }
        Drawable drawable2 = this.loadingDrawable;
        if (drawable2 != null) {
            drawable = drawable2.getCurrent();
        } else {
            drawable = null;
        }
        if (drawable instanceof ApngDrawable) {
            apngDrawable = (ApngDrawable) drawable;
        } else {
            apngDrawable = null;
        }
        if (apngDrawable != null) {
            try {
                apngDrawable.pause();
            } catch (Exception e16) {
                QLog.e("RichBubbleContentViewBinding", 1, "[startLoadingAnim]: " + e16);
            }
        }
        k().removeView(this.loadingView);
        this.loadingView = null;
        this.loadingDrawable = null;
    }

    public final void D() {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (j()) {
            E();
        }
        QQMarkdownView mRv = getMRv();
        int childCount = mRv.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = mRv.getChildAt(i16);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            if (childAt instanceof TextView) {
                ((TextView) childAt).setMaxWidth(m());
            } else {
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                if (layoutParams2 != null) {
                    i3 = layoutParams2.width;
                } else {
                    i3 = 0;
                }
                if (i3 > 0 && (layoutParams = childAt.getLayoutParams()) != null) {
                    layoutParams.width = m();
                }
            }
        }
        getMRv().requestLayout();
        getMRv().invalidate();
    }

    public final void F(@NotNull AIOBubbleSkinInfo skinInfo, boolean useToken, int bubbleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, skinInfo, Boolean.valueOf(useToken), Integer.valueOf(bubbleType));
            return;
        }
        Intrinsics.checkNotNullParameter(skinInfo, "skinInfo");
        this.skinInfo = skinInfo;
        q(skinInfo, useToken, bubbleType);
        h(skinInfo);
        i(skinInfo, this.outPadding);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        int l3 = l();
        ViewGroup.LayoutParams layoutParams = k().getLayoutParams();
        boolean z16 = false;
        if (layoutParams != null && layoutParams.width == l3) {
            z16 = true;
        }
        return !z16;
    }

    public final int m() {
        int i3;
        int i16;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (this.isCenterTemplate) {
            if (this.isWideScreen) {
                f16 = 4.0f;
            } else {
                f16 = 16.0f;
            }
            int d16 = com.tencent.mobileqq.aio.utils.e.f194142a.d() - (ViewUtils.dpToPx(f16) * 2);
            Rect rect = this.outPadding;
            return (d16 - rect.left) - rect.right;
        }
        if (this.isWideScreen) {
            int d17 = com.tencent.mobileqq.aio.utils.e.f194142a.d() - ViewUtils.dpToPx(6.0f);
            Rect rect2 = this.outPadding;
            i3 = d17 - rect2.left;
            i16 = rect2.right;
        } else {
            if (this.needExpandWidth) {
                return ViewUtils.dpToPx(36.0f) + a.C7329a.g(a.C7329a.f192417a, false, 1, null);
            }
            int g16 = a.C7329a.g(a.C7329a.f192417a, false, 1, null);
            Rect rect3 = this.outPadding;
            i3 = g16 - rect3.left;
            i16 = rect3.right;
        }
        return i3 - i16;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public QQMarkdownView getMRv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQMarkdownView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return k();
    }

    public final void r(@NotNull View actionView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) actionView);
            return;
        }
        Intrinsics.checkNotNullParameter(actionView, "actionView");
        if (getMRv().indexOfChild(actionView) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            getMRv().removeView(actionView);
            QQMarkdownView mRv = getMRv();
            Rect rect = this.outPadding;
            mRv.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void s() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        boolean z17 = true;
        if (getMRv().indexOfChild(o()) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            getMRv().removeView(o());
        }
        ConstraintLayout c16 = n().c();
        if (o().indexOfChild(c16) == -1) {
            z17 = false;
        }
        if (z17) {
            o().removeView(c16);
        }
    }

    public final void u(boolean isCenterTemplate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isCenterTemplate);
        } else {
            this.isCenterTemplate = isCenterTemplate;
        }
    }

    public final void v(boolean fixedWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, fixedWidth);
        } else if (this.fixedWidth != fixedWidth) {
            this.fixedWidth = fixedWidth;
            E();
        }
    }

    public final void w(boolean needExpandWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, needExpandWidth);
        } else {
            this.needExpandWidth = needExpandWidth;
        }
    }

    public final void y(boolean isWideScreen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isWideScreen);
        } else {
            this.isWideScreen = isWideScreen;
        }
    }

    public final void z(@NotNull View actionView, int minWidth) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) actionView, minWidth);
            return;
        }
        Intrinsics.checkNotNullParameter(actionView, "actionView");
        if (getMRv().indexOfChild(actionView) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
            if (layoutParams != null) {
                i3 = layoutParams.height;
            } else {
                i3 = -2;
            }
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, i3);
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = 0;
            layoutParams2.topToBottom = getMRv().z0();
            layoutParams2.horizontalBias = 0.0f;
            layoutParams2.matchConstraintMinWidth = minWidth;
            getMRv().addView(actionView, layoutParams2);
        }
        QQMarkdownView mRv = getMRv();
        Rect rect = this.outPadding;
        mRv.setPadding(rect.left, rect.top, rect.right, rect.bottom - a.INSTANCE.a());
    }
}
