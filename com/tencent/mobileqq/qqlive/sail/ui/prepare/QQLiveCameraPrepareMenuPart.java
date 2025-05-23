package com.tencent.mobileqq.qqlive.sail.ui.prepare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.room.anchorcenter.QQLiveAnchorCenterFragment;
import com.tencent.mobileqq.qqlive.room.prepare.event.DelMessageCenterRedPointEvent;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kl4.s;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nf4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0006H\u0002JJ\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J0\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\"\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%H\u0016R#\u0010.\u001a\n )*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u00103\u001a\n )*\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLiveCameraPrepareMenuPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Ia", "ua", "", "redPointTaskId", "sa", "(Ljava/lang/Long;)V", "xa", "", "resId", "", "isVisible", "", "elementId", "", "elementParams", "Landroid/view/View$OnClickListener;", "clickListener", "Ga", "Ja", "view", "ra", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "wa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "f", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "prepareViewModel", tl.h.F, "Landroid/view/View;", "redPointView", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCameraPrepareMenuPart extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy prepareViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View redPointView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLiveCameraPrepareMenuPart$a;", "", "", "QQ_LIVE_PROTOCOL_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLiveCameraPrepareMenuPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/prepare/QQLiveCameraPrepareMenuPart$b", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$b;", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "resolutionLevelType", "", "b", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "supportResolutionLevels", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements QQLivePrepareSettingDialog.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<ResolutionLevelType> supportResolutionLevels;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCameraPrepareMenuPart.this);
            } else {
                this.supportResolutionLevels = QQLiveCameraPrepareMenuPart.this.wa().c2();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog.b
        @NotNull
        public List<ResolutionLevelType> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.supportResolutionLevels;
        }

        @Override // com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog.b
        public void b(@NotNull ResolutionLevelType resolutionLevelType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) resolutionLevelType);
            } else {
                Intrinsics.checkNotNullParameter(resolutionLevelType, "resolutionLevelType");
                QQLiveCameraPrepareMenuPart.this.wa().m2(resolutionLevelType);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCameraPrepareMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLiveCameraPrepareMenuPart$roomViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraPrepareMenuPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RoomViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveCameraPrepareMenuPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.roomViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePrepareViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLiveCameraPrepareMenuPart$prepareViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraPrepareMenuPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQLivePrepareViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePrepareViewModel) QQLiveCameraPrepareMenuPart.this.getViewModel(QQLivePrepareViewModel.class) : (QQLivePrepareViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.prepareViewModel = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(QQLiveCameraPrepareMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wa().k2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(QQLiveCameraPrepareMenuPart this$0, View view) {
        Long l3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long G = com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
        s.Companion companion = kl4.s.INSTANCE;
        com.tencent.mobileqq.qqlive.sail.room.f a26 = this$0.wa().a2();
        if (a26 != null) {
            l3 = Long.valueOf(a26.getRoomId());
        } else {
            l3 = null;
        }
        companion.d(false, l3, Long.valueOf(G));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(QQLiveCameraPrepareMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.anchor.live.utils.c cVar = com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        cVar.f(activity, cVar.b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(QQLiveCameraPrepareMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.anchor.live.utils.c cVar = com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        cVar.e(activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(QQLiveCameraPrepareMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ja();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(QQLiveCameraPrepareMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getPartHost().getHostActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", ht3.a.d("qqlive_open_live_protocol_url", "https://qlive.qq.com/cos/live/h5/policys/index.html?_wv=2"));
        this$0.getPartHost().getHostActivity().startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ga(int resId, boolean isVisible, String elementId, Map<String, String> elementParams, View.OnClickListener clickListener) {
        View findViewById = getPartRootView().findViewById(resId);
        if (!isVisible) {
            findViewById.setVisibility(4);
            return;
        }
        if (elementId != null && !Intrinsics.areEqual(elementId, "em_qqlive_anchorcenter")) {
            Intrinsics.checkNotNullExpressionValue(findViewById, "this");
            ra(findViewById, elementId, elementParams);
        }
        findViewById.setOnClickListener(clickListener);
    }

    static /* synthetic */ void Ha(QQLiveCameraPrepareMenuPart qQLiveCameraPrepareMenuPart, int i3, boolean z16, String str, Map map, View.OnClickListener onClickListener, int i16, Object obj) {
        String str2;
        Map map2;
        View.OnClickListener onClickListener2;
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 4) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i16 & 8) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i16 & 16) != 0) {
            onClickListener2 = null;
        } else {
            onClickListener2 = onClickListener;
        }
        qQLiveCameraPrepareMenuPart.Ga(i3, z17, str2, map2, onClickListener2);
    }

    private final void Ia(View rootView) {
        this.redPointView = rootView.findViewById(R.id.f61332xu);
    }

    private final void Ja() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            new QQLivePrepareSettingDialog(hostFragment, ta().getRoomId(), new b()).show();
        }
    }

    private final void ra(View view, String elementId, Map<String, String> elementParams) {
        nf4.d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
        if (elementParams == null) {
            elementParams = new LinkedHashMap<>();
        }
        d.a.a(liveReportUtil, view, false, null, elementId, elementParams, 4, null);
    }

    private final void sa(Long redPointTaskId) {
        View findViewById = getPartRootView().findViewById(R.id.f61322xt);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (redPointTaskId != null) {
            long longValue = redPointTaskId.longValue();
            if (longValue != 0) {
                concurrentHashMap.put("qqlive_taskid", String.valueOf(longValue));
            }
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        ra(findViewById, "em_qqlive_anchorcenter", concurrentHashMap);
    }

    private final QQLivePrepareViewModel ta() {
        return (QQLivePrepareViewModel) this.prepareViewModel.getValue();
    }

    private final void ua() {
        MutableLiveData<Boolean> S1;
        AegisLogger.INSTANCE.d("Open_Live|QQLiveCameraPrepareMenuPart", "getRedPoint", "getRedPoint...");
        QQLivePrepareViewModel ta5 = ta();
        if (ta5 != null && (S1 = ta5.S1()) != null) {
            S1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveCameraPrepareMenuPart.va(QQLiveCameraPrepareMenuPart.this, (Boolean) obj);
                }
            });
        }
        QQLivePrepareViewModel ta6 = ta();
        if (ta6 != null) {
            ta6.R1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(QQLiveCameraPrepareMenuPart this$0, Boolean bool) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        QQLivePrepareViewModel ta5 = this$0.ta();
        Long l16 = null;
        if (ta5 != null) {
            l3 = Long.valueOf(ta5.T1());
        } else {
            l3 = null;
        }
        companion.i("Open_Live|QQLiveCameraPrepareMenuPart", "getRedPoint", "show:" + bool + " taskId:" + l3);
        if (bool != null && bool.booleanValue()) {
            View view = this$0.redPointView;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this$0.redPointView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        QQLivePrepareViewModel ta6 = this$0.ta();
        if (ta6 != null) {
            l16 = Long.valueOf(ta6.T1());
        }
        this$0.sa(l16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomViewModel wa() {
        return (RoomViewModel) this.roomViewModel.getValue();
    }

    private final void xa() {
        Map<String, String> mutableMapOf;
        Ha(this, R.id.f61322xt, false, "em_qqlive_anchorcenter", null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.za(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 10, null);
        Ha(this, R.id.f60372v9, false, null, null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Aa(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 14, null);
        kl4.s.INSTANCE.g();
        Ha(this, R.id.f60382v_, false, null, null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Ba(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 14, null);
        com.tencent.mobileqq.qqlive.anchor.live.utils.c cVar = com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a;
        Ha(this, R.id.f60402vb, cVar.d(), "em_qqlive_guide", null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Ca(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 8, null);
        boolean c16 = cVar.c();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("em_qqlive_guide_livestatus", "0"));
        Ga(R.id.f60352v7, c16, "em_qqlive_feedback", mutableMapOf, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Da(QQLiveCameraPrepareMenuPart.this, view);
            }
        });
        Ha(this, R.id.f61572yh, false, "em_qqlive_shopwindow_set", null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Ea(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 10, null);
        Ha(this, R.id.f60872wl, false, null, null, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveCameraPrepareMenuPart.Fa(QQLiveCameraPrepareMenuPart.this, view);
            }
        }, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(QQLiveCameraPrepareMenuPart this$0, View view) {
        String str;
        String str2;
        Boolean bool;
        long j3;
        MutableLiveData<Boolean> S1;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        com.tencent.mobileqq.qqlive.sail.room.f a26 = this$0.wa().a2();
        if (a26 == null || (str2 = Long.valueOf(a26.getRoomId()).toString()) == null) {
            str2 = "";
        }
        Intent intent = new Intent();
        QQLivePrepareViewModel ta5 = this$0.ta();
        if (ta5 == null || (S1 = ta5.S1()) == null || (bool = S1.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        intent.putExtra("param_message_red_point", bool.booleanValue());
        QQLivePrepareViewModel ta6 = this$0.ta();
        if (ta6 != null) {
            j3 = ta6.T1();
        } else {
            j3 = 0;
        }
        intent.putExtra("param_red_point_taskid", j3);
        QQLiveAnchorCenterFragment.INSTANCE.a(this$0.getPartHost().getHostActivity(), intent, str, str2);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(DelMessageCenterRedPointEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Ia(rootView);
        xa();
        ua();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        MutableLiveData<Boolean> S1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (event instanceof DelMessageCenterRedPointEvent) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveCameraPrepareMenuPart", "onReceiveEvent", "DelMessageCenterRedPointEvent");
            QQLivePrepareViewModel ta5 = ta();
            if (ta5 != null && (S1 = ta5.S1()) != null) {
                S1.postValue(Boolean.FALSE);
            }
        }
    }
}
