package android.support.v8.renderscript;

import android.renderscript.Element;
import android.support.v8.renderscript.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ElementThunker extends Element {
    android.renderscript.Element mN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: android.support.v8.renderscript.ElementThunker$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataKind;
        static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataType;

        static {
            int[] iArr = new int[Element.DataType.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataType = iArr;
            try {
                iArr[Element.DataType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.FLOAT_32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.FLOAT_64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.SIGNED_64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_8.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_16.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.UNSIGNED_64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.BOOLEAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_4X4.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_3X3.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.MATRIX_2X2.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_ELEMENT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_ALLOCATION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_SAMPLER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataType[Element.DataType.RS_SCRIPT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[Element.DataKind.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataKind = iArr2;
            try {
                iArr2[Element.DataKind.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_L.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_LA.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_RGB.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Element$DataKind[Element.DataKind.PIXEL_RGBA.ordinal()] = 6;
            } catch (NoSuchFieldError unused26) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class BuilderThunker {
        Element.Builder mN;

        public BuilderThunker(RenderScript renderScript) {
            this.mN = new Element.Builder(((RenderScriptThunker) renderScript).mN);
        }

        public void add(Element element, String str, int i3) {
            this.mN.add(((ElementThunker) element).mN, str, i3);
        }

        public Element create(RenderScript renderScript) {
            return new ElementThunker(renderScript, this.mN.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ElementThunker(RenderScript renderScript, android.renderscript.Element element) {
        super(0, renderScript);
        this.mN = element;
    }

    static Element.DataKind convertKind(Element.DataKind dataKind) {
        switch (AnonymousClass1.$SwitchMap$android$support$v8$renderscript$Element$DataKind[dataKind.ordinal()]) {
            case 1:
                return Element.DataKind.USER;
            case 2:
                return Element.DataKind.PIXEL_L;
            case 3:
                return Element.DataKind.PIXEL_A;
            case 4:
                return Element.DataKind.PIXEL_LA;
            case 5:
                return Element.DataKind.PIXEL_RGB;
            case 6:
                return Element.DataKind.PIXEL_RGBA;
            default:
                return null;
        }
    }

    static Element.DataType convertType(Element.DataType dataType) {
        switch (AnonymousClass1.$SwitchMap$android$support$v8$renderscript$Element$DataType[dataType.ordinal()]) {
            case 1:
                return Element.DataType.NONE;
            case 2:
                return Element.DataType.FLOAT_32;
            case 3:
                return Element.DataType.FLOAT_64;
            case 4:
                return Element.DataType.SIGNED_8;
            case 5:
                return Element.DataType.SIGNED_16;
            case 6:
                return Element.DataType.SIGNED_32;
            case 7:
                return Element.DataType.SIGNED_64;
            case 8:
                return Element.DataType.UNSIGNED_8;
            case 9:
                return Element.DataType.UNSIGNED_16;
            case 10:
                return Element.DataType.UNSIGNED_32;
            case 11:
                return Element.DataType.UNSIGNED_64;
            case 12:
                return Element.DataType.BOOLEAN;
            case 13:
                return Element.DataType.MATRIX_4X4;
            case 14:
                return Element.DataType.MATRIX_3X3;
            case 15:
                return Element.DataType.MATRIX_2X2;
            case 16:
                return Element.DataType.RS_ELEMENT;
            case 17:
                return Element.DataType.RS_TYPE;
            case 18:
                return Element.DataType.RS_ALLOCATION;
            case 19:
                return Element.DataType.RS_SAMPLER;
            case 20:
                return Element.DataType.RS_SCRIPT;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Element create(RenderScript renderScript, Element.DataType dataType) {
        android.renderscript.Element F32;
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        switch (AnonymousClass1.$SwitchMap$android$support$v8$renderscript$Element$DataType[dataType.ordinal()]) {
            case 2:
                F32 = android.renderscript.Element.F32(renderScriptThunker.mN);
                break;
            case 3:
                F32 = android.renderscript.Element.F64(renderScriptThunker.mN);
                break;
            case 4:
                F32 = android.renderscript.Element.I8(renderScriptThunker.mN);
                break;
            case 5:
                F32 = android.renderscript.Element.I16(renderScriptThunker.mN);
                break;
            case 6:
                F32 = android.renderscript.Element.I32(renderScriptThunker.mN);
                break;
            case 7:
                F32 = android.renderscript.Element.I64(renderScriptThunker.mN);
                break;
            case 8:
                F32 = android.renderscript.Element.U8(renderScriptThunker.mN);
                break;
            case 9:
                F32 = android.renderscript.Element.U16(renderScriptThunker.mN);
                break;
            case 10:
                F32 = android.renderscript.Element.U32(renderScriptThunker.mN);
                break;
            case 11:
                F32 = android.renderscript.Element.U64(renderScriptThunker.mN);
                break;
            case 12:
                F32 = android.renderscript.Element.BOOLEAN(renderScriptThunker.mN);
                break;
            case 13:
                F32 = android.renderscript.Element.MATRIX_4X4(renderScriptThunker.mN);
                break;
            case 14:
                F32 = android.renderscript.Element.MATRIX_3X3(renderScriptThunker.mN);
                break;
            case 15:
                F32 = android.renderscript.Element.MATRIX_2X2(renderScriptThunker.mN);
                break;
            case 16:
                F32 = android.renderscript.Element.ELEMENT(renderScriptThunker.mN);
                break;
            case 17:
                F32 = android.renderscript.Element.TYPE(renderScriptThunker.mN);
                break;
            case 18:
                F32 = android.renderscript.Element.ALLOCATION(renderScriptThunker.mN);
                break;
            case 19:
                F32 = android.renderscript.Element.SAMPLER(renderScriptThunker.mN);
                break;
            case 20:
                F32 = android.renderscript.Element.SCRIPT(renderScriptThunker.mN);
                break;
            default:
                F32 = null;
                break;
        }
        return new ElementThunker(renderScript, F32);
    }

    public static Element createPixel(RenderScript renderScript, Element.DataType dataType, Element.DataKind dataKind) {
        return new ElementThunker(renderScript, android.renderscript.Element.createPixel(((RenderScriptThunker) renderScript).mN, convertType(dataType), convertKind(dataKind)));
    }

    public static Element createVector(RenderScript renderScript, Element.DataType dataType, int i3) {
        return new ElementThunker(renderScript, android.renderscript.Element.createVector(((RenderScriptThunker) renderScript).mN, convertType(dataType), i3));
    }

    @Override // android.support.v8.renderscript.Element
    public int getBytesSize() {
        return this.mN.getBytesSize();
    }

    @Override // android.support.v8.renderscript.Element
    public Element.DataKind getDataKind() {
        return this.mKind;
    }

    @Override // android.support.v8.renderscript.Element
    public Element.DataType getDataType() {
        return this.mType;
    }

    @Override // android.support.v8.renderscript.Element
    public Element getSubElement(int i3) {
        return new ElementThunker(this.mRS, this.mN.getSubElement(i3));
    }

    @Override // android.support.v8.renderscript.Element
    public int getSubElementArraySize(int i3) {
        return this.mN.getSubElementArraySize(i3);
    }

    @Override // android.support.v8.renderscript.Element
    public int getSubElementCount() {
        return this.mN.getSubElementCount();
    }

    @Override // android.support.v8.renderscript.Element
    public String getSubElementName(int i3) {
        return this.mN.getSubElementName(i3);
    }

    @Override // android.support.v8.renderscript.Element
    public int getSubElementOffsetBytes(int i3) {
        return this.mN.getSubElementOffsetBytes(i3);
    }

    @Override // android.support.v8.renderscript.Element
    public int getVectorSize() {
        return this.mN.getVectorSize();
    }

    @Override // android.support.v8.renderscript.Element
    public boolean isCompatible(Element element) {
        return ((ElementThunker) element).mN.isCompatible(this.mN);
    }

    @Override // android.support.v8.renderscript.Element
    public boolean isComplex() {
        return this.mN.isComplex();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.Element getNObj() {
        return this.mN;
    }
}
