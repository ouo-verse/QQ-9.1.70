package aa2;

import android.util.LruCache;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Laa2/a;", "", "", "tinyId", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUserInfo;", "b", ITVKPlayerEventListener.KEY_USER_INFO, "", "e", "d", "a", "c", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "userInfoCache", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25755a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static LruCache<Long, NearbyProUserInfo> userInfoCache = new LruCache<>(200);

    a() {
    }

    public final void a() {
        userInfoCache.evictAll();
    }

    @Nullable
    public final NearbyProUserInfo b(long tinyId) {
        return userInfoCache.get(Long.valueOf(tinyId));
    }

    public final void c() {
        SelfUserInfo selfUserInfo;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null) {
            selfUserInfo = f16.getSelfUserInfo();
        } else {
            selfUserInfo = null;
        }
        if (selfUserInfo != null) {
            f25755a.e(new NearbyProUserInfo(selfUserInfo.getTid(), selfUserInfo.getNickName(), selfUserInfo.getAvatarUrl()));
        }
    }

    public final void d(long tinyId) {
        userInfoCache.remove(Long.valueOf(tinyId));
    }

    public final void e(@Nullable NearbyProUserInfo userInfo) {
        if (userInfo == null) {
            j.c().d("UserDataCache", "updateNearbyProUserInfo but userInfo is empty");
        } else {
            userInfoCache.put(Long.valueOf(userInfo.tinyId), userInfo);
        }
    }
}
