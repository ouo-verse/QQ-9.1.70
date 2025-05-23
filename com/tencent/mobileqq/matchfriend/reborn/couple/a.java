package com.tencent.mobileqq.matchfriend.reborn.couple;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H'\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "", "", "coupleList", "", "a", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a<T extends IQQCoupleModel> {
    @WorkerThread
    void a(@NotNull List<? extends T> coupleList);
}
