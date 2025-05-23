package com.tencent.mobileqq.kandian.biz.detail;

import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/detail/a;", "", "", "url", "", "dataMap", "Lcom/tencent/mobileqq/kandian/biz/detail/e;", "a", "originUrl", "urlOverrideInfo", "b", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f239362a = new a();

    a() {
    }

    @JvmStatic
    public static final UrlOverrideInfo a(String url, Map<String, String> dataMap) {
        Object obj;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        Iterator<T> it = dataMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) obj, false, 2, (Object) null);
            if (contains$default) {
                break;
            }
        }
        String str = dataMap.get((String) obj);
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return null;
        }
        UrlOverrideInfo a16 = UrlOverrideInfo.INSTANCE.a(str);
        if (a16.getReplaceUrl().length() > 0) {
            return a16;
        }
        return null;
    }

    @JvmStatic
    public static final String b(String originUrl, UrlOverrideInfo urlOverrideInfo) {
        boolean contains$default;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(urlOverrideInfo, "urlOverrideInfo");
        Uri parse = Uri.parse(originUrl);
        if (parse.getEncodedFragment() != null) {
            parse = Uri.parse(parse.getEncodedFragment());
        }
        String replaceUrl = urlOverrideInfo.getReplaceUrl();
        if (!parse.getQueryParameterNames().contains(urlOverrideInfo.getExtractParamKey())) {
            return replaceUrl;
        }
        String queryParameter = parse.getQueryParameter(urlOverrideInfo.getExtractParamKey());
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) replaceUrl, '?', false, 2, (Object) null);
        if (contains$default) {
            endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) replaceUrl, Typography.amp, false, 2, (Object) null);
            if (!endsWith$default) {
                replaceUrl = replaceUrl + ContainerUtils.FIELD_DELIMITER;
            }
        } else {
            replaceUrl = replaceUrl + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return replaceUrl + queryParameter;
    }
}
