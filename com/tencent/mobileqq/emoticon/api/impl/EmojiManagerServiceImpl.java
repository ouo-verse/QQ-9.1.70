package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import com.tencent.util.LRULinkedHashMap;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmojiManagerServiceImpl implements IEmojiManagerService {
    static IPatchRedirector $redirector_ = null;
    static final String COLUMN_NAME_FILE_LIST = "fileList";
    private static String JSON_PREFIX;
    private static int PACKAGE_TYPE_AUDIO;
    private static int PACKAGE_TYPE_VIDEO;
    private static final String TAG;
    public static com.tencent.mobileqq.emoticon.b listenerManager;
    public static int sCurPlayTimes;
    public static long sRecordBeginTime;
    public static boolean sStartRecord;
    com.tencent.mobileqq.vip.f coverDownloadListener;
    public JobQueue emoQueue;
    public com.tencent.mobileqq.vip.f emotionDownloadListener;
    Map<String, String> encryptKeyMap;
    public boolean haveInitFav;
    public boolean haveInitFavWeb;
    public boolean haveInitSmallAndNormal;
    com.tencent.mobileqq.vip.f jsonDownloadListener;
    int limitSize;
    int localGetKeySeq;
    BaseQQAppInterface mApp;
    LRULinkedHashMap<String, ArrayList<String>> mH5MagicFileListCache;
    public HashMap<String, String> mapParams;
    public ConcurrentHashMap<String, TaskStatus> statusMap;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        a(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EmojiManagerServiceImpl.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            try {
                Bundle h16 = gVar.h();
                EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
                if (emoticonPackage == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmojiManagerServiceImpl.TAG, 2, "jsonDownloadListener : onDone epid = " + emoticonPackage.epId + ";task status = " + gVar.i());
                }
                if (gVar.i() != 3) {
                    QLog.e(EmojiManagerServiceImpl.TAG, 1, "jsonDownloadListener : ondone error , reportCode = " + gVar.f313006d);
                    EmojiManagerServiceImpl.listenerManager.j(emoticonPackage, -1, h16);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "3", emoticonPackage.epId, "", "", gVar.f313006d + "", "", "", "");
                    return;
                }
                String handleJsonFileDownload = EmotionJsonUtils.handleJsonFileDownload(EmojiManagerServiceImpl.this.mApp, gVar, h16.getBoolean(EmojiManagerServiceConstant.PARAMS_IS_SMALLEMOTION));
                if (handleJsonFileDownload != null) {
                    QLog.e(EmojiManagerServiceImpl.TAG, 1, "jsonDownloadListener : parse json error : = " + handleJsonFileDownload);
                    EmojiManagerServiceImpl.this.reportEmoticonDownData(emoticonPackage, DigestErrCode.MSG_PARTIAL_SUCCESS_OF_BATCH, 0L, gVar.f313026x);
                    return;
                }
                EmojiManagerServiceImpl.listenerManager.j(emoticonPackage, 0, h16);
            } catch (Exception e16) {
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "json download fail", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        b(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EmojiManagerServiceImpl.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            Bundle h16 = gVar.h();
            int i16 = h16.getInt(gVar.f313011i);
            EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
            if (QLog.isColorLevel()) {
                QLog.d(EmojiManagerServiceImpl.TAG, 2, "coverDownloadListener| onDone:epId=" + emoticonPackage.epId + " task:" + gVar + " localVersion=" + emoticonPackage.localVersion + ",latestVersion=" + emoticonPackage.latestVersion + ",updateFlag=" + emoticonPackage.updateFlag);
            }
            if (gVar.i() != 3) {
                int b16 = com.tencent.mobileqq.emosm.e.b(gVar.f313006d);
                if (EmojiManagerServiceConstant.isCover(i16)) {
                    EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener(emoticonPackage, i16, -1, b16);
                }
                EmojiManagerServiceImpl.listenerManager.k(emoticonPackage, b16, EmojiManagerServiceImpl.this.mApp);
                i3 = b16;
            } else {
                EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener(emoticonPackage, i16, 0, 0);
                i3 = 0;
            }
            EmojiManagerServiceImpl.this.reportEmoticonDownData(emoticonPackage, i3, gVar.I - gVar.H, gVar.f313026x);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            Bundle h16 = gVar.h();
            int i3 = h16.getInt(gVar.f313011i);
            EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
            if (QLog.isColorLevel()) {
                QLog.d(EmojiManagerServiceImpl.TAG, 2, "coverDownloadListener | onProgress:epId=" + emoticonPackage.epId + gVar);
            }
            if (EmojiManagerServiceConstant.isCover(i3)) {
                EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener(emoticonPackage, i3, 0, 0);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            return super.onStart(gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        c(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EmojiManagerServiceImpl.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                return;
            }
            try {
                super.onDone(gVar);
                Bundle h16 = gVar.h();
                EmojiManagerServiceImpl.this.statusMap.remove(((EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG)).epId);
                int i3 = h16.getInt("businessType");
                if (gVar.i() != 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                EmojiManagerServiceImpl.this.handleEmoticonPackageDownloaded(h16, gVar, z16, gVar.f313006d, gVar.f313026x, gVar.I - gVar.H, i3);
            } catch (Exception e16) {
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "onDone failed", e16);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            try {
                Bundle h16 = gVar.h();
                int i3 = h16.getInt(gVar.f313011i);
                EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
                if (emoticonPackage == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmojiManagerServiceImpl.TAG, 2, "emotionDownloadListener | onDoneFile epId=" + emoticonPackage.epId + ",task:" + gVar);
                }
                EmojiManagerServiceImpl.listenerManager.notifyPackageProgress(emoticonPackage, (int) gVar.f313013k, (int) gVar.f313014l);
                if (i3 == 9) {
                    String string = h16.getString(gVar.f313011i + EmojiManagerServiceConstant.PARAMS_EMOTICON_EID);
                    if (!TextUtils.isEmpty(string)) {
                        EmojiManagerServiceImpl.this.reportSoundEmoticonDownload(emoticonPackage.epId, string, gVar.f313006d);
                    }
                }
                if (gVar.f313006d != 0) {
                    QLog.e(EmojiManagerServiceImpl.TAG, 1, "onDoneFile : ondone error , reportCode = " + gVar.f313006d);
                    if (EmojiManagerServiceConstant.isCover(i3)) {
                        EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener(emoticonPackage, i3, -1, gVar.f313006d);
                    }
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "10", emoticonPackage.epId, "", "", gVar.f313006d + "", "", "", "");
                    return;
                }
                if (EmojiManagerServiceConstant.isCover(i3)) {
                    EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener(emoticonPackage, i3, 0, 0);
                } else if (i3 == 7) {
                    EmojiManagerServiceImpl.this.handleEmotionEncryptKey(gVar);
                }
                int i16 = emoticonPackage.jobType;
                if (i16 == 3 || i16 == 5) {
                    EmojiManagerServiceImpl.this.handleMagicOrH5MagicDownloadOnDoneFile(gVar);
                }
            } catch (Exception e16) {
                QLog.e(EmojiManagerServiceImpl.TAG, 1, "onDoneFile failed", e16);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            EmojiManagerServiceImpl.listenerManager.notifyPackageStart((EmoticonPackage) gVar.h().getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG));
            super.onStart(gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReqInfo f204708c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f204709d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(EmoticonHandler emoticonHandler, ReqInfo reqInfo, Object obj) {
            super(emoticonHandler);
            this.f204708c = reqInfo;
            this.f204709d = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EmojiManagerServiceImpl.this, emoticonHandler, reqInfo, obj);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.g
        public void a(boolean z16, int i3, EmoticonResp emoticonResp) {
            Object valueOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), emoticonResp);
                return;
            }
            if (this.f204716a.get() == null) {
                return;
            }
            EmoticonHandler emoticonHandler = this.f204716a.get();
            int i16 = emoticonResp.epId;
            int i17 = emoticonResp.timestamp;
            ArrayList arrayList = (ArrayList) emoticonResp.data;
            String str = this.f204708c.strGetKeySeq;
            if (str != null && str.equals(emoticonResp.keySeq)) {
                emoticonHandler.V2(this);
                ReqInfo reqInfo = this.f204708c;
                reqInfo.encryptKeysSuccess = z16;
                reqInfo.encryptKeysResultCode = emoticonResp.resultcode;
                reqInfo.timeoutReason = emoticonResp.timeoutReason;
                synchronized (this.f204709d) {
                    this.f204709d.notify();
                }
            }
            if (QLog.isColorLevel()) {
                String str2 = EmojiManagerServiceImpl.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fetchEmoticonEncryptKeys|net get key backepId=");
                sb5.append(i16);
                sb5.append(" tstamp=");
                sb5.append(i17);
                sb5.append(" list.size=");
                if (arrayList == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(arrayList.size());
                }
                sb5.append(valueOf);
                sb5.append(" encryptSuccess=");
                sb5.append(z16);
                sb5.append(" type=");
                sb5.append(i3);
                sb5.append(" er.resultCode=");
                sb5.append(emoticonResp.resultcode);
                QLog.d(str2, 2, sb5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e extends EmotionJsonDownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f204711a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f204712b;

        e(String str, Object obj) {
            this.f204711a = str;
            this.f204712b = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EmojiManagerServiceImpl.this, str, obj);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, emoticonPackage, Integer.valueOf(i3), bundle);
            } else if (emoticonPackage.epId.equals(this.f204711a)) {
                synchronized (this.f204712b) {
                    this.f204712b.notify();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f extends FavEmoRoamingObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f204714d;

        f(Object obj) {
            this.f204714d = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmojiManagerServiceImpl.this, obj);
            }
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        protected void onUploadReq(List<CustomEmotionData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            synchronized (this.f204714d) {
                this.f204714d.notify();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<EmoticonHandler> f204716a;

        public g(EmoticonHandler emoticonHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmojiManagerServiceImpl.this, (Object) emoticonHandler);
            } else {
                this.f204716a = new WeakReference<>(emoticonHandler);
            }
        }

        public void a(boolean z16, int i3, EmoticonResp emoticonResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), emoticonResp);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 61)) {
            redirector.redirect((short) 61);
            return;
        }
        TAG = EmojiManagerServiceImpl.class.getSimpleName();
        PACKAGE_TYPE_AUDIO = 0;
        PACKAGE_TYPE_VIDEO = 1;
        sCurPlayTimes = 0;
        sRecordBeginTime = 0L;
        sStartRecord = false;
        listenerManager = null;
        JSON_PREFIX = "json_";
    }

    public EmojiManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mApp = null;
        this.encryptKeyMap = new HashMap();
        this.mapParams = new HashMap<>();
        this.statusMap = new ConcurrentHashMap<>();
        this.limitSize = QzoneConfig.DefaultValue.DEFAULT_WEISHI_VIDEO_MAX_BITRATE;
        this.haveInitFavWeb = false;
        this.haveInitSmallAndNormal = false;
        this.haveInitFav = false;
        this.emoQueue = new JobQueue(3);
        this.jsonDownloadListener = new a(AppConstants.FlowStatPram.PARAM_WIFIEMOJI_STORE_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGEMOJI_STORE_DOWNLOAD_FLOW);
        this.coverDownloadListener = new b(AppConstants.FlowStatPram.PARAM_WIFIEMOJI_STORE_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGEMOJI_STORE_DOWNLOAD_FLOW);
        this.emotionDownloadListener = new c(AppConstants.FlowStatPram.PARAM_WIFIEMOJI_STORE_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGEMOJI_STORE_DOWNLOAD_FLOW);
        this.mH5MagicFileListCache = new LRULinkedHashMap<>(20);
        this.localGetKeySeq = 0;
    }

    private boolean checkH5Resource(String str) {
        ArrayList<String> arrayList;
        try {
            synchronized (this.mH5MagicFileListCache) {
                if (this.mH5MagicFileListCache.containsKey(str)) {
                    arrayList = this.mH5MagicFileListCache.get(str);
                } else {
                    arrayList = null;
                }
            }
            if (arrayList == null) {
                File file = new File(MarketFaceConstants.H5MagicFileListPath.replace("[epId]", str));
                if (!file.exists()) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
                ArrayList<String> arrayList2 = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray(COLUMN_NAME_FILE_LIST);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String string = jSONArray.getString(i3);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList2.add(string);
                    }
                }
                synchronized (this.mH5MagicFileListCache) {
                    this.mH5MagicFileListCache.put(str, arrayList2);
                }
                arrayList = arrayList2;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                File file2 = new File(it.next());
                if (!file2.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "checkH5MagicFacePackageIntact, file miss: " + file2);
                    }
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(e16));
            }
            return false;
        }
    }

    private boolean checkMagicPackage(String str, String str2, String str3, File file) {
        String readFileContent = FileUtils.readFileContent(file);
        if (readFileContent != null) {
            for (String str4 : readFileContent.split(ContainerUtils.FIELD_DELIMITER)) {
                if (!new File(str3 + str2 + File.separator + str4).exists()) {
                    return false;
                }
            }
        }
        File file2 = new File(str3 + "audio" + File.separator + "audio.ini");
        if (!file2.exists()) {
            return false;
        }
        String readFileContent2 = FileUtils.readFileContent(file2);
        if (readFileContent2 != null) {
            for (String str5 : readFileContent2.split(ContainerUtils.FIELD_DELIMITER)) {
                if (!new File(str3 + "audio" + File.separator + str5).exists()) {
                    return false;
                }
            }
        }
        if (!checkPackageIntact(str, PACKAGE_TYPE_VIDEO)) {
            return false;
        }
        return checkMagicFileExist(str);
    }

    private boolean checkSDCardNoAvailable(Emoticon emoticon) {
        if (Utils.B()) {
            if (Utils.z() < 1048576) {
                QLog.d(TAG, 1, "sdcard check, sdcard full .return.");
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "1", emoticon.epId, emoticon.eId, "", "", "", "", "");
                return true;
            }
            return false;
        }
        QLog.d(TAG, 1, "sdcard check, has sdcard FALSE .return.");
        VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "2", emoticon.epId, emoticon.eId, "", "", "", "", "");
        return true;
    }

    private Emoticon downloadAndGetKey(Emoticon emoticon) {
        String str = emoticon.epId;
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class);
        EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(str);
        Emoticon syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(str, emoticon.eId);
        if (syncFindEmoticonPackageById == null || syncFindEmoticonById == null) {
            Object obj = new Object();
            e eVar = new e(str, obj);
            com.tencent.mobileqq.emoticon.b.b().addEmotionJsonDownloadListener(eVar);
            startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
            synchronized (obj) {
                try {
                    obj.wait(35000L);
                } catch (InterruptedException unused) {
                }
            }
            com.tencent.mobileqq.emoticon.b.b().removeEmotionJsonDownloadListener(eVar);
            EmoticonPackage syncFindEmoticonPackageById2 = iEmoticonManagerService.syncFindEmoticonPackageById(str);
            syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(str, emoticon.eId);
            if (syncFindEmoticonPackageById2 == null || syncFindEmoticonById == null) {
                QLog.e(TAG, 1, "downloadAndGetKey fail to download package, epId: " + str);
                return null;
            }
        }
        int i3 = syncFindEmoticonById.jobType;
        if ((i3 == 0 || i3 == 2 || i3 == 4) && !syncFindEmoticonById.hasEncryptKey()) {
            ArrayList<Emoticon> arrayList = new ArrayList<>(1);
            arrayList.add(syncFindEmoticonById);
            ReqInfo reqInfo = new ReqInfo();
            fetchEmoticonEncryptKeys(str, arrayList, reqInfo);
            if (!reqInfo.encryptKeysSuccess) {
                QLog.e(TAG, 1, "downloadAndGetKey fail to getKey, epId: " + str + " eId: " + syncFindEmoticonById.eId);
                return null;
            }
        }
        return syncFindEmoticonById;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r16 != 6) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0038, code lost:
    
        if (com.tencent.mobileqq.core.util.a.h(r27.updateFlag) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        r10 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0045, code lost:
    
        if (isH5MagicFacePackageIntact(r15, true, true) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
    
        r12 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
    
        r3 = 0;
        r10 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0054, code lost:
    
        if (isMagicFacePackageIntact(r15, java.lang.Boolean.TRUE) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006e, code lost:
    
        if (com.tencent.mobileqq.core.util.a.h(r27.updateFlag) != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle getPackageBundle(String str, int i3, int i16, int i17, int i18, int i19, long j3, int i26, int i27, ArrayList<String> arrayList, ArrayList<String> arrayList2, EmoticonPackage emoticonPackage) {
        int i28;
        int i29;
        int i36 = i16;
        int i37 = 0;
        if (i36 == -1) {
            int i38 = 4;
            int i39 = 100;
            int i46 = 3;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            if (emoticonPackage != null && emoticonPackage.status == 2) {
                                if (isSmallEmoticonPackageIntact(str)) {
                                }
                                i38 = 0;
                                i39 = 0;
                                i36 = 0;
                            }
                        }
                    } else if (emoticonPackage != null && emoticonPackage.status == 2) {
                    }
                    i38 = i18;
                    i39 = i26;
                } else {
                    if (emoticonPackage != null && emoticonPackage.status == 2) {
                    }
                    i38 = i18;
                    i39 = i26;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getPackageStatus| query result in DB or not DB, epId:" + str + ",result=" + i36 + " status=" + i38 + " progress=" + i39);
                }
                i28 = i38;
                i29 = i39;
            }
            if (emoticonPackage != null && emoticonPackage.status == 2) {
                if (isEmoticonPackageIntact(str)) {
                }
                i38 = 0;
                i39 = 0;
                i36 = 0;
                if (QLog.isColorLevel()) {
                }
                i28 = i38;
                i29 = i39;
            }
            i38 = i18;
            i39 = i26;
            if (QLog.isColorLevel()) {
            }
            i28 = i38;
            i29 = i39;
        } else if (QLog.isColorLevel()) {
            String str2 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getPackageStatus| query result in running... result=");
            sb5.append(i36);
            sb5.append(" status=");
            i28 = i18;
            sb5.append(i28);
            sb5.append(" progress=");
            i29 = i26;
            sb5.append(i29);
            QLog.d(str2, 2, sb5.toString());
        } else {
            i28 = i18;
            i29 = i26;
        }
        if (i36 == -1) {
            i29 = 0;
            i28 = 0;
        } else {
            i37 = i36;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("result", i37);
        bundle.putInt("status", i28);
        bundle.putInt("pluginStatus", i19);
        bundle.putLong("pluginSize", j3);
        bundle.putInt("progress", i29);
        bundle.putInt("dEmojiId", i27);
        bundle.putInt("flag", i17);
        bundle.putStringArrayList("srcList", arrayList);
        bundle.putStringArrayList("urlParamsList", arrayList2);
        return bundle;
    }

    private boolean handleDowloadPreviewStaticTask(Emoticon emoticon, int i3) {
        if ((i3 & 1) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3);
            }
            String[] imgPreviewStaticTask = getImgPreviewStaticTask(emoticon);
            if (!FileUtils.fileExists(imgPreviewStaticTask[1])) {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(imgPreviewStaticTask[0], new File(imgPreviewStaticTask[1]));
                gVar.Q = true;
                gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
                int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, this.mApp);
                if (download != 0) {
                    QLog.e(TAG, 1, "task aio static down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";ret = " + download);
                    String str = emoticon.epId;
                    String str2 = emoticon.eId;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
                    sb5.append("");
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "9", str, str2, sb5.toString(), download + "", "", "", "");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean handleDownloadGifApngTask(Emoticon emoticon, int i3) {
        String[] strArr;
        com.tencent.mobileqq.vip.g gVar;
        int i16;
        int i17;
        if ((i3 & 4) == 4 || (i3 & 32) == 32) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
            }
            File file = null;
            if (emoticon.jobType != 1) {
                if ((i3 & 32) == 32) {
                    i17 = 2;
                } else {
                    i17 = 0;
                }
                strArr = handleImgGif(emoticon, i17);
                ReqInfo reqInfo = new ReqInfo();
                if (emoticon.jobType != 3 && TextUtils.isEmpty(emoticon.encryptKey)) {
                    ArrayList<Emoticon> arrayList = new ArrayList<>();
                    arrayList.add(emoticon);
                    fetchEmoticonEncryptKeys(emoticon.epId, arrayList, reqInfo);
                    if (TextUtils.isEmpty(emoticon.encryptKey)) {
                        QLog.i(TAG, 1, "Emoticon don't have encryptKey,epId=" + emoticon.epId + ", eid=" + emoticon.eId + " type=4");
                        VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "4", emoticon.epId, emoticon.eId, "", "", "", "", "");
                        return true;
                    }
                }
            } else {
                strArr = null;
            }
            if (strArr == null) {
                return true;
            }
            boolean fileExists = FileUtils.fileExists(strArr[1]);
            if (!fileExists) {
                file = new File(strArr[1]);
                gVar = new com.tencent.mobileqq.vip.g(strArr[0], file);
                gVar.Q = true;
                gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
                int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, this.mApp);
                if (download != 0) {
                    QLog.e(TAG, 1, "task gif down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ":ret = " + download);
                    String str = emoticon.epId;
                    String str2 = emoticon.eId;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
                    sb5.append("");
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "5", str, str2, sb5.toString(), download + "", "", "", "");
                    return true;
                }
            } else {
                gVar = null;
            }
            if (!fileExists && emoticon.jobType != 1) {
                try {
                    byte[] fileToBytes = FileUtils.fileToBytes(file);
                    String absolutePath = file.getAbsolutePath();
                    file.delete();
                    if (fileToBytes == null) {
                        QLog.e(TAG, 1, "task gif 2 fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId);
                        VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "6", emoticon.epId, emoticon.eId, "", "", "", "", "");
                        return true;
                    }
                    int i18 = emoticon.jobType;
                    if (i18 != 3) {
                        i16 = com.tencent.mobileqq.emosm.e.F(fileToBytes, emoticon.encryptKey, absolutePath);
                    } else if (i18 == 3) {
                        i16 = com.tencent.mobileqq.emosm.e.E(fileToBytes, absolutePath);
                    } else {
                        i16 = 0;
                    }
                    if (i16 != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "onProgress download encrypt exception, url=" + gVar.f313011i);
                        }
                        if (Utils.B() && Utils.z() > 1048576) {
                            FileUtils.pushData2File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + NotificationCompat.CATEGORY_ERROR + File.separator + String.valueOf(emoticon.epId) + "_" + emoticon.encryptKey + "_" + file.getName()), fileToBytes, false);
                        }
                        QLog.e(TAG, 1, "task gif save fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";emosmCode = " + i16);
                        String str3 = emoticon.epId;
                        String str4 = emoticon.eId;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(i16);
                        sb6.append("");
                        VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "7", str3, str4, "", sb6.toString(), "", "", "");
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onProgress| Emotiocon encode resource done.result=" + i16 + " time:" + System.currentTimeMillis() + " url=" + gVar.f313011i);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + th5.toString() + " time:" + System.currentTimeMillis() + " url=" + gVar.f313011i);
                    }
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "8", emoticon.epId, emoticon.eId, "", "", "", "", "");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean handleDownloadPreviewTask(Emoticon emoticon, int i3) {
        if ((i3 & 2) == 2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis() + ",jobType:" + emoticon.jobType);
            }
            String[] imgPreviewTask = getImgPreviewTask(emoticon);
            if (!FileUtils.fileExists(imgPreviewTask[1])) {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(imgPreviewTask[0], new File(imgPreviewTask[1]));
                gVar.Q = true;
                gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
                int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, this.mApp);
                if (download != 0) {
                    QLog.e(TAG, 1, "task preview down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "3", emoticon.epId, emoticon.eId, NetworkUtil.getNetworkType(this.mApp.getApplication()) + "", download + "", "", "", "");
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "ret:" + download);
                }
            }
        }
        return false;
    }

    private boolean handleDownloadSoundTask(Emoticon emoticon, int i3) {
        if (emoticon.isSound && (i3 & 8) == 8) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
            }
            String[] soundTask = getSoundTask(emoticon);
            if (!FileUtils.fileExists(soundTask[1])) {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(soundTask[0], new File(soundTask[1]));
                gVar.Q = true;
                gVar.B = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
                int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, this.mApp);
                if (download != 0) {
                    QLog.e(TAG, 1, "task sound down fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";ret = " + download);
                    String str = emoticon.epId;
                    String str2 = emoticon.eId;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(NetworkUtil.getNetworkType(this.mApp.getApplication()));
                    sb5.append("");
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_AIO, "10", str, str2, sb5.toString(), download + "", "", "", "");
                    if (emoticon.isNewSoundEmoticon()) {
                        reportSoundEmoticonDownload(emoticon.epId, emoticon.eId, gVar.f313006d);
                    }
                    return false;
                }
                if (emoticon.isNewSoundEmoticon()) {
                    reportSoundEmoticonDownload(emoticon.epId, emoticon.eId, 0);
                }
            }
        }
        return true;
    }

    private void handleImgPreviewStaticTask(List<String> list, Map<String, File> map, Bundle bundle, int i3, Emoticon emoticon) {
        int i16;
        if ((i3 & 1) == 1) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3);
            }
            String[] imgPreviewStaticTask = getImgPreviewStaticTask(emoticon);
            if (!FileUtils.fileExists(imgPreviewStaticTask[1])) {
                list.add(imgPreviewStaticTask[0]);
                map.put(imgPreviewStaticTask[0], new File(imgPreviewStaticTask[1]));
                String str = imgPreviewStaticTask[0];
                if (emoticon.jobType == 1) {
                    i16 = 15;
                } else {
                    i16 = 8;
                }
                bundle.putInt(str, i16);
            }
        }
    }

    private void handleRscGifTask(EmoticonPackage emoticonPackage, List<String> list, Map<String, File> map, Bundle bundle, Emoticon emoticon, String[] strArr) {
        boolean fileExists;
        if (emoticonPackage.rscType == 1) {
            fileExists = com.tencent.mobileqq.magicface.drawable.d.a(MarketFaceConstants.pngFramePath.replace("[epId]", emoticon.epId));
        } else {
            fileExists = FileUtils.fileExists(strArr[1]);
        }
        if (!fileExists) {
            list.add(strArr[0]);
            map.put(strArr[0], new File(strArr[1]));
            if (emoticonPackage.rscType == 1) {
                bundle.putInt(strArr[0], 16);
            } else if (emoticonPackage.jobType != 1) {
                bundle.putInt(strArr[0], 7);
                synchronized (this.encryptKeyMap) {
                    this.encryptKeyMap.put(strArr[0], emoticon.encryptKey);
                }
            }
        }
    }

    private void handleSoundFileTask(List<String> list, Map<String, File> map, Bundle bundle, int i3, Emoticon emoticon) {
        if (emoticon.isSound && (i3 & 8) == 8) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "addEmoticonsTask| Emoticon download emo sound.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3);
            }
            String[] soundTask = getSoundTask(emoticon);
            if (!FileUtils.fileExists(soundTask[1])) {
                list.add(soundTask[0]);
                map.put(soundTask[0], new File(soundTask[1]));
                bundle.putInt(soundTask[0], 9);
                if (emoticon.isNewSoundEmoticon()) {
                    bundle.putString(soundTask[0] + EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, emoticon.eId);
                }
            }
        }
    }

    private boolean isValidEmoPackage(int i3, int i16) {
        if (i3 == 2 && i16 == 1) {
            return true;
        }
        if (i3 == 3 && i16 == 3) {
            return true;
        }
        if (i3 == 4 && i16 == 5) {
            return true;
        }
        if (i3 == 5 && i16 == 4) {
            return true;
        }
        if (i3 == 1 && i16 == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSoundEmoticonDownload(String str, String str2, int i3) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoResID", str2);
        hashMap.put("emoPackageID", str);
        hashMap.put("result", i3 + "");
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(account, StatisticCollector.EMOTION_SOUND_DOWNLOAD, z16, 0L, 0L, hashMap, null);
    }

    void addAudioTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        if (!checkPackageIntact(emoticonPackage.epId, PACKAGE_TYPE_AUDIO)) {
            String y16 = com.tencent.mobileqq.emosm.e.y(emoticonPackage.epId, 0);
            String replace = MarketFaceConstants.magicFaceZipPath.replace("[epId]", emoticonPackage.epId);
            if (!FileUtils.fileExists(replace)) {
                list.add(y16);
                map.put(y16, new File(replace));
                bundle.putInt(y16, 21);
            }
        }
    }

    void addColorGrayTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        int i3;
        int i16;
        String str = emoticonPackage.epId;
        int i17 = emoticonPackage.jobType;
        if (i17 == 2) {
            str = emoticonPackage.kinId;
            i3 = 13;
            i16 = 14;
        } else if (i17 == 4) {
            i3 = 17;
            i16 = 18;
        } else {
            i3 = 3;
            i16 = 4;
        }
        String p16 = com.tencent.mobileqq.emosm.e.p(i3, str);
        String n3 = com.tencent.mobileqq.emosm.e.n(3, emoticonPackage.epId);
        if (!FileUtils.fileExists(n3)) {
            list.add(p16);
            map.put(p16, new File(n3));
            bundle.putInt(p16, 3);
        }
        String p17 = com.tencent.mobileqq.emosm.e.p(i16, str);
        String n16 = com.tencent.mobileqq.emosm.e.n(4, emoticonPackage.epId);
        if (!FileUtils.fileExists(n16)) {
            list.add(p17);
            map.put(p17, new File(n16));
            bundle.putInt(p17, 4);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public int addEmotionTaskByList(EmoticonPackage emoticonPackage, ArrayList<Emoticon> arrayList, List<String> list, Map<String, File> map, Bundle bundle, int i3) {
        int i16;
        String[] strArr;
        int i17;
        Emoticon emoticon;
        int i18;
        boolean z16;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 4;
        int i27 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, this, emoticonPackage, arrayList, list, map, bundle, Integer.valueOf(i3))).intValue();
        }
        int i28 = 0;
        while (i28 < arrayList.size()) {
            Emoticon emoticon2 = arrayList.get(i28);
            if ((i3 & 2) == i27) {
                if (QLog.isDevelopLevel()) {
                    String str = TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("addEmoticonsTask| Emoticon download emo imgPreview.pid=");
                    sb5.append(emoticon2.epId);
                    sb5.append(" eid=");
                    sb5.append(emoticon2.eId);
                    sb5.append(" type=");
                    sb5.append(i3);
                    sb5.append(" time:");
                    i16 = i28;
                    sb5.append(System.currentTimeMillis());
                    QLog.d(str, i26, sb5.toString());
                } else {
                    i16 = i28;
                }
                String[] imgPreviewTask = getImgPreviewTask(emoticon2);
                if (!FileUtils.fileExists(imgPreviewTask[1])) {
                    list.add(imgPreviewTask[0]);
                    map.put(imgPreviewTask[0], new File(imgPreviewTask[1]));
                    String str2 = imgPreviewTask[0];
                    if (emoticon2.jobType == 1) {
                        i19 = 15;
                    } else {
                        i19 = 6;
                    }
                    bundle.putInt(str2, i19);
                }
            } else {
                i16 = i28;
            }
            if ((i3 & 4) != 4 && (i3 & 32) != 32) {
                emoticon = emoticon2;
                i18 = i16;
                i17 = 2;
                i26 = 4;
                z16 = true;
            } else {
                if (QLog.isDevelopLevel()) {
                    i26 = 4;
                    QLog.d(TAG, 4, "addEmoticonsTask| Emoticon download emo gif.pid=" + emoticon2.epId + " eid=" + emoticon2.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
                } else {
                    i26 = 4;
                }
                if (emoticonPackage.jobType != 1) {
                    if (emoticon2.hasEncryptKey()) {
                        int i29 = emoticonPackage.rscType;
                        if ((i3 & 32) == 32) {
                            i29 = 2;
                        }
                        strArr = handleImgGif(emoticon2, i29);
                    } else {
                        return 11009;
                    }
                } else {
                    strArr = null;
                }
                String[] strArr2 = strArr;
                if (strArr2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + emoticon2.epId + " eid=" + emoticon2.eId);
                        return 11030;
                    }
                    return 11030;
                }
                i17 = 2;
                emoticon = emoticon2;
                i18 = i16;
                z16 = true;
                handleRscGifTask(emoticonPackage, list, map, bundle, emoticon, strArr2);
            }
            Emoticon emoticon3 = emoticon;
            handleImgPreviewStaticTask(list, map, bundle, i3, emoticon3);
            handleSoundFileTask(list, map, bundle, i3, emoticon3);
            i28 = i18 + 1;
            i27 = i17;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int addEmotionsTask(File file, EmoticonPackage emoticonPackage, boolean z16, List<String> list, Map<String, File> map, Bundle bundle, int i3) {
        byte[] bArr;
        byte[] fileToBytes;
        String parseJson;
        String str;
        int i16;
        boolean z17;
        ArrayList<Emoticon> arrayList = new ArrayList<>();
        ReqInfo reqInfo = new ReqInfo();
        if (file != null) {
            try {
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "OutOfMemoryError e = " + e16.getMessage());
                bArr = null;
            }
            if (file.exists()) {
                fileToBytes = FileUtils.fileToBytes(file);
                bArr = fileToBytes;
                if (emoticonPackage.jobType != 4) {
                    parseJson = EmotionJsonUtils.parseSmallJson(this.mApp, emoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bArr, arrayList);
                } else {
                    parseJson = EmotionJsonUtils.parseJson(this.mApp, emoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bArr, arrayList, reqInfo);
                }
                str = parseJson;
                if (emoticonPackage.isAPNG != 2) {
                    i16 = i3 | 32;
                } else {
                    i16 = i3;
                }
                if (str == null) {
                    QLog.e(TAG, 1, "addEmotionsTask| parse json error");
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "4", emoticonPackage.epId, "", "", str, "", "", "");
                    return DigestErrCode.MSG_PARTIAL_SUCCESS_OF_BATCH;
                }
                if (!TextUtils.isEmpty(emoticonPackage.minQQVersion) && !IndividuationConfigInfo.isLaterVersion(emoticonPackage.minQQVersion, AppSetting.f99551k)) {
                    QLog.e(TAG, 1, "unavailable in current version, min version=" + emoticonPackage.minQQVersion);
                    return 11011;
                }
                bundle.putBoolean("isUpdate", z16);
                bundle.putSerializable(EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST, arrayList);
                if (!reqInfo.encryptKeysSuccess && emoticonPackage.jobType != 4) {
                    int i17 = 0;
                    do {
                        reqInfo.strGetKeySeq = null;
                        fetchEmoticonEncryptKeys(emoticonPackage.epId, arrayList, reqInfo);
                        i17++;
                        z17 = reqInfo.encryptKeysSuccess;
                        if (z17) {
                            break;
                        }
                    } while (i17 < 3);
                    if (!z17) {
                        QLog.e(TAG, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + emoticonPackage.epId + " encryptGetKeySeq=" + reqInfo.strGetKeySeq + " encryptKeysResultCode" + reqInfo.encryptKeysResultCode);
                        return 11009;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i17 + " encryptKeysSuccess=" + reqInfo.encryptKeysSuccess);
                    }
                }
                if (emoticonPackage.jobType == 4) {
                    return addSmallEmoticonTaskByList(emoticonPackage, arrayList, list, map, bundle, i16, z16);
                }
                return addEmotionTaskByList(emoticonPackage, arrayList, list, map, bundle, i16);
            }
        }
        fileToBytes = null;
        bArr = fileToBytes;
        if (emoticonPackage.jobType != 4) {
        }
        str = parseJson;
        if (emoticonPackage.isAPNG != 2) {
        }
        if (str == null) {
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void addH5MagicChildDownloadTask(EmoticonPackage emoticonPackage, boolean z16) {
        EmoticonHandler emoticonHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, emoticonPackage, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(emoticonPackage.childEpId) || "0".equals(emoticonPackage.childEpId) || this.mApp == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + emoticonPackage.childEpId);
        }
        if (z16 && (emoticonHandler = (EmoticonHandler) this.mApp.getBusinessHandler(EmoticonHandler.F)) != null) {
            emoticonHandler.W2(emoticonPackage.childEpId, 0);
        }
        EmoticonPackage syncFindTabEmoticonPackageById = getEmoticonManager().syncFindTabEmoticonPackageById(emoticonPackage.childEpId, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleEmotionPackage| old childEp = " + syncFindTabEmoticonPackageById);
        }
        if (syncFindTabEmoticonPackageById == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleEmotionPackage| childEpId = " + emoticonPackage.childEpId);
            }
            syncFindTabEmoticonPackageById = new EmoticonPackage();
            syncFindTabEmoticonPackageById.epId = emoticonPackage.childEpId;
            syncFindTabEmoticonPackageById.wordingId = -1L;
            syncFindTabEmoticonPackageById.jobType = 5;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleEmotionPackage| auto download childEp = " + syncFindTabEmoticonPackageById);
        }
        pullEmoticonPackage(syncFindTabEmoticonPackageById, z16);
    }

    void addH5MagicDownloadTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleEmotionPackage|add h5magic task ");
        }
        if (!isH5MagicFacePackageIntact(emoticonPackage.epId, true, false)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleEmotionPackage| add h5 zip url");
            }
            String x16 = com.tencent.mobileqq.emosm.e.x(emoticonPackage.epId);
            String w3 = com.tencent.mobileqq.emosm.e.w(emoticonPackage.epId);
            if (w3 != null) {
                list.add(x16);
                map.put(x16, new File(w3));
                bundle.putInt(x16, 20);
            }
        }
    }

    void addMagicDownloadTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleEmotionPackage|add magic task ");
        }
        addVideoTask(list, map, emoticonPackage, bundle);
        addAudioTask(list, map, emoticonPackage, bundle);
    }

    int addSmallEmoticonTaskByList(EmoticonPackage emoticonPackage, ArrayList<Emoticon> arrayList, List<String> list, Map<String, File> map, Bundle bundle, int i3, boolean z16) {
        int i16;
        char c16;
        int i17 = 0;
        for (int size = arrayList.size(); i17 < size; size = i16) {
            Emoticon emoticon = arrayList.get(i17);
            if ((i3 & 2) == 2) {
                if (QLog.isDevelopLevel()) {
                    String str = TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("addEmoticonsTask| Emoticon download emo imgPreview.pid=");
                    sb5.append(emoticon.epId);
                    sb5.append(" eid=");
                    sb5.append(emoticon.eId);
                    sb5.append(" type=");
                    sb5.append(i3);
                    sb5.append(" time:");
                    i16 = size;
                    sb5.append(System.currentTimeMillis());
                    QLog.d(str, 4, sb5.toString());
                } else {
                    i16 = size;
                }
                String[] imgPreviewTask = getImgPreviewTask(emoticon);
                if (!FileUtils.fileExists(imgPreviewTask[1]) || z16) {
                    list.add(imgPreviewTask[0]);
                    map.put(imgPreviewTask[0], new File(imgPreviewTask[1]));
                    bundle.putInt(imgPreviewTask[0], 6);
                }
            } else {
                i16 = size;
            }
            if ((i3 & 4) == 4 || (i3 & 32) == 32) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "addEmoticonsTask| Emoticon download emo gif.pid=" + emoticon.epId + " eid=" + emoticon.eId + " type=" + i3 + " time:" + System.currentTimeMillis());
                }
                String[] handleImgGif = handleImgGif(emoticon, emoticonPackage.rscType);
                if (FileUtils.fileExists(handleImgGif[1]) && !z16) {
                    c16 = 0;
                } else {
                    c16 = 0;
                    list.add(handleImgGif[0]);
                }
                map.put(handleImgGif[c16], new File(handleImgGif[1]));
                bundle.putInt(handleImgGif[c16], 7);
            }
            i17++;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void addThumbTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, list, map, emoticonPackage, bundle);
            return;
        }
        int i16 = emoticonPackage.jobType;
        if (i16 == 4) {
            i3 = 19;
        } else {
            i3 = 2;
        }
        if (i16 == 2) {
            str = emoticonPackage.kinId;
        } else {
            str = emoticonPackage.epId;
        }
        String p16 = com.tencent.mobileqq.emosm.e.p(i3, str);
        String n3 = com.tencent.mobileqq.emosm.e.n(2, emoticonPackage.epId);
        if (!FileUtils.fileExists(n3)) {
            list.add(p16);
            map.put(p16, new File(n3));
            bundle.putInt(p16, 2);
        }
    }

    void addVideoTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle) {
        if (!checkPackageIntact(emoticonPackage.epId, PACKAGE_TYPE_VIDEO)) {
            String y16 = com.tencent.mobileqq.emosm.e.y(emoticonPackage.epId, 1);
            String replace = MarketFaceConstants.magicFaceZipPath.replace("[epId]", emoticonPackage.epId);
            if (!FileUtils.fileExists(replace)) {
                list.add(y16);
                map.put(y16, new File(replace));
                bundle.putInt(y16, 21);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean canPlayH5Magic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        boolean z16 = this.mApp.getApplication().getSharedPreferences(EmojiManagerServiceConstant.H5MAGIC_SP_NAME, 4).getBoolean(EmojiManagerServiceConstant.H5MAGIC_SP_ISPLAY_KEY, false);
        boolean isDPCSupportH5Magic = isDPCSupportH5Magic();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPlayH5Magic isPlay = " + z16 + ";isDPCSupport = " + isDPCSupportH5Magic);
        }
        if (z16 || !isDPCSupportH5Magic) {
            return false;
        }
        return true;
    }

    public boolean checkEmoticonPackageIntact(String str) {
        int i3;
        String replace;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        String n3 = com.tencent.mobileqq.emosm.e.n(2, str);
        if (!new File(n3).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cover_pkg_thumb isn't exist." + n3);
            }
            return false;
        }
        String n16 = com.tencent.mobileqq.emosm.e.n(3, str);
        if (!new File(n16).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cover_pkg_color isn't exist." + n16);
            }
            return false;
        }
        String n17 = com.tencent.mobileqq.emosm.e.n(4, str);
        if (!new File(n17).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cover_pkg_gray isn't exist." + n17);
            }
            return false;
        }
        ArrayList arrayList = (ArrayList) getEmoticonManager().syncGetSubEmoticonsByPackageId(str, true);
        if (arrayList != null) {
            EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(str, -1);
            if (syncFindEmoticonPackageById != null) {
                i3 = syncFindEmoticonPackageById.rscType;
            } else {
                i3 = 0;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Emoticon emoticon = (Emoticon) it.next();
                if (emoticon == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "one of encrypts is null!" + str);
                    }
                    return false;
                }
                if (emoticon.jobType == 0 && ((str2 = emoticon.encryptKey) == null || str2.length() == 0)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "encrypt isn't exist.epId=" + str + " eId=" + emoticon.eId);
                    }
                    return false;
                }
                if (!new File(MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", emoticon.eId)).exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "emo img preview do not be exist! epId=" + str + " eId=" + emoticon.eId);
                    }
                    return false;
                }
                if (1 == i3) {
                    return com.tencent.mobileqq.magicface.drawable.d.a(MarketFaceConstants.pngFramePath.replace("[epId]", str));
                }
                if (syncFindEmoticonPackageById != null && syncFindEmoticonPackageById.isAPNG == 2) {
                    replace = MarketFaceConstants.emoticonAPNGPath.replace("[epId]", str).replace("[eId]", emoticon.eId);
                } else {
                    replace = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", str).replace("[eId]", emoticon.eId);
                }
                if (!new File(replace).exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "emo img encrypt file do not be exist! epId=" + str + " eId=" + emoticon.eId);
                    }
                    return false;
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "emoticons do not be exist.epId=" + str);
        }
        return true;
    }

    boolean checkH5MagicFacePackageIntact(String str, boolean z16) {
        String str2;
        if (z16) {
            ArrayList arrayList = (ArrayList) getEmoticonManager().syncGetSubEmoticonsByPackageId(str);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    Emoticon emoticon = (Emoticon) it.next();
                    if (emoticon == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + str);
                        }
                        return false;
                    }
                    if (emoticon.jobType == 4 && ((str2 = emoticon.encryptKey) == null || str2.length() == 0)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + str + " eId=" + emoticon.eId);
                        }
                        return false;
                    }
                    if (!new File(MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", emoticon.eId)).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + str + " eId=" + emoticon.eId);
                        }
                        return false;
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + str);
                }
                return false;
            }
        }
        File file = new File(MarketFaceConstants.H5MagicRootPath.replace("[epId]", str));
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkH5MagicFacePackageIntact, no root path: " + file);
            }
            return false;
        }
        return checkH5Resource(str);
    }

    boolean checkMagicFacePackageIntact(String str, Boolean bool) {
        String str2;
        if (str == null) {
            return false;
        }
        if (bool.booleanValue()) {
            ArrayList arrayList = (ArrayList) getEmoticonManager().syncGetSubEmoticonsByPackageId(str);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    Emoticon emoticon = (Emoticon) it.next();
                    if (emoticon == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "one of encrypts is null!" + str);
                        }
                        return false;
                    }
                    if (emoticon.jobType == 2 && ((str2 = emoticon.encryptKey) == null || str2.length() == 0)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "encrypt isn't exist.epId=" + str + " eId=" + emoticon.eId);
                        }
                        return false;
                    }
                    if (!new File(MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", emoticon.eId)).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "emo img preview do not be exist! epId=" + str + " eId=" + emoticon.eId);
                        }
                        return false;
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "emoticons do not be exist.epId=" + str);
                }
                return false;
            }
        }
        String d16 = com.tencent.mobileqq.magicface.model.f.d();
        String replace = MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(replace);
        sb5.append(d16);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("video.ini");
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            String str4 = replace + "big" + str3 + "video.ini";
            file = new File(str4);
            if (!file.exists()) {
                return false;
            }
            sb6 = str4;
            d16 = "big";
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "videoConfigPath ==" + sb6);
        }
        return checkMagicPackage(str, d16, replace, file);
    }

    protected boolean checkMagicFileExist(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str)).booleanValue();
        }
        EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(str);
        if (syncFindEmoticonPackageById != null) {
            i3 = syncFindEmoticonPackageById.rscType;
        } else {
            i3 = 0;
        }
        if (1 == i3) {
            return com.tencent.mobileqq.magicface.drawable.d.a(MarketFaceConstants.pngFramePath.replace("[epId]", str));
        }
        ArrayList arrayList = (ArrayList) getEmoticonManager().syncGetSubEmoticonsByPackageId(str);
        if (arrayList == null || arrayList.size() <= 0 || new File(MarketFaceConstants.emoticonEncryptPath.replace("[epId]", str).replace("[eId]", ((Emoticon) arrayList.get(0)).eId)).exists()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "emo img encrypt file do not be exist! epId=" + str + " eId=" + ((Emoticon) arrayList.get(0)).eId);
        }
        return false;
    }

    public boolean checkPackageIntact(String str, int i3) {
        String readFileContent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str, i3)).booleanValue();
        }
        String replace = MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", str);
        if (i3 == PACKAGE_TYPE_VIDEO) {
            String d16 = com.tencent.mobileqq.magicface.model.f.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(replace);
            sb5.append(d16);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("video.ini");
            String sb6 = sb5.toString();
            File file = new File(sb6);
            if (!file.exists()) {
                String str3 = replace + "big" + str2 + "video.ini";
                file = new File(str3);
                if (!file.exists()) {
                    return false;
                }
                sb6 = str3;
                d16 = "big";
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "videoConfigPath ==" + sb6);
            }
            for (String str4 : FileUtils.readFileContent(file).split(ContainerUtils.FIELD_DELIMITER)) {
                if (!new File(replace + d16 + File.separator + str4).exists()) {
                    return false;
                }
            }
            return true;
        }
        if (i3 == PACKAGE_TYPE_AUDIO) {
            File file2 = new File(replace + "audio" + File.separator + "audio.ini");
            if (!file2.exists() || (readFileContent = FileUtils.readFileContent(file2)) == null) {
                return false;
            }
            for (String str5 : readFileContent.split(ContainerUtils.FIELD_DELIMITER)) {
                if (!new File(replace + "audio" + File.separator + str5).exists()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean checkSmallEmoticonPackageIntact(String str) {
        String replace;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        String n3 = com.tencent.mobileqq.emosm.e.n(2, str);
        if (!new File(n3).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + n3);
            }
            return false;
        }
        String n16 = com.tencent.mobileqq.emosm.e.n(3, str);
        if (!new File(n16).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + n16);
            }
            return false;
        }
        String n17 = com.tencent.mobileqq.emosm.e.n(4, str);
        if (!new File(n17).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + n17);
            }
            return false;
        }
        ArrayList arrayList = (ArrayList) getEmoticonManager().syncGetSubEmoticonsByPackageId(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Emoticon emoticon = (Emoticon) it.next();
                if (emoticon == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "one of encrypts is null!" + str);
                    }
                    return false;
                }
                if (!new File(MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", emoticon.eId)).exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + str + " eId=" + emoticon.eId);
                    }
                    return false;
                }
                EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(str, -1);
                if (syncFindEmoticonPackageById != null && syncFindEmoticonPackageById.isAPNG == 2) {
                    replace = MarketFaceConstants.emoticonAPNGPath.replace("[epId]", str).replace("[eId]", emoticon.eId);
                } else {
                    replace = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", str).replace("[eId]", emoticon.eId);
                }
                if (!new File(replace).exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + str + " eId=" + emoticon.eId);
                    }
                    return false;
                }
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + str);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public int collectEmoji(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) ? collectEmoji(emoticon, false) : ((Integer) iPatchRedirector.redirect((short) 50, (Object) this, (Object) emoticon)).intValue();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean downloadAIOEmoticon(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        if (emoticon == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadAIOEmoticon|taskvalue:" + i3 + "\uff0cepid:" + emoticon.epId + "\uff0ceid=" + emoticon.eId);
        }
        if (checkSDCardNoAvailable(emoticon) || handleDownloadPreviewTask(emoticon, i3) || handleDownloadGifApngTask(emoticon, i3) || handleDowloadPreviewStaticTask(emoticon, i3)) {
            return false;
        }
        return handleDownloadSoundTask(emoticon, i3);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void fetchEmoticonEncryptKeys(String str, ArrayList<Emoticon> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) arrayList);
            return;
        }
        int m3 = com.tencent.mobileqq.core.util.a.m(str);
        if (arrayList == null || arrayList.size() == 0 || m3 == -1) {
            return;
        }
        int i3 = this.localGetKeySeq;
        this.localGetKeySeq = i3 + 1;
        ((EmoticonHandler) this.mApp.getBusinessHandler(EmoticonHandler.F)).I2(m3, arrayList, Integer.toString(i3));
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void generateFileList(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        ArrayList<String> childFiles = FileUtils.getChildFiles(str2);
        if (childFiles != null && childFiles.size() > 0) {
            synchronized (this.mH5MagicFileListCache) {
                this.mH5MagicFileListCache.put(str, childFiles);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = childFiles.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    jSONArray.mo162put(next);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(COLUMN_NAME_FILE_LIST, jSONArray);
                FileUtils.writeFile(MarketFaceConstants.H5MagicFileListPath.replace("[epId]", str), jSONObject.toString());
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public Bundle getAllDownloadProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bundle) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) getEmoticonManager().syncGetTabEmoticonPackages(i3);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                EmoticonPackage emoticonPackage = (EmoticonPackage) it.next();
                int i16 = emoticonPackage.jobType;
                if (i16 == 0) {
                    arrayList.add(getPackageStatus(emoticonPackage.epId, 1, i3));
                } else if (i16 == 3) {
                    arrayList.add(getPackageStatus(emoticonPackage.epId, 3, i3));
                } else if (i16 == 5) {
                    arrayList.add(getPackageStatus(emoticonPackage.epId, 4, i3));
                } else if (i16 == 4) {
                    arrayList.add(getPackageStatus(emoticonPackage.epId, 5, i3));
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pkgStatusList", arrayList);
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle getDownloadProgress(Bundle bundle) {
        String string;
        int i3;
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bundle) iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
        }
        if (bundle == null) {
            string = "";
            i3 = -1;
            i16 = 0;
        } else {
            string = bundle.getString("id");
            i3 = bundle.getInt("businessType");
            i16 = bundle.getInt("sceneType");
            if (string.length() != 0 && com.tencent.mobileqq.core.util.a.m(string) != -1) {
                z16 = true;
                Bundle bundle2 = new Bundle();
                if (!z16) {
                    Bundle packageStatus = getPackageStatus(string, i3, i16);
                    bundle2.putInt("result", packageStatus.getInt("result"));
                    bundle2.putString("messge", "");
                    bundle2.putInt("id", -1);
                    bundle2.putInt("status", packageStatus.getInt("status"));
                    bundle2.putInt("pluginStatus", packageStatus.getInt("pluginStatus"));
                    bundle2.putLong("pluginSize", packageStatus.getLong("pluginSize"));
                    bundle2.putInt("progress", packageStatus.getInt("progress"));
                    bundle2.putInt("dynamicEmojiId", packageStatus.getInt("dEmojiId"));
                    bundle2.putStringArrayList("dynamicEmojiList", packageStatus.getStringArrayList("srcList"));
                    bundle2.putStringArrayList("urlParamsList", packageStatus.getStringArrayList("urlParamsList"));
                } else {
                    bundle2.putInt("result", 0);
                    bundle2.putString("messge", "");
                    bundle2.putInt("id", -1);
                    bundle2.putInt("status", 0);
                    bundle2.putInt("pluginStatus", 0);
                    bundle2.putLong("pluginSize", 0L);
                    bundle2.putInt("progress", 0);
                    bundle2.putInt("dynamicEmojiId", -1);
                    bundle2.putStringArrayList("dynamicEmojiList", null);
                    bundle2.putStringArrayList("urlParamsList", null);
                }
                return bundle2;
            }
        }
        z16 = false;
        Bundle bundle22 = new Bundle();
        if (!z16) {
        }
        return bundle22;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public h getDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public JobQueue getEmoQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (JobQueue) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.emoQueue;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public IEmojiListenerManager getEmojiListenerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IEmojiListenerManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return listenerManager;
    }

    public boolean getEmoticonJsonLodingStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        com.tencent.mobileqq.vip.g task = getDownloader().getTask(com.tencent.mobileqq.core.util.a.c(str));
        if (task == null || task.j()) {
            return false;
        }
        return true;
    }

    public IEmoticonManagerService getEmoticonManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IEmoticonManagerService) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public float getEmoticonPackageLoadingProgress(String str) {
        TaskStatus taskStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Float) iPatchRedirector.redirect((short) 52, (Object) this, (Object) str)).floatValue();
        }
        if (str == null || str.length() == 0 || (taskStatus = this.statusMap.get(str)) == null) {
            return -1.0f;
        }
        return taskStatus.getPercent();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean getHaveInitFav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return this.haveInitFav;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean getHaveInitSmallAndNormal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        return this.haveInitSmallAndNormal;
    }

    String[] getImgPreviewStaticTask(Emoticon emoticon) {
        String str;
        String str2;
        String str3;
        if (emoticon.jobType != 1) {
            boolean supportExtensionDisplay = supportExtensionDisplay(emoticon);
            String replace = EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
            String str4 = "200";
            if (!supportExtensionDisplay) {
                str3 = "200";
            } else {
                str3 = String.valueOf(emoticon.extensionWidth);
            }
            String replace2 = replace.replace("[width]", str3);
            if (supportExtensionDisplay) {
                str4 = String.valueOf(emoticon.extensionHeight);
            }
            str = replace2.replace("[height]", str4);
            str2 = MarketFaceConstants.emoticonAIOPreviewPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        } else {
            str = null;
            str2 = null;
        }
        return new String[]{str, str2};
    }

    String[] getImgPreviewTask(Emoticon emoticon) {
        return getImgPreviewTask(emoticon.epId, emoticon.eId, emoticon.jobType == 3);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean getMagicFaceSendAccessControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        int i3 = sCurPlayTimes;
        if (i3 == 4) {
            if (System.currentTimeMillis() - sRecordBeginTime <= 15000) {
                return false;
            }
            sCurPlayTimes = 0;
            sStartRecord = false;
            return true;
        }
        int i16 = i3 + 1;
        sCurPlayTimes = i16;
        if (i16 == 4 && !sStartRecord) {
            sStartRecord = true;
            sRecordBeginTime = System.currentTimeMillis();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Bundle getPackageStatus(String str, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        EmoticonPackage syncFindTabEmoticonPackageById = getEmoticonManager().syncFindTabEmoticonPackageById(str, i16);
        if (syncFindTabEmoticonPackageById != null) {
            i17 = syncFindTabEmoticonPackageById.valid;
        } else {
            i17 = 0;
        }
        int i27 = i17;
        if (i3 == 2) {
            i27 = 1;
        }
        int i28 = i27;
        TaskStatus taskStatus = this.statusMap.get(str);
        if (taskStatus != null && !taskStatus.isCancel()) {
            i19 = (int) taskStatus.getPercent();
            i18 = 2;
            i26 = 0;
        } else {
            i18 = 0;
            i19 = 0;
            i26 = -1;
        }
        return getPackageBundle(str, i3, i26, i28, i18, 0, 0L, i19, -1, null, null, syncFindTabEmoticonPackageById);
    }

    String[] getSoundTask(Emoticon emoticon) {
        return new String[]{EmotionPanelConstans.emoticonSoundUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId), MarketFaceConstants.emoticonSoundPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId)};
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public ConcurrentHashMap<String, TaskStatus> getStatusMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.statusMap;
    }

    public void handleEmoticonPackageDownload(EmoticonPackage emoticonPackage, com.tencent.mobileqq.vip.f fVar, boolean z16, boolean z17, int i3) {
        int i16;
        int i17;
        Bundle bundle;
        HashMap hashMap;
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, emoticonPackage, fVar, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            String str3 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("package download epId:");
            if (emoticonPackage != null) {
                str2 = emoticonPackage.epId;
            } else {
                str2 = "null";
            }
            sb5.append(str2);
            QLog.d(str3, 2, sb5.toString());
        }
        if (emoticonPackage != null && this.mApp != null) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QLog.e(TAG, 1, "netUnSupport epId=" + emoticonPackage.epId);
                listenerManager.k(emoticonPackage, DigestErrCode.SPACE_NOT_ENOUGH, this.mApp);
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "2", emoticonPackage.epId, "", "", "", "", "", "");
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("businessType", i3);
            bundle2.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, emoticonPackage);
            bundle2.putBoolean(EmojiManagerServiceConstant.PARAMS_PKG_NEW_ADD, z16);
            bundle2.putBoolean(EmojiManagerServiceConstant.PARAMS_SWITCH_TAB, z17);
            int i18 = emoticonPackage.jobType;
            if (i18 == 3 && emoticonPackage.isMagicFaceDownloading) {
                str = "vipEmoticonKey_auto_" + emoticonPackage.epId;
                bundle = bundle2;
                hashMap = hashMap2;
                arrayList = arrayList3;
            } else {
                if (i18 == 5) {
                    ((VasEmojiManager) ((IEmosmService) QRoute.api(IEmosmService.class)).getVasEmojiManager(this.mApp)).a(emoticonPackage, z16, z17);
                    return;
                }
                String str4 = EmojiManagerServiceConstant.KEY_PRE + emoticonPackage.epId;
                String c16 = com.tencent.mobileqq.core.util.a.c(emoticonPackage.epId);
                if (emoticonPackage.jobType == 4) {
                    c16 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", emoticonPackage.epId);
                }
                File file = new File(MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", emoticonPackage.epId));
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(c16, file);
                TaskStatus taskStatus = new TaskStatus(emoticonPackage.epId, gVar);
                this.statusMap.put(JSON_PREFIX + emoticonPackage.epId, taskStatus);
                gVar.C = EmojiManagerServiceConstant.EMOTION_TRY_DOWNLOAD;
                gVar.K = true;
                gVar.Q = true;
                int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, this.mApp);
                this.statusMap.remove(JSON_PREFIX + emoticonPackage.epId);
                listenerManager.c(emoticonPackage, download);
                if (download != 0) {
                    QLog.e(TAG, 1, "json download faile : resultCode = " + download);
                    int b16 = com.tencent.mobileqq.emosm.e.b(download);
                    listenerManager.k(emoticonPackage, b16, this.mApp);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "3", emoticonPackage.epId, "", NetworkUtil.getNetworkType(this.mApp.getApplication()) + "", b16 + "", "", "", "");
                    return;
                }
                boolean b17 = com.tencent.mobileqq.core.util.a.b(emoticonPackage);
                int i19 = emoticonPackage.jobType;
                if ((i19 == 0 || i19 == 4) && !b17) {
                    addColorGrayTask(arrayList3, hashMap2, emoticonPackage, bundle2);
                }
                addThumbTask(arrayList3, hashMap2, emoticonPackage, bundle2);
                if (emoticonPackage.isAPNG == 2) {
                    i16 = 42;
                } else {
                    i16 = 14;
                }
                int i26 = emoticonPackage.jobType;
                if (i26 == 5) {
                    i17 = 6;
                } else {
                    if (i26 == 3) {
                        i16 |= 1;
                    }
                    i17 = i16;
                }
                bundle = bundle2;
                hashMap = hashMap2;
                arrayList = arrayList3;
                int addEmotionsTask = addEmotionsTask(file, emoticonPackage, b17, arrayList3, hashMap2, bundle, i17);
                if (addEmotionsTask != 0) {
                    QLog.e(TAG, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + addEmotionsTask);
                    listenerManager.k(emoticonPackage, addEmotionsTask, this.mApp);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "5", emoticonPackage.epId, "", "", addEmotionsTask + "", "", "", "");
                    return;
                }
                str = str4;
            }
            int i27 = emoticonPackage.jobType;
            if (i27 == 3) {
                arrayList2 = arrayList;
                addMagicDownloadTask(arrayList2, hashMap, emoticonPackage, bundle);
            } else {
                arrayList2 = arrayList;
                if (i27 == 5) {
                    addH5MagicDownloadTask(arrayList2, hashMap, emoticonPackage, bundle);
                }
            }
            com.tencent.mobileqq.vip.g gVar2 = new com.tencent.mobileqq.vip.g(arrayList2, hashMap, str);
            if (!str.contains("auto")) {
                ConcurrentHashMap<String, TaskStatus> concurrentHashMap = this.statusMap;
                String str5 = emoticonPackage.epId;
                concurrentHashMap.put(str5, new TaskStatus(str5, gVar2));
            }
            gVar2.Q = true;
            if (arrayList2.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleEmotionPackage| urlList is empty");
                }
                gVar2.w(bundle);
                gVar2.y(3);
                fVar.onDone(gVar2);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleEmotionPackage| startDownload");
                }
                getDownloader().startDownload(gVar2, fVar, bundle);
            }
            if (emoticonPackage.jobType == 5) {
                addH5MagicChildDownloadTask(emoticonPackage, z16);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "ep or mApp = null");
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void handleEmoticonPackageDownloaded(Bundle bundle, Object obj, boolean z16, int i3, String str, long j3, int i16) {
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bundle, obj, Boolean.valueOf(z16), Integer.valueOf(i3), str, Long.valueOf(j3), Integer.valueOf(i16));
            return;
        }
        boolean z18 = bundle.getBoolean(EmojiManagerServiceConstant.PARAMS_PKG_NEW_ADD, false);
        boolean z19 = bundle.getBoolean("isUpdate", false);
        boolean z26 = bundle.getBoolean(EmojiManagerServiceConstant.PARAMS_SWITCH_TAB, true);
        EmoticonPackage emoticonPackage = (EmoticonPackage) bundle.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
        if (emoticonPackage == null) {
            return;
        }
        int i18 = emoticonPackage.jobType;
        if (i18 != 3 && i18 != 5) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDone:epId=" + emoticonPackage.epId + " task:" + obj + " localVersion=" + emoticonPackage.localVersion + ",latestVersion=" + emoticonPackage.latestVersion + ",updateFlag=" + emoticonPackage.updateFlag);
        }
        try {
            if (z16) {
                int b16 = com.tencent.mobileqq.emosm.e.b(i3);
                QLog.e(TAG, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + i3);
                listenerManager.k(emoticonPackage, b16, this.mApp);
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "11", emoticonPackage.epId, "", "", i3 + "", "", "", "");
                reportEmoticonDownData(emoticonPackage, b16, 0L, str);
                if (z18) {
                    if (emoticonPackage.type == 1) {
                        i17 = 5;
                    } else {
                        i17 = 4;
                    }
                    EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(String.valueOf(b16), i17);
                    return;
                }
                return;
            }
            if (z19 && !z17) {
                ArrayList arrayList = (ArrayList) bundle.getSerializable(EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST);
                if (arrayList != null && arrayList.size() > 0) {
                    getEmoticonManager().reconstructEmoticonPackage(emoticonPackage.epId, arrayList);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "update package:" + emoticonPackage.epId + ",newEmoticons:" + arrayList.size());
                    }
                }
            } else {
                int i19 = emoticonPackage.latestVersion;
                if (i19 > emoticonPackage.localVersion) {
                    emoticonPackage.localVersion = i19;
                }
                emoticonPackage.hasReadUpdatePage = false;
            }
            emoticonPackage.updateFlag &= -2;
            emoticonPackage.status = 2;
            emoticonPackage.valid = true;
            IEmoticonManagerService emoticonManager = getEmoticonManager();
            emoticonManager.saveEmoticonPackage(emoticonPackage);
            if (emoticonPackage.jobType == 5) {
                EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
                List<? extends Entity> query = createEntityManager.query(EmoticonPackage.class, true, "childEpId=?", new String[]{emoticonPackage.epId}, null, null, null, null);
                if (query != null && query.size() > 0) {
                    Iterator<? extends Entity> it = query.iterator();
                    while (it.hasNext()) {
                        isH5MagicFacePackageIntact(((EmoticonPackage) it.next()).epId, true, true);
                    }
                }
                createEntityManager.close();
            }
            if (z18) {
                synchronized (this) {
                    emoticonManager.addTabEmoticonPackage(emoticonPackage, i16);
                }
                listenerManager.e(emoticonPackage, this.mApp);
            }
            if (!z26) {
                emoticonPackage.extraFlags |= 2;
            }
            listenerManager.l(emoticonPackage);
            reportEmoticonDownData(emoticonPackage, 0, j3, str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleEmoticonPackageDownloaded failed", e16);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void handleEmotionEncryptKey(com.tencent.mobileqq.vip.g gVar) {
        String str;
        String str2;
        int F;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
            return;
        }
        if (gVar == null) {
            return;
        }
        EmoticonPackage emoticonPackage = (EmoticonPackage) gVar.h().getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
        File file = gVar.f313010h.get(gVar.f313011i);
        try {
            byte[] bArr = null;
            if (this.encryptKeyMap.containsKey(gVar.f313011i)) {
                synchronized (this.encryptKeyMap) {
                    str = this.encryptKeyMap.get(gVar.f313011i);
                    this.encryptKeyMap.remove(gVar.f313011i);
                }
            } else {
                str = null;
            }
            if (file != null) {
                bArr = FileUtils.fileToBytes(file);
                str2 = file.getAbsolutePath();
                file.delete();
            } else {
                str2 = null;
            }
            if (bArr != null && str2 != null) {
                int i3 = emoticonPackage.jobType;
                if (i3 != 4 && str == null) {
                    gVar.f313002b = true;
                    QLog.e(TAG, 1, "emotionDownloadListener | onDoneFile encryptKey loss");
                    listenerManager.k(emoticonPackage, 11009, this.mApp);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "7", emoticonPackage.epId, "", "", "", "", "", "");
                    return;
                }
                if (i3 == 4) {
                    F = com.tencent.mobileqq.emosm.e.E(bArr, str2);
                } else {
                    F = com.tencent.mobileqq.emosm.e.F(bArr, str, str2);
                }
                if (F != 0) {
                    QLog.e(TAG, 2, "emotionDownloadListener | onDoneFile onProgress download encrypt exception, url=" + gVar.f313011i);
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "8", emoticonPackage.epId, "", "", F + "", "", "", "");
                    if (Utils.B() && Utils.z() > 1048576) {
                        FileUtils.pushData2File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + NotificationCompat.CATEGORY_ERROR + File.separator + String.valueOf(emoticonPackage.epId) + "_" + file.getName()), bArr, false);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "emotionDownloadListener | onDoneFile Emotion encode resource done.result=" + F + " time:" + System.currentTimeMillis() + " url=" + gVar.f313011i);
                    return;
                }
                return;
            }
            gVar.f313002b = true;
            QLog.e(TAG, 1, "emotionDownloadListener | onDoneFile srcData or filePath = null");
            listenerManager.k(emoticonPackage, 11013, this.mApp);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "6", emoticonPackage.epId, "", "", "", "", "", "");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e(TAG, 2, "emotionDownloadListener | onDoneFile onProgress Emotion encode resource fail .EXCEPTION:" + th5.toString() + " time:" + System.currentTimeMillis() + " url=" + gVar.f313011i);
            gVar.f313002b = true;
            listenerManager.k(emoticonPackage, 11020, this.mApp);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "9", emoticonPackage.epId, "", "", "", "", "", "");
        }
    }

    String[] handleImgGif(Emoticon emoticon, int i3) {
        String str;
        String replace;
        String str2;
        if (emoticon.jobType == 3) {
            replace = EmotionPanelConstans.smallGifUrl.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            if (i3 == 2) {
                replace = EmotionPanelConstans.smallApngUrl.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            }
        } else {
            boolean supportExtensionDisplay = supportExtensionDisplay(emoticon);
            if (1 == i3) {
                replace = EmotionPanelConstans.emoticonPNGZIPUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
            } else {
                String str3 = "200";
                if (i3 == 2) {
                    String replace2 = EmotionPanelConstans.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
                    if (!supportExtensionDisplay) {
                        str2 = "200";
                    } else {
                        str2 = String.valueOf(emoticon.extensionWidth);
                    }
                    String replace3 = replace2.replace("[width]", str2);
                    if (supportExtensionDisplay) {
                        str3 = String.valueOf(emoticon.extensionHeight);
                    }
                    replace = replace3.replace("[height]", str3);
                } else {
                    String replace4 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", emoticon.eId.substring(0, 2)).replace("[eId]", emoticon.eId);
                    if (!supportExtensionDisplay) {
                        str = "200";
                    } else {
                        str = String.valueOf(emoticon.extensionWidth);
                    }
                    String replace5 = replace4.replace("[width]", str);
                    if (supportExtensionDisplay) {
                        str3 = String.valueOf(emoticon.extensionHeight);
                    }
                    replace = replace5.replace("[height]", str3);
                }
            }
        }
        String replace6 = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        if (i3 == 2) {
            replace6 = MarketFaceConstants.emoticonAPNGPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        }
        if (1 == i3 && !TextUtils.isEmpty(replace6)) {
            replace6 = replace6 + ".zip";
        }
        return new String[]{replace, replace6};
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void handleMagicOrH5MagicDownloadOnDoneFile(com.tencent.mobileqq.vip.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gVar);
            return;
        }
        if (gVar == null) {
            return;
        }
        Bundle h16 = gVar.h();
        int i3 = h16.getInt(gVar.f313011i);
        EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
        File file = gVar.f313010h.get(gVar.f313011i);
        if (i3 != 2) {
            if (i3 != 16) {
                if (i3 == 21) {
                    try {
                        FileUtils.uncompressZip(file.getAbsolutePath(), MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", emoticonPackage.epId), false);
                    } catch (IOException e16) {
                        gVar.f313002b = true;
                        e16.printStackTrace();
                    }
                    file.delete();
                    return;
                }
                return;
            }
            try {
                FileUtils.uncompressZip(file.getAbsolutePath(), MarketFaceConstants.pngFramePath.replace("[epId]", emoticonPackage.epId), false);
                ((IEmosmService) QRoute.api(IEmosmService.class)).reparse(this.mApp, emoticonPackage.epId);
            } catch (IOException e17) {
                gVar.f313002b = true;
                e17.printStackTrace();
            }
            file.delete();
            return;
        }
        listenerManager.notifyEmoticonCoverListener(emoticonPackage, 2, 0, 0);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean isDPCSupportH5Magic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.h5magic_support.name());
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean isEmojiCollected(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) emoticon)).booleanValue();
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (((IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId) == null) {
            startDownloadEmosmJson(emoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
        }
        if (!this.haveInitFavWeb && (emoticonDataList == null || emoticonDataList.isEmpty())) {
            this.haveInitFavWeb = true;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                return false;
            }
            IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) this.mApp.getRuntimeService(IFavroamingManagerService.class);
            if (iFavroamingManagerService.isInSyncing()) {
                Object obj = new Object();
                f fVar = new f(obj);
                this.mApp.addObserver(fVar);
                iFavroamingManagerService.syncLocalDel();
                synchronized (obj) {
                    try {
                        obj.wait(35000L);
                    } catch (InterruptedException unused) {
                    }
                }
                this.mApp.removeObserver(fVar);
                emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
            }
        }
        if (emoticonDataList != null) {
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                CustomEmotionData customEmotionData = emoticonDataList.get(i3);
                if (customEmotionData.isMarkFace && customEmotionData.emoPath.equals(emoticon.epId) && customEmotionData.eId.equals(emoticon.eId)) {
                    return !"needDel".equals(customEmotionData.RomaingType);
                }
            }
        }
        return false;
    }

    public boolean isEmoticonPackageIntact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str)).booleanValue();
        }
        boolean checkEmoticonPackageIntact = checkEmoticonPackageIntact(str);
        updatePackageStatus(str, checkEmoticonPackageIntact);
        return checkEmoticonPackageIntact;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean isH5MagicFacePackageIntact(String str, boolean z16, boolean z17) {
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isH5MagicFacePackageIntact, epId = " + str + ", needKey = " + z16 + ", needCheckChild = " + z17);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean checkH5MagicFacePackageIntact = checkH5MagicFacePackageIntact(str, z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isH5MagicFacePackageIntact, result = " + checkH5MagicFacePackageIntact);
        }
        EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(str);
        if (syncFindEmoticonPackageById != null) {
            if (z17 && !TextUtils.isEmpty(syncFindEmoticonPackageById.childEpId)) {
                z18 = checkH5MagicFacePackageIntact(syncFindEmoticonPackageById.childEpId, z16);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isH5MagicFacePackageIntact, childEpId = " + syncFindEmoticonPackageById.childEpId + ", childResult = " + z18);
                }
                updatePackageStatus(syncFindEmoticonPackageById.childEpId, z18);
            } else {
                z18 = true;
            }
            if (!checkH5MagicFacePackageIntact || !z18) {
                z19 = false;
            }
            updatePackageStatus(str, z19);
            checkH5MagicFacePackageIntact = z19;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isH5MagicFacePackageIntact, epId=" + str + ", result=" + checkH5MagicFacePackageIntact);
        }
        return checkH5MagicFacePackageIntact;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean isH5MagicIntact(String str, boolean z16, boolean z17) {
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (getEmoticonManager().syncFindEmoticonPackageById(str) != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && isH5MagicFacePackageIntact(str, z16, z17)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean isMagicFacePackageIntact(String str, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bool)).booleanValue();
        }
        boolean checkMagicFacePackageIntact = checkMagicFacePackageIntact(str, bool);
        updatePackageStatus(str, checkMagicFacePackageIntact);
        return checkMagicFacePackageIntact;
    }

    public boolean isSmallEmoticonPackageIntact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, (Object) str)).booleanValue();
        }
        boolean checkSmallEmoticonPackageIntact = checkSmallEmoticonPackageIntact(str);
        updatePackageStatus(str, checkSmallEmoticonPackageIntact);
        return checkSmallEmoticonPackageIntact;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (BaseQQAppInterface) appRuntime;
            listenerManager = com.tencent.mobileqq.emoticon.b.b();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clear History. uin:" + this.mApp.getAccount() + " app=" + String.valueOf(this.mApp));
        }
        listenerManager.m();
        if (this.mApp.getAccount() != null && getEmoticonManager() != null) {
            getEmoticonManager().clearCache();
        }
        synchronized (this.encryptKeyMap) {
            this.encryptKeyMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            pullEmoticonPackage(emoticonPackage, z16, true, 0);
        } else {
            iPatchRedirector.redirect((short) 33, this, emoticonPackage, Boolean.valueOf(z16));
        }
    }

    public void reportEmoticonDownData(EmoticonPackage emoticonPackage, int i3, long j3, String str) {
        int i16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, emoticonPackage, Integer.valueOf(i3), Long.valueOf(j3), str);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "download emoji report actionResult=" + i3 + ",epId=" + emoticonPackage.epId + ",downloadTime=" + j3);
        }
        if (i3 != 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(this.mApp.getApp().getApplicationContext());
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        ReportController.o(this.mApp, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i16, emoticonPackage.epId + "", systemNetwork + "", str2, String.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean sendEmojiToAio(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) emoticon)).booleanValue();
        }
        PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.mApp.getCurrentAccountUin());
        picEmoticonInfo.type = 6;
        picEmoticonInfo.isAPNG = emoticon.isAPNG;
        Emoticon downloadAndGetKey = downloadAndGetKey(emoticon);
        if (downloadAndGetKey == null) {
            QLog.e(TAG, 1, "sendEmojiToAio fail to download Emoticon");
            return false;
        }
        picEmoticonInfo.emoticon = downloadAndGetKey;
        ((IEmosmService) QRoute.api(IEmosmService.class)).updateMarketFaceItemBuilderEmoticonInfo(picEmoticonInfo);
        return true;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void setHaveInitFav(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        } else {
            this.haveInitFav = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void setHaveInitSmallAndNormal(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, z16);
        } else {
            this.haveInitSmallAndNormal = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void setStatusMap(ConcurrentHashMap<String, TaskStatus> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) concurrentHashMap);
        } else {
            this.statusMap = concurrentHashMap;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void startCoverDownload(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) emoticonPackage);
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, emoticonPackage);
        addColorGrayTask(arrayList, hashMap, emoticonPackage, bundle);
        addThumbTask(arrayList, hashMap, emoticonPackage, bundle);
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(arrayList, hashMap, "vipEmoticonKey_cover_" + emoticonPackage.epId);
        gVar.E = (long) this.limitSize;
        gVar.Q = true;
        getDownloader().startDownload(gVar, this.coverDownloadListener, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public Bundle startDownloadEmoji(Bundle bundle) {
        EmoticonPackage emoticonPackage;
        String str;
        int i3;
        ?? r85;
        EmoticonPackage emoticonPackage2;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        }
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        String valueOf = String.valueOf(bundle.getInt("id"));
        int i18 = bundle.getInt("businessType");
        int i19 = bundle.getInt("sceneType");
        if (EmojiManagerServiceConstant.getStatus(this.mApp, valueOf) != null) {
            bundle2.putInt("result", 0);
            bundle2.putString("messge", "");
            bundle2.putInt("sceneType", i19);
            return bundle2;
        }
        EmoticonPackage syncFindTabEmoticonPackageById = getEmoticonManager().syncFindTabEmoticonPackageById(valueOf, -1);
        if (syncFindTabEmoticonPackageById != null && (i16 = syncFindTabEmoticonPackageById.status) != 0) {
            if (i16 != 2) {
                if (i16 != 3) {
                    i17 = 1;
                } else {
                    i17 = 4;
                }
            } else {
                pullEmoticonPackage(syncFindTabEmoticonPackageById, true, i19);
                i17 = 0;
            }
            BaseQQAppInterface baseQQAppInterface = this.mApp;
            if (baseQQAppInterface != null) {
                ReportController.o(baseQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, syncFindTabEmoticonPackageById.epId, "" + syncFindTabEmoticonPackageById.localVersion, "" + syncFindTabEmoticonPackageById.latestVersion, "");
            }
            bundle2.putInt("result", i17);
            bundle2.putString("messge", "");
            bundle2.putInt("sceneType", i19);
            return bundle2;
        }
        EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(valueOf, -1);
        if (syncFindEmoticonPackageById != null && !isValidEmoPackage(i18, syncFindEmoticonPackageById.jobType)) {
            getEmoticonManager().removeEmoticonPackage(syncFindEmoticonPackageById);
            emoticonPackage = null;
        } else {
            emoticonPackage = syncFindEmoticonPackageById;
        }
        if (emoticonPackage != null) {
            str = "messge";
            i3 = 5;
            r85 = 0;
            emoticonPackage2 = emoticonPackage;
        } else {
            emoticonPackage2 = new EmoticonPackage();
            emoticonPackage2.epId = valueOf;
            str = "messge";
            emoticonPackage2.wordingId = -1L;
            if (i18 == 2) {
                emoticonPackage2.jobType = 1;
            } else if (i18 == 3) {
                emoticonPackage2.jobType = 3;
            } else {
                if (i18 == 4) {
                    i3 = 5;
                    emoticonPackage2.jobType = 5;
                } else {
                    i3 = 5;
                    if (i18 == 5) {
                        emoticonPackage2.jobType = 4;
                    } else {
                        r85 = 0;
                        emoticonPackage2.jobType = 0;
                    }
                }
                r85 = 0;
            }
            i3 = 5;
            r85 = 0;
        }
        emoticonPackage2.isMagicFaceDownloading = r85;
        if (i18 == 4) {
            emoticonPackage2.jobType = i3;
        }
        pullEmoticonPackage(emoticonPackage2, true, i19);
        bundle2.putInt("result", r85);
        bundle2.putString(str, "");
        bundle2.putInt("sceneType", i19);
        return bundle2;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void startDownloadEmosmJson(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            startDownloadEmosmJson(str, i3, null, false, 0);
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public Bundle stopDownloadPacket(String str, int i3) {
        EmoticonPackage emoticonPackage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bundle) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        if (str == null) {
            return null;
        }
        TaskStatus taskStatus = this.statusMap.get(str);
        if (taskStatus != null) {
            Bundle params = taskStatus.getParams(this.mApp);
            taskStatus.cancel(this.mApp);
            if (params != null && (emoticonPackage = (EmoticonPackage) params.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG)) != null) {
                listenerManager.k(emoticonPackage, 11007, this.mApp);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        bundle.putString("messge", "");
        bundle.putInt("sceneType", i3);
        return bundle;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void stopEmoticonPackageDownload(String str) {
        TaskStatus taskStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        } else if (str != null && (taskStatus = this.statusMap.get(str)) != null) {
            taskStatus.cancel(this.mApp);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean supportExtensionDisplay(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this, (Object) emoticon)).booleanValue();
        }
        if (emoticon != null && emoticon.extensionWidth != 0 && emoticon.extensionHeight != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean tasksFileExists(Emoticon emoticon, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        if (emoticon == null) {
            return true;
        }
        String str = null;
        if ((i3 & 1) == 1) {
            if (emoticon.jobType != 1) {
                str = MarketFaceConstants.emoticonAIOPreviewPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            }
            z16 = FileUtils.fileExists(str);
        } else {
            z16 = true;
        }
        if (z16 && (i3 & 4) == 4) {
            if (emoticon.jobType != 1) {
                str = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
            }
            z16 = FileUtils.fileExists(str);
        }
        if (z16 && (i3 & 2) == 2) {
            z16 = FileUtils.fileExists(MarketFaceConstants.emoticonPreviewPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId));
        }
        if (z16 && emoticon.isSound && (i3 & 8) == 8) {
            z16 = FileUtils.fileExists(MarketFaceConstants.emoticonSoundPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId));
        }
        if (z16 && (i3 & 32) == 32) {
            return FileUtils.fileExists(MarketFaceConstants.emoticonAPNGPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId));
        }
        return z16;
    }

    void updatePackageStatus(String str, boolean z16) {
        EmoticonPackage syncFindEmoticonPackageById = getEmoticonManager().syncFindEmoticonPackageById(str);
        if (syncFindEmoticonPackageById != null) {
            if (z16) {
                if (syncFindEmoticonPackageById.status != 2) {
                    syncFindEmoticonPackageById.status = 2;
                    getEmoticonManager().saveEmoticonPackage(syncFindEmoticonPackageById);
                    return;
                }
                return;
            }
            if (syncFindEmoticonPackageById.status != 0) {
                syncFindEmoticonPackageById.status = 0;
                getEmoticonManager().saveEmoticonPackage(syncFindEmoticonPackageById);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public boolean verifyMagicFacePackageIntact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, (Object) str)).booleanValue();
        }
        return new File(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", str) + "audio" + File.separator + "audio.ini").exists();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public int collectEmoji(Emoticon emoticon, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, this, emoticon, Boolean.valueOf(z16))).intValue();
        }
        Emoticon downloadAndGetKey = downloadAndGetKey(emoticon);
        if (downloadAndGetKey == null) {
            QLog.e(TAG, 1, "collectEmoji fail to download Emoticon");
            return -1;
        }
        return ((IEmosmService) QRoute.api(IEmosmService.class)).addEmotionToFavorite(BaseApplication.getContext(), this.mApp, downloadAndGetKey, z16 ? new Handler(Looper.getMainLooper()) : null);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public String[] getImgPreviewTask(String str, String str2, boolean z16) {
        String replace;
        String replace2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String[]) iPatchRedirector.redirect((short) 22, this, str, str2, Boolean.valueOf(z16));
        }
        if (z16) {
            replace = EmotionPanelConstans.smallEmoticonThumbUrl.replace("[epId]", str).replace("[eId]", str2);
            replace2 = MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", str2);
        } else {
            replace = EmotionPanelConstans.emoticonPreviewUrl.replace("[eIdSub]", str2.substring(0, 2)).replace("[eId]", str2);
            replace2 = MarketFaceConstants.emoticonPreviewPath.replace("[epId]", str).replace("[eId]", str2);
        }
        return new String[]{replace, replace2};
    }

    public void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            pullEmoticonPackage(emoticonPackage, z16, true, i3);
        } else {
            iPatchRedirector.redirect((short) 34, this, emoticonPackage, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void startDownloadEmosmJson(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            startDownloadEmosmJson(str, i3, null, false, i16);
        } else {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16, boolean z17, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, emoticonPackage, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (emoticonPackage == null || (str = emoticonPackage.epId) == null || this.mApp == null) {
            return;
        }
        if (i3 == 0) {
            emoticonPackage.aio = true;
        } else if (i3 == 1) {
            emoticonPackage.kandian = true;
        }
        TaskStatus taskStatus = this.statusMap.get(str);
        TaskStatus taskStatus2 = this.statusMap.get(JSON_PREFIX + emoticonPackage.epId);
        if (taskStatus != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pullEmoticonPackage task exist epId = " + emoticonPackage.epId);
                return;
            }
            return;
        }
        if (taskStatus2 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pullEmoticonPackage jsonTask exist epId = " + emoticonPackage.epId);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "try to pullEmoticonPackage ep:" + emoticonPackage.epId);
        }
        if (!com.tencent.mobileqq.emosm.e.C(emoticonPackage.epId)) {
            QLog.e(TAG, 1, "ep.epId=" + emoticonPackage.epId + " isNumeral false.");
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_DOWNLOAD, "1", emoticonPackage.epId, "", "", "", "", "", "");
            return;
        }
        if (!emoticonPackage.isMagicFaceDownloading) {
            if (emoticonPackage.status != 2 || !com.tencent.mobileqq.core.util.a.h(emoticonPackage.updateFlag)) {
                emoticonPackage.status = 0;
            }
            emoticonPackage.valid = true;
            getEmoticonManager().saveEmoticonPackage(emoticonPackage);
        }
        File file = new File(AppConstants.SDCARD_EMOTICON_SAVE);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mkdirs success:" + mkdirs);
            }
        }
        ThreadManagerV2.excute(new Runnable(emoticonPackage, z16, z17, i3) { // from class: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EmoticonPackage f204701d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f204702e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f204703f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f204704h;

            {
                this.f204701d = emoticonPackage;
                this.f204702e = z16;
                this.f204703f = z17;
                this.f204704h = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, EmojiManagerServiceImpl.this, emoticonPackage, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                EmoticonPackage emoticonPackage2 = this.f204701d;
                if (emoticonPackage2.jobType != 2) {
                    EmojiManagerServiceImpl emojiManagerServiceImpl = EmojiManagerServiceImpl.this;
                    emojiManagerServiceImpl.handleEmoticonPackageDownload(emoticonPackage2, emojiManagerServiceImpl.emotionDownloadListener, this.f204702e, this.f204703f, this.f204704h);
                }
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            startDownloadEmosmJson(str, i3, bundle, z16, 0);
        } else {
            iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), bundle, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), bundle, Boolean.valueOf(z16), Integer.valueOf(i16));
        } else {
            if (str == null || str.length() == 0) {
                return;
            }
            this.emoQueue.excuteOnNetThread(new Runnable(z16, str, i16, i3, bundle) { // from class: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f204696d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f204697e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f204698f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f204699h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Bundle f204700i;

                {
                    this.f204696d = z16;
                    this.f204697e = str;
                    this.f204698f = i16;
                    this.f204699h = i3;
                    this.f204700i = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmojiManagerServiceImpl.this, Boolean.valueOf(z16), str, Integer.valueOf(i16), Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String c16;
                    boolean z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f204696d) {
                        c16 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", this.f204697e);
                    } else {
                        c16 = com.tencent.mobileqq.core.util.a.c(this.f204697e);
                    }
                    com.tencent.mobileqq.vip.g task = EmojiManagerServiceImpl.this.getDownloader().getTask(c16);
                    if (task != null && !task.j()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson|epId is in downloading:" + this.f204697e);
                            return;
                        }
                        return;
                    }
                    EmoticonPackage syncFindEmoticonPackageById = EmojiManagerServiceImpl.this.getEmoticonManager().syncFindEmoticonPackageById(this.f204697e, this.f204698f);
                    if (syncFindEmoticonPackageById == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.f204697e);
                        }
                        syncFindEmoticonPackageById = new EmoticonPackage();
                        syncFindEmoticonPackageById.epId = this.f204697e;
                        syncFindEmoticonPackageById.status = 0;
                        int i17 = this.f204698f;
                        if (i17 == 0) {
                            syncFindEmoticonPackageById.aio = true;
                        } else if (i17 == 1) {
                            syncFindEmoticonPackageById.kandian = true;
                        }
                        EmojiManagerServiceImpl.this.getEmoticonManager().saveEmoticonPackage(syncFindEmoticonPackageById);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmojiManagerServiceImpl.TAG, 2, "startDownloadEmosmJson epId:" + syncFindEmoticonPackageById.epId);
                    }
                    com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(c16, new File(MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", this.f204697e)));
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("jsonType", this.f204699h);
                    bundle2.putSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG, syncFindEmoticonPackageById);
                    bundle2.putBoolean(EmojiManagerServiceConstant.PARAMS_IS_SMALLEMOTION, this.f204696d);
                    Bundle bundle3 = this.f204700i;
                    if (bundle3 != null) {
                        bundle2.putBundle(EmojiManagerServiceConstant.PARAMS_REQ, bundle3);
                    }
                    EmojiManagerServiceImpl emojiManagerServiceImpl = EmojiManagerServiceImpl.this;
                    gVar.E = emojiManagerServiceImpl.limitSize;
                    gVar.Q = true;
                    emojiManagerServiceImpl.getDownloader().startDownload(gVar, EmojiManagerServiceImpl.this.jsonDownloadListener, bundle2);
                }
            }, true);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerService
    public void fetchEmoticonEncryptKeys(String str, ArrayList<Emoticon> arrayList, ReqInfo reqInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, arrayList, reqInfo);
            return;
        }
        int m3 = com.tencent.mobileqq.core.util.a.m(str);
        if (arrayList == null || arrayList.size() == 0 || reqInfo == null || m3 == -1) {
            return;
        }
        Object obj = new Object();
        EmoticonHandler emoticonHandler = (EmoticonHandler) this.mApp.getBusinessHandler(EmoticonHandler.F);
        emoticonHandler.D2(new d(emoticonHandler, reqInfo, obj));
        int i3 = this.localGetKeySeq;
        this.localGetKeySeq = i3 + 1;
        String num = Integer.toString(i3);
        reqInfo.strGetKeySeq = num;
        reqInfo.encryptKeysResultCode = 11022;
        emoticonHandler.I2(m3, arrayList, num);
        try {
            synchronized (obj) {
                obj.wait(35000L);
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }
}
