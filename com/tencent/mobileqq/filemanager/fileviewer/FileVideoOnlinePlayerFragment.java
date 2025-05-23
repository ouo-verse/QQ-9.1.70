package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.QQVideoPlayView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes12.dex */
public class FileVideoOnlinePlayerFragment extends IphoneTitleBarFragment implements SimpleEventReceiver {
    private QQVideoPlayView C = null;
    private RFWMediaFocusManager D;

    /* loaded from: classes12.dex */
    private static class a extends QQVideoPlayView {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<FileVideoOnlinePlayerFragment> f208167d;

        public a(FileVideoOnlinePlayerFragment fileVideoOnlinePlayerFragment, Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView) {
            super(context, j3, videoPlayParam, imageView);
            this.f208167d = new WeakReference<>(fileVideoOnlinePlayerFragment);
        }

        @Override // com.tencent.mobileqq.videoplatform.view.QQVideoPlayView, com.tencent.mobileqq.videoplatform.api.IBaseVideoView
        public void pause() {
            super.pause();
            FileVideoOnlinePlayerFragment fileVideoOnlinePlayerFragment = this.f208167d.get();
            if (fileVideoOnlinePlayerFragment != null) {
                fileVideoOnlinePlayerFragment.uh();
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.view.QQVideoPlayView, com.tencent.mobileqq.videoplatform.api.IBaseVideoView
        public void play() {
            super.play();
            FileVideoOnlinePlayerFragment fileVideoOnlinePlayerFragment = this.f208167d.get();
            if (fileVideoOnlinePlayerFragment != null) {
                fileVideoOnlinePlayerFragment.th();
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.view.QQVideoPlayView, com.tencent.mobileqq.videoplatform.api.IBaseVideoView
        public void releasePlayer(boolean z16) {
            super.releasePlayer(z16);
            FileVideoOnlinePlayerFragment fileVideoOnlinePlayerFragment = this.f208167d.get();
            if (fileVideoOnlinePlayerFragment != null) {
                fileVideoOnlinePlayerFragment.uh();
            }
        }
    }

    private void sh(@NotNull RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        QQVideoPlayView qQVideoPlayView;
        if (TextUtils.equals(Constants.Business.QQ_FILE_PREVIEW, rFWMediaFocusChangeEvent.getConflictBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict() && (qQVideoPlayView = this.C) != null && qQVideoPlayView.isPlaying()) {
            this.C.pause();
            uh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        RFWMediaFocusManager createMediaFocusManager = RFWMediaFocusManager.createMediaFocusManager(Constants.Business.QQ_FILE_PREVIEW);
        this.D = createMediaFocusManager;
        createMediaFocusManager.requestMediaFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        RFWMediaFocusManager rFWMediaFocusManager = this.D;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g6z;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.C.releasePlayer(false);
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.C.isPlaying()) {
            this.C.pause();
            QLog.d("FileVideoOnlinePlayerFragment", 1, "onPause video is playing, do pause playing");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            sh((RFWMediaFocusChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        vh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.iep);
        Intent intent = getBaseActivity().getIntent();
        String stringExtra = intent.getStringExtra(QCircleSchemeAttr.Detail.FEED_VIDEO_ID);
        String stringExtra2 = intent.getStringExtra("url");
        String stringExtra3 = intent.getStringExtra("cookie");
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mVideoFormat = 104;
        videoPlayParam.mUrls = new String[]{stringExtra2};
        ArrayList<String> arrayList = new ArrayList<>();
        videoPlayParam.mCookies = arrayList;
        arrayList.add(stringExtra3);
        videoPlayParam.mFileID = stringExtra;
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mIsLoop = false;
        videoPlayParam.mSceneId = 109;
        a aVar = new a(this, getBaseActivity(), 109L, videoPlayParam, null);
        this.C = aVar;
        relativeLayout.addView(aVar, -1, -1);
        this.C.play();
        super.onViewCreated(view, bundle);
        if (getTitleBarView() != null && (textView = (TextView) getTitleBarView().findViewById(R.id.ivTitleBtnLeft)) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qui_chevron_left_icon_white, 0, 0, 0);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    void vh() {
        PublicFragmentActivity publicFragmentActivity;
        SystemBarCompact systemBarComp;
        if (getTitleBarView() != null) {
            getTitleBarView().setBackgroundResource(0);
            getTitleBarView().setBackgroundColor(-16777216);
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (baseActivity instanceof PublicFragmentActivity) && (systemBarComp = SystemBarActivityModule.getSystemBarComp((publicFragmentActivity = (PublicFragmentActivity) baseActivity))) != null && needImmersive() && needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
            if (ThemeUtil.isInNightMode(publicFragmentActivity.app)) {
                if (!cu.g() && !cu.f()) {
                    systemBarComp.setStatusBarColor(0);
                    return;
                } else {
                    systemBarComp.setStatusBarColor(0);
                    systemBarComp.setStatusBarDarkMode(true);
                    return;
                }
            }
            if (!cu.g() && !cu.f()) {
                baseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
                systemBarComp.setStatusBarColor(0);
            } else if (!cu.f()) {
                systemBarComp.setStatusBarColor(0);
            } else {
                systemBarComp.setStatusBarColor(0);
                systemBarComp.setStatusBarDarkMode(true);
            }
        }
    }
}
