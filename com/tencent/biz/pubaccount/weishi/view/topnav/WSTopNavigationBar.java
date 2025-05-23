package com.tencent.biz.pubaccount.weishi.view.topnav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b20.c;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xz.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B)\b\u0007\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\t\u00a2\u0006\u0004\b0\u00101J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J@\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0005R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0016\u0010$\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "Landroid/widget/RelativeLayout;", "", "isShowUnderLine", "isShowDetailBtn", "", "g", "d", "f", "", "backBtnResId", "detailBtnResId", "bgColor", "isShowFloatWindowBtn", "e", "a", "layoutId", "Landroid/view/View;", "c", "Landroid/view/View$OnClickListener;", "listener", "setBackBtnClickListener", "setDetailBtnClickListener", "setFloatWindowBtnClickListener", "barStyle", "setTopBarStyle", "b", "Landroid/view/ViewStub;", "Landroid/view/ViewStub;", "centerContentViewStub", "Landroid/view/View;", "underLine", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "backBtn", h.F, "detailBtn", "i", "floatWindowBtn", "Lb20/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb20/c;", "topFloatWindowGuide", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "Companion", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSTopNavigationBar extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewStub centerContentViewStub;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View underLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView detailBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView floatWindowBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final c topFloatWindowGuide;

    public WSTopNavigationBar(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void e(int backBtnResId, int detailBtnResId, int bgColor, boolean isShowUnderLine, boolean isShowDetailBtn, boolean isShowFloatWindowBtn) {
        this.backBtn.setImageResource(backBtnResId);
        this.detailBtn.setImageResource(detailBtnResId);
        setBackgroundColor(getResources().getColor(bgColor));
        this.underLine.setVisibility(isShowUnderLine ? 0 : 8);
        this.detailBtn.setVisibility(isShowDetailBtn ? 0 : 8);
        a(isShowFloatWindowBtn);
    }

    public final void b() {
        this.topFloatWindowGuide.l();
    }

    public final View c(int layoutId) {
        this.centerContentViewStub.setLayoutResource(layoutId);
        View inflate = this.centerContentViewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "centerContentViewStub.inflate()");
        return inflate;
    }

    public final void setBackBtnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.backBtn.setOnClickListener(listener);
    }

    public final void setDetailBtnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.detailBtn.setOnClickListener(listener);
    }

    public final void setFloatWindowBtnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.floatWindowBtn.setOnClickListener(listener);
    }

    public WSTopNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WSTopNavigationBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void a(boolean isShowFloatWindowBtn) {
        if (isShowFloatWindowBtn && b.f449122a.c()) {
            this.floatWindowBtn.setVisibility(0);
            this.topFloatWindowGuide.g(this.floatWindowBtn);
        } else {
            this.floatWindowBtn.setVisibility(8);
            b();
        }
    }

    public WSTopNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.topFloatWindowGuide = new c(context);
        View.inflate(context, R.layout.d1m, this);
        View findViewById = findViewById(R.id.p3g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.center_content_container)");
        this.centerContentViewStub = (ViewStub) findViewById;
        View findViewById2 = findViewById(R.id.p98);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ws_title_bar_under_line)");
        this.underLine = findViewById2;
        View findViewById3 = findViewById(R.id.f163280p93);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ws_iv_back)");
        this.backBtn = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f163281p94);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ws_iv_detail)");
        this.detailBtn = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.p4d);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_float_window_btn)");
        this.floatWindowBtn = (ImageView) findViewById5;
    }

    public static /* synthetic */ void setTopBarStyle$default(WSTopNavigationBar wSTopNavigationBar, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z17 = true;
        }
        wSTopNavigationBar.setTopBarStyle(i3, z16, z17);
    }

    public final void setTopBarStyle(int barStyle, boolean isShowUnderLine, boolean isShowDetailBtn) {
        if (barStyle == 1) {
            g(isShowUnderLine, isShowDetailBtn);
        } else if (barStyle == 2) {
            d(isShowUnderLine, isShowDetailBtn);
        } else {
            if (barStyle != 3) {
                return;
            }
            f(isShowUnderLine, isShowDetailBtn);
        }
    }

    private final void d(boolean isShowUnderLine, boolean isShowDetailBtn) {
        e(R.drawable.m6m, R.drawable.m6r, R.color.f7594o, isShowUnderLine, isShowDetailBtn, false);
    }

    private final void f(boolean isShowUnderLine, boolean isShowDetailBtn) {
        e(R.drawable.m6m, R.drawable.m6r, R.color.f7674w, isShowUnderLine, isShowDetailBtn, true);
    }

    private final void g(boolean isShowUnderLine, boolean isShowDetailBtn) {
        e(R.drawable.m6l, R.drawable.m6q, R.color.f7674w, isShowUnderLine, isShowDetailBtn, false);
    }
}
