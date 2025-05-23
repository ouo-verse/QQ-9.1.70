package com.tencent.mobileqq.icgame.api.room.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.ISwitchRoomList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lz0.c;
import lz0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/impl/SwitchRoomListImpl;", "Lcom/tencent/mobileqq/icgame/api/room/ISwitchRoomList;", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "sdk", "Llz0/c;", "req", "Lcom/tencent/mobileqq/icgame/api/room/ISwitchRoomList$IRoomResult;", "callback", "", "fetchRoomList", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SwitchRoomListImpl implements ISwitchRoomList {
    @Override // com.tencent.mobileqq.icgame.api.room.ISwitchRoomList
    public void fetchRoomList(@Nullable IQQLiveSDK sdk, @NotNull c req, @Nullable final ISwitchRoomList.IRoomResult callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (sdk != null && sdk.isInited()) {
            sdk.getProxySsoService().sendQQLiveQuickProxyReq("trpc.qlive.trpc_switch_room_list.trpc_switch_room_list", "GetFeedsList", MessageNano.toByteArray(req), new IQQLiveProxySsoObserver() { // from class: com.tencent.mobileqq.icgame.api.room.impl.SwitchRoomListImpl$fetchRoomList$1
                @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
                public void onFail(int errCode, @Nullable String errMsg) {
                    ISwitchRoomList.IRoomResult iRoomResult = ISwitchRoomList.IRoomResult.this;
                    if (iRoomResult != null) {
                        iRoomResult.onResult(null, errCode, errMsg);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
                public void onReceive(@NotNull byte[] data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        d dVar = new d();
                        MessageNano.mergeFrom(dVar, data);
                        ISwitchRoomList.IRoomResult iRoomResult = ISwitchRoomList.IRoomResult.this;
                        if (iRoomResult != null) {
                            iRoomResult.onResult(dVar, 0, null);
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        ISwitchRoomList.IRoomResult iRoomResult2 = ISwitchRoomList.IRoomResult.this;
                        if (iRoomResult2 != null) {
                            iRoomResult2.onResult(null, -1, "parse pb fail");
                        }
                    }
                }
            });
        } else if (callback != null) {
            callback.onResult(null, -3, "empty live sdk or not init");
        }
    }
}
