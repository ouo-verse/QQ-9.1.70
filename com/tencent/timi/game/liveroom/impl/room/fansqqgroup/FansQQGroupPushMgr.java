package com.tencent.timi.game.liveroom.impl.room.fansqqgroup;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveAnchorFansQQGroupEntryRequest;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr4.e;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b&\u0010'J3\u0010\u000b\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tJ\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\u0019\u0010!R;\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/fansqqgroup/FansQQGroupPushMgr;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lkotlin/Function1;", "Lrr4/e;", "Lkotlin/ParameterName;", "name", "groupInfo", "", "Lcom/tencent/timi/game/liveroom/impl/room/fansqqgroup/FansQQGroupInfoReceiver;", "receiver", "f", "c", "Lfp4/c;", "msgInfo", "onPush", "", "data", "onReceive", "", "errCode", "", "errMsg", "onFail", "", "d", "J", "roomId", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lmq4/b;", "e", "Lkotlin/Lazy;", "()Landroidx/lifecycle/LiveData;", "_responseLiveData", "infoLiveData", h.F, "Lkotlin/jvm/functions/Function1;", "<init>", "(J)V", "i", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FansQQGroupPushMgr implements IQQCmdPushCallback, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _responseLiveData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy infoLiveData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super e, Unit> receiver;

    public FansQQGroupPushMgr(long j3) {
        Lazy lazy;
        Lazy lazy2;
        this.roomId = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveData<QQLiveResponse<mq4.b>>>() { // from class: com.tencent.timi.game.liveroom.impl.room.fansqqgroup.FansQQGroupPushMgr$_responseLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveData<QQLiveResponse<mq4.b>> invoke() {
                long j16;
                ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                j16 = FansQQGroupPushMgr.this.roomId;
                return iLiveNetRequest.sendRequest(new QQLiveAnchorFansQQGroupEntryRequest(j16));
            }
        });
        this._responseLiveData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new FansQQGroupPushMgr$infoLiveData$2(this));
        this.infoLiveData = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<QQLiveResponse<mq4.b>> e() {
        return (LiveData) this._responseLiveData.getValue();
    }

    public final void c() {
        this.receiver = null;
        f z16 = c.z(c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterHighPriorityListener(103, this);
        }
    }

    @NotNull
    public final LiveData<e> d() {
        Object value = this.infoLiveData.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-infoLiveData>(...)");
        return (LiveData) value;
    }

    public final void f(@Nullable Function1<? super e, Unit> receiver) {
        this.receiver = receiver;
        f z16 = c.z(c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(167, this);
            z16.p(235, this);
        } else {
            ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
            if (k3 != null) {
                k3.registerHighPriorityListener(103, this);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onFail(int errCode, @Nullable String errMsg) {
        AegisLogger.INSTANCE.e("Audience|FansQQGroupPushMgr", "onFail", "errCode=" + errCode + ", errMsg=" + errMsg);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        e i3 = com.tencent.mobileqq.qqlive.sail.push.a.i(msgInfo);
        if (i3 != null) {
            AegisLogger.INSTANCE.i("Audience|FansQQGroupPushMgr", "onPush", "hasGroup=" + i3.f432116a);
            Function1<? super e, Unit> function1 = this.receiver;
            if (function1 != null) {
                function1.invoke(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onReceive(@Nullable byte[] data) {
        if (data == null) {
            AegisLogger.INSTANCE.i("Audience|FansQQGroupPushMgr", "onReceive", "invalid data");
            return;
        }
        try {
            e c16 = e.c(data);
            AegisLogger.INSTANCE.i("Audience|FansQQGroupPushMgr", "onReceive", "hasGroup=" + c16.f432116a);
            Function1<? super e, Unit> function1 = this.receiver;
            if (function1 != null) {
                function1.invoke(c16);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|FansQQGroupPushMgr", "onReceive", "error, ", e16);
            Function1<? super e, Unit> function12 = this.receiver;
            if (function12 != null) {
                function12.invoke(null);
            }
        }
    }
}
