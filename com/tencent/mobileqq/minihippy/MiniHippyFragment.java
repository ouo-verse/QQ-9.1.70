package com.tencent.mobileqq.minihippy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.minigame.ui.controller.MiniHippyController;
import com.tencent.mobileqq.minihippy.MiniHippyFragment;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniHippyFragment extends CommonHippyFragment {
    private MiniHippyController C;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wh(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniHippyUI", 2, "[onRootViewClick]");
        }
    }

    private void xh() {
        MiniHippyController miniHippyController;
        boolean z16 = false;
        if (getArguments() != null && getArguments().getBoolean("minihippy_root", false)) {
            z16 = true;
        }
        if (!z16 || (miniHippyController = this.C) == null) {
            return;
        }
        miniHippyController.onHippyLoadFinish();
    }

    public void Ah(String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("newScheme", str);
        sendHippyNativeEvent("EventSetScheme", hippyMap);
        if (QLog.isColorLevel()) {
            QLog.i("MiniHippyUI", 2, "setPageUrl: from onNewIntent url=" + str);
        }
    }

    public void Bh(String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("paramUrl", str);
        sendHippyNativeEvent("pageParamUrlUpdate", hippyMap);
        if (QLog.isColorLevel()) {
            QLog.i("MiniHippyUI", 2, "urlUpdate: from onNewIntent url=" + str);
        }
    }

    public String getAppId() {
        MiniHippyController miniHippyController = this.C;
        if (miniHippyController != null) {
            return miniHippyController.getAppId();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment
    public void initProgressBar(ViewGroup viewGroup) {
        boolean z16 = false;
        if (getArguments() != null && getArguments().getBoolean("minihippy_root", false)) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        super.initProgressBar(viewGroup);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("MiniHippyUI", 1, "onCreate");
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        vh(onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(int i3, String str) {
        super.onLoadHippyError(i3, str);
        QLog.e("MiniHippyUI", 1, "onLoadHippyError: statusCode=" + i3 + ";msg=" + str);
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        super.onLoadHippySuccess();
        QLog.d("MiniHippyUI", 1, "onLoadHippySuccess");
        xh();
    }

    public void yh(MiniHippyController miniHippyController) {
        this.C = miniHippyController;
    }

    public void zh(String str) {
        sendHippyNativeEvent("EventSetQuery", str);
        if (QLog.isColorLevel()) {
            QLog.i("MiniHippyUI", 2, "setQuery: from onNewIntent query=" + str);
        }
    }

    private static void vh(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: d92.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniHippyFragment.wh(view2);
            }
        });
    }
}
