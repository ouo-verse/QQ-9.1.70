package com.tencent.mobileqq.util;

import QQService.CARDSETTYPE;
import QQService.EVIPSPEC;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyData;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes20.dex */
public class ProfileCardUtil {

    /* renamed from: a, reason: collision with root package name */
    private static long f306411a;

    /* renamed from: b, reason: collision with root package name */
    public static StringBuilder f306412b;

    /* renamed from: com.tencent.mobileqq.util.ProfileCardUtil$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f306421d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f306422e;

        @Override // java.lang.Runnable
        public void run() {
            String f36 = CardHandler.f3(this.f306421d, CardHandler.P2(BaseApplication.getContext()));
            int Q2 = CardHandler.Q2(BaseApplication.getContext());
            String f37 = CardHandler.f3(this.f306421d, Q2);
            BaseImageUtil.transferFile(this.f306422e, f36);
            BaseImageUtil.cropAndCompressImage(this.f306422e, f37, Q2, Q2);
            FileUtils.delete(this.f306422e, true);
        }
    }

    /* renamed from: com.tencent.mobileqq.util.ProfileCardUtil$3, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f306423d;

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f306423d);
            if (file.exists() && file.isFile()) {
                boolean delete = file.delete();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.profilecard.VoiceIntro", 2, "delete result=" + delete + " f.path=" + this.f306423d);
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f306430a = -99999;

        /* renamed from: b, reason: collision with root package name */
        public String f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UNKNOW_ERROR;
    }

    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        Bundle f306432a = new Bundle();

        public Bundle a() {
            return this.f306432a;
        }

        public b b(String str) {
            this.f306432a.putString("img_evidence", str);
            return this;
        }

        public b c(String str) {
            this.f306432a.putString("text_evidence", str);
            return this;
        }

        public b d(String str) {
            this.f306432a.putString("video_evidence", str);
            return this;
        }
    }

    /* loaded from: classes20.dex */
    public interface c {
        void onResult(boolean z16);
    }

    public static int A(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return FaceUtil.getAvatarLengthOfEdge(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static void A0(Activity activity, View view, String str) {
        B0(activity, view, str, false, false);
    }

    public static final int B(Resources resources) {
        try {
            return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return (int) ((resources.getDisplayMetrics().density * 25.0f) + 0.5d);
        }
    }

    public static void B0(Activity activity, View view, String str, boolean z16, boolean z17) {
        C0(activity, view, str, z16, z17, null);
    }

    public static String C() {
        return VFSAssistantUtils.getSDKPrivatePath(CardHandler.E + FaceUtil.IMG_TEMP + "/" + System.currentTimeMillis() + "_cardbg.tmp");
    }

    public static void C0(Activity activity, View view, String str, boolean z16, boolean z17, AllInOne allInOne) {
        Intent intent = new Intent(activity, (Class<?>) FriendProfileImageActivity.class);
        intent.putExtra("friendUin", str);
        intent.putExtra("KEY_THUMBNAL_BOUND", com.tencent.common.galleryactivity.j.d(view));
        intent.putExtra("is_hide_actionsheet", z16);
        intent.putExtra("is_hide_footbar", z17);
        if (allInOne != null) {
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        }
        activity.startActivity(intent);
    }

    public static String D(byte b16) {
        switch (b16) {
            case 1:
                return HardCodeUtil.qqStr(R.string.pdl);
            case 2:
                return HardCodeUtil.qqStr(R.string.pdd);
            case 3:
                return HardCodeUtil.qqStr(R.string.f172321pe3);
            case 4:
                return HardCodeUtil.qqStr(R.string.pdb);
            case 5:
                return HardCodeUtil.qqStr(R.string.pdi);
            case 6:
                return HardCodeUtil.qqStr(R.string.pdh);
            case 7:
                return HardCodeUtil.qqStr(R.string.pdv);
            case 8:
                return HardCodeUtil.qqStr(R.string.pe8);
            case 9:
                return HardCodeUtil.qqStr(R.string.peg);
            case 10:
                return HardCodeUtil.qqStr(R.string.peo);
            case 11:
                return HardCodeUtil.qqStr(R.string.pe5);
            case 12:
                return HardCodeUtil.qqStr(R.string.pdx);
            default:
                return null;
        }
    }

    public static void D0(Activity activity, View view, String str, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FriendProfileImageActivity.class);
        intent.putExtra("friendUin", str);
        intent.putExtra("curType", i3);
        Rect d16 = com.tencent.common.galleryactivity.j.d(view);
        intent.putExtra("is_from_face2face_add_friend", true);
        intent.putExtra("KEY_THUMBNAL_BOUND", d16);
        activity.startActivity(intent);
    }

    public static void E(Activity activity, String str, String str2, int i3, int i16, int i17, String str3, boolean z16) {
        G(activity, str, str2, i3, i16, i17, str3, z16, false, "", 0);
    }

    public static void E0(Activity activity, View view, String str, long j3, int i3, AllInOne allInOne) {
        Intent intent = new Intent(activity, (Class<?>) FriendProfileImageActivity.class);
        intent.putExtra("friendUin", str);
        Rect d16 = com.tencent.common.galleryactivity.j.d(view);
        intent.putExtra("extra_pendant_id", j3);
        intent.putExtra("extra_action_source", i3);
        intent.putExtra("KEY_THUMBNAL_BOUND", d16);
        if (allInOne != null) {
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        }
        activity.startActivity(intent);
    }

    public static void F(Activity activity, String str, String str2, int i3, int i16, int i17, String str3, boolean z16, int i18) {
        G(activity, str, str2, i3, i16, i17, str3, z16, false, "", i18);
    }

    public static void F0(Activity activity, View view, String str) {
        PicInfo picInfo = new PicInfo();
        picInfo.f258920i = str;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(picInfo);
        Intent intent = new Intent();
        intent.putExtra("intent_param_index", 0);
        intent.putExtra("intent_param_pic_infos", arrayList);
        intent.putExtra("KEY_THUMBNAL_BOUND", com.tencent.common.galleryactivity.j.d(view));
        intent.putExtra("extra.IS_FROM_PROFILE_CARD", true);
        intent.addFlags(536870912);
        RouteUtils.startActivity(activity, intent, "/nearby/profile/pic/browser");
    }

    public static void G(Activity activity, String str, String str2, int i3, int i16, int i17, String str3, boolean z16, boolean z17, String str4, int i18) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra("uin", str);
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, z17);
        bundle.putBoolean(QCircleScheme.AttrDetail.HAS_RED_DOT, z17);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        String marketUrl = IndividuationUrlHelper.getMarketUrl(activity, IndividuationUrlHelper.UrlId.CARD_HOME, str2);
        if (!TextUtils.isEmpty(str3)) {
            marketUrl = marketUrl + ContainerUtils.FIELD_DELIMITER + str3;
        }
        String str5 = marketUrl + "&entryId=" + i16 + "&isCache=" + i3 + "&tabId=" + i17;
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardActivity(activity)) {
            if (i16 == 0) {
                intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_USER_PROFILE_CARD);
                bundle.putInt("individuation_url_type", VasWebviewConstants.REPORT_FROM_USER_PROFILE_CARD);
            } else if (i16 == 1) {
                intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_OTHER_PROFILE_CARD);
                bundle.putInt("individuation_url_type", VasWebviewConstants.REPORT_FROM_OTHER_PROFILE_CARD);
            } else if (i16 == 3) {
                intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_PROFILE_CARD_MALL_BUTON);
                bundle.putInt("individuation_url_type", VasWebviewConstants.REPORT_FROM_PROFILE_CARD_MALL_BUTON);
            }
        }
        String addEntryParamToUrl = VasWebviewUtil.addEntryParamToUrl(str5, i18);
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(activity, addEntryParamToUrl, 0, bundle);
        } else {
            intent.putExtra("url", addEntryParamToUrl);
            VasWebviewUtil.openQQBrowserWithoutAD(activity, addEntryParamToUrl, -1L, intent, z16, 0);
        }
    }

    public static void G0(QQAppInterface qQAppInterface, Activity activity, View view, String str, int i3, int i16) {
        String str2;
        boolean z16 = true;
        boolean z17 = false;
        if (view instanceof DynamicAvatarView) {
            com.tencent.mobileqq.app.face.h hVar = ((DynamicAvatarView) view).E;
            if (hVar != null && hVar.f195576c && !TextUtils.isEmpty(hVar.f195585l)) {
                F0(activity, view, hVar.f195585l);
            } else {
                if (i16 == 1) {
                    D0(activity, view, str, i3);
                } else {
                    B0(activity, view, str, true, true);
                }
                z16 = false;
            }
            z17 = z16;
        } else if (i16 == 1) {
            D0(activity, view, str, i3);
        } else {
            B0(activity, view, str, true, true);
        }
        if (i16 == 0) {
            if (z17) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, str2, "", "", "");
        }
    }

    public static void H(Context context, long j3, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("isShowAd", false);
        if (TextUtils.isEmpty(str)) {
            str = String.format(IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.RARE_CARD), Long.valueOf(j3));
        }
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static synchronized Card I(AppRuntime appRuntime, String str) {
        Card card;
        byte b16;
        byte b17;
        synchronized (ProfileCardUtil.class) {
            FriendsManager friendsManager = (FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "ProfileCardUtil");
            if (friendsManager != null) {
                card = friendsManager.r(str);
            } else {
                card = null;
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "ProfileCardUtil");
            byte b18 = 0;
            if (card == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCardUtil", 2, "initCard card = null, uin = " + str);
                }
                card = new Card();
                card.uin = str;
                card.shGender = (short) -1;
                if (friendsSimpleInfoWithUid != null && vasSimpleInfoWithUid != null) {
                    card.strNick = friendsSimpleInfoWithUid.p();
                    card.strReMark = friendsSimpleInfoWithUid.r();
                    card.strShowName = friendsSimpleInfoWithUid.c();
                    EVIPSPEC evipspec = EVIPSPEC.E_SP_QQVIP;
                    if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec)) {
                        b16 = 1;
                    } else {
                        b16 = 0;
                    }
                    card.bQQVipOpen = b16;
                    EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
                    if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec2)) {
                        b17 = 1;
                    } else {
                        b17 = 0;
                    }
                    card.bSuperVipOpen = b17;
                    EVIPSPEC evipspec3 = EVIPSPEC.E_SP_SUPERQQ;
                    if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec3)) {
                        b18 = 1;
                    }
                    card.bSuperQQOpen = b18;
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCardUtil", 2, "initCard bSuperVipOpen=" + ((int) card.bSuperVipOpen) + ",bQQVipOpen=" + ((int) card.bQQVipOpen) + ",uin = " + str);
                    }
                    card.iQQVipType = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec);
                    card.iSuperVipType = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec2);
                    card.iSuperQQType = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec3);
                    card.iQQVipLevel = com.tencent.mobileqq.vip.r.a(vasSimpleInfoWithUid, evipspec);
                    card.iSuperVipLevel = com.tencent.mobileqq.vip.r.a(vasSimpleInfoWithUid, evipspec2);
                    card.iSuperQQLevel = com.tencent.mobileqq.vip.r.a(vasSimpleInfoWithUid, evipspec3);
                    card.lUserFlag = friendsSimpleInfoWithUid.e().byteValue();
                    card.namePlateOfKingGameId = vasSimpleInfoWithUid.namePlateOfKingGameId;
                    card.namePlateOfKingLoginTime = vasSimpleInfoWithUid.namePlateOfKingLoginTime;
                    card.gameCardId = vasSimpleInfoWithUid.gameCardId;
                } else {
                    card.strSign = "";
                    card.strNick = "";
                    card.strReMark = "";
                }
                if (friendsManager != null) {
                    friendsManager.p0(card);
                }
            } else if (friendsSimpleInfoWithUid != null) {
                if (!Utils.p(friendsSimpleInfoWithUid.c(), card.strShowName)) {
                    card.strShowName = friendsSimpleInfoWithUid.c();
                    b18 = 1;
                }
                if ((friendsSimpleInfoWithUid.e().byteValue() & 1) == 1) {
                    card.lUserFlag |= 1;
                }
                if (friendsManager != null && b18 != 0) {
                    friendsManager.p0(card);
                }
            }
        }
        return card;
    }

    private static a J(String str, Intent intent, boolean z16, c cVar) {
        File file = new File(str);
        long length = file.length();
        a aVar = new a();
        if (!file.exists()) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST;
            s0("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return aVar;
        }
        if (!NetworkUtil.isNetSupport(null)) {
            aVar.f306430a = -10001;
            aVar.f306431b = "network error";
            s0("onAvatarChanged", -10001, "network error");
            return aVar;
        }
        if (length > 0 && length < 1749600) {
            if (z16) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i3 = options.outWidth;
                if (i3 != options.outHeight || i3 <= 0 || i3 > 1080) {
                    aVar.f306430a = -10000;
                    aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
                    s0("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL);
                    return aVar;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + length);
            }
            aVar.f306430a = 0;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            FaceUtil.setTempAvatarFilePath(str);
            y0(str, intent, cVar);
            return aVar;
        }
        s0("onAvatarChanged", 0, String.valueOf(length));
        aVar.f306430a = -10000;
        aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
        s0("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL);
        return aVar;
    }

    public static boolean K(com.tencent.mobileqq.profile.d dVar) {
        if (dVar.f260137a == 160) {
            return true;
        }
        return false;
    }

    public static boolean L(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            return arrayList.contains(3);
        }
        return false;
    }

    public static boolean M(String str) {
        try {
            File file = new File(u(str));
            if (file.exists() && file.isFile()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isExistBgResource is exists");
                    return true;
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isExistBgResource is not exists");
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isExistBgResource exception msg=" + e16.getMessage());
            }
            return false;
        }
    }

    public static boolean N(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            return arrayList.contains(2);
        }
        return false;
    }

    public static boolean O(Card card, QQAppInterface qQAppInterface) {
        boolean z16 = false;
        if (card != null && qQAppInterface != null && !card.isNewSchoolStatusWriteForGuide() && !TextUtils.isEmpty(card.strSchool)) {
            z16 = qQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).getBoolean("new_school_guide_init_" + card.uin, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isNeedGuideForNewSchoolData " + z16);
        }
        return z16;
    }

    public static boolean P(@NonNull QQAppInterface qQAppInterface, String str) {
        if (QVipConfigManager.getInteger(qQAppInterface, QVipConfigManager.KEY_INTEGER_SHOW_DIY_TEMPLATE_GUIDE_FOR_GUEST_TIME, 0) >= 3) {
            return false;
        }
        if (System.currentTimeMillis() - qQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0).getLong(qQAppInterface.getCurrentAccountUin() + "_" + str, 0L) < 86400000) {
            return false;
        }
        return true;
    }

    public static boolean Q(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (!S(arrayList) && !L(arrayList)) {
            return false;
        }
        return true;
    }

    public static boolean R(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (!S(arrayList) && !L(arrayList) && !N(arrayList)) {
            return false;
        }
        return true;
    }

    public static boolean S(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            return arrayList.contains(1);
        }
        return false;
    }

    public static SpannableStringBuilder T(List<SpannableString> list, int i3, int i16, String str, SpannableStringBuilder spannableStringBuilder) {
        int size;
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
        } else {
            spannableStringBuilder.clear();
        }
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        for (int i17 = i3; i17 >= 0 && i17 < i16 && i17 < size; i17++) {
            if (i17 > i3) {
                spannableStringBuilder.append((CharSequence) str);
            }
            spannableStringBuilder.append((CharSequence) list.get(i17));
        }
        return spannableStringBuilder;
    }

    public static void U(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f306411a < 1500) {
            return;
        }
        f306411a = currentTimeMillis;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        String buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl("https://ti.qq.com/signature/msglist?_wv=3&_wwv=128", IVipTraceDetailReport.FROM.DRAWER_TOP_MSG);
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardUtil", 2, "jumpProfileBubbleMsgList pageUrl:" + buildTraceDetailUrl);
        }
        intent.putExtra("url", buildTraceDetailUrl);
        context.startActivity(intent);
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        localRedTouchManager.v(10019, false);
        localRedTouchManager.v(10020, false);
        localRedTouchManager.v(10022, false);
        localRedTouchManager.v(10029, false);
        localRedTouchManager.v(10030, false);
        localRedTouchManager.v(10021, false);
        localRedTouchManager.v(10023, false);
        localRedTouchManager.v(10024, false);
        localRedTouchManager.v(10025, false);
        localRedTouchManager.v(10026, false);
        localRedTouchManager.v(10027, false);
        localRedTouchManager.v(10028, false);
        localRedTouchManager.v(10031, false);
        localRedTouchManager.v(10032, false);
        QLog.d("ProfileCardUtil", 1, "jumpProfileBubbleMsgList");
    }

    public static List<Pair<String, String>> V(Context context, ProfileCardInfo profileCardInfo) {
        ArrayList arrayList = new ArrayList(3);
        if (context != null && profileCardInfo.card != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
            }
            short genderWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(profileCardInfo);
            if (genderWithPrivacy == 0) {
                arrayList.add(Pair.create(context.getString(R.string.c7_), ""));
            } else if (genderWithPrivacy == 1) {
                arrayList.add(Pair.create(context.getString(R.string.b5e), ""));
            }
            String schoolWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(schoolWithPrivacy)) {
                arrayList.add(Pair.create(schoolWithPrivacy, "school"));
            }
            String companyWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(companyWithPrivacy)) {
                arrayList.add(Pair.create(companyWithPrivacy, IProfileProtocolConst.KEY_COMPANY));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
            String locationCountryWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(profileCardInfo);
            String locationProvinceWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(profileCardInfo);
            String locationCityWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(profileCardInfo);
            StringBuilder sb5 = new StringBuilder(50);
            if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !HardCodeUtil.qqStr(R.string.pdw).equals(locationCountryWithPrivacy)) {
                sb5.append(locationCountryWithPrivacy);
            }
            if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
                if (sb5.length() > 0) {
                    sb5.append("-");
                }
                sb5.append(locationProvinceWithPrivacy);
            }
            if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
                if (sb5.length() > 0) {
                    sb5.append("-");
                }
                sb5.append(locationCityWithPrivacy);
            }
            if (sb5.length() > 0) {
                arrayList.add(Pair.create(sb5.toString(), "location"));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
            String constellationWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(constellationWithPrivacy)) {
                arrayList.add(Pair.create(constellationWithPrivacy, ""));
            }
        }
        return arrayList;
    }

    public static List<SpannableString> W(QQAppInterface qQAppInterface, Context context, ProfileCardInfo profileCardInfo) {
        ArrayList arrayList = new ArrayList();
        if (context != null && profileCardInfo.card != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
            }
            short genderWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(profileCardInfo);
            if (genderWithPrivacy == 0) {
                arrayList.add(new SpannableString(context.getString(R.string.c7_)));
            } else if (genderWithPrivacy == 1) {
                arrayList.add(new SpannableString(context.getString(R.string.b5e)));
            }
            String schoolWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(schoolWithPrivacy)) {
                if (profileCardInfo.card.schoolVerifiedFlag) {
                    arrayList.add(Y(schoolWithPrivacy, true, R.drawable.ne8, R.dimen.d6f, R.dimen.d6e, context, qQAppInterface));
                } else {
                    arrayList.add(new SpannableString(profileCardInfo.card.strSchool));
                }
            }
            String companyWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(companyWithPrivacy)) {
                arrayList.add(new SpannableString(companyWithPrivacy));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
            String locationCountryWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(profileCardInfo);
            String locationProvinceWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(profileCardInfo);
            String locationCityWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(profileCardInfo);
            StringBuilder sb5 = new StringBuilder(50);
            if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !HardCodeUtil.qqStr(R.string.pdw).equals(locationCountryWithPrivacy)) {
                sb5.append(locationCountryWithPrivacy);
            }
            if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
                if (sb5.length() > 0) {
                    sb5.append("-");
                }
                sb5.append(locationProvinceWithPrivacy);
            }
            if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
                if (sb5.length() > 0) {
                    sb5.append("-");
                }
                sb5.append(locationCityWithPrivacy);
            }
            if (sb5.length() > 0) {
                arrayList.add(new SpannableString(sb5.toString()));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
            String constellationWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(profileCardInfo);
            if (!TextUtils.isEmpty(constellationWithPrivacy)) {
                arrayList.add(new SpannableString(constellationWithPrivacy));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String X(Context context, ProfileCardInfo profileCardInfo) {
        String str;
        String str2;
        byte b16;
        Card card = profileCardInfo.card;
        ContactCard contactCard = profileCardInfo.contactCard;
        String str3 = "";
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41610, profileCardInfo)) {
            if (card != null) {
                b16 = card.age;
            } else if (contactCard != null) {
                b16 = contactCard.bAge;
            } else {
                b16 = -1;
            }
            if (b16 > 0) {
                str = ((int) b16) + context.getString(R.string.htz);
                if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41614, profileCardInfo)) {
                    if (card != null) {
                        if (TextUtils.isEmpty(card.strCountry) || HardCodeUtil.qqStr(R.string.pdn).equals(card.strCountry)) {
                            str2 = "";
                        } else {
                            str2 = "" + card.strCountry;
                        }
                        if (!TextUtils.isEmpty(card.strProvince)) {
                            if (!TextUtils.isEmpty(str2)) {
                                str2 = str2 + " ";
                            }
                            str2 = str2 + card.strProvince;
                        }
                        if (!TextUtils.isEmpty(card.strCity)) {
                            if (!TextUtils.isEmpty(str2)) {
                                str2 = str2 + " ";
                            }
                            str2 = str2 + card.strCity;
                        }
                    } else if (contactCard != null) {
                        if (TextUtils.isEmpty(contactCard.strCountry) || HardCodeUtil.qqStr(R.string.f172318pe0).equals(contactCard.strCountry)) {
                            str2 = "";
                        } else {
                            str2 = "" + contactCard.strCountry;
                        }
                        if (!TextUtils.isEmpty(contactCard.strProvince)) {
                            if (!TextUtils.isEmpty(str2)) {
                                str2 = str2 + " ";
                            }
                            str2 = str2 + contactCard.strProvince;
                        }
                        if (!TextUtils.isEmpty(contactCard.strCity)) {
                            if (!TextUtils.isEmpty(str2)) {
                                str2 = str2 + " ";
                            }
                            str2 = str2 + contactCard.strCity;
                        }
                    }
                    if (str != null && str.length() > 0) {
                        str3 = " " + str;
                    }
                    if (str2 != null && str2.length() > 0) {
                        return str3 + " " + str2;
                    }
                }
                str2 = "";
                if (str != null) {
                    str3 = " " + str;
                }
                return str2 != null ? str3 : str3;
            }
        }
        str = "";
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41614, profileCardInfo)) {
        }
        str2 = "";
        if (str != null) {
        }
        if (str2 != null) {
        }
    }

    public static SpannableString Y(String str, boolean z16, int i3, int i16, int i17, Context context, QQAppInterface qQAppInterface) {
        String str2;
        int length;
        if (!TextUtils.isEmpty(str)) {
            int i18 = 1;
            if (z16) {
                str2 = " " + str;
                length = 0;
            } else {
                str2 = str + " ";
                length = str2.length() - 1;
                i18 = str2.length();
            }
            SpannableString spannableString = new SpannableString(str2);
            int dimension = (int) context.getResources().getDimension(i16);
            int dimension2 = (int) context.getResources().getDimension(i17);
            Drawable drawable = context.getResources().getDrawable(i3);
            drawable.setBounds(0, 0, dimension, dimension2);
            ProfileCardUtils.setNightModeFilterForDrawable(qQAppInterface, drawable);
            spannableString.setSpan(new ImageSpan(drawable), length, i18, 33);
            return spannableString;
        }
        return null;
    }

    public static String Z(Context context, int i3, int i16, String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append(context.getString(R.string.c7_));
            sb5.append("  ");
        } else if (i3 == 1) {
            sb5.append(context.getString(R.string.b5e));
            sb5.append("  ");
        }
        if (i16 != 0) {
            sb5.append(i16);
            sb5.append(context.getString(R.string.htz));
            sb5.append("  ");
        }
        String str4 = "";
        if (!TextUtils.isEmpty(str) && !HardCodeUtil.qqStr(R.string.pdp).equals(str)) {
            str4 = "" + str;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4 + " ";
            }
            str4 = str4 + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4 + " ";
            }
            str4 = str4 + str3;
        }
        sb5.append(str4);
        return sb5.toString();
    }

    public static int a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap t06 = t0(str, 100, 0.5633803f);
        int i3 = 0;
        if (t06 == null) {
            return 0;
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < t06.getHeight(); i18++) {
            for (int i19 = 0; i19 < t06.getWidth(); i19++) {
                int pixel = t06.getPixel(i19, i18);
                if (((Color.red(pixel) + Color.green(pixel)) + Color.blue(pixel)) / 3 > 127) {
                    i16++;
                } else {
                    i17++;
                }
            }
        }
        if (i16 >= i17) {
            i3 = 1;
        }
        t06.recycle();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - currentTimeMillis) + "(ms)");
        }
        return i3;
    }

    public static String a0(Context context, ProfileCardInfo profileCardInfo) {
        String str;
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41611, profileCardInfo)) {
            Card card = profileCardInfo.card;
            ContactCard contactCard = profileCardInfo.contactCard;
            short s16 = profileCardInfo.allInOne.gender;
            if (s16 != 0 && s16 != 1 && ((card == null || ((s16 = card.shGender) != 0 && s16 != 1)) && (contactCard == null || ((s16 = contactCard.bSex) != 0 && s16 != 1)))) {
                s16 = -1;
            }
            if (s16 == 0) {
                str = context.getString(R.string.c7_);
            } else if (s16 == 1) {
                str = context.getString(R.string.b5e);
            }
            return str + X(context, profileCardInfo);
        }
        str = "";
        return str + X(context, profileCardInfo);
    }

    private static boolean b(RedTouchItem redTouchItem) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        boolean z16 = false;
        if (application == null) {
            QLog.i("ProfileCardUtil", 1, "checkNeedShowRedPoint false, application null.");
            return false;
        }
        AppRuntime runtime = application.getRuntime();
        if (runtime == null) {
            QLog.i("ProfileCardUtil", 1, "checkNeedShowRedPoint false, runtime null.");
            return false;
        }
        if (redTouchItem == null) {
            QLog.i("ProfileCardUtil", 1, "checkNeedShowRedPoint false, item null.");
            return false;
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) runtime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        if (localRedTouchManager == null) {
            QLog.i("ProfileCardUtil", 1, "checkNeedShowRedPoint false, LocalRedTouchManager null.");
            return false;
        }
        if (localRedTouchManager.d(redTouchItem, true) && redTouchItem.count > 0) {
            z16 = true;
        }
        QLog.i("ProfileCardUtil", 1, "checkNeedShowRedPoint, taskId: " + redTouchItem.taskId + ", count: " + redTouchItem.count + ", needShow: " + z16);
        return z16;
    }

    public static String b0(Context context, ProfileCardInfo profileCardInfo) {
        StringBuilder sb5 = new StringBuilder();
        short genderWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(profileCardInfo);
        if (genderWithPrivacy == 0) {
            sb5.append(context.getString(R.string.c7_));
            sb5.append("  ");
        } else if (genderWithPrivacy == 1) {
            sb5.append(context.getString(R.string.b5e));
            sb5.append("  ");
        }
        short ageWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getAgeWithPrivacy(profileCardInfo);
        if (ageWithPrivacy != 0) {
            sb5.append((int) ageWithPrivacy);
            sb5.append(context.getString(R.string.htz));
            sb5.append("  ");
        }
        String constellationWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(constellationWithPrivacy)) {
            sb5.append(constellationWithPrivacy);
            sb5.append("  ");
        }
        String locationCountryWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(profileCardInfo);
        String locationProvinceWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(profileCardInfo);
        String locationCityWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(profileCardInfo);
        String str = "";
        if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !HardCodeUtil.qqStr(R.string.pef).equals(locationCountryWithPrivacy)) {
            str = "" + locationCountryWithPrivacy;
        }
        if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "-";
            }
            str = str + locationProvinceWithPrivacy;
        }
        if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "-";
            }
            str = str + locationCityWithPrivacy;
        }
        sb5.append(str);
        return sb5.toString();
    }

    public static int c(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().heightPixels - B(context.getResources())) * 0.75f);
    }

    public static SpannableString c0(String str, boolean z16, int i3, int i16, int i17, Context context, QQAppInterface qQAppInterface, ClickableSpan clickableSpan) {
        String str2;
        int length;
        if (!TextUtils.isEmpty(str)) {
            int i18 = 1;
            if (z16) {
                str2 = "  " + str;
                length = 0;
            } else {
                str2 = str + "  ";
                length = str2.length() - 1;
                i18 = str2.length();
            }
            SpannableString spannableString = new SpannableString(str2);
            int dimension = (int) context.getResources().getDimension(i16);
            int dimension2 = (int) context.getResources().getDimension(i17);
            Drawable drawable = context.getResources().getDrawable(i3);
            drawable.setBounds(0, 0, dimension, dimension2);
            ProfileCardUtils.setNightModeFilterForDrawable(qQAppInterface, drawable);
            spannableString.setSpan(new VerticalCenterImageSpan(drawable, 0), length, i18, 33);
            if (clickableSpan != null) {
                spannableString.setSpan(clickableSpan, length, i18, 33);
            }
            return spannableString;
        }
        return null;
    }

    public static int d(Context context) {
        return (int) (c(context) * 0.5633803f);
    }

    public static void d0(@NonNull QQAppInterface qQAppInterface) {
        QVipConfigManager.setInteger(qQAppInterface, QVipConfigManager.KEY_INTEGER_SHOW_DIY_TEMPLATE_GUIDE_FOR_GUEST_TIME, QVipConfigManager.getInteger(qQAppInterface, QVipConfigManager.KEY_INTEGER_SHOW_DIY_TEMPLATE_GUIDE_FOR_GUEST_TIME, 0) + 1);
    }

    public static void e(TextView textView, String str, String str2) {
        if (textView != null) {
            Resources resources = textView.getResources();
            LongClickCopyData longClickCopyData = new LongClickCopyData();
            String charSequence = textView.getText().toString();
            if (str != null && charSequence.contains(str)) {
                longClickCopyData.addCopyItem(resources.getString(R.string.f203284zs), str);
                if (!TextUtils.isEmpty(str2) && charSequence.contains(str2)) {
                    longClickCopyData.addCopyItem(resources.getString(R.string.f203264zq), str2);
                }
            } else if (str2 != null && charSequence.contains(str2)) {
                longClickCopyData.addCopyItem(resources.getString(R.string.f203264zq), str2);
            } else {
                longClickCopyData.addCopyItem(resources.getString(R.string.f203254zp), charSequence);
            }
            LongClickCopyAction.attachCopyAction(textView, longClickCopyData);
        }
    }

    public static void e0(@NonNull QQAppInterface qQAppInterface, String str) {
        qQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0).edit().putLong(qQAppInterface.getCurrentAccountUin() + "_" + str, System.currentTimeMillis()).apply();
    }

    @NotNull
    public static void f(QQAppInterface qQAppInterface) {
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        localRedTouchManager.b(10019, false);
        localRedTouchManager.b(10020, false);
        localRedTouchManager.b(10022, false);
        localRedTouchManager.b(10021, false);
        localRedTouchManager.b(10023, false);
        localRedTouchManager.b(10024, false);
        localRedTouchManager.b(10025, false);
        localRedTouchManager.b(10026, false);
        localRedTouchManager.b(10027, false);
        localRedTouchManager.b(10028, false);
    }

    @Deprecated
    public static void f0(BaseActivity baseActivity, long j3, String str, String str2, int i3) {
        NewReportPlugin.O(baseActivity, j3, str, str2, i3, "", new Bundle());
    }

    public static final int g(Context context, float f16) {
        return (int) TypedValue.applyDimension(1, f16, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    @Deprecated
    public static void g0(BaseActivity baseActivity, long j3, String str, String str2, int i3, String str3, Bundle bundle) {
        NewReportPlugin.O(baseActivity, j3, str, str2, i3, str3, bundle);
    }

    public static final int h(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static boolean h0(QQAppInterface qQAppInterface, String str, Intent intent) {
        if (J(str, intent, false, null).f306430a != 0) {
            return false;
        }
        return true;
    }

    public static final int i(Context context, int i3) {
        return (int) Math.floor(TypedValue.applyDimension(1, i3, context.getApplicationContext().getResources().getDisplayMetrics()));
    }

    public static boolean i0(QQAppInterface qQAppInterface, String str, Intent intent, c cVar) {
        if (J(str, intent, false, cVar).f306430a != 0) {
            return false;
        }
        return true;
    }

    public static final int j(Context context, int i3) {
        return (int) Math.ceil(TypedValue.applyDimension(1, i3, context.getApplicationContext().getResources().getDisplayMetrics()));
    }

    public static a j0(QQAppInterface qQAppInterface, String str, Intent intent, boolean z16) {
        boolean z17 = false;
        if (z16) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(str, options);
                if (options.outWidth != options.outHeight) {
                    z17 = true;
                }
            } catch (Exception unused) {
            }
        }
        String uploadAvatarTempPath = FaceUtil.getUploadAvatarTempPath();
        BaseImageUtil.compressImageJpg(str, uploadAvatarTempPath, 1080, 1080, 100, z17);
        return J(uploadAvatarTempPath, intent, true, null);
    }

    public static void k(String str, Activity activity) {
        boolean z16 = true;
        if (!TextUtils.isEmpty(str) && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
            bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("param:activity:");
            if (activity != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("forwardtofriend", 2, sb5.toString());
        }
    }

    public static void k0(String str, QQAppInterface qQAppInterface, Activity activity, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "openAddPersonalityLabel");
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", com.tencent.mobileqq.profile.PersonalityLabel.a.f259945c);
        intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
        intent.putExtra(QQBrowserActivity.BROADCAST_ACTION_KEY, "com.tencent.mobileqq.card.modify_personality_label");
        intent.putExtra("fromProfile", z16);
        activity.startActivity(intent);
    }

    public static void l(String str, QQAppInterface qQAppInterface, Activity activity) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && activity != null) {
            try {
                QfavBuilder.e0(str).h(activity, qQAppInterface.getCurrentAccountUin());
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("forwardFavorite", 2, "", e16);
                }
                QQToast.makeText(activity, activity.getResources().getString(R.string.bfz), 0).show();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("param:app:");
            if (qQAppInterface == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(",activity:");
            if (activity == null) {
                z17 = true;
            }
            sb5.append(z17);
            QLog.i("forwardFavorite", 2, sb5.toString());
        }
    }

    public static void l0(Context context, BusinessCard businessCard, AllInOne allInOne) {
        m0(context, businessCard, allInOne, false);
    }

    public static void m(String str, QQAppInterface qQAppInterface, Activity activity) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && activity != null) {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            userInfo.qzone_uin = currentAccountUin;
            userInfo.nickname = com.tencent.mobileqq.utils.ac.f(qQAppInterface, currentAccountUin);
            QZoneHelper.forwardToPublishMood(activity, userInfo, str, activity.getString(R.string.b1o), "", -1);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("param:app:");
            boolean z17 = true;
            if (qQAppInterface == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(",activity:");
            if (activity != null) {
                z17 = false;
            }
            sb5.append(z17);
            QLog.i("forwardQzone", 2, sb5.toString());
        }
    }

    public static void m0(Context context, BusinessCard businessCard, AllInOne allInOne, boolean z16) {
        n0(context, businessCard, allInOne, z16, null);
    }

    public static String n(boolean z16, boolean z17, int i3, int i16, int i17) {
        if (z16) {
            if (!z17) {
                if (i3 == 4) {
                    if (i16 != 0 && i16 != 1) {
                        if (i16 == 2) {
                            return "mvip.gongneng.android.mingpian_open429";
                        }
                        if (i16 == 4) {
                            return "mvip.gongneng.android.mingpian_open4210";
                        }
                        return "";
                    }
                    return "mvip.gongneng.android.mingpian_open427";
                }
                if (i3 == 2) {
                    if (i16 == 4) {
                        return "mvip.gongneng.android.mingpian_open428";
                    }
                    return "";
                }
                if ((i3 == 0 || i3 == 1) && i16 == 4) {
                    return "mvip.gongneng.android.mingpian_open426";
                }
                return "";
            }
            return "";
        }
        if (!z17) {
            if (i17 == 2) {
                if (i3 == 4) {
                    if (i16 != 0 && i16 != 1) {
                        if (i16 == 2) {
                            return "mvip.gongneng.android.mingpian_open424";
                        }
                        if (i16 == 4) {
                            return "mvip.gongneng.android.mingpian_open425";
                        }
                        return "";
                    }
                    return "mvip.gongneng.android.mingpian_open422";
                }
                if (i3 == 2) {
                    if (i16 == 4) {
                        return "mvip.gongneng.android.mingpian_open423";
                    }
                    return "";
                }
                if ((i3 == 0 || i3 == 1) && i16 == 4) {
                    return "mvip.gongneng.android.mingpian_open421";
                }
                return "";
            }
            if (i3 == 2) {
                if (i16 == 2) {
                    return "mvip.gongneng.android.mingpian_open413";
                }
                return "mvip.gongneng.android.mingpian_open412";
            }
            if (i16 == 2) {
                return "mvip.gongneng.android.mingpian_open411";
            }
            return "";
        }
        return "";
    }

    public static void n0(Context context, BusinessCard businessCard, AllInOne allInOne, boolean z16, Bundle bundle) {
        Intent intent;
        if (!z16) {
            intent = new Intent(context, (Class<?>) BusinessCardEditActivity.class);
        } else {
            intent = new Intent();
            intent.setClassName("com.tencent.mobileqq", BusinessCardEditActivity.class.getName());
        }
        if (allInOne.f260789pa == 0) {
            intent.putExtra("mode_type", 3);
            intent.putExtra("source_activity", 3);
        } else {
            intent.putExtra("mode_type", 2);
            intent.putExtra("source_activity", 1);
            businessCard.bindUin = allInOne.uin;
        }
        intent.putExtra("cur_card_body", businessCard);
        intent.putExtra("is_edit_mode", true);
        intent.putExtra("finish_immedia", true);
        ArrayList<ProfileContactInfo> arrayList = allInOne.contactArray;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ProfileContactInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().phoneNumber);
            }
            intent.putExtra("bind_phone_num", arrayList2);
        }
        if (z16) {
            intent.putExtra(ProfileContants.CMD_PARAM_NOTIFY_PLUGIN, true);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if (allInOne.f260789pa == 0) {
            ReportController.o(null, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
        }
    }

    public static String o(int i3) {
        switch (i3) {
            case 1:
            case 4:
                return "mvip.gongneng.mobileqq.mingpian.open.android";
            case 2:
            case 5:
                return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
            case 3:
            case 6:
                return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
            default:
                return null;
        }
    }

    public static void o0(Activity activity, String str, String str2, int i3, String str3) {
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(str);
            Card I = I(qQAppInterface, str2);
            AllInOne allInOne = new AllInOne(str2, 9);
            allInOne.nickname = com.tencent.mobileqq.utils.ac.F(qQAppInterface, str2);
            allInOne.preWinUin = str2;
            allInOne.preWinType = i3;
            allInOne.lastActivity = 2;
            allInOne.profileEntryType = 123;
            ProfileCardInfo profileCardInfo = new ProfileCardInfo();
            profileCardInfo.card = I;
            profileCardInfo.allInOne = allInOne;
            BusinessCard a16 = BusinessCardUtils.a(qQAppInterface, profileCardInfo);
            if (a16.mobilesNum.size() >= 3) {
                QQToast.makeText(activity, 0, R.string.f171167i31, 0).show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("add_phone_num", str3);
            n0(activity, a16, allInOne, false, bundle);
        } catch (AccountNotMatchException e16) {
            QLog.e("openBusinessCardToAddingPhone", 1, e16, new Object[0]);
        }
    }

    public static int p(AllInOne allInOne) {
        if (allInOne == null) {
            return 1001;
        }
        if (!ProfilePAUtils.isPaTypeFriend(allInOne)) {
            int i3 = allInOne.f260789pa;
            if (i3 != 22 && i3 != 21) {
                if (i3 == 41 || i3 == 42) {
                    return 1001;
                }
                if (i3 == 86) {
                    return 10002;
                }
                if (i3 == 94) {
                    return 10004;
                }
                if (i3 == 3 || i3 == 2) {
                    return 1005;
                }
                if (i3 == 74) {
                    return 1023;
                }
                if (i3 != 32 && i3 != 31 && i3 != 51 && i3 != 50 && i3 != 34 && i3 != 53) {
                    if (i3 != 46 && i3 != 47) {
                        if (i3 != 56 && i3 != 57) {
                            if (i3 == 58) {
                                return 1020;
                            }
                            if (i3 != 71 && i3 != 72) {
                                if (i3 != 70) {
                                    if (i3 != 27 && i3 != 25) {
                                        if (i3 != 75 && i3 != 76) {
                                            if (i3 == 80) {
                                                return 25;
                                            }
                                            if (i3 == 115) {
                                                return 10008;
                                            }
                                            if (i3 == 117) {
                                                return 10010;
                                            }
                                            if (i3 != 125) {
                                                return 1001;
                                            }
                                            return 1024;
                                        }
                                        return 1010;
                                    }
                                    return 1022;
                                }
                            } else {
                                return 1021;
                            }
                        } else {
                            return 1009;
                        }
                    } else {
                        return 1004;
                    }
                } else {
                    return 1006;
                }
            } else {
                return 1000;
            }
        }
        return 0;
    }

    public static void p0(ProfileCardInfo profileCardInfo, QQAppInterface qQAppInterface, Activity activity) {
        if (profileCardInfo != null && qQAppInterface != null && activity != null) {
            String t16 = t(qQAppInterface, activity, profileCardInfo);
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardUtil", 2, String.format("openDetails url=%s", t16));
            }
            if (!TextUtils.isEmpty(t16)) {
                Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", t16);
                intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
                intent.putExtra(QQBrowserActivity.BROADCAST_ACTION_KEY, IProfileCardConst.ACTION_MODIFY_DETAIL_INFO);
                intent.putExtra("reqType", 1);
                intent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
                activity.startActivity(intent);
            }
        }
    }

    public static int q(Activity activity) {
        return (s(activity) * 3) / 4;
    }

    public static Intent q0(Intent intent, String str, AppInterface appInterface, AllInOne allInOne, BusinessCard businessCard) {
        if (intent != null && !TextUtils.isEmpty(str) && appInterface != null) {
            String format = String.format(IProfileCardConst.PROFILE_DETAIL_URL, str, String.valueOf(appInterface.getAppid()), "android-" + AppSetting.f99551k);
            if (QLog.isColorLevel()) {
                QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "openDetails() url = " + format);
            }
            Intent intent2 = new Intent(intent);
            intent2.putExtra("url", format);
            intent2.putExtra("uin", appInterface.getCurrentAccountUin());
            intent2.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            intent2.putExtra("BusinessCard", businessCard);
            return intent2;
        }
        return intent;
    }

    public static String r() {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb5 = new StringBuilder(AppConstants.PROFILE_CARD_BACKGROUND_DIR);
        sb5.append("IMG");
        sb5.append(calendar.get(1));
        int i3 = calendar.get(2) + 1;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = Integer.valueOf(i3);
        }
        sb5.append(valueOf);
        int i16 = calendar.get(5);
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = Integer.valueOf(i16);
        }
        sb5.append(valueOf2);
        int i17 = calendar.get(11);
        if (i17 < 10) {
            valueOf3 = "0" + i17;
        } else {
            valueOf3 = Integer.valueOf(i17);
        }
        sb5.append(valueOf3);
        int i18 = calendar.get(12);
        if (i18 < 10) {
            valueOf4 = "0" + i18;
        } else {
            valueOf4 = Integer.valueOf(i18);
        }
        sb5.append(valueOf4);
        int i19 = calendar.get(13);
        if (i19 < 10) {
            valueOf5 = "0" + i19;
        } else {
            valueOf5 = Integer.valueOf(i19);
        }
        sb5.append(valueOf5);
        if (!new File(sb5.toString() + ".jpg").exists()) {
            return sb5.toString() + ".jpg";
        }
        StringBuilder sb6 = new StringBuilder(sb5);
        int length = sb5.length();
        for (int i26 = 1; i26 < Integer.MAX_VALUE; i26++) {
            sb6.append('(');
            sb6.append(i26);
            sb6.append(')');
            sb6.append(".jpg");
            if (!new File(sb6.toString()).exists()) {
                break;
            }
            sb6.delete(length, sb6.length());
        }
        return sb6.toString();
    }

    public static com.tencent.mobileqq.vas.k r0(String str) {
        if (str != null && !str.equals("")) {
            if (QLog.isColorLevel()) {
                QLog.e("ProfileCardUtil", 2, "do parse ProfileCardBgInfo");
            }
            com.tencent.mobileqq.vas.k kVar = new com.tencent.mobileqq.vas.k();
            try {
                JSONObject jSONObject = new JSONObject(str);
                kVar.f309620h = jSONObject.getInt("frameInterval");
                kVar.f309619g = jSONObject.getInt("frameNumber");
                kVar.f309615c = (float) jSONObject.getDouble("positionX");
                kVar.f309616d = (float) jSONObject.getDouble("positionY");
                kVar.f309617e = (float) jSONObject.getDouble("width");
                kVar.f309618f = (float) jSONObject.getDouble("height");
                return kVar;
            } catch (JSONException e16) {
                QLog.e("ProfileCardUtil", 2, "parse, exception=" + MsfSdkUtils.getStackTraceString(e16));
                return null;
            }
        }
        return null;
    }

    public static int s(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static final void s0(String str, int i3, String str2) {
        StringBuilder sb5 = f306412b;
        if (sb5 == null) {
            f306412b = new StringBuilder(120);
        } else {
            sb5.setLength(0);
        }
        StringBuilder sb6 = f306412b;
        sb6.append(str);
        sb6.append(", reason = [");
        sb6.append(str2);
        sb6.append("], code = [");
        sb6.append(i3);
        sb6.append("]");
        QLog.i("UPLOAD_AVATAR_FAIL", 1, f306412b.toString());
    }

    public static String t(QQAppInterface qQAppInterface, Activity activity, ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        if (qQAppInterface != null && activity != null && profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null && !TextUtils.isEmpty(allInOne.uin)) {
            String str = profileCardInfo.allInOne.uin;
            QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
            if (qidianManager.L(str)) {
                return String.format("https://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", str, Integer.valueOf(qQAppInterface.getAppid()), "android-" + AppSetting.f99551k);
            }
            if (qidianManager.R(str)) {
                return activity.getIntent().getStringExtra("key_qidian_detail_url");
            }
            return ProfileCardUtils.getProfileDetailUrl(qQAppInterface, profileCardInfo);
        }
        return null;
    }

    public static Bitmap t0(String str, int i3, float f16) {
        BufferedInputStream bufferedInputStream;
        File file = new File(str);
        BufferedInputStream bufferedInputStream2 = null;
        if (file.exists() && file.length() > 0 && !file.isDirectory()) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    if (decodeStream == null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused) {
                        }
                        return null;
                    }
                    int width = decodeStream.getWidth();
                    int height = decodeStream.getHeight();
                    if (width > i3) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(i3 / width, ((int) (r11 / f16)) / height);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, width, height, matrix, true);
                        decodeStream.recycle();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused2) {
                        }
                        return createBitmap;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused3) {
                    }
                    return decodeStream;
                } catch (Exception unused4) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return null;
                } catch (OutOfMemoryError unused6) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused9) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused10) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return null;
    }

    public static String u(String str) {
        return ProfileCardTemplateUtil.d() + z0(str);
    }

    public static void u0(Card card, QQAppInterface qQAppInterface) {
        if (card != null && qQAppInterface != null) {
            qQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).edit().putBoolean("new_school_guide_init_" + card.uin, false).commit();
        }
    }

    public static FriendProfileCardBgDrawable v(Resources resources, String str, String str2) {
        com.tencent.mobileqq.vas.k kVar;
        if (!str.equals("")) {
            kVar = r0(FileUtils.readFileToStringEx(new File(str, "config.json"), -1));
            if (kVar != null) {
                String[] strArr = new String[kVar.f309619g];
                int i3 = 0;
                while (i3 < kVar.f309619g) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append("/");
                    int i16 = i3 + 1;
                    sb5.append(i16);
                    sb5.append(".png");
                    strArr[i3] = sb5.toString();
                    i3 = i16;
                }
                kVar.f309614b = strArr;
            }
        } else {
            kVar = null;
        }
        if (kVar == null) {
            kVar = new com.tencent.mobileqq.vas.k();
        }
        kVar.f309613a = str2;
        return new FriendProfileCardBgDrawable(resources, kVar);
    }

    public static void v0(QQAppInterface qQAppInterface, long j3, long j16, String str, long j17, String str2) {
        w0(qQAppInterface, j3, j16, str, j17, str2, 0, null, null, 0.0f, 0.0f, 0.0f, "", 0L);
    }

    public static String w(AllInOne allInOne) {
        ArrayList<ProfileContactInfo> arrayList;
        String str = "";
        if (allInOne == null || (arrayList = allInOne.contactArray) == null || arrayList.size() <= 0) {
            return "";
        }
        ProfileContactInfo profileContactInfo = allInOne.contactArray.get(0);
        if (profileContactInfo != null) {
            str = profileContactInfo.phoneNationalCode + profileContactInfo.phoneNumber;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(allInOne.uin)) {
            return allInOne.uin;
        }
        return str;
    }

    public static void w0(final QQAppInterface qQAppInterface, final long j3, final long j16, final String str, final long j17, final String str2, final int i3, final String str3, final String str4, final float f16, final float f17, final float f18, final String str5, final long j18) {
        qQAppInterface.execute(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.4
            @Override // java.lang.Runnable
            public void run() {
                cardDiyTextInfo carddiytextinfo;
                if (i3 > 0 && !TextUtils.isEmpty(str3)) {
                    carddiytextinfo = new cardDiyTextInfo(i3, str3, str4, f16, f17, f18);
                } else {
                    carddiytextinfo = null;
                }
                SSummaryCardSetReq sSummaryCardSetReq = new SSummaryCardSetReq(2, Long.parseLong(qQAppInterface.getCurrentAccountUin()), j18, AppSetting.f99551k, 109L, j3, j16, str, j17, carddiytextinfo, str2, new cardDiyComplicatedInfo(str5));
                UniPacket uniPacket = new UniPacket(true);
                uniPacket.setEncodeName("utf-8");
                uniPacket.setFuncName("set");
                uniPacket.setServantName("MCardSvc");
                uniPacket.put("req", sSummaryCardSetReq);
                ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).c5(qQAppInterface.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), uniPacket.encode());
            }
        });
    }

    public static int x(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) (((Math.min(r0.widthPixels, r0.heightPixels) - 10) * 0.8f) + 0.5f);
    }

    public static void x0(QQAppInterface qQAppInterface, long j3, long j16, String str, long j17, String str2, String str3, long j18) {
        w0(qQAppInterface, j3, j16, str, j17, str2, 0, null, null, 0.0f, 0.0f, 0.0f, str3, j18);
    }

    public static long y() {
        try {
            if (Utils.B()) {
                return Utils.A(new File(AppConstants.SDCARD_ROOT));
            }
            return Utils.A(new File(Environment.getRootDirectory().getPath()));
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static void y0(final String str, final Intent intent, final c cVar) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0175  */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v8, types: [byte, boolean] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                final String str2;
                boolean z16;
                int i3;
                final ?? r26;
                final boolean z17;
                AppRuntime peekAppRuntime;
                CompressInfo compressInfo = new CompressInfo(str, 0);
                compressInfo.K = 0;
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                Intent intent2 = intent;
                if (intent2 != null) {
                    intent2.getBooleanExtra(FaceConstant.HeadParams.PARAM_ZPLAN_AVATAR, false);
                }
                Intent intent3 = intent;
                HashMap hashMap = null;
                if (intent3 != null) {
                    boolean booleanExtra = intent3.getBooleanExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, false);
                    str2 = intent.getStringExtra("PhotoConst.SOURCE_FROM");
                    Serializable serializableExtra = intent.getSerializableExtra("PhotoConst.EXT_INFO");
                    if (serializableExtra instanceof HashMap) {
                        hashMap = (HashMap) serializableExtra;
                    }
                    if ("FROM_SELECT_PHOTO".equals(str2)) {
                        i3 = 1;
                        r26 = booleanExtra;
                    } else {
                        z16 = booleanExtra;
                        if ("FROM_TAKE_PHOTO".equals(str2)) {
                            i3 = 2;
                            r26 = booleanExtra;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_UPLOAD_LOCAL_PHOTO, 2, ".uploadPhoto(), img_path = " + compressInfo.H + ",isSyncQZone=" + ((boolean) r26));
                    }
                    if (StringUtil.isEmpty(compressInfo.H)) {
                        TransferRequest transferRequest = new TransferRequest();
                        transferRequest.mIsUp = true;
                        transferRequest.mLocalPath = compressInfo.H;
                        transferRequest.mFileType = 22;
                        pu.a aVar = new pu.a();
                        aVar.c(r26);
                        if (hashMap != null) {
                            QLog.i("ProfileCardUtil", 1, "upload avatar extInfoMap = " + hashMap.toString());
                            try {
                                aVar.c((byte) 0);
                                aVar.c((byte) 0);
                                aVar.c((byte) 0);
                                aVar.c((byte) 0);
                                aVar.c((byte) 0);
                                JSONObject jSONObject = new JSONObject(hashMap);
                                String jSONObject2 = jSONObject.toString();
                                if (!jSONObject.optString(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE).equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_AI_AVATAR)) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                try {
                                    byte[] bytes = jSONObject2.getBytes();
                                    if (bytes != null && bytes.length >= 1 && bytes.length <= 500) {
                                        int length = bytes.length;
                                        QLog.i("ProfileCardUtil", 2, "requestUploadAvatar extInfoJson[" + length + "] json: " + jSONObject);
                                        aVar.c((byte) ((length >> 8) & 255));
                                        aVar.c((byte) (length & 255));
                                        for (byte b16 : bytes) {
                                            aVar.c(b16);
                                        }
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e("ProfileCardUtil", 2, "error in write ext info", e);
                                    transferRequest.mExtentionInfo = aVar.a();
                                    transferRequest.mUpCallBack = new com.tencent.mobileqq.pic.ad() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.1.1
                                        @Override // com.tencent.mobileqq.pic.ad
                                        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
                                            return null;
                                        }

                                        @Override // com.tencent.mobileqq.pic.ad
                                        public void q(ad.a aVar2) {
                                            boolean z18;
                                            CardHandler cardHandler;
                                            AvatarHistoryNumProcessor avatarHistoryNumProcessor;
                                            String str3;
                                            boolean z19;
                                            int i16;
                                            int i17 = 0;
                                            if (QLog.isColorLevel()) {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append(" onSend result is null ? ");
                                                if (aVar2 == null) {
                                                    z19 = true;
                                                } else {
                                                    z19 = false;
                                                }
                                                sb5.append(z19);
                                                sb5.append(" result is: ");
                                                if (aVar2 == null) {
                                                    i16 = -99;
                                                } else {
                                                    i16 = aVar2.f258597a;
                                                }
                                                sb5.append(i16);
                                                QLog.i(NearbyPeoplePhotoUploadProcessor.TAG, 2, sb5.toString());
                                            }
                                            if (aVar2 == null) {
                                                return;
                                            }
                                            if (aVar2.f258597a == 0) {
                                                z18 = true;
                                            } else {
                                                z18 = false;
                                            }
                                            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                                            if (peekAppRuntime2 instanceof QQAppInterface) {
                                                cardHandler = (CardHandler) ((QQAppInterface) peekAppRuntime2).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                                            } else {
                                                cardHandler = null;
                                            }
                                            if (cardHandler != null) {
                                                cardHandler.z5(z18, peekAppRuntime2.getCurrentAccountUin(), aVar2.f258598b);
                                            } else {
                                                FaceUtil.setTempAvatarFilePath(null);
                                            }
                                            if (!z18) {
                                                ProfileCardUtil.s0("TransferRequest.onSend", aVar2.f258598b, aVar2.toString());
                                                c cVar2 = cVar;
                                                if (cVar2 != null) {
                                                    cVar2.onResult(false);
                                                }
                                            } else {
                                                if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(peekAppRuntime2.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != 1) {
                                                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(peekAppRuntime2.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
                                                }
                                                if (r26 && z17) {
                                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.1.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            QQToast.makeText(BaseApplicationImpl.getApplication().getBaseContext(), 2, R.string.go_, 0).show();
                                                        }
                                                    });
                                                }
                                                if (ea.h0(peekAppRuntime2.getApp(), peekAppRuntime2.getCurrentAccountUin()) != 2 && (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, peekAppRuntime2)) != null) {
                                                    avatarHistoryNumProcessor.a();
                                                }
                                            }
                                            if ("FROM_MINI_APP".equals(str2)) {
                                                if (!z18) {
                                                    i17 = -10002;
                                                }
                                                if (z18) {
                                                    str3 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                                                } else {
                                                    str3 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED;
                                                }
                                                intent.putExtra(FaceConstant.HeadParams.PARAM_RESULT_CODE, i17);
                                                intent.putExtra(FaceConstant.HeadParams.PARAM_RESULT_DESC, str3);
                                                com.tencent.mobileqq.app.g.b().c(intent);
                                            }
                                        }

                                        @Override // com.tencent.mobileqq.pic.ad
                                        public void r(ad.a aVar2) {
                                        }
                                    };
                                    peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                    if (peekAppRuntime instanceof QQAppInterface) {
                                    }
                                    if (r26 != 0) {
                                    }
                                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X8007C17", "0X8007C17", i3, 0, "", "", "", "");
                                    return;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                z17 = true;
                            }
                        } else {
                            QLog.i("ProfileCardUtil", 1, "upload avatar extInfoMap is null");
                            z17 = true;
                        }
                        transferRequest.mExtentionInfo = aVar.a();
                        transferRequest.mUpCallBack = new com.tencent.mobileqq.pic.ad() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.1.1
                            @Override // com.tencent.mobileqq.pic.ad
                            public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
                                return null;
                            }

                            @Override // com.tencent.mobileqq.pic.ad
                            public void q(ad.a aVar2) {
                                boolean z18;
                                CardHandler cardHandler;
                                AvatarHistoryNumProcessor avatarHistoryNumProcessor;
                                String str3;
                                boolean z19;
                                int i16;
                                int i17 = 0;
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(" onSend result is null ? ");
                                    if (aVar2 == null) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    sb5.append(z19);
                                    sb5.append(" result is: ");
                                    if (aVar2 == null) {
                                        i16 = -99;
                                    } else {
                                        i16 = aVar2.f258597a;
                                    }
                                    sb5.append(i16);
                                    QLog.i(NearbyPeoplePhotoUploadProcessor.TAG, 2, sb5.toString());
                                }
                                if (aVar2 == null) {
                                    return;
                                }
                                if (aVar2.f258597a == 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime2 instanceof QQAppInterface) {
                                    cardHandler = (CardHandler) ((QQAppInterface) peekAppRuntime2).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                                } else {
                                    cardHandler = null;
                                }
                                if (cardHandler != null) {
                                    cardHandler.z5(z18, peekAppRuntime2.getCurrentAccountUin(), aVar2.f258598b);
                                } else {
                                    FaceUtil.setTempAvatarFilePath(null);
                                }
                                if (!z18) {
                                    ProfileCardUtil.s0("TransferRequest.onSend", aVar2.f258598b, aVar2.toString());
                                    c cVar2 = cVar;
                                    if (cVar2 != null) {
                                        cVar2.onResult(false);
                                    }
                                } else {
                                    if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(peekAppRuntime2.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != 1) {
                                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(peekAppRuntime2.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
                                    }
                                    if (r26 && z17) {
                                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardUtil.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                QQToast.makeText(BaseApplicationImpl.getApplication().getBaseContext(), 2, R.string.go_, 0).show();
                                            }
                                        });
                                    }
                                    if (ea.h0(peekAppRuntime2.getApp(), peekAppRuntime2.getCurrentAccountUin()) != 2 && (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, peekAppRuntime2)) != null) {
                                        avatarHistoryNumProcessor.a();
                                    }
                                }
                                if ("FROM_MINI_APP".equals(str2)) {
                                    if (!z18) {
                                        i17 = -10002;
                                    }
                                    if (z18) {
                                        str3 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                                    } else {
                                        str3 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED;
                                    }
                                    intent.putExtra(FaceConstant.HeadParams.PARAM_RESULT_CODE, i17);
                                    intent.putExtra(FaceConstant.HeadParams.PARAM_RESULT_DESC, str3);
                                    com.tencent.mobileqq.app.g.b().c(intent);
                                }
                            }

                            @Override // com.tencent.mobileqq.pic.ad
                            public void r(ad.a aVar2) {
                            }
                        };
                        peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime instanceof QQAppInterface) {
                            ((ITransFileController) ((QQAppInterface) peekAppRuntime).getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
                        }
                        if (r26 != 0) {
                            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X8007C16", "0X8007C16", intent.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1), 0, "", "", "", "");
                        }
                        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X8007C17", "0X8007C17", i3, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                str2 = "";
                z16 = false;
                i3 = 3;
                r26 = z16;
                if (QLog.isColorLevel()) {
                }
                if (StringUtil.isEmpty(compressInfo.H)) {
                }
            }
        }, null, true);
    }

    @NotNull
    public static BusinessInfoCheckUpdate.RedTypeInfo z() {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo.red_type.set(-1);
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(-4);
        RedTouchItem j16 = localRedTouchManager.j(10029);
        RedTouchItem j17 = localRedTouchManager.j(10031);
        RedTouchItem j18 = localRedTouchManager.j(10032);
        RedTouchItem j19 = localRedTouchManager.j(10030);
        if (b(j3) || b(j16) || b(j18) || b(j19) || b(j17)) {
            QLog.d("ProfileCardUtil", 1, "getProfileMsgListRedTouch");
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
        }
        return redTypeInfo;
    }

    public static String z0(String str) {
        if (str == null) {
            return "";
        }
        return MD5.toMD5(str);
    }
}
