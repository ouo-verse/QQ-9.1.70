package lq0;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.guild.aio.panel.plus.subitem.GuildPagerRadioGroup;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Llq0/d;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "Llq0/i;", "d", "Llq0/i;", "mFactory", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "e", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "mPanelParam", "<init>", "(Llq0/i;Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "f", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d implements ViewPager.OnPageChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i mFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.part.root.panel.mvx.config.c mPanelParam;

    public d(@NotNull i mFactory, @NotNull com.tencent.aio.part.root.panel.mvx.config.c mPanelParam) {
        Intrinsics.checkNotNullParameter(mFactory, "mFactory");
        Intrinsics.checkNotNullParameter(mPanelParam, "mPanelParam");
        this.mFactory = mFactory;
        this.mPanelParam = mPanelParam;
    }

    @NotNull
    public final View a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        h d16 = this.mFactory.d(context);
        b bVar = new b(this.mFactory, this.mPanelParam);
        ViewPager c16 = d16.c();
        GuildPagerRadioGroup a16 = d16.a();
        c16.setAdapter(bVar);
        a16.setIndicatorInfo(this.mFactory.c());
        a16.b(bVar.getF373114d(), c16.getCurrentItem());
        c16.addOnPageChangeListener(a16);
        c16.addOnPageChangeListener(this);
        return d16.b();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        QLog.d("PlusPanel", 1, "onPageScrollStateChanged state=" + state);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        QLog.d("PlusPanel", 1, "onPageSelected position=" + position);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
