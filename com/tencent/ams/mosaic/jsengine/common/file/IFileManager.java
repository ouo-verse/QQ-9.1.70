package com.tencent.ams.mosaic.jsengine.common.file;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IFileManager {
    String getExternalPath();

    IFile getFile(String str);

    String getSDKRootPath();

    String getSandboxPath();
}
