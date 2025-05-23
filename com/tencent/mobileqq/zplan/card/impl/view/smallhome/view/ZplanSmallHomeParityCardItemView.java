package com.tencent.mobileqq.zplan.card.impl.view.smallhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZplanSmallHomeParityCardItemView;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.state.report.SquareReportConst;
import fi3.ar;
import gi3.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J2\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\tH\u0014R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZplanSmallHomeParityCardItemView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "itemPosition", "cardPosition", "Lpv4/h;", "partyRoom", "", "g", "", "elementId", "f", "e", "d", "cardData", "i", NodeProps.ON_ATTACHED_TO_WINDOW, "Lfi3/ar;", "Lfi3/ar;", "viewBinding", "Lcom/tencent/sqshow/zootopia/card/report/a;", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Lcom/tencent/sqshow/zootopia/data/c;", "cardDataInfo", h.F, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lpv4/h;", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "needReportWhenAttachToWindow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanSmallHomeParityCardItemView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean needReportWhenAttachToWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ar viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a reportHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaCardData cardDataInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int cardPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int itemPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private pv4.h partyRoom;

    public ZplanSmallHomeParityCardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar f16 = ar.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
        this.reportHelper = new a();
        setBackgroundResource(R.drawable.h_n);
    }

    private final void e(pv4.h partyRoom) {
        if (!partyRoom.f427613j) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = partyRoom.f427610g;
            Intrinsics.checkNotNullExpressionValue(str, "partyRoom.visitSchema");
            iSchemeApi.launchScheme(context, str);
            return;
        }
        QQToast.makeText(getContext(), 0, "\u592a\u706b\u7206\u5566\uff0c\u770b\u770b\u522b\u7684\u6d3e\u5bf9\u5427", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZplanSmallHomeParityCardItemView this$0, pv4.h partyRoom, ZootopiaCardData zootopiaCardData, int i3, int i16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partyRoom, "$partyRoom");
        this$0.e(partyRoom);
        this$0.f(zootopiaCardData, i3, i16, partyRoom, "em_zplan_other_xiaowo_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ZplanSmallHomeParityCardItemView this$0, pv4.h partyRoom, ZootopiaCardData zootopiaCardData, int i3, int i16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partyRoom, "$partyRoom");
        this$0.e(partyRoom);
        this$0.f(zootopiaCardData, i3, i16, partyRoom, "em_zplan_element");
    }

    public final void d(pv4.h partyRoom, ZootopiaCardData dataInfo, int cardPosition, int itemPosition) {
        boolean z16;
        Intrinsics.checkNotNullParameter(partyRoom, "partyRoom");
        a.Companion companion = gi3.a.INSTANCE;
        TextView textView = this.viewBinding.f398911k;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.txtTitle");
        String str = partyRoom.f427611h.f427615b;
        Intrinsics.checkNotNullExpressionValue(str, "partyRoom.owner.nickName");
        companion.b(textView, str, 16);
        this.viewBinding.f398904d.setRadius(i.e(12));
        RoundCornerImageView roundCornerImageView = this.viewBinding.f398904d;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "viewBinding.iconHead");
        String str2 = partyRoom.f427611h.f427614a;
        Intrinsics.checkNotNullExpressionValue(str2, "partyRoom.owner.headUrl");
        CommonExKt.w(roundCornerImageView, str2, null, null, 6, null);
        i(partyRoom, dataInfo, itemPosition, cardPosition);
        if (isAttachedToWindow()) {
            g(this.cardDataInfo, itemPosition, cardPosition, partyRoom);
            z16 = false;
        } else {
            z16 = true;
        }
        this.needReportWhenAttachToWindow = z16;
    }

    public final void i(final pv4.h partyRoom, final ZootopiaCardData cardData, final int itemPosition, final int cardPosition) {
        Intrinsics.checkNotNullParameter(partyRoom, "partyRoom");
        a.Companion companion = gi3.a.INSTANCE;
        TextView textView = this.viewBinding.f398909i;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.txtDesc");
        String str = partyRoom.f427605b.f427583e;
        Intrinsics.checkNotNullExpressionValue(str, "partyRoom.content.msg");
        companion.b(textView, str, 16);
        this.viewBinding.f398910j.setText(partyRoom.f427606c);
        this.viewBinding.f398912l.setText(partyRoom.f427607d);
        this.viewBinding.f398906f.setVisibility(partyRoom.f427608e == 1 ? 0 : 8);
        TextView textView2 = this.viewBinding.f398903c;
        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.btnVisit");
        aa.d(textView2, new View.OnClickListener() { // from class: xf3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSmallHomeParityCardItemView.j(ZplanSmallHomeParityCardItemView.this, partyRoom, cardData, itemPosition, cardPosition, view);
            }
        });
        aa.d(this, new View.OnClickListener() { // from class: xf3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSmallHomeParityCardItemView.k(ZplanSmallHomeParityCardItemView.this, partyRoom, cardData, itemPosition, cardPosition, view);
            }
        });
        this.partyRoom = partyRoom;
        this.cardDataInfo = cardData;
        this.itemPosition = itemPosition;
        this.cardPosition = cardPosition;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        pv4.h hVar;
        super.onAttachedToWindow();
        if (!this.needReportWhenAttachToWindow || (hVar = this.partyRoom) == null) {
            return;
        }
        g(this.cardDataInfo, this.itemPosition, this.cardPosition, hVar);
    }

    private final void f(ZootopiaCardData dataInfo, int itemPosition, int cardPosition, pv4.h partyRoom, String elementId) {
        HashMap<String, Object> hashMapOf;
        if (dataInfo != null) {
            com.tencent.sqshow.zootopia.card.report.a aVar = this.reportHelper;
            TextView textView = this.viewBinding.f398903c;
            Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.btnVisit");
            s sVar = new s();
            String str = partyRoom.f427604a;
            Intrinsics.checkNotNullExpressionValue(str, "partyRoom.roomId");
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(SquareReportConst.Key.KEY_IS_ROOM_ID, str));
            aVar.a(textView, cardPosition, itemPosition, "4", dataInfo, sVar, hashMapOf, elementId);
        }
    }

    private final void g(final ZootopiaCardData dataInfo, final int itemPosition, final int cardPosition, final pv4.h partyRoom) {
        if (dataInfo != null) {
            post(new Runnable() { // from class: xf3.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanSmallHomeParityCardItemView.h(ZplanSmallHomeParityCardItemView.this, cardPosition, itemPosition, dataInfo, dataInfo, partyRoom);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZplanSmallHomeParityCardItemView this$0, int i3, int i16, ZootopiaCardData zootopiaCardData, ZootopiaCardData it, pv4.h partyRoom) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(partyRoom, "$partyRoom");
        com.tencent.sqshow.zootopia.card.report.a aVar = this$0.reportHelper;
        View root = this$0.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        String valueOf = String.valueOf(zootopiaCardData.getType());
        s sVar = new s();
        String str = partyRoom.f427604a;
        Intrinsics.checkNotNullExpressionValue(str, "partyRoom.roomId");
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(SquareReportConst.Key.KEY_IS_ROOM_ID, str));
        aVar.c(root, i3, i16, valueOf, it, sVar, (r24 & 64) != 0 ? new HashMap() : hashMapOf, (r24 & 128) != 0 ? "em_zplan_element" : "em_zplan_element", (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
        com.tencent.sqshow.zootopia.card.report.a aVar2 = this$0.reportHelper;
        TextView textView = this$0.viewBinding.f398903c;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.btnVisit");
        s sVar2 = new s();
        String str2 = partyRoom.f427604a;
        Intrinsics.checkNotNullExpressionValue(str2, "partyRoom.roomId");
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(new Pair(SquareReportConst.Key.KEY_IS_ROOM_ID, str2));
        aVar2.c(textView, i3, i16, "4", it, sVar2, (r24 & 64) != 0 ? new HashMap() : hashMapOf2, (r24 & 128) != 0 ? "em_zplan_element" : "em_zplan_other_xiaowo_btn", (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }
}
