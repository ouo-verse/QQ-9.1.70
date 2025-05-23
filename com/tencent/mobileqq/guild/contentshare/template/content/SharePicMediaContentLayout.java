package com.tencent.mobileqq.guild.contentshare.template.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\u0019B\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!B\u001d\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b \u0010$J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J&\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010\u001d\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/content/SharePicMediaContentLayout;", "Landroid/widget/LinearLayout;", "", "lineCount", "rowCount", "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "mediaList", "", "e", "itemWidth", "itemHeight", "Landroid/view/View;", "d", "info", "c", "f", "", "url", "Landroid/widget/ImageView;", "b", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "g", "width", "a", "targetImageView", "height", h.F, "i", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SharePicMediaContentLayout extends LinearLayout {
    public SharePicMediaContentLayout(@Nullable Context context) {
        super(context);
    }

    private final int a(int width, List<IFeedDetailDataParser.MediaInfo> mediaList) {
        Object first;
        boolean z16;
        float f16;
        boolean z17 = true;
        if (mediaList.size() <= 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mediaList);
            IFeedDetailDataParser.MediaInfo mediaInfo = (IFeedDetailDataParser.MediaInfo) first;
            if (mediaInfo.getWidth() == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (mediaInfo.getHeight() != 0.0f) {
                    z17 = false;
                }
                if (!z17) {
                    f16 = (width * mediaInfo.getHeight()) / mediaInfo.getWidth();
                    return (int) f16;
                }
            }
            f16 = width * 0.625f;
            return (int) f16;
        }
        return width;
    }

    private final ImageView b(String url, int itemWidth, int itemHeight) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        h(url, imageView, itemWidth, itemHeight);
        return imageView;
    }

    private final View c(IFeedDetailDataParser.MediaInfo info, int itemWidth, int itemHeight) {
        if (info.getType() == 0) {
            return b(info.getThumbUrl(), itemWidth, itemHeight);
        }
        return f(info, itemWidth, itemHeight);
    }

    private final View d(List<IFeedDetailDataParser.MediaInfo> mediaList, int itemWidth, int itemHeight) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (getChildCount() > 0) {
            layoutParams.topMargin = com.tencent.guild.aio.util.c.b(3);
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        QLog.i("SharePicMediaContentLayout", 1, "createMediaRowView itemWidth=" + itemWidth + " itemHeight=" + itemHeight);
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            View c16 = c((IFeedDetailDataParser.MediaInfo) it.next(), itemWidth, itemHeight);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(itemWidth, itemHeight);
            if (linearLayout.getChildCount() > 0) {
                layoutParams2.leftMargin = com.tencent.guild.aio.util.c.b(3);
            }
            c16.setLayoutParams(layoutParams2);
            linearLayout.addView(c16);
        }
        return linearLayout;
    }

    private final void e(int lineCount, int rowCount, List<IFeedDetailDataParser.MediaInfo> mediaList) {
        QLog.i("SharePicMediaContentLayout", 1, "createMediaViewAndBindData lineCount=" + lineCount + " rowCount=" + rowCount);
        int measuredWidth = (getMeasuredWidth() - ((rowCount + (-1)) * com.tencent.guild.aio.util.c.b(3))) / rowCount;
        int a16 = a(measuredWidth, mediaList);
        for (int i3 = 0; i3 < lineCount; i3++) {
            int i16 = rowCount * i3;
            int i17 = i16 + rowCount;
            if (i17 > mediaList.size()) {
                i17 = mediaList.size();
            }
            addView(d(mediaList.subList(i16, i17), measuredWidth, a16));
        }
    }

    private final View f(IFeedDetailDataParser.MediaInfo info, int itemWidth, int itemHeight) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(b(info.getThumbUrl(), itemWidth, itemHeight), new ViewGroup.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.guild.aio.util.c.b(40), com.tencent.guild.aio.util.c.b(40));
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.guild_aio_video_play_btn);
        relativeLayout.addView(imageView);
        ImageView imageView2 = new ImageView(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.tencent.guild.aio.util.c.b(58));
        layoutParams2.addRule(12);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setImageResource(R.drawable.guild_video_thumb_img_mask);
        relativeLayout.addView(imageView2);
        ImageView imageView3 = new ImageView(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.tencent.guild.aio.util.c.b(20), com.tencent.guild.aio.util.c.b(20));
        layoutParams3.addRule(9);
        layoutParams3.addRule(12);
        layoutParams3.setMargins(com.tencent.guild.aio.util.c.b(10), 0, 0, com.tencent.guild.aio.util.c.b(10));
        imageView3.setLayoutParams(layoutParams3);
        imageView3.setImageResource(R.drawable.guild_aio_video_icon);
        relativeLayout.addView(imageView3);
        if (info.getDurationMills() > 0) {
            TextView textView = new TextView(relativeLayout.getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(11);
            layoutParams4.addRule(12);
            layoutParams4.setMargins(0, 0, com.tencent.guild.aio.util.c.b(10), com.tencent.guild.aio.util.c.b(13));
            textView.setLayoutParams(layoutParams4);
            textView.setTextSize(11.0f);
            textView.setTextColor(-1);
            QLog.i("SharePicMediaContentLayout", 4, "durationMills=" + info.getDurationMills());
            textView.setText(g(info.getDurationMills() / 1000));
            relativeLayout.addView(textView);
        }
        return relativeLayout;
    }

    private final String g(long second) {
        String format;
        try {
            long j3 = second % 60;
            long j16 = (second / 60) % 60;
            long j17 = (second / 3600) % 24;
            if (j17 > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17), Long.valueOf(j16), Long.valueOf(j3)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16), Long.valueOf(j3)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            return format;
        } catch (Exception e16) {
            QLog.e("TimeStampUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    private final void h(String url, ImageView targetImageView, int width, int height) {
        QLog.i("SharePicMediaContentLayout", 1, "loadImage url=" + url + " width=" + width + " height=" + height);
        com.tencent.mobileqq.guild.picload.e.a().e(new Option().setRegionScaleType(ImageView.ScaleType.CENTER_CROP).setDecodeMode(1).setTargetView(targetImageView).setRequestWidth(width).setRequestHeight(height).setLoadingDrawableId(R.drawable.f162601b70).setUrl(url).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
    }

    public final void i(@NotNull List<IFeedDetailDataParser.MediaInfo> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        int i3 = 1;
        QLog.i("SharePicMediaContentLayout", 1, "update size=" + mediaList.size());
        int size = mediaList.size() / 3;
        int size2 = mediaList.size() % 3;
        if (size2 != 0 && mediaList.size() <= 4) {
            if (mediaList.size() % 2 == 0) {
                e(mediaList.size() / 2, 2, mediaList);
                return;
            } else {
                if (mediaList.size() == 1) {
                    e(1, 1, mediaList);
                    return;
                }
                return;
            }
        }
        if (size != 0) {
            if (size2 == 0) {
                i3 = size;
            } else {
                i3 = size + 1;
            }
        }
        e(i3, 3, mediaList);
    }

    public SharePicMediaContentLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
