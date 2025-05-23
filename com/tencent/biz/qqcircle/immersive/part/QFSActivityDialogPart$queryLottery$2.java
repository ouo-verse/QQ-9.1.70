package com.tencent.biz.qqcircle.immersive.part;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleActivityLottery$LotteryResultRsp;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "rsp", "Lqqcircle/QQCircleActivityLottery$LotteryResultRsp;", "t", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSActivityDialogPart$queryLottery$2 extends Lambda implements Function2<QQCircleActivityLottery$LotteryResultRsp, Throwable, Unit> {
    final /* synthetic */ int $count;
    final /* synthetic */ QFSActivityDialogPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSActivityDialogPart$queryLottery$2(QFSActivityDialogPart qFSActivityDialogPart, int i3) {
        super(2);
        this.this$0 = qFSActivityDialogPart;
        this.$count = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSActivityDialogPart this$0, int i3) {
        Disposable disposable;
        Disposable P9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        disposable = this$0.reqDisposable;
        if (disposable != null) {
            P9 = this$0.P9(i3 - 1);
            disposable.a(P9);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(QQCircleActivityLottery$LotteryResultRsp qQCircleActivityLottery$LotteryResultRsp, Throwable th5) {
        invoke2(qQCircleActivityLottery$LotteryResultRsp, th5);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable QQCircleActivityLottery$LotteryResultRsp qQCircleActivityLottery$LotteryResultRsp, @Nullable Throwable th5) {
        PBEnumField pBEnumField = qQCircleActivityLottery$LotteryResultRsp != null ? qQCircleActivityLottery$LotteryResultRsp.lottery_result : null;
        if (qQCircleActivityLottery$LotteryResultRsp != null && th5 == null) {
            String tag = this.this$0.getTAG();
            Integer valueOf = pBEnumField != null ? Integer.valueOf(pBEnumField.get()) : null;
            QLog.i(tag, 1, " queryLottery " + valueOf + " " + qQCircleActivityLottery$LotteryResultRsp.lottery_detail.name.get());
            Integer valueOf2 = pBEnumField != null ? Integer.valueOf(pBEnumField.get()) : null;
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                this.this$0.U9(qQCircleActivityLottery$LotteryResultRsp);
                return;
            }
            if (valueOf2 != null && valueOf2.intValue() == 2) {
                Handler uIHandler = RFWThreadManager.getUIHandler();
                final QFSActivityDialogPart qFSActivityDialogPart = this.this$0;
                final int i3 = this.$count;
                Message obtain = Message.obtain(uIHandler, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSActivityDialogPart$queryLottery$2.b(QFSActivityDialogPart.this, i3);
                    }
                });
                obtain.what = 234112;
                uIHandler.sendMessageDelayed(obtain, 1000L);
                return;
            }
            return;
        }
        QLog.e(this.this$0.getTAG(), 1, " triggerLottery fail", th5);
    }
}
