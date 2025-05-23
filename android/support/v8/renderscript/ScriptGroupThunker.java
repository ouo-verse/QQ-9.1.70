package android.support.v8.renderscript;

import android.renderscript.ScriptGroup;
import android.support.v8.renderscript.Script;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptGroupThunker extends ScriptGroup {
    android.renderscript.ScriptGroup mN;

    ScriptGroupThunker(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    @Override // android.support.v8.renderscript.ScriptGroup
    public void execute() {
        this.mN.execute();
    }

    @Override // android.support.v8.renderscript.ScriptGroup
    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        this.mN.setInput(kernelID.mN, ((AllocationThunker) allocation).getNObj());
    }

    @Override // android.support.v8.renderscript.ScriptGroup
    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        this.mN.setOutput(kernelID.mN, ((AllocationThunker) allocation).getNObj());
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        ScriptGroup.Builder bN;
        RenderScript mRS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
            this.bN = new ScriptGroup.Builder(((RenderScriptThunker) renderScript).mN);
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            this.bN.addConnection(((TypeThunker) type).getNObj(), kernelID.mN, fieldID.mN);
            return this;
        }

        public Builder addKernel(Script.KernelID kernelID) {
            this.bN.addKernel(kernelID.mN);
            return this;
        }

        public ScriptGroupThunker create() {
            ScriptGroupThunker scriptGroupThunker = new ScriptGroupThunker(0, this.mRS);
            scriptGroupThunker.mN = this.bN.create();
            return scriptGroupThunker;
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            this.bN.addConnection(((TypeThunker) type).getNObj(), kernelID.mN, kernelID2.mN);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.ScriptGroup getNObj() {
        return this.mN;
    }
}
