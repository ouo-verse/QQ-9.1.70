package com.tencent.mobileqq.app;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SignatureManager implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static boolean M;
    public static SignatureTemplateConfig.SignatureTemplateType[] N;
    public static ConcurrentHashMap<Integer, SignatureTemplateInfo> P;
    private static SignatureTemplateInfo Q;
    private static Lock R;
    public static int S;
    public static int T;
    public static ConcurrentLinkedQueue<Runnable> U;
    MqqHandler C;
    Handler D;
    private com.tencent.mobileqq.vip.h E;
    private IPreDownloadController F;
    private Handler.Callback G;
    AtomicInteger H;

    /* renamed from: d, reason: collision with root package name */
    public int f195074d;

    /* renamed from: e, reason: collision with root package name */
    public int f195075e;

    /* renamed from: f, reason: collision with root package name */
    public int f195076f;

    /* renamed from: h, reason: collision with root package name */
    public SignatureTemplateInfo f195077h;

    /* renamed from: i, reason: collision with root package name */
    protected QQAppInterface f195078i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, RichStatus> f195079m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.SignatureManager$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f195082d;
        final /* synthetic */ SignatureManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.H.set(this.f195082d);
            SignatureTemplateInfo signatureTemplateInfoFromFile = SignatureTemplateConfig.getSignatureTemplateInfoFromFile(this.this$0.f195078i, this.f195082d);
            if (signatureTemplateInfoFromFile != null) {
                SignatureManager.P.put(Integer.valueOf(this.f195082d), signatureTemplateInfoFromFile);
            }
            this.this$0.H.set(-1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SigCommentInfo implements Serializable, Comparable<SigCommentInfo> {
        static IPatchRedirector $redirector_;
        public String feedsid;

        /* renamed from: rs, reason: collision with root package name */
        public RichStatus f195083rs;
        public long time;
        public int type;
        public long uin;

        public SigCommentInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(SigCommentInfo sigCommentInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (int) (sigCommentInfo.time - this.time) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sigCommentInfo)).intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SigComments implements Serializable {
        static IPatchRedirector $redirector_;
        public boolean isOver;
        public List<SigCommentInfo> mlist;

        public SigComments() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class TopicInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public int friendNum;
        public int topicId;
        public String topicStr;
        public int totalNum;

        public TopicInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureManager.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (2 == i3) {
                SignatureManager.N = (SignatureTemplateConfig.SignatureTemplateType[]) message.obj;
                QQAppInterface qQAppInterface2 = SignatureManager.this.f195078i;
                if (qQAppInterface2 != null) {
                    MqqHandler handler = qQAppInterface2.getHandler(EditActivity.class);
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(2, 50L);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Signature", 2, "update sign tpl info...");
                        return true;
                    }
                    return true;
                }
                return true;
            }
            if (3 == i3 && (qQAppInterface = SignatureManager.this.f195078i) != null) {
                MqqHandler handler2 = qQAppInterface.getHandler(EditActivity.class);
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(7, 50L);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Signature", 2, "update sign tpl animation ...");
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        I = AppConstants.SDCARD_PATH + ".signatureTemplate/";
        StringBuilder sb5 = new StringBuilder();
        String str = VasConstant.SIGNATURE_TEMPLATE_DIR;
        sb5.append(str);
        sb5.append("sign_tpl.json");
        J = sb5.toString();
        K = str;
        L = str + "/temp";
        M = false;
        N = null;
        P = new ConcurrentHashMap<>();
        R = new ReentrantLock();
        S = 1;
        T = 0;
        U = new ConcurrentLinkedQueue<>();
    }

    public SignatureManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195074d = -1;
        this.f195075e = -1;
        this.f195076f = 0;
        this.f195077h = null;
        this.f195079m = null;
        this.D = null;
        this.G = new a();
        this.H = new AtomicInteger(-1);
        this.f195078i = qQAppInterface;
        this.E = ((DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
        this.D = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.C = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.G);
        this.F = (IPreDownloadController) this.f195078i.getRuntimeService(IPreDownloadController.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(QQAppInterface qQAppInterface, RichStatus richStatus, String str) {
        if (!richStatus.isEmpty() && !TextUtils.isEmpty(richStatus.feedsId)) {
            return false;
        }
        VasCommonReporter.getHistoryFeature("signature_Beancurd").report(false);
        if (com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-03-24", "vas_bug_138986403").isEnable(true)) {
            return false;
        }
        List<MessageRecord> D = qQAppInterface.getMessageFacade().D(str, 0, new int[]{MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED});
        if (D != null) {
            for (MessageRecord messageRecord : D) {
                qQAppInterface.getMessageFacade().A0(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                qQAppInterface.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
            }
        }
        ((com.tencent.mobileqq.activity.aio.q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(str, 0, 1);
        if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded delete signature");
        }
        ea.m4(qQAppInterface.getCurrentUin(), str, 0L);
        return true;
    }

    public static boolean i(String str) {
        String signatureFilePath = SignatureTemplateConfig.getSignatureFilePath(str, "dynamic_aio");
        File file = new File(signatureFilePath);
        if (!file.exists() || !file.isDirectory() || FileUtils.getChildFiles(signatureFilePath).size() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j(RichStatus richStatus) {
        int i3;
        int i16;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "1.0");
            jSONObject.put("time", String.valueOf(richStatus.time));
            String str = richStatus.actionText;
            if (str != null && str.trim().length() > 0) {
                jSONObject.put("aid", String.valueOf(richStatus.actionId));
                jSONObject.put(MessageForRichState.SIGN_MSG_ACTION_TEXT_KEY, richStatus.actionText);
            }
            String str2 = richStatus.dataText;
            if (str2 != null && str2.trim().length() > 0) {
                jSONObject.put(MessageForRichState.SIGN_MSG_DATA_ID_KEY, String.valueOf(richStatus.dataId));
                jSONObject.put(MessageForRichState.SIGN_MSG_DATA_TEXT_KEY, richStatus.dataText);
            }
            jSONObject.put(MessageForRichState.SIGN_MSG_LOC_TEXT_POS_KEY, String.valueOf(richStatus.locationPosition));
            ArrayList<String> arrayList = richStatus.plainText;
            if (arrayList != null && arrayList.size() > 0) {
                int size = richStatus.plainText.size();
                JSONArray jSONArray = new JSONArray();
                for (int i17 = 0; i17 < size; i17++) {
                    String str3 = richStatus.plainText.get(i17);
                    if (str3 != null) {
                        jSONArray.mo162put(str3);
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, jSONArray);
                }
            }
            if (richStatus.topics.size() > 0) {
                jSONObject.put(MessageForRichState.SIGN_MSG_TOPICS, richStatus.topicToJson());
            }
            if (richStatus.topicsPos.size() > 0) {
                jSONObject.put(MessageForRichState.SIGN_MSG_TOPICS_POS, richStatus.topicPosToJson());
            }
            String str4 = richStatus.locationText;
            if (str4 != null && str4.trim().length() > 0) {
                jSONObject.put(MessageForRichState.SIGN_MSG_LOC_TEXT_KEY, richStatus.locationText);
            }
            if (!TextUtils.isEmpty(richStatus.feedsId)) {
                jSONObject.put("feedid", richStatus.feedsId);
            }
            jSONObject.put(MessageForRichState.SIGN_MSG_TPL_ID_KEY, richStatus.tplId);
            HashMap<Integer, RichStatus.b> hashMap = richStatus.sigZanInfo;
            if (hashMap != null && hashMap.get(255) != null) {
                i3 = richStatus.sigZanInfo.get(255).f282156c;
                i16 = richStatus.sigZanInfo.get(255).f282157d;
            } else {
                i3 = 0;
                i16 = 0;
            }
            jSONObject.put("count", i3);
            jSONObject.put(MessageForRichState.SIGN_MSG_ZAN_FLAG_KEY, i16);
            ArrayList<RichStatus.StickerInfo> arrayList2 = richStatus.mStickerInfos;
            if (arrayList2 != null && arrayList2.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i18 = 0; i18 < richStatus.mStickerInfos.size(); i18++) {
                    RichStatus.StickerInfo stickerInfo = richStatus.mStickerInfos.get(i18);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", stickerInfo.f282152id);
                    jSONObject2.put("posX", stickerInfo.posX);
                    jSONObject2.put("posY", stickerInfo.posY);
                    jSONObject2.put("width", stickerInfo.width);
                    jSONObject2.put("height", stickerInfo.height);
                    jSONArray2.mo162put(jSONObject2);
                }
                jSONObject.put("sticker", jSONArray2);
            }
            jSONObject.put(MessageForRichState.SIGN_MSG_FONT_ID, richStatus.fontId);
            jSONObject.put(MessageForRichState.SIGN_MSG_FONT_TYPE, richStatus.fontType);
            if (jSONObject.length() <= 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("Signature", 2, "insertSignMsgIfNeeded sign is empty,rs.actionText is:" + richStatus.actionText + ",rs.dataText is:" + richStatus.dataText + ",rs.plainText is:" + richStatus.plainText + ",rs.locationText is:" + richStatus.locationText);
                }
                return null;
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Signature", 2, "insertSignMsgIfNeeded failed,error msg is:" + e16.getMessage(), e16);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(QQAppInterface qQAppInterface, RichStatus richStatus, ExtensionInfo extensionInfo, String str, String str2) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        com.tencent.mobileqq.activity.aio.q qVar = (com.tencent.mobileqq.activity.aio.q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
        BeancurdMsg beancurdMsg = new BeancurdMsg();
        beancurdMsg.frienduin = str2;
        beancurdMsg.busiid = 1;
        beancurdMsg.isNeedDelHistory = true;
        beancurdMsg.ispush = false;
        beancurdMsg.startTime = NetConnInfoCenter.getServerTime();
        beancurdMsg.validTime = 2592000L;
        beancurdMsg.buffer = str;
        qVar.l(beancurdMsg);
        ea.m4(qQAppInterface.getCurrentUin(), str2, serverTimeMillis);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str2);
        dVar.M();
        dVar.N(Boolean.TRUE);
        iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "Signature", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        ReportController.o(qQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(richStatus.tplId), "", "", "");
    }

    public static boolean m(QQAppInterface qQAppInterface, String str, RichStatus richStatus) {
        if (qQAppInterface == null || TextUtils.isEmpty(str) || ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).isNewFriend(str)) {
            return false;
        }
        if (qQAppInterface.getCurrentAccountUin().equals(str)) {
            return true;
        }
        U.add(new Runnable(str) { // from class: com.tencent.mobileqq.app.SignatureManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f195081e;

            {
                this.f195081e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RichStatus.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5;
                QQAppInterface qQAppInterface2;
                RichStatus richStatus2;
                FriendsManager friendsManager;
                ExtensionInfo extensionInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                        richStatus2 = RichStatus.this;
                        friendsManager = (FriendsManager) qQAppInterface2.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    } catch (Exception e16) {
                        QLog.e("Signature", 2, "insertSignMsgIfNeeded exception:" + e16);
                        if (QLog.isDebugVersion()) {
                            sb5 = new StringBuilder();
                        }
                    }
                    if (!friendsManager.c0(this.f195081e)) {
                        return;
                    }
                    if (richStatus2 == null) {
                        ExtensionInfo H = friendsManager.H(this.f195081e);
                        if (H == null) {
                            if (QLog.isDebugVersion()) {
                                QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            }
                            SignatureManager.s(true);
                            return;
                        }
                        if (H.isAdded2C2C) {
                            if (QLog.isDebugVersion()) {
                                QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            }
                            SignatureManager.s(true);
                            return;
                        }
                        extensionInfo = H;
                        richStatus2 = com.tencent.mobileqq.richstatus.c.e(H);
                    } else {
                        extensionInfo = null;
                    }
                    if (SignatureManager.p(richStatus2)) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                        SignatureManager.s(true);
                        return;
                    }
                    if (!SignatureManager.h(qQAppInterface2, richStatus2, this.f195081e)) {
                        SignatureManager.r(qQAppInterface2, richStatus2);
                        if (!SignatureManager.q(qQAppInterface2, this.f195081e)) {
                            String j3 = SignatureManager.j(richStatus2);
                            if (j3 != null) {
                                SignatureManager.l(qQAppInterface2, richStatus2, extensionInfo, j3, this.f195081e);
                                if (QLog.isDebugVersion()) {
                                    sb5 = new StringBuilder();
                                    sb5.append("insert signature cost:");
                                    sb5.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb5.append(" ms");
                                    QLog.d("Signature", 1, sb5.toString());
                                }
                                SignatureManager.s(true);
                                return;
                            }
                            if (QLog.isDebugVersion()) {
                                QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            }
                            SignatureManager.s(true);
                            return;
                        }
                        if (QLog.isDebugVersion()) {
                            QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                        SignatureManager.s(true);
                        return;
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    SignatureManager.s(true);
                } finally {
                    if (QLog.isDebugVersion()) {
                        QLog.d("Signature", 1, "insert signature cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    SignatureManager.s(true);
                }
            }
        });
        s(false);
        return true;
    }

    public static boolean n(SignatureTemplateInfo signatureTemplateInfo) {
        if (TextUtils.isEmpty(signatureTemplateInfo.dynamicItem[0].pngZip) && TextUtils.isEmpty(signatureTemplateInfo.dynamicItem[1].pngZip) && TextUtils.isEmpty(signatureTemplateInfo.dynamicItem[2].pngZip) && TextUtils.isEmpty(signatureTemplateInfo.dynamicItem[3].pngZip) && TextUtils.isEmpty(signatureTemplateInfo.dynamicItem[4].pngZip)) {
            return false;
        }
        return true;
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (SharpPUtil.isSharpPFile(new File(str))) {
            return true;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, str + " is not a picture");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(RichStatus richStatus) {
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = serverTime - richStatus.time;
        if (QLog.isDebugVersion()) {
            QLog.d("Signature", 4, "insertSignMsgIfNeeded serverTime = " + serverTime + " richTime = " + richStatus.time);
        }
        if (j3 >= JoinTimeType.SEVEN_DAY) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface.getProxyManager().m().findRecentUserByUin(str, 0) != null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded fail ResentUser = null ");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(QQAppInterface qQAppInterface, RichStatus richStatus) {
        SignatureTemplateInfo signatureTemplateInfoFromFile;
        if (!P.containsKey(Integer.valueOf(richStatus.tplId)) && (signatureTemplateInfoFromFile = SignatureTemplateConfig.getSignatureTemplateInfoFromFile(qQAppInterface, richStatus.tplId)) != null) {
            P.put(Integer.valueOf(richStatus.tplId), signatureTemplateInfoFromFile);
        }
    }

    public static synchronized void s(boolean z16) {
        synchronized (SignatureManager.class) {
            if (z16) {
                T--;
            }
            if (T < S && !U.isEmpty()) {
                ThreadManagerV2.excute(U.poll(), 32, null, true);
                T++;
            }
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        ConcurrentHashMap<String, RichStatus> concurrentHashMap = this.f195079m;
        if (concurrentHashMap != null) {
            if (str != null) {
                concurrentHashMap.remove(str);
            } else {
                concurrentHashMap.clear();
                this.f195079m = null;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        return true;
    }

    public RichStatus k(String str) {
        RichStatus e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RichStatus) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f195079m == null) {
            synchronized (this) {
                if (this.f195079m == null) {
                    this.f195079m = new ConcurrentHashMap<>();
                }
            }
        }
        ExtensionInfo H = ((FriendsManager) this.f195078i.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(this.f195078i.getAccount());
        if (H != null && (e16 = com.tencent.mobileqq.richstatus.c.e(H)) != null) {
            this.f195079m.put(e16.feedsId, e16);
        }
        return this.f195079m.get(str);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        N = null;
        Q = null;
        g(null);
        com.tencent.mobileqq.vip.h hVar = this.E;
        if (hVar != null) {
            hVar.onDestroy();
        }
        U.clear();
    }

    public void t(List<RichStatus> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            synchronized (this) {
                if (this.f195079m == null) {
                    this.f195079m = new ConcurrentHashMap<>();
                }
            }
            for (RichStatus richStatus : list) {
                if (!TextUtils.isEmpty(richStatus.feedsId)) {
                    this.f195079m.put(richStatus.feedsId, richStatus);
                }
            }
        }
    }
}
