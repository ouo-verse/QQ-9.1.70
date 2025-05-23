package gy0;

import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQNearbyUserInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lgy0/c;", "", "", "a", "", "b", "c", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "getNearbyInfo", "()Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "nearbyInfo", "<init>", "(Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final UserProxyCmdOuterClass$QQNearbyUserInfo nearbyInfo;

    public c(@Nullable UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo) {
        this.nearbyInfo = userProxyCmdOuterClass$QQNearbyUserInfo;
    }

    @NotNull
    public String a() {
        String str;
        PBStringField pBStringField;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = this.nearbyInfo;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null && (pBStringField = userProxyCmdOuterClass$QQNearbyUserInfo.logo) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public int b() {
        PBUInt32Field pBUInt32Field;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = this.nearbyInfo;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null && (pBUInt32Field = userProxyCmdOuterClass$QQNearbyUserInfo.gender) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    @NotNull
    public String c() {
        String str;
        PBStringField pBStringField;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = this.nearbyInfo;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null && (pBStringField = userProxyCmdOuterClass$QQNearbyUserInfo.nick) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
