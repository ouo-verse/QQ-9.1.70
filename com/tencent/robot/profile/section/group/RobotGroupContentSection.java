package com.tencent.robot.profile.section.group;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.g;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotGroupLabel;
import com.tencent.robot.profile.data.RobotProfileGroupCardData;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000bj\b\u0012\u0004\u0012\u00020\u000f`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J*\u0010\u0019\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/profile/section/group/RobotGroupContentSection;", "Ln44/f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGroupInfo;", "data", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "uinRole", "", "u", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGroupLabel;", "Lkotlin/collections/ArrayList;", "labels", "LNearbyGroup/GroupLabel;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/robot/profile/data/g;", "position", "", "", "payload", "v", "e", "Landroid/view/View;", "groupInfoCard", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "groupHead", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "troopName", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "i", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "barLabel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvDesc", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinButton", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotGroupContentSection extends f {

    @NotNull
    private static final a D = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    private QUIButton joinButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View groupInfoCard;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView groupHead;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView troopName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopLabelLayout barLabel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/profile/section/group/RobotGroupContentSection$a;", "", "", "DT_PARAM_GROUP_ID", "Ljava/lang/String;", "", "GROUP_ROLE_ADMIN", "I", "GROUP_ROLE_DEFAULT", "GROUP_ROLE_MEMBER", "GROUP_ROLE_NON_MEMBER", "GROUP_ROLE_OWNER", "RET_JOIN_SUCCESS", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final ArrayList<GroupLabel> A(ArrayList<RobotGroupLabel> labels) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(labels, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RobotGroupLabel robotGroupLabel : labels) {
            Color color = new Color();
            int i3 = robotGroupLabel.edgingColor.colorR;
            color.R = i3;
            color.G = i3;
            color.B = i3;
            Color color2 = new Color();
            int i16 = robotGroupLabel.textColor.colorR;
            color2.R = i16;
            color2.G = i16;
            color2.B = i16;
            arrayList.add(new GroupLabel(robotGroupLabel.labelName, color2, robotGroupLabel.labelType, color));
        }
        return new ArrayList<>(arrayList);
    }

    private final void t(RobotGroupInfo data) {
        View view = this.groupInfoCard;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
            view = null;
        }
        VideoReport.setElementId(view, "em_bas_group_entry");
        View view3 = this.groupInfoCard;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
            view3 = null;
        }
        VideoReport.setElementParam(view3, FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, String.valueOf(data.groupId));
        View view4 = this.groupInfoCard;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_ALL);
        View view5 = this.groupInfoCard;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
            view5 = null;
        }
        VideoReport.setElementExposePolicy(view5, ExposurePolicy.REPORT_FIRST);
        View view6 = this.groupInfoCard;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
        } else {
            view2 = view6;
        }
        VideoReport.setElementEndExposePolicy(view2, EndExposurePolicy.REPORT_NONE);
    }

    private final boolean u(int uinRole) {
        if (uinRole == 1 || uinRole == 2 || uinRole == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QUIButton this_apply, final RobotGroupInfo groupInfo, final RobotGroupContentSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(groupInfo, "$groupInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = new g();
        gVar.f296167a = String.valueOf(groupInfo.groupId);
        gVar.f296169c = ErrorCode.ERROR_CMD_INVALID;
        gVar.f296171e = groupInfo.authSig;
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).joinTroop(this_apply.getContext(), gVar, new com.tencent.mobileqq.troop.f() { // from class: com.tencent.robot.profile.section.group.c
            @Override // com.tencent.mobileqq.troop.f
            public final void a(String str, int i3) {
                RobotGroupContentSection.x(RobotGroupInfo.this, this$0, str, i3);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final RobotGroupInfo groupInfo, final RobotGroupContentSection this$0, String troopUin, int i3) {
        Intrinsics.checkNotNullParameter(groupInfo, "$groupInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QLog.i("RobotGroupContentSection", 1, "joinTroop: " + troopUin + ", " + i3);
        if (i3 == 1) {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.section.group.RobotGroupContentSection$onBindData$1$1$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QUIButton qUIButton;
                    QUIButton qUIButton2;
                    RobotGroupInfo.this.uinRole = 4;
                    qUIButton = this$0.joinButton;
                    QUIButton qUIButton3 = null;
                    if (qUIButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                        qUIButton = null;
                    }
                    qUIButton.setEnabled(false);
                    qUIButton2 = this$0.joinButton;
                    if (qUIButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                    } else {
                        qUIButton3 = qUIButton2;
                    }
                    qUIButton3.setText(R.string.fvk);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(RobotGroupInfo groupInfo, RobotGroupContentSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(groupInfo, "$groupInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle d16 = aq.d(String.valueOf(groupInfo.groupId), groupInfo.authSig, ErrorCode.ERROR_CMD_INVALID);
        d16.putInt("exposureSource", 3);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(MobileQQ.sMobileQQ, d16, 2);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
        View view2 = this$0.groupInfoCard;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
            view2 = null;
        }
        j44.c cVar = (j44.c) g16.getIocInterface(j44.c.class, robotProfileUtils.j(view2), null);
        if (cVar != null) {
            cVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z() {
        QUIButton qUIButton = this.joinButton;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinButton");
            qUIButton = null;
        }
        VideoReport.setElementId(qUIButton, "em_join_group_btn");
        QUIButton qUIButton3 = this.joinButton;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinButton");
            qUIButton3 = null;
        }
        VideoReport.setElementClickPolicy(qUIButton3, ClickPolicy.REPORT_ALL);
        QUIButton qUIButton4 = this.joinButton;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinButton");
            qUIButton4 = null;
        }
        VideoReport.setElementExposePolicy(qUIButton4, ExposurePolicy.REPORT_NONE);
        QUIButton qUIButton5 = this.joinButton;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinButton");
        } else {
            qUIButton2 = qUIButton5;
        }
        VideoReport.setElementEndExposePolicy(qUIButton2, EndExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.vtv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.group_info_card)");
        this.groupInfoCard = findViewById;
        View findViewById2 = containerView.findViewById(R.id.f165397vt4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.groupHead)");
        this.groupHead = (QQProAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.meg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_troop_name)");
        this.troopName = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.l_w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.bar_label)");
        this.barLabel = (TroopLabelLayout) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f167042k73);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.lax);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.btn_join_troop)");
        this.joinButton = (QUIButton) findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.robot.profile.data.g data, int position, @Nullable List<Object> payload) {
        Object firstOrNull;
        View view;
        if (data instanceof RobotProfileGroupCardData) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((RobotProfileGroupCardData) data).h());
            final RobotGroupInfo robotGroupInfo = (RobotGroupInfo) firstOrNull;
            if (robotGroupInfo != null) {
                QLog.i("RobotGroupContentSection", 1, "onBindData" + robotGroupInfo);
                t(robotGroupInfo);
                QQProAvatarView qQProAvatarView = this.groupHead;
                if (qQProAvatarView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupHead");
                    qQProAvatarView = null;
                }
                qQProAvatarView.x(4, String.valueOf(robotGroupInfo.groupId), new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).f(BaseImageUtil.getDefaultTroopFaceDrawableNew()).a());
                TextView textView = this.troopName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopName");
                    textView = null;
                }
                TextView textView2 = this.troopName;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopName");
                    textView2 = null;
                }
                textView.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_primary));
                TextView textView3 = this.troopName;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopName");
                    textView3 = null;
                }
                textView3.setText(robotGroupInfo.groupName);
                TextView textView4 = this.troopName;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopName");
                    textView4 = null;
                }
                textView4.setContentDescription(robotGroupInfo.groupName);
                TroopLabelLayout troopLabelLayout = this.barLabel;
                if (troopLabelLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barLabel");
                    troopLabelLayout = null;
                }
                troopLabelLayout.setVisibility(0);
                TroopLabelLayout troopLabelLayout2 = this.barLabel;
                if (troopLabelLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barLabel");
                    troopLabelLayout2 = null;
                }
                troopLabelLayout2.setLabelType(1);
                TroopLabelLayout troopLabelLayout3 = this.barLabel;
                if (troopLabelLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barLabel");
                    troopLabelLayout3 = null;
                }
                troopLabelLayout3.setAutoCreateDistanceTextView(true);
                TroopLabelLayout troopLabelLayout4 = this.barLabel;
                if (troopLabelLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barLabel");
                    troopLabelLayout4 = null;
                }
                troopLabelLayout4.setIsInCompleteDrawOutSide(true);
                TroopLabelLayout troopLabelLayout5 = this.barLabel;
                if (troopLabelLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barLabel");
                    troopLabelLayout5 = null;
                }
                ArrayList<RobotGroupLabel> arrayList = robotGroupInfo.robotGroupLabel;
                Intrinsics.checkNotNullExpressionValue(arrayList, "groupInfo.robotGroupLabel");
                troopLabelLayout5.g(A(arrayList));
                TextView textView5 = this.tvDesc;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
                    textView5 = null;
                }
                TextView textView6 = this.tvDesc;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
                    textView6 = null;
                }
                textView5.setTextColor(textView6.getContext().getResources().getColor(R.color.qui_common_text_secondary));
                TextView textView7 = this.tvDesc;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
                    textView7 = null;
                }
                textView7.setText(new QQText(robotGroupInfo.groupFingerMemo, 11, 16));
                QUIButton qUIButton = this.joinButton;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                    qUIButton = null;
                }
                qUIButton.setType(1);
                QUIButton qUIButton2 = this.joinButton;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                    qUIButton2 = null;
                }
                qUIButton2.setPadding(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(4.5f), ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(4.55f));
                if (u(robotGroupInfo.uinRole)) {
                    QUIButton qUIButton3 = this.joinButton;
                    if (qUIButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                        qUIButton3 = null;
                    }
                    qUIButton3.setEnabled(false);
                    QUIButton qUIButton4 = this.joinButton;
                    if (qUIButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                        qUIButton4 = null;
                    }
                    qUIButton4.setText(R.string.fvk);
                } else {
                    final QUIButton qUIButton5 = this.joinButton;
                    if (qUIButton5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
                        qUIButton5 = null;
                    }
                    qUIButton5.setEnabled(true);
                    qUIButton5.setText(R.string.fvi);
                    qUIButton5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.section.group.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            RobotGroupContentSection.w(QUIButton.this, robotGroupInfo, this, view2);
                        }
                    });
                    z();
                }
                View view2 = this.groupInfoCard;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupInfoCard");
                    view = null;
                } else {
                    view = view2;
                }
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.section.group.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        RobotGroupContentSection.y(RobotGroupInfo.this, this, view3);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("RobotGroupContentSection", 1, "onBindData data is not RobotGroupContentSection");
    }
}
