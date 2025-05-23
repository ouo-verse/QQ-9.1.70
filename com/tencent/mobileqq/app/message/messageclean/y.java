package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.hippy.qq.utils.HippyReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "storage-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface y {
    void clearCache();

    long getClearSize();

    @NotNull
    ArrayList<String> getWhiteList();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        public static long b(@NotNull y yVar) {
            return 0L;
        }

        @NotNull
        public static ArrayList<String> c(@NotNull y yVar) {
            return new ArrayList<>();
        }

        public static void a(@NotNull y yVar) {
        }
    }
}
