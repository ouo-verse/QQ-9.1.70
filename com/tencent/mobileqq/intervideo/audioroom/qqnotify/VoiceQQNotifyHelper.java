package com.tencent.mobileqq.intervideo.audioroom.qqnotify;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VoiceQQNotifyHelper {
    public static void querySubscribe(String str, String str2, String str3, IVoiceQQNotifyListener iVoiceQQNotifyListener) {
        ae.k(str, str2, str3, iVoiceQQNotifyListener);
    }

    public static void showSubscribeDialog(Context context, String str, String str2, String str3, int i3) {
        Activity actFromShadowContext = QQVoiceUtil.getActFromShadowContext(context);
        if (actFromShadowContext == null) {
            QLog.w("VoiceQQNotifyHelper", 1, "context is invalid, " + context.getClass().getName());
            return;
        }
        ae.p(actFromShadowContext, str, str2, str3, i3);
    }

    public static void subscribeDirectly(String str, String str2, String str3, ae.c cVar) {
        ae.s(str, str2, str3, cVar);
    }
}
