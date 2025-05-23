package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptIntrinsicBlendThunker extends ScriptIntrinsicBlend {
    android.renderscript.ScriptIntrinsicBlend mN;

    ScriptIntrinsicBlendThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicBlendThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicBlendThunker scriptIntrinsicBlendThunker = new ScriptIntrinsicBlendThunker(0, renderScript);
        scriptIntrinsicBlendThunker.mN = android.renderscript.ScriptIntrinsicBlend.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicBlendThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachAdd(Allocation allocation, Allocation allocation2) {
        this.mN.forEachAdd(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachClear(Allocation allocation, Allocation allocation2) {
        this.mN.forEachClear(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachDst(Allocation allocation, Allocation allocation2) {
        this.mN.forEachDst(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachDstAtop(Allocation allocation, Allocation allocation2) {
        this.mN.forEachDstAtop(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachDstIn(Allocation allocation, Allocation allocation2) {
        this.mN.forEachDstIn(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachDstOut(Allocation allocation, Allocation allocation2) {
        this.mN.forEachDstOut(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachDstOver(Allocation allocation, Allocation allocation2) {
        this.mN.forEachDstOver(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachMultiply(Allocation allocation, Allocation allocation2) {
        this.mN.forEachMultiply(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSrc(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSrc(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSrcAtop(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSrcAtop(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSrcIn(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSrcIn(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSrcOut(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSrcOut(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSrcOver(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSrcOver(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachSubtract(Allocation allocation, Allocation allocation2) {
        this.mN.forEachSubtract(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public void forEachXor(Allocation allocation, Allocation allocation2) {
        this.mN.forEachXor(((AllocationThunker) allocation).getNObj(), ((AllocationThunker) allocation2).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDAdd() {
        Script.KernelID createKernelID = createKernelID(34, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDAdd();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDClear() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDClear();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDst() {
        Script.KernelID createKernelID = createKernelID(2, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDDst();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstAtop() {
        Script.KernelID createKernelID = createKernelID(10, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDDstAtop();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstIn() {
        Script.KernelID createKernelID = createKernelID(6, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDDstIn();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstOut() {
        Script.KernelID createKernelID = createKernelID(8, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDDstOut();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstOver() {
        Script.KernelID createKernelID = createKernelID(4, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDDstOver();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDMultiply() {
        Script.KernelID createKernelID = createKernelID(14, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDMultiply();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrc() {
        Script.KernelID createKernelID = createKernelID(1, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSrc();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcAtop() {
        Script.KernelID createKernelID = createKernelID(9, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSrcAtop();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcIn() {
        Script.KernelID createKernelID = createKernelID(5, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSrcIn();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcOut() {
        Script.KernelID createKernelID = createKernelID(7, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSrcOut();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcOver() {
        Script.KernelID createKernelID = createKernelID(3, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSrcOver();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSubtract() {
        Script.KernelID createKernelID = createKernelID(35, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDSubtract();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDXor() {
        Script.KernelID createKernelID = createKernelID(11, 3, null, null);
        createKernelID.mN = this.mN.getKernelIDXor();
        return createKernelID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicBlend getNObj() {
        return this.mN;
    }
}
