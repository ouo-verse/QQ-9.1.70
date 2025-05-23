package j84;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZootopiaApngImageView;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;
import com.tencent.sqshow.zootopia.view.ZootopiaSimpleButton;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<R\u001f\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\n0\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\rR\u001f\u0010\u0014\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0018\u001a\n \u0004*\u0004\u0018\u00010\u00150\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017R\u001f\u0010\u001e\u001a\n \u0004*\u0004\u0018\u00010\u00190\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010!\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R\u001f\u0010'\u001a\n \u0004*\u0004\u0018\u00010\"0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010*\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000f8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001f\u00100\u001a\n \u0004*\u0004\u0018\u00010+0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001f\u00102\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u001f\u00107\u001a\n \u0004*\u0004\u0018\u000103038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b\u0010\u00106\u00a8\u0006="}, d2 = {"Lj84/b;", "M", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", h.F, "()Landroid/view/View;", "shimmer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "typeText", "Lcom/tencent/sqshow/zootopia/view/ZootopiaApngImageView;", "Lcom/tencent/sqshow/zootopia/view/ZootopiaApngImageView;", "()Lcom/tencent/sqshow/zootopia/view/ZootopiaApngImageView;", "image", "Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "i", "Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "g", "()Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "maskView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "describe", "Lcom/tencent/sqshow/zootopia/view/ZootopiaSimpleButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/view/ZootopiaSimpleButton;", "b", "()Lcom/tencent/sqshow/zootopia/view/ZootopiaSimpleButton;", "button", "D", "j", "titleText", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "E", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "getCardContainer", "()Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "cardContainer", UserInfo.SEX_FEMALE, "shimmerBottom", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "mainContainer", "view", "", "type", "<init>", "(Landroid/view/View;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b<M> extends BaseViewHolder<M> {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZootopiaSimpleButton button;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView titleText;

    /* renamed from: E, reason: from kotlin metadata */
    private final RoundRelativeLayout cardContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private final View shimmerBottom;

    /* renamed from: G, reason: from kotlin metadata */
    private final RelativeLayout mainContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View shimmer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView typeText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaApngImageView image;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMaskView maskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView describe;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, int i3) {
        super(view);
        RelativeLayout.LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(view, "view");
        this.shimmer = view.findViewById(R.id.ql8);
        this.icon = (ImageView) view.findViewById(R.id.q7r);
        this.typeText = (TextView) view.findViewById(R.id.q7u);
        this.image = (ZootopiaApngImageView) view.findViewById(R.id.phr);
        this.maskView = (ZootopiaMaskView) view.findViewById(R.id.phs);
        this.describe = (TextView) view.findViewById(R.id.q7q);
        this.button = (ZootopiaSimpleButton) view.findViewById(R.id.q7p);
        this.titleText = (TextView) view.findViewById(R.id.q7t);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view.findViewById(R.id.phq);
        this.cardContainer = roundRelativeLayout;
        this.shimmerBottom = view.findViewById(R.id.qle);
        this.mainContainer = (RelativeLayout) view.findViewById(R.id.q39);
        if (i3 == 0) {
            layoutParams = new RelativeLayout.LayoutParams(i.a(130.0f), i.a(166.92f));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, i.a(223.6f));
        }
        roundRelativeLayout.setLayoutParams(layoutParams);
        roundRelativeLayout.f316195e = i.a(8.32f);
        if (i3 == 0) {
            layoutParams2 = new RecyclerView.LayoutParams(i.a(130.0f), i.a(206.96f));
        } else {
            layoutParams2 = new RecyclerView.LayoutParams(-1, i.a(264.16f));
        }
        view.setLayoutParams(layoutParams2);
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaSimpleButton getButton() {
        return this.button;
    }

    /* renamed from: c, reason: from getter */
    public final TextView getDescribe() {
        return this.describe;
    }

    /* renamed from: d, reason: from getter */
    public final ImageView getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final ZootopiaApngImageView getImage() {
        return this.image;
    }

    /* renamed from: f, reason: from getter */
    public final RelativeLayout getMainContainer() {
        return this.mainContainer;
    }

    /* renamed from: g, reason: from getter */
    public final ZootopiaMaskView getMaskView() {
        return this.maskView;
    }

    /* renamed from: h, reason: from getter */
    public final View getShimmer() {
        return this.shimmer;
    }

    /* renamed from: i, reason: from getter */
    public final View getShimmerBottom() {
        return this.shimmerBottom;
    }

    /* renamed from: j, reason: from getter */
    public final TextView getTitleText() {
        return this.titleText;
    }

    /* renamed from: k, reason: from getter */
    public final TextView getTypeText() {
        return this.typeText;
    }
}
