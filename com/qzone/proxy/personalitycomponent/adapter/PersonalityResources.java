package com.qzone.proxy.personalitycomponent.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.qzone.util.image.c;
import com.tencent.mobileqq.R;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.ZipResDownloadManager;
import cooperation.vip.vipcomponent.util.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class PersonalityResources {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, Integer> f50958a;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f50958a = hashMap;
        hashMap.put(Integer.valueOf(DrawableID.qzone_cover_widget_flower_load_fail), Integer.valueOf(R.drawable.fzd));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_flower_love), Integer.valueOf(R.drawable.gjd));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_flower_nutrition), Integer.valueOf(R.drawable.gje));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_flower_sunshine), Integer.valueOf(R.drawable.gjf));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_flower_water), Integer.valueOf(R.drawable.gjg));
        f50958a.put(Integer.valueOf(DrawableID.qzone_cover_constellation_star), Integer.valueOf(R.drawable.fz9));
        f50958a.put(Integer.valueOf(DrawableID.qzone_cover_constellation_starry), Integer.valueOf(R.drawable.fz_));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_visitor_default), Integer.valueOf(R.drawable.gjt));
        f50958a.put(Integer.valueOf(DrawableID.skin_tips_newmessage), Integer.valueOf(R.drawable.skin_tips_newmessage));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_visitors_div), Integer.valueOf(R.drawable.gjx));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_vip_namaplate_bg), Integer.valueOf(R.drawable.gjo));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_visitor_star_gray), Integer.valueOf(R.drawable.gjw));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_visitor_star_bright), Integer.valueOf(R.drawable.gjv));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_redpocket), Integer.valueOf(R.drawable.gjm));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_vip_progress_bg), Integer.valueOf(R.drawable.gjp));
        f50958a.put(Integer.valueOf(DrawableID.qzone_icon_star_vip_process_value), Integer.valueOf(R.drawable.g7p));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_vip_progress_value), Integer.valueOf(R.drawable.gjr));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_vip_progress_divider), Integer.valueOf(R.drawable.gjq));
        f50958a.put(Integer.valueOf(DrawableID.qzone_union_vip_progress_bg), Integer.valueOf(R.drawable.gh9));
        f50958a.put(Integer.valueOf(DrawableID.qzone_union_vip_icon), Integer.valueOf(R.drawable.gh8));
        f50958a.put(Integer.valueOf(DrawableID.qzone_widget_vip_number_bg), Integer.valueOf(R.drawable.hz5));
    }

    public static Bitmap getBitmapFromResource(Context context, int i3, int i16, int i17) {
        if (f50958a.containsKey(Integer.valueOf(i3))) {
            return c.t(context.getResources(), f50958a.get(Integer.valueOf(i3)).intValue(), i16, i17);
        }
        return null;
    }

    public static Bitmap getCoverWidgetLunarZipBitmap(int i3, String str, e eVar) {
        return ZipResDownloadManager.C().x("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", i3, str, eVar);
    }

    public static Bitmap getCoverWidgetWeatherZipBitmap(int i3, String str, e eVar) {
        return ZipResDownloadManager.C().x("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", i3, str, eVar);
    }

    public static Drawable getDrawable(Context context, int i3) {
        if (f50958a.containsKey(Integer.valueOf(i3))) {
            return context.getResources().getDrawable(f50958a.get(Integer.valueOf(i3)).intValue());
        }
        return null;
    }

    public static QQUnionIconInfo getQQUnionVipUrl(int i3, Map<String, QQUnionIconInfo> map) {
        return cooperation.vip.vipcomponent.util.c.g(7, i3, map);
    }

    /* loaded from: classes39.dex */
    public static class DrawableID {
        public static int qzone_cover_constellation_star = 0;
        public static int qzone_cover_constellation_starry = 0;
        public static int qzone_cover_widget_flower_load_fail = 1;
        public static int qzone_icon_star_vip_process_value;
        public static int qzone_union_vip_icon;
        public static int qzone_union_vip_progress_bg;
        public static int qzone_widget_flower_love;
        public static int qzone_widget_flower_nutrition;
        public static int qzone_widget_flower_sunshine;
        public static int qzone_widget_flower_water;
        public static int qzone_widget_redpocket;
        public static int qzone_widget_vip_namaplate_bg;
        public static int qzone_widget_vip_number_bg;
        public static int qzone_widget_vip_progress_bg;
        public static int qzone_widget_vip_progress_divider;
        public static int qzone_widget_vip_progress_value;
        public static int qzone_widget_visitor_background;
        public static int qzone_widget_visitor_default;
        public static int qzone_widget_visitor_eye;
        public static int qzone_widget_visitor_star_bright;
        public static int qzone_widget_visitor_star_gray;
        public static int qzone_widget_visitors_div;
        public static int skin_tips_newmessage;

        static {
            int i3 = 1 + 1;
            qzone_widget_flower_love = i3;
            int i16 = i3 + 1;
            qzone_widget_flower_nutrition = i16;
            int i17 = i16 + 1;
            qzone_widget_flower_sunshine = i17;
            int i18 = i17 + 1;
            qzone_widget_flower_water = i18;
            int i19 = i18 + 1;
            qzone_cover_constellation_star = i19;
            int i26 = i19 + 1;
            qzone_cover_constellation_starry = i26;
            int i27 = i26 + 1;
            qzone_widget_visitor_default = i27;
            int i28 = i27 + 1;
            skin_tips_newmessage = i28;
            int i29 = i28 + 1;
            qzone_widget_visitors_div = i29;
            int i36 = i29 + 1;
            qzone_widget_vip_namaplate_bg = i36;
            int i37 = i36 + 1;
            qzone_widget_visitor_star_gray = i37;
            int i38 = i37 + 1;
            qzone_widget_visitor_star_bright = i38;
            int i39 = i38 + 1;
            qzone_widget_visitor_eye = i39;
            int i46 = i39 + 1;
            qzone_widget_visitor_background = i46;
            int i47 = i46 + 1;
            qzone_widget_redpocket = i47;
            int i48 = i47 + 1;
            qzone_widget_vip_progress_bg = i48;
            int i49 = i48 + 1;
            qzone_icon_star_vip_process_value = i49;
            int i56 = i49 + 1;
            qzone_widget_vip_progress_value = i56;
            int i57 = i56 + 1;
            qzone_widget_vip_progress_divider = i57;
            int i58 = i57 + 1;
            qzone_union_vip_progress_bg = i58;
            int i59 = i58 + 1;
            qzone_union_vip_icon = i59;
            qzone_widget_vip_number_bg = i59 + 1;
        }
    }
}
