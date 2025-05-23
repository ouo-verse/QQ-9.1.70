package com.tencent.sqshow.zootopia.samestyle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "", "page", "", "Q1", "", "positionMs", "", "isPlay", "S1", "R1", "O1", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_currentPage", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "currentPage", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel$b;", BdhLogUtil.LogTag.Tag_Conn, "_videoPlayState", "D", "N1", "videoPlayState", "<init>", "()V", "E", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TemplatePreviewViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<VideoPlayState> _videoPlayState;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<VideoPlayState> videoPlayState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> _currentPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Integer> currentPage;

    public TemplatePreviewViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._currentPage = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.currentPage = mutableLiveData;
        MutableLiveData<VideoPlayState> mutableLiveData2 = new MutableLiveData<>(new VideoPlayState(0L, true));
        this._videoPlayState = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel.VideoPlayState>");
        this.videoPlayState = mutableLiveData2;
    }

    public final LiveData<Integer> M1() {
        return this.currentPage;
    }

    public final LiveData<VideoPlayState> N1() {
        return this.videoPlayState;
    }

    public final void O1() {
        final VideoPlayState value = this._videoPlayState.getValue();
        if (value != null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel$pauseVideo$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = TemplatePreviewViewModel.this._videoPlayState;
                    TemplatePreviewViewModel.VideoPlayState it = value;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mutableLiveData.setValue(TemplatePreviewViewModel.VideoPlayState.b(it, 0L, false, 1, null));
                }
            });
        }
    }

    public final void P1() {
        final VideoPlayState value = this._videoPlayState.getValue();
        if (value != null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel$playVideo$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = TemplatePreviewViewModel.this._videoPlayState;
                    TemplatePreviewViewModel.VideoPlayState it = value;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mutableLiveData.setValue(TemplatePreviewViewModel.VideoPlayState.b(it, 0L, true, 1, null));
                }
            });
        }
    }

    public final void Q1(int page) {
        this._currentPage.postValue(Integer.valueOf(page));
    }

    public final void R1(final long positionMs) {
        final VideoPlayState value = this._videoPlayState.getValue();
        if (value != null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel$updateVideoPlayPosition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = TemplatePreviewViewModel.this._videoPlayState;
                    TemplatePreviewViewModel.VideoPlayState it = value;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mutableLiveData.setValue(TemplatePreviewViewModel.VideoPlayState.b(it, positionMs, false, 2, null));
                }
            });
        }
    }

    public final void S1(final long positionMs, final boolean isPlay) {
        final VideoPlayState value = this._videoPlayState.getValue();
        if (value != null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel$updateVideoPlayState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = TemplatePreviewViewModel.this._videoPlayState;
                    mutableLiveData.setValue(value.a(positionMs, isPlay));
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel$b;", "", "", "playPositionMs", "", "isPlay", "a", "", "toString", "", "hashCode", "other", "equals", "J", "c", "()J", "b", "Z", "d", "()Z", "<init>", "(JZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class VideoPlayState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long playPositionMs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPlay;

        public VideoPlayState(long j3, boolean z16) {
            this.playPositionMs = j3;
            this.isPlay = z16;
        }

        public final VideoPlayState a(long playPositionMs, boolean isPlay) {
            return new VideoPlayState(playPositionMs, isPlay);
        }

        /* renamed from: c, reason: from getter */
        public final long getPlayPositionMs() {
            return this.playPositionMs;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsPlay() {
            return this.isPlay;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = com.tencent.mobileqq.vas.banner.c.a(this.playPositionMs) * 31;
            boolean z16 = this.isPlay;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        public String toString() {
            return "VideoPlayState(playPositionMs=" + this.playPositionMs + ", isPlay=" + this.isPlay + ")";
        }

        public static /* synthetic */ VideoPlayState b(VideoPlayState videoPlayState, long j3, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = videoPlayState.playPositionMs;
            }
            if ((i3 & 2) != 0) {
                z16 = videoPlayState.isPlay;
            }
            return videoPlayState.a(j3, z16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoPlayState)) {
                return false;
            }
            VideoPlayState videoPlayState = (VideoPlayState) other;
            return this.playPositionMs == videoPlayState.playPositionMs && this.isPlay == videoPlayState.isPlay;
        }
    }
}
