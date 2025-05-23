package com.tencent.zplan.encode.encode;

import android.media.MediaCodec;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/zplan/encode/encode/e;", "Lcom/tencent/zplan/encode/encode/c;", "", "D", "i", "Ljava/nio/ByteBuffer;", "outputBuffer", "Landroid/media/MediaCodec$BufferInfo;", "outputBufferInfo", "", "outputBufferIndex", "Lcom/tencent/zplan/encode/encode/a;", DomainData.DOMAIN_NAME, "Landroid/media/MediaCodec;", "mediaCodec", "Lcom/tencent/zplan/encode/encode/f;", "frameInfo", "", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lqx4/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lqx4/b;", "encodeSurfaceHolder", "Lqx4/c;", "r", "Lqx4/c;", "drawer", "Lcom/tencent/zplan/encode/utils/a;", "encodeConfigInfo", "Lcom/tencent/zplan/encode/b;", "listener", "", "tempPath", "<init>", "(Landroid/media/MediaCodec;Lcom/tencent/zplan/encode/utils/a;Lcom/tencent/zplan/encode/b;Ljava/lang/String;)V", ReportConstant.COSTREPORT_PREFIX, "a", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class e extends c {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private qx4.b encodeSurfaceHolder;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private qx4.c drawer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MediaCodec mediaCodec, com.tencent.zplan.encode.utils.a encodeConfigInfo, com.tencent.zplan.encode.b bVar, String tempPath) {
        super(mediaCodec, encodeConfigInfo, bVar, tempPath);
        Intrinsics.checkParameterIsNotNull(mediaCodec, "mediaCodec");
        Intrinsics.checkParameterIsNotNull(encodeConfigInfo, "encodeConfigInfo");
        Intrinsics.checkParameterIsNotNull(tempPath, "tempPath");
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void A() {
        super.A();
        qx4.c cVar = this.drawer;
        if (cVar != null) {
            cVar.release();
        }
        this.drawer = null;
        qx4.b bVar = this.encodeSurfaceHolder;
        if (bVar != null) {
            bVar.d();
        }
        this.encodeSurfaceHolder = null;
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void D() {
        qx4.c dVar;
        Surface createInputSurface = getMediaCodec().createInputSurface();
        Intrinsics.checkExpressionValueIsNotNull(createInputSurface, "mediaCodec.createInputSurface()");
        this.encodeSurfaceHolder = new qx4.b(createInputSurface);
        if (getEncodeConfigInfo().f385476n == 1) {
            dVar = new qx4.a();
        } else {
            dVar = new qx4.d();
        }
        this.drawer = dVar;
        super.D();
    }

    @Override // com.tencent.zplan.encode.encode.c
    public void i() {
        qx4.b bVar = this.encodeSurfaceHolder;
        if (bVar != null) {
            bVar.c();
        }
        qx4.c cVar = this.drawer;
        if (cVar == null) {
            return;
        }
        cVar.b();
    }

    @Override // com.tencent.zplan.encode.encode.c
    public a n(ByteBuffer outputBuffer, MediaCodec.BufferInfo outputBufferInfo, int outputBufferIndex) {
        Intrinsics.checkParameterIsNotNull(outputBuffer, "outputBuffer");
        Intrinsics.checkParameterIsNotNull(outputBufferInfo, "outputBufferInfo");
        a aVar = new a();
        outputBuffer.position(outputBufferInfo.offset);
        outputBuffer.limit(outputBufferInfo.offset + outputBufferInfo.size);
        aVar.f385346a = outputBuffer;
        aVar.f385347b = outputBufferIndex;
        aVar.f385348c = outputBufferInfo;
        return aVar;
    }

    @Override // com.tencent.zplan.encode.encode.c
    public boolean u(MediaCodec mediaCodec, f frameInfo) {
        Intrinsics.checkParameterIsNotNull(mediaCodec, "mediaCodec");
        if (!getEncodeConfigInfo().f385463a) {
            return false;
        }
        if ((frameInfo == null ? null : frameInfo.f385371a) == null) {
            mediaCodec.signalEndOfInputStream();
            return true;
        }
        try {
            qx4.c cVar = this.drawer;
            if (cVar != null) {
                byte[] bArr = frameInfo.f385371a;
                Intrinsics.checkExpressionValueIsNotNull(bArr, "frameInfo.data");
                cVar.a(bArr, getEncodeConfigInfo().f385466d, getEncodeConfigInfo().f385467e);
            }
            qx4.b bVar = this.encodeSurfaceHolder;
            if (bVar != null) {
                bVar.e(frameInfo.f385373c * 1000);
            }
            qx4.b bVar2 = this.encodeSurfaceHolder;
            if (bVar2 != null) {
                bVar2.f();
            }
            return true;
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Surface_Encoder", 1, "inputDataIntoCodec throw ", th5);
            return false;
        }
    }
}
