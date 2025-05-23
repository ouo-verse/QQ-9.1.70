package com.qzone.reborn.feedpro.widget.countdown;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.util.c;
import com.qzone.reborn.feedpro.widget.countdown.QzoneFeedProTimeCountDownView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0002R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/countdown/QzoneFeedProTimeCountDownView;", "Landroid/widget/FrameLayout;", "", "e", "c", "", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "setData", "f", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "countDownDescView", "J", "feedDelTime", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "countDownRunnable", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "getOnDeleteFeed", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteFeed", "(Lkotlin/jvm/functions/Function0;)V", "onDeleteFeed", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProTimeCountDownView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView countDownDescView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long feedDelTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Runnable countDownRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onDeleteFeed;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProTimeCountDownView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QzoneFeedProTimeCountDownView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.countDownDescView;
        if (textView != null) {
            textView.setText(c.c(this$0.d(), "hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931"));
        }
        this$0.c();
    }

    private final void c() {
        this.mainHandler.removeCallbacks(this.countDownRunnable);
        if (d() <= 0) {
            Function0<Unit> function0 = this.onDeleteFeed;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        this.mainHandler.postDelayed(this.countDownRunnable, 1000L);
    }

    private final long d() {
        return this.feedDelTime - (NetConnInfoCenter.getServerTimeMillis() / 1000);
    }

    private final void e() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextSize(12.0f);
        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary));
        textView.setIncludeFontPadding(false);
        this.countDownDescView = textView;
        addView(textView);
    }

    public final void f() {
        this.mainHandler.removeCallbacks(this.countDownRunnable);
    }

    public final void setOnDeleteFeed(Function0<Unit> function0) {
        this.onDeleteFeed = function0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProTimeCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzoneFeedProTimeCountDownView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProTimeCountDownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.countDownRunnable = new Runnable() { // from class: te.a
            @Override // java.lang.Runnable
            public final void run() {
                QzoneFeedProTimeCountDownView.b(QzoneFeedProTimeCountDownView.this);
            }
        };
        e();
    }

    public final void setData(CommonFeed feedData) {
        CommonCellCommon cellCommon;
        Long selfDeleteTime;
        Long l3 = null;
        if (feedData != null && (cellCommon = feedData.getCellCommon()) != null && (selfDeleteTime = cellCommon.getSelfDeleteTime()) != null) {
            if (selfDeleteTime.longValue() > 0) {
                l3 = selfDeleteTime;
            }
        }
        if (l3 == null) {
            setVisibility(8);
            return;
        }
        this.feedDelTime = l3.longValue();
        TextView textView = this.countDownDescView;
        if (textView != null) {
            textView.setText(c.c(d(), "hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931"));
        }
        c();
    }
}
