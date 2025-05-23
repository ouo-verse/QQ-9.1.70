package com.tencent.mobileqq.guild.mainframe;

import android.content.Intent;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\fH&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/guild/mainframe/s;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "th", "qh", "xh", "", "tabChanged", "wh", "vh", "yh", "rh", "gg", "isSwitchAccount", "md", "uh", "ph", "intent", "sh", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class AbsGuildMainFragment extends ReportAndroidXFragment implements s {
    public abstract void gg();

    public abstract void md(boolean isSwitchAccount);

    public abstract boolean ph();

    public abstract void qh();

    public abstract void rh();

    public void sh(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    public abstract void th(int requestCode, int resultCode, @Nullable Intent data);

    public abstract boolean uh();

    public abstract void vh(boolean tabChanged);

    public abstract void wh(boolean tabChanged);

    public abstract void xh();

    public abstract void yh();
}
