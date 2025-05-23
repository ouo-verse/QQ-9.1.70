package com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZplanSmallHomeParityCardItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import fi3.aq;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b4\u00105J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0014\u0010\u0013\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bJ\u001e\u0010\u001a\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0018R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00020'j\b\u0012\u0004\u0012\u00020\u0002`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040'j\b\u0012\u0004\u0012\u00020\u0004`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00060'j\b\u0012\u0004\u0012\u00020\u0006`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper;", "", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZplanSmallHomeParityCardItemView;", "itemView", "Landroid/view/View;", "bgView", "Lpv4/h;", "newItemData", "", "itemPosition", "", "j", "l", "k", "index", "partyRoom", "p", "", "partyRoomList", "i", "Lcom/tencent/sqshow/zootopia/data/c;", "cardInfo", "cardPosition", "o", "", "showAnimSameRoom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lfi3/aq;", "b", "Lfi3/aq;", "getViewBinding", "()Lfi3/aq;", "viewBinding", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "roomItemList", "d", "itemBgList", "e", "currentShowRoomList", "f", "Lcom/tencent/sqshow/zootopia/data/c;", "g", "I", "<init>", "(Landroid/content/Context;Lfi3/aq;)V", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanSmallHomePartyAnimHelper {

    /* renamed from: h */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: from kotlin metadata */
    private final aq viewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private final ArrayList<ZplanSmallHomeParityCardItemView> roomItemList;

    /* renamed from: d, reason: from kotlin metadata */
    private final ArrayList<View> itemBgList;

    /* renamed from: e, reason: from kotlin metadata */
    private ArrayList<pv4.h> currentShowRoomList;

    /* renamed from: f, reason: from kotlin metadata */
    private ZootopiaCardData cardInfo;

    /* renamed from: g, reason: from kotlin metadata */
    private int cardPosition;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper$a;", "", "", "ANIM_DELAY", "J", "CHANGE_ANIM_DELAY", "", "MAX_ITEM_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper$a */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public ZplanSmallHomePartyAnimHelper(Context context, aq viewBinding) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.context = context;
        this.viewBinding = viewBinding;
        ArrayList<ZplanSmallHomeParityCardItemView> arrayList = new ArrayList<>();
        this.roomItemList = arrayList;
        ArrayList<View> arrayList2 = new ArrayList<>();
        this.itemBgList = arrayList2;
        this.currentShowRoomList = new ArrayList<>();
        arrayList.add(viewBinding.f398886b);
        arrayList.add(viewBinding.f398887c);
        arrayList.add(viewBinding.f398888d);
        arrayList.add(viewBinding.f398889e);
        arrayList.add(viewBinding.f398890f);
        arrayList.add(viewBinding.f398891g);
        arrayList2.add(viewBinding.f398893i);
        arrayList2.add(viewBinding.f398894j);
        arrayList2.add(viewBinding.f398895k);
        arrayList2.add(viewBinding.f398896l);
        arrayList2.add(viewBinding.f398897m);
        arrayList2.add(viewBinding.f398898n);
    }

    public final void p(int index, pv4.h partyRoom) {
        this.roomItemList.get(index).i(partyRoom, this.cardInfo, index, this.cardPosition);
    }

    public final void i(List<pv4.h> partyRoomList) {
        Intrinsics.checkNotNullParameter(partyRoomList, "partyRoomList");
        this.currentShowRoomList.clear();
        int i3 = 0;
        for (Object obj : partyRoomList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            pv4.h hVar = (pv4.h) obj;
            if (i3 < 6) {
                this.roomItemList.get(i3).setVisibility(0);
                this.roomItemList.get(i3).d(hVar, this.cardInfo, this.cardPosition, i3);
                this.itemBgList.get(i3).setVisibility(4);
                this.currentShowRoomList.add(partyRoomList.get(i3));
            }
            i3 = i16;
        }
        if (partyRoomList.size() < 6) {
            for (int size = this.currentShowRoomList.size(); size < 6; size++) {
                this.roomItemList.get(size).setVisibility(4);
                this.itemBgList.get(size).setVisibility(0);
            }
        }
    }

    public final void o(ZootopiaCardData cardInfo, int cardPosition) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.cardInfo = cardInfo;
        this.cardPosition = cardPosition;
    }

    public final void j(ZplanSmallHomeParityCardItemView itemView, View bgView, pv4.h newItemData, int itemPosition) {
        QLog.i("ZplanSmallHomePartyAnimHelper", 1, "playChangAnim");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154378jz);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, R.anim.f154379k0);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.context, R.anim.f154380k1);
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this.context, R.anim.f154381k2);
        itemView.startAnimation(loadAnimation2);
        bgView.startAnimation(loadAnimation4);
        bgView.setVisibility(0);
        loadAnimation4.setAnimationListener(new b(itemView, newItemData, this, itemPosition, loadAnimation, bgView, loadAnimation3));
        loadAnimation3.setAnimationListener(new c(bgView));
    }

    public final void k(ZplanSmallHomeParityCardItemView itemView, View bgView, pv4.h newItemData, int itemPosition) {
        QLog.i("ZplanSmallHomePartyAnimHelper", 1, "playInAnim");
        itemView.setVisibility(0);
        itemView.d(newItemData, this.cardInfo, this.cardPosition, itemPosition);
        bgView.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154378jz);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, R.anim.f154380k1);
        loadAnimation2.setAnimationListener(new d(bgView));
        itemView.startAnimation(loadAnimation);
        bgView.startAnimation(loadAnimation2);
    }

    public final void l(ZplanSmallHomeParityCardItemView itemView, View bgView) {
        QLog.i("ZplanSmallHomePartyAnimHelper", 1, "playOutAnim");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154379k0);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, R.anim.f154381k2);
        loadAnimation.setAnimationListener(new e(itemView));
        itemView.startAnimation(loadAnimation);
        bgView.setVisibility(0);
        bgView.startAnimation(loadAnimation2);
    }

    public final void m(final List<pv4.h> partyRoomList, boolean z16) {
        Intrinsics.checkNotNullParameter(partyRoomList, "partyRoomList");
        final int size = this.currentShowRoomList.size();
        QLog.i("ZplanSmallHomePartyAnimHelper", 1, "runRefreshAnim partyRoomList.size = " + partyRoomList.size() + " currentShowItemCount = " + size);
        int min = Math.min(size, partyRoomList.size());
        long j3 = 0;
        long j16 = 0L;
        for (final int i3 = 0; i3 < min; i3++) {
            if (!z16 && Intrinsics.areEqual(this.currentShowRoomList.get(i3).f427604a, partyRoomList.get(i3).f427604a)) {
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper$runRefreshAnim$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyAnimHelper.this;
                        int i16 = i3;
                        zplanSmallHomePartyAnimHelper.p(i16, partyRoomList.get(i16));
                    }
                });
            } else {
                CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper$runRefreshAnim$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyAnimHelper.this;
                        arrayList = zplanSmallHomePartyAnimHelper.roomItemList;
                        Object obj = arrayList.get(i3);
                        Intrinsics.checkNotNullExpressionValue(obj, "roomItemList[index]");
                        arrayList2 = ZplanSmallHomePartyAnimHelper.this.itemBgList;
                        Object obj2 = arrayList2.get(i3);
                        Intrinsics.checkNotNullExpressionValue(obj2, "itemBgList[index]");
                        zplanSmallHomePartyAnimHelper.j((ZplanSmallHomeParityCardItemView) obj, (View) obj2, partyRoomList.get(i3), i3);
                    }
                }, j16);
                j16 += 33;
            }
        }
        int size2 = partyRoomList.size();
        if (size > size2) {
            long j17 = 0;
            for (final int i16 = size2; i16 < size; i16++) {
                CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper$runRefreshAnim$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyAnimHelper.this;
                        arrayList = zplanSmallHomePartyAnimHelper.roomItemList;
                        Object obj = arrayList.get(i16);
                        Intrinsics.checkNotNullExpressionValue(obj, "roomItemList[index]");
                        arrayList2 = ZplanSmallHomePartyAnimHelper.this.itemBgList;
                        Object obj2 = arrayList2.get(i16);
                        Intrinsics.checkNotNullExpressionValue(obj2, "itemBgList[index]");
                        zplanSmallHomePartyAnimHelper.l((ZplanSmallHomeParityCardItemView) obj, (View) obj2);
                    }
                }, j17);
                j17 += 33;
            }
        }
        int min2 = Math.min(size2, 6);
        if (size < min2) {
            while (size < size2) {
                CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper$runRefreshAnim$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyAnimHelper.this;
                        arrayList = zplanSmallHomePartyAnimHelper.roomItemList;
                        Object obj = arrayList.get(size);
                        Intrinsics.checkNotNullExpressionValue(obj, "roomItemList[index]");
                        arrayList2 = ZplanSmallHomePartyAnimHelper.this.itemBgList;
                        Object obj2 = arrayList2.get(size);
                        Intrinsics.checkNotNullExpressionValue(obj2, "itemBgList[index]");
                        zplanSmallHomePartyAnimHelper.k((ZplanSmallHomeParityCardItemView) obj, (View) obj2, partyRoomList.get(size), size);
                    }
                }, j3);
                j3 += 33;
                size++;
            }
        }
        QLog.i("ZplanSmallHomePartyAnimHelper", 1, "runRefreshAnim playChangeAnimCount = " + min + " newItemSize = " + size2 + " outItemCount = " + min2);
        this.currentShowRoomList.clear();
        this.currentShowRoomList.addAll(partyRoomList.subList(0, min2));
    }

    public static /* synthetic */ void n(ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        zplanSmallHomePartyAnimHelper.m(list, z16);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ Animation C;

        /* renamed from: d */
        final /* synthetic */ ZplanSmallHomeParityCardItemView f332325d;

        /* renamed from: e */
        final /* synthetic */ pv4.h f332326e;

        /* renamed from: f */
        final /* synthetic */ ZplanSmallHomePartyAnimHelper f332327f;

        /* renamed from: h */
        final /* synthetic */ int f332328h;

        /* renamed from: i */
        final /* synthetic */ Animation f332329i;

        /* renamed from: m */
        final /* synthetic */ View f332330m;

        b(ZplanSmallHomeParityCardItemView zplanSmallHomeParityCardItemView, pv4.h hVar, ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper, int i3, Animation animation, View view, Animation animation2) {
            this.f332325d = zplanSmallHomeParityCardItemView;
            this.f332326e = hVar;
            this.f332327f = zplanSmallHomePartyAnimHelper;
            this.f332328h = i3;
            this.f332329i = animation;
            this.f332330m = view;
            this.C = animation2;
        }

        public static final void b(ZplanSmallHomeParityCardItemView itemView, Animation animation, View bgView, Animation animation2) {
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            Intrinsics.checkNotNullParameter(bgView, "$bgView");
            itemView.setVisibility(0);
            itemView.startAnimation(animation);
            bgView.startAnimation(animation2);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            this.f332325d.setVisibility(4);
            this.f332325d.d(this.f332326e, this.f332327f.cardInfo, this.f332327f.cardPosition, this.f332328h);
            final ZplanSmallHomeParityCardItemView zplanSmallHomeParityCardItemView = this.f332325d;
            final Animation animation = this.f332329i;
            final View view = this.f332330m;
            final Animation animation2 = this.C;
            zplanSmallHomeParityCardItemView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanSmallHomePartyAnimHelper.b.b(ZplanSmallHomeParityCardItemView.this, animation, view, animation2);
                }
            }, 100L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d */
        final /* synthetic */ View f332331d;

        c(View view) {
            this.f332331d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            this.f332331d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: d */
        final /* synthetic */ View f332332d;

        d(View view) {
            this.f332332d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            this.f332332d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: d */
        final /* synthetic */ ZplanSmallHomeParityCardItemView f332333d;

        e(ZplanSmallHomeParityCardItemView zplanSmallHomeParityCardItemView) {
            this.f332333d = zplanSmallHomeParityCardItemView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            this.f332333d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }
}
