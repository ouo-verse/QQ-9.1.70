package nl;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.ar;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lnl/f;", "Lnl/b;", "Landroid/view/View;", "view", "", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "stNotice", "D", "", "coverUrl", "", "showPlayIcon", "J", "", "getViewStubLayoutId", "containerView", "onInitView", "Lkl/a;", "data", "", "position", "", "", "payload", "G", tl.h.F, "Ljava/lang/String;", "TAG", "Lcom/tencent/widget/RoundRectImageView;", "i", "Lcom/tencent/widget/RoundRectImageView;", "albumPic", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "albumPicPlayIcon", "Landroid/view/View$OnClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnClickListener;", "clickPicListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends b {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView albumPic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView albumPicPlayIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneNoticeCoverSection";

    /* renamed from: C, reason: from kotlin metadata */
    private final View.OnClickListener clickPicListener = new View.OnClickListener() { // from class: nl.e
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.F(f.this, view);
        }
    };

    private final void D(Notice stNotice) {
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setCornerRadiusAndMode(ar.d(4.0f), 1);
        yh.a aVar = yh.a.f450323a;
        StFeed stFeed = stNotice.feed;
        Intrinsics.checkNotNullExpressionValue(stFeed, "stNotice.feed");
        BusinessFeedData g16 = aVar.g(stFeed, stNotice.ext);
        String coverUrl = stNotice.noticePatton.lefttxtRightPic.picInfo.defaultUrl.url;
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        J(coverUrl, g16.getVideoInfo() != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(f this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A(it);
        this$0.H(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void J(String coverUrl, boolean showPlayIcon) {
        if (TextUtils.isEmpty(coverUrl)) {
            QLog.e(this.TAG, 1, "updateCover error,coverUrl = null");
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(coverUrl);
        ImageView imageView = this.albumPicPlayIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPicPlayIcon");
            imageView = null;
        }
        imageView.setVisibility(showPlayIcon ? 0 : 8);
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        obtain.setTargetView(roundRectImageView);
        obtain.setLoadingDrawable(p().getResources().getDrawable(R.drawable.at8, null));
        obtain.setFailDrawable(p().getResources().getDrawable(R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(kl.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        D(data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String());
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        x(roundRectImageView, "em_qz_picture_area");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mnz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.qzone_album_pic)");
        this.albumPic = (RoundRectImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f162793mo1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026zone_album_pic_play_icon)");
        this.albumPicPlayIcon = (ImageView) findViewById2;
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setOnClickListener(this.clickPicListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void H(View view) {
    }
}
