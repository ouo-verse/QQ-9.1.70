package com.tencent.qqnt.aio.bottombar.sectionbar.loader;

import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/loader/c;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "c", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface c {
    @NotNull
    ArrayList<BottomSectionBarBaseProcessor> a();

    @NotNull
    com.tencent.qqnt.aio.bottombar.sectionbar.report.b b();

    @NotNull
    ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> c();
}
