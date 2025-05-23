package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicBlurThunker extends ScriptIntrinsicBlur {
    android.renderscript.ScriptIntrinsicBlur mN;

    protected ScriptIntrinsicBlurThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public static ScriptIntrinsicBlurThunker create(RenderScript renderScript, Element element) {
        ScriptIntrinsicBlurThunker scriptIntrinsicBlurThunker = new ScriptIntrinsicBlurThunker(0, renderScript);
        scriptIntrinsicBlurThunker.mN = android.renderscript.ScriptIntrinsicBlur.create(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).getNObj());
        return scriptIntrinsicBlurThunker;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlur
    public void forEach(Allocation allocation) {
        AllocationThunker allocationThunker = (AllocationThunker) allocation;
        if (allocationThunker != null) {
            this.mN.forEach(allocationThunker.getNObj());
        }
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlur
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        createFieldID.mN = this.mN.getFieldID_Input();
        return createFieldID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlur
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        createKernelID.mN = this.mN.getKernelID();
        return createKernelID;
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlur
    public void setInput(Allocation allocation) {
        this.mN.setInput(((AllocationThunker) allocation).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptIntrinsicBlur
    public void setRadius(float f16) {
        this.mN.setRadius(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.Script, android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptIntrinsicBlur getNObj() {
        return this.mN;
    }
}
