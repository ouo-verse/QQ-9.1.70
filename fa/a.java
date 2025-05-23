package fa;

import com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView;
import com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0002\u0007\u0012B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lfa/a;", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "isSelect", "", "a", "", "beginIndex", "onSelectBegin", "selectIndex", "onSelectChanged", "onSelectEnd", "Lfa/a$b;", "Lfa/a$b;", "selectDataDelegate", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "b", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "selectViewModel", "c", "I", "maxIndex", "d", "minIndex", "e", "Z", "isSelected", "<init>", "(Lfa/a$b;Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;)V", "f", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements MediaRecyclerView.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b selectDataDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MediaSelectedViewModel selectViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int minIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lfa/a$b;", "", "", "globalPosition", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        LocalMediaInfo a(int globalPosition);
    }

    public a(b selectDataDelegate, MediaSelectedViewModel selectViewModel) {
        Intrinsics.checkNotNullParameter(selectDataDelegate, "selectDataDelegate");
        Intrinsics.checkNotNullParameter(selectViewModel, "selectViewModel");
        this.selectDataDelegate = selectDataDelegate;
        this.selectViewModel = selectViewModel;
        this.maxIndex = Integer.MIN_VALUE;
        this.minIndex = Integer.MAX_VALUE;
        this.isSelected = true;
    }

    @Override // com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView.d
    public void onSelectBegin(int beginIndex) {
        boolean z16 = true;
        QLog.d("MediaDragSelectHelper", 1, "[onSelectBegin] beginPosition = " + beginIndex);
        this.isSelected = false;
        this.minIndex = beginIndex;
        this.maxIndex = beginIndex;
        LocalMediaInfo a16 = this.selectDataDelegate.a(beginIndex);
        if (a16 != null) {
            int i3 = a16.selectStatus;
            if (i3 != 2 && i3 != 0) {
                z16 = false;
            }
            this.isSelected = z16;
            a(a16, z16);
        }
    }

    @Override // com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView.d
    public void onSelectChanged(int beginIndex, int selectIndex) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int i3;
        int coerceAtMost;
        int coerceAtMost2;
        int i16;
        QLog.d("MediaDragSelectHelper", 1, "[onSelectChanged] select from " + beginIndex + " to " + selectIndex);
        if (selectIndex < beginIndex) {
            int i17 = this.minIndex;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(selectIndex, i17);
            this.minIndex = coerceAtMost;
            if (selectIndex < i17 && selectIndex <= (i16 = i17 - 1)) {
                while (true) {
                    LocalMediaInfo a16 = this.selectDataDelegate.a(i16);
                    if (a16 != null) {
                        a(a16, this.isSelected);
                    }
                    if (i16 == selectIndex) {
                        break;
                    } else {
                        i16--;
                    }
                }
            }
            this.minIndex = selectIndex;
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.maxIndex, beginIndex);
            this.maxIndex = coerceAtMost2;
            return;
        }
        int i18 = this.maxIndex;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(selectIndex, i18);
        this.maxIndex = coerceAtLeast;
        if (selectIndex > i18 && (i3 = i18 + 1) <= selectIndex) {
            while (true) {
                LocalMediaInfo a17 = this.selectDataDelegate.a(i3);
                if (a17 != null) {
                    a(a17, this.isSelected);
                }
                if (i3 == selectIndex) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.maxIndex = selectIndex;
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(this.minIndex, beginIndex);
        this.minIndex = coerceAtLeast2;
    }

    @Override // com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView.d
    public void onSelectEnd() {
        QLog.d("MediaDragSelectHelper", 1, "[onSelectEnd]");
    }

    private final void a(LocalMediaInfo info, boolean isSelect) {
        if (isSelect) {
            int i3 = info.selectStatus;
            if (i3 == 2 || i3 == 0) {
                MediaSelectedViewModel.M1(this.selectViewModel, info, 0, 2, null);
                return;
            }
            return;
        }
        if (info.selectStatus == 1) {
            this.selectViewModel.X1(ea.a.c(info), info);
        }
    }
}
