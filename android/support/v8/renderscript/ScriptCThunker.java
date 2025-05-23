package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.Script;
import android.support.v8.renderscript.Script;

/* compiled from: P */
/* loaded from: classes.dex */
class ScriptCThunker extends android.renderscript.ScriptC {
    private static final String TAG = "ScriptC";

    /* JADX INFO: Access modifiers changed from: protected */
    public ScriptCThunker(RenderScriptThunker renderScriptThunker, Resources resources, int i3) {
        super(renderScriptThunker.mN, resources, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkBindAllocation(Allocation allocation, int i3) {
        android.renderscript.Allocation allocation2;
        if (allocation != null) {
            allocation2 = ((AllocationThunker) allocation).mN;
        } else {
            allocation2 = null;
        }
        bindAllocation(allocation2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Script.FieldID thunkCreateFieldID(int i3, Element element) {
        return createFieldID(i3, ((ElementThunker) element).getNObj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Script.KernelID thunkCreateKernelID(int i3, int i16, Element element, Element element2) {
        android.renderscript.Element element3;
        android.renderscript.Element element4 = null;
        if (element != null) {
            element3 = ((ElementThunker) element).mN;
        } else {
            element3 = null;
        }
        if (element2 != null) {
            element4 = ((ElementThunker) element2).mN;
        }
        return createKernelID(i3, i16, element3, element4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkForEach(int i3, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        forEach(i3, allocation != null ? ((AllocationThunker) allocation).mN : null, allocation2 != null ? ((AllocationThunker) allocation2).mN : null, fieldPacker != null ? new android.renderscript.FieldPacker(fieldPacker.getData()) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkInvoke(int i3) {
        invoke(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetTimeZone(String str) {
        setTimeZone(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, float f16) {
        setVar(i3, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkInvoke(int i3, FieldPacker fieldPacker) {
        invoke(i3, new android.renderscript.FieldPacker(fieldPacker.getData()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, double d16) {
        setVar(i3, d16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, int i16) {
        setVar(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, long j3) {
        setVar(i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkForEach(int i3, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, Script.LaunchOptions launchOptions) {
        Script.LaunchOptions launchOptions2;
        if (launchOptions != null) {
            Script.LaunchOptions launchOptions3 = new Script.LaunchOptions();
            if (launchOptions.getXEnd() > 0) {
                launchOptions3.setX(launchOptions.getXStart(), launchOptions.getXEnd());
            }
            if (launchOptions.getYEnd() > 0) {
                launchOptions3.setY(launchOptions.getYStart(), launchOptions.getYEnd());
            }
            if (launchOptions.getZEnd() > 0) {
                launchOptions3.setZ(launchOptions.getZStart(), launchOptions.getZEnd());
            }
            launchOptions2 = launchOptions3;
        } else {
            launchOptions2 = null;
        }
        forEach(i3, allocation != null ? ((AllocationThunker) allocation).mN : null, allocation2 != null ? ((AllocationThunker) allocation2).mN : null, fieldPacker != null ? new android.renderscript.FieldPacker(fieldPacker.getData()) : null, launchOptions2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, boolean z16) {
        setVar(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, BaseObj baseObj) {
        if (baseObj == null) {
            setVar(i3, 0);
        } else {
            setVar(i3, baseObj.getNObj());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, FieldPacker fieldPacker) {
        setVar(i3, new android.renderscript.FieldPacker(fieldPacker.getData()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void thunkSetVar(int i3, FieldPacker fieldPacker, Element element, int[] iArr) {
        setVar(i3, new android.renderscript.FieldPacker(fieldPacker.getData()), ((ElementThunker) element).mN, iArr);
    }
}
