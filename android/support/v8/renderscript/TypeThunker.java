package android.support.v8.renderscript;

import android.renderscript.Type;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class TypeThunker extends Type {
    static HashMap<android.renderscript.Type, Type> mMap = new HashMap<>();
    android.renderscript.Type mN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeThunker(RenderScript renderScript, android.renderscript.Type type) {
        super(0, renderScript);
        this.mN = type;
        internalCalc();
        this.mElement = new ElementThunker(renderScript, type.getElement());
        synchronized (mMap) {
            mMap.put(this.mN, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type create(RenderScript renderScript, Element element, int i3, int i16, int i17, boolean z16, boolean z17, int i18) {
        Type.Builder builder = new Type.Builder(((RenderScriptThunker) renderScript).mN, ((ElementThunker) element).mN);
        if (i3 > 0) {
            builder.setX(i3);
        }
        if (i16 > 0) {
            builder.setY(i16);
        }
        if (i17 > 0) {
            builder.setZ(i17);
        }
        if (z16) {
            builder.setMipmaps(z16);
        }
        if (z17) {
            builder.setFaces(z17);
        }
        if (i18 > 0) {
            builder.setYuvFormat(i18);
        }
        TypeThunker typeThunker = new TypeThunker(renderScript, builder.create());
        typeThunker.internalCalc();
        return typeThunker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type find(android.renderscript.Type type) {
        return mMap.get(type);
    }

    void internalCalc() {
        this.mDimX = this.mN.getX();
        this.mDimY = this.mN.getY();
        this.mDimZ = this.mN.getZ();
        this.mDimFaces = this.mN.hasFaces();
        this.mDimMipmaps = this.mN.hasMipmaps();
        this.mDimYuv = this.mN.getYuv();
        calcElementCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.Type getNObj() {
        return this.mN;
    }
}
