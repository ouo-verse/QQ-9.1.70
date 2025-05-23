package com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J*\u0010\n\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "I", "", "", "", "coupleMap", "Lkotlin/Function0;", "", "finish", "a", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a<I extends IQQCoupleModel> {
    void a(@NotNull Map<String, ? extends I> coupleMap, @NotNull Function0<Unit> finish);
}
