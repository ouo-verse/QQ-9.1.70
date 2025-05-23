package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicConvolve5x5 extends ScriptIntrinsic {
    private Allocation mInput;
    private final float[] mValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScriptIntrinsicConvolve5x5(int i3, RenderScript renderScript) {
        super(i3, renderScript);
        this.mValues = new float[25];
    }

    public static ScriptIntrinsicConvolve5x5 create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            return ScriptIntrinsicConvolve5x5Thunker.create(renderScript, element);
        }
        return new ScriptIntrinsicConvolve5x5(renderScript.nScriptIntrinsicCreate(4, element.getID(renderScript)), renderScript);
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
        FieldPacker fieldPacker = new FieldPacker(100);
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
