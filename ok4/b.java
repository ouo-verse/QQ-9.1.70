package ok4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0002\u001a\u00020\u0000R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\b\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lok4/b;", "", "b", "", "a", "Ljava/lang/String;", "data", "", "I", "()I", "setGiftId", "(I)V", "giftId", "<init>", "(Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int giftId;

    public b(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* renamed from: a, reason: from getter */
    public final int getGiftId() {
        return this.giftId;
    }

    @NotNull
    public final b b() {
        this.giftId = new JSONObject(this.data).optInt("gift_id", 0);
        return this;
    }
}
