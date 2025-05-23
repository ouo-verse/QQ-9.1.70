package com.tencent.creatorad.ui.presenter;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.constants.Constants;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: y, reason: collision with root package name */
    public static final int f100439y;

    /* renamed from: r, reason: collision with root package name */
    private FrameLayout f100440r;

    /* renamed from: s, reason: collision with root package name */
    private BaseVideoView f100441s;

    /* renamed from: t, reason: collision with root package name */
    private JSONObject f100442t;

    /* renamed from: u, reason: collision with root package name */
    private String f100443u;

    /* renamed from: v, reason: collision with root package name */
    private int f100444v;

    /* renamed from: w, reason: collision with root package name */
    private int f100445w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f100446x;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            l.this.f100417i.startCheck();
            if (!l.this.f100446x) {
                return;
            }
            l.this.f100441s.seekTo(0);
            l.this.f100441s.play();
            l.this.M("bf", "1");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            l.this.w();
            if (l.this.f100441s != null) {
                l.this.K();
                l.this.f100441s.releasePlayer(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
            } else {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(2.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements VideoPlayerCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                l.this.M("bf", "1");
                l.this.M("pa", "11");
                if (((com.tencent.creatorad.ui.b) l.this).f100385d.getGlobalVisibleRect(l.this.f100421m) && l.this.f100441s != null) {
                    l.this.f100441s.play();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                l.this.M("pa", "14");
                l.this.f100444v++;
                l.this.K();
                l.this.M("bt", "0");
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                l.this.M(Constants.KEYS.PLACEMENTS, "2");
            } else {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                l.this.M(FileReaderHelper.ET_EXT, String.valueOf(j16));
                l.this.M("pt", String.valueOf((r5.f100444v * l.this.f100445w) + j16));
                return;
            }
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NarrowBannerPortraitPresenter", 2, "onStateChange , state = " + i3 + ", msgUniseq=" + j3);
            }
            if (i3 != 4) {
                if (i3 == 8) {
                    l.this.M("ef", "1");
                    l.this.K();
                    l.this.M("ef", "0");
                    return;
                }
                return;
            }
            ImageView imageView = l.this.f100414f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f100439y = com.tencent.creatorad.ui.c.c(1, false, 100);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100441s = null;
            this.f100442t = new JSONObject();
        }
    }

    private void G(GdtAd gdtAd) {
        if (gdtAd.isValid() && this.f100446x) {
            this.f100445w = gdtAd.info.display_info.video_info.media_duration.get();
            BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.f100385d.getContext(), gdtAd.getAId(), I(gdtAd.getVideoUrl()), null);
            this.f100441s = baseVideoView;
            this.f100440r.addView(baseVideoView, -1, -1);
            this.f100441s.setOutlineProvider(new b());
            this.f100441s.setClipToOutline(true);
            this.f100440r.setVisibility(0);
            return;
        }
        this.f100440r.setVisibility(8);
    }

    private void H(int i3) {
        ImageView imageView = this.f100414f;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(63.72f);
        layoutParams.height = ViewUtils.dpToPx(36.0f);
        if (i3 == 8) {
            layoutParams.width = ViewUtils.dpToPx(54.0f);
        }
        if (i3 == 10) {
            layoutParams.width = layoutParams.height;
        }
        this.f100414f.setLayoutParams(layoutParams);
    }

    private VideoPlayParam I(String str) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mVideoFormat = 104;
        videoPlayParam.mUrls = new String[]{str};
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mIsMute = true;
        videoPlayParam.mSceneId = 110;
        L(videoPlayParam);
        return videoPlayParam;
    }

    private void J() {
        try {
            this.f100442t.put("bt", "0");
            this.f100442t.put(FileReaderHelper.ET_EXT, "0");
            this.f100442t.put("bf", "0");
            this.f100442t.put("ef", "0");
            this.f100442t.put("pp", "0");
            this.f100442t.put("pa", "0");
            this.f100442t.put("ft", "0");
            this.f100442t.put(Constants.KEYS.PLACEMENTS, "0");
            this.f100442t.put("pt", "0");
        } catch (JSONException e16) {
            QLog.e("NarrowBannerPortraitPresenter", 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (TextUtils.isEmpty(this.f100443u)) {
            QLog.i("NarrowBannerPortraitPresenter", 1, "videoReportUrl is empty, cancel video report");
        } else {
            com.tencent.creatorad.utils.b.c(String.format(Locale.CHINA, "%s&video=%s", this.f100443u, URLEncoder.encode(this.f100442t.toString())));
            M("ft", "0");
        }
    }

    private void L(VideoPlayParam videoPlayParam) {
        videoPlayParam.mCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, String str2) {
        try {
            this.f100442t.put(str, str2);
        } catch (JSONException e16) {
            QLog.e("NarrowBannerPortraitPresenter", 1, "updateVideoReportParams failed, exception is " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.presenter.f, com.tencent.creatorad.ui.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f100439y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public void d(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) creatorReader$ShareAD, i3);
            return;
        }
        if (this.f100446x) {
            M("ft", "2");
        }
        super.d(creatorReader$ShareAD, i3);
    }

    @Override // com.tencent.creatorad.ui.presenter.f, com.tencent.creatorad.ui.b
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.e4v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.presenter.f, com.tencent.creatorad.ui.b
    public void j(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) creatorReader$ShareAD);
            return;
        }
        super.j(creatorReader$ShareAD);
        boolean z16 = true;
        if (!com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
            QLog.e("NarrowBannerPortraitPresenter", 1, "isSharedAdValid false");
            return;
        }
        this.f100414f.setVisibility(0);
        GdtAd gdtAd = new GdtAd(creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
        this.f100443u = gdtAd.getVideoReportUrl();
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 3) {
            z16 = false;
        }
        this.f100446x = z16;
        H(innerShowType);
        G(gdtAd);
        J();
        this.f100385d.addOnAttachStateChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.presenter.f, com.tencent.creatorad.ui.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.k();
        FrameLayout frameLayout = (FrameLayout) this.f100384c.findViewById(R.id.ubg);
        this.f100440r = frameLayout;
        frameLayout.setOnClickListener(this.f100423o);
    }

    @Override // com.tencent.creatorad.ui.b
    public void l() {
        BaseVideoView baseVideoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f100446x && (baseVideoView = this.f100441s) != null) {
            baseVideoView.pause();
            M("ft", "3");
            K();
        }
    }

    @Override // com.tencent.creatorad.ui.b
    public void m() {
        BaseVideoView baseVideoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.f100446x && (baseVideoView = this.f100441s) != null) {
            baseVideoView.play();
            M("bf", "0");
        }
    }
}
