package com.tencent.mobileqq.flashtransfer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/JumpActionReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "b", "NOTIFY_VALUE", "c", "CHAT_HISTORY_VALUE", "d", "FAVORITE_VALUE", "e", "JUMP_ACTIVITY", "<init>", "()V", "qqfile-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class JumpActionReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String NOTIFY_VALUE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String CHAT_HISTORY_VALUE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String FAVORITE_VALUE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String JUMP_ACTIVITY;

    public JumpActionReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "JumpActionReceiver";
        this.NOTIFY_VALUE = "com.tencent.mqq.filetransfer.jumpaction";
        this.CHAT_HISTORY_VALUE = "NTChatHistoryActivity";
        this.FAVORITE_VALUE = "FavoritesListActivity";
        this.JUMP_ACTIVITY = "JumpActivity";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        boolean equals;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null && Intrinsics.areEqual(intent.getAction(), this.NOTIFY_VALUE)) {
            String stringExtra = intent.getStringExtra("url");
            String stringExtra2 = intent.getStringExtra("source");
            int i3 = 2;
            if (!Intrinsics.areEqual(this.CHAT_HISTORY_VALUE, stringExtra2)) {
                if (!TextUtils.isEmpty(stringExtra2) && stringExtra2 != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) stringExtra2, (CharSequence) this.FAVORITE_VALUE, false, 2, (Object) null);
                    if (contains$default) {
                        i3 = 12;
                    }
                }
                equals = StringsKt__StringsJVMKt.equals(this.JUMP_ACTIVITY, stringExtra2, true);
                if (equals) {
                    i3 = 9;
                } else {
                    i3 = 0;
                }
            }
            QLog.d(this.TAG, 1, "JumpActionReceiver source " + stringExtra2);
            if (stringExtra != null) {
                ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).interceptFlashTransferUrl(context, stringExtra, i3, 3);
            }
        }
    }
}
