package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.preview.service.PictureProcessBootService;
import com.qzone.preview.service.PictureService;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ak {
    @Deprecated
    public static Intent A(Context context, int i3, boolean z16, String str, int i16, boolean z17) {
        Intent intent = new Intent(context, lc.b.b());
        intent.putExtra("IsBack", true);
        intent.putExtra("key_from_kuolie", z17);
        intent.putExtra("key_is_upload_video", z16);
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, i3);
        intent.putExtra(QZoneHelper.Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT, false);
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, i16);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("refer", str);
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("publishmood_time_tag", 2, "click to publishmood");
        }
        return intent;
    }

    public static Intent B(Context context) {
        return l(context, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    }

    public static Intent C(Context context) {
        return l(context, "com.qzone.publish.ui.activity.QzonePublishTimeSettingActivity");
    }

    @Deprecated
    public static Intent F(Context context, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i16) {
        String str7;
        Intent intent = new Intent(context, (Class<?>) QZoneUploadPhotoRealActivity.class);
        intent.putExtra(QZoneHelper.Constants.KEY_STATE_TYPE_SRC, i3);
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, str);
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_NAME, str2);
        intent.putExtra("UploadPhoto.key_album_id", str3);
        intent.putExtra("UploadPhoto.key_album_name", str4);
        intent.putExtra("UploadPhoto.key_album_cover", str5);
        intent.putExtra(QZoneHelper.Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT, false);
        intent.putExtra("refer", str6);
        intent.putExtra("UploadPhoto.key_upload_entrance", i16);
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY, UUID.randomUUID().toString());
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        switch (i16) {
            case 11:
                str7 = "1";
                break;
            case 12:
                str7 = "2";
                break;
            case 13:
                str7 = "4";
                break;
            case 14:
                str7 = "6";
                break;
            case 15:
                str7 = "3";
                break;
            case 16:
            default:
                str7 = "";
                break;
            case 17:
                str7 = "5";
                break;
        }
        if (!TextUtils.isEmpty(str7)) {
            intent.putExtra("report_from", str7);
        }
        return intent;
    }

    public static Intent G(Context context, Long l3, int i3) {
        Intent intent = new Intent(context, (Class<?>) QZonePersonalAlbumActivity.class);
        intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_LEFT_TAB_TITLE, context.getString(R.string.gaz));
        intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_RIGHT_TAB_TITLE, context.getString(R.string.gcb));
        intent.putExtra("key_album_owner_uin", l3);
        intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_TAB, i3);
        com.qzone.reborn.albumx.qzone.local.g.f52662a.d();
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        return intent;
    }

    public static Intent H(Context context, String str, String str2, Long l3, String str3, Map<Integer, String> map, int i3, String str4, int i16, boolean z16) {
        Intent w3 = w(context);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, str);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME, str2);
        w3.putExtra("key_album_owner_uin", l3);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_QUESTION, str3);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_BUIS_PARAM, new MapParcelable(map));
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ANSWER_PAGE_CONGENT_FLAG, i3);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ANSWER_PAGE_ERROR_MSG, str4);
        w3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_WX, z16);
        w3.putExtra(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, i16);
        if (z16) {
            w3.addFlags(67108864);
        }
        return w3;
    }

    public static Intent K(Context context, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3, int i16, boolean z16, String str, boolean z17) {
        Intent intent = new Intent(context, (Class<?>) QZonePersonalPhotoListActivity.class);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, baseBusinessAlbumInfo.mAlbumId);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME, baseBusinessAlbumInfo.mTitle);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_PHOTO_SORT_TYPE, baseBusinessAlbumInfo.sortType);
        long j3 = baseBusinessAlbumInfo.mUin;
        if (j3 != 0) {
            intent.putExtra("key_album_owner_uin", j3);
        } else {
            intent.putExtra("key_album_owner_uin", LoginData.getInstance().getUin());
        }
        intent.putExtra("UploadPhoto.key_album_cover", baseBusinessAlbumInfo.mCover);
        intent.putExtra(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, baseBusinessAlbumInfo.mAlbumType);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_INDIVIDUAL_ALBUM, QZoneAlbumUtil.r(baseBusinessAlbumInfo.mAlbumType) == 1 && baseBusinessAlbumInfo.isIndividualityAlbum);
        intent.putExtra("key_personal_album_enter_model", i3);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FROM_SPACE, i16);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_PUBLIC, z16);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_INVITE_KEY, str);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_WX, z17);
        intent.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ANONYMITY, baseBusinessAlbumInfo.mAnonymity);
        if (z17) {
            intent.addFlags(67108864);
        }
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        return intent;
    }

    public static Intent L(Context context, BusinessAlbumInfo businessAlbumInfo, int i3, long j3, long j16) {
        Intent I = I(context, businessAlbumInfo, i3);
        I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_JUMP_PHOTOLIST_BEGIN_TIME, j3);
        I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_JUMP_PHOTOLIST_END_TIME, j16);
        return I;
    }

    public static Intent M(Activity activity, String str, long j3, long j16) {
        Intent l3 = l(activity, "com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity");
        l3.putExtra("SharingOwnersListAlbumId", str);
        l3.putExtra("SharingOwnersListAlbumCreator", j3);
        l3.putExtra("SharingOwnersListAlbumLoginUin", j16);
        return l3;
    }

    public static Intent N(Context context) {
        return l(context, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY);
    }

    public static Intent O(Context context) {
        return l(context, QZoneHelper.VIDEO_COVER_PREVIEW_ACTVITY);
    }

    public static Intent P(Context context) {
        return l(context, QZoneHelper.PAGE_VIDEO_VIEW);
    }

    public static Intent a(String str) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", str);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(str));
        yo.b.a(intent);
        return intent;
    }

    public static Intent b(Context context) {
        return l(context, "com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaListFragment");
    }

    public static Intent c(Context context) {
        return l(context, "com.qzone.business.plusunion.ui.QZoneAppIntroActivity");
    }

    public static Intent d(Context context) {
        return l(context, "com.qzone.homepage.ui.activity.ApplyAccessActivity");
    }

    public static Intent e(Context context) {
        return new Intent(context, (Class<?>) PictureService.class);
    }

    public static Intent f(long j3) {
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(j3);
        if (TextUtils.isEmpty(coverJumpUrlFromJce)) {
            return null;
        }
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", coverJumpUrlFromJce);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(coverJumpUrlFromJce));
        intent.addFlags(268435456);
        yo.b.a(intent);
        return intent;
    }

    public static Intent g(String str, int i3, String str2, long j3) {
        String coverPreviewUrl = QZoneHelper.QZoneCoverConstants.getCoverPreviewUrl(str2, String.valueOf(i3), str, LoginData.getInstance().getUinString(), String.valueOf(j3));
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", coverPreviewUrl);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(coverPreviewUrl));
        yo.b.a(intent);
        return intent;
    }

    public static Intent h(int i3, String str, long j3) {
        String coverStoreUrl = QZoneHelper.QZoneCoverConstants.getCoverStoreUrl(str, String.valueOf(i3), LoginData.getInstance().getUinString(), String.valueOf(j3));
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", coverStoreUrl);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(coverStoreUrl));
        intent.addFlags(268435456);
        yo.b.a(intent);
        return intent;
    }

    public static Intent i(Activity activity, String str, String str2) {
        Intent l3 = l(activity, "com.qzone.album.business.editalbum.QZoneNewAlbumActivity");
        l3.putExtra("QZoneNewAlbumActivity.key_type_src", 1);
        l3.putExtra("QZoneNewAlbumActivity.key_album_id", str);
        l3.putExtra("refer", str2);
        return l3;
    }

    public static Intent j(Context context) {
        return l(context, QZoneHelper.PAGE_FLASH_NICK_NAME_SETTING);
    }

    public static Class<? extends QZoneFragmentHolderActivity> k(String str) {
        boolean c16 = bx.c(str);
        if (com.qzone.reborn.feedx.util.o.f55766a.a(str)) {
            if (c16) {
                return QZoneTransparentFragmentHolderInMainProcessActivity.class;
            }
            return QZoneFragmentHolderInMainProcessActivity.class;
        }
        if (c16) {
            return QZoneTransparentFragmentHolderActivity.class;
        }
        return QZoneFragmentHolderActivity.class;
    }

    public static Intent l(Context context, String str) {
        Intent intent = new Intent(context, k(str));
        intent.putExtra("KEY_FRAGMENT_NAME", str);
        return intent;
    }

    public static Intent m(Context context) {
        return l(context, "com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendStandaloneFragment");
    }

    public static Intent n(String str, int i3, String str2, long j3) {
        String musicCoverPreviewUrl = QZoneHelper.QZoneCoverConstants.getMusicCoverPreviewUrl(str2, String.valueOf(i3), str, LoginData.getInstance().getUinString(), String.valueOf(j3));
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", musicCoverPreviewUrl);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(musicCoverPreviewUrl));
        yo.b.a(intent);
        return intent;
    }

    public static Intent o(Activity activity, String str) {
        Intent l3 = l(activity, "com.qzone.album.business.editalbum.QZoneNewAlbumActivity");
        l3.putExtra("QZoneNewAlbumActivity.key_type_src", 0);
        l3.putExtra("refer", str);
        return l3;
    }

    public static Intent u(Context context, String str, String str2, boolean z16, long j3, boolean z17, int i3, boolean z18) {
        return v(context, str, str2, z16, j3, z17, i3, z18, "");
    }

    private static Intent w(Context context) {
        return l(context, "com.qzone.album.ui.activity.QZonePersonalAlbumAnswerActivity");
    }

    public static Intent y(Context context, String str, int i3, boolean z16) {
        Intent l3 = l(context, QZoneHelper.PERSONAL_ALBUM_SELECT);
        l3.putExtra("key_title", str);
        l3.putExtra("key_personal_album_enter_model", i3);
        l3.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_SELECT_VIDEO, z16);
        return l3;
    }

    public static Intent z(Context context) {
        return new Intent(context, (Class<?>) PictureProcessBootService.class);
    }

    public static void Q(Context context, Intent intent, int i3) {
        R(context, intent, i3, true);
    }

    public static Intent x(Context context, String str, int i3) {
        return y(context, str, i3, false);
    }

    public static void R(Context context, Intent intent, int i3, boolean z16) {
        if (intent != null) {
            intent.putExtra("need_loading_dialog", z16);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                com.qzone.feed.utils.b.e(activity, intent, i3);
                activity.overridePendingTransition(0, 0);
                return;
            }
            com.qzone.feed.utils.b.d(context, intent);
        }
    }

    public static Intent q(Context context, String str, String str2, String str3, boolean z16, long j3, boolean z17) {
        if (context == null) {
            context = ProcessUtils.getTopActivity();
        }
        Intent intent = new Intent(context, VipComponentProxy.f50997g.getUiInterface().getYellowOpenVipActivityClass());
        intent.putExtra("aid", str);
        intent.putExtra("direct_go", !z16);
        intent.putExtra("success_tips", str3);
        intent.putExtra("provide_uin", j3);
        intent.putExtra("serviceType", j3 != LoginData.getInstance().getUin() ? 3 : 1);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("dialog_title", str2);
        }
        return intent;
    }

    public static Intent v(Context context, String str, String str2, boolean z16, long j3, boolean z17, int i3, boolean z18, String str3) {
        if (context == null) {
            context = ProcessUtils.getTopActivity();
        }
        Intent intent = new Intent(context, VipComponentProxy.f50997g.getUiInterface().getYellowOpenVipActivityClass());
        intent.putExtra("aid", str);
        intent.putExtra("direct_go", !z16);
        intent.putExtra("dialog_title", "");
        intent.putExtra("success_tips", str2);
        intent.putExtra("dialog_msg", "");
        intent.putExtra("provide_uin", j3);
        intent.putExtra("serviceType", j3 != LoginData.getInstance().getUin() ? 3 : 1);
        intent.putExtra("is_nianfei_type", z18);
        intent.putExtra("viptype", i3);
        intent.putExtra("url", str3);
        return intent;
    }

    public static Intent I(Context context, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3) {
        return J(context, baseBusinessAlbumInfo, i3, 0, false, null);
    }

    public static Intent J(Context context, BaseBusinessAlbumInfo baseBusinessAlbumInfo, int i3, int i16, boolean z16, String str) {
        return K(context, baseBusinessAlbumInfo, i3, i16, z16, str, false);
    }

    public static Intent r(Context context, String str, String str2, boolean z16, long j3, boolean z17) {
        return u(context, str, str2, z16, j3, z17, 0, false);
    }

    @Deprecated
    public static Intent D(Context context, int i3, String str, String str2, int i16) {
        return F(context, i3, str, str2, null, null, null, null, i16);
    }

    @Deprecated
    public static Intent E(Context context, int i3, String str, String str2, String str3, int i16) {
        return F(context, i3, str, str2, null, null, null, str3, i16);
    }

    public static Intent s(Context context, String str, String str2, boolean z16, long j3, boolean z17, int i3) {
        return u(context, str, str2, z16, j3, z17, i3, false);
    }

    public static Intent t(Context context, String str, String str2, boolean z16, long j3, boolean z17, int i3, String str3) {
        return v(context, str, str2, z16, j3, z17, i3, false, str3);
    }

    public static Intent p(Context context, String str, int i3, String str2, boolean z16, long j3, boolean z17) {
        if (i3 == 5) {
            return u(context, str, str2, z16, j3, z17, 2, false);
        }
        return u(context, str, str2, z16, j3, z17, 0, false);
    }
}
