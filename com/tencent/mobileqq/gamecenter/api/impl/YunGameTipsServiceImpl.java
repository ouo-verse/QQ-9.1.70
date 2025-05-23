package com.tencent.mobileqq.gamecenter.api.impl;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.gamecenter.api.IYunGameTipsService;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameTipsServiceImpl implements IYunGameTipsService, IYunGameManagerService.b {
    public static final String TAG = "YunGameTipsServiceImpl";
    private boolean isStart;
    private IYunGameConstant.GameStatusInfo mCurrentStatusInfo;
    private MqqHandler mHandler;
    private Set<Integer> mJumpStatusSet;
    private Set<Integer> mStatusSet;
    private String queueNoticeBlackGameId = "";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GameInfo f211904d;

        a(GameInfo gameInfo) {
            this.f211904d = gameInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (YunGameTipsServiceImpl.this.mCurrentStatusInfo == null) {
                QLog.d(YunGameTipsServiceImpl.TAG, 1, "[onClick] statuInfo is null, return");
            } else if (!YunGameTipsServiceImpl.this.mJumpStatusSet.contains(Integer.valueOf(YunGameTipsServiceImpl.this.mCurrentStatusInfo.getStatus()))) {
                QLog.d(YunGameTipsServiceImpl.TAG, 1, "[onClick] status:" + YunGameTipsServiceImpl.this.mCurrentStatusInfo.getStatus() + ", return.");
                YunGameTipsServiceImpl.this.hideBanner();
            } else {
                GameInfo gameInfo = this.f211904d;
                if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getJumpUrl())) {
                    YunGameTipsServiceImpl yunGameTipsServiceImpl = YunGameTipsServiceImpl.this;
                    yunGameTipsServiceImpl.report("914206", "20", yunGameTipsServiceImpl.mCurrentStatusInfo, false);
                    String jumpUrl = this.f211904d.getJumpUrl();
                    YunGameTipsServiceImpl.this.hideBanner();
                    QLog.d(YunGameTipsServiceImpl.TAG, 1, "[onClick] jumpUrl:" + jumpUrl);
                    GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, jumpUrl);
                } else {
                    QLog.e(YunGameTipsServiceImpl.TAG, 1, "[onClick] jumpUrl or gameInfo is null");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GameInfo f211906d;

        b(GameInfo gameInfo) {
            this.f211906d = gameInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GameInfo gameInfo;
            EventCollector.getInstance().onViewClickedBefore(view);
            YunGameTipsServiceImpl yunGameTipsServiceImpl = YunGameTipsServiceImpl.this;
            yunGameTipsServiceImpl.report("914206", "20", yunGameTipsServiceImpl.mCurrentStatusInfo, true);
            if (YunGameTipsServiceImpl.this.mCurrentStatusInfo != null && YunGameTipsServiceImpl.this.mCurrentStatusInfo.getStatus() == 2 && (gameInfo = this.f211906d) != null && !TextUtils.isEmpty(gameInfo.getGameId())) {
                YunGameTipsServiceImpl.this.queueNoticeBlackGameId = this.f211906d.getGameId();
            }
            YunGameTipsServiceImpl.this.hideBanner();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private String genTipsByStatus(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        String str;
        String str2;
        if (gameStatusInfo == null) {
            return "";
        }
        GameInfo gameInfo = getGameInfo(gameStatusInfo);
        if (gameInfo != null) {
            str = gameInfo.getGameName();
            str2 = gameInfo.getGameId();
        } else {
            str = null;
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        int status = gameStatusInfo.getStatus();
        if (status != -7) {
            if (status != 2) {
                if (status != -4 && status != -3 && status != -2 && status != -1) {
                    if (status != 0) {
                        return "";
                    }
                    String format = String.format(MobileQQ.sMobileQQ.getResources().getString(R.string.f1375907_), str);
                    optResetBlackGameId(str2);
                    return format;
                }
            } else {
                int index = gameStatusInfo.getIndex() * 16;
                if (index > 300) {
                    index = 300;
                }
                if (TextUtils.isEmpty(str)) {
                    return String.format(MobileQQ.sMobileQQ.getResources().getString(R.string.f13758079), Integer.valueOf(gameStatusInfo.getIndex()), Integer.valueOf(index));
                }
                return String.format(MobileQQ.sMobileQQ.getResources().getString(R.string.f13757078), str, Integer.valueOf(gameStatusInfo.getIndex()), Integer.valueOf(index));
            }
        }
        String format2 = String.format(MobileQQ.sMobileQQ.getResources().getString(R.string.f13756077), str);
        optResetBlackGameId(str2);
        return format2;
    }

    private GameInfo getGameInfo(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        return gameStatusInfo.getGameInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBanner() {
        Message message = new Message();
        message.what = 0;
        BannerManager.l().O(com.tencent.mobileqq.banner.d.O, 0, message);
    }

    private void optResetBlackGameId(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.queueNoticeBlackGameId)) {
            this.queueNoticeBlackGameId = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str, String str2, IYunGameConstant.GameStatusInfo gameStatusInfo, boolean z16) {
        long j3;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        int i16;
        GameInfo gameInfo = getGameInfo(gameStatusInfo);
        if (gameStatusInfo != null && gameInfo != null) {
            str4 = gameInfo.getAppId();
            j3 = (System.currentTimeMillis() - gameInfo.getStartQueueTimeStamp()) / 1000;
            QLog.d(TAG, 1, "[updateTips] queueTime:" + j3);
            i3 = gameStatusInfo.getIndex();
            if (gameStatusInfo.getStatus() == 0) {
                i16 = 4;
            } else if (gameStatusInfo.getStatus() == 2) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            str5 = gameInfo.getReportChannelId();
            str6 = gameInfo.getGameId();
            str3 = gameInfo.getReportActId();
        } else {
            j3 = 0;
            i3 = 0;
            str3 = "";
            str4 = str3;
            str5 = str4;
            str6 = str5;
            i16 = 0;
        }
        if (z16) {
            i16 = 5;
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setGameAppId(str4).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(46, j3 + "").setExt(6, "" + i16).setExt(49, "" + i3).setExt(41, str5).setExt(42, str6).setExt(43, str3).report();
    }

    private boolean showQueueLimit(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        GameInfo gameInfo = getGameInfo(gameStatusInfo);
        if (gameStatusInfo.getStatus() == 2 && gameInfo != null && !TextUtils.isEmpty(gameInfo.getGameId()) && gameInfo.getGameId().equals(this.queueNoticeBlackGameId)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameTipsService
    public void finish() {
        this.isStart = false;
        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IYunGameManagerService.class, "");
        if (iYunGameManagerService != null) {
            iYunGameManagerService.removeGameStateListener(this);
        }
        hideBanner();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mHandler = new MqqHandler(Looper.getMainLooper());
        HashSet hashSet = new HashSet();
        this.mStatusSet = hashSet;
        hashSet.add(0);
        this.mStatusSet.add(2);
        this.mStatusSet.add(-1);
        this.mStatusSet.add(-2);
        this.mStatusSet.add(-3);
        this.mStatusSet.add(-4);
        this.mStatusSet.add(-7);
        HashSet hashSet2 = new HashSet();
        this.mJumpStatusSet = hashSet2;
        hashSet2.add(0);
        this.mJumpStatusSet.add(2);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        finish();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.b
    public void onStateChange(IYunGameConstant.GameStatusInfo gameStatusInfo) {
        if (gameStatusInfo == null) {
            return;
        }
        if (!this.mStatusSet.contains(Integer.valueOf(gameStatusInfo.getStatus()))) {
            QLog.d(TAG, 1, "[onStateChange] status:" + gameStatusInfo.getStatus() + ", return.");
            return;
        }
        if (showQueueLimit(gameStatusInfo)) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.obj = gameStatusInfo;
        BannerManager.l().O(com.tencent.mobileqq.banner.d.O, 2, message);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameTipsService
    public void start() {
        IYunGameManagerService iYunGameManagerService;
        if (!this.isStart && (iYunGameManagerService = (IYunGameManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IYunGameManagerService.class, "")) != null) {
            iYunGameManagerService.addGameStateListener(this);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameTipsService
    public void updateTips(View view, Message message) {
        final com.tencent.biz.qui.noticebar.d d16;
        if (message == null || (d16 = QUINoticeBarManager.l().d(view)) == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 0) {
            QLog.d(TAG, 1, "updateTips hide bar");
            view.setVisibility(8);
            return;
        }
        Object obj = message.obj;
        if ((obj instanceof IYunGameConstant.GameStatusInfo) && i3 == 2) {
            IYunGameConstant.GameStatusInfo gameStatusInfo = (IYunGameConstant.GameStatusInfo) obj;
            String genTipsByStatus = genTipsByStatus(gameStatusInfo);
            if (TextUtils.isEmpty(genTipsByStatus)) {
                QLog.d(TAG, 1, "updateTips tip is empty return.");
                return;
            }
            if (view.getVisibility() != 0) {
                report("914205", "7", gameStatusInfo, false);
            }
            view.setVisibility(0);
            d16.setIcon(R.drawable.c47).setMsg(genTipsByStatus);
            this.mCurrentStatusInfo = gameStatusInfo;
            GameInfo gameInfo = getGameInfo(gameStatusInfo);
            d16.c(new a(gameInfo));
            d16.k(new b(gameInfo));
            if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getIconUrl())) {
                URLDrawable drawable = URLDrawable.getDrawable(gameInfo.getIconUrl(), URLDrawable.URLDrawableOptions.obtain());
                if (drawable.getStatus() == 1) {
                    d16.setIcon(drawable);
                } else {
                    drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameTipsServiceImpl.3
                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadCanceled(URLDrawable uRLDrawable) {
                            QLog.d(YunGameTipsServiceImpl.TAG, 1, "onLoadCanceled...");
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                            QLog.d(YunGameTipsServiceImpl.TAG, 1, "onLoadFialed...");
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadSuccessed(final URLDrawable uRLDrawable) {
                            QLog.d(YunGameTipsServiceImpl.TAG, 1, "onLoadSuccessed urlDrawable=" + uRLDrawable);
                            YunGameTipsServiceImpl.this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameTipsServiceImpl.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d16.setIcon(uRLDrawable);
                                }
                            });
                        }

                        @Override // com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadProgressed(URLDrawable uRLDrawable, int i16) {
                        }
                    });
                    drawable.startDownload();
                }
            }
        }
    }
}
