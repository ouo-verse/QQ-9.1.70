package com.tencent.mobileqq.guild.widget.countrySelect;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCountrySelectView extends RelativeLayout implements IndexView.b {
    private static final String[] F = {"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z"};
    private String C;
    private f D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final Context f236337d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f236338e;

    /* renamed from: f, reason: collision with root package name */
    private PinnedDividerListView f236339f;

    /* renamed from: h, reason: collision with root package name */
    private IndexView f236340h;

    /* renamed from: i, reason: collision with root package name */
    private List<Object> f236341i;

    /* renamed from: m, reason: collision with root package name */
    private LinkedHashMap<String, Integer> f236342m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.countrySelect.GuildCountrySelectView.f
        public void getSelectResult(String str) {
            QLog.d("CountrySelectView", 4, "\u9009\u62e9\u4e86\u56fd\u5bb6\uff1a" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements IProfileEditBusinessApi.OnCountryCacheLoadedListener {
        b() {
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCountryCacheLoadedListener
        public void onCountryInfoLoaded(List<Object> list) {
            try {
                GuildCountrySelectView.this.j(list);
            } catch (ClassCastException e16) {
                QLog.e("CountrySelectView", 1, "getCountryInfo fail: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag instanceof g) {
                GuildCountrySelectView.this.D.getSelectResult(((g) tag).f236351c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d extends PinnedDividerListView.a {

        /* compiled from: P */
        /* loaded from: classes14.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = view.getTag();
                if (tag instanceof g) {
                    GuildCountrySelectView.this.D.getSelectResult(((g) tag).f236351c);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            TextView textView = (TextView) view;
            GuildCountrySelectView guildCountrySelectView = GuildCountrySelectView.this;
            guildCountrySelectView.o(guildCountrySelectView.E, textView);
            Object item = getItem(i3);
            if (item instanceof e) {
                textView.setText(((e) item).f236348a);
            } else if (item instanceof BaseAddress) {
                textView.setText(((BaseAddress) item).pinyinFirst);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GuildCountrySelectView.this.f236341i.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            return R.layout.f29;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return GuildCountrySelectView.this.f236341i.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            return !(GuildCountrySelectView.this.f236341i.get(i3) instanceof e) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            g gVar;
            if (getItemViewType(i3) == 0) {
                if (view == null) {
                    view = LayoutInflater.from(GuildCountrySelectView.this.f236337d).inflate(getDividerLayout(), (ViewGroup) null);
                }
                GuildCountrySelectView guildCountrySelectView = GuildCountrySelectView.this;
                TextView textView = (TextView) view;
                guildCountrySelectView.o(guildCountrySelectView.E, textView);
                textView.setText(((e) getItem(i3)).f236348a);
            } else {
                if (view == null) {
                    view = LayoutInflater.from(GuildCountrySelectView.this.f236337d).inflate(R.layout.f2_, (ViewGroup) null);
                    GuildCountrySelectView guildCountrySelectView2 = GuildCountrySelectView.this;
                    guildCountrySelectView2.p(guildCountrySelectView2.E, view);
                    gVar = new g();
                    gVar.f236349a = (TextView) view.findViewById(R.id.bar);
                    gVar.f236350b = (ImageView) view.findViewById(R.id.ax5);
                    view.findViewById(R.id.baq).setVisibility(8);
                    view.setTag(gVar);
                    view.setOnClickListener(new a());
                } else {
                    gVar = (g) view.getTag();
                }
                BaseAddress baseAddress = (BaseAddress) getItem(i3);
                gVar.f236349a.setText(baseAddress.name);
                if (!TextUtils.isEmpty(GuildCountrySelectView.this.C) && GuildCountrySelectView.this.C.equals(baseAddress.code)) {
                    gVar.f236350b.setVisibility(0);
                } else {
                    gVar.f236350b.setVisibility(8);
                }
                gVar.f236351c = baseAddress.code;
                if (AppSetting.f99565y) {
                    if (gVar.f236350b.getVisibility() == 0) {
                        view.setContentDescription(baseAddress.name + HardCodeUtil.qqStr(R.string.f152331_4));
                    } else {
                        view.setContentDescription(baseAddress.name);
                    }
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            if (getItemViewType(i3) == 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f236348a;

        e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface f {
        void getSelectResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public TextView f236349a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f236350b;

        /* renamed from: c, reason: collision with root package name */
        public String f236351c;

        g() {
        }
    }

    public GuildCountrySelectView(Context context) {
        this(context, false);
    }

    private void i() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadCountryInfo(MobileQQ.sMobileQQ.waitAppRuntime(null), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<BaseAddress> list) {
        this.f236342m = new LinkedHashMap<>();
        this.f236341i = new ArrayList(list.size() + 26);
        int i3 = 0;
        String str = "#";
        this.f236342m.put("#", 0);
        for (BaseAddress baseAddress : list) {
            if (!baseAddress.code.equals("0") && !baseAddress.code.equals("1")) {
                if (!baseAddress.pinyinFirst.equals(str)) {
                    str = baseAddress.pinyinFirst;
                    int indexOf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(str);
                    while (i3 <= indexOf) {
                        int i16 = i3 + 1;
                        this.f236342m.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i3, i16), Integer.valueOf(this.f236341i.size() + this.f236339f.getHeaderViewsCount()));
                        i3 = i16;
                    }
                    this.f236342m.put(str, Integer.valueOf(this.f236341i.size() + this.f236339f.getHeaderViewsCount()));
                    e eVar = new e();
                    eVar.f236348a = str;
                    this.f236341i.add(eVar);
                }
                this.f236341i.add(baseAddress);
            }
        }
        while (i3 < 26) {
            int i17 = i3 + 1;
            this.f236342m.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i3, i17), Integer.valueOf(this.f236341i.size() + this.f236339f.getHeaderViewsCount()));
            i3 = i17;
        }
    }

    private void k(String str, boolean z16) {
        String str2;
        int i3;
        View inflate = LayoutInflater.from(this.f236337d).inflate(R.layout.f2_, (ViewGroup) null);
        p(this.E, inflate);
        g gVar = new g();
        TextView textView = (TextView) inflate.findViewById(R.id.bar);
        if (z16) {
            str2 = "";
        } else {
            str2 = CountrySelectView.NAME_CHINA;
        }
        textView.setText(str2);
        View findViewById = inflate.findViewById(R.id.ax5);
        String str3 = "0";
        if (!str.equals("0") && !str.equals("1")) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        findViewById.setVisibility(i3);
        inflate.findViewById(R.id.baq).setVisibility(8);
        if (!z16) {
            str3 = "1";
        }
        gVar.f236351c = str3;
        inflate.setTag(gVar);
        inflate.setOnClickListener(new c());
        if (AppSetting.f99565y) {
            inflate.setContentDescription("");
        }
        this.f236339f.addHeaderView(inflate);
    }

    private void m() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f236337d).inflate(R.layout.f28, (ViewGroup) null);
        this.f236338e = relativeLayout;
        this.f236339f = (PinnedDividerListView) relativeLayout.findViewById(R.id.bas);
        this.f236340h = (IndexView) this.f236338e.findViewById(R.id.djg);
        n(this.E);
    }

    private void n(boolean z16) {
        Context context = this.f236337d;
        if (context != null) {
            context.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z16, TextView textView) {
        Context context = this.f236337d;
        if (context != null) {
            context.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16, View view) {
        Context context = this.f236337d;
        if (context != null) {
            context.getResources();
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f236338e;
    }

    public void l(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.C = str;
        k(str, z16);
        i();
        this.f236339f.setAdapter((ListAdapter) new d());
        this.f236340h.setIndex(F, false);
        this.f236340h.setOnIndexChangedListener(this);
        this.f236340h.setBackgroundColor(16777215);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        Integer num = this.f236342m.get(str);
        if (QLog.isColorLevel()) {
            QLog.d("CountrySelectView", 2, "onIndexChanged | c = " + str + " | i = " + num);
        }
        if (num != null) {
            this.f236339f.setSelection(num.intValue());
        }
    }

    public void setCountrySelectListener(f fVar) {
        this.D = fVar;
    }

    public GuildCountrySelectView(Context context, boolean z16) {
        super(context);
        this.E = z16;
        this.f236337d = context;
        m();
        this.D = new a();
    }
}
