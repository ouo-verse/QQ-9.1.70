package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedx/widget/QZoneLoadingStateView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "s0", "topMargin", "n0", "", "iconUrl", "p0", "title", "r0", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "o0", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContainerView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mLoadingIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mLoadingTitle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLoadingStateView extends QZoneBaseWidgetView<Integer> {

    /* renamed from: m, reason: collision with root package name */
    private static final int f55950m = ar.e(190.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mLoadingIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mLoadingTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneLoadingStateView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n6s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_loading_state_container)");
        this.mContainerView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.n6r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_loading_icon)");
        this.mLoadingIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n6t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_loading_title)");
        this.mLoadingTitle = (TextView) findViewById3;
        s0();
    }

    private final void n0(int topMargin) {
        this.mContainerView.setPadding(0, topMargin, 0, 0);
    }

    private final void p0(final String iconUrl) {
        if (TextUtils.isEmpty(iconUrl)) {
            this.mLoadingIcon.setVisibility(8);
            return;
        }
        this.mLoadingIcon.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(iconUrl).setTargetView(this.mLoadingIcon), new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.widget.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneLoadingStateView.q0(iconUrl, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(String iconUrl, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(iconUrl, "$iconUrl");
        if (loadState.isFinishError()) {
            QLog.d("QZoneLoadingStateView", 1, "[bindIcon] onStateChange isFinishError: " + iconUrl);
        }
    }

    private final void r0(String title) {
        this.mLoadingTitle.setText(title);
    }

    private final void s0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public /* bridge */ /* synthetic */ void bindData(Object obj, int i3) {
        o0(((Number) obj).intValue(), i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.clm;
    }

    protected void o0(int objData, int pos) {
        if (objData == 5) {
            n0(f55950m);
            String d16 = com.qzone.reborn.util.h.d();
            Intrinsics.checkNotNullExpressionValue(d16, "getMoodListEmptyPageIconUrl()");
            p0(d16);
            String a16 = l.a(R.string.ghb);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobileqq.R.string.qzone_mission)");
            r0(a16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneLoadingStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n6s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_loading_state_container)");
        this.mContainerView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.n6r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_loading_icon)");
        this.mLoadingIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n6t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_loading_title)");
        this.mLoadingTitle = (TextView) findViewById3;
        s0();
    }
}
