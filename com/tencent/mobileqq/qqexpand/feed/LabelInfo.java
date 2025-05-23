package com.tencent.mobileqq.qqexpand.feed;

import android.graphics.drawable.Drawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes35.dex */
public class LabelInfo {

    /* renamed from: a, reason: collision with root package name */
    public int f263546a;

    /* renamed from: b, reason: collision with root package name */
    public String f263547b;

    /* renamed from: c, reason: collision with root package name */
    public String f263548c;

    /* renamed from: d, reason: collision with root package name */
    public String f263549d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f263550e;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes35.dex */
    public @interface LabelType {
        public static final int FEMALE = 0;
        public static final int MALE = 1;
        public static final int PERSONALITY = 3;
        public static final int POPULARITY = 2;
    }
}
