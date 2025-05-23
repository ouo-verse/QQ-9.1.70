package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.KeyEventDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AssociateSearchWordsFragment extends QBaseFragment {
    XListView C;
    LinearLayout E;
    TextView F;
    String G;
    f I;
    private List<AssociateItem> J;
    protected String L;
    private d M;
    boolean D = false;
    int H = 0;
    protected boolean K = false;
    View.OnClickListener N = new b();
    public View.OnTouchListener P = new c();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class AssociateItem implements Parcelable {
        public static final Parcelable.Creator<AssociateItem> CREATOR = new a();
        public int C;
        public String D;
        public int E;

        /* renamed from: d, reason: collision with root package name */
        public int f283158d;

        /* renamed from: e, reason: collision with root package name */
        public String f283159e;

        /* renamed from: f, reason: collision with root package name */
        public String f283160f;

        /* renamed from: h, reason: collision with root package name */
        public String f283161h;

        /* renamed from: i, reason: collision with root package name */
        public String f283162i;

        /* renamed from: m, reason: collision with root package name */
        public int f283163m;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements Parcelable.Creator<AssociateItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AssociateItem createFromParcel(Parcel parcel) {
                return new AssociateItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AssociateItem[] newArray(int i3) {
                return new AssociateItem[i3];
            }
        }

        public AssociateItem() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f283158d);
            parcel.writeString(this.f283159e);
            parcel.writeString(this.f283160f);
            parcel.writeString(this.f283161h);
            parcel.writeString(this.f283162i);
            parcel.writeInt(this.f283163m);
            parcel.writeInt(this.C);
            parcel.writeString(this.D);
            parcel.writeInt(this.E);
        }

        public AssociateItem(Parcel parcel) {
            this.f283158d = parcel.readInt();
            this.f283159e = parcel.readString();
            this.f283160f = parcel.readString();
            this.f283161h = parcel.readString();
            this.f283162i = parcel.readString();
            this.f283163m = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readString();
            this.E = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C458", "0X800C458", 0, 0, "", "", "", "");
            f fVar = AssociateSearchWordsFragment.this.I;
            if (fVar != null) {
                fVar.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() != null) {
                QBaseActivity qBaseActivity = AssociateSearchWordsFragment.this.getQBaseActivity();
                AssociateItem associateItem = (AssociateItem) view.getTag(R.id.kxb);
                int i3 = associateItem.f283158d;
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 6) {
                        if (qBaseActivity instanceof d) {
                            dVar = (d) qBaseActivity;
                        } else if (AssociateSearchWordsFragment.this.M != null) {
                            dVar = AssociateSearchWordsFragment.this.M;
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            dVar.onAssociateWordClick(associateItem.f283159e, associateItem.E);
                        }
                    }
                } else if (qBaseActivity instanceof d) {
                    Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                    String str = associateItem.D;
                    if (!str.startsWith("http")) {
                        str = "http://" + str;
                    }
                    intent.putExtra("url", str);
                    qBaseActivity.startActivity(intent);
                    qBaseActivity.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QBaseActivity qBaseActivity = AssociateSearchWordsFragment.this.getQBaseActivity();
            if (qBaseActivity instanceof ActiveEntitySearchActivity) {
                ((ActiveEntitySearchActivity) qBaseActivity).hideInputMethod();
                return false;
            }
            if (qBaseActivity instanceof UniteSearchActivity) {
                InputMethodUtil.hide(qBaseActivity);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void onAssociateWordClick(String str, int i3);

        void onAssociateWordInput(String str);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<AssociateItem> f283167d;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f283169d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f283170e;

            a(String str, int i3) {
                this.f283169d = str;
                this.f283170e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                KeyEventDispatcher.Component qBaseActivity = AssociateSearchWordsFragment.this.getQBaseActivity();
                d dVar = null;
                if (AssociateSearchWordsFragment.this.getQBaseActivity() instanceof d) {
                    com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.f283169d).ver2(TabPreloadItem.TAB_NAME_KANDIAN).ver3(UniteSearchActivity.f282688f0).ver4(AssociateSearchWordsFragment.this.L).ver5(((this.f283170e / 2) + 1) + "").ver6(UniteSearchActivity.f282687e0).session_id(UniteSearchActivity.f282689g0));
                    dVar = (d) qBaseActivity;
                } else if (AssociateSearchWordsFragment.this.M != null) {
                    dVar = AssociateSearchWordsFragment.this.M;
                }
                if (dVar != null) {
                    dVar.onAssociateWordInput(this.f283169d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public e(List<AssociateItem> list) {
            new ArrayList();
            this.f283167d = list;
        }

        public void a(List<AssociateItem> list) {
            this.f283167d = list;
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<AssociateItem> list = this.f283167d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<AssociateItem> list = this.f283167d;
            if (list == null) {
                return null;
            }
            return list.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            switch (this.f283167d.get(i3).f283158d) {
                case 0:
                    return 1;
                case 1:
                    return 4;
                case 2:
                case 4:
                case 5:
                    return 3;
                case 3:
                    return 2;
                case 6:
                    return 5;
                default:
                    return 0;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x02ef, code lost:
        
            if (r5 != 5) goto L58;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r13v13 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v4, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup] */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            Object obj;
            View view2;
            ?? r132;
            View view3;
            View view4;
            AssociateItem associateItem = this.f283167d.get(i3);
            QBaseActivity qBaseActivity = AssociateSearchWordsFragment.this.getQBaseActivity();
            boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
            int itemViewType = getItemViewType(i3);
            if (view == null) {
                g gVar = new g();
                ?? linearLayout = new LinearLayout(qBaseActivity);
                linearLayout.setPadding(x.c(qBaseActivity, 12.0f), 0, x.c(qBaseActivity, 12.0f), 0);
                linearLayout.setOrientation(1);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            if (itemViewType != 3) {
                                if (itemViewType != 4) {
                                    if (itemViewType != 5) {
                                        view4 = view;
                                    }
                                } else {
                                    TextView textView = new TextView(qBaseActivity);
                                    textView.setHeight(1);
                                    linearLayout.addView(textView);
                                    linearLayout.setPadding(x.c(qBaseActivity, 12.0f), 0, 0, 0);
                                    gVar.f283174c = textView;
                                    linearLayout.setClickable(false);
                                    linearLayout.setFocusable(false);
                                    view4 = linearLayout;
                                }
                            } else {
                                TextView textView2 = new TextView(qBaseActivity);
                                textView2.setTextColor(qBaseActivity.getResources().getColor(R.color.skin_black));
                                textView2.setTextSize(1, 18.0f);
                                textView2.setIncludeFontPadding(false);
                                linearLayout.addView(textView2);
                                gVar.f283172a = textView2;
                                TextView textView3 = new TextView(qBaseActivity);
                                textView3.setTextColor(qBaseActivity.getResources().getColor(R.color.skin_gray2));
                                textView3.setTextSize(1, 14.0f);
                                textView3.setIncludeFontPadding(false);
                                linearLayout.addView(textView3);
                                gVar.f283173b = textView3;
                                linearLayout.setOnClickListener(AssociateSearchWordsFragment.this.N);
                                view4 = linearLayout;
                            }
                            obj = null;
                            view2 = view4;
                        }
                        TextView textView4 = new TextView(qBaseActivity);
                        textView4.setGravity(19);
                        textView4.setTextColor(qBaseActivity.getResources().getColor(R.color.skin_black));
                        if (itemViewType == 5) {
                            textView4.setTextSize(1, 16.0f);
                        } else {
                            textView4.setTextSize(1, 18.0f);
                        }
                        textView4.setSingleLine();
                        textView4.setEllipsize(TextUtils.TruncateAt.END);
                        textView4.setIncludeFontPadding(false);
                        if (itemViewType == 5) {
                            LinearLayout linearLayout2 = new LinearLayout(qBaseActivity);
                            linearLayout2.setOrientation(0);
                            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, x.c(qBaseActivity, 52.0f)));
                            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
                                Drawable drawable = qBaseActivity.getResources().getDrawable(R.drawable.i0a);
                                drawable.setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(R.color.f157942an1), PorterDuff.Mode.SRC_ATOP);
                                textView4.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                            } else {
                                textView4.setCompoundDrawablesWithIntrinsicBounds(qBaseActivity.getResources().getDrawable(R.drawable.i0a), (Drawable) null, (Drawable) null, (Drawable) null);
                            }
                            textView4.setCompoundDrawablePadding(x.c(qBaseActivity, 8.0f));
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                            layoutParams.weight = 1.0f;
                            linearLayout2.addView(textView4, layoutParams);
                            ImageView imageView = new ImageView(qBaseActivity);
                            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
                                imageView.setImageResource(R.drawable.i0b);
                                imageView.setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(R.color.f157942an1));
                            } else {
                                imageView.setImageResource(R.drawable.i0b);
                            }
                            linearLayout2.addView(imageView, new LinearLayout.LayoutParams(-2, -1));
                            imageView.setOnClickListener(new a(associateItem.f283159e, i3));
                            obj = null;
                            boolean isNowThemeIsDefault = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
                            if (!isInNightMode && !isNowThemeIsDefault) {
                                TextView textView5 = new TextView(qBaseActivity);
                                textView5.setPadding(x.c(qBaseActivity, 12.0f), 0, 0, 0);
                                textView5.setBackgroundColor(qBaseActivity.getResources().getColor(R.color.ach));
                                textView5.setHeight(1);
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                gVar.f283174c = textView5;
                                linearLayout.addView(textView5, layoutParams2);
                            }
                        } else {
                            obj = null;
                            linearLayout.setOrientation(0);
                            Drawable drawable2 = qBaseActivity.getResources().getDrawable(R.drawable.skin_searchbar_icon_theme_version2);
                            int c16 = x.c(qBaseActivity, 24.0f);
                            int c17 = x.c(qBaseActivity, 4.0f);
                            drawable2.setBounds(0, 0, c16, c16);
                            ImageView imageView2 = new ImageView(qBaseActivity);
                            imageView2.setImageDrawable(drawable2);
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView2.setPadding(c17, c17, c17, c17);
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(c16, c16);
                            layoutParams3.gravity = 17;
                            linearLayout.addView(imageView2, layoutParams3);
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams4.setMargins(0, x.c(qBaseActivity, 16.0f), 0, x.c(qBaseActivity, 16.0f));
                            linearLayout.addView(textView4, layoutParams4);
                        }
                        gVar.f283172a = textView4;
                        linearLayout.setOnClickListener(AssociateSearchWordsFragment.this.N);
                        view2 = linearLayout;
                    } else {
                        obj = null;
                        TextView textView6 = new TextView(qBaseActivity);
                        textView6.setBackgroundColor(Color.parseColor("#F7F7F9"));
                        textView6.setHeight(x.c(qBaseActivity, 10.0f));
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                        gVar.f283174c = textView6;
                        linearLayout.addView(textView6, layoutParams5);
                        TextView textView7 = new TextView(qBaseActivity);
                        textView7.setTextColor(qBaseActivity.getResources().getColor(R.color.skin_gray2));
                        textView7.setTextSize(1, 15.0f);
                        textView7.setGravity(16);
                        textView7.setIncludeFontPadding(false);
                        textView7.setHeight(qBaseActivity.getResources().getDimensionPixelSize(R.dimen.alg));
                        textView7.setPadding(x.c(qBaseActivity, 12.0f), 0, x.c(qBaseActivity, 12.0f), 0);
                        linearLayout.addView(textView7, new LinearLayout.LayoutParams(-1, -2));
                        linearLayout.setClickable(false);
                        linearLayout.setFocusable(false);
                        linearLayout.setPadding(0, 0, 0, 0);
                        gVar.f283172a = textView7;
                        view2 = linearLayout;
                    }
                    if (view2 != null) {
                        view2.setTag(gVar);
                        view2.setBackgroundResource(R.drawable.f161397wk);
                    }
                } else {
                    obj = null;
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, "SearchAssociatedWordAdapter.getView() itemType not support. value=" + itemViewType);
                    }
                    view3 = view;
                    r132 = obj;
                    EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                    return r132;
                }
            } else {
                obj = null;
                view2 = view;
            }
            if (view2 == null) {
                view3 = view2;
                r132 = obj;
                EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                return r132;
            }
            g gVar2 = (g) view2.getTag();
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        if (itemViewType == 4) {
                            if (isInNightMode) {
                                gVar2.f283174c.setBackgroundColor(qBaseActivity.getResources().getColor(R.color.aci));
                            } else {
                                gVar2.f283174c.setBackgroundColor(qBaseActivity.getResources().getColor(R.color.ach));
                            }
                        }
                    } else {
                        gVar2.f283172a.setText(associateItem.f283159e);
                        gVar2.f283173b.setText(associateItem.D);
                        if (TextUtils.isEmpty(associateItem.f283159e)) {
                            gVar2.f283172a.setVisibility(8);
                            ((LinearLayout.LayoutParams) gVar2.f283173b.getLayoutParams()).setMargins(0, x.c(qBaseActivity, 16.0f), 0, x.c(qBaseActivity, 16.0f));
                        } else {
                            gVar2.f283172a.setVisibility(0);
                            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) gVar2.f283172a.getLayoutParams();
                            layoutParams6.setMargins(0, x.c(qBaseActivity, 12.0f), 0, 0);
                            gVar2.f283172a.setLayoutParams(layoutParams6);
                            LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) gVar2.f283173b.getLayoutParams();
                            layoutParams7.setMargins(0, x.c(qBaseActivity, 5.0f), 0, x.c(qBaseActivity, 12.0f));
                            gVar2.f283173b.setLayoutParams(layoutParams7);
                        }
                    }
                }
                AssociateSearchWordsFragment associateSearchWordsFragment = AssociateSearchWordsFragment.this;
                if (associateSearchWordsFragment.K) {
                    if (itemViewType == 2) {
                        gVar2.f283172a.setText(SearchUtils.K(gVar2.f283172a, 2.14748365E9f, 1, associateItem.f283159e, associateSearchWordsFragment.L, false, false, true));
                    } else {
                        gVar2.f283172a.setText(SearchUtils.F(associateItem.f283159e, associateSearchWordsFragment.L, false));
                    }
                } else {
                    gVar2.f283172a.setText(associateItem.f283159e);
                }
            } else {
                if (i3 == 0) {
                    gVar2.f283174c.setVisibility(8);
                } else {
                    gVar2.f283174c.setVisibility(0);
                    if (isInNightMode) {
                        gVar2.f283174c.setBackgroundColor(qBaseActivity.getResources().getColor(R.color.aci));
                    } else {
                        gVar2.f283174c.setBackgroundColor(qBaseActivity.getResources().getColor(R.color.ach));
                    }
                }
                gVar2.f283172a.setText(associateItem.f283159e);
            }
            if (itemViewType == 2) {
                view2.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
            } else if (isInNightMode) {
                view2.setBackgroundResource(R.drawable.f160534jf);
            } else {
                view2.setBackgroundResource(R.drawable.f160533je);
            }
            view2.setTag(R.id.kxc, Integer.valueOf(i3));
            view2.setTag(R.id.kxb, associateItem);
            view3 = view2;
            r132 = view2;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return r132;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 6;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        TextView f283172a;

        /* renamed from: b, reason: collision with root package name */
        TextView f283173b;

        /* renamed from: c, reason: collision with root package name */
        TextView f283174c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(TextView textView) {
        if (this.H == 0) {
            this.H = this.E.getWidth() - yh(R.id.i_m, R.id.text1, R.id.text2);
        }
        if (TextUtils.isEmpty(TextUtils.ellipsize(textView.getText(), textView.getPaint(), this.H, TextUtils.TruncateAt.END))) {
            textView.setText("\u2026");
        }
    }

    private void sh(View view) {
        if (view == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.zp6);
        this.E = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        this.F = textView;
        textView.setTextColor(com.tencent.mobileqq.search.util.a.a());
        this.F.setText(this.G);
        this.F.post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.1
            @Override // java.lang.Runnable
            public void run() {
                AssociateSearchWordsFragment associateSearchWordsFragment = AssociateSearchWordsFragment.this;
                associateSearchWordsFragment.rh(associateSearchWordsFragment.F);
            }
        });
        this.E.setOnClickListener(new a());
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        this.E.setVisibility(0);
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C457", "0X800C457", 0, 0, "", "", "", "");
        TextView textView2 = (TextView) this.E.findViewById(R.id.text2);
        if (GuildInjectImpl.N()) {
            textView2.setText(HardCodeUtil.qqStr(R.string.f213955rl));
        } else {
            textView2.setText(HardCodeUtil.qqStr(R.string.f213935rj));
        }
    }

    private int yh(int... iArr) {
        int i3 = 0;
        for (int i16 : iArr) {
            View findViewById = this.E.findViewById(i16);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            i3 += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + findViewById.getWidth();
        }
        return i3;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168532zv, (ViewGroup) null);
        XListView xListView = (XListView) inflate.findViewById(R.id.f166837ik3);
        this.C = xListView;
        xListView.setDivider(null);
        this.C.setOnTouchListener(this.P);
        this.D = true;
        List<AssociateItem> list = this.J;
        if (list != null) {
            th(list);
            this.J = null;
        }
        sh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.D = false;
    }

    public void th(List<AssociateItem> list) {
        if (this.C.getAdapter() == null) {
            e eVar = new e(list);
            this.C.setAdapter((ListAdapter) eVar);
            eVar.a(list);
        } else {
            ((e) this.C.getAdapter()).a(list);
        }
        KeyEventDispatcher.Component qBaseActivity = getQBaseActivity();
        if (qBaseActivity instanceof nn2.b) {
            SearchUtils.W0("sub_result", "exp_auto", ((nn2.b) qBaseActivity).getSearchKeyword(), "", "", "");
        }
    }

    public void uh(List<AssociateItem> list) {
        if (!this.D) {
            this.J = list;
        } else {
            th(list);
        }
    }

    public void vh(int i3) {
        LinearLayout linearLayout = this.E;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(i3);
    }

    public void wh(f fVar) {
        this.I = fVar;
    }

    public void xh(String str) {
        this.G = str;
        if (this.F != null && getActivity() != null && !getActivity().isFinishing()) {
            this.F.setText(this.G);
            rh(this.F);
        }
    }
}
