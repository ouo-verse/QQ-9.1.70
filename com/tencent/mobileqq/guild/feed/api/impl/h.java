package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/h;", "", "Landroid/content/DialogInterface$OnClickListener;", "g", "", "traceId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "e", "", "j", "i", "a", "Ljava/lang/String;", "logTag", "", "b", "Z", "d", "()Z", "setHasShowDialog", "(Z)V", "hasShowDialog", "Landroid/content/DialogInterface;", "c", "Landroid/content/DialogInterface;", "dialog", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag = "GuildBackToThirdAppHelper";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface dialog;

    private final DialogInterface.OnClickListener e(final String traceId, final Activity activity, final Bundle bundle) {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.api.impl.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.f(h.this, traceId, bundle, activity, dialogInterface, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, String traceId, Bundle bundle, Activity activity, DialogInterface dialogInterface, int i3) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(traceId, "$traceId");
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.logTag, 2, "[backToThirdApp](" + traceId + "): on click");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
            if (pendingIntent != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(this$0.logTag, 2, "[backToThirdApp](" + traceId + "): send callback using pendingIntent");
                }
                try {
                    pendingIntent.send();
                    bundle.remove(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                } catch (PendingIntent.CanceledException e16) {
                    QLog.e(this$0.logTag, 2, "[backToThirdApp](" + traceId + "): failed send pendingIntent", e16);
                }
            }
            m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(activity.moveTaskToBack(true)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(this$0.logTag, 1, "[backToThirdApp](" + traceId + "): exception happens: ", m479exceptionOrNullimpl);
        }
    }

    private final DialogInterface.OnClickListener g() {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.api.impl.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.h(h.this, dialogInterface, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.logTag, 2, "[stayQQ]: on click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(h this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialog = null;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasShowDialog() {
        return this.hasShowDialog;
    }

    public final void i() {
        DialogInterface dialogInterface = this.dialog;
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.dialog = null;
    }

    public final void j(@NotNull String traceId, @NotNull Activity activity, @NotNull Bundle bundle) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (activity.isFinishing()) {
            return;
        }
        this.hasShowDialog = true;
        String string = activity.getString(R.string.f156691kw);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026guild_share_info_succeed)");
        String string2 = activity.getString(R.string.zmk);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str\u2026_tencent_open_stay_in_QQ)");
        StringBuilder sb5 = new StringBuilder(activity.getString(R.string.button_back));
        String string3 = bundle.getString("app_name");
        if (string3 != null) {
            sb5.append(string3);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 232, (String) null, string, sb5.toString(), string2, g(), e(traceId, activity, bundle));
        createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.feed.api.impl.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                h.k(h.this, dialogInterface);
            }
        });
        try {
            Result.Companion companion = Result.INSTANCE;
            createCustomDialog.show();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(this.logTag, 1, "[showShareResultDialog](" + traceId + "): show dialog exception, ", m479exceptionOrNullimpl);
        }
    }
}
