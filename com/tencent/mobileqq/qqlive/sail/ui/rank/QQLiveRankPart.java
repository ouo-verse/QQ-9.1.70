package com.tencent.mobileqq.qqlive.sail.ui.rank;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanelEvent;
import com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveRoomOnlineRankView;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/rank/QQLiveRankPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "", LocaleUtils.L_JAPANESE, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "V9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "P6", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView;", "rankView", "<init>", "()V", "f", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRankPart extends c implements SimpleEventReceiver<SimpleBaseEvent>, SelfRankInfoView.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveRoomOnlineRankView rankView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/rank/QQLiveRankPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.rank.QQLiveRankPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveRankPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ja() {
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = this.rankView;
        if (qQLiveRoomOnlineRankView != null) {
            qQLiveRoomOnlineRankView.setOpenGiftPanelListener(null);
        }
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView2 = this.rankView;
        if (qQLiveRoomOnlineRankView2 != null) {
            qQLiveRoomOnlineRankView2.onExitRoom(H9());
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView.b
    public void P6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            ((GiftViewModel) getViewModel(GiftViewModel.class)).s2(true);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = this.rankView;
        if (qQLiveRoomOnlineRankView != null) {
            qQLiveRoomOnlineRankView.setContentByConfig(H9());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("room_info|QQLiveRankPart", "onEnterRoom", "roomId=" + H9());
        if (F9() != null) {
            startInit();
            QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = this.rankView;
            if (qQLiveRoomOnlineRankView != null) {
                long H9 = H9();
                qQLiveRoomOnlineRankView.onEnterRoom(H9, Q9());
                qQLiveRoomOnlineRankView.setAnchorId(C9());
                qQLiveRoomOnlineRankView.setRoomType(J9());
                qQLiveRoomOnlineRankView.setContentByConfig(H9);
                qQLiveRoomOnlineRankView.setOpenGiftPanelListener(this);
            }
            SimpleEventBus.getInstance().registerReceiver(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            companion.e("room_info|QQLiveRankPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ja();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TimiGiftEvent.class);
        arrayList.add(TimiGiftPanelEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.id.f61162xd;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = this.rankView;
                if (qQLiveRoomOnlineRankView != null) {
                    qQLiveRoomOnlineRankView.setVisibility(8);
                    return;
                }
                return;
            }
            QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView2 = this.rankView;
            if (qQLiveRoomOnlineRankView2 != null) {
                qQLiveRoomOnlineRankView2.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            qQLiveRoomOnlineRankView = (QQLiveRoomOnlineRankView) rootView.findViewById(R.id.f61152xc);
        } else {
            qQLiveRoomOnlineRankView = null;
        }
        this.rankView = qQLiveRoomOnlineRankView;
        if (qQLiveRoomOnlineRankView != null) {
            qQLiveRoomOnlineRankView.y();
        }
        RFWTypefaceUtil.preloadTypeface("https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        LiveData<Boolean> e26 = ((GiftViewModel) getViewModel(GiftViewModel.class)).e2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.rank.QQLiveRankPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRankPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                qQLiveRoomOnlineRankView2 = QQLiveRankPart.this.rankView;
                if (qQLiveRoomOnlineRankView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQLiveRoomOnlineRankView2.setGiftEnableBtn(it.booleanValue());
                }
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.rank.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveRankPart.la(Function1.this, obj);
            }
        });
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

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView;
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TimiGiftEvent) {
            if (H9() != ((TimiGiftEvent) event).getRoomId() && (qQLiveRoomOnlineRankView2 = this.rankView) != null) {
                qQLiveRoomOnlineRankView2.H(false);
                return;
            }
            return;
        }
        if ((event instanceof TimiGiftPanelEvent) && ((TimiGiftPanelEvent) event).getCmd() == 1 && (qQLiveRoomOnlineRankView = this.rankView) != null) {
            qQLiveRoomOnlineRankView.x();
        }
    }
}
