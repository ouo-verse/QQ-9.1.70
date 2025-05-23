package com.qzone.reborn.feedx.widget.header;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.widget.AsyncImageView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidget;
import com.tencent.biz.videostory.entrancewidget.b;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import eo.c;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ab extends RecyclerView.Adapter<a> {
    private static final Map<String, String> E;
    private a C;
    private Activity D;

    /* renamed from: m, reason: collision with root package name */
    private List<q5.c> f56157m;

    static {
        Map<String, String> a16;
        a16 = aa.a(new Map.Entry[]{new AbstractMap.SimpleEntry("\u7167\u7247", "em_qz_picture"), new AbstractMap.SimpleEntry("\u89c6\u9891", "em_qz_video"), new AbstractMap.SimpleEntry("\u5199\u8bf4\u8bf4", "em_qz_write_talk")});
        E = a16;
    }

    public ab(Activity activity) {
        this.D = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<q5.c> list = this.f56157m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return super.getItemId(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return super.getItemViewType(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        int i16;
        q5.c cVar = this.f56157m.get(i3);
        aVar.A(cVar);
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            if (getNUM_BACKGOURND_ICON() > 0 && getNUM_BACKGOURND_ICON() <= 4) {
                layoutParams.width = FeedGlobalEnv.g().getScreenWidth() / getNUM_BACKGOURND_ICON();
            } else if (getNUM_BACKGOURND_ICON() > 4) {
                layoutParams.width = (int) (FeedGlobalEnv.g().getScreenWidth() / 4.5d);
            } else if (getNUM_BACKGOURND_ICON() <= 0) {
                QZLog.e("QZoneMoodListHeaderShortcutElement", "onBindViewHolder wtf getItemCount()<=0");
            }
        }
        aVar.itemView.requestLayout();
        if (cVar == null || cVar.f428376f || (i16 = cVar.f428375e) <= 0) {
            return;
        }
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, i16, 1);
        cVar.f428376f = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate;
        if (Long.parseLong(LoginData.getInstance().getUinString()) < QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_MOODLIST_ENTRANCE_GRAY, 0)) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f169020bn2, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f169021bn3, viewGroup, false);
        }
        return new a(inflate);
    }

    public void o0() {
        if (this.C != null) {
            if (com.tencent.biz.videostory.entrancewidget.b.c().l()) {
                this.C.x(true);
                this.C.t();
            } else {
                this.C.x(false);
            }
        }
    }

    public void p0(List<q5.c> list) {
        this.f56157m = list;
        notifyDataSetChanged();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends RecyclerView.ViewHolder {
        AsyncImageView E;
        TextView F;
        ViewStub G;
        FrameLayout H;
        VSEntranceWidget I;
        q5.c J;
        WeakReference<AsyncImageView> K;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.qzone.reborn.feedx.widget.header.ab$a$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        public class C0472a extends HdAsyncAction {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f56158a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ WeakReference f56159b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f56160c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.qzone.reborn.feedx.widget.header.ab$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes37.dex */
            public class C0473a extends URLDrawableHandler.Adapter {
                C0473a() {
                }

                @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                public void onFileDownloadFailed(int i3) {
                    ToastUtil.a().e(com.qzone.util.l.a(R.string.f172546s05));
                    C0472a c0472a = C0472a.this;
                    a.this.w(c0472a.f56159b, c0472a.f56160c);
                }

                @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                public void onFileDownloadSucceed(long j3) {
                    QZLog.i("QZoneMoodListHeaderShortcutElement", 2, "SoLoadCallback onApngSoLoad");
                    C0472a c0472a = C0472a.this;
                    a.this.v(c0472a.f56159b, c0472a.f56158a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0472a(Looper looper, String str, WeakReference weakReference, String str2) {
                super(looper);
                this.f56158a = str;
                this.f56159b = weakReference;
                this.f56160c = str2;
            }

            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                try {
                    if (!ApngDrawable.isApngFile(new File(this.f56158a))) {
                        QZLog.w("QZoneMoodListHeaderShortcutElement", 2, this.f56160c, "is not apng, use normal apng ");
                        a.this.w(this.f56159b, this.f56160c);
                    } else {
                        com.tencent.mobileqq.vas.an.h().l(new C0473a(), true);
                    }
                } catch (IOException e16) {
                    a.this.w(this.f56159b, this.f56160c);
                    QZLog.e("QZoneMoodListHeaderShortcutElement", 2, this.f56160c, "is not apng, use normal apng", e16);
                }
                return doNext(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class b extends HdAsyncAction {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeakReference f56163a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Looper looper, WeakReference weakReference) {
                super(looper);
                this.f56163a = weakReference;
            }

            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                ApngDrawable apngDrawable = (ApngDrawable) obj;
                ImageView imageView = (ImageView) this.f56163a.get();
                if (imageView != null) {
                    imageView.setImageDrawable(apngDrawable);
                    ApngImage.playByTag(24);
                }
                return doNext(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class c extends HdAsyncAction {
            c(Looper looper) {
                super(looper);
            }

            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                ApngDrawable r16 = a.this.r(new File((String) obj));
                return doNext(r16 != null, r16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class d implements Downloader.DownloadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f56166a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f56167b;

            d(String str, String str2) {
                this.f56166a = str;
                this.f56167b = str2;
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                a.this.K = new WeakReference<>(a.this.E);
                a aVar = a.this;
                aVar.u(this.f56166a, aVar.K, this.f56167b);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str) {
                QZLog.e("QZoneMoodListHeaderShortcutElement", 1, "download ", str, " onDownloadCanceled");
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str, DownloadResult downloadResult) {
                QZLog.e("QZoneMoodListHeaderShortcutElement", 1, "download ", str, " onDownloadFailed");
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str, long j3, float f16) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class e implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ q5.c f56169d;

            e(q5.c cVar) {
                this.f56169d = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                eo.c.f396879a.b();
                a.this.z(this.f56169d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(View view) {
            super(view);
            this.K = null;
            this.E = (AsyncImageView) view.findViewById(R.id.ezo);
            this.F = (TextView) view.findViewById(R.id.ezp);
            this.G = (ViewStub) view.findViewById(R.id.f167125l31);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ApngDrawable r(File file) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_use_rect", true);
                bundle.putBoolean("key_double_bitmap", true);
                bundle.putIntArray("key_tagId_arr", new int[]{24});
                return new ApngDrawable(new ApngImage(file, true, bundle), ab.this.D.getResources());
            } catch (Throwable th5) {
                QZLog.e("QZoneMoodListHeaderShortcutElement", "createApngDrawable failed", th5);
                return null;
            }
        }

        private void s() {
            if (this.J == null) {
                return;
            }
            fo.b bVar = new fo.b();
            bVar.j(EndExposurePolicy.REPORT_NONE);
            bVar.k(ExposurePolicy.REPORT_NONE);
            bVar.h(new c.a());
            bVar.i(this.J.toString());
            fo.c.o(this.itemView, (String) ab.E.get(this.J.f428372b), bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(String str, WeakReference<AsyncImageView> weakReference, String str2) {
            HdAsync.with(this).then(new C0472a(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.RealTimeThread), str, weakReference, str2)).call();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(WeakReference<AsyncImageView> weakReference, String str) {
            HdAsync.with(this).then(new c(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread))).then(new b(Looper.getMainLooper(), weakReference)).call(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(WeakReference<AsyncImageView> weakReference, String str) {
            AsyncImageView asyncImageView = weakReference.get();
            if (asyncImageView != null) {
                asyncImageView.setAsyncImage(str);
            }
        }

        private void y(AsyncImageView asyncImageView) {
            asyncImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) asyncImageView.getLayoutParams();
            layoutParams.width = com.qzone.util.ar.e(28.0f);
            layoutParams.height = com.qzone.util.ar.e(28.0f);
            asyncImageView.setLayoutParams(layoutParams);
            if ("{\"moodList\":\"choosePicture\"}".equals(this.J.f428371a)) {
                rn.h.a(asyncImageView, "qui_image", R.color.qui_common_icon_primary);
                return;
            }
            if ("{\"moodList\":\"takeVideo\"}".equals(this.J.f428371a)) {
                rn.h.a(asyncImageView, "qui_video_on", R.color.qui_common_icon_primary);
                return;
            }
            if ("{\"moodList\":\"chooseGif\"}".equals(this.J.f428371a)) {
                rn.h.a(asyncImageView, "qui_video_on", R.color.qui_common_icon_primary);
                return;
            }
            if (this.J.f428371a.startsWith("mqqapi://videostory/takevideo")) {
                rn.h.a(asyncImageView, "qui_video_on", R.color.qui_common_icon_primary);
            } else if ("mqzone://arouse/writemood".equals(this.J.f428371a)) {
                rn.h.a(asyncImageView, "qui_shuoshuo", R.color.qui_common_icon_primary);
            } else {
                rn.h.a(asyncImageView, "qui_qiandao", R.color.qui_common_icon_primary);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(q5.c cVar) {
            if (com.qzone.reborn.util.e.b("QZoneMoodListHeaderShortcutElement_startVideoStory", 500L)) {
                return;
            }
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppScheme(cVar.f428371a)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(ab.this.D, cVar.f428371a, 2060, null);
            } else if (cVar.f428371a.startsWith("mqqapi://videostory/takevideo")) {
                b.d d16 = com.tencent.biz.videostory.entrancewidget.b.c().d(LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO);
                String str = cVar.f428371a;
                if (VSConfigManager.c().h() && d16 != null) {
                    String str2 = d16.f97118b;
                    if (!TextUtils.isEmpty(str2)) {
                        str = str.replace("&widgetid=", "&widgetid=" + str2);
                        VSConfigManager.c().i();
                    }
                }
                yo.d.d(str, ab.this.D, null);
            } else {
                yo.d.d(cVar.f428371a, ab.this.D, null);
            }
            int i3 = cVar.f428375e;
            if (i3 > 0) {
                LpReportInfo_pf00064.allReport(q5.c.f428370i, i3, 2);
            }
            if (com.qzone.publish.utils.b.f52149c && cVar.f428377g == 1 && !com.qzone.util.am.h(cVar.f428378h)) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(cVar.f428378h, LoginData.getInstance().getUinString());
                com.qzone.publish.utils.b.f52149c = false;
            }
        }

        public void q() {
            WeakReference<AsyncImageView> weakReference = this.K;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        public void t() {
            if (this.H == null) {
                this.G.setLayoutResource(R.layout.cdy);
                this.H = (FrameLayout) this.G.inflate();
                this.I = new VSEntranceWidget();
            }
            this.I.f(this.H, this.E, LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO);
            this.I.k();
        }

        public void x(boolean z16) {
            FrameLayout frameLayout = this.H;
            if (frameLayout != null) {
                frameLayout.setVisibility(z16 ? 0 : 8);
            }
        }

        public void A(q5.c cVar) {
            if (cVar == null) {
                return;
            }
            this.J = cVar;
            this.F.setText(cVar.f428372b);
            String str = cVar.f428373c;
            String moodListIconDir = CacheManager.getMoodListIconDir();
            String md5 = MD5Utils.toMD5(str);
            if (cVar.f428374d.equals("apng")) {
                String absolutePath = new File(moodListIconDir, md5).getAbsolutePath();
                FileDownloaderManager.g().download(str, absolutePath, new d(absolutePath, str));
            } else {
                y(this.E);
            }
            if ("{\"moodList\":\"choosePicture\"}".equals(cVar.f428371a)) {
                this.itemView.setOnClickListener(com.qzone.publish.utils.b.g(ab.this.D, cVar));
            } else if ("{\"moodList\":\"takeVideo\"}".equals(cVar.f428371a)) {
                this.itemView.setOnClickListener(com.qzone.publish.utils.b.k(ab.this.D, cVar));
            } else if ("{\"moodList\":\"chooseGif\"}".equals(cVar.f428371a)) {
                this.itemView.setOnClickListener(com.qzone.publish.utils.b.l(ab.this.D, cVar));
            } else {
                if (cVar.f428371a.startsWith("mqqapi://videostory/takevideo")) {
                    ab.this.C = this;
                    if (com.tencent.biz.videostory.entrancewidget.b.c().l()) {
                        ab.this.C.x(true);
                        ab.this.C.t();
                    } else {
                        ab.this.C.x(false);
                    }
                }
                this.itemView.setOnClickListener(new e(cVar));
            }
            s();
        }
    }
}
