package com.tencent.mobileqq.qqlive.sail.ui.definition;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import ar4.a;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.widget.bubble.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.definition.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00106\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u0004\u0018\u00010D8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010I\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionTipsPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/a;", "", "firstDelay", "", "Ga", "Ma", "Lar4/a;", "data", "Ja", "La", "Ka", "", "xa", "", "eventId", "bubble", "wa", "za", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "U9", "V9", "K", "w", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d;", "e", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d;", "funcBubbleTip", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "showTipsJob", h.F, "Z", "showTipWhenLandscape", "i", "isUILandscape", "Ljava/text/SimpleDateFormat;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/text/SimpleDateFormat;", "dateFormatter", BdhLogUtil.LogTag.Tag_Conn, "J", "startBufferTimestamp", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "D", "Lkotlin/Lazy;", "Ba", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "E", "Aa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "bottomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", UserInfo.SEX_FEMALE, "Da", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Ca", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "Fa", "()Ljava/lang/String;", "todayKey", "Ea", "tipShowCountKey", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveDefinitionTipsPart extends com.tencent.mobileqq.qqlive.sail.base.c implements mi2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long startBufferTimestamp;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.bubble.d funcBubbleTip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job showTipsJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean showTipWhenLandscape;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUILandscape;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat dateFormatter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionTipsPart$a;", "", "", "DAY_SHOW_TIPS_COUNT_KEY", "Ljava/lang/String;", "LAST_NOTIFY_TIPS_TIME_KEY", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/definition/QQLiveDefinitionTipsPart$b", "Lcom/tencent/mobileqq/qqlive/widget/bubble/d$a;", "", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onDismiss", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ar4.a f272628b;

        b(ar4.a aVar) {
            this.f272628b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.bubble.d.a
        public void onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
                return;
            }
            QQLiveDefinitionTipsPart.this.Ba().X1(true);
            com.tencent.mobileqq.qqlive.widget.bubble.d dVar = QQLiveDefinitionTipsPart.this.funcBubbleTip;
            if (dVar != null) {
                dVar.d();
            }
            QQLiveDefinitionTipsPart.this.wa("ev_qqlive_abnormal_clck", this.f272628b);
        }

        @Override // com.tencent.mobileqq.qqlive.widget.bubble.d.a
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QQLiveDefinitionTipsPart.this.Aa().P1(this.f272628b);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.bubble.d.a
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLiveDefinitionTipsPart.this.wa("ev_qqlive_abnormal_imp", this.f272628b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveDefinitionTipsPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dateFormatter = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());
        this.startBufferTimestamp = -1L;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$definitionViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) QQLiveDefinitionTipsPart.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.definitionViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.more.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$bottomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.more.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.more.b) QQLiveDefinitionTipsPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.more.b.class) : (com.tencent.mobileqq.qqlive.sail.ui.more.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bottomViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveDefinitionTipsPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.more.b Aa() {
        Object value = this.bottomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.more.b) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a Ba() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e Ca() {
        f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    private final RoomViewModel Da() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    private final String Ea() {
        return Fa() + "_day_show_tips_count";
    }

    private final String Fa() {
        String format = this.dateFormatter.format(Long.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "dateFormatter.format(System.currentTimeMillis())");
        return format;
    }

    private final void Ga(long firstDelay) {
        Job launch$default;
        Job job = this.showTipsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveDefinitionTipsPart$launchShowTipsJob$1(firstDelay, this, null), 3, null);
        this.showTipsJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(ar4.a data) {
        boolean z16;
        Resources resources;
        Configuration configuration;
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "showTip");
        ct3.a.q(Ea(), M9(), ct3.a.h(Ea(), M9()) + 1);
        ct3.a.q("last_notify_tips_time", M9(), System.currentTimeMillis());
        if (this.funcBubbleTip == null) {
            FrameLayout anchorView = (FrameLayout) getPartRootView().findViewById(R.id.f61692yt);
            com.tencent.mobileqq.qqlive.sail.ui.more.c cVar = com.tencent.mobileqq.qqlive.sail.ui.more.c.f272913a;
            Intrinsics.checkNotNullExpressionValue(anchorView, "anchorView");
            this.funcBubbleTip = cVar.b(anchorView, data).k(new b(data));
        }
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.showTipWhenLandscape = true;
            Da().e2().postValue(Boolean.TRUE);
        } else {
            this.showTipWhenLandscape = false;
            La();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka() {
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "showLandscapeTip");
        com.tencent.mobileqq.qqlive.widget.bubble.d dVar = this.funcBubbleTip;
        if (dVar != null) {
            dVar.l();
        }
    }

    private final void La() {
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "showPortraitTip");
        com.tencent.mobileqq.qqlive.widget.bubble.d dVar = this.funcBubbleTip;
        if (dVar != null) {
            dVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma() {
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "showTip");
        ar4.a aVar = new ar4.a();
        aVar.f26810a = "switch_definition";
        aVar.f26817h = 0L;
        aVar.f26812c = getContext().getString(R.string.f211035jq);
        a.C0066a c0066a = new a.C0066a();
        c0066a.f26819a = getContext().getString(R.string.f211025jp);
        c0066a.f26820b = "";
        aVar.f26814e = c0066a;
        aVar.f26816g = com.tencent.timi.game.liveroom.impl.room.definition.a.INSTANCE.a().getTipsShowTime() / 1000;
        aVar.f26815f = ht3.a.c("qqlive_player_quality_warning_tips_Interval", 30L);
        Aa().O1(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(String eventId, ar4.a bubble) {
        String str;
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        QQLiveDaTongParams f16 = aVar.f(H9());
        f16.d("em_qqlive_bottom_guide_bubble");
        String str2 = bubble.f26812c;
        Intrinsics.checkNotNullExpressionValue(str2, "bubble.tips");
        f16.o(str2);
        if (this.isUILandscape) {
            str = "1";
        } else {
            str = "0";
        }
        f16.B(str);
        aVar.i(eventId, f16.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean xa() {
        int i3;
        AudienceRoomInfo b16;
        ArrayList<com.tencent.mobileqq.qqlive.sail.model.audience.a> t16;
        if (!R9()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", not entered room");
            return false;
        }
        long h16 = ct3.a.h(Ea(), M9());
        a.Companion companion = com.tencent.timi.game.liveroom.impl.room.definition.a.INSTANCE;
        if (h16 >= companion.a().getMaxDayShowCount()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", max tip show count");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - ct3.a.h("last_notify_tips_time", M9());
        if (currentTimeMillis < companion.a().getNotifySwitchTime()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", in show interval, " + currentTimeMillis);
            return false;
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ca = Ca();
        if (Ca != null && (b16 = Ca.b()) != null && (t16 = b16.t()) != null) {
            i3 = t16.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 1) {
            AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", no enough definition size, " + i3);
            return false;
        }
        StreamDefinition O1 = Ba().O1();
        if (O1.getValue() < StreamDefinition.HD.getValue()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", no lower definition, " + O1);
            return false;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "checkNeedShowTip", "roomId=" + H9() + ", can show tip");
        return true;
    }

    private final void za() {
        com.tencent.mobileqq.qqlive.widget.bubble.d dVar = this.funcBubbleTip;
        if (dVar != null) {
            dVar.d();
        }
        Job job = this.showTipsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        com.tencent.mobileqq.qqlive.sail.room.e Ca = Ca();
        if (Ca != null) {
            Ca.w(this);
        }
    }

    @Override // mi2.a
    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "onStartBuffer", "roomId=" + H9());
        this.startBufferTimestamp = SystemClock.elapsedRealtime();
        Ga(((long) com.tencent.timi.game.liveroom.impl.room.definition.a.INSTANCE.a().getCheckBufferTime()) * 1);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.U9();
        com.tencent.mobileqq.qqlive.sail.room.e Ca = Ca();
        if (Ca != null) {
            Ca.registerBufferListener(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.V9();
            za();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isUILandscape = z16;
        }
        com.tencent.mobileqq.qqlive.widget.bubble.d dVar = this.funcBubbleTip;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> X1 = Aa().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean expand2) {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) expand2);
                    return;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                long H9 = QQLiveDefinitionTipsPart.this.H9();
                z16 = QQLiveDefinitionTipsPart.this.showTipWhenLandscape;
                companion.i("Audience|QQLiveDefinitionTipsPart", "bottomExpandChanged", "roomId=" + H9 + ", expand=" + expand2 + ", showTip=" + z16);
                Intrinsics.checkNotNullExpressionValue(expand2, "expand");
                if (expand2.booleanValue()) {
                    z17 = QQLiveDefinitionTipsPart.this.showTipWhenLandscape;
                    if (z17) {
                        QQLiveDefinitionTipsPart.this.Ka();
                        QQLiveDefinitionTipsPart.this.showTipWhenLandscape = false;
                        return;
                    }
                }
                com.tencent.mobileqq.qqlive.widget.bubble.d dVar = QQLiveDefinitionTipsPart.this.funcBubbleTip;
                if (dVar != null) {
                    dVar.d();
                }
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveDefinitionTipsPart.Ha(Function1.this, obj);
            }
        });
        LiveData<ar4.a> S1 = Aa().S1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<ar4.a, Unit> function12 = new Function1<ar4.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$onPartCreate$2$1", f = "QQLiveDefinitionTipsPart.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart$onPartCreate$2$1, reason: invalid class name */
            /* loaded from: classes17.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ ar4.a $it;
                int label;
                final /* synthetic */ QQLiveDefinitionTipsPart this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(QQLiveDefinitionTipsPart qQLiveDefinitionTipsPart, ar4.a aVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = qQLiveDefinitionTipsPart;
                    this.$it = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, qQLiveDefinitionTipsPart, aVar, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    boolean xa5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            xa5 = this.this$0.xa();
                            if (xa5) {
                                QQLiveDefinitionTipsPart qQLiveDefinitionTipsPart = this.this$0;
                                ar4.a it = this.$it;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                qQLiveDefinitionTipsPart.Ja(it);
                                long tipsShowTime = com.tencent.timi.game.liveroom.impl.room.definition.a.INSTANCE.a().getTipsShowTime() * 1;
                                this.label = 1;
                                if (DelayKt.delay(tipsShowTime, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        com.tencent.mobileqq.qqlive.widget.bubble.d dVar = this.this$0.funcBubbleTip;
                        if (dVar != null) {
                            dVar.d();
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveDefinitionTipsPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ar4.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ar4.a aVar) {
                Job job;
                Job launch$default;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (Intrinsics.areEqual(aVar.f26810a, "switch_definition")) {
                    job = QQLiveDefinitionTipsPart.this.showTipsJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    QQLiveDefinitionTipsPart qQLiveDefinitionTipsPart = QQLiveDefinitionTipsPart.this;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new AnonymousClass1(QQLiveDefinitionTipsPart.this, aVar, null), 3, null);
                    qQLiveDefinitionTipsPart.showTipsJob = launch$default;
                }
            }
        };
        S1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.definition.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveDefinitionTipsPart.Ia(Function1.this, obj);
            }
        });
    }

    @Override // mi2.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.startBufferTimestamp;
        AegisLogger.INSTANCE.i("Audience|QQLiveDefinitionTipsPart", "onStartBuffer", "roomId=" + H9() + ", bufferCost=" + elapsedRealtime);
        Job job = this.showTipsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (this.startBufferTimestamp > 0 && elapsedRealtime >= com.tencent.timi.game.liveroom.impl.room.definition.a.INSTANCE.a().getCheckBufferTime()) {
            Ga(0L);
        }
    }
}
