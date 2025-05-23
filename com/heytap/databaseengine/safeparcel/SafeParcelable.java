package com.heytap.databaseengine.safeparcel;

import android.os.Parcelable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
public interface SafeParcelable extends Parcelable {
    public static final int SAFE_PARCEL_OBJECT_MAGIC = 20293;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface Field {
        boolean mayNull() default false;

        Class subClass() default SafeParcelable.class;

        boolean useDirectList() default false;

        boolean useValueParcel() default false;

        int value();

        long versionCode() default -1;
    }
}
