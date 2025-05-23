package kk;

import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StLeftTxtRightPicInfo;
import qzone.QZIntimateSpaceReader$StNoticePattonInfo;
import qzone.QZIntimateSpaceReader$StPlainTxtInfo;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StRichMsg;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J*\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lkk/b;", "Lkk/a;", "Landroid/view/View$OnClickListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", BdhLogUtil.LogTag.Tag_Conn, "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/reborn/message/data/a;", "data", "", "position", "", "", "payload", "D", "view", NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivLeftPic", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "tvRightText", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "i", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "contentLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends a implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateMessageContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivLeftPic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView tvRightText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout contentLayout;

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        PBRepeatMessageField<QZoneBaseMeta$StRichMsg> pBRepeatMessageField;
        PBRepeatMessageField<QZoneBaseMeta$StRichMsg> pBRepeatMessageField2;
        QZoneRichTextView qZoneRichTextView = null;
        if (C()) {
            QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_patton;
            QZIntimateSpaceReader$StLeftTxtRightPicInfo qZIntimateSpaceReader$StLeftTxtRightPicInfo = qZIntimateSpaceReader$StNoticePattonInfo != null ? qZIntimateSpaceReader$StNoticePattonInfo.lefttxt_right_pic : null;
            String N = oj.a.f423008a.N((qZIntimateSpaceReader$StLeftTxtRightPicInfo == null || (pBRepeatMessageField2 = qZIntimateSpaceReader$StLeftTxtRightPicInfo.txt_info) == null) ? null : pBRepeatMessageField2.get(), ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt());
            QZoneRichTextView qZoneRichTextView2 = this.tvRightText;
            if (qZoneRichTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvRightText");
            } else {
                qZoneRichTextView = qZoneRichTextView2;
            }
            qZoneRichTextView.setRichText(N);
            return;
        }
        QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo2 = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_patton;
        QZIntimateSpaceReader$StPlainTxtInfo qZIntimateSpaceReader$StPlainTxtInfo = qZIntimateSpaceReader$StNoticePattonInfo2 != null ? qZIntimateSpaceReader$StNoticePattonInfo2.plain_txt : null;
        String N2 = oj.a.f423008a.N((qZIntimateSpaceReader$StPlainTxtInfo == null || (pBRepeatMessageField = qZIntimateSpaceReader$StPlainTxtInfo.txt_info) == null) ? null : pBRepeatMessageField.get(), ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt());
        QZoneRichTextView qZoneRichTextView3 = this.tvRightText;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightText");
        } else {
            qZoneRichTextView = qZoneRichTextView3;
        }
        qZoneRichTextView.setRichText(N2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B() {
        HashMap hashMap = new HashMap();
        hashMap.put("notice_type", Integer.valueOf(((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_type.get()));
        fo.b i3 = new fo.b().l(hashMap).i(((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_id.get());
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.contentLayout;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            roundCorneredFrameLayout = null;
        }
        fo.c.o(roundCorneredFrameLayout, "em_qz_message_notification", i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C() {
        PBUInt32Field pBUInt32Field;
        QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_patton;
        return (qZIntimateSpaceReader$StNoticePattonInfo == null || (pBUInt32Field = qZIntimateSpaceReader$StNoticePattonInfo.patton_type) == null || pBUInt32Field.get() != 2) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        PBStringField pBStringField;
        ImageView imageView = null;
        if (C()) {
            ImageView imageView2 = this.ivLeftPic;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLeftPic");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_patton;
            QZIntimateSpaceReader$StLeftTxtRightPicInfo qZIntimateSpaceReader$StLeftTxtRightPicInfo = qZIntimateSpaceReader$StNoticePattonInfo != null ? qZIntimateSpaceReader$StNoticePattonInfo.lefttxt_right_pic : null;
            QZoneBaseMeta$StPicUrl g16 = ij.h.g(qZIntimateSpaceReader$StLeftTxtRightPicInfo != null ? qZIntimateSpaceReader$StLeftTxtRightPicInfo.pic_info : null);
            if (ij.h.f(g16)) {
                com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
                Option url = Option.obtain().setUrl((g16 == null || (pBStringField = g16.url) == null) ? null : pBStringField.get());
                ImageView imageView3 = this.ivLeftPic;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLeftPic");
                } else {
                    imageView = imageView3;
                }
                a16.h(url.setTargetView(imageView));
                return;
            }
            ImageView imageView4 = this.ivLeftPic;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLeftPic");
            } else {
                imageView = imageView4;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.ivLeftPic;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLeftPic");
        } else {
            imageView = imageView5;
        }
        imageView.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        boolean z16 = true;
        if ((valueOf == null || valueOf.intValue() != R.id.n7m) && (valueOf == null || valueOf.intValue() != R.id.n77)) {
            z16 = false;
        }
        if (z16) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.qzone_message_left_pic)");
        this.ivLeftPic = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n7m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026qzone_message_right_text)");
        this.tvRightText = (QZoneRichTextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n77);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026e_message_content_layout)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById3;
        this.contentLayout = roundCorneredFrameLayout;
        QZoneRichTextView qZoneRichTextView = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(ImmersiveUtils.dpToPx(4.0f));
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.contentLayout;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            roundCorneredFrameLayout2 = null;
        }
        roundCorneredFrameLayout2.setOnClickListener(this);
        QZoneRichTextView qZoneRichTextView2 = this.tvRightText;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightText");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setOnClickListener(this);
        QZoneRichTextView qZoneRichTextView3 = this.tvRightText;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightText");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setMaxLine(2);
        QZoneRichTextView qZoneRichTextView4 = this.tvRightText;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightText");
        } else {
            qZoneRichTextView = qZoneRichTextView4;
        }
        qZoneRichTextView.setTextColorLink(p().getResources().getColor(R.color.qui_common_text_primary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.noq};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.message.data.a data, int position, List<Object> payload) {
        if (data != null) {
            z();
            A();
            B();
        }
    }
}
