package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.oskplayer.util.Base16;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileType {
    private static final String charset = "UTF-8";
    String encodeBase16PlainType;
    String plainType;
    public static final FileType UNKNOWN = new FileType("unknown");
    public static final FileType OCTET_STREAM = new FileType("application/octet-stream");
    public static final FileType VIDEO_MP4 = new FileType("video/mp4");
    private static final byte[] UNKNOWN_UTF8_BYTES = {IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 107, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM};
    public static HashMap<String, FileType> sEncodeFileTypeCacheMap = new HashMap<>();

    FileType(String str) {
        this.plainType = str;
    }

    public static FileType decode(String str) {
        if (sEncodeFileTypeCacheMap.containsKey(str)) {
            return sEncodeFileTypeCacheMap.get(str);
        }
        FileType fileType = getFileType(decodeBase16(str));
        sEncodeFileTypeCacheMap.put(str, fileType);
        return fileType;
    }

    private static String decodeBase16(String str) {
        try {
            return new String(Base16.decode(str), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return UNKNOWN.toString();
        }
    }

    private static String encodeBase16(String str) {
        try {
            return Base16.encode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return Base16.encode(UNKNOWN_UTF8_BYTES);
        }
    }

    public static FileType getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        if (str.equals("video/mp4")) {
            return VIDEO_MP4;
        }
        if (str.equals("unknown")) {
            return UNKNOWN;
        }
        return new FileType(str);
    }

    public String encode() {
        if (TextUtils.isEmpty(this.encodeBase16PlainType)) {
            String encodeBase16 = encodeBase16(this.plainType);
            this.encodeBase16PlainType = encodeBase16;
            return encodeBase16;
        }
        return this.encodeBase16PlainType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.plainType;
        String str2 = ((FileType) obj).plainType;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.plainType;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.plainType;
    }
}
