package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchLiveStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchPageCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.event.UpdateSearchHintEvent;
import com.tencent.mobileqq.search.fragment.UniteSearchFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.t;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.search.util.u;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.NumberUtil;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t extends BaseSearchEntryModel<View> implements AdapterView.OnItemClickListener, SimpleEventReceiver {
    private Context F;
    private QQAppInterface G;
    private View H;
    private GridView I;
    private TextView J;
    private a K;
    private HotWordSearchEntryDataModel L;

    public t(int i3, int i16) {
        super(i3, i16);
    }

    private static boolean G(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(hotSearchItem.sExtInfo);
            for (String str : strArr) {
                if (!jSONObject.has(str)) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e16) {
            QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
            return false;
        }
    }

    private void H(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, boolean z16) {
        if (z16) {
            this.L.p(hotSearchItem);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(hotSearchItem.sExtInfo);
            for (String str : com.tencent.biz.qqcircle.immersive.views.search.util.a.f91229a) {
                jSONObject.remove(str);
            }
            hotSearchItem.sExtInfo = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
        }
        this.L.v(hotSearchItem);
    }

    private void I(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i3) {
        if (!V(hotSearchItem, i3)) {
            return;
        }
        this.L.v(hotSearchItem);
    }

    private void J(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            Context context = this.F;
            if (context instanceof AppActivity) {
                AppRuntime appRuntime = ((AppActivity) context).getAppRuntime();
                if (appRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) appRuntime;
                }
            }
        }
        this.G = qQAppInterface;
    }

    private static String K(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, String str) {
        try {
            return new JSONObject(hotSearchItem.sExtInfo).optString(str);
        } catch (JSONException e16) {
            QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
            return null;
        }
    }

    private String L(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        if (!TextUtils.isEmpty(hotSearchItem.sExtInfo)) {
            try {
                return new JSONObject(hotSearchItem.sExtInfo).optString("wordId", "");
            } catch (JSONException e16) {
                QLog.e("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
            }
        }
        return "";
    }

    private HotWordSearchEntryDataModel.HotSearchItem M(long j3) {
        HotWordSearchEntryDataModel hotWordSearchEntryDataModel = this.L;
        if (hotWordSearchEntryDataModel != null && !hotWordSearchEntryDataModel.E.isEmpty()) {
            Iterator<HotWordSearchEntryDataModel.HotSearchItem> it = this.L.E.iterator();
            while (it.hasNext()) {
                HotWordSearchEntryDataModel.HotSearchItem next = it.next();
                if (Q(next) && R(j3, next)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void N(Context context, View view, View view2) {
        if (!aq.a() && !com.tencent.mobileqq.search.util.z.d()) {
            return;
        }
        this.J.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_primary));
        this.J.setTextSize(14.0f);
        if (com.tencent.mobileqq.search.util.z.d()) {
            view2.getLayoutParams().height = ViewUtils.dpToPx(8.0f);
            if (com.tencent.mobileqq.search.util.z.e()) {
                view2.setBackgroundResource(0);
                this.J.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_secondary));
                view.setBackgroundResource(0);
            } else {
                view.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                view2.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            }
        } else {
            view2.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            view.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        }
        TextView textView = this.J;
        textView.setPadding(textView.getPaddingLeft(), 0, this.J.getPaddingRight(), 0);
        this.J.getLayoutParams().height = ViewUtils.dpToPx(38.0f);
        view.findViewById(R.id.xo9).setVisibility(8);
        View findViewById = view.findViewById(R.id.acn);
        findViewById.setVisibility(0);
        findViewById.bringToFront();
        int dip2px = ViewUtils.dip2px(2.0f);
        if (com.tencent.mobileqq.search.util.z.e()) {
            ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = ViewUtils.dip2px(16.0f);
            dip2px = ViewUtils.dip2px(7.0f);
        } else if (com.tencent.mobileqq.search.util.z.d()) {
            dip2px = ViewUtils.dpToPx(4.0f);
        }
        GridView gridView = this.I;
        gridView.setPadding(gridView.getPaddingLeft(), dip2px, this.I.getPaddingRight(), dip2px);
        this.J.setBackgroundResource(0);
        this.I.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        return G(hotSearchItem, "game_description");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        return G(hotSearchItem, "live_status", "live_summary", "live_date");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Q(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        return G(hotSearchItem, "live_status");
    }

    private static boolean R(long j3, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        long stringToLong = NumberUtil.stringToLong(K(hotSearchItem, "live_roomid"), 0L);
        if (stringToLong != 0 && j3 == stringToLong) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(final HotWordSearchEntryDataModel hotWordSearchEntryDataModel) {
        QLog.i("QCircleHotSearchEntryModel", 1, "#initData: load local data");
        hotWordSearchEntryDataModel.l();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.search.r
            @Override // java.lang.Runnable
            public final void run() {
                t.this.S(hotWordSearchEntryDataModel);
            }
        });
    }

    private void U(QFSSearchLiveStatusChangeEvent qFSSearchLiveStatusChangeEvent) {
        HotWordSearchEntryDataModel.HotSearchItem M;
        long p16 = com.tencent.biz.qqcircle.immersive.views.search.util.p.p(qFSSearchLiveStatusChangeEvent.stFeed);
        if (p16 == 0 || (M = M(p16)) == null) {
            return;
        }
        int j3 = com.tencent.biz.qqcircle.immersive.views.search.util.p.j(qFSSearchLiveStatusChangeEvent.stFeed);
        if (j3 == 3) {
            H(M, qFSSearchLiveStatusChangeEvent.isOnlyLiveEvent());
        } else {
            I(M, j3);
        }
        if (!this.K.e(this.L.E)) {
            this.K.notifyDataSetChanged();
        }
    }

    private static boolean V(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i3) {
        try {
            JSONObject jSONObject = new JSONObject(hotSearchItem.sExtInfo);
            String optString = jSONObject.optString("live_status");
            if (!TextUtils.isEmpty(optString) && NumberUtil.stringToInt(optString, -1) == i3) {
                return false;
            }
            jSONObject.put("live_status", String.valueOf(i3));
            hotSearchItem.sExtInfo = jSONObject.toString();
            return true;
        } catch (JSONException e16) {
            QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
            return false;
        }
    }

    private void W(boolean z16) {
        GridView gridView = this.I;
        if (gridView == null) {
            return;
        }
        int childCount = gridView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.I.getChildAt(i3).getTag();
            if (tag instanceof a.AbstractC8550a) {
                a.AbstractC8550a abstractC8550a = (a.AbstractC8550a) tag;
                if (z16) {
                    abstractC8550a.d();
                } else {
                    abstractC8550a.c();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchPageCloseEvent.class);
        arrayList.add(QFSSearchLiveStatusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        final HotWordSearchEntryDataModel hotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(10, this.mTabType, true);
        if (this.J != null && !TextUtils.isEmpty(getModelName())) {
            this.J.setText(getModelName());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.q
            @Override // java.lang.Runnable
            public final void run() {
                t.this.T(hotWordSearchEntryDataModel);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        HotWordSearchEntryDataModel.HotSearchItem item = this.K.getItem(i3);
        com.tencent.mobileqq.search.util.u.b(view);
        String str = item.jumpUrl;
        if (TextUtils.isEmpty(str)) {
            Context context = this.F;
            if (context instanceof UniteSearchActivity) {
                ((UniteSearchActivity) context).M2(1, item.title);
                return;
            }
            if (context instanceof FragmentActivity) {
                Fragment findFragmentById = ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(R.id.ve8);
                if (findFragmentById instanceof UniteSearchFragment) {
                    UniteSearchFragment uniteSearchFragment = (UniteSearchFragment) findFragmentById;
                    uniteSearchFragment.setResultSourceType(1);
                    uniteSearchFragment.setHotSearchKeyWord(item.title);
                    uniteSearchFragment.setHotSearchKeyWordId(L(item));
                    uniteSearchFragment.changeText(item.title, true, false);
                    return;
                }
                return;
            }
            QLog.w("QCircleHotSearchEntryModel", 1, "#onItemClick: context is not instanceof UniteSearchActivity" + this.F);
            return;
        }
        ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), view.getContext(), str);
        if (c16 != null) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            SimpleEventBus.getInstance().registerReceiver(this);
            c16.b();
        } else {
            QLog.w("QCircleHotSearchEntryModel", 1, "#onItemClick: no jumpAction, moreUrl=" + str);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchPageCloseEvent) {
            Context context = this.F;
            if (context instanceof Activity) {
                ((Activity) context).finish();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSSearchLiveStatusChangeEvent) {
            U((QFSSearchLiveStatusChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void onResume() {
        super.onResume();
        W(true);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        this.F = context;
        J(qQAppInterface);
        if (this.G == null) {
            QLog.w("QCircleHotSearchEntryModel", 1, "#onCreateView: app is null");
            return new View(context);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.gva, (ViewGroup) null);
        this.H = inflate;
        int i3 = 8;
        inflate.setVisibility(8);
        View findViewById = this.H.findViewById(R.id.bmt);
        this.J = (TextView) this.H.findViewById(R.id.title);
        this.I = (GridView) this.H.findViewById(R.id.eap);
        if (this.showDivider) {
            i3 = 0;
        }
        findViewById.setVisibility(i3);
        a aVar = new a();
        this.K = aVar;
        this.I.setAdapter((ListAdapter) aVar);
        this.I.setNumColumns(1);
        this.I.setOnItemClickListener(this);
        this.I.setOverScrollMode(2);
        N(context, this.H, findViewById);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.H, false);
            AccessibilityUtil.n(this.I, false);
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void t() {
        super.t();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void u() {
        super.u();
        W(false);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void S(SearchEntryDataModel searchEntryDataModel) {
        if (this.H == null) {
            return;
        }
        HotWordSearchEntryDataModel hotWordSearchEntryDataModel = (HotWordSearchEntryDataModel) searchEntryDataModel;
        this.L = hotWordSearchEntryDataModel;
        if (hotWordSearchEntryDataModel.E.isEmpty()) {
            this.H.setVisibility(8);
            QLog.w("QCircleHotSearchEntryModel", 1, "#updateData: no data");
            return;
        }
        this.H.setVisibility(0);
        String str = this.L.F.f283449a;
        QLog.i("QCircleHotSearchEntryModel", 1, "#updateData: title=" + str + ", item count=" + this.L.E.size());
        if (!TextUtils.isEmpty(str)) {
            this.J.setText(str);
        }
        this.K.e(this.L.E);
        com.tencent.mobileqq.search.util.u.g(this.I, this.K.getCount());
        SimpleEventBus.getInstance().dispatchEvent(new UpdateSearchHintEvent(this.L.r()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final List<HotWordSearchEntryDataModel.HotSearchItem> f284866d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final Comparator<HotWordSearchEntryDataModel.HotSearchItem> f284867e = new Comparator() { // from class: com.tencent.mobileqq.search.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d16;
                d16 = t.a.d((HotWordSearchEntryDataModel.HotSearchItem) obj, (HotWordSearchEntryDataModel.HotSearchItem) obj2);
                return d16;
            }
        };

        /* compiled from: P */
        /* loaded from: classes18.dex */
        private class b extends AbstractC8550a {

            /* renamed from: e, reason: collision with root package name */
            private TextView f284873e;

            b(ViewGroup viewGroup) {
                super(viewGroup);
                this.f284873e = (TextView) this.f284869a.findViewById(R.id.f166942ja3);
            }

            private boolean e() {
                if (!TextUtils.isEmpty(this.f284871c.tagInfo) && !TextUtils.isEmpty(this.f284871c.tagColor) && !TextUtils.isEmpty(this.f284871c.tagBGColor)) {
                    return true;
                }
                return false;
            }

            private void f() {
                if (!e()) {
                    this.f284873e.setVisibility(8);
                    return;
                }
                try {
                    int parseColor = Color.parseColor(this.f284871c.tagColor);
                    int parseColor2 = Color.parseColor(this.f284871c.tagBGColor);
                    this.f284873e.setVisibility(0);
                    this.f284873e.setText(this.f284871c.tagInfo);
                    this.f284873e.setTextColor(parseColor);
                    this.f284873e.setBackground(com.tencent.biz.qqcircle.immersive.views.search.util.ad.f(parseColor2, 3, 17, 17));
                } catch (IllegalArgumentException e16) {
                    QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
                }
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            @CallSuper
            void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i3) {
                super.a(hotSearchItem, i3);
                f();
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            protected int b() {
                return R.layout.gv8;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public abstract class c extends AbstractC8550a {
            c(ViewGroup viewGroup) {
                super(viewGroup);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void g(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
                a.this.f284866d.remove(hotSearchItem);
                a.this.notifyDataSetChanged();
            }

            private void i(final HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
                t.this.I.post(new Runnable() { // from class: com.tencent.mobileqq.search.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.c.this.g(hotSearchItem);
                    }
                });
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            final void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i3) {
                JSONObject jSONObject;
                super.a(hotSearchItem, i3);
                try {
                    jSONObject = new JSONObject(hotSearchItem.sExtInfo);
                } catch (JSONException e16) {
                    QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    i(hotSearchItem);
                } else {
                    f(jSONObject);
                }
            }

            abstract void f(JSONObject jSONObject);

            void h(ImageView imageView, int i3) {
                Drawable mutate;
                Drawable drawable = imageView.getResources().getDrawable(i3);
                if (drawable instanceof SkinnableBitmapDrawable) {
                    mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
                } else {
                    mutate = drawable.mutate();
                }
                imageView.setImageDrawable(mutate);
                imageView.setColorFilter(this.f284869a.getResources().getColor(R.color.qui_common_text_link));
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        private class d extends c {

            /* renamed from: f, reason: collision with root package name */
            private final g f284876f;

            /* renamed from: g, reason: collision with root package name */
            private final ImageView f284877g;

            d(ViewGroup viewGroup) {
                super(viewGroup);
                this.f284876f = new g(this.f284869a);
                this.f284877g = (ImageView) this.f284869a.findViewById(R.id.yls);
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            protected int b() {
                return R.layout.gv_;
            }

            @Override // com.tencent.mobileqq.search.t.a.c
            void f(JSONObject jSONObject) {
                this.f284876f.f284886c.setText(jSONObject.optString("game_description"));
                this.f284876f.f284884a.setAlpha(1.0f);
                this.f284876f.f284884a.setVisibility(0);
                h(this.f284877g, R.drawable.qvideo_skin_icon_search_record);
                this.f284876f.f284885b.setText(R.string.f1907542y);
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        private class e extends f {

            /* renamed from: i, reason: collision with root package name */
            private final g f284879i;

            e(ViewGroup viewGroup) {
                super(viewGroup);
                this.f284879i = new g(this.f284869a);
            }

            private int m(JSONObject jSONObject) {
                String optString = jSONObject.optString("live_status");
                if (TextUtils.isEmpty(optString)) {
                    return -1;
                }
                return NumberUtil.stringToInt(optString, -1);
            }

            private void n(JSONObject jSONObject) {
                this.f284879i.f284886c.setText(jSONObject.optString("live_summary"));
                int m3 = m(jSONObject);
                if (m3 != 0 && m3 != 2) {
                    this.f284879i.f284888e.setVisibility(8);
                    this.f284879i.f284887d.setVisibility(8);
                } else {
                    this.f284879i.f284888e.setText(jSONObject.optString("live_date"));
                    this.f284879i.f284888e.setVisibility(0);
                    this.f284879i.f284887d.setVisibility(0);
                }
            }

            private void o(JSONObject jSONObject) {
                int i3;
                this.f284879i.f284884a.setVisibility(8);
                this.f284879i.f284884a.setAlpha(1.0f);
                int m3 = m(jSONObject);
                if (m3 != 0) {
                    if (m3 != 1) {
                        if (m3 != 2) {
                            return;
                        }
                        this.f284879i.f284884a.setAlpha(0.6f);
                        h(this.f284881f, R.drawable.qvideo_skin_icon_search_record);
                        i3 = R.string.f1914544u;
                    } else {
                        l();
                        i3 = R.string.f1914844x;
                    }
                } else {
                    h(this.f284881f, R.drawable.qvideo_skin_icon_search_record);
                    i3 = R.string.f1914444t;
                }
                this.f284879i.f284884a.setVisibility(0);
                this.f284879i.f284885b.setText(i3);
            }

            @Override // com.tencent.mobileqq.search.t.a.f, com.tencent.mobileqq.search.t.a.AbstractC8550a
            protected int b() {
                return R.layout.gv_;
            }

            @Override // com.tencent.mobileqq.search.t.a.f, com.tencent.mobileqq.search.t.a.c
            void f(JSONObject jSONObject) {
                o(jSONObject);
                n(jSONObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class f extends c {

            /* renamed from: f, reason: collision with root package name */
            final ImageView f284881f;

            /* renamed from: g, reason: collision with root package name */
            private WeakReference<LottieDrawable> f284882g;

            f(ViewGroup viewGroup) {
                super(viewGroup);
                this.f284881f = (ImageView) this.f284869a.findViewById(R.id.yls);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void k(LottieComposition lottieComposition) {
                float dip2px = 33.0f / ViewUtils.dip2px(9.0f);
                LottieDrawable lottieDrawable = new LottieDrawable();
                lottieDrawable.setComposition(lottieComposition);
                lottieDrawable.loop(true);
                this.f284881f.setImageDrawable(lottieDrawable);
                this.f284881f.setScaleX(dip2px);
                this.f284881f.setScaleY(dip2px);
                this.f284881f.setPivotX(r4.getWidth() / 2.0f);
                this.f284881f.setPivotY(r4.getHeight() / 2.0f);
                lottieDrawable.start();
                this.f284882g = new WeakReference<>(lottieDrawable);
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            protected int b() {
                return R.layout.gv9;
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            void c() {
                LottieDrawable lottieDrawable;
                super.c();
                WeakReference<LottieDrawable> weakReference = this.f284882g;
                if (weakReference != null && (lottieDrawable = weakReference.get()) != null) {
                    lottieDrawable.stop();
                }
            }

            @Override // com.tencent.mobileqq.search.t.a.AbstractC8550a
            void d() {
                LottieDrawable lottieDrawable;
                super.d();
                WeakReference<LottieDrawable> weakReference = this.f284882g;
                if (weakReference != null && (lottieDrawable = weakReference.get()) != null) {
                    lottieDrawable.start();
                }
            }

            @Override // com.tencent.mobileqq.search.t.a.c
            void f(JSONObject jSONObject) {
                l();
            }

            void l() {
                LottieCompositionFactory.fromAsset(t.this.F, "q_search_live_icon.json").addListener(new LottieListener() { // from class: com.tencent.mobileqq.search.v
                    @Override // com.airbnb.lottie.LottieListener
                    public final void onResult(Object obj) {
                        t.a.f.this.k((LottieComposition) obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class g {

            /* renamed from: a, reason: collision with root package name */
            final View f284884a;

            /* renamed from: b, reason: collision with root package name */
            final TextView f284885b;

            /* renamed from: c, reason: collision with root package name */
            final TextView f284886c;

            /* renamed from: d, reason: collision with root package name */
            final View f284887d;

            /* renamed from: e, reason: collision with root package name */
            final TextView f284888e;

            g(View view) {
                this.f284884a = view.findViewById(R.id.ylt);
                this.f284885b = (TextView) view.findViewById(R.id.ymb);
                this.f284886c = (TextView) view.findViewById(R.id.xb9);
                this.f284887d = view.findViewById(R.id.xb_);
                this.f284888e = (TextView) view.findViewById(R.id.xbo);
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int d(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem2) {
            if (hotSearchItem == hotSearchItem2) {
                return 0;
            }
            if (hotSearchItem != null && hotSearchItem2 != null && TextUtils.equals(hotSearchItem.title, hotSearchItem2.title) && TextUtils.equals(hotSearchItem.rightIconUrl, hotSearchItem2.rightIconUrl) && TextUtils.equals(hotSearchItem.sExtInfo, hotSearchItem2.sExtInfo)) {
                return 0;
            }
            return -1;
        }

        private void f(int i3, View view, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
            u.b bVar = new u.b();
            bVar.f285083e = String.valueOf(i3 + 1);
            bVar.f285080b = hotSearchItem.title;
            bVar.f285084f = "2";
            if (t.Q(hotSearchItem)) {
                bVar.f285087i = "1";
            } else {
                bVar.f285087i = "0";
            }
            if (!TextUtils.isEmpty(hotSearchItem.sExtInfo)) {
                try {
                    JSONObject jSONObject = new JSONObject(hotSearchItem.sExtInfo);
                    bVar.f285081c = jSONObject.optString("firstSource", "");
                    bVar.f285082d = jSONObject.optString("secondSource", "");
                    bVar.f285079a = jSONObject.optString("wordId", "");
                    if (t.P(hotSearchItem)) {
                        bVar.f285088j = jSONObject.optString("live_roomid", "");
                        bVar.f285089k = jSONObject.optString("live_status", "");
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("label");
                    if (optJSONObject != null) {
                        bVar.f285085g = optJSONObject.optString("text", "");
                        String optString = jSONObject.optString("hot_search_display_tag_type", "");
                        if (!TextUtils.isEmpty(optString)) {
                            bVar.f285085g = optString;
                        }
                    }
                } catch (JSONException e16) {
                    QLog.w("QCircleHotSearchEntryModel", 1, e16.getMessage(), e16);
                }
            }
            com.tencent.mobileqq.search.util.u.f(view, bVar);
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public HotWordSearchEntryDataModel.HotSearchItem getItem(int i3) {
            return this.f284866d.get(i3);
        }

        public boolean e(List<HotWordSearchEntryDataModel.HotSearchItem> list) {
            if (list != null && !list.isEmpty()) {
                if (SearchUtil.g(this.f284866d, list, this.f284867e)) {
                    QLog.i("QCircleHotSearchEntryModel", 1, "#updateData: same data, no update");
                    return false;
                }
                this.f284866d.clear();
                this.f284866d.addAll(list);
            } else {
                this.f284866d.clear();
                QLog.w("QCircleHotSearchEntryModel", 1, "#updateData: empty data. It looks like a server bug");
            }
            notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f284866d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            HotWordSearchEntryDataModel.HotSearchItem item = getItem(i3);
            if (t.P(item)) {
                return 1;
            }
            if (t.Q(item)) {
                return 2;
            }
            if (t.O(item)) {
                return 3;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            AbstractC8550a abstractC8550a;
            if (view == null) {
                int itemViewType = getItemViewType(i3);
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            abstractC8550a = new b(viewGroup);
                        } else {
                            abstractC8550a = new d(viewGroup);
                        }
                    } else {
                        abstractC8550a = new f(viewGroup);
                    }
                } else {
                    abstractC8550a = new e(viewGroup);
                }
                View view3 = abstractC8550a.f284869a;
                view3.setTag(abstractC8550a);
                view2 = view3;
            } else {
                view2 = view;
                abstractC8550a = (AbstractC8550a) view.getTag();
            }
            HotWordSearchEntryDataModel.HotSearchItem item = getItem(i3);
            abstractC8550a.a(item, i3);
            f(i3, view2, item);
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.search.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public abstract class AbstractC8550a {

            /* renamed from: a, reason: collision with root package name */
            protected final View f284869a;

            /* renamed from: b, reason: collision with root package name */
            protected final TextView f284870b;

            /* renamed from: c, reason: collision with root package name */
            protected HotWordSearchEntryDataModel.HotSearchItem f284871c;

            AbstractC8550a(ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(t.this.F).inflate(b(), viewGroup, false);
                this.f284869a = inflate;
                this.f284870b = (TextView) inflate.findViewById(R.id.jfb);
            }

            @CallSuper
            void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i3) {
                this.f284871c = hotSearchItem;
                this.f284870b.setText(hotSearchItem.title);
            }

            protected abstract int b();

            void c() {
            }

            void d() {
            }
        }
    }
}
