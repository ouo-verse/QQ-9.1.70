package android.support.v8.renderscript;

import android.renderscript.Sampler;
import android.support.v8.renderscript.Sampler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class SamplerThunker extends Sampler {
    android.renderscript.Sampler mN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: android.support.v8.renderscript.SamplerThunker$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Sampler$Value;

        static {
            int[] iArr = new int[Sampler.Value.values().length];
            $SwitchMap$android$support$v8$renderscript$Sampler$Value = iArr;
            try {
                iArr[Sampler.Value.NEAREST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.LINEAR_MIP_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.LINEAR_MIP_NEAREST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.WRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.CLAMP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Sampler$Value[Sampler.Value.MIRRORED_REPEAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        float mAniso;
        Sampler.Value mMag;
        Sampler.Value mMin;
        RenderScriptThunker mRS;
        Sampler.Value mWrapR;
        Sampler.Value mWrapS;
        Sampler.Value mWrapT;

        public Builder(RenderScriptThunker renderScriptThunker) {
            this.mRS = renderScriptThunker;
            Sampler.Value value = Sampler.Value.NEAREST;
            this.mMin = value;
            this.mMag = value;
            Sampler.Value value2 = Sampler.Value.WRAP;
            this.mWrapS = value2;
            this.mWrapT = value2;
            this.mWrapR = value2;
        }

        public Sampler create() {
            this.mRS.validate();
            Sampler.Builder builder = new Sampler.Builder(this.mRS.mN);
            builder.setMinification(SamplerThunker.convertValue(this.mMin));
            builder.setMagnification(SamplerThunker.convertValue(this.mMag));
            builder.setWrapS(SamplerThunker.convertValue(this.mWrapS));
            builder.setWrapT(SamplerThunker.convertValue(this.mWrapT));
            builder.setAnisotropy(this.mAniso);
            android.renderscript.Sampler create = builder.create();
            SamplerThunker samplerThunker = new SamplerThunker(0, this.mRS);
            samplerThunker.mMin = this.mMin;
            samplerThunker.mMag = this.mMag;
            samplerThunker.mWrapS = this.mWrapS;
            samplerThunker.mWrapT = this.mWrapT;
            samplerThunker.mWrapR = this.mWrapR;
            samplerThunker.mAniso = this.mAniso;
            samplerThunker.mN = create;
            return samplerThunker;
        }

        public void setAnisotropy(float f16) {
            if (f16 >= 0.0f) {
                this.mAniso = f16;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }

        public void setMagnification(Sampler.Value value) {
            if (value != Sampler.Value.NEAREST && value != Sampler.Value.LINEAR) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mMag = value;
        }

        public void setMinification(Sampler.Value value) {
            if (value != Sampler.Value.NEAREST && value != Sampler.Value.LINEAR && value != Sampler.Value.LINEAR_MIP_LINEAR && value != Sampler.Value.LINEAR_MIP_NEAREST) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mMin = value;
        }

        public void setWrapS(Sampler.Value value) {
            if (value != Sampler.Value.WRAP && value != Sampler.Value.CLAMP && value != Sampler.Value.MIRRORED_REPEAT) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mWrapS = value;
        }

        public void setWrapT(Sampler.Value value) {
            if (value != Sampler.Value.WRAP && value != Sampler.Value.CLAMP && value != Sampler.Value.MIRRORED_REPEAT) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mWrapT = value;
        }
    }

    protected SamplerThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    static Sampler.Value convertValue(Sampler.Value value) {
        switch (AnonymousClass1.$SwitchMap$android$support$v8$renderscript$Sampler$Value[value.ordinal()]) {
            case 1:
                return Sampler.Value.NEAREST;
            case 2:
                return Sampler.Value.LINEAR;
            case 3:
                return Sampler.Value.LINEAR_MIP_LINEAR;
            case 4:
                return Sampler.Value.LINEAR_MIP_NEAREST;
            case 5:
                return Sampler.Value.WRAP;
            case 6:
                return Sampler.Value.CLAMP;
            case 7:
                return Sampler.Value.MIRRORED_REPEAT;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.BaseObj getNObj() {
        return this.mN;
    }
}
