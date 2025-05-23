package com.tencent.mobileqq.guild.widget.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.guild.widget.circleindicator.GuildBaseCircleIndicator;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCircleIndicator extends GuildBaseCircleIndicator {
    private ViewPager2 I;
    private final ViewPager2.OnPageChangeCallback J;
    private final RecyclerView.AdapterDataObserver K;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            GuildCircleIndicator guildCircleIndicator = GuildCircleIndicator.this;
            if (i3 != guildCircleIndicator.H && guildCircleIndicator.I.getAdapter() != null && GuildCircleIndicator.this.I.getAdapter().getItemCount() > 0) {
                GuildCircleIndicator.this.b(i3);
            }
        }
    }

    public GuildCircleIndicator(Context context) {
        super(context);
        this.J = new a();
        this.K = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int itemCount;
        RecyclerView.Adapter adapter = this.I.getAdapter();
        if (adapter == null) {
            itemCount = 0;
        } else {
            itemCount = adapter.getItemCount();
        }
        f(itemCount, this.I.getCurrentItem());
    }

    @Override // com.tencent.mobileqq.guild.widget.circleindicator.GuildBaseCircleIndicator
    public /* bridge */ /* synthetic */ void b(int i3) {
        super.b(i3);
    }

    @Override // com.tencent.mobileqq.guild.widget.circleindicator.GuildBaseCircleIndicator
    public /* bridge */ /* synthetic */ void f(int i3, int i16) {
        super.f(i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.widget.circleindicator.GuildBaseCircleIndicator
    public /* bridge */ /* synthetic */ void i(com.tencent.mobileqq.guild.widget.circleindicator.a aVar) {
        super.i(aVar);
    }

    @Override // com.tencent.mobileqq.guild.widget.circleindicator.GuildBaseCircleIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable GuildBaseCircleIndicator.a aVar) {
        super.setIndicatorCreatedListener(aVar);
    }

    public void setViewPager(@Nullable ViewPager2 viewPager2) {
        this.I = viewPager2;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.H = -1;
            l();
            this.I.unregisterOnPageChangeCallback(this.J);
            this.I.registerOnPageChangeCallback(this.J);
            this.J.onPageSelected(this.I.getCurrentItem());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            int i3;
            super.onChanged();
            if (GuildCircleIndicator.this.I == null) {
                return;
            }
            RecyclerView.Adapter adapter = GuildCircleIndicator.this.I.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i3 == GuildCircleIndicator.this.getChildCount()) {
                return;
            }
            GuildCircleIndicator guildCircleIndicator = GuildCircleIndicator.this;
            if (guildCircleIndicator.H < i3) {
                guildCircleIndicator.H = guildCircleIndicator.I.getCurrentItem();
            } else {
                guildCircleIndicator.H = -1;
            }
            GuildCircleIndicator.this.l();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            super.onItemRangeChanged(i3, i16);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            super.onItemRangeInserted(i3, i16);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            super.onItemRangeMoved(i3, i16, i17);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            super.onItemRangeRemoved(i3, i16);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, @Nullable Object obj) {
            super.onItemRangeChanged(i3, i16, obj);
            onChanged();
        }
    }

    public GuildCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new a();
        this.K = new b();
    }

    public GuildCircleIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = new a();
        this.K = new b();
    }
}
