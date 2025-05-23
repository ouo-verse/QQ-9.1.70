package au;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends d {

    /* renamed from: c, reason: collision with root package name */
    public String f26945c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f26946d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f26947e = Integer.MAX_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public float f26948f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    public int f26949g = 0;

    /* renamed from: h, reason: collision with root package name */
    public RandomAccessFile f26950h = null;

    /* renamed from: i, reason: collision with root package name */
    public long f26951i = 0;

    /* renamed from: j, reason: collision with root package name */
    public MediaExtractor f26952j = null;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.BufferInfo f26953k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f26954l = 0;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f26955m = null;

    public String toString() {
        return "FileInfo{filename = " + this.f26945c + ", fileType = " + this.f26946d + ", volumeScale = " + this.f26948f + ", mixCnt = " + this.f26947e + ", channelNum = " + this.f26944b + "}";
    }
}
