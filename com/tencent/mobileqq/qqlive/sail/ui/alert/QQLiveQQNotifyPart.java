package com.tencent.mobileqq.qqlive.sail.ui.alert;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifyCallback;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.IVoiceQQNotifyApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/alert/QQLiveQQNotifyPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "ia", LocaleUtils.L_JAPANESE, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "U9", "V9", "Lfp4/c;", "msgInfo", "onPush", "", "e", "Z", "hasSubscribed", "Lnk4/a;", "f", "Lnk4/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", h.F, "Lkotlin/Lazy;", "ma", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/intervideo/audioroom/qqnotify/IQQNotifyCallback;", "i", "Lcom/tencent/mobileqq/intervideo/audioroom/qqnotify/IQQNotifyCallback;", "notifyCallback", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "la", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveQQNotifyPart extends com.tencent.mobileqq.qqlive.sail.base.c implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasSubscribed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nk4.a config;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQNotifyCallback notifyCallback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/alert/QQLiveQQNotifyPart$a;", "", "", "KEY_HAS_SUBSCRIBE", "Ljava/lang/String;", "KEY_RET_CODE", "KEY_RET_MSG", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.alert.QQLiveQQNotifyPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveQQNotifyPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.config = new nk4.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.alert.QQLiveQQNotifyPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQQNotifyPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveQQNotifyPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        this.notifyCallback = new IQQNotifyCallback() { // from class: com.tencent.mobileqq.qqlive.sail.ui.alert.c
            @Override // com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifyCallback
            public final void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
                QQLiveQQNotifyPart.na(QQLiveQQNotifyPart.this, bundle, bundle2);
            }
        };
    }

    private final void ia() {
        if (this.hasSubscribed) {
            AegisLogger.INSTANCE.i("Audience|QQLiveQQNotifyPart", "", "roomId=" + H9() + ", has subscribed");
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|QQLiveQQNotifyPart", "checkToShowSubscribe", "query subscribe");
        }
        ((IVoiceQQNotifyApi) QRoute.api(IVoiceQQNotifyApi.class)).querySubscribe(this.config.c(), this.config.b(), this.config.a(), this.notifyCallback);
    }

    private final void ja() {
        e la5 = la();
        if (la5 != null) {
            la5.e(this);
        }
    }

    private final e la() {
        f a26 = ma().a2();
        if (a26 instanceof e) {
            return (e) a26;
        }
        return null;
    }

    private final RoomViewModel ma() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(QQLiveQQNotifyPart this$0, Bundle bundle, Bundle bundle2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bundle.getInt("retcode", -1);
        if (i3 != 0) {
            String string = bundle.getString("retmsg");
            AegisLogger.INSTANCE.w("Audience|QQLiveQQNotifyPart", "notifyCallback", "query failed, " + i3 + ", " + string);
            return;
        }
        boolean z16 = true;
        if (bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, -1) != 1) {
            z16 = false;
        }
        this$0.hasSubscribed = z16;
        if (z16) {
            AegisLogger.INSTANCE.i("Audience|QQLiveQQNotifyPart", "notifyCallback", "already subscribed");
        } else {
            AegisLogger.INSTANCE.i("Audience|QQLiveQQNotifyPart", "notifyCallback", "goto subscribe");
            ((IVoiceQQNotifyApi) QRoute.api(IVoiceQQNotifyApi.class)).subscribeDirectly(this$0.config.c(), this$0.config.b(), this$0.config.a(), null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        e la5 = la();
        if (la5 != null) {
            la5.p(234, this);
        }
        e la6 = la();
        if (la6 != null) {
            la6.p(263, this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.V9();
            ja();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            ja();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        hr4.f j3 = com.tencent.mobileqq.qqlive.sail.push.a.j(msgInfo);
        if (j3 != null && j3.f406107a == com.tencent.mobileqq.qqlive.sail.c.f272176a.G() && j3.f406109c == C9() && j3.f406110d == 1) {
            ia();
        }
    }
}
