package com.tencent.mobileqq.emoticonview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.fd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPanelSystemAndEmojiHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelSystemAndEmojiHelper";
    private long mLastOpenTime;
    private int mLastPosition;
    private ImageView mPopupGuideView;

    public EmoticonPanelSystemAndEmojiHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
        } else {
            this.mLastPosition = -1;
            this.mLastOpenTime = -1L;
        }
    }

    private SystemAndEmojiAdapter fetchSystemAndEmojiAdapter() {
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
        EmotionPanelViewPagerAdapter pageAdapter = ((EmoticonPanelController) this.mPanelController).getPageAdapter();
        if (panelDataList != null && panelDataList.size() > 0 && pageAdapter != null) {
            Iterator<EmotionPanelInfo> it = panelDataList.iterator();
            while (it.hasNext()) {
                BaseEmotionAdapter adapterFromCache = pageAdapter.getAdapterFromCache(it.next());
                if (adapterFromCache instanceof SystemAndEmojiAdapter) {
                    return (SystemAndEmojiAdapter) adapterFromCache;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return LOG_TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{4, 14, 8, 3, 7, 6};
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) this.mPanelController).app;
            if (view.getId() == R.id.f164115k1) {
                SystemAndEmojiAdapter fetchSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
                if (fetchSystemAndEmojiAdapter != null) {
                    fetchSystemAndEmojiAdapter.setSelectionToApolloEmoticon();
                }
                fd.a(qQEmoticonMainPanelApp.getQQAppInterface(), "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        CommonUsedSystemEmojiManagerServiceProxy commonUsedSystemEmojiManagerServiceProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) this.mPanelController).app;
        if (qQEmoticonMainPanelApp != null && (commonUsedSystemEmojiManagerServiceProxy = (CommonUsedSystemEmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)) != null) {
            commonUsedSystemEmojiManagerServiceProxy.saveSystemEmojiInfoToFile();
        }
        removePopupGuide();
        tryReportPanelShowTime();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        IPanelInteractionListener interactionListener = ((EmoticonPanelController) this.mPanelController).getInteractionListener();
        if (interactionListener != null) {
            interactionListener.removeEmoticonGuideBubble();
        }
        tryReportPanelShowTime();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 != 0) {
            removePopupGuide();
        }
        reportPanelOpenTimeEvent(i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "tryReportShowTime onPause ");
        }
        tryReportPanelShowTime();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onResume select: " + BasePanelModel.sLastSelectedSecondTabIndex);
        }
        reportPanelOpenTimeEvent(BasePanelModel.sLastSelectedSecondTabIndex);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShowPageFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onShowPageFinish select: " + BasePanelModel.sLastSelectedSecondTabIndex);
        }
        reportPanelOpenTimeEvent(BasePanelModel.sLastSelectedSecondTabIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removePopupGuide() {
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[removePopupGuide]");
        }
        ImageView imageView = this.mPopupGuideView;
        if (imageView != null && imageView.getParent() != null) {
            ((ViewGroup) this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
        }
    }

    protected void reportPanelOpenTimeEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (this.mLastPosition != i3 && i3 >= 0) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onPageSelected position: " + i3);
            }
            if (!((EmoticonPanelController) this.mPanelController).isInAIO()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "mBusinessType not AIO, it is " + ((EmoticonPanelController) this.mPanelController).getBusinessType());
                    return;
                }
                return;
            }
            if (((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
                if (((EmoticonPanelController) this.mPanelController).findIndexByPanelType(7) == i3) {
                    this.mLastOpenTime = System.currentTimeMillis();
                } else {
                    tryReportPanelShowTime();
                }
                this.mLastPosition = i3;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "mPanelController.panelDataList is null or position error ");
            }
        }
    }

    public void showEmoticonPopupGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        T t16 = this.mPanelController;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
        Context context = ((EmoticonPanelController) t16).context;
        if (qQEmoticonMainPanelApp != null && ((IApolloUtil) QRoute.api(IApolloUtil.class)).shouldShowPopupGuide()) {
            if (this.mPopupGuideView == null) {
                ImageView imageView = new ImageView(context);
                this.mPopupGuideView = imageView;
                imageView.setId(R.id.f164115k1);
                this.mPopupGuideView.setImageResource(R.drawable.c0g);
            }
            this.mPopupGuideView.setClickable(true);
            this.mPopupGuideView.setOnClickListener(this);
            if (this.mPopupGuideView.getParent() != null) {
                ((ViewGroup) this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.tencent.mobileqq.EmotionUtils.a(52.0f, context.getResources());
            layoutParams.rightMargin = com.tencent.mobileqq.EmotionUtils.a(15.0f, context.getResources());
            ((EmoticonPanelController) this.mPanelController).getPanel().addView(this.mPopupGuideView, layoutParams);
            ((IApolloUtil) QRoute.api(IApolloUtil.class)).onPopupGuideShown();
            fd.a(qQEmoticonMainPanelApp.getQQAppInterface(), "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
        }
    }

    public void switchSystemEmojiTabLocationPos(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (BasePanelModel.sLastSelectedSecondTabIndex == ((EmoticonPanelController) this.mPanelController).findIndexByPanelType(7)) {
            SystemAndEmojiAdapter fetchSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
            if (fetchSystemAndEmojiAdapter != null) {
                fetchSystemAndEmojiAdapter.setSelectionToEmoticonByLocalId(i3, i16);
                return;
            }
            return;
        }
        ((EmoticonPanelController) this.mPanelController).getPanel().mLocalId = i16;
        ((EmoticonPanelController) this.mPanelController).getPanel().mEmotionType = i3;
        ((EmoticonPanelController) this.mPanelController).initEmoticonView(7);
    }

    protected void tryReportPanelShowTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mLastOpenTime != -1) {
            long currentTimeMillis = (System.currentTimeMillis() - this.mLastOpenTime) / 1000;
            if (currentTimeMillis >= 0) {
                ReportController.o(null, "dc00898", "", "", "0X800B9F5", "0X800B9F5", 0, 0, "" + currentTimeMillis, "", "", "");
            }
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "tryReportShowTime report show time: " + currentTimeMillis);
            }
            this.mLastOpenTime = -1L;
            this.mLastPosition = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public void updateEmojiMallRedpoint() {
        if (((RedTouchManagerProxy) ((EmoticonPanelController) this.mPanelController).app.getRuntimeService(IRedTouchManager.class)).getAppInfoNewFlagByPath("100610.100611") != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "emoji mall has redpoint.");
            }
            ReportController.o(((EmoticonPanelController) this.mPanelController).app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
            if (((EmoticonPanelController) this.mPanelController).context.getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
                ((EmoticonPanelController) this.mPanelController).getNewFlag().setVisibility(0);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonPanelSystemAndEmojiHelper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.6f);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag(), BasicAnimation.KeyPath.ROTATION, 0.0f, 50.0f);
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag(), com.tencent.luggage.wxa.c8.c.f123400v, 0.6f, 1.0f);
                        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag(), BasicAnimation.KeyPath.ROTATION, 50.0f, 0.0f);
                        ofFloat.setDuration(300L);
                        ofFloat.setInterpolator(new LinearInterpolator());
                        ofFloat2.setDuration(400L);
                        ofFloat2.setInterpolator(new LinearInterpolator());
                        ofFloat3.setDuration(400L);
                        ofFloat3.setInterpolator(new LinearInterpolator());
                        ofFloat4.setDuration(400L);
                        ofFloat4.setInterpolator(new LinearInterpolator());
                        ofFloat5.setDuration(400L);
                        ofFloat5.setInterpolator(new LinearInterpolator());
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(ofFloat4).after(ofFloat2);
                        animatorSet.play(ofFloat5).after(ofFloat3);
                        animatorSet.play(ofFloat2).with(ofFloat3).after(ofFloat);
                        ((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getNewFlag().setVisibility(0);
                        animatorSet.start();
                        ((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).context.getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", true).apply();
                    }
                }, 200L);
            }
        }
    }

    public void updateRecentEmoji(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
            return;
        }
        SystemAndEmojiAdapter fetchSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
        if (fetchSystemAndEmojiAdapter == null) {
            return;
        }
        int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
        List<EmotionPanelData> data = fetchSystemAndEmojiAdapter.getData();
        List<EmotionPanelData> customEmoticonPanelData = SystemAndEmojiEmoticonInfo.getCustomEmoticonPanelData(SystemAndEmojiEmoticonInfo.TITLE_OFTEN, i3, list);
        int size = data.size();
        int i16 = i3;
        while (true) {
            if (i16 >= size) {
                break;
            }
            EmotionPanelData emotionPanelData = data.get(i16);
            if ((emotionPanelData instanceof SystemAndEmojiEmoticonInfo) && ((SystemAndEmojiEmoticonInfo) emotionPanelData).emotionType == 3) {
                i3 = i16;
                break;
            }
            i16++;
        }
        if (i3 <= data.size()) {
            customEmoticonPanelData.addAll(data.subList(i3, data.size()));
        }
        fetchSystemAndEmojiAdapter.setData(customEmoticonPanelData);
    }

    public void updateSystemAndEmojiPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "refresh fav emoticon panel");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelSystemAndEmojiHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                EmotionPanelInfo emotionPanelInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getPanelDataList();
                if (panelDataList != null) {
                    for (int i3 = 0; i3 < panelDataList.size(); i3++) {
                        emotionPanelInfo = panelDataList.get(i3);
                        if (emotionPanelInfo != null && emotionPanelInfo.type == 7) {
                            break;
                        }
                    }
                }
                emotionPanelInfo = null;
                if (emotionPanelInfo != null && ((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getPageAdapter() != null) {
                    ((EmoticonPanelController) EmoticonPanelSystemAndEmojiHelper.this.mPanelController).getPageAdapter().refreshListViewAdapter(emotionPanelInfo);
                }
            }
        }, 200L);
    }
}
