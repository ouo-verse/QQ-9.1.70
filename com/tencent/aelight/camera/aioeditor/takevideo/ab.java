package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.aelight.camera.aebase.AECameraPlugin;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import cooperation.peak.PeakConstants;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ab {
    public static Intent a(String str, String str2, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar, String str3, String str4) {
        Intent intent = new Intent();
        intent.putExtra("uin", eVar.f68834a);
        intent.putExtra("troop_uin", eVar.f68835b);
        intent.putExtra("uintype", eVar.f68837d);
        intent.putExtra(ShortVideoConstants.FROM_UIN_TYPE, eVar.f68837d);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str2);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, str2);
        intent.putExtra("file_send_path", str);
        intent.putExtra(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        intent.putExtra(ShortVideoConstants.FROM_UIN, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        intent.putExtra(ShortVideoConstants.KEY_STORY_VIDEO_TO_RECENT, true);
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str3);
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str4);
        File file = new File(str);
        if (file.exists() && new File(str2).exists()) {
            String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str));
            if (bytes2HexStr == null) {
                QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
                return null;
            }
            String bytes2HexStr2 = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str2));
            if (bytes2HexStr2 == null) {
                QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
                return null;
            }
            eVar.f68847n = bytes2HexStr;
            d.a aVar = new d.a();
            int a16 = com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
            if (a16 != 0) {
                QLog.e("ShortVideoForwardManager", 1, "video file getRotationDegree fail, code:", Integer.valueOf(a16));
                return null;
            }
            int[] iArr = aVar.f288248a;
            int i3 = iArr[0];
            int i16 = iArr[1];
            int i17 = iArr[3];
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, (int) file.length());
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) Math.round(i17 / 1000.0d));
            intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, bytes2HexStr);
            intent.putExtra("file_name", str);
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, i3);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, i16);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str2, options);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, options.outWidth);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, options.outHeight);
            intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, bytes2HexStr2);
            return intent;
        }
        QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
        return null;
    }

    public static void b(Activity activity, int i3, String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(activity, ForwardRecentActivity.class);
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", "com.tencent.camera.activity");
        intent.putExtra("forward_ark_app_view", "preview");
        intent.putExtra("forward_ark_biz_src", "");
        intent.putExtra("forward_ark_app_ver", "0.0.0.23");
        intent.putExtra("forward_ark_app_prompt", str);
        intent.putExtra("forward_ark_app_meta", str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forward", 1);
            jSONObject.put("type", "normal");
            jSONObject.put("width", 162);
            jSONObject.put("height", 259);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject.toString());
        intent.putExtras(QQCustomArkDialog.b.a("com.tencent.camera.activity", "preview", "", "0.0.0.23", str2, com.tencent.mobileqq.ark.f.c(), null, null));
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        activity.startActivityForResult(intent, i3);
    }

    public static void d(Activity activity, String str, boolean z16, boolean z17, String str2, String str3, int i3) {
        String stringExtra;
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("ShortVideoForwardManager", 1, "pic file do not exist");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, file.toURI().toString());
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, file.toURI().toString());
        intent.putExtra(AppConstants.Key.FORWARD_SEND_SELFIE_FACE, true);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(ForwardRecentActivity.KEY_DIRECT_JUMP_QZONE_SHUOSHUO, z16);
        intent.putExtra(AppConstants.Key.FORWARD_IS_SELFIE_FACE, z17);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, "[" + str2 + "]");
        } else if (z17) {
            intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, HardCodeUtil.qqStr(R.string.tgx));
        }
        if (activity != null && activity.getIntent() != null && (stringExtra = activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM)) != null) {
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, lr.a.d(stringExtra));
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, stringExtra);
            String stringExtra2 = activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            ms.a.f("ShortVideoForwardManager", "gotoForwardPicUI---activity=" + activity + ", takeSameName=" + stringExtra2);
            if (!TextUtils.isEmpty(stringExtra2)) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra2);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, stringExtra2);
            } else {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, PeakConstants.QZONETAIL_TITLE);
            }
        }
        if ((activity instanceof PublicFragmentActivityForPeak) || (activity instanceof QQBrowserActivity)) {
            i(activity, intent);
        }
        if (z17) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("gif^");
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, sb5.toString());
        }
        intent.putExtra("k_qzone", true);
        intent.putExtra(ForwardRecentActivity.FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
        intent.putExtra(ForwardRecentActivity.KEY_FORWARD_BUSINESS_ID, "msg_tab_camera");
        intent.putExtra("filePath", str);
        intent.putExtra("reqType", 1);
        intent.putExtra("source", QZoneJsConstants.SHARE_SOURCE_TYPE_MSGTAB_CAMERA);
        if (i3 == 2 || i3 == 1) {
            ForwardBaseOption.startForwardActivityForResult(activity, "caller_aecamera", intent, 21, WiFiPhotoErrorCode.ERR_FILEBRIDGE_GENERATE_THUMB_FAIL);
        } else if (i3 == 4) {
            ForwardBaseOption.startForwardActivityForResult(activity, "caller_aecamera", intent, AECameraPlugin.d0(21), WiFiPhotoErrorCode.ERR_FILEBRIDGE_GENERATE_THUMB_FAIL);
        } else {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 21, WiFiPhotoErrorCode.ERR_FILEBRIDGE_GENERATE_THUMB_FAIL);
        }
    }

    public static String h(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new JSONObject(new JSONObject(jSONObject.optString("msg")).optString(jSONObject.optString("_show_mission"))).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        } catch (Exception e16) {
            QLog.e("ShortVideoForwardManager", 1, "parseLinkFromRedTouchBuffer fail, ", e16);
            return str2;
        }
    }

    public static void i(Activity activity, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String str = "";
        if (activity.getIntent() == null) {
            stringExtra = "";
        } else {
            stringExtra = activity.getIntent().getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME);
        }
        if (activity.getIntent() == null) {
            stringExtra2 = "";
        } else {
            stringExtra2 = activity.getIntent().getStringExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID);
        }
        if (activity.getIntent() != null) {
            str = activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        }
        ms.a.f("ShortVideoForwardManager", "gotoForwardShortVideoUI---activity=" + activity + ", takeSameName=" + str);
        try {
            if (stringExtra2.startsWith("http")) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, URLEncoder.encode(stringExtra2, "UTF-8"));
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, lr.a.d(stringExtra2));
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str);
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, str);
                } else {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, PeakConstants.QZONETAIL_TITLE);
                }
            } else if (!StringUtil.isEmpty(stringExtra2) && !StringUtil.isEmpty(stringExtra)) {
                String str2 = "play^" + stringExtra2 + AECameraConstants.WIDGETINFO_SEPARATE + stringExtra;
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str2);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, lr.a.d(str2));
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str);
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, str);
                } else {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, PeakConstants.QZONETAIL_TITLE);
                }
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    public static void e(Activity activity, String str, String str2, boolean z16, int i3) {
        f(activity, str, str2, z16, i3, null);
    }

    public static void c(Activity activity, String str, boolean z16, int i3) {
        d(activity, str, z16, false, null, null, i3);
    }

    public static void g(Activity activity, String str, String str2, boolean z16, String str3) {
        f(activity, str, str2, z16, 21, str3);
    }

    public static void f(Activity activity, String str, String str2, boolean z16, int i3, String str3) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 21);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str2);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, str2);
        intent.putExtra("file_send_path", str);
        intent.putExtra(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        intent.putExtra(ShortVideoConstants.FROM_UIN, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("k_qzone", true);
        intent.putExtra(ForwardRecentActivity.KEY_DIRECT_JUMP_QZONE_SHUOSHUO, z16);
        intent.putExtra("forward_source_business_type", WiFiPhotoErrorCode.ERR_FILEBRIDGE_GENERATE_THUMB_FAIL);
        intent.putExtra("k_qzone", true);
        intent.putExtra(ForwardRecentActivity.FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
        intent.putExtra(ForwardRecentActivity.KEY_FORWARD_BUSINESS_ID, "msg_tab_camera");
        intent.putExtra("filePath", str);
        intent.putExtra("reqType", 4);
        intent.putExtra("source", QZoneJsConstants.SHARE_SOURCE_TYPE_MSGTAB_CAMERA);
        if (str == null) {
            QLog.e("ShortVideoForwardManager", 1, "videoPath is null");
            return;
        }
        File file = new File(str);
        if (file.exists() && new File(str2).exists()) {
            String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str));
            if (bytes2HexStr == null) {
                QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
                return;
            }
            String bytes2HexStr2 = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str2));
            if (bytes2HexStr2 == null) {
                QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
                return;
            }
            d.a aVar = new d.a();
            int a16 = com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
            if (a16 != 0) {
                QLog.e("ShortVideoForwardManager", 1, "video file getRotationDegree fail, code:", Integer.valueOf(a16));
                return;
            }
            int[] iArr = aVar.f288248a;
            int i16 = iArr[0];
            int i17 = iArr[1];
            int i18 = iArr[3];
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, (int) file.length());
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) Math.round(i18 / 1000.0d));
            intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, bytes2HexStr);
            intent.putExtra("file_name", file.getName());
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, i16);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, i17);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str2, options);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, options.outWidth);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, options.outHeight);
            intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, bytes2HexStr2);
            intent.setClass(activity, ForwardRecentActivity.class);
            if (TextUtils.isEmpty(str3)) {
                intent.putExtra("caller_name", activity.getClass().getSimpleName());
            } else {
                intent.putExtra("caller_name", str3);
            }
            if (activity instanceof QQStoryBaseActivity) {
                String stringExtra = activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, lr.a.d(stringExtra));
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, stringExtra);
                    String stringExtra2 = activity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                    ms.a.f("ShortVideoForwardManager", "gotoForwardShortVideoUI---activity=" + activity + ", takeSameName=" + stringExtra2);
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra2);
                        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, stringExtra2);
                    } else {
                        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, PeakConstants.QZONETAIL_TITLE);
                    }
                }
                ((QQStoryBaseActivity) activity).startActivityForResultDirectly(intent, i3);
                return;
            }
            if (!(activity instanceof PublicFragmentActivityForPeak) && !(activity instanceof QQBrowserActivity)) {
                activity.startActivityForResult(intent, i3);
                return;
            } else {
                i(activity, intent);
                activity.startActivityForResult(intent, i3);
                return;
            }
        }
        QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
    }
}
