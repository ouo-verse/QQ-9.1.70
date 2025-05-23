package com.tencent.timi.game.expand.hall.impl.mic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicApplyEntranceView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.m;
import com.tencent.timi.game.utils.o;
import fm4.k;
import gh4.e;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import nh4.g;
import nr2.ag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ph4.f;
import pl4.d;
import th4.i;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;
import ug4.b;
import wf4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0018\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView;", "Landroid/widget/FrameLayout;", "", "", h.F, "e", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "applyTime", "g", "j", "i", "k", "roomId", "setData", "f", "Lnr2/ag;", "d", "Lnr2/ag;", "binding", "J", "mRoomId", "mLastApplyTime", "com/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView$b", "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView$b;", "mListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MicApplyEntranceView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ag binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mLastApplyTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView$b", "Lfm4/k;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "applyTime", "", "u", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends k {
        b() {
        }

        @Override // fm4.k, fm4.q
        public void u(@NotNull CommonOuterClass$QQUserId uid, long applyTime) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            l.i("MicApplyEntranceView_", "onApplySpeaking uid:" + MobileQQ.getShortUinStr(uid.toString()) + ", applyTime:" + applyTime);
            MicApplyEntranceView.this.g(uid, applyTime);
            MicApplyEntranceView.this.mLastApplyTime = applyTime;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView$c", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f376914b;

        c(f fVar) {
            this.f376914b = fVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            a.f445618a.a(MicApplyEntranceView.this.getContext());
            l.c("MicApplyEntranceView_", 1, "onError timiErrCode:" + timiErrCode + " timiErrMsg:" + timiErrMsg + ", timiDisplayErrMsg:" + timiDisplayErrMsg);
            QQToast.makeText(MicApplyEntranceView.this.getContext(), timiDisplayErrMsg, 0).show();
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            a.f445618a.a(MicApplyEntranceView.this.getContext());
            Context context = MicApplyEntranceView.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            new g(context, this.f376914b).show();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyEntranceView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MicApplyEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("MicApplyEntranceView_")) {
            if (!m.a().b()) {
                com.tencent.timi.game.ui.widget.f.d(true, "\u7f51\u7edc\u51fa\u73b0\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u3002");
            } else {
                this$0.binding.f420803b.setVisibility(4);
                this$0.j();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        gh4.d m06 = I0.m0();
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, this, false, null, m06.p(), m06.E(), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(CommonOuterClass$QQUserId uid, long applyTime) {
        long j3 = this.mLastApplyTime;
        if (j3 != applyTime && j3 < applyTime) {
            this.mLastApplyTime = applyTime;
            this.binding.f420803b.setVisibility(0);
        }
    }

    private final void h() {
        e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            l.e("MicApplyEntranceView_", "refreshUI currentHall is null!");
            return;
        }
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(I0.O().f376303f);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026fo(launchParam.yesGameId)");
        i iVar = i.f436350a;
        String str = l16.room_info.mic_card_config.color_mic_item_nick_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "gameConfigInfo.room_info\u2026_mic_item_nick_name.get()");
        TextView textView = this.binding.f420805d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.onMicApplyHintTxv");
        iVar.d(str, textView);
        String str2 = l16.room_info.mic_card_config.icon_mic_apply_entrance.get();
        URLImageView uRLImageView = this.binding.f420804c;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.micApplyHintIgv");
        iVar.e(str2, uRLImageView);
    }

    private final void i() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.mRoomId).y(this.mListener);
    }

    private final void j() {
        f fVar = new f(this.mRoomId);
        a.f445618a.c(getContext());
        fVar.f(new c(fVar));
    }

    private final void k() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.mRoomId).Q(this.mListener);
    }

    public void f() {
        k();
    }

    public final void setData(long roomId) {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.mRoomId).Q(this.mListener);
        this.mRoomId = roomId;
        i();
        h();
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicApplyEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ag g16 = ag.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.mListener = new b();
        setOnClickListener(new View.OnClickListener() { // from class: qh4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicApplyEntranceView.b(MicApplyEntranceView.this, view);
            }
        });
    }
}
