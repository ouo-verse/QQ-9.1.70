package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.ui.MainProcessLoadingFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0011H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/WeiXinMiniServiceAPIImpl;", "Lcom/tencent/mobileqq/mini/api/IWeiXinMiniServiceAPI;", "()V", "tryTime", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTryTime", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkSession", "", "appId", "callback", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "getAuthCode", "getUserInfo", "hasGrantPermission", "", "lang", "openConnectAuthorize", "data", "Lorg/json/JSONObject;", "triggerPullDownAnim", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class WeiXinMiniServiceAPIImpl implements IWeiXinMiniServiceAPI {
    public static final int MAX_TRY_TIME = 10;
    private final ConcurrentHashMap<String, Integer> tryTime = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void triggerPullDownAnim$lambda$1(WeiXinMiniServiceAPIImpl this$0, String appId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        this$0.triggerPullDownAnim(appId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void triggerPullDownAnim$lambda$2(WeiXinMiniServiceAPIImpl this$0, String appId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        this$0.triggerPullDownAnim(appId, false);
    }

    @Override // com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI
    public void checkSession(String appId, MiniAppCmdInterface callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniAppCmdUtil.getInstance().checkSession(appId, callback);
    }

    @Override // com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI
    public void getAuthCode(String appId, MiniAppCmdInterface callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniAppCmdUtil.getInstance().getLoginCode(appId, callback);
    }

    public final ConcurrentHashMap<String, Integer> getTryTime() {
        return this.tryTime;
    }

    @Override // com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI
    public void getUserInfo(String appId, boolean hasGrantPermission, String lang, MiniAppCmdInterface callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniAppCmdUtil.getInstance().getUserInfo(appId, hasGrantPermission, lang, callback);
    }

    @Override // com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI
    public void openConnectAuthorize(String appId, JSONObject data, MiniAppCmdInterface callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MainProcessLoadingFragment.INSTANCE.setCallback(callback);
        Intent intent = new Intent();
        intent.putExtra("data", data.toString());
        if (Foreground.getTopActivity() == null) {
            QLog.i("AIOMsgItem", 1, "openConnectAuthorize failed, because act is null");
            callback.onCmdListener(false, new JSONObject());
        } else {
            QPublicFragmentActivity.b.b(Foreground.getTopActivity(), intent, QPublicTransFragmentActivityForMultiProcess.class, MainProcessLoadingFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI
    public void triggerPullDownAnim(final String appId, boolean force) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (this.tryTime.get(appId) != null && !force) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.tryTime;
            Integer num = concurrentHashMap.get(appId);
            Intrinsics.checkNotNull(num);
            concurrentHashMap.put(appId, Integer.valueOf(num.intValue() + 1));
        } else {
            this.tryTime.put(appId, 1);
        }
        Integer num2 = this.tryTime.get(appId);
        Intrinsics.checkNotNull(num2);
        if (num2.intValue() > 10) {
            QLog.i("AIOMsgItem", 1, "triggerPullDownAnim time limit");
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity instanceof SplashActivity) {
            if (topActivity.hasWindowFocus()) {
                Bundle bundle = new Bundle();
                bundle.putString("appID", appId);
                Unit unit = Unit.INSTANCE;
                MiniAppUtils.updateMiniAppList(105, bundle);
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.u
                @Override // java.lang.Runnable
                public final void run() {
                    WeiXinMiniServiceAPIImpl.triggerPullDownAnim$lambda$1(WeiXinMiniServiceAPIImpl.this, appId);
                }
            }, 100L);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.v
            @Override // java.lang.Runnable
            public final void run() {
                WeiXinMiniServiceAPIImpl.triggerPullDownAnim$lambda$2(WeiXinMiniServiceAPIImpl.this, appId);
            }
        }, 100L);
    }
}
