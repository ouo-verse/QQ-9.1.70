package com.tencent.mobileqq.qwallet.setting;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.qwallet.utils.QWalletUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.setting.a;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.pay.PayChannelUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010.\u001a\u00020(\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\"\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010%\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/e;", "Lcom/tencent/mobileqq/qwallet/setting/a$a;", "", h.f248218g, "", "title", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedPoint;", "redPoint", "o", "", "redPointId", "id", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qwallet/setting/g;", "settingDataItem", "Lkotlin/Function1;", "onItemClickListener", "r", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "E", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "leftText", "G", "rightText", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "rightIcon", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "rightRedDotContainer", "Landroid/view/View;", "J", "Landroid/view/View;", "bottomDiv", "K", "bgRadius", "itemView", "<init>", "(Landroid/view/View;)V", "L", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends a.C8484a {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RedTouch redTouch;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView leftText;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView rightText;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView rightIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout rightRedDotContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View bottomDiv;

    /* renamed from: K, reason: from kotlin metadata */
    private final int bgRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f67573dp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qwallet_item_left_text)");
        this.leftText = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f67603ds);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026.qwallet_item_right_text)");
        this.rightText = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f67583dq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026.qwallet_item_right_icon)");
        this.rightIcon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f67593dr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026_right_red_dot_container)");
        this.rightRedDotContainer = (RelativeLayout) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f67563do);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026.qwallet_item_bottom_div)");
        this.bottomDiv = findViewById5;
        this.bgRadius = x.c(itemView.getContext(), 8.0f);
    }

    private final void m() {
        this.rightRedDotContainer.removeAllViews();
        View view = new View(this.itemView.getContext());
        view.setId(1002);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0f), ViewUtils.dip2px(9.0f));
        layoutParams.addRule(13);
        this.rightRedDotContainer.addView(view, layoutParams);
        this.redTouch = null;
    }

    private final void n(int redPointId, int id5) {
        ViewGroup viewGroup;
        String c16 = com.tencent.mobileqq.base.a.c();
        View findViewById = this.itemView.findViewById(1001);
        if (findViewById != null) {
            View view = this.itemView;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(findViewById);
            }
        }
        com.tencent.mobileqq.qwallet.utils.g.l("is_person_redpoint_valid_" + c16 + "_" + redPointId, false);
        com.tencent.mobileqq.qwallet.c.e("menureddot.click", String.valueOf(id5), "", "", "");
    }

    private final boolean o(QWalletHomePage$RedPoint redPoint) {
        String c16 = com.tencent.mobileqq.base.a.c();
        if (redPoint != null && redPoint.f41696id.get() != 0 && QWalletUtils.p(redPoint.range)) {
            return com.tencent.mobileqq.qwallet.utils.g.c("is_person_redpoint_valid_" + c16 + "_" + redPoint.f41696id.get(), true);
        }
        return false;
    }

    private final void p(int redPointId, int id5) {
        String c16 = com.tencent.mobileqq.base.a.c();
        ImageView imageView = new ImageView(this.itemView.getContext());
        imageView.setId(1001);
        imageView.setBackgroundResource(R.drawable.skin_tips_dot);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.rightRedDotContainer.addView(imageView, layoutParams);
        String str = "is_person_redpoint_report_" + c16 + "_" + redPointId;
        if (!com.tencent.mobileqq.qwallet.utils.g.c(str, false)) {
            com.tencent.mobileqq.qwallet.c.e("menureddot.show", String.valueOf(id5), "", "", "");
            com.tencent.mobileqq.qwallet.utils.g.l(str, true);
        }
    }

    private final void q(boolean isOpen, String title) {
        int parseColor;
        int i3;
        int i16;
        if (isOpen) {
            parseColor = Color.parseColor("#0099FF");
            i3 = R.drawable.fs6;
            i16 = R.string.f2174160y;
        } else {
            parseColor = Color.parseColor("#999999");
            i3 = R.drawable.fs5;
            i16 = R.string.g6k;
        }
        this.rightIcon.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), i3));
        this.rightIcon.setVisibility(0);
        String string = this.itemView.getContext().getResources().getString(i16);
        this.rightText.setText(string);
        this.rightText.setTextColor(parseColor);
        QWalletUtils.x(this.itemView, title + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 onItemClickListener, SettingDataItem settingDataItem, boolean z16, e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onItemClickListener, "$onItemClickListener");
        Intrinsics.checkNotNullParameter(settingDataItem, "$settingDataItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onItemClickListener.invoke(settingDataItem);
        if (z16) {
            this$0.n(settingDataItem.getRedPoint().f41696id.get(), settingDataItem.getId());
        }
        com.tencent.mobileqq.qwallet.c.e("set.click", settingDataItem.getPv(), "", "", AppSetting.f99551k);
        QWalletUtils.s("set_click", "", settingDataItem.getPv(), "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void r(@NotNull final SettingDataItem settingDataItem, @NotNull final Function1<? super SettingDataItem, Unit> onItemClickListener) {
        Intrinsics.checkNotNullParameter(settingDataItem, "settingDataItem");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.leftText.setText(settingDataItem.getName());
        int settingType = settingDataItem.getSettingType();
        if (settingType != 2) {
            if (settingType != 5) {
                if (settingType != 13) {
                    this.rightText.setText(settingDataItem.getSubName());
                    QWalletUtils.x(this.itemView, settingDataItem.getName() + settingDataItem.getSubName());
                    this.rightIcon.setImageDrawable(null);
                    this.rightIcon.setVisibility(8);
                } else {
                    q(settingDataItem.getIsOpenLock(), settingDataItem.getName());
                }
            } else {
                q(settingDataItem.getIsOpenLock(), settingDataItem.getName());
            }
        } else {
            q(settingDataItem.getIsOpenLock(), settingDataItem.getName());
        }
        m();
        final boolean o16 = o(settingDataItem.getRedPoint());
        if (o16) {
            p(settingDataItem.getRedPoint().f41696id.get(), settingDataItem.getId());
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.setting.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.s(Function1.this, settingDataItem, o16, this, view);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        PayChannelUtils.updateBgRound(itemView, settingDataItem.getEnumBgRadius(), this.bgRadius);
        if (settingDataItem.getEnumBgRadius() == PayChannelUtils.BgRadiusEnum.TopRound || settingDataItem.getEnumBgRadius() == PayChannelUtils.BgRadiusEnum.NONE) {
            this.bottomDiv.setVisibility(0);
        }
    }
}
