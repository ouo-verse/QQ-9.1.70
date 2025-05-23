package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0017\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0014J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0018H\u0016R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/aj;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/c;", "Landroid/view/View$OnClickListener;", "", VasPerfReportUtils.WHILE_UPDATE_ITEM, "", "iconUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "y", "w", "Lez/b;", "data", HippyTKDListViewAdapter.X, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "position", "u", "currentPosition", "v", "f", "Landroid/view/View;", NodeProps.ON_CLICK, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "getHolder", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "D", "Landroid/view/View;", "widgetContainer", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "E", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "ivIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tvTitle", "G", "tvButton", "Lez/a;", "H", "Lez/a;", "richWidgetData", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "I", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "J", "Z", "hasExposed", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;)V", "K", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class aj extends c implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final au holder;

    /* renamed from: D, reason: from kotlin metadata */
    private View widgetContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private KandianUrlImageView ivIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvButton;

    /* renamed from: H, reason: from kotlin metadata */
    private ez.a richWidgetData;

    /* renamed from: I, reason: from kotlin metadata */
    private WSVerticalPageFragment fragment;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasExposed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(Context context, au holder) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.holder = holder;
        this.fragment = holder.f82128e;
    }

    private final void updateView() {
        stSimpleMetaFeed e16;
        ez.a aVar = this.richWidgetData;
        TextView textView = null;
        ez.b bVar = aVar instanceof ez.b ? (ez.b) aVar : null;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemWidgetAdvSmallCardController", "[updateWidgetBtnContent] des = " + ((c16 == null || (e16 = c16.e()) == null) ? null : e16.feed_desc) + ", iconType = " + (bVar != null ? Integer.valueOf(bVar.d()) : null) + ", text = " + (bVar != null ? bVar.c() : null) + ", iconUrl = " + (bVar != null ? bVar.a() : null));
        if (!x(bVar)) {
            this.f80410e.setVisibility(8);
            return;
        }
        if (bVar != null) {
            this.f80410e.setVisibility(0);
            TextView textView2 = this.tvTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                textView2 = null;
            }
            textView2.setText(bVar.c());
            TextView textView3 = this.tvButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvButton");
            } else {
                textView = textView3;
            }
            textView.setText(bVar.k());
            z(bVar.a());
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void w() {
        if (this.hasExposed) {
            return;
        }
        this.hasExposed = true;
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
        WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.V(from, wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null, c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean y() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        au z16;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        stSimpleMetaFeed e16 = c16 != null ? c16.e() : null;
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = (wSVerticalPageFragment == null || (adapter = wSVerticalPageFragment.getAdapter()) == null || (z16 = adapter.z()) == null) ? null : (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f;
        if (jVar == null) {
            return false;
        }
        String str = e16 != null ? e16.f25129id : null;
        if (str == null || str.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual(e16 != null ? e16.f25129id : null, jVar.e().f25129id);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null) {
            this.richWidgetData = c16.f();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        updateView();
        if (y()) {
            w();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        View view = this.widgetContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetContainer");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.j(this.fragment, c());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int position) {
        this.hasExposed = false;
        if (this.f80410e.getVisibility() == 0) {
            WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
            String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
            WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.V(from, wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null, c());
        }
    }

    private final boolean x(ez.b data) {
        boolean isBlank;
        boolean isBlank2;
        if (data != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(data.c());
            if (!isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(data.k());
                if (!isBlank2 && (data.d() == 3 || data.d() == 5)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z(String iconUrl) {
        boolean z16;
        boolean isBlank;
        if (iconUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(iconUrl);
            if (!isBlank) {
                z16 = false;
                KandianUrlImageView kandianUrlImageView = null;
                if (!z16) {
                    KandianUrlImageView kandianUrlImageView2 = this.ivIcon;
                    if (kandianUrlImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
                    } else {
                        kandianUrlImageView = kandianUrlImageView2;
                    }
                    kandianUrlImageView.setVisibility(8);
                    return;
                }
                KandianUrlImageView kandianUrlImageView3 = this.ivIcon;
                if (kandianUrlImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
                    kandianUrlImageView3 = null;
                }
                kandianUrlImageView3.setVisibility(0);
                WSPicLoader g16 = WSPicLoader.g();
                KandianUrlImageView kandianUrlImageView4 = this.ivIcon;
                if (kandianUrlImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
                    kandianUrlImageView4 = null;
                }
                g16.w(kandianUrlImageView4, iconUrl, null);
                return;
            }
        }
        z16 = true;
        KandianUrlImageView kandianUrlImageView5 = null;
        if (!z16) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.p4x);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type android.view.View");
        this.widgetContainer = p16;
        View p17 = p(R.id.p4_);
        Intrinsics.checkNotNull(p17, "null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView");
        this.ivIcon = (KandianUrlImageView) p17;
        View p18 = p(R.id.f163268p71);
        Intrinsics.checkNotNull(p18, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTitle = (TextView) p18;
        View p19 = p(R.id.f163267p70);
        Intrinsics.checkNotNull(p19, "null cannot be cast to non-null type android.widget.TextView");
        this.tvButton = (TextView) p19;
        View view = this.widgetContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetContainer");
            view = null;
        }
        view.setOnClickListener(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int currentPosition) {
    }
}
