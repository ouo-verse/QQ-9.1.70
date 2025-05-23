package com.tencent.robot.menu;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.robot.action.api.IRobotActionApi;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.menu.RobotMenuBusinessDelegate;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n14.AIOSchemeActionContext;
import n64.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u00022\"B\u0017\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020#\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\u0015H\u0016R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010+R\u0014\u0010/\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/menu/RobotMenuBusinessDelegate;", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "commandInfo", "", "p", "data", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRef", "featureInfo", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/CommandCbRequest;", "o", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "c", "l", h.F, "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "b", "Landroid/view/View;", "mAnchorView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "CommandCallback", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMenuBusinessDelegate implements c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f367794c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/menu/RobotMenuBusinessDelegate$CommandCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICommandCbCallback;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/CommandCbRsp;", "response", "", "onResult", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "contextRef", "<init>", "(Ljava/lang/ref/WeakReference;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class CommandCallback implements ICommandCbCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Context> contextRef;

        public CommandCallback(@NotNull WeakReference<Context> contextRef) {
            Intrinsics.checkNotNullParameter(contextRef, "contextRef");
            this.contextRef = contextRef;
        }

        @NotNull
        public final WeakReference<Context> a() {
            return this.contextRef;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
        public void onResult(final int result, @Nullable final String errMsg, @Nullable final CommandCbRsp response) {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.menu.RobotMenuBusinessDelegate$CommandCallback$onResult$1
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
                    Context context = RobotMenuBusinessDelegate.CommandCallback.this.a().get();
                    int i3 = result;
                    boolean z16 = true;
                    if (i3 != 0) {
                        QLog.e("RobotMenuBusinessDelegate", 1, "[callbackBackend]: result=" + i3 + ", error=" + errMsg);
                        if (context == null) {
                            return;
                        }
                        String str = errMsg;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        }
                        String string = z16 ? context.getString(R.string.f222416dg) : errMsg;
                        Intrinsics.checkNotNullExpressionValue(string, "if (errMsg.isNullOrEmpty\u2026allback_fail) else errMsg");
                        QQToast.makeText(context, string, 0).show();
                        return;
                    }
                    CommandCbRsp commandCbRsp = response;
                    if (commandCbRsp != null) {
                        QLog.i("RobotMenuBusinessDelegate", 1, "[callbackBackend]: promptType=" + commandCbRsp.promptType);
                        if (context == null) {
                            return;
                        }
                        IRobotExtApi iRobotExtApi = (IRobotExtApi) QRoute.api(IRobotExtApi.class);
                        CommandCbRsp commandCbRsp2 = response;
                        int i16 = commandCbRsp2.status;
                        int i17 = commandCbRsp2.promptType;
                        String str2 = commandCbRsp2.promptText;
                        Intrinsics.checkNotNullExpressionValue(str2, "response.promptText");
                        iRobotExtApi.handleOnBackendReply(context, i16, i17, str2, response.promptIcon);
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/menu/RobotMenuBusinessDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public RobotMenuBusinessDelegate(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
    }

    private final void n(WeakReference<Context> contextRef, CommonBotInfo robotInfo, CommonBotFeatureInfo featureInfo) {
        ac acVar;
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            acVar = iKernelService.getRobotService();
        } else {
            acVar = null;
        }
        if (acVar != null) {
            acVar.commandCallback(o(robotInfo, featureInfo), new CommandCallback(contextRef));
        }
    }

    private final CommandCbRequest o(CommonBotInfo robotInfo, CommonBotFeatureInfo featureInfo) {
        CommandCbRequest commandCbRequest = new CommandCbRequest();
        commandCbRequest.botAppId = robotInfo.appid;
        commandCbRequest.botUin = robotInfo.uin;
        commandCbRequest.featureId = String.valueOf(featureInfo.f359162id);
        commandCbRequest.callbackData = featureInfo.name;
        commandCbRequest.chatType = CommonBotScene.C2C.ordinal();
        return commandCbRequest;
    }

    private final void p(CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        int i3 = commandInfo.type;
        if (i3 == CommonBotFeatureType.H5.ordinal()) {
            String str = commandInfo.url;
            Intrinsics.checkNotNullExpressionValue(str, "commandInfo.url");
            b.c(context, str);
            return;
        }
        if (i3 == CommonBotFeatureType.MINIAPP.ordinal()) {
            String str2 = commandInfo.url;
            Intrinsics.checkNotNullExpressionValue(str2, "commandInfo.url");
            b.a(context, str2, 0);
        } else {
            if (i3 == CommonBotFeatureType.TOBACKEND.ordinal()) {
                q(robotInfo, commandInfo);
                return;
            }
            if (i3 == CommonBotFeatureType.TOROBOT.ordinal()) {
                r(commandInfo);
                return;
            }
            QLog.e("RobotMenuBusinessDelegate", 1, "unsupported type: " + commandInfo.type);
        }
    }

    private final void q(CommonBotInfo robotInfo, CommonBotFeatureInfo data) {
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        n(new WeakReference<>(context), robotInfo, data);
    }

    private final void r(CommonBotFeatureInfo data) {
        boolean z16;
        String schemeUrl = data.schemaUrl;
        if (schemeUrl != null && schemeUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("RobotMenuBusinessDelegate", 4, "scheme is empty, cmdName=" + data.name);
            schemeUrl = new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("aio").path("/inlinecmd").appendQueryParameter("command", data.name).appendQueryParameter(BaseConstants.BROADCAST_USERSYNC_ENTER, "true").build().toString();
        }
        IRobotActionApi iRobotActionApi = (IRobotActionApi) QRoute.api(IRobotActionApi.class);
        AIOSchemeActionContext aIOSchemeActionContext = new AIOSchemeActionContext(this.mAIOContext, null, null, null, 14, null);
        Intrinsics.checkNotNullExpressionValue(schemeUrl, "schemeUrl");
        iRobotActionApi.doSchemeAction(aIOSchemeActionContext, schemeUrl);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof x54.b) {
            x54.b bVar = (x54.b) itemData;
            p(bVar.getRobotInfo(), bVar.getCommandInfo());
        } else if (itemData instanceof d64.b) {
            d64.b bVar2 = (d64.b) itemData;
            p(bVar2.getRobotInfo(), bVar2.getServiceInfo());
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String str, @NotNull String str2) {
        c.a.f(this, str, str2);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        this.mAIOContext.e().h(RobotMenuMsgIntent.OnRobotMenuDismissAnimStart.f367148d);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new RobotMenuMsgIntent.OnRobotMenuDialogChanged(true));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs functionReportArgs) {
        c.a.d(this, functionReportArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new RobotMenuMsgIntent.OnRobotMenuDialogChanged(false));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs functionReportArgs) {
        c.a.e(this, functionReportArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new u54.c(c16.j(), c16.e());
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        return c.a.b(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo commonBotInfo, @NotNull CommonBotFeatureInfo commonBotFeatureInfo, int i3) {
        c.a.g(this, commonBotInfo, commonBotFeatureInfo, i3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (!(searchResponse instanceof MenuInfo)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MenuInfo menuInfo = (MenuInfo) searchResponse;
        Iterator<CommonBotFeatureInfo> it = menuInfo.featureInfo.iterator();
        while (it.hasNext()) {
            CommonBotFeatureInfo featureInfo = it.next();
            int i3 = featureInfo.type;
            boolean z16 = true;
            if (i3 != CommonBotFeatureType.H5.ordinal() && i3 != CommonBotFeatureType.MINIAPP.ordinal()) {
                z16 = false;
            }
            if (z16) {
                CommonBotInfo commonBotInfo = menuInfo.botInfo;
                Intrinsics.checkNotNullExpressionValue(commonBotInfo, "searchResponse.botInfo");
                Intrinsics.checkNotNullExpressionValue(featureInfo, "featureInfo");
                arrayList.add(new d64.b(commonBotInfo, featureInfo));
            } else {
                featureInfo.desc = "";
                CommonBotInfo commonBotInfo2 = menuInfo.botInfo;
                Intrinsics.checkNotNullExpressionValue(commonBotInfo2, "searchResponse.botInfo");
                Intrinsics.checkNotNullExpressionValue(featureInfo, "featureInfo");
                arrayList.add(new x54.b(commonBotInfo2, featureInfo));
            }
        }
        return new com.tencent.robot.slash.businessapi.a(arrayList, null, 2);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public SearchSessionParams k(@Nullable Object args) {
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public View getMAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new k54.a(this.mAIOContext, this);
    }
}
