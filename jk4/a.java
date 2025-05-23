package jk4;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.timi.game.liveroom.impl.room.match.TGAudienceTabViewPager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass$RoomTabInfo;
import yn4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ljk4/a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;", "viewPager", "", "d", "", "roomId", "", "a", "e", "", "f", "b", "c", "", "Ljava/util/Map;", "chargeRecordCache", "Ljava/lang/String;", "chargeTabId", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "viewPagerRef", "Z", "isLivePowerEnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<TGAudienceTabViewPager> viewPagerRef;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f410352a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Long> chargeRecordCache = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String chargeTabId = "aaaaa";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isLivePowerEnable = true;

    a() {
    }

    private final String a(long roomId) {
        return "USER_CHARGE_" + roomId;
    }

    private final void d(TGAudienceTabViewPager viewPager) {
        List<PremadesTeamServerOuterClass$RoomTabInfo> c16;
        if (viewPager != null && (c16 = viewPager.c()) != null) {
            Iterator<PremadesTeamServerOuterClass$RoomTabInfo> it = c16.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(it.next().f437246id.get(), chargeTabId)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                viewPager.setCurrentItem(i3);
            }
        }
    }

    public final boolean b() {
        return isLivePowerEnable;
    }

    public final void c() {
        TGAudienceTabViewPager tGAudienceTabViewPager;
        WeakReference<TGAudienceTabViewPager> weakReference = viewPagerRef;
        if (weakReference != null) {
            tGAudienceTabViewPager = weakReference.get();
        } else {
            tGAudienceTabViewPager = null;
        }
        d(tGAudienceTabViewPager);
    }

    public final void e(long roomId) {
        if (roomId > 0) {
            long serverTime = NetConnInfoCenter.getServerTime() * 1000;
            rm4.a.j(a(roomId), serverTime);
            chargeRecordCache.put(a(roomId), Long.valueOf(serverTime));
        }
    }

    public final boolean f(long roomId) {
        long j3 = 0;
        if (chargeRecordCache.containsKey(a(roomId))) {
            Long l3 = chargeRecordCache.get(a(roomId));
            if (l3 != null) {
                j3 = l3.longValue();
            }
        } else {
            j3 = rm4.a.d(a(roomId), 0L);
            chargeRecordCache.put(a(roomId), Long.valueOf(j3));
        }
        if (d.g(j3, NetConnInfoCenter.getServerTime() * 1000) && b()) {
            return true;
        }
        return false;
    }
}
