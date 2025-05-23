package com.tencent.qqnt.qbasealbum.albumlist.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.model.MediaMimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/a;", "", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "filter", "", "a", "b", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360874a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f360874a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@Nullable MediaFilter filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) filter);
        }
        if (filter == null) {
            return "_size>0 and (mime_type LIKE '%image/%')";
        }
        StringBuilder sb5 = new StringBuilder("_size>0");
        if (filter.j() != Long.MAX_VALUE) {
            sb5.append(" and _size<" + filter.j());
        }
        if (filter.g() > 0) {
            sb5.append(" and (width>" + filter.g());
            sb5.append(" or width IS NULL)");
        }
        if (filter.c() != Integer.MAX_VALUE) {
            sb5.append(" and (width<" + filter.c());
            sb5.append(" or width IS NULL)");
        }
        if (filter.e() > 0) {
            sb5.append(" and (height>" + filter.e());
            sb5.append(" or height IS NULL)");
        }
        if (filter.a() != Integer.MAX_VALUE) {
            sb5.append(" and (height<" + filter.a());
            sb5.append(" or height IS NULL)");
        }
        sb5.append(" and (mime_type LIKE '%image/%'");
        if (filter.k().contains(MediaMimeType.IMAGE_GIF)) {
            sb5.append(" or mime_type='image/gif' or mime_type='image/gif'");
        }
        if (filter.k().contains(MediaMimeType.IMAGE_HEIF)) {
            sb5.append(" or mime_type='image/heif' or mime_type='image/heic'");
        }
        if (filter.k().contains(MediaMimeType.IMAGE_PNG)) {
            sb5.append(" or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type='image/png'");
        }
        if (filter.k().contains(MediaMimeType.IMAGE_WEBP)) {
            sb5.append(" or mime_type='image/webp'");
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "selection.toString()");
        return sb6;
    }

    @NotNull
    public final String b(@Nullable MediaFilter filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) filter);
        }
        if (filter == null) {
            return "_size>0 and mime_type='video/mp4')";
        }
        StringBuilder sb5 = new StringBuilder("_size>0 and mime_type='video/mp4'");
        if (filter.t() != Long.MAX_VALUE) {
            sb5.append(" and _size<" + filter.t());
        }
        if (filter.s() > 0) {
            sb5.append(" and (width>" + filter.s());
            sb5.append(" or width IS NULL)");
        }
        if (filter.o() != Integer.MAX_VALUE) {
            sb5.append(" and (width<" + filter.o());
            sb5.append(" or width IS NULL)");
        }
        if (filter.q() > 0) {
            sb5.append(" and (height>" + filter.q());
            sb5.append(" or height IS NULL)");
        }
        if (filter.m() != Integer.MAX_VALUE) {
            sb5.append(" and (height<" + filter.m());
            sb5.append(" or height IS NULL)");
        }
        if (filter.p() > 0) {
            sb5.append(" and (duration>" + filter.p());
        }
        if (filter.l() > 0) {
            sb5.append(" and (duration<" + filter.l());
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "selection.toString()");
        return sb6;
    }
}
