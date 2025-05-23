package com.tencent.mobileqq.opr.helper.repair.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0097\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u0003H\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;", "", "albumId", "", "lloc", "url", "localPath", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "getLloc", "getLocalPath", "getTaskId", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class ImageInfo {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String albumId;

    @NotNull
    private final String lloc;

    @Nullable
    private final String localPath;

    @Nullable
    private final String taskId;

    @NotNull
    private final String url;

    public ImageInfo(@NotNull String albumId, @NotNull String lloc, @NotNull String url, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(url, "url");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, albumId, lloc, url, str, str2);
            return;
        }
        this.albumId = albumId;
        this.lloc = lloc;
        this.url = url;
        this.localPath = str;
        this.taskId = str2;
    }

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageInfo.albumId;
        }
        if ((i3 & 2) != 0) {
            str2 = imageInfo.lloc;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = imageInfo.url;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = imageInfo.localPath;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = imageInfo.taskId;
        }
        return imageInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.albumId;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.lloc;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.url;
    }

    @Nullable
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.localPath;
    }

    @Nullable
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.taskId;
    }

    @NotNull
    public final ImageInfo copy(@NotNull String albumId, @NotNull String lloc, @NotNull String url, @Nullable String localPath, @Nullable String taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ImageInfo) iPatchRedirector.redirect((short) 16, this, albumId, lloc, url, localPath, taskId);
        }
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ImageInfo(albumId, lloc, url, localPath, taskId);
    }

    @NativeMethodProxy(enabled = false)
    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other == null) {
            cls = null;
        } else {
            cls = other.getClass();
        }
        if (!Intrinsics.areEqual(ImageInfo.class, cls)) {
            return false;
        }
        if (other != null) {
            ImageInfo imageInfo = (ImageInfo) other;
            if (Intrinsics.areEqual(this.albumId, imageInfo.albumId) && Intrinsics.areEqual(this.lloc, imageInfo.lloc) && Intrinsics.areEqual(this.url, imageInfo.url) && Intrinsics.areEqual(this.localPath, imageInfo.localPath) && Intrinsics.areEqual(this.taskId, imageInfo.taskId)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.opr.helper.repair.model.ImageInfo");
    }

    @NotNull
    public final String getAlbumId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.albumId;
    }

    @NotNull
    public final String getLloc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.lloc;
    }

    @Nullable
    public final String getLocalPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.localPath;
    }

    @Nullable
    public final String getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.taskId;
    }

    @NotNull
    public final String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.url;
    }

    @NativeMethodProxy(enabled = false)
    public int hashCode() {
        int hashCode;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int hashCode2 = this.albumId.hashCode() * 31;
        String str = this.lloc;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.url.hashCode()) * 31;
        String str2 = this.localPath;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode3 + i3) * 31;
        String str3 = this.taskId;
        if (str3 != null) {
            i16 = str3.hashCode();
        }
        return i17 + i16;
    }

    @NativeMethodProxy(enabled = false)
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "ImageInfo(albumId=" + this.albumId + ", lloc:" + this.lloc + ", url=" + this.url + ", localPath=" + ((Object) this.localPath) + ", taskId=" + ((Object) this.taskId);
    }

    public /* synthetic */ ImageInfo(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
