package com.tencent.qqnt.qbasealbum.albumlist.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.db.JobDbManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/b;", "", "", "", "b", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "PROJECTION_BUCKET", "c", "VIDEO_PROJECTION_BUCKET", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f360875a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] PROJECTION_BUCKET;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] VIDEO_PROJECTION_BUCKET;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f360875a = new b();
        PROJECTION_BUCKET = new String[]{"bucket_id", "bucket_display_name", "_id", "date_modified", "_data", "orientation", JobDbManager.COL_UP_MIME_TYPE, "width", "height"};
        VIDEO_PROJECTION_BUCKET = new String[]{"bucket_id", "bucket_display_name", "_id", "date_modified", "_data", JobDbManager.COL_UP_MIME_TYPE, "width", "height"};
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PROJECTION_BUCKET;
    }

    @NotNull
    public final String[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return VIDEO_PROJECTION_BUCKET;
    }
}
