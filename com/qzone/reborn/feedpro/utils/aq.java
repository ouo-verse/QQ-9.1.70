package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.tencent.component.media.image.ImageKey;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ6\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J4\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J2\u0010\u0018\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J4\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/aq;", "", "Landroid/content/Context;", "context", "", "videoWidth", "videoHeight", "feedAreaWidth", "Landroid/util/Pair;", "d", "", "feedKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "pic", "picAreaWidth", "Lkotlin/Pair;", "c", "feedPicAreaWidth", "picSize", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "", "e", "params", "b", "a", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aq {

    /* renamed from: a, reason: collision with root package name */
    public static final aq f54314a = new aq();

    aq() {
    }

    public final void a(Context context, String feedKey, ViewGroup.LayoutParams layoutParams, CommonPicUrl pic, int picAreaWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (layoutParams == null || pic == null) {
            return;
        }
        if (feedKey == null) {
            feedKey = "";
        }
        Pair<Integer, Integer> c16 = c(context, feedKey, pic, picAreaWidth);
        layoutParams.width = c16.getFirst().intValue();
        layoutParams.height = c16.getSecond().intValue();
    }

    public final String f(String feedKey, CommonPicUrl pic) {
        String url;
        StringBuilder sb5 = new StringBuilder();
        if (!(feedKey == null || feedKey.length() == 0)) {
            sb5.append(feedKey);
        }
        if (pic != null && (url = pic.getUrl()) != null) {
            sb5.append("_" + ImageKey.getUrlKey(url, true));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private final Pair<Integer, Integer> c(Context context, String feedKey, CommonPicUrl pic, int picAreaWidth) {
        if (picAreaWidth <= 0) {
            picAreaWidth = pl.a.f426446a.k(context);
        }
        float f16 = picAreaWidth;
        int i3 = (int) (0.42f * f16);
        int i16 = (int) (0.33f * f16);
        int width = pic.getWidth();
        int height = pic.getHeight();
        if (pic.getWidth() <= 0 || pic.getHeight() <= 0) {
            android.util.Pair<Integer, Integer> c16 = com.qzone.reborn.feedx.widget.picmixvideo.a.c(context, f(feedKey, pic));
            Integer num = c16 != null ? (Integer) c16.first : null;
            if ((num == null ? 0 : num.intValue()) > 0) {
                Integer num2 = c16 != null ? (Integer) c16.second : null;
                if ((num2 == null ? 0 : num2.intValue()) > 0) {
                    Object obj = c16.first;
                    Intrinsics.checkNotNullExpressionValue(obj, "cachePair.first");
                    width = ((Number) obj).intValue();
                    Object obj2 = c16.second;
                    Intrinsics.checkNotNullExpressionValue(obj2, "cachePair.second");
                    height = ((Number) obj2).intValue();
                }
            }
            return TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i3));
        }
        float f17 = width / height;
        if (f17 >= 3.0f) {
            return TuplesKt.to(Integer.valueOf(picAreaWidth), Integer.valueOf(i16));
        }
        if (f17 > 1.0f) {
            return TuplesKt.to(Integer.valueOf(picAreaWidth), Integer.valueOf((int) (f16 / f17)));
        }
        if (f17 == 1.0f) {
            return TuplesKt.to(Integer.valueOf(picAreaWidth), Integer.valueOf(picAreaWidth));
        }
        if (f17 > 0.33333334f) {
            return TuplesKt.to(Integer.valueOf((int) (f16 * f17)), Integer.valueOf(picAreaWidth));
        }
        return TuplesKt.to(Integer.valueOf(i16), Integer.valueOf(picAreaWidth));
    }

    private final android.util.Pair<Integer, Integer> d(Context context, int videoWidth, int videoHeight, int feedAreaWidth) {
        if (feedAreaWidth <= 0) {
            feedAreaWidth = pl.a.f426446a.k(context);
        }
        if (videoWidth <= 0 || videoHeight <= 0) {
            return new android.util.Pair<>(Integer.valueOf(feedAreaWidth), Integer.valueOf((feedAreaWidth * 9) / 16));
        }
        if (videoHeight / videoWidth > 1.1d) {
            int i3 = (int) (feedAreaWidth * 0.68f);
            return new android.util.Pair<>(Integer.valueOf(i3), Integer.valueOf((i3 * 4) / 3));
        }
        return new android.util.Pair<>(Integer.valueOf(feedAreaWidth), Integer.valueOf((feedAreaWidth * 9) / 16));
    }

    public final void b(Context context, ViewGroup.LayoutParams params, int videoWidth, int videoHeight, int feedAreaWidth) {
        if (params == null) {
            return;
        }
        android.util.Pair<Integer, Integer> d16 = d(context, videoWidth, videoHeight, feedAreaWidth);
        Object obj = d16.first;
        Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
        params.width = ((Number) obj).intValue();
        Object obj2 = d16.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "pair.second");
        params.height = ((Number) obj2).intValue();
    }

    public final void e(int feedPicAreaWidth, int picSize, ViewGroup.LayoutParams layoutParams) {
        int a16;
        if (picSize != 2 && picSize != 4) {
            a16 = (feedPicAreaWidth - (QzoneFeedProPicMixVideoView.INSTANCE.a() * 2)) / 3;
        } else {
            a16 = (feedPicAreaWidth - QzoneFeedProPicMixVideoView.INSTANCE.a()) / 2;
        }
        if (layoutParams != null) {
            layoutParams.width = a16;
        }
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = a16;
    }
}
