package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u001f\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00130\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001c\u001a\n \t*\u0004\u0018\u00010\u00180\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\"\u001a\n \t*\u0004\u0018\u00010\u001d0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\b\u001e\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/j;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;", "", "id", "", "b", "d", "c", "Lcom/tencent/image/URLImageView;", "kotlin.jvm.PlatformType", "Lcom/tencent/image/URLImageView;", "i", "()Lcom/tencent/image/URLImageView;", "titleIconIgv", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "g", "()Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDot", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "e", "()Landroid/widget/ImageView;", "dropdownIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "titleTxv", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "f", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "j", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "titleImage", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/DropdownStatus;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/DropdownStatus;", "()Lcom/tencent/sqshow/zootopia/nativeui/view/title/DropdownStatus;", "l", "(Lcom/tencent/sqshow/zootopia/nativeui/view/title/DropdownStatus;)V", "dropdownStatus", tl.h.F, "I", "()I", "setRedDotId", "(I)V", "redDotId", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends BaseViewPagerTitle.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final URLImageView titleIconIgv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZPlanRedDotView redDot;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView dropdownIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView titleTxv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZPlanMediaView titleImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private DropdownStatus dropdownStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int redDotId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.titleIconIgv = (URLImageView) view.findViewById(R.id.qrb);
        this.redDot = (ZPlanRedDotView) view.findViewById(R.id.qgv);
        this.dropdownIcon = (ImageView) view.findViewById(R.id.pqu);
        this.titleTxv = (TextView) view.findViewById(R.id.qrj);
        this.titleImage = (ZPlanMediaView) view.findViewById(R.id.qrc);
        this.dropdownStatus = DropdownStatus.FOLD;
    }

    public final void b(int id5) {
        this.redDotId = id5;
        this.redDot.g(1);
        this.redDot.h(id5);
    }

    public final void c() {
        d(this.redDotId);
    }

    public final void d(int id5) {
        g94.f.b(g94.f.f401577a, id5, this.redDot.getStoreType(), 0, false, 12, null);
    }

    /* renamed from: e, reason: from getter */
    public final ImageView getDropdownIcon() {
        return this.dropdownIcon;
    }

    /* renamed from: f, reason: from getter */
    public final DropdownStatus getDropdownStatus() {
        return this.dropdownStatus;
    }

    /* renamed from: g, reason: from getter */
    public final ZPlanRedDotView getRedDot() {
        return this.redDot;
    }

    /* renamed from: h, reason: from getter */
    public final int getRedDotId() {
        return this.redDotId;
    }

    /* renamed from: i, reason: from getter */
    public final URLImageView getTitleIconIgv() {
        return this.titleIconIgv;
    }

    /* renamed from: j, reason: from getter */
    public final ZPlanMediaView getTitleImage() {
        return this.titleImage;
    }

    /* renamed from: k, reason: from getter */
    public final TextView getTitleTxv() {
        return this.titleTxv;
    }

    public final void l(DropdownStatus dropdownStatus) {
        Intrinsics.checkNotNullParameter(dropdownStatus, "<set-?>");
        this.dropdownStatus = dropdownStatus;
    }
}
