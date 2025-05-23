package cooperation.vip.manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FileBannerTianshuManger {

    /* renamed from: l, reason: collision with root package name */
    public static int f391249l = 488;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f391253d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f391254e;

    /* renamed from: f, reason: collision with root package name */
    protected View f391255f;

    /* renamed from: g, reason: collision with root package name */
    protected URLImageView f391256g;

    /* renamed from: h, reason: collision with root package name */
    protected RelativeLayout f391257h;

    /* renamed from: i, reason: collision with root package name */
    protected View f391258i;

    /* renamed from: j, reason: collision with root package name */
    public int f391259j;

    /* renamed from: a, reason: collision with root package name */
    public String f391250a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f391251b = "";

    /* renamed from: c, reason: collision with root package name */
    public TianShuAccess.AdItem f391252c = null;

    /* renamed from: k, reason: collision with root package name */
    TianShuGetAdvCallback f391260k = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements TianShuGetAdvCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            FileBannerTianshuManger.this.j(z16, getAdsRsp);
        }
    }

    public FileBannerTianshuManger(Activity activity, View view, int i3) {
        this.f391259j = 0;
        this.f391253d = new WeakReference<>(activity);
        this.f391258i = view;
        this.f391259j = i3;
    }

    public void c(String str) {
        WeakReference<Activity> weakReference;
        if (!TextUtils.isEmpty(str) && (weakReference = this.f391253d) != null && weakReference.get() != null) {
            try {
                Activity activity = this.f391253d.get();
                if (activity instanceof BasePluginActivity) {
                    activity = ((BasePluginActivity) activity).getOutActivity();
                }
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                    intent.setData(Uri.parse(str));
                    activity.startActivity(intent);
                    g(this.f391252c, 102);
                    if (this.f391259j == 1) {
                        g(this.f391252c, 138);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str);
                intent2.putExtra("big_brother_source_key", "biz_src_jc_vip");
                activity.startActivity(intent2);
                g(this.f391252c, 102);
                if (this.f391259j == 1) {
                    g(this.f391252c, 138);
                }
            } catch (Exception e16) {
                QZLog.e("FileBannerTianshuManger", e16.toString());
            }
        }
    }

    public void d() {
        if (!TextUtils.isEmpty(this.f391251b)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable drawable = URLDrawable.getDrawable(this.f391251b, obtain);
                Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable2;
                obtain.mFailedDrawable = drawable2;
                obtain.mRequestWidth = f();
                obtain.mRequestHeight = e();
                if (drawable.getStatus() == 1) {
                    QZLog.i("FileBannerTianshuManger", "showFileBanner URLDrawable success ");
                    i(this.f391250a, drawable);
                    g(this.f391252c, 101);
                    if (this.f391259j == 1) {
                        g(this.f391252c, 137);
                    }
                } else {
                    drawable.setURLDrawableListener(new b());
                    drawable.startDownload();
                }
                return;
            } catch (Exception unused) {
                QZLog.e("FileBannerTianshuManger", "onGetAdvs pic erro");
                return;
            }
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("FileBannerTianshuManger", "onGetAdvs pic url is null");
        }
    }

    public int e() {
        return (int) (f() * 0.14492753f);
    }

    public int f() {
        return ViewUtils.getScreenWidth();
    }

    public void g(TianShuAccess.AdItem adItem, int i3) {
        if (adItem == null) {
            QZLog.e("FileBannerTianshuManger", "item is  null");
            return;
        }
        int i16 = adItem.iAdId.get();
        String str = adItem.traceinfo.get();
        if (TextUtils.isEmpty(str)) {
            QZLog.e("FileBannerTianshuManger", "rtraceInfo is  null");
            return;
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.99";
        tianShuReportData.mPageId = "tianshu.99";
        tianShuReportData.mItemId = i16 + "";
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = str;
        TianShuManager.getInstance().report(tianShuReportData);
        QZLog.i("FileBannerTianshuManger", "report appid" + i16 + "actionid" + i3);
    }

    public void h() {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.manager.FileBannerTianshuManger.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZLog.isColorLevel()) {
                    QZLog.i("FileBannerTianshuManger", "getTianShuAd");
                }
                ArrayList arrayList = new ArrayList();
                TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
                tianShuAdPosItemData.mPosId = FileBannerTianshuManger.f391249l;
                tianShuAdPosItemData.mNeedCnt = 1;
                arrayList.add(tianShuAdPosItemData);
                TianShuManager.getInstance().requestAdv(arrayList, FileBannerTianshuManger.this.f391260k);
            }
        }, 16, null, true);
    }

    public void i(final String str, final URLDrawable uRLDrawable) {
        try {
            WeakReference<Activity> weakReference = this.f391253d;
            if (weakReference != null && weakReference.get() != null) {
                this.f391253d.get().runOnUiThread(new Runnable() { // from class: cooperation.vip.manager.FileBannerTianshuManger.4

                    /* compiled from: P */
                    /* renamed from: cooperation.vip.manager.FileBannerTianshuManger$4$a */
                    /* loaded from: classes28.dex */
                    class a implements View.OnClickListener {
                        a() {
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FileBannerTianshuManger.this.c(str);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: cooperation.vip.manager.FileBannerTianshuManger$4$b */
                    /* loaded from: classes28.dex */
                    class b implements View.OnClickListener {
                        b() {
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            FileBannerTianshuManger.this.f391257h.setVisibility(8);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (uRLDrawable != null) {
                            FileBannerTianshuManger fileBannerTianshuManger = FileBannerTianshuManger.this;
                            if (fileBannerTianshuManger.f391253d != null) {
                                try {
                                    fileBannerTianshuManger.f391254e = (ViewStub) fileBannerTianshuManger.f391258i.findViewById(R.id.t46);
                                    if (FileBannerTianshuManger.this.f391254e == null) {
                                        QZLog.e("FileBannerTianshuManger", "mFileAssistantBannerViewStub  is null ");
                                        return;
                                    }
                                    FileBannerTianshuManger.this.f391254e.inflate();
                                    FileBannerTianshuManger fileBannerTianshuManger2 = FileBannerTianshuManger.this;
                                    fileBannerTianshuManger2.f391256g = (URLImageView) fileBannerTianshuManger2.f391258i.findViewById(R.id.f164578t45);
                                    FileBannerTianshuManger fileBannerTianshuManger3 = FileBannerTianshuManger.this;
                                    fileBannerTianshuManger3.f391257h = (RelativeLayout) fileBannerTianshuManger3.f391258i.findViewById(R.id.f164577t44);
                                    FileBannerTianshuManger fileBannerTianshuManger4 = FileBannerTianshuManger.this;
                                    fileBannerTianshuManger4.f391255f = fileBannerTianshuManger4.f391258i.findViewById(R.id.f164576t43);
                                    ViewGroup.LayoutParams layoutParams = FileBannerTianshuManger.this.f391256g.getLayoutParams();
                                    layoutParams.width = FileBannerTianshuManger.this.f();
                                    layoutParams.height = FileBannerTianshuManger.this.e();
                                    FileBannerTianshuManger.this.f391256g.setLayoutParams(layoutParams);
                                    FileBannerTianshuManger.this.f391256g.setImageDrawable(uRLDrawable);
                                    ViewGroup.LayoutParams layoutParams2 = FileBannerTianshuManger.this.f391257h.getLayoutParams();
                                    layoutParams2.width = layoutParams.width;
                                    layoutParams2.height = layoutParams.height;
                                    FileBannerTianshuManger.this.f391257h.setLayoutParams(layoutParams2);
                                    FileBannerTianshuManger.this.f391257h.setVisibility(0);
                                    QZLog.i("FileBannerTianshuManger", "showFileBanner setvisble ");
                                    FileBannerTianshuManger.this.f391256g.setOnClickListener(new a());
                                    FileBannerTianshuManger.this.f391255f.setOnClickListener(new b());
                                } catch (Exception e16) {
                                    QZLog.e("FileBannerTianshuManger", e16.toString());
                                }
                            }
                        }
                    }
                });
                return;
            }
            QZLog.i("FileBannerTianshuManger", "showFileBanner activity is null ");
        } catch (Exception e16) {
            QZLog.e("FileBannerTianshuManger", e16.toString());
        }
    }

    public void j(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        if (QZLog.isColorLevel()) {
            QZLog.i("FileBannerTianshuManger", "onGetAdvs isSucc:" + z16);
        }
        if (z16 && getAdsRsp != null) {
            if (getAdsRsp.mapAds.has()) {
                list = getAdsRsp.mapAds.get();
            } else {
                list = null;
            }
            if (list == null) {
                QZLog.e("FileBannerTianshuManger", "rspEntries == null");
                return;
            }
            HashMap hashMap = new HashMap();
            for (TianShuAccess.RspEntry rspEntry : list) {
                if (rspEntry != null && rspEntry.key.has()) {
                    hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
                }
            }
            TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(f391249l));
            if (rspEntry2 != null && (adPlacementInfo = rspEntry2.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry2.value.lst.get(0) != null && rspEntry2.value.lst.get(0).argList != null && rspEntry2.value.lst.get(0).argList.get() != null) {
                List<TianShuAccess.MapEntry> list2 = rspEntry2.value.lst.get(0).argList.get();
                HashMap hashMap2 = new HashMap();
                for (TianShuAccess.MapEntry mapEntry : list2) {
                    String str = mapEntry.key.get();
                    String str2 = mapEntry.value.get();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        hashMap2.put(str, str2);
                    }
                }
                TianShuAccess.AdItem adItem = rspEntry2.value.lst.get(0);
                this.f391251b = (String) hashMap2.get("pic");
                this.f391250a = (String) hashMap2.get("url");
                this.f391252c = adItem;
                d();
                return;
            }
            QZLog.e("FileBannerTianshuManger", "data is error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QZLog.i("FileBannerTianshuManger", "onLoadSuccessed picUrlDrawable ");
            FileBannerTianshuManger fileBannerTianshuManger = FileBannerTianshuManger.this;
            fileBannerTianshuManger.i(fileBannerTianshuManger.f391250a, uRLDrawable);
            FileBannerTianshuManger fileBannerTianshuManger2 = FileBannerTianshuManger.this;
            fileBannerTianshuManger2.g(fileBannerTianshuManger2.f391252c, 101);
            FileBannerTianshuManger fileBannerTianshuManger3 = FileBannerTianshuManger.this;
            if (fileBannerTianshuManger3.f391259j == 1) {
                fileBannerTianshuManger3.g(fileBannerTianshuManger3.f391252c, 137);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
