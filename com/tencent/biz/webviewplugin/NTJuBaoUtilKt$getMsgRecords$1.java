package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "suc", "Lcom/tencent/nt/adapter/session/e;", "sessionWithUid", "", "invoke", "(ZLcom/tencent/nt/adapter/session/e;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes5.dex */
final class NTJuBaoUtilKt$getMsgRecords$1 extends Lambda implements Function2<Boolean, com.tencent.nt.adapter.session.e, Unit> {
    final /* synthetic */ Function1<List<MsgRecord>, Unit> $callback;
    final /* synthetic */ int $maxCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NTJuBaoUtilKt$getMsgRecords$1(int i3, Function1<? super List<MsgRecord>, Unit> function1) {
        super(2);
        this.$maxCount = i3;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 callback, int i3, String errMsg, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (i3 != 0) {
            QLog.d("NewReportPlugin", 1, "getMsgRecords result=" + i3 + " errMsg=" + errMsg);
        }
        callback.invoke(msgList);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.e eVar) {
        invoke(bool.booleanValue(), eVar);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @Nullable com.tencent.nt.adapter.session.e eVar) {
        if (z16 && eVar != null) {
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact a16 = com.tencent.nt.adapter.session.d.a(eVar);
            int i3 = this.$maxCount;
            final Function1<List<MsgRecord>, Unit> function1 = this.$callback;
            iMsgService.getMsgs(a16, 0L, i3, true, new IMsgOperateCallback() { // from class: com.tencent.biz.webviewplugin.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i16, String str, ArrayList arrayList) {
                    NTJuBaoUtilKt$getMsgRecords$1.b(Function1.this, i16, str, arrayList);
                }
            });
            return;
        }
        QLog.i("NewReportPlugin", 1, "getMsgRecords uin2Uid failed!!");
        this.$callback.invoke(null);
    }
}
