package com.qzone.reborn.message.section;

import android.view.View;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import bl.CommonNoticeBean;
import bl.CommonNoticePattonInfo;
import bl.CommonStRichMsg;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\f\u001a\u00020\b*\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J*\u0010\u0019\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/message/section/ae;", "Lcom/qzone/reborn/message/section/y;", "Lbl/c;", "noticePatton", "", "D", "", "coverUrl", "", "showPlayIcon", "J", UserInfo.SEX_FEMALE, "G", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "H", "Lcom/tencent/widget/RoundRectImageView;", "i", "Lcom/tencent/widget/RoundRectImageView;", "albumPic", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "albumPicPlayIcon", "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", "coverText", "Landroid/view/View;", "coverContainer", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ae extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAsyncTextView coverText;

    /* renamed from: D, reason: from kotlin metadata */
    private View coverContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView albumPic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView albumPicPlayIcon;

    private final void D(CommonNoticePattonInfo noticePatton) {
        CommonStPicUrl k3 = k9.a.k(noticePatton.getLefttxtRightPic().getPicInfo());
        if (k3 != null && k9.a.i(k3)) {
            J(k3.getUrl(), noticePatton.getIsVideoContent());
            return;
        }
        RoundRectImageView roundRectImageView = this.albumPic;
        ImageView imageView = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setVisibility(8);
        ImageView imageView2 = this.albumPicPlayIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPicPlayIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
        QLog.e("QZonePassiveMessageCoverSection", 1, "[bindCoverPic] error, coverUrl = null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(CommonNoticePattonInfo noticePatton) {
        int collectionSizeOrDefault;
        QZoneAsyncTextView qZoneAsyncTextView = null;
        if (G(noticePatton)) {
            QZoneAsyncTextView qZoneAsyncTextView2 = this.coverText;
            if (qZoneAsyncTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverText");
                qZoneAsyncTextView2 = null;
            }
            qZoneAsyncTextView2.setVisibility(0);
            QZoneAsyncTextView qZoneAsyncTextView3 = this.coverText;
            if (qZoneAsyncTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverText");
            } else {
                qZoneAsyncTextView = qZoneAsyncTextView3;
            }
            ll.a aVar = ll.a.f414984a;
            List<CommonStRichMsg> a16 = noticePatton.getPlainTxt().a();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(com.qzone.reborn.message.data.e.B((CommonStRichMsg) it.next()));
            }
            qZoneAsyncTextView.setText(aVar.c(arrayList, com.qzone.reborn.message.data.e.A(((CommonNoticeBean) this.mData).getCommonExt())));
            return;
        }
        QZoneAsyncTextView qZoneAsyncTextView4 = this.coverText;
        if (qZoneAsyncTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverText");
        } else {
            qZoneAsyncTextView = qZoneAsyncTextView4;
        }
        qZoneAsyncTextView.setVisibility(8);
    }

    private final boolean G(CommonNoticePattonInfo commonNoticePattonInfo) {
        return commonNoticePattonInfo.getPattonType() == 1;
    }

    private final void J(String coverUrl, boolean showPlayIcon) {
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setVisibility(0);
        ImageView imageView = this.albumPicPlayIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPicPlayIcon");
            imageView = null;
        }
        imageView.setVisibility(showPlayIcon ? 0 : 8);
        Option obtain = Option.obtain();
        obtain.setUrl(coverUrl);
        RoundRectImageView roundRectImageView2 = this.albumPic;
        if (roundRectImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView2 = null;
        }
        obtain.setTargetView(roundRectImageView2);
        obtain.setLoadingDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at8, null));
        obtain.setFailedDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
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
        View findViewById3 = containerView.findViewById(R.id.mtg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.qzone_cover_text)");
        this.coverText = (QZoneAsyncTextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.mtf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026id.qzone_cover_container)");
        this.coverContainer = findViewById4;
        RoundRectImageView roundRectImageView = this.albumPic;
        RoundRectImageView roundRectImageView2 = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setCornerRadiusAndMode(com.tencent.mobileqq.utils.am.a(4.0f), 1);
        View view = this.coverContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverContainer");
            view = null;
        }
        view.setOnClickListener(getSpaceClickListener());
        View view2 = this.coverContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverContainer");
            view2 = null;
        }
        view2.setOnLongClickListener(getLongClickListener());
        QZoneAsyncTextView qZoneAsyncTextView = this.coverText;
        if (qZoneAsyncTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverText");
            qZoneAsyncTextView = null;
        }
        qZoneAsyncTextView.setAtTextColor(R.color.qui_common_text_link);
        QZoneAsyncTextView qZoneAsyncTextView2 = this.coverText;
        if (qZoneAsyncTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverText");
            qZoneAsyncTextView2 = null;
        }
        qZoneAsyncTextView2.setOnClickListener(getSpaceClickListener());
        RoundRectImageView roundRectImageView3 = this.albumPic;
        if (roundRectImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
        } else {
            roundRectImageView2 = roundRectImageView3;
        }
        AccessibilityUtil.s(roundRectImageView2, com.qzone.util.l.a(R.string.gqp));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            D(data.getNotice().getNoticePatton());
            F(data.getNotice().getNoticePatton());
        }
    }
}
