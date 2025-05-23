package com.tencent.qqnt.qbasealbum.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/MediaMimeType;", "", "(Ljava/lang/String;I)V", "IMAGE_JPEG", "IMAGE_PNG", "IMAGE_GIF", "IMAGE_WEBP", "IMAGE_HEIF", "VIDEO_MP4", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class MediaMimeType {
    private static final /* synthetic */ MediaMimeType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MediaMimeType IMAGE_GIF;
    public static final MediaMimeType IMAGE_HEIF;
    public static final MediaMimeType IMAGE_JPEG;
    public static final MediaMimeType IMAGE_PNG;
    public static final MediaMimeType IMAGE_WEBP;
    public static final MediaMimeType VIDEO_MP4;

    private static final /* synthetic */ MediaMimeType[] $values() {
        return new MediaMimeType[]{IMAGE_JPEG, IMAGE_PNG, IMAGE_GIF, IMAGE_WEBP, IMAGE_HEIF, VIDEO_MP4};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        IMAGE_JPEG = new MediaMimeType("IMAGE_JPEG", 0);
        IMAGE_PNG = new MediaMimeType("IMAGE_PNG", 1);
        IMAGE_GIF = new MediaMimeType("IMAGE_GIF", 2);
        IMAGE_WEBP = new MediaMimeType("IMAGE_WEBP", 3);
        IMAGE_HEIF = new MediaMimeType("IMAGE_HEIF", 4);
        VIDEO_MP4 = new MediaMimeType("VIDEO_MP4", 5);
        $VALUES = $values();
    }

    MediaMimeType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MediaMimeType valueOf(String str) {
        return (MediaMimeType) Enum.valueOf(MediaMimeType.class, str);
    }

    public static MediaMimeType[] values() {
        return (MediaMimeType[]) $VALUES.clone();
    }
}
