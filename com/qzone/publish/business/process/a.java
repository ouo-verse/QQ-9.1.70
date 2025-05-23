package com.qzone.publish.business.process;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b$\u0018\u0000 /2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010+\u00a8\u00060"}, d2 = {"Lcom/qzone/publish/business/process/a;", "Lcom/qzone/publish/business/process/base/c;", "", "c", "g", "", "b", h.F, "d", "f", "", "mVideoPath", "", "a", "e", "toString", "I", "getVideoMaxBitrate", "()I", "setVideoMaxBitrate", "(I)V", "videoMaxBitrate", "getVideoHevcMaxBitrate", "setVideoHevcMaxBitrate", "videoHevcMaxBitrate", "getMVideoResolution", "setMVideoResolution", "mVideoResolution", "getFrameRate", "setFrameRate", "frameRate", "getIFrameInterval", "setIFrameInterval", QzoneConfig.SECONDARY_VIDEO_IFRAME_INTERVAL, "Z", "getEnableH265Encoder", "()Z", "setEnableH265Encoder", "(Z)V", "enableH265Encoder", "getEnableOriginVideo", "setEnableOriginVideo", "enableOriginVideo", "Ljava/lang/String;", "mOutVideoPath", "<init>", "()V", "i", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements com.qzone.publish.business.process.base.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int videoMaxBitrate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int videoHevcMaxBitrate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mVideoResolution;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int frameRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableH265Encoder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int iFrameInterval = 1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableOriginVideo = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String mOutVideoPath = "";

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0040, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        Object orNull;
        Object orNull2;
        Object orNull3;
        Integer intOrNull;
        Integer intOrNull2;
        Float floatOrNull;
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_INTEGRATION_COMPRESS_PARAM, "1.5|30|720");
        try {
            Intrinsics.checkNotNullExpressionValue(config, "config");
            List<String> split = new Regex("\\|").split(config, 0);
            orNull = CollectionsKt___CollectionsKt.getOrNull(split, 0);
            String str = (String) orNull;
            float floatValue = (str == null || floatOrNull == null) ? 1.5f : floatOrNull.floatValue();
            this.videoMaxBitrate = (int) (floatValue * 1048576);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(split, 1);
            String str2 = (String) orNull2;
            int intValue = (str2 == null || intOrNull2 == null) ? 30 : intOrNull2.intValue();
            this.frameRate = intValue;
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(split, 2);
            String str3 = (String) orNull3;
            int intValue2 = (str3 == null || intOrNull == null) ? 720 : intOrNull.intValue();
            this.mVideoResolution = intValue2;
            int parseDouble = (int) (Double.parseDouble(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_Integration_hevc_bitrate", "1.5")) * 1048576);
            this.videoHevcMaxBitrate = parseDouble;
            QLog.d("QZQQVideoVideoParams", 1, "init, videoMaxBitrate:" + this.videoMaxBitrate + ",videoHevcMaxBitrate:" + parseDouble + ", frameRate:" + this.frameRate + ", mVideoResolution:" + this.mVideoResolution);
        } catch (Exception e16) {
            QLog.e("QZQQVideoVideoParams", 1, "init, error ", e16);
            this.videoMaxBitrate = 1572864;
            this.videoHevcMaxBitrate = 1572864;
            this.frameRate = 30;
            this.mVideoResolution = 720;
        }
    }

    @Override // com.qzone.publish.business.process.base.c
    public int c() {
        if (b()) {
            return this.videoHevcMaxBitrate;
        }
        return this.videoMaxBitrate;
    }

    @Override // com.qzone.publish.business.process.base.c
    /* renamed from: d, reason: from getter */
    public boolean getEnableOriginVideo() {
        return this.enableOriginVideo;
    }

    @Override // com.qzone.publish.business.process.base.c
    /* renamed from: e, reason: from getter */
    public String getMOutVideoPath() {
        return this.mOutVideoPath;
    }

    @Override // com.qzone.publish.business.process.base.c
    /* renamed from: f, reason: from getter */
    public int getMVideoResolution() {
        return this.mVideoResolution;
    }

    @Override // com.qzone.publish.business.process.base.c
    /* renamed from: g, reason: from getter */
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // com.qzone.publish.business.process.base.c
    /* renamed from: h, reason: from getter */
    public int getIFrameInterval() {
        return this.iFrameInterval;
    }

    public String toString() {
        return "QZQQVideoVideoParams{videoMaxBitrate=" + this.videoMaxBitrate + ", videoResolution=" + getMVideoResolution() + ", frameRate=" + this.frameRate + ", iFrameInterval=" + this.iFrameInterval + ", enableH265Encoder=" + this.enableH265Encoder + ", enableOriginVideo=" + this.enableOriginVideo + ", mOutVideoPath=" + this.mOutVideoPath + "}";
    }

    @Override // com.qzone.publish.business.process.base.c
    public boolean b() {
        this.enableH265Encoder = true;
        return true;
    }

    @Override // com.qzone.publish.business.process.base.c
    public void a(String mVideoPath) {
        if (mVideoPath == null) {
            mVideoPath = "";
        }
        this.mOutVideoPath = mVideoPath;
    }
}
