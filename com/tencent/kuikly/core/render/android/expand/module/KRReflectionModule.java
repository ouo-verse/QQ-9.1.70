package com.tencent.kuikly.core.render.android.expand.module;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.expand.module.KRReflectionModule;
import com.tencent.kuikly.core.render.android.expand.vendor.KRReflect;
import com.tencent.kuikly.core.render.android.expand.vendor.ReflectException;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u000223B\u0007\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J-\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\t\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001bj\u0004\u0018\u0001`\u001fH\u0016R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRReflectionModule;", "Li01/e;", "", "params", "l", "g", "p", "j", "objectID", "method", "", "i", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "krReflect", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "title", "message", "t", "", "splits", "", "d", "(Ljava/util/List;Ljava/lang/String;)[Ljava/lang/Object;", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Ljava/util/HashMap;", "Lcom/tencent/kuikly/core/render/android/expand/module/KRReflectionModule$b;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "objectRegistry", "", "e", "J", "autoObjectID", "", "f", "Z", "needAutoReleaseNextLoop", "<init>", "()V", tl.h.F, "a", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRReflectionModule extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, b> objectRegistry = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long autoObjectID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needAutoReleaseNextLoop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0002\u001a\u00020\u0001R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRReflectionModule$b;", "", "e", "", "a", "I", "b", "()I", "d", "(I)V", "krRetainCount", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "()Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "c", "(Lcom/tencent/kuikly/core/render/android/expand/vendor/a;)V", "javaObject", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int krRetainCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public KRReflect javaObject;

        @NotNull
        public final KRReflect a() {
            KRReflect kRReflect = this.javaObject;
            if (kRReflect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("javaObject");
            }
            return kRReflect;
        }

        /* renamed from: b, reason: from getter */
        public final int getKrRetainCount() {
            return this.krRetainCount;
        }

        public final void c(@NotNull KRReflect kRReflect) {
            Intrinsics.checkNotNullParameter(kRReflect, "<set-?>");
            this.javaObject = kRReflect;
        }

        public final void d(int i3) {
            this.krRetainCount = i3;
        }

        @NotNull
        public final Object e() {
            KRReflect kRReflect = this.javaObject;
            if (kRReflect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("javaObject");
            }
            if (kRReflect.e() != null) {
                KRReflect kRReflect2 = this.javaObject;
                if (kRReflect2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("javaObject");
                }
                Object e16 = kRReflect2.e();
                Intrinsics.checkNotNull(e16);
                return e16;
            }
            KRReflect kRReflect3 = this.javaObject;
            if (kRReflect3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("javaObject");
            }
            return kRReflect3.f();
        }
    }

    private final Object[] d(List<String> splits, String method) {
        String str;
        Object obj;
        ArrayList arrayList = new ArrayList();
        int size = splits.size();
        for (int i3 = 1; i3 < size; i3++) {
            String str2 = splits.get(i3);
            if (str2 != null) {
                boolean z16 = false;
                String substring = str2.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring) + 1;
                String substring2 = str2.substring(1, parseInt);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                Object obj2 = "";
                if (str2.length() <= parseInt) {
                    str = "";
                } else {
                    String substring3 = str2.substring(parseInt, str2.length());
                    Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    str = substring3;
                }
                if (Intrinsics.areEqual(substring2, "object")) {
                    Object i16 = i(str, method);
                    if (i16 == null) {
                        t("\u53cd\u5c04\u53c2\u6570\u5931\u8d25", "objectID:" + str + " \u4e0d\u5b58\u5728 method\uff1a" + method);
                        return null;
                    }
                    if (i16 instanceof b) {
                        obj = ((b) i16).e();
                    } else {
                        obj = i16;
                    }
                } else if (Intrinsics.areEqual(substring2, HippyControllerProps.BOOLEAN)) {
                    if (Integer.parseInt(str) > 0) {
                        z16 = true;
                    }
                    obj = Boolean.valueOf(z16);
                } else if (Intrinsics.areEqual(substring2, PoiListCacheRecord.WEIGHT_TYPE)) {
                    obj = Integer.valueOf(Integer.parseInt(str));
                } else if (Intrinsics.areEqual(substring2, "uint")) {
                    obj = UInt.m564boximpl(UStringsKt.toUInt(str));
                } else if (Intrinsics.areEqual(substring2, Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    obj = Short.valueOf(Short.parseShort(str));
                } else if (Intrinsics.areEqual(substring2, "float")) {
                    obj = Float.valueOf(Float.parseFloat(str));
                } else {
                    obj = str;
                    if (Intrinsics.areEqual(substring2, "double")) {
                        obj = Double.valueOf(Double.parseDouble(str));
                    }
                }
                if (obj != null) {
                    obj2 = obj;
                }
                arrayList.add(obj2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList.toArray();
    }

    private final String g(String params) {
        List split$default;
        KRReflect kRReflect;
        if (params != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"|"}, false, 0, 6, (Object) null);
            String str = (String) split$default.get(0);
            String str2 = (String) split$default.get(1);
            Object i3 = i(str, "getField");
            if (i3 != null) {
                if (i3 instanceof b) {
                    kRReflect = ((b) i3).a();
                } else {
                    kRReflect = (KRReflect) i3;
                }
                try {
                    Object i16 = kRReflect.i(str2);
                    if (i16 != null) {
                        return r(KRReflect.INSTANCE.d(i16));
                    }
                } catch (Throwable th5) {
                    t("\u53cd\u5c04\u5bf9\u8c61\u5c5e\u6027\u5931\u8d25", "\u5c5e\u6027\u540d:" + str2 + " exception:" + th5);
                }
            }
        }
        return "";
    }

    private final Object i(String objectID, String method) {
        Long longOrNull;
        b bVar = this.objectRegistry.get(objectID);
        if (bVar == null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(objectID);
            if (longOrNull == null) {
                try {
                    KRReflect.Companion companion = KRReflect.INSTANCE;
                    Class<?> cls = Class.forName(objectID);
                    Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(objectID)");
                    return KRReflect.Companion.f(companion, cls, null, 2, null);
                } catch (Exception e16) {
                    t("\u53cd\u5c04\u7c7b\u540d\u5931\u8d25", "\u7c7b\u540d:" + objectID + " exception:" + e16 + " method: " + method);
                    return null;
                }
            }
            t("\u53cd\u5c04\u83b7\u53d6\u5bf9\u8c61\u5931\u8d25", "\u83b7\u53d6\u5bf9\u8c61ID:" + objectID + ", \u65b9\u6cd5: " + method + " , \u5bf9\u8c61\u53ef\u80fd\u88ab\u81ea\u52a8\u6e05\u7406,\u53ef\u5c1d\u8bd5retain()/release()\u624b\u52a8\u7ba1\u7406\u5185\u5b58");
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "objectRegistry[objectID]\u2026       null\n            }");
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String j(String params) {
        List<String> split$default;
        List split$default2;
        Object[] d16;
        KRReflect a16;
        if (params != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"\n$\t&@\n"}, false, 0, 6, (Object) null);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(0), new String[]{"|"}, false, 0, 6, (Object) null);
            String str = (String) split$default2.get(0);
            String str2 = (String) split$default2.get(1);
            Object i3 = i(str, str2);
            if (i3 != null && (d16 = d(split$default, str2)) != null) {
                if (i3 instanceof b) {
                    try {
                        a16 = n.a(((b) i3).a(), str2, Arrays.copyOf(d16, d16.length));
                    } catch (Throwable th5) {
                        t("\u53cd\u5c04\u5bf9\u8c61\u65b9\u6cd5\u5931\u8d25", "\u65b9\u6cd5\u540d:" + str2 + " exception:" + th5);
                        a16 = null;
                        if (a16 != null) {
                        }
                        return "";
                    }
                } else {
                    try {
                        a16 = n.a((KRReflect) i3, str2, Arrays.copyOf(d16, d16.length));
                    } catch (Throwable th6) {
                        t("\u53cd\u5c04\u7c7b\u65b9\u6cd5\u5931\u8d25", "\u7c7b\u540d:" + str + " \u65b9\u6cd5\u540d:" + str2 + " exception:" + th6);
                        a16 = null;
                        if (a16 != null) {
                        }
                        return "";
                    }
                }
                if (a16 != null) {
                    return r(a16);
                }
            }
        }
        return "";
    }

    private final String l(String params) {
        Object i3;
        String str;
        if (params == null || (i3 = i(params, "toString")) == null) {
            return "";
        }
        if (i3 instanceof b) {
            String str2 = (String) n.a(((b) i3).a(), "toString", new Object[0]).e();
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        if (!(i3 instanceof KRReflect) || (str = (String) n.a((KRReflect) i3, "toString", new Object[0]).e()) == null) {
            return "";
        }
        return str;
    }

    private final String m(String params) {
        Object i3;
        if (params != null && (i3 = i(params, "release")) != null) {
            ((b) i3).d(r3.getKrRetainCount() - 1);
            q();
        }
        return "";
    }

    private final String o(String params) {
        Object i3;
        if (params != null && (i3 = i(params, "retain")) != null) {
            b bVar = (b) i3;
            bVar.d(bVar.getKrRetainCount() + 1);
        }
        return "";
    }

    private final String p(String params) {
        List<String> split$default;
        List split$default2;
        Object[] d16;
        KRReflect kRReflect;
        if (params != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"\n$\t&@\n"}, false, 0, 6, (Object) null);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(0), new String[]{"|"}, false, 0, 6, (Object) null);
            String str = (String) split$default2.get(0);
            String str2 = (String) split$default2.get(1);
            Object i3 = i(str, "getField");
            if (i3 != null && (d16 = d(split$default, str2)) != null) {
                if (i3 instanceof b) {
                    kRReflect = ((b) i3).a();
                } else {
                    kRReflect = (KRReflect) i3;
                }
                try {
                    kRReflect.l(str2, d16[0]);
                } catch (Throwable th5) {
                    t("\u53cd\u5c04\u8bbe\u7f6e\u5bf9\u8c61\u5c5e\u6027\u5931\u8d25", "\u5c5e\u6027\u540d:" + str2 + " exception:" + th5);
                }
            }
        }
        return "";
    }

    private final void q() {
        KuiklyContextParams contextParams;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (contextParams = aVar.getContextParams()) != null && !this.needAutoReleaseNextLoop) {
            this.needAutoReleaseNextLoop = true;
            KuiklyRenderThreadManager.i(KuiklyRenderThreadManager.f118203b, contextParams, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRReflectionModule$setNeedAutoReleaseInNextLoop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HashMap hashMap;
                    Map map;
                    HashMap hashMap2;
                    hashMap = KRReflectionModule.this.objectRegistry;
                    map = MapsKt__MapsKt.toMap(hashMap);
                    for (Map.Entry entry : map.entrySet()) {
                        if (((KRReflectionModule.b) entry.getValue()).getKrRetainCount() <= 0) {
                            hashMap2 = KRReflectionModule.this.objectRegistry;
                            hashMap2.remove(entry.getKey());
                        }
                    }
                    KRReflectionModule.this.needAutoReleaseNextLoop = false;
                }
            }, 16L, false, 0L, 16, null);
        }
    }

    private final String r(KRReflect krReflect) {
        b bVar = new b();
        bVar.c(krReflect);
        long j3 = this.autoObjectID + 1;
        this.autoObjectID = j3;
        String valueOf = String.valueOf(j3);
        this.objectRegistry.put(valueOf, bVar);
        q();
        return valueOf;
    }

    private final void t(String title, String message) {
        throw new ReflectException(title + QbAddrData.DATA_SPLITER + message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1776922004:
                if (method.equals("toString")) {
                    return l(params);
                }
                return super.call(method, params, callback);
            case -1183693704:
                if (method.equals("invoke")) {
                    return j(params);
                }
                return super.call(method, params, callback);
            case -934416123:
                if (method.equals("retain")) {
                    return o(params);
                }
                return super.call(method, params, callback);
            case 1090594823:
                if (method.equals("release")) {
                    return m(params);
                }
                return super.call(method, params, callback);
            case 1392140728:
                if (method.equals("setField")) {
                    return p(params);
                }
                return super.call(method, params, callback);
            case 1953253188:
                if (method.equals("getField")) {
                    return g(params);
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
