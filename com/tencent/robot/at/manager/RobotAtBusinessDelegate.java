package com.tencent.robot.at.manager;

import android.content.Context;
import android.text.Selection;
import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mvi.base.route.k;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import n64.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u00103\u001a\u00020\u0014\u00a2\u0006\u0004\b7\u00108J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J4\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00100R\u0014\u00103\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00102R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/robot/at/manager/RobotAtBusinessDelegate;", "Lcom/tencent/robot/slash/businessapi/c;", "", "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "commandInfo", "", "p", "command", "r", "serviceInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "troopUin", "troopName", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "o", "Landroid/view/View;", "l", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "Lb54/a;", "itemArgs", "g", "e", "robotUin", "robotTinyId", "b", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/view/View;", "mAnchorView", "c", "Ljava/lang/String;", "mRobotUin", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAtBusinessDelegate implements c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f367466d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mRobotUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/at/manager/RobotAtBusinessDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public RobotAtBusinessDelegate(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
        this.mRobotUin = "";
    }

    private final HashMap<String, Object> o(String troopUin, String troopName) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_qqrobot_halfscreen_order");
        hashMap.put("group_id", troopUin);
        hashMap.put("group_name", troopName);
        hashMap.put("c2c_id", this.mRobotUin);
        hashMap.put("invoke_scene", 2);
        return hashMap;
    }

    private final void p(final String keyword, CommonBotInfo robotInfo, final CommonBotFeatureInfo commandInfo) {
        if (h34.a.f(robotInfo)) {
            Context context = this.mAIOContext.c().getContext();
            if (context == null) {
                return;
            }
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        this.mAIOContext.e().h(new SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent(robotInfo, commandInfo, 1));
        u64.c.e(this.mAIOContext, "RobotAtBusinessDelegate", new Function0<Unit>() { // from class: com.tencent.robot.at.manager.RobotAtBusinessDelegate$handleCommandItemClick$1
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
                RobotAtBusinessDelegate robotAtBusinessDelegate = RobotAtBusinessDelegate.this;
                String str = keyword;
                String str2 = commandInfo.name;
                Intrinsics.checkNotNullExpressionValue(str2, "commandInfo.name");
                robotAtBusinessDelegate.r(str, str2);
            }
        });
    }

    private final void q(CommonBotInfo robotInfo, CommonBotFeatureInfo serviceInfo) {
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        if (h34.a.f(robotInfo)) {
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        this.mAIOContext.e().h(new SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent(robotInfo, serviceInfo, 2));
        int i3 = serviceInfo.type;
        if (i3 == CommonBotFeatureType.H5.ordinal()) {
            String str = serviceInfo.url;
            Intrinsics.checkNotNullExpressionValue(str, "serviceInfo.url");
            b.c(context, str);
        } else if (i3 == CommonBotFeatureType.MINIAPP.ordinal()) {
            String str2 = serviceInfo.url;
            Intrinsics.checkNotNullExpressionValue(str2, "serviceInfo.url");
            b.b(context, str2, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        if (r1 == r0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(String keyword, String command) {
        d.C7264d c7264d;
        CharSequence a16;
        boolean z16;
        int lastIndexOf$default;
        k k3 = this.mAIOContext.e().k(new InputEvent.GetInputString());
        if (k3 instanceof d.C7264d) {
            c7264d = (d.C7264d) k3;
        } else {
            c7264d = null;
        }
        if (c7264d != null && (a16 = c7264d.a()) != null) {
            int selectionStart = Selection.getSelectionStart(a16);
            int selectionEnd = Selection.getSelectionEnd(a16);
            if (keyword.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(a16, keyword, selectionStart, false, 4, (Object) null);
            } else {
                lastIndexOf$default = -1;
            }
            if (lastIndexOf$default > 0) {
                if (selectionStart == selectionEnd && keyword.length() + lastIndexOf$default == selectionStart) {
                    selectionStart = lastIndexOf$default;
                } else if (selectionStart < selectionEnd) {
                }
                this.mAIOContext.e().h(new InputEditTextMsgIntent.ReplaceTextToEditText(command + " ", selectionStart, selectionEnd));
            }
            selectionEnd = selectionStart;
            this.mAIOContext.e().h(new InputEditTextMsgIntent.ReplaceTextToEditText(command + " ", selectionStart, selectionEnd));
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof x54.b) {
            if (keyword == null) {
                keyword = "";
            }
            x54.b bVar = (x54.b) itemData;
            p(keyword, bVar.getRobotInfo(), bVar.getCommandInfo());
            return;
        }
        if (itemData instanceof d64.b) {
            d64.b bVar2 = (d64.b) itemData;
            q(bVar2.getRobotInfo(), bVar2.getServiceInfo());
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String robotUin, @NotNull String robotTinyId) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, robotUin, this.mAIOContext.g().r().c().j(), 3, 0, null, 48, null));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        c.a.c(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        IRuntimeService iRuntimeService;
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        String j3 = this.mAIOContext.g().r().c().j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        String str2 = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null && (findTroopInfo = iTroopInfoService.findTroopInfo(j3)) != null) {
            str2 = findTroopInfo.troopname;
        }
        if (str2 != null) {
            str = str2;
        }
        HashMap<String, Object> o16 = o(j3, str);
        VideoReport.setPageId(rootView, "pg_qqrobot_halfscreen_order");
        VideoReport.setPageParams(rootView, new PageParams(o16));
        VideoReport.reportEvent("dt_pgin", rootView, o16);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.b.f27956a.a(itemArgs);
        } else if (itemArgs.getFunctionType() == 2) {
            b54.b.f27956a.c(itemArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        IRuntimeService iRuntimeService;
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        String j3 = this.mAIOContext.g().r().c().j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        String str2 = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null && (findTroopInfo = iTroopInfoService.findTroopInfo(j3)) != null) {
            str2 = findTroopInfo.troopname;
        }
        if (str2 != null) {
            str = str2;
        }
        HashMap<String, Object> o16 = o(j3, str);
        VideoReport.setPageId(rootView, "pg_qqrobot_halfscreen_order");
        VideoReport.setPageParams(rootView, new PageParams(o16));
        VideoReport.reportEvent("dt_pgout", rootView, o16);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.b.f27956a.b(itemArgs);
        } else if (itemArgs.getFunctionType() == 2) {
            b54.b.f27956a.d(itemArgs);
        }
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
        Object firstOrNull;
        List<b74.a> emptyList;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        CommonBotFeatures commonBotFeatures = null;
        if (searchResponse instanceof List) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) searchResponse);
            if (firstOrNull instanceof CommonBotFeatures) {
                commonBotFeatures = (CommonBotFeatures) firstOrNull;
            }
            if (commonBotFeatures == null || (emptyList = ConvertSearchTools.f368422a.d(commonBotFeatures, keyword)) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new com.tencent.robot.slash.businessapi.a(emptyList, null, 0, 4, null);
        }
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public SearchSessionParams k(@Nullable Object args) {
        Long l3;
        long j3;
        ArrayList arrayListOf;
        if (args instanceof Long) {
            l3 = (Long) args;
        } else {
            l3 = null;
        }
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        this.mRobotUin = String.valueOf(j3);
        AIOContact c16 = this.mAIOContext.g().r().c();
        String str = c16.j() + "_" + c16.e() + "_" + j3;
        Contact contact = new Contact(c16.e(), c16.j(), "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(j3));
        return new SearchSessionParams(contact, arrayListOf, new ArrayList(), CommonBotScene.GROUP, CommonBotFilter.KNONE, str);
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
        return new d34.a(this.mAIOContext, this);
    }
}
