package com.tencent.mobileqq.qqlive.sail.ui.netstatus;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnNetworkQualityEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnStatisticsEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.view.systeminfo.AnchorLiveSystemInfoDetailView;
import com.tencent.timi.game.utils.o;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012`\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/netstatus/g;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnNetworkQualityEvent;", "event", "", "ra", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnStatisticsEvent;", "ta", "va", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "U9", "V9", "e", "Landroid/view/View;", "containerView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "textView", "Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveSystemInfoDetailView;", "i", "Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveSystemInfoDetailView;", "detailView", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "lastSystemInfo", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netEventHandler", "<init>", "()V", "D", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final INetEventHandler netEventHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView iconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorLiveSystemInfoDetailView detailView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorLiveSystemInfo lastSystemInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/netstatus/g$a;", "", "", "BAD_NETWORK_TIME_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.netstatus.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.netEventHandler = new INetEventHandler() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.c
                @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
                public final void onNetChangeEvent(boolean z16) {
                    g.oa(g.this, z16);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(g this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.va();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView = new AnchorLiveSystemInfoDetailView(context);
        this$0.detailView = anchorLiveSystemInfoDetailView;
        AnchorLiveSystemInfo anchorLiveSystemInfo = this$0.lastSystemInfo;
        if (anchorLiveSystemInfo != null) {
            anchorLiveSystemInfoDetailView.P0(anchorLiveSystemInfo, h.f272963a.c());
        }
        Context context2 = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView2 = this$0.detailView;
        com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
        hVar.t(false);
        hVar.v(-1);
        hVar.u(ImmersiveUtils.dpToPx(390.0f));
        hVar.x(true);
        hVar.q(R.style.b0e);
        Unit unit = Unit.INSTANCE;
        final PopupWindow g16 = com.tencent.timi.game.liveroom.impl.room.util.g.g(context2, anchorLiveSystemInfoDetailView2, hVar, null, 8, null);
        AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView3 = this$0.detailView;
        if (anchorLiveSystemInfoDetailView3 != null) {
            anchorLiveSystemInfoDetailView3.setOnCloseClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.qa(g16, view2);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(PopupWindow this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ra(OnNetworkQualityEvent event) {
        final int i3;
        Integer num;
        if (!Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID)) {
            return;
        }
        if (!o.f("onNetworkQualityChange", 60000L)) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            TRTCCloudDef.TRTCQuality localQuality = event.getLocalQuality();
            if (localQuality != null) {
                num = Integer.valueOf(localQuality.quality);
            } else {
                num = null;
            }
            companion.i("Open_Live|QQLiveNetStatusPart", "onNetworkQualityChange", "quality=" + num);
        }
        TRTCCloudDef.TRTCQuality localQuality2 = event.getLocalQuality();
        if (localQuality2 != null) {
            i3 = localQuality2.quality;
        } else {
            i3 = 0;
        }
        h.f272963a.d(i3);
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.a
            @Override // java.lang.Runnable
            public final void run() {
                g.sa(g.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(g this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Resources resources = this$0.getActivity().getResources();
        switch (i3) {
            case 0:
            case 1:
            case 2:
                ImageView imageView = this$0.iconView;
                if (imageView != null) {
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.o5w, null));
                }
                TextView textView = this$0.textView;
                if (textView != null) {
                    textView.setText(resources.getString(R.string.yvr));
                    return;
                }
                return;
            case 3:
            case 4:
                ImageView imageView2 = this$0.iconView;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.o5x, null));
                }
                TextView textView2 = this$0.textView;
                if (textView2 != null) {
                    textView2.setText(resources.getString(R.string.yvs));
                    return;
                }
                return;
            case 5:
            case 6:
                ImageView imageView3 = this$0.iconView;
                if (imageView3 != null) {
                    imageView3.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.o5y, null));
                }
                TextView textView3 = this$0.textView;
                if (textView3 != null) {
                    textView3.setText(resources.getString(R.string.yvt));
                }
                this$0.va();
                return;
            default:
                return;
        }
    }

    private final void ta(OnStatisticsEvent event) {
        TRTCStatistics statistic;
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && (statistic = event.getStatistic()) != null) {
            final AnchorLiveSystemInfo e16 = h.f272963a.e(statistic);
            this.lastSystemInfo = e16;
            if (e16 != null) {
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.ua(AnchorLiveSystemInfo.this, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(AnchorLiveSystemInfo info, g this$0) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.f("anchorLiveNetStatusTag", 60000L)) {
            AegisLogger.INSTANCE.i(AegisLogger.ROOM_INFO, "onAnchorLiveNetStatus", "\u4e0a\u4f20\u901f\u5ea6: " + info.getUpSourceSpeed() + ", \u76f4\u64ad\u5ef6\u8fdf: " + info.getGateWayRtt() + ", \u4e22\u5305\u7387: " + info.getUpSourceLoss() + ", CPU\u5360\u7528\u7387: " + info.getCpuStatus() + ", \u5185\u5b58\u5360\u7528\u7387: " + info.getMemoryRate());
        }
        AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView = this$0.detailView;
        if (anchorLiveSystemInfoDetailView != null) {
            anchorLiveSystemInfoDetailView.P0(info, h.f272963a.c());
        }
    }

    private final void va() {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.e
            @Override // java.lang.Runnable
            public final void run() {
                g.wa(g.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.f("netErrorToastTag", MiniBoxNoticeInfo.MIN_5)) {
            QQToast.makeText(this$0.getContext(), "\u5f53\u524d\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 0).show();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        AnchorRoomInfo anchorRoomInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        Unit unit = null;
        if (F9 != null) {
            com.tencent.mobileqq.qqlive.sail.model.d b16 = F9.b();
            if (b16 instanceof AnchorRoomInfo) {
                anchorRoomInfo = (AnchorRoomInfo) b16;
            } else {
                anchorRoomInfo = null;
            }
            if (anchorRoomInfo != null) {
                if (anchorRoomInfo.r().m() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    AegisLogger.INSTANCE.i("Open_Live|QQLiveNetStatusPart", "onEnterRoom", "obs room not show net status");
                    return;
                }
                startInit();
                AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this.netEventHandler);
                SimpleEventBus.getInstance().registerReceiver(this);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveNetStatusPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppNetConnInfo.unregisterNetEventHandler(this.netEventHandler);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        h.f272963a.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(OnNetworkQualityEvent.class);
        arrayList.add(OnStatisticsEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f61662yq;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        TextView textView = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f61662yq);
        } else {
            view = null;
        }
        this.containerView = view;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f61642yo);
        } else {
            imageView = null;
        }
        this.iconView = imageView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f61652yp);
        }
        this.textView = textView;
        View view2 = this.containerView;
        if (view2 != null) {
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, view2, false, null, "em_qqlive_network_status", null, 22, null);
        }
        View view3 = this.containerView;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.netstatus.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    g.pa(g.this, view4);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
        } else if (event instanceof OnNetworkQualityEvent) {
            ra((OnNetworkQualityEvent) event);
        } else if (event instanceof OnStatisticsEvent) {
            ta((OnStatisticsEvent) event);
        }
    }
}
