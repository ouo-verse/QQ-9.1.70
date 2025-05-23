package com.tencent.qqnt.qbasealbum.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/MediaFilteringCode;", "", "(Ljava/lang/String;I)V", "MEDIA_UNKNOWN", "MEDIA_VALID", "IMAGE_INVALID_RESOLUTION", "IMAGE_INVALID_RATIO", "IMAGE_EXCEED_SIZE_LIMIT", "VIDEO_INVALID_RESOLUTION", "VIDEO_INVALID_RATIO", "VIDEO_EXCEED_SIZE_LIMIT", "VIDEO_INVALID_MIN_DURATION", "VIDEO_INVALID_MAX_DURATION", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class MediaFilteringCode {
    private static final /* synthetic */ MediaFilteringCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MediaFilteringCode IMAGE_EXCEED_SIZE_LIMIT;
    public static final MediaFilteringCode IMAGE_INVALID_RATIO;
    public static final MediaFilteringCode IMAGE_INVALID_RESOLUTION;
    public static final MediaFilteringCode MEDIA_UNKNOWN;
    public static final MediaFilteringCode MEDIA_VALID;
    public static final MediaFilteringCode VIDEO_EXCEED_SIZE_LIMIT;
    public static final MediaFilteringCode VIDEO_INVALID_MAX_DURATION;
    public static final MediaFilteringCode VIDEO_INVALID_MIN_DURATION;
    public static final MediaFilteringCode VIDEO_INVALID_RATIO;
    public static final MediaFilteringCode VIDEO_INVALID_RESOLUTION;

    private static final /* synthetic */ MediaFilteringCode[] $values() {
        return new MediaFilteringCode[]{MEDIA_UNKNOWN, MEDIA_VALID, IMAGE_INVALID_RESOLUTION, IMAGE_INVALID_RATIO, IMAGE_EXCEED_SIZE_LIMIT, VIDEO_INVALID_RESOLUTION, VIDEO_INVALID_RATIO, VIDEO_EXCEED_SIZE_LIMIT, VIDEO_INVALID_MIN_DURATION, VIDEO_INVALID_MAX_DURATION};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MEDIA_UNKNOWN = new MediaFilteringCode("MEDIA_UNKNOWN", 0);
        MEDIA_VALID = new MediaFilteringCode("MEDIA_VALID", 1);
        IMAGE_INVALID_RESOLUTION = new MediaFilteringCode("IMAGE_INVALID_RESOLUTION", 2);
        IMAGE_INVALID_RATIO = new MediaFilteringCode("IMAGE_INVALID_RATIO", 3);
        IMAGE_EXCEED_SIZE_LIMIT = new MediaFilteringCode("IMAGE_EXCEED_SIZE_LIMIT", 4);
        VIDEO_INVALID_RESOLUTION = new MediaFilteringCode("VIDEO_INVALID_RESOLUTION", 5);
        VIDEO_INVALID_RATIO = new MediaFilteringCode("VIDEO_INVALID_RATIO", 6);
        VIDEO_EXCEED_SIZE_LIMIT = new MediaFilteringCode("VIDEO_EXCEED_SIZE_LIMIT", 7);
        VIDEO_INVALID_MIN_DURATION = new MediaFilteringCode("VIDEO_INVALID_MIN_DURATION", 8);
        VIDEO_INVALID_MAX_DURATION = new MediaFilteringCode("VIDEO_INVALID_MAX_DURATION", 9);
        $VALUES = $values();
    }

    MediaFilteringCode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MediaFilteringCode valueOf(String str) {
        return (MediaFilteringCode) Enum.valueOf(MediaFilteringCode.class, str);
    }

    public static MediaFilteringCode[] values() {
        return (MediaFilteringCode[]) $VALUES.clone();
    }
}
