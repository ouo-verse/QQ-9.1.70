package com.tencent.mobileqq.zplan.easteregg;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.ExtBufForUI$ExtData;
import tencent.im.msg.ExtBufForUI$ZPlan;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J-\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/ZPlanHeaderEffectUtil;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "a", "", "needEffect", "", "d", "c", "e", "chatType", "", "peerId", "", "msgId", "b", "(ILjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanHeaderEffectUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanHeaderEffectUtil f332844a = new ZPlanHeaderEffectUtil();

    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052*\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", TabPreloadItem.TAB_NAME_MESSAGE, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    static final class a implements IMsgOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<MsgRecord> f332845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f332846b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super MsgRecord> continuation, long j3) {
            this.f332845a = continuation;
            this.f332846b = j3;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public final void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            ZPlanHeaderEffectUtil zPlanHeaderEffectUtil = ZPlanHeaderEffectUtil.f332844a;
            Continuation<MsgRecord> continuation = this.f332845a;
            long j3 = this.f332846b;
            if (i3 != 0) {
                continuation.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            if (arrayList != null) {
                try {
                    for (MsgRecord msgRecord : arrayList) {
                        if (msgRecord.msgId == j3) {
                            continuation.resumeWith(Result.m476constructorimpl(msgRecord));
                        }
                    }
                } catch (OutOfMemoryError e16) {
                    QLog.e("ZPlanHeaderEffectUtil", 1, "getMsgsByMsgId oom, " + e16);
                }
            }
        }
    }

    ZPlanHeaderEffectUtil() {
    }

    public final int a(MsgRecord msgRecord) {
        ExtBufForUI$ZPlan extBufForUI$ZPlan;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ExtBufForUI$ExtData j3 = MsgExtKt.j(msgRecord);
        if (j3 == null || (extBufForUI$ZPlan = j3.zplan) == null || (pBInt32Field = extBufForUI$ZPlan.aio_head_effect_msg_flag) == null) {
            return 0;
        }
        return pBInt32Field.get();
    }

    public final Object b(int i3, String str, long j3, Continuation<? super MsgRecord> continuation) {
        Continuation intercepted;
        ArrayList<Long> arrayListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ZPlanHeaderEffectUtil", 1, "checkUin app is null, return false");
        } else {
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
            if (msgService == null) {
                QLog.e("ZPlanHeaderEffectUtil", 1, "checkUin msgService is null, return false");
            } else {
                Contact contact = new Contact(i3, str, "");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(j3));
                msgService.getMsgsByMsgId(contact, arrayListOf, new a(safeContinuation, j3));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final int c(MsgRecord msgRecord) {
        ExtBufForUI$ZPlan extBufForUI$ZPlan;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ExtBufForUI$ExtData j3 = MsgExtKt.j(msgRecord);
        if (j3 == null || (extBufForUI$ZPlan = j3.zplan) == null || (pBInt32Field = extBufForUI$ZPlan.recent_list_head_effect_msg_flag) == null) {
            return 0;
        }
        return pBInt32Field.get();
    }

    public final void d(MsgRecord msgRecord, boolean needEffect) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        final ExtBufForUI$ZPlan extBufForUI$ZPlan = new ExtBufForUI$ZPlan();
        extBufForUI$ZPlan.aio_head_effect_msg_flag.set(needEffect ? 1 : 0);
        MsgExtKt.d0(msgRecord, new Function1<ExtBufForUI$ExtData, Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.ZPlanHeaderEffectUtil$setAioHeadEffectMsgFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExtBufForUI$ExtData extBufForUI$ExtData) {
                invoke2(extBufForUI$ExtData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExtBufForUI$ExtData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.zplan.set(ExtBufForUI$ZPlan.this);
            }
        }, null, 2, null);
    }

    public final void e(MsgRecord msgRecord, boolean needEffect) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        final ExtBufForUI$ZPlan extBufForUI$ZPlan = new ExtBufForUI$ZPlan();
        extBufForUI$ZPlan.recent_list_head_effect_msg_flag.set(needEffect ? 1 : 0);
        MsgExtKt.d0(msgRecord, new Function1<ExtBufForUI$ExtData, Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.ZPlanHeaderEffectUtil$setRecentHeadEffectMsgFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExtBufForUI$ExtData extBufForUI$ExtData) {
                invoke2(extBufForUI$ExtData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExtBufForUI$ExtData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.zplan.set(ExtBufForUI$ZPlan.this);
            }
        }, null, 2, null);
    }
}
