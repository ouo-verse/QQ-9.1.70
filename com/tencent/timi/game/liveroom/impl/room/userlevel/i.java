package com.tencent.timi.game.liveroom.impl.room.userlevel;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserPayLevelData;
import com.tencent.timi.game.sso.request.QQLiveGetMyPayLevelRequest;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/i;", "", "", "f", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "userPayLevelData", "", tl.h.F, "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/g;", "callback", "d", "g", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "l", "i", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "uidToPayLevelMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "userLevelChangedListenerList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f378614a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, UserPayLevelData> uidToPayLevelMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<h> userLevelChangedListenerList = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/userlevel/i$a", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lsr4/f;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ILiveNetRequest.Callback<sr4.f> {
        a(g gVar) {
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<sr4.f> response) {
            long j3;
            Long l3;
            Intrinsics.checkNotNullParameter(response, "response");
            sr4.f rsp = response.getRsp();
            if (rsp == null) {
                rsp = new sr4.f();
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Gift|PayUserLevelCenter", "fetchMyPayUserLevel, rsp:" + rsp);
            ConcurrentHashMap concurrentHashMap = i.uidToPayLevelMap;
            i iVar = i.f378614a;
            UserPayLevelData userPayLevelData = (UserPayLevelData) concurrentHashMap.get(iVar.f());
            long j16 = rsp.f434372b;
            if (userPayLevelData != null) {
                j3 = userPayLevelData.getCurPayLevel();
            } else {
                j3 = 0;
            }
            if (j16 >= j3) {
                String f16 = iVar.f();
                if (f16 != null) {
                    long j17 = rsp.f434371a;
                    long j18 = rsp.f434372b;
                    String str = rsp.f434373c;
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.icon");
                    long j19 = rsp.f434375e;
                    String str2 = rsp.f434377g;
                    Intrinsics.checkNotNullExpressionValue(str2, "rsp.privilegeJumpUrl");
                    UserPayLevelData userPayLevelData2 = new UserPayLevelData(f16, j17, j18, str, j19, str2);
                    if (userPayLevelData2.f()) {
                        companion.i("Gift|PayUserLevelCenter", "fetchMyPayUserLevel, notifyChanged");
                        i.uidToPayLevelMap.put(f16, userPayLevelData2);
                        iVar.h(userPayLevelData2);
                        return;
                    }
                    companion.e("Gift|PayUserLevelCenter", "fetchMyPayUserLevel", "rsp is invalid.");
                    return;
                }
                return;
            }
            if (userPayLevelData != null) {
                l3 = Long.valueOf(userPayLevelData.getCurPayLevel());
            } else {
                l3 = null;
            }
            companion.e("Gift|PayUserLevelCenter", "fetchMyPayUserLevel", "curPayLevel:" + l3);
        }
    }

    i() {
    }

    public static /* synthetic */ void e(i iVar, g gVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gVar = null;
        }
        iVar.d(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(UserPayLevelData userPayLevelData) {
        Iterator<T> it = userLevelChangedListenerList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(userPayLevelData);
        }
    }

    public final void d(@Nullable g callback) {
        sr4.e eVar = new sr4.e();
        eVar.f434370a = new String[]{"coin", "level", "icon", "next_level_coin", "privilege_jump_url"};
        String[] strArr = eVar.f434370a;
        Intrinsics.checkNotNullExpressionValue(strArr, "req.fields");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetMyPayLevelRequest(strArr), new a(callback));
    }

    @Nullable
    public final UserPayLevelData g() {
        return uidToPayLevelMap.get(f());
    }

    public final void i(@NotNull h l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        if (userLevelChangedListenerList.contains(l3)) {
            return;
        }
        userLevelChangedListenerList.add(l3);
    }

    public final void j(@NotNull h l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        userLevelChangedListenerList.remove(l3);
    }
}
