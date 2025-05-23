package com.tencent.qqnt.aio.adapter.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/widget/g;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "name", "", "W", "Lcom/tencent/qqnt/aio/adapter/widget/g$a;", "listener", "U", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRoot", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mNickname", "E", "mCancleBtn", UserInfo.SEX_FEMALE, "mConfirmBtn", "G", "Lcom/tencent/qqnt/aio/adapter/widget/g$a;", "mConfirmListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g extends QQCustomDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View mRoot;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView mNickname;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View mCancleBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View mConfirmBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private a mConfirmListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/widget/g$a;", "", "", "onConfirm", "onCancel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.e9d, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026firm_dialog_layout, null)");
        this.mRoot = inflate;
        View findViewById = inflate.findViewById(R.id.nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRoot.findViewById(R.id.nickname)");
        this.mNickname = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.dialogLeftBtn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRoot.findViewById(R.id.dialogLeftBtn)");
        this.mCancleBtn = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.Q(g.this, view);
            }
        });
        View findViewById3 = inflate.findViewById(R.id.dialogRightBtn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRoot.findViewById(R.id.dialogRightBtn)");
        this.mConfirmBtn = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.R(g.this, view);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqnt.aio.adapter.widget.f
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                g.S(g.this, dialogInterface);
            }
        });
        setContentView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mConfirmListener;
        if (aVar != null) {
            aVar.onConfirm();
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(g this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mConfirmListener;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    public final void U(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mConfirmListener = listener;
        }
    }

    public final void W(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
        } else {
            Intrinsics.checkNotNullParameter(name, "name");
            this.mNickname.setText(name);
        }
    }
}
