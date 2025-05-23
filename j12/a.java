package j12;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import j12.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private int f409088d = 8;

    /* renamed from: e, reason: collision with root package name */
    private int f409089e = 4;

    /* renamed from: f, reason: collision with root package name */
    private List<giftList$GroupGiftItem> f409090f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.guild.vas.panel.b f409091h;

    public a(List<giftList$GroupGiftItem> list, com.tencent.mobileqq.guild.vas.panel.b bVar) {
        new ArrayList();
        this.f409090f = list;
        this.f409091h = bVar;
        b.C = 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void g(List<giftList$GroupGiftItem> list) {
        synchronized (this) {
            this.f409090f = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<giftList$GroupGiftItem> list = this.f409090f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return (this.f409090f.size() / this.f409088d) + (this.f409090f.size() % this.f409088d != 0 ? 1 : 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        C10560a c10560a = new C10560a(viewGroup);
        View view = c10560a.f409092a;
        c10560a.b(i3);
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* renamed from: j12.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10560a {

        /* renamed from: a, reason: collision with root package name */
        private View f409092a;

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f409093b;

        /* compiled from: P */
        /* renamed from: j12.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10561a extends GridLayoutManager {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f409095a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C10561a(Context context, int i3, a aVar) {
                super(context, i3);
                this.f409095a = aVar;
            }

            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        }

        public C10560a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hgk, (ViewGroup) null, false);
            this.f409092a = inflate;
            this.f409093b = (RecyclerView) inflate.findViewById(R.id.vpg);
            this.f409093b.setLayoutManager(new C10561a(viewGroup.getContext(), a.this.f409089e, a.this));
        }

        public void b(int i3) {
            if (this.f409093b != null) {
                j12.b bVar = new j12.b(a.this.f409090f, i3);
                bVar.t(new b());
                this.f409093b.setAdapter(bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: j12.a$a$b */
        /* loaded from: classes38.dex */
        public class b implements b.c {
            b() {
            }

            @Override // j12.b.c
            public void a(View view, int i3, int i16) {
                a.this.f409091h.e(i3, i16);
            }

            @Override // j12.b.c
            public void onItemClick(View view, int i3) {
            }
        }
    }
}
