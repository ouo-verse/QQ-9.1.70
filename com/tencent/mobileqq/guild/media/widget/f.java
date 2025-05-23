package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\u0018\u0000 -2\u00020\u0001:\u0001.B\u001f\u0012\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/f;", "Landroid/app/Dialog;", "", ExifInterface.LATITUDE_SOUTH, "", "countDownTime", "X", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/guild/media/core/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/e;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/mobileqq/guild/media/core/e;", "core", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "countDownTimeMinuteTv", "E", "countDownTimeSecondTv", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "countDownTimeColonIv", "G", "cancelBtn", "H", "confirmBtn", "Landroidx/lifecycle/Observer;", "I", "Landroidx/lifecycle/Observer;", "countDownTimerObserver", "com/tencent/mobileqq/guild/media/widget/f$b", "J", "Lcom/tencent/mobileqq/guild/media/widget/f$b;", "audioTimerFinishObserver", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRef", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/guild/media/core/e;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.e core;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView countDownTimeMinuteTv;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView countDownTimeSecondTv;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView countDownTimeColonIv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView cancelBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView confirmBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Observer<Integer> countDownTimerObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b audioTimerFinishObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/f$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.a> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.mobileqq.guild.media.core.e core = f.this.getCore();
            Intrinsics.checkNotNull(core, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.IMediaChannelInnerCore");
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = ((com.tencent.mobileqq.guild.media.core.f) core).getSelfUserInfo();
            if (event.getNotifyForAll() || event.b() == null || event.b().isEmpty() || event.b().contains(selfUserInfo.f228093a)) {
                com.tencent.mobileqq.guild.media.core.logic.ac M = com.tencent.mobileqq.guild.media.core.j.a().M();
                String str = selfUserInfo.f228093a;
                Intrinsics.checkNotNullExpressionValue(str, "selfUser.id");
                com.tencent.mobileqq.guild.media.core.logic.ac.T0(M, str, false, 2, null);
                f.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/f$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QGMC.GuildAudioReadyDialog", 1, "setMicrophone result: " + result + ", " + errMsg);
            f.this.dismiss();
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ac(true));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(@NotNull WeakReference<Context> contextRef, @NotNull com.tencent.mobileqq.guild.media.core.e core) {
        super(r2, R.style.awd);
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(core, "core");
        Context context = contextRef.get();
        Intrinsics.checkNotNull(context);
        this.core = core;
        this.countDownTimerObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.Q(f.this, (Integer) obj);
            }
        };
        this.audioTimerFinishObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(f this$0, Integer countDownTime) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(countDownTime, "countDownTime");
        this$0.X(countDownTime.intValue());
    }

    private final void S() {
        TextView textView = this.confirmBtn;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.U(f.this, view);
            }
        });
        TextView textView3 = this.cancelBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.W(f.this, view);
            }
        });
        this.core.M().l0().observeForever(this.countDownTimerObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioTimerFinishObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.guild.util.o.a(view)) {
            QLog.w("QGMC.GuildAudioReadyDialog", 1, "click too fast.");
        } else {
            com.tencent.mobileqq.guild.media.core.j.a().J().i(true, new c());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X(int countDownTime) {
        String valueOf;
        String valueOf2;
        int i3 = countDownTime / 60;
        int i16 = countDownTime % 60;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = String.valueOf(i16);
        }
        TextView textView = this.countDownTimeMinuteTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimeMinuteTv");
            textView = null;
        }
        textView.setText(valueOf);
        TextView textView2 = this.countDownTimeSecondTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimeSecondTv");
            textView2 = null;
        }
        textView2.setText(valueOf2);
        ImageView imageView2 = this.countDownTimeColonIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimeColonIv");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(0);
    }

    @NotNull
    /* renamed from: R, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.e getCore() {
        return this.core;
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egk);
        View findViewById = findViewById(R.id.vzq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_\u2026y_countdown_timer_minute)");
        this.countDownTimeMinuteTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.vzr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_\u2026y_countdown_timer_second)");
        this.countDownTimeSecondTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.vzp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_\u2026dy_countdown_timer_colon)");
        this.countDownTimeColonIv = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vzo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_audio_ready_confirm_btn)");
        this.confirmBtn = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.vzn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_audio_ready_cancel_btn)");
        this.cancelBtn = (TextView) findViewById5;
        TextView textView = this.countDownTimeMinuteTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimeMinuteTv");
            textView = null;
        }
        textView.setTypeface(TypefaceProvider.c(getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        TextView textView3 = this.countDownTimeSecondTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countDownTimeSecondTv");
        } else {
            textView2 = textView3;
        }
        textView2.setTypeface(TypefaceProvider.c(getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        S();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        QLog.i("QGMC.GuildAudioReadyDialog", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        this.core.M().l0().removeObserver(this.countDownTimerObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioTimerFinishObserver);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
    }
}
