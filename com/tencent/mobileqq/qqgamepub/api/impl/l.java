package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, WeakReference<a>> f264476a;

    /* renamed from: b, reason: collision with root package name */
    private static l f264477b;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends AsyncTask<Void, Void, Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f264478a;

        /* renamed from: b, reason: collision with root package name */
        private long f264479b;

        /* renamed from: c, reason: collision with root package name */
        private VideoConverter f264480c;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQAppInterface> f264481d;

        /* renamed from: e, reason: collision with root package name */
        private jh2.a f264482e;

        /* renamed from: f, reason: collision with root package name */
        private String f264483f;

        /* renamed from: g, reason: collision with root package name */
        private String f264484g;

        /* renamed from: h, reason: collision with root package name */
        private String f264485h;

        /* renamed from: i, reason: collision with root package name */
        private String f264486i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqgamepub.api.impl.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public class C8328a implements c {
            static IPatchRedirector $redirector_;

            C8328a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.qqgamepub.api.impl.l.c
            public void a(float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                } else if (a.this.f264482e != null) {
                    a.this.f264482e.a(f16);
                }
            }

            @Override // com.tencent.mobileqq.qqgamepub.api.impl.l.c
            public void b(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    return;
                }
                QLog.d("QQGameVideoCompressProcessor", 1, "hardware compress finish code: " + i3);
            }
        }

        public a(QQAppInterface qQAppInterface, Context context, String str, String str2, jh2.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, str, str2, aVar);
                return;
            }
            this.f264481d = new WeakReference<>(qQAppInterface);
            this.f264478a = new WeakReference<>(context);
            this.f264482e = aVar;
            this.f264484g = str;
            this.f264486i = str2;
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "[CompressTask] mOriginalVideoPath:" + this.f264484g);
            }
        }

        private int b(String str, String str2) {
            boolean z16;
            long j3;
            int i3;
            String str3;
            String str4;
            long currentTimeMillis = System.currentTimeMillis();
            ac.b b16 = ac.b(this.f264481d.get());
            ac.c c16 = ac.c(str);
            boolean isH265FormatShortVideo = ShortVideoUtils.isH265FormatShortVideo(this.f264484g);
            boolean d16 = ac.d(c16, b16);
            if (!isH265FormatShortVideo && !d16) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.d("QQGameVideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + z16 + ",isH265:" + isH265FormatShortVideo + ",calNeedCompress:" + d16);
            jh2.a aVar = this.f264482e;
            if (aVar != null) {
                aVar.b(z16);
            }
            if (!z16 || c16 == null) {
                return -1;
            }
            ac.a a16 = ac.a(c16, b16, false);
            long j16 = a16.f287760c;
            if (isH265FormatShortVideo) {
                j3 = 524288;
            } else {
                j3 = 1048576;
            }
            a16.f287760c = Math.min(j16, j3);
            b bVar = new b(this.f264481d, str, str2, a16, new C8328a());
            VideoConverter videoConverter = new VideoConverter(new br2.a());
            this.f264480c = videoConverter;
            videoConverter.setCompressMode(1);
            int startCompress = this.f264480c.startCompress(this.f264478a.get(), str, bVar, true);
            if (startCompress != 0 && startCompress != -1002) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
                }
                jh2.a aVar2 = this.f264482e;
                if (aVar2 != null) {
                    aVar2.a(1.0f);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameVideoCompressProcessor", 2, "\u4e0d\u652f\u6301\u786c\u4ef6\u538b\u7f29\uff0c\u4e0d\u7ba1\u8f6f\u4ef6\u538b\u7f29\u6210\u529f\u6216\u5931\u8d25\uff0c\u5747\u9ed8\u8ba4\u5c55\u793a\u5b8c\u6574\u547c\u5438\u5708");
                }
                i3 = -1;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
                }
                i3 = 0;
            }
            if (i3 != 0) {
                if (ShortVideoTrimmer.initVideoTrim(this.f264478a.get())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
                    }
                    VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
                    videoConverterConfig.isNeedCompress = true;
                    videoConverterConfig.rotate = String.valueOf(c16.f287779d);
                    videoConverterConfig.srcWidth = c16.f287777b;
                    videoConverterConfig.srcHeight = c16.f287778c;
                    videoConverterConfig.destWidth = a16.f287758a;
                    videoConverterConfig.destHeight = a16.f287759b;
                    videoConverterConfig.destQmax = 25;
                    videoConverterConfig.videoFrameRate = (int) a16.f287761d;
                    videoConverterConfig.videoBitRate = (int) (a16.f287760c / 1024);
                    str3 = str2;
                    i3 = ShortVideoTrimmer.compressVideo(this.f264478a.get(), str, str3, videoConverterConfig);
                    if (i3 == 0) {
                        QLog.d("QQGameVideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
                    } else {
                        QLog.d("QQGameVideoCompressProcessor", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i3);
                    }
                } else {
                    str3 = str2;
                    this.f264485h = this.f264484g;
                    QLog.e("QQGameVideoCompressProcessor", 1, "CompressTask\uff0cstep: ShortVideoTrimmer init failure, ignore compress, uniseq=" + e());
                }
            } else {
                str3 = str2;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i3 + ", uni=" + e());
            }
            if (i3 == 0) {
                str4 = str3;
            } else {
                str4 = this.f264484g;
            }
            this.f264485h = str4;
            long length = new File(str).length();
            long length2 = new File(this.f264485h).length();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis2 + "ms, fileSourceSize=" + length + ", fileTargetSize=" + length2 + ", uniseq=" + e());
            }
            return i3;
        }

        private long e() {
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) voidArr);
            }
            WeakReference<Context> weakReference = this.f264478a;
            if (weakReference != null && weakReference.get() != null) {
                if (!l.e(this.f264484g)) {
                    QLog.e("QQGameVideoCompressProcessor", 1, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.f264484g);
                    return 3;
                }
                String str = this.f264484g;
                String str2 = this.f264486i;
                if (TextUtils.isEmpty(str2)) {
                    return 5;
                }
                if (FileUtils.fileExistsAndNotEmpty(str2)) {
                    this.f264485h = str2;
                    QLog.d("QQGameVideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + str2 + ", uniseq=" + e());
                    jh2.a aVar = this.f264482e;
                    if (aVar != null) {
                        aVar.a(1.0f);
                    }
                } else {
                    int b16 = b(str, str2);
                    long length = new File(str).length();
                    long length2 = new File(str2).length();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer Over fileSourceSize=" + length + ", fileTargetSize=" + length2 + ", uniseq=" + e() + ", videoInput=" + str + ", mVideoPath=" + this.f264485h);
                    }
                    if (b16 == 0) {
                        this.f264485h = str2;
                    } else {
                        this.f264485h = this.f264484g;
                        QLog.d("QQGameVideoCompressProcessor", 2, "compress task failed,use original video");
                    }
                }
                if (isCancelled()) {
                    return 11;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath = " + this.f264485h + ", videoInput = " + str + ", uniseq=" + e());
                }
                if (!TextUtils.isEmpty(this.f264485h) && FileUtils.fileExistsAndNotEmpty(this.f264485h)) {
                    File file = new File(this.f264485h);
                    this.f264479b = file.length();
                    try {
                        this.f264483f = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(file), this.f264479b));
                    } catch (FileNotFoundException e16) {
                        e16.printStackTrace();
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QQGameVideoCompressProcessor", 2, "", e17);
                        }
                    }
                    if (TextUtils.isEmpty(this.f264483f)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QQGameVideoCompressProcessor", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + e());
                        }
                        return 5;
                    }
                    return 1;
                }
                QLog.e("QQGameVideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.f264485h + ", uniseq=" + e());
                return 3;
            }
            return 7;
        }

        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            VideoConverter videoConverter = this.f264480c;
            if (videoConverter != null) {
                return videoConverter.cancelCompress();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
                return;
            }
            super.onPostExecute(num);
            int i3 = 1;
            QLog.d("QQGameVideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + num + ", " + e());
            jh2.a aVar = this.f264482e;
            if (aVar != null) {
                if (num.intValue() != 1) {
                    i3 = 2;
                }
                aVar.onFinish(i3, this.f264484g, this.f264485h);
            } else if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "onPostExecute, mListener is null ," + e());
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQGameVideoCompressProcessor", 2, "CompressTask onCancelled id:" + e() + ", mOriginalVideoPath:" + this.f264484g + ", md5:" + this.f264483f + ", md5:compressPath:" + this.f264485h);
            }
            jh2.a aVar = this.f264482e;
            if (aVar != null) {
                aVar.onFinish(3, this.f264484g, this.f264485h);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onPreExecute();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b implements VideoConverter.Processor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final String f264488a;

        /* renamed from: b, reason: collision with root package name */
        final String f264489b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<QQAppInterface> f264490c;

        /* renamed from: d, reason: collision with root package name */
        ac.a f264491d;

        /* renamed from: e, reason: collision with root package name */
        c f264492e;

        b(WeakReference<QQAppInterface> weakReference, String str, String str2, ac.a aVar, c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, weakReference, str, str2, aVar, cVar);
                return;
            }
            this.f264490c = weakReference;
            this.f264488a = str2;
            this.f264489b = str;
            this.f264492e = cVar;
            if (str2 != null) {
                this.f264491d = aVar;
                return;
            }
            throw new IllegalArgumentException("null == outputFilePath");
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (VideoConverterConfig) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.output = this.f264488a;
            ac.a aVar = this.f264491d;
            videoConverterConfig.scaleRate = aVar.f287762e;
            videoConverterConfig.videoFrameRate = (int) aVar.f287761d;
            videoConverterConfig.videoBitRate = (int) aVar.f287760c;
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
            }
            c cVar = this.f264492e;
            if (cVar != null) {
                cVar.b(3);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) th5);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQGameVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
            }
            c cVar = this.f264492e;
            if (cVar != null) {
                cVar.b(2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + i3);
            }
            c cVar = this.f264492e;
            if (cVar != null && i3 >= 0 && i3 <= 10000) {
                cVar.a(i3 / 10000.0f);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGameVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
            }
            c cVar = this.f264492e;
            if (cVar != null) {
                cVar.b(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface c {
        void a(float f16);

        void b(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74432);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f264476a = new ConcurrentHashMap<>();
            URLDrawableHelper.initVideoAIOSizeByDpc();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static l d() {
        if (f264477b == null) {
            f264477b = new l();
        }
        return f264477b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        a c16 = c(j3);
        if (c16 != null && c16.getStatus() != AsyncTask.Status.FINISHED && !c16.isCancelled()) {
            c16.cancel(true);
        }
    }

    public a c(long j3) {
        WeakReference<a> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        ConcurrentHashMap<Long, WeakReference<a>> concurrentHashMap = f264476a;
        if (concurrentHashMap.containsKey(Long.valueOf(j3)) && (weakReference = concurrentHashMap.get(Long.valueOf(j3))) != null) {
            return weakReference.get();
        }
        return null;
    }

    public void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        a c16 = c(j3);
        if (c16 != null) {
            c16.d();
        }
        f264476a.remove(Long.valueOf(j3));
    }

    public void g(long j3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), aVar);
        } else if (aVar != null) {
            WeakReference<a> weakReference = new WeakReference<>(aVar);
            f264476a.put(Long.valueOf(j3), weakReference);
            Utils.executeAsyncTaskOnSerialExcuter(weakReference.get(), new Void[0]);
        }
    }
}
