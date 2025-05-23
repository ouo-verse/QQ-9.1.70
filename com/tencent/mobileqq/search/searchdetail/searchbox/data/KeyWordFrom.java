package com.tencent.mobileqq.search.searchdetail.searchbox.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/data/KeyWordFrom;", "", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes18.dex */
public @interface KeyWordFrom {
    public static final int CANCEL_CORRECTION = 5;
    public static final int CORRECTION_CHANGE = 4;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f284588a;
    public static final int HISTORY_RECORD_CLICK = 3;
    public static final int RELATE_SEARCH = 6;
    public static final int SEARCH_FROM_AUDIO_INPUT = 22;
    public static final int SEARCH_FROM_HINT = 21;
    public static final int SEARCH_FROM_LAST_RECORD = 7;
    public static final int SYSTEM_SUGGESTION = 2;
    public static final int UNKNOWN = 0;
    public static final int USER_INPUT = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/data/KeyWordFrom$a;", "", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.searchbox.data.KeyWordFrom$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f284588a = new Companion();

        Companion() {
        }
    }
}
