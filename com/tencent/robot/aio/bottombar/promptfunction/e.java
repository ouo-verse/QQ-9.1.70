package com.tencent.robot.aio.bottombar.promptfunction;

import a74.CustomTitleInfo;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import g34.c;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0007*\u00014\u0018\u0000 \u00062\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010-R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/e;", "Lg34/c;", "Lcom/tencent/robot/aio/bottombar/model/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "Lw64/o;", "g", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", "p", "u", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", h.F, "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "l", "Lb74/a;", "itemData", "k", "Lb54/a;", "impArgs", "j", "i", "", "r", "a", "c", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "Lw64/o;", "mDialogProvider", "", "", "d", "Ljava/util/List;", "mDialogMessageList", "com/tencent/robot/aio/bottombar/promptfunction/e$b", "e", "Lcom/tencent/robot/aio/bottombar/promptfunction/e$b;", "mDialogAction", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements g34.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mMviContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.slash.businessapi.c mBusinessDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o mDialogProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mDialogMessageList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDialogAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/bottombar/promptfunction/e$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            e.this.h(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public e(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        this.mDialogAction = new b();
    }

    private final void f() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        p(a16.c());
        this.mDialogProvider = a16;
    }

    private final o g() {
        if (this.mDialogProvider == null) {
            f();
        }
        o oVar = this.mDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mDialogProvider;
            if (oVar != null) {
                o.a.a(oVar, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            n();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            k(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            m((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            l((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            c.a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            j(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            i(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
        } else if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            o((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        }
    }

    private final void i(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void j(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void k(b74.a itemData) {
        QLog.i("RobotPromptFunctionDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, "");
        c.a.a(this, false, 1, null);
    }

    private final void l(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        this.mBusinessDelegate.f(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, true);
    }

    private final void m(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, false);
        com.tencent.robot.aio.bottombar.a.a("robotPromptFunction", this.mMviContext);
    }

    private final void n() {
        if (this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotPromptFunctionDialogManager", false));
    }

    private final void o(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        c.a.a(this, false, 1, null);
    }

    private final void p(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
    }

    private final void q(RobotBottomBarItemModel data) {
        QLog.i("RobotPromptFunctionDialogManager", 1, "showSuccessDialog itemList");
        s(data);
        this.mMviContext.e().h(new InputEditTextMsgIntent.UpdateRobotPromptFunctionData(0, data.getPromptTemplate(), data.getInputPlaceholder(), new ArrayList()));
    }

    private final void s(RobotBottomBarItemModel data) {
        List listOf;
        List listOf2;
        QLog.i("RobotPromptFunctionDialogManager", 1, "submitList start");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new a(data));
        final o g16 = g();
        g16.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        g16.c().a(new CommonListMsgIntent.SubmitListMsgIntent(listOf, 6, new Runnable() { // from class: com.tencent.robot.aio.bottombar.promptfunction.d
            @Override // java.lang.Runnable
            public final void run() {
                e.t(o.this);
            }
        }, new CustomTitleInfo(data.getTitle(), data.getIconUrl())));
        if (g16.r()) {
            com.tencent.input.base.launch.b c16 = g16.c();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf2));
            return;
        }
        g16.showDialog();
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

    @Override // g34.c
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // g34.c
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
    }

    @Override // g34.c
    public void c(@NotNull RobotBottomBarItemModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        q(data);
    }

    @Override // g34.c
    public void onDestroy() {
        QLog.i("RobotPromptFunctionDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        c.a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            u(oVar.c());
            oVar.onDestroy();
        }
    }

    @Override // g34.c
    public boolean r() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }
}
