package com.tencent.mobileqq.zplan.card.impl.view.smallhome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.ZplanSmallHomeStatusCard;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.b;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardBottomView;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardMsgPopView;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import fi3.ac;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.d;
import pv4.o;
import pv4.s;
import pv4.x;
import qv4.ap;
import zu4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001>B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010%\u001a\u00020\u0006\u00a2\u0006\u0004\b;\u0010<J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0014J\b\u0010\u001b\u001a\u00020\nH\u0014R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/ZplanSmallHomeStatusCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "", "elementId", "", "K", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "I", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "totalCount", "f", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", ExifInterface.LATITUDE_SOUTH, "getItemViewType", "()I", "itemViewType", "Lfi3/ac;", "T", "Lfi3/ac;", "cardViewBinding", "Lcom/tencent/sqshow/zootopia/card/report/a;", "U", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "V", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "dataHelper", "Landroidx/lifecycle/Observer;", "Lzu4/f;", "W", "Landroidx/lifecycle/Observer;", "observer", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "a0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanSmallHomeStatusCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: S, reason: from kotlin metadata */
    private final int itemViewType;

    /* renamed from: T, reason: from kotlin metadata */
    private ac cardViewBinding;

    /* renamed from: U, reason: from kotlin metadata */
    private final a reportHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private final b dataHelper;

    /* renamed from: W, reason: from kotlin metadata */
    private final Observer<f> observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanSmallHomeStatusCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.owner = owner;
        this.itemViewType = i3;
        this.reportHelper = new a();
        this.dataHelper = new b();
        this.observer = new Observer() { // from class: vf3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeStatusCard.J(ZplanSmallHomeStatusCard.this, (zu4.f) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(x xVar, ZplanSmallHomeStatusCard this$0, int i3, ZootopiaCardData dataInfo, View it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        if (xVar != null && (str = xVar.f427721e) != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, str);
        }
        a aVar = this$0.reportHelper;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.a(it, i3, 0, "", dataInfo, new s(), this$0.I(dataInfo), "em_zplan_mod_area");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZplanSmallHomeStatusCard this$0, View it, ZootopiaCardData dataInfo, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        this$0.K(it, dataInfo, i3, "em_zplan_mod_area");
    }

    private final HashMap<String, Object> I(ZootopiaCardData dataInfo) {
        Object obj;
        o oVar;
        HashMap<String, Object> hashMap = new HashMap<>();
        x smallHomeData = dataInfo.getSmallHomeData();
        ap apVar = null;
        byte[] bArr = (smallHomeData == null || (oVar = smallHomeData.f427725i) == null) ? null : oVar.f427646d;
        if (bArr == null) {
            return hashMap;
        }
        try {
            apVar = ap.d(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (apVar != null) {
            obj = Integer.valueOf(apVar.f429974a);
        } else {
            obj = "0";
        }
        hashMap.put("zplan_map_id", obj);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ZplanSmallHomeStatusCard this$0, f fVar) {
        d[] dVarArr;
        ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView;
        ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fVar == null || (dVarArr = fVar.f453435a) == null) {
            return;
        }
        QLog.i("ZplanSmallHomeStatusCard", 1, "onRefresh pop data");
        ac acVar = this$0.cardViewBinding;
        if (acVar != null && (zootopiaSmallHomeCardMsgPopView2 = acVar.f398790d) != null) {
            zootopiaSmallHomeCardMsgPopView2.setData(dVarArr);
        }
        ac acVar2 = this$0.cardViewBinding;
        if (acVar2 == null || (zootopiaSmallHomeCardMsgPopView = acVar2.f398790d) == null) {
            return;
        }
        zootopiaSmallHomeCardMsgPopView.i();
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public boolean A() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r9.f427723g == true) goto L18;
     */
    @Override // l84.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(final ZootopiaCardData dataInfo, final int position, int totalCount) {
        boolean z16;
        ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView;
        final View mContainer;
        ZPlanMediaView zPlanMediaView;
        ZPlanMediaView zPlanMediaView2;
        ZPlanMediaView zPlanMediaView3;
        ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView2;
        View mContainer2;
        ZootopiaSmallHomeCardBottomView zootopiaSmallHomeCardBottomView;
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        ac acVar = this.cardViewBinding;
        if (acVar != null && (zootopiaSmallHomeCardBottomView = acVar.f398789c) != null) {
            zootopiaSmallHomeCardBottomView.A0(dataInfo, o(), r(), p(), position);
        }
        final x smallHomeData = dataInfo.getSmallHomeData();
        ac acVar2 = this.cardViewBinding;
        if (acVar2 != null && (mContainer2 = acVar2.getMContainer()) != null) {
            mContainer2.setOnClickListener(new View.OnClickListener() { // from class: vf3.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanSmallHomeStatusCard.G(x.this, this, position, dataInfo, view);
                }
            });
        }
        if (smallHomeData != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            ac acVar3 = this.cardViewBinding;
            zootopiaSmallHomeCardMsgPopView = acVar3 != null ? acVar3.f398790d : null;
            if (zootopiaSmallHomeCardMsgPopView != null) {
                zootopiaSmallHomeCardMsgPopView.setVisibility(0);
            }
            this.dataHelper.n();
            this.dataHelper.h().observe(o(), this.observer);
            int i3 = smallHomeData.f427724h;
            if (i3 > 0) {
                this.dataHelper.c(i3 * 1000);
                this.dataHelper.d();
                ac acVar4 = this.cardViewBinding;
                if (acVar4 != null && (zootopiaSmallHomeCardMsgPopView2 = acVar4.f398790d) != null) {
                    zootopiaSmallHomeCardMsgPopView2.setCardData(dataInfo);
                    K(zootopiaSmallHomeCardMsgPopView2, dataInfo, position, "em_zplan_xw_msg_bubble");
                }
            }
        } else {
            ac acVar5 = this.cardViewBinding;
            zootopiaSmallHomeCardMsgPopView = acVar5 != null ? acVar5.f398790d : null;
            if (zootopiaSmallHomeCardMsgPopView != null) {
                zootopiaSmallHomeCardMsgPopView.setVisibility(8);
            }
        }
        x smallHomeData2 = dataInfo.getSmallHomeData();
        if (smallHomeData2 != null) {
            ac acVar6 = this.cardViewBinding;
            if (acVar6 != null && (zPlanMediaView3 = acVar6.f398788b) != null) {
                zPlanMediaView3.setRadius(8);
            }
            ac acVar7 = this.cardViewBinding;
            if (acVar7 != null && (zPlanMediaView2 = acVar7.f398788b) != null) {
                g gVar = smallHomeData2.f427722f;
                Intrinsics.checkNotNullExpressionValue(gVar, "it.material");
                zPlanMediaView2.J(gVar);
            }
            ac acVar8 = this.cardViewBinding;
            if (acVar8 != null && (zPlanMediaView = acVar8.f398788b) != null) {
                g gVar2 = smallHomeData2.f427722f;
                Intrinsics.checkNotNullExpressionValue(gVar2, "it.material");
                zPlanMediaView.e(gVar2);
            }
        }
        ac acVar9 = this.cardViewBinding;
        if (acVar9 == null || (mContainer = acVar9.getMContainer()) == null) {
            return;
        }
        mContainer.post(new Runnable() { // from class: vf3.g
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeStatusCard.H(ZplanSmallHomeStatusCard.this, mContainer, dataInfo, position);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dataHelper.d();
        this.dataHelper.h().observe(o(), this.observer);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dataHelper.e();
        this.dataHelper.h().removeObserver(this.observer);
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        ac f16 = ac.f(LayoutInflater.from(context), viewParent);
        this.cardViewBinding = f16;
        View mContainer = f16 != null ? f16.getMContainer() : null;
        Intrinsics.checkNotNull(mContainer);
        return mContainer;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZplanSmallHomeStatusCard";
    }

    private final void K(View view, ZootopiaCardData dataInfo, int position, String elementId) {
        this.reportHelper.c(view, position, 0, "", dataInfo, new s(), (r24 & 64) != 0 ? new HashMap() : I(dataInfo), (r24 & 128) != 0 ? "em_zplan_element" : elementId, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }
}
