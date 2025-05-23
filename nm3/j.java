package nm3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.component.callback.ITimedCallback;
import com.tencent.component.core.event.EventCenter;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel;
import com.tencent.now.linkpkanchorplay.linkscreen.model.AnchorInLinkScreenCtrlModel;
import com.tencent.now.linkpkanchorplay.linkscreen.model.AnchorInPKCtrlModel;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "Lnm3/a;", "closeLiveCallback", "", "t", "", "roomId", "p", "l", "Landroid/view/View;", "view", "k", "i", "j", "qq-live-link-pk-anchorplay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j {
    private static final void i(long j3) {
        new AnchorInPKCtrlModel(new InviteDataModel()).a(j3, new a());
    }

    private static final void j(long j3) {
        new AnchorInLinkScreenCtrlModel().a(j3, new b());
    }

    private static final void k(View view) {
        e55.a c16 = zm3.a.f452778a.c();
        if (c16 != null) {
            mm3.a.f417004a.a(view, c16.f395729a.f395735a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog] */
    public static final void l(@NotNull Context context, final long j3, @NotNull final nm3.a closeLiveCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeLiveCallback, "closeLiveCallback");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? reportDialog = new ReportDialog(context);
        objectRef.element = reportDialog;
        Window window = ((Dialog) reportDialog).getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        ((Dialog) objectRef.element).setContentView(R.layout.fck);
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.uvd)).setOnClickListener(new View.OnClickListener() { // from class: nm3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.m(j3, objectRef, view);
            }
        });
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.uvf)).setOnClickListener(new View.OnClickListener() { // from class: nm3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.n(a.this, objectRef, view);
            }
        });
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.bjv)).setOnClickListener(new View.OnClickListener() { // from class: nm3.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.o(Ref.ObjectRef.this, view);
            }
        });
        ((Dialog) objectRef.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(long j3, Ref.ObjectRef dialog, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        j(j3);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        k(it);
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(nm3.a closeLiveCallback, Ref.ObjectRef dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(closeLiveCallback, "$closeLiveCallback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        closeLiveCallback.a();
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(Ref.ObjectRef dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog] */
    public static final void p(@NotNull Context context, final long j3, @NotNull final nm3.a closeLiveCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeLiveCallback, "closeLiveCallback");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? reportDialog = new ReportDialog(context, R.style.auw);
        objectRef.element = reportDialog;
        Window window = ((Dialog) reportDialog).getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        ((Dialog) objectRef.element).setContentView(R.layout.fcl);
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.uvj)).setOnClickListener(new View.OnClickListener() { // from class: nm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.q(j3, objectRef, view);
            }
        });
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.uvf)).setOnClickListener(new View.OnClickListener() { // from class: nm3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.r(a.this, objectRef, view);
            }
        });
        ((TextView) ((Dialog) objectRef.element).findViewById(R.id.bjv)).setOnClickListener(new View.OnClickListener() { // from class: nm3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.s(Ref.ObjectRef.this, view);
            }
        });
        ((Dialog) objectRef.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(long j3, Ref.ObjectRef dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        i(j3);
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(nm3.a closeLiveCallback, Ref.ObjectRef dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(closeLiveCallback, "$closeLiveCallback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        closeLiveCallback.a();
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(Ref.ObjectRef dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        ((Dialog) dialog.element).dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void t(@NotNull Context context, @NotNull final nm3.a closeLiveCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeLiveCallback, "closeLiveCallback");
        com.tencent.qui.a.a(context, 0, "\u5f53\u524d\u6b63\u5728\u6392\u4f4d\u8d5bPK", "\u63d0\u4ea4\u7ed3\u675f\u76f4\u64ad\uff0cPK\u5c06\u7ee7\u7eed\u8fdb\u884c", "\u53d6\u6d88", "\u7ed3\u675f\u76f4\u64ad", new DialogInterface.OnClickListener() { // from class: nm3.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.u(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: nm3.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.v(a.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(nm3.a closeLiveCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(closeLiveCallback, "$closeLiveCallback");
        closeLiveCallback.a();
        dialogInterface.dismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"nm3/j$a", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/d;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements ITimedCallback<g55.d> {
        a() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable g55.d data) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenDialogHelper", "success: " + data);
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"nm3/j$b", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/b;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ITimedCallback<g55.b> {
        b() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable g55.b data) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenDialogHelper", "success: " + data);
            EventCenter.post(d.g.f338188a);
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
        }
    }
}
