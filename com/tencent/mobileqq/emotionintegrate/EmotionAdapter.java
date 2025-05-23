package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private int C;
    private b D;

    /* renamed from: d, reason: collision with root package name */
    protected Context f205139d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f205140e;

    /* renamed from: f, reason: collision with root package name */
    protected p f205141f;

    /* renamed from: h, reason: collision with root package name */
    public List<p> f205142h;

    /* renamed from: i, reason: collision with root package name */
    private a f205143i;

    /* renamed from: m, reason: collision with root package name */
    public CopyOnWriteArraySet<BaseVideoView> f205144m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private static class VideoViewCallback implements VideoPlayerCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private e f205145d;

        public VideoViewCallback(e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            } else {
                this.f205145d = eVar;
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
            LinearLayout linearLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, j3);
                return;
            }
            e eVar = this.f205145d;
            if ((eVar instanceof e) && (linearLayout = eVar.f205151b) != null) {
                linearLayout.post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.EmotionAdapter.VideoViewCallback.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoViewCallback.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            VideoViewCallback.this.f205145d.f205151b.setVisibility(0);
                            VideoViewCallback.this.f205145d.f205153d.setMute(false);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
            BaseVideoView baseVideoView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            e eVar = this.f205145d;
            if ((eVar instanceof e) && (baseVideoView = eVar.f205153d) != null && !baseVideoView.isMute()) {
                this.f205145d.f205152c.post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.EmotionAdapter.VideoViewCallback.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoViewCallback.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            VideoViewCallback.this.f205145d.f205153d.setMute(true);
                            VideoViewCallback.this.f205145d.f205152c.setImageResource(R.drawable.mnf);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<EmotionAdapter> f205146d;

        public b(EmotionAdapter emotionAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) emotionAdapter);
            } else {
                this.f205146d = new WeakReference<>(emotionAdapter);
            }
        }

        private static boolean a(String str) {
            String parent = MobileQQ.sMobileQQ.getFilesDir().getParent();
            if (parent != null && str.startsWith(parent)) {
                return true;
            }
            File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null);
            if (externalFilesDir != null && externalFilesDir.getParent() != null) {
                return str.startsWith(externalFilesDir.getParent());
            }
            return false;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, interruptedException);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, uRLDrawable, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            EmotionAdapter emotionAdapter = this.f205146d.get();
            if (emotionAdapter == null) {
                return;
            }
            int i3 = 0;
            try {
                File fileInLocal = uRLDrawable.getFileInLocal();
                if (fileInLocal != null) {
                    String absolutePath = fileInLocal.getAbsolutePath();
                    if (a(absolutePath)) {
                        i3 = aw.h(absolutePath);
                    } else {
                        QLog.i("EmotionAdapter", 1, "file not in app private dir, filePath:" + absolutePath);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmotionAdapter", 2, "onLoadSuccessed,orientation");
            }
            com.tencent.mobileqq.pic.util.a.a(view, uRLDrawable, i3);
            emotionAdapter.f205140e.removeMessages(1001);
            emotionAdapter.f205140e.obtainMessage(1001, -1, 1, uRLDrawable).sendToTarget();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f205147a;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private e f205148d;

        public d(e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionAdapter.this, (Object) eVar);
            } else {
                this.f205148d = eVar;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 3) {
                e eVar = this.f205148d;
                BaseVideoView baseVideoView = eVar.f205153d;
                ImageView imageView = eVar.f205152c;
                if (baseVideoView != null && imageView != null) {
                    if (baseVideoView.isMute()) {
                        baseVideoView.setMute(false);
                        baseVideoView.seekTo(0);
                        imageView.setImageResource(R.drawable.mng);
                        EmotionAdapter emotionAdapter = EmotionAdapter.this;
                        emotionAdapter.m(emotionAdapter.getItem(emotionAdapter.b()), false);
                    } else {
                        baseVideoView.setMute(true);
                        imageView.setImageResource(R.drawable.mnf);
                        EmotionAdapter emotionAdapter2 = EmotionAdapter.this;
                        emotionAdapter2.m(emotionAdapter2.getItem(emotionAdapter2.b()), true);
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f205150a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f205151b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f205152c;

        /* renamed from: d, reason: collision with root package name */
        BaseVideoView f205153d;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmotionAdapter(Context context, Handler handler, p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, handler, pVar);
            return;
        }
        this.f205144m = new CopyOnWriteArraySet<>();
        this.C = -1;
        this.f205139d = context;
        this.f205140e = handler;
        this.f205141f = pVar;
    }

    private int[] a(MessageForVideoEmoticon messageForVideoEmoticon) {
        int i3;
        float f16 = this.f205139d.getResources().getDisplayMetrics().widthPixels;
        float f17 = this.f205139d.getResources().getDisplayMetrics().heightPixels;
        int i16 = messageForVideoEmoticon.fileWidth;
        if (i16 > 0 && (i3 = messageForVideoEmoticon.fileHeight) > 0) {
            float min = Math.min(f16 / i16, f17 / i3);
            return new int[]{(int) (messageForVideoEmoticon.fileWidth * min), (int) (min * messageForVideoEmoticon.fileHeight)};
        }
        return new int[]{((int) f16) / 2, ((int) f17) / 2};
    }

    private URLDrawableDownListener i() {
        if (this.D == null) {
            this.D = new b(this);
        }
        return this.D;
    }

    private void l(p pVar, boolean z16) {
        View view = new View(this.f205139d);
        com.tencent.mobileqq.emotionintegrate.report.b.f205282a.e(view, pVar);
        if (z16) {
            VideoReport.reportPgIn(view);
        } else {
            VideoReport.reportPgOut(view);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOEmotionViewerDtReport", 4, "reportPageEvent isPageIn=", Boolean.valueOf(z16), ", data=", pVar);
        }
    }

    public static Bitmap n(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.C;
    }

    public BaseVideoView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BaseVideoView) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        a d16 = d();
        if (d16 instanceof e) {
            return ((e) d16).f205153d;
        }
        return null;
    }

    public a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f205143i;
    }

    public List<p> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f205142h;
    }

    public int f(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) pVar)).intValue();
        }
        return pVar.b(this.f205142h);
    }

    @Override // android.widget.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public p getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (p) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        List<p> list = this.f205142h;
        if (list != null && !list.isEmpty() && i3 >= 0 && i3 < this.f205142h.size()) {
            return this.f205142h.get(i3);
        }
        return this.f205141f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<p> list = this.f205142h;
        if (list == null) {
            return 1;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        p pVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        List<p> list = this.f205142h;
        if (list != null && !list.isEmpty() && i3 >= 0 && i3 < this.f205142h.size()) {
            pVar = this.f205142h.get(i3);
        } else {
            pVar = this.f205141f;
        }
        return pVar.v() ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        c cVar;
        View view2;
        View view3;
        View view4;
        e eVar;
        View view5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view3 = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
            view4 = view;
        } else {
            p item = getItem(i3);
            int i16 = this.C;
            if (i16 != -1 && i16 != i3) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.C = i3;
            int itemViewType = getItemViewType(i3);
            View view6 = view;
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null) {
                        View inflate = LayoutInflater.from(this.f205139d).inflate(R.layout.i3d, (ViewGroup) null);
                        eVar = new e();
                        eVar.f205150a = (RelativeLayout) inflate.findViewById(R.id.b9w);
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f1041462i);
                        eVar.f205151b = linearLayout;
                        linearLayout.setClickable(true);
                        eVar.f205151b.setVisibility(8);
                        eVar.f205151b.setOnTouchListener(new d(eVar));
                        eVar.f205152c = (ImageView) inflate.findViewById(R.id.f1041362h);
                        BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoViewFS(this.f205139d, item.k(), null, null);
                        eVar.f205153d = baseVideoView;
                        baseVideoView.setId(R.id.f1175671s);
                        this.f205144m.add(eVar.f205153d);
                        inflate.setTag(eVar);
                        view5 = inflate;
                    } else {
                        eVar = (e) view.getTag();
                        view5 = view;
                    }
                    this.f205143i = eVar;
                    eVar.f205153d.setContentDescription(HardCodeUtil.qqStr(R.string.f214235sc));
                    eVar.f205152c.setImageResource(R.drawable.mng);
                    eVar.f205150a.addView(eVar.f205153d, 0);
                    MessageRecord messageRecord = ((y) item).f205303a;
                    int[] a16 = a((MessageForVideoEmoticon) messageRecord);
                    int i17 = a16[0];
                    int i18 = a16[1];
                    eVar.f205150a.setLayoutParams(new Gallery.LayoutParams(i17, i18));
                    ViewGroup.LayoutParams layoutParams = eVar.f205153d.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(i17, i18);
                    } else if (layoutParams.width != i17 || layoutParams.height != i18) {
                        layoutParams.width = i17;
                        layoutParams.height = i18;
                    }
                    eVar.f205153d.setLayoutParams(layoutParams);
                    MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
                    if (FileUtils.fileExistsAndNotEmpty(com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4"))) {
                        VideoPlayParam videoPlayParam = new VideoPlayParam();
                        videoPlayParam.mIsLocal = true;
                        videoPlayParam.mIsLoop = true;
                        videoPlayParam.mIsMute = true;
                        videoPlayParam.mCallback = new VideoViewCallback(eVar);
                        videoPlayParam.mVideoPath = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
                        eVar.f205153d.setVideoParam(videoPlayParam);
                        eVar.f205153d.play();
                    }
                    this.f205140e.removeMessages(1001);
                    this.f205140e.obtainMessage(1001, i3, 0).sendToTarget();
                    view6 = view5;
                }
            } else {
                if (view == null) {
                    URLImageView uRLImageView = new URLImageView(this.f205139d);
                    cVar = new c();
                    cVar.f205147a = uRLImageView;
                    uRLImageView.setTag(cVar);
                    view2 = uRLImageView;
                } else {
                    cVar = (c) view.getTag();
                    view2 = view;
                }
                this.f205143i = cVar;
                URLImageView uRLImageView2 = cVar.f205147a;
                Drawable c16 = item.c(this.f205139d);
                if (item.s()) {
                    uRLImageView2.setURLDrawableDownListener(i());
                } else {
                    uRLImageView2.setURLDrawableDownListener(null);
                }
                if (c16 instanceof com.tencent.mobileqq.magicface.drawable.c) {
                    com.tencent.mobileqq.magicface.drawable.c cVar2 = (com.tencent.mobileqq.magicface.drawable.c) c16;
                    if (cVar2.b() != null) {
                        int f16 = BaseAIOUtils.f(100.0f, this.f205139d.getResources());
                        uRLImageView2.setImageBitmap(n(cVar2.b(), f16, f16));
                        this.f205140e.removeMessages(1001);
                        this.f205140e.obtainMessage(1001, i3, 0, c16).sendToTarget();
                        view6 = view2;
                    }
                }
                uRLImageView2.setImageDrawable(c16);
                this.f205140e.removeMessages(1001);
                this.f205140e.obtainMessage(1001, i3, 0, c16).sendToTarget();
                view6 = view2;
            }
            l(item, z16);
            view3 = view6;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 2;
    }

    public Long h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Long) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        return Long.valueOf(getItem(i3).k());
    }

    public boolean j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        return getItem(i3).t(this.f205141f);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        CopyOnWriteArraySet<BaseVideoView> copyOnWriteArraySet = this.f205144m;
        if (copyOnWriteArraySet != null) {
            Iterator<BaseVideoView> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                BaseVideoView next = it.next();
                if (next != null) {
                    next.releasePlayer(false);
                    this.f205144m.remove(next);
                }
            }
        }
    }

    public void m(p pVar, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, pVar, Boolean.valueOf(z16));
            return;
        }
        if (pVar.v()) {
            y yVar = (y) pVar;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (z16) {
                str = "2";
            } else {
                str = "1";
            }
            ReportController.o(waitAppRuntime, "dc00898", "", "", "0X800C08E", "0X800C08E", 0, 0, str, "", "", ((MessageForVideoEmoticon) yVar.f205303a).md5);
        }
    }

    public void setData(List<p> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.f205142h = list;
        }
    }
}
