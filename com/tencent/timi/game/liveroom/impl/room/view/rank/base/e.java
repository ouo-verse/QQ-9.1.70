package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IODGameManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/e;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "", ReportConstant.COSTREPORT_PREFIX, "", "url", "name", "a", "g", "", "Ld55/h;", "k", "()[Ld55/h;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends c {
    private final long s() {
        return ((IODGameManager) QRoute.api(IODGameManager.class)).getODRoomHostId(getRoomId());
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.base.c
    @NotNull
    protected String a(@NotNull String url, @NotNull String name) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!TextUtils.equals(name, "rankRule") && s() > 0) {
            str = "appId=" + c() + "&qqliveAnchorId=" + s() + "&roomId=" + getRoomId() + "&qqLiveZhiBoType=" + n();
        } else {
            str = "appId=" + c() + "&roomId=" + getRoomId() + "&qqLiveZhiBoType=" + n();
        }
        String a16 = com.tencent.qqlive.common.webview.a.a(url, str);
        Intrinsics.checkNotNullExpressionValue(a16, "appendArgs(url, appendArgs)");
        return a16;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.base.c
    @NotNull
    protected String g(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        d55.e d16 = d();
        if (d16 == null) {
            return "";
        }
        h hVar = new h(d16, name);
        if (s() > 0) {
            long s16 = s();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(s16);
            hVar.d(sb5.toString());
        }
        hVar.c(l());
        long roomId = getRoomId();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(roomId);
        hVar.h(sb6.toString());
        hVar.e(h());
        hVar.f(i());
        int n3 = n();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(n3);
        hVar.g(sb7.toString());
        return hVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028 A[RETURN] */
    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.base.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d55.h[] k() {
        boolean z16;
        boolean z17;
        d55.h[] k3 = super.k();
        if (s() > 0) {
            return k3;
        }
        if (k3 != null) {
            if (k3.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = true;
                if (!z16) {
                    return new d55.h[]{k3[0]};
                }
                return k3;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }
}
