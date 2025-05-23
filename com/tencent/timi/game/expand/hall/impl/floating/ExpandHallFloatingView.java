package com.tencent.timi.game.expand.hall.impl.floating;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.app.event.TGDialogHelpCloseEvent;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import fm4.k;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
import ug4.b;
import uh4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00017\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/floating/ExpandHallFloatingView;", "Landroid/widget/FrameLayout;", "Luh4/d;", "", ReportConstant.COSTREPORT_PREFIX, "", "roomId", "Lcom/tencent/timi/game/ui/widget/e;", "dialog", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "B", "r", "u", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/ConcurrentHashMap;", "", "t", "v", "onShow", "Luh4/b;", "a", "onHide", "b", "e", "Landroid/view/View;", "getView", "Luh4/c;", "f", "onBackground", "d", "Ljava/lang/Object;", "obj", "setLaunchParam", "J", "getRoomId", "()J", "setRoomId", "(J)V", "", "Z", "isInMic", "isMicOpen", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", h.F, "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "expandHallLaunchParam", "i", "Luh4/b;", "floatingAnimateInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dialogShowing", "Lnr2/y;", "Lnr2/y;", "binding", "com/tencent/timi/game/expand/hall/impl/floating/ExpandHallFloatingView$backgroundHeartBeat$1", "Lcom/tencent/timi/game/expand/hall/impl/floating/ExpandHallFloatingView$backgroundHeartBeat$1;", "backgroundHeartBeat", "Lfm4/k;", "E", "Lfm4/k;", "getCommonListener", "()Lfm4/k;", "setCommonListener", "(Lfm4/k;)V", "commonListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallFloatingView extends FrameLayout implements uh4.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final y binding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ExpandHallFloatingView$backgroundHeartBeat$1 backgroundHeartBeat;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private k commonListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isInMic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isMicOpen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallLaunchParam expandHallLaunchParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final uh4.b floatingAnimateInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean dialogShowing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/expand/hall/impl/floating/ExpandHallFloatingView$a", "Lfm4/k;", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfoList", "", "o", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends k {
        a() {
        }

        @Override // fm4.k, fm4.q
        public void o(@Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosInfoList) {
            super.o(speakingPosInfoList);
            ExpandHallFloatingView.this.B();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallFloatingView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ExpandHallFloatingView this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogShowing = false;
        SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        YoloRoomOuterClass$YoloRoomCommunityConf yoloRoomOuterClass$YoloRoomCommunityConf;
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
        PBStringField pBStringField;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n3;
        boolean z16;
        this.isInMic = false;
        this.isMicOpen = false;
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
        if (K0 != null && (n3 = K0.n()) != null) {
            for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : n3) {
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, E)) {
                    this.isInMic = true;
                    PBInt32Field pBInt32Field = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.voice_switch;
                    if (pBInt32Field != null && pBInt32Field.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.isMicOpen = true;
                    }
                }
            }
        }
        if (this.isInMic) {
            this.binding.f421166d.setVisibility(0);
            this.binding.f421167e.setVisibility(0);
            if (this.isMicOpen) {
                this.binding.f421167e.setImageResource(R.drawable.o7k);
            } else {
                this.binding.f421167e.setImageResource(R.drawable.o7j);
            }
        } else {
            this.binding.f421166d.setVisibility(8);
            this.binding.f421167e.setVisibility(8);
        }
        YoloRoomOuterClass$YoloRoomConf Y = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).Y();
        if (Y != null && (yoloRoomOuterClass$YoloRoomCommunityConf = Y.yolo_room_community_conf) != null && (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = yoloRoomOuterClass$YoloRoomCommunityConf.wuji_yolo_room_community_conf) != null && (pBStringField = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.room_pin_icon) != null) {
            this.binding.f421164b.setAvatarUrl(pBStringField.get());
        }
    }

    private final void C() {
        setVisibility(0);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(80), com.tencent.timi.game.utils.b.a(80));
    }

    private final void D() {
        uh4.b bVar = this.floatingAnimateInfo;
        Intrinsics.checkNotNullExpressionValue(this.binding.f421164b, "binding.avatar");
        bVar.g(fh4.g.h(r1) + (this.binding.f421164b.getWidth() * 0.5f));
        uh4.b bVar2 = this.floatingAnimateInfo;
        Intrinsics.checkNotNullExpressionValue(this.binding.f421164b, "binding.avatar");
        bVar2.h(fh4.g.j(r1) + (this.binding.f421164b.getHeight() * 0.5f));
        this.floatingAnimateInfo.j(this.binding.f421164b.getWidth());
        this.floatingAnimateInfo.i(uh4.b.INSTANCE.a().getPreDrawBitmap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ExpandHallFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("ExpandHallFloatingView") && !this$0.dialogShowing) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("clck", this$0, this$0.t());
            this$0.D();
            ExpandHallLaunchParam expandHallLaunchParam = this$0.expandHallLaunchParam;
            if (expandHallLaunchParam != null) {
                expandHallLaunchParam.E = true;
                gh4.f fVar = (gh4.f) mm4.b.b(gh4.f.class);
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                fVar.openExpandHall(context, expandHallLaunchParam);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final ExpandHallFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("ExpandHallFloatingView") && !this$0.dialogShowing) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type java.lang.Object");
            bVar.reportEvent("clck", view, this$0.t());
            if (this$0.isInMic) {
                TGDialogHelperFragment.INSTANCE.d(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.floating.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExpandHallFloatingView.w(ExpandHallFloatingView.this);
                    }
                });
            } else {
                gh4.d V0 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this$0.roomId);
                if (V0 != null) {
                    V0.Y(1);
                }
                ((fm4.g) mm4.b.b(fm4.g.class)).T2(this$0.roomId, true, 0, null, false);
                gh4.d V02 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this$0.roomId);
                if (V02 != null) {
                    V02.Y(1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(long roomId, com.tencent.timi.game.ui.widget.e dialog) {
        gh4.d V0 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(roomId);
        if (V0 == null) {
            return;
        }
        HashMap<String, String> E = V0.E();
        ((ug4.b) mm4.b.b(ug4.b.class)).b(dialog.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), V0.C(), V0.D());
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, dialog.getNegativeButton(), false, null, V0.m(), E, 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b17, dialog.getPositiveButton(), false, null, V0.n(), E, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        long j3;
        PBUInt64Field pBUInt64Field;
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 != null && (pBUInt64Field = z16.room_id) != null) {
            j3 = pBUInt64Field.get();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3);
            boolean z17 = false;
            if (K0 != null && K0.M() == 3) {
                z17 = true;
            }
            if (z17) {
                u();
                return;
            }
        }
        C();
    }

    private final void s() {
        gh4.d V0 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this.roomId);
        if (V0 != null) {
            V0.Y(1);
        }
        gh4.d V02 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this.roomId);
        if (V02 != null) {
            V02.V();
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).T2(this.roomId, true, 0, null, false);
        gh4.d V03 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this.roomId);
        if (V03 != null) {
            V03.Y(1);
        }
        gh4.d V04 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(this.roomId);
        if (V04 != null) {
            V04.V();
        }
    }

    private final ConcurrentHashMap<String, String> t() {
        ConcurrentHashMap<String, String> map = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("pgid", "pg_kl_smoba_cpdd");
        return map;
    }

    private final void u() {
        setVisibility(8);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(1), com.tencent.timi.game.utils.b.a(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final ExpandHallFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null) {
            e.a aVar = new e.a(b16);
            aVar.j("\u4f60\u6b63\u5728\u9ea6\u4f4d\u4e0a\uff0c\u786e\u5b9a\u8981\u79bb\u5f00\u5927\u5385?");
            aVar.k(17);
            aVar.n("\u53d6\u6d88");
            aVar.m(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExpandHallFloatingView.x(dialogInterface, i3);
                }
            });
            aVar.p("\u786e\u5b9a");
            aVar.o(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExpandHallFloatingView.y(ExpandHallFloatingView.this, dialogInterface, i3);
                }
            });
            com.tencent.timi.game.ui.widget.e c16 = aVar.c();
            this$0.q(this$0.roomId, c16);
            c16.show();
            c16.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.f
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ExpandHallFloatingView.z(ExpandHallFloatingView.this, dialogInterface);
                }
            });
            c16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ExpandHallFloatingView.A(ExpandHallFloatingView.this, dialogInterface);
                }
            });
            return;
        }
        l.e("ExpandHallFloatingView", "exit hall on mic, but activity not exit!!");
        this$0.u();
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ExpandHallFloatingView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ExpandHallFloatingView this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogShowing = true;
    }

    @Override // uh4.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public uh4.b getFloatingAnimateInfo() {
        return this.floatingAnimateInfo;
    }

    @Override // uh4.d
    public void b() {
        String str;
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        PBInt32Field pBInt32Field;
        ConcurrentHashMap<String, String> t16 = t();
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).y(this.commonListener);
        ViewParent parent = getParent();
        if (parent != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("yes_game_id", String.valueOf(((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).o1()));
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
            if (K0 == null || (roomInfo = K0.getRoomInfo()) == null || (yoloRoomOuterClass$YoloRoomDataInfo = roomInfo.room_data_info) == null || (pBInt32Field = yoloRoomOuterClass$YoloRoomDataInfo.create_from) == null || (str = Integer.valueOf(pBInt32Field.get()).toString()) == null) {
                str = "";
            }
            hashMap.put("yes_user_from", str);
            ((ug4.b) mm4.b.b(ug4.b.class)).b(parent, "pg_kl_smoba_cpdd", hashMap);
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this, false, "", "em_yes_cpdd_floating", t16);
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ImageView imageView = this.binding.f421165c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.close");
            bVar.a(imageView, false, "", "em_yes_cpdd_floating_close", t16);
        }
    }

    @Override // uh4.d
    public void d() {
        C();
    }

    @Override // uh4.d
    public void e() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).Q(this.commonListener);
        removeCallbacks(this.backgroundHeartBeat);
    }

    @Override // uh4.d
    @NotNull
    public uh4.c f() {
        return new c.a().e(com.tencent.timi.game.utils.b.a(80), com.tencent.timi.game.utils.b.a(80)).a();
    }

    @Override // uh4.d
    public void onBackground() {
        r();
    }

    @Override // uh4.d
    public void onHide() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("imp_end", this, t());
        D();
        removeCallbacks(this.backgroundHeartBeat);
    }

    @Override // uh4.d
    public void onShow() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("imp", this, t());
        B();
        removeCallbacks(this.backgroundHeartBeat);
        postDelayed(this.backgroundHeartBeat, 3000L);
    }

    public final void setCommonListener(@NotNull k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.commonListener = kVar;
    }

    @Override // uh4.d
    public void setLaunchParam(@Nullable Object obj) {
        if (obj instanceof ExpandHallLaunchParam) {
            this.expandHallLaunchParam = (ExpandHallLaunchParam) obj;
        }
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    @NotNull
    public uh4.d v(long roomId) {
        this.roomId = roomId;
        return this;
    }

    public /* synthetic */ ExpandHallFloatingView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.timi.game.expand.hall.impl.floating.ExpandHallFloatingView$backgroundHeartBeat$1] */
    @JvmOverloads
    public ExpandHallFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.floatingAnimateInfo = new uh4.b();
        y g16 = y.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f421164b.setNeedRound(false);
        g16.f421164b.setTopLeftRadius(com.tencent.timi.game.utils.b.a(12));
        g16.f421164b.setTopRightRadius(com.tencent.timi.game.utils.b.a(4));
        g16.f421164b.setBottomLeftRadius(com.tencent.timi.game.utils.b.a(12));
        g16.f421164b.setBottomRightRadius(com.tencent.timi.game.utils.b.a(12));
        g16.f421164b.setDefaultImage(0);
        g16.f421164b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFloatingView.m(ExpandHallFloatingView.this, view);
            }
        });
        g16.f421165c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.floating.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFloatingView.n(ExpandHallFloatingView.this, view);
            }
        });
        this.backgroundHeartBeat = new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.floating.ExpandHallFloatingView$backgroundHeartBeat$1
            @Override // java.lang.Runnable
            public void run() {
                if (!GuardManager.sInstance.isApplicationForeground() && !QBaseActivity.mAppForground) {
                    ExpandHallFloatingView.this.r();
                }
                ExpandHallFloatingView.this.postDelayed(this, 3000L);
            }
        };
        this.commonListener = new a();
    }

    @Override // uh4.d
    @NotNull
    public View getView() {
        return this;
    }
}
