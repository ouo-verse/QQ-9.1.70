package a4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tenpay.pay.PayChannelUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qk2.ServiceManagerConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CompoundButton.OnCheckedChangeListener {
    private final List<Object> C = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Context f25454m;

    /* compiled from: P */
    /* renamed from: a4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0010a extends RecyclerView.ViewHolder {
        private final ImageView E;
        private final TextView F;
        private final Switch G;
        private final View H;

        public C0010a(View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.f165733da3);
            this.F = (TextView) view.findViewById(R.id.xxx);
            this.G = (Switch) view.findViewById(R.id.m_b);
            this.H = view.findViewById(R.id.xsp);
        }

        public void m(int i3, c cVar) {
            PayChannelUtils.BgRadiusEnum bgRadiusEnum;
            if (cVar != null && cVar.f25455a != null) {
                if (!TextUtils.isEmpty(cVar.f25455a.f41556c)) {
                    Drawable drawable = ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.frq, null);
                    this.E.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(cVar.f25455a.f41556c, drawable, drawable));
                }
                if (!TextUtils.isEmpty(cVar.f25455a.f41555b)) {
                    this.F.setText(cVar.f25455a.f41555b);
                }
                this.G.setTag(cVar);
                this.G.setChecked(cVar.f25456b);
                if (cVar.f25458d == 1) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BothRound;
                    this.H.setVisibility(8);
                } else if (cVar.f25457c == 0) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.TopRound;
                    this.H.setVisibility(0);
                } else if (cVar.f25457c == cVar.f25458d - 1) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BottomRound;
                    this.H.setVisibility(8);
                } else {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.NONE;
                    this.H.setVisibility(0);
                }
                View view = this.itemView;
                PayChannelUtils.updateBgRound(view, bgRadiusEnum, x.c(view.getContext(), 8.0f));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b extends RecyclerView.ViewHolder {
        private final TextView E;

        public b(View view, boolean z16) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.xxx);
            this.E = textView;
            if (z16) {
                view.getLayoutParams().height = -2;
                ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = x.c(textView.getContext(), 16.0f);
            }
        }

        public void l(d dVar) {
            this.E.setText(dVar.f25459a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final com.qwallet.data.c f25455a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25456b;

        /* renamed from: c, reason: collision with root package name */
        private final int f25457c;

        /* renamed from: d, reason: collision with root package name */
        private final int f25458d;

        public c(com.qwallet.data.c cVar, boolean z16, int i3, int i16) {
            this.f25455a = cVar;
            this.f25456b = z16;
            this.f25457c = i3;
            this.f25458d = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f25459a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f25460b;

        public d(String str, boolean z16) {
            this.f25459a = str;
            this.f25460b = z16;
        }
    }

    public a(Context context) {
        this.f25454m = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        Object obj = this.C.get(i3);
        if (obj instanceof d) {
            if (((d) obj).f25460b) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    public void i0(LinkedHashMap<String, List<c>> linkedHashMap) {
        this.C.clear();
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            Set<Map.Entry<String, List<c>>> entrySet = linkedHashMap.entrySet();
            this.C.add(new d(((ServiceManagerConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_SERVICE_MANAGER_CONFIG, new ServiceManagerConfig())).getContent().getText(), true));
            for (Map.Entry<String, List<c>> entry : entrySet) {
                this.C.add(new d(entry.getKey(), false));
                this.C.addAll(entry.getValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        Object obj = this.C.get(i3);
        if ((viewHolder instanceof C0010a) && (obj instanceof c)) {
            ((C0010a) viewHolder).m(i3, (c) obj);
        } else if ((viewHolder instanceof b) && (obj instanceof d)) {
            ((b) viewHolder).l((d) obj);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Object tag = compoundButton.getTag();
        if (tag instanceof c) {
            c cVar = (c) tag;
            cVar.f25456b = z16;
            QLog.i("QWalletServiceRvAdapter", 2, cVar.f25455a.f41555b + cVar.f25456b);
            g.l(QWalletUtils.g(cVar.f25455a.f41554a), z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        boolean z16 = false;
        if (i3 == 2) {
            C0010a c0010a = new C0010a(from.inflate(R.layout.f168986hk3, viewGroup, false));
            c0010a.G.setOnCheckedChangeListener(this);
            return c0010a;
        }
        View inflate = from.inflate(R.layout.f168987hk4, viewGroup, false);
        if (i3 == 0) {
            z16 = true;
        }
        return new b(inflate, z16);
    }
}
