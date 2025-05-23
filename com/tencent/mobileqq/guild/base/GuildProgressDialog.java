package com.tencent.mobileqq.guild.base;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;", "", "", "message", "", "delay", "", "e", "c", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "J", "delayInMills", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog$ShowRunnable;", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog$ShowRunnable;", "showDialogRunnable", "<init>", "(Landroid/app/Activity;J)V", "ShowRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildProgressDialog {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long delayInMills;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy progressDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShowRunnable showDialogRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/base/GuildProgressDialog$ShowRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;)V", TencentLocation.RUN_MODE, "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class ShowRunnable implements Runnable {
        public ShowRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!GuildProgressDialog.this.activity.isFinishing()) {
                GuildProgressDialog.this.d().show();
            }
        }
    }

    public GuildProgressDialog(@NotNull Activity activity, long j3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.delayInMills = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.guild.base.GuildProgressDialog$progressDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                return new QQProgressDialog(GuildProgressDialog.this.activity);
            }
        });
        this.progressDialog = lazy;
        this.showDialogRunnable = new ShowRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQProgressDialog d() {
        return (QQProgressDialog) this.progressDialog.getValue();
    }

    public static /* synthetic */ void f(GuildProgressDialog guildProgressDialog, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            j3 = guildProgressDialog.delayInMills;
        }
        guildProgressDialog.e(str, j3);
    }

    @MainThread
    public final void c() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showDialogRunnable);
        d().dismiss();
    }

    @JvmOverloads
    @MainThread
    public final void e(@NotNull String message, long delay) {
        Intrinsics.checkNotNullParameter(message, "message");
        d().setMessage(message);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showDialogRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.showDialogRunnable, delay);
    }

    public /* synthetic */ GuildProgressDialog(Activity activity, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i3 & 2) != 0 ? 700L : j3);
    }
}
