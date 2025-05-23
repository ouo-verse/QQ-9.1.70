package com.tencent.mobileqq.activity.aio.voicetextpanel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IVoice2TxtApi extends QRouteApi {
    BaseVoicetoTextView getVoice2TxtView(Context context);
}
