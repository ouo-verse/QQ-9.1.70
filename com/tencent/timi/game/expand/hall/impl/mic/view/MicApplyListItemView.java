package com.tencent.timi.game.expand.hall.impl.mic.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicApplyListItemView;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.g;
import gh4.d;
import gh4.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.ah;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh4.a;
import th4.k;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$ApplyUser;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView;", "Landroid/widget/FrameLayout;", "", "l", "", "errorCode", "", "j", "", "i", com.tencent.luggage.wxa.c8.c.G, "", "roomId", "Ltrpc/yes/common/YoloRoomOuterClass$ApplyUser;", "applyUser", "k", "Lqh4/a;", "op", "setApplyListOp", "Landroid/app/Dialog;", "dialog", h.F, "d", "Ltrpc/yes/common/YoloRoomOuterClass$ApplyUser;", "mData", "e", "J", "mRoomId", "f", "Landroid/app/Dialog;", "mBindingDialog", "I", "mCurrentPos", "Lqh4/a;", "mMicApplyListOp", "Lnr2/ah;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnr2/ah;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MicApplyListItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private YoloRoomOuterClass$ApplyUser mData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mBindingDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mMicApplyListOp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ah binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            wf4.a.f445618a.b(MicApplyListItemView.this.mBindingDialog);
            l.h("MicApplyListItemView_", 1, "reject succeed!");
            f.a(WinkBaseErrorCodeKt.ERROR_MSG_OK);
            a aVar = MicApplyListItemView.this.mMicApplyListOp;
            if (aVar != null) {
                aVar.x(MicApplyListItemView.this.mData);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            a aVar;
            wf4.a.f445618a.b(MicApplyListItemView.this.mBindingDialog);
            l.c("MicApplyListItemView_", 1, "reject failed, " + errorCode + ", " + errorMessage);
            if (MicApplyListItemView.this.j(errorCode) && (aVar = MicApplyListItemView.this.mMicApplyListOp) != null) {
                aVar.x(MicApplyListItemView.this.mData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicApplyListItemView$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            wf4.a.f445618a.b(MicApplyListItemView.this.mBindingDialog);
            l.h("MicApplyListItemView_", 1, "agree succeed!");
            f.a(WinkBaseErrorCodeKt.ERROR_MSG_OK);
            a aVar = MicApplyListItemView.this.mMicApplyListOp;
            if (aVar != null) {
                aVar.x(MicApplyListItemView.this.mData);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            a aVar;
            wf4.a.f445618a.b(MicApplyListItemView.this.mBindingDialog);
            l.c("MicApplyListItemView_", 1, "agree failed, " + errorCode + ", " + errorMessage);
            if (MicApplyListItemView.this.j(errorCode) && (aVar = MicApplyListItemView.this.mMicApplyListOp) != null) {
                aVar.x(MicApplyListItemView.this.mData);
            }
            e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 == null) {
                return;
            }
            HashMap<String, String> E = I0.m0().E();
            E.put("yes_to_uid", String.valueOf(MicApplyListItemView.this.mData.user_id.uid.get()));
            E.put("yes_to_yes_uid", nn4.a.a(MicApplyListItemView.this.mData.user_id.yes_uid.get()));
            if (errorMessage == null) {
                errorMessage = "";
            }
            E.put("yes_fail_reason", errorMessage);
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_approve_fail", E);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyListItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String i() {
        long serverTimeMillis = (NetConnInfoCenter.getServerTimeMillis() - this.mData.apply_time_ms.get()) / 1000;
        if (serverTimeMillis < 60) {
            return "\u521a\u521a";
        }
        long j3 = 60;
        long j16 = serverTimeMillis / j3;
        if (j16 < 60) {
            return j16 + "\u5206\u949f\u524d";
        }
        long j17 = j16 / j3;
        if (j17 < 24) {
            return j17 + "\u5c0f\u65f6\u524d";
        }
        return "\u66f4\u65e9\u4e9b\u65f6\u5019";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(int errorCode) {
        if (errorCode != 0) {
            switch (errorCode) {
                case 920027:
                case 920028:
                case 920029:
                case 920030:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private final void l() {
        this.binding.f420809d.setNeedDrawSex(true);
        this.binding.f420809d.setUserId(this.mData.user_id.get());
        this.binding.f420809d.setOnClickListener(new View.OnClickListener() { // from class: qh4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicApplyListItemView.m(MicApplyListItemView.this, view);
            }
        });
        this.binding.f420811f.setUserId(this.mData.user_id.get());
        this.binding.f420810e.setOnClickListener(new View.OnClickListener() { // from class: qh4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicApplyListItemView.n(MicApplyListItemView.this, view);
            }
        });
        this.binding.f420807b.setOnClickListener(new View.OnClickListener() { // from class: qh4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicApplyListItemView.o(MicApplyListItemView.this, view);
            }
        });
        this.binding.f420808c.setText(i());
        e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        d m06 = I0.m0();
        HashMap<String, String> E = m06.E();
        E.put("yes_to_uid", String.valueOf(this.mData.user_id.uid.get()));
        E.put("yes_to_yes_uid", nn4.a.a(this.mData.user_id.yes_uid.get()));
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        TextView textView = this.binding.f420807b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.agreeTxv");
        b.a.a((ug4.b) b16, textView, false, null, m06.s(), E, 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        TextView textView2 = this.binding.f420810e;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ignoreTxv");
        b.a.a((ug4.b) b17, textView2, false, null, m06.t(), E, 6, null);
        mm4.a b18 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(IReportService::class.java)");
        AvatarRoundImageView avatarRoundImageView = this.binding.f420809d;
        Intrinsics.checkNotNullExpressionValue(avatarRoundImageView, "binding.avatarView");
        b.a.a((ug4.b) b18, avatarRoundImageView, false, null, m06.u(), E, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MicApplyListItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k kVar = k.f436355a;
        QBaseActivity b16 = vf4.a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.mData.user_id.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "mData.user_id.get()");
        kVar.e(b16, commonOuterClass$QQUserId, this$0.mRoomId);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MicApplyListItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wf4.a.f445618a.e(this$0.mBindingDialog);
        ((g) mm4.b.b(g.class)).A(this$0.mRoomId).c(this$0.mData.user_id, new b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MicApplyListItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wf4.a.f445618a.e(this$0.mBindingDialog);
        ((g) mm4.b.b(g.class)).A(this$0.mRoomId).F(this$0.mData.user_id, new c());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void h(@NotNull Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.mBindingDialog = dialog;
    }

    public final void k(int pos, long roomId, @NotNull YoloRoomOuterClass$ApplyUser applyUser) {
        Intrinsics.checkNotNullParameter(applyUser, "applyUser");
        this.mCurrentPos = pos;
        this.mData = applyUser;
        this.mRoomId = roomId;
        l();
    }

    public final void setApplyListOp(@NotNull a op5) {
        Intrinsics.checkNotNullParameter(op5, "op");
        this.mMicApplyListOp = op5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyListItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicApplyListItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicApplyListItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new YoloRoomOuterClass$ApplyUser();
        ah g16 = ah.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }
}
