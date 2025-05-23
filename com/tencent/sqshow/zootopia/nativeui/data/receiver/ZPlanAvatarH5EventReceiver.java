package com.tencent.sqshow.zootopia.nativeui.data.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u94.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/receiver/ZPlanAvatarH5EventReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarH5EventReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String stringExtra;
        String str2 = "";
        if (intent == null || (str = intent.getStringExtra("event")) == null) {
            str = "";
        }
        if (intent != null && (stringExtra = intent.getStringExtra("data")) != null) {
            str2 = stringExtra;
        }
        QLog.i("ZPlanAvatarH5EventReceiver", 1, "onReceive event:" + str + ", data.length:" + str2.length());
        if (Intrinsics.areEqual(str, "ZPlanH5StoreBuySucceed")) {
            a.f438601a.a(str2);
        }
    }
}
