package com.qzone.reborn.feedpro.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.feedpro.widget.header.QzoneTitleGradualTransWrapperButton;
import com.qzone.reborn.feedpro.widget.header.QzoneTitleIconWithTextButton;
import com.qzone.reborn.feedpro.widget.header.ae;
import com.qzone.reborn.feedpro.widget.header.publishbox.QzonePublishBoxGradualTransWrapper;
import com.qzone.reborn.feedpro.widget.l;
import com.qzone.widget.RedDotImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001cB'\b\u0007\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]\u0012\b\b\u0002\u0010_\u001a\u00020\u0003\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\tJ\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0004J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u0007H\u0017J\b\u0010\u001a\u001a\u00020\u0007H\u0017J\b\u0010\u001b\u001a\u00020\u0007H\u0017J\b\u0010\u001c\u001a\u00020\u0007H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"J\n\u0010&\u001a\u0004\u0018\u00010%H\u0014J\b\u0010'\u001a\u00020\u0003H\u0015J\b\u0010(\u001a\u00020\u0003H\u0015J\b\u0010)\u001a\u00020\u0003H\u0015J\b\u0010*\u001a\u00020\u0003H\u0015J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u00100\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0002J&\u00105\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\b\b\u0002\u00104\u001a\u00020\tH\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0003H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000bH\u0002J\u001a\u0010:\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000b2\b\b\u0001\u00109\u001a\u00020\u0003H\u0002J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010<\u001a\u00020\u0007H\u0002R\u0014\u0010=\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010!R\u0014\u0010?\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010!R\u0014\u0010@\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010A\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010!R\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010CR\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010CR\u0016\u0010H\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Tj\b\u0012\u0004\u0012\u00020\u000b`U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010Y\u00a8\u0006d"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/QzoneFriendFeedProTitle;", "Landroid/widget/FrameLayout;", "Lcom/qzone/reborn/feedpro/widget/l$e;", "", "r", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "", "needGradualTrans", "Landroid/view/View;", "t", "Luh/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "needRedDot", "b", "isCoverFold", "j", "startButton", "endButton", "Lcom/qzone/reborn/feedpro/widget/header/QzoneTitleGradualTransWrapperButton;", tl.h.F, com.tencent.luggage.wxa.c8.c.f123400v, "setTitleAlpha", "w", HippyTKDListViewAdapter.X, "u", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/view/ViewGroup;", "B", "Landroid/os/Bundle;", "bundle", "I", "Landroid/content/Intent;", "intent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", DomainData.DOMAIN_NAME, "f", "v", "Lcom/qzone/reborn/feedpro/widget/header/QzoneTitleIconWithTextButton;", "i", "Lcom/qzone/widget/RedDotImageView;", "k", "childView", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "isPublishBtn", "d", "curAlpha", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "color", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "PUBLISH_BUTTON_SIZE", "e", "BUTTON_SIZE", "BUTTON_PADDING", "mCoverStatus", "mCurAlpha", "Landroid/view/View;", "mViewBg", "mTitleHost", "D", "Landroid/widget/FrameLayout;", "mBackBtnContainer", "E", "Lcom/qzone/reborn/feedpro/widget/header/QzoneTitleGradualTransWrapperButton;", "mGradualBackBtn", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mRightBtnContainer", "Lue/a;", "G", "Lue/a;", "mPublishBox", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mRightButtonAddList", "Z", "mLastAddIsPublishBtn", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFriendFeedProTitle extends FrameLayout implements l.e {

    /* renamed from: C, reason: from kotlin metadata */
    private View mTitleHost;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout mBackBtnContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneTitleGradualTransWrapperButton mGradualBackBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mRightBtnContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private ue.a mPublishBox;

    /* renamed from: H, reason: from kotlin metadata */
    private ArrayList<View> mRightButtonAddList;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mLastAddIsPublishBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int PUBLISH_BUTTON_SIZE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int BUTTON_SIZE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int BUTTON_PADDING;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCoverStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurAlpha;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mViewBg;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C() {
        if (getContext() instanceof Activity) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                QUIImmersiveHelper.s((Activity) context, true, false);
            } catch (Throwable th5) {
                RFWLog.fatal("QzoneFriendFeedProTitle", RFWLog.USR, th5);
            }
        }
    }

    private final QzoneTitleGradualTransWrapperButton f() {
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_chevron_left, R.drawable.qui_chevron_left);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFriendFeedProTitle.g(QzoneFriendFeedProTitle.this, view);
            }
        };
        String a16 = com.qzone.util.l.a(R.string.f2201668d);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_voice_back)");
        uh.d dVar = new uh.d(tokenRes, null, onClickListener, null, a16, false, 42, null);
        return h(j(dVar, false, false), j(dVar, false, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QzoneFriendFeedProTitle this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final QzoneTitleIconWithTextButton i(uh.d item, boolean isCoverFold) {
        int q16;
        int o16;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QzoneTitleIconWithTextButton qzoneTitleIconWithTextButton = new QzoneTitleIconWithTextButton(context);
        qzoneTitleIconWithTextButton.setData(item);
        qzoneTitleIconWithTextButton.setLayoutParams(new LinearLayout.LayoutParams(-2, this.BUTTON_SIZE));
        if (isCoverFold) {
            q16 = p();
        } else {
            q16 = q();
        }
        y(qzoneTitleIconWithTextButton, q16);
        if (isCoverFold) {
            o16 = n();
        } else {
            o16 = o();
        }
        qzoneTitleIconWithTextButton.setBackgroundResource(o16);
        aa.g(aa.f54263a, qzoneTitleIconWithTextButton, qzoneTitleIconWithTextButton.getContext(), 0, false, 6, null);
        return qzoneTitleIconWithTextButton;
    }

    private final RedDotImageView k(uh.d item, boolean isCoverFold) {
        int q16;
        int o16;
        RedDotImageView redDotImageView = new RedDotImageView(getContext());
        redDotImageView.h(item.getShowRedDot());
        redDotImageView.setImageResource(item.getDrawableId());
        redDotImageView.setOnClickListener(item.getOnClickListener());
        redDotImageView.setOnLongClickListener(item.getOnLongClickListener());
        redDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i3 = this.BUTTON_SIZE;
        redDotImageView.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        int i16 = this.BUTTON_PADDING;
        redDotImageView.setPadding(i16, i16, i16, i16);
        AccessibilityUtil.p(redDotImageView, item.getContentDescription());
        if (isCoverFold) {
            q16 = p();
        } else {
            q16 = q();
        }
        y(redDotImageView, q16);
        if (isCoverFold) {
            o16 = n();
        } else {
            o16 = o();
        }
        redDotImageView.setBackgroundResource(o16);
        aa aaVar = aa.f54263a;
        aa.c(aaVar, redDotImageView, 0.0f, 1, null);
        aa.g(aaVar, redDotImageView, redDotImageView.getContext(), 0, false, 6, null);
        return redDotImageView;
    }

    private final void v() {
        this.mViewBg.setAlpha(0.0f);
        try {
            Drawable s16 = s();
            if (s16 == null) {
                s16 = new ColorDrawable(getContext().getColor(R.color.qui_common_fill_light_primary));
            }
            this.mViewBg.setBackground(s16);
        } catch (Throwable th5) {
            RFWLog.fatal("QzoneFriendFeedProTitle", RFWLog.USR, th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(View view, int color) {
        if (view instanceof ImageView) {
            com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) view, color);
        } else if (view instanceof com.qzone.reborn.feedx.part.userhome.a) {
            ((com.qzone.reborn.feedx.part.userhome.a) view).a(color);
        } else if (view instanceof QzoneTitleIconWithTextButton) {
            ((QzoneTitleIconWithTextButton) view).o0(color);
        }
    }

    private final void z(View view) {
        if (view.getAlpha() <= 0.01f) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    public final void A(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ue.a aVar = this.mPublishBox;
        if (aVar != null) {
            aVar.G(intent);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.l.e
    public ViewGroup B() {
        return (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.cnf, (ViewGroup) this, false);
    }

    @Override // com.qzone.reborn.feedpro.widget.l.e
    public void I(Bundle bundle) {
        Intent B = ak.B(getContext());
        if (bundle != null) {
            B.putExtras(bundle);
        }
        getContext().startActivity(B);
    }

    public final View b(uh.d item, boolean needRedDot, boolean needGradualTrans) {
        View j3;
        Intrinsics.checkNotNullParameter(item, "item");
        if (needGradualTrans) {
            j3 = h(j(item, needRedDot, false), j(item, needRedDot, true));
        } else {
            j3 = j(item, needRedDot, false);
        }
        View view = j3;
        int b16 = ef.d.b(12);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i3 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
        }
        marginLayoutParams.leftMargin = b16;
        view.setLayoutParams(marginLayoutParams);
        return e(this, view, null, false, 6, null);
    }

    protected final QzoneTitleGradualTransWrapperButton h(View startButton, View endButton) {
        Intrinsics.checkNotNullParameter(startButton, "startButton");
        Intrinsics.checkNotNullParameter(endButton, "endButton");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QzoneTitleGradualTransWrapperButton qzoneTitleGradualTransWrapperButton = new QzoneTitleGradualTransWrapperButton(context, null, 0, 6, null);
        qzoneTitleGradualTransWrapperButton.setData(new ae(startButton, endButton));
        qzoneTitleGradualTransWrapperButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return qzoneTitleGradualTransWrapperButton;
    }

    protected View j(uh.d item, boolean needRedDot, boolean isCoverFold) {
        Intrinsics.checkNotNullParameter(item, "item");
        if ((item.getButtonText().length() == 0) && needRedDot) {
            return k(item, isCoverFold);
        }
        return i(item, isCoverFold);
    }

    protected int n() {
        return R.drawable.f14692u;
    }

    protected int o() {
        return R.drawable.f14682t;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ue.a aVar = this.mPublishBox;
        if (aVar != null) {
            aVar.d0();
        }
    }

    protected int p() {
        return getContext().getColor(R.color.qui_common_icon_primary);
    }

    protected int q() {
        return getContext().getColor(R.color.qui_common_icon_allwhite_primary);
    }

    public int r() {
        return R.layout.cin;
    }

    protected Drawable s() {
        return ContextCompat.getDrawable(getContext(), R.drawable.f14672s);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l3) {
        super.setOnClickListener(l3);
        this.mViewBg.setOnClickListener(l3);
    }

    public final void setTitleAlpha(int alpha) {
        QLog.d("QzoneFriendFeedProTitle", 1, "setTitleAlpha: " + alpha);
        if (alpha < 0 || alpha > 255 || this.mCurAlpha == alpha) {
            return;
        }
        this.mCurAlpha = alpha;
        this.mViewBg.setAlpha(alpha / 255.0f);
        l(this.mCurAlpha);
        m(this.mCurAlpha);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.qzone.reborn.feedpro.widget.QzoneFriendFeedProTitle, android.view.View, com.qzone.reborn.feedpro.widget.l$e] */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.tencent.biz.richframework.widget.BaseWidgetView, com.qzone.reborn.feedpro.widget.header.publishbox.QzonePublishBoxGradualTransWrapper, android.view.View] */
    public final View t(boolean needGradualTrans) {
        View d16;
        l lVar;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.PUBLISH_BUTTON_SIZE);
        if (needGradualTrans) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ?? qzonePublishBoxGradualTransWrapper = new QzonePublishBoxGradualTransWrapper(context, null, 0, 6, null);
            l lVar2 = new l(this, "", q());
            lVar2.x(o());
            aa aaVar = aa.f54263a;
            aa.g(aaVar, qzonePublishBoxGradualTransWrapper, qzonePublishBoxGradualTransWrapper.getContext(), 0, false, 6, null);
            l lVar3 = new l(this, "", p());
            lVar3.x(n());
            aa.g(aaVar, qzonePublishBoxGradualTransWrapper, qzonePublishBoxGradualTransWrapper.getContext(), 0, false, 6, null);
            qzonePublishBoxGradualTransWrapper.setData(new ue.b(lVar2, lVar3));
            qzonePublishBoxGradualTransWrapper.setLayoutParams(layoutParams);
            d16 = d(qzonePublishBoxGradualTransWrapper, layoutParams, true);
            lVar = qzonePublishBoxGradualTransWrapper;
        } else {
            l lVar4 = new l(this, "", q());
            lVar4.x(o());
            aa.g(aa.f54263a, this, getContext(), 0, false, 6, null);
            ViewGroup n3 = lVar4.n();
            Intrinsics.checkNotNullExpressionValue(n3, "publishWrapper.container");
            d16 = d(n3, layoutParams, true);
            lVar = lVar4;
        }
        this.mPublishBox = lVar;
        return d16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void w() {
        this.mCoverStatus = 1;
        C();
    }

    public void x() {
        this.mCoverStatus = 0;
        C();
    }

    public /* synthetic */ QzoneFriendFeedProTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final View d(View childView, LinearLayout.LayoutParams layoutParams, boolean isPublishBtn) {
        if (layoutParams == null) {
            int i3 = this.BUTTON_SIZE;
            layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.setMargins(ef.d.b(12), 0, 0, 0);
        }
        if (this.mLastAddIsPublishBtn && !isPublishBtn) {
            layoutParams.leftMargin = Math.min(ef.d.b(4), layoutParams.leftMargin);
        }
        this.mLastAddIsPublishBtn = isPublishBtn;
        this.mRightBtnContainer.addView(childView, layoutParams);
        this.mRightButtonAddList.add(childView);
        return childView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PUBLISH_BUTTON_SIZE = ef.d.b(48);
        this.BUTTON_SIZE = ef.d.b(32);
        this.BUTTON_PADDING = ef.d.b(6);
        this.mRightButtonAddList = new ArrayList<>();
        LayoutInflater.from(getContext()).inflate(r(), this);
        View findViewById = findViewById(R.id.mj7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qz_feed_pro_title_bg)");
        this.mViewBg = findViewById;
        View findViewById2 = findViewById(R.id.mj8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qz_feed_pro_title_host)");
        this.mTitleHost = findViewById2;
        View findViewById3 = findViewById(R.id.mj6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qz_fee\u2026pro_title_back_container)");
        this.mBackBtnContainer = (FrameLayout) findViewById3;
        View findViewById4 = findViewById(R.id.mj9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qz_fee\u2026itle_right_btn_container)");
        this.mRightBtnContainer = (LinearLayout) findViewById4;
        this.mTitleHost.setPadding(ef.d.b(16), ImmersiveUtils.getStatusBarHeight(getContext()), ef.d.b(16), 0);
        QzoneTitleGradualTransWrapperButton f16 = f();
        this.mGradualBackBtn = f16;
        this.mBackBtnContainer.addView(f16);
        v();
    }

    private final void l(int curAlpha) {
        float f16 = curAlpha / 255.0f;
        this.mGradualBackBtn.setProgress(f16);
        int childCount = this.mRightBtnContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View view = this.mRightBtnContainer.getChildAt(i3);
            if (view instanceof QzoneTitleGradualTransWrapperButton) {
                ((QzoneTitleGradualTransWrapperButton) view).setProgress(f16);
            } else if (view instanceof QzonePublishBoxGradualTransWrapper) {
                ((QzonePublishBoxGradualTransWrapper) view).setProgress(f16);
            } else {
                view.setAlpha(1 - f16);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                z(view);
            }
        }
    }

    private final void m(int alpha) {
        if (alpha >= 125) {
            w();
        } else {
            x();
        }
    }

    static /* synthetic */ View e(QzoneFriendFeedProTitle qzoneFriendFeedProTitle, View view, LinearLayout.LayoutParams layoutParams, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
            }
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return qzoneFriendFeedProTitle.d(view, layoutParams, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRightButtonInternal");
    }

    public static /* synthetic */ View c(QzoneFriendFeedProTitle qzoneFriendFeedProTitle, uh.d dVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            if ((i3 & 4) != 0) {
                z17 = false;
            }
            return qzoneFriendFeedProTitle.b(dVar, z16, z17);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRightButton");
    }

    public void u() {
    }
}
