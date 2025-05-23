package com.tencent.mobileqq.guild.aisearch.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/ChatAnswerItemState;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes12.dex */
public @interface ChatAnswerItemState {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f214110a;
    public static final int STATE_CONTENT_NORMAL = 4;
    public static final int STATE_ERROR = 6;
    public static final int STATE_ERROR_INFO_EMPTY = 10;
    public static final int STATE_ERROR_INFO_ERROR = 9;
    public static final int STATE_ERROR_REVERT = 7;
    public static final int STATE_ERROR_TIMEOUT = 8;
    public static final int STATE_FINISH = 5;
    public static final int STATE_FINISH_REASON = 3;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_REASON_NORMAL = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/ChatAnswerItemState$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.ChatAnswerItemState$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f214110a = new Companion();

        Companion() {
        }
    }
}
