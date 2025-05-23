package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildFileUploadListener {
    void onFileCalcHashSuccess(GProUploadFileInfo gProUploadFileInfo);

    void onFileGroupUploadSizeChanged(String str, long j3, long j16);

    void onFileGroupUploadSpeedChanged(String str, long j3, HashMap<String, Long> hashMap);

    void onFileGroupUploadStatusChanged(GProUploadFileGroupInfo gProUploadFileGroupInfo);

    void onFileUploadStatusChanged(GProUploadFileInfo gProUploadFileInfo);
}
