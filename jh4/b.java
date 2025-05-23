package jh4;

import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Ljh4/b;", "", "", "c", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "hallInfo", "f", "d", "b", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "cacheHallInfo", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f409938a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf cacheHallInfo;

    static {
        b bVar = new b();
        f409938a = bVar;
        bVar.c();
    }

    b() {
    }

    private final void c() {
        boolean z16;
        String bytesString = rm4.a.f("ExpandHallInfoCacheKey", "");
        l.i("ExpandHallInfoCacheManager_", "loadFromLocalCache bytesString length:" + bytesString.length());
        Intrinsics.checkNotNullExpressionValue(bytesString, "bytesString");
        if (bytesString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        byte[] decode = Base64.decode(bytesString, 2);
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = new WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf();
        try {
            wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.mergeFrom(decode);
            cacheHallInfo = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
            l.i("ExpandHallInfoCacheManager_", "loadFromLocalCache cacheHallInfo:" + wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf);
        } catch (Exception e16) {
            l.f("ExpandHallInfoCacheManager_", "loadFromLocalCache mergeFrom failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf this_run) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        f409938a.f(this_run);
    }

    private final void f(WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf hallInfo) {
        String encodeToString = Base64.encodeToString(hallInfo.toByteArray(), 2);
        l.i("ExpandHallInfoCacheManager_", "saveIntoLocal bytesString length:" + encodeToString.length());
        rm4.a.k("ExpandHallInfoCacheKey", encodeToString);
    }

    @Nullable
    public final WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf b() {
        return cacheHallInfo;
    }

    public final void d(@Nullable final WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf hallInfo) {
        cacheHallInfo = hallInfo;
        if (hallInfo != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: jh4.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.e(WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.this);
                }
            }, 16, null, true);
        }
    }
}
