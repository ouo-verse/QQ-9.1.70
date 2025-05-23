package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class InvalidMediaTypeException extends IllegalArgumentException {
    private String mMediaType;

    public InvalidMediaTypeException(String str, String str2) {
        super("Invalid media type \"" + str + "\": " + str2);
        this.mMediaType = str;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public InvalidMediaTypeException(InvalidMimeTypeException invalidMimeTypeException) {
        super(invalidMimeTypeException.getMessage(), invalidMimeTypeException);
        this.mMediaType = invalidMimeTypeException.getMimeType();
    }
}
