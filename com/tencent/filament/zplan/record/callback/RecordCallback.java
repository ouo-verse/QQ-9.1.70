package com.tencent.filament.zplan.record.callback;

import androidx.annotation.Keep;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/filament/zplan/record/callback/RecordCallback;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "getTaskId", "()I", "onRecordFrame", "", "data", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface RecordCallback {
    int getTaskId();

    void onRecordFrame(@NotNull String data);
}
