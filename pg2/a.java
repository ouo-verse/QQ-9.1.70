package pg2;

import com.tencent.ecommerce.base.proto.ECPBParser;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022)\u0010\u000b\u001a%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n\u00a8\u0006\u000f"}, d2 = {"Lpg2/a;", "", "", "pbToken", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lkotlin/ParameterName;", "name", "pb", "", "Lcom/tencent/ecommerce/base/proto/ParserPBCallback;", "callback", "a", "<init>", "()V", "qqecommerce_shell_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f426173a = new a();

    a() {
    }

    public final void a(@NotNull String pbToken, @NotNull Function1<? super MessageMicro<?>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pbToken, "pbToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ECPBParser.f100901b.e(pbToken, callback);
    }
}
