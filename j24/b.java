package j24;

import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import g34.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0006*\u0001<\u0018\u0000 \u00052\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u00100\u001a\u00020.\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\u0002H\u0016R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00109R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010=\u00a8\u0006A"}, d2 = {"Lj24/b;", "Lg34/b;", "", "g", "Lw64/o;", h.F, "Lg34/a;", "dataSource", "Lcom/tencent/robot/slash/businessapi/a;", "convertResult", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "i", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", "p", "o", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb74/a;", "itemData", "l", "Lb54/a;", "impArgs", "k", "j", "", "searchResponse", "f", "", "r", "a", "c", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "Lw64/o;", "mDialogProvider", "d", "Lg34/a;", "mDataSource", "", "", "e", "Ljava/util/List;", "mDialogMessageList", "mMviMessageList", "j24/b$b", "Lj24/b$b;", "mDialogAction", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements g34.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.slash.businessapi.c mBusinessDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o mDialogProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g34.a mDataSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mDialogMessageList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMviMessageList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10567b mDialogAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"j24/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j24.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10567b implements com.tencent.mvi.base.route.a {
        C10567b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.i(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.aioContext = aioContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.GetBotMenuResponseMsgIntent.class).getQualifiedName());
        this.mMviMessageList = listOf2;
        this.mDialogAction = new C10567b();
        Iterator<T> it = listOf2.iterator();
        while (it.hasNext()) {
            this.aioContext.e().d((String) it.next(), this.mDialogAction);
        }
    }

    private final com.tencent.robot.slash.businessapi.a f(Object searchResponse) {
        if (!(searchResponse instanceof MenuInfo)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MenuInfo menuInfo = (MenuInfo) searchResponse;
        Iterator<CommonBotFeatureInfo> it = menuInfo.featureInfo.iterator();
        while (it.hasNext()) {
            CommonBotFeatureInfo featureInfo = it.next();
            CommonBotInfo commonBotInfo = menuInfo.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo, "searchResponse.botInfo");
            Intrinsics.checkNotNullExpressionValue(featureInfo, "featureInfo");
            arrayList.add(new x54.b(commonBotInfo, featureInfo));
        }
        return new com.tencent.robot.slash.businessapi.a(arrayList, null, 6);
    }

    private final void g() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.aioContext));
        q(a16.c());
        this.mDialogProvider = a16;
    }

    private final o h() {
        if (this.mDialogProvider == null) {
            g();
        }
        o oVar = this.mDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mDialogProvider;
            if (oVar != null) {
                o.a.a(oVar, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            o();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            l(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            n((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            m((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            b.a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            k(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            j(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
        } else if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            p((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        }
    }

    private final void j(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void k(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void l(b74.a itemData) {
        RobotBottomBarItemModel robotBottomBarItemModel;
        g34.a aVar;
        QLog.i("RobotSubMenuDialogManager", 1, "handleItemClickMsgIntent");
        if ((itemData instanceof x54.b) && (aVar = this.mDataSource) != null) {
            x54.b bVar = (x54.b) itemData;
            robotBottomBarItemModel = aVar.b(String.valueOf(bVar.getCommandInfo().f359162id), bVar.getCommandInfo().type);
        } else {
            robotBottomBarItemModel = null;
        }
        b.a.a(this, false, 1, null);
        if (robotBottomBarItemModel != null) {
            new i24.a(this.aioContext).a(robotBottomBarItemModel);
        }
    }

    private final void m(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new CommonListMsgIntent.SubmitListMsgIntent(new ArrayList(), 0, null, null, 14, null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.aioContext, true);
    }

    private final void n(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.aioContext, false);
        com.tencent.robot.aio.bottombar.a.a("robotSubMenu", this.aioContext);
    }

    private final void o() {
        if (this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.aioContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotSubMenuDialogManager", false));
    }

    private final void p(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        b.a.a(this, false, 1, null);
    }

    private final void q(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
    }

    private final void s(g34.a dataSource, com.tencent.robot.slash.businessapi.a convertResult) {
        Integer num;
        List listOf;
        int size = convertResult.b().size();
        List<b.UIModelData> a16 = convertResult.a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        QLog.i("RobotSubMenuDialogManager", 1, "submitList itemList size = " + size + " avatarItemList size = " + num);
        final o h16 = h();
        h16.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        h16.c().a(new CommonListMsgIntent.SubmitListMsgIntent(convertResult.b(), convertResult.getCom.tencent.mobileqq.webview.constants.QQBrowserActivityConstants.KEY_TITLE_STYLE java.lang.String(), new Runnable() { // from class: j24.a
            @Override // java.lang.Runnable
            public final void run() {
                b.t(o.this);
            }
        }, dataSource.a()));
        List<b.UIModelData> a17 = convertResult.a();
        if (a17 != null) {
            h16.c().a(new AvatarBarMsgIntent.SubmitList(a17));
        }
        if (h16.r()) {
            com.tencent.input.base.launch.b c16 = h16.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
            return;
        }
        h16.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(o this_with) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.c().a(new SlashListCouplingEffectMsgIntent.ScrollToPosition(0));
    }

    private final void u(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.c(str, this.mDialogAction);
            }
        }
    }

    @Override // g34.b
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // g34.b
    public void b(boolean needAnim) {
        o oVar;
        o oVar2 = this.mDialogProvider;
        boolean z16 = false;
        if (oVar2 != null && oVar2.r()) {
            z16 = true;
        }
        if (z16 && (oVar = this.mDialogProvider) != null) {
            oVar.b(needAnim);
        }
        this.mDataSource = null;
    }

    @Override // g34.b
    public void c(@NotNull g34.a dataSource) {
        Integer num;
        List<b74.a> b16;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.mDataSource = dataSource;
        com.tencent.robot.slash.businessapi.a f16 = f(dataSource.c());
        if (f16 != null && (b16 = f16.b()) != null) {
            num = Integer.valueOf(b16.size());
        } else {
            num = null;
        }
        QLog.i("RobotSubMenuDialogManager", 1, "showSuccessDialog itemList size = " + num);
        if (f16 != null && !f16.b().isEmpty()) {
            s(dataSource, f16);
        } else {
            b.a.a(this, false, 1, null);
        }
    }

    @Override // g34.b
    public void onDestroy() {
        QLog.i("RobotSubMenuDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b.a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            u(oVar.c());
            oVar.onDestroy();
        }
        Iterator<T> it = this.mMviMessageList.iterator();
        while (it.hasNext()) {
            this.aioContext.e().b((String) it.next(), this.mDialogAction);
        }
    }

    @Override // g34.b
    public boolean r() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }
}
