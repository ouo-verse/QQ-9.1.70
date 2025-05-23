package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateUploadTaskReq {
    public BusiScene scene = BusiScene.values()[0];
    public FileSet fileSet = new FileSet();

    public FileSet getFileSet() {
        return this.fileSet;
    }

    public BusiScene getScene() {
        return this.scene;
    }
}
