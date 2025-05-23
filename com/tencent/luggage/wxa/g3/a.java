package com.tencent.luggage.wxa.g3;

import android.content.Intent;
import android.net.Uri;
import com.tencent.libra.util.ImageContentType;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f126397a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f126398b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f126399c;

    static {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        List listOf5;
        List listOf6;
        List listOf7;
        List listOf8;
        List listOf9;
        List listOf10;
        List listOf11;
        List listOf12;
        List listOf13;
        List listOf14;
        List listOf15;
        List listOf16;
        List listOf17;
        List listOf18;
        HashMap hashMap = new HashMap();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".jpg", ".jpeg"});
        hashMap.put("image/jpeg", listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".jpg", ".jpeg"});
        hashMap.put(ImageContentType.MIME_TYPE_JPG, listOf2);
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(".png");
        hashMap.put("image/png", listOf3);
        listOf4 = CollectionsKt__CollectionsJVMKt.listOf(".webp");
        hashMap.put("image/webp", listOf4);
        listOf5 = CollectionsKt__CollectionsJVMKt.listOf(".bmp");
        hashMap.put(MimeHelper.IMAGE_BMP, listOf5);
        listOf6 = CollectionsKt__CollectionsJVMKt.listOf(QzoneEmotionUtils.SIGN_ICON_URL_END);
        hashMap.put("image/gif", listOf6);
        listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".tiff", ".tif"});
        hashMap.put("image/tiff", listOf7);
        listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".svg", ".svgz"});
        hashMap.put("image/svg+xml", listOf8);
        f126398b = hashMap;
        HashMap hashMap2 = new HashMap();
        listOf9 = CollectionsKt__CollectionsJVMKt.listOf(".mp4");
        hashMap2.put("video/mp4", listOf9);
        listOf10 = CollectionsKt__CollectionsJVMKt.listOf(".m4v");
        hashMap2.put("video/x-m4v", listOf10);
        listOf11 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".mpg", ".mpeg", ".mpe"});
        hashMap2.put("video/mpeg", listOf11);
        listOf12 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{".qt", ".mov"});
        hashMap2.put(MimeHelper.VIDEO_MOV, listOf12);
        listOf13 = CollectionsKt__CollectionsJVMKt.listOf(".avi");
        hashMap2.put("video/x-msvideo", listOf13);
        listOf14 = CollectionsKt__CollectionsJVMKt.listOf(".wmv");
        hashMap2.put("video/x-ms-wmv", listOf14);
        listOf15 = CollectionsKt__CollectionsJVMKt.listOf(".webm");
        hashMap2.put("video/webm", listOf15);
        listOf16 = CollectionsKt__CollectionsJVMKt.listOf(".ogv");
        hashMap2.put("video/ogg", listOf16);
        listOf17 = CollectionsKt__CollectionsJVMKt.listOf(".3gp");
        hashMap2.put("video/3gpp", listOf17);
        listOf18 = CollectionsKt__CollectionsJVMKt.listOf(".3g2");
        hashMap2.put("video/3gpp2", listOf18);
        f126399c = hashMap2;
    }

    public static final Intent a(String[] acceptType, Function1 getUriFunction) {
        Intrinsics.checkNotNullParameter(acceptType, "acceptType");
        Intrinsics.checkNotNullParameter(getUriFunction, "getUriFunction");
        a aVar = f126397a;
        if (aVar.b(acceptType)) {
            return aVar.a((Uri) getUriFunction.invoke("wv_choose_image"));
        }
        if (aVar.a(acceptType)) {
            Intent b16 = aVar.b();
            if (b16 != null) {
                return b16;
            }
            w.f("FileChooserUtil", "createChooserIntent no sound recorder");
            return null;
        }
        if (aVar.c(acceptType)) {
            return aVar.a();
        }
        return null;
    }

    public final boolean b(String[] strArr) {
        return a(strArr, f126398b, "image/*");
    }

    public final boolean c(String[] strArr) {
        return a(strArr, f126399c, "video/*");
    }

    public final Intent b() {
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        if (intent.resolveActivity(z.c().getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    public final boolean a(String[] strArr) {
        boolean equals;
        if (strArr == null) {
            return false;
        }
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null) {
                equals = StringsKt__StringsJVMKt.equals(str, "audio/*", true);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String[] strArr, Map map, String str) {
        boolean z16;
        CharSequence trim;
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean z17;
        boolean isBlank;
        if (strArr == null) {
            w.a("FileChooserUtil", "isFileTypeSupport false (null input), type: " + str);
            return false;
        }
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        trim = StringsKt__StringsKt.trim((CharSequence) str2);
                        String obj = trim.toString();
                        equals = StringsKt__StringsJVMKt.equals(obj, str, true);
                        if (equals) {
                            return true;
                        }
                        for (Map.Entry entry : map.entrySet()) {
                            String str3 = (String) entry.getKey();
                            List list = (List) entry.getValue();
                            equals2 = StringsKt__StringsJVMKt.equals(obj, str3, true);
                            if (equals2) {
                                return true;
                            }
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator it5 = list.iterator();
                                while (it5.hasNext()) {
                                    equals3 = StringsKt__StringsJVMKt.equals((String) it5.next(), obj, true);
                                    if (equals3) {
                                        z17 = true;
                                        break;
                                    }
                                }
                            }
                            z17 = false;
                            if (z17) {
                                return true;
                            }
                        }
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isFileTypeSupport false, acceptType: ");
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb5.append(arrays);
        sb5.append(", type: ");
        sb5.append(str);
        w.a("FileChooserUtil", sb5.toString());
        return false;
    }

    public final Intent a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        return intent;
    }

    public final Intent a() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }
}
