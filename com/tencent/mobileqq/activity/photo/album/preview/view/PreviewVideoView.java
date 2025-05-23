package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.net.URL;

/* loaded from: classes10.dex */
public class PreviewVideoView extends BrowserBaseView implements VideoPlayerCallback, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f184347d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f184348e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f184349f;

    /* renamed from: h, reason: collision with root package name */
    private BaseVideoView f184350h;

    /* renamed from: i, reason: collision with root package name */
    private d f184351i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends ColorDrawable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f184352a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f184353b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i3, int i16, int i17) {
            super(i3);
            this.f184352a = i16;
            this.f184353b = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PreviewVideoView.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f184352a;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f184353b;
        }
    }

    public PreviewVideoView(Context context, d dVar) {
        super(context, dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) dVar);
        } else {
            this.f184351i = dVar;
        }
    }

    private void f(Context context) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        d dVar = this.f184351i;
        videoPlayParam.mVideoPath = dVar.m(dVar.getCurrentPosition());
        videoPlayParam.mIsLocal = true;
        videoPlayParam.mCallback = this;
        BaseVideoView d16 = d(context, this.f184351i.getCurrentPosition(), videoPlayParam, null);
        this.f184350h = d16;
        d16.setId(R.id.f11765721);
        this.f184350h.setVideoParam(videoPlayParam);
        this.f184350h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f184350h.setOnClickListener(this);
        this.f184350h.setVisibility(0);
        this.f184350h.setImportantForAccessibility(2);
        this.f184349f.addView(this.f184350h);
    }

    private void g(int i3) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mVideoPath = this.f184351i.m(i3);
        videoPlayParam.mIsLocal = true;
        videoPlayParam.mCallback = this;
        this.f184350h.setVideoParam(videoPlayParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16) {
        int i3;
        ImageView imageView = this.f184348e;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16) {
        int i3;
        ImageView imageView = this.f184347d;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void bindView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        LocalMediaInfo l3 = this.f184351i.l(i3);
        if (l3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "info is null, return");
                return;
            }
            return;
        }
        int i16 = this.mScreenWidthPx;
        int i17 = this.mScreenHeightPx;
        if (l3.mediaWidth > l3.mediaHeight) {
            i17 = i16;
            i16 = i17;
        }
        g(i3);
        Drawable k3 = this.f184351i.k(l3.path);
        if (k3 == null) {
            URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(l3, "FLOW_THUMB");
            if (generateAlbumThumbURL != null) {
                k3 = e(generateAlbumThumbURL.toString(), i16, i17, l3);
                this.f184351i.j(l3.path, k3);
            } else {
                QLog.d("QQAlbum", 2, "url  is null ");
            }
        }
        if (k3 != null) {
            this.f184347d.setImageDrawable(k3);
        }
        i(true);
        h(true);
    }

    protected BaseVideoView d(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BaseVideoView) iPatchRedirector.redirect((short) 11, this, context, Long.valueOf(j3), videoPlayParam, imageView);
        }
        return (BaseVideoView) VideoViewFactory.createBaseVideoView(context, j3, videoPlayParam, imageView);
    }

    public Drawable e(String str, int i3, int i16, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), localMediaInfo);
        }
        a aVar = new a(Color.rgb(214, 214, 214), i16, i3);
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, i3, i16, aVar, aVar);
                drawable.setTag(localMediaInfo);
                if (drawable.getStatus() != 1) {
                    drawable.downloadImediatly();
                }
                return drawable;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQAlbum", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + str, e16);
                }
            }
        }
        return aVar;
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public View getView(View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) viewGroup);
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.i3i, viewGroup, false);
        this.mBrowserItemView = relativeLayout;
        this.f184347d = (ImageView) relativeLayout.findViewById(R.id.fyr);
        ImageView imageView = (ImageView) this.mBrowserItemView.findViewById(R.id.f27450g_);
        this.f184348e = imageView;
        imageView.setOnClickListener(this);
        this.f184349f = (FrameLayout) this.mBrowserItemView.findViewById(R.id.fyt);
        f(this.mContext);
        return this.mBrowserItemView;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseVideoView baseVideoView;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if ((id5 == R.id.f27450g_ || id5 == R.id.f11765721) && (baseVideoView = this.f184350h) != null) {
                if (baseVideoView.isPlaying()) {
                    this.f184350h.pause();
                    h(true);
                } else {
                    this.f184350h.play();
                    h(false);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        BaseVideoView baseVideoView = this.f184350h;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroyView(int i3, View view) {
        LocalMediaInfo l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) view);
            return;
        }
        BaseVideoView baseVideoView = this.f184350h;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
        d dVar = this.f184351i;
        if (dVar != null && (l3 = dVar.l(i3)) != null && !TextUtils.isEmpty(l3.path)) {
            this.f184351i.n(l3.path);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        } else {
            this.f184347d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewVideoView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PreviewVideoView.this.i(false);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onItemSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            super.onItemSelected(i3);
            bindView(i3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.f184350h;
        if (baseVideoView != null && baseVideoView.isPlaying()) {
            this.f184350h.pause();
            h(true);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, e04.d
    public void onScrollHalfScreenWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQAlbum", 2, "onScrollHalfScreenWidth");
        }
        BaseVideoView baseVideoView = this.f184350h;
        if (baseVideoView != null && baseVideoView.isPlaying()) {
            this.f184350h.pause();
            h(true);
            i(true);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onStateChange , state = " + i3);
        }
        if (i3 == 8) {
            this.f184347d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewVideoView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PreviewVideoView.this.h(true);
                        PreviewVideoView.this.i(true);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else if (i3 == 4) {
            this.f184347d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewVideoView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PreviewVideoView.this.h(false);
                        if (PreviewVideoView.this.f184350h != null && PreviewVideoView.this.f184350h.getCurPlayingPos() > 0) {
                            PreviewVideoView.this.i(false);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }
}
