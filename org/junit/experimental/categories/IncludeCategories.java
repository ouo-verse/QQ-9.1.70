package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.experimental.categories.Categories;
import org.junit.runner.manipulation.Filter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class IncludeCategories extends CategoryFilterFactory {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class IncludesAny extends Categories.CategoryFilter {
        public IncludesAny(List<Class<?>> list) {
            this(new HashSet(list));
        }

        @Override // org.junit.experimental.categories.Categories.CategoryFilter, org.junit.runner.manipulation.Filter
        public String describe() {
            return "includes " + super.describe();
        }

        public IncludesAny(Set<Class<?>> set) {
            super(true, set, true, null);
        }
    }

    @Override // org.junit.experimental.categories.CategoryFilterFactory
    protected Filter createFilter(List<Class<?>> list) {
        return new IncludesAny(list);
    }
}
