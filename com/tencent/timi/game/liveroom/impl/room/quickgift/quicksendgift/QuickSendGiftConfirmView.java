package com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.QuickSendGiftConfirmView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qk4.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002<=B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B#\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u00020\r\u00a2\u0006\u0004\b5\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002JF\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010(R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00101\u00a8\u0006>"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftConfirmView;", "Landroid/widget/LinearLayout;", "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "bigGiftUrl", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "", "balance", "marketingBalance", "roomId", "", "roomType", "abTestId", "", "setParams", "Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftConfirmView$b;", "l", "setListener", "d", "Landroid/app/Activity;", "hostActivity", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "giftIconIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "sendGiftMarkTv", h.F, "sendGiftPriceMarkTv", "i", "sendGiftBtnTv", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "closeView", BdhLogUtil.LogTag.Tag_Conn, "J", "D", "E", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftData", UserInfo.SEX_FEMALE, "G", "I", "H", "Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftConfirmView$b;", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QuickSendGiftConfirmView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private long balance;

    /* renamed from: D, reason: from kotlin metadata */
    private long marketingBalance;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private d giftData;

    /* renamed from: F, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: G, reason: from kotlin metadata */
    private int roomType;

    /* renamed from: H, reason: from kotlin metadata */
    private long abTestId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private b listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity hostActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView giftIconIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView sendGiftMarkTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView sendGiftPriceMarkTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView sendGiftBtnTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftConfirmView$b;", "", "", "a", "onClose", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a();

        void onClose();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftConfirmView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169128hw3, this);
        setOrientation(1);
        this.giftIconIv = (ImageView) findViewById(R.id.vpc);
        this.sendGiftMarkTv = (TextView) findViewById(R.id.f83104io);
        this.sendGiftPriceMarkTv = (TextView) findViewById(R.id.f83114ip);
        View findViewById = findViewById(R.id.az7);
        this.closeView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: qk4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.c(QuickSendGiftConfirmView.this, view);
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.f83094in);
        this.sendGiftBtnTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: qk4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.d(QuickSendGiftConfirmView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QuickSendGiftConfirmView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.b("dt_clck", "em_qqlive_quickgift_cancel", this$0.roomId, this$0.roomType, this$0.e(), this$0.abTestId);
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onClose();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QuickSendGiftConfirmView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.b("dt_clck", "em_qqlive_quickgift_sure", this$0.roomId, this$0.roomType, this$0.e(), this$0.abTestId);
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String e() {
        int i3;
        d dVar = this.giftData;
        if (dVar != null) {
            Intrinsics.checkNotNull(dVar);
            i3 = dVar.f264874d;
        } else {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    public final void setListener(@NotNull b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.listener = l3;
    }

    public final void setParams(@NotNull Activity activity, @NotNull String bigGiftUrl, @NotNull d data, long balance, long marketingBalance, long roomId, int roomType, long abTestId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bigGiftUrl, "bigGiftUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.timi.game.utils.d dVar = com.tencent.timi.game.utils.d.f380295a;
        dVar.d(bigGiftUrl, this.giftIconIv, dVar.c(ViewUtils.dpToPx(120.0f), this.giftIconIv, 0));
        this.hostActivity = activity;
        this.giftData = data;
        this.balance = balance;
        this.marketingBalance = marketingBalance;
        this.roomId = roomId;
        this.roomType = roomType;
        this.abTestId = abTestId;
        TextView textView = this.sendGiftMarkTv;
        if (textView != null) {
            textView.setText("\u559c\u6b22\u6211\u5c31\u9001\u4e2a" + data.f264876e + "\u5427");
        }
        TextView textView2 = this.sendGiftPriceMarkTv;
        if (textView2 != null) {
            textView2.setText("\u672c\u6b21\u8d60\u9001\u9700\u8981\u652f\u4ed8" + data.f264878f + "\u91d1\u5e01\uff0c\u652f\u4ed8\u540e\u4e0b\u6b21\u8d60\u9001\u4e0d\u518d\u63d0\u9192");
        }
        i.b("dt_imp", "em_qqlive_quickgift_sure", roomId, roomType, e(), abTestId);
        i.b("dt_imp", "em_qqlive_quickgift_cancel", roomId, roomType, e(), abTestId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftConfirmView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169128hw3, this);
        setOrientation(1);
        this.giftIconIv = (ImageView) findViewById(R.id.vpc);
        this.sendGiftMarkTv = (TextView) findViewById(R.id.f83104io);
        this.sendGiftPriceMarkTv = (TextView) findViewById(R.id.f83114ip);
        View findViewById = findViewById(R.id.az7);
        this.closeView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: qk4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.c(QuickSendGiftConfirmView.this, view);
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.f83094in);
        this.sendGiftBtnTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: qk4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.d(QuickSendGiftConfirmView.this, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSendGiftConfirmView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f169128hw3, this);
        setOrientation(1);
        this.giftIconIv = (ImageView) findViewById(R.id.vpc);
        this.sendGiftMarkTv = (TextView) findViewById(R.id.f83104io);
        this.sendGiftPriceMarkTv = (TextView) findViewById(R.id.f83114ip);
        View findViewById = findViewById(R.id.az7);
        this.closeView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: qk4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.c(QuickSendGiftConfirmView.this, view);
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.f83094in);
        this.sendGiftBtnTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: qk4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSendGiftConfirmView.d(QuickSendGiftConfirmView.this, view);
                }
            });
        }
    }
}
