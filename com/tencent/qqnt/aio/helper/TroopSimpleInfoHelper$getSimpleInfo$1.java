package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.dy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "info", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class TroopSimpleInfoHelper$getSimpleInfo$1 extends Lambda implements Function2<Boolean, TroopInfo, Unit> {
    final /* synthetic */ TroopSimpleInfoHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSimpleInfoHelper$getSimpleInfo$1(TroopSimpleInfoHelper troopSimpleInfoHelper) {
        super(2);
        this.this$0 = troopSimpleInfoHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQAppInterface it, TroopInfo info) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(info, "$info");
        TroopUtils.N(it, info.troopuin, info.discussUin, info.discussMaxSeq, 0L);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
        invoke(bool.booleanValue(), troopInfo);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, final TroopInfo info) {
        String str;
        AppRuntime c16;
        Intrinsics.checkNotNullParameter(info, "info");
        String str2 = null;
        if (info.discussMaxSeq > 0 && !TextUtils.isEmpty(info.discussUin)) {
            QLog.i("TroopSimpleInfoHelper", 1, "onGetSimpleTroopInfoResult current discussMaxSeq = " + info.discussMaxSeq + ", discussUin = " + info.discussUin);
            c16 = this.this$0.c();
            final QQAppInterface qQAppInterface = c16 instanceof QQAppInterface ? (QQAppInterface) c16 : null;
            if (qQAppInterface != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fc
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopSimpleInfoHelper$getSimpleInfo$1.b(QQAppInterface.this, info);
                    }
                }, 240, null, false);
            }
        }
        dy.Companion companion = dy.INSTANCE;
        str = this.this$0.peerUid;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUid");
        } else {
            str2 = str;
        }
        companion.a(str2);
    }
}
