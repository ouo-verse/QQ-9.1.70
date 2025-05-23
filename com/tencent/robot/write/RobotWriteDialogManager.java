package com.tencent.robot.write;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
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
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AIWriteInfo;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.ItemData;
import com.tencent.qqnt.kernel.nativeinterface.ItemList;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequireData;
import com.tencent.qqnt.kernel.nativeinterface.RequireList;
import com.tencent.robot.aio.input.RobotWriteMsgIntent;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import d74.a;
import e74.CallbackData;
import e74.RequireFunction;
import e74.f;
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
import m24.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0002be\u0018\u0000 \u001a2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010K\u001a\u00020I\u0012\u0006\u0010N\u001a\u00020L\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\"\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J8\u00100\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010+j\n\u0012\u0004\u0012\u00020/\u0018\u0001`-2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010+j\n\u0012\u0004\u0012\u00020,\u0018\u0001`-H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0002J\b\u00104\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u00102\u001a\u000205H\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u00102\u001a\u000207H\u0002J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020\u0002H\u0002J\u0010\u0010B\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020\u0002H\u0016J\b\u0010D\u001a\u00020\fH\u0016J\b\u0010E\u001a\u00020\fH\u0016J\u0010\u0010G\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\fH\u0016J\b\u0010H\u001a\u00020\u0002H\u0016R\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001c\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010^R\u001c\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010^R\u001c\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010^R\u0014\u0010d\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010cR\u0014\u0010g\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010f\u00a8\u0006j"}, d2 = {"Lcom/tencent/robot/write/RobotWriteDialogManager;", "Ld74/a;", "", "G", "g", "Lw64/o;", "i", "Lcom/tencent/robot/slash/businessapi/a;", "convertResult", "Le74/f;", "data", "H", "", "isDelay", "E", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", "w", "J", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "k", "intent", "Lcom/tencent/mvi/base/route/k;", "l", HippyTKDListViewAdapter.X, "success", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "j", "rsp", h.F, "B", "Lcom/tencent/qqnt/kernel/nativeinterface/ItemData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Le74/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Le74/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CallbackData;", "Lkotlin/collections/ArrayList;", "source", "Le74/a;", "y", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "p", "Lb74/a;", "itemData", "o", "Lb54/a;", "impArgs", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$UpdateRobotWriteData;", "v", "showDialog", "r", "a", "needAnim", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "c", "Lw64/o;", "mDialogProvider", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadingTipsJob", "", "e", "I", "mState", "f", "Le74/f;", "mData", "", "Ljava/util/List;", "mDialogMessageList", "mDialogMessageRList", "mMviMessageList", "com/tencent/robot/write/RobotWriteDialogManager$b", "Lcom/tencent/robot/write/RobotWriteDialogManager$b;", "mDialogAction", "com/tencent/robot/write/RobotWriteDialogManager$c", "Lcom/tencent/robot/write/RobotWriteDialogManager$c;", "mDialogActionR", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotWriteDialogManager implements d74.a {

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
    private f mData;

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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/write/RobotWriteDialogManager$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotWriteDialogManager.this.k(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/write/RobotWriteDialogManager$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return RobotWriteDialogManager.this.l(i3);
        }
    }

    public RobotWriteDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(RobotWriteMsgIntent.UpdateRobotWriteData.class).getQualifiedName()});
        this.mDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotWriteMsgIntent.GetAnchorViewMsgIntent.class).getQualifiedName());
        this.mDialogMessageRList = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(RobotWriteMsgIntent.GetBotWriteResponseMsgIntent.class).getQualifiedName());
        this.mMviMessageList = listOf3;
        this.mDialogAction = new b();
        this.mDialogActionR = new c();
        Iterator<T> it = listOf3.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().d((String) it.next(), this.mDialogAction);
        }
    }

    private final RequireFunction A(ItemData item) {
        ArrayList<com.tencent.qqnt.kernel.nativeinterface.RequireFunction> arrayList;
        boolean z16;
        com.tencent.qqnt.kernel.nativeinterface.RequireFunction requireFunction;
        if (item != null) {
            arrayList = item.getRequireFunction();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (requireFunction = arrayList.get(0)) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<RequireList> requireList = requireFunction.getRequireList();
        Intrinsics.checkNotNullExpressionValue(requireList, "function.getRequireList()");
        for (RequireList requireList2 : requireList) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList<RequireData> requireData = requireList2.getRequireData();
            Intrinsics.checkNotNullExpressionValue(requireData, "requireList.getRequireData()");
            for (RequireData requireData2 : requireData) {
                String str = requireData2.name;
                Intrinsics.checkNotNullExpressionValue(str, "data.name");
                String str2 = requireData2.url;
                Intrinsics.checkNotNullExpressionValue(str2, "data.url");
                String str3 = requireData2.data;
                Intrinsics.checkNotNullExpressionValue(str3, "data.data");
                String str4 = requireData2.templateInfo;
                Intrinsics.checkNotNullExpressionValue(str4, "data.templateInfo");
                arrayList3.add(new e74.RequireData(str, str2, str3, str4, y(requireData2.callbackData)));
            }
            String str5 = requireList2.buttonName;
            Intrinsics.checkNotNullExpressionValue(str5, "requireList.buttonName");
            String str6 = requireList2.type;
            Intrinsics.checkNotNullExpressionValue(str6, "requireList.type");
            arrayList2.add(new e74.RequireList(str5, str6, arrayList3));
        }
        String str7 = requireFunction.title;
        Intrinsics.checkNotNullExpressionValue(str7, "function.title");
        return new RequireFunction(str7, arrayList2);
    }

    private final f B(QueryHalfViewDataRsp rsp) {
        boolean z16;
        String str;
        ArrayList<ItemList> itemList;
        f fVar = new f(null, null, null, 7, null);
        ArrayList<HalfViewCardNode> nodes = rsp.cardNodes;
        if (nodes != null && !nodes.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return fVar;
        }
        Intrinsics.checkNotNullExpressionValue(nodes, "nodes");
        for (HalfViewCardNode halfViewCardNode : nodes) {
            AIWriteInfo aIWriteInfo = halfViewCardNode.getAIWriteInfo();
            ItemData itemData = null;
            if (aIWriteInfo != null) {
                str = aIWriteInfo.title;
            } else {
                str = null;
            }
            fVar.i(str);
            ArrayList arrayList = new ArrayList();
            AIWriteInfo aIWriteInfo2 = halfViewCardNode.getAIWriteInfo();
            if (aIWriteInfo2 != null && (itemList = aIWriteInfo2.itemList) != null) {
                Intrinsics.checkNotNullExpressionValue(itemList, "itemList");
                Iterator<T> it = itemList.iterator();
                while (it.hasNext()) {
                    ArrayList<ItemData> itemDatas = ((ItemList) it.next()).getItemDatas();
                    Intrinsics.checkNotNullExpressionValue(itemDatas, "list.getItemDatas()");
                    Iterator<T> it5 = itemDatas.iterator();
                    while (it5.hasNext()) {
                        e74.ItemData z17 = z((ItemData) it5.next());
                        if (z17 != null) {
                            arrayList.add(z17);
                        }
                    }
                }
            }
            fVar.h(arrayList);
            AIWriteInfo aIWriteInfo3 = halfViewCardNode.getAIWriteInfo();
            if (aIWriteInfo3 != null) {
                itemData = aIWriteInfo3.defaultData;
            }
            fVar.g(z(itemData));
        }
        return fVar;
    }

    private final void C() {
        Job f16;
        QLog.i("RobotWriteDialogManager", 1, "showEmptyTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o i3 = i();
        if (!i3.r()) {
            i3.showDialog();
        }
        i3.c().a(SlashDialogMsgIntent.ShowEmptyState.f368547e);
    }

    private final void D() {
        Job f16;
        QLog.i("RobotWriteDialogManager", 1, "showFailedTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o i3 = i();
        if (!i3.r()) {
            i3.showDialog();
        }
        i3.c().a(SlashDialogMsgIntent.ShowFailedState.f368548e);
    }

    private final void E(boolean isDelay) {
        Job f16;
        QLog.i("RobotWriteDialogManager", 1, "showLoadingTipDialog");
        if (isDelay) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner d16 = this.mMviContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
            Boolean bool = Boolean.TRUE;
            this.mLoadingTipsJob = CorountineFunKt.e(lifecycleScope, "RobotWriteDialogManagershowLoadingTipDialog", bool, null, bool, new RobotWriteDialogManager$showLoadingTipDialog$1(this, null), 4, null);
            return;
        }
        o i3 = i();
        if (!i3.r()) {
            i3.showDialog();
        }
        i3.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
    }

    static /* synthetic */ void F(RobotWriteDialogManager robotWriteDialogManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        robotWriteDialogManager.E(z16);
    }

    private final void G() {
        com.tencent.robot.slash.businessapi.a j3 = this.mBusinessDelegate.j(this.mData, "");
        QLog.i("RobotWriteDialogManager", 1, "showSuccessDialog");
        f fVar = this.mData;
        if (fVar != null && j3 != null) {
            H(j3, fVar);
        } else {
            a.C10165a.a(this, false, 1, null);
        }
    }

    private final void H(com.tencent.robot.slash.businessapi.a convertResult, f data) {
        List listOf;
        Job f16;
        QLog.i("RobotWriteDialogManager", 1, "submitList start");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        final o i3 = i();
        i3.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        i3.c().a(new RobotWriteMsgIntent.SubmitListMsgIntent(data));
        if (convertResult != null) {
            i3.c().a(new CommonListMsgIntent.SubmitListMsgIntent(convertResult.b(), convertResult.getCom.tencent.mobileqq.webview.constants.QQBrowserActivityConstants.KEY_TITLE_STYLE java.lang.String(), new Runnable() { // from class: com.tencent.robot.write.b
                @Override // java.lang.Runnable
                public final void run() {
                    RobotWriteDialogManager.I(o.this);
                }
            }, null, 8, null));
        }
        if (i3.r()) {
            com.tencent.input.base.launch.b c16 = i3.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
            return;
        }
        i3.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(o this_with) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.c().a(new SlashListCouplingEffectMsgIntent.ScrollToPosition(0));
    }

    private final void J(com.tencent.input.base.launch.b dialogExternalProvider) {
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

    private final void g() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        w(a16.c());
        this.mDialogProvider = a16;
    }

    private final void h(QueryHalfViewDataRsp rsp) {
        this.mState = 4;
        this.mData = B(rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o i() {
        if (this.mDialogProvider == null) {
            g();
        }
        o oVar = this.mDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    private final void j(boolean success, String errMsg, QueryHalfViewDataRsp response) {
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
            h(response);
            QLog.i("RobotWriteDialogManager", 1, "[handleBotResponse]: data empty=" + arrayList.isEmpty() + " isShowing=" + r16);
        } else {
            QLog.e("RobotWriteDialogManager", 1, "[handleBotResponse]: failed success=" + success + ", errMsg=" + errMsg + " isShowing=" + r16);
            this.mState = 2;
        }
        if (r16) {
            showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mDialogProvider;
            if (oVar != null) {
                o.a.a(oVar, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            s();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            o(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.RetryRequestMsgIntent) {
            t();
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            q((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            p((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            a.C10165a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            n(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            m(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            u((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
            return;
        }
        if (event instanceof RobotWriteMsgIntent.GetBotWriteResponseMsgIntent) {
            RobotWriteMsgIntent.GetBotWriteResponseMsgIntent getBotWriteResponseMsgIntent = (RobotWriteMsgIntent.GetBotWriteResponseMsgIntent) event;
            j(getBotWriteResponseMsgIntent.getSuccess(), getBotWriteResponseMsgIntent.getErrMsg(), getBotWriteResponseMsgIntent.getResponse());
        } else if (event instanceof RobotWriteMsgIntent.UpdateRobotWriteData) {
            v((RobotWriteMsgIntent.UpdateRobotWriteData) event);
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k l(MsgIntent intent) {
        if (intent instanceof RobotWriteMsgIntent.GetAnchorViewMsgIntent) {
            return new b.GeAnchorViewMsgResult(this.mBusinessDelegate.getMAnchorView());
        }
        return new j54.a();
    }

    private final void m(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void n(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void o(b74.a itemData) {
        QLog.i("RobotWriteDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, "");
        a.C10165a.a(this, false, 1, null);
    }

    private final void p(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new RobotWriteMsgIntent.SubmitListMsgIntent(null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
        this.mState = 0;
        this.mData = null;
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, true);
    }

    private final void q(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
        com.tencent.robot.aio.bottombar.a.b(this.mMviContext, false);
        com.tencent.robot.aio.bottombar.a.a("robotWrite", this.mMviContext);
    }

    private final void s() {
        if (this.mState != 4 || this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotWriteDialogManager", false));
    }

    private final void t() {
        QLog.i("RobotWriteDialogManager", 1, "handleRetryClickMsgIntent");
        F(this, false, 1, null);
        x();
    }

    private final void u(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        a.C10165a.a(this, false, 1, null);
    }

    private final void v(RobotWriteMsgIntent.UpdateRobotWriteData intent) {
        this.mMviContext.e().h(new InputEditTextMsgIntent.UpdateRobotWriteData(intent.getType(), intent.c(), intent.getPlaceHolder(), intent.a()));
    }

    private final void w(com.tencent.input.base.launch.b dialogExternalProvider) {
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

    private final void x() {
        QLog.i("RobotWriteDialogManager", 1, "requestWriteData");
        this.mMviContext.e().h(RobotWriteMsgIntent.RequestBotWriteMsgIntent.f367163d);
        this.mState = 1;
    }

    private final ArrayList<CallbackData> y(ArrayList<com.tencent.qqnt.kernel.nativeinterface.CallbackData> source) {
        boolean z16;
        if (source != null && !source.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        ArrayList<CallbackData> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.kernel.nativeinterface.CallbackData callbackData : source) {
            String key = callbackData.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "data.getKey()");
            String value = callbackData.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "data.getValue()");
            arrayList.add(new CallbackData(key, value));
        }
        return arrayList;
    }

    private final e74.ItemData z(ItemData item) {
        if (item == null) {
            return null;
        }
        RequireFunction A = A(item);
        ArrayList<CallbackData> y16 = y(item.getCallbackData());
        String name = item.getName();
        Intrinsics.checkNotNullExpressionValue(name, "item.getName()");
        String templateInfo = item.getTemplateInfo();
        Intrinsics.checkNotNullExpressionValue(templateInfo, "item.getTemplateInfo()");
        String placeHolder = item.getPlaceHolder();
        Intrinsics.checkNotNullExpressionValue(placeHolder, "item.getPlaceHolder()");
        return new e74.ItemData(name, templateInfo, placeHolder, A, y16);
    }

    @Override // d74.a
    public boolean a() {
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // d74.a
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

    @Override // d74.a
    public void onDestroy() {
        QLog.i("RobotWriteDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a.C10165a.a(this, false, 1, null);
        o oVar = this.mDialogProvider;
        if (oVar != null) {
            J(oVar.c());
            oVar.onDestroy();
        }
        Iterator<T> it = this.mMviMessageList.iterator();
        while (it.hasNext()) {
            this.mMviContext.e().b((String) it.next(), this.mDialogAction);
        }
    }

    @Override // d74.a
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

    @Override // d74.a
    public void showDialog() {
        QLog.i("RobotWriteDialogManager", 1, "showDialog mState = " + this.mState);
        int i3 = this.mState;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        QLog.e("RobotWriteDialogManager", 1, "mActionState Error");
                        return;
                    } else {
                        G();
                        return;
                    }
                }
                C();
                return;
            }
            D();
            return;
        }
        F(this, false, 1, null);
        x();
    }
}
