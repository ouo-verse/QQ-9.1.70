package ho4;

import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import pl4.a;
import trpc.yes.common.SafeOuterClass$GetUserPrivIdReq;
import trpc.yes.common.SafeOuterClass$GetUserPrivIdRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lho4/e;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u000b"}, d2 = {"Lho4/e$a;", "", "Lmqq/app/NewIntent;", "a", "Lpl4/d;", "Ltrpc/yes/common/SafeOuterClass$GetUserPrivIdRsp;", "requestListener", "", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ho4.e$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final NewIntent a() {
            NewIntent a16 = a.C11028a.a(new MessageMicro<SafeOuterClass$GetUserPrivIdReq>() { // from class: trpc.yes.common.SafeOuterClass$GetUserPrivIdReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SafeOuterClass$GetUserPrivIdReq.class);
            }, e.class);
            Intrinsics.checkNotNullExpressionValue(a16, "createRequestIntent(\n   \u2026:class.java\n            )");
            return a16;
        }

        public final void b(@NotNull pl4.d<SafeOuterClass$GetUserPrivIdRsp> requestListener) {
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            ((pl4.c) mm4.b.b(pl4.c.class)).F1(a(), SafeOuterClass$GetUserPrivIdRsp.class, requestListener);
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 1003;
    }
}
