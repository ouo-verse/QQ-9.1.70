package com.tenpay.sdk.fakeurl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.fakeurl.FakeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonListener", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$OnClickButtonListener;", "getContext", "()Landroid/content/Context;", "fakeInfo", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "msgSchemaAction", "Lkotlin/Function1;", "", "", "build", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "setData", "data", "setMsgSchemaAction", "action", "setOnButtonClickListener", "listener", "BtnIndex", "Companion", "OnClickButtonListener", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FakeUrlDialogBuilder {

    @NotNull
    public static final String TAG = "QWalletHttp.FakeUrlDialog";

    @Nullable
    private OnClickButtonListener buttonListener;

    @Nullable
    private final Context context;

    @Nullable
    private FakeInfo fakeInfo;

    @Nullable
    private Function1<? super String, Unit> msgSchemaAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$BtnIndex;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum BtnIndex {
        LEFT,
        RIGHT
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$OnClickButtonListener;", "", "onClickButton", "", "fakeInfo", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "index", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$BtnIndex;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface OnClickButtonListener {
        boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull BtnIndex index, @Nullable Uri uri);
    }

    public FakeUrlDialogBuilder(@Nullable Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void build$lambda$3$lambda$2$lambda$0(FakeUrlDialogBuilder this$0, FakeInfo data, DialogInterface dialogInterface, int i3) {
        Uri uri;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        OnClickButtonListener onClickButtonListener = this$0.buttonListener;
        boolean z16 = false;
        if (onClickButtonListener != null) {
            BtnIndex btnIndex = BtnIndex.LEFT;
            FakeInfo.FakeButton leftData = data.getLeftData();
            if (leftData != null) {
                uri = leftData.getUri();
            } else {
                uri = null;
            }
            if (onClickButtonListener.onClickButton(data, btnIndex, uri)) {
                z16 = true;
            }
        }
        if (!z16) {
            QLog.w(TAG, 1, "FakeUrlDialog onClick LEFT: Ignored");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void build$lambda$3$lambda$2$lambda$1(FakeUrlDialogBuilder this$0, FakeInfo data, DialogInterface dialogInterface, int i3) {
        Uri uri;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        OnClickButtonListener onClickButtonListener = this$0.buttonListener;
        boolean z16 = false;
        if (onClickButtonListener != null) {
            BtnIndex btnIndex = BtnIndex.RIGHT;
            FakeInfo.FakeButton rightData = data.getRightData();
            if (rightData != null) {
                uri = rightData.getUri();
            } else {
                uri = null;
            }
            if (onClickButtonListener.onClickButton(data, btnIndex, uri)) {
                z16 = true;
            }
        }
        if (!z16) {
            QLog.w(TAG, 1, "FakeUrlDialog onClick RIGHT: Ignored");
        }
    }

    @Nullable
    public final QQCustomDialog build() {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        String str3;
        Context context = this.context;
        boolean z18 = true;
        String str4 = null;
        if (context != null && (!(context instanceof Activity) || (!((Activity) context).isFinishing() && !((Activity) this.context).isDestroyed()))) {
            final FakeInfo fakeInfo = this.fakeInfo;
            if (fakeInfo != null) {
                QQCustomDialog qQCustomDialog = new QQCustomDialog(this.context, R.style.qZoneInputDialog);
                qQCustomDialog.setContentView(R.layout.f167856jn);
                String title = fakeInfo.getTitle();
                if (title != null && title.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    qQCustomDialog.setTitle((String) null);
                } else {
                    qQCustomDialog.setTitle(fakeInfo.getTitle());
                }
                qQCustomDialog.setMessageWithoutAutoLink(FakeSchemaParser.INSTANCE.toSpannable(fakeInfo.getRetMsg(), this.msgSchemaAction));
                qQCustomDialog.setCancelable(false);
                qQCustomDialog.setCanceledOnTouchOutside(false);
                FakeInfo.FakeButton leftData = fakeInfo.getLeftData();
                if (leftData != null) {
                    str = leftData.getText();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    FakeInfo.FakeButton leftData2 = fakeInfo.getLeftData();
                    if (leftData2 != null) {
                        str3 = leftData2.getText();
                    } else {
                        str3 = null;
                    }
                    qQCustomDialog.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.fakeurl.a
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            FakeUrlDialogBuilder.build$lambda$3$lambda$2$lambda$0(FakeUrlDialogBuilder.this, fakeInfo, dialogInterface, i3);
                        }
                    });
                }
                FakeInfo.FakeButton rightData = fakeInfo.getRightData();
                if (rightData != null) {
                    str2 = rightData.getText();
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    FakeInfo.FakeButton rightData2 = fakeInfo.getRightData();
                    if (rightData2 != null) {
                        str4 = rightData2.getText();
                    }
                    qQCustomDialog.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.fakeurl.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            FakeUrlDialogBuilder.build$lambda$3$lambda$2$lambda$1(FakeUrlDialogBuilder.this, fakeInfo, dialogInterface, i3);
                        }
                    });
                }
                return qQCustomDialog;
            }
            QLog.w(TAG, 1, "show FakeUrlDialog fail, fakeInfo is null");
            return null;
        }
        QLog.w(TAG, 1, "show FakeUrlDialog fail, activity is destroyed: " + this.context);
        return null;
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    public final void setData(@NotNull FakeInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.fakeInfo = data;
    }

    public final void setMsgSchemaAction(@NotNull Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.msgSchemaAction = action;
    }

    public final void setOnButtonClickListener(@NotNull OnClickButtonListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.buttonListener = listener;
    }
}
