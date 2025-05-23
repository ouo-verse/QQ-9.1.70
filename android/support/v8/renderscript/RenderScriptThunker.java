package android.support.v8.renderscript;

import android.content.Context;
import android.renderscript.RenderScript;
import android.support.v8.renderscript.RenderScript;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class RenderScriptThunker extends RenderScript {
    android.renderscript.RenderScript mN;

    RenderScriptThunker(Context context) {
        super(context);
        RenderScript.isNative = true;
    }

    public static RenderScript create(Context context, int i3) {
        RenderScriptThunker renderScriptThunker = new RenderScriptThunker(context);
        renderScriptThunker.mN = android.renderscript.RenderScript.create(context, i3);
        return renderScriptThunker;
    }

    @Override // android.support.v8.renderscript.RenderScript
    public void contextDump() {
        this.mN.contextDump();
    }

    @Override // android.support.v8.renderscript.RenderScript
    public void destroy() {
        this.mN.destroy();
        this.mN = null;
    }

    @Override // android.support.v8.renderscript.RenderScript
    public void finish() {
        this.mN.finish();
    }

    @Override // android.support.v8.renderscript.RenderScript
    public void setPriority(RenderScript.Priority priority) {
        if (priority == RenderScript.Priority.LOW) {
            this.mN.setPriority(RenderScript.Priority.LOW);
        }
        if (priority == RenderScript.Priority.NORMAL) {
            this.mN.setPriority(RenderScript.Priority.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.RenderScript
    public void validate() {
        if (this.mN != null) {
        } else {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }
}
