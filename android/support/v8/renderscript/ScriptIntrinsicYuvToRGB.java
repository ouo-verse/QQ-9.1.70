package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicYuvToRGB extends ScriptIntrinsic {
    private Allocation mInput;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScriptIntrinsicYuvToRGB(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicYuvToRGB create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            return ScriptIntrinsicYuvToRGBThunker.create(renderScript, element);
        }
        return new ScriptIntrinsicYuvToRGB(renderScript.nScriptIntrinsicCreate(6, element.getID(renderScript)), renderScript);
    }

    public void forEach(Allocation allocation) {
        forEach(0, null, allocation, null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(0, allocation);
    }
}
