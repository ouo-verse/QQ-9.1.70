package com.tencent.qqnt.aio.adapter.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.adapter.api.IDialogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/widget/c;", "Landroid/app/Dialog;", "", "text", "", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "title", "setTitle", "content", "U", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "getListener", "()Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "W", "(Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IDialogApi.a listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        setContentView(R.layout.e5x);
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.P(c.this, view);
            }
        });
        findViewById(R.id.b7m).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.Q(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        IDialogApi.a aVar = this$0.listener;
        if (aVar != null) {
            aVar.onCancel();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        IDialogApi.a aVar = this$0.listener;
        if (aVar != null) {
            aVar.onConfirm();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void R(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            ((TextView) findViewById(R.id.cancel)).setText(text);
        }
    }

    public final void S(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            ((TextView) findViewById(R.id.b7m)).setText(text);
        }
    }

    public final void U(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) content);
        } else {
            Intrinsics.checkNotNullParameter(content, "content");
            ((TextView) findViewById(R.id.content)).setText(content);
        }
    }

    public final void W(@Nullable IDialogApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.listener = aVar;
        }
    }

    public final void setTitle(@NotNull String title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) title);
        } else {
            Intrinsics.checkNotNullParameter(title, "title");
            ((TextView) findViewById(R.id.title)).setText(title);
        }
    }
}
