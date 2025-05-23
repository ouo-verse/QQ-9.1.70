package com.tencent.robot.aio.panel.menu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.robot.action.api.IRobotActionApi;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.aio.panel.menu.RobotMenuUIState;
import com.tencent.robot.aio.panel.menu.c;
import com.tencent.robot.aio.panel.menu.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n14.AIOSchemeActionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001E\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001PB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010%\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010&\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u0016\u0010)\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140'H\u0002J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020*2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0018\u00101\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010FR&\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020E0H0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010L\u00a8\u0006Q"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/RobotMenuPanelVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/robot/aio/panel/menu/d;", "Lcom/tencent/robot/aio/panel/menu/RobotMenuUIState;", "Lcom/tencent/robot/aio/panel/menu/c$b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "E", HippyTKDListViewAdapter.X, "Lcom/tencent/robot/aio/input/RobotMenuMsgIntent$GetBotMenuResponseMsgIntent;", "u", "Landroid/widget/ImageView;", "avatar", "Lcom/tencent/robot/aio/panel/menu/c;", "adapter", "y", "v", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "data", "B", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/Job;", "loadingTimeoutJob", "featureInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommandCbRequest;", ReportConstant.COSTREPORT_PREFIX, "t", BdhLogUtil.LogTag.Tag_Conn, "", "url", "D", UserInfo.SEX_FEMALE, "", "list", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/api/runtime/a;", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "w", "d", "Lcom/tencent/robot/aio/panel/menu/c;", "mRobotAdapter", "e", "Ljava/lang/String;", "mRobotUid", "Lcom/tencent/qqnt/kernel/api/ac;", "f", "Lcom/tencent/qqnt/kernel/api/ac;", "mRobotService", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "mRobotInfo", "", "i", "J", "mRobotUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/input/RobotMenuMsgIntent$GetBotMenuResponseMsgIntent;", "mResponseEvent", "com/tencent/robot/aio/panel/menu/RobotMenuPanelVM$b", "Lcom/tencent/robot/aio/panel/menu/RobotMenuPanelVM$b;", "mAction", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetBotsMenuCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetBotsMenuCallback;", "mOnBatchGetBotMenu", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMenuPanelVM extends com.tencent.aio.base.mvvm.b<d, RobotMenuUIState> implements c.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final IBatchGetBotsMenuCallback mOnBatchGetBotMenu;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c mRobotAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mRobotUid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ac mRobotService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonBotInfo mRobotInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mRobotUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotMenuMsgIntent.GetBotMenuResponseMsgIntent mResponseEvent;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/aio/panel/menu/RobotMenuPanelVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotMenuPanelVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return true;
        }
    }

    public RobotMenuPanelVM() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right1IvClickEvent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.GetBotMenuResponseMsgIntent.class)), bVar)});
        this.mMessageList = listOf;
        this.mOnBatchGetBotMenu = new IBatchGetBotsMenuCallback() { // from class: com.tencent.robot.aio.panel.menu.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback
            public final void onResult(int i3, String str, BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
                RobotMenuPanelVM.z(RobotMenuPanelVM.this, i3, str, batchGetBotsMenuResponse);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(List<CommonBotFeatureInfo> list) {
        c cVar = this.mRobotAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAdapter");
            cVar = null;
        }
        cVar.t0(list);
        updateUI(new RobotMenuUIState.UpdateMenu(!list.isEmpty(), false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(int position, CommonBotFeatureInfo data) {
        c cVar = this.mRobotAdapter;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAdapter");
            cVar = null;
        }
        if (cVar.getLoadingPosition() != -1) {
            QLog.d("RobotMenuPanelVM", 4, "[triggerCommandCallback]: button is loading!");
            return;
        }
        c cVar3 = this.mRobotAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAdapter");
        } else {
            cVar2 = cVar3;
        }
        cVar2.s0(position);
        Job t16 = t();
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context == null) {
            return;
        }
        q(context, t16, data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(CommonBotFeatureInfo data) {
        boolean z16;
        String schemeUrl = data.schemaUrl;
        if (schemeUrl != null && schemeUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("RobotMenuPanelVM", 4, "scheme is empty, cmdName=" + data.name);
            schemeUrl = new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("aio").path("/inlinecmd").appendQueryParameter("command", data.name).appendQueryParameter(BaseConstants.BROADCAST_USERSYNC_ENTER, "true").build().toString();
        }
        IRobotActionApi iRobotActionApi = (IRobotActionApi) QRoute.api(IRobotActionApi.class);
        AIOSchemeActionContext aIOSchemeActionContext = new AIOSchemeActionContext((com.tencent.aio.api.runtime.a) getMContext(), null, null, null, 8, null);
        Intrinsics.checkNotNullExpressionValue(schemeUrl, "schemeUrl");
        iRobotActionApi.doSchemeAction(aIOSchemeActionContext, schemeUrl);
    }

    private final void D(Context context, String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotMenuPanelVM", 1, "[triggerOpenH5]: url is null or empty");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent event) {
        if (event instanceof AIOTitleEvent.Right1IvClickEvent) {
            x();
        } else if (event instanceof RobotMenuMsgIntent.GetBotMenuResponseMsgIntent) {
            u((RobotMenuMsgIntent.GetBotMenuResponseMsgIntent) event);
        } else {
            QLog.i("RobotMenuPanelVM", 1, "handleAction default");
        }
    }

    private final void F(Context context, String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotMenuPanelVM", 1, "[triggerOpenH5]: url is null or empty");
            return;
        }
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (!iMiniAppService.isMiniAppUrl(url)) {
            return;
        }
        EntryModel entryModel = new EntryModel();
        entryModel.type = 0;
        Unit unit = Unit.INSTANCE;
        iMiniAppService.startMiniApp(context, url, LaunchScene.LAUNCH_SCENE_TROOP_OR_C2C_SLASH, entryModel, null);
    }

    private final void q(final Context context, final Job loadingTimeoutJob, CommonBotFeatureInfo featureInfo) {
        CommonBotInfo commonBotInfo = this.mRobotInfo;
        if (commonBotInfo == null) {
            QLog.e("RobotMenuPanelVM", 1, "[callbackBackend]: botInfo is null, robotUin=" + this.mRobotUin);
            return;
        }
        ac acVar = this.mRobotService;
        if (acVar != null) {
            acVar.commandCallback(s(commonBotInfo, featureInfo), new ICommandCbCallback() { // from class: com.tencent.robot.aio.panel.menu.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
                public final void onResult(int i3, String str, CommandCbRsp commandCbRsp) {
                    RobotMenuPanelVM.r(RobotMenuPanelVM.this, context, loadingTimeoutJob, i3, str, commandCbRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(RobotMenuPanelVM this$0, Context context, Job loadingTimeoutJob, int i3, String str, CommandCbRsp commandCbRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(loadingTimeoutJob, "$loadingTimeoutJob");
        BuildersKt__Builders_commonKt.launch$default(this$0.vmScope(), Dispatchers.getMain(), null, new RobotMenuPanelVM$callbackBackend$1$1(i3, str, context, loadingTimeoutJob, commandCbRsp, null), 2, null);
    }

    private final CommandCbRequest s(CommonBotInfo robotInfo, CommonBotFeatureInfo featureInfo) {
        CommandCbRequest commandCbRequest = new CommandCbRequest();
        commandCbRequest.guildId = 0L;
        commandCbRequest.channelId = 0L;
        commandCbRequest.botAppId = robotInfo.appid;
        commandCbRequest.botUin = robotInfo.uin;
        commandCbRequest.featureId = String.valueOf(featureInfo.f359162id);
        commandCbRequest.callbackData = featureInfo.name;
        commandCbRequest.dmFlag = 0;
        commandCbRequest.groupId = 0L;
        commandCbRequest.c2cUin = 0L;
        commandCbRequest.chatType = CommonBotScene.C2C.ordinal();
        commandCbRequest.storyAction = StoryAction.UNKNOWN;
        commandCbRequest.botUid = robotInfo.uid;
        return commandCbRequest;
    }

    private final Job t() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new RobotMenuPanelVM$createTimeoutJob$1(null), 3, null);
        launch$default.invokeOnCompletion(new RobotMenuPanelVM$createTimeoutJob$2$1(this));
        return launch$default;
    }

    private final void u(RobotMenuMsgIntent.GetBotMenuResponseMsgIntent event) {
        QLog.i("RobotMenuPanelVM", 1, "GetBotMenuResponseMsgIntent|result=" + event.getResult());
        this.mResponseEvent = event;
        if (this.mRobotAdapter != null) {
            v();
        }
    }

    private final void v() {
        RobotMenuMsgIntent.GetBotMenuResponseMsgIntent getBotMenuResponseMsgIntent = this.mResponseEvent;
        if (getBotMenuResponseMsgIntent != null) {
            this.mOnBatchGetBotMenu.onResult(getBotMenuResponseMsgIntent.getResult(), getBotMenuResponseMsgIntent.getErrMsg(), getBotMenuResponseMsgIntent.getResponse());
        }
        this.mResponseEvent = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotMenuPanelVM", false));
    }

    private final void y(ImageView avatar, c adapter) {
        String str;
        this.mRobotAdapter = adapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAdapter");
            adapter = null;
        }
        adapter.u0(this);
        b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
        b.a aVar = new b.a();
        aVar.g(AvatarSizeType.SMALL);
        aVar.b(Integer.valueOf(R.drawable.f160830com));
        com.tencent.qqnt.avatar.b a16 = aVar.a();
        a.Companion companion2 = com.tencent.qqnt.avatar.a.INSTANCE;
        Context context = avatar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "avatar.context");
        com.tencent.qqnt.avatar.e e16 = companion2.b(context).b(avatar).e(a16);
        String str2 = this.mRobotUid;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotUid");
            str = null;
        } else {
            str = str2;
        }
        e.a.b(e16, str, this.mRobotUin, null, 4, null);
        updateUI(new RobotMenuUIState.UpdateMenu(false, true));
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(RobotMenuPanelVM this$0, int i3, String str, BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(this$0.vmScope(), Dispatchers.getMain().getImmediate(), null, new RobotMenuPanelVM$mOnBatchGetBotMenu$1$1(i3, batchGetBotsMenuResponse, str, this$0, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.robot.aio.panel.menu.c.b
    public void d(int position, @NotNull CommonBotFeatureInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        int i3 = data.type;
        if (i3 == CommonBotFeatureType.H5.ordinal()) {
            D(requireContext, data.url);
            return;
        }
        if (i3 == CommonBotFeatureType.MINIAPP.ordinal()) {
            F(requireContext, data.url);
            return;
        }
        if (i3 == CommonBotFeatureType.TOBACKEND.ordinal()) {
            B(position, data);
            return;
        }
        if (i3 == CommonBotFeatureType.TOROBOT.ordinal()) {
            C(data);
            return;
        }
        QLog.e("RobotMenuPanelVM", 1, "unsupported type: " + data.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        ac acVar;
        IKernelService iKernelService;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            acVar = iKernelService.getRobotService();
        } else {
            acVar = null;
        }
        this.mRobotService = acVar;
        this.mRobotUid = context.g().r().c().j();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        this.mRobotUin = su3.c.a(g16);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar = (com.tencent.mvi.base.route.a) pair.getSecond();
            LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
            Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
            e16.c(str, aVar, d16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        this.mRobotUid = "";
        this.mRobotUin = 0L;
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        this.mRobotService = null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.a) {
            d.a aVar = (d.a) intent;
            y(aVar.getRobotAvatar(), aVar.getAdapter());
        } else {
            QLog.i("RobotMenuPanelVM", 1, "handleIntent");
        }
    }
}
