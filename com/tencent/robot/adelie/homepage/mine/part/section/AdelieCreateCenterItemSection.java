package com.tencent.robot.adelie.homepage.mine.part.section;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotActivityLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobotSummary;
import com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.adelie.homepage.utils.n;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.robot.qqmc.model.RobotHomePageMineTabConfig;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 =2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J&\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0016J(\u0010\u0017\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001fR\u0018\u0010-\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001fR\u0018\u0010/\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001fR\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R&\u0010:\u001a\u0012\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/section/AdelieCreateCenterItemSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "La24/g;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "editView", "data", "", "r", "", "getViewStubLayoutId", "containerView", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "d", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "avatarView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "nameView", "f", "Landroid/view/View;", "realContentView", tl.h.F, "loadingContentView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "arrowView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "friendCountView", BdhLogUtil.LogTag.Tag_Conn, "messageCountView", "D", "activityLabelView", "Landroid/content/Context;", "E", "Landroid/content/Context;", "context", UserInfo.SEX_FEMALE, "I", "", "", "G", "Ljava/util/Map;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "()V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateCenterItemSection extends Section<a24.g> {

    @NotNull
    private static final Lazy<RobotHomePageMineTabConfig> I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView messageCountView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView activityLabelView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private int position;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> reportParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nameView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View realContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingContentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView arrowView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView friendCountView;

    static {
        Lazy<RobotHomePageMineTabConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotHomePageMineTabConfig>() { // from class: com.tencent.robot.adelie.homepage.mine.part.section.AdelieCreateCenterItemSection$Companion$mineTabConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotHomePageMineTabConfig invoke() {
                RobotHomePageMineTabConfig homePageMineTabConfig = RobotQQMC.INSTANCE.getHomePageMineTabConfig();
                QLog.i("AdelieHomeMineGridSection", 1, "mineTabConfig:" + homePageMineTabConfig);
                return homePageMineTabConfig;
            }
        });
        I = lazy;
    }

    private final void r(View rootView, View editView, a24.g data) {
        LinkedHashMap linkedHashMap;
        long j3;
        if (rootView != null && editView != null) {
            if (data != null) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("agent_name", data.getRobotInfo().name);
                linkedHashMap.put("agent_id", data.getRobotInfo().uid);
                linkedHashMap.put("serial_number", String.valueOf(data.getIndex() + 1));
                linkedHashMap.put("agent_uin", String.valueOf(data.getRobotInfo().robotUin));
                RobotSummary robotSummary = data.getRobotInfo().summary;
                long j16 = 0;
                if (robotSummary != null) {
                    j3 = robotSummary.friendNum;
                } else {
                    j3 = 0;
                }
                linkedHashMap.put("friends_number", String.valueOf(j3));
                RobotSummary robotSummary2 = data.getRobotInfo().summary;
                if (robotSummary2 != null) {
                    j16 = robotSummary2.msgNum;
                }
                linkedHashMap.put("message_number", String.valueOf(j16));
            } else {
                linkedHashMap = null;
            }
            this.reportParams = linkedHashMap;
            VideoReport.setElementId(rootView, "em_bas_agent_card");
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(rootView, clickPolicy);
            VideoReport.setElementParams(rootView, this.reportParams);
            VideoReport.setElementId(editView, WinkDaTongReportConstant.ElementId.EM_BAS_EDIT);
            VideoReport.setElementClickPolicy(editView, clickPolicy);
            VideoReport.setElementParams(editView, this.reportParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(a24.g gVar, AdelieCreateCenterItemSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("AdelieHomeMineGridSection", 1, "ItemContainer onClick " + gVar);
        }
        if (!FastClickUtils.isFastDoubleClick("AdelieHomeMineGridSection")) {
            ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackground(String.valueOf(gVar.getRobotInfo().robotUin), true);
            VideoReport.reportEvent("clck", this$0.mRootView, this$0.reportParams);
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
            } else {
                n nVar = n.f366680a;
                String str = gVar.getRobotInfo().uid;
                Intrinsics.checkNotNullExpressionValue(str, "data.robotInfo.uid");
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this$0.context, nVar.a("adelie_manager_page", str));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AdelieCreateCenterItemSection this$0, RobotActivityLabel activityLabelInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityLabelInfo, "$activityLabelInfo");
        if (!u64.g.f438512a.g()) {
            QLog.i("AdelieHomeMineGridSection", 1, "activity label click");
            Context context = this$0.context;
            if (context != null) {
                n nVar = n.f366680a;
                String str = activityLabelInfo.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(str, "activityLabelInfo.jumpUrl");
                nVar.f(context, str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        if (attached) {
            VideoReport.reportEvent("imp", this.mRootView, this.reportParams);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        this.mRootView.setOnClickListener(null);
        this.avatarView = null;
        this.nameView = null;
        this.loadingContentView = null;
        this.realContentView = null;
        this.context = null;
        Map<String, String> map = this.reportParams;
        Intrinsics.checkNotNull(map);
        map.clear();
        this.reportParams = null;
        this.mSectionHost = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.avatarView = (RoundImageView) containerView.findViewById(R.id.dvo);
        this.nameView = (TextView) containerView.findViewById(R.id.tv_name);
        this.loadingContentView = containerView.findViewById(R.id.efa);
        this.realContentView = containerView.findViewById(R.id.f70623ly);
        this.arrowView = (ImageView) containerView.findViewById(R.id.f164472yw);
        this.friendCountView = (TextView) containerView.findViewById(R.id.vet);
        this.messageCountView = (TextView) containerView.findViewById(R.id.z5d);
        this.activityLabelView = (TextView) containerView.findViewById(R.id.sak);
        this.context = containerView.getContext();
        Drawable o16 = ie0.a.f().o(this.context, R.drawable.qui_chevron_right, R.color.qui_common_icon_secondary, 1000);
        ImageView imageView = this.arrowView;
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
        FontSettingManager.resetViewSize2Normal(this.context, containerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final a24.g data, int position, @NotNull List<? extends Object> payload) {
        TextView textView;
        Object firstOrNull;
        boolean z16;
        Unit unit;
        Drawable drawable;
        Resources resources;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (data == null) {
            return;
        }
        this.position = position;
        r(this.mRootView, this.arrowView, data);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.mine.part.section.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieCreateCenterItemSection.t(a24.g.this, this, view);
            }
        });
        Unit unit2 = null;
        if (URLUtil.isNetworkUrl(data.getRobotInfo().avatar)) {
            Context context = this.context;
            if (context != null && (resources = context.getResources()) != null) {
                drawable = resources.getDrawable(R.drawable.j4_);
            } else {
                drawable = null;
            }
            RoundImageView roundImageView = this.avatarView;
            if (roundImageView != null) {
                CommonExKt.h(roundImageView, data.getRobotInfo().avatar, drawable, drawable, null, 8, null);
            }
        }
        TextView textView2 = this.nameView;
        if (textView2 != null) {
            textView2.setText(data.getRobotInfo().name);
        }
        TextView textView3 = this.friendCountView;
        if (textView3 != null) {
            AdelieHomeMineGridPart.Companion companion = AdelieHomeMineGridPart.INSTANCE;
            textView3.setText("\u597d\u53cb " + ((Object) companion.a(data.getRobotInfo().summary.friendNum).getFirst()) + ((Object) companion.a(data.getRobotInfo().summary.friendNum).getSecond()));
        }
        TextView textView4 = this.messageCountView;
        if (textView4 != null) {
            AdelieHomeMineGridPart.Companion companion2 = AdelieHomeMineGridPart.INSTANCE;
            textView4.setText("\u6d88\u606f " + ((Object) companion2.a(data.getRobotInfo().summary.msgNum).getFirst()) + ((Object) companion2.a(data.getRobotInfo().summary.msgNum).getSecond()));
        }
        ArrayList<RobotActivityLabel> arrayList = data.getRobotInfo().robotActivityLabelList;
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            final RobotActivityLabel robotActivityLabel = (RobotActivityLabel) firstOrNull;
            if (robotActivityLabel != null) {
                String str = robotActivityLabel.name;
                boolean z17 = true;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String str2 = robotActivityLabel.jumpUrl;
                    if (str2 != null && str2.length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        TextView textView5 = this.activityLabelView;
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                            textView5.setText("#" + robotActivityLabel.name);
                            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.mine.part.section.f
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    AdelieCreateCenterItemSection.u(AdelieCreateCenterItemSection.this, robotActivityLabel, view);
                                }
                            });
                            unit = Unit.INSTANCE;
                            unit2 = unit;
                        }
                    }
                }
                TextView textView6 = this.activityLabelView;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
                unit = Unit.INSTANCE;
                unit2 = unit;
            }
        }
        if (unit2 == null && (textView = this.activityLabelView) != null) {
            textView.setVisibility(8);
        }
    }
}
