package com.tencent.timi.game.ad.ui.view;

import af4.BatteryOperationData;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.ad.ui.view.BatteryItemView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.l;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nr2.ai;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn4.TimiPicInfo;
import wi4.a;
import yn4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B/\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/ad/ui/view/BatteryItemView;", "Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "", "p", "", "sync", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "c", "Lvn4/a;", "d", "Landroid/widget/TextView;", "e", "b", "Lnr2/ai;", "Lnr2/ai;", "binding", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "mTimerEndTime", BdhLogUtil.LogTag.Tag_Conn, "mTimerEndTimeLastUpdateTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "D", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class BatteryItemView extends BaseOperationSingleItemView {

    /* renamed from: C, reason: from kotlin metadata */
    private long mTimerEndTimeLastUpdateTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ai binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mTimerEndTime;

    public /* synthetic */ BatteryItemView(Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, z16);
    }

    @SuppressLint({"SetTextI18n"})
    private final void p() {
        BatteryOperationData batteryData = getData().getBatteryData();
        if (batteryData == null) {
            return;
        }
        this.binding.f420813b.setVisibility(0);
        if (batteryData.getNumOfAvailableTask() > 0) {
            this.binding.f420813b.setText("\u53ef\u9886\u53d6");
            return;
        }
        if (batteryData.getTaskUnionStatusOfToday() == 1) {
            this.binding.f420813b.setText("\u5df2\u9886\u5b8c");
            return;
        }
        long j3 = 1000;
        long serverTime = NetConnInfoCenter.getServerTime() * j3;
        long j16 = this.mTimerEndTime;
        if (serverTime > j16) {
            this.binding.f420813b.setText("\u53ef\u9886\u53d6");
        } else {
            long j17 = (j16 - serverTime) / j3;
            long j18 = 60;
            long j19 = j17 % j18;
            long j26 = (j17 / j18) % j18;
            long j27 = j17 / 3600;
            l.h("BatteryItemView", 4, "updateHintTxv gapTimeInSec:" + j17 + ", hour:" + j27 + ", min:" + j26 + ", sec:" + j19);
            if (j27 == 0) {
                TextView textView = this.binding.f420813b;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j26)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j19)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                textView.setText(format + ":" + format2);
            } else {
                TextView textView2 = this.binding.f420813b;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j27)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                String format4 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j26)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
                String format5 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j19)}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
                textView2.setText(format3 + ":" + format4 + ":" + format5);
            }
        }
        if (serverTime - this.mTimerEndTimeLastUpdateTime > 5000) {
            q(false);
        } else {
            l.h("BatteryItemView_", 4, "updateTimerEndTime Gap 5000, give up.");
        }
    }

    private final void q(boolean sync) {
        final BatteryOperationData batteryData = getData().getBatteryData();
        if (batteryData != null && batteryData.getNumOfAvailableTask() <= 0 && batteryData.getTaskUnionStatusOfToday() != 1) {
            Runnable runnable = new Runnable() { // from class: cf4.a
                @Override // java.lang.Runnable
                public final void run() {
                    BatteryItemView.r(BatteryOperationData.this, this);
                }
            };
            if (sync) {
                runnable.run();
            } else {
                ThreadManagerV2.excute(runnable, 32, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(BatteryOperationData batteryData, BatteryItemView this$0) {
        Intrinsics.checkNotNullParameter(batteryData, "$batteryData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long f16 = d.f();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 1000;
        long d16 = a.f445705a.d(0L, f16, NetConnInfoCenter.getServerTime() * j3, false);
        long currentTimeMillis2 = System.currentTimeMillis();
        int recentTaskWatchTime = batteryData.getRecentTaskWatchTime() * 1000;
        long j16 = recentTaskWatchTime - d16;
        long serverTime = (NetConnInfoCenter.getServerTime() * j3) + j16;
        this$0.mTimerEndTime = serverTime;
        l.i("BatteryItemView", "updateTimerEndTime queryDuration cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms, todayStartTime:" + f16 + ", duration:" + d16 + ", taskNeedWatchTime:" + recentTaskWatchTime + ", remain:" + j16 + "\uff0c mTimerEndTime:" + serverTime);
        this$0.mTimerEndTimeLastUpdateTime = NetConnInfoCenter.getServerTime() * j3;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected RoundCornerImageView c() {
        RoundCornerImageView roundCornerImageView = this.binding.f420814c;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.operationIgv");
        return roundCornerImageView;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    /* renamed from: d */
    protected TimiPicInfo getMCurrentPicInfo() {
        return getData().getPic();
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected TextView e() {
        TextView textView = this.binding.f420813b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintTxv");
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void i() {
        super.i();
        q(true);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void j() {
        BatteryOperationData batteryData = getData().getBatteryData();
        if (batteryData != null && batteryData.getNumOfAvailableTask() <= 0 && batteryData.getTaskUnionStatusOfToday() != 1) {
            p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatteryItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        ai g16 = ai.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        setVisibility(getMIsLandscape() ? 4 : 0);
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void b() {
    }
}
