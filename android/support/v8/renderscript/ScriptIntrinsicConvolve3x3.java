package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicConvolve3x3 extends ScriptIntrinsic {
    private Allocation mInput;
    private final float[] mValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScriptIntrinsicConvolve3x3(int i3, RenderScript renderScript) {
        super(i3, renderScript);
        this.mValues = new float[9];
    }

    public static ScriptIntrinsicConvolve3x3 create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            return ScriptIntrinsicConvolve3x3Thunker.create(renderScript, element);
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (element.isCompatible(Element.U8_4(renderScript))) {
            ScriptIntrinsicConvolve3x3 scriptIntrinsicConvolve3x3 = new ScriptIntrinsicConvolve3x3(renderScript.nScriptIntrinsicCreate(1, element.getID(renderScript)), renderScript);
            scriptIntrinsicConvolve3x3.setCoefficients(fArr);
            return scriptIntrinsicConvolve3x3;
        }
        throw new RSIllegalArgumentException("Unsuported element type.");
    }

    public void forEach(Allocation allocation) {
        forEach(0, null, allocation, null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public void setCoefficients(float[] fArr) {
        FieldPacker fieldPacker = new FieldPacker(36);
        int i3 = 0;
        while (true) {
            float[] fArr2 = this.mValues;
            if (i3 < fArr2.length) {
                float f16 = fArr[i3];
                fArr2[i3] = f16;
                fieldPacker.addF32(f16);
                i3++;
            } else {
                setVar(0, fieldPacker);
                return;
            }
        }
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }
}
