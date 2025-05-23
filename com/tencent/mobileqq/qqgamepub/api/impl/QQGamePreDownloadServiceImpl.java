package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.adapter.FlowControlListenerAdapter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$DSLPermitReq;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$DSLPermitRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$URLResourcePermitRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$URLResourceState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class QQGamePreDownloadServiceImpl implements IQQGamePreDownloadService {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_DSL_FLOW_CONTROL = "/v1/82";
    public static final String QQGAME_BIDS_KEY = "bids";
    public static final String QQGAME_PRELOAD_BUSINESSCODE = "qqgame_pubaccount";
    public static final String QQGAME_PRELOAD_FIELDS_KEY = "__preloadFields";
    public static final String QQGAME_PRELOAD_KEY = "preload";
    public static final String QQGAME_PRELOAD_RES_KEY = "__preloadRes";
    private static final String TAG = "QQGamePub_QQGamePreDownloadServiceImpl";
    private com.tencent.biz.common.offline.a mBidCallback;
    private final WadlTrpcListener mDSLFlowControlListener;
    private DownloaderFactory mDownloaderFactory;
    private com.tencent.mobileqq.vip.h mDownloaderInterface;
    private final WadlTrpcListener mFlowControlListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DownloadParam f264423b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.tencent.mobileqq.vip.f fVar, DownloadParam downloadParam) {
            super(fVar);
            this.f264423b = downloadParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGamePreDownloadServiceImpl.this, fVar, downloadParam);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.f, com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            } else {
                super.onDoneFile(gVar);
                QQGamePreDownloadServiceImpl.this.handleOnFileDone(gVar, this.f264423b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends AbsPreDownloadTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownloadParam f264425d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vip.f f264426e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f264427f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BaseQQAppInterface baseQQAppInterface, String str, DownloadParam downloadParam, com.tencent.mobileqq.vip.f fVar, Bundle bundle) {
            super(baseQQAppInterface, str);
            this.f264425d = downloadParam;
            this.f264426e = fVar;
            this.f264427f = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGamePreDownloadServiceImpl.this, baseQQAppInterface, str, downloadParam, fVar, bundle);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "realCancel...url:" + this.f264425d.url);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQGamePreDownloadServiceImpl.this.startDownload(this.f264425d, this.f264426e, this.f264427f);
            if (QLog.isColorLevel()) {
                QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "realStart...url:" + this.f264425d.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadParam f264429a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f264430b;

        c(DownloadParam downloadParam, String str) {
            this.f264429a = downloadParam;
            this.f264430b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGamePreDownloadServiceImpl.this, downloadParam, str);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            File file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            super.onDoneFile(gVar);
            if (gVar != null && gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c) && (file = gVar.f313010h.get(gVar.f313004c)) != null && file.exists()) {
                try {
                    QQGamePreDownloadServiceImpl.this.updateOfflineByBids(new JSONObject(FileUtils.readFileContent(file)).optJSONObject("preload").optJSONArray(QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY));
                    ((IQQGameResService) QRoute.api(IQQGameResService.class)).updateResInfo(gVar.f313004c, MD5Coding.encodeFile2HexStr(file.getAbsolutePath()), NetConnInfoCenter.getServerTimeMillis(), this.f264429a.filePos);
                } catch (Exception e16) {
                    QLog.e(QQGamePreDownloadServiceImpl.TAG, 1, e16, new Object[0]);
                }
            }
            if (gVar != null) {
                QQGamePreDownloadServiceImpl.reportSceneDownloadResult(this.f264430b, gVar.f313006d, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONArray f264432d;

        d(JSONArray jSONArray) {
            this.f264432d = jSONArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGamePreDownloadServiceImpl.this, (Object) jSONArray);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QQGamePreDownloadServiceImpl.TAG, 1, "[updateOfflineByBids],loaded param:" + str + ",code:" + i3);
            }
            QQGamePreDownloadServiceImpl.reportSceneDownloadResult(this.f264432d.toString(), i3, 2);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* loaded from: classes16.dex */
    class e extends FlowControlListenerAdapter {
        static IPatchRedirector $redirector_;

        /* loaded from: classes16.dex */
        class a extends com.tencent.mobileqq.vip.f {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f264435a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f264436b;

            a(String str, String str2) {
                this.f264435a = str;
                this.f264436b = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, e.this, str, str2);
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
                File file;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                    return;
                }
                super.onDoneFile(gVar);
                if (QLog.isColorLevel()) {
                    QLog.i(QQGamePreDownloadServiceImpl.TAG, 1, "onDoneFile...task:" + gVar + ",Thread:" + Thread.currentThread());
                }
                Map<String, File> map = gVar.f313010h;
                if (map != null && map.containsKey(this.f264435a) && (file = gVar.f313010h.get(this.f264435a)) != null && file.exists()) {
                    String CopyFileToCache = ((IArkHelper) QRoute.api(IArkHelper.class)).CopyFileToCache(this.f264436b, file.getAbsolutePath());
                    ((IQQGameResService) QRoute.api(IQQGameResService.class)).saveArkResPreloadName(this.f264436b, this.f264435a, CopyFileToCache);
                    if (QLog.isColorLevel()) {
                        QLog.i(QQGamePreDownloadServiceImpl.TAG, 1, "CopyFileToCache...fileName:" + CopyFileToCache + ",url:" + this.f264435a + ",appName:" + this.f264436b);
                    }
                }
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGamePreDownloadServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.adapter.FlowControlListenerAdapter
        public void b(String str, String str2, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "resState:" + i3 + ",internalTime:" + j3 + ",url:" + str);
            }
            if (i3 == 1) {
                DownloadParam downloadParam = new DownloadParam();
                downloadParam.url = str;
                downloadParam.filePath = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getFilePath(str, 0);
                QQGamePreDownloadServiceImpl.this.startPreDownload(downloadParam, new a(str, str2), null);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class f extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.mobileqq.vip.f f264438a;

        public f(com.tencent.mobileqq.vip.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            } else {
                this.f264438a = fVar;
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            super.onDoneFile(gVar);
            com.tencent.mobileqq.vip.f fVar = this.f264438a;
            if (fVar != null) {
                fVar.onDoneFile(gVar);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                return;
            }
            super.onProgress(gVar);
            com.tencent.mobileqq.vip.f fVar = this.f264438a;
            if (fVar != null) {
                fVar.onProgress(gVar);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            com.tencent.mobileqq.vip.f fVar = this.f264438a;
            if (fVar != null) {
                fVar.onStart(gVar);
            }
            return super.onStart(gVar);
        }
    }

    public QQGamePreDownloadServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFlowControlListener = new e();
        this.mDSLFlowControlListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGamePreDownloadServiceImpl.this);
                }
            }

            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            public HashSet<String> getFilterCmds() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashSet) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return new HashSet<String>() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.9.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                        } else {
                            add(QQGamePreDownloadServiceImpl.CMD_DSL_FLOW_CONTROL);
                        }
                    }
                };
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i16 = 0;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
                    return;
                }
                String stringExtra = intent.getStringExtra("activityId");
                if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                    try {
                        QQGameResFlowControl$DSLPermitRsp qQGameResFlowControl$DSLPermitRsp = new QQGameResFlowControl$DSLPermitRsp();
                        qQGameResFlowControl$DSLPermitRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                        i3 = qQGameResFlowControl$DSLPermitRsp.res_state.get();
                        if (i3 == 1) {
                            try {
                                QQGamePreDownloadServiceImpl.this.doDownloadDSL(stringExtra);
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e(QQGamePreDownloadServiceImpl.TAG, 1, e, new Object[0]);
                                i16 = i3;
                                if (!QLog.isColorLevel()) {
                                }
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 0;
                    }
                    i16 = i3;
                }
                if (!QLog.isColorLevel()) {
                    QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "onTrpcRs,:request:" + intent + ",cmd:" + str + ",ret:" + j3 + ",rsp resState:" + i16 + ",activityId:" + stringExtra);
                }
            }
        };
        if (this.mDownloaderFactory == null) {
            DownloaderFactory downloaderFactory = new DownloaderFactory(null);
            this.mDownloaderFactory = downloaderFactory;
            this.mDownloaderInterface = downloaderFactory.u(1);
        }
    }

    private boolean addToPreDownloadSchedule(DownloadParam downloadParam, QQAppInterface qQAppInterface, AbsPreDownloadTask absPreDownloadTask) {
        IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
        String str = downloadParam.url;
        return iPreDownloadController.requestPreDownload(10098, PreDownloadConstants.DEPARTMENT_SED, str, 0, str, downloadParam.filePath, 3, 0, true, absPreDownloadTask);
    }

    private boolean checkCopyOriginalFile(String str, String str2, String str3) {
        String resRecordMd5 = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getResRecordMd5(str2, "", 0);
        String resRealMd5 = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getResRealMd5(str3);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "preDownloadPubPushArkRes res checkCopyOriginalFile...originalFileMd5:" + resRecordMd5 + ",currentFileMd5:" + resRealMd5);
        }
        if (resRecordMd5 != null && resRecordMd5.equalsIgnoreCase(resRealMd5)) {
            ((IQQGameResService) QRoute.api(IQQGameResService.class)).saveArkResPreloadName(str, str2, ((IArkHelper) QRoute.api(IArkHelper.class)).CopyFileToCache(str, str3));
            return true;
        }
        ((IQQGameResService) QRoute.api(IQQGameResService.class)).deleteFile(str3);
        ((IQQGameResService) QRoute.api(IQQGameResService.class)).removeResInfo(str2, 0);
        return false;
    }

    private void decodeAndPreloadArkRes(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString(QQGAME_PRELOAD_FIELDS_KEY);
        if (!TextUtils.isEmpty(optString)) {
            for (String str2 : optString.split(",")) {
                String optString2 = jSONObject.optString(str2);
                String resPathByUrl = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getResPathByUrl(optString2, 0);
                if (!TextUtils.isEmpty(resPathByUrl)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "preDownloadPubPushArkRes isAlreadyDownload...url:" + optString2 + ",filePath:" + resPathByUrl);
                    }
                    String arkResRecordName = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getArkResRecordName(str, optString2);
                    if (!TextUtils.isEmpty(arkResRecordName) && new File(((IQQGameResService) QRoute.api(IQQGameResService.class)).getArkResRecordPath(str, optString2)).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "preDownloadPubPushArkRes res isAlready exits...url:" + optString2 + ",filePath:" + resPathByUrl + ",resName:" + arkResRecordName + ",just return");
                        }
                    } else if (checkCopyOriginalFile(str, optString2, resPathByUrl)) {
                    }
                }
                com.tencent.mobileqq.qqgamepub.data.e flowControlConfig = ((IQQGameFlowControlService) QRoute.api(IQQGameFlowControlService.class)).getFlowControlConfig(optString2);
                if (flowControlConfig != null && flowControlConfig.f264507a == 2 && flowControlConfig.f264508b > NetConnInfoCenter.getServerTime()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "preDownloadPubPushArkRes ResourceInvalid...url:" + optString2 + ",flowConfig:" + flowControlConfig + ",just return");
                    }
                } else {
                    ((IQQGameFlowControlService) QRoute.api(IQQGameFlowControlService.class)).checkResFlowControl(optString2, str, this.mFlowControlListener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeAndPreloadFields(String str, JSONObject jSONObject, String str2) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str2);
        if (optJSONObject == null) {
            QLog.i(TAG, 1, "preDownloadPubPushArkRes contentJson is null");
        } else {
            tryPreloadArkRes(str, optJSONObject);
            updateActivityDSL(optJSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDownloadDSL(String str) {
        String str2 = "https://youxi.gamecenter.qq.com/dsl/" + str + Sticker.JSON_SUFFIX;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "doDownloadActivityDSL...dslUrl:" + str2);
        }
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str2;
        downloadParam.filePath = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getFilePath(str2, 0);
        startDownload(downloadParam, new c(downloadParam, str2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDirectJump(JSONObject jSONObject) {
        String optString = jSONObject.optString("transition_animation");
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "animUrl is null");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(optString);
            ((IQQGameFlowControlService) QRoute.api(IQQGameFlowControlService.class)).checkResFlowControl(3, arrayList, new WadlTrpcListener() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl$5$a */
                /* loaded from: classes16.dex */
                class a extends com.tencent.mobileqq.vip.f {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.vip.f
                    public void onDoneFile(com.tencent.mobileqq.vip.g gVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                            return;
                        }
                        super.onDoneFile(gVar);
                        if (QLog.isColorLevel()) {
                            QLog.i(QQGamePreDownloadServiceImpl.TAG, 1, "onDoneFile...task:" + gVar + ",Thread:" + Thread.currentThread());
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGamePreDownloadServiceImpl.this);
                    }
                }

                @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
                public HashSet<String> getFilterCmds() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (HashSet) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return new HashSet<String>() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            } else {
                                add(IQQGameFlowControlService.CMD_RES_FLOW_CONTROL_BATCH);
                            }
                        }
                    };
                }

                @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
                public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
                        return;
                    }
                    if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                        try {
                            QQGameResFlowControl$URLResourcePermitRsp qQGameResFlowControl$URLResourcePermitRsp = new QQGameResFlowControl$URLResourcePermitRsp();
                            qQGameResFlowControl$URLResourcePermitRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                            long j16 = qQGameResFlowControl$URLResourcePermitRsp.internal_time.get();
                            for (QQGameResFlowControl$URLResourceState qQGameResFlowControl$URLResourceState : qQGameResFlowControl$URLResourcePermitRsp.state_list.get()) {
                                int i3 = qQGameResFlowControl$URLResourceState.res_state.get();
                                String str2 = qQGameResFlowControl$URLResourceState.res_url.get();
                                if (i3 == 1) {
                                    DownloadParam downloadParam = new DownloadParam();
                                    downloadParam.url = str2;
                                    downloadParam.filePath = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getFilePath(str2, 0);
                                    QQGamePreDownloadServiceImpl.this.startPreDownload(downloadParam, new a(), null);
                                }
                                QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "[checkResFlowControl] internalTime:" + j16 + ",resState:" + i3 + ",url:" + str2);
                            }
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(QQGamePreDownloadServiceImpl.TAG, 2, e16, new Object[0]);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "[checkResFlowControl] failed,ret:" + j3);
                }
            });
        }
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).preDownloadDirectJumpRes(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFileDone(com.tencent.mobileqq.vip.g gVar, DownloadParam downloadParam) {
        File file;
        if (gVar != null) {
            try {
                if (gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c) && (file = gVar.f313010h.get(gVar.f313004c)) != null) {
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    if (qQAppInterface != null) {
                        IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
                        String str = gVar.f313004c;
                        long j3 = -1;
                        if (gVar.f313006d == 0 && file.exists()) {
                            j3 = file.length();
                        }
                        iPreDownloadController.preDownloadSuccess(str, j3);
                    }
                    if (file.exists()) {
                        ((IQQGameResService) QRoute.api(IQQGameResService.class)).updateResInfo(gVar.f313004c, MD5Coding.encodeFile2HexStr(file.getAbsolutePath()), NetConnInfoCenter.getServerTimeMillis(), downloadParam.filePos);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return;
            }
        }
        if (gVar != null) {
            reportPreDownloadResult(gVar.f313011i, gVar.f313006d);
        }
    }

    public static void reportPreDownloadResult(String str, int i3) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208518").setGameAppId("").setModuleType("104705").setBussinessId("1").setPageId("160").setExt(25, str).setExt(26, i3 + "");
        wadlReportBuilder.report();
    }

    public static void reportPreDownloadSchedule(String str, int i3) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208517").setGameAppId("").setModuleType("104705").setBussinessId("1").setPageId("160").setExt(25, str).setExt(26, i3 + "");
        wadlReportBuilder.report();
    }

    public static void reportSceneDownloadResult(String str, int i3, int i16) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208518").setGameAppId("").setModuleType("104705").setBussinessId("1").setPageId("160").setExt(25, str).setExt(26, i3 + "").setExt(29, i16 + "");
        wadlReportBuilder.report();
    }

    private int transType2Int(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equalsIgnoreCase("WiFi")) {
            return 1;
        }
        if (str.equalsIgnoreCase("4G")) {
            return 4;
        }
        if (str.equalsIgnoreCase("3G")) {
            return 3;
        }
        if (str.equalsIgnoreCase("2G")) {
            return 2;
        }
        if (!str.equalsIgnoreCase("5G")) {
            return 0;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void checkAndCleanExpireCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!((IQQGameResService) QRoute.api(IQQGameResService.class)).isOnlySupportInnerFilePos()) {
            ((IQQGameResService) QRoute.api(IQQGameResService.class)).checkAndCleanExpireCache(0);
        }
        ((IQQGameResService) QRoute.api(IQQGameResService.class)).checkAndCleanExpireCache(1);
    }

    protected void checkAndDownloadDSL(Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) set);
            return;
        }
        if (set == null) {
            return;
        }
        com.tencent.mobileqq.qqgamepub.config.c config = getConfig();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "checkAndDownloadDSL mDownOfflineSwitch:" + config.mDownOfflineSwitch);
        }
        if (config.mDownOfflineSwitch == 0) {
            return;
        }
        for (String str : set) {
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "checkAndDownloadDSL actId:" + str);
                }
                QQGameResFlowControl$DSLPermitReq qQGameResFlowControl$DSLPermitReq = new QQGameResFlowControl$DSLPermitReq();
                qQGameResFlowControl$DSLPermitReq.active_id.set(str);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_DSL_FLOW_CONTROL, false, qQGameResFlowControl$DSLPermitReq.toByteArray());
                Bundle bundle = new Bundle();
                bundle.putString("activityId", str);
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mDSLFlowControlListener);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String getActivityId(String str) {
        Exception e16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        String activityUrl = getActivityUrl(str);
        String str3 = "";
        if (HttpUtil.isValidUrl(activityUrl)) {
            try {
                str2 = Uri.parse(activityUrl).getQueryParameter("__mie_dsl");
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = str2.replace("_hippy", "").replace("_h5", "");
                    }
                } catch (Exception e17) {
                    e16 = e17;
                    QLog.e(TAG, 1, "updateActivityDSL error=" + e16);
                    str3 = str2;
                    if (QLog.isColorLevel()) {
                    }
                    return str3;
                }
            } catch (Exception e18) {
                e16 = e18;
                str2 = "";
            }
            str3 = str2;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "activityId:" + str3 + ",activityUrl:" + activityUrl);
        }
        return str3;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public String getActivityUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        String str2 = "";
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            Uri parse = Uri.parse(decode);
            if (!TextUtils.isEmpty(parse.getQueryParameter("__mie_dsl"))) {
                str2 = decode;
            } else {
                Iterator<String> it = parse.getQueryParameterNames().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        String queryParameter = parse.getQueryParameter(next);
                        if (HttpUtil.isValidUrl(queryParameter)) {
                            String decode2 = URLDecoder.decode(queryParameter, "UTF-8");
                            if (!TextUtils.isEmpty(Uri.parse(decode2).getQueryParameter("__mie_dsl"))) {
                                str2 = decode2;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getActivityUrl...msgUrl:" + str + ",activityUrl:" + str2);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public com.tencent.mobileqq.qqgamepub.config.c getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqgamepub.config.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (com.tencent.mobileqq.qqgamepub.config.c) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_ARKSRC_PRELOAD, new com.tencent.mobileqq.qqgamepub.config.c());
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public boolean interceptJumpHippy(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        HippyMap hippyMap = new HippyMap();
        String activityUrl = ((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).getActivityUrl(str);
        boolean z16 = false;
        if (HttpUtil.isValidUrl(activityUrl) && activityUrl.contains("__bundleName")) {
            try {
                String queryParameter = Uri.parse(activityUrl).getQueryParameter("__bundleName");
                String queryParameter2 = Uri.parse(activityUrl).getQueryParameter("__mie_dsl");
                if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.endsWith("_hippy")) {
                    try {
                        hippyMap.pushString("bundleName", queryParameter);
                        hippyMap.pushString("domain", "gamecenter.qq.com");
                        hippyMap.pushString(OpenHippyInfo.EXTRA_KEY_ERROR_URL, str);
                        JSONObject jSONObject = new JSONObject();
                        String activityId = getActivityId(str);
                        String activityDSL = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getActivityDSL(activityId, 0);
                        if (activityId == null) {
                            activityId = "";
                        }
                        jSONObject.put("dslId", activityId);
                        if (activityDSL == null) {
                            activityDSL = "";
                        }
                        jSONObject.put("dsl", activityDSL);
                        hippyMap.pushString("url", jSONObject.toString());
                        z16 = new OpenHippyInfo(hippyMap).openHippy(MobileQQ.sMobileQQ);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "interceptJumpHippy..." + e16);
                    }
                }
            } catch (Exception e17) {
                QLog.e(TAG, 1, "interceptJumpHippy get activityId error=" + e17);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "shouldInterceptJumpHippy...url:" + activityUrl + ",result:" + hippyMap);
        }
        return z16;
    }

    public boolean isNetValidToDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("\\|");
        int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
        for (String str2 : split) {
            if (transType2Int(str2) == systemNetwork) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void preDownloadPubPushRes(List<QQGameMsgInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f264419d;

                {
                    this.f264419d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGamePreDownloadServiceImpl.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject optJSONObject;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        List list2 = this.f264419d;
                        if (list2 != null && list2.size() > 0) {
                            for (QQGameMsgInfo qQGameMsgInfo : this.f264419d) {
                                String str = qQGameMsgInfo.arkAppName;
                                String str2 = qQGameMsgInfo.arkMetaList;
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    JSONObject jSONObject = new JSONObject(str2);
                                    Iterator keys = jSONObject.keys();
                                    String str3 = "";
                                    if (keys.hasNext()) {
                                        str3 = (String) keys.next();
                                    }
                                    if (!TextUtils.isEmpty(str3)) {
                                        QQGamePreDownloadServiceImpl.this.decodeAndPreloadFields(str, jSONObject, str3);
                                    }
                                } else if (!TextUtils.isEmpty(qQGameMsgInfo.url)) {
                                    HashSet hashSet = new HashSet();
                                    String activityId = QQGamePreDownloadServiceImpl.this.getActivityId(qQGameMsgInfo.url);
                                    if (!TextUtils.isEmpty(activityId)) {
                                        hashSet.add(activityId);
                                    }
                                    QQGamePreDownloadServiceImpl.this.checkAndDownloadDSL(hashSet);
                                }
                                if (!TextUtils.isEmpty(qQGameMsgInfo.extJson) && (optJSONObject = new JSONObject(qQGameMsgInfo.extJson).optJSONObject("direct_jump_configs")) != null) {
                                    QQGamePreDownloadServiceImpl.this.handleDirectJump(optJSONObject);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i(QQGamePreDownloadServiceImpl.TAG, 2, "preDownloadPubPushArkRes...arkAppName:" + str + ",arkMetaList:" + str2 + ",curNetType:" + NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ) + ",url" + qQGameMsgInfo.url);
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        QLog.e(QQGamePreDownloadServiceImpl.TAG, 1, th5, new Object[0]);
                    }
                }
            }, 64, null, false);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void setArkResNameToMeta(String str, JSONObject jSONObject) {
        int i3;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) jSONObject);
            return;
        }
        int i16 = 0;
        try {
            char c17 = 2;
            if (getConfig().mPreDownloadSwitch == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "setArkResNameToMeta...mPreDownloadSwitch == 0 ,just return");
                    return;
                }
                return;
            }
            String optString = jSONObject.optString(QQGAME_PRELOAD_FIELDS_KEY);
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject();
                String[] split = optString.split(",");
                int length = split.length;
                int i17 = 0;
                while (i17 < length) {
                    String str2 = split[i17];
                    String optString2 = jSONObject.optString(str2);
                    String arkResRecordName = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getArkResRecordName(str, optString2);
                    if (!TextUtils.isEmpty(arkResRecordName)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String arkResRecordPath = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getArkResRecordPath(str, optString2);
                        String resRecordMd5 = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getResRecordMd5(optString2, "", i16);
                        try {
                            String resRealMd5 = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getResRealMd5(arkResRecordPath);
                            boolean exists = new File(arkResRecordPath).exists();
                            if (exists && resRecordMd5 != null && resRecordMd5.equalsIgnoreCase(resRealMd5)) {
                                jSONObject2.put(str2, arkResRecordName);
                            } else {
                                ((IQQGameResService) QRoute.api(IQQGameResService.class)).saveArkResPreloadName(str, optString2, "");
                                if (exists) {
                                    ((IQQGameResService) QRoute.api(IQQGameResService.class)).deleteFile(arkResRecordPath);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                c16 = 2;
                                QLog.i(TAG, 2, "setArkResNameToMeta res checkCopyOriginalFile...originalFileMd5:" + resRecordMd5 + ",currentFileMd5:" + resRealMd5 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                            } else {
                                c16 = 2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            i3 = 0;
                            QLog.e(TAG, 1, th, new Object[i3]);
                            return;
                        }
                    } else {
                        c16 = c17;
                    }
                    i17++;
                    c17 = c16;
                    i16 = 0;
                }
                jSONObject.put(QQGAME_PRELOAD_RES_KEY, jSONObject2);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "setArkResPreDownloadFileName...retJson:" + jSONObject);
            }
        } catch (Throwable th6) {
            th = th6;
            i3 = 0;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void startDownload(DownloadParam downloadParam, com.tencent.mobileqq.vip.f fVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, downloadParam, fVar, bundle);
        } else {
            if (downloadParam == null) {
                return;
            }
            downloadParam.standardlize();
            ThreadManagerV2.post(new Runnable(downloadParam, fVar, bundle) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DownloadParam f264416d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.vip.f f264417e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f264418f;

                {
                    this.f264416d = downloadParam;
                    this.f264417e = fVar;
                    this.f264418f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQGamePreDownloadServiceImpl.this, downloadParam, fVar, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.f264416d.url, new File(this.f264416d.filePath));
                    gVar.S = QQGamePreDownloadServiceImpl.QQGAME_PRELOAD_BUSINESSCODE;
                    List<Pair<String, String>> list = this.f264416d.headers;
                    if (list != null) {
                        for (Pair<String, String> pair : list) {
                            if (pair != null) {
                                gVar.b(pair.first, pair.second);
                            }
                        }
                    }
                    if (QQGamePreDownloadServiceImpl.this.mDownloaderInterface != null) {
                        QQGamePreDownloadServiceImpl.this.mDownloaderInterface.startDownload(gVar, this.f264417e, this.f264418f);
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void startPreDownload(DownloadParam downloadParam, com.tencent.mobileqq.vip.f fVar, Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, downloadParam, fVar, bundle);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "downloadParam:" + downloadParam + ",Thread:" + Thread.currentThread());
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (qQAppInterface != null && downloadParam != null && !TextUtils.isEmpty(downloadParam.url) && !TextUtils.isEmpty(downloadParam.filePath)) {
                downloadParam.standardlize();
                checkAndCleanExpireCache();
                boolean addToPreDownloadSchedule = addToPreDownloadSchedule(downloadParam, qQAppInterface, new b(qQAppInterface, downloadParam.url, downloadParam, new a(fVar, downloadParam), bundle));
                String str = downloadParam.url;
                if (addToPreDownloadSchedule) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                reportPreDownloadSchedule(str, i3);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    protected void tryPreloadArkRes(String str, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) jSONObject);
            return;
        }
        com.tencent.mobileqq.qqgamepub.config.c config = getConfig();
        if (config.mPreDownloadSwitch == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "preloadArkRes...mPreDownloadSwitch == 0 ,just return");
            }
        } else {
            if (!isNetValidToDownload(config.mPreDownloadNetType)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "preloadArkRes...netValidToDownload is false ,just return -- mPreDownloadNetType\uff1a" + config.mPreDownloadNetType + ",curNetType:" + NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ));
                    return;
                }
                return;
            }
            decodeAndPreloadArkRes(str, jSONObject);
        }
    }

    protected void updateActivityDSL(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            Iterator keys = jSONObject.keys();
            HashSet hashSet = new HashSet();
            while (keys.hasNext()) {
                Object opt = jSONObject.opt((String) keys.next());
                if (opt instanceof String) {
                    String activityId = getActivityId((String) opt);
                    if (!TextUtils.isEmpty(activityId)) {
                        hashSet.add(activityId);
                    }
                }
            }
            checkAndDownloadDSL(hashSet);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
    public void updateOfflineByBids(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONArray);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[updateOfflineByBids] bids:" + jSONArray);
        }
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            d dVar = new d(jSONArray);
            this.mBidCallback = dVar;
            HtmlOffline.C(arrayList, waitAppRuntime, dVar, true, true);
        }
    }
}
