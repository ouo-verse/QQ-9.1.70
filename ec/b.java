package ec;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.base.l;
import com.qzone.reborn.util.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014R\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019\u00a8\u0006,"}, d2 = {"Lec/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "data", "", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "y", "", "coverUrl", BdhLogUtil.LogTag.Tag_Conn, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "B", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "pic", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "tag", "i", "selectedBorder", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", ParseCommon.CONTAINER, "curUrl", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<QZAlbumxBatchLayerSelectedMediaInfoBean> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView pic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView selectedBorder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxSelectedMediaSection";

    /* renamed from: C, reason: from kotlin metadata */
    private String curUrl = "";

    private final void A(QZAlbumxBatchLayerSelectedMediaInfoBean data) {
        TextView textView = null;
        if (!data.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            TextView textView2 = this.tag;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tag");
                textView2 = null;
            }
            textView2.setText("");
            TextView textView3 = this.tag;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tag");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
            return;
        }
        String d16 = c.d((int) data.getVideoTime());
        TextView textView4 = this.tag;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tag");
            textView4 = null;
        }
        textView4.setText(d16);
        TextView textView5 = this.tag;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tag");
        } else {
            textView = textView5;
        }
        textView.setVisibility(0);
    }

    private final void C(String coverUrl) {
        if (TextUtils.isEmpty(coverUrl)) {
            QLog.e(this.TAG, 1, "updateCover error,coverUrl = null");
            return;
        }
        if (Intrinsics.areEqual(this.curUrl, coverUrl)) {
            return;
        }
        Intrinsics.checkNotNull(coverUrl);
        this.curUrl = coverUrl;
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
        ImageView imageView = this.pic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView = null;
        }
        if (imageView.getLayoutParams() != null) {
            ImageView imageView2 = this.pic;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pic");
                imageView2 = null;
            }
            e16.setRequestWidth(imageView2.getLayoutParams().width);
            ImageView imageView3 = this.pic;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pic");
                imageView3 = null;
            }
            e16.setRequestHeight(imageView3.getLayoutParams().height);
        }
        ImageView imageView4 = this.pic;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView4 = null;
        }
        e16.setTargetView(imageView4);
        e16.setLoadingDrawable(p().getResources().getDrawable(R.drawable.at8, null));
        e16.setFailDrawable(p().getResources().getDrawable(R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void v() {
        ImageView imageView = this.pic;
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = r.f59560a.e(52);
        }
        ImageView imageView2 = this.pic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = r.f59560a.e(52);
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.container;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = roundCorneredFrameLayout2.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = r.f59560a.e(52);
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.container;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            roundCorneredFrameLayout = roundCorneredFrameLayout3;
        }
        ViewGroup.LayoutParams layoutParams4 = roundCorneredFrameLayout.getLayoutParams();
        if (layoutParams4 == null) {
            return;
        }
        layoutParams4.height = r.f59560a.e(52);
    }

    private final void w(final QZAlbumxBatchLayerSelectedMediaInfoBean data) {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.container;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(r.f59560a.e(4));
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.container;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            roundCorneredFrameLayout2 = roundCorneredFrameLayout3;
        }
        roundCorneredFrameLayout2.setOnClickListener(new View.OnClickListener() { // from class: ec.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.x(b.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(b this$0, QZAlbumxBatchLayerSelectedMediaInfoBean data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        oc.b bVar = (oc.b) this$0.t(oc.b.class);
        if (bVar != null) {
            bVar.T1(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(QZAlbumxBatchLayerSelectedMediaInfoBean data) {
        C(data.getUrl());
    }

    private final void z(QZAlbumxBatchLayerSelectedMediaInfoBean data) {
        ImageView imageView = this.selectedBorder;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedBorder");
            imageView = null;
        }
        imageView.setVisibility(data.getIsSelected() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZAlbumxBatchLayerSelectedMediaInfoBean data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v();
        y(data);
        A(data);
        z(data);
        w(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nfn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026.id.selected_media_image)");
        this.pic = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nfo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026(R.id.selected_media_tag)");
        this.tag = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nfl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ected_media_checked_mask)");
        this.selectedBorder = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nfm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026selected_media_container)");
        this.container = (RoundCorneredFrameLayout) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
