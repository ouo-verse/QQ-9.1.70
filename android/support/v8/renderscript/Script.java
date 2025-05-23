package android.support.v8.renderscript;

import android.renderscript.Script;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes.dex */
public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs;
    private final SparseArray<KernelID> mKIDs;
    ScriptCThunker mT;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        RenderScript mRS;

        Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class FieldBase {
        protected Allocation mAllocation;
        protected Element mElement;

        protected FieldBase() {
        }

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        protected void init(RenderScript renderScript, int i3) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i3, 1);
        }

        protected void init(RenderScript renderScript, int i3, int i16) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i3, i16 | 1);
        }

        public void updateAllocation() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class FieldID extends BaseObj {
        Script.FieldID mN;
        Script mScript;
        int mSlot;

        FieldID(int i3, RenderScript renderScript, Script script, int i16) {
            super(i3, renderScript);
            this.mScript = script;
            this.mSlot = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class KernelID extends BaseObj {
        Script.KernelID mN;
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(int i3, RenderScript renderScript, Script script, int i16, int i17) {
            super(i3, renderScript);
            this.mScript = script;
            this.mSlot = i16;
            this.mSig = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class LaunchOptions {
        private int strategy;
        private int xstart = 0;
        private int ystart = 0;
        private int xend = 0;
        private int yend = 0;
        private int zstart = 0;
        private int zend = 0;

        public int getXEnd() {
            return this.xend;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getZEnd() {
            return this.zend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public LaunchOptions setX(int i3, int i16) {
            if (i3 >= 0 && i16 > i3) {
                this.xstart = i3;
                this.xend = i16;
                return this;
            }
            throw new RSIllegalArgumentException("Invalid dimensions");
        }

        public LaunchOptions setY(int i3, int i16) {
            if (i3 >= 0 && i16 > i3) {
                this.ystart = i3;
                this.yend = i16;
                return this;
            }
            throw new RSIllegalArgumentException("Invalid dimensions");
        }

        public LaunchOptions setZ(int i3, int i16) {
            if (i3 >= 0 && i16 > i3) {
                this.zstart = i3;
                this.zend = i16;
                return this;
            }
            throw new RSIllegalArgumentException("Invalid dimensions");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Script(int i3, RenderScript renderScript) {
        super(i3, renderScript);
        this.mKIDs = new SparseArray<>();
        this.mFIDs = new SparseArray<>();
    }

    public void bindAllocation(Allocation allocation, int i3) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkBindAllocation(allocation, i3);
            return;
        }
        this.mRS.validate();
        if (allocation != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptBindAllocation(getID(renderScript), allocation.getID(this.mRS), i3);
        } else {
            RenderScript renderScript2 = this.mRS;
            renderScript2.nScriptBindAllocation(getID(renderScript2), 0, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldID createFieldID(int i3, Element element) {
        RenderScript renderScript = this.mRS;
        if (RenderScript.isNative) {
            FieldID fieldID = new FieldID(0, renderScript, this, i3);
            ScriptCThunker scriptCThunker = this.mT;
            if (scriptCThunker != null) {
                fieldID.mN = scriptCThunker.thunkCreateFieldID(i3, element);
            }
            this.mFIDs.put(i3, fieldID);
            return fieldID;
        }
        FieldID fieldID2 = this.mFIDs.get(i3);
        if (fieldID2 != null) {
            return fieldID2;
        }
        RenderScript renderScript2 = this.mRS;
        int nScriptFieldIDCreate = renderScript2.nScriptFieldIDCreate(getID(renderScript2), i3);
        if (nScriptFieldIDCreate != 0) {
            FieldID fieldID3 = new FieldID(nScriptFieldIDCreate, this.mRS, this, i3);
            this.mFIDs.put(i3, fieldID3);
            return fieldID3;
        }
        throw new RSDriverException("Failed to create FieldID");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KernelID createKernelID(int i3, int i16, Element element, Element element2) {
        KernelID kernelID = this.mKIDs.get(i3);
        if (kernelID != null) {
            return kernelID;
        }
        RenderScript renderScript = this.mRS;
        if (RenderScript.isNative) {
            KernelID kernelID2 = new KernelID(0, renderScript, this, i3, i16);
            ScriptCThunker scriptCThunker = this.mT;
            if (scriptCThunker != null) {
                kernelID2.mN = scriptCThunker.thunkCreateKernelID(i3, i16, element, element2);
            }
            this.mKIDs.put(i3, kernelID2);
            return kernelID2;
        }
        int nScriptKernelIDCreate = renderScript.nScriptKernelIDCreate(getID(renderScript), i3, i16);
        if (nScriptKernelIDCreate != 0) {
            KernelID kernelID3 = new KernelID(nScriptKernelIDCreate, this.mRS, this, i3, i16);
            this.mKIDs.put(i3, kernelID3);
            return kernelID3;
        }
        throw new RSDriverException("Failed to create KernelID");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forEach(int i3, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkForEach(i3, allocation, allocation2, fieldPacker);
            return;
        }
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        int id5 = allocation != null ? allocation.getID(this.mRS) : 0;
        int id6 = allocation2 != null ? allocation2.getID(this.mRS) : 0;
        byte[] data = fieldPacker != null ? fieldPacker.getData() : null;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptForEach(getID(renderScript), i3, id5, id6, data);
    }

    protected void invoke(int i3) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkInvoke(i3);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptInvoke(getID(renderScript), i3);
        }
    }

    public void setTimeZone(String str) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetTimeZone(str);
            return;
        }
        this.mRS.validate();
        try {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetTimeZone(getID(renderScript), str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void setVar(int i3, float f16) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, f16);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarF(getID(renderScript), i3, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.Script getNObj() {
        return this.mT;
    }

    protected void invoke(int i3, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkInvoke(i3, fieldPacker);
        } else if (fieldPacker != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptInvokeV(getID(renderScript), i3, fieldPacker.getData());
        } else {
            RenderScript renderScript2 = this.mRS;
            renderScript2.nScriptInvoke(getID(renderScript2), i3);
        }
    }

    public void setVar(int i3, double d16) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, d16);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarD(getID(renderScript), i3, d16);
        }
    }

    public void setVar(int i3, int i16) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, i16);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarI(getID(renderScript), i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forEach(int i3, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkForEach(i3, allocation, allocation2, fieldPacker, launchOptions);
            return;
        }
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        if (launchOptions == null) {
            forEach(i3, allocation, allocation2, fieldPacker);
            return;
        }
        int id5 = allocation != null ? allocation.getID(this.mRS) : 0;
        int id6 = allocation2 != null ? allocation2.getID(this.mRS) : 0;
        byte[] data = fieldPacker != null ? fieldPacker.getData() : null;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptForEachClipped(getID(renderScript), i3, id5, id6, data, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend);
    }

    public void setVar(int i3, long j3) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, j3);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarJ(getID(renderScript), i3, j3);
        }
    }

    public void setVar(int i3, boolean z16) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, z16);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarI(getID(renderScript), i3, z16 ? 1 : 0);
        }
    }

    public void setVar(int i3, BaseObj baseObj) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, baseObj);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarObj(getID(renderScript), i3, baseObj == null ? 0 : baseObj.getID(this.mRS));
        }
    }

    public void setVar(int i3, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, fieldPacker);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarV(getID(renderScript), i3, fieldPacker.getData());
        }
    }

    public void setVar(int i3, FieldPacker fieldPacker, Element element, int[] iArr) {
        ScriptCThunker scriptCThunker = this.mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i3, fieldPacker, element, iArr);
        } else {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptSetVarVE(getID(renderScript), i3, fieldPacker.getData(), element.getID(this.mRS), iArr);
        }
    }
}
