package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsicConvolve5x5Thunker extends ScriptIntrinsicConvolve5x5 {
    android.renderscript.ScriptIntrinsicConvolve5x5 mN;

    ScriptIntrinsicConvolve5x5Thunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicConvolve5x5Thunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicConvolve5x5Thunker scriptIntrinsicConvolve5x5Thunker = new ScriptIntrinsicConvolve5x5Thunker(0, renderScript);
        scriptIntrinsicConvolve5x5Thunker.mN = android.renderscript.ScriptIntrinsicConvolve5x5.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicConvolve5x5Thunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
    public void forEach(Allocation allocation) {
        this.mN.forEach(((AllocationThunker) allocation).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        createFieldID.mN = this.mN.getFieldID_Input();
        return createFieldID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
    public void setCoefficients(float[] fArr) {
        this.mN.setCoefficients(fArr);
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
    public void setInput(Allocation allocation) {
        this.mN.setInput(((AllocationThunker) allocation).getNObj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicConvolve5x5 getNObj() {
        return this.mN;
    }
}
