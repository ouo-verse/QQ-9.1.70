package com.tencent.mobileqq.app;

import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J \u0010\u000e\u001a\u00020\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\fH&J&\u0010\u0014\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0002H&J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/app/az;", "", "", "timestamp", "segmentFlag", "businessType", "fetchSeq", "", "c", "packageId", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ids", "g", "", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonTabEmojiInfo;", "commonTabInfoList", "", "shouldReverse", "e", "commonTabEmojiInfo", "hide", "d", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface az {
    void c(int timestamp, int segmentFlag, int businessType, int fetchSeq);

    void d(@NotNull CommonTabEmojiInfo commonTabEmojiInfo, int businessType, boolean hide);

    void e(@NotNull List<CommonTabEmojiInfo> commonTabInfoList, boolean shouldReverse, int businessType);

    void f(int packageId, int businessType);

    void g(@NotNull ArrayList<Integer> ids);
}
