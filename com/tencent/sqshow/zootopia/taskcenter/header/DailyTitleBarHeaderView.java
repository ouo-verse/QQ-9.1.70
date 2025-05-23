package com.tencent.sqshow.zootopia.taskcenter.header;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bc4.c;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.a;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskDailyRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.taskcenter.header.DailyTitleBarHeaderView;
import com.tencent.sqshow.zootopia.taskcenter.header.progress.ProgressIconLayout;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.report.SquareReportConst;
import fc4.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.as;
import t74.f;
import tl.h;
import xv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u0001:\u0001>B%\b\u0007\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00107\u001a\u00020\u000f\u00a2\u0006\u0004\b8\u00109B\u001f\b\u0017\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b8\u0010:B\u001b\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u0010;\u001a\u00020\u0015\u00a2\u0006\u0004\b8\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J5\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00101\u00a8\u0006?"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;", "Landroid/widget/RelativeLayout;", "", "j", "Lcom/tencent/sqshow/zootopia/data/s;", "blindBoxData", "", "canOpen", "k", "playBubble", "l", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "view", "f", "Landroid/view/View;", "", "status", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "e", "(Ljava/lang/Integer;)Ljava/util/HashMap;", "g", "Lcom/tencent/sqshow/zootopia/data/u;", "dailyRewardData", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "setHalfScreenView", "d", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Lfc4/d;", "Lfc4/d;", "progressIconAdapter", "Ln74/as;", "Ln74/as;", "viewBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Landroid/os/CountDownTimer;", "i", "Landroid/os/CountDownTimer;", SemanticAttributes.FaasTriggerValues.TIMER, "Z", "hasTipsBubbleShow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sourceId", "(Landroid/content/Context;Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DailyTitleBarHeaderView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d progressIconAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final as viewBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer timer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasTipsBubbleShow;

    public DailyTitleBarHeaderView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    private final HashMap<String, Object> e(Integer status) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_lottery_status", Integer.valueOf(status != null ? status.intValue() : -1));
        return hashMap;
    }

    private final void f(ZPlanMediaView view) {
        if (view.getVisibility() != 0) {
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        b bVar = new b(view);
        this.timer = bVar;
        bVar.start();
    }

    private final void h() {
        this.viewBinding.f418721f.setVisibility(0);
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        RelativeLayout relativeLayout = this.viewBinding.f418721f;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.closeRl");
        zplanViewReportHelper.g(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.viewBinding.f418721f.setOnClickListener(new View.OnClickListener() { // from class: ec4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailyTitleBarHeaderView.i(DailyTitleBarHeaderView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DailyTitleBarHeaderView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("DailyTitleBarHeaderView", 1, "click close icon, close task panel");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zplanViewReportHelper.e(it, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, new LinkedHashMap());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    private final void j() {
        this.viewBinding.getRoot().setRadius(i.d(24.0f), i.d(24.0f), 0.0f, 0.0f);
        this.viewBinding.getRoot().invalidate();
        this.viewBinding.f418722g.setVisibility(4);
        this.viewBinding.f418719d.setVisibility(4);
        h();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d dVar = new d(context, this.reportHelper);
        this.progressIconAdapter = dVar;
        ProgressIconLayout progressIconLayout = this.viewBinding.f418729n;
        Intrinsics.checkNotNull(dVar);
        progressIconLayout.setAdapter(dVar);
    }

    private final void l(ZootopiaTaskBlindBoxData blindBoxData, boolean canOpen, boolean playBubble) {
        String str;
        String iconDefault;
        List<ab> f16;
        List<ab> i3;
        boolean z16 = true;
        QLog.d("DailyTitleBarHeaderView", 1, "playBlindBoxPAGView->,blindBoxData:" + blindBoxData + ", canOpen:" + canOpen + ", playBubble" + playBubble);
        if (canOpen) {
            str = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/blindbox_open_bubble.png";
        } else {
            str = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/blindbox_tips_bubble.png";
        }
        ab abVar = null;
        if (playBubble && (canOpen || !this.hasTipsBubbleShow)) {
            List<ab> i16 = blindBoxData != null ? blindBoxData.i() : null;
            if (!(i16 == null || i16.isEmpty())) {
                this.viewBinding.f418726k.setVisibility(0);
                a m3 = this.viewBinding.f418726k.m();
                if (m3 != null) {
                    m3.resetView();
                }
                a m16 = this.viewBinding.f418726k.m();
                if (m16 != null) {
                    m16.c(f.f435541a.c(str));
                }
                f fVar = f.f435541a;
                ZPlanMediaView zPlanMediaView = this.viewBinding.f418726k;
                Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "viewBinding.itemMedia");
                fVar.i(zPlanMediaView, (blindBoxData == null || (i3 = blindBoxData.i()) == null) ? null : i3.get(0), str);
            } else {
                this.viewBinding.f418726k.setVisibility(4);
            }
        }
        if (playBubble && !canOpen) {
            this.hasTipsBubbleShow = true;
            ZPlanMediaView zPlanMediaView2 = this.viewBinding.f418726k;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView2, "viewBinding.itemMedia");
            f(zPlanMediaView2);
        }
        if (canOpen) {
            if (blindBoxData != null) {
                iconDefault = blindBoxData.getIconOpen();
            }
            iconDefault = null;
        } else {
            if (blindBoxData != null) {
                iconDefault = blindBoxData.getIconDefault();
            }
            iconDefault = null;
        }
        List<ab> f17 = blindBoxData != null ? blindBoxData.f() : null;
        if (f17 != null && !f17.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            a m17 = this.viewBinding.f418727l.m();
            if (m17 != null) {
                m17.c(f.f435541a.c(iconDefault));
            }
            f fVar2 = f.f435541a;
            ZPlanMediaView zPlanMediaView3 = this.viewBinding.f418727l;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView3, "viewBinding.mangheIv");
            if (blindBoxData != null && (f16 = blindBoxData.f()) != null) {
                abVar = f16.get(0);
            }
            fVar2.i(zPlanMediaView3, abVar, iconDefault);
            return;
        }
        f fVar3 = f.f435541a;
        ZPlanMediaView zPlanMediaView4 = this.viewBinding.f418727l;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView4, "viewBinding.mangheIv");
        fVar3.e(zPlanMediaView4, iconDefault);
    }

    private final void m() {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        k84.a aVar = cache instanceof k84.a ? (k84.a) cache : null;
        if (aVar != null) {
            aVar.ne();
        }
    }

    private final void n(View view, int status) {
        Map<String, ? extends Object> mutableMapOf;
        QLog.d("DailyTitleBarHeaderView", 1, "click blindBox, status:" + status);
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_lottery_status", Integer.valueOf(status)));
        zplanViewReportHelper.e(view, "em_zplan_lottery_btn", mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DailyTitleBarHeaderView this$0, ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n(it, zootopiaTaskBlindBoxData.getBlindStatus());
        c cVar = c.f28271a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cVar.c(context, zootopiaTaskBlindBoxData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DailyTitleBarHeaderView this$0, View it) {
        List<ZootopiaTaskRewardInfo> emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n(it, 3);
        c cVar = c.f28271a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        cVar.a(context, emptyList, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData, DailyTitleBarHeaderView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String toastMsg = zootopiaTaskBlindBoxData.getToastMsg();
        if (!(toastMsg == null || toastMsg.length() == 0)) {
            QQToast.makeText(this$0.getContext(), 0, zootopiaTaskBlindBoxData.getToastMsg(), 0).show();
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n(it, 5);
        this$0.m();
    }

    public final void g() {
        this.viewBinding.f418722g.setVisibility(8);
        this.viewBinding.f418719d.setVisibility(8);
        this.viewBinding.f418726k.setVisibility(4);
        this.viewBinding.f418727l.setVisibility(4);
        this.viewBinding.f418725j.setVisibility(4);
        this.viewBinding.f418724i.setVisibility(0);
        this.viewBinding.f418731p.setVisibility(4);
    }

    public final void o(final ZootopiaTaskBlindBoxData blindBoxData) {
        String str;
        Resources resources;
        this.viewBinding.f418727l.setVisibility(0);
        this.viewBinding.f418719d.setVisibility(0);
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        ZPlanMediaView zPlanMediaView = this.viewBinding.f418727l;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "viewBinding.mangheIv");
        zplanViewReportHelper.g(zPlanMediaView, "em_zplan_lottery_btn", (r16 & 4) != 0 ? null : e(blindBoxData != null ? Integer.valueOf(blindBoxData.getBlindStatus()) : null), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.viewBinding.f418728m.setText(blindBoxData != null ? blindBoxData.getBlindDesc() : null);
        this.viewBinding.f418717b.setText(String.valueOf(blindBoxData != null ? Integer.valueOf(blindBoxData.getQuestCurrentCnt()) : null));
        TextView textView = this.viewBinding.f418718c;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            str = null;
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = blindBoxData != null ? Integer.valueOf(blindBoxData.getQuestAmount()) : null;
            str = resources.getString(R.string.xvw, objArr);
        }
        textView.setText(str);
        Integer valueOf = blindBoxData != null ? Integer.valueOf(blindBoxData.getBlindStatus()) : null;
        if (((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 1)) || (valueOf != null && valueOf.intValue() == 2)) {
            k(blindBoxData, false);
            ZPlanMediaView zPlanMediaView2 = this.viewBinding.f418727l;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView2, "viewBinding.mangheIv");
            aa.f(zPlanMediaView2, new View.OnClickListener() { // from class: ec4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailyTitleBarHeaderView.p(DailyTitleBarHeaderView.this, blindBoxData, view);
                }
            }, 1000L, "DailyTitleBarHeaderView");
            return;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            k(blindBoxData, true);
            ZPlanMediaView zPlanMediaView3 = this.viewBinding.f418727l;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView3, "viewBinding.mangheIv");
            aa.f(zPlanMediaView3, new View.OnClickListener() { // from class: ec4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailyTitleBarHeaderView.q(DailyTitleBarHeaderView.this, view);
                }
            }, 1000L, "DailyTitleBarHeaderView");
            return;
        }
        if (valueOf != null && valueOf.intValue() == 5) {
            l(blindBoxData, false, true);
            ZPlanMediaView zPlanMediaView4 = this.viewBinding.f418727l;
            Intrinsics.checkNotNullExpressionValue(zPlanMediaView4, "viewBinding.mangheIv");
            aa.f(zPlanMediaView4, new View.OnClickListener() { // from class: ec4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DailyTitleBarHeaderView.r(ZootopiaTaskBlindBoxData.this, this, view);
                }
            }, 1000L, "DailyTitleBarHeaderView");
        }
    }

    public final void s(ZootopiaTaskDailyRewardData dailyRewardData) {
        String str;
        List<com.tencent.sqshow.zootopia.data.b> c16;
        Resources resources;
        this.viewBinding.f418724i.setVisibility(4);
        this.viewBinding.f418725j.setVisibility(0);
        this.viewBinding.f418723h.setVisibility(0);
        this.viewBinding.f418722g.setVisibility(0);
        this.viewBinding.f418731p.setVisibility(0);
        this.viewBinding.f418732q.setText(String.valueOf(dailyRewardData != null ? Integer.valueOf(dailyRewardData.getQuestCurrentCnt()) : null));
        TextView textView = this.viewBinding.f418733r;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            str = null;
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = dailyRewardData != null ? Integer.valueOf(dailyRewardData.getRewardMaxCnt()) : null;
            str = resources.getString(R.string.xvw, objArr);
        }
        textView.setText(str);
        ArrayList<com.tencent.sqshow.zootopia.data.b> arrayList = new ArrayList<>();
        if (dailyRewardData != null && (c16 = dailyRewardData.c()) != null) {
            arrayList.addAll(c16);
        }
        d dVar = this.progressIconAdapter;
        if (dVar != null) {
            dVar.n(arrayList, dailyRewardData != null ? dailyRewardData.e() : null, dailyRewardData != null ? Integer.valueOf(dailyRewardData.getRewardMaxCnt()) : null, dailyRewardData != null ? Integer.valueOf(dailyRewardData.getQuestCurrentCnt()) : null);
        }
    }

    public final void setHalfScreenView(QUSHalfScreenFloatingView view) {
        this.floatingView = view;
    }

    public DailyTitleBarHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        as g16 = as.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.viewBinding = g16;
        this.reportHelper = new ZplanViewReportHelper();
    }

    private final void k(ZootopiaTaskBlindBoxData blindBoxData, boolean canOpen) {
        l(blindBoxData, canOpen, true);
    }

    public DailyTitleBarHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ DailyTitleBarHeaderView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyTitleBarHeaderView(Context context, String sourceId) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        addView(this.viewBinding.getRoot());
        j();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanMediaView f373051a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZPlanMediaView zPlanMediaView) {
            super(3000L, 1000L);
            this.f373051a = zPlanMediaView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f373051a.setVisibility(4);
            this.f373051a.stop();
            QLog.d("DailyTitleBarHeaderView", 1, "handleTips, hide bubble");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
        }
    }
}
