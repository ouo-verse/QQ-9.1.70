package com.tencent.mobileqq.zplan.widget.impl.reddot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanBaseDotView;
import gv4.e;
import gv4.f;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xv4.ab;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u001b\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010)R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanBaseDotView;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "view", "Lgv4/e;", "redDotData", "Lxv4/ab;", "spMaterial", "p", "", "newIcon", "Lgv4/f;", "configData", ReportConstant.COSTREPORT_PREFIX, "o", "i", "", "r", "E", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "icon", "Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController;", "controller", "G", "Ljava/lang/String;", "lastShowIcon", "", "H", "I", DomainData.DOMAIN_NAME, "()I", "setRewardType", "(I)V", "rewardType", "Lgv4/f;", "showConfig", "J", "Z", "hasResetView", "K", "isRendering", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanBubbleRedDotView extends ZPlanBaseDotView {

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanPAGView icon;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy controller;

    /* renamed from: G, reason: from kotlin metadata */
    private String lastShowIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private int rewardType;

    /* renamed from: I, reason: from kotlin metadata */
    private f showConfig;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile boolean hasResetView;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean isRendering;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/widget/impl/reddot/ZPlanBubbleRedDotView$b", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$c;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ZPlanPAGView.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f336101b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f336102c;

        b(String str, f fVar) {
            this.f336101b = str;
            this.f336102c = fVar;
        }

        @Override // com.tencent.sqshow.widget.pag.ZPlanPAGView.c
        public void a() {
            ZPlanBubbleRedDotView.this.setVisibility(0);
            ZPlanPAGView zPlanPAGView = ZPlanBubbleRedDotView.this.icon;
            if (zPlanPAGView != null) {
                zPlanPAGView.setVisibility(0);
            }
            QLog.i("ZPlanBubbleRedDotView", 1, "render PAG, onViewLoaded, PGN or PAG start play");
            ZPlanBubbleRedDotView zPlanBubbleRedDotView = ZPlanBubbleRedDotView.this;
            String preViewUrl = this.f336101b;
            Intrinsics.checkNotNullExpressionValue(preViewUrl, "preViewUrl");
            zPlanBubbleRedDotView.s(preViewUrl, this.f336102c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBubbleRedDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanBubbleRedDotController>() { // from class: com.tencent.mobileqq.zplan.widget.impl.reddot.ZPlanBubbleRedDotView$controller$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanBubbleRedDotController invoke() {
                return new ZPlanBubbleRedDotController();
            }
        });
        this.controller = lazy;
        this.lastShowIcon = "";
        ZPlanPAGView zPlanPAGView = (ZPlanPAGView) LayoutInflater.from(getContext()).inflate(R.layout.d79, this).findViewById(R.id.q0g);
        this.icon = zPlanPAGView;
        if (zPlanPAGView != null) {
            zPlanPAGView.setVisibility(4);
        }
        setVisibility(4);
        ZPlanPAGView zPlanPAGView2 = this.icon;
        if (zPlanPAGView2 != null) {
            zPlanPAGView2.resetView();
        }
    }

    private final ZPlanBubbleRedDotController m() {
        return (ZPlanBubbleRedDotController) this.controller.getValue();
    }

    private final void o() {
        ZPlanPAGView zPlanPAGView = this.icon;
        if (zPlanPAGView != null) {
            zPlanPAGView.E();
        }
    }

    private final void p(ZPlanPAGView view, e redDotData, ab spMaterial) {
        f fVar = redDotData.f403430f;
        if (fVar == null) {
            return;
        }
        String preViewUrl = redDotData.f403429e;
        QLog.i(getTAG(), 1, "begin render PAG, PAG url:" + (spMaterial != null ? spMaterial.f448769b : null) + ", icon url:" + preViewUrl);
        t74.f fVar2 = t74.f.f435541a;
        Intrinsics.checkNotNullExpressionValue(preViewUrl, "preViewUrl");
        fVar2.k(view, spMaterial, preViewUrl, new b(preViewUrl, fVar));
    }

    private final void q() {
        QLog.i(getTAG(), 1, "resetView, clear before real show");
        ZPlanPAGView zPlanPAGView = this.icon;
        if (zPlanPAGView != null) {
            zPlanPAGView.setVisibility(4);
        }
        setVisibility(4);
        if (!(this.lastShowIcon.length() > 0) || this.hasResetView) {
            return;
        }
        this.hasResetView = true;
        this.showConfig = null;
        this.rewardType = 0;
        this.lastShowIcon = "";
        ZPlanPAGView zPlanPAGView2 = this.icon;
        if (zPlanPAGView2 != null) {
            zPlanPAGView2.resetView();
        }
        QLog.i(getTAG(), 1, "resetView, set invisible");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String newIcon, f configData) {
        QLog.i(getTAG(), 1, "updatePAGStatus, render end, show view, newIcon" + newIcon);
        if (Intrinsics.areEqual(newIcon, this.lastShowIcon) && this.showConfig != null) {
            QLog.i(getTAG(), 1, "updatePAGStatus, has update, return");
            return;
        }
        QLog.i(getTAG(), 1, "updatePAGStatus, render end, update status");
        this.lastShowIcon = newIcon;
        this.showConfig = configData;
        this.rewardType = configData.f403434d;
        m().d(this, configData.f403432b);
        o();
        this.isRendering = false;
        this.hasResetView = false;
        QLog.i(getTAG(), 1, "updatePAGStatus, ====end");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    @Override // com.tencent.sqshow.zootopia.widget.reddot.ZPlanBaseDotView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(e redDotData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(redDotData, "redDotData");
        setReddotStatus(redDotData.f403426b);
        if (redDotData.f403426b == 4) {
            ZPlanPAGView zPlanPAGView = this.icon;
            if (zPlanPAGView == null) {
                return;
            }
            f fVar = redDotData.f403430f;
            if (fVar != null && m().b(fVar.f403436f, fVar.f403431a, fVar.f403433c)) {
                if ((getVisibility() == 0 && Intrinsics.areEqual(this.lastShowIcon, redDotData.f403429e) && this.showConfig != null) || this.isRendering) {
                    QLog.d(getTAG(), 1, "same url or is rendering, not render repeat, old show url:" + this.lastShowIcon + ", new show url:" + redDotData.f403429e);
                    return;
                }
                this.isRendering = true;
                QLog.d(getTAG(), 1, "ready to render, old show url:" + this.lastShowIcon + ", new show url:" + redDotData.f403429e);
                q();
                ab[] abVarArr = fVar.f403435e;
                if (abVarArr != null) {
                    if (!(abVarArr.length == 0)) {
                        z16 = false;
                        if (z16) {
                            p(zPlanPAGView, redDotData, abVarArr[0]);
                            return;
                        }
                        QLog.i(getTAG(), 1, "begin render PNG, icon url:" + redDotData.f403429e);
                        p(zPlanPAGView, redDotData, null);
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            } else {
                setVisibility(4);
                zPlanPAGView.setVisibility(4);
                o();
                QLog.i(getTAG(), 1, "bubble cannot show");
            }
        } else {
            ZPlanPAGView zPlanPAGView2 = this.icon;
            if (zPlanPAGView2 != null) {
                zPlanPAGView2.setVisibility(4);
            }
            setVisibility(4);
        }
    }

    /* renamed from: n, reason: from getter */
    public final int getRewardType() {
        return this.rewardType;
    }

    public final boolean r() {
        f fVar = this.showConfig;
        return fVar != null && fVar.f403433c > 0;
    }

    public final void setRewardType(int i3) {
        this.rewardType = i3;
    }
}
