package ni4;

import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lni4/c;", "", "", "roomId", "", "a", "(Ljava/lang/Long;)I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f420216a = new c();

    c() {
    }

    public final int a(@Nullable Long roomId) {
        if (roomId != null && roomId.longValue() > 0) {
            return QQLiveSDKConfigHelper.getSceneIdByRoomType(wj4.c.a(roomId.longValue()));
        }
        return 10008;
    }
}
