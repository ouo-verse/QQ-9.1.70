package com.tencent.mobileqq.aio.reserve1.audio;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnUIState;
import com.tencent.mobileqq.aio.reserve1.audio.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001b\u0010\u001a\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010(R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/audio/AIOAudioBtnVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "", "speakerPhoneOn", "", "o1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/widget/LinearLayout;", "m1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "initMsgIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "state", "l1", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "e", "Lkotlin/Lazy;", "k1", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "f", "h1", "()Landroid/widget/ImageView;", "aioSpeakerPhoneImage", "Landroid/widget/TextView;", h.F, "i1", "()Landroid/widget/TextView;", "aioSpeakerPhoneText", "Lmqq/app/AppRuntime;", "i", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "j1", "()Landroid/os/Handler;", "handler", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "onPlayerStop", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOAudioBtnVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<at.d, Reserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> onPlayerStop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aioSpeakerPhoneImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aioSpeakerPhoneText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean speakerPhoneOn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/audio/AIOAudioBtnVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAudioBtnVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnVB$rootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOAudioBtnVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    ImageView h16;
                    TextView i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(AIOAudioBtnVB.this.getMContext());
                    AIOAudioBtnVB aIOAudioBtnVB = AIOAudioBtnVB.this;
                    int dpToPx = ViewUtils.dpToPx(45.0f);
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dpToPx, dpToPx);
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(8.0f);
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(8.0f);
                    layoutParams.endToEnd = 0;
                    layoutParams.bottomToBottom = R.id.slg;
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setBackgroundResource(R.drawable.skin_aio_speaker_phone_layout_bg);
                    linearLayout.setOrientation(1);
                    h16 = aIOAudioBtnVB.h1();
                    linearLayout.addView(h16);
                    i16 = aIOAudioBtnVB.i1();
                    linearLayout.addView(i16);
                    return linearLayout;
                }
            });
            this.rootView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnVB$aioSpeakerPhoneImage$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOAudioBtnVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ImageView imageView = new ImageView(AIOAudioBtnVB.this.getMContext());
                    int dpToPx = ViewUtils.dpToPx(21.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
                    layoutParams.gravity = 1;
                    layoutParams.topMargin = ViewUtils.dpToPx(5.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setBackgroundResource(R.drawable.skin_aio_phone_speaker);
                    return imageView;
                }
            });
            this.aioSpeakerPhoneImage = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.reserve1.audio.AIOAudioBtnVB$aioSpeakerPhoneText$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOAudioBtnVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TextView textView = new TextView(AIOAudioBtnVB.this.getMContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 1;
                    layoutParams.topMargin = ViewUtils.dpToPx(3.0f);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(8.0f);
                    textView.setText(textView.getResources().getText(R.string.ytt));
                    textView.setIncludeFontPadding(false);
                    textView.setTextColor(Color.parseColor("#03081a"));
                    return textView;
                }
            });
            this.aioSpeakerPhoneText = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(AIOAudioBtnVB$appRuntime$2.INSTANCE);
            this.appRuntime = lazy4;
            this.speakerPhoneOn = true;
            lazy5 = LazyKt__LazyJVMKt.lazy(AIOAudioBtnVB$handler$2.INSTANCE);
            this.handler = lazy5;
            this.onPlayerStop = new AIOAudioBtnVB$onPlayerStop$1(this);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView h1() {
        return (ImageView) this.aioSpeakerPhoneImage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView i1() {
        return (TextView) this.aioSpeakerPhoneText.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler j1() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout k1() {
        return (LinearLayout) this.rootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(AIOAudioBtnVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOAudioBtnVB", 4, "onClick, switch speakerPhoneOn: " + (!this$0.speakerPhoneOn));
        }
        boolean z16 = !this$0.speakerPhoneOn;
        this$0.speakerPhoneOn = z16;
        this$0.o1(z16);
        AIOPttAudioPlayerManager.f191706d.f(this$0.speakerPhoneOn);
        this$0.sendIntent(new a.C7343a(this$0.speakerPhoneOn));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o1(boolean speakerPhoneOn) {
        if (speakerPhoneOn) {
            h1().setBackgroundResource(R.drawable.skin_aio_phone_speaker);
            i1().setText(R.string.ytt);
        } else {
            h1().setBackgroundResource(R.drawable.skin_aio_phone_ear);
            i1().setText(R.string.yts);
        }
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<at.d, Reserve1UIState> b1(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) initMsgIntent);
        }
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        return new d(initMsgIntent);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Reserve1UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOAudioBtnUIState.PlayAudio) {
            QLog.d("AIOAudioBtnVB", 1, "handle UI State: PlayAudio: " + state);
            k1().setVisibility(0);
            AIOAudioBtnUIState.PlayAudio playAudio = (AIOAudioBtnUIState.PlayAudio) state;
            this.speakerPhoneOn = playAudio.a();
            o1(playAudio.a());
            AIOPttAudioPlayerManager.f191706d.B(this.onPlayerStop);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public LinearLayout onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout k16 = k1();
        k16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.reserve1.audio.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOAudioBtnVB.n1(AIOAudioBtnVB.this, view);
            }
        });
        return k16;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        j1().removeCallbacksAndMessages(null);
        AIOPttAudioPlayerManager.f191706d.B(null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        this.onPlayerStop.invoke();
    }
}
