package com.tencent.mobileqq.onlinestatus.tempapi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IEmojiPanelApi extends QRouteApi {
    View findAndInitEmojiPanel(@NonNull AppRuntime appRuntime, @NonNull Activity activity, @NonNull View view, int i3, @NonNull EditText editText);
}
