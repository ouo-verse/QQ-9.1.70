package com.tencent.mobileqq.ptt.temp.api;

import a61.b;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IVoice2TxtTmpApi extends QRouteApi {
    int getAudioPanelContainerEditStateDeltaHeight(b bVar);

    int getCustomTitleViewBottom(b bVar);

    PopupWindow getTopMask();

    int getWaveViewLen(Context context, int i3, float f16, int i16, int i17, boolean z16, boolean z17);

    void hideChatPieOtherFunction(b bVar);

    void hideSoftInput(b bVar);

    void restoreChatPieOtherFunction(b bVar);

    void sendTxt(b bVar, AppRuntime appRuntime, p pVar, String str, Context context);

    void sendVoiceAndTxt(b bVar, String str, int i3, int i16, RecordParams.RecorderParam recorderParam, int i17, boolean z16, int i18);

    void setCustomTitleVisiable(b bVar, int i3);

    void setIsInVoiceTxt(boolean z16);

    PopupWindow showTopMaskPanel(Context context, int i3, int i16, View view, int i17, int i18, int i19);
}
