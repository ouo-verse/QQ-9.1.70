package com.tencent.timi.game.liveroom.impl.room.medal.data;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.widget.chat.data.DressUpBubble;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.sso.request.QQLiveGetMedalInfoRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sr4.g;
import sr4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J4\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\f0\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/data/MedalRemoteDataSource;", "", "", "userId", "Lsr4/b;", "chatEffectConfRsp", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "c", "roomId", "", "roomType", "Lkotlin/Function1;", "", "callback", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MedalRemoteDataSource {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        r5 = kotlin.collections.ArraysKt___ArraysKt.toList(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.mobileqq.qqlive.widget.chat.data.b c(long userId, sr4.b chatEffectConfRsp) {
        sr4.a aVar;
        DressUpBubble dressUpBubble;
        boolean z16;
        List<g> emptyList;
        String str = null;
        if (chatEffectConfRsp == null) {
            QLog.e("MedalRemoteDataSource", 1, "parseData data is null");
            return null;
        }
        sr4.c cVar = chatEffectConfRsp.f434359a;
        h hVar = chatEffectConfRsp.f434360b;
        if (hVar != null) {
            aVar = hVar.f434412a;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            dressUpBubble = new DressUpBubble(hVar.f434412a);
        } else {
            dressUpBubble = null;
        }
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar = new com.tencent.mobileqq.qqlive.widget.chat.data.b();
        bVar.f273756a = userId;
        boolean z17 = false;
        if (cVar != null) {
            z16 = cVar.f434363b;
        } else {
            z16 = false;
        }
        bVar.f273757b = z16;
        if (cVar != null) {
            z17 = cVar.f434364c;
        }
        bVar.f273758c = z17;
        if (cVar != null) {
            str = cVar.f434365d;
        }
        bVar.f273759d = str;
        if (cVar == null || (r5 = cVar.f434362a) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        bVar.f273762g = emptyList;
        bVar.f273760e = dressUpBubble;
        bVar.f273761f = chatEffectConfRsp.f434361c;
        return bVar;
    }

    public final void b(final long userId, long roomId, int roomType, @NotNull final Function1<? super com.tencent.mobileqq.qqlive.widget.chat.data.b, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("MedalRemoteDataSource", 2, "[getData] userId=" + userId + ", roomType=" + roomType);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetMedalInfoRequest(roomId, roomType, userId, com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null)), new Function1<QQLiveResponse<sr4.b>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.data.MedalRemoteDataSource$getData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<sr4.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<sr4.b> response) {
                com.tencent.mobileqq.qqlive.widget.chat.data.b c16;
                g[] gVarArr;
                g[] gVarArr2;
                Intrinsics.checkNotNullParameter(response, "response");
                sr4.b rsp = response.getRsp();
                Integer num = null;
                if (!response.isFailed() && rsp != null) {
                    if (QLog.isColorLevel()) {
                        sr4.c cVar = rsp.f434359a;
                        Boolean valueOf = cVar != null ? Boolean.valueOf(cVar.f434363b) : null;
                        sr4.c cVar2 = rsp.f434359a;
                        if (cVar2 != null && (gVarArr2 = cVar2.f434362a) != null) {
                            num = Integer.valueOf(gVarArr2.length);
                        }
                        QLog.d("MedalRemoteDataSource", 2, "[getData] showMedal=" + valueOf + ", medalsCount=" + num);
                        sr4.c cVar3 = rsp.f434359a;
                        if (cVar3 != null && (gVarArr = cVar3.f434362a) != null) {
                            for (g gVar : gVarArr) {
                                QLog.d("MedalRemoteDataSource", 2, "[getData] medalType=" + gVar.f434388d + ", medalName=" + gVar.f434386b + ", medalLevel=" + gVar.f434397m);
                            }
                        }
                    }
                    Function1<com.tencent.mobileqq.qqlive.widget.chat.data.b, Unit> function1 = callback;
                    c16 = this.c(userId, rsp);
                    function1.invoke(c16);
                    return;
                }
                QLog.e("MedalRemoteDataSource", 1, "[getData] failed, errorCode=" + response.getRetCode() + ",errorMsg=" + response.getErrMsg());
                callback.invoke(null);
            }
        });
    }
}
