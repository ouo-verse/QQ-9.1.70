package com.qzone.album.protocol;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetDITFontListRequest extends QzoneGetFontListRequest {
    public QzoneGetDITFontListRequest(long j3, int i3) {
        super(j3, i3);
    }

    @Override // com.qzone.album.protocol.QzoneGetFontListRequest
    protected String getCateId() {
        return "FacadeDIYFontList";
    }
}
