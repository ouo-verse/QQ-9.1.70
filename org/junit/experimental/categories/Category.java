package org.junit.experimental.categories;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.validator.ValidateWith;

/* compiled from: P */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@ValidateWith(CategoryValidator.class)
/* loaded from: classes29.dex */
public @interface Category {
    Class<?>[] value();
}
