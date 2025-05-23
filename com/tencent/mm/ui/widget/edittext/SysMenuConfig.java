package com.tencent.mm.ui.widget.edittext;

import android.os.Build;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR?\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\u000ej\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;", "", "", "isNeedReuseMenuItems", "Landroid/widget/TextView;", "textView", "Landroid/view/Menu;", "menu", "populateMenuItems", "", "brand", "Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig$SysMenuConfigItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "checkIntercept", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "getSysMenuConfigMap", "()Ljava/util/HashMap;", "sysMenuConfigMap", "<init>", "()V", "Companion", "SysMenuConfigItem", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SysMenuConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "SysMenuConfig";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final HashMap sysMenuConfigMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig$Companion;", "", "()V", "TAG", "", "parse", "Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig;", "configStr", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SysMenuConfig parse(@Nullable String configStr) {
            Iterator keys;
            SysMenuConfig sysMenuConfig = new SysMenuConfig();
            try {
                JSONObject optJSONObject = new JSONObject(configStr).optJSONObject("sysMenuConfig");
                if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(key);
                        if (optJSONArray != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(key)");
                            int length = optJSONArray.length();
                            for (int i3 = 0; i3 < length; i3++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                if (optJSONObject2 != null) {
                                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(i)");
                                    String optString = optJSONObject2.optString("idName");
                                    String str = "";
                                    if (optString == null) {
                                        optString = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"idName\")?:\"\"");
                                    }
                                    String optString2 = optJSONObject2.optString("idPackage");
                                    if (optString2 == null) {
                                        optString2 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"idPackage\")?:\"\"");
                                    }
                                    String optString3 = optJSONObject2.optString("titleName");
                                    if (optString3 == null) {
                                        optString3 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"titleName\")?:\"\"");
                                    }
                                    String optString4 = optJSONObject2.optString("titlePackage");
                                    if (optString4 != null) {
                                        Intrinsics.checkNotNullExpressionValue(optString4, "it.optString(\"titlePackage\")?:\"\"");
                                        str = optString4;
                                    }
                                    SysMenuConfigItem sysMenuConfigItem = new SysMenuConfigItem(optString, optString2, optString3, str);
                                    if (sysMenuConfig.getSysMenuConfigMap().get(key) == null) {
                                        HashMap<String, List<SysMenuConfigItem>> sysMenuConfigMap = sysMenuConfig.getSysMenuConfigMap();
                                        Intrinsics.checkNotNullExpressionValue(key, "key");
                                        LinkedList linkedList = new LinkedList();
                                        linkedList.add(sysMenuConfigItem);
                                        sysMenuConfigMap.put(key, linkedList);
                                    } else {
                                        List<SysMenuConfigItem> list = sysMenuConfig.getSysMenuConfigMap().get(key);
                                        if (list != null) {
                                            list.add(sysMenuConfigItem);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return sysMenuConfig;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SysMenuConfig$SysMenuConfigItem;", "", "", "component1", "component2", "component3", "component4", "idName", "idPackage", "titleName", "titlePackage", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getIdName", "()Ljava/lang/String;", "b", "getIdPackage", "c", "getTitleName", "d", "getTitlePackage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final /* data */ class SysMenuConfigItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String idName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String idPackage;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String titleName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String titlePackage;

        public SysMenuConfigItem(@NotNull String idName, @NotNull String idPackage, @NotNull String titleName, @NotNull String titlePackage) {
            Intrinsics.checkNotNullParameter(idName, "idName");
            Intrinsics.checkNotNullParameter(idPackage, "idPackage");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(titlePackage, "titlePackage");
            this.idName = idName;
            this.idPackage = idPackage;
            this.titleName = titleName;
            this.titlePackage = titlePackage;
        }

        public static /* synthetic */ SysMenuConfigItem copy$default(SysMenuConfigItem sysMenuConfigItem, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = sysMenuConfigItem.idName;
            }
            if ((i3 & 2) != 0) {
                str2 = sysMenuConfigItem.idPackage;
            }
            if ((i3 & 4) != 0) {
                str3 = sysMenuConfigItem.titleName;
            }
            if ((i3 & 8) != 0) {
                str4 = sysMenuConfigItem.titlePackage;
            }
            return sysMenuConfigItem.copy(str, str2, str3, str4);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdName() {
            return this.idName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getIdPackage() {
            return this.idPackage;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getTitlePackage() {
            return this.titlePackage;
        }

        @NotNull
        public final SysMenuConfigItem copy(@NotNull String idName, @NotNull String idPackage, @NotNull String titleName, @NotNull String titlePackage) {
            Intrinsics.checkNotNullParameter(idName, "idName");
            Intrinsics.checkNotNullParameter(idPackage, "idPackage");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(titlePackage, "titlePackage");
            return new SysMenuConfigItem(idName, idPackage, titleName, titlePackage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SysMenuConfigItem)) {
                return false;
            }
            SysMenuConfigItem sysMenuConfigItem = (SysMenuConfigItem) other;
            if (Intrinsics.areEqual(this.idName, sysMenuConfigItem.idName) && Intrinsics.areEqual(this.idPackage, sysMenuConfigItem.idPackage) && Intrinsics.areEqual(this.titleName, sysMenuConfigItem.titleName) && Intrinsics.areEqual(this.titlePackage, sysMenuConfigItem.titlePackage)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getIdName() {
            return this.idName;
        }

        @NotNull
        public final String getIdPackage() {
            return this.idPackage;
        }

        @NotNull
        public final String getTitleName() {
            return this.titleName;
        }

        @NotNull
        public final String getTitlePackage() {
            return this.titlePackage;
        }

        public int hashCode() {
            return (((((this.idName.hashCode() * 31) + this.idPackage.hashCode()) * 31) + this.titleName.hashCode()) * 31) + this.titlePackage.hashCode();
        }

        @NotNull
        public String toString() {
            return "SysMenuConfigItem(idName=" + this.idName + ", idPackage=" + this.idPackage + ", titleName=" + this.titleName + ", titlePackage=" + this.titlePackage + ')';
        }
    }

    public final boolean checkIntercept(@NotNull String brand, @NotNull TextView textView, @NotNull SysMenuConfigItem item) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = false;
        try {
            if (brand.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && Intrinsics.areEqual(item.getIdName(), "clipboard")) {
                Method declaredMethod = TextView.class.getDeclaredMethod("canClipboard", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(textView, new Object[0]);
                if (invoke instanceof Boolean) {
                    bool = (Boolean) invoke;
                } else {
                    bool = null;
                }
                if (bool != null) {
                    z16 = bool.booleanValue();
                }
                return !z16;
            }
        } catch (Throwable th5) {
            n.a(TAG, th5, "checkIntercept err", new Object[0]);
        }
        return false;
    }

    @NotNull
    public final HashMap<String, List<SysMenuConfigItem>> getSysMenuConfigMap() {
        return this.sysMenuConfigMap;
    }

    public final boolean isNeedReuseMenuItems() {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String lowerCase = BRAND.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        List list = (List) this.sysMenuConfigMap.get(lowerCase);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public final boolean populateMenuItems(@Nullable TextView textView, @Nullable Menu menu) {
        if (textView == null || menu == null) {
            return false;
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String lowerCase = BRAND.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        List<SysMenuConfigItem> list = (List) this.sysMenuConfigMap.get(lowerCase);
        if (list != null && list.size() > 0) {
            for (SysMenuConfigItem sysMenuConfigItem : list) {
                if (!checkIntercept(lowerCase, textView, sysMenuConfigItem)) {
                    try {
                        int identifier = textView.getResources().getIdentifier(sysMenuConfigItem.getIdName(), "id", sysMenuConfigItem.getIdPackage());
                        int identifier2 = textView.getResources().getIdentifier(sysMenuConfigItem.getTitleName(), HippyControllerProps.STRING, sysMenuConfigItem.getTitlePackage());
                        n.c(TAG, "populateMenuItem id:%s strId:%s", Integer.valueOf(identifier), Integer.valueOf(identifier2));
                        if (identifier != 0 && identifier2 != 0) {
                            menu.add(0, identifier, 0, identifier2);
                        }
                    } catch (Throwable th5) {
                        n.a(TAG, th5, "populateMenuItem ERR", new Object[0]);
                    }
                }
            }
        }
        return true;
    }
}
