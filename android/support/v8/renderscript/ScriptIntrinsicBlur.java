package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicBlur extends ScriptIntrinsic {
    private Allocation mInput;
    private final float[] mValues;

    /* JADX INFO: Access modifiers changed from: protected */
    public ScriptIntrinsicBlur(int i3, RenderScript renderScript) {
        super(i3, renderScript);
        this.mValues = new float[9];
    }

    public static ScriptIntrinsicBlur create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            return ScriptIntrinsicBlurThunker.create(renderScript, element);
        }
        if (!element.isCompatible(Element.U8_4(renderScript)) && !element.isCompatible(Element.U8(renderScript))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = new ScriptIntrinsicBlur(renderScript.nScriptIntrinsicCreate(5, element.getID(renderScript)), renderScript);
        scriptIntrinsicBlur.setRadius(5.0f);
        return scriptIntrinsicBlur;
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

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }

    public void setRadius(float f16) {
        if (f16 > 0.0f && f16 <= 25.0f) {
            setVar(0, f16);
            return;
        }
        throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
    }
}
