package com.tencent.mobileqq.pymk.api;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKTotalData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/a;", "", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recommendData", "", "isEnd", "", "d", "Lcom/tencent/mobileqq/pymk/api/c;", "data", "e", "", "uin", "c", "eTag", "b", "Lcom/tencent/mobileqq/data/PYMKTotalData;", "totalInfo", "a", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {
    void a(@NotNull PYMKTotalData totalInfo);

    void b(@Nullable String eTag);

    void c(@NotNull String uin);

    void d(@NotNull List<? extends MayKnowRecommend> recommendData, boolean isEnd);

    void e(@NotNull c data);
}
