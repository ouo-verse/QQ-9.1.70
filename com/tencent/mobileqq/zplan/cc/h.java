package com.tencent.mobileqq.zplan.cc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B/\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001c\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/h;", "Landroid/app/Dialog;", "", "i", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "show", "dismiss", "", "d", "Z", "cancelable", "e", "canceledOnTouchOutside", "", "f", "I", "renderEngine", tl.h.F, "canceled", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "threadHandler", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "getResReadyCallback", "()Ljava/lang/Runnable;", "k", "(Ljava/lang/Runnable;)V", "resReadyCallback", "D", "getCancelCallback", "j", "cancelCallback", "E", "checkCameraResTask", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZZI)V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    private Runnable resReadyCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private Runnable cancelCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private final Runnable checkCameraResTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean cancelable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean canceledOnTouchOutside;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int renderEngine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean canceled;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Handler threadHandler;

    public /* synthetic */ h(Context context, boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? true : z16, (i16 & 4) != 0 ? false : z17, (i16 & 8) != 0 ? 1 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean d16 = com.tencent.mobileqq.zplan.cc.util.e.f332557a.d(this$0.renderEngine);
        QLog.i("ZPlanCamera", 1, "camera res check, engine = " + this$0.renderEngine + ",  result = " + d16 + ", thread:" + Thread.currentThread());
        if (d16) {
            if (this$0.isShowing()) {
                this$0.handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.f(h.this);
                    }
                });
                return;
            }
            return;
        }
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        if (this$0.canceled || (runnable = this$0.resReadyCallback) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final h this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canceled = true;
        this$0.handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.f
            @Override // java.lang.Runnable
            public final void run() {
                h.h(h.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Runnable runnable = this$0.cancelCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void i() {
        this.threadHandler.postDelayed(this.checkCameraResTask, 500L);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.threadHandler.removeCallbacks(this.checkCameraResTask);
    }

    public final void j(Runnable runnable) {
        this.cancelCallback = runnable;
    }

    public final void k(Runnable runnable) {
        this.resReadyCallback = runnable;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(this.cancelable);
        setCanceledOnTouchOutside(this.canceledOnTouchOutside);
        setContentView(R.layout.f168383uh);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.zplan.cc.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                h.g(h.this, dialogInterface);
            }
        });
        ((TextView) findViewById(R.id.photo_prievew_progress_dialog_text)).setText("\u76f8\u673a\u52a0\u8f7d\u4e2d");
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, boolean z16, boolean z17, int i3) {
        super(context, R.style.qZoneInputDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cancelable = z16;
        this.canceledOnTouchOutside = z17;
        this.renderEngine = i3;
        this.handler = new Handler(Looper.getMainLooper());
        this.threadHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.checkCameraResTask = new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.e
            @Override // java.lang.Runnable
            public final void run() {
                h.e(h.this);
            }
        };
    }
}
