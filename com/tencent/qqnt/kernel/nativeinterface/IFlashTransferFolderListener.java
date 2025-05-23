package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFlashTransferFolderListener {
    void onFolderProgressChanged(ArrayList<File> arrayList);

    void onFolderStatusInfoUpdate(ArrayList<File> arrayList);
}
