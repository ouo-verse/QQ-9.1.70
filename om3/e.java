package om3;

import com.tencent.now.linkpkanchorplay.event.UIEvent;
import g55.ag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\rH&J\b\u0010\u001b\u001a\u00020\rH&J\b\u0010\u001c\u001a\u00020\u0007H&\u00a8\u0006\u001d"}, d2 = {"Lom3/e;", "", "Lom3/d;", "getCurrentState", "Le55/a;", "f", "anchorInfo", "", "bizType", "", "inviteID", "", h.F, "", "isSelfCancel", "c", "Lg55/ag;", "inviteMsg", "g", "isAccept", "e", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "pkType", "a", "Le55/c;", "b", "d", "i", "getBizType", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface e {
    void a(@NotNull UIEvent.PKType pkType);

    void b(int pkType, @Nullable e55.c anchorInfo);

    void c(boolean isSelfCancel);

    boolean d();

    void e(boolean isAccept, int bizType, @NotNull e55.a anchorInfo);

    @Nullable
    e55.a f();

    void g(@NotNull ag inviteMsg);

    int getBizType();

    @NotNull
    d getCurrentState();

    void h(@NotNull e55.a anchorInfo, int bizType, @NotNull String inviteID);

    boolean i();
}
