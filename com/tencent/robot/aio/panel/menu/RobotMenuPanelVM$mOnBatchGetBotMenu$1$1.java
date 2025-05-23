package com.tencent.robot.aio.panel.menu;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.panel.menu.RobotMenuPanelVM$mOnBatchGetBotMenu$1$1", f = "RobotMenuPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotMenuPanelVM$mOnBatchGetBotMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errMsg;
    final /* synthetic */ BatchGetBotsMenuResponse $response;
    final /* synthetic */ int $result;
    int label;
    final /* synthetic */ RobotMenuPanelVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMenuPanelVM$mOnBatchGetBotMenu$1$1(int i3, BatchGetBotsMenuResponse batchGetBotsMenuResponse, String str, RobotMenuPanelVM robotMenuPanelVM, Continuation<? super RobotMenuPanelVM$mOnBatchGetBotMenu$1$1> continuation) {
        super(2, continuation);
        this.$result = i3;
        this.$response = batchGetBotsMenuResponse;
        this.$errMsg = str;
        this.this$0 = robotMenuPanelVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotMenuPanelVM$mOnBatchGetBotMenu$1$1(this.$result, this.$response, this.$errMsg, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List emptyList;
        BatchGetBotsMenuResponse batchGetBotsMenuResponse;
        MenuInfo menuInfo;
        List list;
        Object firstOrNull;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.$result;
            if (i3 == 0 && (batchGetBotsMenuResponse = this.$response) != null) {
                ArrayList<MenuInfo> arrayList = batchGetBotsMenuResponse.menuInfo;
                CommonBotInfo commonBotInfo = null;
                if (arrayList != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                    menuInfo = (MenuInfo) firstOrNull;
                } else {
                    menuInfo = null;
                }
                if (menuInfo != null) {
                    list = menuInfo.featureInfo;
                } else {
                    list = null;
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                if (list.isEmpty()) {
                    QLog.i("RobotMenuPanelVM", 1, "[reqMenuList]: data is empty");
                }
                RobotMenuPanelVM robotMenuPanelVM = this.this$0;
                if (menuInfo != null) {
                    commonBotInfo = menuInfo.botInfo;
                }
                robotMenuPanelVM.mRobotInfo = commonBotInfo;
                this.this$0.A(list);
            } else {
                QLog.e("RobotMenuPanelVM", 1, "[reqMenuList]: failed result=" + i3 + ", errMsg=" + this.$errMsg);
                RobotMenuPanelVM robotMenuPanelVM2 = this.this$0;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                robotMenuPanelVM2.A(emptyList);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotMenuPanelVM$mOnBatchGetBotMenu$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
