package om;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellAction;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellHeader;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$PicInfo;
import cooperation.qzone.contentbox.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lom/f;", "Lom/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "e", "Lnm/b;", "itemData", "", com.tencent.luggage.wxa.c8.c.G, "f", "Lcooperation/qzone/contentbox/RoundCornerImageView;", "Lcooperation/qzone/contentbox/RoundCornerImageView;", "mLeftImageView", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "mHeaderTextView", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "mTitleContainer", "i", "mBottomContainer", "b", "()I", "layoutId", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "j", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView mLeftImageView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mHeaderTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mTitleContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mBottomContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ViewGroup rootView) {
        super(rootView);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(f this$0, nm.b itemData, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(v3, "v");
        QZoneOfficialAccountBase$CellAction cellAction = itemData.getCellAction();
        Intrinsics.checkNotNull(cellAction);
        this$0.d(cellAction.jump_url.get(), v3.getContext());
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // om.a
    public int b() {
        return R.layout.cnn;
    }

    @Override // om.a
    public void e(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.lao);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type cooperation.qzone.contentbox.RoundCornerImageView");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
        this.mLeftImageView = roundCornerImageView;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
            roundCornerImageView = null;
        }
        roundCornerImageView.setCorner(ar.e(4.0f), ar.e(4.0f), ar.e(4.0f), ar.e(4.0f));
        View findViewById2 = rootView.findViewById(R.id.niy);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mHeaderTextView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.jot);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mTitleContainer = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.fyp);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mBottomContainer = (FrameLayout) findViewById4;
    }

    @Override // om.a
    public void f(final nm.b itemData, int pos) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData.l() != 2) {
            QLog.e("QZonePublicAccountItemSmallCardBuilder", 1, "bindData error\uff0cinvalid data");
            return;
        }
        if (!itemData.m() && itemData.k() != null) {
            RoundCornerImageView roundCornerImageView = this.mLeftImageView;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView = null;
            }
            roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RoundCornerImageView roundCornerImageView2 = this.mLeftImageView;
            if (roundCornerImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView2 = null;
            }
            roundCornerImageView2.setBackgroundResource(R.drawable.lvj);
            QZoneOfficialAccountBase$PicInfo k3 = itemData.k();
            Intrinsics.checkNotNull(k3);
            String str = k3.pic_url.get();
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            RoundCornerImageView roundCornerImageView3 = this.mLeftImageView;
            if (roundCornerImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView3 = null;
            }
            Option defaultOptions = Option.getDefaultOptions(roundCornerImageView3);
            RoundCornerImageView roundCornerImageView4 = this.mLeftImageView;
            if (roundCornerImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView4 = null;
            }
            a16.h(defaultOptions.setTargetView(roundCornerImageView4).setUrl(str));
        } else {
            RoundCornerImageView roundCornerImageView5 = this.mLeftImageView;
            if (roundCornerImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView5 = null;
            }
            roundCornerImageView5.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RoundCornerImageView roundCornerImageView6 = this.mLeftImageView;
            if (roundCornerImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView6 = null;
            }
            roundCornerImageView6.setImageResource(R.drawable.f166099);
            RoundCornerImageView roundCornerImageView7 = this.mLeftImageView;
            if (roundCornerImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftImageView");
                roundCornerImageView7 = null;
            }
            roundCornerImageView7.setBackgroundResource(R.drawable.f16626e);
        }
        if (itemData.getCellHeader() != null) {
            TextView textView = this.mHeaderTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView = null;
            }
            QZoneOfficialAccountBase$CellHeader cellHeader = itemData.getCellHeader();
            Intrinsics.checkNotNull(cellHeader);
            textView.setText(cellHeader.header_title.get());
            TextView textView2 = this.mHeaderTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.mHeaderTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderTextView");
                textView3 = null;
            }
            textView3.setVisibility(4);
        }
        pm.c cVar = pm.c.f426463a;
        FrameLayout frameLayout = this.mTitleContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            frameLayout = null;
        }
        cVar.a(itemData, frameLayout);
        pm.a aVar = pm.a.f426461a;
        FrameLayout frameLayout2 = this.mBottomContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainer");
            frameLayout2 = null;
        }
        aVar.a(itemData, frameLayout2);
        if (itemData.getCellAction() != null) {
            QZoneOfficialAccountBase$CellAction cellAction = itemData.getCellAction();
            Intrinsics.checkNotNull(cellAction);
            if (!TextUtils.isEmpty(cellAction.jump_url.get())) {
                getMCardContent().setOnClickListener(new View.OnClickListener() { // from class: om.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.k(f.this, itemData, view);
                    }
                });
                return;
            }
        }
        getMCardContent().setOnClickListener(null);
    }
}
