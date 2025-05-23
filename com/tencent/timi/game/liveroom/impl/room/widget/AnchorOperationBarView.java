package com.tencent.timi.game.liveroom.impl.room.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.liveroom.impl.room.more.d;
import com.tencent.timi.game.liveroom.impl.room.util.b;
import com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import fh4.g;
import java.util.concurrent.ConcurrentHashMap;
import kl4.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0015\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/widget/AnchorOperationBarView;", "Landroid/widget/LinearLayout;", "", "roomId", "", "p", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/timi/game/liveroom/impl/room/widget/AnchorOperationBarView$a;", "listener", "setAnchorOperationBarViewListener", "", NodeProps.VISIBLE, "setMoreVisibility", "setPrivacyVisibility", "setMicVisibility", "on", "setPrivacyOn", "setMicOn", "", "visibility", "setInputVisibility", "d", "Z", "isMicOn", "e", "isPrivacyOn", "f", "Lcom/tencent/timi/game/liveroom/impl/room/widget/AnchorOperationBarView$a;", "anchorOperationBarViewListener", "Lnr2/k;", h.F, "Lnr2/k;", "binding", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorOperationBarView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isMicOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPrivacyOn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a anchorOperationBarViewListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/widget/AnchorOperationBarView$a;", "", "", "c", "onMoreClick", "", "on", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(boolean on5);

        void b(boolean on5);

        void c();

        void onMoreClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorOperationBarView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AnchorOperationBarView this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!b.a() && (aVar = this$0.anchorOperationBarViewListener) != null) {
            aVar.c();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AnchorOperationBarView this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!b.a() && (aVar = this$0.anchorOperationBarViewListener) != null) {
            aVar.c();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AnchorOperationBarView this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!b.a() && (aVar = this$0.anchorOperationBarViewListener) != null) {
            aVar.onMoreClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AnchorOperationBarView this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!b.a() && (aVar = this$0.anchorOperationBarViewListener) != null) {
            aVar.a(this$0.isPrivacyOn);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(View view) {
        IQQLiveAnchorRoom J3;
        String str;
        if ((ServerEnv.c() != 2 || eh4.a.c()) && (J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L)) != null) {
            BaseRoomInfo roomInfo = J3.getRoomInfo();
            if (roomInfo != null) {
                str = Long.valueOf(roomInfo.getRoomId()).toString();
            } else {
                str = null;
            }
            l.i("AnchorOperationBarView", "copy roomid = " + str);
            f.c("\u623f\u95f4\u53f7\u5df2\u590d\u5236\n" + str);
            com.tencent.timi.game.utils.a.a(BaseApplication.context, str);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AnchorOperationBarView this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!b.a() && (aVar = this$0.anchorOperationBarViewListener) != null) {
            aVar.b(this$0.isMicOn);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View view) {
        Unit unit;
        BaseRoomInfo roomInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L);
        if (J3 != null && (roomInfo = J3.getRoomInfo()) != null) {
            long roomId = roomInfo.getRoomId();
            s.INSTANCE.d(true, Long.valueOf(roomId), Long.valueOf(c.l(c.f272176a, roomId, 0, 2, null)));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            f.c("\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AnchorOperationBarView this$0, Function1 cb5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        ImageView imageView = this$0.binding.f421087g;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.privacyIv");
        int g16 = g.g(imageView);
        ImageView imageView2 = this$0.binding.f421087g;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.privacyIv");
        int i3 = g.i(imageView2);
        Rect rect = new Rect();
        rect.left = g16;
        rect.top = i3;
        rect.right = g16 + this$0.binding.f421087g.getWidth();
        rect.bottom = i3 + this$0.binding.f421087g.getHeight();
        cb5.invoke(rect);
    }

    public final void p(long roomId) {
        ConcurrentHashMap a16 = d.a(roomId);
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        aVar.b(this, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, a16);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        TextView textView = this.binding.f421084d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.inputTv");
        a.C11346a.a((ug4.a) b16, textView, false, null, "em_qqlive_inputbar", null, 22, null);
        mm4.a b17 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        ImageView imageView = this.binding.f421086f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.moreIv");
        a.C11346a.a((ug4.a) b17, imageView, false, null, "em_qqlive_morefunction_entrance", null, 22, null);
        mm4.a b18 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
        ImageView imageView2 = this.binding.f421085e;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.micIv");
        a.C11346a.a((ug4.a) b18, imageView2, false, null, "em_qqlive_microphone_switch", null, 22, null);
    }

    public final void q(@NotNull final Function1<? super Rect, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.binding.f421087g.post(new Runnable() { // from class: kl4.h
            @Override // java.lang.Runnable
            public final void run() {
                AnchorOperationBarView.r(AnchorOperationBarView.this, cb5);
            }
        });
    }

    public final void setAnchorOperationBarViewListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.anchorOperationBarViewListener = listener;
    }

    public final void setInputVisibility(int visibility) {
        this.binding.f421084d.setVisibility(visibility);
    }

    public final void setMicOn(boolean on5) {
        int i3;
        this.isMicOn = on5;
        ImageView imageView = this.binding.f421085e;
        if (on5) {
            i3 = R.drawable.o67;
        } else {
            i3 = R.drawable.o66;
        }
        imageView.setImageResource(i3);
    }

    public final void setMicVisibility(boolean visible) {
        int i3;
        ImageView imageView = this.binding.f421085e;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setMoreVisibility(boolean visible) {
        int i3;
        ImageView imageView = this.binding.f421086f;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setPrivacyOn(boolean on5) {
        int i3;
        this.isPrivacyOn = on5;
        ImageView imageView = this.binding.f421087g;
        if (!on5) {
            i3 = R.drawable.o6_;
        } else {
            i3 = R.drawable.o69;
        }
        imageView.setImageResource(i3);
    }

    public final void setPrivacyVisibility(boolean visible) {
        int i3;
        ImageView imageView = this.binding.f421087g;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorOperationBarView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorOperationBarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorOperationBarView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.isMicOn = true;
        k f16 = k.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(0);
        setPadding(0, 0, fh4.b.b(4), 0);
        f16.f421084d.setOnClickListener(new View.OnClickListener() { // from class: kl4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.i(AnchorOperationBarView.this, view);
            }
        });
        f16.f421082b.setOnClickListener(new View.OnClickListener() { // from class: kl4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.j(AnchorOperationBarView.this, view);
            }
        });
        f16.f421086f.setOnClickListener(new View.OnClickListener() { // from class: kl4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.k(AnchorOperationBarView.this, view);
            }
        });
        f16.f421087g.setOnClickListener(new View.OnClickListener() { // from class: kl4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.l(AnchorOperationBarView.this, view);
            }
        });
        f16.f421087g.setOnLongClickListener(new View.OnLongClickListener() { // from class: kl4.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m3;
                m3 = AnchorOperationBarView.m(view);
                return m3;
            }
        });
        f16.f421085e.setOnClickListener(new View.OnClickListener() { // from class: kl4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.n(AnchorOperationBarView.this, view);
            }
        });
        f16.f421088h.setOnClickListener(new View.OnClickListener() { // from class: kl4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorOperationBarView.o(view);
            }
        });
    }
}
