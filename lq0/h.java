package lq0;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.guild.aio.panel.plus.subitem.GuildPagerRadioGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Llq0/h;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "e", "(Landroid/view/View;)V", "root", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/viewpager/widget/ViewPager;", "c", "()Landroidx/viewpager/widget/ViewPager;", "f", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPager", "Lcom/tencent/guild/aio/panel/plus/subitem/GuildPagerRadioGroup;", "Lcom/tencent/guild/aio/panel/plus/subitem/GuildPagerRadioGroup;", "()Lcom/tencent/guild/aio/panel/plus/subitem/GuildPagerRadioGroup;", "d", "(Lcom/tencent/guild/aio/panel/plus/subitem/GuildPagerRadioGroup;)V", "pagerRadioGroup", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public View root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public ViewPager viewPager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public GuildPagerRadioGroup pagerRadioGroup;

    @NotNull
    public final GuildPagerRadioGroup a() {
        GuildPagerRadioGroup guildPagerRadioGroup = this.pagerRadioGroup;
        if (guildPagerRadioGroup != null) {
            return guildPagerRadioGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerRadioGroup");
        return null;
    }

    @NotNull
    public final View b() {
        View view = this.root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @NotNull
    public final ViewPager c() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            return viewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    public final void d(@NotNull GuildPagerRadioGroup guildPagerRadioGroup) {
        Intrinsics.checkNotNullParameter(guildPagerRadioGroup, "<set-?>");
        this.pagerRadioGroup = guildPagerRadioGroup;
    }

    public final void e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.root = view;
    }

    public final void f(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }
}
