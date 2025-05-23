package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsicConvolve3x3Thunker extends ScriptIntrinsicConvolve3x3 {
    android.renderscript.ScriptIntrinsicConvolve3x3 mN;

    ScriptIntrinsicConvolve3x3Thunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicConvolve3x3Thunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicConvolve3x3Thunker scriptIntrinsicConvolve3x3Thunker = new ScriptIntrinsicConvolve3x3Thunker(0, renderScript);
        scriptIntrinsicConvolve3x3Thunker.mN = android.renderscript.ScriptIntrinsicConvolve3x3.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicConvolve3x3Thunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
    public void forEach(Allocation allocation) {
        this.mN.forEach(((AllocationThunker) allocation).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        createFieldID.mN = this.mN.getFieldID_Input();
        return createFieldID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
    public void setCoefficients(float[] fArr) {
        this.mN.setCoefficients(fArr);
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
    public void setInput(Allocation allocation) {
        this.mN.setInput(((AllocationThunker) allocation).getNObj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicConvolve3x3 getNObj() {
        return this.mN;
    }
}
