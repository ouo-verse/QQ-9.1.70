package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ISystemAndEmojiSenderService extends QRouteApi {
    void send(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable);
}
