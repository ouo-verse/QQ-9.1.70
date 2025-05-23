package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ImageInfo extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f297361f;

    /* renamed from: g, reason: collision with root package name */
    public String f297362g;

    /* renamed from: h, reason: collision with root package name */
    protected String f297363h;

    /* renamed from: i, reason: collision with root package name */
    public String f297364i;

    /* renamed from: j, reason: collision with root package name */
    public URL f297365j;

    /* renamed from: k, reason: collision with root package name */
    public String f297366k;

    /* renamed from: l, reason: collision with root package name */
    public int f297367l;

    /* renamed from: m, reason: collision with root package name */
    public int f297368m;

    /* renamed from: n, reason: collision with root package name */
    public int f297369n;

    /* renamed from: o, reason: collision with root package name */
    public int f297370o;

    /* renamed from: p, reason: collision with root package name */
    public ConcurrentHashMap<String, TroopHomeworkHelper.UploadFileTask> f297371p;

    /* renamed from: q, reason: collision with root package name */
    public long f297372q;

    /* renamed from: r, reason: collision with root package name */
    public String f297373r;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class UploadMediaSegment extends JobSegment<ImageInfo, ImageInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<XMediaEditor> f297374d;

        /* renamed from: e, reason: collision with root package name */
        private int f297375e;

        /* renamed from: f, reason: collision with root package name */
        private String f297376f;

        /* renamed from: h, reason: collision with root package name */
        private TroopHomeworkHelper.UploadFileTask f297377h;

        /* renamed from: i, reason: collision with root package name */
        private ImageInfo f297378i;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes19.dex */
        public class MediaUploadCallback implements TroopHomeworkHelper.f {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private int f297379a;

            /* renamed from: b, reason: collision with root package name */
            private float f297380b;

            /* renamed from: c, reason: collision with root package name */
            private long f297381c;

            public MediaUploadCallback() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UploadMediaSegment.this);
                    return;
                }
                this.f297380b = 1.0f;
                int i3 = UploadMediaSegment.this.f297375e;
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.f297379a = 0;
                        this.f297380b = 1.0f;
                        return;
                    } else {
                        this.f297379a = 95;
                        this.f297380b = 0.05f;
                        return;
                    }
                }
                this.f297379a = 10;
                this.f297380b = 0.85f;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
            
                if (r0 != 2) goto L27;
             */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00f3  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00fd  */
            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onComplete(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                if (UploadMediaSegment.this.isCanceled()) {
                    UploadMediaSegment.this.onCancel();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UploadMediaSegment", 2, "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(UploadMediaSegment.this.f297375e), ", info hash=", Integer.valueOf(UploadMediaSegment.this.f297378i.hashCode()), ", info status=", Integer.valueOf(UploadMediaSegment.this.f297378i.f297417d));
                }
                int i3 = UploadMediaSegment.this.f297375e;
                if (i3 != 0) {
                    if (i3 == 1) {
                        VideoInfo videoInfo = (VideoInfo) UploadMediaSegment.this.f297378i;
                        videoInfo.f297389s = str;
                        if (!TextUtils.isEmpty(videoInfo.f297391u)) {
                            videoInfo.f297389s += "?md5=" + videoInfo.f297391u;
                        }
                        ThreadManager.getUIHandler().post(new Runnable(videoInfo) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ VideoInfo f297383d;

                            {
                                this.f297383d = videoInfo;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MediaUploadCallback.this, (Object) videoInfo);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                UploadMediaSegment.this.f297378i.f297370o = 95;
                                UploadMediaSegment.this.f297378i.f297417d = Integer.MIN_VALUE;
                                XMediaEditor xMediaEditor = (XMediaEditor) UploadMediaSegment.this.f297374d.get();
                                if (xMediaEditor != null) {
                                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(UploadMediaSegment.this.f297378i.f297409a);
                                    if (findViewHolderForLayoutPosition instanceof e.c) {
                                        e.c cVar = (e.c) findViewHolderForLayoutPosition;
                                        if (this.f297383d.f297366k.equals(cVar.C.getTag())) {
                                            ((com.tencent.mobileqq.troop.homework.xmediaeditor.ui.e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) xMediaEditor.getAdapter()).f297359e.a(2)).a(cVar, UploadMediaSegment.this.f297378i, 0);
                                        }
                                    }
                                }
                            }
                        });
                    }
                    if (UploadMediaSegment.this.isCanceled()) {
                        UploadMediaSegment uploadMediaSegment = UploadMediaSegment.this;
                        uploadMediaSegment.notifyResult(uploadMediaSegment.f297378i);
                        return;
                    } else {
                        UploadMediaSegment.this.onCancel();
                        return;
                    }
                }
                UploadMediaSegment.this.f297378i.f297363h = str;
                if (!TextUtils.isEmpty(UploadMediaSegment.this.f297378i.f297362g)) {
                    StringBuilder sb5 = new StringBuilder();
                    ImageInfo imageInfo = UploadMediaSegment.this.f297378i;
                    sb5.append(imageInfo.f297363h);
                    sb5.append("?md5=");
                    sb5.append(UploadMediaSegment.this.f297378i.f297362g);
                    imageInfo.f297363h = sb5.toString();
                }
                if (UploadMediaSegment.this.isCanceled()) {
                }
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            public void onError(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(getClass().getSimpleName(), 2, "upload onError. errorCode=", Integer.valueOf(i3), ", info type=", Integer.valueOf(UploadMediaSegment.this.f297378i.c()), ", mediaType=", Integer.valueOf(UploadMediaSegment.this.f297375e));
                }
                if (UploadMediaSegment.this.f297375e != 2) {
                    UploadMediaSegment.this.notifyError(new Error("-3"));
                } else {
                    UploadMediaSegment uploadMediaSegment = UploadMediaSegment.this;
                    uploadMediaSegment.notifyResult(uploadMediaSegment.f297378i);
                }
                com.tencent.mobileqq.troop.homework.utils.a.b(i3, "\u4e0a\u4f20\u5931\u8d25\uff0c", UploadMediaSegment.this.f297378i);
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            public void onProgress(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    return;
                }
                if (UploadMediaSegment.this.isCanceled()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UploadMediaSegment", 2, "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(i3));
                    }
                    UploadMediaSegment.this.onCancel();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UploadMediaSegment", 2, "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(UploadMediaSegment.this.f297375e), ", info hash=", Integer.valueOf(UploadMediaSegment.this.f297378i.hashCode()), ", info status=", Integer.valueOf(UploadMediaSegment.this.f297378i.f297417d), ", progress=", Integer.valueOf(i3));
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i16 = this.f297379a + ((int) (this.f297380b * i3));
                if (i16 < 100 && currentTimeMillis - this.f297381c > 500) {
                    this.f297381c = currentTimeMillis;
                    ThreadManager.getUIHandler().post(new Runnable(i16) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f297385d;

                        {
                            this.f297385d = i16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MediaUploadCallback.this, i16);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                UploadMediaSegment.this.f297378i.f297370o = this.f297385d;
                                XMediaEditor xMediaEditor = (XMediaEditor) UploadMediaSegment.this.f297374d.get();
                                if (xMediaEditor != null) {
                                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(UploadMediaSegment.this.f297378i.f297409a);
                                    if (findViewHolderForLayoutPosition instanceof ImageItem.e) {
                                        ImageItem.e eVar = (ImageItem.e) findViewHolderForLayoutPosition;
                                        if (UploadMediaSegment.this.f297378i.f297366k.equals(eVar.C.getTag())) {
                                            eVar.C.setVisibility(0);
                                            eVar.C.setDrawStatus(1);
                                            eVar.C.setAnimProgress(UploadMediaSegment.this.f297378i.f297370o, UploadMediaSegment.this.f297378i.f297366k);
                                            return;
                                        }
                                        return;
                                    }
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

        public UploadMediaSegment(int i3, XMediaEditor xMediaEditor, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), xMediaEditor, str);
                return;
            }
            this.f297375e = i3;
            this.f297374d = new WeakReference<>(xMediaEditor);
            this.f297376f = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, ImageInfo imageInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) imageInfo);
                return;
            }
            if (isCanceled()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UploadMediaSegment", 2, "UploadMediaSegment start. mediaType=", Integer.valueOf(this.f297375e), ", info status=", Integer.valueOf(imageInfo.f297417d));
            }
            this.f297378i = imageInfo;
            if (this.f297375e != 1) {
                str = imageInfo.f297364i;
                if (!TextUtils.isEmpty(imageInfo.f297361f)) {
                    imageInfo.f297362g = FileUtils.calcMd5(imageInfo.f297361f);
                }
            } else {
                VideoInfo videoInfo = (VideoInfo) imageInfo;
                String str2 = videoInfo.f297392v;
                if (!TextUtils.isEmpty(videoInfo.f297390t)) {
                    videoInfo.f297391u = FileUtils.calcMd5(videoInfo.f297390t);
                }
                str = str2;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UploadMediaSegment", 2, "UploadMediaSegment start - getFilePath: ", str);
            }
            if (!TextUtils.isEmpty(str)) {
                TroopHomeworkHelper.UploadFileTask l3 = imageInfo.l(str, this.f297376f);
                this.f297377h = l3;
                l3.k(new MediaUploadCallback());
                this.f297377h.j();
                return;
            }
            notifyError(new Error("-2"));
        }

        @Override // com.tribe.async.async.JobSegment, com.tribe.async.reactive.StreamFunction
        protected void onCancel() {
            Error error;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.f297375e));
            }
            TroopHomeworkHelper.UploadFileTask uploadFileTask = this.f297377h;
            if (uploadFileTask != null) {
                uploadFileTask.d();
            }
            int i3 = this.f297375e;
            if (i3 != 1) {
                if (i3 != 2) {
                    error = new Error("c_1001");
                } else {
                    error = new Error("c_2003");
                }
            } else {
                error = new Error("c_2002");
            }
            notifyError(error);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a extends JobSegment<ImageInfo, ImageInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f297387d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f297388e;

        public a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f297387d = i3;
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
            if (QLog.isColorLevel()) {
                QLog.d("CompressImageSegment", 2, "CompressImageSegment start. info status=", Integer.valueOf(imageInfo.f297417d));
            }
            ImageInfo.j();
            try {
                String C = TroopHWJsPlugin.C(-1, imageInfo.f297361f, this.f297387d, null);
                if (FileUtils.fileExistsAndNotEmpty(C)) {
                    imageInfo.f297364i = C;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("CompressImageSegment", 2, "CompressImageSegment failed.");
                    }
                    imageInfo.f297364i = imageInfo.f297361f;
                }
                QLog.d("CompressImageSegment", 2, "CompressImageSegment. in path=", imageInfo.f297361f, ", out path=", imageInfo.f297364i);
                if (!isCanceled()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CompressImageSegment", 2, "CompressImageSegment notifyResult. info status=", Integer.valueOf(imageInfo.f297417d));
                    }
                    notifyResult(imageInfo);
                }
            } catch (Exception e16) {
                QLog.e("CompressImageSegment", 1, "CompressImageSegment Exception: ", e16);
                notifyError(new Error("101"));
            } catch (OutOfMemoryError unused) {
                QLog.e("CompressImageSegment", 1, "CompressImageSegment error. OutOfMemoryError");
                URLDrawable.clearMemoryCache();
                System.gc();
                if (!this.f297388e) {
                    this.f297388e = true;
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
                notifyError(new Error("c_1000"));
            }
        }
    }

    public ImageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static String j() {
        VFSFile vFSFile = new VFSFile(TroopHWJsPlugin.L());
        if (!vFSFile.exists()) {
            vFSFile.mkdirs();
            FileUtils.createFileIfNotExits(TroopHWJsPlugin.L() + ".nomedia");
        }
        return TroopHWJsPlugin.L();
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JSONObject) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "img");
            jSONObject.put("url", this.f297363h);
            jSONObject.put("width", this.f297367l);
            jSONObject.put("height", this.f297368m);
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("ImageInfo", 2, "ImageInfo getContent exception.");
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.f297363h);
    }

    public Stream<ImageInfo> g(XMediaEditor xMediaEditor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Stream) iPatchRedirector.redirect((short) 15, (Object) this, (Object) xMediaEditor);
        }
        this.f297417d = 1;
        Stream map = Stream.of(this).map(new ThreadOffFunction("ImageInfo", 2));
        if (!FileUtils.fileExistsAndNotEmpty(this.f297364i)) {
            map = map.map(new a(this.f297369n));
        }
        if (TextUtils.isEmpty(this.f297363h)) {
            map = map.map(new UploadMediaSegment(0, xMediaEditor, xMediaEditor.r("troopuin")));
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297409a);
        if (findViewHolderForLayoutPosition instanceof ImageItem.e) {
            ImageItem.e eVar = (ImageItem.e) findViewHolderForLayoutPosition;
            if (this.f297366k.equals(eVar.C.getTag())) {
                ((ImageItem) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) xMediaEditor.getAdapter()).f297359e.a(1)).a(eVar, this, 0);
            }
        }
        return map.map(new UIThreadOffFunction(null));
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (FileUtils.fileExistsAndNotEmpty(this.f297361f)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(this.f297361f, options);
            this.f297367l = options.outWidth;
            this.f297368m = options.outHeight;
            int readOrientation = JpegExifReader.readOrientation(this.f297361f);
            if (readOrientation == 6 || readOrientation == 5 || readOrientation == 8 || readOrientation == 7) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageInfo", 2, "calculateLocalImageSize need orientation. before width=", Integer.valueOf(this.f297367l), ", height=", Integer.valueOf(this.f297368m), ", path=", this.f297361f);
                }
                int i3 = this.f297367l;
                this.f297367l = this.f297368m;
                this.f297368m = i3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageInfo", 2, "calculateLocalImageSize result. width=", Integer.valueOf(this.f297367l), ", height=", Integer.valueOf(this.f297368m), ", path=", this.f297361f, ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void i(JSONObject jSONObject) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSONObject);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ImageInfo", 2, "ImageInfo createFrom json: ", jSONObject);
        }
        this.f297410b = jSONObject;
        o(jSONObject.optString("url"));
        this.f297367l = jSONObject.optInt("width");
        this.f297368m = jSONObject.optInt("height");
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (TextUtils.isEmpty(this.f297361f)) {
            return this.f297363h;
        }
        return this.f297361f;
    }

    public TroopHomeworkHelper.UploadFileTask l(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopHomeworkHelper.UploadFileTask) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f297371p == null) {
            this.f297371p = new ConcurrentHashMap<>();
        }
        if (!this.f297371p.containsKey(str)) {
            TroopHomeworkHelper.UploadFileTask uploadFileTask = new TroopHomeworkHelper.UploadFileTask(MobileQQ.sMobileQQ.waitAppRuntime(null), str, str2);
            this.f297371p.put(str, uploadFileTask);
            return uploadFileTask;
        }
        return this.f297371p.get(str);
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return TextUtils.isEmpty(this.f297363h);
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        try {
            this.f297365j = new File(str).toURI().toURL();
            this.f297361f = str;
        } catch (Exception unused) {
            QLog.e("ImageInfo", 1, "setURLFromPath exception.");
        }
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        try {
            this.f297365j = new URL(str);
            this.f297363h = str;
        } catch (Exception unused) {
            QLog.e("ImageInfo", 1, "Image setURLFromContentUrl exception.");
        }
    }

    public ImageInfo(JSONObject jSONObject, String str) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject, (Object) str);
            return;
        }
        i(jSONObject);
        this.f297366k = String.valueOf(hashCode());
        this.f297373r = str;
    }

    public ImageInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        n(str);
        h();
        this.f297366k = String.valueOf(hashCode());
        this.f297373r = str2;
    }
}
