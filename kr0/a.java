package kr0;

import android.widget.EditText;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lkr0/a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lkr0/a$a;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lkr0/a$a;", "Lkr0/a;", "Landroid/widget/EditText;", "a", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "input", "<init>", "(Landroid/widget/EditText;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kr0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C10677a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EditText input;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10677a(@NotNull EditText input) {
            super(null);
            Intrinsics.checkNotNullParameter(input, "input");
            this.input = input;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EditText getInput() {
            return this.input;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
