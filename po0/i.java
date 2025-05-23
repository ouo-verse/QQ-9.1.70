package po0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import no0.k;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i<E> extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final k f426597d;

    /* renamed from: e, reason: collision with root package name */
    private final View f426598e;

    /* renamed from: f, reason: collision with root package name */
    private final c f426599f;

    /* renamed from: h, reason: collision with root package name */
    private String f426600h = "0";

    /* renamed from: i, reason: collision with root package name */
    private List<b<E>> f426601i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private a<E> f426602m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    interface a<E> {
        void a(int i3, b<E> bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b<E> {
        Drawable a();

        E getData();

        String getId();

        CharSequence getText();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        int f426603a;

        /* renamed from: b, reason: collision with root package name */
        View f426604b;

        /* renamed from: c, reason: collision with root package name */
        TextView f426605c;

        /* renamed from: d, reason: collision with root package name */
        GuildUserAvatarView f426606d;

        /* renamed from: e, reason: collision with root package name */
        View f426607e;

        c(View view, int i3) {
            a(view, i3);
        }

        void a(View view, int i3) {
            this.f426603a = i3;
            this.f426604b = view;
            if (i3 == 0) {
                this.f426606d = (GuildUserAvatarView) view.findViewById(R.id.xsl);
                this.f426605c = (TextView) this.f426604b.findViewById(R.id.xw7);
                this.f426607e = null;
            } else {
                this.f426607e = view;
                this.f426606d = null;
                this.f426605c = null;
            }
            this.f426604b.setTag(this);
        }
    }

    public i(k kVar, View view) {
        this.f426597d = kVar;
        this.f426598e = view;
        this.f426599f = new c(view, 1);
    }

    protected static void b(k kVar, c cVar) {
        ViewGroup.LayoutParams f16 = f(cVar.f426604b.getLayoutParams());
        f16.height = kVar.f420571a.f420590e;
        f16.width = -1;
        cVar.f426604b.setLayoutParams(f16);
        cVar.f426604b.setBackgroundResource(kVar.f420573c.f420608c);
    }

    protected static void c(k kVar, c cVar, int i3) {
        ViewGroup.LayoutParams f16 = f(cVar.f426604b.getLayoutParams());
        k.b bVar = kVar.f420571a;
        f16.height = bVar.f420596k;
        Objects.requireNonNull(bVar);
        int screenWidth = ViewUtils.getScreenWidth();
        k.b bVar2 = kVar.f420571a;
        int i16 = screenWidth - (bVar2.f420591f * 2);
        int i17 = bVar2.f420594i;
        f16.width = (((i16 - i17) / 4) * (4 - (i3 % 4))) - i17;
        cVar.f426604b.setLayoutParams(f16);
        cVar.f426604b.setBackgroundColor(kVar.f420572b.f420577d);
        cVar.f426604b.setClickable(true);
        cVar.f426604b.setFocusable(true);
    }

    protected static void d(k kVar, c cVar, int i3) {
        if (cVar.f426603a == 0) {
            b(kVar, cVar);
        } else {
            c(kVar, cVar, i3);
        }
    }

    protected static ViewGroup.LayoutParams f(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-2, -2);
        }
        return layoutParams;
    }

    private int g(int i3) {
        if (i3 == getCount() - 1) {
            return 1;
        }
        return 0;
    }

    public void a(String str, b<E> bVar) {
        if (bVar != null) {
            this.f426600h = str;
            this.f426601i.add(bVar);
            notifyDataSetChanged();
        }
    }

    protected void e(b<E> bVar, c cVar) {
        if (bVar != null) {
            cVar.f426605c.setText(bVar.getText());
            if (bVar.a() == null) {
                cVar.f426606d.setAvatarTinyId(this.f426600h, bVar.getId());
            } else {
                cVar.f426606d.setAvatarTinyId(this.f426600h, null);
                cVar.f426606d.setImageDrawable(bVar.a());
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f426601i.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (i3 == getCount() - 1) {
            return null;
        }
        return this.f426601i.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (g(i3) == 1) {
            return -1;
        }
        return super.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b<E> bVar;
        c cVar;
        View view2;
        int g16 = g(i3);
        if (g16 == 1) {
            cVar = this.f426599f;
            view2 = cVar.f426604b;
        } else {
            if (view == null || view.equals(this.f426598e)) {
                view = h(viewGroup.getContext());
            }
            if (g16 == 0) {
                bVar = this.f426601i.get(i3);
            } else {
                bVar = null;
            }
            if (view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                cVar = new c(view, g16);
            }
            e(bVar, cVar);
            view2 = cVar.f426604b;
        }
        View view3 = view;
        d(this.f426597d, cVar, i3);
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    protected View h(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ega, (ViewGroup) null);
    }

    public void i() {
        this.f426601i.clear();
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(E e16) {
        int i3 = 0;
        while (i3 < this.f426601i.size() && !this.f426601i.get(i3).getData().equals(e16)) {
            if ((e16 instanceof AtUserWithRoleInfo) && (this.f426601i.get(i3).getData() instanceof AtUserWithRoleInfo)) {
                if (((AtUserWithRoleInfo) e16).getKey().equals(((AtUserWithRoleInfo) this.f426601i.get(i3).getData()).getKey())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                if ((e16 instanceof IGProUserInfo) && (this.f426601i.get(i3).getData() instanceof IGProUserInfo)) {
                    if (((IGProUserInfo) e16).getTinyId().equals(((IGProUserInfo) this.f426601i.get(i3).getData()).getTinyId())) {
                        break;
                    }
                }
                i3++;
            }
        }
        if (i3 < this.f426601i.size()) {
            this.f426601i.remove(i3);
            notifyDataSetChanged();
        }
    }

    public void k(a<E> aVar) {
        this.f426602m = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        if (this.f426602m != null && i3 < getCount() - 1) {
            this.f426602m.a(i3, this.f426601i.get(i3));
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }
}
