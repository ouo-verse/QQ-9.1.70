package com.tencent.qqnt.compress.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \b2\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\b\u0010'\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/a;", "Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;", "", "progress", "", "onProgress", "onSuccess", "", "e", "onFail", "onCancel", "width", "height", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "getEncodeConfig", "", "a", "Ljava/lang/String;", "getMInputFilePath", "()Ljava/lang/String;", "mInputFilePath", "b", "getMOutputFilePath", "mOutputFilePath", "Lcom/tencent/mobileqq/shortvideo/ac$a;", "c", "Lcom/tencent/mobileqq/shortvideo/ac$a;", "getMCompressInfo", "()Lcom/tencent/mobileqq/shortvideo/ac$a;", "setMCompressInfo", "(Lcom/tencent/mobileqq/shortvideo/ac$a;)V", "mCompressInfo", "Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;", "d", "Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;", "getMListener", "()Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;", "setMListener", "(Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;)V", "mListener", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/ac$a;Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements VideoConverter.Processor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mInputFilePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String mOutputFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ac.a mCompressInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoCompressProcessor.c mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String mInputFilePath, @Nullable String str, @NotNull ac.a mCompressInfo, @Nullable VideoCompressProcessor.c cVar) {
        Intrinsics.checkNotNullParameter(mInputFilePath, "mInputFilePath");
        Intrinsics.checkNotNullParameter(mCompressInfo, "mCompressInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mInputFilePath, str, mCompressInfo, cVar);
            return;
        }
        this.mInputFilePath = mInputFilePath;
        this.mOutputFilePath = str;
        this.mCompressInfo = mCompressInfo;
        this.mListener = cVar;
        if (str != null) {
        } else {
            throw new IllegalArgumentException("null == outputFilePath".toString());
        }
    }

    @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
    @NotNull
    public VideoConverterConfig getEncodeConfig(int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (VideoConverterConfig) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(width), Integer.valueOf(height));
        }
        VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
        videoConverterConfig.output = this.mOutputFilePath;
        ac.a aVar = this.mCompressInfo;
        videoConverterConfig.scaleRate = aVar.f287762e;
        videoConverterConfig.videoFrameRate = (int) aVar.f287761d;
        videoConverterConfig.videoBitRate = (int) aVar.f287760c;
        return videoConverterConfig;
    }

    @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
    public void onCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
        }
        VideoCompressProcessor.c cVar = this.mListener;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.b(3);
        }
    }

    @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
    public void onFail(@NotNull Throwable e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) e16);
            return;
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        QLog.e("HWCompressProcessor", 1, "CompressTask, step: HWCompressProcessor onFailed");
        VideoCompressProcessor.c cVar = this.mListener;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.b(2);
        }
    }

    @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
    public void onProgress(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, progress);
            return;
        }
        VideoCompressProcessor.c cVar = this.mListener;
        if (cVar != null && progress >= 0 && progress <= 10000) {
            Intrinsics.checkNotNull(cVar);
            cVar.a(progress / 10000.0f);
        }
    }

    @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
        }
        VideoCompressProcessor.c cVar = this.mListener;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.b(1);
        }
    }
}
