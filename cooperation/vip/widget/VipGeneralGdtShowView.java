package cooperation.vip.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.webview.controller.a;
import cooperation.vip.widget.a;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VipGeneralGdtShowView {

    /* renamed from: a, reason: collision with root package name */
    private Context f391419a;

    /* renamed from: b, reason: collision with root package name */
    private int f391420b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f391421c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f391422d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f391423e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f391424f;

    /* renamed from: g, reason: collision with root package name */
    private View f391425g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f391426h;

    /* renamed from: j, reason: collision with root package name */
    private AlumBasicData f391428j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f391429k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f391430l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f391431m;

    /* renamed from: n, reason: collision with root package name */
    c f391432n;

    /* renamed from: o, reason: collision with root package name */
    private int f391433o;

    /* renamed from: p, reason: collision with root package name */
    private int f391434p;

    /* renamed from: q, reason: collision with root package name */
    private int f391435q;

    /* renamed from: r, reason: collision with root package name */
    private int f391436r;

    /* renamed from: s, reason: collision with root package name */
    private int f391437s;

    /* renamed from: t, reason: collision with root package name */
    View.OnClickListener f391438t = new a();

    /* renamed from: i, reason: collision with root package name */
    private Handler f391427i = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && view.getId() == R.id.csy) {
                QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
                cooperation.vip.widget.a aVar = new cooperation.vip.widget.a((Activity) VipGeneralGdtShowView.this.f391419a);
                a.f fVar = new a.f();
                a.f fVar2 = new a.f();
                if (VipGeneralGdtShowView.this.f391428j.dropList != null && VipGeneralGdtShowView.this.f391428j.dropList.size() != 0) {
                    for (int i3 = 0; i3 < VipGeneralGdtShowView.this.f391428j.dropList.size(); i3++) {
                        a.f fVar3 = new a.f();
                        fVar3.f391473a = VipGeneralGdtShowView.this.f391428j.dropList.get(i3).actionType;
                        fVar3.f391475c = VipGeneralGdtShowView.this.f391428j.dropList.get(i3).logoUrl;
                        fVar3.f391476d = VipGeneralGdtShowView.this.f391428j.dropList.get(i3).jumpUrl;
                        fVar3.f391474b = VipGeneralGdtShowView.this.f391428j.dropList.get(i3).content;
                        aVar.b(fVar3);
                    }
                } else {
                    fVar.f391475c = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
                    fVar.f391473a = 0;
                    fVar.f391474b = HardCodeUtil.qqStr(R.string.vgb);
                    fVar2.f391475c = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
                    fVar2.f391473a = 1;
                    fVar2.f391474b = HardCodeUtil.qqStr(R.string.vgc);
                    fVar2.f391476d = "https://www.qq.com";
                    aVar.b(fVar);
                    aVar.b(fVar2);
                }
                aVar.n();
                aVar.s(new b(aVar));
                cooperation.vip.webview.controller.a.a((Activity) VipGeneralGdtShowView.this.f391419a, view, new a.C10130a(view.getLeft(), view.getTop(), 0, 0, view.getWidth(), view.getHeight()), aVar);
            } else if (VipGeneralGdtShowView.this.f391428j != null) {
                VipGeneralGdtShowView vipGeneralGdtShowView = VipGeneralGdtShowView.this;
                vipGeneralGdtShowView.i(2, vipGeneralGdtShowView.f391428j.recCookie, VipGeneralGdtShowView.this.f391433o + 1);
                VipGeneralGdtShowView.this.f(new WeakReference<>((Activity) VipGeneralGdtShowView.this.f391419a), VipGeneralGdtShowView.this.f391435q);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class b implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final cooperation.vip.widget.a f391441d;

        public b(cooperation.vip.widget.a aVar) {
            this.f391441d = aVar;
        }

        private void a(a.f fVar) {
            if (!TextUtils.isEmpty(fVar.f391476d) && VipGeneralGdtShowView.this.f391419a != null) {
                Intent intent = new Intent(VipGeneralGdtShowView.this.f391419a, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", fVar.f391476d);
                VipGeneralGdtShowView.this.f391419a.startActivity(intent);
            }
        }

        private void b() {
            if (VipGeneralGdtShowView.this.f391428j != null) {
                if (!TextUtils.isEmpty(VipGeneralGdtShowView.this.f391428j.negativeFeedbackUrl)) {
                    VipGeneralGdtShowView.this.j(VipGeneralGdtShowView.this.f391428j.negativeFeedbackUrl.replace("__ACT_TYPE__", "2001"));
                }
                if (VipGeneralGdtShowView.this.f391426h != null) {
                    VipGeneralGdtShowView vipGeneralGdtShowView = VipGeneralGdtShowView.this;
                    vipGeneralGdtShowView.i(3, vipGeneralGdtShowView.f391428j.recCookie, VipGeneralGdtShowView.this.f391433o + 1);
                }
            }
            c cVar = VipGeneralGdtShowView.this.f391432n;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            cooperation.vip.widget.a aVar = this.f391441d;
            if (aVar != null) {
                aVar.dismiss();
                ArrayList<a.f> arrayList = this.f391441d.f391463q;
                if (arrayList != null && i3 < arrayList.size()) {
                    a.f fVar = this.f391441d.f391463q.get(i3);
                    int i16 = fVar.f391473a;
                    if (i16 == 1) {
                        a(fVar);
                    } else if (i16 == 2) {
                        b();
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface c {
        void a();
    }

    public VipGeneralGdtShowView(Context context, int i3, int i16, int i17) {
        this.f391420b = -1;
        this.f391419a = context;
        this.f391420b = i3;
        this.f391434p = i16;
        this.f391425g = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        this.f391435q = i17;
    }

    private void k(AlumBasicData alumBasicData) {
        int i3;
        int i16;
        URLDrawable drawable = URLDrawable.getDrawable(alumBasicData.advimageUrl, (URLDrawable.URLDrawableOptions) null);
        if (drawable != null) {
            this.f391436r = alumBasicData.imageWith;
            this.f391437s = alumBasicData.imageHeight;
            int dpToPx = this.f391419a.getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(56.0f);
            int i17 = this.f391436r;
            if (i17 != 0 && (i16 = this.f391437s) != 0) {
                i3 = (int) ((i16 / (i17 * 1.0d)) * dpToPx);
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                ViewGroup.LayoutParams layoutParams = this.f391421c.getLayoutParams();
                layoutParams.height = i3;
                this.f391421c.setLayoutParams(layoutParams);
                QZLog.i("VipGeneralGdtShowView", " @getGdtInfo height  =" + i3 + "contrlwith =" + dpToPx + "imagewith =" + this.f391436r + "imageheight =" + this.f391437s);
            }
            this.f391421c.setImageDrawable(drawable);
            if (alumBasicData.hasExposed == 0) {
                alumBasicData.hasExposed = 1;
                j(alumBasicData.qqbexposureInfor);
                i(1, alumBasicData.recCookie, 0);
            }
        }
    }

    private void m(AlumBasicData alumBasicData) {
        Drawable drawable = this.f391422d.getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mUseMemoryCache = false;
        URLDrawable drawable2 = URLDrawable.getDrawable(alumBasicData.advLogoUrl, obtain);
        if (this.f391434p == 3 && !SimpleUIUtil.getSimpleUISwitch()) {
            drawable2.setTag(com.tencent.mobileqq.urldrawable.a.d(ViewUtils.dip2px(40.0f), ViewUtils.dip2px(40.0f)));
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306335o);
        } else {
            drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(ViewUtils.dip2px(40.0f), ViewUtils.dip2px(40.0f), ViewUtils.dip2px(3.5f)));
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
        }
        this.f391431m.setImageDrawable(drawable2);
    }

    public void f(WeakReference<Activity> weakReference, int i3) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = i3;
        if (weakReference != null) {
            params.activity = weakReference;
            params.f108486ad = new GdtAd(this.f391428j.adInfo);
            params.reportForClick = true;
            params.appAutoDownload = true;
            Bundle bundle = new Bundle();
            params.extra = bundle;
            if (this.f391434p == 3) {
                bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_kuolie");
            }
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
            QZLog.i("VipGeneralGdtShowView", " @getGdtInfo clickAdvInfoToQiQiaoBan");
        }
    }

    public View g() {
        return this.f391425g;
    }

    public void h(View view, c cVar) {
        if (view == null) {
            return;
        }
        this.f391432n = cVar;
        QZLog.i("VipGeneralGdtShowView", " @getGdtInfo initAdvView");
        this.f391426h = (RelativeLayout) view.findViewById(R.id.csu);
        this.f391421c = (ImageView) view.findViewById(R.id.csx);
        this.f391424f = (TextView) view.findViewById(R.id.csy);
        this.f391422d = (TextView) view.findViewById(R.id.f165351ct0);
        this.f391423e = (TextView) view.findViewById(R.id.csw);
        this.f391429k = (TextView) view.findViewById(R.id.f165352ct1);
        this.f391430l = (TextView) view.findViewById(R.id.f165353ct2);
        this.f391431m = (ImageView) view.findViewById(R.id.csz);
        this.f391426h.setOnClickListener(this.f391438t);
        this.f391424f.setOnClickListener(this.f391438t);
    }

    public void i(int i3, String str, int i16) {
        long j3;
        if (!TextUtils.isEmpty(str)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                j3 = ((QQAppInterface) runtime).getLongAccountUin();
            } else {
                j3 = 0;
            }
            VasAdMetaReportParam.Builder builder = new VasAdMetaReportParam.Builder();
            builder.setAdvPos(Integer.valueOf(this.f391434p));
            builder.setUin(Long.valueOf(j3));
            builder.setActionType(Integer.valueOf(i3));
            builder.setRecommendCookie(str);
            builder.setFeedIndex(Integer.valueOf(i16));
            builder.setActionType(1);
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsync(builder.build());
            return;
        }
        QZLog.i("VipGeneralGdtShowView", " @getGdtInfo sendBusinessReport");
    }

    public void j(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: cooperation.vip.widget.VipGeneralGdtShowView.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.i("VipGeneralGdtShowView", "@getGdtInfo exporsure rspCode " + responseCode + "\uff0c request thirdparty" + z16 + " url =" + str);
                    }
                } catch (Exception e16) {
                    if (QZLog.isColorLevel()) {
                        QZLog.w("VipGeneralGdtShowView", 2, e16.toString());
                    }
                }
            }
        }, 0L);
    }

    public void l(AlumBasicData alumBasicData, int i3) {
        try {
            this.f391428j = alumBasicData;
            this.f391433o = i3 + 1;
            if (alumBasicData != null && !TextUtils.isEmpty(alumBasicData.advimageUrl) && this.f391426h != null && this.f391421c != null && this.f391424f != null && this.f391422d != null && this.f391423e != null) {
                m(alumBasicData);
                k(alumBasicData);
                this.f391429k.setText(alumBasicData.leftBottomText);
                this.f391430l.setText(alumBasicData.rightBottomButton);
                this.f391422d.setText(alumBasicData.advTextTitle);
                this.f391423e.setText(alumBasicData.advTextText);
                this.f391426h.setVisibility(0);
                if (QZLog.isColorLevel()) {
                    QZLog.i("VipGeneralGdtShowView", "setDataChanged titile =" + alumBasicData.advTextTitle + " desc =" + alumBasicData.advTextText + " url =" + alumBasicData.advimageUrl);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout = this.f391426h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            QZLog.i("VipGeneralGdtShowView", " @getGdtInfo setDataChanged is null");
        } catch (Exception e16) {
            QZLog.e("VipGeneralGdtShowView", e16.toString());
        }
    }
}
