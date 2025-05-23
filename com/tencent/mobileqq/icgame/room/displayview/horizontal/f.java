package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.view.View;
import android.widget.ImageView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/f;", "Ly22/a;", "Lw42/e;", "msg", "", "j", "k", "o", "", DomainData.DOMAIN_NAME, "", "roomId", "i", "g", "e", "f", "d", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "a", tl.h.F, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "danmuIconHor", "Lfv0/a;", "b", "Lfv0/a;", "danmakuView", "Lfu0/c;", "c", "Lfu0/c;", "liveRoomService", "J", "Z", "isDanmuOpen", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "configHorDamuOpen", "isHorUI", "<init>", "(Landroid/widget/ImageView;Lfv0/a;Lfu0/c;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f implements y22.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView danmuIconHor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fv0.a danmakuView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu0.c liveRoomService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDanmuOpen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean configHorDamuOpen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isHorUI;

    public f(@NotNull ImageView danmuIconHor, @NotNull fv0.a danmakuView, @NotNull fu0.c liveRoomService) {
        Intrinsics.checkNotNullParameter(danmuIconHor, "danmuIconHor");
        Intrinsics.checkNotNullParameter(danmakuView, "danmakuView");
        Intrinsics.checkNotNullParameter(liveRoomService, "liveRoomService");
        this.danmuIconHor = danmuIconHor;
        this.danmakuView = danmakuView;
        this.liveRoomService = liveRoomService;
        this.isDanmuOpen = rx0.a.b("dan_mu_key", true);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        IAegisLogApi iAegisLogApi = (IAegisLogApi) api;
        this.mAegisLog = iAegisLogApi;
        this.configHorDamuOpen = true;
        iAegisLogApi.i("ICGameHorDanmakuController", 1, "constructor, isDanmuOpen " + this.isDanmuOpen);
        danmakuView.f(n());
        o();
        danmuIconHor.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.c(f.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(w42.e msg2) {
        if (QLog.isColorLevel()) {
            this.mAegisLog.i("ICGameHorDanmakuController", 2, "onNewMsg: " + msg2);
        }
        long j3 = msg2.c().mSpeakId;
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        boolean z16 = false;
        if (selfUserInfo != null && selfUserInfo.uid == j3) {
            z16 = true;
        }
        if (!z16) {
            this.danmakuView.i(msg2.message());
        } else {
            this.danmakuView.g(msg2.message());
        }
    }

    private final void k() {
        boolean z16 = !this.isDanmuOpen;
        this.isDanmuOpen = z16;
        this.mAegisLog.i("ICGameHorDanmakuController", 1, "onShowDanmakuIconClick, new danmaku state " + z16);
        rx0.a.h("dan_mu_key", this.isDanmuOpen);
        this.danmakuView.f(n());
        o();
    }

    private final boolean n() {
        if (this.configHorDamuOpen && this.isDanmuOpen && this.isHorUI) {
            return true;
        }
        return false;
    }

    private final void o() {
        int i3;
        ImageView imageView = this.danmuIconHor;
        if (this.isDanmuOpen) {
            i3 = R.drawable.ova;
        } else {
            i3 = R.drawable.ov_;
        }
        imageView.setImageResource(i3);
    }

    @Override // y22.a
    public void a(@Nullable LiveMessageData msg2) {
        if (msg2 == null) {
            this.mAegisLog.e("ICGameHorDanmakuController", 1, "onReceive null msg");
        } else {
            j(new w42.h(msg2));
        }
    }

    public final void d() {
        this.danmakuView.h();
    }

    public final void e() {
        this.danmakuView.d();
    }

    public final void f() {
        this.danmakuView.e();
    }

    public final void g() {
        ILiveRoomMessage k3 = this.liveRoomService.k(this.roomId);
        if (k3 != null) {
            k3.unRegisterRoomChatMsgListener(this);
        }
    }

    public final void h(long roomId) {
        this.configHorDamuOpen = true;
        this.mAegisLog.i("ICGameHorDanmakuController", "configHorDamuOpen:true");
        this.danmakuView.f(n());
    }

    public final void i(long roomId) {
        this.roomId = roomId;
        ILiveRoomMessage k3 = this.liveRoomService.k(roomId);
        if (k3 != null) {
            k3.registerRoomChatMsgListener(this);
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameHorDanmakuController", 1, "onEnterRoom, register chat msg");
        }
    }

    public final void l() {
        this.mAegisLog.i("ICGameHorDanmakuController", 1, "onShowHorUI");
        this.isHorUI = true;
        this.danmakuView.f(n());
    }

    public final void m() {
        this.mAegisLog.i("ICGameHorDanmakuController", 1, "onShowVerUI");
        this.isHorUI = false;
        this.danmakuView.f(false);
    }
}
