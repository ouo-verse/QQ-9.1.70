package no0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.selectmember.view.GuildAtSelectItemListView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import oo0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public class l extends c.AbstractC10933c implements c.d {

    /* renamed from: d, reason: collision with root package name */
    private int f420612d = 1;

    /* renamed from: e, reason: collision with root package name */
    private final xe1.b f420613e;

    /* renamed from: f, reason: collision with root package name */
    private final k f420614f;

    /* renamed from: h, reason: collision with root package name */
    private final String[] f420615h;

    /* renamed from: i, reason: collision with root package name */
    private GuildAtSelectItemListView f420616i;

    /* renamed from: m, reason: collision with root package name */
    private final vo0.b f420617m;

    public l(@NonNull xe1.b bVar, vo0.b bVar2, k kVar) {
        this.f420615h = r1;
        this.f420614f = kVar;
        this.f420613e = bVar;
        this.f420617m = bVar2;
        Resources resources = bVar.c().getResources();
        String[] strArr = {resources.getString(R.string.f139790c8), resources.getString(R.string.f146770v3)};
    }

    private boolean f(int i3) {
        GuildAtSelectItemListView guildAtSelectItemListView = this.f420616i;
        if (guildAtSelectItemListView != null) {
            return guildAtSelectItemListView.k(i3);
        }
        return false;
    }

    private GuildAtSelectItemListView j(xe1.b bVar, vo0.b bVar2) {
        if (this.f420616i == null) {
            GuildAtSelectItemListView guildAtSelectItemListView = new GuildAtSelectItemListView(new xo0.b(bVar.d(), bVar.a(), bVar.b(), bVar.c(), bVar.e()), bVar2, this.f420613e.k());
            this.f420616i = guildAtSelectItemListView;
            ViewGroup.LayoutParams b16 = so0.d.b(guildAtSelectItemListView.getLayoutParams(), -1, -1);
            b16.height = -1;
            b16.width = -1;
            this.f420616i.setLayoutParams(b16);
            this.f420616i.setPadding(0, 0, 0, this.f420614f.f420571a.f420605t);
            this.f420616i.setBackgroundColor(this.f420614f.f420572b.f420584k);
        }
        return this.f420616i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // oo0.c.AbstractC10933c
    public void e(c.f fVar) {
        fVar.f423258b.setBackgroundColor(this.f420614f.f420572b.f420582i);
        fVar.f423257a.setBackgroundColor(this.f420614f.f420572b.f420583j);
    }

    public boolean g(int i3, int i16) {
        if (i16 == 0) {
            return f(i3);
        }
        return false;
    }

    @Override // oo0.c.AbstractC10933c, androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f420612d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i3) {
        return this.f420615h[i3];
    }

    public GuildAtSelectItemListView h() {
        if (this.f420616i == null) {
            this.f420616i = j(this.f420613e, this.f420617m);
        }
        return this.f420616i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public View instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        GuildAtSelectItemListView j3 = j(this.f420613e, this.f420617m);
        viewGroup.addView(j3);
        return j3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void k(int i3) {
        QLog.d("GuildAtViewPagerAdapter2", 4, "currentTabCount = " + this.f420612d + " targetCount = " + i3);
        this.f420612d = Math.max(i3, 0);
        notifyDataSetChanged();
    }

    @Override // oo0.c.AbstractC10933c
    public void onDestroy() {
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildAtViewPagerAdapter2", 4, "onDestroy: remove callback and view");
        }
        GuildAtSelectItemListView guildAtSelectItemListView = this.f420616i;
        if (guildAtSelectItemListView != null) {
            guildAtSelectItemListView.j();
        }
    }

    @Override // oo0.c.d
    public void onPageSelected(int i3) {
    }
}
