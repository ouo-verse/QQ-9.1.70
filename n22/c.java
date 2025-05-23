package n22;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.icgame.framework.page.Page;
import i22.OrientationChangedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Ln22/c;", "", "Ln22/b;", "", MiniChatConstants.MINI_APP_LANDSCAPE, "", "a", h.F, "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "trigger", "b", "Z", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Page trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    public c(@NotNull Page trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
    }

    public void a(boolean isLandscape) {
        this.isLandscape = isLandscape;
        this.trigger.a(new OrientationChangedEvent(isLandscape));
    }

    @Override // n22.b
    /* renamed from: h, reason: from getter */
    public boolean getIsLandscape() {
        return this.isLandscape;
    }
}
