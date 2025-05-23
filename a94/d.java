package a94;

import androidx.fragment.app.Fragment;
import java.util.Stack;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"La94/d;", "", "Landroidx/fragment/app/Fragment;", "b", "<set-?>", "a", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "c", "(Landroidx/fragment/app/Fragment;)V", "current", "Ljava/util/Stack;", "Ljava/util/Stack;", "fragmentStack", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Fragment current;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Stack<Fragment> fragmentStack = new Stack<>();

    /* renamed from: a, reason: from getter */
    public final Fragment getCurrent() {
        return this.current;
    }

    public final Fragment b() {
        if (this.fragmentStack.isEmpty()) {
            return this.current;
        }
        return this.fragmentStack.peek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Fragment fragment) {
        this.current = fragment;
    }
}
