package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/a;", "", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "c", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "body", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/b;", "b", "Ljava/util/List;", "()Ljava/util/List;", TabPreloadItem.TAB_NAME_DYNAMIC, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String body;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<b> dynamic;

    public a(String str, List<b> list) {
        this.body = str;
        this.dynamic = list;
    }

    /* renamed from: a */
    public String getBody() {
        throw null;
    }

    public List<b> b() {
        throw null;
    }

    public final String c(Map<String, ? extends Object> pageParams) {
        boolean startsWith$default;
        String replace$default;
        String replace$default2;
        String replace$default3;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        String body = getBody();
        if (!(body == null || body.length() == 0) && !pageParams.isEmpty()) {
            if (b() != null) {
                List<b> b16 = b();
                Intrinsics.checkNotNull(b16);
                if (!b16.isEmpty()) {
                    String body2 = getBody();
                    Intrinsics.checkNotNull(body2, "null cannot be cast to non-null type kotlin.String");
                    List<b> b17 = b();
                    Intrinsics.checkNotNull(b17);
                    while (true) {
                        String str = body2;
                        for (b bVar : b17) {
                            String str2 = "\\\"" + bVar.getName() + "\\\"";
                            String name = bVar.getName();
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(bVar.getName(), "${", false, 2, null);
                            if (startsWith$default) {
                                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(bVar.getName(), "}", false, 2, null);
                                if (endsWith$default) {
                                    name = bVar.getName().substring(2, bVar.getName().length() - 1);
                                    Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                }
                            }
                            if (Intrinsics.areEqual("platform", name)) {
                                replace$default = StringsKt__StringsJVMKt.replace$default(str, str2, "1", false, 4, (Object) null);
                                body2 = StringsKt__StringsJVMKt.replace$default(replace$default, bVar.getName(), "1", false, 4, (Object) null);
                            } else if (Intrinsics.areEqual("uin", name)) {
                                body2 = StringsKt__StringsJVMKt.replace$default(str, str2, "\\\"" + String.valueOf(QQKuiklyPlatformApi.INSTANCE.a()) + "\\\"", false, 4, (Object) null);
                            } else if (Intrinsics.areEqual("timestamp", name)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(currentTimeMillis);
                                replace$default2 = StringsKt__StringsJVMKt.replace$default(str, str2, sb5.toString(), false, 4, (Object) null);
                                String name2 = bVar.getName();
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(currentTimeMillis);
                                body2 = StringsKt__StringsJVMKt.replace$default(replace$default2, name2, sb6.toString(), false, 4, (Object) null);
                            } else if (Intrinsics.areEqual("device_info", name)) {
                                body2 = StringsKt__StringsJVMKt.replace$default(str, str2, "\\\"" + SubscribeAdDeviceInfoHelper.e().d() + "\\\"", false, 4, (Object) null);
                            } else {
                                Object obj = pageParams.get(name);
                                if (obj != null) {
                                    if (!Intrinsics.areEqual(Entry.DATA_TYPE_STRING, bVar.getType())) {
                                        replace$default3 = StringsKt__StringsJVMKt.replace$default(str, str2, obj.toString(), false, 4, (Object) null);
                                        body2 = StringsKt__StringsJVMKt.replace$default(replace$default3, bVar.getName(), obj.toString(), false, 4, (Object) null);
                                    } else {
                                        body2 = StringsKt__StringsJVMKt.replace$default(str, str2, "\\\"" + obj + "\\\"", false, 4, (Object) null);
                                    }
                                }
                            }
                        }
                        return str;
                    }
                }
            }
            String body3 = getBody();
            Intrinsics.checkNotNull(body3, "null cannot be cast to non-null type kotlin.String");
            return body3;
        }
        return "{}";
    }
}
