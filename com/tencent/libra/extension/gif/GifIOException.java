package com.tencent.libra.extension.gif;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;

    @NonNull
    public final GifError reason;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifIOException(int i3, String str) {
        this.reason = GifError.fromCode(i3);
        this.mErrnoMessage = str;
    }

    static GifIOException fromCode(int i3) {
        if (i3 == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i3, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + MsgSummary.STR_COLON + this.mErrnoMessage;
    }
}
