package com.tencent.mobileqq.weather.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0012R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/g;", "Lcom/tencent/mobileqq/weather/adapter/b;", "", "topHighLight", "bottomHighLight", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/d;", "Lkotlin/collections/ArrayList;", "data", "l", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "mTopLayout", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTopName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mTopImage", "H", "mTopTitle", "I", "mTopDesc", "J", "mBottomLayout", "K", "mBottomTitle", "L", "mBottomName", "M", "mBottomDesc", "N", "mBottomImage", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private RelativeLayout mTopLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTopName;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mTopImage;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTopTitle;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mTopDesc;

    /* renamed from: J, reason: from kotlin metadata */
    private RelativeLayout mBottomLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mBottomTitle;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mBottomName;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView mBottomDesc;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView mBottomImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View this_run, com.tencent.mobileqq.weather.data.d topData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(topData, "$topData");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Context context = this_run.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gVar.O(context, topData.g());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View this_run, com.tencent.mobileqq.weather.data.d bottomData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(bottomData, "$bottomData");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Context context = this_run.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gVar.O(context, bottomData.g());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(boolean topHighLight, boolean bottomHighLight) {
        int i3;
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mTopTitle;
            RelativeLayout relativeLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitle");
                textView = null;
            }
            int i16 = SupportMenu.CATEGORY_MASK;
            if (topHighLight) {
                i3 = -65536;
            } else {
                i3 = -1;
            }
            textView.setTextColor(i3);
            TextView textView2 = this.mBottomTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomTitle");
                textView2 = null;
            }
            if (!bottomHighLight) {
                i16 = -1;
            }
            textView2.setTextColor(i16);
            TextView textView3 = this.mTopDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopDesc");
                textView3 = null;
            }
            textView3.setTextColor(-1);
            TextView textView4 = this.mBottomDesc;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomDesc");
                textView4 = null;
            }
            textView4.setTextColor(-1);
            RelativeLayout relativeLayout2 = this.mTopLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setBackgroundColor(Color.parseColor("#313131"));
            RelativeLayout relativeLayout3 = this.mBottomLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomLayout");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setBackgroundColor(Color.parseColor("#313131"));
        }
    }

    @Override // com.tencent.mobileqq.weather.adapter.b
    public void l(@NotNull ArrayList<com.tencent.mobileqq.weather.data.d> data) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        final View view = this.itemView;
        View findViewById = view.findViewById(R.id.smq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.almanac_top_layout)");
        this.mTopLayout = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.smt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.almanac_top_pos_title)");
        this.mTopTitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.sms);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.almanac_top_pos_desc)");
        this.mTopDesc = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.smr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.almanac_top_name)");
        this.mTopName = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.smp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.almanac_top_icon)");
        this.mTopImage = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f164300sm4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.almanac_bottom_layout)");
        this.mBottomLayout = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.sm7);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.almanac_bottom_pos_title)");
        this.mBottomTitle = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.sm6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.almanac_bottom_pos_desc)");
        this.mBottomDesc = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.sm5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.almanac_bottom_name)");
        this.mBottomName = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f164299sm3);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.almanac_bottom_icon)");
        this.mBottomImage = (ImageView) findViewById10;
        com.tencent.mobileqq.weather.data.d dVar = data.get(0);
        Intrinsics.checkNotNullExpressionValue(dVar, "data[0]");
        final com.tencent.mobileqq.weather.data.d dVar2 = dVar;
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        RelativeLayout relativeLayout = null;
        if (gVar.D()) {
            RelativeLayout relativeLayout2 = this.mTopLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.o(view, dVar2, view2);
                }
            });
        }
        TextView textView = this.mTopName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopName");
            textView = null;
        }
        textView.setText(dVar2.d());
        ImageView imageView = this.mTopImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopImage");
            imageView = null;
        }
        imageView.setImageDrawable(view.getContext().getDrawable(dVar2.c()));
        TextView textView2 = this.mTopTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitle");
            textView2 = null;
        }
        textView2.setText(dVar2.f());
        TextView textView3 = this.mTopTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitle");
            textView3 = null;
        }
        boolean b16 = dVar2.b();
        int i16 = SupportMenu.CATEGORY_MASK;
        if (b16) {
            i3 = -65536;
        } else {
            i3 = -16777216;
        }
        textView3.setTextColor(i3);
        TextView textView4 = this.mTopDesc;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopDesc");
            textView4 = null;
        }
        textView4.setText(dVar2.a());
        com.tencent.mobileqq.weather.data.d dVar3 = data.get(1);
        Intrinsics.checkNotNullExpressionValue(dVar3, "data[1]");
        final com.tencent.mobileqq.weather.data.d dVar4 = dVar3;
        if (gVar.D()) {
            RelativeLayout relativeLayout3 = this.mBottomLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.p(view, dVar4, view2);
                }
            });
        }
        TextView textView5 = this.mBottomName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomName");
            textView5 = null;
        }
        textView5.setText(dVar4.d());
        ImageView imageView2 = this.mBottomImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomImage");
            imageView2 = null;
        }
        imageView2.setImageDrawable(view.getContext().getDrawable(dVar4.c()));
        TextView textView6 = this.mBottomTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomTitle");
            textView6 = null;
        }
        textView6.setText(dVar4.f());
        TextView textView7 = this.mBottomTitle;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomTitle");
            textView7 = null;
        }
        if (!dVar4.b()) {
            i16 = -16777216;
        }
        textView7.setTextColor(i16);
        TextView textView8 = this.mBottomDesc;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomDesc");
            textView8 = null;
        }
        textView8.setText(dVar4.a());
        q(dVar2.b(), dVar4.b());
        RelativeLayout relativeLayout4 = this.mTopLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopLayout");
            relativeLayout4 = null;
        }
        com.tencent.mobileqq.weather.util.b.j(relativeLayout4, 5.0f);
        RelativeLayout relativeLayout5 = this.mBottomLayout;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomLayout");
        } else {
            relativeLayout = relativeLayout5;
        }
        com.tencent.mobileqq.weather.util.b.j(relativeLayout, 5.0f);
    }
}
