package com.tencent.opentelemetry.sdk.autoconfigure;

import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes22.dex */
public final class ConfigProperties {
    static IPatchRedirector $redirector_;
    private final Map<String, String> config;

    ConfigProperties(Map<?, ?> map, Map<String, String> map2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map, (Object) map2);
            return;
        }
        final HashMap hashMap = new HashMap();
        map2.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ConfigProperties.lambda$new$0(hashMap, (String) obj, (String) obj2);
            }
        });
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.d
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ConfigProperties.lambda$new$1(hashMap, obj, obj2);
            }
        });
        this.config = hashMap;
    }

    static ConfigProperties createForTest(Map<String, String> map) {
        return new ConfigProperties(map, Collections.emptyMap());
    }

    private static List<String> filterBlanksAndNulls(String[] strArr) {
        Stream stream;
        Stream map;
        Stream filter;
        Collector list;
        Object collect;
        stream = Arrays.stream(strArr);
        map = stream.map(new Function() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).trim();
            }
        });
        filter = map.filter(new Predicate() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$filterBlanksAndNulls$5;
                lambda$filterBlanksAndNulls$5 = ConfigProperties.lambda$filterBlanksAndNulls$5((String) obj);
                return lambda$filterBlanksAndNulls$5;
            }
        });
        list = Collectors.toList();
        collect = filter.collect(list);
        return (List) collect;
    }

    static ConfigProperties get() {
        return new ConfigProperties(System.getProperties(), System.getenv());
    }

    private static TimeUnit getDurationUnit(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 0:
                if (str.equals("")) {
                    c16 = 0;
                    break;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    c16 = 1;
                    break;
                }
                break;
            case 104:
                if (str.equals(tl.h.F)) {
                    c16 = 2;
                    break;
                }
                break;
            case 109:
                if (str.equals(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) {
                    c16 = 3;
                    break;
                }
                break;
            case 115:
                if (str.equals(ReportConstant.COSTREPORT_PREFIX)) {
                    c16 = 4;
                    break;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 5:
                return TimeUnit.MILLISECONDS;
            case 1:
                return TimeUnit.DAYS;
            case 2:
                return TimeUnit.HOURS;
            case 3:
                return TimeUnit.MINUTES;
            case 4:
                return TimeUnit.SECONDS;
            default:
                throw new ConfigurationException("Invalid duration string, found: " + str);
        }
    }

    private static String getUnitString(String str) {
        int length = str.length() - 1;
        while (length >= 0 && !Character.isDigit(str.charAt(length))) {
            length--;
        }
        return str.substring(length + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$filterBlanksAndNulls$5(String str) {
        return !str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getCommaSeparatedMap$2(String str) {
        return filterBlanksAndNulls(str.split(ContainerUtils.KEY_VALUE_DELIMITER, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMap.SimpleImmutableEntry lambda$getCommaSeparatedMap$3(String str, List list) {
        if (list.size() == 2) {
            return new AbstractMap.SimpleImmutableEntry((String) list.get(0), (String) list.get(1));
        }
        throw new ConfigurationException("Invalid map property: " + str + ContainerUtils.KEY_VALUE_DELIMITER + this.config.get(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Map map, String str, String str2) {
        map.put(str.toLowerCase(Locale.ROOT).replace(util.base64_pad_url, '.'), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(Map map, Object obj, Object obj2) {
        map.put(((String) obj).toLowerCase(Locale.ROOT).replace('-', '.'), (String) obj2);
    }

    private static ConfigurationException newInvalidPropertyException(String str, String str2, String str3) {
        throw new ConfigurationException("Invalid value for property " + str + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ". Must be a " + str3 + ".");
    }

    public boolean getBoolean(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        return Boolean.parseBoolean(this.config.get(str));
    }

    public Map<String, String> getCommaSeparatedMap(final String str) {
        Stream stream;
        Stream map;
        Stream map2;
        Collector map3;
        Object collect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            stream = getCommaSeparatedValues(str).stream();
            map = stream.map(new Function() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    List lambda$getCommaSeparatedMap$2;
                    lambda$getCommaSeparatedMap$2 = ConfigProperties.lambda$getCommaSeparatedMap$2((String) obj);
                    return lambda$getCommaSeparatedMap$2;
                }
            });
            map2 = map.map(new Function() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    AbstractMap.SimpleImmutableEntry lambda$getCommaSeparatedMap$3;
                    lambda$getCommaSeparatedMap$3 = ConfigProperties.this.lambda$getCommaSeparatedMap$3(str, (List) obj);
                    return lambda$getCommaSeparatedMap$3;
                }
            });
            map3 = Collectors.toMap(new Function() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (String) ((AbstractMap.SimpleImmutableEntry) obj).getKey();
                }
            }, new Function() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (String) ((AbstractMap.SimpleImmutableEntry) obj).getValue();
                }
            }, new BinaryOperator() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.i
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    String lambda$getCommaSeparatedMap$4;
                    lambda$getCommaSeparatedMap$4 = ConfigProperties.lambda$getCommaSeparatedMap$4((String) obj, (String) obj2);
                    return lambda$getCommaSeparatedMap$4;
                }
            }, new Supplier() { // from class: com.tencent.opentelemetry.sdk.autoconfigure.j
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new LinkedHashMap();
                }
            });
            collect = map2.collect(map3);
            return (Map) collect;
        }
        return (Map) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }

    public List<String> getCommaSeparatedValues(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        String str2 = this.config.get(str);
        if (str2 == null) {
            return Collections.emptyList();
        }
        return filterBlanksAndNulls(str2.split(","));
    }

    @Nullable
    public Double getDouble(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Double) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        String str2 = this.config.get(str);
        if (str2 != null && !str2.isEmpty()) {
            try {
                return Double.valueOf(Double.parseDouble(str2));
            } catch (NumberFormatException unused) {
                throw newInvalidPropertyException(str, str2, "double");
            }
        }
        return null;
    }

    @Nullable
    public Integer getInt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        String str2 = this.config.get(str);
        if (str2 != null && !str2.isEmpty()) {
            try {
                return Integer.valueOf(Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                throw newInvalidPropertyException(str, str2, "integer");
            }
        }
        return null;
    }

    @Nullable
    public Long getLong(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        String str2 = this.config.get(str);
        if (str2 != null && !str2.isEmpty()) {
            try {
                return Long.valueOf(Long.parseLong(str2));
            } catch (NumberFormatException unused) {
                throw newInvalidPropertyException(str, str2, PoiListCacheRecord.TIMESTAMP_TYPE);
            }
        }
        return null;
    }

    @Nullable
    public String getString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.config.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getCommaSeparatedMap$4(String str, String str2) {
        return str2;
    }
}
