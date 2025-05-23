package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPanelFavHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> {
    static IPatchRedirector $redirector_ = null;
    public static final String LOG_TAG = "EmoticonPanelFavHelper";
    protected QQEmoticonMainPanelApp app;
    Runnable comicEmoticon;
    FavEmoRoamingObserver favEmoRoamingObserver;
    private final boolean initFavWhenSwipe;
    com.tencent.mobileqq.emosm.favroaming.n<CustomEmotionData> sListener;
    private final com.tencent.mobileqq.qdispatchqueue.h serialQueue;

    public EmoticonPanelFavHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.initFavWhenSwipe = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_init_fav_127205421", true);
        this.serialQueue = com.tencent.mobileqq.qdispatchqueue.d.a(LOG_TAG);
        this.comicEmoticon = new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelFavHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).app;
                if (qQEmoticonMainPanelApp != null) {
                    ((VipComicMqqManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IVipComicMqqManagerService.class)).uploadInitComicEmoStructMsgInfo();
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonPanelFavHelper.LOG_TAG, 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
                    }
                }
            }
        };
        this.sListener = new com.tencent.mobileqq.emosm.favroaming.n<CustomEmotionData>() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelFavHelper.this);
                }
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onDownloadFinish(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmoticonPanelFavHelper.LOG_TAG, 2, LibraTraceConst.Node.IMAGE_DOWNLOAD_SUCCESS);
                }
                EmoticonPanelFavHelper.this.updateFavEmoticonPanel();
                ReportController.o(((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).app.getQQAppInterface(), "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, i3 + "", "", "", "");
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onSyncFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmoticonPanelFavHelper.LOG_TAG, 2, "roaming_finish");
                }
                T t16 = EmoticonPanelFavHelper.this.mPanelController;
                if (((EmoticonPanelController) t16).app != null) {
                    ((FavroamingManagerServiceProxy) ((EmoticonPanelController) t16).app.getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(EmoticonPanelFavHelper.this.sListener);
                }
                EmoticonPanelFavHelper.this.updateFavEmoticonPanel();
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onUploadFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                } else if (QLog.isColorLevel()) {
                    QLog.d(EmoticonPanelFavHelper.LOG_TAG, 2, "upload_finish");
                }
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onFileDone(CustomEmotionData customEmotionData, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    EmoticonPanelFavHelper.this.updateFavEmoticonPanel();
                } else {
                    iPatchRedirector2.redirect((short) 2, this, customEmotionData, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }
        };
        this.favEmoRoamingObserver = new FavEmoRoamingObserver() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelFavHelper.this);
                }
            }

            @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
            protected void onUpdateFavData(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (z16) {
                    EmoticonPanelFavHelper.this.updateFavEmoticonPanel();
                }
                if (obj != null && (obj instanceof Integer)) {
                    ThreadManager.getUIHandler().post(new Runnable(obj) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Object val$data;

                        {
                            this.val$data = obj;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, obj);
                            }
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0019. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
                        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            int i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            int i16 = 2;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            int intValue = ((Integer) this.val$data).intValue();
                            switch (intValue) {
                                case 1:
                                    i3 = R.string.f208975e6;
                                    if (i3 != 0) {
                                        QQToast.makeText(BaseApplication.getContext(), 1, i3, 0).show(((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).getToastOffset());
                                        return;
                                    }
                                    return;
                                case 2:
                                    i3 = R.string.f208985e7;
                                    if (i3 != 0) {
                                    }
                                    break;
                                case 3:
                                    i3 = R.string.f209075ef;
                                    if (i3 != 0) {
                                    }
                                    break;
                                case 4:
                                    i3 = R.string.f209065ee;
                                    if (i3 != 0) {
                                    }
                                    break;
                                case 5:
                                    i3 = R.string.inb;
                                    if (i3 != 0) {
                                    }
                                    break;
                                case 6:
                                    i3 = R.string.ind;
                                    if (i3 != 0) {
                                    }
                                    break;
                                case 7:
                                case 8:
                                    QLog.e(FavEmoRoamingObserver.TAG, 1, "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.S), " ret:", Integer.valueOf(intValue), " isResumed:", Boolean.valueOf(((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).isResumed()));
                                    if (!((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).isResumed()) {
                                        return;
                                    }
                                    CameraEmoAllSend.S = true;
                                    if (intValue == 7) {
                                        i16 = 1;
                                    }
                                    EmoAddedAuthCallback.j(((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).app.getQQAppInterface(), ((EmoticonPanelController) EmoticonPanelFavHelper.this.mPanelController).context, i16);
                                default:
                                    i3 = 0;
                                    if (i3 != 0) {
                                    }
                                    break;
                            }
                        }
                    });
                }
            }
        };
    }

    private void considerInitFav() {
        if (!this.initFavWhenSwipe) {
            return;
        }
        this.serialQueue.post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.l
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonPanelFavHelper.this.lambda$considerInitFav$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$considerInitFav$1() {
        boolean haveInitFav = ((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).haveInitFav();
        QLog.e(LOG_TAG, 1, "considerInitFav, haveInitFav:" + haveInitFav);
        if (!haveInitFav) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.k
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonPanelFavHelper.this.doSyncFavEmotion();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doSyncFavEmotion$2(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        ((EmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class)).setHaveInitFav(true);
    }

    protected void applyFavEmoticonSharePref(SharedPreferences sharedPreferences, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) sharedPreferences, (Object) str);
            return;
        }
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(FavEmoConstant.SP_LOCAL_OVERFLOW + str, true).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doSyncFavEmotion() {
        T t16 = this.mPanelController;
        final QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
        Context context = ((EmoticonPanelController) t16).context;
        if (qQEmoticonMainPanelApp == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mobileQQ", 0);
        String currentUin = qQEmoticonMainPanelApp.getCurrentUin();
        boolean z16 = sharedPreferences.getBoolean(FavEmoConstant.SP_LOCAL_OVERFLOW + currentUin, false);
        QLog.d(LOG_TAG, 1, "isDelOverflow=" + z16);
        ThreadManagerV2.post(new Runnable(qQEmoticonMainPanelApp, z16, sharedPreferences, currentUin) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQEmoticonMainPanelApp val$app;
            final /* synthetic */ boolean val$isDelOverflow;
            final /* synthetic */ SharedPreferences val$sp;
            final /* synthetic */ String val$uin;

            {
                this.val$app = qQEmoticonMainPanelApp;
                this.val$isDelOverflow = z16;
                this.val$sp = sharedPreferences;
                this.val$uin = currentUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, EmoticonPanelFavHelper.this, qQEmoticonMainPanelApp, Boolean.valueOf(z16), sharedPreferences, currentUin);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp2 = this.val$app;
                if (qQEmoticonMainPanelApp2 == null) {
                    return;
                }
                EmoticonPanelFavHelper.this.realDoSyncFavEmoticon(this.val$isDelOverflow, qQEmoticonMainPanelApp2, this.val$sp, this.val$uin);
            }
        }, 5, null, false);
        if (this.initFavWhenSwipe) {
            this.serialQueue.post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.n
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonPanelFavHelper.lambda$doSyncFavEmotion$2(QQEmoticonMainPanelApp.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: downloadSmallAndNormalEmotion, reason: merged with bridge method [inline-methods] */
    public void lambda$roamTenEmoticon$0(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, List<EmotionPanelInfo> list, EmojiManagerServiceProxy emojiManagerServiceProxy) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qQEmoticonMainPanelApp, list, emojiManagerServiceProxy);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[downloadSmallAndNormalEmotion] newPanelDataList.size() = " + arrayList.size());
        }
        int businessType = ((EmoticonPanelController) this.mPanelController).getBusinessType();
        Iterator it = arrayList.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            EmoticonPackage emoticonPackage = ((EmotionPanelInfo) it.next()).emotionPkg;
            i16++;
            if (emoticonPackage != null && ((i3 = emoticonPackage.jobType) == 0 || i3 == 4)) {
                if (emoticonPackage.status != 2) {
                    emojiManagerServiceProxy.setHaveInitSmallAndNormal(true);
                    if (i16 <= 10) {
                        EmoticonUtils.downloadNormalEmotion(qQEmoticonMainPanelApp, emoticonPackage, businessType);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return LOG_TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.app = ((EmoticonPanelController) this.mPanelController).app;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{8, 9, 10, 1, 3};
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.app;
        if (qQEmoticonMainPanelApp != null) {
            qQEmoticonMainPanelApp.addObserver(this.favEmoRoamingObserver);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) this.mPanelController).app;
        if (qQEmoticonMainPanelApp != null) {
            qQEmoticonMainPanelApp.removeObserver(this.favEmoRoamingObserver);
        }
        this.sListener = null;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.app;
        if (qQEmoticonMainPanelApp != null) {
            qQEmoticonMainPanelApp.removeObserver(this.favEmoRoamingObserver);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.onPageSelected(i3);
        T t16 = this.mPanelController;
        if (t16 != 0 && ((EmoticonPanelController) t16).findIndexByPanelType(4) == BasePanelModel.sLastSelectedSecondTabIndex) {
            considerInitFav();
        }
    }

    protected void realDoSyncFavEmoticon(boolean z16, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, SharedPreferences sharedPreferences, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), qQEmoticonMainPanelApp, sharedPreferences, str);
            return;
        }
        if (!z16) {
            FavroamingDBManagerServiceProxy favroamingDBManagerServiceProxy = (FavroamingDBManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IFavroamingDBManagerService.class);
            List<CustomEmotionData> emoticonDataList = favroamingDBManagerServiceProxy.getEmoticonDataList();
            if (emoticonDataList != null && emoticonDataList.size() > FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                List<CustomEmotionData> subList = emoticonDataList.subList(0, emoticonDataList.size() - FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "delListOverflow=" + subList.toString() + "emolist.size=" + emoticonDataList.size());
                }
                favroamingDBManagerServiceProxy.delOverflow(subList);
                updateFavEmoticonPanel();
            }
            applyFavEmoticonSharePref(sharedPreferences, str);
            startSyncFavEmoticon();
            return;
        }
        startSyncFavEmoticon();
    }

    protected void realUpdateFavEmoticonPanel() {
        EmotionPanelInfo emotionPanelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
        if (panelDataList != null) {
            for (int i3 = 0; i3 < panelDataList.size(); i3++) {
                emotionPanelInfo = panelDataList.get(i3);
                if (emotionPanelInfo != null && emotionPanelInfo.type == 4) {
                    break;
                }
            }
        }
        emotionPanelInfo = null;
        if (emotionPanelInfo != null && ((EmoticonPanelController) this.mPanelController).getPageAdapter() != null) {
            ((EmoticonPanelController) this.mPanelController).getPageAdapter().refreshListViewAdapter(emotionPanelInfo);
        }
    }

    public void roamTenEmoticon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        T t16 = this.mPanelController;
        final QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
        if (qQEmoticonMainPanelApp == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "[roamTenEmoticon] app is null");
                return;
            }
            return;
        }
        final List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) t16).getPanelDataList();
        if (panelDataList != null && panelDataList.size() >= 1) {
            final EmojiManagerServiceProxy emojiManagerServiceProxy = (EmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
            if (!emojiManagerServiceProxy.haveInitSmallAndNormal()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonPanelFavHelper.this.lambda$roamTenEmoticon$0(qQEmoticonMainPanelApp, panelDataList, emojiManagerServiceProxy);
                    }
                }, 16, null, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[roamTenEmoticon] panelDataList is empty");
        }
    }

    void startSyncFavEmoticon() {
        T t16 = this.mPanelController;
        Context context = ((EmoticonPanelController) t16).context;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
        if (NetworkUtil.isNetSupport(context) && qQEmoticonMainPanelApp != null) {
            FavroamingManagerServiceProxy favroamingManagerServiceProxy = (FavroamingManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IFavroamingManagerService.class);
            VipComicMqqHandlerProxy vipComicMqqHandlerProxy = (VipComicMqqHandlerProxy) qQEmoticonMainPanelApp.getBusinessHandler(VipComicMqqHandler.f204459e);
            if (favroamingManagerServiceProxy.isInSyncing()) {
                vipComicMqqHandlerProxy.getMyComicFavorEmotIcons();
                QLog.d(LOG_TAG, 1, "comicHandler.GetMyComicFavorEmotIcons");
                favroamingManagerServiceProxy.addSyncListener(this.sListener);
                favroamingManagerServiceProxy.syncLocalDel();
                this.comicEmoticon.run();
                ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
            }
        }
    }

    public void updateFavEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "refresh fav emoticon panel");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelFavHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    EmoticonPanelFavHelper.this.realUpdateFavEmoticonPanel();
                }
            }
        }, 200L);
    }
}
