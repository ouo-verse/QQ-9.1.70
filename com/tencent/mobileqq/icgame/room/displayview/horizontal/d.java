package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.liveroom.impl.room.live.widget.HorBottomControllerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u001c\u0010)\u001a\n $*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/d;", "", "", DomainData.DOMAIN_NAME, "", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "forbidExpose", "l", "e", "k", "j", "i", "", "text", "o", "", "roomId", tl.h.F, "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "a", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "bottomControllerViewHor", "Landroid/view/View$OnClickListener;", "b", "Landroid/view/View$OnClickListener;", "shareClick", "c", "definitionClick", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "d", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "msgEvent", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/widget/ImageView;", "giftBulletSwitchIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "definitionTv", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "logger", "Z", "configHorChatOpen", "isHorUI", "<init>", "(Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HorBottomControllerView bottomControllerViewHor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener shareClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener definitionClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.icgame.liveroom.impl.room.live.widget.d msgEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView giftBulletSwitchIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView definitionTv;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean configHorChatOpen;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHorUI;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/d$a", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "", "text", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.icgame.liveroom.impl.room.live.widget.d {
        a() {
        }

        @Override // com.tencent.icgame.liveroom.impl.room.live.widget.d
        public void a(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            d.this.msgEvent.a(text);
            d.this.bottomControllerViewHor.L0();
        }
    }

    public d(@NotNull HorBottomControllerView bottomControllerViewHor, @NotNull View.OnClickListener shareClick, @NotNull View.OnClickListener definitionClick, @NotNull com.tencent.icgame.liveroom.impl.room.live.widget.d msgEvent) {
        Intrinsics.checkNotNullParameter(bottomControllerViewHor, "bottomControllerViewHor");
        Intrinsics.checkNotNullParameter(shareClick, "shareClick");
        Intrinsics.checkNotNullParameter(definitionClick, "definitionClick");
        Intrinsics.checkNotNullParameter(msgEvent, "msgEvent");
        this.bottomControllerViewHor = bottomControllerViewHor;
        this.shareClick = shareClick;
        this.definitionClick = definitionClick;
        this.msgEvent = msgEvent;
        ImageView imageView = (ImageView) bottomControllerViewHor.findViewById(R.id.f165363vo4);
        this.giftBulletSwitchIcon = imageView;
        TextView textView = (TextView) bottomControllerViewHor.findViewById(R.id.ufs);
        this.definitionTv = textView;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        this.configHorChatOpen = true;
        bottomControllerViewHor.S0(n());
        ((ImageView) bottomControllerViewHor.findViewById(R.id.f84134lf)).setOnClickListener(shareClick);
        bottomControllerViewHor.setLiveMsgEven(new a());
        textView.setOnClickListener(definitionClick);
        imageView.setVisibility(0);
        m();
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.b(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f() {
        hw0.a aVar = hw0.a.f406502a;
        aVar.b();
        m();
        if (aVar.c()) {
            ToastUtil.a().e(this.giftBulletSwitchIcon.getContext().getString(R.string.f227716rs));
        } else {
            ToastUtil.a().e(this.giftBulletSwitchIcon.getContext().getString(R.string.f158861qr));
        }
    }

    private final void m() {
        if (hw0.a.f406502a.c()) {
            this.giftBulletSwitchIcon.setImageResource(R.drawable.ov8);
        } else {
            this.giftBulletSwitchIcon.setImageResource(R.drawable.ov7);
        }
    }

    private final boolean n() {
        if (this.configHorChatOpen && this.isHorUI) {
            return true;
        }
        return false;
    }

    public final void e() {
        this.bottomControllerViewHor.G0();
    }

    public final int g() {
        return this.bottomControllerViewHor.J0();
    }

    public final void h(long roomId) {
        this.configHorChatOpen = true;
        this.logger.i("ICGameHorBottomViewController", "isHorChatOpen:true");
        this.bottomControllerViewHor.S0(n());
    }

    public final void i() {
        m();
        this.bottomControllerViewHor.P0();
        this.isHorUI = true;
        this.bottomControllerViewHor.S0(n());
    }

    public final void j() {
        this.bottomControllerViewHor.Q0();
        this.isHorUI = false;
        this.bottomControllerViewHor.S0(false);
    }

    public final void k() {
        this.bottomControllerViewHor.R0();
    }

    public final void l(boolean forbidExpose) {
        this.bottomControllerViewHor.setForbidExpose(forbidExpose);
    }

    public final void o(@Nullable String text) {
        if (text == null) {
            this.definitionTv.setVisibility(8);
            this.definitionTv.setText((CharSequence) null);
        } else {
            this.definitionTv.setVisibility(0);
            this.definitionTv.setText(text);
        }
    }
}
