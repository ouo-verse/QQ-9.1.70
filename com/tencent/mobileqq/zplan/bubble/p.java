package com.tencent.mobileqq.zplan.bubble;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.falco.utils.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import yi3.ZPlanOperateBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010+R\u001a\u0010.\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/p;", "Lcom/tencent/mobileqq/zplan/bubble/c;", "Lyi3/c;", "", "actionId", "", "iAdId", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "i", "Lcom/tencent/mobileqq/tianshu/data/TianShuReportData;", "f", "g", "Lyi3/e;", "newBubbleInfo", "", "b", "Landroid/view/View$OnClickListener;", "listener", "setOnClickListener", "onCreate", "onShow", "onHide", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "newParent", "a", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "I", "parentWidthPx", "c", "parentHeightPx", "d", "Lyi3/c;", "bubbleInfo", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "e", "Landroid/content/Context;", "context", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "bubbleImageView", "Z", "isClickable", "()Z", tl.h.F, "Landroid/view/View$OnClickListener;", "outerClickListener", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "globalVisibleRect", "<init>", "(Landroid/widget/FrameLayout;IILyi3/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class p implements c<ZPlanOperateBubbleInfo> {

    /* renamed from: i, reason: collision with root package name */
    private static final a f332031i = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FrameLayout parent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int parentWidthPx;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int parentHeightPx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanOperateBubbleInfo bubbleInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private URLImageView bubbleImageView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isClickable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener outerClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/p$a;", "", "", "ACTION_ID_CLICK", "I", "ACTION_ID_CLOSE", "ACTION_ID_IMP", "GROUP_ID", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public p(FrameLayout parent, int i3, int i16, ZPlanOperateBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.parent = parent;
        this.parentWidthPx = i3;
        this.parentHeightPx = i16;
        this.bubbleInfo = bubbleInfo;
        this.context = parent.getContext();
        this.isClickable = true;
    }

    private final TianShuReportData f(int actionId, long iAdId, String traceInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return null;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "273";
        tianShuReportData.mPageId = "273";
        tianShuReportData.mItemId = String.valueOf(iAdId);
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = traceInfo;
        return tianShuReportData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(p this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.outerClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        j(this$0, 102, this$0.bubbleInfo.getId(), null, 4, null);
    }

    private final void i(int actionId, long iAdId, String traceInfo) {
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(f(actionId, iAdId, traceInfo));
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void a(FrameLayout newParent) {
        Intrinsics.checkNotNullParameter(newParent, "newParent");
        FrameLayout frameLayout = this.parent;
        if (Intrinsics.areEqual(frameLayout, newParent)) {
            return;
        }
        URLImageView uRLImageView = this.bubbleImageView;
        if (uRLImageView != null) {
            frameLayout.removeView(uRLImageView);
            newParent.addView(uRLImageView);
        }
        this.parent = newParent;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public boolean b(yi3.e newBubbleInfo) {
        Intrinsics.checkNotNullParameter(newBubbleInfo, "newBubbleInfo");
        if (!(newBubbleInfo instanceof ZPlanOperateBubbleInfo)) {
            return false;
        }
        this.bubbleInfo = (ZPlanOperateBubbleInfo) newBubbleInfo;
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public Rect d() {
        Rect rect = new Rect();
        URLImageView uRLImageView = this.bubbleImageView;
        if (uRLImageView != null) {
            uRLImageView.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: g, reason: from getter and merged with bridge method [inline-methods] */
    public ZPlanOperateBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: isClickable, reason: from getter */
    public boolean getIsClickable() {
        return this.isClickable;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onCreate() {
        URLImageView uRLImageView = new URLImageView(this.context);
        this.bubbleImageView = uRLImageView;
        this.parent.addView(uRLImageView);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onDestroy() {
        this.parent.removeView(this.bubbleImageView);
        this.bubbleImageView = null;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onHide() {
        URLImageView uRLImageView = this.bubbleImageView;
        if (uRLImageView != null) {
            uRLImageView.setVisibility(8);
        }
        j(this, 122, this.bubbleInfo.getId(), null, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onShow() {
        URLImageView uRLImageView = this.bubbleImageView;
        if (uRLImageView == null) {
            return;
        }
        URL picUrl = this.bubbleInfo.getPicUrl();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Unit unit = Unit.INSTANCE;
        uRLImageView.setImageDrawable(URLDrawable.getDrawable(picUrl, obtain));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtil.dp2px(this.context, this.bubbleInfo.getWidth()), UIUtil.dp2px(this.context, this.bubbleInfo.getHeight()));
        layoutParams.gravity = 5;
        layoutParams.setMarginEnd((int) (this.bubbleInfo.getXFromRight() * this.parentWidthPx));
        layoutParams.topMargin = (int) (this.bubbleInfo.getYFromTop() * this.parentHeightPx);
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setVisibility(0);
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.bubble.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.h(p.this, view);
            }
        });
        j(this, 101, this.bubbleInfo.getId(), null, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void setOnClickListener(View.OnClickListener listener) {
        this.outerClickListener = listener;
    }

    static /* synthetic */ void j(p pVar, int i3, long j3, String str, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str = "";
        }
        pVar.i(i3, j3, str);
    }
}
