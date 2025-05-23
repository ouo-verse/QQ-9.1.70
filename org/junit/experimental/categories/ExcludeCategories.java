package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.experimental.categories.Categories;
import org.junit.runner.manipulation.Filter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExcludeCategories extends CategoryFilterFactory {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ExcludesAny extends Categories.CategoryFilter {
        public ExcludesAny(List<Class<?>> list) {
            this(new HashSet(list));
        }

        @Override // org.junit.experimental.categories.Categories.CategoryFilter, org.junit.runner.manipulation.Filter
        public String describe() {
            return "excludes " + super.describe();
        }

        public ExcludesAny(Set<Class<?>> set) {
            super(true, null, true, set);
        }
    }

    @Override // org.junit.experimental.categories.CategoryFilterFactory
    protected Filter createFilter(List<Class<?>> list) {
        return new ExcludesAny(list);
    }
}
