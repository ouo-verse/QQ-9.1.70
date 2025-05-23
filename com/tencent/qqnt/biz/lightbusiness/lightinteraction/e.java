package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import androidx.annotation.WorkerThread;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J6\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH'\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/e;", "", "", "uid", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "actionRes", "Lkotlin/Function1;", "", "doneCallback", "a", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface e {
    @WorkerThread
    void a(@NotNull String uid, @NotNull LIAActionItem item, @Nullable com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b actionRes, @NotNull Function1<? super Boolean, Unit> doneCallback);

    @WorkerThread
    boolean b(@NotNull String uid, @NotNull LIAActionItem item);
}
