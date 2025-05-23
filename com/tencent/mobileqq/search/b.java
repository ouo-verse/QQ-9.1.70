package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.model.b;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchdetail.eventbus.JumpBusinessSearchEntryEvent;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends BaseSearchEntryModel<View> {
    private Context F;
    private View G;
    private LinearLayout H;
    private QQAppInterface I;
    private HashMap<String, Integer> J;
    private com.tencent.mobileqq.search.util.z K;
    private TextView L;
    private ArrayList<String> M;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f282775d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b.a f282776e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f282777f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f282778h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f282779i;

        a(View view, b.a aVar, View view2, String str, List list) {
            this.f282775d = view;
            this.f282776e = aVar;
            this.f282777f = view2;
            this.f282778h = str;
            this.f282779i = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0180  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (!(this.f282775d.getTag() instanceof Long) || currentTimeMillis - ((Long) this.f282775d.getTag()).longValue() >= 400) {
                this.f282775d.setTag(Long.valueOf(currentTimeMillis));
                if (this.f282776e.f283521d.equals("mqqapi://contact/search_might_know")) {
                    ReportController.o(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
                }
                if (!TextUtils.isEmpty(this.f282776e.f283521d)) {
                    String str = this.f282776e.f283521d;
                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                        if (this.f282776e.f283524g == 103) {
                            Intent intent = new Intent();
                            intent.putExtra("key_refer", 4001);
                            PublicFragmentActivity.start(view.getContext(), intent, ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
                        } else {
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(b.this.F, str, 2005, null);
                            z16 = true;
                            if (this.f282776e.f283524g == 1) {
                                if (z16) {
                                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "2", null, null);
                                } else {
                                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "1", null, null);
                                }
                            }
                        }
                    } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                        if (this.f282776e.f283524g == 104) {
                            ActiveEntitySearchActivity.e3(b.this.F, HardCodeUtil.qqStr(R.string.f172669t74), new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN}, 99, 86, b.this.E(), "QQ\u53f7/QID/\u624b\u673a\u53f7/\u7fa4");
                        } else if (b.this.F instanceof BaseActivity) {
                            ax c16 = bi.c(((BaseActivity) view.getContext()).app, b.this.F, str);
                            if (c16 != null) {
                                c16.b();
                            } else {
                                b.this.F.startActivity(new Intent(b.this.F, (Class<?>) JumpActivity.class).setData(Uri.parse(str)));
                            }
                        } else {
                            b.this.F.startActivity(new Intent(b.this.F, (Class<?>) JumpActivity.class).setData(Uri.parse(str)));
                        }
                    } else {
                        Intent intent2 = new Intent(b.this.F, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("url", str);
                        b.this.F.startActivity(intent2);
                    }
                    z16 = false;
                    if (this.f282776e.f283524g == 1) {
                    }
                } else {
                    b bVar = b.this;
                    int i3 = bVar.mTabType;
                    if (i3 == 3) {
                        i3 = 21;
                    }
                    ArrayList E = bVar.E();
                    Context context = b.this.F;
                    b.a aVar = this.f282776e;
                    ActiveEntitySearchActivity.f3(context, aVar.f283518a, aVar.f283520c, i3, E, "QQ\u53f7/QID/\u624b\u673a\u53f7/\u7fa4");
                    if (!NetworkUtil.isNetworkAvailable(b.this.F)) {
                        QQToast.makeText(b.this.F, 0, b.this.F.getResources().getString(R.string.f173056gt1), 0).show();
                    }
                }
                SimpleEventBus.getInstance().dispatchEvent(new JumpBusinessSearchEntryEvent(this.f282776e.f283524g));
                if (this.f282777f.getVisibility() == 0) {
                    this.f282777f.setVisibility(8);
                    ea.N2(this.f282776e.f283524g, this.f282778h);
                }
                SearchUtils.W0("home_page", "clk_entry", this.f282776e.f283518a, String.valueOf(b.this.mTabType), String.valueOf(this.f282779i.size()));
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(com.tencent.mobileqq.search.report.b.a(b.this.mTabType)).ver3(this.f282779i.size() + "").ver4(this.f282776e.f283518a).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                new UniteSearchHandler(qQAppInterface).H2(qQAppInterface, "clk_entry", "all_result", com.tencent.mobileqq.search.report.b.a(b.this.mTabType), "", this.f282776e.f283518a, "{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}");
                com.tencent.mobileqq.search.report.b.e(b.this.I, 0, SearchEntryFragment.convertTabTypeToSearchFrom(b.this.mTabType), "0X8009D1C", 0, 0, this.f282776e.f283518a, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(int i3, int i16) {
        super(i3, i16);
        this.M = new ArrayList<>();
    }

    private URLDrawable D(b.a aVar, ColorDrawable colorDrawable) {
        int i3;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (I()) {
            i3 = 24;
        } else {
            i3 = 28;
        }
        float f16 = i3;
        obtain.mRequestHeight = BaseAIOUtils.f(f16, this.F.getResources());
        obtain.mRequestWidth = BaseAIOUtils.f(f16, this.F.getResources());
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        return URLDrawable.getDrawable(aVar.f283519b, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ArrayList<String> E() {
        ArrayList<String> arrayList = this.M;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (TextUtils.equals("\u641c\u7d22", arrayList.get(i3))) {
                arrayList.set(i3, "QQ\u53f7/QID/\u624b\u673a\u53f7/\u7fa4");
            }
        }
        return arrayList;
    }

    private void G(View view) {
        int i3;
        int i16;
        if (!aq.a() && !I()) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.kbs);
        this.L = textView;
        Context context = textView.getContext();
        if (J()) {
            i3 = R.color.qui_common_text_secondary;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        textView.setTextColor(AppCompatResources.getColorStateList(context, i3));
        this.L.setGravity(8388627);
        View view2 = new View(this.F);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.F.getResources().getDimensionPixelSize(R.dimen.f158696ml));
        layoutParams.leftMargin = ViewUtils.dip2px(16.0f);
        if (J()) {
            i16 = ViewUtils.dip2px(16.0f);
        } else {
            i16 = 0;
        }
        layoutParams.rightMargin = i16;
        layoutParams.gravity = 80;
        view2.setLayoutParams(layoutParams);
        ViewGroup viewGroup = (ViewGroup) this.L.getParent();
        view2.setBackgroundDrawable(view.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        viewGroup.addView(view2);
        if (J()) {
            this.G.setBackgroundResource(0);
        } else if (I()) {
            this.G.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        } else {
            this.G.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        }
        if (I()) {
            this.L.setTextSize(1, 14.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            marginLayoutParams.height = ViewUtils.dpToPx(38.0f);
            viewGroup.setLayoutParams(marginLayoutParams);
            this.G.setPadding(0, 0, 0, ViewUtils.dip2px(12.0f));
        }
    }

    private void H() {
        String str;
        int i3;
        if (this.J != null) {
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        this.J = hashMap;
        hashMap.put("https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png", Integer.valueOf(R.drawable.qui_add_friend));
        this.J.put("https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png", Integer.valueOf(R.drawable.qui_emoticon));
        this.J.put("https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png", Integer.valueOf(R.drawable.qui_avatar));
        this.J.put("https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png", Integer.valueOf(R.drawable.qui_mini_program));
        this.J.put("https://sola.gtimg.cn/aoi/sola/20200805150154_yGkHAchZSR.png", Integer.valueOf(R.drawable.qui_hi));
        HashMap<String, Integer> hashMap2 = this.J;
        if (uq3.c.Y4()) {
            str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_entrance_icon_search.png";
        } else {
            str = "https://static-res.qq.com/static-res/jaxlin/small_world@3x.png";
        }
        if (uq3.c.Y4()) {
            i3 = R.drawable.qui_small_world_02;
        } else {
            i3 = R.drawable.qui_small_world;
        }
        hashMap2.put(str, Integer.valueOf(i3));
        this.J.put("https://downv6.qq.com/innovate/search_robot.png", Integer.valueOf(R.drawable.qui_robot));
    }

    private boolean I() {
        if (this.K != null) {
            return true;
        }
        return false;
    }

    private boolean J() {
        if (this.K != null) {
            return true;
        }
        return false;
    }

    private void M(List<Integer> list) {
        if (list != null && I()) {
            int dip2px = ViewUtils.dip2px(12.0f);
            this.H.setPadding(0, dip2px, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.H.getLayoutParams();
            int dip2px2 = ViewUtils.dip2px(10.0f);
            marginLayoutParams.leftMargin = dip2px2;
            marginLayoutParams.rightMargin = dip2px2;
            LinearLayout linearLayout = (LinearLayout) this.G.findViewById(R.id.yoy);
            linearLayout.setPadding(0, dip2px, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams2.leftMargin = dip2px2;
            marginLayoutParams2.rightMargin = dip2px2;
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.G.findViewById(it.next().intValue()).setPadding(0, 0, 0, 0);
            }
            if (this.showDivider) {
                View view = this.G;
                view.setPadding(view.getPaddingLeft(), ViewUtils.dip2px(8.0f), this.G.getPaddingRight(), this.G.getPaddingBottom());
            }
        }
    }

    public List<Integer> C() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id.bl9));
        arrayList.add(Integer.valueOf(R.id.blc));
        arrayList.add(Integer.valueOf(R.id.bld));
        arrayList.add(Integer.valueOf(R.id.ble));
        arrayList.add(Integer.valueOf(R.id.blf));
        arrayList.add(Integer.valueOf(R.id.blg));
        arrayList.add(Integer.valueOf(R.id.blh));
        arrayList.add(Integer.valueOf(R.id.bli));
        arrayList.add(Integer.valueOf(R.id.blj));
        arrayList.add(Integer.valueOf(R.id.bl_));
        arrayList.add(Integer.valueOf(R.id.bla));
        arrayList.add(Integer.valueOf(R.id.blb));
        return arrayList;
    }

    public List<Integer> F() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id.bl9));
        arrayList.add(Integer.valueOf(R.id.blc));
        arrayList.add(Integer.valueOf(R.id.bld));
        arrayList.add(Integer.valueOf(R.id.ble));
        arrayList.add(Integer.valueOf(R.id.blf));
        arrayList.add(Integer.valueOf(R.id.blh));
        arrayList.add(Integer.valueOf(R.id.bli));
        arrayList.add(Integer.valueOf(R.id.blj));
        arrayList.add(Integer.valueOf(R.id.bl_));
        arrayList.add(Integer.valueOf(R.id.bla));
        return arrayList;
    }

    public void K(com.tencent.mobileqq.search.util.z zVar) {
        this.K = zVar;
    }

    public void L(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.M = new ArrayList<>();
        } else {
            this.M = arrayList;
        }
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        com.tencent.mobileqq.search.model.b bVar = new com.tencent.mobileqq.search.model.b(3, this.mTabType);
        if (this.L != null && !TextUtils.isEmpty(getModelName())) {
            this.L.setText(getModelName());
        }
        p(bVar);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        this.F = context;
        this.I = qQAppInterface;
        if (qQAppInterface == null) {
            if (context instanceof BaseActivity) {
                obj = ((BaseActivity) context).getAppRuntime();
            } else {
                obj = null;
            }
            if (obj instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) obj;
            }
        }
        if (qQAppInterface == null) {
            return new View(context);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.c2f, (ViewGroup) null);
        this.G = inflate;
        this.H = (LinearLayout) inflate.findViewById(R.id.edn);
        G(this.G);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.G, false);
        }
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    /* renamed from: y */
    public void S(SearchEntryDataModel searchEntryDataModel) {
        List<b.a> list;
        List<Integer> C;
        float f16;
        int i3;
        String currentUin = this.I.getCurrentUin();
        com.tencent.mobileqq.search.model.b bVar = (com.tencent.mobileqq.search.model.b) searchEntryDataModel;
        if (bVar != null && (list = bVar.D) != null && list.size() != 0) {
            if (list.size() <= 6) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
            }
            if (list.size() == 10) {
                C = F();
            } else {
                C = C();
            }
            List<Integer> list2 = C;
            for (int i16 = 0; i16 < list.size(); i16++) {
                b.a aVar = list.get(i16);
                View findViewById = this.G.findViewById(list2.get(i16).intValue());
                View findViewById2 = findViewById.findViewById(R.id.i4v);
                TextView textView = (TextView) findViewById.findViewById(R.id.bl8);
                URLImageView uRLImageView = (URLImageView) findViewById.findViewById(R.id.bl7);
                if (I() && uRLImageView != null) {
                    ViewGroup.LayoutParams layoutParams = uRLImageView.getLayoutParams();
                    int dip2px = ViewUtils.dip2px(24.0f);
                    layoutParams.width = dip2px;
                    layoutParams.height = dip2px;
                }
                findViewById.setVisibility(0);
                findViewById.setPadding(0, ViewUtils.dip2px(12.0f), 0, 0);
                ColorDrawable colorDrawable = new ColorDrawable();
                if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                    colorDrawable.setColor(this.F.getResources().getColor(R.color.akc));
                } else {
                    colorDrawable.setColor(this.F.getResources().getColor(R.color.akb));
                }
                if (!TextUtils.isEmpty(aVar.f283519b) && uRLImageView != null) {
                    if (!QQTheme.isNowSimpleUI() && !TokenResUtils.useTokenIcon() && !I()) {
                        uRLImageView.setImageDrawable(D(aVar, colorDrawable));
                    } else {
                        H();
                        Integer num = this.J.get(aVar.f283519b);
                        if (num == null) {
                            uRLImageView.setImageDrawable(D(aVar, colorDrawable));
                        } else {
                            Drawable drawable = AppCompatResources.getDrawable(this.F, num.intValue());
                            if (drawable != null) {
                                uRLImageView.setImageDrawable(drawable);
                            } else {
                                uRLImageView.setImageDrawable(D(aVar, colorDrawable));
                            }
                        }
                        if (J()) {
                            uRLImageView.setAlpha(0.7f);
                        }
                    }
                }
                textView.setText(aVar.f283518a);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.c(findViewById, aVar.f283518a, Button.class.getName());
                }
                if (I()) {
                    textView.setTextColor(AppCompatResources.getColorStateList(this.F, R.color.qui_common_text_primary_selector));
                    if (J()) {
                        textView.setAlpha(0.7f);
                    }
                    textView.setTextSize(1, 14.0f);
                    ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = ViewUtils.dip2px(4.0f);
                } else if (QQTheme.isNowSimpleUI()) {
                    if (!QQTheme.isNowThemeSimpleNight()) {
                        textView.setTextColor(-16777216);
                    }
                    if (SimpleUIUtil.isNowElderMode()) {
                        f16 = 18.0f;
                    } else {
                        f16 = 12.0f;
                    }
                    textView.setTextSize(1, f16);
                }
                int s06 = ea.s0(aVar.f283524g, currentUin);
                boolean g26 = ea.g2(aVar.f283524g, currentUin);
                if (aVar.f283522e == 1 && ((i3 = aVar.f283523f) > s06 || (i3 == s06 && !g26))) {
                    findViewById2.setVisibility(0);
                } else {
                    findViewById2.setVisibility(8);
                }
                ea.x2(aVar.f283524g, aVar.f283523f, currentUin);
                findViewById.setOnClickListener(new a(findViewById, aVar, findViewById2, currentUin, list));
                com.tencent.mobileqq.search.util.u.r(findViewById, String.valueOf(i16), com.tencent.mobileqq.search.util.x.j(aVar.f283524g));
            }
            if (list.size() < 6) {
                int size = list.size();
                for (int i17 = 6; size < i17; i17 = 6) {
                    this.G.findViewById(list2.get(size).intValue()).setVisibility(8);
                    size++;
                }
            }
            if (list.size() == 6) {
                this.G.findViewById(R.id.blh).setVisibility(8);
                this.G.findViewById(R.id.bli).setVisibility(8);
                this.G.findViewById(R.id.blj).setVisibility(8);
                this.G.findViewById(R.id.bl_).setVisibility(8);
                this.G.findViewById(R.id.bla).setVisibility(8);
                this.G.findViewById(R.id.blb).setVisibility(8);
            } else if (list.size() == 10) {
                this.G.findViewById(R.id.blg).setVisibility(8);
                this.G.findViewById(R.id.blb).setVisibility(8);
            }
            StringBuilder sb5 = new StringBuilder("");
            for (int i18 = 0; i18 < list.size(); i18++) {
                if (i18 == list.size() - 1) {
                    sb5.append(list.get(i18).f283518a);
                } else {
                    sb5.append(list.get(i18).f283518a);
                    sb5.append("::");
                }
            }
            Map<Integer, Boolean> map = ISearchEntryFragment.mIsModelsReported;
            Boolean bool = map.get(3);
            if (bool == null || !bool.booleanValue()) {
                SearchUtils.W0("home_page", "exp_entry", sb5.toString(), "", String.valueOf(this.mTabType));
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(com.tencent.mobileqq.search.report.b.a(this.mTabType)).ver4(sb5.toString()).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                new UniteSearchHandler(qQAppInterface).H2(qQAppInterface, "exp_entry", "all_result", com.tencent.mobileqq.search.report.b.a(this.mTabType), "", sb5.toString(), "{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}");
                map.put(3, Boolean.TRUE);
                int convertTabTypeToSearchFrom = SearchEntryFragment.convertTabTypeToSearchFrom(this.mTabType);
                for (b.a aVar2 : list) {
                    if (aVar2 != null) {
                        com.tencent.mobileqq.search.report.b.e(this.I, 0, convertTabTypeToSearchFrom, "0X8009D1B", 0, 0, aVar2.f283518a, null);
                    }
                }
            }
            M(list2);
        }
    }
}
