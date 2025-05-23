package com.tencent.timi.game.liveroom.impl.room.userlevel;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanel;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserPayLevelData;
import com.tencent.timi.game.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/b;", "", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "userPayLevelData", "", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;", "userPayLevelView", "j", "", "addGold", "i", "e", "l", "", "fromBatchGift", "c", "goldCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftData", "", "d", "f", "a", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;", "giftPanelUserPayLevelView", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "b", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "userLevelChangedListener", "Z", "fromSendBatchGift", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftPanelUserPayLevelView giftPanelUserPayLevelView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h userLevelChangedListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean fromSendBatchGift;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/userlevel/b$b", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "userPayLevelData", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.userlevel.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9956b implements h {
        C9956b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.userlevel.h
        public void a(@NotNull UserPayLevelData userPayLevelData) {
            Intrinsics.checkNotNullParameter(userPayLevelData, "userPayLevelData");
            b.this.g(userPayLevelData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(UserPayLevelData userPayLevelData) {
        if (!this.fromSendBatchGift) {
            l();
        }
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null) {
            giftPanelUserPayLevelView.setUserPayLevelData(userPayLevelData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!o.a()) {
            TimiGiftPanel.INSTANCE.c();
            j.f378617a.a(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c(boolean fromBatchGift) {
        this.fromSendBatchGift = fromBatchGift;
        i.e(i.f378614a, null, 1, null);
    }

    public final int d(@NotNull com.tencent.mobileqq.qqgift.data.service.d giftData) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        String userLevel = giftData.f264873c0;
        try {
            Intrinsics.checkNotNullExpressionValue(userLevel, "userLevel");
            return Integer.parseInt(userLevel);
        } catch (NumberFormatException unused) {
            AegisLogger.INSTANCE.i("Gift|GiftPanelUserPayLevelController", "\u89e3\u6790\u793c\u7269UserLevel\u5b57\u6bb5\u9519\u8bef:" + userLevel);
            return 0;
        }
    }

    public final void e() {
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null) {
            giftPanelUserPayLevelView.setVisibility(8);
        }
    }

    public final boolean f(@NotNull com.tencent.mobileqq.qqgift.data.service.d giftData) {
        long j3;
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        String userLevel = giftData.f264873c0;
        try {
            Intrinsics.checkNotNullExpressionValue(userLevel, "userLevel");
            int parseInt = Integer.parseInt(userLevel);
            UserPayLevelData g16 = i.f378614a.g();
            if (g16 != null) {
                j3 = g16.getCurPayLevel();
            } else {
                j3 = 0;
            }
            if (j3 < parseInt) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            AegisLogger.INSTANCE.i("Gift|GiftPanelUserPayLevelController", "\u89e3\u6790\u793c\u7269UserLevel\u5b57\u6bb5\u9519\u8bef:" + userLevel);
            return false;
        }
    }

    public final void h() {
        h hVar = this.userLevelChangedListener;
        if (hVar != null) {
            i.f378614a.j(hVar);
        }
        this.userLevelChangedListener = null;
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null) {
            giftPanelUserPayLevelView.release();
        }
        this.giftPanelUserPayLevelView = null;
    }

    public final void i(long addGold) {
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null) {
            giftPanelUserPayLevelView.setAddGoldCount(addGold);
        }
    }

    public final void j(@NotNull final Activity activity, @NotNull GiftPanelUserPayLevelView userPayLevelView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userPayLevelView, "userPayLevelView");
        this.giftPanelUserPayLevelView = userPayLevelView;
        if (userPayLevelView != null) {
            userPayLevelView.setUserLevelRightClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.k(activity, view);
                }
            });
        }
        i iVar = i.f378614a;
        UserPayLevelData g16 = iVar.g();
        if (g16 == null) {
            e();
        } else {
            g(g16);
        }
        if (this.userLevelChangedListener == null) {
            this.userLevelChangedListener = new C9956b();
        }
        h hVar = this.userLevelChangedListener;
        if (hVar != null) {
            iVar.i(hVar);
        }
        c(this.fromSendBatchGift);
    }

    public final void l() {
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null) {
            giftPanelUserPayLevelView.setVisibility(0);
        }
    }

    public final void m(long goldCount) {
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = this.giftPanelUserPayLevelView;
        if (giftPanelUserPayLevelView != null && giftPanelUserPayLevelView.getVisibility() == 0) {
            giftPanelUserPayLevelView.M0(goldCount);
        }
    }
}
