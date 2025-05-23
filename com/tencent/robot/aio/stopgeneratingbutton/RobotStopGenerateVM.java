package com.tencent.robot.aio.stopgeneratingbutton;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateUIState;
import com.tencent.robot.aio.stopgeneratingbutton.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007*\u0001\u001c\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c0!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$BottomLayoutHeightChange;", "intent", "w", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", ReportConstant.COSTREPORT_PREFIX, "u", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "msg", BdhLogUtil.LogTag.Tag_Conn, "y", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateVM$b", "e", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateVM$b;", "mAction", "", "Lkotlin/Pair;", "", "f", "Ljava/util/List;", "mMessageList", "Lkotlinx/coroutines/Job;", h.F, "Lkotlinx/coroutines/Job;", "delayedShowButtonJob", "Z", "buttonVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isFirstScreenShown", "", "J", "curJobMsgId", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStopGenerateVM extends com.tencent.qqnt.aio.baseVM.a<a, RobotStopGenerateUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private long curJobMsgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job delayedShowButtonJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean buttonVisible;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstScreenShown;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotStopGenerateVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public RobotStopGenerateVM() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.AIOMsgListUpdateEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.BottomLayoutHeightChange.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnFirstScreenShow.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A(AIOMsgItem msg2) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (msg2 == 0 || B()) {
            return false;
        }
        if (msg2 instanceof i) {
            z16 = ((i) msg2).g();
        } else {
            z16 = false;
        }
        HashMap<Integer, InlineKeyboardButton> b16 = com.tencent.qqnt.aio.msg.d.b(msg2, "");
        if (b16 != null && b16.containsKey(4)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (com.tencent.qqnt.aio.msg.d.g(msg2) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 || !z17 || !z18) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B() {
        com.tencent.mvi.base.route.j e16;
        MultiSelectEvent.GetSelectMode getSelectMode = new MultiSelectEvent.GetSelectMode(false, 1, null);
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(getSelectMode);
        }
        return getSelectMode.a();
    }

    private final void C(AIOMsgItem msg2) {
        Job launch$default;
        if (msg2 != null) {
            boolean z16 = true;
            if (!this.buttonVisible) {
                if (msg2.getMsgRecord().msgId == this.curJobMsgId) {
                    Job job = this.delayedShowButtonJob;
                    if (job == null || !job.isActive()) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                }
                r();
                this.curJobMsgId = msg2.getMsgRecord().msgId;
                launch$default = BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new RobotStopGenerateVM$tryShowButton$1(this, null), 3, null);
                launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateVM$tryShowButton$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th5) {
                        QLog.i("RobotStopGenerateVM", 1, "[tryShowButton]: delay task ended");
                        RobotStopGenerateVM.this.curJobMsgId = 0L;
                    }
                });
                this.delayedShowButtonJob = launch$default;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof AIOMsgListEvent.OnFirstScreenShow) {
            z();
            return;
        }
        if (i3 instanceof AIOMsgListEvent.AIOMsgListUpdateEvent) {
            x();
            return;
        }
        if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            if (((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b()) {
                y();
            }
        } else if (i3 instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
            w((AIOMsgListEvent.BottomLayoutHeightChange) i3);
        }
    }

    private final void r() {
        Job job = this.delayedShowButtonJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.delayedShowButtonJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AIOMsgItem s() {
        k kVar;
        e.b bVar;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            kVar = e16.k(RobotMsgIntent.GetLatestRobotMsg.f188688d);
        } else {
            kVar = null;
        }
        if (kVar instanceof e.b) {
            bVar = (e.b) kVar;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        final MsgRecord msgRecord;
        com.tencent.mvi.base.route.j e16;
        AIOMsgItem s16 = s();
        if (s16 != null) {
            msgRecord = s16.getMsgRecord();
        } else {
            msgRecord = null;
        }
        if (msgRecord == null) {
            QLog.e("RobotStopGenerateVM", 1, "[stopGenerate]: msgRecord is null");
            return;
        }
        QLog.i("RobotStopGenerateVM", 1, "[stopGenerate]: seq=" + msgRecord.getMsgSeq() + " msgId=" + msgRecord.getMsgId() + " status=" + com.tencent.qqnt.aio.msg.d.h(msgRecord));
        if (com.tencent.qqnt.aio.msg.d.h(msgRecord) == 1) {
            ((IMsgService) QRoute.api(IMsgService.class)).stopGenerateMsg(new Contact(msgRecord.chatType, msgRecord.peerUid, ""), msgRecord.msgId, new IOperateCallback() { // from class: com.tencent.robot.aio.stopgeneratingbutton.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotStopGenerateVM.v(RobotStopGenerateVM.this, msgRecord, i3, str);
                }
            });
            return;
        }
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new StreamMsgEvent.EndStreamAnim(msgRecord.getMsgId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(RobotStopGenerateVM this$0, MsgRecord msgRecord, int i3, String str) {
        boolean z16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStopGenerateVM", 1, "[stopGenerate]: result is " + i3 + ", errMsg is " + str);
        if (i3 == 0) {
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) this$0.getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new StreamMsgEvent.EndStreamAnim(msgRecord.getMsgId()));
                return;
            }
            return;
        }
        if (861700 <= i3 && i3 < 861800) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
        }
    }

    private final void w(AIOMsgListEvent.BottomLayoutHeightChange intent) {
        updateUI(new RobotStopGenerateUIState.ButtonBottomMargin(intent.a()));
    }

    private final void x() {
        if (!this.isFirstScreenShown) {
            return;
        }
        AIOMsgItem s16 = s();
        if (A(s16)) {
            C(s16);
        } else {
            y();
        }
    }

    private final void y() {
        r();
        if (!this.buttonVisible) {
            return;
        }
        this.buttonVisible = false;
        updateUI(new RobotStopGenerateUIState.ButtonVisible(false));
        QLog.i("RobotStopGenerateVM", 1, "[hideButton]: hide button");
    }

    private final void z() {
        r();
        AIOMsgItem s16 = s();
        if (s16 == null) {
            this.buttonVisible = false;
            updateUI(new RobotStopGenerateUIState.ButtonVisible(false));
            this.isFirstScreenShown = true;
        } else {
            if (A(s16)) {
                QLog.i("RobotStopGenerateVM", 1, "[initButtonVisible]: need show button");
                this.buttonVisible = true;
                updateUI(new RobotStopGenerateUIState.ButtonVisible(true));
            } else {
                y();
            }
            this.isFirstScreenShown = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        super.onDestroy();
        r();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C9769a) {
            u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
    }
}
