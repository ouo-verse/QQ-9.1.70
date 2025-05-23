package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/weather/part/c;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "", "p", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", NodeProps.VISIBLE, "onVisibleChanged", "Landroidx/cardview/widget/CardView;", "d", "Landroidx/cardview/widget/CardView;", "mCardContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTopTitle", "f", "mTopDesc", tl.h.F, "mPosDesc", "i", "mNegDesc", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCalendarText1", BdhLogUtil.LogTag.Tag_Conn, "mCalendarText2", "Lcom/tencent/mobileqq/weather/part/WeatherMainPageRecyclerView;", "D", "Lcom/tencent/mobileqq/weather/part/WeatherMainPageRecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/weather/adapter/a;", "E", "Lcom/tencent/mobileqq/weather/adapter/a;", "mAdapter", UserInfo.SEX_FEMALE, "I", "mPagePos", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends Section<com.tencent.mobileqq.weather.data.k> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mCalendarText2;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeatherMainPageRecyclerView mRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.weather.adapter.a mAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private int mPagePos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CardView mCardContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mTopTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTopDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mPosDesc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mNegDesc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mCalendarText1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/weather/part/c$a", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends SafeLinearLayoutManager {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context, 0, false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAdapter = new com.tencent.mobileqq.weather.adapter.a();
        }
    }

    private final void p() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mTopTitle;
            CardView cardView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitle");
                textView = null;
            }
            textView.setTextColor(-1);
            TextView textView2 = this.mTopDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopDesc");
                textView2 = null;
            }
            textView2.setTextColor(-1);
            TextView textView3 = this.mPosDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosDesc");
                textView3 = null;
            }
            textView3.setTextColor(-1);
            TextView textView4 = this.mNegDesc;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNegDesc");
                textView4 = null;
            }
            textView4.setTextColor(-1);
            TextView textView5 = this.mCalendarText1;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCalendarText1");
                textView5 = null;
            }
            textView5.setTextColor(-1);
            TextView textView6 = this.mCalendarText2;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCalendarText2");
                textView6 = null;
            }
            textView6.setTextColor(-1);
            CardView cardView2 = this.mCardContainer;
            if (cardView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            } else {
                cardView = cardView2;
            }
            cardView.setCardBackgroundColor(Color.parseColor("#1A1A1A"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190475s};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            WeatherMainPageRecyclerView weatherMainPageRecyclerView = (WeatherMainPageRecyclerView) containerView.findViewById(R.id.smo);
            weatherMainPageRecyclerView.setLayoutManager(new a(weatherMainPageRecyclerView.getContext()));
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            weatherMainPageRecyclerView.setItemAnimator(defaultItemAnimator);
            this.mRecyclerView = weatherMainPageRecyclerView;
            if (weatherMainPageRecyclerView != null) {
                weatherMainPageRecyclerView.setAdapter(this.mAdapter);
            }
            View findViewById = containerView.findViewById(R.id.sm8);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.almanac_card_container)");
            this.mCardContainer = (CardView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.sme);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.almanac_date_title)");
            this.mTopTitle = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.smd);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.almanac_date_desc)");
            this.mTopDesc = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.smm);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.almanac_pos_desc)");
            this.mPosDesc = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.smk);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.almanac_neg_desc)");
            this.mNegDesc = (TextView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.sm9);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.almanac_date_calendar_text_1)");
            this.mCalendarText1 = (TextView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.sm_);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.almanac_date_calendar_text_2)");
            this.mCalendarText2 = (TextView) findViewById7;
        }
        p();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, visible);
            return;
        }
        super.onVisibleChanged(visible);
        if (visible) {
            com.tencent.mobileqq.weather.util.report.c.f313670a.d(this.mPagePos);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.b) {
            com.tencent.mobileqq.weather.data.b bVar = (com.tencent.mobileqq.weather.data.b) data;
            this.mPagePos = bVar.a();
            this.mAdapter.k0(bVar.e());
            TextView textView = this.mTopTitle;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitle");
                textView = null;
            }
            textView.setText(bVar.g());
            TextView textView3 = this.mTopDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopDesc");
                textView3 = null;
            }
            textView3.setText(bVar.f());
            TextView textView4 = this.mPosDesc;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosDesc");
                textView4 = null;
            }
            textView4.setText(bVar.i());
            TextView textView5 = this.mNegDesc;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNegDesc");
            } else {
                textView2 = textView5;
            }
            textView2.setText(bVar.h());
        }
    }
}
