package com.qzone.reborn.util;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
                return;
            }
            option.getAnimatable().start();
        }
    }

    public static BitmapReference a(Drawable drawable) {
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return ((SpecifiedBitmapDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapRefDrawable) {
            return ((BitmapRefDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapDrawable) {
            return BitmapReference.getBitmapReference(((BitmapDrawable) drawable).getBitmap());
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof SpecifiedDrawable) {
            return BitmapUtils.drawableToBitmapByCanvas(drawable);
        }
        return null;
    }

    public static String c(boolean z16) {
        if (z16) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "activePageForbiddenViewFeedEmptyShuoshuo", "\u5728\u8fd9\u91cc\uff0c\u5f00\u59cb\u8fde\u8f7d\u4f60\u7684\u751f\u6d3b");
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "activePageForbiddenViewFeedEmptyAlbum", "\u7528\u76f8\u518c\u8bb0\u5f55\u751f\u6d3b\uff0c\u5feb\u6765\u4e0a\u4f20\u5427");
    }

    public static String d() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UGC_EMPTY_PAGE, QzoneConfig.SECONDARYUGC_SHUOSHUO_EMPTY_VIEW, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png");
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UGC_EMPTY_PAGE, QzoneConfig.SECONDARYUGC_SHUOSHUO_EMPTY_VIEW, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
    }

    public static String e(boolean z16) {
        return !NetworkState.isNetSupport() ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoNetworkContent", "\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e") : z16 ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ShuoShuoListGuestContentTitle", "\u771f\u6b63\u7684\u53cb\u60c5\u662f\u7406\u89e3\u5f7c\u6b64\u7684\u6b32\u8a00\u53c8\u6b62") : "";
    }

    public static String f(boolean z16) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoNetworkTitle", "\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51");
        if (z16) {
            return NetworkState.isNetSupport() ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ShuoShuoListGuestTitle", "\u597d\u53cb\u6ca1\u6709\u53d1\u8868\u8fc7\u8bf4\u8bf4\u54e6") : config;
        }
        return NetworkState.isNetSupport() ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ShuoShuoListTitle", "\u5199\u4e0b\u6b64\u523b\u5fc3\u60c5\uff0c\u7ed9\u6545\u4e8b\u5f00\u4e00\u4e2a\u5934") : config;
    }

    public static String g(List<FeedCloudCommon$Entry> list, String str) {
        return h(list, str, "");
    }

    public static String b(boolean z16, boolean z17) {
        if (z17) {
            return "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        }
        if (z16) {
            if (QQTheme.isNowSimpleUI()) {
                return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FORBIDDEN_PAGE_FEED, QzoneConfig.SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_CONCISE_IMAGE_URL, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
            }
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FORBIDDEN_PAGE_FEED, QzoneConfig.SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_MOOD_IMAGE_URL, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
        }
        if (QQTheme.isNowSimpleUI()) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FORBIDDEN_PAGE_FEED, QzoneConfig.SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_CONCISE_IMAGE_URL, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FORBIDDEN_PAGE_FEED, QzoneConfig.SECONDARY_FORBIDDEN_VIEW_FEED_EMPTY_ALBUM_IMAGE_URL, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");
    }

    public static String h(List<FeedCloudCommon$Entry> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (feedCloudCommon$Entry.key.get().equals(str)) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return str2;
    }

    public static void i(Context context, ImageView imageView, String str, int i3, int i16) {
        j(imageView, str, i3, i16, new ColorDrawable(context.getColor(R.color.a_n)));
    }

    public static void j(ImageView imageView, String str, int i3, int i16, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(imageView).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawable(drawable).setFailedDrawableId(R.drawable.fux), new a());
    }
}
