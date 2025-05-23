package ln3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lln3/a;", "", "", "reqData", "Lln3/a$a;", "callback", "", "a", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lln3/a$a;", "", "", "rspData", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ln3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC10739a {
        void onFail(int errCode, @Nullable String errMsg);

        void onReceive(@Nullable byte[] rspData);
    }

    void a(@NotNull byte[] reqData, @NotNull InterfaceC10739a callback);
}
