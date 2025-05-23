package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.app.Dialog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$timeOutRunnable$1", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "d", "Lmqq/util/WeakReference;", "getJsCallback", "()Lmqq/util/WeakReference;", "a", "(Lmqq/util/WeakReference;)V", "jsCallback", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ShareAppMessageMethod$timeOutRunnable$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c> jsCallback;
    final /* synthetic */ ShareAppMessageMethod this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareAppMessageMethod$timeOutRunnable$1(ShareAppMessageMethod shareAppMessageMethod) {
        this.this$0 = shareAppMessageMethod;
    }

    public final void a(@Nullable WeakReference<com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c> weakReference) {
        this.jsCallback = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Dialog dialog;
        com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback;
        bVar = this.this$0.checkJob;
        if (bVar != null) {
            ShareAppMessageMethod shareAppMessageMethod = this.this$0;
            Job f16 = bVar.f();
            if (f16 != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            WeakReference<com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c> weakReference = this.jsCallback;
            if (weakReference != null && (callback = weakReference.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                ShareAppMessageMethod.r(shareAppMessageMethod, callback, 0, 0, 6, null);
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[ShareAppMessageMethod] timeout");
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("ShareAppMessageMethod", 1, (String) it.next(), null);
            }
        }
        dialog = this.this$0.progressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.jsCallback = null;
    }
}
