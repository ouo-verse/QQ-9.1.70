package com.tencent.component.media;

import com.tencent.libra.util.ImageContentType;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MediaFile {
    public static final int FILE_TYPE_3GPP = 23;
    public static final int FILE_TYPE_3GPP2 = 24;
    public static final int FILE_TYPE_AAC = 8;
    public static final int FILE_TYPE_AMR = 4;
    public static final int FILE_TYPE_ASF = 26;
    public static final int FILE_TYPE_AVI = 29;
    public static final int FILE_TYPE_AWB = 5;
    public static final int FILE_TYPE_BMP = 34;
    public static final int FILE_TYPE_FL = 51;
    public static final int FILE_TYPE_FLAC = 10;
    public static final int FILE_TYPE_FLV = 201;
    public static final int FILE_TYPE_GIF = 32;
    public static final int FILE_TYPE_HTML = 101;
    public static final int FILE_TYPE_HTTPLIVE = 44;
    public static final int FILE_TYPE_IMY = 13;
    public static final int FILE_TYPE_JPEG = 31;
    public static final int FILE_TYPE_M3U = 41;
    public static final int FILE_TYPE_M4A = 2;
    public static final int FILE_TYPE_M4V = 22;
    public static final int FILE_TYPE_MID = 11;
    public static final int FILE_TYPE_MKA = 9;
    public static final int FILE_TYPE_MKV = 27;
    public static final int FILE_TYPE_MP2PS = 200;
    public static final int FILE_TYPE_MP2TS = 28;
    public static final int FILE_TYPE_MP3 = 1;
    public static final int FILE_TYPE_MP4 = 21;
    public static final int FILE_TYPE_MS_EXCEL = 105;
    public static final int FILE_TYPE_MS_POWERPOINT = 106;
    public static final int FILE_TYPE_MS_WORD = 104;
    public static final int FILE_TYPE_OGG = 7;
    public static final int FILE_TYPE_PDF = 102;
    public static final int FILE_TYPE_PLS = 42;
    public static final int FILE_TYPE_PNG = 33;
    public static final int FILE_TYPE_QUICKTIME = 202;
    public static final int FILE_TYPE_RMVB = 203;
    public static final int FILE_TYPE_SMF = 12;
    public static final int FILE_TYPE_TEXT = 100;
    public static final int FILE_TYPE_WAV = 3;
    public static final int FILE_TYPE_WBMP = 35;
    public static final int FILE_TYPE_WEBM = 30;
    public static final int FILE_TYPE_WEBP = 36;
    public static final int FILE_TYPE_WMA = 6;
    public static final int FILE_TYPE_WMV = 25;
    public static final int FILE_TYPE_WPL = 43;
    public static final int FILE_TYPE_XML = 103;
    public static final int FILE_TYPE_ZIP = 107;
    private static final int FIRST_AUDIO_FILE_TYPE = 1;
    private static final int FIRST_DRM_FILE_TYPE = 51;
    private static final int FIRST_IMAGE_FILE_TYPE = 31;
    private static final int FIRST_MIDI_FILE_TYPE = 11;
    private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
    private static final int FIRST_VIDEO_FILE_TYPE = 21;
    private static final int FIRST_VIDEO_FILE_TYPE2 = 200;
    private static final int LAST_AUDIO_FILE_TYPE = 10;
    private static final int LAST_DRM_FILE_TYPE = 51;
    private static final int LAST_IMAGE_FILE_TYPE = 36;
    private static final int LAST_MIDI_FILE_TYPE = 13;
    private static final int LAST_PLAYLIST_FILE_TYPE = 44;
    private static final int LAST_VIDEO_FILE_TYPE = 30;
    private static final int LAST_VIDEO_FILE_TYPE2 = 203;
    private static final HashMap<String, MediaFileType> sFileTypeMap = new HashMap<>();
    private static final HashMap<String, Integer> sMimeTypeMap = new HashMap<>();
    private static final HashMap<String, Integer> sFileTypeToFormatMap = new HashMap<>();
    private static final HashMap<String, Integer> sMimeTypeToFormatMap = new HashMap<>();
    private static final HashMap<Integer, String> sFormatToMimeTypeMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class MediaFileType {
        public final int fileType;
        public final String mimeType;

        MediaFileType(int i3, String str) {
            this.fileType = i3;
            this.mimeType = str;
        }
    }

    static {
        addFileType("MP3", 1, "audio/mpeg", 12297);
        addFileType("MPGA", 1, "audio/mpeg", 12297);
        addFileType("M4A", 2, "audio/mp4", 12299);
        addFileType("WAV", 3, "audio/x-wav", 12296);
        addFileType("AMR", 4, "audio/amr");
        addFileType("AWB", 5, "audio/amr-wb");
        if (isWMAEnabled()) {
            addFileType("WMA", 6, "audio/x-ms-wma", MtpConstants.FORMAT_WMA);
        }
        addFileType("OGG", 7, "audio/ogg", MtpConstants.FORMAT_OGG);
        addFileType("OGG", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("OGA", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("AAC", 8, "audio/aac", MtpConstants.FORMAT_AAC);
        addFileType("AAC", 8, "audio/aac-adts", MtpConstants.FORMAT_AAC);
        addFileType("MKA", 9, "audio/x-matroska");
        addFileType("MID", 11, "audio/midi");
        addFileType("MIDI", 11, "audio/midi");
        addFileType("XMF", 11, "audio/midi");
        addFileType("RTTTL", 11, "audio/midi");
        addFileType("SMF", 12, "audio/sp-midi");
        addFileType("IMY", 13, "audio/imelody");
        addFileType("RTX", 11, "audio/midi");
        addFileType("OTA", 11, "audio/midi");
        addFileType("MXMF", 11, "audio/midi");
        addFileType("MPEG", 21, "video/mpeg", 12299);
        addFileType("MPG", 21, "video/mpeg", 12299);
        addFileType(MovieExporter.FILE_TYPE, 21, "video/mp4", 12299);
        addFileType("M4V", 22, "video/mp4", 12299);
        addFileType("3GP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3G2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("MKV", 27, "video/x-matroska");
        addFileType("WEBM", 30, "video/webm");
        addFileType("TS", 28, "video/mp2ts");
        addFileType("AVI", 29, "video/avi");
        if (isWMVEnabled()) {
            addFileType("WMV", 25, "video/x-ms-wmv", MtpConstants.FORMAT_WMV);
            addFileType("ASF", 26, "video/x-ms-asf");
        }
        addFileType("JPG", 31, "image/jpeg", MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("JPEG", 31, "image/jpeg", MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("GIF", 32, "image/gif", MtpConstants.FORMAT_GIF);
        addFileType("PNG", 33, "image/png", MtpConstants.FORMAT_PNG);
        addFileType("BMP", 34, ImageContentType.MIME_TYPE_X_MS_BMP, MtpConstants.FORMAT_BMP);
        addFileType("WBMP", 35, ImageContentType.MIME_TYPE_WBMP);
        addFileType("WEBP", 36, "image/webp");
        addFileType("M3U", 41, "audio/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("M3U", 41, "application/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("PLS", 42, "audio/x-scpls", MtpConstants.FORMAT_PLS_PLAYLIST);
        addFileType("WPL", 43, "application/vnd.ms-wpl", MtpConstants.FORMAT_WPL_PLAYLIST);
        addFileType("M3U8", 44, VideoProxy.VALUE_CONTENT_TYPE_VIDEO_M3U8);
        addFileType("M3U8", 44, "audio/mpegurl");
        addFileType("M3U8", 44, "audio/x-mpegurl");
        addFileType("FL", 51, "application/x-android-drm-fl");
        addFileType("TXT", 100, "text/plain", 12292);
        addFileType("HTM", 101, "text/html", 12293);
        addFileType("HTML", 101, "text/html", 12293);
        addFileType("PDF", 102, MediaType.APPLICATION_PDF_VALUE);
        addFileType("DOC", 104, "application/msword", MtpConstants.FORMAT_MS_WORD_DOCUMENT);
        addFileType("XLS", 105, "application/vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET);
        addFileType("PPT", 106, "application/mspowerpoint", MtpConstants.FORMAT_MS_POWERPOINT_PRESENTATION);
        addFileType("FLAC", 10, "audio/flac", MtpConstants.FORMAT_FLAC);
        addFileType("ZIP", 107, "application/zip");
        addFileType("MPG", 200, "video/mp2p");
        addFileType("MPEG", 200, "video/mp2p");
        addFileType("FLV", 201, "video/x-flv");
        addFileType("MOV", 202, MimeHelper.VIDEO_MOV);
        addFileType("QT", 202, MimeHelper.VIDEO_MOV);
        addFileType("RMVB", 203, "video/vnd.rn-realvideo");
    }

    static void addFileType(String str, int i3, String str2) {
        sFileTypeMap.put(str, new MediaFileType(i3, str2));
        sMimeTypeMap.put(str2, Integer.valueOf(i3));
    }

    public static String getFileTitle(String str) {
        int i3;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0 && (i3 = lastIndexOf + 1) < str.length()) {
            str = str.substring(i3);
        }
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 > 0) {
            return str.substring(0, lastIndexOf2);
        }
        return str;
    }

    public static MediaFileType getFileType(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        return sFileTypeMap.get(str.substring(lastIndexOf + 1).toUpperCase());
    }

    public static int getFileTypeForMimeType(String str) {
        Integer num = sMimeTypeMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int getFormatCode(String str, String str2) {
        Integer num;
        if (str2 != null && (num = sMimeTypeToFormatMap.get(str2)) != null) {
            return num.intValue();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            Integer num2 = sFileTypeToFormatMap.get(str.substring(lastIndexOf + 1).toUpperCase());
            if (num2 != null) {
                return num2.intValue();
            }
            return 12288;
        }
        return 12288;
    }

    public static String getMimeTypeForFile(String str) {
        MediaFileType fileType = getFileType(str);
        if (fileType == null) {
            return null;
        }
        return fileType.mimeType;
    }

    public static String getMimeTypeForFormatCode(int i3) {
        return sFormatToMimeTypeMap.get(Integer.valueOf(i3));
    }

    public static boolean isAudioFileType(int i3) {
        if (i3 >= 1 && i3 <= 10) {
            return true;
        }
        if (i3 >= 11 && i3 <= 13) {
            return true;
        }
        return false;
    }

    public static boolean isDrmFileType(int i3) {
        if (i3 >= 51 && i3 <= 51) {
            return true;
        }
        return false;
    }

    public static boolean isImageFileType(int i3) {
        if (i3 >= 31 && i3 <= 36) {
            return true;
        }
        return false;
    }

    public static boolean isMimeTypeMedia(String str) {
        int fileTypeForMimeType = getFileTypeForMimeType(str);
        if (!isAudioFileType(fileTypeForMimeType) && !isVideoFileType(fileTypeForMimeType) && !isImageFileType(fileTypeForMimeType) && !isPlayListFileType(fileTypeForMimeType)) {
            return false;
        }
        return true;
    }

    public static boolean isPlayListFileType(int i3) {
        if (i3 >= 41 && i3 <= 44) {
            return true;
        }
        return false;
    }

    public static boolean isVideoFileType(int i3) {
        if ((i3 >= 21 && i3 <= 30) || (i3 >= 200 && i3 <= 203)) {
            return true;
        }
        return false;
    }

    private static boolean isWMAEnabled() {
        return true;
    }

    private static boolean isWMVEnabled() {
        return true;
    }

    static void addFileType(String str, int i3, String str2, int i16) {
        addFileType(str, i3, str2);
        sFileTypeToFormatMap.put(str, Integer.valueOf(i16));
        sMimeTypeToFormatMap.put(str2, Integer.valueOf(i16));
        sFormatToMimeTypeMap.put(Integer.valueOf(i16), str2);
    }
}
