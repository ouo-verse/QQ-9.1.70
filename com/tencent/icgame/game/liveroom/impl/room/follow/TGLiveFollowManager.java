package com.tencent.icgame.game.liveroom.impl.room.follow;

import bp4.b;
import bp4.d;
import bp4.g;
import com.tencent.icgame.game.sso.request.QQLiveCheckFollowRequest;
import com.tencent.icgame.game.sso.request.QQLiveFollowRequest;
import com.tencent.icgame.game.sso.request.QQLiveFollowRoomRequest;
import com.tencent.icgame.game.sso.request.QQLiveUnFollowRequest;
import com.tencent.icgame.game.sso.request.QQLiveUnfollowRoomRequest;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import fu0.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qx0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010J(\u0010\u0018\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J(\u0010\u001a\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001d\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0002R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00100!j\b\u0012\u0004\u0012\u00020\u0010`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050&j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/follow/TGLiveFollowManager;", "", "", "uid", "key", "", "k", "followedId", "followState", "roomId", "", "o", "anchorId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "l", "p", "r", "Lcom/tencent/mobileqq/icgame/api/message/IQQLiveFollowMsgService;", "service", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "cb", "f", "g", h.F, "i", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "e", "", "j", DomainData.DOMAIN_NAME, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "mListenerPool", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "mFollowStateCache", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TGLiveFollowManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TGLiveFollowManager f115307a = new TGLiveFollowManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<IQQLiveFollowStateListener> mListenerPool = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> mFollowStateCache = new HashMap<>();

    TGLiveFollowManager() {
    }

    private final int k(long uid, long key) {
        Integer num = mFollowStateCache.get(m(uid, key));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    static /* synthetic */ int l(TGLiveFollowManager tGLiveFollowManager, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            Long K = ((c) a.b(c.class)).K();
            Intrinsics.checkNotNullExpressionValue(K, "getService(ITgLiveRoomSe\u2026e::class.java).selfUserId");
            j3 = K.longValue();
        }
        return tGLiveFollowManager.k(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(long uid, long anchorId) {
        return uid + "_" + anchorId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(long uid, long followedId, int followState, long roomId) {
        Iterator<IQQLiveFollowStateListener> it = mListenerPool.iterator();
        while (it.hasNext()) {
            it.next().onFollowStateChange(uid, followedId, followState, String.valueOf(roomId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long q() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.getUid();
        }
        return 0L;
    }

    public final void e(@Nullable IQQLiveFollowMsgService service, final long anchorId, @NotNull final IQQLiveCheckFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveCheckFollowRequest(anchorId), new Function1<QQLiveResponse<b>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager$doCheckFollow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<b> it) {
                HashMap hashMap;
                long q16;
                String m3;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    b rsp = it.getRsp();
                    int i3 = rsp != null ? rsp.f28918a : 0;
                    Integer valueOf = Integer.valueOf(i3);
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f115307a;
                    q16 = tGLiveFollowManager.q();
                    m3 = tGLiveFollowManager.m(q16, anchorId);
                    hashMap.put(m3, valueOf);
                    cb5.onSuccess(i3);
                    return;
                }
                cb5.onFail((int) it.getRetCode(), it.getErrMsg());
            }
        });
    }

    public final void f(@Nullable IQQLiveFollowMsgService service, final long anchorId, final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFollowRequest(roomId, anchorId), new Function1<QQLiveResponse<d>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager$doFollowAnchor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<d> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<d> response) {
                HashMap hashMap;
                long q16;
                String m3;
                long q17;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f115307a;
                    q16 = tGLiveFollowManager.q();
                    m3 = tGLiveFollowManager.m(q16, anchorId);
                    hashMap.put(m3, 1);
                    cb5.onSuccess();
                    q17 = tGLiveFollowManager.q();
                    tGLiveFollowManager.o(q17, anchorId, 1, roomId);
                    return;
                }
                cb5.onFail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    public final void g(final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFollowRoomRequest(roomId), new Function1<QQLiveResponse<kz0.b>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager$doFollowRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<kz0.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<kz0.b> response) {
                HashMap hashMap;
                long q16;
                String m3;
                long q17;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f115307a;
                    q16 = tGLiveFollowManager.q();
                    m3 = tGLiveFollowManager.m(q16, roomId);
                    hashMap.put(m3, 1);
                    cb5.onSuccess();
                    q17 = tGLiveFollowManager.q();
                    long j3 = roomId;
                    tGLiveFollowManager.o(q17, j3, 1, j3);
                    return;
                }
                cb5.onFail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    public final void h(@Nullable IQQLiveFollowMsgService service, final long anchorId, final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveUnFollowRequest(roomId, anchorId), new Function1<QQLiveResponse<g>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager$doUnFollowAnchor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<g> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<g> response) {
                HashMap hashMap;
                long q16;
                String m3;
                long q17;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f115307a;
                    q16 = tGLiveFollowManager.q();
                    m3 = tGLiveFollowManager.m(q16, anchorId);
                    hashMap.put(m3, 0);
                    cb5.onSuccess();
                    q17 = tGLiveFollowManager.q();
                    tGLiveFollowManager.o(q17, anchorId, 0, roomId);
                    return;
                }
                cb5.onFail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    public final void i(final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveUnfollowRoomRequest(roomId), new Function1<QQLiveResponse<kz0.d>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager$doUnFollowRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<kz0.d> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<kz0.d> it) {
                HashMap hashMap;
                long q16;
                String m3;
                long q17;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f115307a;
                    q16 = tGLiveFollowManager.q();
                    m3 = tGLiveFollowManager.m(q16, roomId);
                    hashMap.put(m3, 0);
                    cb5.onSuccess();
                    q17 = tGLiveFollowManager.q();
                    long j3 = roomId;
                    tGLiveFollowManager.o(q17, j3, 0, j3);
                    return;
                }
                cb5.onFail((int) it.getRetCode(), it.getErrMsg());
            }
        });
    }

    public final boolean j(long anchorId) {
        if (l(this, 0L, anchorId, 1, null) == 1) {
            return true;
        }
        return false;
    }

    public final boolean n(long roomId) {
        if (l(this, 0L, roomId, 1, null) == 1) {
            return true;
        }
        return false;
    }

    public final void p(@NotNull IQQLiveFollowStateListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.add(l3);
    }

    public final void r(@NotNull IQQLiveFollowStateListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.remove(l3);
    }
}
