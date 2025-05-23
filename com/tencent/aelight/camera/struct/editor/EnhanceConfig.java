package com.tencent.aelight.camera.struct.editor;

import com.heytap.databaseengine.model.UserInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002\u0004-BO\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u001b\u0010\u000bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0010\u0010 \"\u0004\b!\u0010\"R*\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010&\u001a\u0004\b\u001e\u0010'\"\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig;", "", "", "b", "a", "", h.F, "I", "getEnableHDR", "()I", "setEnableHDR", "(I)V", "enableHDR", "getHdrType", "setHdrType", "hdrType", "c", "getEnableDeLogo", "setEnableDeLogo", "enableDeLogo", "d", "e", "setExtraMaxDuration", "extraMaxDuration", "f", "setMaxDelogoFrameRate", "maxDelogoFrameRate", "setDeblurAverageScore", "deblurAverageScore", "", "g", UserInfo.SEX_FEMALE, "()F", "setBlurBias", "(F)V", "blurBias", "", "Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig$SharpenStrength;", "Ljava/util/List;", "()Ljava/util/List;", "i", "(Ljava/util/List;)V", "sharpenStrengths", "<init>", "(IIIIIIFLjava/util/List;)V", "SharpenStrength", "aelight-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class EnhanceConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int enableHDR;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int hdrType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int enableDeLogo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int extraMaxDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxDelogoFrameRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int deblurAverageScore;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float blurBias;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<SharpenStrength> sharpenStrengths;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e\u00a8\u00060"}, d2 = {"Lcom/tencent/aelight/camera/struct/editor/EnhanceConfig$SharpenStrength;", "Ljava/io/Serializable;", "()V", "deblurScoreEnd", "", "getDeblurScoreEnd", "()F", "setDeblurScoreEnd", "(F)V", "deblurScoreStart", "", "getDeblurScoreStart", "()I", "setDeblurScoreStart", "(I)V", "lowDeviceLevel", "getLowDeviceLevel", "setLowDeviceLevel", "scaleEnd", "getScaleEnd", "setScaleEnd", "scaleStart", "getScaleStart", "setScaleStart", "seq", "getSeq", "setSeq", "sharpenType", "getSharpenType", "setSharpenType", "sizeEndHeight", "getSizeEndHeight", "setSizeEndHeight", "sizeEndWidth", "getSizeEndWidth", "setSizeEndWidth", "sizeStartHeight", "getSizeStartHeight", "setSizeStartHeight", "sizeStartWidth", "getSizeStartWidth", "setSizeStartWidth", "strength", "getStrength", "setStrength", "superResolution", "getSuperResolution", "setSuperResolution", "aelight-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SharpenStrength implements Serializable {
        private int deblurScoreStart;
        private float scaleStart;
        private int seq;
        private int sharpenType;
        private float strength;
        private int superResolution;
        private float deblurScoreEnd = 101.0f;
        private float scaleEnd = 10000.0f;
        private int sizeStartHeight = 1;
        private int sizeEndHeight = 100000;
        private int sizeStartWidth = 1;
        private int sizeEndWidth = 100000;
        private int lowDeviceLevel = 1;

        public final float getDeblurScoreEnd() {
            return this.deblurScoreEnd;
        }

        public final int getDeblurScoreStart() {
            return this.deblurScoreStart;
        }

        public final int getLowDeviceLevel() {
            return this.lowDeviceLevel;
        }

        public final float getScaleEnd() {
            return this.scaleEnd;
        }

        public final float getScaleStart() {
            return this.scaleStart;
        }

        public final int getSeq() {
            return this.seq;
        }

        public final int getSharpenType() {
            return this.sharpenType;
        }

        public final int getSizeEndHeight() {
            return this.sizeEndHeight;
        }

        public final int getSizeEndWidth() {
            return this.sizeEndWidth;
        }

        public final int getSizeStartHeight() {
            return this.sizeStartHeight;
        }

        public final int getSizeStartWidth() {
            return this.sizeStartWidth;
        }

        public final float getStrength() {
            return this.strength;
        }

        public final int getSuperResolution() {
            return this.superResolution;
        }

        public final void setDeblurScoreEnd(float f16) {
            this.deblurScoreEnd = f16;
        }

        public final void setDeblurScoreStart(int i3) {
            this.deblurScoreStart = i3;
        }

        public final void setLowDeviceLevel(int i3) {
            this.lowDeviceLevel = i3;
        }

        public final void setScaleEnd(float f16) {
            this.scaleEnd = f16;
        }

        public final void setScaleStart(float f16) {
            this.scaleStart = f16;
        }

        public final void setSeq(int i3) {
            this.seq = i3;
        }

        public final void setSharpenType(int i3) {
            this.sharpenType = i3;
        }

        public final void setSizeEndHeight(int i3) {
            this.sizeEndHeight = i3;
        }

        public final void setSizeEndWidth(int i3) {
            this.sizeEndWidth = i3;
        }

        public final void setSizeStartHeight(int i3) {
            this.sizeStartHeight = i3;
        }

        public final void setSizeStartWidth(int i3) {
            this.sizeStartWidth = i3;
        }

        public final void setStrength(float f16) {
            this.strength = f16;
        }

        public final void setSuperResolution(int i3) {
            this.superResolution = i3;
        }
    }

    public EnhanceConfig(int i3, int i16, int i17, int i18, int i19, int i26, float f16, @Nullable List<SharpenStrength> list) {
        this.enableHDR = i3;
        this.hdrType = i16;
        this.enableDeLogo = i17;
        this.extraMaxDuration = i18;
        this.maxDelogoFrameRate = i19;
        this.deblurAverageScore = i26;
        this.blurBias = f16;
        this.sharpenStrengths = list;
    }

    public final boolean a() {
        if (this.enableDeLogo == 1) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.enableHDR == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: from getter */
    public final float getBlurBias() {
        return this.blurBias;
    }

    /* renamed from: d, reason: from getter */
    public final int getDeblurAverageScore() {
        return this.deblurAverageScore;
    }

    /* renamed from: e, reason: from getter */
    public final int getExtraMaxDuration() {
        return this.extraMaxDuration;
    }

    /* renamed from: f, reason: from getter */
    public final int getMaxDelogoFrameRate() {
        return this.maxDelogoFrameRate;
    }

    @Nullable
    public final List<SharpenStrength> g() {
        return this.sharpenStrengths;
    }

    /* renamed from: h, reason: from getter */
    public final int getHdrType() {
        return this.hdrType;
    }

    public final void i(@Nullable List<SharpenStrength> list) {
        this.sharpenStrengths = list;
    }
}
