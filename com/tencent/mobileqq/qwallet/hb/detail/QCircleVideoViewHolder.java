package com.tencent.mobileqq.qwallet.hb.detail;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/QCircleVideoViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryVideoViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "storyRes", "", "w", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "state", ReportConstant.COSTREPORT_PREFIX, "", com.tencent.luggage.wxa.c8.c.f123400v, "r", "Landroid/view/View;", "itemView", "", "skinId", "", "uniqueSkinId", "<init>", "(Landroid/view/View;ILjava/lang/String;)V", "a0", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QCircleVideoViewHolder extends CoverStoryVideoViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleVideoViewHolder(@NotNull View itemView, int i3, @NotNull String uniqueSkinId) {
        super(itemView, i3, uniqueSkinId);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(uniqueSkinId, "uniqueSkinId");
        getController().p(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(QCircleVideoViewHolder this$0, HbSkinData hbSkinData, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IQWalletHbApi iQWalletHbApi = (IQWalletHbApi) QRoute.api(IQWalletHbApi.class);
        Context context = this$0.itemView.getContext();
        if (hbSkinData == null || (str = hbSkinData.getActivityUrl()) == null) {
            str = "";
        }
        iQWalletHbApi.doJumpAction(context, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(QCircleVideoViewHolder this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K(!this$0.getController().i());
        this$0.M(this$0.getIsCurrentMute());
        String valueOf = String.valueOf(this$0.getSkinId());
        if (this$0.getIsCurrentMute()) {
            str = "1";
        } else {
            str = "0";
        }
        HbDetailModule.l("redpacket.voice.click", valueOf, str, this$0.getUniqueSkinId());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryVideoViewHolder, com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void r(float alpha) {
        boolean z16;
        if (!getController().j()) {
            if (alpha == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                I().setAlpha(0.0f);
                return;
            }
        }
        I().setAlpha(1.0f);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryVideoViewHolder, com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void s(@NotNull HbSkinState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.d("QCircleVideoViewHolder", 4, "state = " + state);
        if (state == HbSkinState.INTERMEDIATE) {
            super.s(HbSkinState.EXPANDED);
        } else {
            super.s(state);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryVideoViewHolder, com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void w(@Nullable final HbSkinData hbSkinData, @NotNull HbSkinData.StoryRes storyRes) {
        Intrinsics.checkNotNullParameter(storyRes, "storyRes");
        QLog.d("QCircleVideoViewHolder", 4, "setItem");
        super.w(hbSkinData, storyRes);
        ((ImageView) I().findViewById(R.id.t6_)).setVisibility(8);
        I().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleVideoViewHolder.Q(QCircleVideoViewHolder.this, hbSkinData, view);
            }
        });
        getMuteVideoImg().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleVideoViewHolder.R(QCircleVideoViewHolder.this, view);
            }
        });
    }
}
