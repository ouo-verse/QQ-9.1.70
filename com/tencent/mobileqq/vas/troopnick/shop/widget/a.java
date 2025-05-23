package com.tencent.mobileqq.vas.troopnick.shop.widget;

import QC.CGetChiefRsp;
import QC.ItemDisDetail;
import QC.ModuleData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends RecyclerView.Adapter<b> {
    private c C;

    /* renamed from: e, reason: collision with root package name */
    private ShopLayout.e f311096e;

    /* renamed from: h, reason: collision with root package name */
    private Context f311098h;

    /* renamed from: i, reason: collision with root package name */
    private d f311099i;

    /* renamed from: m, reason: collision with root package name */
    private d f311100m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<d> f311095d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    protected int f311097f = -1;
    private boolean D = true;
    private boolean E = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.troopnick.shop.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class ViewOnClickListenerC8930a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        long f311101d = 0;

        ViewOnClickListenerC8930a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f311101d;
            if (j3 == 0 || currentTimeMillis - j3 > 2000) {
                o33.a.b(2, "svip_pay", 4, 102);
                a.this.C.b();
                this.f311101d = currentTimeMillis;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView C;
        public TextView D;

        /* renamed from: d, reason: collision with root package name */
        public TextView f311103d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f311104e;

        /* renamed from: f, reason: collision with root package name */
        public RoundRelativeLayout f311105f;

        /* renamed from: h, reason: collision with root package name */
        public LinearLayout f311106h;

        /* renamed from: i, reason: collision with root package name */
        public Button f311107i;

        /* renamed from: m, reason: collision with root package name */
        public boolean f311108m;

        public b(View view) {
            super(view);
            this.f311108m = false;
            this.f311103d = (TextView) view.findViewById(R.id.tv_name);
            this.f311104e = (ImageView) view.findViewById(R.id.dex);
            this.f311105f = (RoundRelativeLayout) view.findViewById(R.id.f164600a83);
            this.f311106h = (LinearLayout) view.findViewById(R.id.gg7);
            this.f311107i = (Button) view.findViewById(R.id.xxo);
            this.C = (TextView) view.findViewById(R.id.f9029523);
            this.D = (TextView) view.findViewById(R.id.f167032mc1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final d f311120d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f311121e;

        public e(d dVar, boolean z16) {
            this.f311120d = dVar;
            this.f311121e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = a.this;
            d dVar = this.f311120d;
            aVar.f311097f = dVar.f311113e;
            aVar.f311100m = dVar;
            a aVar2 = a.this;
            aVar2.w(aVar2.f311100m);
            if (this.f311121e) {
                a.this.C.a();
            }
            d dVar2 = this.f311120d;
            int i16 = dVar2.f311113e;
            if (this.f311121e) {
                i3 = 4;
            } else {
                i3 = dVar2.f311115g;
            }
            o33.a.a(2, i16, i3, 102);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context) {
        this.f311098h = context;
    }

    private void A(TextView textView, int i3, String str) {
        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, v(i3, textView, str), 0);
    }

    private void F(b bVar, int i3, d dVar) {
        bVar.f311103d.setText(dVar.f311109a);
        TextView textView = bVar.C;
        if (textView != null) {
            textView.setText(dVar.f311111c);
        }
        View findViewById = bVar.itemView.findViewById(R.id.f901851s);
        if (findViewById != null) {
            if (TextUtils.isEmpty(dVar.f311111c)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        View findViewById2 = bVar.itemView.findViewById(R.id.bms);
        if (findViewById2 != null) {
            if (i3 > 1) {
                findViewById2.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
            }
        }
        bVar.D.setOnClickListener(new ViewOnClickListenerC8930a());
        if (ThemeUtil.isNowThemeIsNight(ThemeUtil.getCreateAppRuntime(), false, null)) {
            bVar.f311103d.setTextColor(-1);
            bVar.C.setTextColor(-1);
        }
    }

    private void t(b bVar, boolean z16) {
        if (ThemeUtil.isNowThemeIsNight(ThemeUtil.getCreateAppRuntime(), false, null)) {
            bVar.f311103d.setTextColor(-1);
            bVar.f311107i.setTextColor(-1);
            Drawable drawable = this.f311098h.getDrawable(R.drawable.lai);
            drawable.setColorFilter(this.f311098h.getResources().getColor(R.color.f156802bq), PorterDuff.Mode.MULTIPLY);
            bVar.f311107i.setBackgroundDrawable(drawable);
            if (z16) {
                Button button = bVar.f311107i;
                button.setTextColor(button.getResources().getColor(R.color.ala));
            }
        }
    }

    private Drawable u(String str, boolean z16) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains("#")) {
                str = "#" + str;
            }
            i3 = Color.parseColor(str);
        } else {
            i3 = 14606046;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3 - (-1291845632), i3 - Integer.MIN_VALUE});
        if (!z16) {
            return gradientDrawable;
        }
        return new LayerDrawable(new Drawable[]{gradientDrawable, this.f311098h.getResources().getDrawable(R.drawable.nv8)});
    }

    private int v(int i3, TextView textView, String str) {
        if (i3 != 0 && i3 != 1) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 21) {
                        if (i3 != 22) {
                            textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2064658d));
                            return R.drawable.d5o;
                        }
                        textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2065058h));
                        return R.drawable.d7q;
                    }
                    textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2065158i));
                    return R.drawable.f162144d91;
                }
                textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2064858f));
                return R.drawable.f162145d92;
            }
            textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2064958g));
            return R.drawable.d9f;
        }
        textView.setContentDescription(str + HardCodeUtil.qqStr(R.string.f2064758e));
        return R.drawable.d5n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(d dVar) {
        notifyDataSetChanged();
        ShopLayout.e eVar = this.f311096e;
        if (eVar != null) {
            eVar.a(dVar.f311114f, dVar.f311113e);
        }
    }

    private boolean z(ModuleData moduleData, String str) {
        Map<String, String> map = moduleData.extModParams;
        if (map != null) {
            str = map.get(QQWinkConstants.TAB_SUBTITLE);
        }
        this.f311095d.add(new d(2, moduleData.cname, str));
        if (this.D) {
            o33.a.a(2, 0, 0, 111);
        }
        ArrayList<ItemDisDetail> arrayList = moduleData.vitem;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<ItemDisDetail> it = moduleData.vitem.iterator();
            while (it.hasNext()) {
                ItemDisDetail next = it.next();
                this.f311095d.add(new d(0, moduleData.cname, str, next));
                if (this.D) {
                    o33.a.a(2, next.itemId, next.feeType, 101);
                }
            }
            return false;
        }
        return true;
    }

    public void B(c cVar) {
        this.C = cVar;
    }

    public void C(int i3) {
        this.f311097f = -1;
        if (this.f311095d == null) {
            return;
        }
        for (int i16 = 0; i16 < this.f311095d.size(); i16++) {
            if (this.f311095d.get(i16).a() && this.f311095d.get(i16).f311113e == i3) {
                this.f311097f = i3;
                this.f311099i = this.f311095d.get(i16);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void D(ShopLayout.e eVar) {
        this.f311096e = eVar;
    }

    @UiThread
    public void E(Object[] objArr) {
        boolean z16;
        ArrayList<ModuleData> arrayList;
        ArrayList<d> arrayList2 = this.f311095d;
        if (arrayList2 != null && objArr != null) {
            arrayList2.clear();
            int length = objArr.length;
            boolean z17 = false;
            int i3 = 0;
            while (i3 < length) {
                Object obj = objArr[i3];
                if (obj instanceof CGetChiefRsp) {
                    CGetChiefRsp cGetChiefRsp = (CGetChiefRsp) obj;
                    if (cGetChiefRsp.ret == 0 && (arrayList = cGetChiefRsp.modData) != null && arrayList.size() > 0) {
                        Iterator<ModuleData> it = cGetChiefRsp.modData.iterator();
                        while (it.hasNext()) {
                            if (!z(it.next(), "")) {
                                this.D = z17;
                            }
                        }
                    }
                } else if (obj instanceof com.tencent.mobileqq.vas.troopnick.shop.adapter.e) {
                    com.tencent.mobileqq.vas.troopnick.shop.adapter.e eVar = (com.tencent.mobileqq.vas.troopnick.shop.adapter.e) obj;
                    this.f311095d.add(new d(2, eVar.f311085d, ""));
                    for (AvatarPendantItem avatarPendantItem : eVar.f311082a) {
                        ItemDisDetail itemDisDetail = new ItemDisDetail();
                        itemDisDetail.feeType = avatarPendantItem.feeType;
                        itemDisDetail.itemId = avatarPendantItem.itemId;
                        itemDisDetail.appId = avatarPendantItem.appid;
                        itemDisDetail.isSetup = avatarPendantItem.isSetup ? 1 : 0;
                        itemDisDetail.itemBgColor = avatarPendantItem.itemBgColor;
                        itemDisDetail.image = avatarPendantItem.imageUrl;
                        itemDisDetail.name = avatarPendantItem.name;
                        this.f311095d.add(new d(0, eVar.f311085d, "", itemDisDetail));
                        if (this.E) {
                            o33.a.a(2, itemDisDetail.itemId, itemDisDetail.feeType, 101);
                        }
                        z17 = false;
                    }
                    z16 = z17;
                    this.E = z16;
                    i3++;
                    z17 = z16;
                }
                z16 = z17;
                i3++;
                z17 = z16;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d> arrayList = this.f311095d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f311095d.get(i3).f311110b;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        boolean z16;
        ArrayList<d> arrayList = this.f311095d;
        if (arrayList != null && arrayList.get(i3) != null) {
            d dVar = this.f311095d.get(i3);
            if (dVar.f311110b == 2) {
                F(bVar, i3, dVar);
            } else if (this.f311095d.get(i3).a()) {
                bVar.f311103d.setText(dVar.f311118j);
                if (this.f311097f == dVar.f311113e) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f311105f.setBackgroundDrawable(u(dVar.f311117i, z16));
                if (dVar.f311112d) {
                    bVar.f311107i.setText(R.string.ztk);
                    Button button = bVar.f311107i;
                    button.setTextColor(button.getResources().getColor(R.color.f156935fp));
                }
                int realWidth = (ScreenUtil.getRealWidth(this.f311098h) - ScreenUtil.dip2px(96.0f)) / 3;
                ViewGroup.LayoutParams layoutParams = bVar.f311104e.getLayoutParams();
                layoutParams.width = realWidth;
                layoutParams.height = (int) (realWidth * 0.57f);
                bVar.f311104e.setLayoutParams(layoutParams);
                bVar.f311104e.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(dVar.f311116h));
                A(bVar.f311103d, dVar.f311115g, dVar.f311118j);
                if (!dVar.f311112d) {
                    bVar.f311107i.setOnClickListener(new e(dVar, true));
                } else {
                    bVar.f311107i.setOnClickListener(null);
                }
                bVar.f311105f.setOnClickListener(new e(dVar, false));
                t(bVar, dVar.f311112d);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        b bVar;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            bVar = new b(View.inflate(this.f311098h, R.layout.hho, null));
            bVar.f311108m = true;
        } else {
            bVar = new b(View.inflate(this.f311098h, R.layout.hhm, null));
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f311109a;

        /* renamed from: b, reason: collision with root package name */
        public final int f311110b;

        /* renamed from: c, reason: collision with root package name */
        public final String f311111c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f311112d;

        /* renamed from: e, reason: collision with root package name */
        public final int f311113e;

        /* renamed from: f, reason: collision with root package name */
        public final int f311114f;

        /* renamed from: g, reason: collision with root package name */
        public final int f311115g;

        /* renamed from: h, reason: collision with root package name */
        public final String f311116h;

        /* renamed from: i, reason: collision with root package name */
        public final String f311117i;

        /* renamed from: j, reason: collision with root package name */
        public final String f311118j;

        public d(int i3, String str, String str2) {
            this.f311110b = i3;
            this.f311109a = str;
            this.f311111c = str2;
            this.f311113e = 0;
            this.f311114f = 0;
            this.f311115g = 0;
            this.f311116h = "";
            this.f311117i = "";
            this.f311118j = "";
            this.f311112d = false;
        }

        public boolean a() {
            if (this.f311110b == 0) {
                return true;
            }
            return false;
        }

        public d(int i3, String str, String str2, @NotNull ItemDisDetail itemDisDetail) {
            this.f311110b = i3;
            this.f311109a = str;
            this.f311111c = str2;
            this.f311113e = itemDisDetail.itemId;
            this.f311114f = itemDisDetail.appId;
            this.f311115g = itemDisDetail.feeType;
            this.f311116h = itemDisDetail.image;
            this.f311117i = itemDisDetail.itemBgColor;
            this.f311118j = itemDisDetail.name;
            this.f311112d = itemDisDetail.isSetup != 0;
        }
    }
}
