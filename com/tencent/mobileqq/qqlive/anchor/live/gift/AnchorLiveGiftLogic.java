package com.tencent.mobileqq.qqlive.anchor.live.gift;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.b;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.timi.game.liveroom.impl.room.manager.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nh2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nJ&\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"`#H\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/gift/AnchorLiveGiftLogic;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftEvent;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "message", "", "d", "k", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "animTotalData", "", "e", "Lnh2/c;", "c", "b", "landscape", h.F, "", "roomId", "", "roomType", "isAnchor", "anchorUid", "f", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "i", "Landroid/widget/FrameLayout;", "j", "g", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "J", "I", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "giftAnimationEngine", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "giftBannerContainer", "D", "Landroid/widget/FrameLayout;", "giftEffectContainer", "Lcom/tencent/mobileqq/qqlive/anchor/live/gift/a;", "E", "Lcom/tencent/mobileqq/qqlive/anchor/live/gift/a;", "giftPushMgr", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AnchorLiveGiftLogic implements SimpleEventReceiver<TimiGiftEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout giftBannerContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout giftEffectContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a giftPushMgr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long anchorUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b giftAnimationEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/gift/AnchorLiveGiftLogic$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.gift.AnchorLiveGiftLogic$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AnchorLiveGiftLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.giftPushMgr = new a();
        }
    }

    private final boolean b() {
        if (!this.isAnchor && this.isLandscape) {
            return com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a.b();
        }
        return true;
    }

    private final c c() {
        c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneIdByRoomType(this.roomType));
        Intrinsics.checkNotNullExpressionValue(sDKImpl, "api(IQQGiftManager::clas\u2026java).getSDKImpl(sceneId)");
        return sDKImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(GiftMessage message) {
        if (message == null) {
            AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "handleGiftMessage", "invalid message");
            return;
        }
        if (message.sender == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "handleGiftMessage", "sender is self");
            return;
        }
        if (message.comboOver) {
            AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "handleGiftMessage", "comboOver, giftId=" + message.giftID + ", giftName=" + message.giftName);
            return;
        }
        k(message);
    }

    private final boolean e(com.tencent.mobileqq.qqgift.mvvm.business.anim.a animTotalData) {
        int i3;
        int i16;
        if (animTotalData.f264924o != 1 || (i3 = animTotalData.f264915f) > 5 || (i16 = animTotalData.f264926q) <= 1 || i16 < i3) {
            return false;
        }
        return true;
    }

    private final void k(GiftMessage message) {
        if (this.giftAnimationEngine == null) {
            AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "unpackGiftMessage", "invalid engine");
            return;
        }
        if (!b()) {
            return;
        }
        if (!this.isAnchor) {
            message.senderNick = e.INSTANCE.a().b(this.roomId, message.senderNick, message.sender, this.anchorUid);
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a a16 = oj4.a.a(message);
        if (a16 == null) {
            return;
        }
        a16.f264931v = pk4.b.z(message.giftID);
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, "");
        if (!e(a16)) {
            b bVar = this.giftAnimationEngine;
            if (bVar != null) {
                bVar.d(a16);
                return;
            }
            return;
        }
        for (int i3 = a16.f264915f - 1; -1 < i3; i3--) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a a17 = oj4.a.a(message);
            if (a17 != null) {
                a17.f264915f = 1;
                int i16 = a17.f264926q - i3;
                a17.f264926q = i16;
                a17.f264928s = i16;
                b bVar2 = this.giftAnimationEngine;
                if (bVar2 != null) {
                    bVar2.d(a17);
                }
            }
        }
    }

    public final void f(long roomId, int roomType, boolean isAnchor, long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Integer.valueOf(roomType), Boolean.valueOf(isAnchor), Long.valueOf(anchorUid));
            return;
        }
        this.roomId = roomId;
        this.roomType = roomType;
        this.isAnchor = isAnchor;
        this.anchorUid = anchorUid;
        c c16 = c();
        AegisLogger.INSTANCE.d("Open_Live|AnchorLiveGiftLogic", "[onEnterRoom] isSDKInited=" + c16.isInited() + ", isSDKDestroyed=" + c16.isDestroyed());
        if (c16.isInited() && !c16.isDestroyed()) {
            b A = c16.d().A(BaseApplication.getContext(), 1);
            this.giftAnimationEngine = A;
            if (A != null) {
                A.prepare();
            }
            SimpleEventBus.getInstance().registerReceiver(this);
            if (this.giftBannerContainer != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.bottomMargin = wi2.c.b(8);
                LinearLayout linearLayout = this.giftBannerContainer;
                Intrinsics.checkNotNull(linearLayout);
                b bVar = this.giftAnimationEngine;
                Intrinsics.checkNotNull(bVar);
                linearLayout.addView(bVar.i(), marginLayoutParams);
                LinearLayout linearLayout2 = this.giftBannerContainer;
                Intrinsics.checkNotNull(linearLayout2);
                b bVar2 = this.giftAnimationEngine;
                Intrinsics.checkNotNull(bVar2);
                linearLayout2.addView(bVar2.b(), new ViewGroup.MarginLayoutParams(-2, -2));
            }
            if (this.giftEffectContainer != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                FrameLayout frameLayout = this.giftEffectContainer;
                Intrinsics.checkNotNull(frameLayout);
                b bVar3 = this.giftAnimationEngine;
                Intrinsics.checkNotNull(bVar3);
                frameLayout.addView(bVar3.k(), layoutParams);
            }
            this.giftPushMgr.a(roomId, new Function1<GiftMessage, Unit>() { // from class: com.tencent.mobileqq.qqlive.anchor.live.gift.AnchorLiveGiftLogic$onEnterRoom$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnchorLiveGiftLogic.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GiftMessage giftMessage) {
                    invoke2(giftMessage);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GiftMessage giftMessage) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        AnchorLiveGiftLogic.this.d(giftMessage);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) giftMessage);
                    }
                }
            });
            pk4.b.H(roomType);
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("Open_Live|AnchorLiveGiftLogic", 1, "onExitRoom");
        this.roomId = 0L;
        this.giftPushMgr.b();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        b bVar = this.giftAnimationEngine;
        if (bVar != null) {
            bVar.release();
        }
        this.giftAnimationEngine = null;
        LinearLayout linearLayout = this.giftBannerContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<TimiGiftEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<Class<TimiGiftEvent>> arrayList = new ArrayList<>();
        arrayList.add(TimiGiftEvent.class);
        return arrayList;
    }

    public final void h(boolean landscape) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, landscape);
            return;
        }
        this.isLandscape = landscape;
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (this.isLandscape && !com.tencent.timi.game.liveroom.impl.room.util.a.b(BaseApplication.context, screenWidth, screenHeight)) {
            FrameLayout frameLayout = this.giftEffectContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            if (!b() && (bVar = this.giftAnimationEngine) != null) {
                bVar.reset();
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.giftEffectContainer;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
    }

    public final void i(@Nullable LinearLayout container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) container);
        } else {
            this.giftBannerContainer = container;
        }
    }

    public final void j(@Nullable FrameLayout container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) container);
        } else {
            this.giftEffectContainer = container;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TimiGiftEvent) {
            TimiGiftEvent timiGiftEvent = (TimiGiftEvent) event;
            if (this.roomId != timiGiftEvent.getRoomId()) {
                AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "onReceiveEvent", "not the same room, " + this.roomId + ", " + timiGiftEvent.getRoomId());
                return;
            }
            if (!b()) {
                AegisLogger.INSTANCE.w("Open_Live|AnchorLiveGiftLogic", "onReceiveEvent", "cannot show gift, isAnchor=" + this.isAnchor + ", isLandscape=" + this.isLandscape);
                return;
            }
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, String.valueOf(timiGiftEvent.getSceneId()));
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a a16 = oj4.a.a(timiGiftEvent.getGiftMsg());
            if (a16 != null) {
                if (!a16.f264933x) {
                    a16.f264919j = e.INSTANCE.a().b(this.roomId, timiGiftEvent.getGiftMsg().senderNick, timiGiftEvent.getGiftMsg().sender, this.anchorUid);
                    a16.f264931v = pk4.b.z(a16.f264910a);
                }
                a16.f264916g = 100;
                b bVar = this.giftAnimationEngine;
                if (bVar != null) {
                    bVar.d(a16);
                }
            }
        }
    }
}
