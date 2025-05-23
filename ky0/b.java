package ky0;

import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$BatchGetUserInfoReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ox0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lky0/b;", "Lox0/a;", "", "b", "<init>", "()V", "d", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends ox0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Lky0/b$a;", "", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userIdList", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ky0.b$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NewIntent a(@NotNull List<CommonOuterClass$QQUserId> userIdList) {
            Intrinsics.checkNotNullParameter(userIdList, "userIdList");
            UserProxyCmdOuterClass$BatchGetUserInfoReq userProxyCmdOuterClass$BatchGetUserInfoReq = new UserProxyCmdOuterClass$BatchGetUserInfoReq();
            userProxyCmdOuterClass$BatchGetUserInfoReq.qq_user_id_list.set(userIdList);
            return a.C10966a.a(userProxyCmdOuterClass$BatchGetUserInfoReq, b.class);
        }

        Companion() {
        }
    }

    @Override // ox0.a
    protected int b() {
        return 103;
    }
}
