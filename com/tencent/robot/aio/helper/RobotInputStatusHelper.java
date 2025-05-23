package com.tencent.robot.aio.helper;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotInputStatusHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "", "j", "", ViewStickEventHelper.IS_SHOW, "finalStatusText", "p", DomainData.DOMAIN_NAME, "", "Lcom/tencent/qqnt/msg/d;", TabPreloadItem.TAB_NAME_MESSAGE, "k", "i", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Z", "mIsShowingInputStatus", "", "f", "J", "mTimeStamp", "<init>", "()V", tl.h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotInputStatusHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowingInputStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mTimeStamp;

    private final void i() {
        this.mIsShowingInputStatus = false;
        p(false, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(InputStatusInfo inputStatusInfo) {
        String statusText;
        if (TextUtils.isEmpty(inputStatusInfo.statusText)) {
            if (inputStatusInfo.eventType == 1) {
                statusText = HardCodeUtil.qqStr(R.string.f222176ct);
            } else {
                statusText = "";
            }
        } else {
            statusText = inputStatusInfo.statusText;
        }
        Intrinsics.checkNotNullExpressionValue(statusText, "statusText");
        return statusText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(List<? extends com.tencent.qqnt.msg.d> msgList) {
        Object last;
        List listOf;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        ArrayList arrayList = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : msgList) {
            if (TextUtils.equals(((com.tencent.qqnt.msg.d) obj).a().peerUid, j3)) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            long j16 = ((com.tencent.qqnt.msg.d) last).a().msgTime;
            int size = arrayList.size();
            listOf = CollectionsKt__CollectionsJVMKt.listOf("markdownElement");
            QLog.d("RobotInputStatusHelper", 1, "handlerRecMsg " + size + ", " + com.tencent.util.k.f(arrayList, listOf) + ", msgTime: " + j16 + ", mTimeStamp: " + this.mTimeStamp);
            if (j16 >= this.mTimeStamp && this.mIsShowingInputStatus) {
                QLog.d("RobotInputStatusHelper", 1, "handlerRecMsg, clearInputStatusAfterMessageArrived");
                i();
            }
        }
    }

    private final void m() {
        QLog.d("RobotInputStatusHelper", 1, "listenerInputStatus");
        com.tencent.aio.api.runtime.a aVar = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).getOnInputStatusPush(), new RobotInputStatusHelper$listenerInputStatus$1(this, null)), Dispatchers.getIO());
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mAIOContext.lifecycleOwner.lifecycle");
        FlowKt.launchIn(flowOn, LifecycleKt.getCoroutineScope(lifecycle));
    }

    private final void n() {
        QLog.d("RobotInputStatusHelper", 1, "listenerMsgRecInputStatus receiveMsgCallBack");
        com.tencent.aio.api.runtime.a aVar = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new RobotInputStatusHelper$listenerMsgRecInputStatus$1(this, null)), zs.b.a(Dispatchers.INSTANCE));
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mAIOContext.lifecycleOwner.lifecycle");
        FlowKt.launchIn(flowOn, LifecycleKt.getCoroutineScope(lifecycle));
    }

    private final void o() {
        this.mIsShowingInputStatus = false;
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean isShow, String finalStatusText) {
        this.mIsShowingInputStatus = isShow;
        com.tencent.aio.api.runtime.a aVar = null;
        if (isShow) {
            ai aiVar = new ai(null, null, null, finalStatusText, "4");
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new AIOTitleEvent.SubTitleResponseEvent(aiVar));
        } else {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(new AIOTitleEvent.SubTitleRequestEvent(0));
        }
        QLog.d("RobotInputStatusHelper", 1, "showInputStatus, isShow:" + isShow + ", subTitleData:" + Unit.INSTANCE);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.I0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotInputStatusHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mAIOContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        this.mIsShowingInputStatus = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            o();
        }
    }
}
