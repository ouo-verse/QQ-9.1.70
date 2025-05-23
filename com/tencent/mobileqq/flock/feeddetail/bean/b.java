package com.tencent.mobileqq.flock.feeddetail.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.i;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/bean/b;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "c", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "b", "a", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "e", "", "toString", "", "hashCode", "other", "", "equals", "Ly45/i;", "Ly45/i;", "d", "()Ly45/i;", "image", "<init>", "(Ly45/i;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i image;

    public b(@NotNull i image) {
        Intrinsics.checkNotNullParameter(image, "image");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) image);
        } else {
            this.image = image;
        }
    }

    private final RFWLayerPicInfo.RFWPicInfo a() {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(this.image.f449405c);
        rFWPicInfo.setLocalPath("");
        rFWPicInfo.setWidth(this.image.f449403a);
        rFWPicInfo.setHeight(this.image.f449404b);
        return rFWPicInfo;
    }

    private final RFWLayerPicInfo.RFWPicInfo b() {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(this.image.f449405c);
        rFWPicInfo.setLocalPath("");
        return rFWPicInfo;
    }

    private final RFWLayerPicInfo c() {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId("");
        rFWLayerPicInfo.setBigPicInfo(a());
        rFWLayerPicInfo.setDownloadPicInfo(b());
        return rFWLayerPicInfo;
    }

    @NotNull
    public final i d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.image;
    }

    @NotNull
    public final RFWLayerItemMediaInfo e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RFWLayerItemMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setMediaId("");
        rFWLayerItemMediaInfo.setLayerPicInfo(c());
        return rFWLayerItemMediaInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof b) && Intrinsics.areEqual(this.image, ((b) other).image)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.image.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "FlockFeedDetailMediaBean(image=" + this.image + ")";
    }
}
