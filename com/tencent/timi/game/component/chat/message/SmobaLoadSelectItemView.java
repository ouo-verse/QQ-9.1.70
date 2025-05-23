package com.tencent.timi.game.component.chat.message;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.event.TeamLaneEvent;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00015\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u0004\u00a2\u0006\u0004\bE\u0010FJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001bR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u001bR\u0014\u00100\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u0018R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u0018R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\u0018R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006G"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Landroid/widget/ImageView;", "roadIv", "", "fromColor", "toColor", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/graphics/drawable/GradientDrawable;", "drawable", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "roadTv", "V", "index", "Landroid/widget/FrameLayout;", "fl", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "selectdRoadNum", ExifInterface.LATITUDE_SOUTH, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "I", "", "f0", "Ljava/util/List;", "roadFls", "g0", "roadFlDrawables", "h0", "roadIconIvs", "i0", "roadDescTvs", "", "", "j0", "roadDescs", "k0", "roadIDs", "l0", "disableIcons", "m0", "normalIcons", "n0", "selectedIcons", "o0", "normalTextColor", "p0", "selectedTextColor", "q0", "disableTextColor", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$a", "r0", "Lcom/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$a;", "eventReceiver", "Landroid/widget/LinearLayout;", "s0", "Landroid/widget/LinearLayout;", "loadContainer", "t0", "Landroid/widget/FrameLayout;", "rootContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SmobaLoadSelectItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<FrameLayout> roadFls;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GradientDrawable> roadFlDrawables;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ImageView> roadIconIvs;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TextView> roadDescTvs;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> roadDescs;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> roadIDs;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> disableIcons;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> normalIcons;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> selectedIcons;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final int normalTextColor;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final int selectedTextColor;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final int disableTextColor;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a eventReceiver;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout loadContainer;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout rootContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/team/impl/event/TeamLaneEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements SimpleEventReceiver<TeamLaneEvent> {
        a() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<TeamLaneEvent>> getEventClass() {
            ArrayList<Class<TeamLaneEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TeamLaneEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            com.tencent.timi.game.tim.api.message.a msg2;
            boolean z16;
            if ((event instanceof TeamLaneEvent) && (msg2 = SmobaLoadSelectItemView.this.getMsg()) != null) {
                SmobaLoadSelectItemView smobaLoadSelectItemView = SmobaLoadSelectItemView.this;
                int m3 = msg2.m();
                int i3 = 0;
                if (m3 >= 0 && m3 < 10) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    for (Object obj : smobaLoadSelectItemView.roadIDs) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (((Number) obj).intValue() == ((TeamLaneEvent) event).getLaneId()) {
                            msg2.n(i16);
                            smobaLoadSelectItemView.I(msg2);
                        }
                        i3 = i16;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SmobaLoadSelectItemView f376557c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f376558d;

        b(com.tencent.timi.game.tim.api.message.a aVar, int i3, SmobaLoadSelectItemView smobaLoadSelectItemView, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            this.f376555a = aVar;
            this.f376556b = i3;
            this.f376557c = smobaLoadSelectItemView;
            this.f376558d = yoloRoomOuterClass$YoloRoomInfo;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            this.f376555a.n(this.f376556b + 1);
            CommonOuterClass$QQUserId selfQQUserId = this.f376557c.getSelfQQUserId();
            if (selfQQUserId != null) {
                YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f376558d;
                SmobaLoadSelectItemView smobaLoadSelectItemView = this.f376557c;
                int i3 = this.f376556b;
                com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(yoloRoomOuterClass$YoloRoomInfo.tim_group_id.get());
                String b16 = ym4.a.b(((Number) smobaLoadSelectItemView.roadIDs.get(i3)).intValue());
                Intrinsics.checkNotNullExpressionValue(b16, "buildText(roadIDs[index])");
                com.tencent.timi.game.tim.api.message.a j3 = M.j(selfQQUserId, b16);
                if (j3 != null) {
                    j3.e("");
                }
            }
            this.f376557c.I(this.f376555a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            this.f376557c.I(this.f376555a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaLoadSelectItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void Q(ImageView roadIv, int fromColor, int toColor) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(roadIv, CustomAnimation.KeyPath.COLOR_FILTER, fromColor, toColor);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setDuration(80L).start();
    }

    private final void R(GradientDrawable drawable, int fromColor, int toColor) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawable, "color", fromColor, toColor);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setDuration(80L).start();
    }

    private final void S(final int index, FrameLayout fl5, final com.tencent.timi.game.tim.api.message.a msg2, int selectdRoadNum) {
        final YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null) {
            Iterator<T> it = this.roadFls.iterator();
            while (it.hasNext()) {
                ((FrameLayout) it.next()).setClickable(false);
            }
            int[] iArr = {0, 0};
            this.roadIconIvs.get(index).getLocationOnScreen(iArr);
            int i3 = 0;
            for (Object obj : this.roadIconIvs) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ImageView imageView = (ImageView) obj;
                if (i3 == index) {
                    R(this.roadFlDrawables.get(i3), Color.parseColor("#FFFFFF"), Color.parseColor("#F5A300"));
                    Q(imageView, Color.parseColor("#F5A300"), Color.parseColor("#FFFFFF"));
                } else if (i3 == selectdRoadNum - 1) {
                    R(this.roadFlDrawables.get(i3), Color.parseColor("#F5A300"), Color.parseColor("#FFFFFF"));
                    Q(imageView, Color.parseColor("#FFFFFF"), Color.parseColor("#F5A300"));
                }
                i3 = i16;
            }
            int i17 = 0;
            for (Object obj2 : this.roadDescTvs) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TextView textView = (TextView) obj2;
                if (i17 == index) {
                    V(textView, Color.parseColor("#000000"), Color.parseColor("#FFFFFF"));
                } else if (i17 == selectdRoadNum - 1) {
                    V(textView, Color.parseColor("#A2A4A9"), Color.parseColor("#000000"));
                }
                i17 = i18;
            }
            int b16 = fh4.b.b(20);
            int b17 = fh4.b.b(250);
            double d16 = b16 - iArr[0];
            int i19 = b17 - iArr[1];
            long sqrt = (long) (400 + ((Math.sqrt((d16 * d16) + (i19 * i19)) * 300) / fh4.b.b(200)));
            SimpleEventBus.getInstance().dispatchEvent(new ChooseLaneEvent(this.roadIDs.get(index).intValue(), this.normalIcons.get(index).intValue(), iArr[0], iArr[1], sqrt));
            com.tencent.timi.game.utils.w.d(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.as
                @Override // java.lang.Runnable
                public final void run() {
                    SmobaLoadSelectItemView.T(YoloRoomOuterClass$YoloRoomInfo.this, this, index, msg2);
                }
            }, sqrt - 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(YoloRoomOuterClass$YoloRoomInfo this_run, SmobaLoadSelectItemView this$0, int i3, com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        ((fm4.g) mm4.b.b(fm4.g.class)).A(this_run.room_id.get()).J(this$0.roadIDs.get(i3).intValue(), new b(msg2, i3, this$0, this_run));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(SmobaLoadSelectItemView this$0, int i3, FrameLayout fl5, com.tencent.timi.game.tim.api.message.a msg2, int i16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fl5, "$fl");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.S(i3, fl5, msg2, i16);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V(TextView roadTv, int fromColor, int toColor) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(roadTv, "textColor", fromColor, toColor);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setDuration(80L).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull final com.tencent.timi.game.tim.api.message.a msg2) {
        boolean z16;
        int i3;
        int intValue;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        final int m3 = msg2.m() % 10;
        int i16 = 0;
        if (msg2.m() / 10 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        final int i17 = 0;
        for (Object obj : this.roadFls) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final FrameLayout frameLayout = (FrameLayout) obj;
            YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
            if (roomInfo != null) {
                mm4.a b16 = mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                ug4.b bVar = (ug4.b) b16;
                String id5 = msg2.id();
                ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
                L.put("yes_user_branch", String.valueOf(this.roadIDs.get(i17).intValue()));
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026                        }");
                b.a.a(bVar, frameLayout, false, id5, "em_yes_chat_branch_choose", L, 2, null);
            }
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ar
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmobaLoadSelectItemView.U(SmobaLoadSelectItemView.this, i17, frameLayout, msg2, m3, view);
                }
            });
            frameLayout.setClickable(z16);
            i17 = i18;
        }
        int i19 = 0;
        for (Object obj2 : this.roadFlDrawables) {
            int i26 = i19 + 1;
            if (i19 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GradientDrawable gradientDrawable = (GradientDrawable) obj2;
            if (i19 == m3 - 1) {
                gradientDrawable.setColor(Color.parseColor("#F5A300"));
            } else {
                gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
            }
            i19 = i26;
        }
        int i27 = 0;
        for (Object obj3 : this.roadIconIvs) {
            int i28 = i27 + 1;
            if (i27 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ImageView imageView = (ImageView) obj3;
            imageView.clearColorFilter();
            if (i27 == m3 - 1) {
                intValue = this.selectedIcons.get(i27).intValue();
            } else if (z16) {
                intValue = this.normalIcons.get(i27).intValue();
            } else {
                intValue = this.disableIcons.get(i27).intValue();
            }
            imageView.setImageResource(intValue);
            i27 = i28;
        }
        for (Object obj4 : this.roadDescTvs) {
            int i29 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj4;
            if (i16 == m3 - 1) {
                i3 = this.selectedTextColor;
            } else if (z16) {
                i3 = this.normalTextColor;
            } else {
                i3 = this.disableTextColor;
            }
            textView.setTextColor(i3);
            i16 = i29;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaLoadSelectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SmobaLoadSelectItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaLoadSelectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<String> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        List<Integer> listOf4;
        List<Integer> listOf5;
        Intrinsics.checkNotNullParameter(context, "context");
        this.roadFls = new ArrayList();
        this.roadFlDrawables = new ArrayList();
        this.roadIconIvs = new ArrayList();
        this.roadDescTvs = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u53d1\u80b2\u8def", "\u5bf9\u6297\u8def", "\u4e2d\u8def", "\u6253\u91ce", "\u6e38\u8d70"});
        this.roadDescs = listOf;
        int i16 = 0;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 1, 2, 4, 5});
        this.roadIDs = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.o9i), Integer.valueOf(R.drawable.o9f), Integer.valueOf(R.drawable.o9o), Integer.valueOf(R.drawable.o9c), Integer.valueOf(R.drawable.o9l)});
        this.disableIcons = listOf3;
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.o9j), Integer.valueOf(R.drawable.o9g), Integer.valueOf(R.drawable.o9p), Integer.valueOf(R.drawable.o9d), Integer.valueOf(R.drawable.o9m)});
        this.normalIcons = listOf4;
        listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.o9k), Integer.valueOf(R.drawable.o9h), Integer.valueOf(R.drawable.o9q), Integer.valueOf(R.drawable.o9e), Integer.valueOf(R.drawable.o9n)});
        this.selectedIcons = listOf5;
        this.normalTextColor = yn4.c.a(R.color.black);
        this.selectedTextColor = yn4.c.a(R.color.f158017al3);
        this.disableTextColor = Color.parseColor("#A2A4A9");
        this.eventReceiver = new a();
        setContentView(R.layout.hwg);
        View findViewById = findViewById(R.id.yrn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.loadContainer)");
        this.loadContainer = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.f782746m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rootContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.rootContainer = frameLayout;
        fh4.g.f(frameLayout, fh4.b.b(15), yn4.c.a(R.color.f158017al3));
        for (int i17 = 0; i17 < 5; i17++) {
            LinearLayout linearLayout = this.loadContainer;
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            this.roadFls.add(frameLayout2);
            this.roadFlDrawables.add(fh4.g.f(frameLayout2, fh4.b.b(4), Color.parseColor("#FFFFFF")));
            ImageView imageView = new ImageView(frameLayout2.getContext());
            this.roadIconIvs.add(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fh4.b.b(28), fh4.b.b(28));
            layoutParams.topMargin = fh4.b.b(7);
            layoutParams.gravity = 1;
            Unit unit = Unit.INSTANCE;
            frameLayout2.addView(imageView, layoutParams);
            TextView textView = new TextView(frameLayout2.getContext());
            this.roadDescTvs.add(textView);
            fh4.b.g(textView, 10.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(fh4.b.f(frameLayout2), fh4.b.f(frameLayout2));
            layoutParams2.topMargin = fh4.b.b(38);
            layoutParams2.gravity = 1;
            frameLayout2.addView(textView, layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(fh4.b.b(48), fh4.b.b(60));
            layoutParams3.weight = 1.0f;
            linearLayout.addView(frameLayout2, layoutParams3);
        }
        for (Object obj : this.roadDescTvs) {
            int i18 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((TextView) obj).setText(this.roadDescs.get(i16));
            i16 = i18;
        }
    }
}
