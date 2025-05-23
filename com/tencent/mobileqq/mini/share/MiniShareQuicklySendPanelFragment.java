package com.tencent.mobileqq.mini.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelAdapter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.mobileqq.widget.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class MiniShareQuicklySendPanelFragment extends PublicBaseFragment implements r, View.OnClickListener {
    public static final int QUCIKLY_SHARE_REQUEST_CODE = 678;
    public static final String TAG = "MiniShareQuicklySendPanelFragment";
    private MiniShareQuicklySendPanelAdapter adapter;
    private ImageView arrowView;
    private View backgroundView;
    private View contentView;
    private View footerView;
    private XListView listView;
    private ScreenShotHelper mHelper;
    private View mRootView;
    private Handler mainHandler;
    private SlideBottomPanel slidePanel;
    private boolean isShowedPanel = false;
    private boolean needShareCallback = false;
    private boolean isCallback = false;

    private void dealSendViewAnimation() {
        View view = this.footerView;
        if (view != null && view.getVisibility() == 8 && this.slidePanel.n()) {
            showSendView(0, 1, 0);
        }
    }

    private View getBottomView() {
        View view = new View(getBaseActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(130.0f, getResources())));
        view.setBackgroundResource(R.drawable.skin_setting_strip_bg_unpressed);
        return view;
    }

    private void initData() {
        Bundle extras = getBaseActivity().getIntent().getExtras();
        if (extras != null) {
            this.needShareCallback = extras.getBoolean("needShareCallBack", false);
            extras.putBoolean("needShareCallBack", false);
        }
        MiniShareQuicklySendPanelAdapter miniShareQuicklySendPanelAdapter = new MiniShareQuicklySendPanelAdapter(getBaseActivity(), getBaseActivity().app, this.listView, extras);
        this.adapter = miniShareQuicklySendPanelAdapter;
        this.listView.setAdapter((ListAdapter) miniShareQuicklySendPanelAdapter);
        ScreenShotHelper screenShotHelper = new ScreenShotHelper();
        this.mHelper = screenShotHelper;
        screenShotHelper.e(new ScreenShotHelper.c() { // from class: com.tencent.mobileqq.mini.share.d
            @Override // com.tencent.mobileqq.screendetect.ScreenShotHelper.c
            public final void a(List list) {
                MiniShareQuicklySendPanelFragment.this.lambda$initData$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0(List list) {
        this.adapter.setData(resetResultRecordToSendPanelData(list));
    }

    private ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> resetResultRecordToSendPanelData(List<RecentUser> list) {
        ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> arrayList = new ArrayList<>();
        int i3 = 0;
        for (RecentUser recentUser : list) {
            RecentUser recentUser2 = new RecentUser(recentUser.uin, recentUser.type);
            RecentItemNoticeData recentItemNoticeData = new RecentItemNoticeData(recentUser2);
            recentUser2.troopUin = recentUser.troopUin;
            recentUser2.msgType = recentUser.msgType;
            recentItemNoticeData.mTitleName = recentUser.displayName;
            MiniShareQuicklySendPanelAdapter.SendPanelData sendPanelData = new MiniShareQuicklySendPanelAdapter.SendPanelData(recentItemNoticeData);
            sendPanelData.position = i3;
            sendPanelData.operateStatus = 0;
            i3++;
            arrayList.add(sendPanelData);
        }
        return arrayList;
    }

    private void shareCallBack(boolean z16) {
        if (!this.needShareCallback || this.isCallback) {
            return;
        }
        this.isCallback = true;
        if (z16) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
        } else {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
        }
    }

    private void showSendView(int i3, int i16, int i17) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(i3, i16);
        this.footerView.startAnimation(alphaAnimation);
        alphaAnimation.setDuration(500L);
        this.footerView.setVisibility(i17);
    }

    @Override // com.tencent.mobileqq.widget.r
    public void displayPanel() {
        dealSendViewAnimation();
        View view = this.backgroundView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void displayPanelFinish() {
        ImageView imageView = this.arrowView;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.hzl);
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void fadeBackground(float f16) {
        View view = this.backgroundView;
        if (view != null) {
            view.setVisibility(0);
            this.backgroundView.setAlpha(f16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.widget.r
    public void hidePanel() {
        View view = this.footerView;
        if (view != null && view.getVisibility() == 0) {
            showSendView(1, 0, 8);
        }
        View view2 = this.backgroundView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.mainHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (MiniShareQuicklySendPanelFragment.this.getBaseActivity() == null) {
                    QLog.e(MiniShareQuicklySendPanelFragment.TAG, 1, "hidePanel: getBaseActivity() is null!");
                } else {
                    MiniShareQuicklySendPanelFragment.this.getBaseActivity().finish();
                    MiniShareQuicklySendPanelFragment.this.getBaseActivity().overridePendingTransition(0, 0);
                }
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.widget.r
    public void hidePanelFinish() {
        ImageView imageView = this.arrowView;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.hzk);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str = TAG;
        QLog.d(str, 4, "onActivityResult requestCode:" + i3);
        if (i3 == 678) {
            if (i16 == -1) {
                QLog.d(str, 4, "onActivityResult RESULT_OK:" + i16);
                shareCallBack(true);
                this.adapter.notifyShareSuc();
            } else {
                QLog.d(str, 4, "onActivityResult other:" + i16);
                this.adapter.notifyShareCancel();
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.imy) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "R.id.send - onClick");
        }
        getBaseActivity().finish();
        getBaseActivity().overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().app == null) {
            return null;
        }
        this.mainHandler = new Handler(Looper.getMainLooper());
        View inflate = layoutInflater.inflate(R.layout.ceh, viewGroup, false);
        this.mRootView = inflate;
        this.slidePanel = (SlideBottomPanel) inflate.findViewById(R.id.m8z);
        this.contentView = this.mRootView.findViewById(R.id.b_7);
        this.listView = (XListView) this.mRootView.findViewById(R.id.eap);
        this.footerView = this.mRootView.findViewById(R.id.m7z);
        this.backgroundView = this.mRootView.findViewById(R.id.a4f);
        this.arrowView = (ImageView) this.mRootView.findViewById(R.id.f167007jv2);
        this.listView.addFooterView(getBottomView());
        this.slidePanel.setSlidePanelListener(this);
        this.footerView.findViewById(R.id.imy).setOnClickListener(this);
        initData();
        return this.mRootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MiniShareQuicklySendPanelAdapter miniShareQuicklySendPanelAdapter = this.adapter;
        if (miniShareQuicklySendPanelAdapter != null) {
            miniShareQuicklySendPanelAdapter.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        SlideBottomPanel slideBottomPanel = this.slidePanel;
        if (slideBottomPanel == null || this.isShowedPanel) {
            return;
        }
        slideBottomPanel.b();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        shareCallBack(false);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.widget.r
    public void cancelAnimator() {
    }
}
