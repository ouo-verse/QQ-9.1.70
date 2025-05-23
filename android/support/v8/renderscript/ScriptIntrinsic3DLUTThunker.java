package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsic3DLUTThunker extends ScriptIntrinsic3DLUT {
    android.renderscript.ScriptIntrinsic3DLUT mN;

    ScriptIntrinsic3DLUTThunker(int i3, RenderScript renderScript, Element element) {
        super(i3, renderScript, element);
    }

    public static ScriptIntrinsic3DLUTThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsic3DLUTThunker scriptIntrinsic3DLUTThunker = new ScriptIntrinsic3DLUTThunker(0, renderScript, element);
        scriptIntrinsic3DLUTThunker.mN = android.renderscript.ScriptIntrinsic3DLUT.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsic3DLUTThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsic3DLUT
    public void forEach(Allocation allocation, Allocation allocation2) {
        this.mN.forEach(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsic3DLUT
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsic3DLUT
    public void setLUT(Allocation allocation) {
        this.mN.setLUT(((AllocationThunker) allocation).getNObj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsic3DLUT getNObj() {
        return this.mN;
    }
}
