package android.support.v8.renderscript;

import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptC extends Script {
    private static final String TAG = "ScriptC";

    protected ScriptC(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    private static synchronized int internalCreate(RenderScript renderScript, Resources resources, int i3) {
        int nScriptCCreate;
        synchronized (ScriptC.class) {
            InputStream openRawResource = resources.openRawResource(i3);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    int i16 = 0;
                    while (true) {
                        int length = bArr.length - i16;
                        if (length == 0) {
                            int length2 = bArr.length * 2;
                            byte[] bArr2 = new byte[length2];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            length = length2 - i16;
                            bArr = bArr2;
                        }
                        int read = openRawResource.read(bArr, i16, length);
                        if (read <= 0) {
                            nScriptCCreate = renderScript.nScriptCCreate(resources.getResourceEntryName(i3), renderScript.getApplicationContext().getCacheDir().toString(), bArr, i16);
                        } else {
                            i16 += read;
                        }
                    }
                } finally {
                    openRawResource.close();
                }
            } catch (IOException unused) {
                throw new Resources.NotFoundException();
            }
        }
        return nScriptCCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ScriptC(RenderScript renderScript, Resources resources, int i3) {
        super(0, renderScript);
        if (RenderScript.isNative) {
            this.mT = new ScriptCThunker((RenderScriptThunker) renderScript, resources, i3);
            return;
        }
        int internalCreate = internalCreate(renderScript, resources, i3);
        if (internalCreate != 0) {
            setID(internalCreate);
            return;
        }
        throw new RSRuntimeException("Loading of ScriptC script failed.");
    }
}
