package com.tencent.mobileqq.emoticon.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.EmoticonQBoxConfProcessor;
import com.tencent.mobileqq.config.business.k;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.n;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavEmoticonUtilsImpl implements IFavEmoticonUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FavEmoticonUtils";
    private a mFavSyncListener;
    private o mSyncServerResultListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends n<CustomEmotionData> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private o f204722a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FavEmoticonUtilsImpl.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z16) {
            o oVar = this.f204722a;
            if (oVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("FavSyncListener", 2, "finishListener is null, return");
                }
            } else if (z16) {
                oVar.a();
            } else {
                oVar.notifySyncFail();
            }
        }

        public void c(o oVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar);
            } else {
                this.f204722a = oVar;
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onDownloadFinish(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavSyncListener", 2, LibraTraceConst.Node.IMAGE_DOWNLOAD_SUCCESS);
            }
            b(true);
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onSyncFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavSyncListener", 2, "roaming_finish");
            }
            ((FavroamingManagerServiceProxy) new QQEmoticonMainPanelApp().getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(FavEmoticonUtilsImpl.this.mFavSyncListener);
            b(true);
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onUploadFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d("FavSyncListener", 2, "upload_finish");
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onFileDone(CustomEmotionData customEmotionData, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b(true);
            } else {
                iPatchRedirector.redirect((short) 3, this, customEmotionData, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    public FavEmoticonUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFavSyncListener = new a();
        }
    }

    private void applyFavEmoticonSharePref(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(FavEmoConstant.SP_LOCAL_OVERFLOW + str, true).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDoSyncFavEmoticon(boolean z16, @NonNull QQEmoticonMainPanelApp qQEmoticonMainPanelApp, SharedPreferences sharedPreferences, String str) {
        if (!z16) {
            FavroamingDBManagerServiceProxy favroamingDBManagerServiceProxy = (FavroamingDBManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IFavroamingDBManagerService.class);
            List<CustomEmotionData> emoticonDataList = favroamingDBManagerServiceProxy.getEmoticonDataList();
            if (emoticonDataList != null && emoticonDataList.size() > FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                List<CustomEmotionData> subList = emoticonDataList.subList(0, emoticonDataList.size() - FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "delListOverflow=" + subList.toString() + "emolist.size=" + emoticonDataList.size());
                }
                favroamingDBManagerServiceProxy.delOverflow(subList);
            }
            applyFavEmoticonSharePref(sharedPreferences, str);
            startSyncFavEmoticon(qQEmoticonMainPanelApp);
            return;
        }
        startSyncFavEmoticon(qQEmoticonMainPanelApp);
    }

    private void startSyncFavEmoticon(@NonNull QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        Context app = qQEmoticonMainPanelApp.getApp();
        this.mFavSyncListener.c(this.mSyncServerResultListener);
        if (!NetworkUtil.isNetSupport(app)) {
            notifySyncFail();
            return;
        }
        FavroamingManagerServiceProxy favroamingManagerServiceProxy = (FavroamingManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IFavroamingManagerService.class);
        VipComicMqqHandlerProxy vipComicMqqHandlerProxy = (VipComicMqqHandlerProxy) qQEmoticonMainPanelApp.getBusinessHandler(VipComicMqqHandler.f204459e);
        if (favroamingManagerServiceProxy.isInSyncing()) {
            vipComicMqqHandlerProxy.getMyComicFavorEmotIcons();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "comicHandler.GetMyComicFavorEmotIcons");
            }
            favroamingManagerServiceProxy.addSyncListener(this.mFavSyncListener);
            favroamingManagerServiceProxy.syncLocalDel();
            syncComicEmoticon(qQEmoticonMainPanelApp);
            ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public void getAccessibilityData(com.tencent.mobileqq.emosm.favroaming.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        FavroamingManagerServiceProxy favroamingManagerServiceProxy = FavroamingManagerServiceImpl.get(new QQEmoticonMainPanelApp());
        favroamingManagerServiceProxy.setAccessibilityResultListener(aVar);
        favroamingManagerServiceProxy.cacheAccessibilityEmotionData();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public ArrayList<EmoticonInfo> getEmoticonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<EmoticonInfo> arrayList = new ArrayList<>();
        List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = ((FavroamingDBManagerServiceProxy) new QQEmoticonMainPanelApp().getRuntimeService(IFavroamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel();
        if (syncGetCustomEmotionInfoShowedInPanel != null) {
            if (syncGetCustomEmotionInfoShowedInPanel.size() > FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                arrayList.addAll(new ArrayList(syncGetCustomEmotionInfoShowedInPanel.subList(0, FavEmoConstant.FAV_LOCAL_MAX_COUNT)));
            } else {
                arrayList.addAll(syncGetCustomEmotionInfoShowedInPanel);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public k getEmoticonQBoxConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (k) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return EmoticonQBoxConfProcessor.c();
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public void notifySyncFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        a aVar = this.mFavSyncListener;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public void removeAccessibilityListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            FavroamingManagerServiceImpl.get(new QQEmoticonMainPanelApp()).setAccessibilityResultListener(null);
        }
    }

    public void syncComicEmoticon(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQEmoticonMainPanelApp);
        } else if (qQEmoticonMainPanelApp != null) {
            ((VipComicMqqManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IVipComicMqqManagerService.class)).uploadInitComicEmoStructMsgInfo();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils
    public void triggerToSyncFromServer(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar);
            return;
        }
        this.mSyncServerResultListener = oVar;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = new QQEmoticonMainPanelApp();
        SharedPreferences sharedPreferences = qQEmoticonMainPanelApp.getApp().getSharedPreferences("mobileQQ", 0);
        String currentUin = qQEmoticonMainPanelApp.getCurrentUin();
        boolean z16 = sharedPreferences.getBoolean(FavEmoConstant.SP_LOCAL_OVERFLOW + currentUin, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isDelOverflow=" + z16);
        }
        ThreadManagerV2.post(new Runnable(qQEmoticonMainPanelApp, z16, sharedPreferences, currentUin) { // from class: com.tencent.mobileqq.emoticon.api.impl.FavEmoticonUtilsImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQEmoticonMainPanelApp f204718d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f204719e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ SharedPreferences f204720f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f204721h;

            {
                this.f204718d = qQEmoticonMainPanelApp;
                this.f204719e = z16;
                this.f204720f = sharedPreferences;
                this.f204721h = currentUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FavEmoticonUtilsImpl.this, qQEmoticonMainPanelApp, Boolean.valueOf(z16), sharedPreferences, currentUin);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp2 = this.f204718d;
                if (qQEmoticonMainPanelApp2 != null) {
                    FavEmoticonUtilsImpl.this.realDoSyncFavEmoticon(this.f204719e, qQEmoticonMainPanelApp2, this.f204720f, this.f204721h);
                } else {
                    FavEmoticonUtilsImpl.this.notifySyncFail();
                }
            }
        }, 5, null, false);
    }
}
