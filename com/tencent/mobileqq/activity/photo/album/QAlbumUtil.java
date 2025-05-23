package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.webkit.MimeTypeMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QAlbumUtil extends QAlbumBaseUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String ALBUM_FILE_NAME = "album_file";
    public static final String ALBUM_KEY_ID = "album_key_id";
    public static final String ALBUM_KEY_NAME = "album_key_name";
    public static final int MEDIA_TYPE_CAMERA = 2;
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final HashMap<String, Integer> MEDIA_TYPE_MAPS;
    public static final int MEDIA_TYPE_NONE = -1;
    public static final int MEDIA_TYPE_VIDEO = 1;
    public static final long PHOTO_SLOT_TIME = 60000;
    public static final String PROTOCOL_ALBUM_THUMB = "albumthumb";
    public static final String PROTOCOL_VIDEO_COVER = "videocover";
    public static SimpleDateFormat sDateFormatForHour;
    public static SimpleDateFormat sDateFormatForMinute;
    public static String sLastAlbumId;
    public static String sLastAlbumName;
    public static String sLastAlbumPath;
    public static HashMap<String, Integer> sLastAlbumPhotoCountMap;
    public static long sLastAlbumRecordTime;
    public static HashMap<String, Pair<String, String>> sSelectItemAlbum;
    public static HashMap<String, LinkedHashMap<String, Integer>> sSelectItemPosMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        MEDIA_TYPE_MAPS = hashMap;
        sDateFormatForMinute = new SimpleDateFormat("yyyy\u5e74MM\u6708dd HH\u70b9mm\u5206");
        sDateFormatForHour = new SimpleDateFormat("yyyy\u5e74MM\u6708dd HH\u70b9");
        sLastAlbumRecordTime = 0L;
        sLastAlbumPhotoCountMap = new HashMap<>();
        sLastAlbumPath = "";
        sSelectItemAlbum = new HashMap<>();
        sSelectItemPosMap = new HashMap<>();
        hashMap.put("image", 0);
        hashMap.put("video", 1);
        hashMap.put(MimeHelper.MIME_TYPE_MOBILEQQ, 2);
    }

    public QAlbumUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void anim(Activity activity, boolean z16, boolean z17) {
        if (z16) {
            if (z17) {
                xInAnim(activity);
                return;
            } else {
                xOutAnim(activity);
                return;
            }
        }
        if (z17) {
            yInAnim(activity);
        } else {
            yOutAnim(activity);
        }
    }

    public static void clearSelectItemInfo() {
        sSelectItemAlbum.clear();
        sSelectItemPosMap.clear();
    }

    public static String createContentDescription(int i3, LocalMediaInfo localMediaInfo, int i16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1) {
            sb5.append("\u7167\u7247 ");
        } else {
            sb5.append("\u89c6\u9891 ");
        }
        sb5.append("\u62cd\u6444\u65f6\u95f4: ");
        sb5.append(sDateFormatForMinute.format(new Date(localMediaInfo.modifiedDate * 1000)));
        return sb5.toString();
    }

    public static String createContentDescriptionWithCheckBox(int i3, LocalMediaInfo localMediaInfo, int i16, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1) {
            sb5.append("\u7167\u7247 ");
        } else {
            sb5.append("\u89c6\u9891 ");
        }
        sb5.append("\u62cd\u6444\u65f6\u95f4: ");
        sb5.append(sDateFormatForHour.format(new Date(localMediaInfo.modifiedDate * 1000)));
        return sb5.toString();
    }

    public static String formatTimeToString(long j3) {
        String str;
        String str2;
        int i3 = (int) (j3 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + String.valueOf(i16);
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + String.valueOf(i17);
        }
        return str2 + ":" + str;
    }

    public static URL generateAlbumThumbURL(LocalMediaInfo localMediaInfo) {
        return generateAlbumThumbURL(localMediaInfo, null);
    }

    public static URL generateAlbumVideoThumbURL(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(PROTOCOL_VIDEO_COVER);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(str);
        if (str2 != null) {
            sb5.append("#");
            sb5.append(str2);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SelectPhotoTrace", 2, e16.getMessage(), e16);
                return null;
            }
            return null;
        }
    }

    public static int getMediaType(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return -1;
        }
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (mimeType == null) {
            return 0;
        }
        Integer num = MEDIA_TYPE_MAPS.get(mimeType[0]);
        if (num == null) {
            QLog.w("QQAlbum", 1, "getMediaType fail : " + localMediaInfo.mMimeType + " - " + mimeType[0]);
            return -1;
        }
        return num.intValue();
    }

    public static boolean isGif(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo != null && "image/gif".equals(localMediaInfo.mMimeType)) {
            return true;
        }
        return false;
    }

    public static final boolean isNetUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }

    public static void putLastAlbumInfo(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ALBUM_FILE_NAME, 0).edit();
        edit.putString(ALBUM_KEY_ID, sLastAlbumId);
        edit.putString(ALBUM_KEY_NAME, sLastAlbumName);
        edit.commit();
    }

    public static void rotate180Degrees(View view, boolean z16) {
        float f16;
        float f17 = 180.0f;
        if (z16) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        if (z16) {
            f17 = 360.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, f17, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    private static void xInAnim(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
    }

    private static void xOutAnim(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
    }

    private static void yInAnim(Activity activity) {
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    private static void yOutAnim(Activity activity) {
        activity.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
    }

    public static URL generateAlbumThumbURL(LocalMediaInfo localMediaInfo, String str) {
        StringBuilder sb5 = new StringBuilder(PROTOCOL_ALBUM_THUMB);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(localMediaInfo.path);
        if (str != null) {
            sb5.append("#");
            sb5.append(str);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("SelectPhotoTrace", 2, e16.getMessage(), e16);
            return null;
        }
    }

    public static int getMediaType(String str) {
        if (str != null && str.contains(".")) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1));
            if (mimeTypeFromExtension != null && mimeTypeFromExtension.contains("video")) {
                return 1;
            }
            if (mimeTypeFromExtension != null && mimeTypeFromExtension.contains("image")) {
                return 0;
            }
        }
        return -1;
    }
}
