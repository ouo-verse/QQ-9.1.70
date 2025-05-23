package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsicColorMatrixThunker extends ScriptIntrinsicColorMatrix {
    android.renderscript.ScriptIntrinsicColorMatrix mN;

    ScriptIntrinsicColorMatrixThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicColorMatrixThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicColorMatrixThunker scriptIntrinsicColorMatrixThunker = new ScriptIntrinsicColorMatrixThunker(0, renderScript);
        scriptIntrinsicColorMatrixThunker.mN = android.renderscript.ScriptIntrinsicColorMatrix.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicColorMatrixThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void forEach(Allocation allocation, Allocation allocation2) {
        this.mN.forEach(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void setColorMatrix(Matrix4f matrix4f) {
        this.mN.setColorMatrix(new android.renderscript.Matrix4f(matrix4f.getArray()));
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void setGreyscale() {
        this.mN.setGreyscale();
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void setRGBtoYUV() {
        this.mN.setRGBtoYUV();
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void setYUVtoRGB() {
        this.mN.setYUVtoRGB();
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicColorMatrix
    public void setColorMatrix(Matrix3f matrix3f) {
        this.mN.setColorMatrix(new android.renderscript.Matrix3f(matrix3f.getArray()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicColorMatrix getNObj() {
        return this.mN;
    }
}
