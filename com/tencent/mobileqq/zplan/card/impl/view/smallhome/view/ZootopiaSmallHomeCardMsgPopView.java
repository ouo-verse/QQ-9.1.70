package com.tencent.mobileqq.zplan.card.impl.view.smallhome.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.utils.a;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardMsgPopView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import fi3.ae;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.d;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0019\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001b\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0007R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u001cj\b\u0012\u0004\u0012\u00020\u0010`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZootopiaSmallHomeCardMsgPopView;", "Landroid/widget/FrameLayout;", "", "position", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZplanSmallHomeCardMsgPopItemView;", "g", "view", "", "f", h.F, "k", ParseCommon.CONTAINER, "j", "tempPosition", "e", "", "Lpv4/d;", "dataArray", "setData", "([Lpv4/d;)V", "Lcom/tencent/sqshow/zootopia/data/c;", "cardData", "setCardData", "i", "Lfi3/ae;", "d", "Lfi3/ae;", "viewBinding", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "I", "", "Z", "isAnimRunning", "stopAnim", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSmallHomeCardMsgPopView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ae viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<d> itemList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimRunning;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean stopAnim;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZootopiaCardData cardData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSmallHomeCardMsgPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemList = new ArrayList<>();
        ae f16 = ae.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
    }

    private final void f(ZplanSmallHomeCardMsgPopItemView view, int position) {
        QLog.i("ZootopiaSmallHomeCardMsgPopView", 4, "bindItemView position:" + position);
        d dVar = this.itemList.get(position);
        Intrinsics.checkNotNullExpressionValue(dVar, "itemList[position]");
        view.b(dVar, position, this.cardData);
    }

    private final ZplanSmallHomeCardMsgPopItemView g(int position) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new ZplanSmallHomeCardMsgPopItemView(context);
    }

    private final int h() {
        return this.itemList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AnimatorSet animSetTop) {
        Intrinsics.checkNotNullParameter(animSetTop, "$animSetTop");
        animSetTop.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final ZootopiaSmallHomeCardMsgPopView this$0, final FrameLayout itemTop, final FrameLayout itemMid, final FrameLayout itemBottom) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemTop, "$itemTop");
        Intrinsics.checkNotNullParameter(itemMid, "$itemMid");
        Intrinsics.checkNotNullParameter(itemBottom, "$itemBottom");
        if (this$0.stopAnim) {
            return;
        }
        this$0.postDelayed(new Runnable() { // from class: xf3.e
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaSmallHomeCardMsgPopView.n(ZootopiaSmallHomeCardMsgPopView.this, itemTop, itemMid, itemBottom);
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZootopiaSmallHomeCardMsgPopView this$0, FrameLayout itemTop, FrameLayout itemMid, FrameLayout itemBottom) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemTop, "$itemTop");
        Intrinsics.checkNotNullParameter(itemMid, "$itemMid");
        Intrinsics.checkNotNullParameter(itemBottom, "$itemBottom");
        this$0.j(itemTop);
        this$0.j(itemMid);
        this$0.j(itemBottom);
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FrameLayout itemBottom) {
        Intrinsics.checkNotNullParameter(itemBottom, "$itemBottom");
        itemBottom.setPivotX(itemBottom.getWidth() / 2.0f);
        itemBottom.setPivotY(i.e(40));
    }

    public final void i() {
        if (h() == 0) {
            this.viewBinding.f398802b.setVisibility(8);
            this.viewBinding.f398803c.setVisibility(8);
            this.viewBinding.f398804d.setVisibility(8);
            return;
        }
        if (h() == 1) {
            this.viewBinding.f398802b.setVisibility(8);
            this.viewBinding.f398803c.setVisibility(0);
            this.viewBinding.f398804d.setVisibility(8);
            FrameLayout frameLayout = this.viewBinding.f398803c;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.container2");
            e(frameLayout, 0);
            this.stopAnim = true;
            return;
        }
        if (h() == 2) {
            this.viewBinding.f398802b.setVisibility(0);
            this.viewBinding.f398803c.setVisibility(0);
            this.viewBinding.f398804d.setVisibility(8);
            FrameLayout frameLayout2 = this.viewBinding.f398802b;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "viewBinding.container1");
            e(frameLayout2, 0);
            FrameLayout frameLayout3 = this.viewBinding.f398803c;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "viewBinding.container2");
            e(frameLayout3, 1);
            this.stopAnim = true;
            return;
        }
        if (this.isAnimRunning) {
            return;
        }
        this.viewBinding.f398802b.setVisibility(0);
        this.viewBinding.f398803c.setVisibility(0);
        this.viewBinding.f398804d.setVisibility(0);
        this.stopAnim = false;
        k();
    }

    public final void setCardData(ZootopiaCardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        this.cardData = cardData;
    }

    public final void setData(d[] dataArray) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        this.itemList.clear();
        CollectionsKt__MutableCollectionsKt.addAll(this.itemList, dataArray);
    }

    private final void e(FrameLayout container, int tempPosition) {
        View childAt = container.getChildAt(0);
        ZplanSmallHomeCardMsgPopItemView zplanSmallHomeCardMsgPopItemView = childAt instanceof ZplanSmallHomeCardMsgPopItemView ? (ZplanSmallHomeCardMsgPopItemView) childAt : null;
        if (zplanSmallHomeCardMsgPopItemView == null) {
            zplanSmallHomeCardMsgPopItemView = g(this.position);
            container.removeAllViews();
            container.addView(zplanSmallHomeCardMsgPopItemView);
        }
        f(zplanSmallHomeCardMsgPopItemView, tempPosition);
    }

    private final void j(FrameLayout container) {
        container.setTranslationY(0.0f);
        container.setScaleX(1.0f);
        container.setScaleY(1.0f);
        container.setAlpha(1.0f);
    }

    private final void k() {
        final FrameLayout frameLayout = this.viewBinding.f398802b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.container1");
        final FrameLayout frameLayout2 = this.viewBinding.f398803c;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "viewBinding.container2");
        final FrameLayout frameLayout3 = this.viewBinding.f398804d;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "viewBinding.container3");
        int i3 = this.position + 1;
        if (i3 >= h()) {
            i3 = 0;
        }
        int i16 = i3 + 1;
        if (i16 >= h()) {
            i16 = 0;
        }
        e(frameLayout, this.position);
        e(frameLayout2, i3);
        e(frameLayout3, i16);
        int i17 = this.position + 1;
        this.position = i17;
        if (i17 >= h()) {
            this.position = 0;
        }
        float b16 = 0.0f - i.b(35);
        ObjectAnimator animTransYTop = ObjectAnimator.ofFloat(frameLayout, "translationY", 0.0f, b16);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.2f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.2f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(frameLayout, c.f123400v, 1.0f, 0.0f);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animTransYTop.setDuration(300L);
        animatorSet.setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(animTransYTop, "animTransYTop");
        a.a(animTransYTop, new Runnable() { // from class: xf3.b
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaSmallHomeCardMsgPopView.l(animatorSet);
            }
        });
        a.a(animatorSet, new Runnable() { // from class: xf3.c
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaSmallHomeCardMsgPopView.m(ZootopiaSmallHomeCardMsgPopView.this, frameLayout, frameLayout2, frameLayout3);
            }
        });
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(frameLayout2, "translationY", 0.0f, b16);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(frameLayout3, BasicAnimation.KeyPath.SCALE_X, 0.2f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(frameLayout3, BasicAnimation.KeyPath.SCALE_Y, 0.2f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(frameLayout3, c.f123400v, 0.2f, 1.0f);
        post(new Runnable() { // from class: xf3.d
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaSmallHomeCardMsgPopView.o(frameLayout3);
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat4);
        animatorSet2.play(ofFloat5);
        animatorSet2.play(ofFloat6);
        animatorSet2.play(ofFloat7);
        animatorSet2.setDuration(500L);
        animTransYTop.start();
        animatorSet2.start();
        this.isAnimRunning = true;
    }
}
