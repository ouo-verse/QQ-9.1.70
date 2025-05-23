package com.tencent.mobileqq.shortvideo.hwcodec;

import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements e, d {

    /* renamed from: f, reason: collision with root package name */
    private String f287999f;

    /* renamed from: h, reason: collision with root package name */
    private String f288000h;

    /* renamed from: i, reason: collision with root package name */
    private VideoSourceHelper f288001i;

    /* renamed from: d, reason: collision with root package name */
    private final String f287997d = "HwEncodeHelper";

    /* renamed from: e, reason: collision with root package name */
    private int f287998e = 0;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f288002m = null;
    private byte[] C = null;
    private long[] D = new long[1];
    private SVHwEncoder.a E = new SVHwEncoder.a();
    private SVHwEncoder.a F = new SVHwEncoder.a();
    private boolean G = false;
    private boolean H = false;

    public a(String str, String str2, String str3) {
        this.f287999f = str3;
        this.f288001i = new VideoSourceHelper(str, str2);
    }

    private boolean d() {
        int[] bufferSize = this.f288001i.getBufferSize();
        if (bufferSize != null && bufferSize.length >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d("HwEncodeHelper", 4, "initMediaBuffer videosize=" + bufferSize[0] + ", audiosize=" + bufferSize[1]);
            }
            try {
                if (this.f288002m == null) {
                    this.f288002m = new byte[bufferSize[0]];
                }
                if (this.C == null) {
                    this.C = new byte[bufferSize[1]];
                }
                return true;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public String c() {
        return this.f288000h;
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.d
    public SVHwEncoder.a e() {
        VideoSourceHelper videoSourceHelper = this.f288001i;
        if (videoSourceHelper != null && !this.G) {
            int nextAudioFrame = videoSourceHelper.getNextAudioFrame(this.C);
            SVHwEncoder.a aVar = this.F;
            aVar.f287989a = this.C;
            boolean z16 = false;
            aVar.f287990b = 0;
            aVar.f287991c = nextAudioFrame;
            aVar.f287994f = false;
            if (nextAudioFrame <= 0) {
                z16 = true;
            }
            aVar.f287993e = z16;
            aVar.f287996h = -1;
            aVar.f287992d = -1;
            aVar.f287995g = -1.0f;
            if (QLog.isColorLevel()) {
                QLog.d("HwEncodeHelper", 4, "getAudioFrame() bufferSize=" + this.C.length + ", readSize=" + nextAudioFrame);
            }
            SVHwEncoder.a aVar2 = this.F;
            this.G = aVar2.f287993e;
            return aVar2;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void g(String str, int i3, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("HwEncodeHelper", 4, "svMergeOK() path=" + str + ", totalTime=" + i3 + " mergetime=" + j3 + " us");
        }
        this.f288000h = str;
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.d
    public SVHwEncoder.a j(int i3) {
        VideoSourceHelper videoSourceHelper = this.f288001i;
        if (videoSourceHelper != null && !this.H) {
            int nextVideoFrame = videoSourceHelper.getNextVideoFrame(this.f288002m, this.D, i3);
            SVHwEncoder.a aVar = this.E;
            aVar.f287989a = this.f288002m;
            aVar.f287990b = 0;
            aVar.f287991c = nextVideoFrame;
            boolean z16 = true;
            aVar.f287994f = true;
            if (nextVideoFrame > 0) {
                z16 = false;
            }
            aVar.f287993e = z16;
            aVar.f287992d = this.D[0];
            aVar.f287996h = -1;
            aVar.f287995g = -1.0f;
            if (QLog.isColorLevel()) {
                QLog.d("HwEncodeHelper", 4, "getVideoFrame() bufferSize=" + this.f288002m.length + ", readSize=" + nextVideoFrame + ", frametime=" + this.D[0]);
            }
            SVHwEncoder.a aVar2 = this.E;
            this.H = aVar2.f287993e;
            return aVar2;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void k(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("HwEncodeHelper", 4, "svErrorOcured() code=" + i3 + ", subcode=" + i16);
        }
        this.f287998e = -1;
    }

    public int l() {
        int i3;
        if (!b.a()) {
            return -1;
        }
        if (this.f288001i.initHelperParam() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("HwEncodeHelper", 4, "initHelperParam error");
            }
            return -1;
        }
        if (!d()) {
            if (QLog.isColorLevel()) {
                QLog.d("HwEncodeHelper", 4, "initMediaBuffer error");
            }
            this.f288001i.closeHelper();
            return -1;
        }
        SVHwEncoder sVHwEncoder = new SVHwEncoder();
        int i16 = 2;
        if (CodecParam.mAudioChannel == 16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (CodecParam.mAudioFormat != 2) {
            i16 = 1;
        }
        int i17 = CodecParam.mAudioSampleRate;
        sVHwEncoder.H(i17, i3, i17 * i3 * i16 * 8, i16);
        int[] sourceVideoParam = this.f288001i.getSourceVideoParam();
        sVHwEncoder.I(this.f287999f, sourceVideoParam[0], sourceVideoParam[1]);
        boolean R = sVHwEncoder.R(CodecParam.mRecordFrames, CodecParam.mRecordTime, this.f288001i.mOrientationDegree);
        if (QLog.isColorLevel()) {
            QLog.d("HwEncodeHelper", 4, "startHwEncode mRecordFrames=" + CodecParam.mRecordFrames + ", mRecordTime=" + CodecParam.mRecordTime + " successCode=" + R);
        }
        if (!R) {
            this.f288001i.closeHelper();
            return -1;
        }
        sVHwEncoder.S(this, this, true);
        this.f288001i.closeHelper();
        return this.f287998e;
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void f() {
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void h() {
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void a(int i3) {
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void b(String str, int i3, int i16, String str2) {
    }

    @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
    public void i(String str, int i3, int i16, int i17) {
    }
}
