package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicYuvToRGBThunker extends ScriptIntrinsicYuvToRGB {
    android.renderscript.ScriptIntrinsicYuvToRGB mN;

    ScriptIntrinsicYuvToRGBThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicYuvToRGBThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicYuvToRGBThunker scriptIntrinsicYuvToRGBThunker = new ScriptIntrinsicYuvToRGBThunker(0, renderScript);
        scriptIntrinsicYuvToRGBThunker.mN = android.renderscript.ScriptIntrinsicYuvToRGB.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicYuvToRGBThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
    public void forEach(Allocation allocation) {
        this.mN.setInput(((AllocationThunker) allocation).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(0, null);
        createFieldID.mN = this.mN.getFieldID_Input();
        return createFieldID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
    public void setInput(Allocation allocation) {
        this.mN.setInput(((AllocationThunker) allocation).getNObj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicYuvToRGB getNObj() {
        return this.mN;
    }
}
