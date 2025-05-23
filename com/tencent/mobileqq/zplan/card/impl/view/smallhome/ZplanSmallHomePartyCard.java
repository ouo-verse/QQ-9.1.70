package com.tencent.mobileqq.zplan.card.impl.view.smallhome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.ZplanSmallHomePartyCard;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.anim.ZplanSmallHomePartyAnimHelper;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaPartyRoomData;
import com.tencent.sqshow.zootopia.utils.aa;
import fi3.aq;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.h;
import pv4.s;
import pv4.u;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00019\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0014R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/ZplanSmallHomePartyCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", "position", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "N", "P", "Lcom/tencent/sqshow/zootopia/data/o;", "roomData", "K", "L", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", BdhLogUtil.LogTag.Tag_Conn, "totalCount", "f", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", ExifInterface.LATITUDE_SOUTH, "I", "getItemViewType", "()I", "itemViewType", "Lfi3/aq;", "T", "Lfi3/aq;", "viewBinding", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper;", "U", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper;", "dataHelper", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper;", "V", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/anim/ZplanSmallHomePartyAnimHelper;", "animHelper", "W", "Z", "isRefreshing", "Lcom/tencent/sqshow/zootopia/card/report/a;", "a0", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "com/tencent/mobileqq/zplan/card/impl/view/smallhome/ZplanSmallHomePartyCard$a", "b0", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/ZplanSmallHomePartyCard$a;", "onCardDataRefreshCallback", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanSmallHomePartyCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: S, reason: from kotlin metadata */
    private final int itemViewType;

    /* renamed from: T, reason: from kotlin metadata */
    private aq viewBinding;

    /* renamed from: U, reason: from kotlin metadata */
    private final SmallHomePartyCardDataHelper dataHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private ZplanSmallHomePartyAnimHelper animHelper;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isRefreshing;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final a onCardDataRefreshCallback;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/ZplanSmallHomePartyCard$a", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper$b;", "Lcom/tencent/sqshow/zootopia/data/o;", "roomData", "", "b", "", "Lpv4/h;", "roomList", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements SmallHomePartyCardDataHelper.b {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper.b
        public void a(List<h> roomList) {
            Intrinsics.checkNotNullParameter(roomList, "roomList");
            ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyCard.this.animHelper;
            if (zplanSmallHomePartyAnimHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animHelper");
                zplanSmallHomePartyAnimHelper = null;
            }
            zplanSmallHomePartyAnimHelper.m(roomList, false);
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper.b
        public void b(ZootopiaPartyRoomData roomData) {
            Intrinsics.checkNotNullParameter(roomData, "roomData");
            ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = ZplanSmallHomePartyCard.this.animHelper;
            if (zplanSmallHomePartyAnimHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animHelper");
                zplanSmallHomePartyAnimHelper = null;
            }
            ZplanSmallHomePartyAnimHelper.n(zplanSmallHomePartyAnimHelper, roomData.d(), false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanSmallHomePartyCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.owner = owner;
        this.itemViewType = i3;
        this.dataHelper = new SmallHomePartyCardDataHelper();
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
        this.onCardDataRefreshCallback = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ZplanSmallHomePartyCard this$0, int i3, ZootopiaCardData dataInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        this$0.L();
        this$0.P(i3, dataInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ZplanSmallHomePartyCard this$0, int i3, ZootopiaCardData dataInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        this$0.L();
        this$0.P(i3, dataInfo);
    }

    private final void K(ZootopiaPartyRoomData roomData) {
        this.dataHelper.m(roomData);
        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = this.animHelper;
        if (zplanSmallHomePartyAnimHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animHelper");
            zplanSmallHomePartyAnimHelper = null;
        }
        zplanSmallHomePartyAnimHelper.i(roomData.d());
        this.dataHelper.d();
        this.dataHelper.p(this.onCardDataRefreshCallback);
    }

    private final void L() {
        if (this.isRefreshing) {
            return;
        }
        Animation refreshAnim = AnimationUtils.loadAnimation(getContext(), R.anim.k3);
        aq aqVar = this.viewBinding;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        aqVar.f398899o.startAnimation(refreshAnim);
        Intrinsics.checkNotNullExpressionValue(refreshAnim, "refreshAnim");
        com.tencent.mobileqq.zootopia.utils.a.b(refreshAnim, new Runnable() { // from class: vf3.d
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomePartyCard.M(ZplanSmallHomePartyCard.this);
            }
        });
        this.dataHelper.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ZplanSmallHomePartyCard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isRefreshing = false;
    }

    private final void N(final int position, final ZootopiaCardData dataInfo) {
        aq aqVar = this.viewBinding;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        aqVar.f398899o.post(new Runnable() { // from class: vf3.c
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomePartyCard.O(ZplanSmallHomePartyCard.this, position, dataInfo);
            }
        });
    }

    private final void P(int position, ZootopiaCardData dataInfo) {
        com.tencent.sqshow.zootopia.card.report.a aVar = this.reportHelper;
        aq aqVar = this.viewBinding;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        View view = aqVar.f398899o;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.iconChange");
        aVar.a(view, position, 0, "", dataInfo, new s(), (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : "em_zplan_change_batch");
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    protected boolean C() {
        return false;
    }

    @Override // l84.a
    public void f(final ZootopiaCardData dataInfo, final int position, int totalCount) {
        String str;
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        aq aqVar = this.viewBinding;
        aq aqVar2 = null;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        TextView textView = aqVar.f398892h;
        u title = dataInfo.getTitleData().getTitle();
        if (title == null || (str = title.f427702a) == null) {
            str = "\u52a0\u5165\u6d3e\u5bf9";
        }
        textView.setText(str);
        ZplanSmallHomePartyAnimHelper zplanSmallHomePartyAnimHelper = this.animHelper;
        if (zplanSmallHomePartyAnimHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animHelper");
            zplanSmallHomePartyAnimHelper = null;
        }
        zplanSmallHomePartyAnimHelper.o(dataInfo, position);
        ZootopiaPartyRoomData mCachePartyRoomData = this.dataHelper.getMCachePartyRoomData();
        if (mCachePartyRoomData == null) {
            mCachePartyRoomData = dataInfo.getPartyRoomData();
        }
        if (mCachePartyRoomData != null) {
            K(mCachePartyRoomData);
        }
        aq aqVar3 = this.viewBinding;
        if (aqVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            aqVar2 = aqVar3;
        }
        View iconChange = aqVar2.f398899o;
        Intrinsics.checkNotNullExpressionValue(iconChange, "iconChange");
        aa.d(iconChange, new View.OnClickListener() { // from class: vf3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSmallHomePartyCard.I(ZplanSmallHomePartyCard.this, position, dataInfo, view);
            }
        });
        TextView txtChange = aqVar2.f398900p;
        Intrinsics.checkNotNullExpressionValue(txtChange, "txtChange");
        aa.d(txtChange, new View.OnClickListener() { // from class: vf3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSmallHomePartyCard.J(ZplanSmallHomePartyCard.this, position, dataInfo, view);
            }
        });
        N(position, dataInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dataHelper.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dataHelper.e();
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        aq f16 = aq.f(LayoutInflater.from(context), viewParent);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), viewParent)");
        this.viewBinding = f16;
        aq aqVar = this.viewBinding;
        aq aqVar2 = null;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        this.animHelper = new ZplanSmallHomePartyAnimHelper(context, aqVar);
        setBackgroundColor(-1);
        aq aqVar3 = this.viewBinding;
        if (aqVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            aqVar2 = aqVar3;
        }
        View mRv = aqVar2.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "viewBinding.root");
        return mRv;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZplanSmallHomePartyCard";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(ZplanSmallHomePartyCard this$0, int i3, ZootopiaCardData dataInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        com.tencent.sqshow.zootopia.card.report.a aVar = this$0.reportHelper;
        aq aqVar = this$0.viewBinding;
        if (aqVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aqVar = null;
        }
        View view = aqVar.f398899o;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.iconChange");
        aVar.c(view, i3, 0, "", dataInfo, new s(), (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : "em_zplan_change_batch", (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }
}
