package com.tencent.android.androidbypass.enhance.inlinekeyboard.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.enhance.c;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001R\u0018\u0000 0*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u0004:\u0001\\B\u0019\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u00a2\u0006\u0004\bZ\u0010[J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J?\u0010\u0018\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00104\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00106R\u0016\u0010O\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR \u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006]"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "DispatchContext", "Payload", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Landroid/graphics/drawable/Drawable;", "icon", "", "N0", "O0", "K0", "J0", "D0", "E0", "C0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "ctx", "payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "button", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "listener", "setBtnInfo", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;)V", "", NodeProps.ENABLED, "setEnabled", "selected", "setSelected", "M0", "L0", "I0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mIconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTitleTv", "", "f", "Ljava/lang/String;", "mTitle", "", h.F, "I", "btnType", "i", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "mInlineKeyboardBtnClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", "G0", "()Ljava/lang/Object;", "setMPayload", "(Ljava/lang/Object;)V", "mPayload", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "F0", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "setMBtnModel", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;)V", "mBtnModel", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "D", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "H0", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "setMStyleSheet$bypass_release", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;)V", "mStyleSheet", "E", "mDispatchContext", UserInfo.SEX_FEMALE, "Z", "mLoading", "G", "mIsIconAlignRightTop", "com/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView$b", "H", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView$b;", "mViewCreator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class InlineBtnView<DispatchContext, Payload> extends ConstraintLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a mBtnModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public InlineBtnStyleSheet mStyleSheet;

    /* renamed from: E, reason: from kotlin metadata */
    private DispatchContext mDispatchContext;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mLoading;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsIconAlignRightTop;

    /* renamed from: H, reason: from kotlin metadata */
    private final b mViewCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView mTitleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int btnType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> mInlineKeyboardBtnClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Payload mPayload;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView$a;", "", "", "BUTTON_HEIGHT_DP", "I", "BUTTON_HEIGHT_DP_SMALL", "BUTTON_TEXT_BOTTOM_PX", "", "BUTTON_TEXT_SIZE_SP", UserInfo.SEX_FEMALE, "BUTTON_TEXT_SIZE_SP_SMALL", "CHAIN_PACK_STYLE_ICON_RIGHT_MARGIN_DP", "RIGHT_TOP_STYLE_ICON_RIGHT_MARGIN_DP", "RIGHT_TOP_STYLE_ICON_SIZE_DP", "RIGHT_TOP_STYLE_ICON_TOP_MARGIN_DP", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0006R\u001f\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"com/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView$b", "", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "b", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "d", "Landroid/widget/ImageView;", "a", "c", "Lcom/tencent/android/androidbypass/enhance/c;", "kotlin.jvm.PlatformType", "Lcom/tencent/android/androidbypass/enhance/c;", "e", "()Lcom/tencent/android/androidbypass/enhance/c;", "dipTool", "", "I", "titleId", "iconId", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final c dipTool;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int titleId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int iconId;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f72273e;

        b(Context context) {
            this.f72273e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) InlineBtnView.this, (Object) context);
                return;
            }
            this.dipTool = c.a(context);
            this.titleId = ViewCompat.generateViewId();
            this.iconId = ViewCompat.generateViewId();
        }

        @NotNull
        public final ImageView a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setId(this.iconId);
            imageView.setLayoutParams(c());
            return imageView;
        }

        @NotNull
        public final TextView b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setId(this.titleId);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(2, 14.0f);
            textView.setTypeface(null, 1);
            textView.setLayoutParams(d());
            textView.setGravity(17);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 2);
            return textView;
        }

        @NotNull
        public final ConstraintLayout.LayoutParams c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ConstraintLayout.LayoutParams) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.dipTool.d(18), this.dipTool.d(18));
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.endToStart = this.titleId;
            layoutParams.startToStart = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.dipTool.d(4);
            layoutParams.horizontalChainStyle = 2;
            layoutParams.validate();
            return layoutParams;
        }

        @NotNull
        public final ConstraintLayout.LayoutParams d() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ConstraintLayout.LayoutParams) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            int i16 = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.endToEnd = 0;
            if (InlineBtnView.this.mIconView != null) {
                i3 = this.iconId;
            } else {
                i3 = -1;
            }
            layoutParams.startToEnd = i3;
            if (InlineBtnView.this.mIconView != null) {
                i16 = -1;
            }
            layoutParams.startToStart = i16;
            layoutParams.constrainedWidth = true;
            layoutParams.validate();
            return layoutParams;
        }

        public final c e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (c) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.dipTool;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.btnType = -1;
        b bVar = new b(context);
        this.mViewCreator = bVar;
        TextView b16 = bVar.b(context);
        this.mTitleTv = b16;
        addView(b16);
        setFocusable(true);
        setClickable(true);
        setOnClickListener(this);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, c.a(context).d(36)));
    }

    private final Drawable C0() {
        Drawable b16;
        boolean z16;
        if (this.mLoading) {
            InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
            if (inlineBtnStyleSheet == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
            }
            b16 = inlineBtnStyleSheet.g();
            if (b16 == null) {
                InlineBtnStyleSheet inlineBtnStyleSheet2 = this.mStyleSheet;
                if (inlineBtnStyleSheet2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
                }
                b16 = inlineBtnStyleSheet2.b();
            }
        } else {
            InlineBtnStyleSheet inlineBtnStyleSheet3 = this.mStyleSheet;
            if (inlineBtnStyleSheet3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
            }
            b16 = inlineBtnStyleSheet3.b();
        }
        if (b16 == null) {
            InlineBtnStyleSheet inlineBtnStyleSheet4 = this.mStyleSheet;
            if (inlineBtnStyleSheet4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
            }
            Integer valueOf = Integer.valueOf(inlineBtnStyleSheet4.h());
            if (valueOf.intValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf == null) {
                return null;
            }
            return ResourcesCompat.getDrawable(getResources(), valueOf.intValue(), null);
        }
        return b16;
    }

    private final Drawable D0() {
        boolean z16;
        InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
        if (inlineBtnStyleSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
        }
        Drawable f16 = inlineBtnStyleSheet.f();
        if (f16 == null) {
            InlineBtnStyleSheet inlineBtnStyleSheet2 = this.mStyleSheet;
            if (inlineBtnStyleSheet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
            }
            Integer valueOf = Integer.valueOf(inlineBtnStyleSheet2.getIconRes());
            if (valueOf.intValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf == null) {
                return null;
            }
            return ResourcesCompat.getDrawable(getResources(), valueOf.intValue(), null);
        }
        return f16;
    }

    private final Drawable E0() {
        boolean z16;
        InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
        if (inlineBtnStyleSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
        }
        Drawable c16 = inlineBtnStyleSheet.c();
        if (c16 == null) {
            InlineBtnStyleSheet inlineBtnStyleSheet2 = this.mStyleSheet;
            if (inlineBtnStyleSheet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
            }
            Integer valueOf = Integer.valueOf(inlineBtnStyleSheet2.a());
            if (valueOf.intValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf == null) {
                return null;
            }
            return ResourcesCompat.getDrawable(getResources(), valueOf.intValue(), null);
        }
        return c16;
    }

    private final void J0() {
        this.mIsIconAlignRightTop = true;
        final int d16 = this.mViewCreator.e().d(16);
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(d16, d16);
            layoutParams.topToTop = 0;
            layoutParams.rightToRight = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mViewCreator.e().c(4.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.mViewCreator.e().c(3.8333333f);
            Unit unit = Unit.INSTANCE;
            layoutParams.validate();
            imageView.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mTitleTv.getLayoutParams();
        if (!(layoutParams2 instanceof ConstraintLayout.LayoutParams)) {
            layoutParams2 = null;
        }
        final ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        if (layoutParams3 != null) {
            layoutParams3.startToEnd = -1;
            layoutParams3.startToStart = 0;
            if (this.mIconView != null) {
                post(new Runnable(this, d16) { // from class: com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView$overrideDefaultLayoutParamToRightTop$$inlined$apply$lambda$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f72268e;
                    final /* synthetic */ InlineBtnView this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.this$0 = this;
                        this.f72268e = d16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ConstraintLayout.LayoutParams.this, this, Integer.valueOf(d16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        InlineBtnView.b bVar;
                        TextView textView;
                        TextView textView2;
                        int i3;
                        TextView textView3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        int i16 = this.f72268e;
                        bVar = this.this$0.mViewCreator;
                        int c16 = i16 + bVar.e().c(3.8333333f);
                        int width = this.this$0.getWidth();
                        textView = this.this$0.mTitleTv;
                        if ((width - textView.getWidth()) / 2 < c16) {
                            ConstraintLayout.LayoutParams layoutParams4 = ConstraintLayout.LayoutParams.this;
                            ImageView imageView2 = this.this$0.mIconView;
                            if (imageView2 != null) {
                                i3 = imageView2.getId();
                            } else {
                                i3 = -1;
                            }
                            layoutParams4.endToStart = i3;
                            ConstraintLayout.LayoutParams layoutParams5 = ConstraintLayout.LayoutParams.this;
                            layoutParams5.endToEnd = -1;
                            layoutParams5.horizontalBias = 1.0f;
                            textView3 = this.this$0.mTitleTv;
                            textView3.setLayoutParams(ConstraintLayout.LayoutParams.this);
                            return;
                        }
                        ConstraintLayout.LayoutParams layoutParams6 = ConstraintLayout.LayoutParams.this;
                        layoutParams6.endToStart = -1;
                        layoutParams6.endToEnd = 0;
                        layoutParams6.horizontalBias = 0.5f;
                        textView2 = this.this$0.mTitleTv;
                        textView2.setLayoutParams(ConstraintLayout.LayoutParams.this);
                    }
                });
            } else {
                layoutParams3.endToStart = -1;
                layoutParams3.endToEnd = 0;
                layoutParams3.horizontalBias = 0.5f;
            }
            this.mTitleTv.setLayoutParams(layoutParams3);
        }
    }

    private final void K0() {
        if (this.mIsIconAlignRightTop) {
            this.mIsIconAlignRightTop = false;
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setLayoutParams(this.mViewCreator.c());
            }
            this.mTitleTv.setLayoutParams(this.mViewCreator.d());
            return;
        }
        if (this.mIconView != null) {
            ViewGroup.LayoutParams layoutParams = this.mTitleTv.getLayoutParams();
            if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
                layoutParams = null;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                ImageView imageView2 = this.mIconView;
                Intrinsics.checkNotNull(imageView2);
                layoutParams2.startToEnd = imageView2.getId();
                layoutParams2.startToStart = -1;
                layoutParams2.endToStart = -1;
                layoutParams2.endToEnd = 0;
                layoutParams2.horizontalBias = 0.5f;
                this.mTitleTv.setLayoutParams(layoutParams2);
            }
        }
    }

    private final void N0(Drawable icon) {
        if (icon != null) {
            if (this.mIconView == null) {
                b bVar = this.mViewCreator;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ImageView a16 = bVar.a(context);
                this.mIconView = a16;
                addView(a16);
            }
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mIconView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(icon);
                return;
            }
            return;
        }
        ImageView imageView3 = this.mIconView;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    private final void O0() {
        InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
        if (inlineBtnStyleSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
        }
        if (inlineBtnStyleSheet.getType() == InlineBtnStyleSheet.BtnType.ENTER) {
            J0();
        } else {
            K0();
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = this.mBtnModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        return aVar;
    }

    @Nullable
    public final Payload G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Payload) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mPayload;
    }

    @NotNull
    public final InlineBtnStyleSheet H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InlineBtnStyleSheet) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
        if (inlineBtnStyleSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
        }
        return inlineBtnStyleSheet;
    }

    public final void I0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.mLoading = false;
        this.mTitleTv.setVisibility(0);
        N0(D0());
        setBackground(C0());
        O0();
    }

    public final void L0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mLoading = true;
        this.mTitleTv.setVisibility(8);
        N0(E0());
        setBackground(C0());
        K0();
    }

    public final void M0() {
        boolean z16;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        InlineBtnStyleSheet inlineBtnStyleSheet = this.mStyleSheet;
        if (inlineBtnStyleSheet != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        TextView textView = this.mTitleTv;
        if (inlineBtnStyleSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStyleSheet");
        }
        textView.setTextColor(inlineBtnStyleSheet.e());
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = this.mBtnModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        if (aVar.f().d() > 0) {
            TextView textView2 = this.mTitleTv;
            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar2 = this.mBtnModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
            }
            textView2.setTextSize(2, aVar2.f().d());
        }
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar3 = this.mBtnModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        if (aVar3.d()) {
            L0();
        } else {
            I0();
        }
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar4 = this.mBtnModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        setEnabled(aVar4.b());
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar5 = this.mBtnModel;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        setSelected(aVar5.g());
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar6 = this.mBtnModel;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        if (aVar6.f().a() > 0 && (layoutParams = getLayoutParams()) != null) {
            c a16 = c.a(getContext());
            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar7 = this.mBtnModel;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
            }
            layoutParams.height = a16.d(aVar7.f().a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> bVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            DispatchContext dispatchcontext = this.mDispatchContext;
            if (dispatchcontext != null && (bVar = this.mInlineKeyboardBtnClickListener) != null) {
                Intrinsics.checkNotNull(dispatchcontext);
                com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = this.mBtnModel;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
                }
                bVar.a(dispatchcontext, this, aVar, this.mPayload);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setBtnInfo(@Nullable DispatchContext ctx, @Nullable Payload payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a button, @Nullable com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, ctx, payload, button, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(button, "button");
        this.mDispatchContext = ctx;
        this.mInlineKeyboardBtnClickListener = listener;
        this.mPayload = payload;
        this.mBtnModel = button;
        this.btnType = button.a().c();
        M0();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, enabled);
            return;
        }
        super.setEnabled(enabled);
        this.mTitleTv.setEnabled(enabled);
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setEnabled(enabled);
        }
    }

    public final void setMBtnModel(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mBtnModel = aVar;
        }
    }

    public final void setMPayload(@Nullable Payload payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload);
        } else {
            this.mPayload = payload;
        }
    }

    public final void setMStyleSheet$bypass_release(@NotNull InlineBtnStyleSheet inlineBtnStyleSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) inlineBtnStyleSheet);
        } else {
            Intrinsics.checkNotNullParameter(inlineBtnStyleSheet, "<set-?>");
            this.mStyleSheet = inlineBtnStyleSheet;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r2 != false) goto L23;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSelected(boolean selected) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, selected);
            return;
        }
        super.setSelected(selected);
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = this.mBtnModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        String e16 = aVar.f().e();
        if (selected) {
            if (e16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar2 = this.mBtnModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnModel");
        }
        e16 = aVar2.f().b();
        this.mTitle = e16;
        this.mTitleTv.setText(e16);
        this.mTitleTv.setSelected(selected);
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setSelected(selected);
        }
    }
}
