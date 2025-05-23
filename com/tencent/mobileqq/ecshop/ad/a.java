package com.tencent.mobileqq.ecshop.ad;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\t\u0010\b\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0010\u001a\u00020\u000f*\u0004\u0018\u00010\u0000\u00a8\u0006\u0011"}, d2 = {"Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "", "l", "e", "g", "k", "", "i", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)Ljava/lang/Float;", "d", "j", h.F, "b", "f", "a", "", "c", "qqshop-feature-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {
    @NotNull
    public static final String a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return "";
        }
        return String.valueOf(adInfo.report_info.trace_info.aid.get());
    }

    @NotNull
    public static final String b(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return "";
        }
        try {
            String str = adInfo.display_info.button_info.get(0).txt.get();
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final int c(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.display_info.creative_size.get();
    }

    @Nullable
    public static final Float d(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        int i3 = adInfo.display_info.basic_info.pic_height.get();
        int i16 = adInfo.display_info.basic_info.pic_width.get();
        if (i3 == 0 || i16 == 0) {
            return null;
        }
        return Float.valueOf((i16 * 1.0f) / i3);
    }

    @NotNull
    public static final String e(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.display_info.basic_info.img.get()) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String f(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.dest_info.landing_page.get()) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String g(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        Object firstOrNull;
        if (adInfo == null) {
            return "";
        }
        List<String> list = adInfo.display_info.muti_pic_text_info.image.get();
        Intrinsics.checkNotNullExpressionValue(list, "display_info.muti_pic_text_info.image.get()");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        String str = (String) firstOrNull;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String h(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.display_info.basic_info.txt.get()) == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public static final Float i(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        int i3 = adInfo.display_info.video_info.height.get();
        int i16 = adInfo.display_info.video_info.width.get();
        if (i3 == 0 || i16 == 0) {
            return null;
        }
        return Float.valueOf((i16 * 1.0f) / i3);
    }

    @NotNull
    public static final String j(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.report_info.video_report_url.get()) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String k(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.display_info.video_info.video_url.get()) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String l(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String obj;
        Object pbToJson = GdtJsonPbUtil.pbToJson(adInfo);
        if (pbToJson == null || (obj = pbToJson.toString()) == null) {
            return "";
        }
        return obj;
    }
}
