package android.support.v8.renderscript;

/* compiled from: P */
/* loaded from: classes.dex */
public class BaseObj {
    private boolean mDestroyed;
    private int mID;
    RenderScript mRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseObj(int i3, RenderScript renderScript) {
        renderScript.validate();
        this.mRS = renderScript;
        this.mID = i3;
        this.mDestroyed = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkValid() {
        if (this.mID == 0 && getNObj() == null) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    public synchronized void destroy() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            this.mRS.nObjDestroy(this.mID);
        } else {
            throw new RSInvalidStateException("Object already destroyed.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass() && this.mID == ((BaseObj) obj).mID) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!this.mDestroyed) {
            if (this.mID != 0 && this.mRS.isAlive()) {
                this.mRS.nObjDestroy(this.mID);
            }
            this.mRS = null;
            this.mID = 0;
            this.mDestroyed = true;
        }
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getID(RenderScript renderScript) {
        this.mRS.validate();
        if (RenderScript.isNative) {
            if (getNObj() != null) {
                return getNObj().hashCode();
            }
        }
        if (!this.mDestroyed) {
            int i3 = this.mID;
            if (i3 != 0) {
                if (renderScript != null && renderScript != this.mRS) {
                    throw new RSInvalidStateException("using object with mismatched context.");
                }
                return i3;
            }
            throw new RSRuntimeException("Internal error: Object id 0.");
        }
        throw new RSInvalidStateException("using a destroyed object.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.renderscript.BaseObj getNObj() {
        return null;
    }

    public int hashCode() {
        return this.mID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setID(int i3) {
        if (this.mID == 0) {
            this.mID = i3;
            return;
        }
        throw new RSRuntimeException("Internal Error, reset of object ID.");
    }
}
