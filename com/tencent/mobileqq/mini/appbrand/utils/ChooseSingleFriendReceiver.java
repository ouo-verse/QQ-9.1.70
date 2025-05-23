package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0004J\u001c\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00070\u00070\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/appbrand/utils/ChooseSingleFriendReceiver;", "Landroid/os/ResultReceiver;", "shareSimpleCallback", "Lcom/tencent/mobileqq/mini/appbrand/utils/ShareUtils$ShareSimpleCallback;", "handler", "Landroid/os/Handler;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "(Lcom/tencent/mobileqq/mini/appbrand/utils/ShareUtils$ShareSimpleCallback;Landroid/os/Handler;Landroid/app/Activity;)V", "actRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "getActRef", "()Lmqq/util/WeakReference;", "reference", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "onShareReceiverObtain", "callback", "shareReceiver", "Lcom/tencent/mobileqq/mini/appbrand/utils/ShareReceiver;", "parseShareReceiver", "safeToastResult", "success", "", "toastResult", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class ChooseSingleFriendReceiver extends ResultReceiver {
    private static final String TAG = "ChooseFriendSharePicWithTailReceiver";
    private final WeakReference<Activity> actRef;
    private final WeakReference<ShareUtils.ShareSimpleCallback> reference;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseSingleFriendReceiver(ShareUtils.ShareSimpleCallback shareSimpleCallback, Handler handler, Activity activity) {
        super(handler);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.reference = new WeakReference<>(shareSimpleCallback);
        this.actRef = new WeakReference<>(activity);
    }

    private final ShareReceiver parseShareReceiver(Bundle resultData) {
        String str;
        Long longOrNull;
        ArrayList<String> stringArrayList = resultData.getStringArrayList("choose_friend_uins");
        ArrayList<String> stringArrayList2 = resultData.getStringArrayList("choose_friend_group_uins");
        int i3 = 0;
        if (!(stringArrayList == null || stringArrayList.isEmpty())) {
            str = stringArrayList.get(0);
            i3 = 1;
        } else {
            if (!(stringArrayList2 == null || stringArrayList2.isEmpty())) {
                str = stringArrayList2.get(0);
                i3 = 2;
            } else {
                str = "0";
            }
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull == null) {
            QLog.e(ShareUtils.TAG, 1, "SharePicWithTail receiver invalid!");
            return null;
        }
        return new ShareReceiver(longOrNull.longValue(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void safeToastResult$lambda$0(ChooseSingleFriendReceiver this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toastResult(z16);
    }

    private final void toastResult(boolean success) {
        String str;
        Activity activity = this.actRef.get();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (success) {
            str = "\u5df2\u53d1\u9001";
        } else {
            str = "\u53d1\u9001\u5931\u8d25";
        }
        QQToast.makeText(activity, str, 0).show();
    }

    protected final WeakReference<Activity> getActRef() {
        return this.actRef;
    }

    @Override // android.os.ResultReceiver
    protected final void onReceiveResult(int resultCode, Bundle resultData) {
        if (resultCode == 0 && resultData != null) {
            ShareReceiver parseShareReceiver = parseShareReceiver(resultData);
            QLog.e(TAG, 2, "shareReceiver:" + parseShareReceiver);
            onShareReceiverObtain(this.reference.get(), parseShareReceiver);
            return;
        }
        QLog.e(TAG, 1, "params invalid");
        onShareReceiverObtain(this.reference.get(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void safeToastResult(final boolean success) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            toastResult(success);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChooseSingleFriendReceiver.safeToastResult$lambda$0(ChooseSingleFriendReceiver.this, success);
                }
            });
        }
    }

    public void onShareReceiverObtain(ShareUtils.ShareSimpleCallback callback, ShareReceiver shareReceiver) {
    }
}
