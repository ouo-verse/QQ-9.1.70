package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0002\u0012\fB\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "", "", "key", "", "value", "c", "", "d", "", "b", "", "a", "Landroid/content/SharedPreferences$Editor;", "Landroid/content/SharedPreferences$Editor;", "editor", "<init>", "(Landroid/content/SharedPreferences$Editor;)V", "CommitRunnable", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AsyncSPEditor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SharedPreferences.Editor editor;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rmonitor/common/util/AsyncSPEditor$CommitRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Landroid/content/SharedPreferences$Editor;", "d", "Landroid/content/SharedPreferences$Editor;", "edit", "<init>", "(Lcom/tencent/rmonitor/common/util/AsyncSPEditor;Landroid/content/SharedPreferences$Editor;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public final class CommitRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final SharedPreferences.Editor edit;
        final /* synthetic */ AsyncSPEditor this$0;

        public CommitRunnable(@NotNull AsyncSPEditor asyncSPEditor, SharedPreferences.Editor edit) {
            Intrinsics.checkParameterIsNotNull(edit, "edit");
            this.this$0 = asyncSPEditor;
            this.edit = edit;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.edit.commit();
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_common_AsyncSPEditor", e16);
            }
        }
    }

    public AsyncSPEditor(@Nullable SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public final void a() {
        b();
    }

    public final boolean b() {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            ThreadManager.Companion.runInMonitorThread$default(ThreadManager.INSTANCE, new CommitRunnable(this, editor), 0L, 2, null);
            return true;
        }
        return true;
    }

    @NotNull
    public final AsyncSPEditor c(@NotNull String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            editor.putInt(key, value);
        }
        return this;
    }

    @NotNull
    public final AsyncSPEditor d(@NotNull String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            editor.putLong(key, value);
        }
        return this;
    }
}
