package lg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.util.Consumer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0002\u001d!B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010'R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010(\u00a8\u0006-"}, d2 = {"Llg/k;", "", "Landroid/content/Context;", "context", "", "e", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "coverUrl", "o", "p", DomainData.DOMAIN_NAME, "i", "j", "d", tl.h.F, "", "width", "height", "", "filePath", "l", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Landroidx/core/util/Consumer;", "Llg/k$b;", "result", "", "f", "Landroid/view/View;", "a", "Landroid/view/View;", "shareCardView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "ivImageView", "c", "ivLogoView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/content/Context;", "Landroidx/core/util/Consumer;", "resultCallback", "<init>", "()V", "g", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k {

    /* renamed from: h, reason: collision with root package name */
    private static final int f414471h = ImmersiveUtils.dpToPx(16.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f414472i = ImmersiveUtils.dpToPx(305.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View shareCardView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView ivImageView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView ivLogoView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData feedData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Consumer<QZoneQrcodeResult> resultCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Llg/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(ZLjava/lang/String;Landroid/graphics/Bitmap;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lg.k$b, reason: from toString */
    /* loaded from: classes38.dex */
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

    private final void d(PictureUrl coverUrl) {
        int coerceAtMost;
        float coerceAtLeast;
        float coerceAtMost2;
        int i3;
        pl.a aVar = pl.a.f426446a;
        Context context = this.context;
        ImageView imageView = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(aVar.o(context), f414472i);
        int i16 = coerceAtMost - f414471h;
        int i17 = coverUrl.width;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((i17 == 0 || (i3 = coverUrl.height) == 0) ? 1.0f : i17 / i3, 0.5164609f);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.887218f);
        float f16 = i16 / coerceAtMost2;
        ImageView imageView2 = this.ivImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView2 = null;
        }
        imageView2.getLayoutParams().width = i16;
        ImageView imageView3 = this.ivImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
        } else {
            imageView = imageView3;
        }
        imageView.getLayoutParams().height = (int) f16;
        QLog.d("QZoneLogoWatermarkShareCardHelper", 1, "adjustPicImageViewSize  | url=" + coverUrl.url + " | coverUrl.width=" + coverUrl.width + " | coverUrl.height=" + coverUrl.height + " | width=" + i16 + " | height=" + f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(k this$0, Context context, PictureUrl coverUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coverUrl, "$coverUrl");
        this$0.e(context);
        this$0.o(coverUrl);
    }

    private final void h() {
        String str = u6.a.f438462b + "feed_share_qrcode_" + System.currentTimeMillis() + ".jpg";
        ImageView imageView = this.ivImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
            imageView = null;
        }
        int i3 = imageView.getLayoutParams().width;
        ImageView imageView3 = this.ivImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageView");
        } else {
            imageView2 = imageView3;
        }
        l(i3, imageView2.getLayoutParams().height, str);
    }

    private final PictureUrl i() {
        PictureUrl t16;
        VideoInfo videoInfo;
        BusinessFeedData businessFeedData = this.feedData;
        BusinessFeedData businessFeedData2 = null;
        if (businessFeedData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            businessFeedData = null;
        }
        if (businessFeedData.getPictureInfo() != null) {
            BusinessFeedData businessFeedData3 = this.feedData;
            if (businessFeedData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedData");
                businessFeedData3 = null;
            }
            if (!bl.b(businessFeedData3.getPictureInfo().pics)) {
                BusinessFeedData businessFeedData4 = this.feedData;
                if (businessFeedData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedData");
                } else {
                    businessFeedData2 = businessFeedData4;
                }
                PictureItem pictureItem = businessFeedData2.getPictureInfo().pics.get(0);
                Intrinsics.checkNotNullExpressionValue(pictureItem, "feedData.pictureInfo.pics[0]");
                PictureItem pictureItem2 = pictureItem;
                if (pictureItem2.videoflag == 1 && (videoInfo = pictureItem2.videodata) != null) {
                    t16 = tk.h.w(videoInfo);
                } else {
                    t16 = tk.h.t(pictureItem2);
                }
                return t16;
            }
        }
        BusinessFeedData businessFeedData5 = this.feedData;
        if (businessFeedData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            businessFeedData5 = null;
        }
        if (!businessFeedData5.isVideo()) {
            return null;
        }
        BusinessFeedData businessFeedData6 = this.feedData;
        if (businessFeedData6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            businessFeedData2 = businessFeedData6;
        }
        return tk.h.w(businessFeedData2.getVideoInfo());
    }

    private final void j(final PictureUrl coverUrl) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl.url);
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
        } else {
            imageView2 = imageView4;
        }
        e16.setRequestHeight(imageView2.getLayoutParams().height);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: lg.i
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                k.k(PictureUrl.this, this, loadState, option);
            }
        });
        QLog.d("QZoneLogoWatermarkShareCardHelper", 1, "loadPicUrlData , url=" + coverUrl.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PictureUrl coverUrl, k this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(coverUrl, "$coverUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess()) {
            QLog.d("QZoneLogoWatermarkShareCardHelper", 1, "loadPicUrlData  isFinishSuccess, url=" + coverUrl.url);
            this$0.h();
            return;
        }
        if (loadState.isFinishError()) {
            QLog.e("QZoneLogoWatermarkShareCardHelper", 1, "loadPicUrlData  isFinishError, url=" + coverUrl.url);
            Consumer<QZoneQrcodeResult> consumer = this$0.resultCallback;
            if (consumer != null) {
                consumer.accept(new QZoneQrcodeResult(false, null, null, 6, null));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, android.graphics.Bitmap] */
    private final void l(int width, int height, final String filePath) {
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
                        RFWLog.e("QZoneLogoWatermarkShareCardHelper", 1, "saveBitmapFromView fail");
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
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: lg.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.m(Ref.ObjectRef.this, filePath, this);
                        }
                    });
                    return;
                } catch (Exception e16) {
                    RFWLog.fatal("QZoneLogoWatermarkShareCardHelper", RFWLog.USR, "saveBitmapFromView fail", e16);
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
        RFWLog.e("QZoneLogoWatermarkShareCardHelper", 1, "saveBitmapFromView  width:" + width + ", height:" + height);
        Consumer<QZoneQrcodeResult> consumer3 = this.resultCallback;
        if (consumer3 != null) {
            consumer3.accept(new QZoneQrcodeResult(false, null, null, 6, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Ref.ObjectRef bitmap, String filePath, k this$0) {
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

    private final void n(PictureUrl coverUrl) {
        d(coverUrl);
        j(coverUrl);
    }

    private final void o(PictureUrl coverUrl) {
        n(coverUrl);
        p();
    }

    private final void p() {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView = this.ivLogoView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLogoView");
            imageView = null;
        }
        ImageView imageView3 = this.ivLogoView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLogoView");
            imageView3 = null;
        }
        Drawable drawable = imageView3.getContext().getResources().getDrawable(R.drawable.f16135j);
        ImageView imageView4 = this.ivLogoView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLogoView");
        } else {
            imageView2 = imageView4;
        }
        a16.g(imageView, drawable, imageView2.getContext().getResources().getColor(R.color.f158017al3));
    }

    public final boolean f(final Context context, BusinessFeedData feedData, Consumer<QZoneQrcodeResult> result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(result, "result");
        this.context = context;
        this.feedData = feedData;
        final PictureUrl i3 = i();
        if (i3 == null) {
            return false;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: lg.h
            @Override // java.lang.Runnable
            public final void run() {
                k.g(k.this, context, i3);
            }
        });
        this.resultCallback = result;
        return true;
    }

    private final void e(Context context) {
        View view = null;
        View inflate = View.inflate(context, R.layout.cln, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026cture_share_layout, null)");
        this.shareCardView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.la8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "shareCardView.findViewById(R.id.iv_image_view)");
        this.ivImageView = (ImageView) findViewById;
        View view2 = this.shareCardView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCardView");
        } else {
            view = view2;
        }
        View findViewById2 = view.findViewById(R.id.lci);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "shareCardView.findViewById(R.id.iv_logo_view)");
        this.ivLogoView = (ImageView) findViewById2;
    }
}
