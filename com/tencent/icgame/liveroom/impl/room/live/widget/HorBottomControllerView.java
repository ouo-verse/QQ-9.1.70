package com.tencent.icgame.liveroom.impl.room.live.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.v;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rv0.SoftKeyBoardStateEvent;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001C\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\t\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010)\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00107R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006N"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "isEnd", "", "H0", "Lf32/a;", "componentContext", "setComponentContext", "", "J0", "R0", "G0", "isAnchor", "setIsAnchor", "L0", "Q0", "P0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "roomId", "roomType", "N0", "O0", "show", "setGiftEntranceVisibility", "S0", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "d", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "K0", "()Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "setLiveMsgEven", "(Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;)V", "liveMsgEven", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "Z", h.F, "I", "horState", "i", "I0", "()Z", "setForbidExpose", "(Z)V", "forbidExpose", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lf32/a;", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "danmuIconHor", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "inputPlaceHolder", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView;", "E", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView;", "horInputBoxView", UserInfo.SEX_FEMALE, "giftBulletSwitchIcon", "com/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView$a", "G", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView$a;", "stateChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class HorBottomControllerView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView danmuIconHor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView inputPlaceHolder;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HorInputBoxView horInputBoxView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView giftBulletSwitchIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final a stateChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d liveMsgEven;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int horState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean forbidExpose;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f32.a componentContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView$a", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements TimiBaseInputView.b {
        a() {
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            CharSequence trim;
            boolean z16;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            trim = StringsKt__StringsKt.trim((CharSequence) text);
            String obj = trim.toString();
            if (obj.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            d liveMsgEven = HorBottomControllerView.this.getLiveMsgEven();
            if (liveMsgEven != null) {
                liveMsgEven.a(obj);
            }
            timiBaseInputView.g();
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3;
            HorInputBoxView horInputBoxView = HorBottomControllerView.this.horInputBoxView;
            if (state == 1) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            horInputBoxView.setVisibility(i3);
            if (HorBottomControllerView.this.horState != state) {
                HorBottomControllerView.this.horState = state;
                if (HorBottomControllerView.this.getForbidExpose()) {
                    return;
                }
                if (HorBottomControllerView.this.horInputBoxView.getPreState() != 1 && state == 1) {
                    Activity activity = HorBottomControllerView.this.activity;
                    if (activity != null) {
                        v.c(activity.getWindow().getDecorView());
                    }
                    HorBottomControllerView.this.horInputBoxView.T(true);
                    return;
                }
                if (HorBottomControllerView.this.horInputBoxView.getPreState() == 1 && state != 1) {
                    HorBottomControllerView.this.horInputBoxView.T(false);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorBottomControllerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(final HorBottomControllerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.activity != null) {
            this$0.post(new Runnable() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    HorBottomControllerView.M0(HorBottomControllerView.this);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H0(boolean isEnd) {
        String str;
        if (!isEnd) {
            str = "imp";
        } else {
            str = "imp_end";
        }
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        ImageView imageView = this.danmuIconHor;
        Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type java.lang.Object");
        aVar.reportEvent(str, imageView, new LinkedHashMap());
        ru0.a aVar2 = (ru0.a) qx0.a.b(ru0.a.class);
        ImageView imageView2 = this.giftBulletSwitchIcon;
        Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type java.lang.Object");
        aVar2.reportEvent(str, imageView2, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(HorBottomControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.horInputBoxView.setVisibility(0);
        this$0.horInputBoxView.P();
        f32.a aVar = this$0.componentContext;
        if (aVar != null) {
            aVar.w0(new SoftKeyBoardStateEvent(true));
        }
    }

    public final void G0() {
        this.horInputBoxView.f(this.stateChangeListener);
    }

    /* renamed from: I0, reason: from getter */
    public final boolean getForbidExpose() {
        return this.forbidExpose;
    }

    public final int J0() {
        return this.horInputBoxView.getCurrentState();
    }

    @Nullable
    /* renamed from: K0, reason: from getter */
    public final d getLiveMsgEven() {
        return this.liveMsgEven;
    }

    public final void L0() {
        HorInputBoxView horInputBoxView = this.horInputBoxView;
        if (horInputBoxView != null) {
            horInputBoxView.setState(1);
        }
    }

    public final void P0() {
        H0(false);
    }

    public final void Q0() {
        HorInputBoxView horInputBoxView = this.horInputBoxView;
        if (horInputBoxView != null) {
            horInputBoxView.setVisibility(8);
        }
        H0(true);
    }

    public final void R0() {
        this.horInputBoxView.M(this.stateChangeListener);
    }

    public final void S0(boolean show) {
        int i3;
        TextView textView = this.inputPlaceHolder;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.activity = com.tencent.icgame.game.utils.a.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.activity = null;
    }

    public final void setComponentContext(@NotNull f32.a componentContext) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.componentContext = componentContext;
    }

    public final void setForbidExpose(boolean z16) {
        this.forbidExpose = z16;
    }

    public final void setIsAnchor(boolean isAnchor) {
        this.isAnchor = isAnchor;
    }

    public final void setLiveMsgEven(@Nullable d dVar) {
        this.liveMsgEven = dVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorBottomControllerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HorBottomControllerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorBottomControllerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.horState = 1;
        this.forbidExpose = true;
        LayoutInflater.from(getContext()).inflate(R.layout.fbo, this);
        View findViewById = findViewById(R.id.udf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.danmuIconHor)");
        this.danmuIconHor = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.xod);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.inputPlaceHolder)");
        TextView textView = (TextView) findViewById2;
        this.inputPlaceHolder = textView;
        View findViewById3 = findViewById(R.id.xaw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.horInputBoxView)");
        this.horInputBoxView = (HorInputBoxView) findViewById3;
        View findViewById4 = findViewById(R.id.f165363vo4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftBulletSwitchIcon)");
        this.giftBulletSwitchIcon = (ImageView) findViewById4;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HorBottomControllerView.B0(HorBottomControllerView.this, view);
            }
        });
        G0();
        this.stateChangeListener = new a();
    }

    public final void O0() {
    }

    public final void setGiftEntranceVisibility(boolean show) {
    }

    public final void N0(long roomId, int roomType) {
    }
}
