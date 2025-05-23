package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$GetSubscribeInfoReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$GetSubscribeInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$GetSubscribeListReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$GetSubscribeListRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$SetSubscribeStatusReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$SetSubscribeStatusRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView;
import com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameSubscribeServiceImpl implements IQQGameSubscribeService {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_GET_SUBSCRIBE_INFO = "/v1/97";
    public static final String CMD_GET_SUBSCRIBE_LIST = "/v1/96";
    public static final String CMD_SET_SUBSCRIBE_STATUS = "/v1/95";
    public static final int GAME_INFO_VIEW_HEIGHT_DP = 80;
    private static final String TAG = "QQGamePub_QQGameSubscribeServiceImpl";
    private AppRuntime mApp;
    private final HashMap<String, IQQGameSubscribeService.a> mGameBaseInfoMap;
    private final WadlTrpcListener mSubscribeListener;
    private final ArrayList<QQGamePubSubscribe$AppSubscribeInfo> mSubscribedList;
    private final HashSet<String> sCmdSet;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f264442a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f264443b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f264444c;

        a(Context context, String str, int i3) {
            this.f264442a = context;
            this.f264443b = str;
            this.f264444c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGameSubscribeServiceImpl.this, context, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QQGameSubscribeServiceImpl.TAG, 2, "enterSingleGameMsgPage onError,context:" + this.f264442a + ",result:" + i3 + ",appId:" + this.f264443b + ",from:" + this.f264444c);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QQGameSubscribeServiceImpl.TAG, 2, "enterSingleGameMsgPage onSuccess,context:" + this.f264442a + ",appId:" + this.f264443b + ",from:" + this.f264444c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements WadlTrpcListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameSubscribeServiceImpl.this);
            }
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QQGameSubscribeServiceImpl.this.sCmdSet;
            }
            return (HashSet) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
                return;
            }
            if (QQGameSubscribeServiceImpl.CMD_SET_SUBSCRIBE_STATUS.equals(str)) {
                QQGameSubscribeServiceImpl.this.handleSetSubscribeStatusRsp(intent, str, j3, trpcInovkeRsp);
            } else if (QQGameSubscribeServiceImpl.CMD_GET_SUBSCRIBE_LIST.equals(str)) {
                QQGameSubscribeServiceImpl.this.handleGetSubscribeListRsp(intent, str, j3, trpcInovkeRsp);
            } else if (QQGameSubscribeServiceImpl.CMD_GET_SUBSCRIBE_INFO.equals(str)) {
                QQGameSubscribeServiceImpl.this.handleGetSubscribeInfoRsp(intent, str, j3, trpcInovkeRsp);
            }
        }
    }

    public QQGameSubscribeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSubscribedList = new ArrayList<>();
        this.mGameBaseInfoMap = new HashMap<>();
        this.sCmdSet = new HashSet<String>() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameSubscribeServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameSubscribeServiceImpl.this);
                    return;
                }
                add(QQGameSubscribeServiceImpl.CMD_SET_SUBSCRIBE_STATUS);
                add(QQGameSubscribeServiceImpl.CMD_GET_SUBSCRIBE_LIST);
                add(QQGameSubscribeServiceImpl.CMD_GET_SUBSCRIBE_INFO);
            }
        };
        b bVar = new b();
        this.mSubscribeListener = bVar;
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(bVar);
    }

    private boolean isNeedShowGrayTips(Activity activity, String str) {
        if (!((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(str)) {
            return false;
        }
        boolean booleanExtra = activity.getIntent().getBooleanExtra("key_is_from_game_pub", false);
        boolean isGameSinglePage = isGameSinglePage(activity.getIntent());
        if (!booleanExtra || isGameSinglePage) {
            return false;
        }
        return true;
    }

    private void reportSetSubscribe(String str, int i3, int i16) {
        int i17 = 1;
        if (1 == i16 || 2 == i16) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            String str2 = "1";
            WadlReportBuilder pageId = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208617").setGameAppId(str).setModuleType("76901").setOperType("20").setBussinessId("1").setPageId("160");
            if (1 != i16) {
                str2 = "2";
            }
            WadlReportBuilder ext = pageId.setExt(3, str2);
            if (i3 != 1) {
                i17 = 0;
            }
            ext.setRetId(i17);
            wadlReportBuilder.report();
        }
    }

    private void updateSubscribedListOnSetStatusRsp(QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo) {
        if (qQGamePubSubscribe$AppSubscribeInfo.appid.get() != 0) {
            synchronized (this.mSubscribedList) {
                Iterator<QQGamePubSubscribe$AppSubscribeInfo> it = this.mSubscribedList.iterator();
                while (it.hasNext()) {
                    QQGamePubSubscribe$AppSubscribeInfo next = it.next();
                    if (next != null && qQGamePubSubscribe$AppSubscribeInfo.appid.get() == next.appid.get()) {
                        it.remove();
                    }
                }
                if (qQGamePubSubscribe$AppSubscribeInfo.subscribe.get() == 1) {
                    this.mSubscribedList.add(qQGamePubSubscribe$AppSubscribeInfo);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void enterSingleGameMsgPage(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, str, Integer.valueOf(i3));
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_GAME_CHAT_ACTVITY);
        BaseAIOUtils.n(activityURIRequest, new int[]{1});
        activityURIRequest.extra().putBoolean("open_chatfragment", true);
        ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).initPublicAccountChatPieIntent(activityURIRequest);
        activityURIRequest.extra().putString("uin", "2747277822");
        activityURIRequest.extra().putInt("uintype", 1008);
        activityURIRequest.extra().putString("uinname", "");
        activityURIRequest.extra().putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        activityURIRequest.extra().putInt("aio_msg_source", 0);
        if (!(context instanceof Activity)) {
            activityURIRequest.setFlags(268435456);
        }
        activityURIRequest.extra().putInt("qqgame_msg_scene_key", 2);
        activityURIRequest.extra().putString("qqgame_msg_page_appid_key", str);
        activityURIRequest.extra().putInt("qqgame_msg_single_page_from_key", i3);
        activityURIRequest.extra().putBoolean("game_pub_new_style_key", true);
        QRoute.startUri(activityURIRequest, new a(context, str, i3));
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public boolean enterSubscribeManagePage(Activity activity, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, activity, str, str2, str3)).booleanValue();
        }
        if (activity != null && activity.getIntent().getBooleanExtra("key_is_from_game_pub", false)) {
            String subscribePageUrl = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getSubscribePageUrl();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, subscribePageUrl);
            }
            com.tencent.mobileqq.qqgamepub.utils.a.i(activity, subscribePageUrl);
            return true;
        }
        QLog.e(TAG, 4, "enterSubscribeManagePage activity is null or is not from game pub");
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void filterSingleGameMsgList(Activity activity, List<ChatMessage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) activity, (Object) list);
            return;
        }
        if (activity != null && list != null && isGameSinglePage(activity.getIntent())) {
            activity.getIntent().getStringExtra("qqgame_msg_page_appid_key");
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
            }
            list.clear();
            list.addAll(arrayList);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "filterSingleGameMsgList...singleGameMsgSize:" + arrayList.size());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public View findGameGrayTipsViewInParent(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
        }
        if (viewGroup != null) {
            return viewGroup.findViewById(R.id.f630632i);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public List<QQGamePubSubscribe$AppSubscribeInfo> getCachedSubscribeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mSubscribedList;
    }

    public View getGameGrayTipsView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        return new QQGameGrayTipsView(context);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public IQQGameSubscribeService.a getGameInfoFromCacheMap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IQQGameSubscribeService.a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return this.mGameBaseInfoMap.get(str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void getSubscribeInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getSubscribeInfo...appId:" + str);
        }
        if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(str)) {
            return;
        }
        QQGamePubSubscribe$GetSubscribeInfoReq qQGamePubSubscribe$GetSubscribeInfoReq = new QQGamePubSubscribe$GetSubscribeInfoReq();
        qQGamePubSubscribe$GetSubscribeInfoReq.appidList.add(Integer.valueOf(Integer.parseInt(str)));
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_GET_SUBSCRIBE_INFO, false, qQGamePubSubscribe$GetSubscribeInfoReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void handleGameInfoUiOnRsp(ViewGroup viewGroup, String str, QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo, boolean z16) {
        QQGameSubscribeInfoView qQGameSubscribeInfoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, viewGroup, str, qQGamePubSubscribe$AppSubscribeInfo, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleGameInfoUiOnRsp...rootView:" + viewGroup + ",appId:" + str + ",subscribeInfo:" + qQGamePubSubscribe$AppSubscribeInfo + ",needAnim:" + z16);
        }
        if (viewGroup != null && qQGamePubSubscribe$AppSubscribeInfo != null && !((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(str) && (qQGameSubscribeInfoView = (QQGameSubscribeInfoView) viewGroup.findViewById(R.id.f630732j)) != null) {
            qQGameSubscribeInfoView.g(str, qQGamePubSubscribe$AppSubscribeInfo, z16);
        }
    }

    protected void handleGetSubscribeInfoRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
            try {
                QQGamePubSubscribe$GetSubscribeInfoRsp qQGamePubSubscribe$GetSubscribeInfoRsp = new QQGamePubSubscribe$GetSubscribeInfoRsp();
                qQGamePubSubscribe$GetSubscribeInfoRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                arrayList.addAll(qQGamePubSubscribe$GetSubscribeInfoRsp.appList.get());
                QQGameSubscribeBusEvent qQGameSubscribeBusEvent = new QQGameSubscribeBusEvent(2);
                if (arrayList.size() > 0 && arrayList.get(0) != null) {
                    qQGameSubscribeBusEvent.subscribeInfo = (QQGamePubSubscribe$AppSubscribeInfo) arrayList.get(0);
                    SimpleEventBus.getInstance().dispatchEvent(qQGameSubscribeBusEvent);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleGetSubscribeInfoRsp...cmd:" + str + ",ret:" + j3 + ",subscribeInfoList:" + arrayList.size());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.tencent.mobileqq.pb.MessageMicro, com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$GetSubscribeListRsp] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void handleGetSubscribeListRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        ?? r75;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
            return;
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
            try {
                r75 = new QQGamePubSubscribe$GetSubscribeListRsp();
                r75.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                try {
                    synchronized (this.mSubscribedList) {
                        try {
                            this.mSubscribedList.clear();
                            this.mSubscribedList.addAll(r75.subscribeList.get());
                            SimpleEventBus.getInstance().dispatchEvent(new QQGameSubscribeBusEvent(1));
                            int size = this.mSubscribedList.size();
                        } catch (Throwable th5) {
                            th = th5;
                            r75 = 0;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
                try {
                    throw th;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, e, new Object[0]);
                    int i16 = r75;
                    i3 = i16;
                    if (!QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                r75 = 0;
            }
        }
        if (!QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleGetSubscribeListRsp...cmd:" + str + ",ret:" + j3 + ",subscribeInfoListSize:" + i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void handleSetSubscribeStatusRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
            return;
        }
        ArrayList arrayList = new ArrayList();
        long j16 = 0;
        QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo = null;
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
            try {
                QQGamePubSubscribe$SetSubscribeStatusRsp qQGamePubSubscribe$SetSubscribeStatusRsp = new QQGamePubSubscribe$SetSubscribeStatusRsp();
                qQGamePubSubscribe$SetSubscribeStatusRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                arrayList.addAll(qQGamePubSubscribe$SetSubscribeStatusRsp.appList.get());
            } catch (Exception e16) {
                e = e16;
            }
            if (arrayList.size() > 0 && arrayList.get(0) != null) {
                QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo2 = (QQGamePubSubscribe$AppSubscribeInfo) arrayList.get(0);
                try {
                    updateSubscribedListOnSetStatusRsp(qQGamePubSubscribe$AppSubscribeInfo2);
                    if (intent != null) {
                        i3 = intent.getIntExtra("qqgame_msg_scene_key", 1);
                        try {
                            j16 = intent.getLongExtra("set_subscribe_seq_key", 0L);
                        } catch (Exception e17) {
                            e = e17;
                            qQGamePubSubscribe$AppSubscribeInfo = qQGamePubSubscribe$AppSubscribeInfo2;
                            QLog.e(TAG, 1, e, new Object[0]);
                            i17 = i3;
                            if (QLog.isColorLevel()) {
                            }
                            if (qQGamePubSubscribe$AppSubscribeInfo == null) {
                            }
                        }
                    } else {
                        i3 = 1;
                    }
                    if (i3 != 1) {
                        i16 = 3;
                    }
                    QQGameSubscribeBusEvent qQGameSubscribeBusEvent = new QQGameSubscribeBusEvent(i16);
                    qQGameSubscribeBusEvent.subscribeInfo = qQGamePubSubscribe$AppSubscribeInfo2;
                    qQGameSubscribeBusEvent.seq = j16;
                    SimpleEventBus.getInstance().dispatchEvent(qQGameSubscribeBusEvent);
                    qQGamePubSubscribe$AppSubscribeInfo = qQGamePubSubscribe$AppSubscribeInfo2;
                } catch (Exception e18) {
                    e = e18;
                    qQGamePubSubscribe$AppSubscribeInfo = qQGamePubSubscribe$AppSubscribeInfo2;
                    i3 = 1;
                    QLog.e(TAG, 1, e, new Object[0]);
                    i17 = i3;
                    if (QLog.isColorLevel()) {
                    }
                    if (qQGamePubSubscribe$AppSubscribeInfo == null) {
                    }
                }
                i17 = i3;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleSetSubscribeStatusRsp...cmd:" + str + ",ret:" + j3 + ",scene:" + i17 + ",seq:" + j16);
            }
        }
        if (qQGamePubSubscribe$AppSubscribeInfo == null) {
            SimpleEventBus.getInstance().dispatchEvent(new QQGameSubscribeBusEvent(6));
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void handleSubscribeGrayTipsUi(String str, ChatMessage chatMessage, ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, chatMessage, viewGroup, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public boolean isFromAllMsgGameSinglePage(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) intent)).booleanValue();
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("qqgame_msg_single_page_from_key", 0);
        if (!isGameSinglePage(intent) || intExtra != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public boolean isGameSinglePage(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) intent)).booleanValue();
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("qqgame_msg_scene_key", 0);
        String stringExtra = intent.getStringExtra("qqgame_msg_page_appid_key");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "isGameSinglePage...singleKey:" + intExtra + ",appId:" + stringExtra);
        }
        if (intExtra != 2 || ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(stringExtra)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public boolean isSubscribed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.mSubscribedList) {
            Iterator<QQGamePubSubscribe$AppSubscribeInfo> it = this.mSubscribedList.iterator();
            while (it.hasNext()) {
                QQGamePubSubscribe$AppSubscribeInfo next = it.next();
                if (next != null && str != null) {
                    if (str.equals(next.appid.get() + "")) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = appRuntime;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCreate:" + appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void preHandleGameInfoUi(ViewGroup viewGroup, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) viewGroup, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "preHandleGameInfoUi...rootView:" + viewGroup + ",appId:" + str);
        }
        if (viewGroup != null && !((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(str)) {
            View findViewById = viewGroup.findViewById(R.id.root);
            QQGameSubscribeInfoView qQGameSubscribeInfoView = (QQGameSubscribeInfoView) viewGroup.findViewById(R.id.f630732j);
            if (qQGameSubscribeInfoView == null) {
                qQGameSubscribeInfoView = new QQGameSubscribeInfoView(viewGroup.getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mobileqq.qqgamepub.utils.g.a(80.0f, viewGroup.getResources()));
            layoutParams.addRule(3, R.id.rlCommenTitle);
            viewGroup.addView(qQGameSubscribeInfoView, layoutParams);
            findViewById.setPadding(0, com.tencent.mobileqq.qqgamepub.utils.g.a(80.0f, viewGroup.getResources()), 0, 0);
            qQGameSubscribeInfoView.g(str, null, false);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void putToGameInfoMap(String str, IQQGameSubscribeService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) aVar);
        } else if (!TextUtils.isEmpty(str) && aVar != null) {
            this.mGameBaseInfoMap.put(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public long reqSetSubscribeStatus(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(str)) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QQGamePubSubscribe$SetSubscribeStatusReq qQGamePubSubscribe$SetSubscribeStatusReq = new QQGamePubSubscribe$SetSubscribeStatusReq();
        qQGamePubSubscribe$SetSubscribeStatusReq.operation.set(i3);
        qQGamePubSubscribe$SetSubscribeStatusReq.appidList.add(Integer.valueOf(Integer.parseInt(str)));
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_SET_SUBSCRIBE_STATUS, false, qQGamePubSubscribe$SetSubscribeStatusReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("qqgame_msg_scene_key", i16);
        bundle.putLong("set_subscribe_seq_key", currentTimeMillis);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setSubscribeStatus...operation:" + i3 + ",appId:" + str + ",scene:" + i16 + ",seq:" + currentTimeMillis);
        }
        reportSetSubscribe(str, i3, i16);
        return currentTimeMillis;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
    public void reqSubscribeList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getSubscribeList...query:" + i3);
        }
        QQGamePubSubscribe$GetSubscribeListReq qQGamePubSubscribe$GetSubscribeListReq = new QQGamePubSubscribe$GetSubscribeListReq();
        qQGamePubSubscribe$GetSubscribeListReq.query.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_GET_SUBSCRIBE_LIST, false, qQGamePubSubscribe$GetSubscribeListReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }
}
