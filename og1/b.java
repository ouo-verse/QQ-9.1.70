package og1;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import og1.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H&R\u001c\u0010\n\u001a\u00028\u00008&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Log1/b;", "Log1/a;", "Options", "", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "a", "getOptions", "()Log1/a;", "setOptions", "(Log1/a;)V", "options", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface b<Options extends a> {
    @NotNull
    ViewPager2.OnPageChangeCallback a();

    @NotNull
    Options getOptions();

    void setOptions(@NotNull Options options);
}
