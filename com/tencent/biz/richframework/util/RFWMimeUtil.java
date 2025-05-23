package com.tencent.biz.richframework.util;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.media.MediaType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMimeUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.richframework.util.RFWMimeUtil$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$biz$richframework$media$MediaType;

        static {
            int[] iArr = new int[MediaType.values().length];
            $SwitchMap$com$tencent$biz$richframework$media$MediaType = iArr;
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$biz$richframework$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$biz$richframework$media$MediaType[MediaType.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String getMimeByBitmapFactory(String str) {
        String str2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str3 = options.outMimeType;
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getMimeByBitmapFactory] mime: ");
        if (TextUtils.isEmpty(str3)) {
            str2 = "unknown";
        } else {
            str2 = str3;
        }
        sb5.append(str2);
        objArr[0] = sb5.toString();
        RFWLog.d("RFWMimeUtil", i3, objArr);
        return str3;
    }

    private static String getMimeByMediaRetriever(String str) {
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            try {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(str);
                    String extractMetadata = mediaMetadataRetriever2.extractMetadata(12);
                    int i3 = RFWLog.USR;
                    Object[] objArr = new Object[1];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[getMimeByMediaRetriever] mime: ");
                    if (TextUtils.isEmpty(extractMetadata)) {
                        str2 = "unknown";
                    } else {
                        str2 = extractMetadata;
                    }
                    sb5.append(str2);
                    objArr[0] = sb5.toString();
                    RFWLog.d("RFWMimeUtil", i3, objArr);
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception e16) {
                        RFWLog.e("RFWMimeUtil", RFWLog.USR, "[getMimeByMediaRetriever] release error: " + e16);
                    }
                    return extractMetadata;
                } catch (Exception e17) {
                    e = e17;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    RFWLog.e("RFWMimeUtil", RFWLog.USR, "[getMimeByMediaRetriever] e: " + e);
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                            return "";
                        } catch (Exception e18) {
                            RFWLog.e("RFWMimeUtil", RFWLog.USR, "[getMimeByMediaRetriever] release error: " + e18);
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e19) {
                            RFWLog.e("RFWMimeUtil", RFWLog.USR, "[getMimeByMediaRetriever] release error: " + e19);
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String getMimeByMimeTool(String str) {
        String mimeByBitmapFactory = getMimeByBitmapFactory(str);
        if (TextUtils.isEmpty(mimeByBitmapFactory)) {
            return getMimeByMediaRetriever(str);
        }
        return mimeByBitmapFactory;
    }

    public static String getMimePrefixByMediaType(MediaType mediaType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$biz$richframework$media$MediaType[mediaType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "audio";
            }
            return "video";
        }
        return "image";
    }
}
