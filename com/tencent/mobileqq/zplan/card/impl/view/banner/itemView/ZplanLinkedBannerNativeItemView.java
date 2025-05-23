package com.tencent.mobileqq.zplan.card.impl.view.banner.itemView;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pu4.t;
import pv4.s;
import pv4.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0016\u0018\u0000 V2\u00020\u0001:\u0001WB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\bT\u0010UJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u0010/\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b-\u0010$\u001a\u0004\b#\u0010%\"\u0004\b.\u0010'R\"\u00105\u001a\u00020\u001e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b0\u0010 \u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010-R\u0014\u0010E\u001a\u00020B8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b@\u0010-R\u0014\u0010G\u001a\u00020B8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bF\u0010-R\u0014\u0010I\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010@R\u0014\u0010K\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010@R\u0014\u0010M\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010@R\u0014\u0010O\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010@R\u0014\u0010Q\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010@R\u0014\u0010S\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010@\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanLinkedBannerNativeItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanBaseDownloadButtonItemView;", "", "", "picList", "", "o", "([Ljava/lang/String;)V", "p", ReportConstant.COSTREPORT_PREFIX, "Lpv4/s;", "data", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "t", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Loa4/a;", h.F, "Loa4/a;", "getMapResViewModel", "()Loa4/a;", "mapResViewModel", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "u", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "bgImage", BdhLogUtil.LogTag.Tag_Conn, "j", "v", "contentImage", "D", "y", "titleImage", "E", "l", "()Landroid/view/View;", HippyTKDListViewAdapter.X, "(Landroid/view/View;)V", "tagsView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "w", "(Landroid/widget/TextView;)V", "contentText", "", "G", "I", "cardWidth", "", "H", "bgRate", "contentRate", "J", "titleRate", "K", "bgHeight", "L", "contentWidth", "M", "contentHeight", "N", "titleWidth", "P", "titleHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "topMarginRate", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;)V", BdhLogUtil.LogTag.Tag_Req, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanLinkedBannerNativeItemView extends ZplanBaseDownloadButtonItemView {
    private static final int S = ViewUtils.dpToPx(16.0f);

    /* renamed from: C, reason: from kotlin metadata */
    protected ZPlanMediaView contentImage;

    /* renamed from: D, reason: from kotlin metadata */
    protected ZPlanMediaView titleImage;

    /* renamed from: E, reason: from kotlin metadata */
    protected View tagsView;

    /* renamed from: F, reason: from kotlin metadata */
    protected TextView contentText;

    /* renamed from: G, reason: from kotlin metadata */
    private final int cardWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private final double bgRate;

    /* renamed from: I, reason: from kotlin metadata */
    private final double contentRate;

    /* renamed from: J, reason: from kotlin metadata */
    private final double titleRate;

    /* renamed from: K, reason: from kotlin metadata */
    private final int bgHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private final int contentWidth;

    /* renamed from: M, reason: from kotlin metadata */
    private final int contentHeight;

    /* renamed from: N, reason: from kotlin metadata */
    private final int titleWidth;

    /* renamed from: P, reason: from kotlin metadata */
    private final int titleHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int topMarginRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected ZPlanMediaView bgImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanLinkedBannerNativeItemView(Context context, LifecycleOwner lifecycleOwner, oa4.a mapResViewModel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        this.lifecycleOwner = lifecycleOwner;
        this.mapResViewModel = mapResViewModel;
        int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(32.0f);
        this.cardWidth = screenWidth;
        this.bgRate = 0.48703170028818443d;
        this.contentRate = 0.6856060606060606d;
        this.titleRate = 0.4596774193548387d;
        this.bgHeight = (int) (screenWidth * 0.48703170028818443d);
        int i3 = (int) (screenWidth * 0.6657060518731989d);
        this.contentWidth = i3;
        int i16 = (int) (i3 * 0.6856060606060606d);
        this.contentHeight = i16;
        int i17 = (int) (screenWidth * 0.3573487031700288d);
        this.titleWidth = i17;
        this.titleHeight = (int) (i17 * 0.4596774193548387d);
        this.topMarginRate = (int) (i16 * 0.1712707182320442d);
        n(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(String[] picList) {
        String str;
        RoundCornerImageView l3;
        g gVar = new g();
        gVar.f427435b = "png";
        if (picList != null) {
            if (!(picList.length == 0)) {
                str = picList[0];
                gVar.f427434a = str;
                ZPlanMediaView i3 = i();
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.cardWidth, this.bgHeight);
                layoutParams.startToStart = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.endToEnd = 0;
                i3.setLayoutParams(layoutParams);
                i().setDefaultDrawable(new ColorDrawable(q.a(R.color.f8426x)));
                i().e(gVar);
                l3 = i().l();
                if (l3 != null) {
                    return;
                }
                l3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return;
            }
        }
        str = "";
        gVar.f427434a = str;
        ZPlanMediaView i36 = i();
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(this.cardWidth, this.bgHeight);
        layoutParams2.startToStart = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.endToEnd = 0;
        i36.setLayoutParams(layoutParams2);
        i().setDefaultDrawable(new ColorDrawable(q.a(R.color.f8426x)));
        i().e(gVar);
        l3 = i().l();
        if (l3 != null) {
        }
    }

    private final void p(String[] picList) {
        String str;
        g gVar = new g();
        gVar.f427435b = "png";
        if (picList != null && picList.length > 1) {
            str = picList[1];
        } else {
            str = "";
        }
        gVar.f427434a = str;
        ZPlanMediaView j3 = j();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.contentWidth, this.contentHeight);
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        j3.setLayoutParams(layoutParams);
        j().setDefaultDrawable(null);
        j().e(gVar);
        RoundCornerImageView l3 = j().l();
        if (l3 == null) {
            return;
        }
        l3.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private final void q(s data) {
        m84.b.h(k(), data.f427680a);
    }

    private final void r(s data) {
        List listOf;
        u[] uVarArr = data.f427689j;
        if (uVarArr != null) {
            if (!(uVarArr.length == 0)) {
                View findViewById = l().findViewById(R.id.r8o);
                Intrinsics.checkNotNullExpressionValue(findViewById, "tagsView.findViewById(R.id.zplan_tag_first)");
                View findViewById2 = l().findViewById(R.id.r8r);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "tagsView.findViewById(R.id.zplan_tag_mid)");
                View findViewById3 = l().findViewById(R.id.r8p);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "tagsView.findViewById(R.id.zplan_tag_last)");
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TextView[]{(TextView) findViewById, (TextView) findViewById2, (TextView) findViewById3});
                int length = uVarArr.length;
                int size = listOf.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (length > i3) {
                        m84.b.h((TextView) listOf.get(i3), uVarArr[i3]);
                    } else {
                        ((TextView) listOf.get(i3)).setVisibility(8);
                    }
                }
                return;
            }
        }
        l().setVisibility(4);
    }

    private final void s(String[] picList) {
        String str;
        g gVar = new g();
        gVar.f427435b = "png";
        if (picList != null && picList.length > 2) {
            str = picList[2];
        } else {
            str = "";
        }
        gVar.f427434a = str;
        ZPlanMediaView m3 = m();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.titleWidth, this.titleHeight);
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.topMarginRate;
        m3.setLayoutParams(layoutParams);
        m();
        m().setDefaultDrawable(null);
        m().e(gVar);
        RoundCornerImageView l3 = m().l();
        if (l3 == null) {
            return;
        }
        l3.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    protected final ZPlanMediaView i() {
        ZPlanMediaView zPlanMediaView = this.bgImage;
        if (zPlanMediaView != null) {
            return zPlanMediaView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bgImage");
        return null;
    }

    protected final ZPlanMediaView j() {
        ZPlanMediaView zPlanMediaView = this.contentImage;
        if (zPlanMediaView != null) {
            return zPlanMediaView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentImage");
        return null;
    }

    protected final TextView k() {
        TextView textView = this.contentText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentText");
        return null;
    }

    protected final View l() {
        View view = this.tagsView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tagsView");
        return null;
    }

    protected final ZPlanMediaView m() {
        ZPlanMediaView zPlanMediaView = this.titleImage;
        if (zPlanMediaView != null) {
            return zPlanMediaView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleImage");
        return null;
    }

    public final void n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167450dd4, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026ve_item_view, this, true)");
        this.view = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.r46);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.zplan_download_button)");
        g((ZplanCommonButton) findViewById);
        View view2 = this.view;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.r6f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.zplan_iv_item_bg)");
        u((ZPlanMediaView) findViewById2);
        View view3 = this.view;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.r6g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.zplan_iv_item_content)");
        v((ZPlanMediaView) findViewById3);
        View view4 = this.view;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.r6h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.zplan_iv_item_title)");
        y((ZPlanMediaView) findViewById4);
        View view5 = this.view;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.r9z);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.zplan_view_tags)");
        x(findViewById5);
        View view6 = this.view;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            view = view6;
        }
        View findViewById6 = view.findViewById(R.id.r97);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.zplan_tv_item_content)");
        w((TextView) findViewById6);
        setDownloadButtonBinder(new ZootopiaDownloadButtonBinder(context, this.lifecycleOwner, this.mapResViewModel));
    }

    public final void t(s data) {
        t tVar;
        Intrinsics.checkNotNullParameter(data, "data");
        g gVar = data.f427681b;
        String[] strArr = (gVar == null || (tVar = gVar.f427438e) == null) ? null : tVar.f427524b;
        o(strArr);
        p(strArr);
        s(strArr);
        r(data);
        q(data);
    }

    protected final void u(ZPlanMediaView zPlanMediaView) {
        Intrinsics.checkNotNullParameter(zPlanMediaView, "<set-?>");
        this.bgImage = zPlanMediaView;
    }

    protected final void v(ZPlanMediaView zPlanMediaView) {
        Intrinsics.checkNotNullParameter(zPlanMediaView, "<set-?>");
        this.contentImage = zPlanMediaView;
    }

    protected final void w(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.contentText = textView;
    }

    protected final void x(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.tagsView = view;
    }

    protected final void y(ZPlanMediaView zPlanMediaView) {
        Intrinsics.checkNotNullParameter(zPlanMediaView, "<set-?>");
        this.titleImage = zPlanMediaView;
    }
}
