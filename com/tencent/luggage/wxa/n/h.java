package com.tencent.luggage.wxa.n;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f134994a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f134995b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 48000, -1, -1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f134996c = {64, 112, 128, 192, 224, 256, MsgConstant.KRMFILETHUMBSIZE384, TroopInfo.PAY_PRIVILEGE_ALL, 512, 640, 768, 896, 1024, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, 1280, 1536, 1920, 2048, 2304, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static com.tencent.luggage.wxa.m.j a(byte[] bArr, String str, String str2, com.tencent.luggage.wxa.p.a aVar) {
        com.tencent.luggage.wxa.n0.k kVar = new com.tencent.luggage.wxa.n0.k(bArr);
        kVar.c(60);
        int i3 = f134994a[kVar.a(6)];
        int i16 = f134995b[kVar.a(4)];
        int a16 = kVar.a(5);
        int[] iArr = f134996c;
        int i17 = a16 >= iArr.length ? -1 : (iArr[a16] * 1000) / 2;
        kVar.c(10);
        return com.tencent.luggage.wxa.m.j.a(str, "audio/vnd.dts", null, i17, -1, i3 + (kVar.a(2) > 0 ? 1 : 0), i16, null, aVar, 0, str2);
    }

    public static int b(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int a(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) + 1;
    }
}
