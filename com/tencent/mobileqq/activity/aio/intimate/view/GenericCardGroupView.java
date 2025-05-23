package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.h;
import com.tencent.mobileqq.activity.aio.intimate.header.n;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import f61.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB!\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/view/GenericCardGroupView;", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "", "Lf61/c;", "cardInfoList", "Landroid/widget/LinearLayout;", "t", ParseCommon.CONTAINER, "", ReportConstant.COSTREPORT_PREFIX, "", "a", "b", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "", "friendIntimateType", "i", "Landroid/view/View;", "v", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GenericCardGroupView extends IntimateContentItemBaseView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericCardGroupView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void s(LinearLayout container) {
        boolean z16;
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
        Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderConfigData");
        String genericCardGroupTitle = ((h) loadConfig).getGenericCardGroupTitle();
        if (genericCardGroupTitle.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        TextView textView = new TextView(this.f179219d);
        textView.setText(genericCardGroupTitle);
        textView.setTypeface(null, 1);
        textView.setTextSize(14.0f);
        textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary, null));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dpToPx(20.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(20.0f);
        textView.setLayoutParams(layoutParams);
        container.addView(textView);
    }

    private final LinearLayout t(List<c> cardInfoList) {
        LinearLayout linearLayout = new LinearLayout(this.f179219d);
        linearLayout.setOrientation(1);
        s(linearLayout);
        int size = cardInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = cardInfoList.get(i3);
            Context context = this.f179219d;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            HorizontalGenericCardView horizontalGenericCardView = new HorizontalGenericCardView(context);
            horizontalGenericCardView.setFriendUin(this.f179220e);
            horizontalGenericCardView.setCardInfo(cVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ViewUtils.dpToPx(12.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(horizontalGenericCardView, layoutParams);
        }
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return n.b();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(@Nullable IntimateInfo intimateInfo, int friendIntimateType) {
        List<c> list;
        if (intimateInfo != null) {
            list = intimateInfo.genericCardInfoList;
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            setVisibility(0);
            LinearLayout t16 = t(list);
            removeAllViews();
            addView(t16, new LinearLayout.LayoutParams(-1, -2));
            return;
        }
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericCardGroupView(@NotNull Context context, @NotNull AttributeSet attr) {
        super(context, attr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericCardGroupView(@NotNull Context context, @NotNull AttributeSet attr, int i3) {
        super(context, attr, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(@Nullable View v3) {
    }
}
