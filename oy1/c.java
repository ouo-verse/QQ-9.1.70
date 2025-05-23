package oy1;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildCalendarLayout;
import ny1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f424505a;

    /* renamed from: b, reason: collision with root package name */
    private final GuildCalendarLayout f424506b;

    /* renamed from: c, reason: collision with root package name */
    private final GuildScheduleCalendarHelper f424507c;

    /* renamed from: d, reason: collision with root package name */
    private final g f424508d;

    /* renamed from: e, reason: collision with root package name */
    private int f424509e;

    /* renamed from: f, reason: collision with root package name */
    private int f424510f;

    /* renamed from: g, reason: collision with root package name */
    private int f424511g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            float f17;
            float f18;
            if (c.this.f424505a.getCurrentItem() > i3) {
                f17 = c.this.f424510f;
                f18 = (c.this.f424509e - c.this.f424510f) * (1.0f - f16);
            } else {
                f17 = c.this.f424510f;
                f18 = (c.this.f424511g - c.this.f424510f) * f16;
            }
            int i17 = (int) (f17 + f18);
            ViewGroup.LayoutParams layoutParams = c.this.f424505a.getLayoutParams();
            if (layoutParams.height == i17) {
                return;
            }
            layoutParams.height = i17;
            c.this.f424505a.setLayoutParams(layoutParams);
            c.this.f424506b.s(i17);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            int i16 = c.this.f424507c.f233280w + (i3 / 12);
            int i17 = i3 % 12;
            c.this.p(i16, i17);
            c.this.f424507c.l(i16, i17);
            ViewGroup.LayoutParams layoutParams = c.this.f424505a.getLayoutParams();
            if (layoutParams.height == c.this.f424510f) {
                return;
            }
            layoutParams.height = c.this.f424510f;
            c.this.f424505a.setLayoutParams(layoutParams);
            c.this.f424506b.s(c.this.f424510f);
        }
    }

    public c(ViewPager2 viewPager2, GuildCalendarLayout guildCalendarLayout) {
        this.f424505a = viewPager2;
        this.f424506b = guildCalendarLayout;
        GuildScheduleCalendarHelper k3 = guildCalendarLayout.k();
        this.f424507c = k3;
        this.f424508d = new g(k3);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(py1.a aVar) {
        int currentItem = this.f424505a.getCurrentItem();
        int i3 = ((aVar.f428062a - this.f424507c.f233280w) * 12) + aVar.f428063b;
        if (currentItem != i3) {
            this.f424505a.setCurrentItem(i3, true);
        }
        RecyclerView.Adapter adapter = this.f424505a.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3, int i16) {
        int a16;
        int a17;
        this.f424510f = this.f424507c.a(i3, i16);
        if (i16 == 0) {
            a16 = this.f424507c.a(i3 - 1, 11);
        } else {
            a16 = this.f424507c.a(i3, i16 - 1);
        }
        this.f424509e = a16;
        if (i16 == 11) {
            a17 = this.f424507c.a(i3 + 1, 0);
        } else {
            a17 = this.f424507c.a(i3, i16 + 1);
        }
        this.f424511g = a17;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void i() {
        this.f424505a.setAdapter(this.f424508d);
        this.f424505a.registerOnPageChangeCallback(new a());
        this.f424508d.notifyDataSetChanged();
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.f424507c;
        py1.a aVar = guildScheduleCalendarHelper.f233279v;
        int i3 = aVar.f428062a;
        this.f424505a.setCurrentItem(((i3 - guildScheduleCalendarHelper.f233280w) * 12) + aVar.f428063b, false);
    }

    public void k() {
        RecyclerView.Adapter adapter = this.f424505a.getAdapter();
        int currentItem = this.f424505a.getCurrentItem();
        if (adapter != null) {
            adapter.notifyItemChanged(currentItem);
        }
    }

    public void l(final py1.a aVar) {
        ViewCompat.postOnAnimation(this.f424505a, new Runnable() { // from class: oy1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.j(aVar);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void m() {
        RecyclerView.Adapter adapter = this.f424505a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void n() {
        RecyclerView.Adapter adapter = this.f424505a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void o() {
        RecyclerView.Adapter adapter = this.f424505a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
