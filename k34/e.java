package k34;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lk34/e;", "Lk34/a;", "", "getItemType", "", "getItemId", "", "d", "Z", "a", "()Z", "b", "(Z)V", ViewStickEventHelper.IS_SHOW, "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    public e(boolean z16) {
        this.isShow = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void b(boolean z16) {
        this.isShow = z16;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return "5";
    }

    @Override // k34.a
    public int getItemType() {
        return 5;
    }
}
