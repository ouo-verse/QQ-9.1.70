package ml2;

import com.tencent.mobileqq.qwallet.report.ReportField;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\b"}, d2 = {"Lml2/d;", "", "reportBean", "", "", "a", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f416922a = new d();

    d() {
    }

    @NotNull
    public final Map<String, String> a(@Nullable Object reportBean) {
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        if (reportBean == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Field[] fields = reportBean.getClass().getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(fields, "fields");
            for (Field field : fields) {
                if (field.isAnnotationPresent(ReportField.class)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    ReportField reportField = (ReportField) field.getAnnotation(ReportField.class);
                    if (reportField != null) {
                        Intrinsics.checkNotNullExpressionValue(reportField, "it.getAnnotation(ReportF\u2026s.java) ?: return@forEach");
                        String name = reportField.name();
                        Object obj = field.get(reportBean);
                        if (obj == null) {
                            obj = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(obj, "it.get(reportBean) ?: \"\"");
                        }
                        linkedHashMap.put(name, obj.toString());
                    }
                }
            }
            return linkedHashMap;
        } catch (Exception e16) {
            QLog.e("ReportFieldParser", 1, "parseFieldToKv error", e16);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }
}
