package org.junit.runner;

import org.junit.runner.manipulation.Filter;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FilterFactory {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FilterNotCreatedException extends Exception {
        public FilterNotCreatedException(Exception exc) {
            super(exc.getMessage(), exc);
        }
    }

    Filter createFilter(FilterFactoryParams filterFactoryParams) throws FilterNotCreatedException;
}
