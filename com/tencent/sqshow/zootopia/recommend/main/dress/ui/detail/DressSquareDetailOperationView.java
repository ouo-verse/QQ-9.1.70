package com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cc4.a;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.ZootopiaDoublePraiseView;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailOperationView;
import com.tencent.sqshow.zootopia.recommend.main.dress.util.ZPlanDressFeedsActionEvent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ac;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.sqshow.zootopia.widget.AlphaClickableLinearLayout;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mc4.ZPlanUserFollowStatusInfo;
import n74.ba;
import org.libpag.PAGView;
import pu4.g;
import pu4.j;
import pu4.l;
import pu4.n;
import pu4.q;
import pu4.s;
import t74.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001O\u0018\u0000 [2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\\B#\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010V\u001a\u00020\t\u00a2\u0006\u0004\bW\u0010XB\u0013\b\u0016\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u00a2\u0006\u0004\bW\u0010YB\u001f\b\u0016\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u00a2\u0006\u0004\bW\u0010ZJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J0\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J&\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u001a\u0010\"\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\tH\u0002J\"\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J$\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020.0-j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020.`/H\u0002J\b\u00101\u001a\u00020\u0004H\u0014J\b\u00102\u001a\u00020\u0004H\u0014J\u0006\u00103\u001a\u00020\u0004J\"\u00106\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u00105\u001a\u000204J:\u00109\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00107\u001a\u00020\f2\b\b\u0002\u00108\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\fJ\u0012\u0010:\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010=\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<\u0018\u00010;H\u0016R\u0017\u0010C\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010JR\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010LR\u0016\u0010N\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010P\u00a8\u0006]"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailOperationView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "l", "Lpu4/n;", "outfitWorksInfo", "t", "", "relation", "y", "", "isFollow", "showFollowPAG", "w", "J", "Lcom/tencent/sqshow/zootopia/card/view/ZootopiaDoublePraiseView;", "praiseView", "E", DomainData.DOMAIN_NAME, "isPraised", QZoneJsConstants.METHOD_PLAY, "Landroid/view/MotionEvent;", "event", "H", "L", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", ReportConstant.COSTREPORT_PREFIX, "", "id", "type", "i", "Landroid/widget/TextView;", "numTextView", WidgetCacheConstellationData.NUM, "defaultTxtResId", "B", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "p", "j", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "k", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "r", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", BdhLogUtil.LogTag.Tag_Conn, "isFromDoubleTab", "isFromClick", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Ln74/ba;", "d", "Ln74/ba;", "getBinding", "()Ln74/ba;", "binding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "e", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "f", "Lpu4/n;", "Ljava/lang/String;", "sourceId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Z", "hasUpdatePraisedIcon", "com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailOperationView$c", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailOperationView$c;", "userFollowStatusListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressSquareDetailOperationView extends RelativeLayout implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C */
    private final c userFollowStatusListener;

    /* renamed from: d, reason: from kotlin metadata */
    private final ba binding;

    /* renamed from: e, reason: from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: f, reason: from kotlin metadata */
    private n outfitWorksInfo;

    /* renamed from: h */
    private String sourceId;

    /* renamed from: i, reason: from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* renamed from: m */
    private boolean hasUpdatePraisedIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailOperationView$b", "Lcc4/a;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends a {

        /* renamed from: f */
        final /* synthetic */ ZPlanPAGView f372609f;

        b(ZPlanPAGView zPlanPAGView) {
            this.f372609f = zPlanPAGView;
        }

        public static final void d(ZPlanPAGView operatePagView) {
            Intrinsics.checkNotNullParameter(operatePagView, "$operatePagView");
            operatePagView.setVisibility(4);
        }

        @Override // cc4.a, org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.d(getTAG(), 1, "play followed pag end, set invisible");
            DressSquareDetailOperationView dressSquareDetailOperationView = DressSquareDetailOperationView.this;
            final ZPlanPAGView zPlanPAGView = this.f372609f;
            dressSquareDetailOperationView.post(new Runnable() { // from class: jb4.o
                @Override // java.lang.Runnable
                public final void run() {
                    DressSquareDetailOperationView.b.d(ZPlanPAGView.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailOperationView$c", "Lmc4/a;", "Lmc4/b;", "followStatusInfo", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements mc4.a {
        c() {
        }

        @Override // mc4.a
        public void a(ZPlanUserFollowStatusInfo followStatusInfo) {
            s sVar;
            Intrinsics.checkNotNullParameter(followStatusInfo, "followStatusInfo");
            String uin = followStatusInfo.getUin();
            n nVar = DressSquareDetailOperationView.this.outfitWorksInfo;
            if (!Intrinsics.areEqual(uin, (nVar == null || (sVar = nVar.f427500c) == null) ? null : Long.valueOf(sVar.f427518a).toString()) || followStatusInfo.getIsUpdating()) {
                return;
            }
            DressSquareDetailOperationView.this.y(followStatusInfo.getCurRelation());
        }
    }

    public DressSquareDetailOperationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ba g16 = ba.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        this.reportHelper = new ZplanViewReportHelper();
        this.userFollowStatusListener = new c();
    }

    public static final void D(DressSquareDetailOperationView this$0, n nVar, View it) {
        l lVar;
        j jVar;
        l lVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kb4.a aVar = kb4.a.f411993a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = null;
        String str2 = (nVar == null || (lVar2 = nVar.f427499b) == null) ? null : lVar2.f427476a;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (nVar == null || (jVar = nVar.f427498a) == null) ? null : jVar.f427463b;
        if (nVar != null && (lVar = nVar.f427499b) != null) {
            str = lVar.f427484i;
        }
        aVar.i(context, str2, str3, str != null ? str : "");
        eb4.a aVar2 = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        HashMap<String, Object> k3 = this$0.k();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar2.b(zplanViewReportHelper, k3, it, "ev_zplan_try_clothes_btn");
    }

    private final void E(n outfitWorksInfo, final ZootopiaDoublePraiseView praiseView) {
        j jVar;
        B(this.binding.f418797i, (outfitWorksInfo == null || (jVar = outfitWorksInfo.f427498a) == null) ? 0 : jVar.f427464c, R.string.xnj);
        I(this, n(), false, null, null, 12, null);
        AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418799k;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.likeLl");
        aa.d(alphaClickableLinearLayout, new View.OnClickListener() { // from class: jb4.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailOperationView.F(DressSquareDetailOperationView.this, praiseView, view);
            }
        });
    }

    public static final void F(DressSquareDetailOperationView this$0, ZootopiaDoublePraiseView zootopiaDoublePraiseView, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, Object> k3 = this$0.k();
        k3.put("zplan_like_status", this$0.j());
        A(this$0, zootopiaDoublePraiseView, null, false, true, true, 6, null);
        eb4.a aVar = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.b(zplanViewReportHelper, k3, it, "em_zplan_like_btn");
    }

    private final void G(boolean r65, ZootopiaDoublePraiseView praiseView, MotionEvent event) {
        q qVar;
        QLog.d("DressSquareDetailOperationView", 1, "updatePraiseStatus, playAnimation: " + r65);
        this.binding.f418800l.setVisibility(0);
        this.binding.f418798j.setVisibility(4);
        if (this.hasUpdatePraisedIcon) {
            QLog.d("DressSquareDetailOperationView", 1, "updatePraiseStatus, hasUpdatePraisedIcon, return");
            return;
        }
        this.hasUpdatePraisedIcon = true;
        if (r65) {
            if (praiseView != null) {
                praiseView.e(event);
            }
            n nVar = this.outfitWorksInfo;
            if (((nVar == null || (qVar = nVar.f427501d) == null) ? 0L : qVar.f427513a) > 0) {
                QLog.d("DressSquareDetailOperationView", 1, "has praised, return");
                return;
            }
            if (m("https://image.superqqshow.qq.com/wear-square/detail_dianzan_small.pag")) {
                QLog.d("DressSquareDetailOperationView", 1, "updatePraiseStatus, small praise pag is ready, show pag");
                g a16 = f.f435541a.a("https://image.superqqshow.qq.com/wear-square/detail_dianzan_small.pag", "https://image.superqqshow.qq.com/wear-square/zootopia_dress_square_detail_liked_0804.png");
                this.binding.f418800l.resetView();
                this.binding.f418800l.setRepeatCount(1);
                this.binding.f418800l.C(a16);
                return;
            }
            QLog.d("DressSquareDetailOperationView", 1, "updatePraiseStatus, small praise pag is not ready, show native png");
            q();
            return;
        }
        QLog.d("DressSquareDetailOperationView", 1, "updatePraiseStatus, just show praised png");
        q();
    }

    private final void J(final n outfitWorksInfo) {
        j jVar;
        B(this.binding.f418802n, (outfitWorksInfo == null || (jVar = outfitWorksInfo.f427498a) == null) ? 0 : jVar.f427471j, R.string.xnl);
        AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418803o;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.shareLl");
        aa.d(alphaClickableLinearLayout, new View.OnClickListener() { // from class: jb4.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailOperationView.K(pu4.n.this, this, view);
            }
        });
    }

    private final void h() {
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RelativeLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        zplanViewReportHelper.a(context, mRv, "pg_zplan_outfit_detail", k());
    }

    private final void i(String id5, int type) {
        j jVar;
        j jVar2;
        int max;
        j jVar3;
        q qVar;
        long currentTimeMillis = System.currentTimeMillis();
        n nVar = this.outfitWorksInfo;
        boolean z16 = ((nVar == null || (qVar = nVar.f427501d) == null) ? 0L : qVar.f427513a) > 0;
        int i3 = (nVar == null || (jVar3 = nVar.f427498a) == null) ? 0 : jVar3.f427464c;
        Integer num = null;
        j jVar4 = nVar != null ? nVar.f427498a : null;
        if (jVar4 != null) {
            if (z16) {
                max = Math.max(0, i3 - 1);
            } else {
                max = Math.max(1, i3 + 1);
            }
            jVar4.f427464c = max;
        }
        n nVar2 = this.outfitWorksInfo;
        q qVar2 = nVar2 != null ? nVar2.f427501d : null;
        if (qVar2 != null) {
            if (type != 0) {
                currentTimeMillis = 0;
            }
            qVar2.f427513a = currentTimeMillis;
        }
        B(this.binding.f418797i, (nVar2 == null || (jVar2 = nVar2.f427498a) == null) ? 0 : jVar2.f427464c, R.string.xnj);
        kb4.a aVar = kb4.a.f411993a;
        String str = id5 == null ? "" : id5;
        n nVar3 = this.outfitWorksInfo;
        if (nVar3 != null && (jVar = nVar3.f427498a) != null) {
            num = Integer.valueOf(jVar.f427464c);
        }
        aVar.f(str, 5, num, Boolean.valueOf(type == 0));
        p84.a.e(p84.a.f425784a, id5 != null ? id5 : "", type, i3, null, 8, null);
    }

    private final String j() {
        q qVar;
        n nVar = this.outfitWorksInfo;
        if (((nVar == null || (qVar = nVar.f427501d) == null) ? 0L : qVar.f427513a) > 0) {
            return "1";
        }
        return "0";
    }

    private final HashMap<String, Object> k() {
        return eb4.a.f396070a.a(this.outfitWorksInfo, this.sourceId);
    }

    private final void l() {
        this.binding.f418795g.setVisibility(4);
        this.binding.f418796h.setVisibility(4);
    }

    private final boolean m(String str) {
        return ZPlanPAGLoader.h(ZPlanPAGLoader.f369875a, str, false, 2, null) != null;
    }

    private final boolean n() {
        q qVar;
        n nVar = this.outfitWorksInfo;
        return ((nVar == null || (qVar = nVar.f427501d) == null) ? 0L : qVar.f427513a) > 0;
    }

    private final void o() {
        s sVar;
        n nVar = this.outfitWorksInfo;
        long j3 = (nVar == null || (sVar = nVar.f427500c) == null) ? 0L : sVar.f427518a;
        if (j3 == 0 || w.f373306a.c(String.valueOf(j3))) {
            return;
        }
        hc4.a.f404730a.a(String.valueOf(j3), this.userFollowStatusListener);
    }

    private final void p() {
        HashMap<String, Object> k3 = k();
        eb4.a aVar = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        RelativeLayout relativeLayout = this.binding.f418807s;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.userRl");
        aVar.c(zplanViewReportHelper, k3, relativeLayout, "em_zplan_friend_area");
        ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
        RelativeLayout relativeLayout2 = this.binding.f418790b;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.authorFollowRl");
        aVar.c(zplanViewReportHelper2, k3, relativeLayout2, "em_zplan_follow");
        ZplanViewReportHelper zplanViewReportHelper3 = this.reportHelper;
        AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418805q;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.tryOnLl");
        aVar.c(zplanViewReportHelper3, k3, alphaClickableLinearLayout, "ev_zplan_try_clothes_btn");
        ZplanViewReportHelper zplanViewReportHelper4 = this.reportHelper;
        AlphaClickableLinearLayout alphaClickableLinearLayout2 = this.binding.f418803o;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout2, "binding.shareLl");
        aVar.c(zplanViewReportHelper4, k3, alphaClickableLinearLayout2, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE);
        k3.put("zplan_like_status", j());
        ZplanViewReportHelper zplanViewReportHelper5 = this.reportHelper;
        AlphaClickableLinearLayout alphaClickableLinearLayout3 = this.binding.f418799k;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout3, "binding.likeLl");
        aVar.c(zplanViewReportHelper5, k3, alphaClickableLinearLayout3, "em_zplan_like_btn");
    }

    private final void q() {
        g c16 = f.f435541a.c("https://image.superqqshow.qq.com/wear-square/zootopia_dress_square_detail_liked_0804.png");
        this.binding.f418800l.resetView();
        this.binding.f418800l.c(c16);
    }

    private final void s() {
        hc4.a.f404730a.c(this.userFollowStatusListener);
    }

    private final void t(final n outfitWorksInfo) {
        long j3;
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        SimpleEventBus.getInstance().registerReceiver(this);
        this.binding.f418806r.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.f11685f) / 2.0f);
        RoundCornerImageView roundCornerImageView = this.binding.f418806r;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.userIv");
        String str = (outfitWorksInfo == null || (sVar5 = outfitWorksInfo.f427500c) == null) ? null : sVar5.f427520c;
        if (str == null) {
            str = "";
        }
        CommonExKt.w(roundCornerImageView, str, null, null, 4, null);
        URLImageView uRLImageView = this.binding.f418794f;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.avatarBg");
        String str2 = (outfitWorksInfo == null || (sVar4 = outfitWorksInfo.f427500c) == null) ? null : sVar4.f427521d;
        CommonExKt.w(uRLImageView, str2 == null ? "" : str2, null, null, 4, null);
        RoundCornerImageView roundCornerImageView2 = this.binding.f418806r;
        final long j16 = 0;
        if (outfitWorksInfo != null && (sVar3 = outfitWorksInfo.f427500c) != null) {
            j3 = Long.valueOf(sVar3.f427518a);
        } else {
            j3 = 0L;
        }
        roundCornerImageView2.setTag(j3);
        if (outfitWorksInfo != null && (sVar2 = outfitWorksInfo.f427500c) != null) {
            j16 = sVar2.f427518a;
        }
        if (!w.f373306a.c(String.valueOf(j16))) {
            QLog.d("DressSquareDetailOperationView", 1, "not self, show follow icon");
            x(this, p84.a.f425784a.c((outfitWorksInfo == null || (sVar = outfitWorksInfo.f427500c) == null) ? null : Integer.valueOf(sVar.f427522e)), false, 2, null);
            RelativeLayout relativeLayout = this.binding.f418790b;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.authorFollowRl");
            aa.d(relativeLayout, new View.OnClickListener() { // from class: jb4.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DressSquareDetailOperationView.u(DressSquareDetailOperationView.this, outfitWorksInfo, j16, view);
                }
            });
        } else {
            QLog.d("DressSquareDetailOperationView", 1, "is self, hide follow icon");
            this.binding.f418790b.setVisibility(4);
        }
        RelativeLayout relativeLayout2 = this.binding.f418807s;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.userRl");
        aa.d(relativeLayout2, new View.OnClickListener() { // from class: jb4.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailOperationView.v(DressSquareDetailOperationView.this, outfitWorksInfo, view);
            }
        });
    }

    public static final void u(DressSquareDetailOperationView this$0, n nVar, long j3, View it) {
        s sVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eb4.a aVar = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        HashMap<String, Object> k3 = this$0.k();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.b(zplanViewReportHelper, k3, it, "em_zplan_follow");
        if (nVar == null || (sVar = nVar.f427500c) == null) {
            return;
        }
        p84.a.f425784a.a(j3, sVar.f427522e);
    }

    public static final void v(DressSquareDetailOperationView this$0, n nVar, View it) {
        s sVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kb4.a aVar = kb4.a.f411993a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String valueOf = String.valueOf((nVar == null || (sVar = nVar.f427500c) == null) ? 0L : sVar.f427518a);
        ZootopiaSource zootopiaSource = this$0.sourceCurrent;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.ZootopiaActivity, "", null, 4, null);
        }
        aVar.e(context, valueOf, zootopiaSource);
        eb4.a aVar2 = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        HashMap<String, Object> k3 = this$0.k();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar2.b(zplanViewReportHelper, k3, it, "em_zplan_friend_area");
    }

    public final void y(int relation) {
        s sVar;
        n nVar = this.outfitWorksInfo;
        if (nVar != null && (sVar = nVar.f427500c) != null) {
            sVar.f427522e = relation;
        }
        w(p84.a.f425784a.c(Integer.valueOf(relation)), true);
    }

    public final void C(final n nVar, ZootopiaDoublePraiseView zootopiaDoublePraiseView, ZootopiaSource sourceCurrent) {
        j jVar;
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.outfitWorksInfo = nVar;
        this.sourceId = ah.b(sourceCurrent);
        this.sourceCurrent = sourceCurrent;
        t(nVar);
        J(nVar);
        E(nVar, zootopiaDoublePraiseView);
        B(this.binding.f418804p, (nVar == null || (jVar = nVar.f427498a) == null) ? 0 : jVar.f427465d, R.string.xnm);
        AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418805q;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.tryOnLl");
        aa.d(alphaClickableLinearLayout, new View.OnClickListener() { // from class: jb4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailOperationView.D(DressSquareDetailOperationView.this, nVar, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanDressFeedsActionEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        l lVar;
        QLog.d("DressSquareDetailOperationView", 1, "onReceiveEvent, event: " + event);
        if (event instanceof ZPlanDressFeedsActionEvent) {
            ZPlanDressFeedsActionEvent zPlanDressFeedsActionEvent = (ZPlanDressFeedsActionEvent) event;
            String zplanFeedsId = zPlanDressFeedsActionEvent.getZplanFeedsId();
            n nVar = this.outfitWorksInfo;
            String str = (nVar == null || (lVar = nVar.f427499b) == null) ? null : lVar.f427476a;
            if (str == null) {
                str = "";
            }
            if (Intrinsics.areEqual(zplanFeedsId, str)) {
                int actionType = zPlanDressFeedsActionEvent.getActionType();
                int i3 = 0;
                r3 = 0;
                int i16 = 0;
                i3 = 0;
                if (actionType == 1) {
                    QLog.d("DressSquareDetailOperationView", 1, "update, FEEDS_ACTION_TYPE_SHARE");
                    n nVar2 = this.outfitWorksInfo;
                    if (nVar2 != null && (jVar2 = nVar2.f427498a) != null) {
                        jVar2.f427471j = (jVar2 != null ? jVar2.f427471j : 0) + 1;
                    }
                    TextView textView = this.binding.f418802n;
                    if (nVar2 != null && (jVar = nVar2.f427498a) != null) {
                        i3 = jVar.f427471j;
                    }
                    B(textView, i3, R.string.xnl);
                    return;
                }
                if (actionType != 3) {
                    if (actionType != 5) {
                        return;
                    }
                    TextView textView2 = this.binding.f418797i;
                    Integer localFakePraiseNum = zPlanDressFeedsActionEvent.getLocalFakePraiseNum();
                    B(textView2, localFakePraiseNum != null ? localFakePraiseNum.intValue() : 0, R.string.xnj);
                    Boolean localFakeHasPraised = zPlanDressFeedsActionEvent.getLocalFakeHasPraised();
                    I(this, localFakeHasPraised != null ? localFakeHasPraised.booleanValue() : false, false, null, null, 12, null);
                    return;
                }
                QLog.d("DressSquareDetailOperationView", 1, "update, FEEDS_ACTION_TYPE_TRY");
                n nVar3 = this.outfitWorksInfo;
                if (nVar3 != null && (jVar4 = nVar3.f427498a) != null) {
                    jVar4.f427465d = (jVar4 != null ? jVar4.f427465d : 0) + 1;
                }
                TextView textView3 = this.binding.f418804p;
                if (nVar3 != null && (jVar3 = nVar3.f427498a) != null) {
                    i16 = jVar3.f427465d;
                }
                B(textView3, i16, R.string.xnm);
            }
        }
    }

    private final void L() {
        this.hasUpdatePraisedIcon = false;
        g b16 = f.f435541a.b("https://image.superqqshow.qq.com/wear-square/zootopia_dress_square_detail_like.png");
        this.binding.f418800l.setVisibility(4);
        this.binding.f418798j.setVisibility(0);
        this.binding.f418798j.e(b16);
    }

    private final void w(boolean isFollow, boolean showFollowPAG) {
        if (!isFollow) {
            QLog.d("DressSquareDetailOperationView", 1, "show not follow icon");
            this.binding.f418790b.setVisibility(0);
            this.binding.f418792d.setBackgroundResource(R.drawable.icf);
            return;
        }
        QLog.d("DressSquareDetailOperationView", 1, "show followed icon");
        this.binding.f418790b.setVisibility(8);
        if (!showFollowPAG) {
            QLog.d("DressSquareDetailOperationView", 1, "don't show pag, return");
            return;
        }
        QLog.d("DressSquareDetailOperationView", 1, "show followed pag");
        ZPlanPAGView zPlanPAGView = this.binding.f418793e;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView, "binding.authorOperatePag");
        zPlanPAGView.setVisibility(0);
        if (zPlanPAGView.A()) {
            return;
        }
        zPlanPAGView.resetView();
        f fVar = f.f435541a;
        g a16 = fVar.a("https://image.superqqshow.qq.com/wear-square/detail_attention_update.pag", "");
        zPlanPAGView.setRepeatCount(1);
        fVar.d(zPlanPAGView, a16, new b(zPlanPAGView));
        QLog.d("DressSquareDetailOperationView", 1, "show followed icon");
    }

    public final void r() {
        QLog.d("DressSquareDetailOperationView", 1, "operate view showOnScreen");
        h();
        p();
    }

    private final int H(boolean isPraised, boolean r26, ZootopiaDoublePraiseView praiseView, MotionEvent event) {
        if (isPraised) {
            G(r26, praiseView, event);
            return 0;
        }
        L();
        return 1;
    }

    public final void z(ZootopiaDoublePraiseView zootopiaDoublePraiseView, MotionEvent motionEvent, boolean z16, boolean z17, boolean z18) {
        int i3;
        l lVar;
        if (z17) {
            i3 = H(!n(), z18, zootopiaDoublePraiseView, motionEvent);
        } else {
            if (z16) {
                G(z18, zootopiaDoublePraiseView, motionEvent);
            }
            i3 = 0;
        }
        if (z16 && n()) {
            return;
        }
        n nVar = this.outfitWorksInfo;
        i((nVar == null || (lVar = nVar.f427499b) == null) ? null : lVar.f427476a, i3);
    }

    public DressSquareDetailOperationView(Context context) {
        this(context, null);
    }

    private final void B(TextView numTextView, int r26, int defaultTxtResId) {
        String string;
        if (numTextView != null) {
            if (r26 > 0) {
                string = ac.f373252a.a(r26);
            } else {
                string = numTextView.getResources().getString(defaultTxtResId);
            }
            numTextView.setText(string);
        }
    }

    public DressSquareDetailOperationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        addView(this.binding.getMRv(), -1, -1);
        l();
    }

    static /* synthetic */ void x(DressSquareDetailOperationView dressSquareDetailOperationView, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        dressSquareDetailOperationView.w(z16, z17);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void K(n nVar, DressSquareDetailOperationView this$0, View it) {
        g gVar;
        String str;
        l lVar;
        j jVar;
        l lVar2;
        l lVar3;
        g[] gVarArr;
        Object firstOrNull;
        l lVar4;
        g[] gVarArr2;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e eVar = e.f328302a;
        if (nVar == null || (lVar4 = nVar.f427499b) == null || (gVarArr2 = lVar4.f427479d) == null) {
            gVar = null;
        } else {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(gVarArr2);
            gVar = (g) firstOrNull2;
        }
        boolean a16 = eVar.a(gVar);
        if (nVar != null && (lVar3 = nVar.f427499b) != null && (gVarArr = lVar3.f427479d) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(gVarArr);
            g gVar2 = (g) firstOrNull;
            if (gVar2 != null) {
                str = gVar2.f427434a;
                String str2 = str != null ? "" : str;
                zb4.a aVar = zb4.a.f452297a;
                String str3 = (nVar != null || (lVar2 = nVar.f427499b) == null) ? null : lVar2.f427476a;
                String str4 = str3 != null ? "" : str3;
                String str5 = (nVar != null || (jVar = nVar.f427498a) == null) ? null : jVar.f427463b;
                aVar.a(str4, (r20 & 2) != 0 ? "" : str5 != null ? "" : str5, (r20 & 4) != 0 ? null : null, (r20 & 8) != 0 ? 0 : 0, (r20 & 16) == 0 ? str2 : "", (r20 & 32) != 0 ? true : a16, (r20 & 64) != 0 ? null : nVar != null ? nVar.f427502e : null, (r20 & 128) == 0 ? (nVar != null || (lVar = nVar.f427499b) == null) ? -1 : lVar.f427491p : 0, (r20 & 256) == 0 ? this$0.sourceCurrent : null);
                eb4.a aVar2 = eb4.a.f396070a;
                ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
                HashMap<String, Object> k3 = this$0.k();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar2.b(zplanViewReportHelper, k3, it, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE);
            }
        }
        str = null;
        if (str != null) {
        }
        zb4.a aVar3 = zb4.a.f452297a;
        if (nVar != null) {
        }
        if (str3 != null) {
        }
        if (nVar != null) {
        }
        aVar3.a(str4, (r20 & 2) != 0 ? "" : str5 != null ? "" : str5, (r20 & 4) != 0 ? null : null, (r20 & 8) != 0 ? 0 : 0, (r20 & 16) == 0 ? str2 : "", (r20 & 32) != 0 ? true : a16, (r20 & 64) != 0 ? null : nVar != null ? nVar.f427502e : null, (r20 & 128) == 0 ? (nVar != null || (lVar = nVar.f427499b) == null) ? -1 : lVar.f427491p : 0, (r20 & 256) == 0 ? this$0.sourceCurrent : null);
        eb4.a aVar22 = eb4.a.f396070a;
        ZplanViewReportHelper zplanViewReportHelper2 = this$0.reportHelper;
        HashMap<String, Object> k36 = this$0.k();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar22.b(zplanViewReportHelper2, k36, it, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE);
    }

    static /* synthetic */ int I(DressSquareDetailOperationView dressSquareDetailOperationView, boolean z16, boolean z17, ZootopiaDoublePraiseView zootopiaDoublePraiseView, MotionEvent motionEvent, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            zootopiaDoublePraiseView = null;
        }
        if ((i3 & 8) != 0) {
            motionEvent = null;
        }
        return dressSquareDetailOperationView.H(z16, z17, zootopiaDoublePraiseView, motionEvent);
    }

    public static /* synthetic */ void A(DressSquareDetailOperationView dressSquareDetailOperationView, ZootopiaDoublePraiseView zootopiaDoublePraiseView, MotionEvent motionEvent, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            motionEvent = null;
        }
        MotionEvent motionEvent2 = motionEvent;
        boolean z19 = (i3 & 4) != 0 ? false : z16;
        boolean z26 = (i3 & 8) != 0 ? false : z17;
        if ((i3 & 16) != 0) {
            z18 = true;
        }
        dressSquareDetailOperationView.z(zootopiaDoublePraiseView, motionEvent2, z19, z26, z18);
    }
}
