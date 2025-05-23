package com.tencent.mobileqq.qqlive.room.gamedownloader.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0002R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeBtn;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "", "tips", "", "y", "", "progress", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "color", "Landroid/graphics/drawable/Drawable;", "p", "Landroid/graphics/drawable/ClipDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "hostActivity", "Lcr4/b;", "gameInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d", "onDownloadStart", "a", "onDownloadPause", "onDownloadFinish", "", "fromQQLive", "c", "errorCode", "e", "b", "customDistributeListener", "setListener", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController;", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController;", "controller", "f", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "stateListener", "Landroid/widget/ProgressBar;", tl.h.F, "Landroid/widget/ProgressBar;", "qqliveCustomDistributeProgress", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "qqliveCustomDistributeTips", "I", DomainData.DOMAIN_NAME, "()I", "setLastProgress", "(I)V", "lastProgress", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/State;", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/State;", "o", "()Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/State;", "setLastState", "(Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/State;)V", "lastState", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCustomDistributeBtn extends FrameLayout implements QQLiveCustomDistributeController.b {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private State lastState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQLiveCustomDistributeController controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveCustomDistributeController.b stateListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProgressBar qqliveCustomDistributeProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView qqliveCustomDistributeTips;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastProgress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeBtn$a;", "", "", "CLICK_GAP", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeBtn$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveCustomDistributeBtn(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) ctx);
    }

    private final ClipDrawable m(int color) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f}, null, null));
        shapeDrawable.getPaint().setColor(color);
        return new ClipDrawable(shapeDrawable, 8388611, 1);
    }

    private final Drawable p(int color) {
        return new LayerDrawable(new ClipDrawable[]{m(color)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y("\u70b9\u51fb\u7ee7\u7eed\u4e0b\u8f7d");
        this$0.lastState = State.ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y("\u5b89\u88c5");
        this$0.lastState = State.FINISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastProgress = 0;
        this$0.y(this$0.getResources().getString(R.string.f210645io));
        this$0.lastState = State.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y("\u70b9\u51fb\u7ee7\u7eed\u4e0b\u8f7d");
        this$0.lastState = State.PAUSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z(this$0.lastProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QQLiveCustomDistributeBtn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y("\u6253\u5f00");
        this$0.lastState = State.INSTALLED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QQLiveCustomDistributeBtn this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastProgress = i3;
        this$0.z(i3);
        this$0.lastState = State.DOWNLOADING;
    }

    private final void y(String tips) {
        ProgressBar progressBar = this.qqliveCustomDistributeProgress;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        TextView textView = this.qqliveCustomDistributeTips;
        if (textView != null) {
            textView.setText(tips);
        }
    }

    private final void z(int progress) {
        ProgressBar progressBar = this.qqliveCustomDistributeProgress;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        ProgressBar progressBar2 = this.qqliveCustomDistributeProgress;
        if (progressBar2 != null) {
            progressBar2.setProgressDrawable(p(Color.parseColor("#0099FF")));
        }
        ProgressBar progressBar3 = this.qqliveCustomDistributeProgress;
        if (progressBar3 != null) {
            progressBar3.setProgress(progress);
        }
        TextView textView = this.qqliveCustomDistributeTips;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(progress)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        int value = this.lastState.getValue();
        if (value == State.IDLE.getValue()) {
            this.controller.u();
            return;
        }
        if (value == State.DOWNLOADING.getValue()) {
            this.controller.t();
            return;
        }
        if (value == State.PAUSE.getValue()) {
            this.controller.u();
            return;
        }
        if (value == State.FINISH.getValue()) {
            this.controller.k();
        } else if (value == State.INSTALLED.getValue()) {
            this.controller.l();
            b();
        }
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.controller.w();
        this.activity = null;
        this.lastState = State.IDLE;
        this.lastProgress = 0;
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.controller.x();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void a(final int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, progress);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onProgressUpdated", "progress=" + progress);
        post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCustomDistributeBtn.x(QQLiveCustomDistributeBtn.this, progress);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onCallApp", "");
        QQLiveCustomDistributeController.b bVar = this.stateListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void c(boolean fromQQLive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, fromQQLive);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onInstallSucceed", "");
        post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCustomDistributeBtn.w(QQLiveCustomDistributeBtn.this);
            }
        });
        QQLiveCustomDistributeController.b bVar = this.stateListener;
        if (bVar != null) {
            bVar.c(fromQQLive);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Audience|DistributeButton", "onDownloadIdle", "");
            post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCustomDistributeBtn.t(QQLiveCustomDistributeBtn.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void e(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, errorCode);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onDownloadError", "errorCode=" + errorCode);
        post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCustomDistributeBtn.r(QQLiveCustomDistributeBtn.this);
            }
        });
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.lastProgress;
    }

    @NotNull
    public final State o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (State) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lastState;
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onDownloadFinish", "");
        post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCustomDistributeBtn.s(QQLiveCustomDistributeBtn.this);
            }
        });
        QQLiveCustomDistributeController.b bVar = this.stateListener;
        if (bVar != null) {
            bVar.onDownloadFinish();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Audience|DistributeButton", "onDownloadPause", "");
            post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCustomDistributeBtn.u(QQLiveCustomDistributeBtn.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|DistributeButton", "onDownloadStart", "");
        post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveCustomDistributeBtn.v(QQLiveCustomDistributeBtn.this);
            }
        });
        this.lastState = State.DOWNLOADING;
        QQLiveCustomDistributeController.b bVar = this.stateListener;
        if (bVar != null) {
            bVar.onDownloadStart();
        }
    }

    public final void q(@Nullable Activity hostActivity, @NotNull cr4.b gameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hostActivity, (Object) gameInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(gameInfo, "gameInfo");
        this.activity = hostActivity;
        this.controller.j(gameInfo, this);
    }

    public final void setLastProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.lastProgress = i3;
        }
    }

    public final void setLastState(@NotNull State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.lastState = state;
        }
    }

    public final void setListener(@NotNull QQLiveCustomDistributeController.b customDistributeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) customDistributeListener);
        } else {
            Intrinsics.checkNotNullParameter(customDistributeListener, "customDistributeListener");
            this.stateListener = customDistributeListener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveCustomDistributeBtn(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) ctx, (Object) attributeSet);
    }

    public /* synthetic */ QQLiveCustomDistributeBtn(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveCustomDistributeBtn(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.controller = new QQLiveCustomDistributeController();
        this.lastState = State.IDLE;
        View.inflate(getContext(), R.layout.h_a, this);
        this.qqliveCustomDistributeProgress = (ProgressBar) findViewById(R.id.f630832k);
        this.qqliveCustomDistributeTips = (TextView) findViewById(R.id.f631032m);
        y("\u7acb\u5373\u4e0b\u8f7d");
    }
}
