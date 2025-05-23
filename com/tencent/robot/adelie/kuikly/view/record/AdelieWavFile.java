package com.tencent.robot.adelie.kuikly.view.record;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0014H\u0002J0\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/record/AdelieWavFile;", "", "", "filePath", "newExtension", "d", "Ljava/io/File;", "pcmFile", "", "f", "pcmData", "", "sampleRate", "numChannels", "bitsPerSample", "outputFile", "", "i", "value", "e", "", h.F, "pcmForVadPath", "Lcom/tencent/robot/adelie/kuikly/module/n;", "param", "Lkotlin/Function2;", "", "success", "g", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieWavFile {
    /* JADX INFO: Access modifiers changed from: private */
    public final String d(String filePath, String newExtension) {
        String nameWithoutExtension;
        boolean z16;
        File file = new File(filePath);
        nameWithoutExtension = FilesKt__UtilsKt.getNameWithoutExtension(file);
        String parent = file.getParent();
        if (parent == null) {
            parent = "";
        }
        if (parent.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return nameWithoutExtension + "." + newExtension;
        }
        return parent + "/" + nameWithoutExtension + "." + newExtension;
    }

    private final byte[] e(int value) {
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(value).array();
        Intrinsics.checkNotNullExpressionValue(array, "allocate(4).order(ByteOr\u2026AN).putInt(value).array()");
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] f(File pcmFile) {
        FileInputStream fileInputStream = new FileInputStream(pcmFile);
        try {
            byte[] readBytes = ByteStreamsKt.readBytes(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return readBytes;
        } finally {
        }
    }

    private final byte[] h(short value) {
        byte[] array = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(value).array();
        Intrinsics.checkNotNullExpressionValue(array, "allocate(2).order(ByteOr\u2026).putShort(value).array()");
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(byte[] pcmData, int sampleRate, int numChannels, int bitsPerSample, File outputFile) {
        int i3 = ((sampleRate * numChannels) * bitsPerSample) / 8;
        int length = pcmData.length;
        int i16 = length + 36;
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        try {
            Charset charset = Charsets.UTF_8;
            byte[] bytes = "RIFF".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.write(e(i16));
            byte[] bytes2 = "WAVE".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes2);
            byte[] bytes3 = "fmt ".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes3);
            fileOutputStream.write(e(16));
            fileOutputStream.write(h((short) 1));
            fileOutputStream.write(h((short) numChannels));
            fileOutputStream.write(e(sampleRate));
            fileOutputStream.write(e(i3));
            fileOutputStream.write(h((short) ((numChannels * bitsPerSample) / 8)));
            fileOutputStream.write(h((short) bitsPerSample));
            byte[] bytes4 = "data".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes4);
            fileOutputStream.write(e(length));
            fileOutputStream.write(pcmData);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            return true;
        } finally {
        }
    }

    public final void g(@NotNull String pcmForVadPath, @NotNull AdelieTtsRecordParam param, @NotNull Function2<? super Boolean, ? super String, Unit> success) {
        Intrinsics.checkNotNullParameter(pcmForVadPath, "pcmForVadPath");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(success, "success");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieWavFilesaveWav", null, null, null, new AdelieWavFile$saveWav$1(pcmForVadPath, this, param, success, null), 14, null);
        }
    }
}
