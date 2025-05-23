package com.tencent.robot.menu;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.slash.manager.c;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\u0006*\u0001J\u0018\u0000 +2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u00105\u001a\u000203\u0012\u0006\u00108\u001a\u000206\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\u0002H\u0016R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010DR\u001c\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010GR\u001c\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010GR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010K\u00a8\u0006O"}, d2 = {"Lcom/tencent/robot/menu/RobotMenuDialogManager;", "Lcom/tencent/robot/slash/manager/c;", "", HippyTKDListViewAdapter.X, "f", "Lw64/o;", "g", "Lcom/tencent/robot/slash/businessapi/a;", "convertResult", "y", "", "isDelay", "v", "t", "u", "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "i", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchGetBotsMenuResponse;", "response", h.F, "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb74/a;", "itemData", "l", "Lb54/a;", "impArgs", "k", "j", "p", "showDialog", "r", "a", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "c", "Lw64/o;", "mDialogProvider", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadingTipsJob", "e", "I", "mState", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "mMenuInfo", "", "Ljava/util/List;", "mDialogMessageList", "mMviMessageList", "com/tencent/robot/menu/RobotMenuDialogManager$b", "Lcom/tencent/robot/menu/RobotMenuDialogManager$b;", "mDialogAction", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMenuDialogManager implements c {

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
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b mLoadingTipsJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MenuInfo mMenuInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mDialogMessageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMviMessageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDialogAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/menu/RobotMenuDialogManager$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotMenuDialogManager.this.i(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public RobotMenuDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.GetBotMenuResponseMsgIntent.class).getQualifiedName());
        this.mMviMessageList = listOf2;
        this.mDialogAction = new b();
        Iterator<T> it = listOf2.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().d((String) it.next(), this.mDialogAction);
        }
    }

    private final void A(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.c(str, this.mDialogAction);
            }
        }
    }

    private final void f() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        s(a16.c());
        this.mDialogProvider = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o g() {
        if (this.mDialogProvider == null) {
            f();
        }
        o oVar = this.mDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (r7 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(int result, String errMsg, BatchGetBotsMenuResponse response) {
        MenuInfo menuInfo;
        int i3;
        Object firstOrNull;
        boolean r16 = r();
        if (result == 0 && response != null) {
            ArrayList<MenuInfo> arrayList = response.menuInfo;
            if (arrayList != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                menuInfo = (MenuInfo) firstOrNull;
            }
            menuInfo = new MenuInfo();
            List list = menuInfo.featureInfo;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            QLog.i("RobotMenuDialogManager", 1, "[handleBotMenuResponse]: data empty=" + list.isEmpty() + " isShowing=" + r16);
            this.mMenuInfo = menuInfo;
            if (!list.isEmpty()) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            this.mState = i3;
        } else {
            QLog.e("RobotMenuDialogManager", 1, "[handleBotMenuResponse]: failed result=" + result + ", errMsg=" + errMsg + " isShowing=" + r16);
            this.mState = 2;
        }
        if (r16) {
            showDialog();
        }
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
        if (event instanceof SlashDialogMsgIntent.RetryRequestMsgIntent) {
            p();
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
            c.a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            k(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            j(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            q((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
            return;
        }
        if (event instanceof RobotMenuMsgIntent.GetBotMenuResponseMsgIntent) {
            RobotMenuMsgIntent.GetBotMenuResponseMsgIntent getBotMenuResponseMsgIntent = (RobotMenuMsgIntent.GetBotMenuResponseMsgIntent) event;
            h(getBotMenuResponseMsgIntent.getResult(), getBotMenuResponseMsgIntent.getErrMsg(), getBotMenuResponseMsgIntent.getResponse());
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
        QLog.i("RobotMenuDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, "");
        c.a.a(this, false, 1, null);
    }

    private final void m(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new CommonListMsgIntent.SubmitListMsgIntent(new ArrayList(), 0, null, null, 14, null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
        if (this.mState == 1) {
            this.mState = 0;
        }
    }

    private final void n(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
    }

    private final void o() {
        if (this.mState != 4 || this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotMenuDialogManager", false));
    }

    private final void p() {
        QLog.i("RobotMenuDialogManager", 1, "handleRetryClickMsgIntent");
        w(this, false, 1, null);
        this.mMviContext.e().h(RobotMenuMsgIntent.RequestBotMenuMsgIntent.f367149d);
        this.mState = 1;
    }

    private final void q(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        c.a.a(this, false, 1, null);
    }

    private final void s(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
    }

    private final void t() {
        Job f16;
        QLog.i("RobotMenuDialogManager", 1, "showEmptyTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o g16 = g();
        if (!g16.r()) {
            g16.showDialog();
        }
        g16.c().a(SlashDialogMsgIntent.ShowEmptyState.f368547e);
    }

    private final void u() {
        Job f16;
        QLog.i("RobotMenuDialogManager", 1, "showFailedTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o g16 = g();
        if (!g16.r()) {
            g16.showDialog();
        }
        g16.c().a(SlashDialogMsgIntent.ShowFailedState.f368548e);
    }

    private final void v(boolean isDelay) {
        Job f16;
        QLog.i("RobotMenuDialogManager", 1, "showLoadingTipDialog");
        if (isDelay) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner d16 = this.mMviContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
            Boolean bool = Boolean.TRUE;
            this.mLoadingTipsJob = CorountineFunKt.e(lifecycleScope, "RobotMenuDialogManagershowLoadingTipDialog", bool, null, bool, new RobotMenuDialogManager$showLoadingTipDialog$1(this, null), 4, null);
            return;
        }
        o g16 = g();
        if (!g16.r()) {
            g16.showDialog();
        }
        g16.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
    }

    static /* synthetic */ void w(RobotMenuDialogManager robotMenuDialogManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        robotMenuDialogManager.v(z16);
    }

    private final void x() {
        Integer num;
        List<b74.a> b16;
        com.tencent.robot.slash.businessapi.a j3 = this.mBusinessDelegate.j(this.mMenuInfo, "");
        if (j3 != null && (b16 = j3.b()) != null) {
            num = Integer.valueOf(b16.size());
        } else {
            num = null;
        }
        QLog.i("RobotMenuDialogManager", 1, "showSuccessDialog itemList size = " + num);
        if (j3 != null && !j3.b().isEmpty()) {
            y(j3);
        } else {
            c.a.a(this, false, 1, null);
        }
    }

    private final void y(com.tencent.robot.slash.businessapi.a convertResult) {
        Integer num;
        List listOf;
        Job f16;
        int size = convertResult.b().size();
        List<b.UIModelData> a16 = convertResult.a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        QLog.i("RobotMenuDialogManager", 1, "submitList itemList size = " + size + " avatarItemList size = " + num);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        final o g16 = g();
        g16.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        g16.c().a(new CommonListMsgIntent.SubmitListMsgIntent(convertResult.b(), convertResult.getCom.tencent.mobileqq.webview.constants.QQBrowserActivityConstants.KEY_TITLE_STYLE java.lang.String(), new Runnable() { // from class: com.tencent.robot.menu.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotMenuDialogManager.z(o.this);
            }
        }, null, 8, null));
        List<b.UIModelData> a17 = convertResult.a();
        if (a17 != null) {
            g16.c().a(new AvatarBarMsgIntent.SubmitList(a17));
        }
        if (g16.r()) {
            com.tencent.input.base.launch.b c16 = g16.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
            return;
        }
        g16.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(o this_with) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.c().a(new SlashListCouplingEffectMsgIntent.ScrollToPosition(0));
    }

    @Override // com.tencent.robot.slash.manager.c
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // com.tencent.robot.slash.manager.c
    public void b(boolean needAnim) {
        o oVar;
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        boolean z16 = true;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o oVar2 = this.mDialogProvider;
        if (oVar2 == null || !oVar2.r()) {
            z16 = false;
        }
        if (z16 && (oVar = this.mDialogProvider) != null) {
            oVar.b(needAnim);
        }
    }

    @Override // com.tencent.robot.slash.manager.c
    public void onDestroy() {
        QLog.i("RobotMenuDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        c.a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            A(oVar.c());
            oVar.onDestroy();
        }
        Iterator<T> it = this.mMviMessageList.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().b((String) it.next(), this.mDialogAction);
        }
    }

    @Override // com.tencent.robot.slash.manager.c
    public boolean r() {
        boolean z16;
        if (this.mState == 1) {
            return true;
        }
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            z16 = oVar.r();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.slash.manager.c
    public void showDialog() {
        QLog.i("RobotMenuDialogManager", 1, "showDialog");
        int i3 = this.mState;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        QLog.e("RobotMenuDialogManager", 1, "mActionState Error");
                        return;
                    } else {
                        x();
                        return;
                    }
                }
                t();
                return;
            }
            u();
            return;
        }
        w(this, false, 1, null);
        this.mState = 1;
    }
}
