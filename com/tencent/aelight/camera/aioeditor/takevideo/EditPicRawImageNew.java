package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Bundle;

/* loaded from: classes32.dex */
public class EditPicRawImageNew extends EditPicRawImage {
    public EditPicRawImageNew(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
    public void r0(int i3, int i16) {
        super.r0(i3, i16);
        Bundle bundle = this.mParent.C.f204058h;
        if (bundle != null) {
            bundle.putString("extra_media_size", i3 + "*" + i16);
        }
        w0();
    }
}
