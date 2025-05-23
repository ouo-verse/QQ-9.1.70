package oy1;

import android.annotation.SuppressLint;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildCalendarLayout;
import ny1.h;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f424515a;

    /* renamed from: b, reason: collision with root package name */
    private final GuildScheduleCalendarHelper f424516b;

    /* renamed from: c, reason: collision with root package name */
    private final h f424517c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            e.this.f424516b.m(i3);
        }
    }

    public e(ViewPager2 viewPager2, GuildCalendarLayout guildCalendarLayout) {
        this.f424515a = viewPager2;
        GuildScheduleCalendarHelper k3 = guildCalendarLayout.k();
        this.f424516b = k3;
        this.f424517c = new h(k3);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(py1.a aVar) {
        int currentItem = this.f424515a.getCurrentItem();
        int w3 = this.f424516b.w(aVar.f428062a, aVar.f428063b, aVar.f428064c);
        if (currentItem != w3) {
            this.f424515a.setCurrentItem(w3, false);
        }
        RecyclerView.Adapter adapter = this.f424515a.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(w3);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void c() {
        this.f424515a.setAdapter(this.f424517c);
        this.f424515a.registerOnPageChangeCallback(new a());
        this.f424517c.notifyDataSetChanged();
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.f424516b;
        py1.a aVar = guildScheduleCalendarHelper.f233279v;
        this.f424515a.setCurrentItem(guildScheduleCalendarHelper.w(aVar.f428062a, aVar.f428063b, aVar.f428064c), false);
    }

    public void e() {
        RecyclerView.Adapter adapter = this.f424515a.getAdapter();
        int currentItem = this.f424515a.getCurrentItem();
        if (adapter != null) {
            adapter.notifyItemChanged(currentItem);
        }
    }

    public void f(final py1.a aVar) {
        ViewCompat.postOnAnimation(this.f424515a, new Runnable() { // from class: oy1.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.d(aVar);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void g() {
        RecyclerView.Adapter adapter = this.f424515a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void h() {
        RecyclerView.Adapter adapter = this.f424515a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void i() {
        RecyclerView.Adapter adapter = this.f424515a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
