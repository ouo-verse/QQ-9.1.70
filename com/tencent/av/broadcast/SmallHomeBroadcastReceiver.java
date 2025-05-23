package com.tencent.av.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\t\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/av/broadcast/SmallHomeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/av/broadcast/SmallHomeBroadcastReceiver$b;", "a", "Lcom/tencent/av/broadcast/SmallHomeBroadcastReceiver$b;", "mEnterCallback", "callback", "<init>", "(Lcom/tencent/av/broadcast/SmallHomeBroadcastReceiver$b;)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class SmallHomeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mEnterCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/av/broadcast/SmallHomeBroadcastReceiver$b;", "", "", "result", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean result);
    }

    public SmallHomeBroadcastReceiver(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mEnterCallback = callback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str != null && Intrinsics.areEqual(str, "tencent.video.q2v.ACTION_ENTER_SMALL_HOME")) {
            boolean booleanExtra = intent.getBooleanExtra("enter_result", false);
            if (QLog.isColorLevel()) {
                QLog.i("SmallHomeBroadcastReceiver", 2, "receive ACTION_ENTER_SMALL_HOME result " + booleanExtra);
            }
            this.mEnterCallback.a(booleanExtra);
        }
    }
}
