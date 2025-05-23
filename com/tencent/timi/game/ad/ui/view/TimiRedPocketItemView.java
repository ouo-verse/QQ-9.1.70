package com.tencent.timi.game.ad.ui.view;

import af4.OperationItem;
import af4.RedPocketOperationData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.web.business.api.task.LiveLotteryTaskDataManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.ak;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn4.TimiPicInfo;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001\u0011B/\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0010\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/timi/game/ad/ui/view/TimiRedPocketItemView;", "Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "", "p", "", "progress", "o", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "c", "Lvn4/a;", "d", "Landroid/widget/TextView;", "e", "i", "j", "b", "", "a", "Lnr2/ak;", "Lnr2/ak;", "binding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvn4/a;", "mCurrentPicInfo", BdhLogUtil.LogTag.Tag_Conn, "I", "mCurrentViewState", "D", "mLastProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "E", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiRedPocketItemView extends BaseOperationSingleItemView {

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurrentViewState;

    /* renamed from: D, reason: from kotlin metadata */
    private int mLastProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ak binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimiPicInfo mCurrentPicInfo;

    public /* synthetic */ TimiRedPocketItemView(Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, z16);
    }

    private final void o(int progress) {
        FrameLayout.LayoutParams layoutParams;
        l.i("TimiRedPocketItemView_", "showParticipatedStyle progress:" + progress);
        if (this.mLastProgress != progress) {
            this.binding.f420820c.setProgress(progress);
            this.mLastProgress = progress;
        }
        if (this.mCurrentViewState == 2) {
            return;
        }
        this.mCurrentViewState = 2;
        this.binding.f420820c.setVisibility(0);
        this.binding.f420821d.setVisibility(0);
        this.binding.f420821d.setBackgroundResource(R.color.ajr);
        ViewGroup.LayoutParams layoutParams2 = this.binding.f420821d.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            return;
        }
        layoutParams.bottomMargin = 0;
        this.binding.f420821d.setLayoutParams(layoutParams);
    }

    private final void p() {
        FrameLayout.LayoutParams layoutParams;
        if (this.mCurrentViewState == 1) {
            return;
        }
        this.mCurrentViewState = 1;
        this.binding.f420820c.setVisibility(8);
        this.binding.f420821d.setVisibility(0);
        this.binding.f420821d.setBackgroundResource(R.drawable.ltr);
        ViewGroup.LayoutParams layoutParams2 = this.binding.f420821d.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            return;
        }
        layoutParams.bottomMargin = b.a(3);
        this.binding.f420821d.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    protected boolean a() {
        return false;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected RoundCornerImageView c() {
        RoundCornerImageView roundCornerImageView = this.binding.f420819b;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.operationIgv");
        return roundCornerImageView;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    /* renamed from: d, reason: from getter */
    protected TimiPicInfo getMCurrentPicInfo() {
        return this.mCurrentPicInfo;
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    @NotNull
    protected TextView e() {
        TextView textView = this.binding.f420821d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.stateTxv");
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:
    
        if (r2 != 3) goto L21;
     */
    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        String audienceHintTxt;
        TimiPicInfo initStatePicInfo;
        boolean I = ((jg4.b) mm4.b.b(jg4.b.class)).I(getData().getRoomId());
        l.h("TimiRedPocketItemView_", 2, "onNewData pocket data:" + getData().getTimiRedPocketData() + ", roomId:" + getData().getRoomId() + ", isAnchor:" + I);
        RedPocketOperationData timiRedPocketData = getData().getTimiRedPocketData();
        if (timiRedPocketData == null) {
            return;
        }
        int activityState = timiRedPocketData.getActivityState();
        if (activityState != 1) {
            if (activityState == 2) {
                if (LiveLotteryTaskDataManager.f380318a.i(timiRedPocketData.getActivityId())) {
                    long a16 = OperationItem.INSTANCE.a();
                    long progressFullTime = timiRedPocketData.getProgressFullTime();
                    long startTime = getData().getStartTime();
                    o((int) (((a16 - startTime) / (progressFullTime - startTime)) * 100));
                    initStatePicInfo = timiRedPocketData.getParticipatedPicInfo();
                } else {
                    p();
                    initStatePicInfo = timiRedPocketData.getInitStatePicInfo();
                }
                this.mCurrentPicInfo = initStatePicInfo;
            }
            super.i();
        }
        p();
        TextView textView = this.binding.f420821d;
        if (I) {
            audienceHintTxt = timiRedPocketData.getAnchorHintTxt();
        } else {
            audienceHintTxt = timiRedPocketData.getAudienceHintTxt();
        }
        textView.setText(audienceHintTxt);
        this.mCurrentPicInfo = timiRedPocketData.getInitStatePicInfo();
        super.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void j() {
        RedPocketOperationData timiRedPocketData = getData().getTimiRedPocketData();
        if (timiRedPocketData != null && timiRedPocketData.getActivityState() == 2) {
            int c16 = LiveLotteryTaskDataManager.f380318a.c(timiRedPocketData.getActivityId());
            long a16 = OperationItem.INSTANCE.a();
            long progressFullTime = timiRedPocketData.getProgressFullTime();
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 == 2) {
                        p();
                        this.binding.f420821d.setText("\u5df2\u5f00\u5956");
                        this.binding.f420821d.setBackgroundResource(R.drawable.ltr);
                        this.mCurrentPicInfo = timiRedPocketData.getInitStatePicInfo();
                        m();
                        return;
                    }
                    return;
                }
                long startTime = getData().getStartTime();
                o((int) (((a16 - startTime) / (progressFullTime - startTime)) * 100));
                super.j();
                if (a16 > getData().getETimer()) {
                    this.binding.f420821d.setText("\u7ed3\u7b97\u4e2d");
                    this.binding.f420821d.setBackgroundResource(R.drawable.ltr);
                    this.mCurrentPicInfo = timiRedPocketData.getParticipatedPicInfo();
                    m();
                    return;
                }
                return;
            }
            p();
            super.j();
            if (a16 > getData().getETimer()) {
                this.binding.f420821d.setText("\u7ed3\u7b97\u4e2d");
                this.binding.f420821d.setBackgroundResource(R.drawable.ltr);
                this.mCurrentPicInfo = timiRedPocketData.getInitStatePicInfo();
                m();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiRedPocketItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentPicInfo = getData().getPic();
        ak g16 = ak.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f420820c.setProgress(this.mLastProgress);
    }

    @Override // com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView
    public void b() {
    }
}
