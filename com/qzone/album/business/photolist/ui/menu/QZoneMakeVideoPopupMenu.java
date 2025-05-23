package com.qzone.album.business.photolist.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.content.ContextCompat;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.ui.widget.SafePopupWindow;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.util.P2VUtil;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.al;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.RFWTriangleView;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes39.dex */
public class QZoneMakeVideoPopupMenu {

    /* renamed from: w, reason: collision with root package name */
    public static final String f43658w = l.a(R.string.wbe);

    /* renamed from: x, reason: collision with root package name */
    public static final String f43659x = l.a(R.string.wbw);

    /* renamed from: y, reason: collision with root package name */
    public static final String f43660y = l.a(R.string.w__);

    /* renamed from: a, reason: collision with root package name */
    private Context f43661a;

    /* renamed from: b, reason: collision with root package name */
    private SafePopupWindow f43662b;

    /* renamed from: e, reason: collision with root package name */
    private Animation f43665e;

    /* renamed from: f, reason: collision with root package name */
    private Animation f43666f;

    /* renamed from: g, reason: collision with root package name */
    private View f43667g;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<PhotoCacheData> f43669i;

    /* renamed from: m, reason: collision with root package name */
    private Timer f43673m;

    /* renamed from: n, reason: collision with root package name */
    private TimerTask f43674n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f43675o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f43676p;

    /* renamed from: q, reason: collision with root package name */
    public int f43677q;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f43678r;

    /* renamed from: s, reason: collision with root package name */
    int f43679s;

    /* renamed from: t, reason: collision with root package name */
    int f43680t;

    /* renamed from: u, reason: collision with root package name */
    private final HashMap<String, d> f43681u;

    /* renamed from: v, reason: collision with root package name */
    int f43682v;

    /* renamed from: c, reason: collision with root package name */
    private int f43663c = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f43664d = 1;

    /* renamed from: h, reason: collision with root package name */
    private String f43668h = null;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<PhotoCacheData> f43670j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f43671k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f43672l = false;

    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10) {
                QZoneMakeVideoPopupMenu.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneMakeVideoPopupMenu.this.e();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements PopupWindow.OnDismissListener {
        c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            QZoneMakeVideoPopupMenu.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        String f43687a;

        /* renamed from: b, reason: collision with root package name */
        View f43688b;

        /* renamed from: c, reason: collision with root package name */
        ViewSwitcher f43689c;

        /* renamed from: d, reason: collision with root package name */
        AsyncImageView[] f43690d;

        /* renamed from: e, reason: collision with root package name */
        TextView f43691e;

        d() {
        }
    }

    public QZoneMakeVideoPopupMenu(Context context, int i3) {
        this.f43675o = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MAKE_PHOTO_BLOG_FUNCTION_SWITCH, 1) == 1;
        this.f43678r = new a(Looper.getMainLooper());
        this.f43681u = new HashMap<>();
        if (context != null) {
            this.f43661a = context;
            this.f43677q = i3;
            o();
        }
    }

    private d c(int i3, int i16, String str) {
        View inflate = LayoutInflater.from(this.f43661a).inflate(R.layout.bgv, (ViewGroup) null);
        d dVar = new d();
        dVar.f43687a = str;
        dVar.f43688b = inflate;
        dVar.f43689c = (ViewSwitcher) inflate.findViewById(R.id.fgm);
        AsyncImageView[] asyncImageViewArr = new AsyncImageView[2];
        dVar.f43690d = asyncImageViewArr;
        asyncImageViewArr[0] = (AsyncImageView) inflate.findViewById(R.id.fgk);
        dVar.f43690d[1] = (AsyncImageView) inflate.findViewById(R.id.fgl);
        dVar.f43690d[0].setDefaultImage(R.drawable.fyy);
        dVar.f43690d[1].setDefaultImage(R.drawable.fyy);
        for (int i17 = 0; i17 < 2; i17++) {
            ViewGroup.LayoutParams layoutParams = dVar.f43690d[i17].getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            dVar.f43690d[i17].setLayoutParams(layoutParams);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.fgn);
        dVar.f43691e = textView;
        textView.setText(str);
        return dVar;
    }

    private void d() {
        Timer timer = this.f43673m;
        if (timer != null) {
            timer.cancel();
            this.f43673m = null;
        }
        TimerTask timerTask = this.f43674n;
        if (timerTask != null) {
            timerTask.cancel();
            this.f43674n = null;
        }
    }

    private int k() {
        int i3 = (this.f43670j.size() <= 0 || !this.f43671k) ? 1 : 2;
        return this.f43675o ? i3 + 1 : i3;
    }

    private void m() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f43661a, R.anim.f154548b2);
        this.f43665e = loadAnimation;
        loadAnimation.setDuration(995L);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f43661a, R.anim.f154550b4);
        this.f43666f = loadAnimation2;
        loadAnimation2.setDuration(1000L);
    }

    private void n(View view) {
        boolean g16 = u5.c.g("key_sp_has_show_guide", false, LoginData.getInstance().getUin());
        final View findViewById = view.findViewById(R.id.mra);
        if (g16) {
            findViewById.setVisibility(8);
            return;
        }
        int color = view.getResources().getColor(R.color.qui_common_brand_standard);
        if (QQTheme.isVasTheme()) {
            color = ContextCompat.getColor(this.f43661a, R.color.csm);
        }
        View findViewById2 = view.findViewById(R.id.mr8);
        findViewById.setVisibility(0);
        TextView textView = (TextView) findViewById.findViewById(R.id.mrb);
        RFWTriangleView rFWTriangleView = (RFWTriangleView) findViewById.findViewById(R.id.mr5);
        rFWTriangleView.setVisibility(0);
        rFWTriangleView.setArrowColor(color);
        findViewById2.setBackgroundColor(color);
        textView.setText(view.getResources().getString(R.string.skv));
        findViewById.postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.ui.menu.QZoneMakeVideoPopupMenu.4
            @Override // java.lang.Runnable
            public void run() {
                findViewById.setVisibility(8);
                u5.c.C("key_sp_has_show_guide", true, LoginData.getInstance().getUin());
            }
        }, 3000L);
    }

    private void o() {
        View inflate = LayoutInflater.from(this.f43661a).inflate(R.layout.f128463f, (ViewGroup) null);
        this.f43667g = inflate;
        this.f43676p = (LinearLayout) inflate.findViewById(R.id.mht);
        this.f43667g.findViewById(R.id.mhr).setOnClickListener(new b());
        Context context = this.f43661a;
        if ((context instanceof Activity) && DisplayUtil.hasNavBar(context) && DisplayUtil.isNavigationBarExist((Activity) this.f43661a)) {
            this.f43676p.setPadding(0, 0, 0, al.d((Activity) this.f43661a));
        }
        SafePopupWindow safePopupWindow = new SafePopupWindow(this.f43667g, -1, -1);
        this.f43662b = safePopupWindow;
        safePopupWindow.setFocusable(true);
        this.f43662b.setClippingEnabled(false);
        this.f43662b.setBackgroundDrawable(new BitmapDrawable());
        this.f43662b.setOnDismissListener(new c());
        n(this.f43667g);
        m();
    }

    private void p() {
        if (this.f43674n == null || this.f43673m == null) {
            this.f43673m = new BaseTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.qzone.album.business.photolist.ui.menu.QZoneMakeVideoPopupMenu.6
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Message message = new Message();
                    message.what = 10;
                    QZoneMakeVideoPopupMenu.this.f43678r.sendMessage(message);
                }
            };
            this.f43674n = timerTask;
            this.f43673m.schedule(timerTask, 2000L, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        PhotoCacheData photoCacheData;
        PictureItem pictureItem;
        ArrayList<PhotoCacheData> arrayList = this.f43670j;
        if (arrayList != null) {
            this.f43663c %= 2;
            if (this.f43664d >= arrayList.size() || (photoCacheData = this.f43670j.get(this.f43664d)) == null || (pictureItem = photoCacheData.picItem) == null || pictureItem.currentUrl == null) {
                return;
            }
            int i3 = this.f43664d + 1;
            this.f43664d = i3;
            if (i3 == this.f43670j.size()) {
                this.f43664d = 0;
            }
            HashMap<String, d> hashMap = this.f43681u;
            String str = f43658w;
            if (hashMap.get(str) == null || this.f43681u.get(str).f43690d == null) {
                return;
            }
            AsyncImageView[] asyncImageViewArr = this.f43681u.get(str).f43690d;
            ViewSwitcher viewSwitcher = this.f43681u.get(str).f43689c;
            asyncImageViewArr[this.f43663c].setAsyncImage(photoCacheData.picItem.currentUrl.url);
            asyncImageViewArr[this.f43663c].setVisibility(0);
            if (viewSwitcher != null) {
                viewSwitcher.setInAnimation(this.f43665e);
                viewSwitcher.setOutAnimation(this.f43666f);
                int i16 = this.f43663c;
                this.f43663c = i16 + 1;
                viewSwitcher.setDisplayedChild(i16);
            }
        }
    }

    public void f(boolean z16) {
        this.f43671k = z16;
    }

    public void g() {
        if (this.f43670j.size() <= 0 || !this.f43671k) {
            return;
        }
        LpReportInfo_pf00064.allReport(326, 2, 37);
    }

    public ArrayList<PhotoCacheData> i() {
        return this.f43669i;
    }

    public String j() {
        return this.f43668h;
    }

    public void r(d dVar) {
        dVar.f43689c.setVisibility(0);
        if (this.f43670j.size() == 0) {
            return;
        }
        PhotoCacheData photoCacheData = this.f43670j.get(0);
        if (photoCacheData != null) {
            dVar.f43690d[0].setAsyncImage(photoCacheData.picItem.currentUrl.url);
        }
        dVar.f43689c.setInAnimation(null);
        dVar.f43689c.setOutAnimation(null);
        dVar.f43689c.setDisplayedChild(0);
    }

    public void s(String str, View.OnClickListener onClickListener) {
        if (!this.f43681u.containsKey(str) || this.f43681u.get(str) == null || this.f43681u.get(str).f43688b == null || onClickListener == null) {
            return;
        }
        this.f43681u.get(str).f43688b.setOnClickListener(onClickListener);
    }

    public void u(View view) {
        SafePopupWindow safePopupWindow = this.f43662b;
        if (safePopupWindow != null && view != null) {
            safePopupWindow.showAtLocation(view, 80, 0, 0);
            this.f43662b.setFocusable(true);
            this.f43662b.setOutsideTouchable(true);
            this.f43662b.update();
        }
        if (!this.f43671k || this.f43672l) {
            return;
        }
        p();
        if (view != null) {
            view.post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.menu.QZoneMakeVideoPopupMenu.5
                @Override // java.lang.Runnable
                public void run() {
                    QZoneMakeVideoPopupMenu.this.q();
                }
            });
        } else {
            QZLog.e("QZoneMakeVideoPopupMenu", 2, "parent == null");
        }
    }

    public void v(View view) {
        P2VUtil.d().j(this.f43661a.getApplicationContext());
        u(view);
    }

    public void w() {
        String str;
        String l3;
        this.f43682v = this.f43661a.getResources().getDisplayMetrics().widthPixels;
        int d16 = ar.d(24.0f);
        int k3 = k();
        int d17 = ar.d(k3 == 2 ? 23.0f : 17.0f);
        boolean z16 = k3 == 2;
        this.f43679s = ((this.f43682v - (d16 * 2)) - ((k3 - 1) * d17)) / k3;
        this.f43680t = ar.d(195.0f);
        QZLog.d("[PhotoAlbum]p2vMakeBlog", 1, "width:", Integer.valueOf(this.f43679s), " height:", Integer.valueOf(this.f43680t), " itemNums:", Integer.valueOf(k3));
        this.f43676p.removeAllViews();
        if (this.f43670j.size() > 0 && this.f43671k) {
            int i3 = this.f43679s;
            int i16 = this.f43680t;
            String str2 = f43658w;
            d c16 = c(i3, i16, str2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = d16;
            c16.f43688b.setLayoutParams(layoutParams);
            this.f43681u.put(str2, c16);
            this.f43676p.addView(c16.f43688b);
            r(c16);
        }
        int i17 = this.f43679s;
        int i18 = this.f43680t;
        String str3 = f43659x;
        d c17 = c(i17, i18, str3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = d17;
        c17.f43688b.setLayoutParams(layoutParams2);
        this.f43681u.put(str3, c17);
        this.f43676p.addView(c17.f43688b);
        c17.f43690d[0].setScaleType(ImageView.ScaleType.FIT_XY);
        AsyncImageView asyncImageView = c17.f43690d[0];
        if (z16) {
            str = "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/video_template_covers/two_entrances_style.png";
        } else {
            str = "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/video_template_covers/three_entrances_style.png";
        }
        asyncImageView.setAsyncImage(str);
        if (this.f43675o) {
            int i19 = this.f43679s;
            int i26 = this.f43680t;
            String str4 = f43660y;
            d c18 = c(i19, i26, str4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = d17;
            c18.f43688b.setLayoutParams(layoutParams3);
            this.f43681u.put(str4, c18);
            this.f43676p.addView(c18.f43688b);
            AsyncImageView asyncImageView2 = c18.f43690d[0];
            if (k() >= 3) {
                l3 = h(this.f43677q);
            } else {
                l3 = l(this.f43677q);
            }
            asyncImageView2.setAsyncImage(l3);
            c18.f43690d[0].setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public void e() {
        this.f43672l = false;
        HashMap<String, d> hashMap = this.f43681u;
        String str = f43658w;
        if (hashMap.get(str) != null && this.f43681u.get(str).f43690d != null) {
            AsyncImageView[] asyncImageViewArr = this.f43681u.get(str).f43690d;
            ViewSwitcher viewSwitcher = this.f43681u.get(str).f43689c;
            viewSwitcher.setInAnimation(null);
            viewSwitcher.setOutAnimation(null);
            asyncImageViewArr[0].clearAnimation();
            asyncImageViewArr[1].clearAnimation();
        }
        d();
        SafePopupWindow safePopupWindow = this.f43662b;
        if (safePopupWindow != null) {
            safePopupWindow.dismiss();
        }
    }

    public void t(String str, ArrayList<PhotoCacheData> arrayList) {
        if (arrayList == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setP2VRecommendData:");
        String str2 = this.f43668h;
        sb5.append((str2 == null || str2.equals("") || !this.f43668h.equals(str)) ? false : true);
        QZLog.d("QZoneMakeVideoPopupMenu", 4, sb5.toString());
        this.f43668h = str;
        this.f43669i = arrayList;
        this.f43663c = 1;
        this.f43664d = 1;
        this.f43670j.clear();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoCacheData photoCacheData = arrayList.get(i3);
            if (photoCacheData.videoflag != 1) {
                this.f43670j.add(photoCacheData);
            }
        }
        if (this.f43670j.size() == 0) {
            QZLog.e("QZoneMakeVideoPopupMenu", "setP2VRecommendData - but p2vFakeRecommendList.size is 0 ?!");
            f(false);
        }
    }

    private String h(int i3) {
        if (i3 == 8) {
            return "https://qzonestyle.gtimg.cn/aoi/sola/20181122095143_YEOk96CuFy.png";
        }
        if (i3 == 9) {
            return "https://qzonestyle.gtimg.cn/aoi/sola/20181122095143_zLo9oSocJL.png";
        }
        if (i3 != 11) {
            return "https://qzonestyle.gtimg.cn/aoi/sola/20181122095143_c4izBUyUsn.png";
        }
        return "https://qzonestyle.gtimg.cn/aoi/sola/20181122095143_YX2BEbaOFk.png";
    }

    private String l(int i3) {
        if (i3 == 8) {
            return "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/notepad_blog_covers/children.png";
        }
        if (i3 == 9) {
            return "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/notepad_blog_covers/travel.png";
        }
        if (i3 != 11) {
            return "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/notepad_blog_covers/multi.png";
        }
        return "https://qzonestyle.gtimg.cn/qzone/qzone-static/album/notepad_blog_covers/love.png";
    }
}
