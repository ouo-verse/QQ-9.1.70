package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import jh.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0002'+B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J8\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001cJ\u001e\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0011J\u0018\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001fR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010;R\u0016\u0010=\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u00108R\u0016\u0010>\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u00100R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010@R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010BR\u0016\u0010D\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u00100R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u00100R\"\u0010P\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010S\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u0016\u0010U\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010TR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010W\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010KR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006]"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/ag;", "", "Landroid/content/Context;", "context", "", tl.h.F, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "coverUrl", "v", "g", "y", HippyTKDListViewAdapter.X, "w", "u", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "", "url", "l", "i", "Landroid/graphics/Bitmap;", "p", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Landroidx/core/util/Consumer;", "Lcom/qzone/reborn/feedpro/utils/ag$b;", "result", "", "isAddQRCode", "j", "", "width", "height", "filePath", ReportConstant.COSTREPORT_PREFIX, "resourceId", DomainData.DOMAIN_NAME, "Landroid/view/View;", "a", "Landroid/view/View;", "shareCardView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "b", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundPicLayout", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "ivImageView", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "d", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "tvShareText", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvShareTime", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "shareAvatar", "tvShareNick", "ivWaterMark", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "llShareTextArea", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "k", "qrcodeView", "Landroid/content/Context;", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "qrcodeLL", "ivVideoPlayView", "I", "getCardViewWidth", "()I", "setCardViewWidth", "(I)V", "cardViewWidth", "getCardViewHeight", "setCardViewHeight", "cardViewHeight", "Z", "isVideoCover", "r", "successType", "t", "Landroidx/core/util/Consumer;", "resultCallback", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ag {

    /* renamed from: v, reason: collision with root package name */
    private static final int f54277v = ImmersiveUtils.dpToPx(16.0f);

    /* renamed from: w, reason: collision with root package name */
    private static final int f54278w = ImmersiveUtils.dpToPx(305.0f);

    /* renamed from: x, reason: collision with root package name */
    private static final int f54279x = ImmersiveUtils.dpToPx(228.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View shareCardView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout roundPicLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView ivImageView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView tvShareText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvShareTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView shareAvatar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView tvShareNick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivWaterMark;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llShareTextArea;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private CommonFeed feedData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ImageView qrcodeView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout qrcodeLL;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ImageView ivVideoPlayView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int cardViewWidth;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int cardViewHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoCover;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isAddQRCode;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int successType = 4;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Consumer<QZoneQrcodeResult> resultCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/ag$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(ZLjava/lang/String;Landroid/graphics/Bitmap;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.utils.ag$b, reason: from toString */
    /* loaded from: classes37.dex */
    public static final /* data */ class QZoneQrcodeResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String filePath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final Bitmap bitmap;

        public QZoneQrcodeResult(boolean z16, String str, Bitmap bitmap) {
            this.isSuccess = z16;
            this.filePath = str;
            this.bitmap = bitmap;
        }

        /* renamed from: a, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.filePath;
            int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            Bitmap bitmap = this.bitmap;
            return hashCode + (bitmap != null ? bitmap.hashCode() : 0);
        }

        public String toString() {
            return "QZoneQrcodeResult(isSuccess=" + this.isSuccess + ", filePath=" + this.filePath + ", bitmap=" + this.bitmap + ")";
        }

        public /* synthetic */ QZoneQrcodeResult(boolean z16, String str, Bitmap bitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : bitmap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QZoneQrcodeResult)) {
                return false;
            }
            QZoneQrcodeResult qZoneQrcodeResult = (QZoneQrcodeResult) other;
            return this.isSuccess == qZoneQrcodeResult.isSuccess && Intrinsics.areEqual(this.filePath, qZoneQrcodeResult.filePath) && Intrinsics.areEqual(this.bitmap, qZoneQrcodeResult.bitmap);
        }
    }

    private final void f(CommonPicUrl coverUrl) {
        int coerceAtMost;
        float coerceAtLeast;
        float coerceAtMost2;
        pl.a aVar = pl.a.f426446a;
        Context context = this.context;
        ImageView imageView = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(aVar.o(context), f54278w);
        int i3 = coerceAtMost - f54277v;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((coverUrl.getWidth() == 0 || coverUrl.getHeight() == 0) ? 1.0f : coverUrl.getWidth() / coverUrl.getHeight(), 0.5164609f);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.887218f);
        float f16 = i3 / coerceAtMost2;
        ImageView imageView2 = this.ivImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView2 = null;
        }
        imageView2.getLayoutParams().width = i3;
        ImageView imageView3 = this.ivImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
        } else {
            imageView = imageView3;
        }
        imageView.getLayoutParams().height = (int) f16;
        QLog.d("QZoneQRCodeShareCardHelper", 1, "adjustPicImageViewSize  | url=" + coverUrl.getUrl() + " | coverUrl.width=" + coverUrl.getWidth() + " | coverUrl.height=" + coverUrl.getHeight() + " | width=" + i3 + " | height=" + f16);
    }

    private final void g() {
        View view = null;
        if (!this.isAddQRCode) {
            RelativeLayout relativeLayout = this.qrcodeLL;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrcodeLL");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(8);
            LinearLayout linearLayout = this.llShareTextArea;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llShareTextArea");
                linearLayout = null;
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = 0;
                LinearLayout linearLayout2 = this.llShareTextArea;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llShareTextArea");
                    linearLayout2 = null;
                }
                linearLayout2.setLayoutParams(layoutParams2);
            }
        }
        ImageView imageView = this.ivImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView = null;
        }
        int i3 = imageView.getLayoutParams().width;
        int i16 = f54277v;
        this.cardViewWidth = i3 + i16;
        ImageView imageView2 = this.ivImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView2 = null;
        }
        this.cardViewHeight = imageView2.getLayoutParams().height + i16 + ImmersiveUtils.dpToPx(104.0f);
        View view2 = this.shareCardView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view2 = null;
        }
        if (view2.getLayoutParams() == null) {
            View view3 = this.shareCardView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            } else {
                view = view3;
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(this.cardViewWidth, this.cardViewHeight));
        } else {
            View view4 = this.shareCardView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view4 = null;
            }
            view4.getLayoutParams().width = this.cardViewWidth;
            View view5 = this.shareCardView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            } else {
                view = view5;
            }
            view.getLayoutParams().height = this.cardViewHeight;
        }
        i();
    }

    private final void i() {
        int i3 = this.successType;
        if (i3 > 1) {
            this.successType = i3 - 1;
            return;
        }
        s(this.cardViewWidth, this.cardViewHeight, u6.a.f438462b + "feed_share_qrcode_" + System.currentTimeMillis() + ".jpg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ag this$0, Context context, CommonPicUrl coverUrl, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coverUrl, "$coverUrl");
        this$0.h(context);
        this$0.v(coverUrl);
        this$0.g();
        this$0.l(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ag this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess()) {
            this$0.i();
            return;
        }
        if (loadState.isFinishError()) {
            QLog.e("QZoneQRCodeShareCardHelper", 1, "generateQRCodeView load qrcode frame fail");
            Consumer<QZoneQrcodeResult> consumer = this$0.resultCallback;
            if (consumer != null) {
                consumer.accept(new QZoneQrcodeResult(false, null, null, 6, null));
            }
        }
    }

    private final CommonPicUrl o() {
        CommonPicUrl e16;
        CommonFeed commonFeed = this.feedData;
        if (commonFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed = null;
        }
        CommonCellMedia cellMedia = commonFeed.getCellMedia();
        if ((cellMedia != null ? cellMedia.getMediaItems() : null) == null) {
            return null;
        }
        CommonFeed commonFeed2 = this.feedData;
        if (commonFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed2 = null;
        }
        CommonCellMedia cellMedia2 = commonFeed2.getCellMedia();
        if (bl.b(cellMedia2 != null ? cellMedia2.getMediaItems() : null)) {
            return null;
        }
        CommonFeed commonFeed3 = this.feedData;
        if (commonFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed3 = null;
        }
        CommonCellMedia cellMedia3 = commonFeed3.getCellMedia();
        List<CommonMedia> mediaItems = cellMedia3 != null ? cellMedia3.getMediaItems() : null;
        Intrinsics.checkNotNull(mediaItems);
        CommonMedia commonMedia = mediaItems.get(0);
        if (xd.c.z(commonMedia) && commonMedia.getVideo() != null) {
            this.isVideoCover = true;
            CommonVideo video = commonMedia.getVideo();
            Intrinsics.checkNotNull(video);
            CommonImage cover = video.getCover();
            if (cover == null || (e16 = xd.d.e(cover)) == null) {
                return null;
            }
        } else {
            CommonImage image = commonMedia.getImage();
            if (image == null || (e16 = xd.d.e(image)) == null) {
                return null;
            }
        }
        return e16;
    }

    private final Bitmap p(String url) {
        b.a g16 = jh.b.g().k(url).j(f54279x).g(-16777216);
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        jh.b f16 = g16.i(n(context, R.drawable.f16806v)).f();
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        return jh.a.i(context2, f16);
    }

    private final void q(final CommonPicUrl coverUrl) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl.getUrl());
        ImageView imageView = this.ivImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView = null;
        }
        e16.setTargetView(imageView);
        ImageView imageView3 = this.ivImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView3 = null;
        }
        e16.setRequestWidth(imageView3.getLayoutParams().width);
        ImageView imageView4 = this.ivImageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView4 = null;
        }
        e16.setRequestHeight(imageView4.getLayoutParams().height);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.utils.ad
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ag.r(CommonPicUrl.this, this, loadState, option);
            }
        });
        if (this.isVideoCover) {
            ImageView imageView5 = this.ivVideoPlayView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivVideoPlayView");
            } else {
                imageView2 = imageView5;
            }
            imageView2.setVisibility(0);
        } else {
            ImageView imageView6 = this.ivVideoPlayView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivVideoPlayView");
            } else {
                imageView2 = imageView6;
            }
            imageView2.setVisibility(8);
        }
        QLog.d("QZoneQRCodeShareCardHelper", 1, "loadPicUrlData , url=" + coverUrl.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CommonPicUrl coverUrl, ag this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(coverUrl, "$coverUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess()) {
            QLog.d("QZoneQRCodeShareCardHelper", 1, "loadPicUrlData  isFinishSuccess, url=" + coverUrl.getUrl());
            this$0.i();
            return;
        }
        if (loadState.isFinishError()) {
            QLog.e("QZoneQRCodeShareCardHelper", 1, "loadPicUrlData  isFinishError, url=" + coverUrl.getUrl());
            Consumer<QZoneQrcodeResult> consumer = this$0.resultCallback;
            if (consumer != null) {
                consumer.accept(new QZoneQrcodeResult(false, null, null, 6, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(Ref.ObjectRef bitmap, String filePath, ag this$0) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean saveBitmapAsJpg = RFWSaveUtil.saveBitmapAsJpg((Bitmap) bitmap.element, filePath);
        Consumer<QZoneQrcodeResult> consumer = this$0.resultCallback;
        if (consumer != null) {
            consumer.accept(new QZoneQrcodeResult(saveBitmapAsJpg, filePath, (Bitmap) bitmap.element));
        }
        ((Bitmap) bitmap.element).recycle();
    }

    private final void u(CommonPicUrl coverUrl) {
        f(coverUrl);
        q(coverUrl);
    }

    private final void v(CommonPicUrl coverUrl) {
        u(coverUrl);
        w();
        x();
        y();
    }

    private final void w() {
        CommonFeed commonFeed = this.feedData;
        TextView textView = null;
        if (commonFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed = null;
        }
        String feedContentSummary = CommonFeedDataUtilKt.getFeedContentSummary(commonFeed);
        if (TextUtils.isEmpty(feedContentSummary)) {
            QZoneRichTextView qZoneRichTextView = this.tvShareText;
            if (qZoneRichTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvShareText");
                qZoneRichTextView = null;
            }
            qZoneRichTextView.setRichText(com.qzone.util.l.a(R.string.wb_));
        } else {
            QZoneRichTextView qZoneRichTextView2 = this.tvShareText;
            if (qZoneRichTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvShareText");
                qZoneRichTextView2 = null;
            }
            qZoneRichTextView2.setRichText(feedContentSummary);
        }
        CommonFeed commonFeed2 = this.feedData;
        if (commonFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed2 = null;
        }
        CommonCellCommon cellCommon = commonFeed2.getCellCommon();
        String b16 = cellCommon != null ? com.qzone.reborn.feedx.util.n.b(cellCommon.getTime()) : null;
        TextView textView2 = this.tvShareTime;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShareTime");
        } else {
            textView = textView2;
        }
        textView.setText(b16);
        QLog.d("QZoneQRCodeShareCardHelper", 1, "updateTextAndTime | summaryText=" + feedContentSummary + " | time=" + b16);
    }

    private final void x() {
        String str;
        CommonUser user;
        CommonUser user2;
        CommonUser user3;
        QZoneUserAvatarView qZoneUserAvatarView = this.shareAvatar;
        CommonFeed commonFeed = null;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareAvatar");
            qZoneUserAvatarView = null;
        }
        CommonFeed commonFeed2 = this.feedData;
        if (commonFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed2 = null;
        }
        CommonCellUserInfo cellUserInfo = commonFeed2.getCellUserInfo();
        qZoneUserAvatarView.setUser(ef.d.k((cellUserInfo == null || (user3 = cellUserInfo.getUser()) == null) ? null : user3.getUin()));
        TextView textView = this.tvShareNick;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShareNick");
            textView = null;
        }
        ao aoVar = ao.f54312a;
        CommonFeed commonFeed3 = this.feedData;
        if (commonFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            commonFeed3 = null;
        }
        CommonCellUserInfo cellUserInfo2 = commonFeed3.getCellUserInfo();
        String uin = (cellUserInfo2 == null || (user2 = cellUserInfo2.getUser()) == null) ? null : user2.getUin();
        CommonFeed commonFeed4 = this.feedData;
        if (commonFeed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            commonFeed = commonFeed4;
        }
        CommonCellUserInfo cellUserInfo3 = commonFeed.getCellUserInfo();
        if (cellUserInfo3 == null || (user = cellUserInfo3.getUser()) == null || (str = user.getNick()) == null) {
            str = "";
        }
        textView.setText(aoVar.n(uin, str));
    }

    private final void y() {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e("https://qzonestyle.gtimg.cn/qzone/client/mqq/qzone-icon/qzone-logo2.png");
        ImageView imageView = this.ivWaterMark;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivWaterMark");
            imageView = null;
        }
        e16.setTargetView(imageView);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.utils.ac
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ag.z(ag.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ag this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess()) {
            QLog.d("QZoneQRCodeShareCardHelper", 1, "updateWaterMarkIcon  isFinishSuccess");
            this$0.i();
        } else if (loadState.isFinishError()) {
            QLog.e("QZoneQRCodeShareCardHelper", 1, "updateWaterMarkIcon  isFinishError");
            Consumer<QZoneQrcodeResult> consumer = this$0.resultCallback;
            if (consumer != null) {
                consumer.accept(new QZoneQrcodeResult(false, null, null, 6, null));
            }
        }
    }

    public final boolean j(final Context context, CommonFeed feedData, final String url, Consumer<QZoneQrcodeResult> result, boolean isAddQRCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        this.successType = ((url == null || url.length() == 0) || !isAddQRCode) ? 3 : 4;
        this.context = context;
        this.feedData = feedData;
        this.isAddQRCode = isAddQRCode;
        final CommonPicUrl o16 = o();
        if (o16 == null) {
            return false;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.utils.ab
            @Override // java.lang.Runnable
            public final void run() {
                ag.k(ag.this, context, o16, url);
            }
        });
        this.resultCallback = result;
        return true;
    }

    public final Bitmap n(Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getDrawable(resourceId);
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, android.graphics.Bitmap] */
    public final void s(int width, int height, final String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (width != 0 && height != 0) {
            View view = this.shareCardView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view = null;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
            View view3 = this.shareCardView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view3 = null;
            }
            View view4 = this.shareCardView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view4 = null;
            }
            int measuredWidth = view4.getMeasuredWidth();
            View view5 = this.shareCardView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view5 = null;
            }
            view3.layout(0, 0, measuredWidth, view5.getMeasuredHeight());
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                try {
                    ?? createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    objectRef.element = createBitmap;
                    if (createBitmap == 0) {
                        RFWLog.e("QZoneQRCodeShareCardHelper", 1, "saveBitmapFromView fail");
                        Consumer<QZoneQrcodeResult> consumer = this.resultCallback;
                        if (consumer != null) {
                            consumer.accept(new QZoneQrcodeResult(false, null, null, 6, null));
                            return;
                        }
                        return;
                    }
                    Canvas canvas = new Canvas((Bitmap) objectRef.element);
                    View view6 = this.shareCardView;
                    if (view6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                    } else {
                        view2 = view6;
                    }
                    view2.draw(canvas);
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedpro.utils.af
                        @Override // java.lang.Runnable
                        public final void run() {
                            ag.t(Ref.ObjectRef.this, filePath, this);
                        }
                    });
                    return;
                } catch (Exception e16) {
                    RFWLog.fatal("QZoneQRCodeShareCardHelper", RFWLog.USR, "saveBitmapFromView fail", e16);
                    Consumer<QZoneQrcodeResult> consumer2 = this.resultCallback;
                    if (consumer2 != null) {
                        consumer2.accept(new QZoneQrcodeResult(false, null, null, 6, null));
                        return;
                    }
                    return;
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
                objectRef.element = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                return;
            }
        }
        RFWLog.e("QZoneQRCodeShareCardHelper", 1, "saveBitmapFromView  width:" + width + ", height:" + height);
        Consumer<QZoneQrcodeResult> consumer3 = this.resultCallback;
        if (consumer3 != null) {
            consumer3.accept(new QZoneQrcodeResult(false, null, null, 6, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.RelativeLayout] */
    private final void l(String url) {
        ImageView imageView = null;
        if (!(url == null || url.length() == 0) && this.isAddQRCode) {
            RelativeLayout relativeLayout = this.qrcodeLL;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrcodeLL");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            View view = this.shareCardView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
                view = null;
            }
            View findViewById = view.findViewById(R.id.n9z);
            Intrinsics.checkNotNullExpressionValue(findViewById, "shareCardView.findViewBy\u2026(R.id.qzone_qrcode_frame)");
            ImageView imageView2 = (ImageView) findViewById;
            ImageView imageView3 = this.qrcodeView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrcodeView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageBitmap(p(url));
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setTargetView(imageView2).setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/qzone-icon/Code_background.png"), new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.utils.ae
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    ag.m(ag.this, loadState, option);
                }
            });
            return;
        }
        ?? r56 = this.qrcodeLL;
        if (r56 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("qrcodeLL");
        } else {
            imageView = r56;
        }
        imageView.setVisibility(8);
    }

    private final void h(Context context) {
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        View inflate = View.inflate(context, R.layout.cns, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026cture_share_layout, null)");
        this.shareCardView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f162938nf3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "shareCardView.findViewById(R.id.round_pic_layout)");
        this.roundPicLayout = (RoundCorneredFrameLayout) findViewById;
        View view = this.shareCardView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.la8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "shareCardView.findViewById(R.id.iv_image_view)");
        this.ivImageView = (ImageView) findViewById2;
        View view2 = this.shareCardView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.nk5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "shareCardView.findViewById(R.id.tv_share_text)");
        this.tvShareText = (QZoneRichTextView) findViewById3;
        View view3 = this.shareCardView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.nk6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "shareCardView.findViewById(R.id.tv_share_time)");
        this.tvShareTime = (TextView) findViewById4;
        View view4 = this.shareCardView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.nfp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "shareCardView.findViewById(R.id.share_avatar)");
        this.shareAvatar = (QZoneUserAvatarView) findViewById5;
        View view5 = this.shareCardView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view5 = null;
        }
        View findViewById6 = view5.findViewById(R.id.f162964nk4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "shareCardView.findViewById(R.id.tv_share_nick)");
        this.tvShareNick = (TextView) findViewById6;
        View view6 = this.shareCardView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view6 = null;
        }
        View findViewById7 = view6.findViewById(R.id.lvy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "shareCardView.findViewById(R.id.iv_water_mark)");
        this.ivWaterMark = (ImageView) findViewById7;
        View view7 = this.shareCardView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view7 = null;
        }
        View findViewById8 = view7.findViewById(R.id.n9y);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "shareCardView.findViewById(R.id.qzone_qrcode_code)");
        this.qrcodeView = (ImageView) findViewById8;
        View view8 = this.shareCardView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view8 = null;
        }
        View findViewById9 = view8.findViewById(R.id.mgg);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "shareCardView.findViewById(R.id.ll_share_txt_area)");
        this.llShareTextArea = (LinearLayout) findViewById9;
        View view9 = this.shareCardView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view9 = null;
        }
        View findViewById10 = view9.findViewById(R.id.n_0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "shareCardView.findViewById(R.id.qzone_qrcode_rl)");
        this.qrcodeLL = (RelativeLayout) findViewById10;
        View view10 = this.shareCardView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            view10 = null;
        }
        View findViewById11 = view10.findViewById(R.id.lvw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "shareCardView.findViewBy\u2026(R.id.iv_video_play_view)");
        this.ivVideoPlayView = (ImageView) findViewById11;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.roundPicLayout;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundPicLayout");
        } else {
            roundCorneredFrameLayout = roundCorneredFrameLayout2;
        }
        roundCorneredFrameLayout.setRadius(ImmersiveUtils.dpToPx(4.0f));
    }
}
