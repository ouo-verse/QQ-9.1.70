package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoInfo extends ImageInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: s, reason: collision with root package name */
    public String f297389s;

    /* renamed from: t, reason: collision with root package name */
    public String f297390t;

    /* renamed from: u, reason: collision with root package name */
    public String f297391u;

    /* renamed from: v, reason: collision with root package name */
    public String f297392v;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class CompressVideoSegment extends JobSegment<ImageInfo, ImageInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<XMediaEditor> f297393d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f297394e;

        public CompressVideoSegment(XMediaEditor xMediaEditor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor);
            } else {
                this.f297393d = new WeakReference<>(xMediaEditor);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, ImageInfo imageInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) imageInfo);
                return;
            }
            VideoInfo videoInfo = (VideoInfo) imageInfo;
            if (QLog.isColorLevel()) {
                QLog.d("CompressVideoSegment", 2, "CompressVideoSegment start. info status=", Integer.valueOf(videoInfo.f297417d));
            }
            String j3 = ImageInfo.j();
            try {
                XMediaEditor xMediaEditor = this.f297393d.get();
                if (xMediaEditor != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CompressVideoSegment", 2, "CompressVideoSegment sourceVideoPath=", videoInfo.f297390t);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(j3);
                    String str = videoInfo.f297390t;
                    sb5.append(str.substring(str.lastIndexOf("/") + 1, videoInfo.f297390t.lastIndexOf(".")));
                    sb5.append(System.currentTimeMillis());
                    sb5.append(q.j(videoInfo.f297390t));
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
                    int d16 = TroopHomeworkHelper.d(xMediaEditor.getContext(), videoInfo.f297390t, sDKPrivatePath);
                    if (QLog.isColorLevel()) {
                        QLog.d("CompressVideoSegment", 2, "CompressVideo ret:", Integer.valueOf(d16));
                    }
                    if (d16 == 1) {
                        sDKPrivatePath = videoInfo.f297390t;
                    }
                    if ((d16 == 0 || d16 == 1) && FileUtils.fileExistsAndNotEmpty(sDKPrivatePath)) {
                        if (q.m(sDKPrivatePath) > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                            notifyError(new Error("200"));
                            return;
                        }
                        videoInfo.f297392v = sDKPrivatePath;
                        ThreadManager.getUIHandler().post(new Runnable(videoInfo, xMediaEditor) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ VideoInfo f297395d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ XMediaEditor f297396e;

                            {
                                this.f297395d = videoInfo;
                                this.f297396e = xMediaEditor;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, CompressVideoSegment.this, videoInfo, xMediaEditor);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                VideoInfo videoInfo2 = this.f297395d;
                                videoInfo2.f297370o = 10;
                                videoInfo2.f297417d = -2147483647;
                                RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f297396e.findViewHolderForLayoutPosition(videoInfo2.f297409a);
                                if (findViewHolderForLayoutPosition instanceof e.c) {
                                    e.c cVar = (e.c) findViewHolderForLayoutPosition;
                                    if (this.f297395d.f297366k.equals(cVar.C.getTag())) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("CompressVideoSegment", 2, "CompressVideo before notify. vh hash=", Integer.valueOf(cVar.hashCode()));
                                        }
                                        ((com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) this.f297396e.getAdapter()).f297359e.a(2)).a(cVar, this.f297395d, 0);
                                    }
                                }
                            }
                        });
                        if (!isCanceled()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("CompressVideoSegment", 2, "CompressVideoSegment notifyResult. mVideoCompressedPath=", videoInfo.f297392v, ", info status=", Integer.valueOf(videoInfo.f297417d));
                            }
                            notifyResult(videoInfo);
                            return;
                        }
                        return;
                    }
                    notifyError(new Error("-200"));
                    return;
                }
                notifyError(new Error("0"));
            } catch (OutOfMemoryError unused) {
                QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
                URLDrawable.clearMemoryCache();
                System.gc();
                if (!this.f297394e) {
                    this.f297394e = true;
                    runSegment(jobContext, imageInfo);
                } else {
                    notifyError(new Error("-1"));
                }
            }
        }

        @Override // com.tribe.async.async.JobSegment, com.tribe.async.reactive.StreamFunction
        protected void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                notifyError(new Error("c_2001"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class GenerateVideoPosterSegment extends JobSegment<VideoInfo, VideoInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<XMediaEditor> f297397d;

        /* renamed from: e, reason: collision with root package name */
        private int f297398e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f297399f;

        public GenerateVideoPosterSegment(XMediaEditor xMediaEditor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor, i3);
            } else {
                this.f297397d = new WeakReference<>(xMediaEditor);
                this.f297398e = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0140 A[Catch: RuntimeException -> 0x0143, TRY_LEAVE, TryCatch #6 {RuntimeException -> 0x0143, blocks: (B:61:0x013b, B:63:0x0140), top: B:60:0x013b }] */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void runSegment(JobContext jobContext, VideoInfo videoInfo) {
            Bitmap bitmap;
            Bitmap bitmap2;
            Bitmap frameAtTime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) videoInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GenerateVideoPosterSegment", 2, "GenerateVideoPosterSegment start. info status=", Integer.valueOf(videoInfo.f297417d));
            }
            String j3 = ImageInfo.j();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(videoInfo.f297390t);
                        frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                    } catch (Exception e16) {
                        e = e16;
                        bitmap2 = null;
                    } catch (OutOfMemoryError unused) {
                        bitmap2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bitmap = null;
                        try {
                            mediaMetadataRetriever.release();
                            if (0 != 0) {
                            }
                        } catch (RuntimeException unused2) {
                        }
                        throw th;
                    }
                    if (frameAtTime == null) {
                        notifyError(new Error("-201"));
                        try {
                            mediaMetadataRetriever.release();
                            return;
                        } catch (RuntimeException unused3) {
                            return;
                        }
                    }
                    int[] p16 = ImageItem.p(this.f297398e, 200, 300, videoInfo.f297367l, videoInfo.f297368m);
                    bitmap2 = ThumbnailUtils.extractThumbnail(frameAtTime, p16[0], p16[1]);
                    try {
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("GenerateVideoPosterSegment", 1, "error retrieve video info" + e.getMessage());
                        notifyError(new Error("-201"));
                        mediaMetadataRetriever.release();
                        if (bitmap2 == null) {
                            return;
                        }
                        bitmap2.recycle();
                    } catch (OutOfMemoryError unused4) {
                        QLog.e("GenerateVideoPosterSegment", 1, "GenerateVideoPosterSegment error. OutOfMemoryError");
                        URLDrawable.clearMemoryCache();
                        System.gc();
                        if (!this.f297399f) {
                            this.f297399f = true;
                            runSegment(jobContext, videoInfo);
                        } else {
                            notifyError(new Error("-1"));
                        }
                        mediaMetadataRetriever.release();
                        if (bitmap2 == null) {
                            return;
                        }
                        bitmap2.recycle();
                    }
                    if (bitmap2 == null) {
                        notifyError(new Error("-201"));
                        try {
                            mediaMetadataRetriever.release();
                            if (bitmap2 != null) {
                                bitmap2.recycle();
                                return;
                            }
                            return;
                        } catch (RuntimeException unused5) {
                            return;
                        }
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(j3 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
                    BaseImageUtil.saveBitmapToFile(bitmap2, new File(sDKPrivatePath));
                    videoInfo.f297364i = sDKPrivatePath;
                    ThreadManager.getUIHandler().post(new Runnable(videoInfo, sDKPrivatePath) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ VideoInfo f297400d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f297401e;

                        {
                            this.f297400d = videoInfo;
                            this.f297401e = sDKPrivatePath;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, GenerateVideoPosterSegment.this, videoInfo, sDKPrivatePath);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            this.f297400d.n(this.f297401e);
                            VideoInfo videoInfo2 = this.f297400d;
                            videoInfo2.f297370o = 5;
                            videoInfo2.f297417d = -2147483646;
                            XMediaEditor xMediaEditor = (XMediaEditor) GenerateVideoPosterSegment.this.f297397d.get();
                            if (xMediaEditor != null) {
                                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297400d.f297409a);
                                if (findViewHolderForLayoutPosition instanceof e.c) {
                                    e.c cVar = (e.c) findViewHolderForLayoutPosition;
                                    if (this.f297400d.f297366k.equals(cVar.C.getTag())) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("GenerateVideoPosterSegment", 2, "GeneratePoster before notify. vh hash=", Integer.valueOf(cVar.hashCode()));
                                        }
                                        ((com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) xMediaEditor.getAdapter()).f297359e.a(2)).a(cVar, this.f297400d, 0);
                                    }
                                }
                            }
                        }
                    });
                    if (!isCanceled()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("GenerateVideoPosterSegment", 2, "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(videoInfo.f297417d));
                        }
                        notifyResult(videoInfo);
                    }
                    mediaMetadataRetriever.release();
                    bitmap2.recycle();
                } catch (Throwable th6) {
                    th = th6;
                    mediaMetadataRetriever.release();
                    if (0 != 0) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } catch (RuntimeException unused6) {
            }
        }

        @Override // com.tribe.async.async.JobSegment, com.tribe.async.reactive.StreamFunction
        protected void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                notifyError(new Error("c_2000"));
            }
        }
    }

    public VideoInfo(JSONObject jSONObject, String str) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject, (Object) str);
            return;
        }
        i(jSONObject);
        this.f297366k = String.valueOf(hashCode());
        this.f297373r = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (FileUtils.fileExistsAndNotEmpty(this.f297390t)) {
            MediaMetadataRetriever mediaMetadataRetriever = null;
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever3 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever3.setDataSource(this.f297390t);
                        this.f297367l = Integer.valueOf(mediaMetadataRetriever3.extractMetadata(18)).intValue();
                        this.f297368m = Integer.valueOf(mediaMetadataRetriever3.extractMetadata(19)).intValue();
                        int i3 = Build.VERSION.SDK_INT;
                        int intValue = Integer.valueOf(mediaMetadataRetriever3.extractMetadata(24)).intValue();
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoInfo", 2, "calculateLocalVideoSize rotation. sdk=", Integer.valueOf(i3), ", rotation=", Integer.valueOf(intValue));
                        }
                        if (intValue == 90 || intValue == 270) {
                            int i16 = this.f297367l;
                            this.f297367l = this.f297368m;
                            this.f297368m = i16;
                        }
                        boolean isColorLevel = QLog.isColorLevel();
                        MediaMetadataRetriever mediaMetadataRetriever4 = isColorLevel;
                        if (isColorLevel != 0) {
                            Object[] objArr = {"calculateLocalVideoSize result. path=", this.f297390t, ", width=", Integer.valueOf(this.f297367l), ", height=", Integer.valueOf(this.f297368m), ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)};
                            QLog.d("VideoInfo", 2, objArr);
                            mediaMetadataRetriever4 = objArr;
                        }
                        if (this.f297367l <= 0 || this.f297368m <= 0) {
                            this.f297367l = this.f297369n;
                            this.f297368m = (int) ((r1 * 9) / 16.0f);
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoInfo", 2, "calculateLocalVideoSize doudi. maxWidth=", Integer.valueOf(this.f297367l), ", height=", Integer.valueOf(this.f297368m));
                            }
                        }
                        mediaMetadataRetriever3.release();
                        mediaMetadataRetriever = mediaMetadataRetriever4;
                    } catch (Exception unused) {
                        mediaMetadataRetriever2 = mediaMetadataRetriever3;
                        QLog.e("VideoInfo", 1, "calculateLocalVideoSize exception. path=", this.f297390t);
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever2 != null) {
                            mediaMetadataRetriever2.release();
                            mediaMetadataRetriever = mediaMetadataRetriever2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (JSONObject) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "video");
            jSONObject.put("url", this.f297389s);
            jSONObject.put("width", this.f297367l);
            jSONObject.put("height", this.f297368m);
            jSONObject.put(QAdVrReport.ElementID.AD_POSTER, this.f297363h);
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoInfo", 2, "VideoInfo getContent exception.");
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.f297389s);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.g
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int i3 = this.f297417d;
        switch (i3) {
            case Integer.MIN_VALUE:
            case -2147483647:
            case -2147483646:
            case -2147483645:
                return 1;
            default:
                return i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
    public Stream<ImageInfo> g(XMediaEditor xMediaEditor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Stream) iPatchRedirector.redirect((short) 12, (Object) this, (Object) xMediaEditor);
        }
        Stream map = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
        if (!FileUtils.fileExistsAndNotEmpty(this.f297392v)) {
            if (this.f297417d >= 0) {
                this.f297417d = -2147483646;
            }
            map = map.map(new CompressVideoSegment(xMediaEditor));
        }
        String r16 = xMediaEditor.r("troopuin");
        if (TextUtils.isEmpty(this.f297389s)) {
            if (this.f297417d >= 0) {
                this.f297417d = -2147483647;
            }
            map = map.map(new ImageInfo.UploadMediaSegment(1, xMediaEditor, r16));
        }
        if (TextUtils.isEmpty(this.f297363h)) {
            if (this.f297417d >= 0) {
                this.f297417d = Integer.MIN_VALUE;
            }
            map = map.map(new ImageInfo.UploadMediaSegment(2, xMediaEditor, r16));
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297409a);
        if (findViewHolderForLayoutPosition instanceof e.c) {
            e.c cVar = (e.c) findViewHolderForLayoutPosition;
            if (this.f297366k.equals(cVar.C.getTag())) {
                ((com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) xMediaEditor.getAdapter()).f297359e.a(2)).a(cVar, this, 0);
            }
        }
        return map.map(new UIThreadOffFunction(null));
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
    public void i(JSONObject jSONObject) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSONObject);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoInfo", 2, "VideoInfo createFrom json: ", jSONObject);
        }
        this.f297410b = jSONObject;
        o(jSONObject.optString(QAdVrReport.ElementID.AD_POSTER));
        this.f297367l = jSONObject.optInt("width");
        this.f297368m = jSONObject.optInt("height");
        String optString = jSONObject.optString("url");
        this.f297389s = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.f297389s = this.f297389s.replace("https://", "http://");
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (TextUtils.isEmpty(this.f297390t)) {
            return this.f297389s;
        }
        return this.f297390t;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f297389s) && !TextUtils.isEmpty(this.f297363h)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo
    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        try {
            this.f297365j = new URL(str);
            this.f297363h = str;
        } catch (MalformedURLException unused) {
            QLog.e("VideoInfo", 1, "Video setURLFromContentUrl exception.");
        }
    }

    public Stream<VideoInfo> p(XMediaEditor xMediaEditor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Stream) iPatchRedirector.redirect((short) 13, (Object) this, (Object) xMediaEditor);
        }
        this.f297417d = 1;
        if (FileUtils.fileExistsAndNotEmpty(this.f297364i)) {
            return null;
        }
        Stream<VideoInfo> map = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
        if (!FileUtils.fileExistsAndNotEmpty(this.f297364i)) {
            this.f297417d = -2147483645;
            return map.map(new GenerateVideoPosterSegment(xMediaEditor, this.f297369n)).map(new UIThreadOffFunction(null));
        }
        return map;
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (TextUtils.isEmpty(this.f297390t)) {
            return this.f297389s;
        }
        return this.f297390t;
    }

    public VideoInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f297390t = str;
        q();
        this.f297366k = String.valueOf(hashCode());
        this.f297373r = str2;
    }
}
