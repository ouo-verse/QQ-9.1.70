package com.tencent.robot.adelie.homepage.cards.role;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.cards.role.AdelieHomeRoleCardItem;
import com.tencent.robot.adelie.homepage.category.section.AdelieHomeCardHotView;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.qqmc.model.RobotHomeSuperResolutionUinBlacklist;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/adelie/homepage/cards/role/AdelieHomeRoleCardItem;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotInfo", "", "d", "c", "", "", "", "e", "data", "subjectName", "setData", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "ivAvatar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvName", "f", "tvDesc", "Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeCardHotView;", h.F, "Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeCardHotView;", "hotView", "i", "Landroid/view/View;", "loadingContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "realContent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", ISchemeApi.KEY_PAGE_DATA, "D", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeRoleCardItem extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RobotCoreInfo pageData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String subjectName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView ivAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieHomeCardHotView hotView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View realContent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeRoleCardItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieHomeRoleCardItem this$0, View view) {
        RobotCoreInfo robotCoreInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!g.f438512a.g() && (robotCoreInfo = this$0.pageData) != null) {
            this$0.d(robotCoreInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void c() {
        VideoReport.setElementId(this, "em_bas_bot_entry");
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
    }

    private final void d(RobotCoreInfo robotInfo) {
        AIOUtil aIOUtil = AIOUtil.f366629a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AIOUtil.e(aIOUtil, context, robotInfo, null, null, 12, null);
        VideoReport.reportEvent("clck", this, e());
    }

    private final Map<String, Object> e() {
        Map<String, Object> mapOf;
        Map<String, Object> emptyMap;
        RobotCoreInfo robotCoreInfo = this.pageData;
        if (robotCoreInfo == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_theme_card"), TuplesKt.to("agent_uin", String.valueOf(robotCoreInfo.robotUin)), TuplesKt.to("subject_name", this.subjectName), TuplesKt.to(IPublicAccountConfigAttr.CARD_STYLE, 2));
        return mapOf;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            VideoReport.reportEvent("imp", this, e());
        }
    }

    public final void setData(@NotNull RobotCoreInfo data, @NotNull String subjectName) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.subjectName = subjectName;
        this.pageData = data;
        View view = this.loadingContent;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.realContent;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (RobotHomeSuperResolutionUinBlacklist.INSTANCE.b(String.valueOf(data.robotUin))) {
            RoundImageView roundImageView = this.ivAvatar;
            if (roundImageView != null) {
                CommonExKt.h(roundImageView, data.robotAvatar, null, null, null, 14, null);
            }
        } else {
            RoundImageView roundImageView2 = this.ivAvatar;
            if (roundImageView2 != null) {
                CommonExKt.j(roundImageView2, com.tencent.robot.adelie.homepage.g.f366352a.b(), data.robotAvatar, null, null, null, null, 60, null);
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
        AdelieHomeCardHotView adelieHomeCardHotView = this.hotView;
        if (adelieHomeCardHotView != null) {
            adelieHomeCardHotView.setHotNumber(data.hotNumber);
        }
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeRoleCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieHomeRoleCardItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHomeRoleCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subjectName = "";
        View.inflate(context, R.layout.ds7, this);
        this.ivAvatar = (RoundImageView) findViewById(R.id.dvo);
        this.tvName = (TextView) findViewById(R.id.tv_name);
        this.tvDesc = (TextView) findViewById(R.id.f167042k73);
        this.loadingContent = findViewById(R.id.efa);
        this.realContent = findViewById(R.id.f70623ly);
        this.hotView = (AdelieHomeCardHotView) findViewById(R.id.xbw);
        View view = this.realContent;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: p14.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdelieHomeRoleCardItem.b(AdelieHomeRoleCardItem.this, view2);
                }
            });
        }
    }
}
