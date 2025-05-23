package com.tencent.mobileqq.qqlive.sail.ui.input;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.liveroom.impl.room.audienceoperationbar.event.AnchorInputClickEvent;
import com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012`\u0013H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/c;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", LocaleUtils.L_JAPANESE, "", "la", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "U9", "V9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "e", "Landroid/view/View;", "inputClickMask", "Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout;", "inputLayout", "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", h.F, "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "atEvent", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inputClickMask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorInputLayout inputLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorAtEvent atEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.input.c$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/input/c$b", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$c;", "", "state", "", "onStateChanged", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements LiveInputLayout.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout.c
        public void onStateChanged(int state) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                View view = c.this.inputClickMask;
                if (view != null) {
                    if (state == 1) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    view.setVisibility(i3);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, state);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ja() {
        EditText c06;
        AnchorAtEvent anchorAtEvent = this.atEvent;
        if (anchorAtEvent != null && la()) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            commonOuterClass$QQUserId.uid.set(anchorAtEvent.getLiveUserInfo().uid);
            AnchorInputLayout anchorInputLayout = this.inputLayout;
            if (anchorInputLayout != null) {
                String str = anchorAtEvent.getLiveUserInfo().nick;
                String str2 = anchorAtEvent.getLiveUserInfo().showNick;
                Intrinsics.checkNotNullExpressionValue(str2, "it.liveUserInfo.showNick");
                String str3 = anchorAtEvent.getLiveUserInfo().headUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "it.liveUserInfo.headUrl");
                anchorInputLayout.j(commonOuterClass$QQUserId, str, str2, str3);
            }
            AnchorInputLayout anchorInputLayout2 = this.inputLayout;
            if (anchorInputLayout2 != null && (c06 = anchorInputLayout2.c0()) != null) {
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
    private final boolean la() {
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
    public static final void ma(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnchorInputLayout anchorInputLayout = this$0.inputLayout;
        if (anchorInputLayout != null) {
            anchorInputLayout.setState(1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        if (F9() != null) {
            startInit();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.atEvent = null;
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AnchorInputClickEvent.class, AnchorAtEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f60992wx;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        AnchorInputLayout anchorInputLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        AnchorInputLayout anchorInputLayout2 = null;
        if (rootView != null && (view = rootView.findViewById(R.id.f61002wy)) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.input.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.ma(c.this, view2);
                }
            });
        } else {
            view = null;
        }
        this.inputClickMask = view;
        if (rootView != null && (anchorInputLayout = (AnchorInputLayout) rootView.findViewById(R.id.f60992wx)) != null) {
            anchorInputLayout.setRoomId(H9());
            anchorInputLayout.d0(H9());
            anchorInputLayout.k(new b());
            anchorInputLayout2 = anchorInputLayout;
        }
        this.inputLayout = anchorInputLayout2;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        if (event instanceof AnchorInputClickEvent) {
            AnchorInputLayout anchorInputLayout = this.inputLayout;
            if (anchorInputLayout != null) {
                anchorInputLayout.l();
                ja();
                anchorInputLayout.Y();
            }
            this.atEvent = null;
            return;
        }
        if (event instanceof AnchorAtEvent) {
            this.atEvent = (AnchorAtEvent) event;
        }
    }
}
