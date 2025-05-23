package com.qzone.publish.ui.publishmodule;

import NS_MOBILE_OPERATION.ImageSummary;
import NS_MOBILE_OPERATION.ImageSummaryList;
import NS_MOBILE_OPERATION.PicInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.business.protocol.QZoneGetPublishMoodEggShellRequest;
import com.qzone.publish.business.protocol.QZoneReportMoodEggOprationRequest;
import com.qzone.widget.AsynAutoGifImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AnimateUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends com.qzone.publish.ui.publishmodule.b implements View.OnClickListener, IQZoneServiceListener {
    private static final String L = "a";
    private String C;
    private TextView D;
    private AlphaAnimation E;
    public HashMap<String, ImageSummaryList> G;
    public String H;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f51985h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f51986i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f51987m;
    private boolean F = false;
    private boolean I = false;
    private boolean J = true;
    private boolean K = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.publish.ui.publishmodule.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0443a extends AnimateUtils.AnimationAdapter {
        C0443a() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f51985h != null) {
                a.this.z();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ImageSummary imageSummary = (ImageSummary) view.getTag();
            if (imageSummary != null) {
                a.this.K = true;
                PicInfo picInfo = new PicInfo();
                picInfo.imageId = imageSummary.imageId;
                picInfo.pic_url = imageSummary.url;
                picInfo.sourceType = 1;
                a.this.e().f51486u2.put(picInfo.pic_url, picInfo);
                a.this.b().fi(imageSummary.url);
                a.this.b().Pk();
                a.this.z();
                a.this.I = false;
                ClickReport.c(i.CTRL_INDEX, 50, "2", true, new String[0]);
                if (a.this.b().T != null) {
                    a.this.b().T.notifyDataSetChanged();
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d(a.L, 2, "click egg:", imageSummary.url, ",entryid:", "2", ",source_id:", String.valueOf(imageSummary.source_id));
                }
                a.this.e().f51446b6.put(imageSummary.url, new Pair<>("2", String.valueOf(imageSummary.source_id)));
                a.this.K(2);
                ((com.qzone.publish.ui.publishmodule.d) a.this.d(com.qzone.publish.ui.publishmodule.d.class)).H(false, a.this.b().P, a.this.b().T, null, a.this.b().getActivity());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements AsynAutoGifImageView.a {
        c() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    private void B() {
        this.f51985h.setVisibility(8);
        ClickReport.q(String.valueOf(i.CTRL_INDEX), String.valueOf(50), "3", true);
        yo.d.l(b().getActivity(), QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_WHISPER_EGG, "https://h5.qzone.qq.com/mood/whisper?_wv=2097155&_proxy=1&txt={word}&qua={qua}").replace("{word}", Uri.encode(this.C).replace("{qua}", QUA.getQUA3())), 200, null);
        b().Rl("3");
    }

    private boolean H() {
        return (e().f45084c1 || e().f45090e1 || !this.J || ((com.qzone.publish.ui.publishmodule.d) d(com.qzone.publish.ui.publishmodule.d.class)).D()) ? false : true;
    }

    private void J(String str) {
        ImageSummaryList imageSummaryList = this.G.get(str);
        this.C = str;
        this.f51987m.removeAllViews();
        int dimensionPixelSize = f().getDimensionPixelSize(R.dimen.avs);
        int dimensionPixelSize2 = f().getDimensionPixelSize(R.dimen.avr);
        if (dimensionPixelSize2 == 0) {
            dimensionPixelSize2 = u5.a.f438266d * 4;
        }
        int i3 = 0;
        while (i3 < imageSummaryList.vecImageSummary.size()) {
            this.f51987m.addView(y(imageSummaryList.vecImageSummary.get(i3), dimensionPixelSize, i3 != 0 ? dimensionPixelSize2 : 0));
            i3++;
        }
        ClickReport.c(i.CTRL_INDEX, 50, "1", true, new String[0]);
    }

    private void O() {
        if (this.f51987m == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f51987m.getChildCount(); i3++) {
            ViewGroup viewGroup = (ViewGroup) this.f51987m.getChildAt(i3);
            if (viewGroup != null && viewGroup.getChildCount() != 0 && (viewGroup.getChildAt(0) instanceof AsynAutoGifImageView)) {
                ((AsynAutoGifImageView) viewGroup.getChildAt(0)).h();
            }
        }
    }

    private void x() {
        if (this.f51987m == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f51987m.getChildCount(); i3++) {
            ViewGroup viewGroup = (ViewGroup) this.f51987m.getChildAt(i3);
            if (viewGroup != null && viewGroup.getChildCount() != 0 && (viewGroup.getChildAt(0) instanceof AsynAutoGifImageView)) {
                ((AsynAutoGifImageView) viewGroup.getChildAt(0)).i();
            }
        }
    }

    public int A() {
        return this.f51985h.getVisibility();
    }

    public void C(String str) {
        if (!H() || ((a) d(a.class)).G == null || ((a) d(a.class)).G.size() == 0) {
            return;
        }
        if (b().U == null || b().U.isEmpty()) {
            String str2 = "";
            if (((a) d(a.class)).H == null) {
                ((a) d(a.class)).H = "";
            }
            int i3 = Integer.MAX_VALUE;
            for (String str3 : this.G.keySet()) {
                int lastIndexOf = str.lastIndexOf(str3);
                if (lastIndexOf == -1) {
                    lastIndexOf = str.indexOf(str3);
                }
                if (lastIndexOf != -1 && lastIndexOf <= i3 && str3.length() + lastIndexOf == str.length()) {
                    str2 = str3;
                    i3 = lastIndexOf;
                }
            }
            boolean z16 = true;
            if (!TextUtils.isEmpty(str2) && i3 + str2.length() == str.length()) {
                if (!this.H.contains(str2)) {
                    J(str2);
                    this.H += "|" + str2;
                    this.I = true;
                    N();
                }
                z16 = false;
            }
            if (z16) {
                D();
            }
        }
    }

    public void D() {
        RelativeLayout relativeLayout = this.f51985h;
        if (relativeLayout != null) {
            if (relativeLayout.isShown() && !this.K) {
                K(1);
            }
            if (this.f51985h.isShown() && this.f51985h.getAnimation() == null) {
                this.f51985h.startAnimation(this.E);
            }
        }
    }

    public boolean F() {
        return this.I;
    }

    public void G() {
        if (b().oj() == null || b().oj().size() == 0) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetPublishMoodEggShellRequest(LoginData.getInstance().getUin()), b().getHandler(), this, 200));
        }
    }

    public void I() {
        if (this.f51987m == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f51987m.getChildCount(); i3++) {
            ViewGroup viewGroup = (ViewGroup) this.f51987m.getChildAt(i3);
            if (viewGroup != null && viewGroup.getChildCount() != 0 && (viewGroup.getChildAt(0) instanceof AsynAutoGifImageView)) {
                ((AsynAutoGifImageView) viewGroup.getChildAt(0)).g();
            }
        }
    }

    public void K(int i3) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneReportMoodEggOprationRequest(LoginData.getInstance().getUin(), (byte) i3), b().getHandler(), this, 202));
    }

    public void L(boolean z16) {
        this.I = z16;
    }

    public void N() {
        RelativeLayout relativeLayout;
        if (H() && (relativeLayout = this.f51985h) != null) {
            if (relativeLayout.isShown() && this.f51985h.getAnimation() != null) {
                this.f51985h.clearAnimation();
            }
            this.f51985h.setVisibility(0);
        }
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void g() {
        super.g();
        x();
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void h() {
        super.h();
        O();
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void l() {
        super.l();
        this.F = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_WEB_PICTURE_ADD_MORE, 1) == 1;
        E();
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void m() {
        super.m();
        I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.iu6) {
            z();
            K(3);
        } else if (id5 == R.id.bu7) {
            B();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mResultCode;
        if (i3 != 0) {
            QZLog.e(L, "get eggkey failed,code = " + qZoneTask.mResultCode);
            return;
        }
        int i16 = qZoneTask.mType;
        if (i16 != 200) {
            if (i16 == 200) {
                if (i3 == 0) {
                    QZLog.i(L, "report succeess = " + qZoneTask.mResultCode);
                    return;
                }
                QZLog.i(L, "report fail = " + qZoneTask.mResultCode);
                return;
            }
            return;
        }
        QZoneGetPublishMoodEggShellRequest qZoneGetPublishMoodEggShellRequest = (QZoneGetPublishMoodEggShellRequest) qZoneTask.mRequest;
        if (qZoneGetPublishMoodEggShellRequest.getRsp() == null) {
            return;
        }
        e().A2 = new HashMap<>(qZoneGetPublishMoodEggShellRequest.getRsp().mapKeyWord);
        if (e().Ym() != null || e().f45084c1) {
            return;
        }
        this.J = qZoneGetPublishMoodEggShellRequest.getRsp().ifOpenEntrance != 0;
        this.G = new HashMap<>(qZoneGetPublishMoodEggShellRequest.getRsp().mapKeyWordEggs);
        if (e().f51486u2 == null) {
            e().f51486u2 = new HashMap<>();
        }
        Iterator<Map.Entry<String, ImageSummaryList>> it = this.G.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<ImageSummary> it5 = it.next().getValue().vecImageSummary.iterator();
            while (it5.hasNext()) {
                ImageSummary next = it5.next();
                PicInfo picInfo = new PicInfo();
                picInfo.sourceType = 1;
                picInfo.imageId = next.imageId;
                e().f51486u2.put(next.url, picInfo);
            }
        }
    }

    public View y(ImageSummary imageSummary, int i3, int i16) {
        String str;
        View inflate = LayoutInflater.from(b().getActivity()).inflate(R.layout.brb, (ViewGroup) null);
        AsynAutoGifImageView asynAutoGifImageView = (AsynAutoGifImageView) inflate.findViewById(R.id.dxn);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.bu8);
        asynAutoGifImageView.setTag(imageSummary);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i3;
            layoutParams.height = i3;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i3, i3);
        }
        layoutParams.leftMargin = i16;
        inflate.setLayoutParams(layoutParams);
        int min = Math.min(100, i3);
        asynAutoGifImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        asynAutoGifImageView.setAdjustViewBounds(false);
        asynAutoGifImageView.setCornerRadius(10.0f);
        asynAutoGifImageView.setDefaultImage(R.drawable.asd);
        asynAutoGifImageView.setOnClickListener(new b());
        if (!TextUtils.isEmpty(imageSummary.bubbleUrl)) {
            str = imageSummary.bubbleUrl;
        } else {
            str = imageSummary.url;
        }
        if (o7.b.b(str)) {
            asynAutoGifImageView.setAsynGifImage(str, new c(), new d(progressBar));
            asynAutoGifImageView.h();
        } else {
            asynAutoGifImageView.setAsyncImageProcessor(new ScaleProcessor(min, min, true));
            asynAutoGifImageView.setAsyncClipSize(min, min);
            progressBar.setVisibility(8);
            asynAutoGifImageView.setAsyncImage(str);
        }
        return inflate;
    }

    public void z() {
        RelativeLayout relativeLayout = this.f51985h;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f51985h.setVisibility(8);
        I();
    }

    public void M(boolean z16) {
        RelativeLayout relativeLayout;
        if (!z16 && (relativeLayout = this.f51985h) != null && relativeLayout.isShown()) {
            this.f51985h.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.f51987m;
        if (linearLayout == null || linearLayout.getChildCount() == 0 || !this.I) {
            return;
        }
        N();
    }

    private void E() {
        this.f51985h = (RelativeLayout) a(R.id.iu7);
        this.f51987m = (LinearLayout) a(R.id.bu6);
        RelativeLayout relativeLayout = this.f51985h;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(f().getColor(R.color.qzone_skin_color_tab_egg_photos_bg));
        }
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_EGGPHOTO_LAYERTYPE, 1);
        try {
            RelativeLayout relativeLayout2 = this.f51985h;
            if (relativeLayout2 != null) {
                relativeLayout2.setLayerType(config, null);
            }
        } catch (Exception e16) {
            QZLog.e(L, "mEggPhotoLayout.setLayerType false", e16);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.E = alphaAnimation;
        alphaAnimation.setAnimationListener(new C0443a());
        this.E.setDuration(2000L);
        TextView textView = (TextView) a(R.id.bu7);
        this.D = textView;
        textView.setOnClickListener(this);
        if (this.F) {
            this.D.setVisibility(0);
        }
        ImageView imageView = (ImageView) a(R.id.iu6);
        this.f51986i = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements AutoGifDrawable.GifDownloadCallBackListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProgressBar f51991d;

        d(ProgressBar progressBar) {
            this.f51991d = progressBar;
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f51991d.setVisibility(8);
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
