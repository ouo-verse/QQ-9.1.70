package cooperation.zebra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationQzone;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone;
import com.tencent.mobileqq.pluginsdk.PluginActivity;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes28.dex */
public class ZebraPluginProxy {
    public static final String KEY_PHOTOCONST_INIT_ACTIVITY_CLASS_NAME = "PhotoConst.INIT_ACTIVITY_CLASS_NAME";
    public static final String KEY_PHOTOCONST_INIT_ACTIVITY_PACKAGE_NAME = "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME";
    public static final String KEY_PHOTOCONST_IS_CALL_IN_PLUGIN = "PhotoConst.IS_CALL_IN_PLUGIN";
    public static final String KEY_PHOTOCONST_IS_SINGLE_DERECTBACK_MODE = "PhotoConst.IS_SINGLE_DERECTBACK_MODE";
    public static final String KEY_PHOTOCONST_IS_SINGLE_MODE = "PhotoConst.IS_SINGLE_MODE";
    public static final String KEY_PHOTOCONST_MAXUM_SELECTED_NUM = "PhotoConst.MAXUM_SELECTED_NUM";
    public static final String KEY_PHOTOCONST_PLUGIN_APK = "PhotoConst.PLUGIN_APK";
    public static final String KEY_PHOTOCONST_PLUGIN_NAME = "PhotoConst.PLUGIN_NAME";
    public static final String KEY_PHOTOCONST_SINGLE_PHOTO_PATH = "PhotoConst.SINGLE_PHOTO_PATH";
    public static final String KEY_PHOTOCONST_UIN = "PhotoConst.UIN";
    public static final String KEY_TRANSFILE_UTILE_TYPE_PHOTO = "TransfileUtile.TYPE_PHOTO";
    private static HashMap<String, Integer> sConstIntMap;
    private static HashMap<String, String> sConstStringMap;

    static {
        sConstIntMap = new HashMap<>();
        sConstStringMap = new HashMap<>();
        if (sConstIntMap == null) {
            sConstIntMap = new HashMap<>();
        }
        if (sConstStringMap == null) {
            sConstStringMap = new HashMap<>();
        }
        sConstIntMap.put(KEY_TRANSFILE_UTILE_TYPE_PHOTO, 1);
        sConstStringMap.put("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        sConstStringMap.put("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        sConstStringMap.put("PhotoConst.IS_CALL_IN_PLUGIN", "PhotoConst.IS_CALL_IN_PLUGIN");
        sConstStringMap.put("PhotoConst.PLUGIN_NAME", "PhotoConst.PLUGIN_NAME");
        sConstStringMap.put("PhotoConst.PLUGIN_APK", "PhotoConst.PLUGIN_APK");
        sConstStringMap.put("PhotoConst.UIN", "PhotoConst.UIN");
        sConstStringMap.put("PhotoConst.MAXUM_SELECTED_NUM", "PhotoConst.MAXUM_SELECTED_NUM");
        sConstStringMap.put("PhotoConst.IS_SINGLE_MODE", "PhotoConst.IS_SINGLE_MODE");
        sConstStringMap.put("PhotoConst.IS_SINGLE_DERECTBACK_MODE", "PhotoConst.IS_SINGLE_DERECTBACK_MODE");
        sConstStringMap.put("PhotoConst.SINGLE_PHOTO_PATH", "PhotoConst.SINGLE_PHOTO_PATH");
    }

    public static void backToPhoto(Intent intent, Activity activity) {
        PhotoUtils.backToPhoto(intent, activity);
    }

    public static int getConstInt(String str) {
        if (sConstIntMap.containsKey(str)) {
            return sConstIntMap.get(str).intValue();
        }
        throw new RuntimeException("key not found");
    }

    public static String getConstString(String str) {
        if (sConstStringMap.containsKey(str)) {
            return sConstStringMap.get(str);
        }
        throw new RuntimeException("key not found");
    }

    public static String md5_toMD5(String str) {
        return MD5.toMD5(str);
    }

    public static void onSendResult(Activity activity, int i3, int i16, Intent intent, boolean z16) {
        PhotoUtils.onSendResult(activity, i3, i16, intent, z16);
    }

    public static void reportController_reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        ReportController.o(null, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
    }

    public static void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, boolean z16) {
        PhotoUtils.sendPhoto(activity, intent, arrayList, 0, z16);
    }

    public static void sendPhotoForPhotoPlus(Activity activity, Intent intent, ArrayList<String> arrayList) {
        PhotoUtils.sendPhotoForPhotoPlus(activity, intent, arrayList);
    }

    public static void startPhotoList(Activity activity, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 7);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationQzone.f184396f0);
            intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationQzone.f184373k);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationQzone.P);
            intent.setClassName("com.tencent.mobileqq", NewPhotoListActivity.class.getName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            activity.startActivity(intent);
            if (activity instanceof PluginActivity) {
                QAlbumUtil.anim(((PluginActivity) activity).getOutActivity(), false, true);
            } else {
                QAlbumUtil.anim(activity, false, true);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
