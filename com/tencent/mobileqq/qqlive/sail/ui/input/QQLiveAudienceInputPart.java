package com.tencent.mobileqq.qqlive.sail.ui.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sail.model.ForbidSwitchRoomEvent;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout;
import com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u00017\u0018\u0000 D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u0004\u0018\u00010>8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/QQLiveAudienceInputPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "", "xa", "ta", "", "ua", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "V9", "e", "Z", "isInited", "f", "Landroid/view/View;", "inputtingChatBgView", h.F, "inputClickMask", "Lcom/tencent/timi/game/liveroom/impl/room/input/AudienceInputLayout;", "i", "Lcom/tencent/timi/game/liveroom/impl/room/input/AudienceInputLayout;", "inputLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "atEvent", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "inputViewModel", "com/tencent/mobileqq/qqlive/sail/ui/input/QQLiveAudienceInputPart$b", "D", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/QQLiveAudienceInputPart$b;", "inputStateChangedListener", "za", "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "wa", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceInputPart extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<AnchorAtEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b inputStateChangedListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inputtingChatBgView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inputClickMask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AudienceInputLayout inputLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorAtEvent atEvent;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/QQLiveAudienceInputPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.input.QQLiveAudienceInputPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/input/QQLiveAudienceInputPart$b", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$c;", "", "state", "", "onStateChanged", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements LiveInputLayout.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceInputPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout.c
        public void onStateChanged(int state) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            ViewStub viewStub;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, state);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("Audience|QQLiveAudienceInputPart", "onStateChanged", "state=" + state);
            }
            if (QQLiveAudienceInputPart.this.inputtingChatBgView == null) {
                View partRootView = QQLiveAudienceInputPart.this.getPartRootView();
                View view = null;
                if (partRootView != null) {
                    viewStub = (ViewStub) partRootView.findViewById(R.id.f61022x0);
                } else {
                    viewStub = null;
                }
                QQLiveAudienceInputPart qQLiveAudienceInputPart = QQLiveAudienceInputPart.this;
                if (viewStub != null) {
                    view = viewStub.inflate();
                }
                qQLiveAudienceInputPart.inputtingChatBgView = view;
            }
            View view2 = QQLiveAudienceInputPart.this.inputtingChatBgView;
            boolean z26 = false;
            if (view2 != null) {
                if (state != 1 && !QQLiveAudienceInputPart.this.za()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                wi2.d.e(view2, z19);
            }
            View view3 = QQLiveAudienceInputPart.this.inputClickMask;
            if (view3 != null) {
                if (state != 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                wi2.d.e(view3, z18);
            }
            AudienceInputLayout audienceInputLayout = QQLiveAudienceInputPart.this.inputLayout;
            if (audienceInputLayout != null) {
                if (state != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                wi2.d.e(audienceInputLayout, z17);
            }
            long H9 = QQLiveAudienceInputPart.this.H9();
            if (!BusConfigHelper.f378723a.f(18, H9)) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (state != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                simpleEventBus.dispatchEvent(new ForbidSwitchRoomEvent(z16, H9, false, 4, null));
            }
            a va5 = QQLiveAudienceInputPart.this.va();
            if (state != 1) {
                z26 = true;
            }
            va5.O1(z26);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceInputPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.input.QQLiveAudienceInputPart$inputViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceInputPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) QQLiveAudienceInputPart.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.inputViewModel = lazy;
            this.inputStateChangedListener = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(QQLiveAudienceInputPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudienceInputLayout audienceInputLayout = this$0.inputLayout;
        if (audienceInputLayout != null) {
            audienceInputLayout.setState(1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta() {
        EditText c06;
        AnchorAtEvent anchorAtEvent = this.atEvent;
        if (anchorAtEvent != null && ua()) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            commonOuterClass$QQUserId.uid.set(anchorAtEvent.getLiveUserInfo().uid);
            AudienceInputLayout audienceInputLayout = this.inputLayout;
            if (audienceInputLayout != null) {
                String str = anchorAtEvent.getLiveUserInfo().nick;
                String str2 = anchorAtEvent.getLiveUserInfo().showNick;
                Intrinsics.checkNotNullExpressionValue(str2, "it.liveUserInfo.showNick");
                String str3 = anchorAtEvent.getLiveUserInfo().headUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "it.liveUserInfo.headUrl");
                audienceInputLayout.j(commonOuterClass$QQUserId, str, str2, str3);
            }
            AudienceInputLayout audienceInputLayout2 = this.inputLayout;
            if (audienceInputLayout2 != null && (c06 = audienceInputLayout2.c0()) != null) {
                Editable text = c06.getText();
                c06.setText(((Object) text) + "@" + anchorAtEvent.getLiveUserInfo().showNick + " " + anchorAtEvent.getQuickTip());
                c06.setSelection(c06.getText().length());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean ua() {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean isBlank;
        LiveUserInfo liveUserInfo;
        LiveUserInfo liveUserInfo2;
        LiveUserInfo liveUserInfo3;
        boolean isBlank2;
        LiveUserInfo liveUserInfo4;
        AnchorAtEvent anchorAtEvent = this.atEvent;
        String str2 = null;
        if (anchorAtEvent != null && (liveUserInfo4 = anchorAtEvent.getLiveUserInfo()) != null) {
            str = liveUserInfo4.nick;
        } else {
            str = null;
        }
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    AnchorAtEvent anchorAtEvent2 = this.atEvent;
                    if (anchorAtEvent2 != null && (liveUserInfo3 = anchorAtEvent2.getLiveUserInfo()) != null && liveUserInfo3.uid == M9()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        AnchorAtEvent anchorAtEvent3 = this.atEvent;
                        if (anchorAtEvent3 != null && (liveUserInfo2 = anchorAtEvent3.getLiveUserInfo()) != null && liveUserInfo2.uid == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18) {
                            AnchorAtEvent anchorAtEvent4 = this.atEvent;
                            if (anchorAtEvent4 != null && (liveUserInfo = anchorAtEvent4.getLiveUserInfo()) != null) {
                                str2 = liveUserInfo.showNick;
                            }
                            if (str2 != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank) {
                                    z19 = false;
                                    if (!z19) {
                                        return true;
                                    }
                                }
                            }
                            z19 = true;
                            if (!z19) {
                            }
                        }
                    }
                }
                return false;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a va() {
        Object value = this.inputViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputViewModel>(...)");
        return (a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e wa() {
        f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        String str;
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        if (this.isInited) {
            return;
        }
        if (!R9()) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceInputPart", "initInputLayout", "roomId=" + H9() + ", no enter room");
            return;
        }
        startInit();
        AudienceInputLayout audienceInputLayout = this.inputLayout;
        if (audienceInputLayout != null) {
            audienceInputLayout.setRoomId(H9());
            f F9 = F9();
            WindowMode windowMode = null;
            if (F9 != null && (b16 = F9.b()) != null) {
                str = b16.f();
            } else {
                str = null;
            }
            audienceInputLayout.setPlatform(str);
            audienceInputLayout.L0(H9(), com.tencent.mobileqq.qqlive.sail.report.a.f272382a.f(H9()).a());
            com.tencent.mobileqq.qqlive.sail.room.e wa5 = wa();
            if (wa5 != null) {
                windowMode = wa5.q();
            }
            if (windowMode == WindowMode.FLOAT) {
                z16 = true;
            } else {
                z16 = false;
            }
            audienceInputLayout.i0(z16);
            audienceInputLayout.k(this.inputStateChangedListener);
            this.isInited = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean za() {
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        uq4.c cVar = busConfigHelper.j().get(Long.valueOf(H9()));
        if (cVar != null) {
            boolean z16 = !busConfigHelper.g(10, cVar);
            boolean z17 = !busConfigHelper.g(11, cVar);
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceInputPart", "onBusConfigUpdate", "showPortraitInput=" + z16 + ", showLandscapeInput=" + z17);
            va().Q1(z16);
            va().P1(z17);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.U9();
        if (F9() != null) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.V9();
        this.atEvent = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AudienceInputLayout audienceInputLayout = this.inputLayout;
        if (audienceInputLayout != null) {
            audienceInputLayout.j0();
            audienceInputLayout.U(this.inputStateChangedListener);
        }
        this.isInited = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<AnchorAtEvent>> getEventClass() {
        ArrayList<Class<AnchorAtEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AnchorAtEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f60992wx;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        AudienceInputLayout audienceInputLayout = this.inputLayout;
        if (audienceInputLayout != null) {
            audienceInputLayout.setState(1);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        AudienceInputLayout audienceInputLayout;
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        AudienceInputLayout audienceInputLayout2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f61022x0);
        } else {
            view = null;
        }
        this.inputtingChatBgView = view;
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.f61012wz)) != null) {
            view2 = viewStub.inflate();
        } else {
            view2 = null;
        }
        this.inputClickMask = view2;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.input.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QQLiveAudienceInputPart.Aa(QQLiveAudienceInputPart.this, view3);
                }
            });
        }
        if (rootView != null && (audienceInputLayout = (AudienceInputLayout) rootView.findViewById(R.id.f60992wx)) != null) {
            QQLiveAudienceBarrageViewModel.Companion companion = QQLiveAudienceBarrageViewModel.INSTANCE;
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            QQLiveAudienceBarrageViewModel a16 = companion.a(partHost, H9());
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            audienceInputLayout.setInputViewModel(a16, lifecycleOwner);
            audienceInputLayout2 = audienceInputLayout;
        }
        this.inputLayout = audienceInputLayout2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> L1 = va().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.input.QQLiveAudienceInputPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceInputPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                AudienceInputLayout audienceInputLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) show);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceInputPart", "showKeyboard", "roomId=" + QQLiveAudienceInputPart.this.H9() + ", show=" + show);
                Intrinsics.checkNotNullExpressionValue(show, "show");
                if (show.booleanValue()) {
                    QQLiveAudienceInputPart.this.xa();
                    QQLiveAudienceInputPart.this.ta();
                    AudienceInputLayout audienceInputLayout2 = QQLiveAudienceInputPart.this.inputLayout;
                    if (audienceInputLayout2 != null) {
                        audienceInputLayout2.Y();
                    }
                    if (QQLiveAudienceInputPart.this.za() && (audienceInputLayout = QQLiveAudienceInputPart.this.inputLayout) != null) {
                        audienceInputLayout.setState(2);
                    }
                }
                QQLiveAudienceInputPart.this.atEvent = null;
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.input.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceInputPart.Ba(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        AudienceInputLayout audienceInputLayout = this.inputLayout;
        if (audienceInputLayout != null) {
            audienceInputLayout.U(this.inputStateChangedListener);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
        } else if (event instanceof AnchorAtEvent) {
            this.atEvent = (AnchorAtEvent) event;
            va().O1(true);
        }
    }
}
