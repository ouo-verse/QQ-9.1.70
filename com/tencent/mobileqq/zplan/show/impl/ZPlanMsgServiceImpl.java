package com.tencent.mobileqq.zplan.show.impl;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.mobileqq.zplan.show.MsgData;
import com.tencent.mobileqq.zplan.show.MsgType;
import com.tencent.mobileqq.zplan.show.g;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0017H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/show/impl/ZPlanMsgServiceImpl;", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "", "registerMsgReceive", "registerInputStatus", "", "isC2C", "", "Lcom/tencent/qqnt/msg/d;", TabPreloadItem.TAB_NAME_MESSAGE, "onMsgReceive", "msg", "Lcom/tencent/mobileqq/zplan/show/b;", "convertRecordToType", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "init", "Lcom/tencent/mobileqq/zplan/show/a;", "listener", "addListener", "clearListener", "", "friendUin", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService$b;", "sendActionMsg", "", "listenerList", "Ljava/util/List;", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMsgServiceImpl implements IZPlanMsgService {
    public static final String TAG = "ZPlanMsgReceiveService";
    private WeakReference<AIOParam> aioParam;
    private final List<com.tencent.mobileqq.zplan.show.a> listenerList = new ArrayList();

    private final MsgData convertRecordToType(d msg2) {
        MsgType msgType;
        String str;
        if (a.e(msg2)) {
            msgType = MsgType.MSG_TEXT;
        } else if (a.g(msg2)) {
            msgType = MsgType.MSG_VOICE;
        } else if (a.d(msg2)) {
            msgType = MsgType.MSG_RED_ENVELOPE;
        } else if (a.c(msg2)) {
            msgType = MsgType.MSG_GIFT;
        } else if (a.b(msg2)) {
            msgType = MsgType.MSG_FILE;
        } else if (a.f(msg2)) {
            msgType = MsgType.MSG_TRANSFER;
        } else {
            msgType = MsgType.MSG_COMMON;
        }
        if (msgType == MsgType.MSG_TEXT) {
            str = a.a(msg2);
        } else {
            str = "";
        }
        return new MsgData(msgType, str);
    }

    private final boolean isC2C() {
        AIOParam aIOParam;
        WeakReference<AIOParam> weakReference = this.aioParam;
        return (weakReference == null || (aIOParam = weakReference.get()) == null || aIOParam.r().c().e() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMsgReceive(List<? extends d> msgList) {
        AIOParam aIOParam;
        AIOSession r16;
        AIOContact c16;
        for (d dVar : msgList) {
            if (dVar.a().chatType == 1) {
                WeakReference<AIOParam> weakReference = this.aioParam;
                if (Intrinsics.areEqual((weakReference == null || (aIOParam = weakReference.get()) == null || (r16 = aIOParam.r()) == null || (c16 = r16.c()) == null) ? null : c16.j(), dVar.a().senderUid)) {
                    Iterator<com.tencent.mobileqq.zplan.show.a> it = this.listenerList.iterator();
                    while (it.hasNext()) {
                        it.next().a(convertRecordToType(dVar));
                    }
                }
            }
        }
    }

    private final void registerInputStatus() {
        if (isC2C()) {
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).getOnInputStatusPush(), new ZPlanMsgServiceImpl$registerInputStatus$1(this, null)), Dispatchers.getIO()), CoroutineScopeKt.MainScope());
        }
    }

    private final void registerMsgReceive() {
        if (isC2C()) {
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new ZPlanMsgServiceImpl$registerMsgReceive$1(this, null)), Dispatchers.getIO()), CoroutineScopeKt.MainScope());
        }
    }

    @Override // com.tencent.mobileqq.zplan.show.IZPlanMsgService
    public void addListener(com.tencent.mobileqq.zplan.show.a listener) {
        Object obj;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<T> it = this.listenerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual((com.tencent.mobileqq.zplan.show.a) obj, listener)) {
                    break;
                }
            }
        }
        if (((com.tencent.mobileqq.zplan.show.a) obj) == null) {
            this.listenerList.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.zplan.show.IZPlanMsgService
    public void clearListener(com.tencent.mobileqq.zplan.show.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerList.remove(listener);
    }

    @Override // com.tencent.mobileqq.zplan.show.IZPlanMsgService
    public void init(AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        this.aioParam = new WeakReference<>(aioParam);
        registerMsgReceive();
        registerInputStatus();
    }

    @Override // com.tencent.mobileqq.zplan.show.IZPlanMsgService
    public void sendActionMsg(String friendUin, IZPlanMsgService.ZPlanActionMsg msg2) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        g.f335631a.f(friendUin, msg2);
    }
}
