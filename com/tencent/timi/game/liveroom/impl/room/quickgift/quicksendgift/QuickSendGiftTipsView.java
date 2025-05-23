package com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.QuickSendGiftTipsView;
import com.tencent.timi.game.utils.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0002'(B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#B#\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010%J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftTipsView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "roomType", "", "giftUrl", "", "setParams", "Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftTipsView$b;", "l", "setListener", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "tipsGiftIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tipsNick", "Landroid/view/View;", "f", "Landroid/view/View;", "quickSendConfirmTips", h.F, "J", "i", "I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QuickSendGiftTipsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView tipsGiftIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tipsNick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View quickSendConfirmTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftTipsView$b;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftTipsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169129hw4, this);
        this.tipsGiftIv = (ImageView) findViewById(R.id.f97805ld);
        this.tipsNick = (TextView) findViewById(R.id.f97815le);
        this.quickSendConfirmTips = findViewById(R.id.f66593b2);
        setOnClickListener(new View.OnClickListener() { // from class: qk4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSendGiftTipsView.c(QuickSendGiftTipsView.this, view);
            }
        });
        View view = this.quickSendConfirmTips;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: qk4.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickSendGiftTipsView.d(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QuickSendGiftTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setListener(@NotNull b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
    
        if (r6 != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setParams(long roomId, int roomType, @NotNull String giftUrl) {
        String str;
        TextView textView;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(giftUrl, "giftUrl");
        d dVar = d.f380295a;
        boolean z16 = false;
        dVar.d(giftUrl, this.tipsGiftIv, dVar.c(ViewUtils.dpToPx(36.0f), this.tipsGiftIv, 0));
        this.roomId = roomId;
        this.roomType = roomType;
        LiveLoginInfo u16 = c.f272176a.u();
        if (u16 != null) {
            str = u16.m();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
        }
        z16 = true;
        if (!z16 && (textView = this.tipsNick) != null) {
            textView.setText("Hi\uff0c" + str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169129hw4, this);
        this.tipsGiftIv = (ImageView) findViewById(R.id.f97805ld);
        this.tipsNick = (TextView) findViewById(R.id.f97815le);
        this.quickSendConfirmTips = findViewById(R.id.f66593b2);
        setOnClickListener(new View.OnClickListener() { // from class: qk4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSendGiftTipsView.c(QuickSendGiftTipsView.this, view);
            }
        });
        View view = this.quickSendConfirmTips;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: qk4.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickSendGiftTipsView.d(view2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169129hw4, this);
        this.tipsGiftIv = (ImageView) findViewById(R.id.f97805ld);
        this.tipsNick = (TextView) findViewById(R.id.f97815le);
        this.quickSendConfirmTips = findViewById(R.id.f66593b2);
        setOnClickListener(new View.OnClickListener() { // from class: qk4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSendGiftTipsView.c(QuickSendGiftTipsView.this, view);
            }
        });
        View view = this.quickSendConfirmTips;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: qk4.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickSendGiftTipsView.d(view2);
                }
            });
        }
    }
}
