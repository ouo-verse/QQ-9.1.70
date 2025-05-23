package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file.getAbsolutePath() + "/.nomedia");
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e16) {
                    QLog.e("QQAlbum", 1, "createNewFile error, ", e16);
                }
            }
        }
    }

    public static int b(List<String> list, int i3, Map<String, LocalMediaInfo> map, boolean z16, Map<String, LocalMediaInfo> map2) {
        LocalMediaInfo localMediaInfo;
        int i16 = 0;
        for (String str : list) {
            if (map2 != null) {
                localMediaInfo = map2.get(str);
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo == null && map != null) {
                localMediaInfo = map.get(str);
            }
            if (localMediaInfo == null || QAlbumUtil.getMediaType(localMediaInfo) != 1) {
                long length = new File(str).length();
                long j3 = i3;
                if (length > j3) {
                    i16++;
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SEND_QUALITY_PIC_LIMIT, true, j3, length, null, "");
                }
            }
        }
        return i16;
    }

    public static URLDrawable c(URL url, Drawable drawable, Drawable drawable2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mPlayGifImage = false;
        return URLDrawable.getDrawable(url, obtain);
    }

    public static void d(LocalMediaInfo localMediaInfo, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            localMediaInfo.mediaHeight = options.outHeight;
            localMediaInfo.mediaWidth = options.outWidth;
            localMediaInfo.mMimeType = options.outMimeType;
            localMediaInfo.addedDate = System.currentTimeMillis();
            localMediaInfo.modifiedDate = System.currentTimeMillis();
            localMediaInfo.path = str;
            localMediaInfo.panoramaPhotoType = 3;
            localMediaInfo.fileSize = new File(str).length();
        } catch (Exception e16) {
            QLog.e("QQAlbum", 2, "decode image error", e16);
        }
    }

    public static String e(Context context, float f16) {
        float f17 = f16 / 1024000;
        if (f17 >= 10.0f) {
            return new DecimalFormat("0").format(f17) + "M";
        }
        if (f17 >= 1.0f) {
            return new DecimalFormat("0.0").format(f17) + "M";
        }
        double d16 = f17;
        if (d16 >= 0.001d) {
            return new DecimalFormat("0").format(f17 * 1024.0f) + "K";
        }
        if (d16 >= 1.0E-4d) {
            return new DecimalFormat("0.0").format(f17 * 1024.0f) + "K";
        }
        return "0.1K";
    }

    public static int f(List<String> list, Map<String, LocalMediaInfo> map, boolean z16, HashMap<String, PhotoSendParams> hashMap, Map<String, LocalMediaInfo> map2) {
        LocalMediaInfo localMediaInfo;
        long length;
        int i3 = 0;
        for (String str : list) {
            if (hashMap != null && ImageManager.isNetworkUrl(str)) {
                if (hashMap.get(str) != null) {
                    length = hashMap.get(str).fileSize;
                } else {
                    QLog.w(PeakConstants.TAG, 1, "mSelectedSendParams.get(p) == null path:" + str);
                    length = 0;
                }
            } else {
                if (map2 != null) {
                    localMediaInfo = map2.get(str);
                } else {
                    localMediaInfo = null;
                }
                if (localMediaInfo == null && map != null) {
                    map.get(str);
                }
                length = new File(str).length();
            }
            i3 = (int) (i3 + length);
            if (QLog.isColorLevel()) {
                QLog.d(PeakConstants.TAG, 2, "setQualityTextViewText, path:" + str + ",len:" + length);
            }
        }
        return i3;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            String name = new File(str).getParentFile().getName();
            String str2 = AppConstants.SDCARD_IMG_CAMERA;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str2 + name + ".mp4";
        } catch (Exception e16) {
            QZLog.i("QQAlbum", 1, "get target path error encode error", e16);
            return null;
        }
    }

    public static void h(Activity activity, int i3, int i16, Intent intent, boolean z16, String str) {
        if (intent != null) {
            intent.removeExtra(PeakConstants.VIDEO_INFO);
        }
        if ((i3 == 2 || i3 == 7001) && i16 == -1) {
            if (intent == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQAlbum", 2, "[onSendResult] data = null");
                }
                intent = new Intent();
            }
            intent.putExtra(PeakConstants.SEND_PHOTO_ACTIVITY_RESULT, -1);
            if (i3 == 7001) {
                Intent intent2 = activity.getIntent();
                QZoneHelper.saveSelectedAlbumInfo(str, intent2.getStringExtra("uin"), intent2.getStringExtra("UploadPhoto.key_album_id"), intent2.getStringExtra("UploadPhoto.key_album_name"));
                intent2.putExtras(intent);
                intent2.setClassName(activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                if (!z16) {
                    intent2.addFlags(603979776);
                    activity.startActivity(intent2);
                }
            } else if (activity.getIntent().getIntExtra("uintype", -1) == 10014) {
                Intent intent3 = (Intent) activity.getIntent().getParcelableExtra(PeakConstants.GUILD_OPEN_AIO_INTENT);
                if (intent3 != null) {
                    activity.startActivity(intent3);
                } else {
                    QLog.e("QQAlbum", 1, "OpenGuild Error ! guildIntent is null!");
                }
            } else {
                intent.setClassName(activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                if (!z16) {
                    intent.addFlags(603979776);
                    activity.startActivity(intent);
                } else {
                    QLog.e("QQAlbum", 1, "Watermark has been deleted!");
                }
            }
            activity.finish();
            QAlbumUtil.anim(activity, false, false);
        }
    }

    public static void i(Intent intent, String str, String str2, boolean z16) {
        if (z16) {
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, z16);
            intent.putExtra(QAlbumConstants.ALBUM_ID, str);
            intent.putExtra(PeakConstants.LAST_ALBUMPATH, str2);
        }
    }

    public static String j(String str) {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
        QLog.d("QQAlbum", 2, "saveToDCIM() oldPath:" + str + ",privatePath:" + sDKPrivatePath);
        if (str != null && str.startsWith(sDKPrivatePath)) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    String name = file.getName();
                    StringBuilder sb5 = new StringBuilder();
                    String str2 = AppConstants.SDCARD_IMG_CAMERA;
                    sb5.append(str2);
                    sb5.append(name);
                    String sb6 = sb5.toString();
                    if (!sb6.equals(str)) {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        boolean renameTo = file.renameTo(new File(sb6));
                        if (!renameTo) {
                            renameTo = FileUtils.moveFile(str, sb6);
                        }
                        QLog.d("QQAlbum", 2, "saveToDCIM rename to :", sb6);
                        if (renameTo) {
                            return sb6;
                        }
                        return str;
                    }
                }
            } catch (Throwable th5) {
                QLog.e("QQAlbum", 2, "saveToDCIM :", th5);
            }
        }
        return str;
    }

    public static void k(Context context, String str) {
        try {
            FileProvider7Helper.savePhotoToSysAlbum(context, str);
        } catch (Exception e16) {
            QLog.e("QQAlbum", 2, "scanMediaFile :", e16);
        }
    }

    public static void l(TextView textView, List<String> list, Map<String, LocalMediaInfo> map, boolean z16, Activity activity, HashMap<String, PhotoSendParams> hashMap, Map<String, LocalMediaInfo> map2) {
        String str;
        LocalMediaInfo localMediaInfo;
        for (String str2 : list) {
            if (!ImageManager.isNetworkUrl(str2)) {
                if (map2 != null) {
                    localMediaInfo = map2.get(str2);
                } else {
                    localMediaInfo = null;
                }
                if (localMediaInfo == null && map != null) {
                    localMediaInfo = map.get(str2);
                }
                if (localMediaInfo != null) {
                    QAlbumUtil.getMediaType(localMediaInfo);
                }
            }
        }
        int f16 = f(list, map, z16, hashMap, map2);
        if (f16 == 0) {
            textView.setVisibility(4);
            return;
        }
        String e16 = e(activity, f16);
        if (e16.equals("0")) {
            textView.setVisibility(4);
            str = "(999K)";
        } else {
            str = "(" + e16 + ")";
            textView.setVisibility(0);
        }
        int length = 6 - str.length();
        for (int i3 = 0; i3 < length; i3++) {
            str = str + " ";
        }
        textView.setText(str);
        if (list.isEmpty()) {
            textView.setVisibility(4);
        }
    }

    public static void m(com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar) {
        if (fVar != null) {
            if ((fVar.f184312h.f184306q && QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(fVar.f184310e.albumId)) || (fVar.f184312h.f184307r && QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(fVar.f184310e.albumId))) {
                fVar.f184313i.m(true);
            }
        }
    }

    public static void n(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QQAlbum", 4, "userAlbumSourceTypeStatistic (" + i3 + "," + i16 + "," + i17 + "," + i18 + "," + i19 + "," + i26 + "," + i27 + "," + i28 + "," + i29 + "," + i36 + "," + i37 + ")");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        long j3 = defaultSharedPreferences.getLong("PhotoConst.last_album_source_type", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j3 > 86400000) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_systemAlbumCount", i3 + "");
            hashMap.put("param_screnshot_qq_cnt", i16 + "");
            hashMap.put("param_screnshot_other_cnt", i17 + "");
            hashMap.put("param_appCount", i18 + "");
            hashMap.put("param_otherCount", i19 + "");
            hashMap.put("param_qq_collection_cnt", i26 + "");
            hashMap.put("param_qq_filerecv_cnt", i28 + "");
            hashMap.put("param_qq_image_cnt", i27 + "");
            hashMap.put("param_qq_zebra_cnt", i29 + "");
            hashMap.put("param_qq_favorite_cnt", i36 + "");
            hashMap.put("param_weixinCnt", i37 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actAlbumPicSourceType", false, 0L, 0L, hashMap, "", false);
            defaultSharedPreferences.edit().putLong("PhotoConst.last_album_source_type", currentTimeMillis).commit();
        }
    }
}
