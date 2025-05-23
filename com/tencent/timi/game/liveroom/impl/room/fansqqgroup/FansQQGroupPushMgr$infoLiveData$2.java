package com.tencent.timi.game.liveroom.impl.room.fansqqgroup;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import rr4.e;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/LiveData;", "Lrr4/e;", "kotlin.jvm.PlatformType", "invoke", "()Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FansQQGroupPushMgr$infoLiveData$2 extends Lambda implements Function0<LiveData<e>> {
    final /* synthetic */ FansQQGroupPushMgr this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansQQGroupPushMgr$infoLiveData$2(FansQQGroupPushMgr fansQQGroupPushMgr) {
        super(0);
        this.this$0 = fansQQGroupPushMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData b(QQLiveResponse qQLiveResponse) {
        mq4.b bVar = (mq4.b) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && bVar != null) {
            e eVar = new e();
            boolean z16 = bVar.f417199a;
            eVar.f432116a = z16;
            eVar.f432117b = bVar.f417200b;
            AegisLogger.INSTANCE.i("Audience|FansQQGroupPushMgr", "fetchGroupInfo", "hasGroup=" + z16);
            return new MutableLiveData(eVar);
        }
        AegisLogger.INSTANCE.w("Audience|FansQQGroupPushMgr", "fetchGroupInfo", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        return new MutableLiveData(null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LiveData<e> invoke() {
        LiveData e16;
        e16 = this.this$0.e();
        return Transformations.switchMap(e16, new Function() { // from class: com.tencent.timi.game.liveroom.impl.room.fansqqgroup.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData b16;
                b16 = FansQQGroupPushMgr$infoLiveData$2.b((QQLiveResponse) obj);
                return b16;
            }
        });
    }
}
