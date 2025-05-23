package do4;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass$QQNearbyUserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ldo4/c;", "Lbo4/e;", "", "c", "", "d", "a", "", "b", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "getNearbyInfo", "()Ltrpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "nearbyInfo", "<init>", "(Ltrpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements bo4.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final UserProxyCmdOuterClass$QQNearbyUserInfo nearbyInfo;

    public c(@Nullable UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo) {
        this.nearbyInfo = userProxyCmdOuterClass$QQNearbyUserInfo;
    }

    @Override // bo4.e
    @NotNull
    public String a() {
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

    @Override // bo4.e
    public long b() {
        PBUInt64Field pBUInt64Field;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = this.nearbyInfo;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null && (pBUInt64Field = userProxyCmdOuterClass$QQNearbyUserInfo.tiny_id) != null) {
            return pBUInt64Field.get();
        }
        return 0L;
    }

    @NotNull
    public String c() {
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

    public int d() {
        PBUInt32Field pBUInt32Field;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = this.nearbyInfo;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null && (pBUInt32Field = userProxyCmdOuterClass$QQNearbyUserInfo.gender) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }
}
