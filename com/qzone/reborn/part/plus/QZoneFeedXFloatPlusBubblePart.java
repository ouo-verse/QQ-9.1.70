package com.qzone.reborn.part.plus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.util.j;
import com.qzone.reborn.feedx.viewmodel.q;
import com.qzone.reborn.util.l;
import com.qzone.util.ak;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import eo.c;
import ho.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q5.QZoneFloatPlusBubbleInfo;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0018\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/part/plus/QZoneFeedXFloatPlusBubblePart;", "Lcom/qzone/reborn/base/k;", "", "I9", "Landroid/view/View;", "anchorView", "Lq5/b;", "bubbleInfo", "L9", "uiRootView", "K9", "", "", "H9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "action", "", "args", "handleBroadcastMessage", "Lcom/qzone/reborn/feedx/viewmodel/q;", "d", "Lcom/qzone/reborn/feedx/viewmodel/q;", "mFeedxDataViewModel", "e", "Landroid/view/View;", "", "f", "Z", "needInterceptShowBubble", h.F, "Lq5/b;", "bubbleInfoData", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedXFloatPlusBubblePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private q mFeedxDataViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View anchorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needInterceptShowBubble;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneFloatPlusBubbleInfo bubbleInfoData;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/part/plus/QZoneFeedXFloatPlusBubblePart$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "onShow", "onDismiss", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneFloatPlusBubbleInfo f58501a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZoneFeedXFloatPlusBubblePart f58502b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f58503c;

        b(QZoneFloatPlusBubbleInfo qZoneFloatPlusBubbleInfo, QZoneFeedXFloatPlusBubblePart qZoneFeedXFloatPlusBubblePart, View view) {
            this.f58501a = qZoneFloatPlusBubbleInfo;
            this.f58502b = qZoneFeedXFloatPlusBubblePart;
            this.f58503c = view;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View v3) {
            eo.c.f396879a.b();
            com.qzone.business.tianshu.d.f44862a.e(this.f58501a);
            i.q(this.f58502b.getContext(), this.f58501a.getJumpUrl());
            ak.g(this.f58501a.getAdItem(), 102);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            this.f58502b.bubbleInfoData = null;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QZoneFeedXFloatPlusBubblePart qZoneFeedXFloatPlusBubblePart = this.f58502b;
            View contentView = this.f58503c;
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            qZoneFeedXFloatPlusBubblePart.K9(contentView, this.f58501a);
            ak.g(this.f58501a.getAdItem(), 101);
        }
    }

    private final void I9() {
        QLog.i("QZoneFeedXFloatPlusBubblePart", 1, "handleShowPlusIconLongClickBubble");
        this.needInterceptShowBubble = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(View uiRootView, QZoneFloatPlusBubbleInfo bubbleInfo) {
        fo.b bVar = new fo.b();
        bVar.l(H9(bubbleInfo));
        bVar.h(new c.a());
        Unit unit = Unit.INSTANCE;
        fo.c.b("dt_imp", uiRootView, "em_qz_plus_suspend_bubble", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(View anchorView, QZoneFloatPlusBubbleInfo bubbleInfo) {
        if (this.needInterceptShowBubble) {
            QLog.i("QZoneFeedXFloatPlusBubblePart", 1, "need intercept tian shu bubble show");
            this.bubbleInfoData = bubbleInfo;
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.beg, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mzi);
        if (textView != null) {
            textView.setText(bubbleInfo.getName());
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.mzh);
        if (textView2 != null) {
            textView2.setText(bubbleInfo.getText());
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.mzg);
        if (textView3 != null) {
            textView3.setVisibility(com.qzone.business.tianshu.d.f44862a.a(bubbleInfo) ? 0 : 8);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(bubbleInfo.getIcon()).setTargetView((ImageView) inflate.findViewById(R.id.mzf)));
        if (anchorView != null) {
            com.tencent.mobileqq.widget.tip.a.r(getContext()).S(anchorView).a0(inflate).R(2).k0(0).b0(5000L).g0(false).f(new b(bubbleInfo, this, inflate)).d0(true).W(getContext().getResources().getColor(R.color.qui_common_bg_top_light)).i0(ar.m(2.0f), ar.m(3.0f)).e0(true).s0();
            com.qzone.reborn.util.i.b().p(j.f55760a.k(1028), System.currentTimeMillis() / 1000);
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(1028);
            com.qzone.reborn.util.i.b().m("publish_plus_icon_tian_shu_entry", null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedXFloatPlusBubblePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "PLUS_ICON_LONG_CLICK_BUBBLE_IS_SHOWING")) {
            I9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(q.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFriend\u2026ataViewModel::class.java)");
        q qVar = (q) viewModel;
        this.mFeedxDataViewModel = qVar;
        com.qzone.business.tianshu.d dVar = com.qzone.business.tianshu.d.f44862a;
        q qVar2 = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedxDataViewModel");
            qVar = null;
        }
        dVar.b(qVar.G2());
        this.anchorView = rootView != null ? rootView.findViewById(R.id.n18) : null;
        q qVar3 = this.mFeedxDataViewModel;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedxDataViewModel");
        } else {
            qVar2 = qVar3;
        }
        MutableLiveData<QZoneFloatPlusBubbleInfo> G2 = qVar2.G2();
        Fragment hostFragment = getHostFragment();
        final Function1<QZoneFloatPlusBubbleInfo, Unit> function1 = new Function1<QZoneFloatPlusBubbleInfo, Unit>() { // from class: com.qzone.reborn.part.plus.QZoneFeedXFloatPlusBubblePart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneFloatPlusBubbleInfo qZoneFloatPlusBubbleInfo) {
                invoke2(qZoneFloatPlusBubbleInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneFloatPlusBubbleInfo bubbleInfo) {
                View view;
                RFWLog.d("QZoneFeedXFloatPlusBubblePart", RFWLog.USR, "begin show bubble part " + bubbleInfo + " " + Thread.currentThread());
                QZoneFeedXFloatPlusBubblePart qZoneFeedXFloatPlusBubblePart = QZoneFeedXFloatPlusBubblePart.this;
                view = qZoneFeedXFloatPlusBubblePart.anchorView;
                Intrinsics.checkNotNullExpressionValue(bubbleInfo, "bubbleInfo");
                qZoneFeedXFloatPlusBubblePart.L9(view, bubbleInfo);
            }
        };
        G2.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.part.plus.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedXFloatPlusBubblePart.J9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.needInterceptShowBubble = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QZoneFloatPlusBubbleInfo qZoneFloatPlusBubbleInfo;
        super.onPartResume(activity);
        boolean V = l.f59550a.V();
        boolean z16 = this.needInterceptShowBubble || V;
        this.needInterceptShowBubble = z16;
        QLog.i("QZoneFeedXFloatPlusBubblePart", 1, "needInterceptShowBubble is " + z16 + ", needInterceptFromMMKV is " + V);
        if (this.needInterceptShowBubble || (qZoneFloatPlusBubbleInfo = this.bubbleInfoData) == null) {
            return;
        }
        View view = this.anchorView;
        Intrinsics.checkNotNull(qZoneFloatPlusBubbleInfo);
        L9(view, qZoneFloatPlusBubbleInfo);
    }

    private final Map<String, String> H9(QZoneFloatPlusBubbleInfo bubbleInfo) {
        String str;
        Map<String, String> mapOf;
        PBUInt32Field pBUInt32Field;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("dt_pgid", "pg_bas_social_updates");
        TianShuAccess.AdItem adItem = bubbleInfo.getAdItem();
        if (adItem == null || (pBUInt32Field = adItem.iAdId) == null || (str = Integer.valueOf(pBUInt32Field.get()).toString()) == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("advertising_id", str);
        pairArr[2] = TuplesKt.to("content_list", bubbleInfo.getName());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }
}
