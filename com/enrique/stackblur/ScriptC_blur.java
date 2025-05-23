package com.enrique.stackblur;

import android.content.res.Resources;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.FieldPacker;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Script;
import android.support.v8.renderscript.ScriptC;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScriptC_blur extends ScriptC {
    private static final String __rs_resource_name = "blur";
    private static final int mExportForEachIdx_blur_h = 2;
    private static final int mExportForEachIdx_blur_v = 1;
    private static final int mExportVarIdx_gIn = 0;
    private static final int mExportVarIdx_height = 2;
    private static final int mExportVarIdx_radius = 3;
    private static final int mExportVarIdx_width = 1;
    private Element __ALLOCATION;
    private Element __U32;
    private FieldPacker __rs_fp_ALLOCATION;
    private FieldPacker __rs_fp_U32;
    private Allocation mExportVar_gIn;
    private long mExportVar_height;
    private long mExportVar_radius;
    private long mExportVar_width;

    public ScriptC_blur(RenderScript renderScript) {
        this(renderScript, renderScript.getApplicationContext().getResources(), renderScript.getApplicationContext().getResources().getIdentifier("blur", "raw", renderScript.getApplicationContext().getPackageName()));
    }

    public void forEach_blur_h(Allocation allocation) {
        forEach_blur_h(allocation, null);
    }

    public void forEach_blur_v(Allocation allocation) {
        forEach_blur_v(allocation, null);
    }

    public Script.FieldID getFieldID_gIn() {
        return createFieldID(0, null);
    }

    public Script.FieldID getFieldID_height() {
        return createFieldID(2, null);
    }

    public Script.FieldID getFieldID_radius() {
        return createFieldID(3, null);
    }

    public Script.FieldID getFieldID_width() {
        return createFieldID(1, null);
    }

    public Script.KernelID getKernelID_blur_h() {
        return createKernelID(2, 33, null, null);
    }

    public Script.KernelID getKernelID_blur_v() {
        return createKernelID(1, 33, null, null);
    }

    public Allocation get_gIn() {
        return this.mExportVar_gIn;
    }

    public long get_height() {
        return this.mExportVar_height;
    }

    public long get_radius() {
        return this.mExportVar_radius;
    }

    public long get_width() {
        return this.mExportVar_width;
    }

    public synchronized void set_gIn(Allocation allocation) {
        setVar(0, allocation);
        this.mExportVar_gIn = allocation;
    }

    public synchronized void set_height(long j3) {
        FieldPacker fieldPacker = this.__rs_fp_U32;
        if (fieldPacker != null) {
            fieldPacker.reset();
        } else {
            this.__rs_fp_U32 = new FieldPacker(4);
        }
        this.__rs_fp_U32.addU32(j3);
        setVar(2, this.__rs_fp_U32);
        this.mExportVar_height = j3;
    }

    public synchronized void set_radius(long j3) {
        FieldPacker fieldPacker = this.__rs_fp_U32;
        if (fieldPacker != null) {
            fieldPacker.reset();
        } else {
            this.__rs_fp_U32 = new FieldPacker(4);
        }
        this.__rs_fp_U32.addU32(j3);
        setVar(3, this.__rs_fp_U32);
        this.mExportVar_radius = j3;
    }

    public synchronized void set_width(long j3) {
        FieldPacker fieldPacker = this.__rs_fp_U32;
        if (fieldPacker != null) {
            fieldPacker.reset();
        } else {
            this.__rs_fp_U32 = new FieldPacker(4);
        }
        this.__rs_fp_U32.addU32(j3);
        setVar(1, this.__rs_fp_U32);
        this.mExportVar_width = j3;
    }

    public void forEach_blur_h(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.__U32)) {
            forEach(2, allocation, null, null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U32!");
    }

    public void forEach_blur_v(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.__U32)) {
            forEach(1, allocation, null, null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U32!");
    }

    public ScriptC_blur(RenderScript renderScript, Resources resources, int i3) {
        super(renderScript, resources, i3);
        this.__ALLOCATION = Element.ALLOCATION(renderScript);
        this.__U32 = Element.U32(renderScript);
    }
}
