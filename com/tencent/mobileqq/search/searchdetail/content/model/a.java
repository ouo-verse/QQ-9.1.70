package com.tencent.mobileqq.search.searchdetail.content.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/a;", "", "", "isPlayable", "", "newState", "", "f", "isPlaying", "k4", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {

    /* renamed from: k4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f283905a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/a$a;", "", "Ljava/lang/Object;", "b", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "PAYLOAD_PLAY_STATE", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.model.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f283905a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Object PAYLOAD_PLAY_STATE = new Object();

        Companion() {
        }

        @NotNull
        public final Object a() {
            return PAYLOAD_PLAY_STATE;
        }
    }

    void f(int newState);

    boolean isPlayable();

    boolean isPlaying();
}
