package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Categories extends Suite {

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes29.dex */
    public @interface ExcludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes29.dex */
    public @interface IncludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    public Categories(Class<?> cls, RunnerBuilder runnerBuilder) throws InitializationError {
        super(cls, runnerBuilder);
        try {
            filter(CategoryFilter.categoryFilter(isAnyIncluded(cls), getIncludedCategory(cls), isAnyExcluded(cls), getExcludedCategory(cls)));
            assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
        } catch (NoTestsRemainException e16) {
            throw new InitializationError(e16);
        }
    }

    private static void assertNoCategorizedDescendentsOfUncategorizeableParents(Description description) throws InitializationError {
        if (!canHaveCategorizedChildren(description)) {
            assertNoDescendantsHaveCategoryAnnotations(description);
        }
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            assertNoCategorizedDescendentsOfUncategorizeableParents(it.next());
        }
    }

    private static void assertNoDescendantsHaveCategoryAnnotations(Description description) throws InitializationError {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description next = it.next();
            if (next.getAnnotation(Category.class) == null) {
                assertNoDescendantsHaveCategoryAnnotations(next);
            } else {
                throw new InitializationError("Category annotations on Parameterized classes are not supported on individual methods.");
            }
        }
    }

    private static boolean canHaveCategorizedChildren(Description description) {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().getTestClass() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<Class<?>> createSet(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    private static Set<Class<?>> getExcludedCategory(Class<?> cls) {
        Class<?>[] value;
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        if (excludeCategory == null) {
            value = null;
        } else {
            value = excludeCategory.value();
        }
        return createSet(value);
    }

    private static Set<Class<?>> getIncludedCategory(Class<?> cls) {
        Class<?>[] value;
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        if (includeCategory == null) {
            value = null;
        } else {
            value = includeCategory.value();
        }
        return createSet(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasAssignableTo(Set<Class<?>> set, Class<?> cls) {
        Iterator<Class<?>> it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnyExcluded(Class<?> cls) {
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        if (excludeCategory != null && !excludeCategory.matchAny()) {
            return false;
        }
        return true;
    }

    private static boolean isAnyIncluded(Class<?> cls) {
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        if (includeCategory != null && !includeCategory.matchAny()) {
            return false;
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CategoryFilter extends Filter {
        private final Set<Class<?>> excluded;
        private final boolean excludedAny;
        private final Set<Class<?>> included;
        private final boolean includedAny;

        /* JADX INFO: Access modifiers changed from: protected */
        public CategoryFilter(boolean z16, Set<Class<?>> set, boolean z17, Set<Class<?>> set2) {
            this.includedAny = z16;
            this.excludedAny = z17;
            this.included = copyAndRefine(set);
            this.excluded = copyAndRefine(set2);
        }

        private static Set<Class<?>> categories(Description description) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, directCategories(description));
            Collections.addAll(hashSet, directCategories(parentDescription(description)));
            return hashSet;
        }

        public static CategoryFilter categoryFilter(boolean z16, Set<Class<?>> set, boolean z17, Set<Class<?>> set2) {
            return new CategoryFilter(z16, set, z17, set2);
        }

        private static Set<Class<?>> copyAndRefine(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove(null);
            return hashSet;
        }

        private static Class<?>[] directCategories(Description description) {
            if (description == null) {
                return new Class[0];
            }
            Category category = (Category) description.getAnnotation(Category.class);
            if (category == null) {
                return new Class[0];
            }
            return category.value();
        }

        public static CategoryFilter exclude(boolean z16, Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(true, null, z16, Categories.createSet(clsArr));
            }
            throw new NullPointerException("has null category");
        }

        private boolean hasCorrectCategoryAnnotation(Description description) {
            Set<Class<?>> categories = categories(description);
            if (categories.isEmpty()) {
                return this.included.isEmpty();
            }
            if (!this.excluded.isEmpty()) {
                if (this.excludedAny) {
                    if (matchesAnyParentCategories(categories, this.excluded)) {
                        return false;
                    }
                } else if (matchesAllParentCategories(categories, this.excluded)) {
                    return false;
                }
            }
            if (this.included.isEmpty()) {
                return true;
            }
            if (this.includedAny) {
                return matchesAnyParentCategories(categories, this.included);
            }
            return matchesAllParentCategories(categories, this.included);
        }

        private static boolean hasNull(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        public static CategoryFilter include(boolean z16, Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(z16, Categories.createSet(clsArr), true, null);
            }
            throw new NullPointerException("has null category");
        }

        private boolean matchesAllParentCategories(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (!Categories.hasAssignableTo(set, it.next())) {
                    return false;
                }
            }
            return true;
        }

        private boolean matchesAnyParentCategories(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (Categories.hasAssignableTo(set, it.next())) {
                    return true;
                }
            }
            return false;
        }

        private static Description parentDescription(Description description) {
            Class<?> testClass = description.getTestClass();
            if (testClass == null) {
                return null;
            }
            return Description.createSuiteDescription(testClass);
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return toString();
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            if (hasCorrectCategoryAnnotation(description)) {
                return true;
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (shouldRun(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            Object obj;
            StringBuilder sb5 = new StringBuilder("categories ");
            if (this.included.isEmpty()) {
                obj = "[all]";
            } else {
                obj = this.included;
            }
            sb5.append(obj);
            if (!this.excluded.isEmpty()) {
                sb5.append(" - ");
                sb5.append(this.excluded);
            }
            return sb5.toString();
        }

        public static CategoryFilter exclude(Class<?> cls) {
            return exclude(true, cls);
        }

        public static CategoryFilter include(Class<?> cls) {
            return include(true, cls);
        }

        public static CategoryFilter exclude(Class<?>... clsArr) {
            return exclude(true, clsArr);
        }

        public static CategoryFilter include(Class<?>... clsArr) {
            return include(true, clsArr);
        }
    }
}
