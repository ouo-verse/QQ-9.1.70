package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import st1.h;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$RspBody;
import tencent.im.oidb.oidb_0xd55$RspBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ForwardUtils extends BaseForwardUtil {
    public static boolean A(Intent intent, final SessionInfo sessionInfo, final String str, QQAppInterface qQAppInterface) {
        boolean z16;
        boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.EXTRA_IS_EDITED_PIC, false);
        boolean booleanExtra2 = intent.getBooleanExtra(AppConstants.Key.FORWARD_SEND_SELFIE_FACE, false);
        boolean booleanExtra3 = intent.getBooleanExtra(ShortVideoConstants.KEY_STORY_PIC_TO_RECENT, false);
        if (!booleanExtra && !booleanExtra2 && !booleanExtra3) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            intent.putExtra("uin", sessionInfo.f179557e);
            intent.putExtra("uintype", sessionInfo.f179555d);
            intent.putExtra("troop_uin", sessionInfo.f179559f);
            intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
            intent.putExtra(PeakConstants.PHOTO_SEND_PATH, str);
            int forwardSrcBusinessType = ForwardBaseOption.getForwardSrcBusinessType(intent.getExtras());
            int i3 = 1051;
            if (forwardSrcBusinessType != 100200) {
                if (forwardSrcBusinessType != 100100 && forwardSrcBusinessType != 100101 && forwardSrcBusinessType != 100300 && !ForwardBaseOption.isTempAIO(intent.getExtras()) && intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1) != 1041) {
                    if (!booleanExtra3) {
                        i3 = 1007;
                    }
                } else {
                    i3 = 1048;
                }
            }
            com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, i3);
            createPicReq.f(((IPicBus) QRoute.api(IPicBus.class)).createPicUploadInfo(i3, intent));
            createPicReq.I = intent.getIntExtra("KEY_MSG_FORWARD_ID", 0);
            if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_SELFIE_FACE, false)) {
                PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
                picMessageExtraData.imageBizType = 8;
                String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
                if (!TextUtils.isEmpty(stringExtra)) {
                    picMessageExtraData.textSummary = stringExtra;
                }
                createPicReq.E = picMessageExtraData;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.forward.utils.f.f211079a.l(SessionInfo.this, str);
                }
            });
        }
        return z16;
    }

    private static void B(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, SessionInfo sessionInfo, String str, int i3) {
        try {
            ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
            boolean booleanExtra = intent.getBooleanExtra("foward_editbar", false);
            if (!booleanExtra) {
                try {
                    if (intent.getExtras().getBoolean("sendMultiple", false)) {
                        String stringExtra = intent.getStringExtra("uin");
                        intent.getStringExtra("troop_uin");
                        int intExtra = intent.getIntExtra("uintype", -1);
                        ArrayList arrayList = (ArrayList) intent.getExtras().get("android.intent.extra.STREAM");
                        if (arrayList == null) {
                            return;
                        }
                        if (FileManagerUtil.is2GOr3G()) {
                            FMDialogUtil.a(activity, R.string.b_v, R.string.f170958ba0, new a(arrayList, activity, intExtra, qQAppInterface, stringExtra, i3, sessionInfo));
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String pathFromUri = new UriParserPathHelper(activity, false, null).getPathFromUri((Uri) it.next());
                            if (TextUtils.isEmpty(pathFromUri)) {
                                QLog.e("ForwardUtils<FileAssistant>", 1, "mutilSend but localpath is null!");
                            } else if (intExtra == 1) {
                                qQAppInterface.getFileManagerEngine().J0(pathFromUri, stringExtra, 0L, i3);
                            } else {
                                qQAppInterface.getNTFileManageBridger().p0(pathFromUri, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, 0L, i3);
                            }
                        }
                        return;
                    }
                } catch (Exception e16) {
                    QLog.e(ForwardBaseOption.TAG, 1, e16, new Object[0]);
                }
            }
            if (!booleanExtra) {
                if (forwardFileInfo != null) {
                    forwardFileInfo.L = i3;
                }
                ChatActivityFacade.R(qQAppInterface, activity, sessionInfo, intent, str, forwardFileInfo, false, i3);
                String stringExtra2 = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
                boolean booleanExtra2 = intent.getBooleanExtra("isFromShare", false);
                if (!intent.getBooleanExtra("is_from_file", false) && !booleanExtra2 && !TextUtils.isEmpty(stringExtra2)) {
                    com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra2);
                    return;
                }
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("fileinfo_array");
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                Iterator it5 = parcelableArrayListExtra.iterator();
                while (it5.hasNext()) {
                    ForwardFileInfo forwardFileInfo2 = (ForwardFileInfo) it5.next();
                    if (forwardFileInfo2.c() == 3) {
                        forwardFileInfo2.g();
                    }
                }
                Iterator it6 = parcelableArrayListExtra.iterator();
                while (it6.hasNext()) {
                    ForwardFileInfo forwardFileInfo3 = (ForwardFileInfo) it6.next();
                    ChatActivityFacade.R(qQAppInterface, activity, sessionInfo, intent, forwardFileInfo3.l(), forwardFileInfo3, true, i3);
                }
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "FORWARD_TYPE.FILE failed. " + e17, e17);
            }
        }
    }

    private static boolean C(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, SessionInfo sessionInfo, String str, int i3) {
        if (N(sessionInfo.f179557e)) {
            QQToast.makeText(qQAppInterface.getApp(), R.string.f1787837l, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return false;
        }
        B(qQAppInterface, activity, context, intent, sessionInfo, str, i3);
        intent.removeExtra(AEEditorConstants.EXTRA_IS_EDITED_PIC);
        intent.removeExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC);
        intent.removeExtra("key_allow_multiple_forward_from_limit");
        intent.removeExtra(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT);
        return true;
    }

    private static void D(QQAppInterface qQAppInterface, Context context, Intent intent, SessionInfo sessionInfo) {
        if (intent.getBooleanExtra("isFromFavorites", false)) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(AppConstants.Key.FORWARD_LATITUDE);
                String string2 = extras.getString(AppConstants.Key.FORWARD_LONGITUDE);
                String string3 = extras.getString(AppConstants.Key.FORWARD_LOCATION);
                String string4 = extras.getString("title");
                String string5 = extras.getString("summary");
                extras.putInt("isArk", 1);
                ChatActivityFacade.S(context, qQAppInterface, sessionInfo, string, string2, string3, string4, string5, "", "", "", "", extras);
                return;
            }
            return;
        }
        ChatActivityFacade.T(qQAppInterface, sessionInfo, intent.getStringExtra(AppConstants.Key.FORWARD_LATITUDE), intent.getStringExtra(AppConstants.Key.FORWARD_LONGITUDE), intent.getStringExtra(AppConstants.Key.FORWARD_LOCATION));
    }

    private static void E(QQAppInterface qQAppInterface, Activity activity, Intent intent, SessionInfo sessionInfo, int i3) {
        IPicEmoticonInfo iPicEmoticonInfo;
        if (2 == MarketFaceItemBuilder.f179358a) {
            ReportController.o(qQAppInterface, "CliOper", "", activity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        } else {
            ReportController.o(qQAppInterface, "CliOper", "", activity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, false)) {
            iPicEmoticonInfo = AIOEmotionFragment.O0;
        } else {
            iPicEmoticonInfo = MarketFaceItemBuilder.f179359b;
        }
        IPicEmoticonInfo iPicEmoticonInfo2 = iPicEmoticonInfo;
        com.tencent.biz.anonymous.a.h().f78364c = true;
        if (iPicEmoticonInfo2 != null) {
            iPicEmoticonInfo2.send(qQAppInterface, activity, null, sessionInfo, true, i3);
        }
    }

    private static void F(QQAppInterface qQAppInterface, Activity activity, Intent intent, MqqHandler mqqHandler, SessionInfo sessionInfo, String str, int i3) {
        boolean booleanExtra = intent.getBooleanExtra("isFromShare", false);
        e0("forward", "handleForwardData() photograph isFromShare" + booleanExtra);
        if (booleanExtra) {
            H(qQAppInterface, activity, intent, mqqHandler, sessionInfo, str, i3);
            return;
        }
        if (A(intent, sessionInfo, str, qQAppInterface)) {
            e0("ForwardUtils", "handleForwardEditedPhoto = " + str);
            return;
        }
        u(qQAppInterface, intent, sessionInfo, str, i3);
    }

    private static void G(QQAppInterface qQAppInterface, MqqHandler mqqHandler, SessionInfo sessionInfo, String str) {
        if (ChatActivityFacade.U(qQAppInterface, sessionInfo, str) != -1) {
            Message message = new Message();
            message.what = 59;
            if (mqqHandler != null) {
                mqqHandler.sendMessage(message);
            }
        }
    }

    static void H(QQAppInterface qQAppInterface, Activity activity, Intent intent, final MqqHandler mqqHandler, final SessionInfo sessionInfo, final String str, int i3) {
        if (intent.getBooleanExtra("sendMultiple", false)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_EDITED, false);
        e0("forward", "handleForwardData() photograph isEdited" + booleanExtra);
        if (booleanExtra) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("KEY_JUMP_FORWARD_TIME", currentTimeMillis);
        if (currentTimeMillis - longExtra > 60000) {
            QLog.i("ForwardUtils", 1, String.format("filter invalid jump forward photo, currentTimeStamp:%d jumpForwardTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(longExtra)));
            return;
        }
        QLog.i("ForwardUtils", 1, String.format("valid jump forward photo, currentTimeStamp:%d jumpForwardTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(longExtra)));
        intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_TASK_KEY);
        intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN);
        intent.getIntExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, -1);
        intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH);
        intent.getLongExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, 0L);
        Message message = new Message();
        message.what = 58;
        if (mqqHandler != null) {
            mqqHandler.sendMessage(message);
        }
        e0("ForwardUtils", "[@]call sendPic start!");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.4
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.forward.utils.f.f211079a.l(SessionInfo.this, str);
                ForwardUtils.e0("ForwardUtils", "[@]call instantUpdate start!");
                Message message2 = new Message();
                message2.what = 59;
                MqqHandler mqqHandler2 = mqqHandler;
                if (mqqHandler2 != null) {
                    mqqHandler2.sendMessage(message2);
                }
                ForwardUtils.e0("ForwardUtils", "[@]call instantUpdate end!");
            }
        }, 8, null, false);
        e0("ForwardUtils", "[@]call sendPic end!");
    }

    private static void I(QQAppInterface qQAppInterface, Intent intent, int i3) {
        int i16 = 0;
        int intExtra = intent.getIntExtra(ShortVideoConstants.FROM_BUSI_TYPE, 0);
        if (intExtra == 1) {
            i16 = 2;
        } else if (intExtra == 2) {
            i16 = 3;
        }
        com.tencent.mobileqq.shortvideo.v b16 = com.tencent.mobileqq.shortvideo.h.b(3, i16);
        com.tencent.mobileqq.shortvideo.p a16 = com.tencent.mobileqq.shortvideo.l.a(i16, intent, b16);
        if (a16 != null) {
            a16.I = i3;
        }
        b16.d(a16);
        if (a16 != null) {
            com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar.r(fVar.c(a16.f288041d, a16.f288043f, a16.f288044g), a16.f288204r);
        }
    }

    private static void J(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, MqqHandler mqqHandler, SessionInfo sessionInfo, int i3) {
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_TEXT);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.tencent.biz.anonymous.a.h().f78364c = true;
        }
        new ChatActivityFacade.d().f175158v = true;
        boolean[] booleanArrayExtra = intent.getBooleanArrayExtra(AppConstants.Key.FORWARD_IS_WRITE_TOGETHER);
        String stringExtra2 = intent.getStringExtra("uin");
        boolean[] booleanArrayExtra2 = intent.getBooleanArrayExtra(AppConstants.Key.FORWARD_WRITE_TOGETHER_IS_EXPIRED);
        if (booleanArrayExtra != null && booleanArrayExtra[0] && sessionInfo.f179555d == 1 && stringExtra2.equals(sessionInfo.f179557e) && booleanArrayExtra2 != null && !booleanArrayExtra2[0]) {
            return;
        }
        com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra);
        Message message = new Message();
        message.what = 57;
        message.obj = stringExtra;
        if (mqqHandler != null) {
            mqqHandler.sendMessage(message);
        }
    }

    public static boolean K(SessionInfo sessionInfo, int i3, Intent intent) {
        if (sessionInfo.f179555d == 10014) {
            int i16 = 1;
            if (i3 != -1) {
                if (i3 != 1) {
                    i16 = 3;
                    if (i3 != 3 && i3 != 21) {
                        i16 = -1;
                    }
                } else {
                    i16 = 2;
                }
            }
            return ((IGuildForwardUtilsApi) QRoute.api(IGuildForwardUtilsApi.class)).forwardToGuild(intent, i16);
        }
        return false;
    }

    private static void L(QQAppInterface qQAppInterface, final Intent intent, int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.2
            @Override // java.lang.Runnable
            public void run() {
                String stringExtra = intent.getStringExtra("uin");
                String stringExtra2 = intent.getStringExtra("troop_uin");
                int intExtra = intent.getIntExtra("uintype", -2);
                String stringExtra3 = intent.getStringExtra("file_send_path");
                com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
                fVar.r(fVar.c(intExtra, stringExtra, stringExtra2), stringExtra3);
            }
        }, 128, null, true);
    }

    public static boolean M(int i3, int i16) {
        for (int i17 : BaseForwardUtil.f178060a) {
            if (i3 == i17 && (i16 == 1 || i16 == 2 || i16 == 2147483646 || i16 == 6 || i16 == 147)) {
                return true;
            }
        }
        return false;
    }

    private static boolean N(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("ForwardUtils", 1, "isForwardDataInvalid fail. " + str);
            return true;
        }
        return false;
    }

    public static boolean O(AbsStructMsg absStructMsg) {
        if ((absStructMsg instanceof StructMsgForImageShare) && !com.tencent.mobileqq.forward.x.l()) {
            return true;
        }
        return false;
    }

    public static boolean P(ad.a aVar) {
        String[] strArr;
        if (aVar.f258597a != 0 || (strArr = (String[]) aVar.f258608l) == null || strArr.length != 2) {
            return false;
        }
        return true;
    }

    public static void Q(Activity activity, Intent intent, Bundle bundle) {
        intent.putExtra("k_from_login", true);
        intent.putExtra("sdk_mult_share", true);
        BaseAIOUtils.m(intent, new int[]{2});
        intent.putExtra("open_chatfragment", false);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        l(activity);
    }

    public static void R(Activity activity, Bundle bundle) {
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra("sdk_mult_share_for_local", true);
        Q(activity, aliasIntent, bundle);
    }

    public static void S(Activity activity, Bundle bundle, String str) {
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra("sdk_mult_share_result_code", 3);
        aliasIntent.putExtra("sdk_mult_share_error_wording", str);
        Q(activity, aliasIntent, bundle);
    }

    public static boolean T(Intent intent) {
        boolean z16;
        if ((intent.getFlags() & 1048576) != 0 && (intent.getFlags() & 268435456) != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i("SplashActivity", 1, "needFilterInvalidForwardIntent: not new launch");
            return true;
        }
        long j3 = intent.getExtras().getLong("preAct_time", 0L);
        if (System.currentTimeMillis() - j3 <= o()) {
            return false;
        }
        QLog.i("SplashActivity", 1, "needFilterInvalidForwardIntent: no time valid. diff = " + (System.currentTimeMillis() - j3));
        return true;
    }

    private static boolean U(List<oidb_cmd0xdc2$BatchSendRsp> list, String str) {
        if (list == null) {
            return true;
        }
        for (oidb_cmd0xdc2$BatchSendRsp oidb_cmd0xdc2_batchsendrsp : list) {
            if (String.valueOf(oidb_cmd0xdc2_batchsendrsp.recv_uin.get()).equals(str) && oidb_cmd0xdc2_batchsendrsp.err_code.get() != 0) {
                QLog.d("ForwardUtils", 1, "needSendComment uin=", com.tencent.open.agent.util.g.C(str), ", err_code=", Integer.valueOf(oidb_cmd0xdc2_batchsendrsp.err_code.get()));
                return false;
            }
        }
        return true;
    }

    public static void V(QQAppInterface qQAppInterface, Intent intent, Activity activity) {
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, qQAppInterface.getApplication().getString(R.string.hvn));
        Intent intent2 = new Intent();
        intent2.putExtras(new Bundle(intent.getExtras()));
        w(qQAppInterface, activity, activity, intent2, null);
    }

    public static void W(Activity activity, int i3, String str, String str2, String str3, boolean z16, boolean z17) {
        activity.startActivityForResult(k(activity, str, str2, str3, z16, z17), i3);
    }

    public static void X(Fragment fragment, int i3, String str, String str2, String str3, boolean z16, boolean z17) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        fragment.startActivityForResult(k(activity, str, str2, str3, z16, z17), i3);
    }

    public static int Y(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ForwardUtils", 1, "parseInt text isEmpty");
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("ForwardUtils", 1, "parseInt Exception", e16);
            return 0;
        }
    }

    public static long Z(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ForwardUtils", 1, "parseLong text = ", str);
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            QLog.e("ForwardUtils", 1, "parseLong text = ", str);
            return 0L;
        }
    }

    public static oidb_0xd55$RspBody a0(byte[] bArr) {
        if (bArr == null) {
            QLog.e("ForwardUtils", 1, "parseOIDBD55RspBody onError data == null");
            return null;
        }
        oidb_0xd55$RspBody oidb_0xd55_rspbody = new oidb_0xd55$RspBody();
        try {
            oidb_0xd55_rspbody.mergeFrom(bArr);
            return oidb_0xd55_rspbody;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ForwardUtils", 1, "onError msg =", e16);
            return null;
        }
    }

    public static Object[] b0(byte[] bArr) {
        String str;
        String str2 = "";
        String str3 = com.tencent.mobileqq.forward.x.f211080d;
        Object[] objArr = {0, "", str3, ""};
        if (bArr == null) {
            QLog.e("ForwardUtils", 1, "parseOIDBb77RspBody onError data == null");
            return objArr;
        }
        oidb_cmd0xb77$RspBody oidb_cmd0xb77_rspbody = new oidb_cmd0xb77$RspBody();
        try {
            oidb_cmd0xb77_rspbody.mergeFrom(bArr);
            objArr[0] = Integer.valueOf(oidb_cmd0xb77_rspbody.jump_result.get());
            if (!oidb_cmd0xb77_rspbody.jump_url.has()) {
                str = "";
            } else {
                str = oidb_cmd0xb77_rspbody.jump_url.get();
            }
            objArr[1] = str;
            if (oidb_cmd0xb77_rspbody.wording.has()) {
                str3 = oidb_cmd0xb77_rspbody.wording.get();
            }
            objArr[2] = str3;
            if (oidb_cmd0xb77_rspbody.develop_msg.has()) {
                str2 = oidb_cmd0xb77_rspbody.develop_msg.get();
            }
            objArr[3] = str2;
            QLog.d("ForwardUtils", 1, "parseOIDBb77RspBody  jumpResult =", objArr[0], ", jumpUrl = ", objArr[1], ", wording =", objArr[2]);
            return objArr;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ForwardUtils", 1, "onError msg =", e16);
            return objArr;
        }
    }

    public static boolean c() {
        try {
            d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
            if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
                e91.g c16 = arkPlatformConfig.c();
                QLog.d("ForwardUtils", 1, "addBackslashToUrl addBackslashEnable=", Boolean.valueOf(c16.f395977g));
                return c16.f395977g;
            }
        } catch (Exception e16) {
            QLog.e("ForwardUtils", 1, "Exception", e16);
        }
        QLog.d("ForwardUtils", 1, "addBackslashToUrl default true");
        return true;
    }

    public static List<oidb_cmd0xdc2$BatchSendRsp> c0(byte[] bArr) {
        if (bArr == null) {
            QLog.e("ForwardUtils", 1, "parseOIDBdc2RspBody onError data == null");
            return null;
        }
        oidb_cmd0xdc2$RspBody oidb_cmd0xdc2_rspbody = new oidb_cmd0xdc2$RspBody();
        try {
            oidb_cmd0xdc2_rspbody.mergeFrom(bArr);
            return oidb_cmd0xdc2_rspbody.batch_send_rsp.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ForwardUtils", 1, "onError msg =", e16);
            return null;
        }
    }

    private static void d(Intent intent, com.tencent.mobileqq.pic.p pVar) {
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_CUSTOM_FACE, false)) {
            PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
            picMessageExtraData.imageBizType = 1;
            picMessageExtraData.customFaceType = intent.getIntExtra(AppConstants.Key.FORWARD_CUSTOM_FACE_TYPE, 0);
            String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_DIY_PACKAGE_ID);
            picMessageExtraData.emojiPkgId = stringExtra;
            if (stringExtra == null) {
                picMessageExtraData.emojiPkgId = "";
            }
            String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
            if (!TextUtils.isEmpty(stringExtra2)) {
                picMessageExtraData.textSummary = stringExtra2;
            }
            pVar.E = picMessageExtraData;
        }
        if (intent.getBooleanExtra(HotPicData.HOT_PIC_HAS_EXTRA, false)) {
            PicMessageExtraData picMessageExtraData2 = new PicMessageExtraData();
            picMessageExtraData2.imageBizType = 2;
            String stringExtra3 = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
            if (!TextUtils.isEmpty(stringExtra3)) {
                picMessageExtraData2.textSummary = stringExtra3;
            }
            pVar.E = picMessageExtraData2;
        }
        e(intent, pVar);
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_ZHITU, false)) {
            PicMessageExtraData picMessageExtraData3 = new PicMessageExtraData();
            picMessageExtraData3.imageBizType = 4;
            String stringExtra4 = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
            if (!TextUtils.isEmpty(stringExtra4)) {
                picMessageExtraData3.textSummary = stringExtra4;
            }
            pVar.E = picMessageExtraData3;
        }
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_SELFIE_FACE, false)) {
            PicMessageExtraData picMessageExtraData4 = new PicMessageExtraData();
            picMessageExtraData4.imageBizType = 8;
            String stringExtra5 = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
            String stringExtra6 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            if (!TextUtils.isEmpty(stringExtra5)) {
                picMessageExtraData4.textSummary = stringExtra5;
            }
            picMessageExtraData4.mTemplateId = stringExtra6;
            pVar.E = picMessageExtraData4;
        }
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_SEND_TEMPLATE_PIC, false)) {
            String stringExtra7 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            String stringExtra8 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            if (!TextUtils.isEmpty(stringExtra7) || !TextUtils.isEmpty(stringExtra8)) {
                if (pVar.E == null) {
                    pVar.E = new PicMessageExtraData();
                }
                PicMessageExtraData picMessageExtraData5 = pVar.E;
                picMessageExtraData5.mTemplateId = stringExtra7;
                picMessageExtraData5.mTemplateName = stringExtra8;
            }
        }
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_TAB_SEARCH_EMO, false)) {
            if (pVar.E == null) {
                pVar.E = new PicMessageExtraData();
            }
            pVar.E.imageBizType = 12;
        }
    }

    public static void d0(Bundle bundle) {
        if (bundle != null) {
            StringBuilder sb5 = new StringBuilder("bundle ");
            sb5.append(" extras:");
            for (String str : bundle.keySet()) {
                if (!str.equalsIgnoreCase("uin")) {
                    sb5.append(str);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(bundle.get(str));
                    sb5.append(" ");
                }
            }
            QLog.i("ForwardUtils", 1, sb5.toString());
        }
    }

    public static void e(Intent intent, com.tencent.mobileqq.pic.p pVar) {
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_STICKER, false) || intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_STICKER_AD, false)) {
            PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
            if (intent.getBooleanExtra(AppConstants.Key.FORWARD_IS_STICKER, false)) {
                picMessageExtraData.imageBizType = 7;
            } else {
                picMessageExtraData.imageBizType = 9;
                picMessageExtraData.setAdEmoJumpUrl(intent.getStringExtra(IPicBus.AD_EMO_JUMP_URL));
                picMessageExtraData.setAdEmoDescStr(intent.getStringExtra(IPicBus.AD_EMO_DESC_STR));
            }
            String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA);
            if (!TextUtils.isEmpty(stringExtra)) {
                picMessageExtraData.textSummary = stringExtra;
            }
            picMessageExtraData.from = intent.getIntExtra(PeakConstants.KEY_EMOTION_SOURCE_FROM, 0);
            picMessageExtraData.source = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_INFO);
            picMessageExtraData.webUrl = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_WEBURL);
            picMessageExtraData.iconUrl = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_ICONURL);
            picMessageExtraData.packageName = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_PACKAGE);
            picMessageExtraData.emojiPkgId = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID);
            pVar.E = picMessageExtraData;
        }
    }

    public static void e0(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static boolean f() {
        try {
            d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
            if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
                e91.g c16 = arkPlatformConfig.c();
                QLog.d("ForwardUtils", 1, "backToFileScheme mIsBackToFileSchemeEnable=", Boolean.valueOf(c16.d()));
                return c16.d();
            }
        } catch (Exception e16) {
            QLog.e("ForwardUtils", 1, "Exception", e16);
        }
        QLog.d("ForwardUtils", 1, "backToFileScheme default true");
        return true;
    }

    public static void f0(int i3, Intent intent, Bundle bundle) {
        if (i3 == 10014 && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            Bundle bundle2 = (Bundle) bundle.clone();
            for (String str : extras.keySet()) {
                if (bundle2.containsKey(str)) {
                    bundle2.remove(str);
                }
            }
            extras.putAll(bundle2);
            intent.putExtras(extras);
            d0(intent.getExtras());
            return;
        }
        intent.putExtras(bundle);
    }

    public static void g(Context context, String str, Intent intent, long j3) {
        Intent intent2 = new Intent();
        Uri parse = Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), "shareToQQ"));
        intent2.setData(parse);
        intent2.setPackage(str);
        intent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, PendingIntent.getActivity(context, 0, intent2, 335544320));
        intent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_URI_DATA, parse);
        intent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_APP_ID, j3);
        intent.putExtra(AppConstants.Key.SHARE_RES_PKG_NAME, str);
    }

    public static void g0(QQAppInterface qQAppInterface, String str, int i3, String... strArr) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (strArr != null) {
            if (strArr.length == 1) {
                str2 = strArr[0];
                str3 = "";
                str5 = str3;
                str4 = str5;
                ReportController.o(qQAppInterface, "dc00898", "", "", str, str, i3, 0, str2, str3, str5, str4);
            }
            if (strArr.length == 2) {
                String str6 = strArr[0];
                str3 = strArr[1];
                str5 = "";
                str4 = str5;
                str2 = str6;
            } else if (strArr.length == 3) {
                String str7 = strArr[0];
                String str8 = strArr[1];
                str5 = strArr[2];
                str4 = "";
                str2 = str7;
                str3 = str8;
            } else if (strArr.length == 4) {
                String str9 = strArr[0];
                String str10 = strArr[1];
                String str11 = strArr[2];
                str4 = strArr[3];
                str2 = str9;
                str3 = str10;
                str5 = str11;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", str, str, i3, 0, str2, str3, str5, str4);
        }
        str2 = "";
        str3 = str2;
        str5 = str3;
        str4 = str5;
        ReportController.o(qQAppInterface, "dc00898", "", "", str, str, i3, 0, str2, str3, str5, str4);
    }

    public static h.a h(String str, String str2, String str3, ArrayList<AtTroopMemberInfo> arrayList) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            h.a aVar = new h.a();
            aVar.f434699a = str;
            aVar.f434700b = str2;
            aVar.f434701c = str3;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            aVar.f434702d = arrayList;
            aVar.f434704f = System.currentTimeMillis();
            aVar.f434703e = false;
            aVar.f434705g = false;
            return aVar;
        }
        QLog.d("ForwardUtils", 1, "msg|guildId|channelId is empty");
        return null;
    }

    public static void h0(QQAppInterface qQAppInterface, String str, String... strArr) {
        g0(qQAppInterface, str, 0, strArr);
    }

    protected static boolean i(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo) {
        if (sessionInfo.f179555d != 1 || !((com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(sessionInfo.f179557e, true).f300235b) {
            return false;
        }
        QQToast.makeText(qQAppInterface.getApp(), R.string.emm, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return true;
    }

    public static void i0(final QQAppInterface qQAppInterface, final String str, final int i3, final String str2) {
        QLog.i(ForwardBaseOption.TAG, 1, "saveForwardRecord toUin=" + str + "toUinType" + i3 + "guildId" + str2);
        if (i3 == 10008) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.1
            @Override // java.lang.Runnable
            public void run() {
                RecentUser recentUser = new RecentUser(str, i3);
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                recentUser.lastmsgtime = K0;
                recentUser.lastmsgdrafttime = K0;
                int i16 = i3;
                if (i16 == 1046 || i16 == 10014) {
                    return;
                }
                if (i16 == 10027) {
                    recentUser.troopUin = str2;
                    IGProGuildInfo guildInfo = ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(str2);
                    if (guildInfo != null) {
                        recentUser.displayName = guildInfo.getGuildName();
                    }
                }
                if (AppConstants.DATALINE_PC_UIN.equals(str)) {
                    recentUser.type = 6000;
                } else if (AppConstants.DATALINE_PHONE_UIN.equals(str)) {
                    recentUser.type = 6005;
                } else if (AppConstants.DATALINE_IPAD_UIN.equals(str)) {
                    recentUser.type = 6003;
                }
                ((IRecentUserProxyService) qQAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache().saveRecentUser(((ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class)).onSaveRecentUser(recentUser, false));
            }
        }, 32, null, true);
    }

    protected static boolean j(QQAppInterface qQAppInterface, Intent intent, SessionInfo sessionInfo, int i3) {
        if (sessionInfo.f179555d == 9501) {
            return true;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(sessionInfo.f179557e)) {
            String stringExtra = intent.getStringExtra("file_send_path");
            if (FileUtils.fileExistsAndNotEmpty(stringExtra)) {
                com.tencent.mobileqq.forward.utils.f.f211079a.r(sessionInfo, stringExtra);
                return true;
            }
            return false;
        }
        return false;
    }

    private static void j0(int i3, p pVar, int i16) {
        String str;
        AniStickerInfo aniStickerInfo = QQSysFaceUtil.getAniStickerInfo(i3);
        if (aniStickerInfo != null && pVar != null) {
            MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
            messageForAniSticker.sourceType = 1;
            String str2 = aniStickerInfo.text;
            messageForAniSticker.f203106msg = str2;
            messageForAniSticker.text = str2;
            messageForAniSticker.sevrId = aniStickerInfo.sevrId;
            messageForAniSticker.packId = aniStickerInfo.aniStickerPackId;
            messageForAniSticker.stickerId = aniStickerInfo.aniStickerId;
            messageForAniSticker.stickerType = aniStickerInfo.aniStickerType;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d(ForwardBaseOption.TAG, 1, "sendAniStickerMsg appRuntime is null");
                return;
            }
            ChatActivityFacade.v0((QQAppInterface) peekAppRuntime, pVar, messageForAniSticker, i16);
            if (messageForAniSticker.isAniStickerRandom()) {
                str = "0X800BCCC";
            } else {
                str = "0X800BBD5";
            }
            String str3 = str;
            ReportController.o(peekAppRuntime, "dc00898", "", "", str3, str3, aniStickerInfo.sevrId, 0, "", "", "", "");
            return;
        }
        QLog.d(ForwardBaseOption.TAG, 1, "sendAniStickerMsg. when AniStickerInfo or session null");
    }

    private static Intent k(Activity activity, String str, String str2, String str3, boolean z16, boolean z17) {
        Intent intent = new Intent(activity, (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("only_single_selection", !z17);
        intent.putExtra("call_by_forward", false);
        intent.putExtra("extra_mini_mode", true);
        intent.putExtra("extra_show_friend_first", true);
        intent.putExtra("key_forward_is_show_troop", z16);
        intent.putExtra("extra_forward_title", str);
        intent.putExtra("extra_troop_entrance_title", str2);
        intent.putExtra("extra_select_finish_text", str3);
        intent.putExtra("key_forward_is_show_guild", false);
        intent.putExtra(AppConstants.Key.IS_SELECT_TROOP, true);
        intent.putExtra("extra_choose_friend", 9);
        return intent;
    }

    public static void k0(List<ResultRecord> list, List<oidb_cmd0xdc2$BatchSendRsp> list2, Context context, String str) {
        QLog.d("ForwardUtils", 1, "sendCommentMsg: invoked textAndEmoji : ", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (ResultRecord resultRecord : list) {
            if (U(list2, resultRecord.uin)) {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = resultRecord.getUinType();
                sessionInfo.f179557e = resultRecord.uin;
                sessionInfo.f179559f = resultRecord.groupUin;
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, str);
            }
        }
    }

    public static void l(Activity activity) {
        activity.finish();
        Intent intent = activity.getIntent();
        if (intent != null && intent.getBooleanExtra(ForwardRecentActivity.PARAM_BIND_FINISH, false)) {
            activity.sendBroadcast(new Intent(ForwardRecentActivity.ACTION_BIND_FINISH));
        }
    }

    public static void l0(Bundle bundle) {
        String string = bundle.getString("uin");
        String string2 = bundle.getString("guild_id");
        String string3 = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER);
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ((st1.h) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).h0(qQAppInterface, h(string2, string, string3, null));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ForwardUtils", 2, "sendCommentMsgToGuild exception", e16);
            }
        }
    }

    public static void m(Intent intent, Bundle bundle, final QQAppInterface qQAppInterface, final String str, final String str2, final int i3) {
        String string = bundle.getString(AppConstants.Key.FORWARD_EXTRA);
        if (string == null) {
            string = intent.getStringExtra(AppConstants.Key.FORWARD_EXTRA);
        }
        if (string == null) {
            string = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = bundle.getString(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
        }
        final String str3 = string;
        final int i16 = bundle.getInt("KEY_MSG_FORWARD_ID");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.6
            @Override // java.lang.Runnable
            public void run() {
                String fileName = FileManagerUtil.getFileName(str3);
                QLog.i("Dataline_FileAssistant", 1, "---forwardToNewDataLine--- forwardID:" + i16);
                if (FileUtils.fileExistsAndNotEmpty(str3)) {
                    String j3 = com.tencent.mobileqq.filemanager.util.q.j(fileName);
                    if (TextUtils.isEmpty(j3)) {
                        j3 = ".jpg";
                    }
                    String str4 = lc1.b.a().getDefaultRecvPath() + fileName + j3;
                    FileUtils.copyFile(str3, str4);
                    QLog.i("Dataline_FileAssistant", 1, "---forwardToNewDataLine--- sendLocalFile");
                    qQAppInterface.getFileManagerEngine().G0(str4, str, str2, "", i3, true, 0L, i16);
                }
            }
        });
    }

    public static void m0(@NotNull List<ResultRecord> list, List<oidb_cmd0xdc2$BatchSendRsp> list2, String str) {
        QLog.d("ForwardUtils", 1, "sendCommentMsgToGuild: invoked textAndEmoji : ", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        for (ResultRecord resultRecord : list) {
            if (U(list2, resultRecord.uin)) {
                ((st1.h) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).h0(qQAppInterface, h(resultRecord.guildId, resultRecord.uin, str, null));
            }
        }
    }

    public static URLDrawable n(Context context, MessageForPic messageForPic) {
        return com.tencent.mobileqq.activity.aio.photo.f.c(messageForPic);
    }

    public static SessionInfo n0(Intent intent) {
        return p0(intent.getExtras());
    }

    private static long o() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getMaxValidForwardDiffTime: runtime is null ? ");
        if (peekAppRuntime == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("SplashActivity", 1, sb5.toString());
        if (peekAppRuntime != null) {
            if (TextUtils.isEmpty(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getString("forward_max_valid_diff_time", String.valueOf(600000)))) {
                return 600000L;
            }
            try {
                return Integer.parseInt(r0);
            } catch (NumberFormatException e16) {
                QLog.i("SplashActivity", 1, "getMaxValidForwardDiffTime: ", e16);
            }
        }
        return 600000L;
    }

    public static SessionInfo o0(Intent intent, String str, int i3, String str2) {
        return q0(intent.getExtras(), str, i3, str2, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0182 A[Catch: all -> 0x019d, Exception -> 0x019f, TryCatch #0 {Exception -> 0x019f, blocks: (B:5:0x0036, B:10:0x004a, B:13:0x0064, B:20:0x0074, B:24:0x0130, B:26:0x0134, B:28:0x013d, B:30:0x0147, B:32:0x014d, B:34:0x0182, B:36:0x0188, B:37:0x018a, B:39:0x0190, B:43:0x007a, B:45:0x007e, B:47:0x008d, B:50:0x0096, B:52:0x009c, B:53:0x009e, B:55:0x00a4, B:56:0x00aa, B:58:0x00b7, B:60:0x00c3, B:61:0x00cc, B:62:0x010e, B:63:0x0072), top: B:4:0x0036, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, Intent intent) {
        AbsStructMsg d16;
        String str;
        boolean z16;
        int i3;
        String b16;
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "handleAppShareAction() type" + sessionInfo.f179555d + "uin=" + sessionInfo.f179557e);
        }
        try {
            try {
                d16 = com.tencent.mobileqq.structmsg.i.d(intent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardUtils", 2, "handleAppShareAction Exception", e16);
                }
                e16.printStackTrace();
            }
            if (d16 == null) {
                return;
            }
            d16.sourceAccoutType = intent.getIntExtra("accostType", 0);
            String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
            int i16 = d16.mMsgServiceID;
            if (i16 == 83) {
                d16.mMsgActionData = "";
            }
            if (i16 == 108 || i16 == 114 || i16 == 116) {
                d16.mMsgActionData = "";
            }
            if (!(d16 instanceof StructMsgForImageShare) && (!(d16 instanceof AbsShareMsg) || !M(((AbsShareMsg) d16).forwardType, i16))) {
                if (35 != d16.mMsgServiceID) {
                    str = "";
                    int c16 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
                    intent.getIntExtra("forward_msg_from_together", 0);
                    com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra);
                    d16.forwardID = c16;
                    ShareMsgHelper.i(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d, d16, null);
                    z16 = false;
                } else {
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = d16.mCommentText;
                    }
                    if (!TextUtils.isEmpty(stringExtra)) {
                        com.tencent.biz.anonymous.a.h().f78364c = true;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (MultiMsgManager.w().K != null && MultiMsgManager.w().K.size() > 0) {
                        arrayList.addAll(MultiMsgManager.w().K);
                    }
                    long longExtra = intent.getLongExtra(AppConstants.Key.STRUCT_MSG_UNISEQ, 0L);
                    int intExtra = intent.getIntExtra("forward_msg_from_together", 0);
                    int c17 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
                    com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra);
                    str = "";
                    MultiMsgManager.w().U(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179555d, sessionInfo.f179559f, d16, longExtra, false, intExtra, c17, intent.getExtras());
                    stringExtra = stringExtra;
                    z16 = false;
                }
                if ((d16 instanceof StructMsgForGeneralShare) && com.tencent.mobileqq.structmsg.d.a((AbsShareMsg) d16)) {
                    i3 = d16.uinType;
                    b16 = com.tencent.mobileqq.structmsg.d.b(d16.mMsgUrl);
                    if (b16 != null && !b16.equals(str)) {
                        ReportController.o(null, "CliOper", "", "", "0X8005F54", "0X8005F54", 0, 0, com.tencent.mobileqq.structmsg.d.d(i3) + str, "", b16, "");
                    }
                }
                if (z16) {
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = d16.mCommentText;
                    }
                    if (!TextUtils.isEmpty(stringExtra)) {
                        com.tencent.biz.anonymous.a.h().f78364c = true;
                        com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, stringExtra);
                    }
                }
            }
            z16 = true;
            str = "";
            if (d16 instanceof StructMsgForGeneralShare) {
                i3 = d16.uinType;
                b16 = com.tencent.mobileqq.structmsg.d.b(d16.mMsgUrl);
                if (b16 != null) {
                    ReportController.o(null, "CliOper", "", "", "0X8005F54", "0X8005F54", 0, 0, com.tencent.mobileqq.structmsg.d.d(i3) + str, "", b16, "");
                }
            }
            if (z16) {
            }
        } finally {
            intent.removeExtra("forward_type");
            intent.removeExtra(AppConstants.Key.SHARE_RES_ID);
        }
    }

    public static SessionInfo p0(Bundle bundle) {
        String string;
        String string2;
        String str = null;
        if (bundle == null) {
            string = null;
        } else {
            string = bundle.getString("uin");
        }
        int i3 = -1;
        if (bundle != null) {
            i3 = bundle.getInt("uintype", -1);
        }
        if (bundle == null) {
            string2 = null;
        } else {
            string2 = bundle.getString("troop_uin");
        }
        if (bundle != null) {
            str = bundle.getString(AppConstants.Key.UID);
        }
        return q0(bundle, string, i3, string2, str);
    }

    public static void q(QQAppInterface qQAppInterface, SessionInfo sessionInfo, Intent intent) {
        com.tencent.mobileqq.profile.util.b.n(qQAppInterface, intent.getExtras(), sessionInfo);
    }

    public static SessionInfo q0(Bundle bundle, String str, int i3, String str2, String str3) {
        String string;
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = str;
        sessionInfo.f179555d = i3;
        if (i3 == 1026) {
            sessionInfo.f179555d = 1;
            if (QLog.isDevelopLevel()) {
                QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
            }
        }
        if (bundle == null) {
            string = null;
        } else {
            string = bundle.getString(AppConstants.Key.PHONENUM);
        }
        sessionInfo.f179564m = string;
        int i16 = 0;
        if (bundle != null) {
            i16 = bundle.getInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
        }
        sessionInfo.P = i16;
        sessionInfo.f179559f = str2;
        int i17 = BuddySource.DEFAULT;
        if (bundle != null) {
            i17 = bundle.getInt(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        }
        sessionInfo.Q = i17;
        sessionInfo.f178172i0 = str3;
        return sessionInfo;
    }

    public static String r(QQAppInterface qQAppInterface, String str, String str2) {
        if (str == null) {
            return "";
        }
        int q16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str2);
        int length = str.length();
        int integer = qQAppInterface.getApplication().getResources().getInteger(R.integer.f167159l);
        if (length > integer) {
            str = str.substring(0, integer) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str + "(" + q16 + ")";
    }

    public static void r0(Context context, Intent intent) {
        intent.setClass(context, QPublicFragmentActivity.class);
        intent.putExtra("is_multi_selection", false);
        intent.putExtra("only_single_selection", true);
        intent.putExtra("call_by_forward", true);
        intent.putExtra("public_fragment_class", ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass().getName());
    }

    public static String s(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        TroopInfo troopInfo;
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopInfo = troopManager.k(str);
        } else {
            troopInfo = null;
        }
        if (troopInfo != null && i3 == 23) {
            return troopInfo.getNewTroopNameOrTroopName();
        }
        return str2;
    }

    public static void s0(final QQAppInterface qQAppInterface, long j3) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.8
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
                    QQToast.makeText(QQAppInterface.this.getApp(), 2, R.string.f170969bc3, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            }
        }, j3);
    }

    private static void t(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, MqqHandler mqqHandler, SessionInfo sessionInfo, int i3) {
        int i16 = sessionInfo.f179555d;
        if (i16 != 0 && i16 != 1) {
            J(qQAppInterface, activity, context, intent, mqqHandler, sessionInfo, i3);
        } else {
            j0(intent.getIntExtra(AppConstants.Key.FORWARD_EXTRA, -1), sessionInfo, i3);
        }
    }

    private static void u(final QQAppInterface qQAppInterface, Intent intent, final SessionInfo sessionInfo, String str, int i3) {
        int intExtra;
        intent.putExtra(AppConstants.Key.FORWARD_UIN_TYPE, sessionInfo.f179555d);
        intent.putExtra(AppConstants.Key.SENDER_TROOP_UIN, sessionInfo.f179559f);
        intent.putExtra(AppConstants.Key.FORWARD_PEER_UIN, sessionInfo.f179557e);
        intent.putExtra(AppConstants.Key.FORWARD_SELF_UIN, qQAppInterface.getCurrentAccountUin());
        int intExtra2 = intent.getIntExtra(AppConstants.Key.BUSI_TYPE, 1009);
        final int intExtra3 = intent.getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1);
        e0("ForwardUtils", "report forward! forwardFilePath = " + str + ",forwardSourceUinType = " + intExtra3);
        if (str != null) {
            final String str2 = AppConstants.SDCARD_AIO_FORWARD + "#" + intent.getLongExtra(AppConstants.Key.FORWARD_IMAGE_WIDTH, 0L) + "#" + intent.getLongExtra(AppConstants.Key.FORWARD_IMAGE_HEIGHT, 0L) + "#" + intent.getIntExtra(AppConstants.Key.FORWARD_IMAGE_TYPE, 0);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ForwardUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.activity.photo.m.k(new String[]{str2}, sessionInfo.f179555d, false, true, intExtra3, qQAppInterface);
                }
            }, 64, null, false);
        }
        com.tencent.mobileqq.pic.l createForwardPicInfo = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(intExtra2, intent);
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(3, intExtra2);
        createPicReq.e(createForwardPicInfo);
        d(intent, createPicReq);
        new x61.e().h(qQAppInterface, sessionInfo, createPicReq);
        createPicReq.I = i3;
        PicMessageExtraData picMessageExtraData = createPicReq.E;
        if (picMessageExtraData == null || (intExtra = picMessageExtraData.imageBizType) <= 0) {
            intExtra = intent.getIntExtra(AppConstants.Key.FORWARD_PHOTO_IMAGEBIZ_TYPE, 0);
        }
        int a16 = am.f178207a.a(intExtra);
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_ORIGIN_IMAGE_MD5);
        if (stringExtra == null) {
            stringExtra = "";
        }
        com.tencent.mobileqq.forward.utils.f.f211079a.o(sessionInfo, str, a16, stringExtra, intent.getIntExtra(AppConstants.Key.FORWARD_PIC_PACKAGE_ID, -1), intent.getIntExtra(AppConstants.Key.FORWARD_PIC_SUB_SUB_TYPE, -1));
    }

    private static void v(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, MqqHandler mqqHandler, SessionInfo sessionInfo) {
        Iterator it = intent.getExtras().getParcelableArrayList(AppConstants.Key.FORWARD_COMPOSITE).iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            int i3 = ((BaseForwardUtil.SectionBase) parcelable).f178061d;
            if (i3 != -1) {
                if (i3 == 1) {
                    intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_TASK_KEY);
                    intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN);
                    intent.getIntExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, -1);
                    intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH);
                    intent.getLongExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, -1L);
                    com.tencent.mobileqq.forward.utils.f.f211079a.l(sessionInfo, ((BaseForwardUtil.SectionPic) parcelable).f178063f);
                    Message message = new Message();
                    message.what = 59;
                    if (mqqHandler != null) {
                        mqqHandler.sendMessage(message);
                    }
                }
            } else {
                BaseForwardUtil.SectionText sectionText = (BaseForwardUtil.SectionText) parcelable;
                if (!TextUtils.isEmpty(sectionText.f178064e)) {
                    com.tencent.biz.anonymous.a.h().f78364c = true;
                }
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, sectionText.f178064e);
            }
        }
    }

    public static boolean w(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, MqqHandler mqqHandler) {
        e0("forward", "handleForwardData");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            x(qQAppInterface, activity, context, intent, mqqHandler, parcelableArrayListExtra);
        } else {
            SessionInfo n06 = n0(intent);
            if (i(qQAppInterface, context, n06)) {
                return false;
            }
            int intExtra = intent.getIntExtra("forward_type", Integer.MAX_VALUE);
            e0("forward", "handleForwardData() forwardType" + intExtra);
            if (intExtra == Integer.MAX_VALUE) {
                return false;
            }
            intent.removeExtra("forward_type");
            String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            int intExtra2 = intent.getIntExtra("KEY_MSG_FORWARD_ID", 0);
            if (NtMsgForwardUtils.k(n06, intExtra, intent) || K(n06, intExtra, intent)) {
                return true;
            }
            if (intExtra != -6) {
                if (intExtra != -5) {
                    if (intExtra != -2) {
                        if (intExtra != -1) {
                            if (intExtra != 0) {
                                if (intExtra != 1) {
                                    if (intExtra != 8) {
                                        if (intExtra != 10) {
                                            if (intExtra != 21) {
                                                if (intExtra == 1054) {
                                                    if (j(qQAppInterface, intent, n06, intExtra2)) {
                                                        return true;
                                                    }
                                                    e0("ForwardUtils", "handleForwardData(): VideoEmoticon => " + intent.getExtras());
                                                    L(qQAppInterface, intent, intExtra2);
                                                }
                                            } else {
                                                if (j(qQAppInterface, intent, n06, intExtra2)) {
                                                    return true;
                                                }
                                                e0("ForwardUtils", "handleForwardData(): ShortVideo => " + intent.getExtras());
                                                I(qQAppInterface, intent, intExtra2);
                                            }
                                        } else {
                                            v(qQAppInterface, activity, context, intent, mqqHandler, n06);
                                        }
                                    } else {
                                        G(qQAppInterface, mqqHandler, n06, stringExtra);
                                    }
                                } else {
                                    F(qQAppInterface, activity, intent, mqqHandler, n06, stringExtra, intExtra2);
                                }
                            } else {
                                return C(qQAppInterface, activity, context, intent, n06, stringExtra, intExtra2);
                            }
                        } else {
                            J(qQAppInterface, activity, context, intent, mqqHandler, n06, intExtra2);
                        }
                    } else {
                        D(qQAppInterface, context, intent, n06);
                    }
                } else {
                    ((MixedMsgManager) qQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).k(n06, intent.getLongExtra(AppConstants.Key.FORWARD_UNISEQ, 0L), intExtra2);
                }
            } else {
                com.tencent.mobileqq.replymsg.d.c().b(qQAppInterface, n06, intent);
            }
            z(intExtra, qQAppInterface, n06, intExtra2, intent, mqqHandler, context, activity);
            y(intExtra, qQAppInterface, n06, context, intent);
        }
        intent.removeExtra(AEEditorConstants.EXTRA_IS_EDITED_PIC);
        intent.removeExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC);
        intent.removeExtra("key_allow_multiple_forward_from_limit");
        intent.removeExtra(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT);
        return true;
    }

    private static boolean x(QQAppInterface qQAppInterface, Activity activity, Context context, Intent intent, MqqHandler mqqHandler, List<ResultRecord> list) {
        int i3;
        intent.removeExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        int[] intArrayExtra = intent.getIntArrayExtra("KEY_MSG_FORWARD_ID_ARRAY");
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            ResultRecord resultRecord = list.get(i16);
            Intent intent2 = new Intent(intent);
            intent2.putExtra("uin", resultRecord.uin);
            intent2.putExtra("uintype", resultRecord.getUinType());
            intent2.putExtra("troop_uin", resultRecord.groupUin);
            intent2.putExtra("uinname", resultRecord.name);
            intent2.putExtra("guild_id", resultRecord.guildId);
            intent2.removeExtra("KEY_MSG_FORWARD_ID_ARRAY");
            if (intArrayExtra != null && intArrayExtra.length > i16) {
                i3 = intArrayExtra[i16];
            } else {
                i3 = 0;
            }
            intent2.putExtra("KEY_MSG_FORWARD_ID", i3);
            w(qQAppInterface, activity, context, intent2, mqqHandler);
        }
        return true;
    }

    private static void y(int i3, QQAppInterface qQAppInterface, SessionInfo sessionInfo, Context context, Intent intent) {
        if (i3 != -3 && i3 != 20 && i3 != 29 && i3 != 36) {
            if (i3 != 42 && i3 != 53) {
                if (i3 != 23 && i3 != 24) {
                    return;
                }
            } else {
                q(qQAppInterface, sessionInfo, intent);
                return;
            }
        }
        p(qQAppInterface, context, sessionInfo, intent);
    }

    private static void z(int i3, QQAppInterface qQAppInterface, SessionInfo sessionInfo, int i16, Intent intent, MqqHandler mqqHandler, Context context, Activity activity) {
        if (i3 != 9) {
            if (i3 == 48) {
                t(qQAppInterface, activity, context, intent, mqqHandler, sessionInfo, i16);
                return;
            }
            return;
        }
        E(qQAppInterface, activity, intent, sessionInfo, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f178099a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f178100b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f178101c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f178102d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f178103e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f178104f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ SessionInfo f178105g;

        a(ArrayList arrayList, Activity activity, int i3, QQAppInterface qQAppInterface, String str, int i16, SessionInfo sessionInfo) {
            this.f178099a = arrayList;
            this.f178100b = activity;
            this.f178101c = i3;
            this.f178102d = qQAppInterface;
            this.f178103e = str;
            this.f178104f = i16;
            this.f178105g = sessionInfo;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            String str;
            Iterator it = this.f178099a.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (uri != null) {
                    str = new UriParserPathHelper(this.f178100b, false, null).getPathFromUri(uri);
                } else {
                    str = "";
                }
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    String str3 = "localPath = null. model:" + Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel();
                    if (uri != null) {
                        str3 = str3 + " uri:" + uri.toString();
                    }
                    QLog.e("ForwardUtils<FileAssistant>", 1, str3);
                }
                if (this.f178101c == 1) {
                    this.f178102d.getFileManagerEngine().J0(str2, this.f178103e, 0L, this.f178104f);
                } else {
                    NTFileManageBridger nTFileManageBridger = this.f178102d.getNTFileManageBridger();
                    SessionInfo sessionInfo = this.f178105g;
                    nTFileManageBridger.p0(str2, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, 0L, this.f178104f);
                }
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
