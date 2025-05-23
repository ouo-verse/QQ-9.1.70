package com.tencent.robot.search;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.robot.aio.input.RobotSearchMsgIntent;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import f54.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001L\u0018\u0000 \u00152\u00020\u0001:\u00011B\u0017\u0012\u0006\u00107\u001a\u000205\u0012\u0006\u0010:\u001a\u000208\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010 \u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\u0002H\u0016R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010HR\u001c\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010HR\u001c\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010HR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010M\u00a8\u0006Q"}, d2 = {"Lcom/tencent/robot/search/RobotSearchDialogManager;", "Lf54/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "f", "Lw64/o;", h.F, "Lcom/tencent/robot/slash/businessapi/a;", "convertResult", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isDelay", HippyTKDListViewAdapter.X, "v", "w", "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", "t", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "j", "u", "success", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "i", "rsp", "g", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", ReportConstant.COSTREPORT_PREFIX, "p", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "o", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", DomainData.DOMAIN_NAME, "Lb74/a;", "itemData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb54/a;", "impArgs", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "showDialog", "r", "a", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "c", "Lw64/o;", "mDialogProvider", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadingTipsJob", "", "e", "I", "mState", "", "Lc64/b;", "Ljava/util/List;", "mCardList", "mDialogMessageList", "mMviMessageList", "com/tencent/robot/search/RobotSearchDialogManager$b", "Lcom/tencent/robot/search/RobotSearchDialogManager$b;", "mDialogAction", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSearchDialogManager implements f54.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mMviContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mBusinessDelegate;

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
    private List<c64.b> mCardList;

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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/search/RobotSearchDialogManager$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotSearchDialogManager.this.j(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public RobotSearchDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRightClickMsgIntent.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotSearchMsgIntent.GetBotSearchResponseMsgIntent.class).getQualifiedName());
        this.mMviMessageList = listOf2;
        this.mDialogAction = new b();
        Iterator<T> it = listOf2.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().d((String) it.next(), this.mDialogAction);
        }
    }

    private final void A(com.tencent.robot.slash.businessapi.a convertResult) {
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
        QLog.i("RobotSearchDialogManager", 1, "submitList itemList size = " + size + " avatarItemList size = " + num);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        final o h16 = h();
        h16.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        h16.c().a(new CommonListMsgIntent.SubmitListMsgIntent(convertResult.b(), convertResult.getCom.tencent.mobileqq.webview.constants.QQBrowserActivityConstants.KEY_TITLE_STYLE java.lang.String(), new Runnable() { // from class: com.tencent.robot.search.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotSearchDialogManager.B(o.this);
            }
        }, null, 8, null));
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
    public static final void B(o this_with) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.c().a(new SlashListCouplingEffectMsgIntent.ScrollToPosition(0));
    }

    private final void C(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.c(str, this.mDialogAction);
            }
        }
    }

    private final void f() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        t(a16.c());
        this.mDialogProvider = a16;
    }

    private final void g(QueryHalfViewDataRsp rsp) {
        int collectionSizeOrDefault;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ArrayList<HalfViewCardNode> arrayList2 = rsp.cardNodes;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.cardNodes");
        ArrayList<HalfViewCardNode> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((HalfViewCardNode) obj).searchInfo != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (HalfViewCardNode halfViewCardNode : arrayList3) {
            String searchTitle = halfViewCardNode.searchInfo.title;
            Intrinsics.checkNotNullExpressionValue(searchTitle, "searchTitle");
            String data = halfViewCardNode.getData();
            Intrinsics.checkNotNullExpressionValue(data, "card.getData()");
            arrayList4.add(new c64.b(searchTitle, data));
        }
        this.mState = 4;
        arrayList.addAll(arrayList4);
        this.mCardList = arrayList;
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
        List<c64.b> emptyList;
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
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.mCardList = emptyList;
                return;
            }
            g(response);
            QLog.i("RobotSearchDialogManager", 1, "[handleBotSearchResponse]: data empty=" + arrayList.isEmpty() + " isShowing=" + r16);
        } else {
            QLog.e("RobotSearchDialogManager", 1, "[handleBotSearchResponse]: failed success=" + success + ", errMsg=" + errMsg + " isShowing=" + r16);
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
            p();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            m(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.RetryRequestMsgIntent) {
            q();
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            o((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            n((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            a.C10281a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            l(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            k(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            s((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
            return;
        }
        if (event instanceof RobotSearchMsgIntent.GetBotSearchResponseMsgIntent) {
            RobotSearchMsgIntent.GetBotSearchResponseMsgIntent getBotSearchResponseMsgIntent = (RobotSearchMsgIntent.GetBotSearchResponseMsgIntent) event;
            i(getBotSearchResponseMsgIntent.getSuccess(), getBotSearchResponseMsgIntent.getErrMsg(), getBotSearchResponseMsgIntent.getResponse());
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        } else if (event instanceof SlashTitleMsgIntent.OnTitleRightClickMsgIntent) {
            this.mMviContext.e().h(RobotSearchMsgIntent.RefreshBotSearchMsgIntent.f367156d);
        }
    }

    private final void k(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void l(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void m(b74.a itemData) {
        QLog.i("RobotSearchDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, "");
        a.C10281a.a(this, false, 1, null);
    }

    private final void n(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new CommonListMsgIntent.SubmitListMsgIntent(new ArrayList(), 0, null, null, 14, null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
        this.mState = 0;
        this.mCardList = null;
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, true);
    }

    private final void o(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, false);
        com.tencent.robot.aio.bottombar.a.a("robotSearch", this.mMviContext);
    }

    private final void p() {
        if (this.mState != 4 || this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotSearchDialogManager", false));
    }

    private final void q() {
        QLog.i("RobotSearchDialogManager", 1, "handleRetryClickMsgIntent");
        y(this, false, 1, null);
        u();
    }

    private final void s(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        a.C10281a.a(this, false, 1, null);
    }

    private final void t(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
    }

    private final void u() {
        QLog.i("RobotSearchDialogManager", 1, "requestSearchData");
        this.mMviContext.e().h(RobotSearchMsgIntent.RequestBotSearchMsgIntent.f367157d);
        this.mState = 1;
    }

    private final void v() {
        Job f16;
        QLog.i("RobotSearchDialogManager", 1, "showEmptyTipDialog");
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

    private final void w() {
        Job f16;
        QLog.i("RobotSearchDialogManager", 1, "showFailedTipDialog");
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

    private final void x(boolean isDelay) {
        Job f16;
        QLog.i("RobotSearchDialogManager", 1, "showLoadingTipDialog");
        if (isDelay) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner d16 = this.mMviContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
            Boolean bool = Boolean.TRUE;
            this.mLoadingTipsJob = CorountineFunKt.e(lifecycleScope, "RobotSearchDialogManagershowLoadingTipDialog", bool, null, bool, new RobotSearchDialogManager$showLoadingTipDialog$1(this, null), 4, null);
            return;
        }
        o h16 = h();
        if (!h16.r()) {
            h16.showDialog();
        }
        h16.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
    }

    static /* synthetic */ void y(RobotSearchDialogManager robotSearchDialogManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        robotSearchDialogManager.x(z16);
    }

    private final void z() {
        Integer num;
        List<b74.a> b16;
        com.tencent.robot.slash.businessapi.a j3 = this.mBusinessDelegate.j(this.mCardList, "");
        if (j3 != null && (b16 = j3.b()) != null) {
            num = Integer.valueOf(b16.size());
        } else {
            num = null;
        }
        QLog.i("RobotSearchDialogManager", 1, "showSuccessDialog itemList size = " + num);
        if (j3 != null && !j3.b().isEmpty()) {
            A(j3);
        } else {
            a.C10281a.a(this, false, 1, null);
        }
    }

    @Override // f54.a
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // f54.a
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

    @Override // f54.a
    public void onDestroy() {
        QLog.i("RobotSearchDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a.C10281a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            C(oVar.c());
            oVar.onDestroy();
        }
        Iterator<T> it = this.mMviMessageList.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().b((String) it.next(), this.mDialogAction);
        }
    }

    @Override // f54.a
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

    @Override // f54.a
    public void showDialog() {
        QLog.i("RobotSearchDialogManager", 1, "showDialog mState = " + this.mState);
        int i3 = this.mState;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        QLog.e("RobotSearchDialogManager", 1, "mActionState Error");
                        return;
                    } else {
                        z();
                        return;
                    }
                }
                v();
                return;
            }
            w();
            return;
        }
        y(this, false, 1, null);
        u();
    }
}
