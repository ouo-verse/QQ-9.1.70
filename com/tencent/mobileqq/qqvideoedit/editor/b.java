package com.tencent.mobileqq.qqvideoedit.editor;

import android.support.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b#\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u001a\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\r\u001a\u001a\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000f\u001a\u001a\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011\u001a\u0006\u0010\u0013\u001a\u00020\u0000\"(\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\"(\u0010\u001e\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\"(\u0010!\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017\"(\u0010$\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017\"(\u0010'\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017\"(\u0010*\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017\"(\u0010-\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001d\"(\u00100\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001d\"(\u00105\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104\"(\u00108\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017\"(\u0010;\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u00102\"\u0004\b:\u00104\u00a8\u0006<"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "o", "", "key", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "default", "l", "value", "", "t", tl.h.F, "g", "", "i", "", "f", "", ReportConstant.COSTREPORT_PREFIX, "r", "k", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setName", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "name", "", "c", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "displayDownloadIcon", "j", "setModeLoop", "modeLoop", "e", "setDynamicThumbUrl", "dynamicThumbUrl", "a", "v", "categoryId", "b", "w", "categoryName", "p", "u", "isApplyLocal", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "isSmallLoading", "d", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", HippyTKDListViewAdapter.X, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "downloadProgress", "getThumbText", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "thumbText", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "thumbBackground", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    public static final void A(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        t(metaMaterial, "exThumbText", value);
    }

    @NotNull
    public static final String a(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return m(metaMaterial, "categoryId");
    }

    @NotNull
    public static final String b(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return m(metaMaterial, "categoryName");
    }

    public static final boolean c(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (h(metaMaterial, "displayDownloadIcon") == 1) {
            return true;
        }
        return false;
    }

    public static final int d(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return g(metaMaterial, "downloadProgress", -1);
    }

    @NotNull
    public static final String e(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return m(metaMaterial, "motionCoverUrl");
    }

    public static final float f(@NotNull MetaMaterial metaMaterial, @NotNull String key, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return f16;
        }
        String str = map.get(key);
        if (str == null) {
            return f16;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f16;
        }
    }

    public static final int g(@NotNull MetaMaterial metaMaterial, @NotNull String key, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return i3;
        }
        String str = map.get(key);
        if (str == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static final int h(@NotNull MetaMaterial metaMaterial, @NotNull String key) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return g(metaMaterial, key, 0);
    }

    public static final long i(@NotNull MetaMaterial metaMaterial, @NotNull String key, long j3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return j3;
        }
        String str = map.get(key);
        if (str == null) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j3;
        }
    }

    @NotNull
    public static final String j(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return l(metaMaterial, "modeLoop", "none");
    }

    @NotNull
    public static final String k(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return m(metaMaterial, "name");
    }

    @NotNull
    public static final String l(@NotNull MetaMaterial metaMaterial, @NotNull String key, @NotNull String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map != null) {
            String str2 = map.get(key);
            if (str2 == null) {
                return str;
            }
            return str2;
        }
        return str;
    }

    @NotNull
    public static final String m(@NotNull MetaMaterial metaMaterial, @NotNull String key) {
        String str;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null || (str = map.get(key)) == null) {
            return "";
        }
        return str;
    }

    public static final int n(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return g(metaMaterial, "exThumbBackground", -1);
    }

    @DrawableRes
    public static final int o(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return 0;
    }

    public static final boolean p(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (g(metaMaterial, "isApplyLocal", 1) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (g(metaMaterial, "isSmallLoading", 1) == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final MetaMaterial r() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "ID_PLACEHOLDER";
        return metaMaterial;
    }

    public static final void s(@NotNull MetaMaterial metaMaterial, @NotNull String key, @NotNull Number value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        try {
            Map<String, String> map = metaMaterial.additionalFields;
            Intrinsics.checkNotNullExpressionValue(map, "this.additionalFields");
            map.put(key, value.toString());
        } catch (Exception unused) {
        }
    }

    public static final void t(@NotNull MetaMaterial metaMaterial, @NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        Map<String, String> map = metaMaterial.additionalFields;
        Intrinsics.checkNotNullExpressionValue(map, "this.additionalFields");
        map.put(key, str);
    }

    public static final void u(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        s(metaMaterial, "isApplyLocal", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void v(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        t(metaMaterial, "categoryId", value);
    }

    public static final void w(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        t(metaMaterial, "categoryName", value);
    }

    public static final void x(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        s(metaMaterial, "downloadProgress", Integer.valueOf(Math.min(i3, 100)));
    }

    public static final void y(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        s(metaMaterial, "isSmallLoading", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void z(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        s(metaMaterial, "exThumbBackground", Integer.valueOf(i3));
    }
}
