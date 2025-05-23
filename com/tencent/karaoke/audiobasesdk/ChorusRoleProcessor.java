package com.tencent.karaoke.audiobasesdk;

/* loaded from: classes7.dex */
public class ChorusRoleProcessor {
    private static final String TAG = "ChorusRoleProcessor";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();

    private native String[] native_lineMappingRole(byte[] bArr, int[] iArr);

    public String[] lineMappingRole(byte[] bArr, int[] iArr) {
        if (mIsLoaded) {
            return native_lineMappingRole(bArr, iArr);
        }
        return null;
    }
}
