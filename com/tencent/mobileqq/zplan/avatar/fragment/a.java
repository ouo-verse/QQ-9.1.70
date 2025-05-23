package com.tencent.mobileqq.zplan.avatar.fragment;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J,\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004H&J\"\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", "", "", "prepare", "", "actionId", "status", "", "path", "a", "", "actionList", "batchCount", "c", "", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    void a(int actionId, int status, @Nullable String path);

    boolean b(@Nullable List<Integer> actionList, int batchCount);

    @Nullable
    List<Integer> c(@Nullable List<Integer> actionList, int batchCount);

    void prepare();
}
