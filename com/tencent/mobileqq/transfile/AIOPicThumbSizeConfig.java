package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\u0006H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006H\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\u0006H\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/transfile/AIOPicThumbSizeConfig;", "", "maxRatio", "", "minRatio", "textOtherSpace", "", "picSizeLimit", "aioImageMaxSize", "aioImageMinSize", "aioImageMaxSizeUnderLimit", "aioImageMinSizeUnderLimit", "aioImageDynamicMaxSize", "aioImageDynamicMinSize", "(FFIIIIIIII)V", "getAioImageDynamicMaxSize", "()I", "setAioImageDynamicMaxSize", "(I)V", "getAioImageDynamicMinSize", "setAioImageDynamicMinSize", "getAioImageMaxSize", "setAioImageMaxSize", "getAioImageMaxSizeUnderLimit", "setAioImageMaxSizeUnderLimit", "getAioImageMinSize", "setAioImageMinSize", "getAioImageMinSizeUnderLimit", "setAioImageMinSizeUnderLimit", "getMaxRatio", "()F", "setMaxRatio", "(F)V", "getMinRatio", "setMinRatio", "getPicSizeLimit", "setPicSizeLimit", "getTextOtherSpace", "setTextOtherSpace", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "pic_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class AIOPicThumbSizeConfig {
    static IPatchRedirector $redirector_;
    private int aioImageDynamicMaxSize;
    private int aioImageDynamicMinSize;
    private int aioImageMaxSize;
    private int aioImageMaxSizeUnderLimit;
    private int aioImageMinSize;
    private int aioImageMinSizeUnderLimit;
    private float maxRatio;
    private float minRatio;
    private int picSizeLimit;
    private int textOtherSpace;

    public AIOPicThumbSizeConfig() {
        this(0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            return;
        }
        iPatchRedirector.redirect((short) 37, (Object) this);
    }

    public static /* synthetic */ AIOPicThumbSizeConfig copy$default(AIOPicThumbSizeConfig aIOPicThumbSizeConfig, float f16, float f17, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, Object obj) {
        float f18;
        float f19;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        if ((i29 & 1) != 0) {
            f18 = aIOPicThumbSizeConfig.maxRatio;
        } else {
            f18 = f16;
        }
        if ((i29 & 2) != 0) {
            f19 = aIOPicThumbSizeConfig.minRatio;
        } else {
            f19 = f17;
        }
        if ((i29 & 4) != 0) {
            i36 = aIOPicThumbSizeConfig.textOtherSpace;
        } else {
            i36 = i3;
        }
        if ((i29 & 8) != 0) {
            i37 = aIOPicThumbSizeConfig.picSizeLimit;
        } else {
            i37 = i16;
        }
        if ((i29 & 16) != 0) {
            i38 = aIOPicThumbSizeConfig.aioImageMaxSize;
        } else {
            i38 = i17;
        }
        if ((i29 & 32) != 0) {
            i39 = aIOPicThumbSizeConfig.aioImageMinSize;
        } else {
            i39 = i18;
        }
        if ((i29 & 64) != 0) {
            i46 = aIOPicThumbSizeConfig.aioImageMaxSizeUnderLimit;
        } else {
            i46 = i19;
        }
        if ((i29 & 128) != 0) {
            i47 = aIOPicThumbSizeConfig.aioImageMinSizeUnderLimit;
        } else {
            i47 = i26;
        }
        if ((i29 & 256) != 0) {
            i48 = aIOPicThumbSizeConfig.aioImageDynamicMaxSize;
        } else {
            i48 = i27;
        }
        if ((i29 & 512) != 0) {
            i49 = aIOPicThumbSizeConfig.aioImageDynamicMinSize;
        } else {
            i49 = i28;
        }
        return aIOPicThumbSizeConfig.copy(f18, f19, i36, i37, i38, i39, i46, i47, i48, i49);
    }

    public final float component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.maxRatio;
    }

    public final int component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.aioImageDynamicMinSize;
    }

    public final float component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Float) iPatchRedirector.redirect((short) 24, (Object) this)).floatValue();
        }
        return this.minRatio;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.textOtherSpace;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.picSizeLimit;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.aioImageMaxSize;
    }

    public final int component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.aioImageMinSize;
    }

    public final int component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.aioImageMaxSizeUnderLimit;
    }

    public final int component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.aioImageMinSizeUnderLimit;
    }

    public final int component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.aioImageDynamicMaxSize;
    }

    @NotNull
    public final AIOPicThumbSizeConfig copy(float maxRatio, float minRatio, int textOtherSpace, int picSizeLimit, int aioImageMaxSize, int aioImageMinSize, int aioImageMaxSizeUnderLimit, int aioImageMinSizeUnderLimit, int aioImageDynamicMaxSize, int aioImageDynamicMinSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (AIOPicThumbSizeConfig) iPatchRedirector.redirect((short) 33, this, Float.valueOf(maxRatio), Float.valueOf(minRatio), Integer.valueOf(textOtherSpace), Integer.valueOf(picSizeLimit), Integer.valueOf(aioImageMaxSize), Integer.valueOf(aioImageMinSize), Integer.valueOf(aioImageMaxSizeUnderLimit), Integer.valueOf(aioImageMinSizeUnderLimit), Integer.valueOf(aioImageDynamicMaxSize), Integer.valueOf(aioImageDynamicMinSize));
        }
        return new AIOPicThumbSizeConfig(maxRatio, minRatio, textOtherSpace, picSizeLimit, aioImageMaxSize, aioImageMinSize, aioImageMaxSizeUnderLimit, aioImageMinSizeUnderLimit, aioImageDynamicMaxSize, aioImageDynamicMinSize);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOPicThumbSizeConfig)) {
            return false;
        }
        AIOPicThumbSizeConfig aIOPicThumbSizeConfig = (AIOPicThumbSizeConfig) other;
        if (Float.compare(this.maxRatio, aIOPicThumbSizeConfig.maxRatio) == 0 && Float.compare(this.minRatio, aIOPicThumbSizeConfig.minRatio) == 0 && this.textOtherSpace == aIOPicThumbSizeConfig.textOtherSpace && this.picSizeLimit == aIOPicThumbSizeConfig.picSizeLimit && this.aioImageMaxSize == aIOPicThumbSizeConfig.aioImageMaxSize && this.aioImageMinSize == aIOPicThumbSizeConfig.aioImageMinSize && this.aioImageMaxSizeUnderLimit == aIOPicThumbSizeConfig.aioImageMaxSizeUnderLimit && this.aioImageMinSizeUnderLimit == aIOPicThumbSizeConfig.aioImageMinSizeUnderLimit && this.aioImageDynamicMaxSize == aIOPicThumbSizeConfig.aioImageDynamicMaxSize && this.aioImageDynamicMinSize == aIOPicThumbSizeConfig.aioImageDynamicMinSize) {
            return true;
        }
        return false;
    }

    public final int getAioImageDynamicMaxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.aioImageDynamicMaxSize;
    }

    public final int getAioImageDynamicMinSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.aioImageDynamicMinSize;
    }

    public final int getAioImageMaxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.aioImageMaxSize;
    }

    public final int getAioImageMaxSizeUnderLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.aioImageMaxSizeUnderLimit;
    }

    public final int getAioImageMinSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.aioImageMinSize;
    }

    public final int getAioImageMinSizeUnderLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.aioImageMinSizeUnderLimit;
    }

    public final float getMaxRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.maxRatio;
    }

    public final float getMinRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.minRatio;
    }

    public final int getPicSizeLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.picSizeLimit;
    }

    public final int getTextOtherSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.textOtherSpace;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return (((((((((((((((((Float.floatToIntBits(this.maxRatio) * 31) + Float.floatToIntBits(this.minRatio)) * 31) + this.textOtherSpace) * 31) + this.picSizeLimit) * 31) + this.aioImageMaxSize) * 31) + this.aioImageMinSize) * 31) + this.aioImageMaxSizeUnderLimit) * 31) + this.aioImageMinSizeUnderLimit) * 31) + this.aioImageDynamicMaxSize) * 31) + this.aioImageDynamicMinSize;
    }

    public final void setAioImageDynamicMaxSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.aioImageDynamicMaxSize = i3;
        }
    }

    public final void setAioImageDynamicMinSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.aioImageDynamicMinSize = i3;
        }
    }

    public final void setAioImageMaxSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.aioImageMaxSize = i3;
        }
    }

    public final void setAioImageMaxSizeUnderLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.aioImageMaxSizeUnderLimit = i3;
        }
    }

    public final void setAioImageMinSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.aioImageMinSize = i3;
        }
    }

    public final void setAioImageMinSizeUnderLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.aioImageMinSizeUnderLimit = i3;
        }
    }

    public final void setMaxRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.maxRatio = f16;
        }
    }

    public final void setMinRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.minRatio = f16;
        }
    }

    public final void setPicSizeLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.picSizeLimit = i3;
        }
    }

    public final void setTextOtherSpace(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.textOtherSpace = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return "AIOPicThumbSizeConfig(maxRatio=" + this.maxRatio + ", minRatio=" + this.minRatio + ", textOtherSpace=" + this.textOtherSpace + ", picSizeLimit=" + this.picSizeLimit + ", aioImageMaxSize=" + this.aioImageMaxSize + ", aioImageMinSize=" + this.aioImageMinSize + ", aioImageMaxSizeUnderLimit=" + this.aioImageMaxSizeUnderLimit + ", aioImageMinSizeUnderLimit=" + this.aioImageMinSizeUnderLimit + ", aioImageDynamicMaxSize=" + this.aioImageDynamicMaxSize + ", aioImageDynamicMinSize=" + this.aioImageDynamicMinSize + ")";
    }

    public AIOPicThumbSizeConfig(float f16, float f17, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
            return;
        }
        this.maxRatio = f16;
        this.minRatio = f17;
        this.textOtherSpace = i3;
        this.picSizeLimit = i16;
        this.aioImageMaxSize = i17;
        this.aioImageMinSize = i18;
        this.aioImageMaxSizeUnderLimit = i19;
        this.aioImageMinSizeUnderLimit = i26;
        this.aioImageDynamicMaxSize = i27;
        this.aioImageDynamicMinSize = i28;
    }

    public /* synthetic */ AIOPicThumbSizeConfig(float f16, float f17, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this((i29 & 1) != 0 ? 0.85f : f16, (i29 & 2) != 0 ? 0.28f : f17, (i29 & 4) != 0 ? 0 : i3, (i29 & 8) != 0 ? 650 : i16, (i29 & 16) != 0 ? 135 : i17, (i29 & 32) != 0 ? 45 : i18, (i29 & 64) != 0 ? 135 : i19, (i29 & 128) != 0 ? 45 : i26, (i29 & 256) != 0 ? 45 : i27, (i29 & 512) != 0 ? 135 : i28);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), defaultConstructorMarker);
    }
}
