package com.tencent.qqnt.http.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/http/download/DownloadException;", "Ljava/io/IOException;", "errorCode", "", "e", "(ILjava/io/IOException;)V", "(I)V", "getErrorCode", "()I", "httpCode", "getHttpCode", "()Ljava/lang/Integer;", "setHttpCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "http_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class DownloadException extends IOException {
    static IPatchRedirector $redirector_;
    private final int errorCode;

    @Nullable
    private Integer httpCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadException(int i3, @NotNull IOException e16) {
        super(e16);
        Intrinsics.checkNotNullParameter(e16, "e");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) e16);
        }
    }

    public final int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    @Nullable
    public final Integer getHttpCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.httpCode;
    }

    public final void setHttpCode(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
        } else {
            this.httpCode = num;
        }
    }

    public DownloadException(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }
}
