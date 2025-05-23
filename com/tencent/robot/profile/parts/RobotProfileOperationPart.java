package com.tencent.robot.profile.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.AioConfig;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.addtotroop.RobotAddToTroopFragment;
import com.tencent.robot.profile.data.RobotProfileAvatarHeaderData;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001WB\u001f\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010<\u001a\u00020&\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001dH\u0016J \u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0016JR\u00101\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&H\u0016R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010M\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010>R\u0016\u0010O\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010>R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileOperationPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "Landroid/view/View$OnLayoutChangeListener;", "", "da", "initData", "", "canC2C", "Z9", "T9", "", "tag", "isAbNormalState", "R9", "ca", "uid", "nick", "uin", "S9", "N9", "", "aa", "Landroid/os/Bundle;", "Q9", "ea", "overScrollDrag", "P9", "Landroid/view/View;", "parentView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "getLogTag", "v", NodeProps.ON_CLICK, "", "naviHeight", "left", "right", "onChange", "top", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "d", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "f", "I", "layoutId", tl.h.F, "Landroid/view/View;", "bottomMask", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "operateLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "sendMessageBtn", BdhLogUtil.LogTag.Tag_Conn, "manageBtn", "D", "add2CurrentTroopBtn", "E", "mRootView", UserInfo.SEX_FEMALE, "bottomLayout", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "G", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "smartRefreshLayout", "<init>", "(Lcom/tencent/robot/profile/RobotProfileViewModel;Landroidx/lifecycle/LifecycleOwner;I)V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileOperationPart extends Part implements View.OnClickListener, RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback, View.OnLayoutChangeListener {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<a> I = new ArrayList();
    private static int J = -1;

    /* renamed from: C */
    private QUIButton manageBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private QUIButton add2CurrentTroopBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: F */
    private View bottomLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private SmartRefreshLayout smartRefreshLayout;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final RobotProfileViewModel viewModel;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: from kotlin metadata */
    private final int layoutId;

    /* renamed from: h */
    private View bottomMask;

    /* renamed from: i, reason: from kotlin metadata */
    private ViewGroup operateLayout;

    /* renamed from: m */
    private QUIButton sendMessageBtn;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileOperationPart$a;", "", "", "height", "", "c", "Lcom/tencent/robot/profile/parts/a;", "listener", "", "callbackFirstUseCache", "d", "f", "b", "", "TAG", "Ljava/lang/String;", "heightCache", "I", "", "onOperationBarHeightChangedListeners", "Ljava/util/List;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.parts.RobotProfileOperationPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void c(int height) {
            if (QLog.isColorLevel()) {
                QLog.i("robot.profile.RobotProfileOperationPart", 2, "notifyOperationBarHeightChanged height: " + height + ", heightCache: " + RobotProfileOperationPart.J);
            }
            if (height != RobotProfileOperationPart.J) {
                RobotProfileOperationPart.J = height;
                if (RobotProfileOperationPart.I.isEmpty()) {
                    return;
                }
                Iterator it = RobotProfileOperationPart.I.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onChange(height);
                }
            }
        }

        public static /* synthetic */ void e(Companion companion, a aVar, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            companion.d(aVar, z16);
        }

        public final void b() {
            RobotProfileOperationPart.I.clear();
            RobotProfileOperationPart.J = -1;
        }

        public final void d(@NotNull a listener, boolean callbackFirstUseCache) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!RobotProfileOperationPart.I.contains(listener)) {
                RobotProfileOperationPart.I.add(listener);
                if (callbackFirstUseCache && RobotProfileOperationPart.J != -1) {
                    listener.onChange(RobotProfileOperationPart.J);
                }
            }
        }

        public final void f(@NotNull a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (RobotProfileOperationPart.I.contains(listener)) {
                RobotProfileOperationPart.I.remove(listener);
            }
        }

        Companion() {
        }
    }

    public RobotProfileOperationPart(@NotNull RobotProfileViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner, int i3) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.layoutId = i3;
    }

    private final void N9(final String uin, final String uid, final String nick) {
        IRuntimeService iRuntimeService;
        if (!AppNetConnInfo.isNetSupport()) {
            QQToastUtil.showQQToastInUiThread(1, BaseApplication.getContext().getString(R.string.ci7));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRobotFriend(uin, uid, new IAddFriendCallback() { // from class: com.tencent.robot.profile.parts.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
                    RobotProfileOperationPart.O9(RobotProfileOperationPart.this, uid, nick, uin, i3, str, robotAddFriendResponse);
                }
            });
        }
    }

    public static final void O9(RobotProfileOperationPart this$0, String uid, String nick, String uin, int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(nick, "$nick");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        QLog.i("robot.profile.RobotProfileOperationPart", 1, "addFriend result=" + i3 + " errMsg = " + str);
        if (i3 != 0) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str = BaseApplication.getContext().getString(R.string.ci7);
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (errMsg.isNullOrEmpty\u2026 errMsg\n                }");
            QQToastUtil.showQQToastInUiThread(1, str);
            return;
        }
        QQToastUtil.showQQToastInUiThread(2, BaseApplication.getContext().getString(R.string.yoh));
        this$0.aa(uid, nick, Long.parseLong(uin));
    }

    private final void P9(boolean overScrollDrag) {
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableOverScrollDrag(overScrollDrag);
    }

    private final Bundle Q9() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        AioConfig aioConfig;
        Bundle bundle = new Bundle();
        bundle.putString("key_from", "28");
        String str7 = "";
        bundle.putString(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, "");
        GroupRobotProfile robotProfileRaw = this.viewModel.getRobotProfileRaw();
        String str8 = null;
        if (robotProfileRaw != null) {
            str = robotProfileRaw.dayColor;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "viewModel.robotProfileRaw?.dayColor ?: \"\"");
        }
        bundle.putString("key_day_color", str);
        GroupRobotProfile robotProfileRaw2 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw2 != null) {
            str2 = robotProfileRaw2.nightColor;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "viewModel.robotProfileRaw?.nightColor ?: \"\"");
        }
        bundle.putString("key_night_color", str2);
        GroupRobotProfile robotProfileRaw3 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw3 != null) {
            str3 = robotProfileRaw3.avatarDominantColor;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "viewModel.robotProfileRa\u2026avatarDominantColor ?: \"\"");
        }
        bundle.putString("key_avatar_dominantColor", str3);
        GroupRobotProfile robotProfileRaw4 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw4 != null) {
            str4 = robotProfileRaw4.c2cDayBackground;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "viewModel.robotProfileRaw?.c2cDayBackground ?: \"\"");
        }
        bundle.putString("key_day_bg", str4);
        GroupRobotProfile robotProfileRaw5 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw5 != null) {
            str5 = robotProfileRaw5.c2cNightBackground;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "viewModel.robotProfileRa\u2026.c2cNightBackground ?: \"\"");
        }
        bundle.putString("key_night_bg", str5);
        GroupRobotProfile robotProfileRaw6 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw6 != null) {
            str6 = robotProfileRaw6.dayDynamicPic;
        } else {
            str6 = null;
        }
        if (str6 == null) {
            str6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str6, "viewModel.robotProfileRaw?.dayDynamicPic ?: \"\"");
        }
        bundle.putString("key_day_dynamic_bg", str6);
        GroupRobotProfile robotProfileRaw7 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw7 != null) {
            str8 = robotProfileRaw7.nightDynamicPic;
        }
        if (str8 != null) {
            Intrinsics.checkNotNullExpressionValue(str8, "viewModel.robotProfileRaw?.nightDynamicPic ?: \"\"");
            str7 = str8;
        }
        bundle.putString("key_night_dynamic_bg", str7);
        GroupRobotProfile robotProfileRaw8 = this.viewModel.getRobotProfileRaw();
        boolean z19 = false;
        if (robotProfileRaw8 != null && (aioConfig = robotProfileRaw8.aioConfig) != null) {
            i3 = aioConfig.supportHalfScreenSwitch;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("key_support_half_screen", z16);
        GroupRobotProfile robotProfileRaw9 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw9 != null) {
            z17 = u64.d.d(robotProfileRaw9);
        } else {
            z17 = false;
        }
        bundle.putBoolean("key_support_tts", z17);
        GroupRobotProfile robotProfileRaw10 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw10 != null) {
            z18 = u64.d.b(robotProfileRaw10);
        } else {
            z18 = false;
        }
        bundle.putBoolean("key_support_auto_tts", z18);
        GroupRobotProfile robotProfileRaw11 = this.viewModel.getRobotProfileRaw();
        if (robotProfileRaw11 != null) {
            z19 = u64.d.e(robotProfileRaw11);
        }
        bundle.putBoolean("key_support_wide_sceen", z19);
        bundle.putString("key_robot_aio_scene", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID);
        return bundle;
    }

    public final void R9(String tag, boolean isAbNormalState) {
        QLog.d("robot.profile.RobotProfileOperationPart", 1, "handleAbNormalState: " + isAbNormalState, "tag: " + tag);
        ea();
        da();
    }

    private final void S9(String uid, String nick, String uin) {
        if (this.viewModel.getRelationShip().getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_IS_FRIEND java.lang.String()) {
            aa(uid, nick, Long.parseLong(uin));
        } else {
            N9(uin, uid, nick);
        }
    }

    private final void T9() {
        QUIButton qUIButton = this.add2CurrentTroopBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
            qUIButton = null;
        }
        VideoReport.setElementId(qUIButton, "em_bas_add_to_group_chat");
        QUIButton qUIButton3 = this.add2CurrentTroopBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
            qUIButton3 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(qUIButton3, clickPolicy);
        QUIButton qUIButton4 = this.add2CurrentTroopBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
            qUIButton4 = null;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_FIRST;
        VideoReport.setElementExposePolicy(qUIButton4, exposurePolicy);
        QUIButton qUIButton5 = this.add2CurrentTroopBtn;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
            qUIButton5 = null;
        }
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        VideoReport.setElementEndExposePolicy(qUIButton5, endExposurePolicy);
        QUIButton qUIButton6 = this.sendMessageBtn;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton6 = null;
        }
        VideoReport.setElementId(qUIButton6, "em_bas_send_message_button");
        QUIButton qUIButton7 = this.sendMessageBtn;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton7 = null;
        }
        VideoReport.setElementClickPolicy(qUIButton7, clickPolicy);
        QUIButton qUIButton8 = this.sendMessageBtn;
        if (qUIButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton8 = null;
        }
        VideoReport.setElementExposePolicy(qUIButton8, exposurePolicy);
        QUIButton qUIButton9 = this.sendMessageBtn;
        if (qUIButton9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton9 = null;
        }
        VideoReport.setElementEndExposePolicy(qUIButton9, endExposurePolicy);
        QUIButton qUIButton10 = this.manageBtn;
        if (qUIButton10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
            qUIButton10 = null;
        }
        VideoReport.setElementId(qUIButton10, "em_bas_manage");
        QUIButton qUIButton11 = this.manageBtn;
        if (qUIButton11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
            qUIButton11 = null;
        }
        VideoReport.setElementClickPolicy(qUIButton11, clickPolicy);
        QUIButton qUIButton12 = this.manageBtn;
        if (qUIButton12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
            qUIButton12 = null;
        }
        VideoReport.setElementExposePolicy(qUIButton12, exposurePolicy);
        QUIButton qUIButton13 = this.manageBtn;
        if (qUIButton13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
        } else {
            qUIButton2 = qUIButton13;
        }
        VideoReport.setElementEndExposePolicy(qUIButton2, endExposurePolicy);
    }

    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void Z9(boolean canC2C) {
        QUIButton qUIButton = this.sendMessageBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton = null;
        }
        Boolean valueOf = Boolean.valueOf(canC2C);
        qUIButton.setVisibility(0);
        if (((View) au.a(valueOf, qUIButton)) == null) {
            qUIButton.setVisibility(8);
        }
        if (this.viewModel.getRelationShip().getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_IS_FRIEND java.lang.String()) {
            QUIButton qUIButton3 = this.sendMessageBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            } else {
                qUIButton2 = qUIButton3;
            }
            qUIButton2.setText("\u53d1\u6d88\u606f");
            return;
        }
        QUIButton qUIButton4 = this.sendMessageBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
        } else {
            qUIButton2 = qUIButton4;
        }
        qUIButton2.setText("\u6dfb\u52a0\u4f7f\u7528");
    }

    private final void aa(String uid, String nick, long uin) {
        boolean z16;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            z16 = intent.getBooleanExtra("key_enter_chat_by_finish", false);
        } else {
            z16 = false;
        }
        if (z16) {
            Intent intent2 = new Intent();
            intent2.putExtra("finchat", true);
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(0, intent2);
                activity2.finish();
                return;
            }
            return;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iAIOStarterApi.navigateToAIOActivity(context, 1, uid, nick, 67108864, uin, Q9());
    }

    public static final void ba(RobotProfileOperationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = INSTANCE;
        View view = this$0.bottomLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            view = null;
        }
        companion.c(view.getHeight());
    }

    private final void ca() {
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f170632lk, 0).show();
            return;
        }
        com.tencent.robot.profile.data.g m26 = this.viewModel.m2();
        if (m26 instanceof RobotProfileAvatarHeaderData) {
            RobotAddToTroopFragment.Companion companion = RobotAddToTroopFragment.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RobotProfileAvatarHeaderData robotProfileAvatarHeaderData = (RobotProfileAvatarHeaderData) m26;
            companion.a(context, robotProfileAvatarHeaderData.getRobotUin(), robotProfileAvatarHeaderData.getTroopUin(), this.viewModel.getReportEventData());
        }
    }

    private final void da() {
        View view = this.bottomMask;
        QUIButton qUIButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomMask");
            view = null;
        }
        Context context = view.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        int color = context.getColor(R.color.qui_common_bg_bottom_light);
        gradientDrawable.setColors(new int[]{color, 0});
        View view2 = this.bottomMask;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomMask");
            view2 = null;
        }
        view2.setBackground(gradientDrawable);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        view3.setBackgroundColor(color);
        QUIButton qUIButton2 = this.sendMessageBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
        } else {
            qUIButton = qUIButton2;
        }
        qUIButton.setType(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r0 != false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ea() {
        int i3;
        View view;
        View view2;
        boolean z16;
        boolean z17;
        boolean z18;
        Boolean value = this.viewModel.k2().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        Boolean value2 = this.viewModel.h2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        boolean booleanValue2 = value2.booleanValue();
        boolean z19 = true;
        View view3 = null;
        if (!booleanValue && !booleanValue2) {
            QUIButton qUIButton = this.sendMessageBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
                qUIButton = null;
            }
            if (qUIButton.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QUIButton qUIButton2 = this.add2CurrentTroopBtn;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                    qUIButton2 = null;
                }
                if (qUIButton2.getVisibility() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    QUIButton qUIButton3 = this.manageBtn;
                    if (qUIButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
                        qUIButton3 = null;
                    }
                    if (qUIButton3.getVisibility() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                }
            }
            i3 = 0;
            view = this.bottomLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
                view = null;
            }
            view.setVisibility(i3);
            view2 = this.bottomMask;
            if (view2 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomMask");
            } else {
                view3 = view2;
            }
            view3.setVisibility(i3);
            if (i3 != 0) {
                z19 = false;
            }
            P9(z19);
        }
        i3 = 8;
        view = this.bottomLayout;
        if (view == null) {
        }
        view.setVisibility(i3);
        view2 = this.bottomMask;
        if (view2 != null) {
        }
        view3.setVisibility(i3);
        if (i3 != 0) {
        }
        P9(z19);
    }

    private final void initData() {
        MutableLiveData<Boolean> i26 = this.viewModel.i2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileOperationPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean canC2C) {
                QUIButton qUIButton;
                RobotProfileOperationPart robotProfileOperationPart = RobotProfileOperationPart.this;
                Intrinsics.checkNotNullExpressionValue(canC2C, "canC2C");
                robotProfileOperationPart.Z9(canC2C.booleanValue());
                RobotProfileOperationPart.this.ea();
                qUIButton = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                    qUIButton = null;
                }
                qUIButton.setType(canC2C.booleanValue() ? 1 : 0);
                QLog.d("robot.profile.RobotProfileOperationPart", 1, "canC2C :" + canC2C);
            }
        };
        i26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileOperationPart.U9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> j26 = this.viewModel.j2();
        LifecycleOwner lifecycleOwner2 = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileOperationPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                QUIButton qUIButton;
                QUIButton qUIButton2;
                qUIButton = RobotProfileOperationPart.this.manageBtn;
                QUIButton qUIButton3 = null;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
                    qUIButton = null;
                }
                qUIButton.setVisibility(0);
                if (((View) au.a(bool, qUIButton)) == null) {
                    qUIButton.setVisibility(8);
                }
                qUIButton2 = RobotProfileOperationPart.this.manageBtn;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
                } else {
                    qUIButton3 = qUIButton2;
                }
                qUIButton3.setType(1);
                RobotProfileOperationPart.this.ea();
                QLog.d("robot.profile.RobotProfileOperationPart", 1, "canManage :" + bool);
            }
        };
        j26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.robot.profile.parts.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileOperationPart.V9(Function1.this, obj);
            }
        });
        MutableLiveData<RobotProfileViewModel.AddToTroopBtnState> g26 = this.viewModel.g2();
        LifecycleOwner lifecycleOwner3 = this.viewLifecycleOwner;
        final Function1<RobotProfileViewModel.AddToTroopBtnState, Unit> function13 = new Function1<RobotProfileViewModel.AddToTroopBtnState, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileOperationPart$initData$3

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes25.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f368022a;

                static {
                    int[] iArr = new int[RobotProfileViewModel.AddToTroopBtnState.values().length];
                    try {
                        iArr[RobotProfileViewModel.AddToTroopBtnState.STATE_ADD_TO_CURRENT_TROOP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[RobotProfileViewModel.AddToTroopBtnState.STATE_ADD_TO_TROOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f368022a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotProfileViewModel.AddToTroopBtnState addToTroopBtnState) {
                invoke2(addToTroopBtnState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RobotProfileViewModel.AddToTroopBtnState addToTroopBtnState) {
                QUIButton qUIButton;
                QUIButton qUIButton2;
                QUIButton qUIButton3;
                QUIButton qUIButton4;
                QUIButton qUIButton5;
                QUIButton qUIButton6;
                int i3 = addToTroopBtnState == null ? -1 : a.f368022a[addToTroopBtnState.ordinal()];
                QUIButton qUIButton7 = null;
                if (i3 == 1) {
                    qUIButton = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                    if (qUIButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                        qUIButton = null;
                    }
                    qUIButton.setText("\u6dfb\u52a0\u5230\u672c\u7fa4");
                    qUIButton2 = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                    if (qUIButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                        qUIButton2 = null;
                    }
                    qUIButton2.setVisibility(0);
                } else if (i3 != 2) {
                    qUIButton6 = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                    if (qUIButton6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                        qUIButton6 = null;
                    }
                    qUIButton6.setVisibility(8);
                } else {
                    qUIButton4 = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                    if (qUIButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                        qUIButton4 = null;
                    }
                    qUIButton4.setText("\u6dfb\u52a0\u5230\u7fa4\u804a");
                    qUIButton5 = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                    if (qUIButton5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                        qUIButton5 = null;
                    }
                    qUIButton5.setVisibility(0);
                }
                qUIButton3 = RobotProfileOperationPart.this.add2CurrentTroopBtn;
                if (qUIButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                } else {
                    qUIButton7 = qUIButton3;
                }
                qUIButton7.setTag(addToTroopBtnState);
                RobotProfileOperationPart.this.ea();
                QLog.d("robot.profile.RobotProfileOperationPart", 1, "addToTroopBtnState addToTroopBtnState:" + addToTroopBtnState);
            }
        };
        g26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.robot.profile.parts.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileOperationPart.W9(Function1.this, obj);
            }
        });
        LiveData<Boolean> k26 = this.viewModel.k2();
        LifecycleOwner lifecycleOwner4 = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileOperationPart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isOffline) {
                RobotProfileOperationPart robotProfileOperationPart = RobotProfileOperationPart.this;
                Intrinsics.checkNotNullExpressionValue(isOffline, "isOffline");
                robotProfileOperationPart.R9("offline", isOffline.booleanValue());
            }
        };
        k26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.robot.profile.parts.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileOperationPart.X9(Function1.this, obj);
            }
        });
        LiveData<Boolean> h26 = this.viewModel.h2();
        LifecycleOwner lifecycleOwner5 = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileOperationPart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isBlock) {
                RobotProfileOperationPart robotProfileOperationPart = RobotProfileOperationPart.this;
                Intrinsics.checkNotNullExpressionValue(isBlock, "isBlock");
                robotProfileOperationPart.R9("blackList", isBlock.booleanValue());
            }
        };
        h26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.robot.profile.parts.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileOperationPart.Y9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "robot.profile.RobotProfileOperationPart";
    }

    @Override // com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback
    public void onChange(int naviHeight, int left, int right) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int b16 = com.tencent.qqnt.aio.utils.l.b(32) + naviHeight;
        ViewGroup viewGroup = this.operateLayout;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateLayout");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.bottomMargin;
        } else {
            i3 = 0;
        }
        if (b16 != i3) {
            ViewGroup viewGroup2 = this.operateLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateLayout");
                viewGroup2 = null;
            }
            int b17 = naviHeight + com.tencent.qqnt.aio.utils.l.b(32);
            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams3 = viewGroup2.getLayoutParams();
                int i17 = -2;
                if (layoutParams3 != null) {
                    i16 = layoutParams3.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams4 = viewGroup2.getLayoutParams();
                if (layoutParams4 != null) {
                    i17 = layoutParams4.height;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (b17 != marginLayoutParams2.bottomMargin) {
                marginLayoutParams2.bottomMargin = b17;
                viewGroup2.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!u64.g.f438512a.g()) {
            QUIButton qUIButton = this.sendMessageBtn;
            QUIButton qUIButton2 = null;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
                qUIButton = null;
            }
            if (Intrinsics.areEqual(v3, qUIButton)) {
                com.tencent.robot.profile.data.g m26 = this.viewModel.m2();
                if (m26 instanceof RobotProfileAvatarHeaderData) {
                    RobotProfileAvatarHeaderData robotProfileAvatarHeaderData = (RobotProfileAvatarHeaderData) m26;
                    S9(robotProfileAvatarHeaderData.getRobotUid(), robotProfileAvatarHeaderData.getName(), robotProfileAvatarHeaderData.getRobotUin());
                }
            } else {
                QUIButton qUIButton3 = this.add2CurrentTroopBtn;
                if (qUIButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                    qUIButton3 = null;
                }
                if (Intrinsics.areEqual(v3, qUIButton3)) {
                    QUIButton qUIButton4 = this.add2CurrentTroopBtn;
                    if (qUIButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
                    } else {
                        qUIButton2 = qUIButton4;
                    }
                    if (qUIButton2.getTag() == RobotProfileViewModel.AddToTroopBtnState.STATE_ADD_TO_CURRENT_TROOP) {
                        this.viewModel.W1();
                    } else {
                        ca();
                    }
                } else {
                    QUIButton qUIButton5 = this.manageBtn;
                    if (qUIButton5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
                    } else {
                        qUIButton2 = qUIButton5;
                    }
                    if (Intrinsics.areEqual(v3, qUIButton2)) {
                        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(getContext(), com.tencent.robot.adelie.homepage.utils.n.f366680a.e());
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        View findViewById = parentView.findViewById(this.layoutId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(layoutId)");
        this.mRootView = findViewById;
        View findViewById2 = parentView.findViewById(R.id.f164629ad2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "parentView.findViewById(R.id.bottom_mask)");
        this.bottomMask = findViewById2;
        View findViewById3 = parentView.findViewById(R.id.acy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "parentView.findViewById(R.id.bottom_layout)");
        this.bottomLayout = findViewById3;
        View findViewById4 = parentView.findViewById(R.id.fex);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "parentView.findViewById(R.id.operate_layout)");
        this.operateLayout = (ViewGroup) findViewById4;
        View findViewById5 = parentView.findViewById(R.id.f772543v);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "parentView.findViewById(\u2026obot_profile_button_send)");
        this.sendMessageBtn = (QUIButton) findViewById5;
        View findViewById6 = parentView.findViewById(R.id.f772443u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "parentView.findViewById(\u2026ot_profile_button_manage)");
        this.manageBtn = (QUIButton) findViewById6;
        View findViewById7 = parentView.findViewById(R.id.sdq);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "parentView.findViewById(R.id.add_to_troop_btn)");
        this.add2CurrentTroopBtn = (QUIButton) findViewById7;
        View findViewById8 = parentView.findViewById(R.id.f7732442);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "parentView.findViewById(\u2026rofile_overscroll_layout)");
        this.smartRefreshLayout = (SmartRefreshLayout) findViewById8;
        QUIButton qUIButton = this.sendMessageBtn;
        View view = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendMessageBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        QUIButton qUIButton2 = this.manageBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBtn");
            qUIButton2 = null;
        }
        qUIButton2.setOnClickListener(this);
        QUIButton qUIButton3 = this.add2CurrentTroopBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("add2CurrentTroopBtn");
            qUIButton3 = null;
        }
        qUIButton3.setOnClickListener(this);
        da();
        initData();
        T9();
        View view2 = this.bottomLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            view2 = null;
        }
        view2.post(new Runnable() { // from class: com.tencent.robot.profile.parts.i
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileOperationPart.ba(RobotProfileOperationPart.this);
            }
        });
        View view3 = this.bottomLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
        } else {
            view = view3;
        }
        view.addOnLayoutChangeListener(this);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        Activity activity = getActivity();
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        bVar.k(activity, nf2.b.a(activity2), this);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        INSTANCE.c(bottom - top);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity r16) {
        super.onPartDestroy(r16);
        com.tencent.mobileqq.qui.b.f276860a.n(this);
        View view = this.bottomLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            view = null;
        }
        view.removeOnLayoutChangeListener(this);
        INSTANCE.b();
    }
}
