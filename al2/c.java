package al2;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bl2.HbSkinInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.send.view.HbSkinItemView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lal2/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lbl2/c;", "hbSkinInfo", "", "l", "Lcom/tencent/mobileqq/qwallet/hb/send/view/HbSkinItemView;", "E", "Lcom/tencent/mobileqq/qwallet/hb/send/view/HbSkinItemView;", "hbSkinItemView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "hbSkinDesc", "G", "hbSkinLabel", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "hbSkinBadge", "I", "hbSkinSubTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "J", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HbSkinItemView hbSkinItemView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView hbSkinDesc;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView hbSkinLabel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView hbSkinBadge;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView hbSkinSubTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"al2/c$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getWidth() * 0.081f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.x7_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.hb_skin_item_view)");
        this.hbSkinItemView = (HbSkinItemView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.d1u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.hb_skin_desc)");
        this.hbSkinDesc = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.x7a);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.hb_skin_label)");
        this.hbSkinLabel = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f165667x74);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.hb_skin_badge)");
        this.hbSkinBadge = (ImageView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.x7c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.hb_skin_sub_title)");
        this.hbSkinSubTitle = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.x78);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.hb_skin_item_layout)");
        findViewById6.setOutlineProvider(new a());
        findViewById6.setClipToOutline(true);
    }

    public final void l(@NotNull HbSkinInfo hbSkinInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(hbSkinInfo, "hbSkinInfo");
        if (QLog.isColorLevel()) {
            QLog.d("HbSkinHolder", 2, "onBindViewHolder " + hbSkinInfo);
        }
        this.hbSkinItemView.A0(hbSkinInfo);
        this.hbSkinDesc.setText(hbSkinInfo.getTitle());
        this.hbSkinSubTitle.setText(hbSkinInfo.getExpireDatePrompt());
        String badgeUrl = hbSkinInfo.getBadgeUrl();
        String labelStr = hbSkinInfo.getLabelStr();
        this.hbSkinLabel.setVisibility(8);
        this.hbSkinBadge.setVisibility(8);
        boolean z17 = true;
        if (badgeUrl != null && badgeUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.hbSkinBadge.setVisibility(0);
            this.hbSkinBadge.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(badgeUrl));
            return;
        }
        if (labelStr != null && labelStr.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            this.hbSkinLabel.setVisibility(0);
            this.hbSkinLabel.setText(labelStr);
        }
    }
}
