package org.junit.runner;

import com.huawei.hms.framework.common.ContainerUtils;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.manipulation.Filter;

/* compiled from: P */
/* loaded from: classes29.dex */
class FilterFactories {
    FilterFactories() {
    }

    public static Filter createFilter(String str, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return createFilterFactory(str).createFilter(filterFactoryParams);
    }

    static FilterFactory createFilterFactory(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return createFilterFactory((Class<? extends FilterFactory>) Classes.getClass(str).asSubclass(FilterFactory.class));
        } catch (Exception e16) {
            throw new FilterFactory.FilterNotCreatedException(e16);
        }
    }

    public static Filter createFilterFromFilterSpec(Request request, String str) throws FilterFactory.FilterNotCreatedException {
        String[] strArr;
        Description description = request.getRunner().getDescription();
        if (str.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
            strArr = str.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
        } else {
            strArr = new String[]{str, ""};
        }
        return createFilter(strArr[0], new FilterFactoryParams(description, strArr[1]));
    }

    public static Filter createFilter(Class<? extends FilterFactory> cls, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return createFilterFactory(cls).createFilter(filterFactoryParams);
    }

    static FilterFactory createFilterFactory(Class<? extends FilterFactory> cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            throw new FilterFactory.FilterNotCreatedException(e16);
        }
    }
}
