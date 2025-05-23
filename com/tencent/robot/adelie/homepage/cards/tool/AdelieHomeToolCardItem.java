package com.tencent.robot.adelie.homepage.cards.tool;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.cards.tool.AdelieHomeToolCardItem;
import com.tencent.robot.adelie.homepage.category.section.AdelieHomeCardHotView;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.util.URLUtil;
import ie0.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u64.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/adelie/homepage/cards/tool/AdelieHomeToolCardItem;", "Landroid/widget/RelativeLayout;", "", "e", "c", "", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "data", "setData", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Ljava/lang/String;", "getSubjectName", "()Ljava/lang/String;", "subjectName", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "ivAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvName", h.F, "tvDesc", "i", "Landroid/widget/RelativeLayout;", "hotView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "realContent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", ISchemeApi.KEY_PAGE_DATA, "D", "hotNumberTextView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "hotImageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeToolCardItem extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RobotCoreInfo pageData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView hotNumberTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView hotImageView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subjectName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView ivAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout hotView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View realContent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeToolCardItem(@NotNull Context context) {
        this(context, null, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieHomeToolCardItem this$0, Context context, View view) {
        RobotCoreInfo robotCoreInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!g.f438512a.g() && (robotCoreInfo = this$0.pageData) != null) {
            AIOUtil.e(AIOUtil.f366629a, context, robotCoreInfo, null, null, 12, null);
            VideoReport.reportEvent("clck", this$0, this$0.d());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void c() {
        VideoReport.setElementId(this, "em_bas_bot_entry");
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
    }

    private final Map<String, String> d() {
        Map<String, String> mapOf;
        Map<String, String> emptyMap;
        RobotCoreInfo robotCoreInfo = this.pageData;
        if (robotCoreInfo == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_theme_card"), TuplesKt.to("agent_uin", String.valueOf(robotCoreInfo.robotUin)), TuplesKt.to(IPublicAccountConfigAttr.CARD_STYLE, "3"), TuplesKt.to("subject_name", this.subjectName));
        return mapOf;
    }

    private final void e() {
        Drawable o16 = a.f().o(getContext(), R.drawable.qui_operation, R.color.qui_common_icon_tertiary, 1000);
        ImageView imageView = this.hotImageView;
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            VideoReport.reportEvent("imp", this, d());
        }
    }

    public final void setData(@NotNull RobotCoreInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.pageData = data;
        View view = this.realContent;
        if (view != null) {
            view.setVisibility(0);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        String str = data.robotAvatar;
        if (!RobotQQMC.INSTANCE.enableQQPicLoader()) {
            if (URLUtil.isValidUrl(str)) {
                drawable = URLDrawable.getDrawable(data.robotAvatar, obtain);
            }
            RoundImageView roundImageView = this.ivAvatar;
            if (roundImageView != null) {
                roundImageView.setImageDrawable(drawable);
            }
        } else {
            RoundImageView roundImageView2 = this.ivAvatar;
            if (roundImageView2 != null && URLUtil.isValidUrl(str)) {
                Option option = Option.obtain().setTargetView(roundImageView2).setUrl(str).setLoadingDrawable(drawable).setFailDrawable(drawable);
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, null);
            }
        }
        TextView textView = this.tvName;
        if (textView != null) {
            textView.setText(data.name);
        }
        TextView textView2 = this.tvName;
        if (textView2 != null) {
            textView2.setTypeface(Typeface.defaultFromStyle(1));
        }
        TextView textView3 = this.tvDesc;
        if (textView3 != null) {
            textView3.setText(data.desc);
        }
        if (data.hotNumber <= 0) {
            RelativeLayout relativeLayout = this.hotView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        } else {
            RelativeLayout relativeLayout2 = this.hotView;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            TextView textView4 = this.hotNumberTextView;
            if (textView4 != null) {
                textView4.setText(AdelieHomeCardHotView.INSTANCE.a(data.hotNumber));
            }
        }
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeToolCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeToolCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieHomeToolCardItem(Context context, AttributeSet attributeSet, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeToolCardItem(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull String subjectName) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.subjectName = subjectName;
        View.inflate(context, R.layout.dso, this);
        this.ivAvatar = (RoundImageView) findViewById(R.id.dvo);
        this.tvName = (TextView) findViewById(R.id.tv_name);
        this.tvDesc = (TextView) findViewById(R.id.f167042k73);
        this.realContent = findViewById(R.id.f70623ly);
        this.hotView = (RelativeLayout) findViewById(R.id.xbw);
        this.hotNumberTextView = (TextView) findViewById(R.id.xbc);
        this.hotImageView = (ImageView) findViewById(R.id.xbb);
        e();
        View view = this.realContent;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: q14.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdelieHomeToolCardItem.b(AdelieHomeToolCardItem.this, context, view2);
                }
            });
        }
    }
}
