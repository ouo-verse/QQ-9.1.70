package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsicLUTThunker extends ScriptIntrinsicLUT {
    android.renderscript.ScriptIntrinsicLUT mN;

    ScriptIntrinsicLUTThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicLUTThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicLUTThunker scriptIntrinsicLUTThunker = new ScriptIntrinsicLUTThunker(0, renderScript);
        scriptIntrinsicLUTThunker.mN = android.renderscript.ScriptIntrinsicLUT.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicLUTThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public void forEach(Allocation allocation, Allocation allocation2) {
        this.mN.forEach(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public void setAlpha(int i3, int i16) {
        this.mN.setAlpha(i3, i16);
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public void setBlue(int i3, int i16) {
        this.mN.setBlue(i3, i16);
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public void setGreen(int i3, int i16) {
        this.mN.setGreen(i3, i16);
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicLUT
    public void setRed(int i3, int i16) {
        this.mN.setRed(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicLUT getNObj() {
        return this.mN;
    }
}
