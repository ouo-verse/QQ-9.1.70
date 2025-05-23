package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.PKOtherAnchorVideoView;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnDisconnectOtherRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnFirstVideoFrameEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVideoAvailableEvent;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.guide.LinkMicVideoCutGuideDialog;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0012H\u0016J\n\u00102\u001a\u0004\u0018\u00010,H\u0016R\u0018\u00105\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010:\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00104R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00109R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u001b\u0010R\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010E\u001a\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010_R\u0016\u0010d\u001a\u0004\u0018\u00010a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAnchorLinkScreenPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lei2/a;", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "", "Ba", "Ca", "za", "xa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "", "isPartEnable", "", "action", "", "args", "getMessage", "U9", "V9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/view/ViewGroup;", "k6", "", "E0", "v", NodeProps.ON_CLICK, "", "roomId", "userId", "connectRemote", "disconnectRemote", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "mute", "muteRemoteAudio", "W1", "e", "Landroid/view/ViewGroup;", "pkBtnContainer", "f", "pkUIContainer", h.F, "Landroid/widget/FrameLayout;", "preview", "i", "previewContainer", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/PKOtherAnchorVideoView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/PKOtherAnchorVideoView;", "otherAnchorVideoViewContainer", BdhLogUtil.LogTag.Tag_Conn, "pkGameContainer", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/b;", "D", "Lkotlin/Lazy;", "sa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/b;", "entranceViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/d;", "E", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/d;", "linkViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", UserInfo.SEX_FEMALE, "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "pkViewModel", "Lcom/tencent/component/core/event/Eventor;", "G", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lcom/tencent/mobileqq/qqlive/sail/room/c;", "H", "Lcom/tencent/mobileqq/qqlive/sail/room/c;", "room", "I", "Z", "isPendingPKBtnClick", "va", "()I", "streamRecordType", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "wa", "()Lcom/tencent/mobileqq/qqlive/sail/room/d;", "trtc", "<init>", "()V", "J", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorLinkScreenPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.now.linkpkanchorplay.componententry.f, SimpleEventReceiver<SimpleBaseEvent>, ei2.a, com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FrameLayout pkGameContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy entranceViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy linkViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy pkViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.room.c room;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isPendingPKBtnClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup pkBtnContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup pkUIContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout preview;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup previewContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PKOtherAnchorVideoView otherAnchorVideoViewContainer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAnchorLinkScreenPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAnchorLinkScreenPart$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements OnEvent<LinkScreenEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkScreenEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNull(event);
            LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
            AegisLogger.INSTANCE.i("Open_Live|QQLivePKPart", "observeEvent", "LinkScreenEvent: " + event + "!!, anchorInfo " + linkScreenAnchorInfo);
            int type = event.getType();
            if (type != 1) {
                if (type == 2) {
                    QQLiveAnchorLinkScreenPart.this.ta().S1(QQLiveAnchorLinkScreenPart.this.otherAnchorVideoViewContainer, QQLiveAnchorLinkScreenPart.this.preview, QQLiveAnchorLinkScreenPart.this.previewContainer);
                    return;
                }
                return;
            }
            QQLiveAnchorLinkScreenPart qQLiveAnchorLinkScreenPart = QQLiveAnchorLinkScreenPart.this;
            Context context = QQLiveAnchorLinkScreenPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qQLiveAnchorLinkScreenPart.otherAnchorVideoViewContainer = new PKOtherAnchorVideoView(context, null, 0, 6, null);
            d ta5 = QQLiveAnchorLinkScreenPart.this.ta();
            QQLiveAnchorLinkScreenPart qQLiveAnchorLinkScreenPart2 = QQLiveAnchorLinkScreenPart.this;
            ta5.U1(event, qQLiveAnchorLinkScreenPart2, qQLiveAnchorLinkScreenPart2, qQLiveAnchorLinkScreenPart2.otherAnchorVideoViewContainer, QQLiveAnchorLinkScreenPart.this.preview, QQLiveAnchorLinkScreenPart.this.previewContainer);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAnchorLinkScreenPart$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lio3/a;", "muteEvent", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements OnEvent<LinkMuteEvent> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkMuteEvent muteEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) muteEvent);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLivePKPart", "observeEvent", "LinkMuteEvent: " + muteEvent);
            d ta5 = QQLiveAnchorLinkScreenPart.this.ta();
            Intrinsics.checkNotNull(muteEvent);
            ta5.T1(muteEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAnchorLinkScreenPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart$entranceViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (b) QQLiveAnchorLinkScreenPart.this.getViewModel(b.class) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.entranceViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart$linkViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final d invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (d) QQLiveAnchorLinkScreenPart.this.getViewModel(d.class) : (d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.linkViewModel = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart$pkViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (e) QQLiveAnchorLinkScreenPart.this.getViewModel(e.class) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pkViewModel = lazy3;
            this.eventor = new Eventor();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ba() {
        AegisLogger.INSTANCE.i("Open_Live|QQLivePKPart", "onClickPkBtn");
        if (sa().S1(va())) {
            Ca();
        } else {
            this.isPendingPKBtnClick = true;
            sa().O1();
        }
    }

    private final void Ca() {
        final LinkMicVideoCutGuideDialog linkMicVideoCutGuideDialog = new LinkMicVideoCutGuideDialog();
        linkMicVideoCutGuideDialog.th(new BottomDialog.a() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.g
            @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog.a
            public final void onDismiss(DialogInterface dialogInterface) {
                QQLiveAnchorLinkScreenPart.Da(LinkMicVideoCutGuideDialog.this, this, dialogInterface);
            }
        });
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        linkMicVideoCutGuideDialog.show(((Fragment) partHost).getParentFragmentManager(), "showVideoCutGuideDialog");
        sa().R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(LinkMicVideoCutGuideDialog dialog, QQLiveAnchorLinkScreenPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialog.getDismissFromClickButton()) {
            this$0.sa().O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b sa() {
        Object value = this.entranceViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-entranceViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d ta() {
        Object value = this.linkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-linkViewModel>(...)");
        return (d) value;
    }

    private final e ua() {
        Object value = this.pkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pkViewModel>(...)");
        return (e) value;
    }

    private final int va() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.room;
        if (cVar != null && (b16 = cVar.b()) != null && (r16 = b16.r()) != null) {
            return r16.m();
        }
        return 0;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.d wa() {
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.room;
        if (cVar instanceof com.tencent.mobileqq.qqlive.sail.room.d) {
            return (com.tencent.mobileqq.qqlive.sail.room.d) cVar;
        }
        return null;
    }

    private final void xa() {
        this.eventor.addOnEvent(new b()).addOnEvent(new c());
    }

    private final void za() {
        LiveData<Boolean> P1 = sa().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAnchorLinkScreenPart$observeResource$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorLinkScreenPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                boolean z16;
                b sa5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    z16 = QQLiveAnchorLinkScreenPart.this.isPendingPKBtnClick;
                    if (z16) {
                        sa5 = QQLiveAnchorLinkScreenPart.this.sa();
                        sa5.X1();
                    }
                } else {
                    BaseApplication baseApplication = BaseApplication.context;
                    QQToast.makeText(baseApplication, 1, baseApplication.getResources().getString(R.string.f221206a7), 1).show();
                }
                QQLiveAnchorLinkScreenPart.this.isPendingPKBtnClick = false;
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAnchorLinkScreenPart.Aa(Function1.this, obj);
            }
        });
        sa().O1();
    }

    @Override // com.tencent.now.linkpkanchorplay.componententry.f
    @NotNull
    public int[] E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        int[] iArr = new int[2];
        ViewGroup viewGroup = this.pkBtnContainer;
        if (viewGroup != null) {
            viewGroup.getLocationInWindow(iArr);
        }
        if (va() == 0) {
            iArr[0] = 0;
            iArr[1] = q.a(getContext(), 64.0f);
        } else {
            iArr[0] = iArr[0] - q.a(getContext(), 12.0f);
            iArr[1] = q.a(getContext(), 71.0f);
        }
        return iArr;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        com.tencent.mobileqq.qqlive.sail.room.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        Unit unit = null;
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.c) {
            cVar = (com.tencent.mobileqq.qqlive.sail.room.c) F9;
        } else {
            cVar = null;
        }
        this.room = cVar;
        if (cVar != null) {
            startInit();
            com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b sa5 = sa();
            AnchorRoomInfo b16 = cVar.b();
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            sa5.U1(b16, partHost, this);
            ta().P1(cVar.b());
            ua().Q1(getContext(), cVar.b(), this.pkGameContainer);
            za();
            xa();
            SimpleEventBus.getInstance().registerReceiver(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLivePKPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.V9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.room = null;
        this.eventor.removeAll();
        ua().R1();
        ta().Q1(this.otherAnchorVideoViewContainer, this.preview, this.previewContainer);
        sa().W1();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c
    @Nullable
    public FrameLayout W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        PKOtherAnchorVideoView pKOtherAnchorVideoView = this.otherAnchorVideoViewContainer;
        if (pKOtherAnchorVideoView != null) {
            return pKOtherAnchorVideoView.b();
        }
        return null;
    }

    @Override // ei2.a
    public void connectRemote(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(roomId), Long.valueOf(userId));
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.d wa5 = wa();
        if (wa5 != null) {
            wa5.connectRemote(roomId, userId);
        }
    }

    @Override // ei2.a
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.d wa5 = wa();
        if (wa5 != null) {
            wa5.disconnectRemote();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OnFirstVideoFrameEvent.class, OnUserVideoAvailableEvent.class, OnDisconnectOtherRoomEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f61042x2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, args);
        }
        if (Intrinsics.areEqual(action, "link_screen_state_msg")) {
            return new com.tencent.mobileqq.qqlive.sail.ui.linkscreen.c(ta().N1(), ua().O1(), ua().P1());
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ht3.a.e("qqlive_enable_anchor_pk_feature", true);
    }

    @Override // com.tencent.now.linkpkanchorplay.componententry.f
    @Nullable
    public ViewGroup k6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.pkUIContainer;
    }

    @Override // ei2.a
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, userId, Boolean.valueOf(mute));
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.qqlive.sail.room.d wa5 = wa();
        if (wa5 != null) {
            wa5.muteRemoteAudio(userId, mute);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) v3);
        } else {
            boolean z16 = false;
            if (v3 != null && v3.getId() == R.id.ta5) {
                z16 = true;
            }
            if (z16) {
                Ba();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        FrameLayout frameLayout;
        ViewGroup viewGroup3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        FrameLayout frameLayout2 = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.ta5);
        } else {
            viewGroup = null;
        }
        this.pkBtnContainer = viewGroup;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        if (rootView != null) {
            viewGroup2 = (ViewGroup) rootView.findViewById(R.id.f61032x1);
        } else {
            viewGroup2 = null;
        }
        this.pkUIContainer = viewGroup2;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61432y4);
        } else {
            frameLayout = null;
        }
        this.preview = frameLayout;
        if (rootView != null) {
            viewGroup3 = (ViewGroup) rootView.findViewById(R.id.f61442y5);
        } else {
            viewGroup3 = null;
        }
        this.previewContainer = viewGroup3;
        if (rootView != null) {
            frameLayout2 = (FrameLayout) rootView.findViewById(R.id.f61222xj);
        }
        this.pkGameContainer = frameLayout2;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if (event instanceof OnFirstVideoFrameEvent) {
            ta().R1((OnFirstVideoFrameEvent) event, this.otherAnchorVideoViewContainer);
        } else if (event instanceof OnUserVideoAvailableEvent) {
            ta().W1((OnUserVideoAvailableEvent) event, this.otherAnchorVideoViewContainer);
        } else if (event instanceof OnDisconnectOtherRoomEvent) {
            ta().O1((OnDisconnectOtherRoomEvent) event, this.otherAnchorVideoViewContainer, this.preview, this.previewContainer);
        }
    }

    @Override // ei2.a
    public void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uid, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        com.tencent.mobileqq.qqlive.sail.room.d wa5 = wa();
        if (wa5 != null) {
            wa5.startRemoteView(uid, videoView);
        }
    }

    @Override // ei2.a
    public void stopRemoteView(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.mobileqq.qqlive.sail.room.d wa5 = wa();
        if (wa5 != null) {
            wa5.stopRemoteView(uid);
        }
    }
}
