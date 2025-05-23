package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

/* loaded from: classes9.dex */
final class VFSNativeAPI {
    private static final int ALL_SUPPORTED_FLAGS = 1603;
    private static final int O_ACCMODE = 3;
    private static final int O_APPEND = 1024;
    private static final int O_CREAT = 64;
    private static final int O_RDONLY = 0;
    private static final int O_RDWR = 2;
    private static final int O_TRUNC = 512;
    private static final int O_WRONLY = 1;
    private static final String TAG = "VFS.VFSNativeAPI";

    VFSNativeAPI() {
    }

    static int openFd(String str, int i3) {
        String str2;
        if ((i3 & (-1604)) == 0) {
            int i16 = i3 & 3;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        str2 = "rw";
                    } else {
                        throw new IllegalArgumentException("Invalid access mode: " + i3);
                    }
                } else {
                    str2 = "w";
                }
            } else {
                str2 = "r";
            }
            if ((i3 & 512) != 0) {
                str2 = str2 + "t";
            }
            if ((i3 & 1024) != 0) {
                str2 = str2 + "a";
            }
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                try {
                    parcelFileDescriptor = VFSFileOp.openFileDescriptor(str, str2);
                    if (parcelFileDescriptor != null) {
                        return parcelFileDescriptor.detachFd();
                    }
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "Failed to open file descriptor for file: " + str, e16);
                }
                return -1;
            } finally {
                VFSUtils.closeQuietly(parcelFileDescriptor);
            }
        }
        throw new IllegalArgumentException("Flags unsupported: " + i3);
    }
}
