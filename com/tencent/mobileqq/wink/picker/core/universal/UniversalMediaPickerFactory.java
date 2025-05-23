package com.tencent.mobileqq.wink.picker.core.universal;

import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.core.d;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\f\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaPickerFactory;", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/b;", "f", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "", "a", "Z", "enableVideoTemplate", "", "b", "I", tl.h.F, "()I", "mediaViewHolderLayout", "Lcom/tencent/mobileqq/wink/picker/core/a;", "c", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/wink/picker/core/a;", "mediaItemClickListener", "Lcom/tencent/mobileqq/wink/picker/core/m;", "performanceMonitorCallback", "Lcom/tencent/mobileqq/wink/picker/core/m;", "()Lcom/tencent/mobileqq/wink/picker/core/m;", "<init>", "(Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class UniversalMediaPickerFactory implements com.tencent.mobileqq.wink.picker.core.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVideoTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mediaViewHolderLayout = R.layout.i68;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaItemClickListener;

    public UniversalMediaPickerFactory(boolean z16) {
        Lazy lazy;
        this.enableVideoTemplate = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<UniversalMediaItemClickListener>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory$mediaItemClickListener$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UniversalMediaItemClickListener invoke() {
                return new UniversalMediaItemClickListener();
            }
        });
        this.mediaItemClickListener = lazy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.a a() {
        return (com.tencent.mobileqq.wink.picker.core.a) this.mediaItemClickListener.getValue();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @Nullable
    public com.tencent.mobileqq.wink.picker.core.m b() {
        return null;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    public boolean c(int i3) {
        return d.a.c(this, i3);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    /* renamed from: d */
    public boolean getSingleSelectMode() {
        return d.a.b(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    public void e(boolean z16) {
        d.a.d(this, z16);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.b f(@NotNull View itemView, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        return new q(itemView, selectedMediaViewModel);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public List<Part> g() {
        List<Part> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{new UniversalMediaSelectionActionPart(this.enableVideoTemplate, null, 2, 0 == true ? 1 : 0), new UniversalMediaSelectionPreviewPart()});
        return listOf;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    /* renamed from: h, reason: from getter */
    public int getMediaViewHolderLayout() {
        return this.mediaViewHolderLayout;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @Nullable
    public com.tencent.mobileqq.wink.picker.core.adapter.c i(@NotNull WinkMediaListPart winkMediaListPart, int i3) {
        return d.a.a(this, winkMediaListPart, i3);
    }
}
