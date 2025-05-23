package com.tencent.aelight.camera.ae.album.data;

import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumImageModel extends AEAlbumMediaBaseModel {
    private EditorPicInfo editorPicInfo;

    public AEAlbumImageModel(String str, EditorPicInfo editorPicInfo) {
        super(str);
        this.editorPicInfo = editorPicInfo;
    }

    public EditorPicInfo getEditorPicInfo() {
        return this.editorPicInfo;
    }

    public void setEditorPicInfo(EditorPicInfo editorPicInfo) {
        this.editorPicInfo = editorPicInfo;
    }
}
