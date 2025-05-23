package com.tencent.mobileqq.wink.picker.qcircle;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.QCircleMediaMemAlbumFirstItemAdapter;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionActionPart;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionPreviewPart;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0010\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFactory;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaPickerFactory;", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "", "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "i", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "d", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "initBean", "", "e", "Z", "()Z", "(Z)V", "singleSelectMode", "Lcom/tencent/mobileqq/wink/picker/core/a;", "f", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/picker/core/a;", "mediaItemClickListener", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerFactory extends UniversalMediaPickerFactory {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean singleSelectMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaItemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaPickerFactory(@NotNull QCircleInitBean initBean) {
        super(true);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        e(uq3.k.a().c(QQWinkConstants.MMKV_QCIRCLE_SINGLE_SELECT_MODE, true));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QCircleMediaClickListener>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFactory$mediaItemClickListener$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleMediaClickListener invoke() {
                return new QCircleMediaClickListener();
            }
        });
        this.mediaItemClickListener = lazy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.a a() {
        return (com.tencent.mobileqq.wink.picker.core.a) this.mediaItemClickListener.getValue();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
    /* renamed from: d, reason: from getter */
    public boolean getSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
    public void e(boolean z16) {
        this.singleSelectMode = z16;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
    @NotNull
    public List<Part> g() {
        List<Part> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{new QCircleMediaPickerSelectionActionPart(this.initBean.getShowVideoTemplateButton(), "\u4e0b\u4e00\u6b65"), new QCircleMediaPickerSelectionPreviewPart()});
        return listOf;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
    @Nullable
    public com.tencent.mobileqq.wink.picker.core.adapter.c i(@NotNull WinkMediaListPart mediaListPart, int mediaViewHolderSize) {
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.g() && mediaListPart.getMediaType().isLocalMedia()) {
            return new QCircleMediaMemAlbumFirstItemAdapter(mediaListPart, mediaViewHolderSize);
        }
        return null;
    }
}
