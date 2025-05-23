package com.huawei.hms.hwid;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.GetChannelResult;
import com.huawei.hms.support.api.client.Status;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i extends TaskApiCall<c, AccountIcon> {

    /* renamed from: a, reason: collision with root package name */
    private Context f37322a;

    public i(String str, String str2, String str3, Context context) {
        super(str, str2, str3);
        this.f37322a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(c cVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<AccountIcon> taskCompletionSource) {
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "ResponseErrorCode.status:" + responseErrorCode.getErrorCode(), true);
        AccountIcon accountIcon = new AccountIcon();
        if (!TextUtils.isEmpty(str)) {
            if ("{}".equals(str)) {
                as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, body is null", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
            try {
                GetChannelResult fromJson = new GetChannelResult().fromJson(str);
                if (fromJson.isSuccess()) {
                    as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel success", true);
                    accountIcon.setDescription(fromJson.getDescription());
                    accountIcon.setIcon(a(fromJson.getIcon()));
                    taskCompletionSource.setResult(accountIcon);
                    long a16 = ao.a();
                    SharedPreferences.Editor edit = this.f37322a.getSharedPreferences("ACCOUNT_CHANNEL_CACHE", 0).edit();
                    edit.putLong("cache_time", a16);
                    edit.putString("desc", fromJson.getDescription());
                    edit.putString("icon", fromJson.getIcon());
                    edit.apply();
                } else {
                    as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel failed", true);
                    taskCompletionSource.setException(new ApiException(fromJson.getStatus()));
                }
                return;
            } catch (JSONException unused) {
                as.c("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, but parser json exception", true);
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
        }
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, response is null, failed", true);
        taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 10;
    }

    private Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e16) {
            as.d("[AccountSDK]AccountGetChannelTaskApiCall", "stringToBitmap Exception is " + e16.getClass().getSimpleName(), true);
            return null;
        } catch (OutOfMemoryError unused) {
            as.d("[AccountSDK]AccountGetChannelTaskApiCall", "out of memory error ", true);
            return null;
        }
    }
}
