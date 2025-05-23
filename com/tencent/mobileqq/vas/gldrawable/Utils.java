package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/gldrawable/Utils;", "", "()V", "getHardwareDecodec", "Ljava/util/ArrayList;", "Landroid/media/MediaCodecInfo;", "Lkotlin/collections/ArrayList;", "mime", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class Utils {

    @NotNull
    public static final Utils INSTANCE = new Utils();

    Utils() {
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<MediaCodecInfo> getHardwareDecodec(@NotNull String mime) {
        boolean contains;
        boolean contains2;
        boolean equals;
        Intrinsics.checkNotNullParameter(mime, "mime");
        ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MediaCodec support list:");
            Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
            StringsKt__StringBuilderJVMKt.appendln(sb5);
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                String str = null;
                if (codecInfoAt.isEncoder()) {
                    codecInfoAt = null;
                }
                if (codecInfoAt != null) {
                    sb5.append(codecInfoAt.getName());
                    Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
                    StringsKt__StringBuilderJVMKt.appendln(sb5);
                    sb5.append(Arrays.toString(codecInfoAt.getSupportedTypes()));
                    Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
                    StringsKt__StringBuilderJVMKt.appendln(sb5);
                    String name = codecInfoAt.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "info.name");
                    contains = StringsKt__StringsKt.contains((CharSequence) name, (CharSequence) ".sw.", true);
                    if (!contains) {
                        String name2 = codecInfoAt.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "info.name");
                        contains2 = StringsKt__StringsKt.contains((CharSequence) name2, (CharSequence) ".google.", true);
                        if (!contains2) {
                            String[] supportedTypes = codecInfoAt.getSupportedTypes();
                            Intrinsics.checkNotNullExpressionValue(supportedTypes, "info.supportedTypes");
                            int length = supportedTypes.length;
                            int i16 = 0;
                            while (true) {
                                if (i16 >= length) {
                                    break;
                                }
                                String str2 = supportedTypes[i16];
                                equals = StringsKt__StringsJVMKt.equals(str2, mime, true);
                                if (equals) {
                                    str = str2;
                                    break;
                                }
                                i16++;
                            }
                            if (str != null) {
                                arrayList.add(codecInfoAt);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
