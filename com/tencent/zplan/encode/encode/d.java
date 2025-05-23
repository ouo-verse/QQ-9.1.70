package com.tencent.zplan.encode.encode;

import android.media.MediaCodec;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/encode/encode/d;", "Lcom/tencent/zplan/encode/encode/c;", "Landroid/media/MediaCodec;", "mediaCodec", "Lcom/tencent/zplan/encode/encode/a;", "G", "", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/ByteBuffer;", "outputBuffer", "Landroid/media/MediaCodec$BufferInfo;", "outputBufferInfo", "", "outputBufferIndex", DomainData.DOMAIN_NAME, "Lcom/tencent/zplan/encode/encode/f;", "frameInfo", "", "u", "", "data", "dataSize", "frameIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "J", "lastPts", "Lcom/tencent/zplan/encode/utils/a;", "encodeConfigInfo", "Lcom/tencent/zplan/encode/b;", "listener", "", "tempPath", "<init>", "(Landroid/media/MediaCodec;Lcom/tencent/zplan/encode/utils/a;Lcom/tencent/zplan/encode/b;Ljava/lang/String;)V", "r", "a", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class d extends c {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long lastPts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MediaCodec mediaCodec, com.tencent.zplan.encode.utils.a encodeConfigInfo, com.tencent.zplan.encode.b bVar, String tempPath) {
        super(mediaCodec, encodeConfigInfo, bVar, tempPath);
        Intrinsics.checkParameterIsNotNull(mediaCodec, "mediaCodec");
        Intrinsics.checkParameterIsNotNull(encodeConfigInfo, "encodeConfigInfo");
        Intrinsics.checkParameterIsNotNull(tempPath, "tempPath");
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void A() {
        super.A();
        com.tencent.zplan.encode.utils.d.c();
        com.tencent.zplan.encode.utils.e.f385508a.b();
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void D() {
        super.D();
        com.tencent.zplan.encode.utils.d.f(getEncodeConfigInfo());
        com.tencent.zplan.encode.utils.e.f385508a.d(getEncodeConfigInfo().f385467e * getEncodeConfigInfo().f385466d * 4 * 2);
    }

    @Override // com.tencent.zplan.encode.encode.c
    public a n(ByteBuffer outputBuffer, MediaCodec.BufferInfo outputBufferInfo, int outputBufferIndex) {
        Intrinsics.checkParameterIsNotNull(outputBuffer, "outputBuffer");
        Intrinsics.checkParameterIsNotNull(outputBufferInfo, "outputBufferInfo");
        a aVar = new a();
        aVar.f385346a = outputBuffer;
        aVar.f385347b = outputBufferIndex;
        aVar.f385348c = outputBufferInfo;
        return aVar;
    }

    @Override // com.tencent.zplan.encode.encode.c
    public byte[] o(byte[] data) {
        return com.tencent.zplan.encode.utils.d.d(getEncodeConfigInfo(), data, getEncodeConfigInfo().f385471i, getEncodeConfigInfo().f385476n == 1 ? 2 : 1);
    }

    @Override // com.tencent.zplan.encode.encode.c
    public boolean u(MediaCodec mediaCodec, f frameInfo) {
        byte[] bArr;
        long j3;
        int i3;
        int i16;
        Object valueOf;
        Intrinsics.checkParameterIsNotNull(mediaCodec, "mediaCodec");
        a G = G(mediaCodec);
        com.tencent.zplan.encode.d.a("SR_MP4_Buffer_Encoder", 2, Intrinsics.stringPlus("inputDataIntoCodec bufferInfo:", G));
        if (G == null) {
            return false;
        }
        if (getEncodeConfigInfo().f385463a && frameInfo != null) {
            byte[] bArr2 = frameInfo.f385371a;
            if (bArr2 == null) {
                com.tencent.zplan.encode.d.b("SR_MP4_Buffer_Encoder", 1, Intrinsics.stringPlus("covert error, skip, ", Integer.valueOf(frameInfo.f385374d)));
                return false;
            }
            frameInfo.f385372b = bArr2.length;
        }
        G.f385346a.clear();
        if (com.tencent.zplan.encode.d.f() && getEncodeConfigInfo().f385463a && frameInfo != null) {
            com.tencent.zplan.encode.d.a("SR_MP4_Buffer_Encoder", 1, "videoBuffer, " + frameInfo.f385371a.length + ", " + G.f385346a.capacity() + ", " + G.f385346a.limit() + ", " + G.f385346a.position());
        }
        try {
            if (frameInfo != null) {
                G.f385346a.put(frameInfo.f385371a);
                long j16 = frameInfo.f385373c;
                this.lastPts = j16;
                j3 = j16;
                i3 = 0;
                i16 = frameInfo.f385372b;
            } else {
                j3 = this.lastPts;
                i3 = 4;
                i16 = 0;
            }
            if (com.tencent.zplan.encode.d.f()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("queueInput, isVideo:");
                sb5.append(getEncodeConfigInfo().f385463a);
                sb5.append(", pts:");
                sb5.append(j3);
                sb5.append(", index:");
                if (frameInfo == null) {
                    valueOf = "-1";
                } else {
                    valueOf = Integer.valueOf(frameInfo.f385374d);
                }
                sb5.append(valueOf);
                sb5.append(", size:");
                sb5.append(i16);
                sb5.append(", endFlag:");
                sb5.append(i3);
                sb5.append(", config:");
                sb5.append(getEncodeConfigInfo());
                com.tencent.zplan.encode.d.a("SR_MP4_Buffer_Encoder", 1, sb5.toString());
            }
            try {
                mediaCodec.queueInputBuffer(G.f385347b, 0, i16, j3, i3);
                return true;
            } catch (Throwable th5) {
                com.tencent.zplan.encode.d.c("SR_MP4_Buffer_Encoder", 1, "queueInputBuffer error: ", th5);
                return false;
            }
        } catch (Throwable unused) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("error: ");
            sb6.append(getEncodeConfigInfo().f385463a);
            sb6.append(", ");
            Integer num = null;
            if (frameInfo != null && (bArr = frameInfo.f385371a) != null) {
                num = Integer.valueOf(bArr.length);
            }
            sb6.append(num);
            sb6.append(", ");
            sb6.append(G.f385346a.limit());
            sb6.append(", ");
            sb6.append(G.f385346a.position());
            com.tencent.zplan.encode.d.b("SR_MP4_Buffer_Encoder", 1, sb6.toString());
            return false;
        }
    }

    private final a G(MediaCodec mediaCodec) {
        ByteBuffer inputBuffer;
        try {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(5000L);
            if (dequeueInputBuffer < 0 || (inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer)) == null) {
                return null;
            }
            a aVar = new a();
            aVar.f385346a = inputBuffer;
            aVar.f385347b = dequeueInputBuffer;
            return aVar;
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Buffer_Encoder", 1, "getAvailableInputByteBuffer error, ", th5);
            return null;
        }
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void z(byte[] data, int dataSize, int frameIndex) {
        if (data != null && getEncodeConfigInfo().f385476n == 1) {
            byte[] a16 = com.tencent.zplan.encode.utils.e.f385508a.a(data, getEncodeConfigInfo().f385467e, getEncodeConfigInfo().f385466d);
            super.z(a16, a16.length, frameIndex);
        } else {
            super.z(data, dataSize, frameIndex);
        }
    }
}
