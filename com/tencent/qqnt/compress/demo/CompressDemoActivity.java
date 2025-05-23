package com.tencent.qqnt.compress.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.view.SimpleVideoView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.utils.Logger;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\t*\u0002)-\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0003J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0003J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0015R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/compress/demo/CompressDemoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "errorMessage", "", "c3", "", "size", "W2", "Ljava/io/File;", "imageFile", "T2", "V2", "videoFile", "Lcom/tencent/mobileqq/qqnt/videoplay/api/view/SimpleVideoView;", "view", "b3", "U2", "Landroid/content/Context;", "context", "S2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lrw3/a;", "b0", "Lrw3/a;", "binding", "c0", "Ljava/io/File;", "originPic", "d0", "originVideo", "e0", "compressedVideo", "com/tencent/qqnt/compress/demo/CompressDemoActivity$videoProcessor$1", "f0", "Lcom/tencent/qqnt/compress/demo/CompressDemoActivity$videoProcessor$1;", "videoProcessor", "com/tencent/qqnt/compress/demo/CompressDemoActivity$b", "g0", "Lcom/tencent/qqnt/compress/demo/CompressDemoActivity$b;", "convertLogger", "<init>", "()V", "h0", "a", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class CompressDemoActivity extends AppCompatActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private rw3.a binding;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private File originPic;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private File originVideo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private File compressedVideo;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompressDemoActivity$videoProcessor$1 videoProcessor;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b convertLogger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/compress/demo/CompressDemoActivity$a;", "", "", "PICK_IMAGE_REQUEST", "I", "PICK_VIDEO_REQUEST", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.demo.CompressDemoActivity$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/compress/demo/CompressDemoActivity$b", "Lcom/tencent/richmedia/videocompress/utils/Logger;", "", "tag", "msg", "", "e", "", ReportConstant.COSTREPORT_TRANS, "w", "i", "d", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements Logger {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, msg2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void e(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, 1, msg2);
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, msg2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void w(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, msg2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, tag, msg2, tr5);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr5, "tr");
            QLog.e(tag, 1, msg2, tr5);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39290);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.qqnt.compress.demo.CompressDemoActivity$videoProcessor$1] */
    public CompressDemoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.videoProcessor = new VideoConverter.Processor() { // from class: com.tencent.qqnt.compress.demo.CompressDemoActivity$videoProcessor$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CompressDemoActivity.this);
                    }
                }

                @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
                @NotNull
                public VideoConverterConfig getEncodeConfig(int width, int height) {
                    File file;
                    String S2;
                    File file2;
                    File file3;
                    File file4;
                    File file5;
                    File file6;
                    File file7;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (VideoConverterConfig) iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height));
                    }
                    com.tencent.qqnt.compress.video.config.a aVar = com.tencent.qqnt.compress.video.config.a.f355762a;
                    file = CompressDemoActivity.this.originVideo;
                    File file8 = null;
                    if (file == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("originVideo");
                        file = null;
                    }
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "originVideo.absolutePath");
                    VideoConverterConfig first = aVar.a(absolutePath).getFirst();
                    CompressDemoActivity compressDemoActivity = CompressDemoActivity.this;
                    CompressDemoActivity compressDemoActivity2 = CompressDemoActivity.this;
                    S2 = compressDemoActivity2.S2(compressDemoActivity2);
                    file2 = CompressDemoActivity.this.originVideo;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("originVideo");
                        file2 = null;
                    }
                    compressDemoActivity.compressedVideo = new File(S2 + file2.getName());
                    file3 = CompressDemoActivity.this.compressedVideo;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                        file3 = null;
                    }
                    if (file3.exists()) {
                        file7 = CompressDemoActivity.this.compressedVideo;
                        if (file7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                            file7 = null;
                        }
                        file7.delete();
                    } else {
                        file4 = CompressDemoActivity.this.compressedVideo;
                        if (file4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                            file4 = null;
                        }
                        File parentFile = file4.getParentFile();
                        Intrinsics.checkNotNull(parentFile);
                        if (!parentFile.exists()) {
                            file5 = CompressDemoActivity.this.compressedVideo;
                            if (file5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                                file5 = null;
                            }
                            File parentFile2 = file5.getParentFile();
                            Intrinsics.checkNotNull(parentFile2);
                            parentFile2.mkdirs();
                        }
                    }
                    file6 = CompressDemoActivity.this.compressedVideo;
                    if (file6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                    } else {
                        file8 = file6;
                    }
                    first.output = file8.getAbsolutePath();
                    return first;
                }

                @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
                public void onCancel() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this);
                    }
                }

                @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
                public void onFail(@Nullable Throwable p06) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) p06);
                    }
                }

                @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
                public void onProgress(int progress) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, progress);
                    } else if (progress % 500 == 0) {
                        Lifecycle lifecycle = CompressDemoActivity.this.getLifecycle();
                        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getMain(), null, new CompressDemoActivity$videoProcessor$1$onProgress$1(CompressDemoActivity.this, progress, null), 2, null);
                    }
                }

                @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
                public void onSuccess() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this);
                    }
                }
            };
            this.convertLogger = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String S2(Context context) {
        String path = context.getCacheDir().getPath();
        String str = File.separator;
        return path + str + "compressor" + str;
    }

    @SuppressLint({"SetTextI18n"})
    private final void T2(File imageFile) {
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new CompressDemoActivity$compressPic$1(this, imageFile, null), 3, null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void U2(File videoFile) {
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new CompressDemoActivity$compressVideo$1(this, videoFile, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String V2(File imageFile) {
        Bitmap c16 = com.tencent.qqnt.compress.pic.impl.util.a.f355759a.c(imageFile);
        return "width: " + c16.getWidth() + ", height: " + c16.getHeight() + ", size: " + W2(imageFile.length());
    }

    private final String W2(long size) {
        if (size <= 0) {
            return "0";
        }
        double d16 = size;
        int log10 = (int) (Math.log10(d16) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d16 / Math.pow(1024.0d, log10)) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(CompressDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rw3.a aVar = this$0.binding;
        rw3.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f432644l.setVisibility(0);
        rw3.a aVar3 = this$0.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f432647o.setVisibility(4);
        rw3.a aVar4 = this$0.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        aVar4.f432642j.c(false);
        rw3.a aVar5 = this$0.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar5;
        }
        aVar2.f432638f.c(false);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        this$0.startActivityForResult(intent, 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(CompressDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rw3.a aVar = this$0.binding;
        rw3.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f432644l.setVisibility(4);
        rw3.a aVar3 = this$0.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f432647o.setVisibility(0);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        this$0.startActivityForResult(intent, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b3(File videoFile, SimpleVideoView view) {
        com.tencent.mobileqq.qqnt.videoplay.api.param.c cVar = new com.tencent.mobileqq.qqnt.videoplay.api.param.c();
        cVar.l(true);
        cVar.a().h(true);
        cVar.a().l(true);
        cVar.a().g(true);
        cVar.p(videoFile.getAbsolutePath());
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        view.a(this, cVar, LifecycleKt.getCoroutineScope(lifecycle));
        view.b();
    }

    private final void c3(String errorMessage) {
        Toast.makeText(this, errorMessage, 0).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null) {
            rw3.a aVar = null;
            if (requestCode != 1) {
                if (requestCode == 2) {
                    try {
                        c cVar = c.f355724a;
                        Uri data2 = data.getData();
                        Intrinsics.checkNotNull(data2);
                        File b16 = cVar.b(this, data2);
                        this.originVideo = b16;
                        rw3.a aVar2 = this.binding;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            aVar2 = null;
                        }
                        TextView textView = aVar2.f432643k;
                        rw3.a aVar3 = this.binding;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            aVar3 = null;
                        }
                        CharSequence text = aVar3.f432643k.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "binding.originVideoPath.text");
                        textView.setText(text.subSequence(0, 7).toString() + b16.getAbsolutePath());
                        rw3.a aVar4 = this.binding;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            aVar = aVar4;
                        }
                        SimpleVideoView simpleVideoView = aVar.f432642j;
                        Intrinsics.checkNotNullExpressionValue(simpleVideoView, "binding.originVideo");
                        b3(b16, simpleVideoView);
                        U2(b16);
                        return;
                    } catch (IOException e16) {
                        c3("Failed to read video data!");
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                c cVar2 = c.f355724a;
                Uri data3 = data.getData();
                Intrinsics.checkNotNull(data3);
                File b17 = cVar2.b(this, data3);
                this.originPic = b17;
                rw3.a aVar5 = this.binding;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar5 = null;
                }
                TextView textView2 = aVar5.f432641i;
                rw3.a aVar6 = this.binding;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar6 = null;
                }
                CharSequence text2 = aVar6.f432641i.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "binding.originPicPath.text");
                textView2.setText(text2.subSequence(0, 7).toString() + b17.getAbsolutePath());
                rw3.a aVar7 = this.binding;
                if (aVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    aVar = aVar7;
                }
                aVar.f432640h.setImageBitmap(com.tencent.qqnt.compress.pic.impl.util.a.f355759a.c(b17));
                T2(b17);
                return;
            } catch (IOException e17) {
                c3("Failed to read picture data!");
                e17.printStackTrace();
                return;
            }
        }
        c3("Failed to open picture!");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlayDemoActivity", 2, "onCreate");
        }
        rw3.a g16 = rw3.a.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        rw3.a aVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        rw3.a aVar2 = this.binding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar2 = null;
        }
        aVar2.f432645m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.compress.demo.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompressDemoActivity.Y2(CompressDemoActivity.this, view);
            }
        });
        rw3.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar3;
        }
        aVar.f432646n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.compress.demo.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompressDemoActivity.Z2(CompressDemoActivity.this, view);
            }
        });
    }
}
