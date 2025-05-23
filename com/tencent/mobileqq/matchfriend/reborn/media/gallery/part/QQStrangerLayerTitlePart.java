package com.tencent.mobileqq.matchfriend.reborn.media.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.event.QQStrangerGalleryEvent;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.part.QQStrangerLayerTitlePart$rightAction$2;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\t*\u0001\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/part/QQStrangerLayerTitlePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", "z9", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "x9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "com/tencent/mobileqq/matchfriend/reborn/media/gallery/part/QQStrangerLayerTitlePart$rightAction$2$a", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/part/QQStrangerLayerTitlePart$rightAction$2$a;", "rightAction", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLayerTitlePart extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy rightAction;

    public QQStrangerLayerTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerLayerTitlePart$rightAction$2.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.gallery.part.QQStrangerLayerTitlePart$rightAction$2

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/media/gallery/part/QQStrangerLayerTitlePart$rightAction$2$a", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
            public static final class a extends com.tencent.biz.qui.quisecnavbar.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ QQStrangerLayerTitlePart f245200a;

                a(QQStrangerLayerTitlePart qQStrangerLayerTitlePart) {
                    this.f245200a = qQStrangerLayerTitlePart;
                }

                @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
                public void a(View view) {
                    SimpleEventBus.getInstance().dispatchEvent(QQStrangerGalleryEvent.OnPhotoDeleteEvent.INSTANCE);
                    Activity activity = this.f245200a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }

                @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
                public boolean c() {
                    return false;
                }

                @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
                public int d() {
                    return R.drawable.qui_delete_icon_allwhite_primary_selector;
                }

                @Override // com.tencent.biz.qui.quisecnavbar.b
                public int getDrawable() {
                    return R.drawable.qui_delete_icon_allwhite_primary_selector;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(QQStrangerLayerTitlePart.this);
            }
        });
        this.rightAction = lazy;
    }

    private final QQStrangerLayerTitlePart$rightAction$2.a A9() {
        return (QQStrangerLayerTitlePart$rightAction$2.a) this.rightAction.getValue();
    }

    private final QUISecNavBar x9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setRightType(2);
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_allwhite_primary_selector);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.gallery.part.QQStrangerLayerTitlePart$createTitle$1$1
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
                    QQStrangerLayerTitlePart.this.getActivity().finish();
                }
            }
        });
        qUISecNavBar.d(A9());
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
