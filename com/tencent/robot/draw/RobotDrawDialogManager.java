package com.tencent.robot.draw;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AIDrawInfo;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequireData;
import com.tencent.qqnt.kernel.nativeinterface.RequireFunction;
import com.tencent.qqnt.kernel.nativeinterface.RequireList;
import com.tencent.qqnt.kernel.nativeinterface.ReviseFunction;
import com.tencent.qqnt.kernel.nativeinterface.StyleData;
import com.tencent.qqnt.kernel.nativeinterface.StyleFunction;
import com.tencent.qqnt.kernel.nativeinterface.StyleList;
import com.tencent.robot.aio.input.RobotDrawMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import m24.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;
import z34.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0002SV\u0018\u0000 12\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010=\u001a\u00020;\u0012\u0006\u0010@\u001a\u00020>\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\"\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010$\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010$\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002J\b\u00102\u001a\u00020\u0002H\u0002J\u0010\u00104\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u000203H\u0002J\b\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\nH\u0016J\u0010\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020\u0002H\u0016R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010LR\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010OR\u001c\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010OR\u001c\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010OR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010W\u00a8\u0006["}, d2 = {"Lcom/tencent/robot/draw/RobotDrawDialogManager;", "Lz34/a;", "", BdhLogUtil.LogTag.Tag_Conn, "f", "Lw64/o;", h.F, "La44/a;", "data", "D", "", "isDelay", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", "v", "E", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "j", "intent", "Lcom/tencent/mvi/base/route/k;", "k", "w", "success", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "i", "rsp", "g", HippyTKDListViewAdapter.X, "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "p", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "o", "Lb74/a;", "itemData", DomainData.DOMAIN_NAME, "Lb54/a;", "impArgs", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$UpdateRobotDrawData;", "u", "showDialog", "r", "a", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "c", "Lw64/o;", "mDialogProvider", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadingTipsJob", "", "e", "I", "mState", "La44/a;", "mData", "", "Ljava/util/List;", "mDialogMessageList", "mDialogMessageRList", "mMviMessageList", "com/tencent/robot/draw/RobotDrawDialogManager$b", "Lcom/tencent/robot/draw/RobotDrawDialogManager$b;", "mDialogAction", "com/tencent/robot/draw/RobotDrawDialogManager$c", "Lcom/tencent/robot/draw/RobotDrawDialogManager$c;", "mDialogActionR", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotDrawDialogManager implements z34.a {

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
    private a44.a mData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mDialogMessageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mDialogMessageRList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMviMessageList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDialogAction;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mDialogActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/draw/RobotDrawDialogManager$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotDrawDialogManager.this.j(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/draw/RobotDrawDialogManager$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return RobotDrawDialogManager.this.k(i3);
        }
    }

    public RobotDrawDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.UpdateRobotDrawData.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.GetAnchorViewMsgIntent.class).getQualifiedName());
        this.mDialogMessageRList = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.GetBotDrawResponseMsgIntent.class).getQualifiedName());
        this.mMviMessageList = listOf3;
        this.mDialogAction = new b();
        this.mDialogActionR = new c();
        Iterator<T> it = listOf3.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().d((String) it.next(), this.mDialogAction);
        }
    }

    private final void A(boolean isDelay) {
        Job f16;
        QLog.i("RobotDrawDialogManager", 1, "showLoadingTipDialog");
        if (isDelay) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner d16 = this.mMviContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
            Boolean bool = Boolean.TRUE;
            this.mLoadingTipsJob = CorountineFunKt.e(lifecycleScope, "RobotDrawDialogManagershowLoadingTipDialog", bool, null, bool, new RobotDrawDialogManager$showLoadingTipDialog$1(this, null), 4, null);
            return;
        }
        o h16 = h();
        if (!h16.r()) {
            h16.showDialog();
        }
        h16.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
    }

    static /* synthetic */ void B(RobotDrawDialogManager robotDrawDialogManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        robotDrawDialogManager.A(z16);
    }

    private final void C() {
        QLog.i("RobotDrawDialogManager", 1, "showSuccessDialog itemList");
        a44.a aVar = this.mData;
        if (aVar == null) {
            a.C11649a.a(this, false, 1, null);
        } else {
            D(aVar);
        }
    }

    private final void D(a44.a data) {
        List listOf;
        Job f16;
        QLog.i("RobotDrawDialogManager", 1, "submitList start");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        String str = null;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o h16 = h();
        h16.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        h16.c().a(new RobotDrawMsgIntent.SubmitListMsgIntent(data));
        j e16 = this.mMviContext.e();
        if (data != null) {
            str = data.getCallbackData();
        }
        e16.h(new InputEditTextMsgIntent.UpdateRobotDrawData(3, null, null, null, null, str));
        if (h16.r()) {
            com.tencent.input.base.launch.b c16 = h16.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
            return;
        }
        h16.showDialog();
    }

    private final void E(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.c(str, this.mDialogAction);
            }
        }
        for (String str2 : this.mDialogMessageRList) {
            if (str2 != null) {
                dialogExternalProvider.e(str2, this.mDialogActionR);
            }
        }
    }

    private final void f() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        v(a16.c());
        this.mDialogProvider = a16;
    }

    private final void g(QueryHalfViewDataRsp rsp) {
        this.mState = 4;
        this.mData = x(rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o h() {
        if (this.mDialogProvider == null) {
            f();
        }
        o oVar = this.mDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    private final void i(boolean success, String errMsg, QueryHalfViewDataRsp response) {
        boolean z16;
        boolean r16 = r();
        if (success && response != null) {
            ArrayList<HalfViewCardNode> arrayList = response.cardNodes;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.mState = 3;
                this.mData = null;
                return;
            }
            g(response);
            QLog.i("RobotDrawDialogManager", 1, "[handleBotResponse]: data empty=" + arrayList.isEmpty() + " isShowing=" + r16);
        } else {
            QLog.e("RobotDrawDialogManager", 1, "[handleBotResponse]: failed success=" + success + ", errMsg=" + errMsg + " isShowing=" + r16);
            this.mState = 2;
        }
        if (r16) {
            showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mDialogProvider;
            if (oVar != null) {
                o.a.a(oVar, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            q();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            n(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.RetryRequestMsgIntent) {
            s();
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            p((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            o((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            a.C11649a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            m(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            l(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            t((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
            return;
        }
        if (event instanceof RobotDrawMsgIntent.GetBotDrawResponseMsgIntent) {
            RobotDrawMsgIntent.GetBotDrawResponseMsgIntent getBotDrawResponseMsgIntent = (RobotDrawMsgIntent.GetBotDrawResponseMsgIntent) event;
            i(getBotDrawResponseMsgIntent.getSuccess(), getBotDrawResponseMsgIntent.getErrMsg(), getBotDrawResponseMsgIntent.getResponse());
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        } else if (event instanceof RobotDrawMsgIntent.UpdateRobotDrawData) {
            u((RobotDrawMsgIntent.UpdateRobotDrawData) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k k(MsgIntent intent) {
        if (intent instanceof RobotDrawMsgIntent.GetAnchorViewMsgIntent) {
            return new a.GeAnchorViewMsgResult(this.mBusinessDelegate.getMAnchorView());
        }
        return new j54.a();
    }

    private final void l(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void m(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void n(b74.a itemData) {
        QLog.i("RobotDrawDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, "");
        a.C11649a.a(this, false, 1, null);
    }

    private final void o(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new RobotDrawMsgIntent.SubmitListMsgIntent(null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
        this.mState = 0;
        this.mData = null;
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, true);
    }

    private final void p(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, false);
        com.tencent.robot.aio.bottombar.a.a("robotDraw", this.mMviContext);
    }

    private final void q() {
        if (this.mState != 4 || this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotDrawDialogManager", false));
    }

    private final void s() {
        QLog.i("RobotDrawDialogManager", 1, "handleRetryClickMsgIntent");
        B(this, false, 1, null);
        w();
    }

    private final void t(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        a.C11649a.a(this, false, 1, null);
    }

    private final void u(RobotDrawMsgIntent.UpdateRobotDrawData intent) {
        QLog.i("RobotDrawDialogManager", 1, "handleUpdateRobotDrawDataMsgIntent intent = " + intent);
        this.mMviContext.e().h(new InputEditTextMsgIntent.UpdateRobotDrawData(intent.getType(), intent.getStyleName(), intent.getStyleData(), intent.getRequireName(), intent.getRequireData(), null));
    }

    private final void v(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
        for (String str2 : this.mDialogMessageRList) {
            if (str2 != null) {
                dialogExternalProvider.d(str2, this.mDialogActionR);
            }
        }
    }

    private final void w() {
        QLog.i("RobotDrawDialogManager", 1, "requestDrawData");
        this.mMviContext.e().h(RobotDrawMsgIntent.RequestBotDrawMsgIntent.f367136d);
        this.mState = 1;
    }

    private final a44.a x(QueryHalfViewDataRsp rsp) {
        boolean z16;
        Iterator it;
        ReviseFunction reviseFunction;
        RequireFunction requireFunction;
        StyleFunction styleFunction;
        a44.a aVar = new a44.a(null, null, null, null, 15, null);
        ArrayList<HalfViewCardNode> nodes = rsp.cardNodes;
        ArrayList arrayList = new ArrayList();
        if (nodes != null && !nodes.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return aVar;
        }
        Intrinsics.checkNotNullExpressionValue(nodes, "nodes");
        Iterator it5 = nodes.iterator();
        while (it5.hasNext()) {
            HalfViewCardNode halfViewCardNode = (HalfViewCardNode) it5.next();
            AIDrawInfo aIDrawInfo = halfViewCardNode.aiDrawInfo;
            if (aIDrawInfo != null && (styleFunction = aIDrawInfo.styleFunction) != null) {
                Intrinsics.checkNotNullExpressionValue(styleFunction, "styleFunction");
                ArrayList<StyleList> styleList = styleFunction.getStyleList();
                Intrinsics.checkNotNullExpressionValue(styleList, "it.getStyleList()");
                Iterator<T> it6 = styleList.iterator();
                while (it6.hasNext()) {
                    ArrayList<StyleData> styleData = ((StyleList) it6.next()).getStyleData();
                    Intrinsics.checkNotNullExpressionValue(styleData, "styleList.getStyleData()");
                    for (StyleData styleData2 : styleData) {
                        String str = styleData2.styleName;
                        Intrinsics.checkNotNullExpressionValue(str, "data.styleName");
                        String str2 = styleData2.url;
                        Intrinsics.checkNotNullExpressionValue(str2, "data.url");
                        String str3 = styleData2.style;
                        Intrinsics.checkNotNullExpressionValue(str3, "data.style");
                        arrayList.add(new a44.StyleData(str, str2, str3));
                    }
                }
                String str4 = styleFunction.title;
                Intrinsics.checkNotNullExpressionValue(str4, "it.title");
                aVar.k(new a44.StyleFunction(str4, arrayList));
            }
            AIDrawInfo aIDrawInfo2 = halfViewCardNode.aiDrawInfo;
            if (aIDrawInfo2 != null && (requireFunction = aIDrawInfo2.requireFunction) != null) {
                Intrinsics.checkNotNullExpressionValue(requireFunction, "requireFunction");
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RequireList> requireList = requireFunction.getRequireList();
                Intrinsics.checkNotNullExpressionValue(requireList, "it.getRequireList()");
                for (RequireList requireList2 : requireList) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList<RequireData> arrayList4 = requireList2.requireData;
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "list.requireData");
                    for (RequireData requireData : arrayList4) {
                        String str5 = requireData.name;
                        Intrinsics.checkNotNullExpressionValue(str5, "data.name");
                        String str6 = requireData.url;
                        Intrinsics.checkNotNullExpressionValue(str6, "data.url");
                        String str7 = requireData.data;
                        Intrinsics.checkNotNullExpressionValue(str7, "data.data");
                        arrayList3.add(new a44.RequireData(str5, str6, str7));
                        it5 = it5;
                    }
                    String str8 = requireList2.buttonName;
                    Intrinsics.checkNotNullExpressionValue(str8, "list.buttonName");
                    String str9 = requireList2.type;
                    Intrinsics.checkNotNullExpressionValue(str9, "list.type");
                    arrayList2.add(new a44.RequireList(str8, str9, arrayList3));
                    it5 = it5;
                }
                it = it5;
                String str10 = requireFunction.title;
                Intrinsics.checkNotNullExpressionValue(str10, "it.title");
                aVar.i(new a44.RequireFunction(str10, arrayList2));
            } else {
                it = it5;
            }
            AIDrawInfo aIDrawInfo3 = halfViewCardNode.aiDrawInfo;
            if (aIDrawInfo3 != null && (reviseFunction = aIDrawInfo3.reviseFunction) != null) {
                Intrinsics.checkNotNullExpressionValue(reviseFunction, "reviseFunction");
                String str11 = reviseFunction.title;
                Intrinsics.checkNotNullExpressionValue(str11, "it.title");
                String str12 = reviseFunction.questionMarkUrl;
                Intrinsics.checkNotNullExpressionValue(str12, "it.questionMarkUrl");
                String str13 = reviseFunction.questionMarkMsg;
                Intrinsics.checkNotNullExpressionValue(str13, "it.questionMarkMsg");
                aVar.j(new a44.ReviseFunction(str11, str12, str13, reviseFunction.revise));
            }
            String data = halfViewCardNode.getData();
            Intrinsics.checkNotNullExpressionValue(data, "cardNode.getData()");
            aVar.h(data);
            it5 = it;
        }
        return aVar;
    }

    private final void y() {
        Job f16;
        QLog.i("RobotDrawDialogManager", 1, "showEmptyTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o h16 = h();
        if (!h16.r()) {
            h16.showDialog();
        }
        h16.c().a(SlashDialogMsgIntent.ShowEmptyState.f368547e);
    }

    private final void z() {
        Job f16;
        QLog.i("RobotDrawDialogManager", 1, "showFailedTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o h16 = h();
        if (!h16.r()) {
            h16.showDialog();
        }
        h16.c().a(SlashDialogMsgIntent.ShowFailedState.f368548e);
    }

    @Override // z34.a
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // z34.a
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

    @Override // z34.a
    public void onDestroy() {
        QLog.i("RobotDrawDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a.C11649a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            E(oVar.c());
            oVar.onDestroy();
        }
        Iterator<T> it = this.mMviMessageList.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().b((String) it.next(), this.mDialogAction);
        }
    }

    @Override // z34.a
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

    @Override // z34.a
    public void showDialog() {
        QLog.i("RobotDrawDialogManager", 1, "showDialog mState = " + this.mState);
        int i3 = this.mState;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        QLog.e("RobotDrawDialogManager", 1, "mActionState Error");
                        return;
                    } else {
                        C();
                        return;
                    }
                }
                y();
                return;
            }
            z();
            return;
        }
        B(this, false, 1, null);
        w();
    }
}
