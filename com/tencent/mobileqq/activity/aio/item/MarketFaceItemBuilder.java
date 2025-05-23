package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MarketFaceItemBuilder {

    /* renamed from: a, reason: collision with root package name */
    public static int f179358a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static IPicEmoticonInfo f179359b;

    /* renamed from: c, reason: collision with root package name */
    public static ChatMessage f179360c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Emoticon f179374d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f179375e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179376f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f179377h;

        a(Emoticon emoticon, Context context, QQAppInterface qQAppInterface, int i3) {
            this.f179374d = emoticon;
            this.f179375e = context;
            this.f179376f = qQAppInterface;
            this.f179377h = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            boolean z16;
            if (this.f179374d.jobType == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            EmojiHomeUiPlugin.openEmojiDetailPage((Activity) this.f179375e, this.f179376f.getAccount(), 8, this.f179374d.epId, false, z16);
            ChatMessage chatMessage = MarketFaceItemBuilder.f179360c;
            if (chatMessage != null) {
                int i16 = this.f179377h;
                if (7 == i16) {
                    MarketFaceItemBuilder.g(this.f179376f, chatMessage.frienduin, "ep_mall", "Clk_pkg_forward", 0);
                } else if (6 == i16) {
                    MarketFaceItemBuilder.g(this.f179376f, chatMessage.frienduin, "ep_mall", "Clk_collect_more", 0);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c extends o.a {

        /* renamed from: f, reason: collision with root package name */
        public IPicEmoticonInfo f179378f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f179379g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f179380h;

        /* renamed from: i, reason: collision with root package name */
        public FrameLayout f179381i;

        /* renamed from: j, reason: collision with root package name */
        public ProgressBar f179382j;

        /* renamed from: k, reason: collision with root package name */
        public long f179383k;

        /* renamed from: l, reason: collision with root package name */
        public int f179384l = -1;
    }

    public static void b(QQAppInterface qQAppInterface, Emoticon emoticon, com.tencent.mobileqq.emosm.favroaming.j jVar) {
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("EmoBatchAdded", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        boolean z16 = false;
        if (emoticonDataList != null) {
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                CustomEmotionData customEmotionData = emoticonDataList.get(i3);
                if (customEmotionData.isMarkFace && customEmotionData.emoPath.equals(emoticon.epId) && customEmotionData.eId.equals(emoticon.eId)) {
                    if (iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData, i3)) {
                        MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
                        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
                        if (handler != null) {
                            handler.obtainMessage(10).sendToTarget();
                        }
                        com.tencent.mobileqq.emosm.favroaming.d.a(jVar, 4);
                        return;
                    }
                    com.tencent.mobileqq.emosm.favroaming.d.a(jVar, 2);
                    EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
                    return;
                }
            }
        }
        CustomEmotionData customEmotionData2 = new CustomEmotionData();
        customEmotionData2.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData2.emoId = jVar.getEmoId();
        customEmotionData2.isMarkFace = true;
        customEmotionData2.emoPath = emoticon.epId;
        customEmotionData2.eId = emoticon.eId;
        customEmotionData2.checkMarketFace("addEmotionToFavorite");
        EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId);
        if (syncFindEmoticonPackageById != null) {
            if (syncFindEmoticonPackageById.isAPNG == 2) {
                z16 = true;
            }
            customEmotionData2.isAPNG = z16;
        }
        jVar.b(customEmotionData2);
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        if (iFavroamingManagerService != null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoBatchAdded", 1, "addBatchEmotionToFavorite fm.syncUpload");
            }
            iFavroamingManagerService.syncUpload(customEmotionData2, jVar);
        }
    }

    public static int c(final Context context, QQAppInterface qQAppInterface, Emoticon emoticon, Handler handler) {
        int i3;
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        boolean z16 = true;
        int i16 = 0;
        if (emoticonDataList != null) {
            int i17 = 0;
            i3 = 1;
            while (i16 < emoticonDataList.size()) {
                CustomEmotionData customEmotionData = emoticonDataList.get(i16);
                if (TextUtils.isEmpty(customEmotionData.RomaingType) || !"needDel".equals(customEmotionData.RomaingType)) {
                    i17++;
                }
                if (customEmotionData.isMarkFace && customEmotionData.emoPath.equals(emoticon.epId) && customEmotionData.eId.equals(emoticon.eId)) {
                    if (iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData, i16)) {
                        MqqHandler handler2 = qQAppInterface.getHandler(ChatActivity.class);
                        if (handler != null) {
                            handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    QQToast.makeText(context.getApplicationContext(), context.getString(R.string.f170069ez), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                }
                            });
                        }
                        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
                        if (handler2 != null) {
                            handler2.obtainMessage(10).sendToTarget();
                        }
                    } else {
                        if (handler != null) {
                            handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    QQToast.makeText(context.getApplicationContext(), 0, context.getString(R.string.f170070f0), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                }
                            });
                        }
                        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
                    }
                    return 0;
                }
                int i18 = customEmotionData.emoId;
                if (i3 < i18) {
                    i3 = i18;
                }
                i16++;
            }
            if (i17 >= FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                i16 = -2;
            } else {
                i16 = 0;
            }
        } else {
            i3 = 1;
        }
        CustomEmotionData customEmotionData2 = new CustomEmotionData();
        customEmotionData2.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData2.emoId = i3 + 1;
        customEmotionData2.isMarkFace = true;
        customEmotionData2.emoPath = emoticon.epId;
        customEmotionData2.eId = emoticon.eId;
        customEmotionData2.checkMarketFace("addEmotionToFavorite");
        EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId);
        if (syncFindEmoticonPackageById != null) {
            if (syncFindEmoticonPackageById.isAPNG != 2) {
                z16 = false;
            }
            customEmotionData2.isAPNG = z16;
        }
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        if (iFavroamingManagerService != null) {
            iFavroamingManagerService.syncUpload(customEmotionData2, ((IEmoAddedAuthCallbackService) QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(qQAppInterface, context, customEmotionData2, null, 0));
        }
        ChatMessage chatMessage = f179360c;
        if (chatMessage != null) {
            g(qQAppInterface, chatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return i16;
    }

    public static void d(QQAppInterface qQAppInterface, EmoticonPackage emoticonPackage, IPicEmoticonInfo iPicEmoticonInfo, com.tencent.mobileqq.emosm.favroaming.j jVar) {
        if (iPicEmoticonInfo == null) {
            return;
        }
        if (emoticonPackage != null && emoticonPackage.mobileFeetype == 1) {
            b(qQAppInterface, iPicEmoticonInfo.getEmoticon(), jVar);
        } else {
            ((com.tencent.mobileqq.emosm.o) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).t2(6, Integer.valueOf(iPicEmoticonInfo.getEmoticon().epId).intValue(), iPicEmoticonInfo.getEmoticon().eId);
        }
    }

    public static void e(int i3, Context context, QQAppInterface qQAppInterface, EmoticonPackage emoticonPackage, IPicEmoticonInfo iPicEmoticonInfo, SessionInfo sessionInfo, QQProgressDialog qQProgressDialog, boolean z16) {
        if (iPicEmoticonInfo == null) {
            return;
        }
        if (emoticonPackage != null && emoticonPackage.mobileFeetype == 1) {
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                qQProgressDialog.dismiss();
            }
            j(i3, context, qQAppInterface, iPicEmoticonInfo.getEmoticon(), 0, null, sessionInfo, z16);
            return;
        }
        if (NetworkUtil.isNetworkAvailable(context) && i3 <= 1000) {
            ((com.tencent.mobileqq.emosm.o) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).t2(i3, Integer.valueOf(iPicEmoticonInfo.getEmoticon().epId).intValue(), iPicEmoticonInfo.getEmoticon().eId);
            return;
        }
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            qQProgressDialog.dismiss();
        }
        j(i3, context, qQAppInterface, iPicEmoticonInfo.getEmoticon(), ErrorCode.WX_TTS_ERROR_TEXT_TO_GBK, HardCodeUtil.qqStr(R.string.nyb), sessionInfo, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
    
        r0 = r0.get(0).topActivity;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(Context context) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0 || componentName == null) {
            return true;
        }
        return context.getClass().getName().equals(componentName.getClassName());
    }

    public static void g(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3) {
        ReportController.o(qQAppInterface, "CliOper", "", "", str2, str3, i3, 0, "", "", "", "");
    }

    public static boolean h(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("MarketFaceItemBuilder", 2, "isQBoxEmoticon: " + i3);
        }
        com.tencent.mobileqq.config.business.k emoticonQBoxConfig = ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getEmoticonQBoxConfig();
        if (emoticonQBoxConfig.b()) {
            return false;
        }
        ArrayList<Integer> arrayList = emoticonQBoxConfig.a().f202670f;
        if (arrayList != null && arrayList.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("MarketFaceItemBuilder", 2, "isQBoxEmoticon packageIDs: " + arrayList.toString());
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                if (i3 == arrayList.get(i16).intValue()) {
                    return true;
                }
            }
            return false;
        }
        QLog.i("MarketFaceItemBuilder", 2, "isQBoxEmoticon packageIDs empty");
        return false;
    }

    public static void i(String str, QQAppInterface qQAppInterface) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.config.business.k emoticonQBoxConfig = ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getEmoticonQBoxConfig();
            if (!emoticonQBoxConfig.b()) {
                str = emoticonQBoxConfig.a().f202669e;
            } else {
                str = "";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ax c16 = bi.c(qQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext(), str);
            if (c16 != null) {
                c16.b();
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MarketFaceItemBuilder", 2, "jumpToEmoticonQBoxWeb jumpUrl is illegal");
                    return;
                }
                return;
            }
        }
        QLog.i("MarketFaceItemBuilder", 1, "jumpToEmoticonQBoxWeb failed");
    }

    public static void j(final int i3, final Context context, final QQAppInterface qQAppInterface, final Emoticon emoticon, int i16, final String str, SessionInfo sessionInfo, boolean z16) {
        if (emoticon == null) {
            QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
            return;
        }
        if (!f(context)) {
            if (QLog.isColorLevel()) {
                QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
                return;
            }
            return;
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        if (i16 == 0) {
            int i17 = i3 % 1000;
            if (7 == i17) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("forward_type", 9);
                    bundle.putBoolean(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, z16);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    ForwardBaseOption.startForwardActivityForResult((BaseActivity) context, intent, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gif");
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (6 == i17) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarketFaceItemBuilder.c(context, qQAppInterface, emoticon, handler);
                    }
                }, 5, null, true);
                return;
            } else {
                if (107 == i17) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", emoticon.epId, "", "");
                    return;
                }
                return;
            }
        }
        if (i16 < 0) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context.getApplicationContext(), str, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            if (6 == i3 % 1000) {
                EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2001", 1);
            }
            QLog.i("MarketFaceItemBuilder", 1, "opType: " + i3 + ",result:" + i16);
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.3
            @Override // java.lang.Runnable
            public void run() {
                int i18 = i3;
                Context context2 = context;
                MarketFaceItemBuilder.n(i18, context2, qQAppInterface, emoticon, context2.getString(R.string.i1h), str);
            }
        });
        if (6 == i3 % 1000) {
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2002", 1);
        }
    }

    public static void k(int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800C45F", "0X800C45F", 0, 0, i3 + "", "", "", "");
    }

    public static void l() {
        ReportController.o(null, "dc00898", "", "", "0X800C45E", "0X800C45E", 0, 0, "", "", "", "");
    }

    public static boolean m(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, Context context) {
        com.tencent.mobileqq.config.business.k emoticonQBoxConfig = ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getEmoticonQBoxConfig();
        if (emoticonQBoxConfig.b()) {
            return false;
        }
        DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.f170313lz), emoticonQBoxConfig.a().f202666b, emoticonQBoxConfig.a().f202667c, emoticonQBoxConfig.a().f202668d, onClickListener, onClickListener2).show();
        l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(int i3, Context context, QQAppInterface qQAppInterface, Emoticon emoticon, String str, String str2) {
        try {
            DialogUtil.createCustomDialog(context, 230, str, str2, R.string.cancel, R.string.ant, new a(emoticon, context, qQAppInterface, i3), new b()).show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
