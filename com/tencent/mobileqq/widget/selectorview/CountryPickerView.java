package com.tencent.mobileqq.widget.selectorview;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes20.dex */
public class CountryPickerView extends RelativeLayout implements IndexView.b {
    private static final String[] F = {"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z"};
    private LinkedHashMap<String, Integer> C;
    private String D;
    private f E;

    /* renamed from: d, reason: collision with root package name */
    private final Context f317297d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f317298e;

    /* renamed from: f, reason: collision with root package name */
    private PinnedDividerListView f317299f;

    /* renamed from: h, reason: collision with root package name */
    private IndexView f317300h;

    /* renamed from: i, reason: collision with root package name */
    private List<Object> f317301i;

    /* renamed from: m, reason: collision with root package name */
    private List<BaseAddress> f317302m;

    /* loaded from: classes20.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.CountryPickerView.f
        public void getSelectResult(String str) {
            QLog.d("CountrySelectView", 4, "\u9009\u62e9\u4e86\u56fd\u5bb6\uff1a" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag instanceof g) {
                CountryPickerView.this.E.getSelectResult(((g) tag).f317311c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() instanceof g) {
                CountryPickerView.this.E.getSelectResult("0");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes20.dex */
    private class d extends PinnedDividerListView.a {

        /* loaded from: classes20.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = view.getTag();
                if (tag instanceof g) {
                    CountryPickerView.this.E.getSelectResult(((g) tag).f317311c);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            TextView textView = (TextView) view;
            Object item = getItem(i3);
            if (item instanceof e) {
                textView.setText(((e) item).f317308a);
            } else if (item instanceof BaseAddress) {
                textView.setText(((BaseAddress) item).pinyinFirst);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CountryPickerView.this.f317301i.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            return R.layout.f168366u3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return CountryPickerView.this.f317301i.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            return !(CountryPickerView.this.f317301i.get(i3) instanceof e) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            g gVar;
            if (getItemViewType(i3) == 0) {
                if (view == null) {
                    view = LayoutInflater.from(CountryPickerView.this.f317297d).inflate(getDividerLayout(), (ViewGroup) null);
                }
                ((TextView) view).setText(((e) getItem(i3)).f317308a);
            } else {
                if (view == null) {
                    view = LayoutInflater.from(CountryPickerView.this.f317297d).inflate(R.layout.f168367u4, (ViewGroup) null);
                    gVar = new g();
                    gVar.f317309a = (TextView) view.findViewById(R.id.bar);
                    gVar.f317310b = (ImageView) view.findViewById(R.id.ax5);
                    view.findViewById(R.id.baq).setVisibility(8);
                    view.setTag(gVar);
                    view.setOnClickListener(new a());
                } else {
                    gVar = (g) view.getTag();
                }
                BaseAddress baseAddress = (BaseAddress) getItem(i3);
                gVar.f317309a.setText(baseAddress.name);
                if (!TextUtils.isEmpty(CountryPickerView.this.D) && CountryPickerView.this.D.equals(baseAddress.code)) {
                    gVar.f317310b.setVisibility(0);
                } else {
                    gVar.f317310b.setVisibility(8);
                }
                gVar.f317311c = baseAddress.code;
                if (QQUIAppSetting.enableTalkBack()) {
                    if (gVar.f317310b.getVisibility() == 0) {
                        view.setContentDescription(baseAddress.name + HardCodeUtil.qqStr(R.string.f170771zn2));
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
    /* loaded from: classes20.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f317308a;

        e() {
        }
    }

    /* loaded from: classes20.dex */
    public interface f {
        void getSelectResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public TextView f317309a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f317310b;

        /* renamed from: c, reason: collision with root package name */
        public String f317311c;

        g() {
        }
    }

    public CountryPickerView(Context context) {
        super(context);
        this.f317297d = context;
        h();
        this.E = new a();
    }

    private void e() {
        this.C = new LinkedHashMap<>();
        this.f317301i = new ArrayList(this.f317302m.size() + 26);
        int i3 = 0;
        String str = "#";
        this.C.put("#", 0);
        for (BaseAddress baseAddress : this.f317302m) {
            if (!baseAddress.code.equals("0") && !baseAddress.code.equals("1")) {
                if (!baseAddress.pinyinFirst.equals(str)) {
                    str = baseAddress.pinyinFirst;
                    int indexOf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(str);
                    while (i3 <= indexOf) {
                        int i16 = i3 + 1;
                        this.C.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i3, i16), Integer.valueOf(this.f317301i.size() + this.f317299f.getHeaderViewsCount()));
                        i3 = i16;
                    }
                    this.C.put(str, Integer.valueOf(this.f317301i.size() + this.f317299f.getHeaderViewsCount()));
                    e eVar = new e();
                    eVar.f317308a = str;
                    this.f317301i.add(eVar);
                }
                this.f317301i.add(baseAddress);
            }
        }
        while (i3 < 26) {
            int i17 = i3 + 1;
            this.C.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i3, i17), Integer.valueOf(this.f317301i.size() + this.f317299f.getHeaderViewsCount()));
            i3 = i17;
        }
    }

    private void f(String str, boolean z16) {
        int i3;
        if (z16) {
            i(str);
        }
        View inflate = LayoutInflater.from(this.f317297d).inflate(R.layout.f168367u4, (ViewGroup) null);
        g gVar = new g();
        ((TextView) inflate.findViewById(R.id.bar)).setText(CountrySelectView.NAME_CHINA);
        View findViewById = inflate.findViewById(R.id.ax5);
        if (str.equals("1")) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        inflate.findViewById(R.id.baq).setVisibility(8);
        gVar.f317311c = "1";
        inflate.setTag(gVar);
        inflate.setOnClickListener(new b());
        if (QQUIAppSetting.enableTalkBack()) {
            inflate.setContentDescription(CountrySelectView.NAME_CHINA);
        }
        this.f317299f.addHeaderView(inflate);
    }

    private void h() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f317297d).inflate(R.layout.f168365u2, (ViewGroup) null);
        this.f317298e = relativeLayout;
        this.f317299f = (PinnedDividerListView) relativeLayout.findViewById(R.id.bas);
        this.f317300h = (IndexView) this.f317298e.findViewById(R.id.djg);
    }

    private void i(String str) {
        int i3;
        View inflate = LayoutInflater.from(this.f317297d).inflate(R.layout.f168367u4, (ViewGroup) null);
        g gVar = new g();
        ((TextView) inflate.findViewById(R.id.bar)).setText(IProfileCardConst.NAME_NO_LIMIT);
        View findViewById = inflate.findViewById(R.id.ax5);
        if (str.equals("0")) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        inflate.findViewById(R.id.baq).setVisibility(8);
        gVar.f317311c = "0";
        inflate.setTag(gVar);
        inflate.setOnClickListener(new c());
        if (QQUIAppSetting.enableTalkBack()) {
            inflate.setContentDescription(IProfileCardConst.NAME_NO_LIMIT);
        }
        this.f317299f.addHeaderView(inflate);
    }

    public void g(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.D = str;
        f(str, z16);
        e();
        this.f317299f.setAdapter((ListAdapter) new d());
        this.f317300h.setIndex(F, false);
        this.f317300h.setOnIndexChangedListener(this);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f317298e;
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        Integer num = this.C.get(str);
        if (QLog.isColorLevel()) {
            QLog.d("CountrySelectView", 2, "onIndexChanged | c = " + str + " | i = " + num);
        }
        if (num != null) {
            this.f317299f.setSelection(num.intValue());
        }
    }

    public void setCountryList(List<BaseAddress> list) {
        this.f317302m = list;
    }

    public void setCountrySelectListener(f fVar) {
        this.E = fVar;
    }
}
