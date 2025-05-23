package com.tencent.mobileqq.wink.picker.core;

import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R$\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00128V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/d;", "", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "", "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "i", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/b;", "f", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "requestCode", "", "c", "value", "d", "()Z", "e", "(Z)V", "singleSelectMode", tl.h.F, "()I", "mediaViewHolderLayout", "Lcom/tencent/mobileqq/wink/picker/core/a;", "a", "()Lcom/tencent/mobileqq/wink/picker/core/a;", "mediaItemClickListener", "Lcom/tencent/mobileqq/wink/picker/core/m;", "b", "()Lcom/tencent/mobileqq/wink/picker/core/m;", "performanceMonitorCallback", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface d {
    @NotNull
    com.tencent.mobileqq.wink.picker.core.a a();

    @Nullable
    m b();

    boolean c(int requestCode);

    /* renamed from: d */
    boolean getSingleSelectMode();

    void e(boolean z16);

    @NotNull
    b f(@NotNull View itemView, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel);

    @NotNull
    List<Part> g();

    int h();

    @Nullable
    com.tencent.mobileqq.wink.picker.core.adapter.c i(@NotNull WinkMediaListPart mediaListPart, int mediaViewHolderSize);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        @Nullable
        public static com.tencent.mobileqq.wink.picker.core.adapter.c a(@NotNull d dVar, @NotNull WinkMediaListPart mediaListPart, int i3) {
            Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
            return null;
        }

        public static boolean b(@NotNull d dVar) {
            return false;
        }

        public static boolean c(@NotNull d dVar, int i3) {
            return false;
        }

        public static void d(@NotNull d dVar, boolean z16) {
        }
    }
}
