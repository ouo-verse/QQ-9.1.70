package com.tencent.mobileqq.aio.robot.msgrepo;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.d;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.AdelieRecommendedMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/msgrepo/RobotReportAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "t", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "v", "msgItem", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "aioMsgService", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lj81/a;", "i", "Lj81/a;", DownloadInfo.spKey_Config, "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotReportAbility extends g<AIOMsgRepo> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j81.a config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotReportAbility(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        j81.a aVar = new j81.a();
        aVar.c(FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("105450", ""));
        this.config = aVar;
    }

    private final boolean r() {
        int simpleUpperLimitCount = this.config.getSimpleUpperLimitCount();
        if (simpleUpperLimitCount <= 0 || Random.INSTANCE.nextInt(0, simpleUpperLimitCount) != 0) {
            return false;
        }
        return true;
    }

    private final boolean s() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("105450", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = d().g().r().c().j();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
            if (Intrinsics.areEqual(aIOMsgItem.getMsgRecord().peerUid, j3) && aIOMsgItem.getMsgRecord().msgType != 1 && d.L(aIOMsgItem)) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            for (final com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.msgrepo.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        RobotReportAbility.u(RobotReportAbility.this, aVar2);
                    }
                }, 16, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(RobotReportAbility this$0, com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.x((AIOMsgItem) msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(List<? extends AIOMsgItem> msgList) {
        String j3 = d().g().r().c().j();
        ArrayList<AIOMsgItem> arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AIOMsgItem aIOMsgItem = (AIOMsgItem) next;
            if (!Intrinsics.areEqual(aIOMsgItem.getMsgRecord().peerUid, j3) || !d.L(aIOMsgItem)) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            for (final AIOMsgItem aIOMsgItem2 : arrayList) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.msgrepo.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        RobotReportAbility.w(RobotReportAbility.this, aIOMsgItem2);
                    }
                }, 16, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RobotReportAbility this$0, AIOMsgItem msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.x(msg2);
    }

    private final void x(AIOMsgItem msgItem) {
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        if (!r()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bot_uin", String.valueOf(msgItem.getMsgRecord().peerUin));
        hashMap.put("push_status", String.valueOf(d.g(msgItem)));
        AdelieRecommendedMsgElement e16 = d.e(msgItem);
        int i17 = 0;
        if (e16 != null) {
            i3 = d.f(e16);
        } else {
            i3 = 0;
        }
        hashMap.put("recommend_count", String.valueOf(i3));
        if (msgItem instanceof MarkdownMsgItem) {
            ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    if (((MsgElement) it.next()).elementType == 14) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && (i18 = i18 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
                i17 = i18;
            }
            hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, "1");
            hashMap.put("slice_count", String.valueOf(i17));
            MarkdownMsgItem markdownMsgItem = (MarkdownMsgItem) msgItem;
            hashMap.put("char_count", String.valueOf(markdownMsgItem.r2().content.length()));
            hashMap.put("regenerate_count", String.valueOf(markdownMsgItem.s2()));
        } else if (msgItem instanceof ae) {
            ArrayList<MsgElement> arrayList2 = msgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.elements");
            if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                i16 = 0;
            } else {
                Iterator<T> it5 = arrayList2.iterator();
                i16 = 0;
                while (it5.hasNext()) {
                    int i19 = ((MsgElement) it5.next()).elementType;
                    if (i19 != 1 && i19 != 6) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16 && (i16 = i16 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, "2");
            hashMap.put("slice_count", String.valueOf(i16));
            ae aeVar = (ae) msgItem;
            CharSequence u26 = aeVar.u2();
            if (u26 != null) {
                i17 = u26.length();
            }
            hashMap.put("char_count", String.valueOf(i17));
            hashMap.put("regenerate_count", String.valueOf(aeVar.t2()));
        }
        v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "aio_stream_msg_end", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotReportAbility", 4, "reportStreamEnd uin=" + msgItem.getMsgRecord().peerUin + " pushStatus=" + d.g(msgItem));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void m(@NotNull AIOMsgServiceWithContext aioMsgService) {
        Intrinsics.checkNotNullParameter(aioMsgService, "aioMsgService");
        if (!s()) {
            return;
        }
        Flow onEach = FlowKt.onEach(aioMsgService.q(), new RobotReportAbility$registerNotification$1(this, null));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        FlowKt.launchIn(FlowKt.flowOn(onEach, zs.b.a(dispatchers)), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aioMsgService.r(), new RobotReportAbility$registerNotification$2(this, null)), zs.b.a(dispatchers)), f());
    }
}
