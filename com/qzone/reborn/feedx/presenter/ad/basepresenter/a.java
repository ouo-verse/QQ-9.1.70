package com.qzone.reborn.feedx.presenter.ad.basepresenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0002>?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00105\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u00101\u001a\u0004\b!\u00102\"\u0004\b3\u00104R&\u0010;\u001a\u000606R\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00107\u001a\u0004\b)\u00108\"\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", "J", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "L", "K", "N", "O", "Landroid/view/ViewStub;", UserInfo.SEX_FEMALE, "Landroid/view/ViewStub;", "getMAdBottomRightBtnViewStub", "()Landroid/view/ViewStub;", "setMAdBottomRightBtnViewStub", "(Landroid/view/ViewStub;)V", "mAdBottomRightBtnViewStub", "G", "Z", "getMIsAdBottomRightBtnInflate", "()Z", "setMIsAdBottomRightBtnInflate", "(Z)V", "mIsAdBottomRightBtnInflate", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "getMAdBottomRightText", "()Landroid/widget/TextView;", "setMAdBottomRightText", "(Landroid/widget/TextView;)V", "mAdBottomRightText", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "getMAdBottomRightImg", "()Landroid/widget/ImageView;", "setMAdBottomRightImg", "(Landroid/widget/ImageView;)V", "mAdBottomRightImg", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "setMAdBottomRightLayout", "(Landroid/widget/LinearLayout;)V", "mAdBottomRightLayout", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a$a;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a$a;", "()Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a$a;", "setMAdFeedBottomData", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a$a;)V", "mAdFeedBottomData", "<init>", "()V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class a extends vg.a implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private ViewStub mAdBottomRightBtnViewStub;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsAdBottomRightBtnInflate;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mAdBottomRightText;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mAdBottomRightImg;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout mAdBottomRightLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private C0466a mAdFeedBottomData = new C0466a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "rightBtnText", "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/a;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.presenter.ad.basepresenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public final class C0466a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String rightBtnText = "\u7acb\u5373\u67e5\u770b";

        public C0466a() {
        }

        /* renamed from: a, reason: from getter */
        public final String getRightBtnText() {
            return this.rightBtnText;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rightBtnText = str;
        }
    }

    private final void J() {
        if (this.mIsAdBottomRightBtnInflate) {
            return;
        }
        View view = this.f441562d;
        ViewStub viewStub = view != null ? (ViewStub) view.findViewById(R.id.nmi) : null;
        this.mAdBottomRightBtnViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mAdBottomRightLayout = (LinearLayout) this.f441562d.findViewById(R.id.f162812mr4);
        this.mAdBottomRightText = (TextView) this.f441562d.findViewById(R.id.f162786mm4);
        this.mAdBottomRightImg = (ImageView) this.f441562d.findViewById(R.id.f162783mm1);
        this.mIsAdBottomRightBtnInflate = true;
        View view2 = this.f441562d;
        if (view2 != null) {
            int color = view2.getResources().getColor(R.color.qui_common_brand_standard);
            TextView textView = this.mAdBottomRightText;
            if (textView != null) {
                textView.setTextColor(color);
            }
        }
    }

    /* renamed from: H, reason: from getter */
    public final LinearLayout getMAdBottomRightLayout() {
        return this.mAdBottomRightLayout;
    }

    /* renamed from: I, reason: from getter */
    public final C0466a getMAdFeedBottomData() {
        return this.mAdFeedBottomData;
    }

    public abstract boolean K();

    public abstract boolean L();

    public abstract void M();

    public abstract void N();

    public void O() {
        J();
        LinearLayout linearLayout = this.mAdBottomRightLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.mAdBottomRightText;
        if (textView != null) {
            String rightBtnText = this.mAdFeedBottomData.getRightBtnText();
            if (rightBtnText.length() == 0) {
                rightBtnText = "\u7acb\u5373\u67e5\u770b";
            }
            textView.setText(rightBtnText);
        }
        TextView textView2 = this.mAdBottomRightText;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        ImageView imageView = this.mAdBottomRightImg;
        if (imageView != null) {
            imageView.setColorFilter(ResourcesCompat.getColor(this.f441562d.getResources(), R.color.qui_common_brand_standard, null));
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmm;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        ViewParent parent;
        if (feedData == null) {
            return;
        }
        View view = this.f441562d;
        ViewGroup viewGroup = (ViewGroup) ((view == null || (parent = view.getParent()) == null) ? null : parent.getParent());
        this.f441562d.setVisibility(8);
        if (L()) {
            QLog.d(getTAG(), 2, "[onBindData] don't show bottom view");
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(8);
            return;
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (K()) {
            QLog.d(getTAG(), 2, "[onBindData] don't show bottom right view");
            return;
        }
        View view2 = this.f441562d;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        M();
        N();
    }
}
