package com.tencent.robot.aio.bottombar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.event.ScaleAIOEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.robot.titlebar.intent.BabyQModelSwitchMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.qqnt.doutu.event.DoutuEvent;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.qqnt.kernel.nativeinterface.ModelConfig;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.aio.bottombar.RobotBottomBarUIState;
import com.tencent.robot.aio.bottombar.b;
import com.tencent.robot.aio.bottombar.model.OptionType;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.bottombar.model.RobotBottomItemsDataModel;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k81.RobotAIModelData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007*\u0001G\b\u0007\u0018\u0000 \b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001QB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0)2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\rH\u0002J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020/H\u0002J\u0012\u00104\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000102H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR(\u0010N\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0)0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/robot/aio/bottombar/f;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/robot/aio/bottombar/b;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/a;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "L", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/robot/aio/bottombar/model/a;", "itemData", HippyTKDListViewAdapter.X, "", "y", ReportConstant.COSTREPORT_PREFIX, "P", "B", "Landroid/content/Context;", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "N", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mode", "add", "o", "p", "r", "Lk81/a;", "modelData", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "inputBox", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "modelID", "", "u", "aioContext", "it", DomainData.DOMAIN_NAME, "M", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "groupRobotProfile", "H", "K", "Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "v", "O", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/tencent/aio/api/runtime/a;", "f", "I", "modeStateFlag", "Lcom/tencent/robot/aio/bottombar/model/RobotBottomItemsDataModel;", h.F, "Lcom/tencent/robot/aio/bottombar/model/RobotBottomItemsDataModel;", "robotBottomItemsDataModel", "com/tencent/robot/aio/bottombar/f$b", "i", "Lcom/tencent/robot/aio/bottombar/f$b;", "mAction", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "messageListMap", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends com.tencent.qqnt.aio.baseVM.a<com.tencent.robot.aio.bottombar.b, RobotBottomBarUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int modeStateFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotBottomItemsDataModel robotBottomItemsDataModel = new RobotBottomItemsDataModel();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, List<String>> messageListMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/bottombar/f$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            f.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void A() {
        updateUI(RobotBottomBarUIState.HideRobotBottomBar.f366866d);
    }

    private final void B() {
        a.c cVar;
        View view;
        ArrayList arrayList;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            if (((IAIOImmersiveApi) QRoute.api(IAIOImmersiveApi.class)).enableImmersive(aVar)) {
                k k3 = aVar.e().k(AIOBackgroundMsgIntent.GetBackgroundView.f349766d);
                View view2 = null;
                if (k3 instanceof a.c) {
                    cVar = (a.c) k3;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    view = cVar.a();
                } else {
                    view = null;
                }
                if (view != null) {
                    ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.setAlphaComponent(view.getContext().getColor(R.color.qui_common_bg_nav_bottom_aio), 128));
                    int screenWidth = ImmersiveUtils.getScreenWidth();
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "bgView.context");
                    colorDrawable.setBounds(0, 0, screenWidth, t(context));
                    arrayList = CollectionsKt__CollectionsKt.arrayListOf(view, colorDrawable);
                } else {
                    arrayList = null;
                }
                if (cVar != null) {
                    view2 = cVar.a();
                }
                updateUI(new RobotBottomBarUIState.UpdateBlurState(true, view2, arrayList));
                return;
            }
            updateUI(new RobotBottomBarUIState.UpdateBlurState(false, null, null, 6, null));
        }
    }

    private final void C(com.tencent.aio.api.runtime.a context) {
        L(context);
    }

    private final void D(final RobotAIModelData modelData) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            return;
        }
        Intrinsics.checkNotNull(aVar);
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext!!.aioParam");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(su3.c.b(g16), "", new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.aio.bottombar.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                f.F(f.this, modelData, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof BabyQModelSwitchMsgIntent.OnAIModelSwitch) {
            D(((BabyQModelSwitchMsgIntent.OnAIModelSwitch) intent).getModelData());
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            updateUI(RobotBottomBarUIState.PostThemeChanged.f366867d);
            return;
        }
        if (intent instanceof AIOMsgListEvent.InputToolBarChanged) {
            if (s()) {
                if (((AIOMsgListEvent.InputToolBarChanged) intent).a()) {
                    A();
                    return;
                } else {
                    N();
                    return;
                }
            }
            return;
        }
        if (intent instanceof RobotProfileMsgIntent.OnRobotProfileUpdate) {
            H(((RobotProfileMsgIntent.OnRobotProfileUpdate) intent).getRobotProfile());
            return;
        }
        if (intent instanceof RobotProfileMsgIntent.OnRobotCoreInfoUpdated) {
            G(((RobotProfileMsgIntent.OnRobotCoreInfoUpdated) intent).getRobotCoreInfo());
            return;
        }
        if (intent instanceof InputStyleConfigMsgIntent.OnInputStyleConfigChanged) {
            v(((InputStyleConfigMsgIntent.OnInputStyleConfigChanged) intent).getInputStyleConfig());
            return;
        }
        if (intent instanceof ScaleAIOEvent.SwitchToFullScreen) {
            z();
            return;
        }
        if (y(intent)) {
            if (s()) {
                N();
                P();
            } else {
                A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(f this$0, RobotAIModelData modelData, int i3, String str, GroupRobotProfile groupRobotProfile) {
        Long l3;
        RobotBaseInfo robotBaseInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(modelData, "$modelData");
        InputBox inputBox = null;
        if (groupRobotProfile != null && (robotBaseInfo = groupRobotProfile.robotData) != null) {
            l3 = Long.valueOf(robotBaseInfo.robotUin);
        } else {
            l3 = null;
        }
        QLog.i("RobotBottomBarVM", 1, "updateRobotProfileFromLocal result=" + i3 + " uin=" + l3);
        if (groupRobotProfile != null) {
            inputBox = groupRobotProfile.inputBox;
        }
        if (inputBox == null || groupRobotProfile.robotData == null) {
            QLog.e("RobotBottomBarVM", 1, "updateRobotProfileFromLocal the robot profile data is null!");
        }
        InputBox inputBox2 = groupRobotProfile.inputBox;
        Intrinsics.checkNotNullExpressionValue(inputBox2, "robotProfile.inputBox");
        this$0.J(modelData, inputBox2);
    }

    private final void G(RobotCoreInfo robotCoreInfo) {
        Unit unit;
        if (this.aioContext == null) {
            return;
        }
        InputBox inputBox = robotCoreInfo.inputBox;
        if (inputBox != null) {
            K(inputBox);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("RobotBottomBarVM", 1, "onRobotCoreInfoUpdated the data is null!}");
        }
    }

    private final void H(GroupRobotProfile groupRobotProfile) {
        RobotBaseInfo robotBaseInfo;
        InputBox inputBox;
        if (this.aioContext == null) {
            return;
        }
        if (groupRobotProfile != null) {
            robotBaseInfo = groupRobotProfile.robotData;
        } else {
            robotBaseInfo = null;
        }
        if (robotBaseInfo != null && (inputBox = groupRobotProfile.inputBox) != null) {
            Intrinsics.checkNotNullExpressionValue(inputBox, "groupRobotProfile.inputBox");
            K(inputBox);
        } else {
            QLog.e("RobotBottomBarVM", 1, "onRobotProfileUpdated the profile data is null!}");
        }
    }

    private final void J(RobotAIModelData modelData, InputBox inputBox) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            List<RobotBottomBarItemModel> u16 = u(this.robotBottomItemsDataModel.e());
            QLog.i("RobotBottomBarVM", 1, "processAIModelSwitchBottomItemData lastSelectedModelItems: " + u16 + "}");
            Iterator<T> it = u16.iterator();
            while (it.hasNext()) {
                M(aVar, (RobotBottomBarItemModel) it.next());
            }
            this.robotBottomItemsDataModel.t(inputBox);
            this.robotBottomItemsDataModel.q(modelData);
            List<RobotBottomBarItemModel> u17 = u(modelData.getModelID());
            updateUI(new RobotBottomBarUIState.SubmitBottomItemList(u17));
            ArrayList arrayList = new ArrayList();
            for (Object obj : u17) {
                if (((RobotBottomBarItemModel) obj).getIsChecked()) {
                    arrayList.add(obj);
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                n(aVar, (RobotBottomBarItemModel) it5.next());
            }
        }
    }

    private final void K(InputBox inputBox) {
        boolean z16;
        ArrayList<ModelConfig> arrayList = inputBox.modelList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z17 = !z16;
        QLog.i("RobotBottomBarVM", 1, "onRobotProfileUpdated hasModelList: " + z17 + "}");
        this.robotBottomItemsDataModel.r(z17);
        this.robotBottomItemsDataModel.t(inputBox);
        if (!z17) {
            O();
        }
    }

    private final void L(com.tencent.aio.api.runtime.a context) {
        context.e().f(this, this.mAction);
        for (String str : new ArrayList()) {
            j e16 = context.e();
            b bVar = this.mAction;
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(str, bVar, d16);
        }
    }

    private final void M(com.tencent.aio.api.runtime.a aioContext, RobotBottomBarItemModel it) {
        aioContext.e().h(new AIOMsgSendEvent.RemoveBotExtData(it.getCallBackData()));
    }

    private final void N() {
        updateUI(RobotBottomBarUIState.ShowRobotBottomBar.f366868d);
    }

    private final void O() {
        boolean z16;
        Boolean hasModelList = this.robotBottomItemsDataModel.getHasModelList();
        Boolean isShowMoreInteract = this.robotBottomItemsDataModel.getIsShowMoreInteract();
        if (QLog.isColorLevel()) {
            QLog.i("RobotBottomBarVM", 2, "showLocalMoreInteractButtonIfNeeded hasModelListFlag: " + hasModelList + " hasMoreInteractShowFlag:" + isShowMoreInteract + "}");
        }
        if (this.robotBottomItemsDataModel.getHasModelList() != null && this.robotBottomItemsDataModel.getIsShowMoreInteract() != null) {
            ArrayList arrayList = new ArrayList();
            List<RobotBottomBarItemModel> u16 = u("default_model_id");
            if (Intrinsics.areEqual(this.robotBottomItemsDataModel.getHasModelList(), Boolean.FALSE)) {
                arrayList.addAll(u16);
            }
            List<RobotBottomBarItemModel> list = u16;
            boolean z17 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((RobotBottomBarItemModel) it.next()).getOptionType() == OptionType.OPTION_MORE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            if (Intrinsics.areEqual(this.robotBottomItemsDataModel.getIsShowMoreInteract(), Boolean.TRUE) && !z17) {
                arrayList.add(this.robotBottomItemsDataModel.g());
            }
            updateUI(new RobotBottomBarUIState.SubmitBottomItemList(arrayList));
        }
    }

    private final void P() {
        updateUI(new RobotBottomBarUIState.SubmitSections(new ArrayList()));
    }

    private final void n(com.tencent.aio.api.runtime.a aioContext, RobotBottomBarItemModel it) {
        aioContext.e().h(new AIOMsgSendEvent.AddBotExtData(it.getCallBackData(), false, 2, null));
    }

    private final void o(int mode, boolean add) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotBottomBarVM", 2, "addModeOrClear mode:" + mode + " add:" + mode);
        }
        if (add) {
            p(mode);
        } else {
            r(mode);
        }
    }

    private final void p(int mode) {
        this.modeStateFlag = (mode & 371) | this.modeStateFlag;
    }

    private final void q() {
        this.modeStateFlag = 0;
    }

    private final void r(int mode) {
        this.modeStateFlag = (~(mode & 371)) & this.modeStateFlag;
    }

    private final boolean s() {
        if ((this.modeStateFlag & 371) == 0) {
            return true;
        }
        return false;
    }

    private final int t(Context context) {
        return ImmersiveUtils.getScreenHeight() + ImmersiveUtils.getStatusBarHeight(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r0 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<RobotBottomBarItemModel> u(String modelID) {
        List<OptionType> emptyList;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            if (!com.tencent.mobileqq.aio.a.d(aVar) && !com.tencent.mobileqq.aio.a.c(aVar)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                aVar = null;
            }
            if (aVar != null) {
                emptyList = RobotBottomItemsDataModel.INSTANCE.a();
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return this.robotBottomItemsDataModel.i(modelID, emptyList);
    }

    private final void v(com.tencent.robot.aio.input.styleconfig.a inputStyleConfig) {
        boolean contains = inputStyleConfig.c().contains(1011);
        QLog.i("RobotBottomBarVM", 1, "handleInputStyleConfigChanged isShowMoreInteract: " + contains + "}");
        this.robotBottomItemsDataModel.s(contains);
        O();
    }

    private final void x(RobotBottomBarItemModel itemData) {
        RobotBottomBarItemModel a16;
        String str;
        j e16;
        j e17;
        boolean z16 = !itemData.getIsChecked();
        a16 = itemData.a((r37 & 1) != 0 ? itemData.sectionType : 0, (r37 & 2) != 0 ? itemData.optID : 0, (r37 & 4) != 0 ? itemData.itemID : null, (r37 & 8) != 0 ? itemData.iconUrl : null, (r37 & 16) != 0 ? itemData.iconResId : 0, (r37 & 32) != 0 ? itemData.title : null, (r37 & 64) != 0 ? itemData.enableBlur : false, (r37 & 128) != 0 ? itemData.action : null, (r37 & 256) != 0 ? itemData.scheme : null, (r37 & 512) != 0 ? itemData.data : null, (r37 & 1024) != 0 ? itemData.showStroke : false, (r37 & 2048) != 0 ? itemData.optionType : null, (r37 & 4096) != 0 ? itemData.subItemsList : null, (r37 & 8192) != 0 ? itemData.callBackData : null, (r37 & 16384) != 0 ? itemData.isDefaultChecked : false, (r37 & 32768) != 0 ? itemData.isChecked : z16, (r37 & 65536) != 0 ? itemData.optDesc : null, (r37 & 131072) != 0 ? itemData.promptTemplate : null, (r37 & 262144) != 0 ? itemData.inputPlaceholder : null);
        updateUI(new RobotBottomBarUIState.UpdateBottomItem(a16));
        if (z16) {
            str = itemData.getCallBackData();
        } else {
            str = "";
        }
        if (z16) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e17 = aVar.e()) != null) {
                e17.h(new AIOMsgSendEvent.AddBotExtData(itemData.getCallBackData(), false, 2, null));
            }
        } else {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                e16.h(new AIOMsgSendEvent.RemoveBotExtData(itemData.getCallBackData()));
            }
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        Intrinsics.checkNotNull(aVar3);
        this.robotBottomItemsDataModel.k(aVar3.g().r().c().j(), z16, itemData);
        QLog.i("RobotBottomBarVM", 1, "onItemCheckStateChanged callBackData =  " + str);
    }

    private final boolean y(MsgIntent intent) {
        QLog.i("RobotBottomBarVM", 1, "handleShowStateEvent intent =  " + intent);
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            o(4, ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent).b());
        } else if (intent instanceof AIOMsgListEvent.AddAvatarAreaView) {
            o(32, true);
        } else {
            boolean z16 = false;
            if (intent instanceof AIOMsgListEvent.RemoveAvatarAreaView) {
                o(32, false);
            } else if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
                o(2, ((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
            } else if (intent instanceof DoutuEvent.OnShowOrHideDoutuEvent) {
                o(16, ((DoutuEvent.OnShowOrHideDoutuEvent) intent).a());
            } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
                o(1, ((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
            } else if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
                o(64, ((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a());
            } else if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
                o(128, ((KeyboardMsgIntent.OnKeyboardStateChanged) intent).b());
            } else {
                if (!(intent instanceof PhotoPanelEvent.OnPictureNumberAboveInputChanged)) {
                    return false;
                }
                if (((PhotoPanelEvent.OnPictureNumberAboveInputChanged) intent).a() > 0) {
                    z16 = true;
                }
                o(256, z16);
            }
        }
        return true;
    }

    private final void z() {
        AIOParam g16;
        Bundle l3;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (g16 = aVar.g()) != null && (l3 = g16.l()) != null) {
            l3.putBoolean("key_is_scale_chat", false);
        }
        updateUI(new RobotBottomBarUIState.SubmitBottomItemList(u(this.robotBottomItemsDataModel.e())));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.qqnt.doutu.event.DoutuEvent.OnShowOrHideDoutuEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.AddAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.RemoveAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputToolBarChanged");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.robot.titlebar.intent.BabyQModelSwitchMsgIntent.OnAIModelSwitch");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotProfileUpdate");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotCoreInfoUpdated");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotPersonalInfoUpdated");
        hashSet.add("com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent.OnInputStyleConfigChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.PhotoPanelEvent.OnPictureNumberAboveInputChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.ScaleAIOEvent.SwitchToFullScreen");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        this.aioContext = context;
        C(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        Iterator<Map.Entry<Integer, List<String>>> it = this.messageListMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) it5.next(), this.mAction);
            }
        }
        q();
        A();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.robot.aio.bottombar.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent, b.a.f366882d)) {
            B();
        } else if (intent instanceof b.C9758b) {
            x(((b.C9758b) intent).getItemData());
        }
    }
}
