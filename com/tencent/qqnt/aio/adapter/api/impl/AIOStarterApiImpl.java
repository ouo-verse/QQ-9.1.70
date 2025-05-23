package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J:\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016JB\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOStarterApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOStarterApi;", "Landroid/content/Context;", "context", "", "chatType", "", "uid", "nick", "", "uin", "Landroid/os/Bundle;", "data", "", "navigateToAIO", "navigateToAIOActivity", "activityFlag", "navigateToScaleAIO", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOStarterApiImpl implements IAIOStarterApi {
    private static final String TAG = "AIOStarterApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIO(Context context, int chatType, String uid, String nick, long uin, Bundle data) {
        boolean startsWith$default;
        Intent w3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        BaseAIOUtils.d(uid);
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(nick, "u_", false, 2, null);
        if (startsWith$default) {
            QLog.i(TAG, 1, "[navigateToAIO]: " + Log.getStackTraceString(new Throwable()));
        }
        boolean z16 = context instanceof SplashActivity;
        if (z16) {
            w3 = new Intent().setClassName(context, SplashActivity.getAliasName());
        } else {
            w3 = com.tencent.mobileqq.activity.aio.l.w(context, SplashActivity.getAliasName());
        }
        w3.putExtra("key_peerId", uid);
        w3.putExtra("key_chat_type", chatType);
        w3.putExtra("key_chat_name", nick);
        w3.putExtra("key_peerUin", uin);
        w3.putExtra("key_from_splash_activity", true);
        w3.putExtra("open_chatfragment_withanim", true);
        if (data != null) {
            w3.putExtras(data);
        }
        if (z16) {
            w3.putExtra("isFromMainTab", true);
            w3.putExtra("isBack2Root", true);
            SplashActivity splashActivity = (SplashActivity) context;
            splashActivity.setIntent(w3);
            if (QLog.isColorLevel()) {
                QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
            }
            splashActivity.openAIO(false, 1);
            return;
        }
        boolean z17 = data != null ? data.getBoolean("key_open_normal_aio_addnewtask") : false;
        BaseAIOUtils.m(w3, new int[]{1});
        if (z17 || !(context instanceof Activity)) {
            w3.addFlags(268435456);
        }
        context.startActivity(w3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIOActivity(Context context, int chatType, String uid, String nick, long uin, Bundle data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        navigateToAIOActivity(context, chatType, uid, nick, 268435456, uin, data);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToScaleAIO(Context context, int chatType, String uid, String nick, Bundle data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        BaseAIOUtils.d(uid);
        Bundle bundle = new Bundle();
        if (data != null) {
            bundle.putAll(data);
        }
        bundle.putString("key_peerId", uid);
        bundle.putInt("key_chat_type", chatType);
        bundle.putString("key_chat_name", nick);
        bundle.putBoolean("key_is_scale_chat", true);
        bundle.putBoolean("key_square_aio_start_activity_for_result", true);
        com.tencent.mobileqq.activity.aio.l.a0(context, null, 0, null, bundle, 0, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIOActivity(Context context, int chatType, String uid, String nick, int activityFlag, long uin, Bundle data) {
        ActivityURIRequest y16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        BaseAIOUtils.d(uid);
        if (data != null ? data.getBoolean("key_ignore_pre_scale_chat", false) : false) {
            y16 = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        } else {
            y16 = com.tencent.mobileqq.activity.aio.l.y(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        }
        y16.extra().putString("key_chat_name", nick);
        y16.extra().putString("key_peerId", uid);
        y16.extra().putInt("key_chat_type", chatType);
        y16.extra().putLong("key_peerUin", uin);
        if (data != null) {
            y16.extra().putAll(data);
        }
        if (activityFlag == 67108864) {
            y16.setFlags(536870912 | activityFlag);
        } else {
            y16.setFlags(activityFlag);
        }
        y16.setFlags(activityFlag);
        QRoute.startUri(y16, (com.tencent.mobileqq.qroute.route.o) null);
    }
}
