package com.tencent.qqnt.audio.record.writer;

import android.widget.TextView;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b0\u00101B\u0013\b\u0016\u0012\b\u00102\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b0\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J>\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0019\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u001c\u0010\u001b\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/audio/record/writer/e;", "Lcom/tencent/mobileqq/ptt/d$a;", "", "end", "", "i", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p", "onRecorderPrepare", "", "sliceData", "", "size", "maxAmplitude", "", "time", "onRecorderSilceEnd", "totalTime", "onRecorderEnd", "onInitFailed", "onInitSuccess", "onRecorderAbnormal", "throwable", "onRecorderError", "onRecorderStart", "onBeginReceiveData", "state", "onRecorderVolumeStateChanged", "Ljava/io/ByteArrayOutputStream;", "d", "Ljava/io/ByteArrayOutputStream;", "mBuffer", "e", "Ljava/lang/String;", "mAudioPath", "Ljava/io/File;", "f", "Ljava/io/File;", "mAudioFile", "Ljava/io/FileOutputStream;", h.F, "Ljava/io/FileOutputStream;", "mAudioFileOs", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mInfoView", "<init>", "()V", "view", "(Landroid/widget/TextView;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e implements d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ByteArrayOutputStream mBuffer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAudioPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private File mAudioFile;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FileOutputStream mAudioFileOs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mInfoView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/audio/record/writer/e$a;", "", "", "MAX_BUFFER_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.record.writer.e$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mInfoView;
        Intrinsics.checkNotNull(textView);
        textView.setText("onRecorderAbnormal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mInfoView;
        Intrinsics.checkNotNull(textView);
        textView.setText("onRecorderEnd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mInfoView;
        Intrinsics.checkNotNull(textView);
        textView.setText("onRecorderPrepare");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(e this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mInfoView;
        Intrinsics.checkNotNull(textView);
        textView.setText("onRecorderSliceEnd, size:" + i3);
    }

    private final void i(boolean end) {
        int i3;
        FileOutputStream fileOutputStream;
        String stackTraceToString;
        ByteArrayOutputStream byteArrayOutputStream = this.mBuffer;
        if (byteArrayOutputStream != null) {
            i3 = byteArrayOutputStream.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (this.mAudioFile == null) {
                String str = this.mAudioPath;
                Intrinsics.checkNotNull(str);
                File file = new File(str);
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    Intrinsics.checkNotNull(parentFile);
                    parentFile.mkdirs();
                    try {
                        file.createNewFile();
                    } catch (IOException e16) {
                        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                        QLog.e("AudioFileWriter", 1, "file create error: " + stackTraceToString);
                        String str2 = this.mAudioPath;
                        if (str2 != null) {
                            file = new File(str2);
                        }
                        File parentFile2 = file.getParentFile();
                        if (parentFile2 != null) {
                            parentFile2.mkdirs();
                        }
                        if (end && (fileOutputStream = this.mAudioFileOs) != null) {
                            try {
                                Intrinsics.checkNotNull(fileOutputStream);
                                fileOutputStream.flush();
                                this.mAudioFileOs = null;
                                this.mAudioFile = null;
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                return;
                            } finally {
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.mAudioFileOs = new FileOutputStream(file);
                this.mAudioFile = file;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = this.mBuffer;
            Intrinsics.checkNotNull(byteArrayOutputStream2);
            FileOutputStream fileOutputStream2 = this.mAudioFileOs;
            Intrinsics.checkNotNull(fileOutputStream2);
            byteArrayOutputStream2.writeTo(fileOutputStream2);
        }
        if (end && (fileOutputStream = this.mAudioFileOs) != null) {
            try {
                Intrinsics.checkNotNull(fileOutputStream);
                fileOutputStream.flush();
                this.mAudioFileOs = null;
                this.mAudioFile = null;
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) path, (Object) p16)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) path, (Object) p16);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) path, (Object) p16);
            return;
        }
        QLog.e("AudioFileWriter", 1, "record abnormal: path=" + path + ", param=" + p16);
        TextView textView = this.mInfoView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.qqnt.audio.record.writer.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.e(e.this);
                }
            });
        }
        ByteArrayOutputStream byteArrayOutputStream = this.mBuffer;
        if (byteArrayOutputStream != null) {
            try {
                i(true);
                ByteArrayOutputStream byteArrayOutputStream2 = this.mBuffer;
                Intrinsics.checkNotNull(byteArrayOutputStream2);
                byteArrayOutputStream2.reset();
                this.mBuffer = null;
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(byteArrayOutputStream, null);
            } finally {
            }
        }
        FileOutputStream fileOutputStream = this.mAudioFileOs;
        if (fileOutputStream != null) {
            try {
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        }
        this.mAudioFileOs = null;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(@Nullable String path, @Nullable RecordParams.RecorderParam p16, double totalTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, path, p16, Double.valueOf(totalTime));
            return;
        }
        TextView textView = this.mInfoView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.qqnt.audio.record.writer.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(e.this);
                }
            });
        }
        ByteArrayOutputStream byteArrayOutputStream = this.mBuffer;
        if (byteArrayOutputStream != null) {
            try {
                i(true);
                ByteArrayOutputStream byteArrayOutputStream2 = this.mBuffer;
                Intrinsics.checkNotNull(byteArrayOutputStream2);
                byteArrayOutputStream2.reset();
                this.mBuffer = null;
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(byteArrayOutputStream, null);
            } finally {
            }
        }
        FileOutputStream fileOutputStream = this.mAudioFileOs;
        if (fileOutputStream != null) {
            try {
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        }
        this.mAudioFileOs = null;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(@Nullable String path, @Nullable RecordParams.RecorderParam p16, @Nullable String throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, path, p16, throwable);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path, (Object) p16);
            return;
        }
        if (p16 == null) {
            return;
        }
        TextView textView = this.mInfoView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.qqnt.audio.record.writer.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(e.this);
                }
            });
        }
        this.mAudioPath = path;
        byte[] a16 = RecordParams.a(p16.f307257f, p16.f307255d);
        if (this.mBuffer == null) {
            this.mBuffer = new ByteArrayOutputStream(a16.length << 1);
        }
        ByteArrayOutputStream byteArrayOutputStream = this.mBuffer;
        Intrinsics.checkNotNull(byteArrayOutputStream);
        byteArrayOutputStream.write(a16, 0, a16.length);
        ByteArrayOutputStream byteArrayOutputStream2 = this.mBuffer;
        Intrinsics.checkNotNull(byteArrayOutputStream2);
        if (byteArrayOutputStream2.size() >= 4000) {
            i(false);
            ByteArrayOutputStream byteArrayOutputStream3 = this.mBuffer;
            Intrinsics.checkNotNull(byteArrayOutputStream3);
            byteArrayOutputStream3.reset();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(@Nullable String path, @Nullable byte[] sliceData, final int size, int maxAmplitude, double time, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, path, sliceData, Integer.valueOf(size), Integer.valueOf(maxAmplitude), Double.valueOf(time), p16);
            return;
        }
        TextView textView = this.mInfoView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.tencent.qqnt.audio.record.writer.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(e.this, size);
                }
            });
        }
        if (this.mBuffer == null) {
            this.mBuffer = new ByteArrayOutputStream(size << 1);
        }
        if (sliceData != null) {
            ByteArrayOutputStream byteArrayOutputStream = this.mBuffer;
            Intrinsics.checkNotNull(byteArrayOutputStream);
            byteArrayOutputStream.write(sliceData, 0, size);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = this.mBuffer;
        Intrinsics.checkNotNull(byteArrayOutputStream2);
        if (byteArrayOutputStream2.size() >= 4000) {
            i(false);
            ByteArrayOutputStream byteArrayOutputStream3 = this.mBuffer;
            Intrinsics.checkNotNull(byteArrayOutputStream3);
            byteArrayOutputStream3.reset();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, state);
        }
    }

    public e(@Nullable TextView textView) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mInfoView = textView;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) textView);
        }
    }
}
