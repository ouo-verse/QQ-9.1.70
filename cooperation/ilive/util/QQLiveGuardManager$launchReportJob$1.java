package cooperation.ilive.util;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "cooperation.ilive.util.QQLiveGuardManager$launchReportJob$1", f = "QQLiveGuardManager.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class QQLiveGuardManager$launchReportJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQLiveGuardManager$launchReportJob$1(Continuation<? super QQLiveGuardManager$launchReportJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQLiveGuardManager$launchReportJob$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AudienceRoomInfo audienceRoomInfo;
        AudienceRoomInfo audienceRoomInfo2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Integer num = null;
        String str = null;
        EIPCResult b16 = QQLiveClientQIPCModule.INSTANCE.b(QQLiveIPCConstants.Action.ACTION_ROOM_BACKGROUND_REPORT, null);
        boolean z16 = false;
        if (b16 != null && b16.isSuccess()) {
            z16 = true;
        }
        if (z16) {
            Bundle bundle = b16.data;
            if (bundle != null) {
                bundle.setClassLoader(AudienceRoomInfo.class.getClassLoader());
            }
            QQLiveGuardManager qQLiveGuardManager = QQLiveGuardManager.f390141d;
            Bundle bundle2 = b16.data;
            if (bundle2 != null) {
                audienceRoomInfo = (AudienceRoomInfo) bundle2.getParcelable(QQLiveIPCConstants.Param.PARAM_BACKGROUND_ROOM_INFO);
            } else {
                audienceRoomInfo = null;
            }
            QQLiveGuardManager.roomInfo = audienceRoomInfo;
            audienceRoomInfo2 = QQLiveGuardManager.roomInfo;
            if (audienceRoomInfo2 != null) {
                str = audienceRoomInfo2.w();
            }
            QLog.i("QQLiveGuardManager", 1, "[launchReportJob] windowModeSeq=" + str);
        } else if (QLog.isColorLevel()) {
            if (b16 != null) {
                num = Boxing.boxInt(b16.code);
            }
            QLog.i("QQLiveGuardManager", 1, "[launchReportJob] no room, code=" + num);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQLiveGuardManager$launchReportJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
