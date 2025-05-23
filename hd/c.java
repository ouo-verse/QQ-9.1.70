package hd;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lhd/c;", "Lhd/b;", "", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_HINT, "(Ljava/lang/String;)V", "hint", "Lhd/c$a;", "f", "Lhd/c$a;", "d", "()Lhd/c$a;", "setOnConfirmListener", "(Lhd/c$a;)V", "onConfirmListener", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lhd/c$a;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String hint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a onConfirmListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lhd/c$a;", "", "", "input", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void a(String input);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String name, String hint, a onConfirmListener) {
        super(name, "", 4);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(onConfirmListener, "onConfirmListener");
        this.hint = hint;
        this.onConfirmListener = onConfirmListener;
    }

    /* renamed from: c, reason: from getter */
    public final String getHint() {
        return this.hint;
    }

    /* renamed from: d, reason: from getter */
    public final a getOnConfirmListener() {
        return this.onConfirmListener;
    }
}
