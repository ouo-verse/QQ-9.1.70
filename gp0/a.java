package gp0;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lgp0/a;", "Loo0/a;", "", "d", "Landroid/view/ViewGroup;", "content", "", h.F, "b", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lfp0/b;", "Lfp0/b;", "panelStyle", "<init>", "(Landroid/content/Context;Lfp0/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends oo0.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fp0.b panelStyle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull fp0.b panelStyle) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelStyle, "panelStyle");
        this.context = context;
        this.panelStyle = panelStyle;
    }

    @Override // oo0.a
    protected int b() {
        return R.layout.f_9;
    }

    @Override // oo0.a
    public int d() {
        ViewGroup viewGroup = this.f423246b;
        if (viewGroup != null) {
            int height = viewGroup.getHeight();
            if (height <= 0) {
                return this.panelStyle.getDimen().getLittleTongueHeight();
            }
            return height;
        }
        return 0;
    }

    @Override // oo0.a
    protected void h(@NotNull ViewGroup content) {
        Intrinsics.checkNotNullParameter(content, "content");
        content.setLayoutParams(new ViewGroup.LayoutParams(-1, this.panelStyle.getDimen().getLittleTongueHeight()));
        content.findViewById(R.id.vyx).setBackgroundResource(this.panelStyle.getDrawable().getLittleTongueLeverIcon());
    }
}
