package com.tencent.mobileqq.app;

import AccostSvc.RespClientMsg;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.CARDSETTYPE;
import QQService.PushVoteIncreaseInfo;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHead;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.TMedalWallInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import SummaryCardTaf.summaryCardWzryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.ExecSQLTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.observer.ICardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import cooperation.qzone.UploadEnv;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.medal.common$MedalInfo;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspBody;
import tencent.im.oidb.cmd0x7a8$ReqBody;
import tencent.im.oidb.cmd0x7a8$RspBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba$PraiseInfo;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba$ReqBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba$RspBody;
import tencent.im.oidb.cmd0x922.cmd0x922$ReqBody;
import tencent.im.oidb.cmd0x922.cmd0x922$RspBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$ReqBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$RspBody;
import tencent.im.oidb.cmd0xac6$MedalReport;
import tencent.im.oidb.cmd0xac6$ReqBody;
import tencent.im.oidb.cmd0xac6$RspBody;
import tencent.im.oidb.cmd0xac6$operate_result;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$GetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$GetDataRsp;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$ReqBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$RspBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$SetDataReq;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d$EduHis;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d$ReqBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d$RspBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d$SchoolInfo;
import tencent.im.oidb.cmd0xd8a$ClientInfo;
import tencent.im.oidb.cmd0xd8a$ReqBody;
import tencent.im.oidb.cmd0xd8a$RspBody;
import tencent.im.oidb.cmd0xe26.oidb_0xe26$EntranceTemplate;
import tencent.im.oidb.cmd0xe26.oidb_0xe26$ReqBody;
import tencent.im.oidb.cmd0xe26.oidb_0xe26$RspBody;
import tencent.im.oidb.oidb_0xc33$ReqBody;
import tencent.im.oidb.oidb_0xc33$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.storage.wording_storage$WordingCfg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CardHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    public static final String E;
    public static final Vector<Integer> F;
    public static final Vector<Integer> G;
    private String C;
    short D;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f194468d;

    /* renamed from: e, reason: collision with root package name */
    protected String f194469e;

    /* renamed from: f, reason: collision with root package name */
    private ITransFileController f194470f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f194471h;

    /* renamed from: i, reason: collision with root package name */
    private AppInterface f194472i;

    /* renamed from: m, reason: collision with root package name */
    short f194473m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.CardHandler$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CardHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.v5();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements IUploadTaskCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardHandler.this);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, abstractUploadTask, Integer.valueOf(i3), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.QZONE_PHOTO_WALL, 2, "onUploadError " + str + " path:" + abstractUploadTask.uploadFilePath);
            }
            CardHandler.this.notifyUI(69, false, new Object[]{abstractUploadTask.uploadFilePath});
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, abstractUploadTask, Long.valueOf(j3), Long.valueOf(j16));
            } else if (j3 == j16) {
                CardHandler.this.f194469e = null;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "onUploadProgress is 100%");
                }
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) abstractUploadTask, i3);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractUploadTask, obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "onUploadSucceed ");
            }
            synchronized (CardHandler.this.f194468d) {
                if (CardHandler.this.f194468d.size() != 0) {
                    CardHandler.this.v5();
                } else {
                    CardHandler.this.notifyUI(69, true, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends com.tencent.mobileqq.profile.upload.config.a {
        static IPatchRedirector $redirector_;

        b(long j3) {
            super(j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CardHandler.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadConfig
        public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize uploadImageSize, int i3, AbstractUploadTask abstractUploadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IUploadConfig.UploadImageSize) iPatchRedirector.redirect((short) 2, this, uploadImageSize, Integer.valueOf(i3), abstractUploadTask);
            }
            Bitmap e16 = com.tencent.mobileqq.profile.upload.a.e(abstractUploadTask.uploadFilePath);
            if (e16 != null) {
                IUploadConfig.UploadImageSize uploadImageSize2 = new IUploadConfig.UploadImageSize(e16.getWidth(), e16.getHeight(), 100);
                e16.recycle();
                return uploadImageSize2;
            }
            return new IUploadConfig.UploadImageSize(640, 1136, 100);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<d> f194477a;

        public c(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            } else {
                this.f194477a = new WeakReference<>(dVar);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg.fileType == 35) {
                switch (message.what) {
                    case 1003:
                        byte[] bArr = fileMsg.bdhExtendInfo;
                        WeakReference<d> weakReference = this.f194477a;
                        if (weakReference != null && weakReference.get() != null) {
                            this.f194477a.get().b(bArr);
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
                                return;
                            }
                            return;
                        }
                    case 1004:
                    case 1005:
                        WeakReference<d> weakReference2 = this.f194477a;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            this.f194477a.get().a(fileMsg.errorCode);
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
                                return;
                            }
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void a(int i3);

        void b(byte[] bArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 92)) {
            redirector.redirect((short) 92);
            return;
        }
        E = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "portrait/");
        F = new Vector<>();
        G = new Vector<>();
    }

    public CardHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194468d = new ArrayList<>();
        this.f194469e = null;
        this.f194470f = null;
        this.f194473m = (short) 9;
        this.C = null;
        this.D = (short) -23461;
        this.f194471h = qQAppInterface;
        this.f194472i = qQAppInterface;
        Vector<Integer> vector = F;
        if (vector.size() == 0) {
            vector.add(0);
            vector.add(60);
            vector.add(100);
            vector.add(160);
            vector.add(640);
        }
        Vector<Integer> vector2 = G;
        if (vector2.size() == 0) {
            vector2.add(0);
            vector.add(60);
            vector.add(100);
            vector.add(160);
            vector.add(640);
            vector.add(960);
            vector.add(120);
        }
    }

    private void A3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList success=" + z16);
        }
        A4((byte[]) obj, z16, true);
    }

    private void A4(byte[] bArr, boolean z16, boolean z17) {
        StringBuilder sb5;
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                    boolean z18 = false;
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_notify_on_like_ranking_list_flag.get() == 0) {
                                z18 = true;
                            }
                            z16 = true;
                            z17 = z18;
                        } else {
                            z16 = false;
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + z16);
                }
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("handleGetNotifyOnLikeRankingList result=");
            sb5.append(z16);
            QLog.d("CardHandler", 2, sb5.toString());
        }
        notifyUI(77, z16, Boolean.valueOf(z17));
    }

    private void B3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handlePartekeLikeRankingList success=" + z16);
        }
        B4((byte[]) obj, z16, true);
    }

    private void B4(byte[] bArr, boolean z16, boolean z17) {
        StringBuilder sb5;
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                    boolean z18 = false;
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_notify_partake_like_ranking_list_flag.get() == 0) {
                                z18 = true;
                            }
                            z16 = true;
                            z17 = z18;
                        } else {
                            z16 = false;
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + z16);
                }
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("handlePartekeLikeRankingList result=");
            sb5.append(z16);
            QLog.d("CardHandler", 2, sb5.toString());
        }
        notifyUI(81, z16, Boolean.valueOf(z17));
    }

    private void C3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z18 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ByteBuffer wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    wrap.getInt();
                    if (wrap.get() != 0) {
                        z18 = false;
                    }
                    this.f194471h.setPhoneNumSearchable(z18, false);
                }
                z16 = z17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("GetPhoneNumSearchable", 2, e16.getMessage());
                }
                z16 = false;
            }
        }
        if (!z16) {
            z18 = this.f194471h.isPhoneNumSearchable(false);
        }
        notifyUI(38, z16, Boolean.valueOf(z18));
    }

    private void C4(ToServiceMsg toServiceMsg, byte[] bArr, boolean z16, boolean z17) {
        StringBuilder sb5;
        boolean z18;
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetNotifyOnLikeRankingList result=" + z18);
                    }
                    z16 = H2(z18, mergeFrom);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetNotifyOnLikeRankingList ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("handleSetNotifyOnLikeRankingList result=");
                sb5.append(z16);
                sb5.append(";allow=");
                sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
            }
            if (z16) {
                z17 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            }
            notifyUI(78, z16, Boolean.valueOf(z17));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetNotifyOnLikeRankingList result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            throw th5;
        }
    }

    private void D3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17;
        boolean z18 = false;
        boolean z19 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag success=" + fromServiceMsg.getResultCode());
        if (z16) {
            try {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z16);
                } catch (Exception e16) {
                    QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag ex", e16);
                    QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z16);
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_flag_hide_pretty_group_owner_identity.get() == 0) {
                            z18 = true;
                        }
                        z17 = z18;
                        z18 = true;
                        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z18);
                        z19 = z17;
                        z16 = z18;
                        notifyUI(107, z16, Boolean.valueOf(z19));
                    }
                    z17 = true;
                    QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z18);
                    z19 = z17;
                    z16 = z18;
                    notifyUI(107, z16, Boolean.valueOf(z19));
                }
            } catch (Throwable th5) {
                QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z16);
                throw th5;
            }
        }
        z18 = z16;
        z17 = true;
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + z18);
        z19 = z17;
        z16 = z18;
        notifyUI(107, z16, Boolean.valueOf(z19));
    }

    private boolean D4(ToServiceMsg toServiceMsg, boolean z16, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        long j3;
        if (z16 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            int i3 = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray()).getInt();
            if (i3 < 0) {
                j3 = i3 + 4294967296L;
            } else {
                j3 = i3;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetStrangerInviteToGroupSwitch uin=" + this.f194471h.getCurrentAccountUin() + "  lUin:" + String.valueOf(j3));
            }
            if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Card q16 = friendsManager.q(this.f194471h.getCurrentAccountUin());
                boolean z17 = q16.strangerInviteMeGroupOpen;
                q16.strangerInviteMeGroupOpen = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                friendsManager.p0(q16);
                boolean z18 = q16.strangerInviteMeGroupOpen;
                if (z17 != z18) {
                    notifyUI(93, true, new Object[]{Boolean.valueOf(z18), Boolean.valueOf(z17)});
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetStrangerInviteToGroupSwitch newConfigOn=" + z18 + "  oldConfigOn:" + z17);
                }
                return true;
            }
        }
        return false;
    }

    private void E3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar;
        boolean z16;
        String str = (String) toServiceMsg.getAttribute("uin");
        if (fromServiceMsg.isSuccess() && (obj instanceof mobile_sub_get_cover_rsp)) {
            mobile_sub_get_cover_rspVar = (mobile_sub_get_cover_rsp) obj;
            EntityManager createEntityManager = this.f194471h.getEntityManagerFactory().createEntityManager();
            QZoneCover qZoneCover = (QZoneCover) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QZoneCover.class, str);
            if (qZoneCover == null) {
                qZoneCover = new QZoneCover();
                qZoneCover.uin = str;
            }
            qZoneCover.updateQzoneCover(mobile_sub_get_cover_rspVar);
            if (qZoneCover.getStatus() == 1000) {
                createEntityManager.persist(qZoneCover);
            } else {
                createEntityManager.update(qZoneCover);
            }
            createEntityManager.close();
            z16 = true;
        } else {
            mobile_sub_get_cover_rspVar = null;
            z16 = false;
        }
        notifyUI(40, z16, new Object[]{str, mobile_sub_get_cover_rspVar});
    }

    private void E4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        long j3;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("MCardSvc.ReqSetCard".equals(serviceCmd)) {
            boolean c46 = c4(toServiceMsg, fromServiceMsg, obj, bundle);
            ReportInfo cmdQuality = VasCommonReporter.getCmdQuality("MCardSvc.ReqSetCard");
            if (c46) {
                j3 = 0;
            } else {
                j3 = 1;
            }
            cmdQuality.setNum1(j3).report(false);
            return;
        }
        if ("SummaryCard.SetLabel".equals(serviceCmd)) {
            q4(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("SummaryCard.LikeIt".equals(serviceCmd)) {
            i4(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("MCardSvc.ReqGetCardSwitch".equals(serviceCmd)) {
            u3(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("MCardSvc.ReqSetCardSwitch".equals(serviceCmd)) {
            d4(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("VisitorSvc.ReqFavorite".equals(serviceCmd)) {
            r3(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("VisitorSvc.ReqGetVoterList".equals(serviceCmd)) {
            S3(toServiceMsg, fromServiceMsg, obj, bundle);
        } else if ("VisitorSvc.ReqGetFavoriteList".equals(serviceCmd)) {
            Q3(toServiceMsg, fromServiceMsg, obj, bundle);
        } else if ("VisitorSvc.ReqDeleteVisitorRecord".equals(serviceCmd)) {
            P3(toServiceMsg, fromServiceMsg, obj, bundle);
        }
    }

    private void F3(FromServiceMsg fromServiceMsg, Object obj) {
        TMedalWallInfo tMedalWallInfo;
        SparseArray<MedalInfo> sparseArray;
        boolean z16;
        boolean z17;
        Card card;
        boolean z18;
        TMedalWallInfo tMedalWallInfo2;
        cmd0x7a8$RspBody cmd0x7a8_rspbody = new cmd0x7a8$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x7a8_rspbody);
        MedalWallMng medalWallMng = (MedalWallMng) this.f194471h.getManager(QQManagerFactory.MEDAL_WALL_MNG);
        char c16 = 0;
        if (parseOIDBPkg == 0) {
            TMedalWallInfo tMedalWallInfo3 = new TMedalWallInfo();
            tMedalWallInfo3.iOpenFlag = Integer.MIN_VALUE;
            tMedalWallInfo3.iMedalCount = cmd0x7a8_rspbody.uint32_metal_count.get();
            tMedalWallInfo3.iNewCount = cmd0x7a8_rspbody.int32_new_count.get();
            tMedalWallInfo3.iUpgradeCount = cmd0x7a8_rspbody.int32_upgrade_count.get();
            tMedalWallInfo3.strPromptParams = cmd0x7a8_rspbody.str_prompt_params.get();
            y5(tMedalWallInfo3);
            List<common$MedalInfo> list = cmd0x7a8_rspbody.rpt_msg_medal.get();
            ArrayList<MedalID> arrayList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                sparseArray = new SparseArray<>(list.size());
                for (common$MedalInfo common_medalinfo : list) {
                    if (common_medalinfo != null) {
                        int i3 = common_medalinfo.uint32_level.get();
                        if (i3 == 0) {
                            if (QLog.isColorLevel()) {
                                Locale locale = Locale.getDefault();
                                Object[] objArr = new Object[2];
                                objArr[c16] = Integer.valueOf(common_medalinfo.uint32_id.get());
                                objArr[1] = Integer.valueOf(i3);
                                QLog.i("MedalWallMng", 2, String.format(locale, "handleGetSelfNewObtainedMedal medal[%d] get level[%d]", objArr));
                            }
                        } else {
                            MedalInfo h16 = medalWallMng.h(common_medalinfo.uint32_id.get());
                            h16.strName = common_medalinfo.str_name.get();
                            h16.iType = common_medalinfo.uint32_type.get();
                            h16.iNoProgress = common_medalinfo.uint32_no_progress.get();
                            h16.strResJson = common_medalinfo.str_resource.get();
                            h16.iLevelCount = common_medalinfo.uint32_level_count.get();
                            TMedalWallInfo tMedalWallInfo4 = tMedalWallInfo3;
                            h16.lSeqLevel1 = common_medalinfo.uint32_seq.get();
                            h16.lObtainTimeLevel1 = common_medalinfo.uint64_time.get();
                            h16.strDescLevel1 = common_medalinfo.str_desc.get();
                            h16.iPointLevel1 = common_medalinfo.uint32_point.get();
                            h16.strDetailUrlLevel1 = common_medalinfo.str_detail_url.get();
                            h16.strTaskDescLevel1 = common_medalinfo.str_task_desc.get();
                            h16.lSeqLevel2 = common_medalinfo.uint32_seq_level2.get();
                            h16.lObtainTimeLevel2 = common_medalinfo.uint64_time_level2.get();
                            h16.strDescLevel2 = common_medalinfo.str_desc_level2.get();
                            h16.iPointLevel2 = common_medalinfo.uint32_point_level2.get();
                            h16.strDetailUrlLevel2 = common_medalinfo.str_detail_url_2.get();
                            h16.strTaskDescLevel2 = common_medalinfo.str_task_desc_2.get();
                            h16.lSeqLevel3 = common_medalinfo.uint32_seq_level3.get();
                            h16.lObtainTimeLevel3 = common_medalinfo.uint64_time_level3.get();
                            h16.strDescLevel3 = common_medalinfo.str_desc_level3.get();
                            h16.iPointLevel3 = common_medalinfo.uint32_point_level3.get();
                            h16.strDetailUrlLevel3 = common_medalinfo.str_detail_url_3.get();
                            h16.strTaskDescLevel3 = common_medalinfo.str_task_desc_3.get();
                            int i16 = common_medalinfo.uint32_unread.get();
                            int i17 = common_medalinfo.uint32_unread_2.get();
                            int i18 = common_medalinfo.uint32_unread_3.get();
                            if (i3 == 255) {
                                if (h16.iLevel == i3 && h16.iUnreadLevel1 == 2 && i16 == 1) {
                                    arrayList.add(new MedalID(h16.iId, 255));
                                    i16 = 2;
                                }
                            } else if (h16.iLevelCount > 1) {
                                if (h16.iLevel >= 1 && h16.iUnreadLevel1 == 2 && i16 == 1) {
                                    arrayList.add(new MedalID(h16.iId, 1));
                                    i16 = h16.iUnreadLevel1;
                                }
                                if (h16.iLevel >= 2 && h16.iUnreadLevel2 == 2 && i17 == 1) {
                                    arrayList.add(new MedalID(h16.iId, 2));
                                    i17 = h16.iUnreadLevel2;
                                }
                                if (h16.iLevel >= 3 && h16.iUnreadLevel3 == 2 && i18 == 1) {
                                    arrayList.add(new MedalID(h16.iId, 3));
                                    i18 = h16.iUnreadLevel3;
                                }
                            }
                            h16.iLevel = i3;
                            h16.iUnreadLevel1 = i16;
                            h16.iUnreadLevel2 = i17;
                            h16.iUnreadLevel3 = i18;
                            sparseArray.put(h16.iId, h16);
                            tMedalWallInfo3 = tMedalWallInfo4;
                            c16 = 0;
                        }
                    }
                }
                tMedalWallInfo2 = tMedalWallInfo3;
            } else {
                tMedalWallInfo2 = tMedalWallInfo3;
                sparseArray = null;
            }
            if (arrayList.size() > 0) {
                O4(arrayList);
            }
            tMedalWallInfo = tMedalWallInfo2;
        } else {
            tMedalWallInfo = null;
            sparseArray = null;
        }
        if (QLog.isColorLevel()) {
            z16 = false;
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal result: %d", Integer.valueOf(parseOIDBPkg)));
        } else {
            z16 = false;
        }
        if (parseOIDBPkg == 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        medalWallMng.r(z17, tMedalWallInfo, sparseArray);
        if (parseOIDBPkg == 0) {
            card = ((FriendsManager) this.f194472i.getManager(QQManagerFactory.FRIENDS_MANAGER)).s(this.f194472i.getCurrentAccountUin(), true);
        } else {
            card = null;
        }
        if (parseOIDBPkg == 0) {
            z18 = true;
        } else {
            z18 = z16;
        }
        notifyUI(51, z18, card);
    }

    private void F4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("MCardSvc.ReqDelFace".equals(serviceCmd)) {
            q3(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if ("AccostSvc.ClientMsg".equals(serviceCmd)) {
            p3(fromServiceMsg, bundle);
            return;
        }
        if ("AccostSvc.SvrMsg".equals(serviceCmd)) {
            V3(fromServiceMsg, bundle);
            return;
        }
        if ("MCardSvc.ReqPicSafetyCheck".equals(serviceCmd)) {
            N3(toServiceMsg, fromServiceMsg, bundle);
            return;
        }
        if ("OidbSvc.0x490_100".equals(serviceCmd)) {
            C3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x491_100".equals(serviceCmd)) {
            o4(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("SQQzoneSvc.getCover".equals(serviceCmd)) {
            E3(toServiceMsg, fromServiceMsg, obj);
        } else if (ProfileContants.CMD_SET_DETAIL_INFO.equals(serviceCmd)) {
            M4(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x66b".equals(serviceCmd)) {
            I3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x020e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Throwable th5;
        Exception e16;
        String str;
        SharedPreferences preferences;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z17 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetSigninOperate success=" + z16);
        }
        if (z16) {
            try {
                preferences = this.f194471h.getPreferences();
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() != 0) {
                    z17 = false;
                }
            } catch (Exception e17) {
                z17 = z16;
                e16 = e17;
            } catch (Throwable th6) {
                z17 = z16;
                th5 = th6;
                if (QLog.isColorLevel()) {
                }
                throw th5;
            }
            try {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetSigninOperate result=" + z17);
                    }
                    if (z17 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0xe26$RspBody oidb_0xe26_rspbody = new oidb_0xe26$RspBody();
                        oidb_0xe26_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0xe26_rspbody.err_code.get() == 0 && oidb_0xe26_rspbody.template_list.get().size() > 0) {
                            for (int i3 = 0; i3 < oidb_0xe26_rspbody.template_list.get().size(); i3++) {
                                oidb_0xe26$EntranceTemplate oidb_0xe26_entrancetemplate = oidb_0xe26_rspbody.template_list.get().get(i3);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("id", oidb_0xe26_entrancetemplate.f435994id.get());
                                jSONObject.put("name", new String(oidb_0xe26_entrancetemplate.name.get().toByteArray()));
                                jSONObject.put("state", oidb_0xe26_entrancetemplate.state.get());
                                jSONObject.put("template_text", new String(oidb_0xe26_entrancetemplate.template_text.get().toByteArray()));
                                jSONObject.put("start_time", oidb_0xe26_entrancetemplate.start_time.get());
                                jSONObject.put("end_time", oidb_0xe26_entrancetemplate.end_time.get());
                                jSONObject.put("type", oidb_0xe26_entrancetemplate.type.get());
                                jSONObject.put("bytes_url", new String(oidb_0xe26_entrancetemplate.bytes_url.get().toByteArray()));
                                jSONObject.put("bytes_icon_url", new String(oidb_0xe26_entrancetemplate.bytes_icon_url.get().toByteArray()));
                                jSONObject.put("bytes_icon_custom_url", new String(oidb_0xe26_entrancetemplate.bytes_icon_custom_url.get().toByteArray()));
                                jSONObject.put("trace_info", oidb_0xe26_entrancetemplate.trace_info.get());
                                String jSONObject2 = jSONObject.toString();
                                preferences.edit().putString(this.f194471h.getCurrentUin() + "sign_in_operation" + oidb_0xe26_entrancetemplate.state.get() + "" + oidb_0xe26_entrancetemplate.type.get(), jSONObject2);
                            }
                        }
                        preferences.edit().putLong(this.f194471h.getCurrentUin() + "sign_in_operation_time_refresh", oidb_0xe26_rspbody.refresh_second.get()).commit();
                    }
                    z16 = z17;
                } catch (Throwable th7) {
                    th5 = th7;
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + z17);
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                e16 = e18;
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handleGetSigninRedTouch ex", e16);
                }
                if (QLog.isColorLevel()) {
                    str = "handleGetSigninRedTouch result=" + z17;
                    QLog.d("CardHandler", 2, str);
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            str = "handleGetSigninRedTouch result=" + z16;
            QLog.d("CardHandler", 2, str);
        }
    }

    private void G4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0x5eb_22".equals(serviceCmd)) {
            K4(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x5eb_15".equals(serviceCmd)) {
            J4(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_LIKE_RANKING_LIST.equals(serviceCmd)) {
            R3(toServiceMsg, fromServiceMsg, obj, bundle);
            return;
        }
        if (ProfileContants.CMD_GET_NOTIFY_ON_LIKE_RANKING_LIST.equals(serviceCmd)) {
            A3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_PRETTY_TROOP_OWNER_FLAG.equals(serviceCmd)) {
            D3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_PARTAKE_LIKE_RANKING_LIST.equals(serviceCmd)) {
            B3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_SIGNIN_RED_TOUCH.equals(serviceCmd)) {
            H3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_SIGNIN_OPRATION_CONTENT.equals(serviceCmd)) {
            G3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_KPL_INFO.equals(serviceCmd)) {
            x3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_MEDALWALL_INFO.equals(serviceCmd)) {
            z3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_REPORT_MEDALWALL_READ.equals(serviceCmd)) {
            O3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_GET_BIND_PHONE_SWITCH_INFO.equals(serviceCmd)) {
            t3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_AUTO_REPLY.equals(serviceCmd)) {
            L4(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xd8a".equals(serviceCmd)) {
            r4(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xd2d".equals(serviceCmd)) {
            v3(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x4ff_42315".equals(serviceCmd)) {
            g4(toServiceMsg, fromServiceMsg, obj);
        }
    }

    private boolean H2(boolean z16, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        if (z16 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            int i3 = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray()).getInt();
            long j3 = i3;
            if (i3 < 0) {
                j3 = 2147483648L | (i3 & Integer.MAX_VALUE);
            }
            if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                return true;
            }
            return false;
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0324  */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb5;
        String str7;
        boolean z17;
        ?? r36;
        int i3;
        int i16;
        int i17;
        boolean z18;
        JSONObject jSONObject;
        String str8;
        String str9;
        if (fromServiceMsg.isSuccess() && obj != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetSigninRedTouch success=" + z16);
        }
        if (!z16) {
            str9 = "CardHandler";
            str7 = "handleGetSigninRedTouch result=";
        } else {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + z16);
                    }
                    try {
                        if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                            cmd0x922$RspBody cmd0x922_rspbody = new cmd0x922$RspBody();
                            cmd0x922_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                            int i18 = cmd0x922_rspbody.uint32_need_update_flag.get();
                            long j3 = cmd0x922_rspbody.uint64_timestamp.get();
                            SharedPreferences preferences = this.f194471h.getPreferences();
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putLong(this.f194471h.getCurrentUin() + "sign_in_next_get_time", cmd0x922_rspbody.uint32_next_req_time.get() * 1000).commit();
                            int i19 = cmd0x922_rspbody.msg_push_info.uint32_type.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("CardHandler", 2, "handleGetSigninRedTouch testtype=" + i19 + ",needUpdate = " + i18);
                            }
                            try {
                                if (i18 == 1) {
                                    try {
                                        i3 = cmd0x922_rspbody.msg_push_info.uint32_type.get();
                                        i16 = cmd0x922_rspbody.msg_push_info.uint32_red_point.get();
                                        i17 = cmd0x922_rspbody.msg_push_info.uint32_day.get();
                                        str4 = "handleGetSigninRedTouch result=";
                                    } catch (Exception e16) {
                                        e = e16;
                                        str3 = "CardHandler";
                                        str4 = "handleGetSigninRedTouch result=";
                                        try {
                                            if (!QLog.isColorLevel()) {
                                            }
                                            if (!QLog.isColorLevel()) {
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            str2 = str4;
                                            str = str3;
                                            if (QLog.isColorLevel()) {
                                                QLog.d(str, 2, str2 + z16);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str = "CardHandler";
                                        str2 = "handleGetSigninRedTouch result=";
                                        if (QLog.isColorLevel()) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        str3 = "CardHandler";
                                    } catch (Exception e17) {
                                        e = e17;
                                        str3 = "CardHandler";
                                    } catch (Throwable th7) {
                                        th = th7;
                                        str5 = "CardHandler";
                                        str2 = str4;
                                        str = str5;
                                        if (QLog.isColorLevel()) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        String str10 = new String(cmd0x922_rspbody.msg_push_info.bytes_prompt.get().toByteArray());
                                        z18 = z16;
                                        String str11 = new String(cmd0x922_rspbody.msg_push_info.bytes_url.get().toByteArray());
                                        String str12 = new String(cmd0x922_rspbody.msg_push_info.bytes_icon_url.get().toByteArray());
                                        int i26 = cmd0x922_rspbody.msg_push_info.uint32_lst_checkin_time.get();
                                        int i27 = cmd0x922_rspbody.msg_push_info.uint32_open_func.get();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("type", i3);
                                        jSONObject2.put(RedTouchWebviewHandler.PLUGIN_NAMESPACE, i16);
                                        jSONObject2.put("day", i17);
                                        jSONObject2.put("wording", str10);
                                        jSONObject2.put("url", str11);
                                        jSONObject2.put("iconUrl", str12);
                                        jSONObject2.put("lastTime", i26);
                                        jSONObject2.put("openfunc", i27);
                                        String jSONObject3 = jSONObject2.toString();
                                        preferences.edit().putString(this.f194471h.getCurrentUin() + "sign_in_info", jSONObject3).putLong("sign_in_time_stamp", j3).commit();
                                        if (QLog.isColorLevel()) {
                                            QLog.d(DailySignInWebviewPlugin.TAG, 2, "handleGetSigninRedTouch type=" + i3 + " redpoint=" + i16 + " day=" + i17 + " wording=" + str10 + " url=" + str11 + " iconUrl=" + str12 + " lastTime=" + i26 + " openfunc=" + i27);
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        if (!QLog.isColorLevel()) {
                                            str5 = str3;
                                            try {
                                                QLog.d(str5, 2, "handleGetSigninRedTouch ex", e);
                                                str6 = str5;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                str2 = str4;
                                                str = str5;
                                                if (QLog.isColorLevel()) {
                                                }
                                                throw th;
                                            }
                                        } else {
                                            str6 = str3;
                                        }
                                        if (!QLog.isColorLevel()) {
                                            sb5 = new StringBuilder();
                                            str7 = str4;
                                            str8 = str6;
                                            sb5.append(str7);
                                            sb5.append(z16);
                                            QLog.d(str8, 2, sb5.toString());
                                        }
                                        return;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        str2 = str4;
                                        str = str3;
                                        if (QLog.isColorLevel()) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    z18 = z16;
                                    str3 = "CardHandler";
                                    str4 = "handleGetSigninRedTouch result=";
                                    if (i18 == 2) {
                                        String string = preferences.getString(this.f194471h.getCurrentUin() + "sign_in_info", "");
                                        if (TextUtils.isEmpty(string)) {
                                            jSONObject = new JSONObject();
                                        } else {
                                            jSONObject = new JSONObject(string);
                                        }
                                        jSONObject.put(RedTouchWebviewHandler.PLUGIN_NAMESPACE, 0);
                                        jSONObject.put("openfunc", 0);
                                        String jSONObject4 = jSONObject.toString();
                                        preferences.edit().putString(this.f194471h.getCurrentUin() + this.f194471h.getCurrentUin() + "sign_in_info", jSONObject4).putLong("sign_in_time_stamp", j3).commit();
                                    }
                                }
                                z17 = z18;
                                notifyUI(82, z17, null);
                            } catch (Exception e19) {
                                e = e19;
                                z16 = obj;
                            } catch (Throwable th10) {
                                th = th10;
                                z16 = obj;
                            }
                        } else {
                            z17 = z16;
                            str3 = "CardHandler";
                            str4 = "handleGetSigninRedTouch result=";
                            if (QLog.isColorLevel()) {
                                QLog.d(DailySignInWebviewPlugin.TAG, 2, "handleGetSigninRedTouch failed:" + mergeFrom.uint32_result.get());
                            }
                        }
                        z16 = z17;
                        str7 = str4;
                        r36 = str3;
                        str9 = r36;
                    } catch (Exception e26) {
                        e = e26;
                        z16 = r36;
                    } catch (Throwable th11) {
                        th = th11;
                        z16 = r36;
                    }
                } catch (Exception e27) {
                    e = e27;
                } catch (Throwable th12) {
                    th = th12;
                }
            } catch (Exception e28) {
                e = e28;
            } catch (Throwable th13) {
                th = th13;
            }
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            str8 = str9;
            sb5.append(str7);
            sb5.append(z16);
            QLog.d(str8, 2, sb5.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void I2() {
        boolean mkdirs;
        File file = new File(E);
        if (!file.exists()) {
            try {
                mkdirs = file.mkdirs();
            } catch (SecurityException unused) {
            }
            if (!mkdirs) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("background");
                arrayList.add(FaceUtil.IMG_TEMP);
                arrayList.add(FaceUtil.PORTRAIT_HDAVATAR);
                int i3 = 0;
                while (true) {
                    Vector<Integer> vector = F;
                    if (i3 >= vector.size()) {
                        break;
                    }
                    arrayList.add(String.valueOf(vector.get(i3).intValue()));
                    i3++;
                }
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    File file2 = new File(E + "/" + ((String) arrayList.get(i16)));
                    if (!file2.exists()) {
                        try {
                            file2.mkdir();
                        } catch (SecurityException unused2) {
                        }
                    }
                }
                return;
            }
            return;
        }
        mkdirs = true;
        if (!mkdirs) {
        }
    }

    private boolean J2(boolean z16, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        if (z16 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            int i3 = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray()).getInt();
            long j3 = i3;
            if (i3 < 0) {
                j3 = 2147483648L | (i3 & Integer.MAX_VALUE);
            }
            if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                return true;
            }
            return false;
        }
        return z16;
    }

    private void J3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z18 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSession success=" + z16);
        }
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    String str = mergeFrom.str_error_msg.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSession result=" + z16 + " error=" + str);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() > 0 && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_hidden_session_switch.has()) {
                            int i3 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_hidden_session_switch.get();
                            int i16 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_hidden_session_video_switch.get();
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSession settingValue=" + i3 + " videoValue=" + i16);
                            }
                            if (i3 >= 0) {
                                String currentAccountUin = this.f194472i.getCurrentAccountUin();
                                Context applicationContext = this.f194472i.getApplication().getApplicationContext();
                                if (i3 != 1) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                com.tencent.mobileqq.app.hiddenchat.b.e(currentAccountUin, applicationContext, z17);
                            }
                            if (i16 >= 0) {
                                String currentAccountUin2 = this.f194472i.getCurrentAccountUin();
                                Context applicationContext2 = this.f194472i.getApplication().getApplicationContext();
                                if (i16 == 1) {
                                    z18 = false;
                                }
                                com.tencent.mobileqq.app.hiddenchat.b.f(currentAccountUin2, applicationContext2, z18);
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSession ex", e16);
                    }
                }
            } finally {
                notifyUI(104, z16, null);
            }
        }
    }

    private void J4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean g16 = com.tencent.relation.common.config.toggle.c.S.g(false);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "isCombination=" + g16);
        }
        if (g16) {
            U3(toServiceMsg, fromServiceMsg, obj);
            J3(toServiceMsg, fromServiceMsg, obj);
        } else if (toServiceMsg.extraData.getBoolean("sendGlobalRingIdRequest", false)) {
            U3(toServiceMsg, fromServiceMsg, obj);
        } else {
            J3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    private void K4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false)) {
            y3(toServiceMsg, fromServiceMsg, obj);
        } else if (toServiceMsg.extraData.getBoolean("uint32_do_not_disturb_mode_time", false)) {
            L3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    private void L2(ToServiceMsg toServiceMsg, Bundle bundle, Card card, RespGetVoterList respGetVoterList, StringBuilder sb5, int i3) {
        Iterator<UserProfile> it = respGetVoterList.vVoterInfos.iterator();
        ArrayList arrayList = new ArrayList(0);
        while (it.hasNext()) {
            UserProfile next = it.next();
            CardProfile cardProfile = new CardProfile();
            cardProfile.readFrom(next);
            cardProfile.type = 2;
            arrayList.add(cardProfile);
            if (QLog.isColorLevel() && sb5 != null) {
                sb5.append("\n");
                sb5.append("i=");
                sb5.append(i3);
                sb5.append(",");
                sb5.append(cardProfile.getSimpleZanInfo());
                i3++;
            }
        }
        bundle.putLong("respTime", respGetVoterList.RespTime);
        bundle.putLong("startMid", toServiceMsg.extraData.getLong("nextMid"));
        bundle.putLong("nextMid", respGetVoterList.stUserData.lNextMid);
        bundle.putByteArray("strCookie", respGetVoterList.stUserData.strCookie);
        long j3 = toServiceMsg.extraData.getLong("nextMid", -1L);
        if (j3 == 0) {
            K2(2);
        }
        x5(toServiceMsg.getUin(), arrayList);
        ArrayList arrayList2 = new ArrayList(0);
        if (j3 == 0) {
            ArrayList<UserProfile> arrayList3 = respGetVoterList.vTodayFavoriteInfos;
            if (arrayList3 != null) {
                Iterator<UserProfile> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Long.valueOf(it5.next().lEctID));
                }
            }
            S4(arrayList2);
        }
        notifyUI(6, true, new Object[]{card, bundle, arrayList, arrayList2, Integer.valueOf(respGetVoterList.iMaxFriendFavoriteCount), Integer.valueOf(respGetVoterList.iMaxStrangerFavoriteCount), Integer.valueOf(respGetVoterList.iTodayVoteCount), Integer.valueOf(respGetVoterList.iTodayVoteRank), Integer.valueOf(respGetVoterList.iTotalVoteCount)});
    }

    private void L3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturb success=" + z16);
        }
        String string = toServiceMsg.extraData.getString("source_from", "");
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturb result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() > 0 && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_do_not_disturb_mode_time.has()) {
                            int i3 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_do_not_disturb_mode_time.get();
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturb settingValue=" + i3);
                            }
                            if (i3 >= 0) {
                                SettingCloneUtil.writeValueForInt(this.f194472i.getApplication().getApplicationContext(), null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, i3);
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleGetSelfAddFriendSetting ex", e16);
                    }
                    notifyUI(96, z16, new String[]{"", string});
                    return;
                }
            } catch (Throwable th5) {
                notifyUI(96, z16, new String[]{"", string});
                throw th5;
            }
        }
        notifyUI(96, z16, new String[]{"", string});
    }

    private void L4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.extraData.getBoolean("isGetList", false)) {
            s3(toServiceMsg, fromServiceMsg, obj);
        } else {
            Y3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    private void M2(List<im_msg_body$RichText> list, AutoReplyText autoReplyText) {
        if (autoReplyText.getTextId() == Integer.MAX_VALUE) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "setAutoReplyList, filter TEXT_NONE");
            }
        } else {
            im_msg_body$RichText B = com.tencent.mobileqq.service.message.p.B(autoReplyText.getRawText(), null);
            if (B != null) {
                list.add(B);
            }
        }
    }

    private void M4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.extraData.getBoolean("reqFromCardHandler", false)) {
            if (toServiceMsg.extraData.getBoolean("isSetLoginDays", false)) {
                j4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("pcActiveState", false)) {
                m4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("helloLiveMessage", false)) {
                h4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetActivateFriend", false)) {
                W3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("from_send_no_disturb", false)) {
                M3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("from_send_hidden_session", false)) {
                K3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("calltabstate", false)) {
                b4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isGetAntiLost")) {
                X3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false)) {
                a4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetBabyQSwitch")) {
                Z3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false)) {
                k4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("StrangerInviteToGroup", false)) {
                t4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetNotifyOnLikeRankingList", false)) {
                l4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetDisplayThirdQQSwitch", false)) {
                f4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetPartakeLikeRankingList", false)) {
                n4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("isSetCommonSwitchFromDetailInfo", false)) {
                e4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("uint32_req_push_notice_flag", false)) {
                s4(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (toServiceMsg.extraData.getBoolean("tempConversationBlocState", false)) {
                u4(toServiceMsg, fromServiceMsg, obj);
            } else if (toServiceMsg.extraData.getBoolean("tempConversationNewBlockState", false)) {
                v4(toServiceMsg, fromServiceMsg, obj);
            } else if (toServiceMsg.extraData.getBoolean("setPrettyTroopOwnerFlag", false)) {
                p4(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }

    private void N3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Bundle bundle) {
        bundle.putString("uin", String.valueOf(toServiceMsg.extraData.getLong("lToUIN")));
        if (fromServiceMsg.getResultCode() == 1000) {
            notifyUI(23, true, bundle);
        } else {
            notifyUI(23, false, bundle);
        }
    }

    private boolean O2() {
        AppRuntime peekAppRuntime;
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_ZPLAN_UPLOAD_SAVE_DB_SWITCH, true);
            QLog.i("CardHandler", 1, "disableSaveSetting " + isFeatureSwitchEnable);
            return isFeatureSwitchEnable;
        }
        QLog.i("CardHandler", 2, "enableSaveSetting true");
        return true;
    }

    private void O3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        StringBuilder sb5;
        String sb6;
        TMedalWallInfo tMedalWallInfo = null;
        if (QLog.isDevelopLevel()) {
            sb5 = new StringBuilder(300);
            ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("medal_wall_list");
            sb5.append("report list: [");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    MedalID medalID = (MedalID) it.next();
                    if (medalID != null) {
                        sb5.append("(");
                        sb5.append(medalID.f245721d);
                        sb5.append(",");
                        sb5.append(medalID.f245722e);
                        sb5.append("), ");
                    }
                }
            }
            sb5.append("]");
        } else {
            sb5 = null;
        }
        cmd0xac6$RspBody cmd0xac6_rspbody = new cmd0xac6$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xac6_rspbody);
        if (parseOIDBPkg == 0) {
            if (QLog.isDevelopLevel() && sb5 != null) {
                List<cmd0xac6$operate_result> list = cmd0xac6_rspbody.rpt_results.get();
                sb5.append(", result list [");
                if (list != null && list.size() > 0) {
                    for (cmd0xac6$operate_result cmd0xac6_operate_result : list) {
                        if (cmd0xac6_operate_result != null) {
                            sb5.append("(");
                            sb5.append(cmd0xac6_operate_result.uint32_id.get());
                            sb5.append(",");
                            sb5.append(cmd0xac6_operate_result.int32_result.get());
                            sb5.append(",");
                            sb5.append(cmd0xac6_operate_result.str_errmsg.get());
                            sb5.append("), ");
                        }
                    }
                }
                sb5.append("]");
            }
            tMedalWallInfo = new TMedalWallInfo(Integer.MIN_VALUE, cmd0xac6_rspbody.uint32_metal_count.get(), cmd0xac6_rspbody.int32_new_count.get(), cmd0xac6_rspbody.int32_upgrade_count.get(), cmd0xac6_rspbody.str_prompt_params.get());
        }
        boolean z16 = true;
        if (QLog.isDevelopLevel()) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(parseOIDBPkg);
            if (sb5 == null) {
                sb6 = "null";
            } else {
                sb6 = sb5.toString();
            }
            objArr[1] = sb6;
            QLog.i("MedalWallMng", 4, String.format(locale, "handleReportMedalWall result: %s  msg: %s", objArr));
        }
        Card w3 = ((MedalWallMng) this.f194471h.getManager(QQManagerFactory.MEDAL_WALL_MNG)).w(tMedalWallInfo, false);
        if (parseOIDBPkg != 0) {
            z16 = false;
        }
        notifyUI(51, z16, w3);
    }

    public static int P2(Context context) {
        return 640;
    }

    private void P3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        long j3 = toServiceMsg.extraData.getLong("selfUin", 0L);
        long j16 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        int i3 = toServiceMsg.extraData.getInt("type");
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] resultCode = " + fromServiceMsg.getResultCode() + "targetUin:" + j16 + " type:" + i3);
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            RespDeleteVisitorRecord respDeleteVisitorRecord = (RespDeleteVisitorRecord) fromServiceMsg.getAttribute("result");
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] replyCode = " + respDeleteVisitorRecord.stHeader.iReplyCode);
            }
            if (respDeleteVisitorRecord.stHeader.iReplyCode != 0) {
                notifyUI(91, false, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3)});
                return;
            } else {
                notifyUI(91, true, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3)});
                return;
            }
        }
        notifyUI(91, false, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3)});
    }

    public static int Q2(Context context) {
        int i3 = i3(context);
        if (i3 <= 240) {
            return 60;
        }
        if (i3 <= 320) {
            return 100;
        }
        return 160;
    }

    private void Q3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        StringBuilder sb5;
        int i3;
        int i16;
        if (fromServiceMsg.getResultCode() == 1000) {
            Card q16 = ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(toServiceMsg.getUin());
            RespGetFavoriteList respGetFavoriteList = (RespGetFavoriteList) fromServiceMsg.getAttribute("result");
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(1024);
                sb5.append("handleReqFavoriteList log [ ");
            } else {
                sb5 = null;
            }
            if (respGetFavoriteList.stHeader.iReplyCode != 0) {
                ArrayList<CardProfile> S2 = S2(3, 7);
                bundle.putLong("respTime", respGetFavoriteList.RespTime);
                bundle.putLong("nextMid", respGetFavoriteList.stUserData.lNextMid);
                bundle.putByteArray("strCookie", respGetFavoriteList.stUserData.strCookie);
                bundle.putLong("startMid", -1L);
                notifyUI(42, false, new Object[]{q16, bundle, S2});
                i16 = 2;
            } else {
                Iterator<UserProfile> it = respGetFavoriteList.vFavoriteInfos.iterator();
                ArrayList arrayList = new ArrayList(0);
                int i17 = 0;
                while (it.hasNext()) {
                    UserProfile next = it.next();
                    CardProfile cardProfile = new CardProfile();
                    cardProfile.readFrom(next);
                    cardProfile.type = 3;
                    arrayList.add(cardProfile);
                    if (QLog.isColorLevel() && sb5 != null) {
                        sb5.append("\n");
                        sb5.append("i=");
                        sb5.append(i17);
                        sb5.append(",");
                        sb5.append(cardProfile.getSimpleZanInfo());
                        i17++;
                    }
                }
                bundle.putLong("respTime", respGetFavoriteList.RespTime);
                bundle.putLong("startMid", toServiceMsg.extraData.getLong("nextMid"));
                bundle.putLong("nextMid", respGetFavoriteList.stUserData.lNextMid);
                bundle.putByteArray("strCookie", respGetFavoriteList.stUserData.strCookie);
                if (toServiceMsg.extraData.getLong("nextMid", -1L) == 0) {
                    i3 = 3;
                    K2(3);
                } else {
                    i3 = 3;
                }
                w5(toServiceMsg.getUin(), arrayList);
                Object[] objArr = new Object[i3];
                objArr[0] = q16;
                objArr[1] = bundle;
                i16 = 2;
                objArr[2] = arrayList;
                notifyUI(42, true, objArr);
            }
            if (QLog.isColorLevel() && sb5 != null) {
                sb5.append(" ]");
                QLog.i("CardHandler", i16, sb5.toString());
                return;
            }
            return;
        }
        Card q17 = ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(toServiceMsg.getUin());
        bundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[]{q17, bundle, S2(3, 7)});
    }

    private void R3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        oidb_0x7ba$RspBody oidb_0x7ba_rspbody = new oidb_0x7ba$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x7ba_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "[handleReqLikeRankingList] result=" + parseOIDBPkg);
        }
        boolean z16 = false;
        if (parseOIDBPkg == 0) {
            PBRepeatMessageField<oidb_0x7ba$PraiseInfo> pBRepeatMessageField = oidb_0x7ba_rspbody.rpt_info;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
                LikeRankingInfo likeRankingInfo = new LikeRankingInfo();
                oidb_0x7ba$PraiseInfo oidb_0x7ba_praiseinfo = pBRepeatMessageField.get(i3);
                likeRankingInfo.uin = oidb_0x7ba_praiseinfo.uint64_ddwuin.get();
                likeRankingInfo.likeCountOfToday = oidb_0x7ba_praiseinfo.uint32_praise_today_count.get();
                likeRankingInfo.totalLikeCount = oidb_0x7ba_praiseinfo.uint32_praise_total_count.get();
                likeRankingInfo.rankingNum = oidb_0x7ba_praiseinfo.uint32_rank_number.get();
                arrayList.add(likeRankingInfo);
            }
            Object[] objArr = new Object[4];
            objArr[0] = arrayList;
            objArr[1] = Integer.valueOf(oidb_0x7ba_rspbody.uint32_next_index.get());
            if (oidb_0x7ba_rspbody.uint32_complete.get() == 1) {
                z16 = true;
            }
            objArr[2] = Boolean.valueOf(z16);
            objArr[3] = bundle.getString("uin");
            notifyUI(76, true, objArr);
            return;
        }
        notifyUI(76, false, bundle.getString("uin"));
    }

    private void S3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "[handleReqVoterList] resultCode = " + fromServiceMsg.getResultCode());
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            T3(toServiceMsg, fromServiceMsg, bundle);
            return;
        }
        Card q16 = ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(toServiceMsg.getUin());
        bundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[]{q16, bundle, S2(2, 7)});
    }

    private void T3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Bundle bundle) {
        StringBuilder sb5;
        Card q16 = ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(toServiceMsg.getUin());
        RespGetVoterList respGetVoterList = (RespGetVoterList) fromServiceMsg.getAttribute("result");
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "[handleReqVoterList] replyCode = " + respGetVoterList.stHeader.iReplyCode);
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(1024);
            sb5.append("handleReqVoterList log [ ");
        } else {
            sb5 = null;
        }
        if (respGetVoterList.stHeader.iReplyCode != 0) {
            ArrayList<CardProfile> S2 = S2(2, 7);
            bundle.putLong("respTime", respGetVoterList.RespTime);
            bundle.putLong("nextMid", respGetVoterList.stUserData.lNextMid);
            bundle.putByteArray("strCookie", respGetVoterList.stUserData.strCookie);
            bundle.putLong("startMid", -1L);
            notifyUI(6, false, new Object[]{q16, bundle, S2});
        } else {
            L2(toServiceMsg, bundle, q16, respGetVoterList, sb5, 0);
        }
        if (QLog.isColorLevel() && sb5 != null) {
            sb5.append(" ]");
            QLog.i("CardHandler", 2, sb5.toString());
        }
    }

    private void U3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z17 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "AfterSyncMsg doAfterLogin&doOnReconnect::handleSendGlobalRingIdRequestResp success=" + z16);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() != 0) {
                    z17 = false;
                }
                String str = mergeFrom.str_error_msg.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSendGlobalRingIdRequestResp result=" + z17 + " error=" + str);
                }
                x4(z17, mergeFrom);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSendGlobalRingIdRequestResp ex", e16);
                }
            }
        }
    }

    private void V3(FromServiceMsg fromServiceMsg, Bundle bundle) {
        boolean z16;
        if (fromServiceMsg.getResultCode() == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        notifyUI(29, z16, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void W3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch success=" + z16);
        }
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) this.f194471h.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        boolean t16 = activateFriendsManager.t(false);
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch result=" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch result=false;allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(P))) {
                        t16 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        activateFriendsManager.L(t16, false);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch cur:" + this.f194471h.getCurrentAccountUin() + " dwUin:" + P);
                        }
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    z18 = z17;
                    notifyUI(57, z18, Boolean.valueOf(t16));
                }
            }
            z17 = z16;
            if (QLog.isColorLevel()) {
            }
            z18 = z17;
            notifyUI(57, z18, Boolean.valueOf(t16));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetActivateFriendSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            throw th5;
        }
    }

    private short X2(short s16, boolean z16) {
        if (!((TempMsgManager) this.f194471h.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).W(s16)) {
            return z16 ? (short) 1 : (short) 0;
        }
        if (z16) {
            return (short) 1;
        }
        return (short) 2;
    }

    private void X3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetAntilostState success=" + z16);
        }
    }

    private void Y3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_cmd0xcd5$RspBody oidb_cmd0xcd5_rspbody = new oidb_cmd0xcd5$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xcd5_rspbody);
        boolean z17 = toServiceMsg.extraData.getBoolean("needNotify");
        if (parseOIDBPkg == 0 && oidb_cmd0xcd5_rspbody.setdata_rsp.has()) {
            ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("replyMsgList");
            int i3 = toServiceMsg.extraData.getInt("selectId");
            com.tencent.mobileqq.onlinestatus.manager.b bVar = (com.tencent.mobileqq.onlinestatus.manager.b) ((IOnlineStatusManagerService) this.f194471h.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.b.class);
            if (bVar != null) {
                bVar.e(parcelableArrayList, i3);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetAutoReplyList, result = " + parseOIDBPkg);
        }
        if (z17) {
            notifyUI(97, z16, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Z3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch result=" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 += 4294967296L;
                    }
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                        Card q16 = friendsManager.q(AppConstants.BABY_Q_UIN);
                        q16.babyQSwitch = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        friendsManager.p0(q16);
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    z16 = z17;
                    notifyUI(72, z16, Boolean.valueOf(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)));
                }
            }
            z17 = z16;
            if (QLog.isColorLevel()) {
            }
            z16 = z17;
            notifyUI(72, z16, Boolean.valueOf(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetBabyQSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCalReactiveSwitch success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCalReactiveSwitch result=" + z16);
                    }
                } catch (Exception e16) {
                    e = e16;
                    z17 = z16;
                } catch (Throwable th5) {
                    th = th5;
                    z17 = z16;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCalReactiveSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    throw th;
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 += 4294967296L;
                    }
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                        Card q16 = friendsManager.q(this.f194471h.getCurrentAccountUin());
                        q16.allowCalInteractive = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        friendsManager.p0(q16);
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("interactive", 2, "handleSetCalReactiveSwitch allowCalInteractive=" + q16.allowCalInteractive);
                            }
                            if (q16.allowCalInteractive) {
                                friendsManager.Y = 1;
                            } else {
                                friendsManager.Y = 0;
                            }
                            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).writeDisableInteractiveSwitchLocal(q16.allowCalInteractive);
                            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(com.tencent.qqnt.bus.event.p.f353239a);
                            com.tencent.qqnt.lightbusinesskit.a.f();
                            this.f194471h.getApp().getSharedPreferences(this.f194471h.getCurrentAccountUin(), 0).edit().putInt("hotDisableInteractive", friendsManager.Y).commit();
                        } catch (Exception e17) {
                            e = e17;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCalReactiveSwitch ex", e);
                            }
                            if (QLog.isColorLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("handleSetCalReactiveSwitch result=");
                                sb5.append(z17);
                                sb5.append(";allow=");
                                sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                                QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
                            }
                            if (QLog.isColorLevel()) {
                            }
                            notifyUI(71, z17, null);
                            com.tencent.mobileqq.mutualmark.nt.f.f252196a.t();
                        }
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("handleSetCalReactiveSwitch result=");
                        sb5.append(z17);
                        sb5.append(";allow=");
                        sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                        QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("interactive", 2, "handleSetCalReactiveSwitch allowCalInteractive=" + ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.f194471h.getCurrentAccountUin()).allowCalInteractive + "isSuccess=" + z17);
                    }
                    notifyUI(71, z17, null);
                    com.tencent.mobileqq.mutualmark.nt.f.f252196a.t();
                }
            }
            z17 = z16;
            if (QLog.isColorLevel()) {
            }
            if (QLog.isColorLevel()) {
            }
            notifyUI(71, z17, null);
            com.tencent.mobileqq.mutualmark.nt.f.f252196a.t();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCallTabState success=" + z16);
        }
        this.f194471h.getApplication().getString(R.string.cqy);
        this.f194471h.getCurrentAccountUin();
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCallTabState result=" + z16);
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 = (i3 & Integer.MAX_VALUE) | 2147483648L;
                    }
                    toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    if (!this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        try {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCallTabState dwUin!=current," + j3 + "," + this.f194471h.getCurrentAccountUin());
                                }
                                z17 = false;
                            } catch (Throwable th5) {
                                th = th5;
                                if (QLog.isColorLevel()) {
                                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCallTabState result=" + z18 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                                }
                                throw th;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetCallTabState ex", e);
                            }
                            if (QLog.isColorLevel()) {
                                str = "handleSetCallTabState result=" + z18 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                                QLog.d(LogTag.PROFILE_CARD, 2, str);
                            }
                            return;
                        }
                    }
                    z16 = z17;
                }
            } catch (Exception e17) {
                e = e17;
                z18 = z16;
            } catch (Throwable th6) {
                th = th6;
                z18 = z16;
                if (QLog.isColorLevel()) {
                }
                throw th;
            }
        }
        if (QLog.isColorLevel()) {
            str = "handleSetCallTabState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            QLog.d(LogTag.PROFILE_CARD, 2, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        Pair pair;
        boolean z16;
        boolean z17;
        byte[] bArr;
        String str;
        SharedPreferences.Editor edit;
        int i3 = toServiceMsg.extraData.getInt("eSubCmd");
        boolean z18 = false;
        if (i3 != CARDSETTYPE.TYPE_SET_TEMPLATE.value()) {
            QLog.w("CardHandler", 1, String.format("handleSetCard not support cmd, subCmd=%s", Integer.valueOf(i3)));
            return false;
        }
        bundle.putInt("eSubCmd", i3);
        bundle.putByte("bIsSingle", toServiceMsg.extraData.getByte("bIsSingle"));
        bundle.putByteArray("vBackground", toServiceMsg.extraData.getByteArray("vBackground"));
        bundle.putByteArray("vReqSetTemplate", toServiceMsg.extraData.getByteArray("vReqSetTemplate"));
        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (fromServiceMsg.isSuccess()) {
            Object obj2 = null;
            if (obj instanceof RespSetCard) {
                RespSetCard respSetCard = (RespSetCard) obj;
                RespHead respHead = respSetCard.stHeader;
                if (respHead != null && respHead.iReplyCode == 0 && (bArr = respSetCard.vRespSetTemplate) != null) {
                    SSummaryCardRsp sSummaryCardRsp = (SSummaryCardRsp) decodePacket(bArr, "rsp", new SSummaryCardRsp());
                    if (sSummaryCardRsp != null) {
                        VasLogReporter.getProfileCard().reportHighest("receive MCardSvc.ReqSetCard id=" + sSummaryCardRsp.bgid + " cardid=" + sSummaryCardRsp.cardid + " cardType=" + sSummaryCardRsp.cardType + " styleid=" + sSummaryCardRsp.styleid + " bgurl=" + sSummaryCardRsp.bgurl + " strZipUrl=" + sSummaryCardRsp.strZipUrl + " strDrawerCardUrl=" + sSummaryCardRsp.strDrawerCard + " res=" + sSummaryCardRsp.res);
                        if (sSummaryCardRsp.res == 0) {
                            Card r16 = friendsManager.r(this.f194471h.getCurrentAccountUin());
                            if (r16 != null) {
                                r16.lCurrentStyleId = sSummaryCardRsp.styleid;
                                r16.backgroundUrl = sSummaryCardRsp.bgurl;
                                r16.lCurrentBgId = sSummaryCardRsp.bgid;
                                r16.backgroundColor = sSummaryCardRsp.color;
                                r16.dynamicCardFlag = sSummaryCardRsp.dynamicCardFlag;
                                r16.strZipUrl = sSummaryCardRsp.strZipUrl;
                                r16.strActiveUrl = sSummaryCardRsp.strActiveCardUrl;
                                r16.strDrawerCardUrl = sSummaryCardRsp.strDrawerCard;
                                r16.strWzryHeroUrl = sSummaryCardRsp.strWzryHeroUrl;
                                r16.strExtInfo = sSummaryCardRsp.extInfo;
                                r16.cardType = sSummaryCardRsp.cardType;
                                r16.diyDefaultText = sSummaryCardRsp.strDiyDefaultText;
                                cardDiyComplicatedInfo carddiycomplicatedinfo = sSummaryCardRsp.stDiyComplicated;
                                if (carddiycomplicatedinfo == null) {
                                    str = "";
                                } else {
                                    str = carddiycomplicatedinfo.detail;
                                }
                                r16.diyComplicatedInfo = str;
                                r16.cardId = sSummaryCardRsp.cardid;
                                r16.likeAreaId = sSummaryCardRsp.likeAreaID;
                                ArrayList<Integer> arrayList = sSummaryCardRsp.bgtype;
                                if (arrayList != null) {
                                    r16.setBgType(arrayList);
                                }
                                ArrayList<summaryCardWzryInfo> arrayList2 = sSummaryCardRsp.wzryInfo;
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    r16.setWzryHonorInfo(sSummaryCardRsp.wzryInfo);
                                }
                                r16.templateRet = 0;
                                cardDiyTextInfo carddiytextinfo = sSummaryCardRsp.stDiyText;
                                if (carddiytextinfo != null) {
                                    r16.diyTextFontId = carddiytextinfo.iFontId;
                                    r16.diyText = carddiytextinfo.strText;
                                    r16.diyTextScale = carddiytextinfo.fScaling;
                                    r16.diyTextDegree = carddiytextinfo.fRotationAngle;
                                    r16.diyTextTransparency = carddiytextinfo.fTransparency;
                                    if (!TextUtils.isEmpty(carddiytextinfo.strPoint)) {
                                        String[] split = sSummaryCardRsp.stDiyText.strPoint.split("_");
                                        if (split.length == 2) {
                                            try {
                                                r16.diyTextLocX = Float.parseFloat(split[0]);
                                                r16.diyTextLocY = Float.parseFloat(split[1]);
                                            } catch (Exception e16) {
                                                QLog.e("CardHandler", 1, "set card with diy text response", e16);
                                            }
                                        }
                                    }
                                }
                                friendsManager.p0(r16);
                                SharedPreferences preferences = this.f194471h.getPreferences();
                                if (preferences != null && (edit = preferences.edit()) != null) {
                                    edit.putBoolean(AppConstants.Preferences.SVIP_PROFILE_USE_GUIDE_SHOWN_FLAG, false).commit();
                                }
                            }
                            z18 = true;
                            obj2 = r16;
                            pair = null;
                        } else {
                            pair = new Pair(Integer.valueOf(sSummaryCardRsp.res), sSummaryCardRsp);
                        }
                        if (obj2 == null) {
                            obj2 = pair;
                        }
                        notifyUI(41, true, obj2);
                    } else {
                        VasLogReporter.getProfileCard().reportHighest("receive MCardSvc.ReqSetCard error: cardRsp is null");
                    }
                } else {
                    VasLogReportProxy profileCard = VasLogReporter.getProfileCard();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("receive MCardSvc.ReqSetCard error: header: ");
                    if (respSetCard.stHeader == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    sb5.append(", template: ");
                    if (respSetCard.vRespSetTemplate == null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    sb5.append(z17);
                    profileCard.reportHighest(sb5.toString());
                }
            }
            pair = null;
            if (obj2 == null) {
            }
            notifyUI(41, true, obj2);
        } else {
            VasLogReporter.getProfileCard().reportHighest("receive MCardSvc.ReqSetCard error");
            notifyUI(41, false, friendsManager.q(this.f194471h.getCurrentAccountUin()));
            ReportCenter.f().r(fromServiceMsg.getServiceCmd(), 100, fromServiceMsg.getBusinessFailCode(), this.f194471h.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.k_b), true);
        }
        return z18;
    }

    private void d4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        boolean z16;
        boolean z17 = true;
        boolean z18 = toServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f194471h.getApp());
        boolean z19 = false;
        if (fromServiceMsg.isSuccess()) {
            RespSetCardSwitch respSetCardSwitch = (RespSetCardSwitch) obj;
            if (z18) {
                if (respSetCardSwitch.uCloseNeighborVote == 0) {
                    z19 = true;
                }
                ((com.tencent.mobileqq.nearby.a) this.f194471h.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(z19);
            } else {
                if (respSetCardSwitch.uCloseTimeGateVote == 0) {
                    z19 = true;
                }
                defaultSharedPreferences.edit().putBoolean(this.f194471h.getApplication().getString(R.string.cyq) + this.f194471h.getCurrentAccountUin(), z19).commit();
            }
            bundle.putBoolean("modify_switch_for_near_people", z18);
            bundle.putBoolean("target_switch", z19);
            bundle.putString("uin", toServiceMsg.getUin());
            notifyUI(34, true, bundle);
        } else {
            long j3 = toServiceMsg.extraData.getLong("target_value");
            QQAppInterface qQAppInterface = this.f194471h;
            if (j3 != 0) {
                z17 = false;
            }
            if (!qQAppInterface.trySetCardSwitch(z18, z17)) {
                if (z18) {
                    z16 = com.tencent.mobileqq.nearby.h.a(this.f194471h).a();
                } else {
                    z16 = defaultSharedPreferences.getBoolean(this.f194471h.getApplication().getString(R.string.cyq) + this.f194471h.getCurrentAccountUin(), false);
                }
                bundle.putString("uin", toServiceMsg.getUin());
                bundle.putBoolean("current_switch", z16);
                notifyUI(34, false, bundle);
                z19 = z16;
            }
        }
        if (z18) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f194471h.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", fromServiceMsg.isSuccess(), 0L, 0L, null, "response");
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetCardSwitch succuss " + fromServiceMsg.isSuccess() + " forNearPeople:" + z18 + " curSwitch:" + z19);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        short s16 = toServiceMsg.extraData.getShort("switch_id");
        short s17 = toServiceMsg.extraData.getShort("switch_value");
        int i3 = -1;
        try {
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CommonSwitchTag", 2, "handleSetCommonSwitchFromDetailInfo ex", e16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", Boolean.FALSE, Integer.valueOf(i3), Short.valueOf(s16), Short.valueOf(s17)));
                }
                z16 = false;
            }
            if (fromServiceMsg.isSuccess() && obj != null) {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                i3 = mergeFrom.uint32_result.get();
                if (i3 == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i16 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i16;
                    if (i16 < 0) {
                        j3 += 4294967296L;
                    }
                    if (String.valueOf(j3).equals(this.f194471h.getCurrentAccountUin())) {
                        z16 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", Boolean.valueOf(z16), Integer.valueOf(i3), Short.valueOf(s16), Short.valueOf(s17)));
                        }
                        notifyUI(84, z16, new Object[]{Short.valueOf(s16), Short.valueOf(s17)});
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo invalidate account info [dwUin: %d, lUin: %d, account: %s]", Integer.valueOf(i16), Long.valueOf(j3), this.f194471h.getCurrentAccountUin()));
                    }
                }
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
            notifyUI(84, z16, new Object[]{Short.valueOf(s16), Short.valueOf(s17)});
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", Boolean.FALSE, Integer.valueOf(i3), Short.valueOf(s16), Short.valueOf(s17)));
            }
            throw th5;
        }
    }

    public static String f3(String str, int i3) {
        if (str == null || "".equals(str) || !F.contains(Integer.valueOf(i3))) {
            return "";
        }
        return E + i3 + "/" + str + ".jpg";
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp success=" + z16);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp result=" + z16);
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(P))) {
                        boolean z26 = toServiceMsg.extraData.getBoolean("uint32_emotion_recommend_flag");
                        try {
                            ((IStickerRecManager) this.f194471h.getRuntimeService(IStickerRecManager.class)).updateEmotionRecSetting(z26);
                            z19 = z26;
                        } catch (Exception e16) {
                            boolean z27 = z16;
                            z18 = z26;
                            e = e16;
                            z17 = z27;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.e("CardHandler", 1, "handleSetEmotionRecommendSwitchResp ex", e);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp result=false open=" + z18);
                                }
                                notifyUI(102, true, Boolean.valueOf(z18));
                            } catch (Throwable th5) {
                                th = th5;
                                z19 = z18;
                                z16 = z17;
                                if (QLog.isColorLevel()) {
                                    QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp result=" + z16 + " open=" + z19);
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            z19 = z26;
                            th = th6;
                            if (QLog.isColorLevel()) {
                            }
                            throw th;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp cur:" + this.f194471h.getCurrentAccountUin() + " dwUin:" + P);
                    }
                }
            } catch (Exception e17) {
                e = e17;
                z17 = z16;
                z18 = false;
            } catch (Throwable th7) {
                th = th7;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetEmotionRecommendSwitchResp result=" + z16 + " open=" + z19);
        }
        z18 = z19;
        notifyUI(102, true, Boolean.valueOf(z18));
    }

    private void h4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        boolean z17;
        boolean z18;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetHelloLiveMessageState success=" + z16);
        }
        String string = this.f194471h.getApplication().getString(R.string.cqy);
        String currentAccountUin = this.f194471h.getCurrentAccountUin();
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetHelloLiveMessageState result=" + z17);
                    }
                    z16 = J2(z17, mergeFrom);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("handleSetPCActiveState result=");
                sb5.append(z16);
                sb5.append(";allow=");
                sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
            }
            if (z16) {
                z18 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            } else {
                z18 = false;
            }
            notifyUI(85, z16, new Object[]{Boolean.valueOf(z18), string, currentAccountUin});
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            throw th5;
        }
    }

    protected static int i3(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (i3 <= i16) {
            return i16;
        }
        return i3;
    }

    private void i4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        boolean z16;
        if (fromServiceMsg.getResultCode() == 1000 && (obj instanceof SSummaryCardLableRsp)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + z16 + ", data : " + obj);
        }
        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(String.valueOf(toServiceMsg.extraData.getLong("destUin")));
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("labelId"));
        if (z16 && obj != null) {
            SSummaryCardLableRsp sSummaryCardLableRsp = (SSummaryCardLableRsp) obj;
            if (sSummaryCardLableRsp.ret == 0) {
                SUserLabel sUserLabel = sSummaryCardLableRsp.likes;
                if (sUserLabel != null) {
                    q16.setLabelList(sUserLabel.label);
                    friendsManager.p0(q16);
                }
                notifyUI(53, true, new Object[]{q16, Long.valueOf(valueOf.longValue())});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + sSummaryCardLableRsp.ret + ", msg : " + sSummaryCardLableRsp.f25108msg);
            }
            notifyUI(53, false, q16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + fromServiceMsg.getResultCode());
        }
        notifyUI(53, false, q16);
        if (QLog.isColorLevel()) {
            QLog.e("CardHandler", 2, "-->report MM:cmd=" + fromServiceMsg.getServiceCmd() + ",error code=" + fromServiceMsg.getBusinessFailCode() + ",uin=" + this.f194471h.getCurrentAccountUin());
        }
        ReportCenter.f().r(fromServiceMsg.getServiceCmd(), 100, fromServiceMsg.getBusinessFailCode(), this.f194471h.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.k_d), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch success=" + z16);
        }
        if (z16) {
            try {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch result=" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 += 4294967296L;
                    }
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                        Card q16 = friendsManager.q(this.f194471h.getCurrentAccountUin());
                        q16.allowPeopleSee = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        friendsManager.p0(q16);
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    z16 = z17;
                    notifyUI(45, z16, null);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetLoginDaysSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                }
                throw th5;
            }
        }
        z17 = z16;
        if (QLog.isColorLevel()) {
        }
        z16 = z17;
        notifyUI(45, z16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        StringBuilder sb5;
        oidb_sso$OIDBSSOPkg mergeFrom;
        long j3;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch success=" + z16);
        }
        if (z16) {
            try {
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch result=" + z16);
                }
            } catch (Exception e16) {
                e = e16;
                z17 = z16;
            } catch (Throwable th5) {
                th = th5;
                z17 = z16;
            }
            if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                if (i3 < 0) {
                    j3 = i3 + 4294967296L;
                } else {
                    j3 = i3;
                }
                if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                    boolean checkMedalRedPointConfig = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.f194471h);
                    FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    Card q16 = friendsManager.q(this.f194471h.getCurrentAccountUin());
                    q16.medalSwitchDisable = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    friendsManager.p0(q16);
                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + j3, 4).edit();
                    edit.putBoolean("medal_switch_disable", q16.medalSwitchDisable);
                    edit.commit();
                    boolean checkMedalRedPointConfig2 = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.f194471h);
                    if (checkMedalRedPointConfig != checkMedalRedPointConfig2) {
                        ((IUtil) QRoute.api(IUtil.class)).onMedalConfigChanged(this.f194471h, checkMedalRedPointConfig2);
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch medalSwitchDisable=" + q16.medalSwitchDisable);
                        }
                        z17 = true;
                    } catch (Exception e17) {
                        e = e17;
                        z17 = true;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch ex", e);
                            }
                            if (QLog.isColorLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("handleSetMedalSwitch result=");
                                sb5.append(z17);
                                sb5.append(";medalSwitchDisable=");
                                sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                                QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
                            }
                            if (QLog.isColorLevel()) {
                            }
                            notifyUI(74, z17, null);
                        } catch (Throwable th6) {
                            th = th6;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch result=" + z17 + ";medalSwitchDisable=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z17 = true;
                        if (QLog.isColorLevel()) {
                        }
                        throw th;
                    }
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                    sb5.append("handleSetMedalSwitch result=");
                    sb5.append(z17);
                    sb5.append(";medalSwitchDisable=");
                    sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetMedalSwitch medal=" + ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.f194471h.getCurrentAccountUin()).medalSwitchDisable + "isSuccess=" + z17);
                }
                notifyUI(74, z17, null);
            }
        }
        z17 = z16;
        if (QLog.isColorLevel()) {
        }
        if (QLog.isColorLevel()) {
        }
        notifyUI(74, z17, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        oidb_sso$OIDBSSOPkg mergeFrom;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState success=" + z16);
        }
        String string = this.f194471h.getApplication().getString(R.string.cqy);
        String currentAccountUin = this.f194471h.getCurrentAccountUin();
        if (z16) {
            try {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState result=" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    z17 = false;
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 = (i3 & Integer.MAX_VALUE) | 2147483648L;
                    }
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        z17 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        z16 = true;
                    } else {
                        z17 = false;
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    notifyUI(55, z16, new Object[]{Boolean.valueOf(z17), string, currentAccountUin});
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPCActiveState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                }
                throw th5;
            }
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        notifyUI(55, z16, new Object[]{Boolean.valueOf(z17), string, currentAccountUin});
    }

    private void o4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = toServiceMsg.extraData.getBoolean("key_searchable", true);
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                    z17 = false;
                }
                if (z17) {
                    this.f194471h.setPhoneNumSearchable(z18, false);
                }
                z16 = z17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SetPhoneNumSearchable", 2, e16.getMessage());
                }
                z16 = false;
            }
        }
        if (!z16) {
            z18 = this.f194471h.isPhoneNumSearchable(false);
        }
        notifyUI(39, z16, Boolean.valueOf(z18));
    }

    private void p3(FromServiceMsg fromServiceMsg, Bundle bundle) {
        RespClientMsg respClientMsg;
        if (fromServiceMsg.getResultCode() == 1000 && (respClientMsg = (RespClientMsg) fromServiceMsg.getAttribute("result")) != null && 1 == respClientMsg.stMsg.eAccostType) {
            notifyUI(22, true, bundle);
        }
    }

    private void q3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        bundle.putByteArray(PreDownloadConstants.RPORT_KEY_FILE_KEY, toServiceMsg.extraData.getByteArray("filekey"));
        if (fromServiceMsg.isSuccess() && obj != null) {
            RespDelFace respDelFace = (RespDelFace) obj;
            FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Card r16 = friendsManager.r(toServiceMsg.getUin());
            if (r16 == null) {
                r16 = new Card();
                r16.uin = toServiceMsg.getUin();
            }
            bundle.putInt("result", respDelFace.stHeader.iReplyCode);
            int i3 = respDelFace.stHeader.iReplyCode;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    notifyUI(12, false, new Object[]{bundle, r16});
                }
            } else {
                int i16 = respDelFace.uFaceTimeStamp;
                if (i16 > r16.uFaceTimeStamp) {
                    r16.uFaceTimeStamp = i16;
                }
                notifyUI(12, true, new Object[]{bundle, r16});
            }
            friendsManager.p0(r16);
            return;
        }
        bundle.putInt("result", -1);
        notifyUI(12, false, new Object[]{bundle, ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(toServiceMsg.getUin())});
    }

    private void q4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        boolean z16;
        if (fromServiceMsg.getResultCode() == 1000 && (obj instanceof SSummaryCardLableRsp)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + z16 + ", data : " + obj);
        }
        if (z16 && obj != null) {
            SSummaryCardLableRsp sSummaryCardLableRsp = (SSummaryCardLableRsp) obj;
            if (sSummaryCardLableRsp.ret == 0) {
                if (sSummaryCardLableRsp.likes != null) {
                    FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    Card q16 = friendsManager.q(this.f194471h.getCurrentAccountUin());
                    q16.setLabelList(sSummaryCardLableRsp.likes.label);
                    friendsManager.p0(q16);
                }
                notifyUI(52, true, obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + sSummaryCardLableRsp.ret + ", msg : " + sSummaryCardLableRsp.f25108msg);
            }
            notifyUI(52, false, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + fromServiceMsg.getResultCode());
        }
        notifyUI(52, false, obj);
        if (QLog.isColorLevel()) {
            QLog.e("CardHandler", 2, "-->report MM:cmd=" + fromServiceMsg.getServiceCmd() + ",error code=" + fromServiceMsg.getBusinessFailCode() + ",uin=" + this.f194471h.getCurrentAccountUin());
        }
        ReportCenter.f().r(fromServiceMsg.getServiceCmd(), 100, fromServiceMsg.getBusinessFailCode(), this.f194471h.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.k_e), true);
    }

    private void r3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        int i3;
        long j3;
        CardHandler cardHandler;
        String str;
        short s16;
        String str2;
        String str3;
        int i16;
        boolean z16;
        String str4;
        String str5;
        byte b16;
        int i17;
        CardHandler cardHandler2;
        boolean z17;
        Object attribute = fromServiceMsg.getAttribute("result");
        HashMap<String, String> hashMap = new HashMap<>();
        long j16 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        long j17 = toServiceMsg.extraData.getLong("selfUin");
        int i18 = toServiceMsg.extraData.getInt("favoriteSource");
        int i19 = toServiceMsg.extraData.getInt(FloatCacheData.ICOUNT);
        int i26 = toServiceMsg.extraData.getInt("from");
        bundle.putString(IProfileProtocolConst.PARAM_TARGET_UIN, Long.toString(j16));
        bundle.putString("selfUin", Long.toString(j17));
        bundle.putInt("favoriteSource", i18);
        bundle.putInt(FloatCacheData.ICOUNT, i19);
        bundle.putInt("from", i26);
        if (attribute != null && (attribute instanceof RespFavorite)) {
            RespFavorite respFavorite = (RespFavorite) attribute;
            if (respFavorite.stHeader.iReplyCode == 0) {
                hashMap.put("param_FailCode", "0");
                cardHandler2 = this;
                z17 = true;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, "back reqFavorite| result = false," + j16 + ",replyCode=" + respFavorite.stHeader.iReplyCode);
                }
                hashMap.put("param_FailCode", String.valueOf(respFavorite.stHeader.iReplyCode));
                cardHandler2 = this;
                z17 = false;
            }
            i3 = i19;
            j3 = j16;
            StatisticCollector.getInstance(cardHandler2.f194471h.getApp()).collectPerformance(String.valueOf(j17), "profileCardSendFavorite", z17, 0L, 0L, hashMap, "", false);
            cardHandler = cardHandler2;
            z16 = z17;
            str3 = LogTag.PROFILE_CARD;
            i16 = 2;
            s16 = 0;
        } else {
            i3 = i19;
            j3 = j16;
            cardHandler = this;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("back reqFavorite| result = ");
                s16 = 0;
                sb5.append(false);
                sb5.append(",");
                sb5.append(j3);
                sb5.append(",obj is");
                if (attribute != null) {
                    str4 = "not RespFavorite";
                } else {
                    str4 = "null";
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                str = LogTag.PROFILE_CARD;
                QLog.i(str, 2, sb6);
            } else {
                str = LogTag.PROFILE_CARD;
                s16 = 0;
            }
            if (attribute != null) {
                str2 = "-201";
            } else {
                str2 = "-202";
            }
            hashMap.put("param_FailCode", str2);
            str3 = str;
            i16 = 2;
            StatisticCollector.getInstance(cardHandler.f194471h.getApp()).collectPerformance(String.valueOf(j17), "profileCardSendFavorite", false, 0L, 0L, hashMap, "", false);
            z16 = s16 == true ? 1 : 0;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            objArr[s16] = Boolean.valueOf(z16);
            b16 = 1;
            objArr[1] = Long.valueOf(j3);
            objArr[i16] = Integer.valueOf(i3);
            str5 = str3;
            QLog.i(str5, i16, String.format("handleFavorite result=%s targetUin=%s iCount=%s", objArr));
        } else {
            str5 = str3;
            b16 = 1;
        }
        if (z16 && j3 > 0) {
            Card card = (Card) DBMethodProxy.find(cardHandler.f194471h.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) Card.class, j3);
            if (card != null) {
                if (QLog.isColorLevel()) {
                    Object[] objArr2 = new Object[3];
                    objArr2[s16] = Long.valueOf(card.lVoteCount);
                    objArr2[b16] = Byte.valueOf(card.bVoted);
                    objArr2[i16] = Short.valueOf(card.bAvailVoteCnt);
                    QLog.i(str5, i16, String.format("handleFavorite card in db: lVoteCount=%s bVoted=%s bAvailVoteCnt=%s", objArr2));
                }
                i17 = i3;
                card.lVoteCount += i17;
                card.bVoted = b16;
                short s17 = (short) (card.bAvailVoteCnt - i17);
                card.bAvailVoteCnt = s17;
                if (s17 < 0) {
                    card.bAvailVoteCnt = s16;
                }
                ((FriendsManager) cardHandler.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).p0(card);
            } else {
                i17 = i3;
            }
            com.tencent.mobileqq.util.dc.b(cardHandler.f194471h, j3, i17);
        }
        cardHandler.notifyUI(32, z16, bundle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e5, code lost:
    
        if (r8 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e7, code lost:
    
        notifyUI(103, true, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0131, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00eb, code lost:
    
        notifyUI(103, false, java.lang.Boolean.valueOf(!r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
    
        if ((-1) != 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("vip_ptt.CardHandler", 2, "handleSetPttAuToTextOffLineSwitchResp success=" + z16);
        try {
            try {
                if (!z16) {
                    QLog.d("vip_ptt.CardHandler", 2, "handleSetPttAuToTextOffLineSwitchResp msf error=" + fromServiceMsg.getResultCode());
                    notifyUI(103, false, Boolean.valueOf(!toServiceMsg.extraData.getBoolean("uint32_auto_to_text_flag")));
                    return;
                }
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                try {
                    if (mergeFrom.uint32_result.get() == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19 && mergeFrom.bytes_bodybuffer.has()) {
                        QLog.e("vip_ptt.CardHandler", 2, "handleSetPttAuToTextOffLineSwitchResp oidb decode failed:" + mergeFrom.uint32_result.get());
                        notifyUI(103, false, Boolean.valueOf(!toServiceMsg.extraData.getBoolean("uint32_auto_to_text_flag")));
                        return;
                    }
                    cmd0xd8a$RspBody cmd0xd8a_rspbody = new cmd0xd8a$RspBody();
                    cmd0xd8a_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    int i3 = cmd0xd8a_rspbody.uint32_retcode.get();
                    QLog.e("vip_ptt.CardHandler", 1, "handleSetPttAuToTextOffLineSwitchResp errorCode=" + i3 + " error msg=" + cmd0xd8a_rspbody.str_res.get());
                    z18 = toServiceMsg.extraData.getBoolean("uint32_auto_to_text_flag");
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    z17 = true;
                    if (z17) {
                        QLog.e("vip_ptt.CardHandler", 1, "handleSetPttAuToTextOffLineSwitchResp ex:" + e);
                    } else {
                        QLog.e("vip_ptt.CardHandler", 1, "handleSetPttAuToTextOffLineSwitchResp oidb ex:" + e);
                    }
                    z18 = toServiceMsg.extraData.getBoolean("uint32_auto_to_text_flag");
                }
            } catch (Throwable th5) {
                boolean z26 = toServiceMsg.extraData.getBoolean("uint32_auto_to_text_flag");
                if (-1 != 0) {
                    notifyUI(103, false, Boolean.valueOf(!z26));
                } else {
                    notifyUI(103, true, null);
                }
                throw th5;
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e = e17;
            z17 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0102 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        oidb_cmd0xcd5$GetDataRsp oidb_cmd0xcd5_getdatarsp;
        com.tencent.mobileqq.onlinestatus.manager.b bVar;
        oidb_cmd0xcd5$RspBody oidb_cmd0xcd5_rspbody = new oidb_cmd0xcd5$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xcd5_rspbody);
        ArrayList arrayList = new ArrayList();
        if (parseOIDBPkg == 0) {
            try {
                oidb_cmd0xcd5_getdatarsp = oidb_cmd0xcd5_rspbody.getdata_rsp.get();
            } catch (Exception e16) {
                e = e16;
                i3 = 0;
                z16 = true;
            }
            if (oidb_cmd0xcd5_getdatarsp != null && oidb_cmd0xcd5_getdatarsp.pb_data.has()) {
                byte[] byteArray = oidb_cmd0xcd5_getdatarsp.pb_data.get().toByteArray();
                wording_storage$WordingCfg wording_storage_wordingcfg = new wording_storage$WordingCfg();
                wording_storage_wordingcfg.mergeFrom(byteArray);
                if (wording_storage_wordingcfg.select_id.has()) {
                    i16 = wording_storage_wordingcfg.select_id.get();
                } else {
                    i16 = 0;
                }
                try {
                    if (wording_storage_wordingcfg.auto_reply_flag.get() == 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    try {
                        List<im_msg_body$RichText> list = wording_storage_wordingcfg.wording_list.get();
                        if (list != null) {
                            Iterator<im_msg_body$RichText> it = list.iterator();
                            int i17 = 0;
                            while (it.hasNext()) {
                                List<im_msg_body$Elem> list2 = it.next().elems.get();
                                if (list2 != null && list2.size() > 0) {
                                    String e17 = new com.tencent.mobileqq.service.message.o().e1(list2);
                                    if (!TextUtils.isEmpty(e17)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("CardHandler", 2, "handleGetAutoReplyList, parse richText: " + e17 + ", id: " + i17);
                                        }
                                        int i18 = i17 + 1;
                                        arrayList.add(new AutoReplyText(e17, i17));
                                        i17 = i18;
                                    }
                                }
                            }
                        }
                        z17 = true;
                    } catch (Exception e18) {
                        e = e18;
                        Exception exc = e;
                        i3 = i16;
                        e = exc;
                        e.printStackTrace();
                        QLog.e("CardHandler", 1, "handleGetAutoReplyList exception: " + e.getMessage());
                        i16 = i3;
                        z17 = false;
                        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.k_c), Integer.MAX_VALUE));
                        int size = arrayList.size();
                        if (!z16) {
                        }
                        i16 = Integer.MAX_VALUE;
                        if (z17) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        notifyUI(95, z17, new Object[]{arrayList, Integer.valueOf(i16)});
                    }
                } catch (Exception e19) {
                    e = e19;
                    z16 = true;
                }
                arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.k_c), Integer.MAX_VALUE));
                int size2 = arrayList.size();
                if (!z16 && size2 > 1) {
                    if (i16 < 0 || i16 >= size2) {
                        QLog.d("CardHandler", 1, "handleGetAutoReplyList, error select id: " + i16);
                        i16 = 0;
                    }
                } else {
                    i16 = Integer.MAX_VALUE;
                }
                if (z17 && (bVar = (com.tencent.mobileqq.onlinestatus.manager.b) ((IOnlineStatusManagerService) this.f194471h.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.b.class)) != null) {
                    bVar.e(arrayList, i16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, String.format("handleGetAutoReplyList result: %s, isSuccess: %s, enableAutoReply: %s, replyList size: %s, selectId: %s", Integer.valueOf(parseOIDBPkg), Boolean.valueOf(z17), Boolean.valueOf(z16), Integer.valueOf(size2), Integer.valueOf(i16)));
                }
                notifyUI(95, z17, new Object[]{arrayList, Integer.valueOf(i16)});
            }
        }
        i16 = 0;
        z17 = false;
        z16 = true;
        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.k_c), Integer.MAX_VALUE));
        int size22 = arrayList.size();
        if (!z16) {
        }
        i16 = Integer.MAX_VALUE;
        if (z17) {
            bVar.e(arrayList, i16);
        }
        if (QLog.isColorLevel()) {
        }
        notifyUI(95, z17, new Object[]{arrayList, Integer.valueOf(i16)});
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z18;
        boolean z19 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetShowPushNotice success=" + z16);
        }
        if (z16) {
            try {
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetShowPushNotice result=" + z16);
                }
            } catch (Exception e16) {
                e = e16;
                z19 = z16;
                z17 = true;
            }
            if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                long j3 = i3;
                if (i3 < 0) {
                    j3 += 4294967296L;
                }
                if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                    z18 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetShowPushNotice show=" + z18);
                        }
                        QLog.d("PushNotise", 2, "handleSetShowPushNotice show=" + z18);
                    } catch (Exception e17) {
                        z17 = z18;
                        e = e17;
                        QLog.e(LogTag.PROFILE_CARD, 2, e, new Object[0]);
                        if (QLog.isColorLevel()) {
                        }
                        notifyUI(90, z19, Boolean.valueOf(z17));
                    }
                } else {
                    z18 = true;
                    z19 = false;
                }
                z17 = z18;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetShowPushNotice show=" + z17 + "isSuccess=" + z19);
                }
                notifyUI(90, z19, Boolean.valueOf(z17));
            }
        }
        z18 = true;
        z19 = z16;
        z17 = z18;
        if (QLog.isColorLevel()) {
        }
        notifyUI(90, z19, Boolean.valueOf(z17));
    }

    private void t3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        oidb_0xc33$RspBody oidb_0xc33_rspbody = new oidb_0xc33$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xc33_rspbody);
        boolean z18 = false;
        int i3 = 300;
        if (parseOIDBPkg == 0) {
            if (oidb_0xc33_rspbody.uint32_result.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            int i16 = oidb_0xc33_rspbody.uint32_next_gap.get();
            if (oidb_0xc33_rspbody.uint32_new_user.get() > 0) {
                z18 = true;
            }
            if (i16 > 0) {
                i3 = i16;
            }
            if (toServiceMsg != null && TextUtils.equals(this.f194471h.getCurrentUin(), toServiceMsg.getUin())) {
                ((CTEntryMng) this.f194471h.getManager(QQManagerFactory.CTENTRY_MNG)).K(z17, i3, z18);
            }
            z16 = z18;
            z18 = z17;
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("CardHandler", 4, "handleGetBindPhoneSwitchInfo needShow:" + z18 + " net_gap:" + i3 + " isNewUser:" + z16 + " uin:" + this.f194471h.getCurrentUin() + "  result:" + parseOIDBPkg);
        }
    }

    private void t4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetStrangerInviteToGroupSwitch success=" + z16);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() != 0) {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetStrangerInviteToGroupSwitch result=" + z17);
                }
                if (D4(toServiceMsg, z17, mergeFrom)) {
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleSetStrangerInviteToGroupSwitch ex", e16);
                }
            }
        }
        notifyUI(93, false, null);
    }

    private boolean t5() {
        SharedPreferences preferences = this.f194471h.getPreferences();
        long j3 = preferences.getLong(this.f194471h.getCurrentUin() + "sign_in_last_get_time", 0L);
        long j16 = preferences.getLong(this.f194471h.getCurrentUin() + "sign_in_next_get_time", 0L);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "shouldGetSignInInfo, last=" + j3 + ", next=" + j16 + ", now=" + serverTimeMillis);
        }
        if (Math.abs(serverTimeMillis - j3) <= 600000) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "shouldGetSignInInfo, <10min");
            }
            return false;
        }
        if (serverTimeMillis < j16) {
            return false;
        }
        preferences.edit().putLong(this.f194471h.getCurrentUin() + "sign_in_last_get_time", serverTimeMillis).commit();
        return true;
    }

    private void u3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, Bundle bundle) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (fromServiceMsg.isSuccess()) {
            RespGetCardSwitch respGetCardSwitch = (RespGetCardSwitch) obj;
            long j3 = respGetCardSwitch.uCloseNeighborVote;
            long j16 = respGetCardSwitch.uCloseTimeGateVote;
            if (j3 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            com.tencent.mobileqq.nearby.a aVar = (com.tencent.mobileqq.nearby.a) this.f194471h.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
            if (j3 == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.b(z18);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f194471h.getApp()).edit();
            String str = this.f194471h.getApplication().getString(R.string.cyq) + this.f194471h.getCurrentAccountUin();
            if (j16 == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            edit.putBoolean(str, z19).commit();
            bundle.putLong("uCloseNeighborVote", j3);
            bundle.putLong("uColseTimeEntityManager", j16);
            bundle.putString("uin", toServiceMsg.getUin());
            notifyUI(33, true, bundle);
            z16 = z17;
        } else {
            bundle.putString("uin", toServiceMsg.getUin());
            notifyUI(33, false, bundle);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetCardSwitches succuss " + fromServiceMsg.isSuccess() + " curSwitch:" + z16);
        }
    }

    private void u4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetTempConversationBlocState success=" + z16);
        }
        boolean z17 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        ((TempMsgManager) this.f194471h.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).R(toServiceMsg.extraData.getShort("type"), y4(toServiceMsg, (byte[]) obj, z16), this.f194471h.getApplication().getString(R.string.cqy), z17);
    }

    private boolean u5() {
        SharedPreferences preferences = this.f194471h.getPreferences();
        long j3 = preferences.getLong(this.f194471h.getCurrentUin() + "sign_in_operation_time_stamp", 0L);
        long j16 = preferences.getLong(this.f194471h.getCurrentUin() + "sign_in_operation_time_refresh", 0L) * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "shouldResuestSignOperate, last=" + j3 + ", interval=" + j16 + ", now=" + serverTimeMillis);
        }
        long j17 = serverTimeMillis - j3;
        if (Math.abs(j17) <= 600000) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "shouldResuestSignOperate, <10min");
            }
            return false;
        }
        if (j17 < j16) {
            return false;
        }
        preferences.edit().putLong(this.f194471h.getCurrentUin() + "sign_in_operation_time_stamp", serverTimeMillis).commit();
        return true;
    }

    private void v3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        long longValue = ((Long) toServiceMsg.getAttribute("uin", 0L)).longValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("isSelf", Boolean.TRUE)).booleanValue();
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetEducationList " + longValue);
        }
        oidb_cmd0xd2d$RspBody oidb_cmd0xd2d_rspbody = new oidb_cmd0xd2d$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xd2d_rspbody);
        if (parseOIDBPkg == 0) {
            ArrayList<com.tencent.mobileqq.profile.i> arrayList = new ArrayList<>(5);
            if (oidb_cmd0xd2d_rspbody.msg_edu_his.has()) {
                oidb_cmd0xd2d$EduHis oidb_cmd0xd2d_eduhis = oidb_cmd0xd2d_rspbody.msg_edu_his.get();
                if (oidb_cmd0xd2d_eduhis.rpt_msg_school.has()) {
                    for (oidb_cmd0xd2d$SchoolInfo oidb_cmd0xd2d_schoolinfo : oidb_cmd0xd2d_eduhis.rpt_msg_school.get()) {
                        com.tencent.mobileqq.profile.i iVar = new com.tencent.mobileqq.profile.i();
                        iVar.f260182a = oidb_cmd0xd2d_schoolinfo.uint32_idx.get();
                        iVar.f260186e = oidb_cmd0xd2d_schoolinfo.str_department_id.get();
                        iVar.f260187f = oidb_cmd0xd2d_schoolinfo.str_department_name.get();
                        iVar.f260184c = oidb_cmd0xd2d_schoolinfo.str_school_id.get();
                        iVar.f260185d = oidb_cmd0xd2d_schoolinfo.str_school_name.get();
                        iVar.f260183b = oidb_cmd0xd2d_schoolinfo.uint32_category.get();
                        iVar.f260188g = oidb_cmd0xd2d_schoolinfo.uint32_degree.get();
                        iVar.f260189h = oidb_cmd0xd2d_schoolinfo.uint32_enrollment_year.get();
                        iVar.f260190i = oidb_cmd0xd2d_schoolinfo.uint32_graduation_year.get();
                        iVar.f260191j = oidb_cmd0xd2d_schoolinfo.uint32_allow_recommend.get();
                        if (oidb_cmd0xd2d_schoolinfo.uint32_hidden_flag.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        iVar.f260192k = z16;
                        if (oidb_cmd0xd2d_schoolinfo.uint32_verify_status.get() == 2) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        iVar.f260193l = z17;
                        arrayList.add(iVar);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "handleGetEducationList " + arrayList.toString());
            }
            if (booleanValue) {
                ((BusinessCardManager) this.f194471h.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).v(arrayList);
            }
            notifyUI(99, true, new Object[]{Long.valueOf(longValue), arrayList});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "handleGetEducationList failed result:" + parseOIDBPkg);
        }
        notifyUI(99, false, new Object[]{Long.valueOf(longValue), null});
    }

    private void v4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleSetTempConversationInBoxState success=" + z16);
        }
        boolean z17 = toServiceMsg.extraData.getBoolean("blockSwitch");
        boolean z18 = toServiceMsg.extraData.getBoolean("inBoxSwitch");
        ((TempMsgManager) this.f194471h.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).Q(toServiceMsg.extraData.getShort("type"), y4(toServiceMsg, (byte[]) obj, z16), this.f194471h.getApplication().getString(R.string.cqy), z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v5() {
        synchronized (this.f194468d) {
            if (this.f194468d.size() == 0) {
                notifyUI(69, false, new Object[]{""});
                return;
            }
            String remove = this.f194468d.remove(0);
            if (TextUtils.isEmpty(remove)) {
                notifyUI(69, false, new Object[]{""});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "uploadPhotoWall filePath:" + remove);
            }
            PhotoWallUploadTask photoWallUploadTask = new PhotoWallUploadTask(remove);
            photoWallUploadTask.flowId = ((int) System.currentTimeMillis()) / 1000;
            photoWallUploadTask.sRefer = "mqq";
            photoWallUploadTask.iUin = Long.parseLong(this.f194471h.getCurrentAccountUin());
            photoWallUploadTask.vLoginData = com.tencent.mobileqq.profile.upload.a.d(this.f194471h);
            photoWallUploadTask.f383923op = 1;
            photoWallUploadTask.source = 1;
            photoWallUploadTask.uploadTaskCallback = new a();
            photoWallUploadTask.uploadFilePath = remove;
            photoWallUploadTask.md5 = com.tencent.mobileqq.profile.upload.a.a(remove);
            photoWallUploadTask.autoRotate = true;
            b bVar = new b(Long.parseLong(this.f194471h.getCurrentAccountUin()));
            UploadEnv uploadEnv = new UploadEnv();
            if (!UploadServiceBuilder.getInstance().isInitialized()) {
                UploadServiceBuilder.getInstance().init(this.f194471h.getApp().getApplicationContext(), bVar, null, null, uploadEnv, uploadEnv);
            }
            UploadServiceBuilder.getInstance().upload(photoWallUploadTask);
        }
    }

    private void w3(FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        cmd0x7a8$RspBody cmd0x7a8_rspbody = new cmd0x7a8$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x7a8_rspbody);
        boolean z16 = false;
        if (parseOIDBPkg == 0) {
            i3 = cmd0x7a8_rspbody.uint32_metal_count.get();
        } else {
            i3 = 0;
        }
        if (parseOIDBPkg == 0) {
            z16 = true;
        }
        notifyUI(121, z16, Integer.valueOf(i3));
    }

    private void x3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception e16;
        String str;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z17 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetKPLInfo success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() != 0) {
                        z17 = false;
                    }
                } catch (Exception e17) {
                    z17 = z16;
                    e16 = e17;
                } catch (Throwable th5) {
                    z17 = z16;
                    th = th5;
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + z17);
                    }
                    throw th;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + z17);
                    }
                    if (z17 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0xa28$RspBody oidb_0xa28_rspbody = new oidb_0xa28$RspBody();
                        oidb_0xa28_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        KplCard parseProto = KplCard.parseProto(oidb_0xa28_rspbody, this.C);
                        ((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).H0(parseProto);
                        notifyUI(88, z17, parseProto);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetKPLInfo failed:" + mergeFrom.uint32_result.get());
                    }
                    z16 = z17;
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d("CardHandler", 2, "handleGetKPLInfo ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        str = "handleGetKPLInfo result=" + z17;
                        QLog.d("CardHandler", 2, str);
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                str = "handleGetKPLInfo result=" + z16;
                QLog.d("CardHandler", 2, str);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void x4(boolean z16, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws InvalidProtocolBufferMicroException {
        if (z16 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
            oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() > 0 && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_req_global_ring_id.has()) {
                int i3 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_req_global_ring_id.get();
                if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handleSendGlobalRingIdRequestResp: invoked. ", " ringId: ", Integer.valueOf(i3));
                }
                if (i3 > 0) {
                    MessageNotificationSettingManager.l(this.f194471h).R(i3);
                }
            }
        }
    }

    private void x5(String str, List<CardProfile> list) {
        w5(str, list);
    }

    private void y3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleGetMedalSwitch success=" + z16);
        }
        String currentUin = this.f194471h.getCurrentUin();
        FriendsManager friendsManager = (FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(currentUin);
        if (z16) {
            try {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleGetMedalSwitch result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() > 0) {
                            boolean checkMedalRedPointConfig = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.f194471h);
                            if (oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0).uint32_req_medalwall_flag.get() == 0) {
                                z17 = false;
                            }
                            q16.medalSwitchDisable = z17;
                            friendsManager.p0(q16);
                            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + currentUin, 4).edit();
                            edit.putBoolean("medal_switch_disable", q16.medalSwitchDisable);
                            edit.commit();
                            boolean checkMedalRedPointConfig2 = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.f194471h);
                            if (checkMedalRedPointConfig != checkMedalRedPointConfig2) {
                                ((IUtil) QRoute.api(IUtil.class)).onMedalConfigChanged(this.f194471h, checkMedalRedPointConfig2);
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleGetMedalSwitch ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            } finally {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "handleGetMedalSwitch result=" + z16 + ";medal=" + q16.medalSwitchDisable);
                }
            }
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("handleGetMedalSwitch result=");
            sb5.append(z16);
            sb5.append(";medal=");
            sb5.append(q16.medalSwitchDisable);
            QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
        }
        notifyUI(75, z16, Boolean.valueOf(q16.medalSwitchDisable));
    }

    private boolean y4(ToServiceMsg toServiceMsg, byte[] bArr, boolean z16) {
        StringBuilder sb5;
        boolean z17;
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetTempConversationBlocState result=" + z17);
                    }
                    z16 = J2(z17, mergeFrom);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetTempConversationBlocState ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("handleSetTempConversationBlocState result=");
                sb5.append(z16);
                sb5.append(";allow=");
                sb5.append(toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
            }
            return z16;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetTempConversationBlocState result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            throw th5;
        }
    }

    private void z3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string = toServiceMsg.extraData.getString("from");
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", string));
        }
        if ("getSelfNewObtainedMedalWall".equals(string)) {
            F3(fromServiceMsg, obj);
        } else if ("getGuestMedalWall".equals(string)) {
            w3(fromServiceMsg, obj);
        }
    }

    public void A5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mLocalPath = str;
        transferRequest.mIsUp = true;
        transferRequest.mPeerUin = this.f194472i.getCurrentAccountUin();
        transferRequest.mUniseq = 0L;
        transferRequest.mFileType = 35;
        transferRequest.mRichTag = StatisticCollector.PROFILE_COVER_PIC_UPLOAD_STATISTIC_TAG;
        ITransFileController iTransFileController = this.f194470f;
        if (iTransFileController != null) {
            iTransFileController.transferAsync(transferRequest);
        }
    }

    public void B5(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList == null) {
            return;
        }
        synchronized (this.f194468d) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f194468d.add(it.next());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "uploadPhotoWall size:" + arrayList.size());
        }
        this.f194471h.execute(new Runnable() { // from class: com.tencent.mobileqq.app.CardHandler.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CardHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    CardHandler.this.v5();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    public c G2(QQAppInterface qQAppInterface, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (c) iPatchRedirector.redirect((short) 34, (Object) this, (Object) qQAppInterface, (Object) dVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, String.format("addCoverTransCallback app=%s callBack=%s", qQAppInterface, dVar));
        }
        if (this.f194470f == null) {
            this.f194470f = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
        }
        c cVar = new c(dVar);
        cVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        this.f194470f.addHandle(cVar);
        return cVar;
    }

    public void H4(PushVoteIncreaseInfo pushVoteIncreaseInfo, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, pushVoteIncreaseInfo, str, str2);
            return;
        }
        Visitor visitor = pushVoteIncreaseInfo.vVoterList.get(0);
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        d16.frienduin = AppConstants.VOTE_MSG_UIN;
        d16.istroop = 0;
        d16.senderuin = String.valueOf(visitor.lUIN);
        d16.extraflag = pushVoteIncreaseInfo.iIncrement;
        d16.time = System.currentTimeMillis() / 1000;
        ThreadManagerV2.post(new Runnable(pushVoteIncreaseInfo.iIncrement) { // from class: com.tencent.mobileqq.app.CardHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f194474d;

            {
                this.f194474d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CardHandler.this, r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String currentAccountUin = CardHandler.this.f194471h.getCurrentAccountUin();
                FriendsManager friendsManager = (FriendsManager) CardHandler.this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Card r16 = friendsManager.r(currentAccountUin);
                if (r16 != null) {
                    r16.iVoteIncrement = this.f194474d;
                    friendsManager.p0(r16);
                }
            }
        }, 8, null, false);
        try {
            str3 = new String(visitor.vecNick, "UTF8");
        } catch (UnsupportedEncodingException unused) {
            if (QLog.isColorLevel()) {
                QLog.w("accost", 2, "last voter's name. unsupported encoding.");
            }
            str3 = "";
        }
        if (str3.trim().length() == 0) {
            str3 = String.valueOf(visitor.lUIN);
        }
        if (1 == pushVoteIncreaseInfo.iIncrement) {
            d16.f203106msg = String.format(this.f194471h.getApp().getApplicationContext().getString(R.string.bba), str3);
        } else {
            d16.f203106msg = String.format(this.f194471h.getApp().getApplicationContext().getString(R.string.bb_), str3, Integer.valueOf(pushVoteIncreaseInfo.iIncrement));
        }
        this.f194471h.getMessageFacade().c(d16, str);
        this.f194471h.handleReceivedMessage(1, true, true);
        Bundle bundle = new Bundle();
        bundle.putInt("newVoteCount", pushVoteIncreaseInfo.iIncrement);
        bundle.putString("sender", str2);
        bundle.putString("voteeUin", str);
        bundle.putString("uin", str);
        notifyUI(28, true, new Object[]{((FriendsManager) this.f194471h.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.f194471h.getCurrentAccountUin()), bundle});
    }

    public void I3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        Oidb_0x66b$RspBody oidb_0x66b$RspBody = new Oidb_0x66b$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x66b$RspBody);
        if (QLog.isColorLevel()) {
            QLog.d("NewNearbyMyTab", 2, "handleGetSimpleNearbyMyTab, result=" + parseOIDBPkg);
        }
        if (parseOIDBPkg == 0) {
            if (oidb_0x66b$RspBody.stPansocialInfo.has()) {
                ((ay) this.f194471h.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(oidb_0x66b$RspBody.stPansocialInfo.get().uint32_charmlevel.get());
                return;
            }
            return;
        }
        notifyUI(65, false, null);
    }

    public void I4(long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(j3), "MCardSvc.ReqPicSafetyCheck");
        toServiceMsg.extraData.putLong("selfUin", j3);
        toServiceMsg.extraData.putLong("lToUIN", j16);
        toServiceMsg.extraData.putLong("friendUin", j16);
        toServiceMsg.extraData.putInt("iScene", i3);
        send(toServiceMsg);
    }

    public void K2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        EntityManager createEntityManager = this.f194471h.getEntityManagerFactory().createEntityManager();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ExecSQLTransaction("delete from " + ((CardProfile) CardProfile.class.newInstance()).getTableName() + " where type=" + i3 + ";"));
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("CardHandler", 2, e16.getMessage(), e16);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        oidb_sso$OIDBSSOPkg mergeFrom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = toServiceMsg.extraData.getInt("hidden_session_switch", 0);
        int i16 = toServiceMsg.extraData.getInt("type", 0);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSessionRes success=" + z16 + " type=" + i16 + " open=" + i3);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSessionRes result=" + z16);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSessionRes ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(P))) {
                        if (i3 >= 0) {
                            if (i16 == 42318) {
                                String currentUin = this.f194471h.getCurrentUin();
                                Context applicationContext = this.f194471h.getApp().getApplicationContext();
                                if (i3 == 1) {
                                    z17 = false;
                                }
                                com.tencent.mobileqq.app.hiddenchat.b.e(currentUin, applicationContext, z17);
                            } else if (i16 == 42319) {
                                String currentUin2 = this.f194471h.getCurrentUin();
                                Context applicationContext2 = this.f194471h.getApp().getApplicationContext();
                                if (i3 == 1) {
                                    z17 = false;
                                }
                                com.tencent.mobileqq.app.hiddenchat.b.f(currentUin2, applicationContext2, z17);
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSessionRes cur:" + this.f194471h.getCurrentAccountUin() + " dwUin:" + P);
                        }
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("handleHiddenSessionRes result=");
                            sb5.append(z18);
                            sb5.append(";open=");
                            sb5.append(i3);
                            sb5.append(" type=");
                            sb5.append(i16);
                            QLog.d(LogTag.PROFILE_CARD, 2, sb5.toString());
                        }
                        notifyUI(105, z18, Integer.valueOf(i16));
                    }
                }
            }
            z18 = z16;
            if (QLog.isColorLevel()) {
            }
            notifyUI(105, z18, Integer.valueOf(i16));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleHiddenSessionRes result=" + z16 + ";open=" + i3 + " type=" + i16);
            }
            notifyUI(105, z16, Integer.valueOf(i16));
            throw th5;
        }
    }

    public void M3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes success=" + z16);
        }
        String string = toServiceMsg.extraData.getString("no_disturb_last_time", "");
        String string2 = toServiceMsg.extraData.getString("source_from", "");
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes result=" + z16);
                    }
                    if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        long P = Utils.P(ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt());
                        if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(P))) {
                            int i3 = toServiceMsg.extraData.getInt("no_disturb_time", Integer.MAX_VALUE);
                            if (i3 >= 0) {
                                SettingCloneUtil.writeValueForInt(this.f194472i.getApplication().getApplicationContext(), null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, i3);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes cur:" + this.f194471h.getCurrentAccountUin() + " dwUin:" + P);
                            }
                            z16 = false;
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes result=false;allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    notifyUI(94, false, new String[]{string, string2});
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            notifyUI(94, z16, new String[]{string, string2});
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleNotDisturbRes result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            notifyUI(94, z16, new String[]{string, string2});
            throw th5;
        }
    }

    public void N2(String str, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Long.valueOf(j3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "deleteLbsPortrait() uin = " + str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194471h.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
        toServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.f194471h.getCurrentAccountUin()));
        toServiceMsg.extraData.putByteArray("filekey", bArr);
        toServiceMsg.extraData.putLong("timestamp", j3);
        toServiceMsg.extraData.putString("touin", str);
        send(toServiceMsg);
    }

    public void N4(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, String.format("removeCoverTransCallback transHandler=%s", cVar));
        }
        ITransFileController iTransFileController = this.f194470f;
        if (iTransFileController != null) {
            iTransFileController.removeHandle(cVar);
        }
    }

    public void O4(ArrayList<MedalID> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("reportMedalWallRead, ");
            if (arrayList != null) {
                Iterator<MedalID> it = arrayList.iterator();
                while (it.hasNext()) {
                    MedalWallMng.b(it.next(), sb5);
                }
            }
            QLog.i("MedalWallMng", 4, sb5.toString());
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            cmd0xac6$ReqBody cmd0xac6_reqbody = new cmd0xac6$ReqBody();
            Iterator<MedalID> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                MedalID next = it5.next();
                if (next != null) {
                    cmd0xac6$MedalReport cmd0xac6_medalreport = new cmd0xac6$MedalReport();
                    cmd0xac6_medalreport.uint32_id.set(next.f245721d);
                    cmd0xac6_medalreport.uint32_level.set(next.f245722e);
                    cmd0xac6_reqbody.rpt_medals.add(cmd0xac6_medalreport);
                }
            }
            if (cmd0xac6_reqbody.rpt_medals.isEmpty()) {
                return;
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_REPORT_MEDALWALL_READ, 2758, 2, cmd0xac6_reqbody.toByteArray());
            makeOIDBPkg.extraData.putParcelableArrayList("medal_wall_list", arrayList);
            sendPbReq(makeOIDBPkg);
        }
    }

    public void P4(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, String.format("reqDelVoteRecord selfUin:%s targetUin:%d type:%d", str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(str), "VisitorSvc.ReqDeleteVisitorRecord");
        toServiceMsg.extraData.putLong("selfUin", Long.parseLong(str));
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, j3);
        toServiceMsg.extraData.putInt("type", i3);
        send(toServiceMsg);
    }

    public void Q4(long j3, long j16, byte[] bArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16), bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.PROFILE_CARD, 4, String.format("reqFavorite|%d|%d|likeSource=%d", Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(j3), "VisitorSvc.ReqFavorite");
        toServiceMsg.extraData.putLong("selfUin", j3);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, j16);
        toServiceMsg.extraData.putByteArray("vCookies", bArr);
        toServiceMsg.extraData.putInt("favoriteSource", i3);
        toServiceMsg.extraData.putInt(FloatCacheData.ICOUNT, i16);
        toServiceMsg.extraData.putInt("from", i17);
        send(toServiceMsg);
    }

    public void R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getBindPhoneCardExtInfo uin:" + this.f194471h.getCurrentUin(), new Object[0]));
        }
        sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_BIND_PHONE_SWITCH_INFO, 3123, 0, new MessageMicro<oidb_0xc33$ReqBody>() { // from class: tencent.im.oidb.oidb_0xc33$ReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xc33$ReqBody.class);
        }.toByteArray()));
    }

    public void R4(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        oidb_0x7ba$ReqBody oidb_0x7ba_reqbody = new oidb_0x7ba$ReqBody();
        oidb_0x7ba_reqbody.uint64_uin.set(Long.parseLong(str));
        oidb_0x7ba_reqbody.uint32_start_index.set(i3);
        oidb_0x7ba_reqbody.uint32_want_num.set(i16);
        sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_LIKE_RANKING_LIST, 1978, 0, oidb_0x7ba_reqbody.toByteArray()));
    }

    public ArrayList<CardProfile> S2(int i3, int i16) {
        ArrayList<CardProfile> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ArrayList) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        EntityManager createEntityManager = this.f194471h.getEntityManagerFactory().createEntityManager();
        try {
            try {
                arrayList = (ArrayList) createEntityManager.query(CardProfile.class, true, "type=?", new String[]{String.valueOf(i3)}, null, null, "lTime desc", String.valueOf(i16));
                createEntityManager.close();
                if (arrayList == null) {
                    arrayList = new ArrayList<>(0);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                createEntityManager.close();
                arrayList = new ArrayList<>(0);
            }
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                arrayList.get(i17).updateTime(r14.lTime);
            }
            return arrayList;
        } catch (Throwable th5) {
            createEntityManager.close();
            new ArrayList(0);
            throw th5;
        }
    }

    public void S4(List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) list);
            return;
        }
        FileUtils.writeObject(this.f194471h.getCurrentUin() + "_todayVoters", list);
    }

    public void T2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            send(createToServiceMsg("MCardSvc.ReqGetCardSwitch"));
        }
    }

    public void T4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "send0x5eb_15");
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f194471h.getCurrentAccountUin())));
            oidb_0x5eb_reqbody.uint32_req_hidden_session_switch.set(1);
            oidb_0x5eb_reqbody.uint32_req_hidden_session_video_switch.set(1);
            oidb_0x5eb_reqbody.uint32_req_global_ring_id.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.extraData.putBoolean("sendGlobalRingIdRequest", true);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "send0x5eb_15 ex", e16);
            }
        }
    }

    public void U2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, j3);
        } else {
            V2(j3, true);
        }
    }

    public void U4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::sendGlobalRingIdRequest");
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f194471h.getCurrentAccountUin())));
            oidb_0x5eb_reqbody.uint32_req_global_ring_id.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.extraData.putBoolean("sendGlobalRingIdRequest", true);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "sendGlobalRingIdRequest ex ", e16);
            }
        }
    }

    public void V2(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getEducationList " + j3 + " isSelf " + z16);
        }
        oidb_cmd0xd2d$ReqBody oidb_cmd0xd2d_reqbody = new oidb_cmd0xd2d$ReqBody();
        oidb_cmd0xd2d_reqbody.uint64_req_uin.set(j3);
        oidb_cmd0xd2d_reqbody.uint32_req_category.set(0);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd2d", 3373, 1, oidb_cmd0xd2d_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("uin", Long.valueOf(j3));
        makeOIDBPkg.addAttribute("isSelf", Boolean.valueOf(z16));
        sendPbReq(makeOIDBPkg);
    }

    public void V4(boolean z16, int i3) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "sendHiddenSessionRequest open=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) i3).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putInt("type", i3);
            createToServiceMsg.extraData.putInt("hidden_session_switch", s16);
            createToServiceMsg.extraData.putBoolean("from_send_hidden_session", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "sendHiddenSessionRequest ex", e16);
            }
        }
    }

    public void W2(String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(str), "VisitorSvc.ReqGetFavoriteList");
        toServiceMsg.extraData.putLong("selfUin", Long.parseLong(str));
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, Long.parseLong(str2));
        toServiceMsg.extraData.putLong("nextMid", j3);
        toServiceMsg.extraData.putInt("pageSize", i3);
        send(toServiceMsg);
    }

    public void W4(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "sendNotDisturbTime time=" + i3 + " lastTime=" + str + " source_from" + str2);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(15);
            allocate.putInt(Utils.O(Long.parseLong(this.f194471h.getCurrentAccountUin()))).put((byte) 0).putShort((short) 1).putShort((short) 27240).putShort((short) 4).putInt(i3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putInt("no_disturb_time", i3);
            createToServiceMsg.extraData.putString("no_disturb_last_time", str);
            createToServiceMsg.extraData.putString("source_from", str2);
            createToServiceMsg.extraData.putBoolean("from_send_no_disturb", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "sendNotDisturbTime ex", e16);
            }
        }
    }

    public void X4(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setActivateFriendSwitch OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -25031).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isSetActivateFriend", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setActivateFriendSwitch ex", e16);
            }
        }
    }

    public void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getHiddenSwitch");
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f194471h.getCurrentAccountUin())));
            oidb_0x5eb_reqbody.uint32_req_hidden_session_switch.set(1);
            oidb_0x5eb_reqbody.uint32_req_hidden_session_video_switch.set(1);
            sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, oidb_0x5eb_reqbody.toByteArray()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "getHiddenSwitch ex", e16);
            }
        }
    }

    public void Y4(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setAllowStrangerInviteToGroupSwitch OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23282).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("StrangerInviteToGroup", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setAllowStrangerInviteToGroupSwitch ex", e16);
            }
        }
    }

    public void Z2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
            return;
        }
        this.C = str;
        oidb_0xa28$ReqBody oidb_0xa28_reqbody = new oidb_0xa28$ReqBody();
        oidb_0xa28_reqbody.uint64_request_uin.set(Long.valueOf(str).longValue());
        oidb_0xa28_reqbody.uint32_sourceID.set(0);
        oidb_0xa28_reqbody.uint32_sourceSubID.set(0);
        sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_KPL_INFO, 2600, 0, oidb_0xa28_reqbody.toByteArray()));
    }

    public void Z4(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setBabyQSwitch OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.FIELD_BABY_Q_SWITCH).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isSetBabyQSwitch", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
            if (z16) {
                this.f194471h.getApp().getSharedPreferences(this.f194471h.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setBabyQSwitch ex", e16);
            }
        }
    }

    public void a3(String str) {
        long j3;
        ToServiceMsg makeOIDBPkg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
        }
        try {
            j3 = Long.parseLong(this.f194471h.getCurrentAccountUin());
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        cmd0x7a8$ReqBody cmd0x7a8_reqbody = new cmd0x7a8$ReqBody();
        if (j3 == Long.parseLong(str)) {
            cmd0x7a8_reqbody.uint64_req_uin.set(j3);
            cmd0x7a8_reqbody.uint32_sort_type.set(1);
            cmd0x7a8_reqbody.uint32_only_obtained.set(1);
            cmd0x7a8_reqbody.uint32_only_new.set(1);
            makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_GET_MEDALWALL_INFO, 1960, 5, cmd0x7a8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("from", "getSelfNewObtainedMedalWall");
        } else {
            cmd0x7a8_reqbody.uint64_req_uin.set(Long.parseLong(str));
            cmd0x7a8_reqbody.uint32_only_obtained.set(1);
            makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_GET_MEDALWALL_INFO, 1960, 5, cmd0x7a8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("from", "getGuestMedalWall");
        }
        sendPbReq(makeOIDBPkg);
    }

    public void a5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
            return;
        }
        QLog.d(LogTag.PROFILE_CARD, 1, "setCalReactiveSwitch OPEN=" + z16);
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 1;
            } else {
                s16 = 0;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.FIELD_CAL_REACTIVE_DAY_SWITCH).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isSetCalReactiveDays", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setCalReactiveSwitch ex", e16);
            }
        }
    }

    public void b3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getNotDisturb");
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f194471h.getCurrentAccountUin())));
            oidb_0x5eb_reqbody.uint32_do_not_disturb_mode_time.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            sendPbReq(makeOIDBPkg);
            Bundle bundle = new Bundle();
            bundle.putString("source_from", "not_disturb_from_cardhandler");
            bundle.putBoolean("uint32_do_not_disturb_mode_time", true);
            makeOIDBPkg.extraData.putAll(bundle);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "getNotDisturb ex", e16);
            }
        }
    }

    public void b5(boolean z16, boolean z17) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setCallTabState open=" + z16);
        }
        try {
            int intValue = Integer.valueOf("" + this.f194471h.getNowLiveManager().e().charAt(2)).intValue();
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(19);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            ByteBuffer putShort = allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 2).putShort((short) -25217).putShort((short) 2).putShort(s16).putShort((short) -23476).putShort((short) 2);
            if (intValue >= 2) {
                i3 = 1;
            }
            putShort.putShort((short) i3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("calltabstate", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setCallTabState ex", e16);
            }
        }
    }

    public void c3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getNotifyOnLikeRankingList");
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(this.f194471h.getAccount())));
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
            oidb_0x5eb_reqbody.uint32_notify_on_like_ranking_list_flag.set(1);
            sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_NOTIFY_ON_LIKE_RANKING_LIST, 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("CardHandler", 2, "send_oidb_0x5eb_42092 error", e16);
            }
        }
    }

    public void c5(String str, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), bArr);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MCardSvc.ReqSetCard");
        createToServiceMsg.extraData.putInt("eSubCmd", i3);
        createToServiceMsg.extraData.putByteArray("vReqSetTemplate", bArr);
        send(createToServiceMsg);
        VasLogReporter.getProfileCard().reportHighest("send MCardSvc.ReqSetCard");
    }

    public void d3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getPartekeLikeRankingList");
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(this.f194471h.getAccount())));
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
            oidb_0x5eb_reqbody.uint32_notify_partake_like_ranking_list_flag.set(1);
            sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_PARTAKE_LIKE_RANKING_LIST, 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", e16);
            }
        }
    }

    public void d5(List<ProfileLabelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<ProfileLabelInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().labelId);
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("SummaryCard.SetLabel");
            createToServiceMsg.extraData.putSerializable("labels", arrayList);
            send(createToServiceMsg);
        }
    }

    public void e3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1168);
        oidb_sso_oidbssopkg.uint32_service_type.set(100);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) com.tencent.relation.common.utils.j.b("CardHandler", this.f194471h.getCurrentAccountUin()));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x490_100");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void e5(boolean z16, boolean z17) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MCardSvc.ReqSetCardSwitch");
        createToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", z16);
        Bundle bundle = createToServiceMsg.extraData;
        if (z17) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        bundle.putLong("target_value", j3);
        send(createToServiceMsg);
    }

    public void f4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception e16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z17 = true;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetDisplayThirdQQSwitch success=" + z16);
        }
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() != 0) {
                        z17 = false;
                    }
                } catch (Exception e17) {
                    z17 = z16;
                    e16 = e17;
                } catch (Throwable th5) {
                    z17 = z16;
                    th = th5;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetDisplayThirdQQSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    throw th;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetDisplayThirdQQSwitch result=" + z17 + ",pkg.uint32_result.get() = " + mergeFrom.uint32_result.get());
                    }
                    z16 = J2(z17, mergeFrom);
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetDisplayThirdQQSwitch ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetDisplayThirdQQSwitch result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    notifyUI(79, z17, null);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetDisplayThirdQQSwitch result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            z17 = z16;
            notifyUI(79, z17, null);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void f5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "setCareBarEnable: invoked.  enable: " + z16);
        }
        notifyUI(100, true, Boolean.valueOf(z16));
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23234).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("CardHandler", 2, "setCareBarEnable: failed. ", e16);
            }
        }
    }

    public void g3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(this.f194471h.getAccount())));
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
            oidb_0x5eb_reqbody.uint32_flag_hide_pretty_group_owner_identity.set(1);
            sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_PRETTY_TROOP_OWNER_FLAG, 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", e16);
            }
        }
    }

    public void g5(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bundle);
            return;
        }
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) this.f194471h.getRuntimeService(IProfileProtocolService.class, "all");
        if (iProfileProtocolService != null) {
            iProfileProtocolService.setProfileDetail(bundle);
        }
    }

    public void getAutoReplyList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "getAutoReplyList");
        }
        oidb_cmd0xcd5$ReqBody oidb_cmd0xcd5_reqbody = new oidb_cmd0xcd5$ReqBody();
        oidb_cmd0xcd5$GetDataReq oidb_cmd0xcd5_getdatareq = new oidb_cmd0xcd5$GetDataReq();
        oidb_cmd0xcd5_getdatareq.query_type.set(1);
        oidb_cmd0xcd5_reqbody.getdata_req.set(oidb_cmd0xcd5_getdatareq);
        oidb_cmd0xcd5_reqbody.service_type.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_AUTO_REPLY, 3285, 0, oidb_cmd0xcd5_reqbody.toByteArray());
        makeOIDBPkg.extraData.putBoolean("isGetList", true);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("MCardSvc.ReqSetCard");
            this.allowCmdSet.add("SummaryCard.SetLabel");
            this.allowCmdSet.add("SummaryCard.LikeIt");
            this.allowCmdSet.add("MCardSvc.ReqGetCardSwitch");
            this.allowCmdSet.add("MCardSvc.ReqSetCardSwitch");
            this.allowCmdSet.add("VisitorSvc.ReqDeleteVisitorRecord");
            this.allowCmdSet.add("VisitorSvc.ReqFavorite");
            this.allowCmdSet.add("VisitorSvc.ReqGetVoterList");
            this.allowCmdSet.add("VisitorSvc.ReqGetFavoriteList");
            this.allowCmdSet.add("MCardSvc.ReqDelFace");
            this.allowCmdSet.add("AccostSvc.ClientMsg");
            this.allowCmdSet.add("AccostSvc.SvrMsg");
            this.allowCmdSet.add("MCardSvc.ReqPicSafetyCheck");
            this.allowCmdSet.add("OidbSvc.0x490_100");
            this.allowCmdSet.add("OidbSvc.0x491_100");
            this.allowCmdSet.add("SQQzoneSvc.getCover");
            this.allowCmdSet.add(ProfileContants.CMD_SET_DETAIL_INFO);
            this.allowCmdSet.add(ProfileContants.CMD_UPLOAD_QZONE_PHOTO);
            this.allowCmdSet.add(ProfileContants.CMD_IMPORT_QZONE_PHOTOES);
            this.allowCmdSet.add(ProfileContants.CMD_QUERY_IMPORT_QZONE_PHOTOES_STATUS);
            this.allowCmdSet.add("OidbSvc.0x66b");
            this.allowCmdSet.add("OidbSvc.0x5eb_22");
            this.allowCmdSet.add("OidbSvc.0x5eb_15");
            this.allowCmdSet.add(ProfileContants.CMD_GET_LIKE_RANKING_LIST);
            this.allowCmdSet.add(ProfileContants.CMD_GET_NOTIFY_ON_LIKE_RANKING_LIST);
            this.allowCmdSet.add(ProfileContants.CMD_GET_PARTAKE_LIKE_RANKING_LIST);
            this.allowCmdSet.add(ProfileContants.CMD_GET_SIGNIN_RED_TOUCH);
            this.allowCmdSet.add(ProfileContants.CMD_GET_SIGNIN_OPRATION_CONTENT);
            this.allowCmdSet.add(ProfileContants.CMD_GET_KPL_INFO);
            this.allowCmdSet.add(ProfileContants.CMD_REPORT_MEDALWALL_READ);
            this.allowCmdSet.add(ProfileContants.CMD_GET_MEDALWALL_INFO);
            this.allowCmdSet.add(ProfileContants.CMD_GET_BIND_PHONE_SWITCH_INFO);
            this.allowCmdSet.add(ProfileContants.CMD_AUTO_REPLY);
            this.allowCmdSet.add("OidbSvc.0xd8a");
            this.allowCmdSet.add("OidbSvc.0xd2d");
            this.allowCmdSet.add("OidbSvc.0x4ff_42315");
            this.allowCmdSet.add(ProfileContants.CMD_GET_PRETTY_TROOP_OWNER_FLAG);
        }
        return this.allowCmdSet;
    }

    public void h3(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_COVER, 2, "getQzoneCover");
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("SQQzoneSvc.getCover");
        createToServiceMsg.addAttribute("uin", str);
        createToServiceMsg.addAttribute("flag", Integer.valueOf(i3));
        send(createToServiceMsg);
    }

    public void h5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setDisplayThirdQQSwitch OPEN=" + z16);
        }
        try {
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            byte[] bArr = new byte[13];
            PkgTools.dWord2Byte(bArr, 0, parseLong);
            bArr[4] = 0;
            PkgTools.word2Byte(bArr, 5, (short) 1);
            PkgTools.dWordTo2Bytes(bArr, 7, ProfileContants.FIELD_SUBACCOUNT_DISPLAY_THIRD_QQ);
            PkgTools.word2Byte(bArr, 9, (short) 2);
            PkgTools.word2Byte(bArr, 11, s16);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_SET_DETAIL_INFO, 1279, 9, bArr);
            makeOIDBPkg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            makeOIDBPkg.extraData.putBoolean("isSetDisplayThirdQQSwitch", true);
            makeOIDBPkg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            e16.printStackTrace();
            notifyUI(79, false, null);
        }
    }

    public void i5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "setEmotionRecommendSwitch!");
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort((short) -23221).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4ff_42315");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean("uint32_emotion_recommend_flag", z16);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 1, "setEmotionRecommendSwitch ex", e16);
            }
        }
    }

    public void j3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "getSigninRedTouchShell");
        }
        if (t5()) {
            l3(i3);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i(DailySignInWebviewPlugin.TAG, 2, "getSignRedTouchShell time kill");
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.CardHandler.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CardHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        CardHandler.this.notifyUI(82, true, null);
                    }
                }
            });
        }
        if (u5()) {
            k3();
        } else if (QLog.isColorLevel()) {
            QLog.i(DailySignInWebviewPlugin.TAG, 2, "shouldResuestSignOperate false");
        }
    }

    public void j5(String str, String str2, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, l3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("SummaryCard.LikeIt");
        createToServiceMsg.extraData.putLong("selfUin", Long.parseLong(str));
        createToServiceMsg.extraData.putLong("destUin", Long.parseLong(str2));
        createToServiceMsg.extraData.putLong("labelId", l3.longValue());
        send(createToServiceMsg);
    }

    public void k3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(DailySignInWebviewPlugin.TAG, 2, "getSigniOperat ");
        }
        sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_SIGNIN_OPRATION_CONTENT, 3622, 0, new MessageMicro<oidb_0xe26$ReqBody>() { // from class: tencent.im.oidb.cmd0xe26.oidb_0xe26$ReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_req_source", "clientInfo"}, new Object[]{0, null}, oidb_0xe26$ReqBody.class);
            public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
            public final PBRepeatMessageField<oidb_0xe26$ClientInfo> clientInfo = PBField.initRepeatMessage(oidb_0xe26$ClientInfo.class);
        }.toByteArray()));
    }

    public void k5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setMedalSwitch OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 1;
            } else {
                s16 = 0;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(this.D).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("uint32_req_medalwall_flag", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setMedalSwitch ex", e16);
            }
        }
    }

    public void l3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(DailySignInWebviewPlugin.TAG, 2, "getSigninRedTouch svrType=" + i3);
        }
        cmd0x922$ReqBody cmd0x922_reqbody = new cmd0x922$ReqBody();
        cmd0x922_reqbody.uint64_timestamp.set(this.f194471h.getPreferences().getLong("sign_in_time_stamp", 0L));
        sendPbReq(makeOIDBPkg(ProfileContants.CMD_GET_SIGNIN_RED_TOUCH, 2338, i3, cmd0x922_reqbody.toByteArray()));
    }

    public void l4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetNotifyOnLikeRankingList success=" + z16);
        }
        this.f194471h.getCurrentAccountUin();
        C4(toServiceMsg, (byte[]) obj, z16, false);
    }

    public void l5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "setNotifyOnLikeRankingList OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.NOTIFY_ON_LIKE_RANKING_LIST_FIELD_ID).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isSetNotifyOnLikeRankingList", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setNotifyOnLikeRankingList ex", e16);
            }
        }
    }

    public void m3(String str, String str2, int i3, long j3, byte b16, long j16, long j17, byte[] bArr, String str3, long j18, int i16, byte[] bArr2, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Byte.valueOf(b16), Long.valueOf(j16), Long.valueOf(j17), bArr, str3, Long.valueOf(j18), Integer.valueOf(i16), bArr2, Byte.valueOf(b17));
            return;
        }
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) this.f194471h.getRuntimeService(IProfileProtocolService.class, "all");
        if (iProfileProtocolService != null) {
            iProfileProtocolService.requestProfileCard(str, str2, i3, j3, b16, j16, j17, bArr, str3, j18, i16, bArr2, b17);
        }
    }

    public void m5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setPCActiveState OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 1;
            } else {
                s16 = 0;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.FIELD_PC_PUSH_PHONEQQ).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isGetLoginDays", false);
            createToServiceMsg.extraData.putBoolean("pcActiveState", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setPCActiveState ex", e16);
            }
        }
    }

    public void n3(List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) list);
            return;
        }
        Object readObject = FileUtils.readObject(this.f194471h.getCurrentUin() + "_todayVoters");
        if (readObject != null && (readObject instanceof ArrayList)) {
            List list2 = (List) readObject;
            if (list2.size() > 0) {
                list.addAll(list2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception e16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleSetPartakeLikeRankingList success=" + z16);
        }
        this.f194471h.getCurrentAccountUin();
        try {
            if (z16) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() != 0) {
                        z17 = false;
                    }
                } catch (Exception e17) {
                    z17 = z16;
                    e16 = e17;
                } catch (Throwable th5) {
                    z17 = z16;
                    th = th5;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPartakeLikeRankingList result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    throw th;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPartakeLikeRankingList result=" + z17 + "resultCode=" + mergeFrom.uint32_result.get());
                    }
                    z16 = J2(z17, mergeFrom);
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPartakeLikeRankingList ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPartakeLikeRankingList result=" + z17 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    if (z17) {
                    }
                    notifyUI(80, z17, Boolean.valueOf(z18));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleSetPartakeLikeRankingList result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
            }
            z17 = z16;
            if (z17) {
                z18 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            }
            notifyUI(80, z17, Boolean.valueOf(z18));
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void n5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "setPartakeLikeRankingList OPEN=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.PARTAKE_LIKE_RANKING_LIST_ID).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("isSetPartakeLikeRankingList", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setPartakeLikeRankingList ex", e16);
            }
        }
    }

    public void o3(String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(str), "VisitorSvc.ReqGetVoterList");
        toServiceMsg.extraData.putLong("selfUin", Long.parseLong(str));
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, Long.parseLong(str2));
        toServiceMsg.extraData.putLong("nextMid", j3);
        toServiceMsg.extraData.putInt("pageSize", i3);
        send(toServiceMsg);
    }

    public void o5(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1169);
        oidb_sso_oidbssopkg.uint32_service_type.set(100);
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (!z16 ? 1 : 0));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x491_100");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putBoolean("key_searchable", z16);
        createToServiceMsg.setTimeout(10000L);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ICardObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        String string = toServiceMsg.extraData.getString("friendUin");
        if (string == null) {
            string = fromServiceMsg.getUin();
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", string);
        E4(toServiceMsg, fromServiceMsg, obj, bundle);
        F4(toServiceMsg, fromServiceMsg, obj, bundle);
        G4(toServiceMsg, fromServiceMsg, obj, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean z18 = false;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag success=" + z16);
        }
        this.f194471h.getCurrentAccountUin();
        if (z16) {
            try {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + z16 + "resultCode=" + mergeFrom.uint32_result.get());
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag ex", e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                }
                if (z16 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    int i3 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray()).getInt();
                    long j3 = i3;
                    if (i3 < 0) {
                        j3 = (i3 & Integer.MAX_VALUE) | 2147483648L;
                    }
                    if (this.f194471h.getCurrentAccountUin().equals(String.valueOf(j3))) {
                        z17 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                        z18 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + z18 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                    }
                    boolean z19 = z18;
                    z18 = z17;
                    z16 = z19;
                    notifyUI(106, z16, Boolean.valueOf(z18));
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + z16 + ";allow=" + toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
                }
                throw th5;
            }
        }
        z18 = z16;
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        boolean z192 = z18;
        z18 = z17;
        z16 = z192;
        notifyUI(106, z16, Boolean.valueOf(z18));
    }

    public void p5(boolean z16) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, z16);
            return;
        }
        QLog.e("vip_pretty.CardHandler", 1, "setPrettyTroopOwnerFlag OPEN=" + z16);
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(this.f194473m);
            oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
            ByteBuffer allocate = ByteBuffer.allocate(13);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            if (z16) {
                s16 = 0;
            } else {
                s16 = 1;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 1).putShort(ProfileContants.PRETTY_TROOP_OWNER_FLAG_ID).putShort((short) 2).putShort(s16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putBoolean("setPrettyTroopOwnerFlag", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "setPrettyTroopOwnerFlag ex", e16);
            }
        }
    }

    public void q5(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("vip_ptt.CardHandler", 2, "setPttAuToTextOffLineSwitch:" + UIUtils.k(30));
        }
        try {
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(3466);
            oidb_sso_oidbssopkg.uint32_service_type.set(21);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            cmd0xd8a$ReqBody cmd0xd8a_reqbody = new cmd0xd8a$ReqBody();
            cmd0xd8a_reqbody.uint64_uin.set(parseLong);
            PBUInt32Field pBUInt32Field = cmd0xd8a_reqbody.uint32_cmd;
            if (z16) {
                i3 = 101;
            } else {
                i3 = 102;
            }
            pBUInt32Field.set(i3);
            cmd0xd8a$ClientInfo cmd0xd8a_clientinfo = new cmd0xd8a$ClientInfo();
            cmd0xd8a_clientinfo.uint32_implat.set(109);
            cmd0xd8a_clientinfo.string_clientver.set(AppSetting.n());
            cmd0xd8a_reqbody.client_info.set(cmd0xd8a_clientinfo);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xd8a_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xd8a");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean("uint32_auto_to_text_flag", z16);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("vip_ptt.CardHandler", 1, "setMedalSwitch ex", e16);
            }
        }
    }

    public void r5(short s16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Short.valueOf(s16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setTempConversationBlocState type=" + ((int) s16) + " Block=" + z16);
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(13);
            allocate.putInt(Utils.O(Long.parseLong(this.f194471h.getCurrentAccountUin()))).put((byte) 0).putShort((short) 1).putShort(s16).putShort((short) 2).putShort(X2(s16, z16));
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putShort("type", s16);
            createToServiceMsg.extraData.putBoolean("tempConversationBlocState", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            QLog.e(LogTag.PROFILE_CARD, 1, "setTempConversationBlocState ex", e16);
        }
    }

    public void s5(short s16, short s17, short s18, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Short.valueOf(s16), Short.valueOf(s17), Short.valueOf(s18), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "setTempConversationNewBlockState() called with: type = [" + ((int) s16) + "], inBoxType = [" + ((int) s17) + "], state = [" + ((int) s18) + "], isAllowedToReceiveMessageBefore = [" + z16 + "], isInBox = [" + z17 + "]");
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1279);
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
            ByteBuffer allocate = ByteBuffer.allocate(19);
            long parseLong = Long.parseLong(this.f194471h.getCurrentAccountUin());
            short s19 = (short) (s18 & 1);
            short s26 = (short) (s18 >> 1);
            if (s19 == 0 && s16 == -20457) {
                s19 = 2;
            }
            allocate.putInt(Utils.O(parseLong)).put((byte) 0).putShort((short) 2).putShort(s16).putShort((short) 2).putShort(s19).putShort(s17).putShort((short) 2).putShort(s26);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SET_DETAIL_INFO);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean("blockSwitch", z16);
            createToServiceMsg.extraData.putBoolean("inBoxSwitch", z17);
            createToServiceMsg.extraData.putShort("type", s16);
            createToServiceMsg.extraData.putBoolean("tempConversationNewBlockState", true);
            createToServiceMsg.extraData.putBoolean("reqFromCardHandler", true);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            QLog.e(LogTag.PROFILE_CARD, 1, "setTempConversationNewBlockState ex", e16);
        }
    }

    public void setAutoReplyList(ArrayList<AutoReplyText> arrayList, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (arrayList != null && ((i3 >= 0 && i3 < arrayList.size()) || i3 == Integer.MAX_VALUE)) {
            if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, String.format("setAutoReplyList, selectIndex: %s, replyMsgList: %s, lastSelectId: %s, needNotify: %s", Integer.valueOf(i3), arrayList, Integer.valueOf(i16), Boolean.valueOf(z16)));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<AutoReplyText> it = arrayList.iterator();
            while (it.hasNext()) {
                M2(arrayList2, it.next());
            }
            wording_storage$WordingCfg wording_storage_wordingcfg = new wording_storage$WordingCfg();
            if (i3 == Integer.MAX_VALUE) {
                wording_storage_wordingcfg.auto_reply_flag.set(0);
                wording_storage_wordingcfg.select_id.set(i16);
            } else {
                wording_storage_wordingcfg.auto_reply_flag.set(1);
                wording_storage_wordingcfg.select_id.set(i3);
            }
            wording_storage_wordingcfg.wording_list.set(arrayList2);
            oidb_cmd0xcd5$SetDataReq oidb_cmd0xcd5_setdatareq = new oidb_cmd0xcd5$SetDataReq();
            oidb_cmd0xcd5_setdatareq.pb_data.set(ByteStringMicro.copyFrom(wording_storage_wordingcfg.toByteArray()));
            oidb_cmd0xcd5$ReqBody oidb_cmd0xcd5_reqbody = new oidb_cmd0xcd5$ReqBody();
            oidb_cmd0xcd5_reqbody.service_type.set(2);
            oidb_cmd0xcd5_reqbody.setdata_req.set(oidb_cmd0xcd5_setdatareq);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ProfileContants.CMD_AUTO_REPLY, 3285, 0, oidb_cmd0xcd5_reqbody.toByteArray());
            makeOIDBPkg.extraData.putParcelableArrayList("replyMsgList", arrayList);
            makeOIDBPkg.extraData.putInt("selectId", i3);
            makeOIDBPkg.extraData.putBoolean("needNotify", z16);
            sendPbReq(makeOIDBPkg);
            return;
        }
        QLog.d("CardHandler", 1, String.format("setAutoReplyList param error, replyList: %s, lastSelectId: %s", arrayList, Integer.valueOf(i3)));
        notifyUI(97, false, null);
    }

    public boolean w4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        SharedPreferences preferences = this.f194471h.getPreferences();
        long j3 = preferences.getLong("sign_in_time_stamp", 0L);
        try {
            JSONObject jSONObject = new JSONObject(preferences.getString(this.f194471h.getCurrentUin() + "sign_in_info", ""));
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt(RedTouchWebviewHandler.PLUGIN_NAMESPACE);
            if (jSONObject.optInt("openfunc") != 0) {
                if (com.tencent.mobileqq.service.message.e.K0() - j3 <= 86400 && optInt != 4 && optInt2 == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    protected void w5(String str, List<CardProfile> list) {
        EntityManager createEntityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (list != null && list.size() > 0 && (createEntityManager = this.f194471h.getEntityManagerFactory().createEntityManager()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<CardProfile> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new PersistOrReplaceTransaction(it.next()));
            }
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
        }
    }

    public void y5(TMedalWallInfo tMedalWallInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) tMedalWallInfo);
            return;
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(String.format(Locale.getDefault(), "%s%s", "medal_wall_", this.f194472i.getAccount()), 4).edit();
        edit.putInt("medal_total_number", tMedalWallInfo.iMedalCount);
        edit.putInt("medal_new_number", tMedalWallInfo.iNewCount);
        edit.apply();
    }

    public boolean z4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        return this.f194471h.getApp().getSharedPreferences(AppConstants.Preferences.TASK_ENTRY_CONFIG + this.f194471h.getCurrentAccountUin(), 0).getBoolean("open", false);
    }

    public void z5(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + z16);
        }
        String tempAvatarFilePath = FaceUtil.getTempAvatarFilePath();
        FaceUtil.setTempAvatarFilePath(null);
        if (z16) {
            if (O2()) {
                EntityManager createEntityManager = this.f194471h.getEntityManagerFactory().createEntityManager();
                Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, str);
                if (setting == null) {
                    setting = new Setting();
                    setting.uin = str;
                    setting.bHeadType = (byte) 1;
                    setting.bUsrType = (byte) 1;
                    long currentTimeMillis = System.currentTimeMillis();
                    setting.updateTimestamp = currentTimeMillis;
                    setting.headImgTimestamp = currentTimeMillis / 1000;
                    createEntityManager.persist(setting);
                } else {
                    setting.bHeadType = (byte) 1;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    setting.updateTimestamp = currentTimeMillis2;
                    setting.headImgTimestamp = currentTimeMillis2 / 1000;
                    QLog.i("CardHandler", 1, "uploadAvatarResult save db headImgTimestamp: " + setting.headImgTimestamp);
                    createEntityManager.update(setting);
                }
                createEntityManager.close();
                this.f194471h.updateSettingTableCache(setting);
            } else {
                QLog.i("CardHandler", 1, "uploadAvatarResult system time: " + (System.currentTimeMillis() / 1000));
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "CardHandler");
            if (vasSimpleInfoWithUid == null) {
                vasSimpleInfoWithUid = new NTVasSimpleInfo();
                vasSimpleInfoWithUid.e(uidFromUin);
                vasSimpleInfoWithUid.f(str);
            }
            vasSimpleInfoWithUid.faceId = 0;
            vasSimpleInfoWithUid.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            ((com.tencent.mobileqq.vas.ao) this.f194471h.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f.l(vasSimpleInfoWithUid);
            QQAppInterface qQAppInterface = this.f194471h;
            String customFaceFilePath = qQAppInterface.getCustomFaceFilePath(false, qQAppInterface.getCurrentAccountUin());
            if (!TextUtils.isEmpty(customFaceFilePath)) {
                FileUtils.deleteFile(customFaceFilePath);
            }
            String hDAvatarPath = FaceUtil.getHDAvatarPath(str);
            if (!TextUtils.isEmpty(hDAvatarPath)) {
                FileUtils.deleteFile(hDAvatarPath);
            }
            String fHDAvatarPath = FaceUtil.getFHDAvatarPath(str);
            if (!TextUtils.isEmpty(fHDAvatarPath)) {
                FileUtils.deleteFile(fHDAvatarPath);
            }
            FaceUtil.removeAvatarFromCache(this.f194471h, str);
            this.f194471h.removeFaceIconCache(1, str, 0);
            if (!TextUtils.isEmpty(tempAvatarFilePath)) {
                BaseImageUtil.compressImagetoSize(null, tempAvatarFilePath, customFaceFilePath, 140, 140);
                FileUtils.copyFile(tempAvatarFilePath, hDAvatarPath);
                this.f194471h.sendSelfQQHeadBroadcast(1, str, 0, customFaceFilePath);
            }
        }
        if (!TextUtils.isEmpty(tempAvatarFilePath)) {
            StringBuilder sb5 = new StringBuilder();
            String str2 = AppConstants.SDCARD_ROOT;
            sb5.append(str2);
            sb5.append("/DCIM/");
            if (!tempAvatarFilePath.contains(sb5.toString())) {
                if (!tempAvatarFilePath.contains(str2 + "/Pictures/")) {
                    FileUtils.deleteFile(tempAvatarFilePath);
                }
            }
            QLog.e("CardHandler", 1, "uploadAvatarResult delete file in system dir. path= " + tempAvatarFilePath);
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putInt("result", i3);
        notifyUI(8, z16, bundle);
    }
}
