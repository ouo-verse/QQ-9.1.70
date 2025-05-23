package o53;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleViewModel;
import com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarStyleListFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lo53/e;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "position", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;", "d", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "", "f", "e", "getCount", "", "getPageTitle", "Landroidx/fragment/app/Fragment;", "getItem", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "aiAvatarViewModel", "", "Ljava/util/List;", "fragmentList", "Landroidx/fragment/app/FragmentManager;", "fragmentMgr", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;Landroidx/fragment/app/FragmentManager;)V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends FragmentPagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAIAvatarStyleViewModel aiAvatarViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MetaCategory> categories;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<WinkAIAvatarStyleListFragment> fragmentList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@Nullable WinkAIAvatarStyleViewModel winkAIAvatarStyleViewModel, @NotNull FragmentManager fragmentMgr) {
        super(fragmentMgr, 1);
        Intrinsics.checkNotNullParameter(fragmentMgr, "fragmentMgr");
        this.aiAvatarViewModel = winkAIAvatarStyleViewModel;
        this.categories = new ArrayList();
        this.fragmentList = new ArrayList();
    }

    private final WinkAIAvatarStyleListFragment d(int position) {
        if (!this.fragmentList.isEmpty() && position < this.fragmentList.size()) {
            return this.fragmentList.get(position);
        }
        return null;
    }

    public final void e() {
        WinkAIAvatarStyleListFragment d16;
        WinkAIAvatarStyleViewModel winkAIAvatarStyleViewModel = this.aiAvatarViewModel;
        if (winkAIAvatarStyleViewModel != null && (d16 = d(winkAIAvatarStyleViewModel.getTargetStyleTabPosition())) != null) {
            d16.sh();
        }
    }

    public final void f(@NotNull List<MetaCategory> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.categories.clear();
        this.categories.addAll(categories);
        this.fragmentList.clear();
        w53.b.f("WinkAIAvatarPagerAdapter", "new categories ==> " + categories.size());
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.categories.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        Integer num;
        Integer num2;
        WinkAIAvatarStyleViewModel winkAIAvatarStyleViewModel = this.aiAvatarViewModel;
        boolean z16 = false;
        if (winkAIAvatarStyleViewModel != null && position == winkAIAvatarStyleViewModel.getTargetStyleTabPosition()) {
            z16 = true;
        }
        Integer num3 = null;
        if (z16) {
            WinkAIAvatarStyleViewModel winkAIAvatarStyleViewModel2 = this.aiAvatarViewModel;
            if (winkAIAvatarStyleViewModel2 != null) {
                num2 = Integer.valueOf(winkAIAvatarStyleViewModel2.getTargetStyleGroupPosition());
            } else {
                num2 = null;
            }
            WinkAIAvatarStyleViewModel winkAIAvatarStyleViewModel3 = this.aiAvatarViewModel;
            if (winkAIAvatarStyleViewModel3 != null) {
                num3 = Integer.valueOf(winkAIAvatarStyleViewModel3.getTargetStyleItemPosition());
            }
            Integer num4 = num2;
            num = num3;
            num3 = num4;
        } else {
            num = null;
        }
        WinkAIAvatarStyleListFragment a16 = WinkAIAvatarStyleListFragment.INSTANCE.a(this.categories.get(position), num3, num);
        this.fragmentList.add(a16);
        return a16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        return this.categories.get(position).name;
    }
}
