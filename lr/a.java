package lr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.g;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.api.IAECaptureMode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.scaleaio.api.IScaleAIOActivityApi;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.HashMap;
import or.b;
import or.c;
import or.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "mqqapi://qcircle/opencamera?activity_id=circle_takesame";
        }
        return "mqqapi://qcircle/opencamera?activity_id=circle_takesame&tab=camera&widgetinfo=" + str;
    }

    private static EditVideoParams c(Activity activity, LocalMediaInfo localMediaInfo, c cVar, int i3, Bundle bundle, EditVideoParams.EditSource editSource, int i16) {
        EditVideoParams editVideoParams = new EditVideoParams(i16, i3, editSource, bundle);
        if (cVar != null) {
            editVideoParams.f204056e = cVar.f423434g;
        }
        editVideoParams.D = activity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        editVideoParams.f204058h.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
            QLog.d("JumpUtil", 2, "EditVideoParams params:" + editVideoParams.toString());
        }
        long longExtra = activity.getIntent().getLongExtra("troop_uin", 0L);
        if (longExtra != 0) {
            editVideoParams.f204058h.putLong("troop_uin", longExtra);
        }
        return editVideoParams;
    }

    public static Bundle e(Bundle bundle, String str) {
        String str2;
        String string = bundle.getString(IAECameraUnit.KEY_CURRENT_SELECT_ID);
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            String[] split = str.split("\\^");
            if (split.length <= 0) {
                str2 = "";
            } else {
                str2 = split[0];
            }
            if (split.length == 1) {
                string = split[0];
                str2 = ((IAECaptureMode) QRoute.api(IAECaptureMode.class)).getNormalModeName();
            }
            if (split.length > 1) {
                string = split[1];
            }
            if (split.length > 2) {
                str3 = split[2];
            }
        }
        if (!TextUtils.isEmpty(string)) {
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(IAECameraUnit.KEY_CURRENT_TYPE, str3);
            } else {
                bundle.putString(IAECameraUnit.KEY_CURRENT_TYPE, " ");
            }
            bundle.putString(IAECameraUnit.KEY_CURRENT_TAB, ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).switchTabToName(str2));
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, string);
        }
        return bundle;
    }

    public static void f(Activity activity, boolean z16, d dVar) {
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
        aliasIntent.setFlags(335544320);
        activity.startActivity(aliasIntent);
    }

    public static void h(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=" + str + "&cmode=singlegif"));
        JumpActivity.processIntent(intent);
        JumpActivity.handleIntentForQQBrowser(activity, intent);
        activity.startActivity(intent);
    }

    public static void k(Activity activity, Bundle bundle) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        bundle.putInt("qq_sub_business_id", 3);
        bundle.putInt("entrance_type", 10001);
        bundle.putLong("qzone_slide_enable_mask", 50043L);
        bundle.putBoolean("from_qzone_slideshow", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
        PublicFragmentActivityForPeak.start(activity.getApplicationContext(), intent, QzoneSlideShowPreparingFragment.class);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity, Intent intent) {
        boolean z16;
        EditVideoParams editVideoParams;
        Context context;
        EditVideoParams.EditSource editLocalPhotoSource;
        Boolean bool;
        HashMap hashMap;
        long longExtra = intent.getLongExtra("TEMP_PARAM", 0L);
        boolean z17 = intent.getIntExtra("camera_type", -1) != -1;
        int intExtra = intent.getIntExtra("EDIT_BUSI", 2);
        int intExtra2 = intent.getIntExtra("qq_sub_business_id", 0);
        int intExtra3 = intent.getIntExtra("entrance_type", 99);
        String stringExtra = intent.getStringExtra(AEEditorConstants.PATH);
        long longExtra2 = intent.getLongExtra(AEEditorConstants.PHOTO_ID, 0L);
        Bundle bundle = new Bundle();
        bundle.putInt("qq_sub_business_id", intExtra2);
        if (intExtra != 3) {
            bundle.putAll(intent.getExtras());
        }
        bundle.putInt("entrance_type", intExtra3);
        bundle.putInt(AEEditorConstants.PIC_ENTRANCE_TYPE, intent.getIntExtra(AEEditorConstants.PIC_ENTRANCE_TYPE, 0));
        boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
        QLog.d("JumpUtil", 1, "doStartEditPic busiType: ", Integer.valueOf(intExtra), ", entranceType: ", Integer.valueOf(intExtra3), ", isGoPublish: ", Boolean.valueOf(booleanExtra));
        if (booleanExtra) {
            bundle.putString("extra_publish_text", HardCodeUtil.qqStr(R.string.jri));
        }
        if (intent.hasExtra("troop_uin")) {
            bundle.putString("troop_uin", intent.getStringExtra("troop_uin"));
        }
        if (intent.hasExtra("extra_enable_flash_pic")) {
            z16 = false;
            bundle.putBoolean("extra_enable_flash_pic", intent.getBooleanExtra("extra_enable_flash_pic", false));
        } else {
            z16 = false;
        }
        if (intent.hasExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR)) {
            bundle.putBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, intent.getBooleanExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, z16));
        }
        if (intent.hasExtra("key_multi_edit_pic")) {
            bundle.putBoolean("key_multi_edit_pic", intent.getBooleanExtra("key_multi_edit_pic", z16));
        }
        bundle.putParcelable("edit_send_session_info", intent.getParcelableExtra("edit_send_session_info"));
        bundle.putString("extra_text_filter_text", intent.getStringExtra("extra_text_filter_text"));
        try {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) intent.getParcelableExtra(ShortVideoConstants.MEDIA_INFO);
            if (localMediaInfo == null && (hashMap = (HashMap) intent.getSerializableExtra("user_params")) != null) {
                localMediaInfo = (LocalMediaInfo) hashMap.get(AEEditorConstants.PARAM_LOCALMEDIAINFO);
            }
            if (localMediaInfo == null) {
                localMediaInfo = new LocalMediaInfo();
            }
            HashMap hashMap2 = (HashMap) intent.getSerializableExtra("user_params");
            if (hashMap2 != null && (bool = (Boolean) hashMap2.get("extra_complete_preview_share")) != null) {
                bundle.putBoolean("extra_complete_preview_share", bool.booleanValue());
            }
            int i3 = (int) longExtra;
            if (z17) {
                editLocalPhotoSource = new EditTakePhotoSource(stringExtra, g.f(longExtra2));
            } else {
                editLocalPhotoSource = new EditLocalPhotoSource(stringExtra, localMediaInfo);
            }
            editVideoParams = new EditVideoParams(intExtra, i3, editLocalPhotoSource, bundle);
        } catch (IllegalArgumentException e16) {
            e = e16;
            editVideoParams = null;
        }
        try {
            editVideoParams.v(longExtra2);
        } catch (IllegalArgumentException e17) {
            e = e17;
            QLog.d("JumpUtil", 2, " Can not find file by sourcePath: busiType=" + intExtra + " isTakePhoto:" + z17 + " subBusinessId:" + intExtra2, e);
            if (editVideoParams != null) {
            }
            if (booleanExtra) {
            }
            if (intExtra == 3) {
            }
            intent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
        }
        if (editVideoParams != null) {
            intent.putExtra(EditVideoParams.class.getName(), editVideoParams);
        }
        if (booleanExtra) {
            context = activity;
            intent.setClass(context, EditPicActivity.class);
        } else {
            context = activity;
        }
        if (intExtra == 3) {
            intent.setClass(context, QzoneEditPictureActivity.class);
        }
        intent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("mqqapi://")) {
            return str;
        }
        return "mqqapi://videostory/takevideo?from=qzoneTail&widgetinfo=" + str + "&cmode=all";
    }

    public static void i(Activity activity, AEPhotoCaptureResult aEPhotoCaptureResult, or.a aVar, Bundle bundle, int i3) {
        if (activity == null || activity.isFinishing() || aVar == null) {
            return;
        }
        b c16 = aVar.c();
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
                return;
            }
            return;
        }
        boolean h16 = c16.h();
        int i16 = aVar.f423403c;
        int c17 = c16.c();
        int b16 = aVar.b();
        c16.d();
        c16.g();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(EditPicActivity.EXTRA_SKIP_ArtFilterBridgeActivity, true);
        Intent startEditPic = EditPicActivity.startEditPic(activity, aEPhotoCaptureResult.filePath, true, c16.f423415j, true, h16, true, false, false, false, i16, b16, c17, false, null, bundle2);
        startEditPic.putExtra("qcamera_photo_filepath", aEPhotoCaptureResult.filePath);
        startEditPic.putExtra("qcamera_rotate", aEPhotoCaptureResult.orientation);
        startEditPic.putExtra("camera_type", 103);
        startEditPic.putExtra("state", bundle);
        startEditPic.putExtra(AEEditorConstants.PHOTO_ID, aEPhotoCaptureResult.photoId);
        SessionWrap e16 = c16.e();
        if (e16 != null) {
            startEditPic.putExtra("uin", e16.f394447d);
            startEditPic.putExtra("uintype", e16.f394449f);
            startEditPic.putExtra("troop_uin", e16.f394450h);
            startEditPic.putExtra("uinname", e16.f394448e);
            startEditPic = BaseAIOUtils.m(startEditPic, null);
        }
        startEditPic.putExtra(IJumpUtil.EDIT_VIDEO_WAY, i3);
        startEditPic.putExtra("qq_sub_business_id", c16.f());
        String aliasName = SplashActivity.getAliasName();
        String a16 = c16.a();
        if (ChatActivity.class.getName().equals(a16) || ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).getGuildChatActivityClass().getName().equals(a16) || QPublicTransFragmentActivity.class.getName().equals(a16) || ((IScaleAIOActivityApi) QRoute.api(IScaleAIOActivityApi.class)).getScaleAIOActivityClassName().equals(a16)) {
            aliasName = a16;
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.c.d("finish");
        com.tencent.aelight.camera.aioeditor.activity.richmedia.c.f(startEditPic);
        startEditPic.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, aliasName);
        int i17 = aEPhotoCaptureResult.type;
        if (i17 == 1) {
            startEditPic.putExtra(AECameraConstants.KEY_EDITPIC_CAMERATYPE, 1);
        } else if (i17 == 0) {
            startEditPic.putExtra(AECameraConstants.KEY_EDITPIC_CAMERATYPE, 2);
        }
        if (activity.getIntent().hasExtra("aio_capture_report_params")) {
            startEditPic.putExtra("aio_capture_report_params", activity.getIntent().getParcelableExtra("aio_capture_report_params"));
        }
        a(activity, startEditPic);
        activity.startActivityForResult(startEditPic, 1012);
        com.tencent.mobileqq.activity.richmedia.d.d("", "0X80075C1", "", "", "", "");
    }

    public static void j(Activity activity, BaseVideoCaptureResult baseVideoCaptureResult, LocalMediaInfo localMediaInfo, or.a aVar, Bundle bundle, int i3, Bundle bundle2) {
        Intent intent;
        int i16;
        if (activity == null || activity.isFinishing() || aVar == null) {
            return;
        }
        c d16 = aVar.d();
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
                return;
            }
            return;
        }
        long longExtra = activity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
        int i17 = (activity.getIntent() == null || longExtra == -1) ? 1099 : (int) longExtra;
        int i18 = (d16.f423430c && ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isTransitionSwtichOpen()) ? i17 | 16 : i17 | 32;
        if (d16.c()) {
            i18 |= 512;
        }
        if (d16.d()) {
            i18 |= 256;
        }
        int i19 = aVar.f423401a;
        if (i19 != 10013 && i19 != 10012 && i19 != 10007) {
            i18 |= 4096;
        }
        if (!d16.f423431d) {
            i18 &= -2;
        }
        Bundle bundle3 = bundle2 == null ? new Bundle() : bundle2;
        int i26 = aVar.f423401a;
        if (i26 == 10012) {
            if (localMediaInfo.mDuration > 20000 || localMediaInfo.mTotalDuration > 20000) {
                bundle3.putBoolean("extra_enable_revert", false);
                bundle3.putBoolean("extra_enable_slow", false);
            }
            boolean z16 = bundle3.getBoolean("needVideoDoodle", false);
            boolean z17 = bundle3.getBoolean("needVideoWording", false);
            if (!z16) {
                i18 &= -1025;
            }
            if (!z17) {
                i18 &= -2;
            }
        } else if (i26 == 10013) {
            if (localMediaInfo.mDuration > 20000 || localMediaInfo.mTotalDuration > 20000) {
                bundle3.putBoolean("extra_enable_revert", false);
                bundle3.putBoolean("extra_enable_slow", false);
            }
        } else if (i26 == 10000 || i26 == 10007) {
            i18 &= -33;
        }
        int i27 = i18;
        if (localMediaInfo.mDuration > 80000) {
            bundle3.putBoolean("extra_enable_slow", false);
        }
        SessionWrap sessionWrap = (SessionWrap) activity.getIntent().getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
        if (sessionWrap != null) {
            bundle3.putString("uin", sessionWrap.f394447d);
            bundle3.putInt("uintype", sessionWrap.f394449f);
            bundle3.putString("troop_uin", sessionWrap.f394450h);
            bundle3.putString("uinname", sessionWrap.f394448e);
        }
        SessionInfo sessionInfo = (SessionInfo) activity.getIntent().getParcelableExtra(PeakConstants.SEND_SESSION_INFO);
        if (sessionInfo != null) {
            bundle3.putParcelable("edit_send_session_info", sessionInfo);
        }
        bundle3.putInt("qq_sub_business_id", d16.b());
        bundle3.putInt("entrance_type", aVar.f423402b);
        EditTakeVideoSource editTakeVideoSource = new EditTakeVideoSource(baseVideoCaptureResult.videoMp4FilePath, baseVideoCaptureResult.audioDataFilePath, localMediaInfo);
        int i28 = aVar.f423403c;
        int a16 = d16.a();
        id0.b.m(a16);
        EditVideoParams c16 = c(activity, localMediaInfo, d16, i27, bundle3, editTakeVideoSource, i28);
        if (bundle2 != null && bundle2.getBoolean("from_qzone_slideshow")) {
            intent = new Intent(activity, (Class<?>) QzoneEditVideoActivity.class);
            intent.putExtra("qqstory_slide_show_scene", SlideShowPhotoListManager.n().m());
            intent.putExtra("qqstory_slide_show_entrance", SlideShowPhotoListManager.n().l());
        } else {
            intent = new Intent(activity, (Class<?>) EditVideoActivity.class);
        }
        j.a(intent, activity.getIntent().getExtras(), activity);
        float f16 = (!(baseVideoCaptureResult instanceof AEVideoCaptureResult) || (i16 = baseVideoCaptureResult.videoFrameCount) == 0) ? 0.0f : (((AEVideoCaptureResult) baseVideoCaptureResult).arkCoverStartFrame * 1.0f) / i16;
        ms.a.f("JumpUtil", "ArkVideo cover percentage=" + f16);
        intent.putExtra(AECameraConstants.KEY_SEND_ARK_MSG_COVER_START_PERCENTAGE, f16);
        intent.putExtra("short_video_entrance_type", a16);
        intent.putExtra(EditVideoParams.class.getName(), c16);
        int i29 = aVar.f423401a;
        if (i29 == 10012) {
            intent.putExtra("op_department", "grp_tribe");
        } else if (i29 == 10013) {
            intent.putExtra("op_department", "grp_readinjoy");
        } else {
            intent.putExtra("op_department", "grp_qq");
        }
        intent.putExtra("op_type", "video_edit");
        intent.putExtra("stop_record_time", System.currentTimeMillis());
        intent.putExtra("state", bundle);
        intent.putExtra(IJumpUtil.EDIT_VIDEO_WAY, i3);
        intent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getStoryShareType(activity.getIntent()));
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getAEFromType(activity.getIntent()));
        if (activity.getIntent().hasExtra("aio_capture_report_params")) {
            intent.putExtra("aio_capture_report_params", activity.getIntent().getParcelableExtra("aio_capture_report_params"));
        }
        if (activity instanceof QzoneEditVideoActivity) {
            ((QzoneEditVideoActivity) activity).W2(intent);
        } else {
            activity.startActivityForResult(intent, aVar.f423401a);
            activity.overridePendingTransition(0, 0);
        }
    }

    @Deprecated
    public static void g(Activity activity, String str) {
    }
}
