package com.tencent.mobileqq.wink.picker.core.view;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 .2\u00020\u0001:\u0001\u000bB5\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020\u0001\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/view/a;", "Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView$c;", "", "beginIndex", "selectIndex", "", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "isSelect", "a", "_beginIndex", "onSelectBegin", "_selectIndex", "onSelectChanged", "onSelectEnd", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mediaRecyclerView", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "c", "Ljava/util/List;", "mediaList", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "d", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "e", "Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView$c;", "onDragSelectListener", "f", "I", "maxIndex", "g", "minIndex", tl.h.F, "Z", "isSelected", "i", "offsetIndex", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/wink/picker/MediaType;Ljava/util/List;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView$c;)V", "j", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements MediaRecyclerView.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mediaRecyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaType mediaType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> mediaList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaRecyclerView.c onDragSelectListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maxIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int minIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int offsetIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull RecyclerView mediaRecyclerView, @NotNull MediaType mediaType, @NotNull List<? extends LocalMediaInfo> mediaList, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel, @NotNull MediaRecyclerView.c onDragSelectListener) {
        Intrinsics.checkNotNullParameter(mediaRecyclerView, "mediaRecyclerView");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        Intrinsics.checkNotNullParameter(onDragSelectListener, "onDragSelectListener");
        this.mediaRecyclerView = mediaRecyclerView;
        this.mediaType = mediaType;
        this.mediaList = mediaList;
        this.selectedMediaViewModel = selectedMediaViewModel;
        this.onDragSelectListener = onDragSelectListener;
        this.maxIndex = Integer.MIN_VALUE;
        this.minIndex = Integer.MAX_VALUE;
        this.isSelected = true;
        this.offsetIndex = mediaRecyclerView.getAdapter() instanceof RFWConcatAdapter ? 1 : 0;
    }

    private final void a(LocalMediaInfo media, boolean isSelect) {
        if (media == null) {
            return;
        }
        if (isSelect) {
            int i3 = media.selectStatus;
            if (i3 == 2 || i3 == 0) {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.d().a(this.mediaRecyclerView, media, this.mediaType, this.selectedMediaViewModel);
                return;
            }
            return;
        }
        if (media.selectStatus == 1) {
            com.tencent.mobileqq.wink.picker.core.c.f324480a.d().a(this.mediaRecyclerView, media, this.mediaType, this.selectedMediaViewModel);
        }
    }

    private final void b(int beginIndex, int selectIndex) {
        int coerceAtLeast;
        int i3;
        Object orNull;
        int coerceAtMost;
        int i16;
        Object orNull2;
        if (selectIndex < beginIndex) {
            int i17 = this.minIndex;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(selectIndex, i17);
            this.minIndex = coerceAtMost;
            if (selectIndex >= i17 || selectIndex > i17 - 1) {
                return;
            }
            while (true) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i16);
                a((LocalMediaInfo) orNull2, this.isSelected);
                if (i16 != selectIndex) {
                    i16--;
                } else {
                    return;
                }
            }
        } else {
            int i18 = this.maxIndex;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(selectIndex, i18);
            this.maxIndex = coerceAtLeast;
            if (selectIndex <= i18 || (i3 = i18 + 1) > selectIndex) {
                return;
            }
            while (true) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i3);
                a((LocalMediaInfo) orNull, this.isSelected);
                if (i3 != selectIndex) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
    public void onSelectBegin(int _beginIndex) {
        Object orNull;
        int i3 = _beginIndex - this.offsetIndex;
        if (i3 < 0) {
            return;
        }
        this.onDragSelectListener.onSelectBegin(i3);
        QLog.d("MediaDragSelectHelper", 4, "start select from " + i3);
        boolean z16 = false;
        this.isSelected = false;
        this.minIndex = i3;
        this.maxIndex = i3;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i3);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            int i16 = localMediaInfo.selectStatus;
            if (i16 == 2 || i16 == 0) {
                z16 = true;
            }
            this.isSelected = z16;
            a(localMediaInfo, z16);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
    public void onSelectChanged(int _beginIndex, int _selectIndex) {
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost2;
        Object orNull;
        Object orNull2;
        int i3 = this.offsetIndex;
        int i16 = _beginIndex - i3;
        int i17 = _selectIndex - i3;
        if (i16 >= 0 && i17 >= 0) {
            this.onDragSelectListener.onSelectChanged(i16, i17);
            QLog.d("MediaDragSelectHelper", 4, "select from " + i16 + " to " + i17);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, i17);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, i17);
            b(i16, i17);
            for (int i18 = this.minIndex; i18 < coerceAtMost; i18++) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i18);
                a((LocalMediaInfo) orNull2, !this.isSelected);
            }
            int i19 = coerceAtLeast + 1;
            int i26 = this.maxIndex;
            if (i19 <= i26) {
                while (true) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i19);
                    a((LocalMediaInfo) orNull, !this.isSelected);
                    if (i19 == i26) {
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            if (i17 < i16) {
                this.minIndex = i17;
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.maxIndex, i16);
                this.maxIndex = coerceAtMost2;
            } else {
                this.maxIndex = i17;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(this.minIndex, i16);
                this.minIndex = coerceAtLeast2;
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
    public void onSelectEnd() {
        this.onDragSelectListener.onSelectEnd();
        QLog.d("MediaDragSelectHelper", 4, "finish select");
        this.maxIndex = Integer.MIN_VALUE;
        this.minIndex = Integer.MAX_VALUE;
    }
}
