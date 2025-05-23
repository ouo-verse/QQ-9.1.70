package com.tencent.mobileqq.emoticonview.view;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelParams;

/* loaded from: classes12.dex */
public interface IBasePanelView {
    Context getContext();

    EmoticonPanelController getController();

    EmoticonMainPanel getMainPanel();

    void onAttachedToWindow();

    void onDestory();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void onShow();

    void setViewData(EmoticonPanelParams emoticonPanelParams);
}
