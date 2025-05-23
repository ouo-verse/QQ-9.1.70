package com.qzone.proxy.feedcomponent.service;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.reborn.configx.g;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.ui.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n7.a;

/* loaded from: classes39.dex */
public class QzoneCustomPraiseService {

    /* renamed from: m, reason: collision with root package name */
    static final String f50460m = "QzoneCustomPraiseService";

    /* renamed from: n, reason: collision with root package name */
    public static QzoneCustomPraiseService f50461n;

    /* renamed from: o, reason: collision with root package name */
    static final Object f50462o = new Object();

    /* renamed from: a, reason: collision with root package name */
    CustomPraiseData f50463a;

    /* renamed from: b, reason: collision with root package name */
    AnimationDrawable f50464b;

    /* renamed from: c, reason: collision with root package name */
    c f50465c;

    /* renamed from: e, reason: collision with root package name */
    boolean f50467e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<AsyncImageView> f50468f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Activity> f50469g;

    /* renamed from: j, reason: collision with root package name */
    ZipLoadedListener f50472j;

    /* renamed from: k, reason: collision with root package name */
    boolean f50473k;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, CustomPraiseData> f50466d = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final int f50470h = 15;

    /* renamed from: i, reason: collision with root package name */
    final b f50471i = new b("TABLE_CUSTOM_PRAISE", CustomPraiseData.class);

    /* renamed from: l, reason: collision with root package name */
    private AnimationDrawableLoadedListener f50474l = new AnimationDrawableLoadedListener() { // from class: com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService.2
        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onNewLoadSuccess(final c cVar) {
            QzoneCustomPraiseService.this.f50465c = cVar;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService.2.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncImageView asyncImageView;
                    if (QzoneCustomPraiseService.this.f50468f == null || (asyncImageView = (AsyncImageView) QzoneCustomPraiseService.this.f50468f.get()) == null) {
                        return;
                    }
                    asyncImageView.setImageDrawable(cVar.getDrawable());
                }
            });
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            if (animationDrawable != null) {
                QzoneCustomPraiseService.this.f50464b = animationDrawable;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncImageView asyncImageView;
                    if (QzoneCustomPraiseService.this.f50468f == null || (asyncImageView = (AsyncImageView) QzoneCustomPraiseService.this.f50468f.get()) == null) {
                        return;
                    }
                    asyncImageView.setImageDrawable(QzoneCustomPraiseService.this.f50464b);
                    asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    QzoneCustomPraiseService.this.f50464b.setOneShot(false);
                    QzoneCustomPraiseService.this.f50464b.start();
                }
            });
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedFailed() {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ZipLoadedListener {
        a() {
        }

        @Override // cooperation.qzone.zipanimate.ZipLoadedListener
        public void onZipLoaded(boolean z16) {
            QzoneCustomPraiseService.this.f50473k = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f50481a;

        /* renamed from: b, reason: collision with root package name */
        m f50482b;

        /* renamed from: c, reason: collision with root package name */
        String f50483c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f50484d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f50485e = new a();

        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                com.qzone.proxy.feedcomponent.b.a(QzoneCustomPraiseService.f50460m, "DbCacheManager onClosed QzoneCustomPraiseService table:" + b.this.f50483c);
                b bVar = b.this;
                bVar.f50481a = 0L;
                bVar.f50482b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f50483c = str;
            this.f50484d = cls;
        }
    }

    QzoneCustomPraiseService() {
    }

    private void e(AsyncImageView asyncImageView, CustomPraiseData customPraiseData) {
        int dip2px;
        int dip2px2;
        int i3;
        int i16;
        if (TextUtils.isEmpty(customPraiseData.strPraiseZipAfter)) {
            return;
        }
        if (asyncImageView != null) {
            if (asyncImageView.getWidth() == 0) {
                dip2px = ViewUtils.dip2px(23.0f);
                dip2px2 = ViewUtils.dip2px(23.0f);
            } else {
                int width = asyncImageView.getWidth();
                i3 = asyncImageView.getHeight();
                i16 = width;
                QzoneZipAnimateUtil.j(customPraiseData.strPraiseZipAfter, "birthday_praise", customPraiseData.strPraiseZipAfter.hashCode() + "", i16, i3, 8, this.f50474l);
            }
        } else {
            dip2px = ViewUtils.dip2px(23.0f);
            dip2px2 = ViewUtils.dip2px(23.0f);
        }
        i16 = dip2px;
        i3 = dip2px2;
        QzoneZipAnimateUtil.j(customPraiseData.strPraiseZipAfter, "birthday_praise", customPraiseData.strPraiseZipAfter.hashCode() + "", i16, i3, 8, this.f50474l);
    }

    public static QzoneCustomPraiseService i() {
        if (f50461n == null) {
            synchronized (f50462o) {
                if (f50461n == null) {
                    f50461n = new QzoneCustomPraiseService();
                }
            }
        }
        return f50461n;
    }

    public void b(Activity activity, AsyncImageView asyncImageView, CustomPraiseData customPraiseData) {
        this.f50469g = new WeakReference<>(activity);
        this.f50468f = new WeakReference<>(asyncImageView);
        if (QzoneZipAnimateUtil.f60590a) {
            c cVar = this.f50465c;
            if (cVar != null && asyncImageView != null) {
                cVar.getDrawable().setBounds(0, 0, asyncImageView.getHeight(), asyncImageView.getHeight());
                asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                asyncImageView.setImageDrawable(this.f50465c.getDrawable());
                return;
            }
            e(asyncImageView, customPraiseData);
            return;
        }
        AnimationDrawable animationDrawable = this.f50464b;
        if (animationDrawable != null && asyncImageView != null) {
            AnimationDrawable animationDrawable2 = (AnimationDrawable) animationDrawable.getConstantState().newDrawable();
            this.f50464b = animationDrawable2;
            animationDrawable2.setBounds(0, 0, asyncImageView.getWidth(), asyncImageView.getHeight());
            asyncImageView.setImageDrawable(this.f50464b);
            asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f50464b.setOneShot(false);
            this.f50464b.start();
            return;
        }
        e(asyncImageView, customPraiseData);
    }

    public void c(ArrayList<BusinessFeedData> arrayList) {
        CustomPraiseData createFrom;
        try {
            int S = i.H().S("QZoneSetting", "batchPreloadCmRes", 1);
            if (arrayList != null && arrayList.size() != 0 && S != 0) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Iterator<BusinessFeedData> it = arrayList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    BusinessFeedData next = it.next();
                    if (next.getUser().customPraiseData != null && next.getUser().customPraiseData.itemId != -1) {
                        createFrom = next.getUser().customPraiseData;
                    } else {
                        if (next.getCellDecorateInfo() != null && next.getCellDecorateInfo().cellCustomPraise != null) {
                            createFrom = CustomPraiseData.createFrom(next.getCellDecorateInfo().cellCustomPraise);
                        }
                        return;
                    }
                    if (createFrom != null && createFrom.cmShowActionId != 0 && i3 < 15) {
                        if (!arrayList2.contains(next.getUser().uin + "")) {
                            arrayList2.add(next.getUser().uin + "");
                            i3++;
                        }
                        if (!arrayList3.contains(Integer.valueOf(this.f50463a.cmShowActionId))) {
                            arrayList3.add(Integer.valueOf(this.f50463a.cmShowActionId));
                        }
                    }
                    if (next.getUser().cmPraiseActionid != 0 && i3 < 15) {
                        if (!arrayList2.contains(next.getUser().uin + "")) {
                            arrayList2.add(next.getUser().uin + "");
                            i3++;
                        }
                        if (!arrayList3.contains(Integer.valueOf(next.getUser().cmPraiseActionid))) {
                            arrayList3.add(Integer.valueOf(next.getUser().cmPraiseActionid));
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    com.qzone.homepage.ui.component.a.i(arrayList2);
                    com.qzone.proxy.feedcomponent.b.a(f50460m, "@cmPraise batchPreloadCmPraise feeds preLoadRes uins size" + arrayList2.size());
                }
                if (arrayList3.size() > 0) {
                    int[] iArr = new int[arrayList3.size()];
                    for (int i16 = 0; i16 < arrayList3.size(); i16++) {
                        iArr[i16] = ((Integer) arrayList3.get(i16)).intValue();
                    }
                    com.qzone.homepage.ui.component.a.h(arrayList2, iArr);
                    com.qzone.proxy.feedcomponent.b.a(f50460m, "@cmPraise batchPreloadCmPraise feeds preLoadRes actioid size" + arrayList3.size());
                }
            }
        } catch (Exception unused) {
        }
    }

    public m f(long j3) {
        j(j3);
        return this.f50471i.f50482b;
    }

    public CustomPraiseData g() {
        CustomPraiseData customPraiseData = this.f50463a;
        if (customPraiseData == null || customPraiseData.itemId <= 0) {
            return null;
        }
        if (!this.f50473k) {
            l();
        }
        if (this.f50473k) {
            return this.f50463a;
        }
        return null;
    }

    public CustomPraiseData h(String str) {
        return this.f50466d.get(str);
    }

    void j(long j3) {
        b bVar = this.f50471i;
        if (bVar.f50481a != j3) {
            synchronized (bVar) {
                b bVar2 = this.f50471i;
                if (bVar2.f50481a != j3) {
                    d(bVar2);
                }
            }
        }
    }

    public void k(CustomPraiseData customPraiseData) {
        e.b("CustomPraise", this, 1, customPraiseData);
    }

    public void l() {
        CustomPraiseData customPraiseData = this.f50463a;
        if (customPraiseData == null || customPraiseData.itemId <= 0) {
            return;
        }
        this.f50473k = false;
        if (g.f53821a.b().x0() && ImageManagerEnv.getAppContext() == null) {
            ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
        }
        if (this.f50463a.cmShowActionId != 0) {
            com.qzone.proxy.feedcomponent.b.a(f50460m, "@cmPraise preLoadRes cmactionid" + this.f50463a.cmShowActionId);
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(i.H().j0()));
            com.qzone.homepage.ui.component.a.h(arrayList, new int[1]);
            this.f50473k = true;
        }
        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
        if (this.f50472j == null) {
            this.f50472j = new a();
        }
        zipDrawableLoader.setZipLoadedListener(this.f50472j);
        zipDrawableLoader.setDrawableData(this.f50463a.praiseZipUrl, -1, false);
        ImageLoader imageLoader = ImageLoader.getInstance();
        CustomPraiseData customPraiseData2 = this.f50463a;
        imageLoader.loadImage(customPraiseData2.praiseIconImageUrl, customPraiseData2.praiseIconUrl, (ImageLoader.Options) null);
        ImageLoader imageLoader2 = ImageLoader.getInstance();
        CustomPraiseData customPraiseData3 = this.f50463a;
        imageLoader2.loadImage(customPraiseData3.strPraiseListImageUrl, customPraiseData3.strPraiseListPic, (ImageLoader.Options) null);
    }

    public void o(final long j3) {
        CustomPraiseData customPraiseData = this.f50463a;
        if (customPraiseData != null && j3 == customPraiseData.uin && this.f50467e) {
            return;
        }
        this.f50467e = false;
        FeedGlobalEnv.g().getBackgroundHandler().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService.3
            @Override // java.lang.Runnable
            public void run() {
                m f16 = QzoneCustomPraiseService.this.f(j3);
                if (f16 == null) {
                    return;
                }
                f16.l("uin=?");
                f16.i(new String[]{"" + j3});
                CustomPraiseData customPraiseData2 = (CustomPraiseData) f16.k("uin=?", new String[]{"" + j3});
                if (customPraiseData2 != null && j3 == customPraiseData2.uin) {
                    QzoneCustomPraiseService qzoneCustomPraiseService = QzoneCustomPraiseService.this;
                    if (!qzoneCustomPraiseService.f50467e) {
                        qzoneCustomPraiseService.f50463a = customPraiseData2;
                        qzoneCustomPraiseService.l();
                        QzoneCustomPraiseService.this.k(customPraiseData2);
                    }
                }
                QzoneCustomPraiseService.this.f50467e = true;
            }
        });
    }

    public void m(CustomPraiseData customPraiseData) {
        n(customPraiseData, true);
    }

    public void p(CustomPraiseData customPraiseData) {
        q(customPraiseData, false);
    }

    public void n(CustomPraiseData customPraiseData, boolean z16) {
        if (customPraiseData == null || customPraiseData.itemId <= 0) {
            return;
        }
        if (z16 && customPraiseData.cmShowActionId != 0) {
            com.qzone.proxy.feedcomponent.b.a(f50460m, "@cmPraise preLoadRes cmactionid" + customPraiseData.cmShowActionId);
            com.qzone.homepage.ui.component.a.h(new ArrayList(), new int[]{customPraiseData.cmShowActionId});
        }
        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
        zipDrawableLoader.setZipLoadedListener(this.f50472j);
        zipDrawableLoader.setDrawableData(customPraiseData.praiseZipUrl, -1, false);
        if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            if (TextUtils.isEmpty(customPraiseData.praiseIconUrl)) {
                return;
            }
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(customPraiseData.praiseIconUrl));
        } else {
            ImageLoader.getInstance().loadImage(customPraiseData.praiseIconImageUrl, customPraiseData.praiseIconUrl, (ImageLoader.Options) null);
            ImageLoader.getInstance().loadImage(customPraiseData.strPraiseListImageUrl, customPraiseData.strPraiseListPic, (ImageLoader.Options) null);
        }
    }

    void d(b bVar) {
        m mVar;
        if (bVar == null) {
            return;
        }
        long j06 = i.H().j0();
        if (j06 != bVar.f50481a || (mVar = bVar.f50482b) == null || mVar.isClosed()) {
            bVar.f50481a = j06;
            m y16 = i.H().y1(bVar.f50484d, j06, bVar.f50483c);
            bVar.f50482b = y16;
            y16.d(bVar.f50485e);
        }
    }

    public void q(CustomPraiseData customPraiseData, boolean z16) {
        if (customPraiseData == null) {
            return;
        }
        if (customPraiseData.uin != i.H().j0()) {
            com.qzone.proxy.feedcomponent.b.a(f50460m, "uin not the login uin, no update.");
            return;
        }
        CustomPraiseData customPraiseData2 = this.f50463a;
        if (customPraiseData2 == null || !customPraiseData2.equals(customPraiseData)) {
            this.f50463a = customPraiseData;
            this.f50467e = true;
            l();
            long j06 = i.H().j0();
            m f16 = f(j06);
            if (f16 != null) {
                if (customPraiseData.itemId <= 0) {
                    f16.o("uin=" + j06);
                    com.qzone.proxy.feedcomponent.b.a(f50460m, "updateCustomPraiseCache deleteData");
                    return;
                }
                f16.appendData(customPraiseData);
                com.qzone.proxy.feedcomponent.b.a(f50460m, "updateCustomPraiseCache saveData");
            }
        }
    }
}
