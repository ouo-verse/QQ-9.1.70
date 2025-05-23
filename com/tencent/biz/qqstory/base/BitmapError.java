package com.tencent.biz.qqstory.base;

import com.tribe.async.reactive.Optional;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapError extends Error {
    public static final int REASON_BITMAP_COPY_FAIL = 3;
    public static final int REASON_BITMAP_ERR_WIDTH_HEIGHT = 8;
    public static final int REASON_BITMAP_GET_ERR = 7;
    public static final int REASON_BITMAP_LOAD_FAIL = 2;
    public static final int REASON_BITMAP_RENDER = 9;
    public static final int REASON_DECODE_ERROR = 6;
    public static final int REASON_FILE_NOT_FOUND = 4;
    public static final int REASON_IO_ERROR = 4;
    public static final int REASON_OUT_OF_MEM = 5;
    public static final int REASON_UNKNOWN = 0;
    public static final int REASON_URL_EMPTY = 1;
    public Optional<String> detail = Optional.empty();
    public final int reason;
    public final String source;

    public BitmapError(String str, int i3) {
        this.reason = i3;
        this.source = str;
    }

    public void setDetail(String str) {
        this.detail = Optional.ofNullable(str);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BimapError { reason = " + this.reason + ", source = " + this.source + ", detail = " + this.detail.orElse("(no detail)") + " }";
    }
}
