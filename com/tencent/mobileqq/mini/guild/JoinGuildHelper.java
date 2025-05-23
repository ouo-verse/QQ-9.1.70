package com.tencent.mobileqq.mini.guild;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class JoinGuildHelper {
    private static final String BUNDLE_KEY_GUILD_ID = "guild_id";
    private static final String BUNDLE_KEY_RESULT_URL = "result_url";
    public static final String INTENT_KEY_JUMP_FROM_MINI_APP = "jump_from_mini_app";
    public static final String INTENT_KEY_JUMP_GUILD_REQUEST = "jump_guild_request_id";
    public static final String INTENT_KEY_MINI_APP_ID = "mini_app_id";
    public static final int JUMP_GUILD_REQUEST_ID = 100000;
    private static final String TAG = "JoinGuildHelper";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface ResultCallback {
        void onResult(boolean z16, String str);
    }

    private void jumpToShareUrl(final Context context, final String str, final ResultCallback resultCallback, final String str2) {
        QLog.d(TAG, 1, "jumpToShareUrl:" + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.mini.guild.a
            @Override // java.lang.Runnable
            public final void run() {
                JoinGuildHelper.lambda$jumpToShareUrl$1(str, str2, context, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$joinGuild$0(ResultCallback resultCallback, Context context, String str, boolean z16, Bundle bundle) {
        QLog.i(TAG, 2, "getGuildJoinSign success:" + z16);
        if (!z16) {
            if (resultCallback != null) {
                resultCallback.onResult(false, "get sign request failed");
                return;
            }
            return;
        }
        String string = bundle.getString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
        if (context == null) {
            resultCallback.onResult(false, "context is null, can't start activity");
        } else if (TextUtils.isEmpty(string)) {
            resultCallback.onResult(false, "get url failed");
        } else {
            jumpToShareUrl(context, getShareUrl(string), resultCallback, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$jumpToShareUrl$1(String str, String str2, Context context, ResultCallback resultCallback) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra(INTENT_KEY_JUMP_FROM_MINI_APP, true);
        intent.putExtra("mini_app_id", str2);
        intent.putExtra(INTENT_KEY_JUMP_GUILD_REQUEST, 100000);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, JumpGuildTransferFragment.class);
        resultCallback.onResult(true, "");
    }

    public void joinGuild(final String str, String str2, final ResultCallback resultCallback, final Context context) {
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("joinGuild but guild id is null or empty:");
            sb5.append(str2 == null);
            QLog.e(TAG, 2, sb5.toString());
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("joinGuild start:");
        sb6.append(str2);
        sb6.append(",callback:");
        sb6.append(resultCallback == null);
        QLog.i(TAG, 2, sb6.toString());
        MiniAppCmdUtil.getInstance().getGuildJoinUrl(str2, new MiniAppCmdUtil.BunddleListener() { // from class: com.tencent.mobileqq.mini.guild.b
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.BunddleListener
            public final void onResult(boolean z16, Bundle bundle) {
                JoinGuildHelper.this.lambda$joinGuild$0(resultCallback, context, str, z16, bundle);
            }
        });
    }

    private String getShareUrl(String str) {
        return URLUtil.addParameter(URLUtil.addParameter(str, "from", String.valueOf(246622)), "biz", "ka");
    }
}
