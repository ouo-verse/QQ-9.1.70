package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/e;", "Lcom/tencent/mobileqq/guild/feed/api/h;", "listener", "", "i", "", "mediumId", "Lcom/tencent/mobileqq/guild/data/o;", "info", "e", "", "uploadedSize", "totalSize", "c", "b", "d", tl.h.F, "f", "g", "a", "Ljava/lang/String;", "logTag", "parentId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "taskInfoChangeListeners", "", "j", "()Z", "hasSubscriber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements com.tencent.mobileqq.guild.feed.api.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String parentId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.feed.api.h> taskInfoChangeListeners;

    public e(@NotNull String logTag, @NotNull String parentId) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        this.logTag = logTag;
        this.parentId = parentId;
        this.taskInfoChangeListeners = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h, com.tencent.mobileqq.guild.feed.api.f
    public void a(@NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.a(info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void b(@NotNull String mediumId, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.b(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void c(@NotNull String mediumId, long uploadedSize, long totalSize, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.c(mediumId, uploadedSize, totalSize, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void d(@NotNull String mediumId, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.d(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void e(@NotNull String mediumId, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.e(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void f(@NotNull String mediumId, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.f(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void g(@NotNull String mediumId, @NotNull o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.g(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void h(@NotNull String mediumId, @Nullable o info) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        for (com.tencent.mobileqq.guild.feed.api.h listener : this.taskInfoChangeListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                listener.h(mediumId, info);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String str = this.logTag;
                String str2 = this.parentId;
                int hashCode = listener.hashCode();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e(str, 1, "[dispatchToListeners]: parentId=" + str2 + "listener.hashCode=" + hashCode + " has exception=" + stackTraceToString);
            }
        }
    }

    public final void i(@NotNull com.tencent.mobileqq.guild.feed.api.h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.taskInfoChangeListeners.add(listener);
    }

    public final boolean j() {
        return !this.taskInfoChangeListeners.isEmpty();
    }
}
