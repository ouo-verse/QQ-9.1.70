package com.tencent.mobileqq.relation.qzonefeeds;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010%\u001a\u0004\u0018\u00010$2\b\u0010 \u001a\u0004\u0018\u00010\u001a2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0007J&\u0010)\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040&j\b\u0012\u0004\u0012\u00020\u0004`'R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010+R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010-R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010-R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/relation/qzonefeeds/c;", "", "Landroid/view/ViewGroup;", "feedContainer", "LNS_MOBILE_NEWEST_FEEDS/feed_info;", QCircleScheme.AttrDetail.FEED_INFO, "", "photoSize", "Ljava/util/concurrent/atomic/AtomicInteger;", "curWidth", NodeProps.MAX_WIDTH, "", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "a", "Landroid/widget/ImageView;", "picView", "videoIcon", "Landroid/widget/TextView;", "contentTextView", "", "d", "c", "f", "", "url", BaseProfileQZoneComponent.KEY_IS_VIDEO, "e", "feedView", h.F, "videoPath", "maxLength", "", "timeUs", "Landroid/graphics/Bitmap;", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "feedList", "g", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "defaultPic", "I", "ROUND_RADIUS", "LEFT_MARGIN", "FEED_MARGIN", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f280652a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Drawable defaultPic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int ROUND_RADIUS;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int LEFT_MARGIN;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int FEED_MARGIN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f280652a = new c();
        ROUND_RADIUS = ViewUtils.dpToPx(2.0f);
        LEFT_MARGIN = ViewUtils.dpToPx(16.0f);
        FEED_MARGIN = ViewUtils.dpToPx(2.0f);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View a(Activity activity, feed_info feedInfo, int photoSize) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.gvj, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(\n\u2026eeds_item, null\n        )");
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) inflate.findViewById(R.id.ifh);
        roundRelativeLayout.f316195e = ROUND_RADIUS;
        roundRelativeLayout.setVisibility(0);
        ImageView picView = (ImageView) inflate.findViewById(R.id.f165927y33);
        View videoIcon = inflate.findViewById(R.id.f165928y34);
        TextView contentTextView = (TextView) inflate.findViewById(R.id.f107906bo);
        contentTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        Intrinsics.checkNotNullExpressionValue(picView, "picView");
        Intrinsics.checkNotNullExpressionValue(videoIcon, "videoIcon");
        Intrinsics.checkNotNullExpressionValue(contentTextView, "contentTextView");
        d(activity, feedInfo, picView, videoIcon, contentTextView, photoSize);
        return inflate;
    }

    private final void c(ImageView picView, View videoIcon, TextView contentTextView) {
        picView.setVisibility(8);
        videoIcon.setVisibility(8);
        contentTextView.setVisibility(8);
    }

    private final void d(Activity activity, feed_info feedInfo, ImageView picView, View videoIcon, TextView contentTextView, int photoSize) {
        int i3 = feedInfo.sourceType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (!TextUtils.isEmpty(feedInfo.strImgUrl)) {
                        c(picView, videoIcon, contentTextView);
                        String str = feedInfo.strImgUrl;
                        Intrinsics.checkNotNullExpressionValue(str, "feedInfo.strImgUrl");
                        e(activity, photoSize, str, picView, true);
                        videoIcon.setVisibility(0);
                        return;
                    }
                    c(picView, videoIcon, contentTextView);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(feedInfo.strImgUrl)) {
                c(picView, videoIcon, contentTextView);
                String str2 = feedInfo.strImgUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "feedInfo.strImgUrl");
                e(activity, photoSize, str2, picView, false);
                return;
            }
            c(picView, videoIcon, contentTextView);
            return;
        }
        if (!TextUtils.isEmpty(feedInfo.strcontent)) {
            picView.setVisibility(8);
            videoIcon.setVisibility(8);
            contentTextView.setVisibility(0);
            f(contentTextView, feedInfo, photoSize);
            return;
        }
        c(picView, videoIcon, contentTextView);
    }

    private final void e(Activity activity, int photoSize, String url, ImageView picView, boolean isVideo) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (defaultPic == null) {
            defaultPic = new ColorDrawable(activity.getResources().getColor(R.color.f157194kw));
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = defaultPic;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mRequestHeight = photoSize;
            obtain.mRequestWidth = photoSize;
            picView.setVisibility(0);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                if (!startsWith$default2) {
                    if (isVideo) {
                        Bitmap b16 = b(url, photoSize, 0L);
                        if (b16 != null) {
                            picView.setImageBitmap(b16);
                            return;
                        } else {
                            picView.setImageDrawable(defaultPic);
                            return;
                        }
                    }
                    picView.setImageDrawable(URLDrawable.getFileDrawable(url, obtain));
                    return;
                }
            }
            picView.setImageDrawable(URLDrawable.getDrawable(url, obtain));
        } catch (Exception e16) {
            QLog.d("AddFriendShowQZoneFeedsUIHelper", 1, "wrapFeedView exception: ", e16);
        }
    }

    private final void f(TextView contentTextView, feed_info feedInfo, int photoSize) {
        contentTextView.setText(feedInfo.strcontent);
        ViewGroup.LayoutParams layoutParams = contentTextView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "contentTextView.layoutParams");
        layoutParams.width = photoSize;
        layoutParams.height = photoSize;
        if (contentTextView.getLineHeight() > 0) {
            contentTextView.setMaxLines(3);
        }
    }

    private final void h(View feedView, int photoSize, AtomicInteger curWidth) {
        ViewGroup.LayoutParams layoutParams = feedView.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = FEED_MARGIN;
            feedView.setLayoutParams(layoutParams);
        }
        ImageView imageView = (ImageView) feedView.findViewById(R.id.f165927y33);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.width = photoSize;
        layoutParams2.height = photoSize;
        imageView.setLayoutParams(layoutParams2);
        if (curWidth.get() > 0) {
            curWidth.set(curWidth.get() + FEED_MARGIN);
        }
        curWidth.set(curWidth.get() + photoSize);
    }

    private final boolean i(ViewGroup feedContainer, feed_info feedInfo, int photoSize, AtomicInteger curWidth, int maxWidth) {
        Context context = feedContainer.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View a16 = a((Activity) context, feedInfo, photoSize);
        feedContainer.addView(a16);
        h(a16, photoSize, curWidth);
        if (curWidth.get() + photoSize + FEED_MARGIN > maxWidth) {
            return true;
        }
        return false;
    }

    @TargetApi(10)
    @Nullable
    public final Bitmap b(@Nullable String videoPath, int maxLength, long timeUs) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, videoPath, Integer.valueOf(maxLength), Long.valueOf(timeUs));
        }
        if (maxLength <= 0) {
            maxLength = 640;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap2 = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(videoPath);
                bitmap = mediaMetadataRetriever.getFrameAtTime(timeUs);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused) {
                }
                if (bitmap == null) {
                    return null;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int max = Math.max(width, height);
                if (max > maxLength) {
                    float f16 = maxLength / max;
                    try {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(f16 * height), true);
                    } catch (OutOfMemoryError e16) {
                        QLog.d("AddFriendShowQZoneFeedsUIHelper", 1, "getVideoThumbnail OOM, ", e16);
                    }
                    return bitmap2;
                }
                return bitmap;
            } catch (IllegalArgumentException | RuntimeException unused2) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                    bitmap = null;
                }
            } catch (OutOfMemoryError e17) {
                QLog.d("AddFriendShowQZoneFeedsUIHelper", 1, "getVideoThumbnail OOM, ", e17);
                mediaMetadataRetriever.release();
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused4) {
            }
            throw th5;
        }
    }

    public final void g(@NotNull ViewGroup feedContainer, @NotNull ArrayList<feed_info> feedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) feedContainer, (Object) feedList);
            return;
        }
        Intrinsics.checkNotNullParameter(feedContainer, "feedContainer");
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        int screenWidth = ViewUtils.getScreenWidth();
        int i3 = LEFT_MARGIN;
        int i16 = (screenWidth - i3) - i3;
        int i17 = ((int) ((i16 - (FEED_MARGIN * 3)) * 1.0f)) / 4;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<feed_info> it = feedList.iterator();
        while (it.hasNext()) {
            feed_info feed_info = it.next();
            Intrinsics.checkNotNullExpressionValue(feed_info, "feed_info");
            if (i(feedContainer, feed_info, i17, atomicInteger, i16)) {
                return;
            }
        }
    }
}
