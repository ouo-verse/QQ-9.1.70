package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0004\u0010\u0014\u0018$B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator;", "", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/e;", "tavCutSession", "", "g", "Lcom/tencent/tav/coremedia/CMTime;", "requestTime", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "listener", "d", "e", "", "stopTask", "f", "", "a", "Ljava/lang/String;", "TAG", "Lbe4/b;", "b", "Lbe4/b;", "iCoverProvider", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$ImageGeneratorThread;", "c", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$ImageGeneratorThread;", "generatorThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lcom/tencent/tavcut/composition/model/component/Size;", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "maximumSize", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/e;Lcom/tencent/tavcut/composition/model/component/Size;)V", "ImageGeneratorThread", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TavImageGenerator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private be4.b iCoverProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ImageGeneratorThread generatorThread;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Size size;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$b;", "", "Lcom/tencent/tav/coremedia/CMTime;", "a", "Lcom/tencent/tav/coremedia/CMTime;", "b", "()Lcom/tencent/tav/coremedia/CMTime;", "requestTime", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "()Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "listener", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final CMTime requestTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final c listener;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TavImageGenerator f347938c;

        public b(TavImageGenerator tavImageGenerator, CMTime requestTime, c cVar) {
            Intrinsics.checkNotNullParameter(requestTime, "requestTime");
            this.f347938c = tavImageGenerator;
            this.requestTime = requestTime;
            this.listener = cVar;
        }

        /* renamed from: a, reason: from getter */
        public final c getListener() {
            return this.listener;
        }

        /* renamed from: b, reason: from getter */
        public final CMTime getRequestTime() {
            return this.requestTime;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "", "Lcom/tencent/tav/coremedia/CMTime;", "requestedTime", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c {
        void a(CMTime requestedTime, Bitmap bitmap);
    }

    public TavImageGenerator(e tavCutSession, Size size) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.TAG = "TavImageGenerator@" + Integer.toHexString(hashCode());
        Size size2 = new Size(720, 1280, null, 4, null);
        this.size = size2;
        this.size = size == null ? size2 : size;
        ImageGeneratorThread imageGeneratorThread = new ImageGeneratorThread("image_generator");
        this.generatorThread = imageGeneratorThread;
        imageGeneratorThread.start();
        this.handler = imageGeneratorThread.e();
        g(tavCutSession);
    }

    public final void d(CMTime requestTime, c listener) {
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = new b(this, requestTime, listener);
        this.handler.sendMessage(obtain);
    }

    public final void e() {
        ee4.b.a(this.TAG, "release() called");
        f(false);
    }

    public final void f(boolean stopTask) {
        be4.b bVar = this.iCoverProvider;
        if (bVar != null) {
            bVar.release();
        }
        this.iCoverProvider = null;
        this.generatorThread.release(stopTask);
    }

    public final void g(e tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        RenderModel renderModel = tavCutSession.getCutSession().getRenderModel();
        if (renderModel != null) {
            this.iCoverProvider = od4.b.e(od4.b.f422509e, renderModel, this.size, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$ImageGeneratorThread;", "Landroid/os/HandlerThread;", "Landroid/os/Handler$Callback;", "Landroid/os/Message;", "msg", "", "f", "Lcom/tencent/tav/coremedia/CMTime;", "requestedTime", "Landroid/graphics/Bitmap;", "d", "g", "Landroid/os/Handler;", "e", "", "handleMessage", "stopTask", "release", "", "name", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator;Ljava/lang/String;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class ImageGeneratorThread extends BaseHandlerThread implements Handler.Callback {
        public ImageGeneratorThread(String str) {
            super(str);
        }

        private final Bitmap d(CMTime requestedTime) throws Exception {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                return g(requestedTime);
            }
            throw new Exception("cannot process in the main thread");
        }

        private final void f(Message msg2) {
            Bitmap bitmap;
            Object obj = msg2.obj;
            if (obj instanceof b) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.TavImageGenerator.CoverMsg");
                b bVar = (b) obj;
                try {
                    bitmap = d(bVar.getRequestTime());
                } catch (Exception e16) {
                    ee4.b.c(TavImageGenerator.this.TAG, "doGeneratorCover: ", e16);
                    bitmap = null;
                }
                if (bVar.getListener() != null) {
                    bVar.getListener().a(bVar.getRequestTime(), bitmap);
                }
            }
        }

        private final Bitmap g(CMTime requestedTime) {
            be4.b bVar = TavImageGenerator.this.iCoverProvider;
            if (bVar != null) {
                return bVar.getCoverAtTime(requestedTime.getTimeUs() / 1000);
            }
            return null;
        }

        public final Handler e() {
            return new Handler(getLooper(), this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 == 1) {
                f(msg2);
                return false;
            }
            if (i3 != 2) {
                return false;
            }
            TavImageGenerator.this.handler.removeCallbacksAndMessages(null);
            return false;
        }

        public final void release(boolean stopTask) {
            if (stopTask) {
                TavImageGenerator.this.handler.removeCallbacksAndMessages(null);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            TavImageGenerator.this.handler.sendMessage(obtain);
        }
    }
}
