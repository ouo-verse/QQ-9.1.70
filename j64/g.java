package j64;

import com.tencent.robot.slash.dialog.search.SearchException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000 \u000f2\u00020\u0001:\u0002\t\u000bB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lj64/g;", "", "", "e", "f", "Lj64/g$b;", "callback", "", "i", "a", "Lcom/tencent/robot/slash/dialog/search/SearchException;", "b", "g", tl.h.F, "", "c", "d", "", "I", "mState", "Lj64/g$b;", "mSearchCallback", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mSearchCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lj64/g$b;", "", "Lj64/g;", "searchContext", "Lcom/tencent/robot/slash/dialog/search/SearchException;", "e", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@NotNull g searchContext, @Nullable SearchException e16);
    }

    public void a() {
        int i3 = this.mState;
        if (i3 != 1 && i3 != 3) {
            return;
        }
        this.mState = 3;
        b bVar = this.mSearchCallback;
        if (bVar != null) {
            bVar.a(this, null);
        }
    }

    public void b(@NotNull SearchException e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.mState != 1) {
            return;
        }
        this.mState = 4;
        b bVar = this.mSearchCallback;
        if (bVar != null) {
            bVar.a(this, e16);
        }
    }

    @NotNull
    public abstract String c();

    @Nullable
    public abstract Object d();

    public boolean e() {
        if (this.mState == 2) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.mState == 3) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract void h();

    public void i(@Nullable b callback) {
        if (this.mState != 0) {
            return;
        }
        this.mState = 1;
        this.mSearchCallback = callback;
        h();
    }
}
