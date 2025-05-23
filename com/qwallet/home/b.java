package com.qwallet.home;

import android.app.Dialog;
import android.content.Context;
import com.qwallet.home.NativePopViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/qwallet/home/b;", "Landroid/app/Dialog;", "Lcom/qwallet/home/NativePopViewModel$b;", "popInfo", "Lcom/qwallet/home/b$b;", "listener", "P", "", "show", "dismiss", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qwallet/home/NativePopViewModel$b;", "O", "()Lcom/qwallet/home/NativePopViewModel$b;", "setMPopInfo", "(Lcom/qwallet/home/NativePopViewModel$b;)V", "mPopInfo", "D", "Lcom/qwallet/home/b$b;", "N", "()Lcom/qwallet/home/b$b;", "setMListener", "(Lcom/qwallet/home/b$b;)V", "mListener", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "E", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public class b extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private NativePopViewModel.PopInfo mPopInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private InterfaceC0306b mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/qwallet/home/b$b;", "", "", NodeProps.ON_CLICK, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.home.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0306b {
        void a(@NotNull String closeType);

        void onClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: N, reason: from getter */
    public final InterfaceC0306b getMListener() {
        return this.mListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: O, reason: from getter */
    public final NativePopViewModel.PopInfo getMPopInfo() {
        return this.mPopInfo;
    }

    @NotNull
    public final Dialog P(@NotNull NativePopViewModel.PopInfo popInfo, @NotNull InterfaceC0306b listener) {
        Intrinsics.checkNotNullParameter(popInfo, "popInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPopInfo = popInfo;
        this.mListener = listener;
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th5) {
            QLog.e("HomeBasePopDialog", 1, "dismiss", th5);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Throwable th5) {
            QLog.e("HomeBasePopDialog", 1, "show", th5);
        }
    }
}
