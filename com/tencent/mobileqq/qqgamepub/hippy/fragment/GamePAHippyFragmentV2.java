package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.b;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class GamePAHippyFragmentV2 extends GamePAHippyBaseFragment<b> {
    @Override // lh2.a
    /* renamed from: Ah, reason: merged with bridge method [inline-methods] */
    public b V() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("initView");
        ((b) this.C).O(2);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("loadHippy");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("initGameContentView");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("initPreloadListener");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("initViewEnd");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(final int i3, final String str) {
        super.onLoadHippyError(i3, str);
        QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "onLoadHippyError statusCode:" + i3 + " msg:" + str);
        ((b) this.C).O(6);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).u(false);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).w(-1L);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("onLoadHippyEnd");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) GamePAHippyFragmentV2.this.C).i()).k(i3 + "", str);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        super.onLoadHippySuccess();
        ((b) this.C).O(5);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("onLoadHippyEnd");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).u(true);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        ((b) this.C).J(HippyQQConstants.EventNames.EVENT_THEME_MODE_CHANGED, new HippyMap());
        Intent intent = new Intent("action_qgame_theme_change");
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
    public void uh(long j3) {
        super.uh(j3);
        ((b) this.C).O(3);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("onHippyFirstScreen");
        QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on HippyFirstScreen");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).v(j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
    public void xh(long j3) {
        super.xh(j3);
        ((b) this.C).O(4);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).a("onHippShow");
        QLog.d("QQGamePub_GamePAHippyFragmentV2", 1, "--->on hippy show");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) this.C).i()).w(j3);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((b) GamePAHippyFragmentV2.this.C).i()).k("0", "");
            }
        });
    }
}
