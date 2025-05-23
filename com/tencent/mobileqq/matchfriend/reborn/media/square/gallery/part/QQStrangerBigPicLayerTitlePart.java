package com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/square/gallery/part/QQStrangerBigPicLayerTitlePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", "z9", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "x9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerBigPicLayerTitlePart extends RFWLayerBasePart {
    private final QUISecNavBar x9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_allwhite_primary_selector);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerTitlePart$createTitle$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, BaseAction action) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (action == BaseAction.ACTION_LEFT_BUTTON) {
                    QQStrangerBigPicLayerTitlePart.this.getActivity().finish();
                }
            }
        });
        qUISecNavBar.setTitleAlpha(0.0f);
        return qUISecNavBar;
    }

    private final View z9() {
        View view = new View(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#B2000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        view.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.b(150));
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView(z9());
            QUISecNavBar x95 = x9();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(viewGroup.getContext());
            Unit unit = Unit.INSTANCE;
            viewGroup.addView(x95, layoutParams);
        }
    }
}
