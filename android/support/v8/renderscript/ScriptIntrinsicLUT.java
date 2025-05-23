package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptIntrinsicLUT extends ScriptIntrinsic {
    private final byte[] mCache;
    private boolean mDirty;
    private final Matrix4f mMatrix;
    private Allocation mTables;

    /* JADX INFO: Access modifiers changed from: protected */
    public ScriptIntrinsicLUT(int i3, RenderScript renderScript) {
        super(i3, renderScript);
        this.mMatrix = new Matrix4f();
        this.mCache = new byte[1024];
        this.mDirty = true;
    }

    public static ScriptIntrinsicLUT create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            return ScriptIntrinsicLUTThunker.create(renderScript, element);
        }
        ScriptIntrinsicLUT scriptIntrinsicLUT = new ScriptIntrinsicLUT(renderScript.nScriptIntrinsicCreate(3, element.getID(renderScript)), renderScript);
        scriptIntrinsicLUT.mTables = Allocation.createSized(renderScript, Element.U8(renderScript), 1024);
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr = scriptIntrinsicLUT.mCache;
            byte b16 = (byte) i3;
            bArr[i3] = b16;
            bArr[i3 + 256] = b16;
            bArr[i3 + 512] = b16;
            bArr[i3 + 768] = b16;
        }
        scriptIntrinsicLUT.setVar(0, scriptIntrinsicLUT.mTables);
        return scriptIntrinsicLUT;
    }

    private void validate(int i3, int i16) {
        if (i3 >= 0 && i3 <= 255) {
            if (i16 >= 0 && i16 <= 255) {
                return;
            } else {
                throw new RSIllegalArgumentException("Value out of range (0-255).");
            }
        }
        throw new RSIllegalArgumentException("Index out of range (0-255).");
    }

    public void forEach(Allocation allocation, Allocation allocation2) {
        if (this.mDirty) {
            this.mDirty = false;
            this.mTables.copyFromUnchecked(this.mCache);
        }
        forEach(0, allocation, allocation2, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, null, null);
    }

    public void setAlpha(int i3, int i16) {
        validate(i3, i16);
        this.mCache[i3 + 768] = (byte) i16;
        this.mDirty = true;
    }

    public void setBlue(int i3, int i16) {
        validate(i3, i16);
        this.mCache[i3 + 512] = (byte) i16;
        this.mDirty = true;
    }

    public void setGreen(int i3, int i16) {
        validate(i3, i16);
        this.mCache[i3 + 256] = (byte) i16;
        this.mDirty = true;
    }

    public void setRed(int i3, int i16) {
        validate(i3, i16);
        this.mCache[i3] = (byte) i16;
        this.mDirty = true;
    }
}
