package ej4;

import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yo4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B?\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016RG\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lej4/a;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "pushMsg", "d", "Lkotlin/jvm/functions/Function2;", "getOnReceivePushCallback", "()Lkotlin/jvm/functions/Function2;", "onReceivePushCallback", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "e", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements IQQCmdPushCallback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, String, Unit> onReceivePushCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function2<? super Integer, ? super String, Unit> onReceivePushCallback) {
        Intrinsics.checkNotNullParameter(onReceivePushCallback, "onReceivePushCallback");
        this.onReceivePushCallback = onReceivePushCallback;
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onFail(int errCode, @Nullable String errMsg) {
        QLog.e("EcommerceLuckBagPushListener", 1, "EcommerceLuckBagPushListener onFail errCode=" + errCode + ", errMsg=" + errMsg);
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onReceive(@Nullable byte[] data) {
        b c16 = b.c(data);
        Function2<Integer, String, Unit> function2 = this.onReceivePushCallback;
        Integer valueOf = Integer.valueOf(c16.f450750a);
        String str = c16.f450753d;
        Intrinsics.checkNotNullExpressionValue(str, "pushData.msgData");
        function2.invoke(valueOf, str);
    }
}
