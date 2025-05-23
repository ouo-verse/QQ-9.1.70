package com.tencent.mobileqq.wink.picker.qzone;

import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.core.d;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaSelectionPanelPart;
import com.tencent.mobileqq.wink.picker.qzone.part.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010!R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0016\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPickerFactory;", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "", "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "i", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/b;", "f", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "a", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "initBean", "", "b", "Z", "needShowFirstRecommendItem", "c", "I", tl.h.F, "()I", "mediaViewHolderLayout", "Lcom/tencent/mobileqq/wink/picker/core/a;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/wink/picker/core/a;", "mediaItemClickListener", "Lcom/tencent/mobileqq/wink/picker/core/m;", "performanceMonitorCallback", "Lcom/tencent/mobileqq/wink/picker/core/m;", "()Lcom/tencent/mobileqq/wink/picker/core/m;", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPickerFactory implements com.tencent.mobileqq.wink.picker.core.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QZoneInitBean initBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean needShowFirstRecommendItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int mediaViewHolderLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaItemClickListener;

    public QZoneMediaPickerFactory(@NotNull QZoneInitBean initBean, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.needShowFirstRecommendItem = z16;
        this.mediaViewHolderLayout = R.layout.i68;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneMediaItemClickListener>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFactory$mediaItemClickListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QZoneMediaItemClickListener invoke() {
                QZoneInitBean qZoneInitBean;
                qZoneInitBean = QZoneMediaPickerFactory.this.initBean;
                return new QZoneMediaItemClickListener(qZoneInitBean);
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
        return new com.tencent.mobileqq.wink.picker.core.universal.q(itemView, selectedMediaViewModel);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public List<Part> g() {
        ArrayList arrayList = new ArrayList();
        if (this.initBean.getShowSelectionPreview()) {
            arrayList.add(new QZoneMediaSelectionPanelPart(this.initBean));
            arrayList.add(new UniversalMediaSelectionPreviewPart());
        } else {
            arrayList.add(new QZoneMediaSelectionPanelPart(this.initBean));
        }
        if (this.initBean.getShowTitlePublishMoodBtn()) {
            arrayList.add(new u(this.initBean));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    /* renamed from: h, reason: from getter */
    public int getMediaViewHolderLayout() {
        return this.mediaViewHolderLayout;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.d
    @Nullable
    public com.tencent.mobileqq.wink.picker.core.adapter.c i(@NotNull WinkMediaListPart mediaListPart, int mediaViewHolderSize) {
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        if (this.needShowFirstRecommendItem && mediaListPart.getMediaType().isLocalMedia()) {
            return new QZoneMediaFirstItemAdapter(mediaListPart, mediaViewHolderSize);
        }
        return null;
    }
}
