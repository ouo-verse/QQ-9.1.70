package com.tencent.timi.game.liveroom.impl.room.follow;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.sso.request.QQLiveCheckFollowRequest;
import com.tencent.timi.game.sso.request.QQLiveCheckFollowRoomRequest;
import com.tencent.timi.game.sso.request.QQLiveFollowRequest;
import com.tencent.timi.game.sso.request.QQLiveFollowRoomRequest;
import com.tencent.timi.game.sso.request.QQLiveUnFollowRequest;
import com.tencent.timi.game.sso.request.QQLiveUnfollowRoomRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr4.d;
import pr4.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010J,\u0010\u0018\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J,\u0010\u001a\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001d\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001cJ\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u0002R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00100\"j\b\u0012\u0004\u0012\u00020\u0010`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050'j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/follow/TGLiveFollowManager;", "", "", "uid", "key", "", "o", "followedId", "followState", "roomId", "", "t", "anchorId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "l", "u", "w", "Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveFollowMsgService;", "service", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "cb", h.F, "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "f", "g", "", DomainData.DOMAIN_NAME, "r", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "mListenerPool", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "mFollowStateCache", "d", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "mQQLiveFollowStateListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveFollowManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TGLiveFollowManager f377684a = new TGLiveFollowManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<IQQLiveFollowApi.IQQLiveFollowStateListener> mListenerPool = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> mFollowStateCache = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IQQLiveFollowApi.IQQLiveFollowStateListener mQQLiveFollowStateListener;

    static {
        IQQLiveFollowApi.IQQLiveFollowStateListener iQQLiveFollowStateListener = new IQQLiveFollowApi.IQQLiveFollowStateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.b
            @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
            public final void onFollowStateChange(long j3, long j16, int i3, String str) {
                TGLiveFollowManager.s(j3, j16, i3, str);
            }
        };
        mQQLiveFollowStateListener = iQQLiveFollowStateListener;
        ((IQQLiveFollowApi) QRoute.api(IQQLiveFollowApi.class)).addWebFollowStateChangeListener(iQQLiveFollowStateListener);
    }

    TGLiveFollowManager() {
    }

    public static /* synthetic */ void i(TGLiveFollowManager tGLiveFollowManager, IQQLiveFollowMsgService iQQLiveFollowMsgService, long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            iQQLiveFollowCallback = null;
        }
        tGLiveFollowManager.h(iQQLiveFollowMsgService, j3, j16, iQQLiveFollowCallback);
    }

    public static /* synthetic */ void l(TGLiveFollowManager tGLiveFollowManager, IQQLiveFollowMsgService iQQLiveFollowMsgService, long j3, long j16, IQQLiveFollowCallback iQQLiveFollowCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            iQQLiveFollowCallback = null;
        }
        tGLiveFollowManager.k(iQQLiveFollowMsgService, j3, j16, iQQLiveFollowCallback);
    }

    private final int o(long uid, long key) {
        Integer num = mFollowStateCache.get(q(uid, key));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    static /* synthetic */ int p(TGLiveFollowManager tGLiveFollowManager, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = c.f272176a.G();
        }
        return tGLiveFollowManager.o(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q(long uid, long anchorId) {
        return uid + "_" + anchorId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(long j3, long j16, int i3, String str) {
        Iterator<T> it = mListenerPool.iterator();
        while (it.hasNext()) {
            ((IQQLiveFollowApi.IQQLiveFollowStateListener) it.next()).onFollowStateChange(j3, j16, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(long uid, long followedId, int followState, long roomId) {
        Iterator<IQQLiveFollowApi.IQQLiveFollowStateListener> it = mListenerPool.iterator();
        while (it.hasNext()) {
            it.next().onFollowStateChange(uid, followedId, followState, String.valueOf(roomId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long v() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.q();
        }
        return 0L;
    }

    public final void f(@Nullable IQQLiveFollowMsgService service, final long anchorId, @NotNull final IQQLiveCheckFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveCheckFollowRequest(anchorId), new Function1<QQLiveResponse<hr4.b>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doCheckFollow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<hr4.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<hr4.b> it) {
                HashMap hashMap;
                long v3;
                String q16;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    hr4.b rsp = it.getRsp();
                    int i3 = rsp != null ? rsp.f406097a : 0;
                    Integer valueOf = Integer.valueOf(i3);
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, anchorId);
                    hashMap.put(q16, valueOf);
                    cb5.onSuccess(i3);
                    return;
                }
                cb5.onFail((int) it.getRetCode(), it.getErrMsg());
            }
        });
    }

    public final void g(final long roomId, @NotNull final IQQLiveCheckFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveCheckFollowRoomRequest(roomId), new Function1<QQLiveResponse<d>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doCheckFollowRoom$1
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
            public final void invoke2(@NotNull QQLiveResponse<d> it) {
                HashMap hashMap;
                long v3;
                String q16;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    d rsp = it.getRsp();
                    int i3 = rsp != null ? rsp.f427064a : 0;
                    Integer valueOf = Integer.valueOf(i3);
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, roomId);
                    hashMap.put(q16, valueOf);
                    cb5.onSuccess(i3);
                    return;
                }
                cb5.onFail((int) it.getRetCode(), it.getErrMsg());
            }
        });
    }

    public final void h(@Nullable IQQLiveFollowMsgService service, final long anchorId, final long roomId, @Nullable final IQQLiveFollowCallback cb5) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFollowRequest(roomId, anchorId), new Function1<QQLiveResponse<hr4.d>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doFollowAnchor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<hr4.d> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<hr4.d> response) {
                HashMap hashMap;
                long v3;
                String q16;
                long v16;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, anchorId);
                    hashMap.put(q16, 1);
                    IQQLiveFollowCallback iQQLiveFollowCallback = cb5;
                    if (iQQLiveFollowCallback != null) {
                        iQQLiveFollowCallback.onSuccess();
                    }
                    v16 = tGLiveFollowManager.v();
                    tGLiveFollowManager.t(v16, anchorId, 1, roomId);
                    return;
                }
                IQQLiveFollowCallback iQQLiveFollowCallback2 = cb5;
                if (iQQLiveFollowCallback2 != null) {
                    iQQLiveFollowCallback2.onFail((int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }

    public final void j(final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFollowRoomRequest(roomId), new Function1<QQLiveResponse<pr4.b>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doFollowRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<pr4.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<pr4.b> response) {
                HashMap hashMap;
                long v3;
                String q16;
                long v16;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, roomId);
                    hashMap.put(q16, 1);
                    cb5.onSuccess();
                    v16 = tGLiveFollowManager.v();
                    long j3 = roomId;
                    tGLiveFollowManager.t(v16, j3, 1, j3);
                    return;
                }
                cb5.onFail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    public final void k(@Nullable IQQLiveFollowMsgService service, final long anchorId, final long roomId, @Nullable final IQQLiveFollowCallback cb5) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveUnFollowRequest(roomId, anchorId), new Function1<QQLiveResponse<hr4.h>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doUnFollowAnchor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<hr4.h> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<hr4.h> response) {
                HashMap hashMap;
                long v3;
                String q16;
                long v16;
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isFailed() && response.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, anchorId);
                    hashMap.put(q16, 0);
                    IQQLiveFollowCallback iQQLiveFollowCallback = cb5;
                    if (iQQLiveFollowCallback != null) {
                        iQQLiveFollowCallback.onSuccess();
                    }
                    v16 = tGLiveFollowManager.v();
                    tGLiveFollowManager.t(v16, anchorId, 0, roomId);
                    return;
                }
                IQQLiveFollowCallback iQQLiveFollowCallback2 = cb5;
                if (iQQLiveFollowCallback2 != null) {
                    iQQLiveFollowCallback2.onFail((int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }

    public final void m(final long roomId, @NotNull final IQQLiveFollowCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveUnfollowRoomRequest(roomId), new Function1<QQLiveResponse<f>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager$doUnFollowRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<f> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<f> it) {
                HashMap hashMap;
                long v3;
                String q16;
                long v16;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    hashMap = TGLiveFollowManager.mFollowStateCache;
                    TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                    v3 = tGLiveFollowManager.v();
                    q16 = tGLiveFollowManager.q(v3, roomId);
                    hashMap.put(q16, 0);
                    cb5.onSuccess();
                    v16 = tGLiveFollowManager.v();
                    long j3 = roomId;
                    tGLiveFollowManager.t(v16, j3, 0, j3);
                    return;
                }
                cb5.onFail((int) it.getRetCode(), it.getErrMsg());
            }
        });
    }

    public final boolean n(long anchorId) {
        if (p(this, 0L, anchorId, 1, null) == 1) {
            return true;
        }
        return false;
    }

    public final boolean r(long roomId) {
        if (p(this, 0L, roomId, 1, null) == 1) {
            return true;
        }
        return false;
    }

    public final void u(@NotNull IQQLiveFollowApi.IQQLiveFollowStateListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.add(l3);
    }

    public final void w(@NotNull IQQLiveFollowApi.IQQLiveFollowStateListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.remove(l3);
    }
}
