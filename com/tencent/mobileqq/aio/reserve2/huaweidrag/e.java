package com.tencent.mobileqq.aio.reserve2.huaweidrag;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/e;", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/c;", "", "b", "I", "a", "()I", "mediaType", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "()Landroid/net/Uri;", "mediaUri", "<init>", "(ILjava/lang/String;Landroid/net/Uri;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mediaType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Uri mediaUri;

    public /* synthetic */ e(int i3, String str, Uri uri, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str, uri);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, uri, Integer.valueOf(i16), defaultConstructorMarker);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mediaType;
    }

    @NotNull
    public final Uri b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Uri) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mediaUri;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, @Nullable String str, @NotNull Uri mediaUri) {
        super(3);
        Intrinsics.checkNotNullParameter(mediaUri, "mediaUri");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, mediaUri);
            return;
        }
        this.mediaType = i3;
        this.path = str;
        this.mediaUri = mediaUri;
    }
}
