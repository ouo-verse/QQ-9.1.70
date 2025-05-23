package com.tencent.mobileqq.qqlive.sail.ui.player;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.definition.DefinitionBeginSwitchEvent;
import com.tencent.mobileqq.qqlive.sail.ui.player.PlayerViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.utils.k;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00020\b0\u0007:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0016\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010'\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010 H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\tH\u0016J\b\u0010-\u001a\u00020\tH\u0016J\b\u0010.\u001a\u00020\tH\u0016J$\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b000/j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b00`1H\u0016J\u0012\u00104\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\bH\u0016J\b\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\tH\u0016J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J*\u0010=\u001a\u00020\t2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u001e2\b\u0010<\u001a\u0004\u0018\u00010\u001aH\u0016R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010P\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010P\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u0004\u0018\u00010b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bc\u0010d\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/QQLivePlayerStatusPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/c;", "Lmi2/a;", "Lmi2/g;", "Lmi2/d;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Oa", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "Ka", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "streamInfo", "wa", "Da", "Ma", "La", "Na", "", "newStreams", "Pa", "Ia", "xa", "", "eventId", "Ja", "Fa", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "v", NodeProps.ON_CLICK, "u3", "T9", "U9", "V9", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "onVideoPrepared", "onFirstFrameRendered", "K", "w", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onError", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "rootViewStub", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "warningTitleView", tl.h.F, "warningDescView", "i", "warningConfirmView", "Lkotlinx/coroutines/Job;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/Job;", "noNetworkJob", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ca", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "D", "za", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel;", "E", "Aa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel;", "playerViewModel", "", "Ea", "()Z", "isVideoPlaying", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Ba", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePlayerStatusPart extends com.tencent.mobileqq.qqlive.sail.base.c implements mi2.c, mi2.a, mi2.g, mi2.d, View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView warningTitleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView warningDescView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView warningConfirmView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job noNetworkJob;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/QQLivePlayerStatusPart$a;", "", "", "CONFIRM_FOR_MOBILE", "I", "CONFIRM_FOR_RETRY", "", "NO_NETWORK_SHOW_ERROR_DELAY_MS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/player/QQLivePlayerStatusPart$b", "Lcom/tencent/mobileqq/qqlive/huya/d;", "", "urlWithToken", "", "onUrlCallback", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.mobileqq.qqlive.huya.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.sail.model.audience.a f273021a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLivePlayerStatusPart f273022b;

        b(com.tencent.mobileqq.qqlive.sail.model.audience.a aVar, QQLivePlayerStatusPart qQLivePlayerStatusPart) {
            this.f273021a = aVar;
            this.f273022b = qQLivePlayerStatusPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) qQLivePlayerStatusPart);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQLivePlayerStatusPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Oa();
        }

        @Override // com.tencent.mobileqq.qqlive.huya.d
        public void onUrlCallback(@Nullable String urlWithToken) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlWithToken);
                return;
            }
            com.tencent.mobileqq.qqlive.sail.model.audience.a aVar = this.f273021a;
            if (urlWithToken == null) {
                urlWithToken = "";
            }
            aVar.g(urlWithToken);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final QQLivePlayerStatusPart qQLivePlayerStatusPart = this.f273022b;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePlayerStatusPart.b.b(QQLivePlayerStatusPart.this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52855);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePlayerStatusPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$roomViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerStatusPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RoomViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLivePlayerStatusPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.roomViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.definition.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$definitionViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerStatusPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.qqlive.sail.ui.definition.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.definition.a) QQLivePlayerStatusPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.definition.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.definitionViewModel = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PlayerViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$playerViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerStatusPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PlayerViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (PlayerViewModel) QQLivePlayerStatusPart.this.getViewModel(PlayerViewModel.class) : (PlayerViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.playerViewModel = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerViewModel Aa() {
        Object value = this.playerViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-playerViewModel>(...)");
        return (PlayerViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.room.e Ba() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    private final RoomViewModel Ca() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da() {
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "hideStatusView");
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        ViewGroup viewGroup = this.rootViewStub;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ea() {
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null) {
            return Ba.isPlaying();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa() {
        Job launch$default;
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLivePlayerStatusPart$launchNoNetworkJob$1(this, null), 3, null);
        this.noNetworkJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ia() {
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null) {
            Ba.registerBufferListener(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba2 = Ba();
        if (Ba2 != null) {
            Ba2.x(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba3 = Ba();
        if (Ba3 != null) {
            Ba3.registerVideoPreparedListener(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba4 = Ba();
        if (Ba4 != null) {
            Ba4.registerFirstFrameRenderedListener(this);
        }
    }

    private final void Ja(String eventId) {
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        QQLiveDaTongParams f16 = aVar.f(H9());
        f16.d("em_qqlive_notwifi_continue");
        aVar.i(eventId, f16.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka(StreamDefinition definition) {
        Unit unit;
        com.tencent.mobileqq.qqlive.sail.model.audience.a a16;
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null && (a16 = com.tencent.mobileqq.qqlive.sail.model.f.a(Ba, definition)) != null) {
            za().W1(a16.b());
            Ca().h2(a16);
            wa(a16);
            AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "setPlayStream", "roomId=" + H9() + ", stream=" + a16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|QQLivePlayerStatusPart", "setPlayStream", "roomId=" + H9() + ", no play stream");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La() {
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "showErrorStatusView");
        startInit();
        ViewGroup viewGroup = this.rootViewStub;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
        TextView textView = this.warningTitleView;
        if (textView != null) {
            textView.setText(R.string.f210785j2);
        }
        TextView textView2 = this.warningConfirmView;
        if (textView2 != null) {
            textView2.setText(R.string.f210795j3);
        }
        TextView textView3 = this.warningConfirmView;
        if (textView3 != null) {
            textView3.setTag(0);
        }
        ViewGroup viewGroup2 = this.rootViewStub;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        TextView textView4 = this.warningTitleView;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        TextView textView5 = this.warningDescView;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.warningConfirmView;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma() {
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "showLoadingStatusView");
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        startInit();
        ViewGroup viewGroup = this.rootViewStub;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        TextView textView = this.warningTitleView;
        if (textView != null) {
            textView.setText(R.string.f210845j8);
        }
        TextView textView2 = this.warningTitleView;
        if (textView2 != null) {
            textView2.setBackgroundResource(R.drawable.lph);
        }
        ViewGroup viewGroup2 = this.rootViewStub;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        TextView textView3 = this.warningTitleView;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.warningDescView;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = this.warningConfirmView;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na() {
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "showMobileStatusView");
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        startInit();
        ViewGroup viewGroup = this.rootViewStub;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        TextView textView = this.warningTitleView;
        if (textView != null) {
            textView.setText(R.string.f210835j7);
        }
        TextView textView2 = this.warningTitleView;
        if (textView2 != null) {
            textView2.setBackgroundColor(0);
        }
        TextView textView3 = this.warningDescView;
        if (textView3 != null) {
            textView3.setText(R.string.f210825j6);
        }
        TextView textView4 = this.warningConfirmView;
        if (textView4 != null) {
            textView4.setText(R.string.f210815j5);
        }
        TextView textView5 = this.warningConfirmView;
        if (textView5 != null) {
            textView5.setTag(1);
        }
        ViewGroup viewGroup2 = this.rootViewStub;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        TextView textView6 = this.warningTitleView;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        TextView textView7 = this.warningDescView;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        TextView textView8 = this.warningConfirmView;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        Ja("dt_imp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa() {
        Unit unit;
        com.tencent.mobileqq.qqlive.sail.room.e Ba;
        boolean isBlank;
        com.tencent.mobileqq.qqlive.sail.model.audience.a T1 = Ca().T1();
        if (T1 != null) {
            if (!Ea() && (Ba = Ba()) != null) {
                if (Ba.b().x()) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(T1.f());
                    if (isBlank) {
                        QLog.w("Audience|QQLivePlayerStatusPart", 1, "tryPlayVideo wait huya url with token callback");
                    } else {
                        QLog.i("Audience|QQLivePlayerStatusPart", 2, "tryPlayVideo huya url with token " + T1.f());
                        Ba.k(T1.f());
                    }
                } else {
                    Ba.k(T1.e());
                }
                k.d(k.f273458a, "Audience|QQLivePlayerStatusPart", Ba, false, 4, null);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|QQLivePlayerStatusPart", "tryPlayVideo", "roomId=" + H9() + ", no play stream set");
            La();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pa(List<com.tencent.mobileqq.qqlive.sail.model.audience.a> newStreams) {
        AudienceRoomInfo b16;
        ArrayList<com.tencent.mobileqq.qqlive.sail.model.audience.a> t16;
        Object obj;
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null && (b16 = Ba.b()) != null && (t16 = b16.t()) != null) {
            ArrayList<com.tencent.mobileqq.qqlive.sail.model.audience.a> arrayList = new ArrayList();
            for (com.tencent.mobileqq.qqlive.sail.model.audience.a aVar : t16) {
                Iterator<T> it = newStreams.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((com.tencent.mobileqq.qqlive.sail.model.audience.a) obj).b() == aVar.b()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.mobileqq.qqlive.sail.model.audience.a aVar2 = (com.tencent.mobileqq.qqlive.sail.model.audience.a) obj;
                if (aVar2 != null) {
                    arrayList.add(new com.tencent.mobileqq.qqlive.sail.model.audience.a(aVar.d(), aVar.b(), aVar.a(), aVar2.e(), aVar.c(), aVar.f()));
                }
            }
            if (AegisLogger.INSTANCE.isColorLevel()) {
                for (com.tencent.mobileqq.qqlive.sail.model.audience.a aVar3 : arrayList) {
                    AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "updateStreamInfo", "roomId=" + H9() + ", " + aVar3);
                }
            }
            com.tencent.mobileqq.qqlive.sail.room.e Ba2 = Ba();
            if (Ba2 != null) {
                Ba2.i(arrayList);
            }
        }
    }

    private final void wa(com.tencent.mobileqq.qqlive.sail.model.audience.a streamInfo) {
        boolean isBlank;
        AudienceRoomInfo b16;
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        boolean z16 = false;
        if (Ba != null && (b16 = Ba.b()) != null && b16.x()) {
            z16 = true;
        }
        if (z16) {
            isBlank = StringsKt__StringsJVMKt.isBlank(streamInfo.f());
            if (!isBlank) {
                return;
            }
            QLog.d("Audience|QQLivePlayerStatusPart", 2, "refresh originUrl: " + streamInfo.e());
            QQLiveHuYa.f271333a.i(streamInfo.e(), new b(streamInfo, this));
        }
    }

    private final void xa() {
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null) {
            Ba.w(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba2 = Ba();
        if (Ba2 != null) {
            Ba2.r(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba3 = Ba();
        if (Ba3 != null) {
            Ba3.z(this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba4 = Ba();
        if (Ba4 != null) {
            Ba4.u(this);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.definition.a za() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.definition.a) value;
    }

    @Override // mi2.a
    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "onStartBuffer");
        LifecycleCoroutineScope P9 = P9();
        if (P9 != null) {
            BuildersKt__Builders_commonKt.launch$default(P9, null, null, new QQLivePlayerStatusPart$onStartBuffer$1(this, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.T9();
            Ia();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U9() {
        String str;
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Aa().Z1();
        com.tencent.mobileqq.qqlive.sail.model.audience.a T1 = Ca().T1();
        if (T1 != null) {
            str = T1.e();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Ka(za().S1());
                }
                if (Ea()) {
                    Aa().S1();
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (Ea()) {
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Job job = this.noNetworkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Aa().a2();
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null) {
            ReportExtKt.i(Ba, za().O1().getValue());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(DefinitionBeginSwitchEvent.class, RFWMediaFocusChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f61262xn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f61232xk) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isDevelopLevel()) {
                    companion.d("Audience|QQLivePlayerStatusPart", NodeProps.ON_CLICK, "roomId=" + H9() + ", tag=" + v3.getTag());
                }
                if (Intrinsics.areEqual(v3.getTag(), (Object) 1)) {
                    Aa().X1();
                    ji4.a.f409945a.b();
                    Ja("dt_clck");
                }
                Aa().S1();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // mi2.c
    public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        boolean z16;
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Audience|QQLivePlayerStatusPart", "onError", "errorCode=" + errorCode + ", msg=" + extraInfo);
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && hostFragment.isDetached()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            companion.i("Audience|QQLivePlayerStatusPart", "onError", "fragment detached");
            return;
        }
        if (R9()) {
            PlayerViewModel Aa = Aa();
            long H9 = H9();
            com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
            if (Ba == null || (b16 = Ba.b()) == null || !b16.x()) {
                z17 = false;
            }
            if (Aa.b2(H9, errorCode, z17)) {
                companion.i("Audience|QQLivePlayerStatusPart", "onError", "roomId=" + H9() + ", to change url");
                return;
            }
        }
        LifecycleCoroutineScope P9 = P9();
        if (P9 != null) {
            BuildersKt__Builders_commonKt.launch$default(P9, null, null, new QQLivePlayerStatusPart$onError$1(this, null), 3, null);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba2 = Ba();
        if (Ba2 != null) {
            ReportExtKt.g(Ba2, za().O1().getValue());
            ReportExtKt.i(Ba2, za().O1().getValue());
            ReportExtKt.h(Ba2, errorCode, extraInfo);
        }
    }

    @Override // mi2.d
    public void onFirstFrameRendered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba != null) {
            ReportExtKt.c(Ba);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        TextView textView;
        TextView textView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView3 = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f61262xn);
        } else {
            viewGroup = null;
        }
        this.rootViewStub = viewGroup;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f61252xm);
        } else {
            textView = null;
        }
        this.warningTitleView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f61242xl);
        } else {
            textView2 = null;
        }
        this.warningDescView = textView2;
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.f61232xk);
        }
        this.warningConfirmView = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        Ka(za().S1());
        Ia();
        SimpleEventBus.getInstance().registerReceiver(this);
        LiveData<List<com.tencent.mobileqq.qqlive.sail.model.audience.a>> W1 = Aa().W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.qqlive.sail.model.audience.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.qqlive.sail.model.audience.a>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerStatusPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.qqlive.sail.model.audience.a> list) {
                invoke2((List<com.tencent.mobileqq.qqlive.sail.model.audience.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.qqlive.sail.model.audience.a> it) {
                com.tencent.mobileqq.qqlive.sail.ui.definition.a za5;
                com.tencent.mobileqq.qqlive.sail.room.e Ba;
                PlayerViewModel Aa;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (QQLivePlayerStatusPart.this.R9()) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!it.isEmpty()) {
                        QQLivePlayerStatusPart.this.Pa(it);
                        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "urlChanged", "roomId=" + QQLivePlayerStatusPart.this.H9());
                        QQLivePlayerStatusPart qQLivePlayerStatusPart = QQLivePlayerStatusPart.this;
                        za5 = qQLivePlayerStatusPart.za();
                        qQLivePlayerStatusPart.Ka(za5.O1());
                        Ba = QQLivePlayerStatusPart.this.Ba();
                        if (Ba != null) {
                            Ba.stopVideo();
                        }
                        Aa = QQLivePlayerStatusPart.this.Aa();
                        Aa.S1();
                    }
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePlayerStatusPart.Ga(Function1.this, obj);
            }
        });
        LiveData<PlayerViewModel.NetworkChangeType> U1 = Aa().U1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<PlayerViewModel.NetworkChangeType, Unit> function12 = new Function1<PlayerViewModel.NetworkChangeType, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes17.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f273023a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52847);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[PlayerViewModel.NetworkChangeType.values().length];
                    try {
                        iArr[PlayerViewModel.NetworkChangeType.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PlayerViewModel.NetworkChangeType.WIFI.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PlayerViewModel.NetworkChangeType.MOBILE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f273023a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerStatusPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerViewModel.NetworkChangeType networkChangeType) {
                invoke2(networkChangeType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerViewModel.NetworkChangeType networkChangeType) {
                com.tencent.mobileqq.qqlive.sail.room.e Ba;
                PlayerViewModel Aa;
                com.tencent.mobileqq.qqlive.sail.room.e Ba2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) networkChangeType);
                    return;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Audience|QQLivePlayerStatusPart", "networkChanged", "roomId=" + QQLivePlayerStatusPart.this.H9() + ", network=" + networkChangeType);
                int i3 = networkChangeType == null ? -1 : a.f273023a[networkChangeType.ordinal()];
                if (i3 == 1) {
                    com.tencent.timi.game.ui.widget.f.b(R.string.f210855j9);
                    Ba = QQLivePlayerStatusPart.this.Ba();
                    if (Ba != null) {
                        Ba.pauseVideo();
                    }
                    QQLivePlayerStatusPart.this.Ma();
                    QQLivePlayerStatusPart.this.Fa();
                    return;
                }
                if (i3 == 2) {
                    QQLivePlayerStatusPart.this.Da();
                    QQLivePlayerStatusPart.this.Oa();
                    return;
                }
                if (i3 == 3) {
                    Aa = QQLivePlayerStatusPart.this.Aa();
                    if (!Aa.Q1()) {
                        Ba2 = QQLivePlayerStatusPart.this.Ba();
                        if (Ba2 != null) {
                            Ba2.pauseVideo();
                        }
                        QQLivePlayerStatusPart.this.Na();
                        return;
                    }
                    com.tencent.timi.game.ui.widget.f.b(R.string.f210805j4);
                    QQLivePlayerStatusPart.this.Da();
                    QQLivePlayerStatusPart.this.Oa();
                    return;
                }
                companion.w("Audience|QQLivePlayerStatusPart", "networkChanged", "roomId=" + QQLivePlayerStatusPart.this.H9() + ", invalid network type");
            }
        };
        U1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePlayerStatusPart.Ha(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            xa();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) event);
            return;
        }
        if (event instanceof DefinitionBeginSwitchEvent) {
            DefinitionBeginSwitchEvent definitionBeginSwitchEvent = (DefinitionBeginSwitchEvent) event;
            if (H9() != definitionBeginSwitchEvent.getRoomId() && !Ea()) {
                AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "onReceiveEvent", "roomId=" + H9());
                Ka(definitionBeginSwitchEvent.getDefinition());
                com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
                if (Ba != null) {
                    Ba.stopVideo();
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof RFWMediaFocusChangeEvent) {
            RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent = (RFWMediaFocusChangeEvent) event;
            if (TextUtils.equals("QQ\u76f4\u64ad", rFWMediaFocusChangeEvent.getConflictBusinessName())) {
                if (rFWMediaFocusChangeEvent.hasFocusConflict()) {
                    com.tencent.mobileqq.qqlive.sail.room.e Ba2 = Ba();
                    if (Ba2 != null) {
                        Ba2.y(true);
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.qqlive.sail.room.e Ba3 = Ba();
                if (Ba3 != null) {
                    Ba3.y(false);
                }
            }
        }
    }

    @Override // mi2.g
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "onVideoPrepared");
        LifecycleCoroutineScope P9 = P9();
        if (P9 != null) {
            BuildersKt__Builders_commonKt.launch$default(P9, null, null, new QQLivePlayerStatusPart$onVideoPrepared$1(this, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "onPageIn", "roomId=" + H9() + ", stream=" + Ca().T1());
        if (Ca().T1() != null) {
            Aa().S1();
        }
    }

    @Override // mi2.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerStatusPart", "onEndBuffer");
        LifecycleCoroutineScope P9 = P9();
        if (P9 != null) {
            BuildersKt__Builders_commonKt.launch$default(P9, null, null, new QQLivePlayerStatusPart$onEndBuffer$1(this, null), 3, null);
        }
    }
}
