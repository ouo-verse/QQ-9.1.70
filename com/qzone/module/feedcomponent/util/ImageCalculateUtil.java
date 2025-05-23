package com.qzone.module.feedcomponent.util;

import android.content.Context;
import android.util.Pair;
import android.view.WindowManager;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ImageCalculateUtil {
    public static final String TAG = "ImageCalculateUtil";
    static int screenHeight;
    static int screenWidth;

    public static Pair<Integer, Integer> calculateImageWidthHeight(int i3, PictureUrl pictureUrl, boolean z16, int i16, int i17) {
        if (pictureUrl == null) {
            return new Pair<>(0, 0);
        }
        return calculateImageWidthHeight(i3, pictureUrl.width, pictureUrl.height, z16, i16, i17);
    }

    public static int getScreenHeight(Context context) {
        int i3 = screenHeight;
        if (i3 > 0) {
            return i3;
        }
        int height = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        screenHeight = height;
        return height;
    }

    public static int getScreenWidth(Context context) {
        int i3 = screenWidth;
        if (i3 > 0) {
            return i3;
        }
        int width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        screenWidth = width;
        return width;
    }

    public static boolean isShowBigPicturlMode(Context context) {
        return i.H().W() == 1;
    }

    public static Pair<Integer, Integer> calculateImageWidthHeight(int i3, int i16, int i17, boolean z16, int i18, int i19) {
        int i26;
        int i27 = (i3 - i18) - i19;
        if (i16 == 0 || i17 == 0) {
            i16 = 0;
            i26 = 0;
        } else if (i16 <= i27) {
            double d16 = i16;
            i26 = (int) (i17 * (d16 / (1.0d * d16)));
        } else {
            if (z16) {
                i27 = Math.min(i16, FeedGlobalEnv.g().getScreenWidth());
            }
            int i28 = (int) (i17 * (i27 / (i16 * 1.0d)));
            i16 = i27;
            i26 = i28;
        }
        return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i26));
    }

    public static ArrayList<Object> getCellDetailContent(BusinessFeedData businessFeedData) {
        ArrayList<Object> detailContent;
        if (businessFeedData == null || (detailContent = businessFeedData.getDetailContent()) == null || detailContent.size() <= 0) {
            return null;
        }
        return detailContent;
    }

    static PictureUrl getPictureUrlByConfig(PictureItem pictureItem, String str) {
        if (pictureItem == null) {
            return null;
        }
        return pictureItem.currentUrl;
    }

    public static PictureUrl getPictureUrlByModeAndConfig(Context context, PictureItem pictureItem) {
        if (pictureItem == null) {
            return null;
        }
        return pictureItem.currentUrl;
    }
}
