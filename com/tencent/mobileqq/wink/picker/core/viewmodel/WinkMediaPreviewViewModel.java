package com.tencent.mobileqq.wink.picker.core.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaType;
import d93.c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 C2\u00020\u0001:\u0002DEB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010%\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R(\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020,008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\t008\u0006\u00a2\u0006\f\n\u0004\b:\u00102\u001a\u0004\b;\u00104R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00108R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\t008\u0006\u00a2\u0006\f\n\u0004\b>\u00102\u001a\u0004\b?\u00104\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "c2", "", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "Z1", "", "mediaLayoutPos", QAdVrReportParams.ParamKey.MEDIA, "N1", "Landroid/view/View;", "v", "P1", "", "checkAnySelection", "O1", "newMediaInfo", "b2", "<set-?>", "i", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "W1", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "T1", "()Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "I", "R1", "()I", "curPreviewMediaLayoutPosition", "D", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Q1", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "curPreviewMedia", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel$b;", "E", "Landroidx/lifecycle/MediatorLiveData;", "_seqNumberTextAttrs", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "seqNumberTextAttrs", "Landroidx/lifecycle/MutableLiveData;", "G", "Landroidx/lifecycle/MutableLiveData;", "_curPreviewMediaMutableLiveData", "H", "S1", "curPreviewMediaLiveData", "_selectMediaMutableLiveData", "J", "U1", "selectMediaLiveData", "<init>", "()V", "K", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaPreviewViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private int curPreviewMediaLayoutPosition;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo curPreviewMedia;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<SeqNumberTextAttrs> _seqNumberTextAttrs;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<SeqNumberTextAttrs> seqNumberTextAttrs;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LocalMediaInfo> _curPreviewMediaMutableLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<LocalMediaInfo> curPreviewMediaLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LocalMediaInfo> _selectMediaMutableLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<LocalMediaInfo> selectMediaLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends LocalMediaInfo> previewMedia;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isChecked", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "numberText", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "<init>", "(ZLjava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SeqNumberTextAttrs {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isChecked;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String numberText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final LocalMediaInfo media;

        public SeqNumberTextAttrs(boolean z16, @NotNull String numberText, @Nullable LocalMediaInfo localMediaInfo) {
            Intrinsics.checkNotNullParameter(numberText, "numberText");
            this.isChecked = z16;
            this.numberText = numberText;
            this.media = localMediaInfo;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final LocalMediaInfo getMedia() {
            return this.media;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getNumberText() {
            return this.numberText;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeqNumberTextAttrs)) {
                return false;
            }
            SeqNumberTextAttrs seqNumberTextAttrs = (SeqNumberTextAttrs) other;
            if (this.isChecked == seqNumberTextAttrs.isChecked && Intrinsics.areEqual(this.numberText, seqNumberTextAttrs.numberText) && Intrinsics.areEqual(this.media, seqNumberTextAttrs.media)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isChecked;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode2 = ((r06 * 31) + this.numberText.hashCode()) * 31;
            LocalMediaInfo localMediaInfo = this.media;
            if (localMediaInfo == null) {
                hashCode = 0;
            } else {
                hashCode = localMediaInfo.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SeqNumberTextAttrs(isChecked=" + this.isChecked + ", numberText=" + this.numberText + ", media=" + this.media + ")";
        }
    }

    public WinkMediaPreviewViewModel() {
        List<? extends LocalMediaInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.previewMedia = emptyList;
        this.curPreviewMediaLayoutPosition = -1;
        MediatorLiveData<SeqNumberTextAttrs> mediatorLiveData = new MediatorLiveData<>();
        this._seqNumberTextAttrs = mediatorLiveData;
        this.seqNumberTextAttrs = mediatorLiveData;
        MutableLiveData<LocalMediaInfo> mutableLiveData = new MutableLiveData<>();
        this._curPreviewMediaMutableLiveData = mutableLiveData;
        this.curPreviewMediaLiveData = mutableLiveData;
        MutableLiveData<LocalMediaInfo> mutableLiveData2 = new MutableLiveData<>();
        this._selectMediaMutableLiveData = mutableLiveData2;
        this.selectMediaLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2() {
        LocalMediaInfo localMediaInfo = this.curPreviewMedia;
        if (localMediaInfo != null) {
            int i3 = 0;
            if (localMediaInfo.selectStatus == 1) {
                MediatorLiveData<SeqNumberTextAttrs> mediatorLiveData = this._seqNumberTextAttrs;
                int p16 = e93.i.p(localMediaInfo);
                WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
                if (winkSelectedMediaViewModel != null) {
                    i3 = winkSelectedMediaViewModel.getAlreadySelectedMediaCount();
                }
                mediatorLiveData.setValue(new SeqNumberTextAttrs(true, String.valueOf(p16 + i3 + 1), localMediaInfo));
                return;
            }
            this._seqNumberTextAttrs.setValue(new SeqNumberTextAttrs(false, "", localMediaInfo));
        }
    }

    public final void N1(int mediaLayoutPos, @Nullable LocalMediaInfo media) {
        if (media == null) {
            return;
        }
        w53.b.f("WinkMediaPreviewViewModel", "[changeCurrentPreviewMedia] curPreviewMediaLayoutPosition=" + this.curPreviewMediaLayoutPosition + ", mediaLayoutPos=" + mediaLayoutPos);
        if (this.curPreviewMediaLayoutPosition == mediaLayoutPos) {
            return;
        }
        this.curPreviewMediaLayoutPosition = mediaLayoutPos;
        this.curPreviewMedia = media;
        this._curPreviewMediaMutableLiveData.setValue(media);
        c2();
    }

    public final boolean O1(@NotNull View v3, boolean checkAnySelection) {
        boolean z16;
        List<LocalMediaInfo> selectedMedia;
        Intrinsics.checkNotNullParameter(v3, "v");
        boolean z17 = true;
        if (checkAnySelection) {
            WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
            if (winkSelectedMediaViewModel != null && (selectedMedia = winkSelectedMediaViewModel.getSelectedMedia()) != null && selectedMedia.size() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        LocalMediaInfo localMediaInfo = this.curPreviewMedia;
        if (localMediaInfo == null) {
            return false;
        }
        if (localMediaInfo.selectStatus != 1) {
            if (e93.i.x(localMediaInfo) == 0) {
                com.tencent.mobileqq.wink.picker.core.a d16 = com.tencent.mobileqq.wink.picker.core.c.f324480a.d();
                MediaType mediaType = MediaType.LOCAL_ALL;
                WinkSelectedMediaViewModel winkSelectedMediaViewModel2 = this.selectedMediaViewModel;
                Intrinsics.checkNotNull(winkSelectedMediaViewModel2);
                d16.a(v3, localMediaInfo, mediaType, winkSelectedMediaViewModel2);
            } else {
                c.Companion companion = d93.c.INSTANCE;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                companion.a(context, e93.i.x(localMediaInfo));
                return z17;
            }
        }
        z17 = false;
        return z17;
    }

    public final void P1(@NotNull View v3) {
        WinkSelectedMediaViewModel winkSelectedMediaViewModel;
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.curPreviewMedia != null && (winkSelectedMediaViewModel = this.selectedMediaViewModel) != null) {
            Intrinsics.checkNotNull(winkSelectedMediaViewModel);
            com.tencent.mobileqq.wink.picker.core.a d16 = com.tencent.mobileqq.wink.picker.core.c.f324480a.d();
            LocalMediaInfo localMediaInfo = this.curPreviewMedia;
            Intrinsics.checkNotNull(localMediaInfo);
            if (d16.a(v3, localMediaInfo, MediaType.LOCAL_ALL, winkSelectedMediaViewModel) == 1) {
                this._seqNumberTextAttrs.setValue(new SeqNumberTextAttrs(true, String.valueOf(winkSelectedMediaViewModel.getSelectedMedia().size() + winkSelectedMediaViewModel.getAlreadySelectedMediaCount()), this.curPreviewMedia));
            } else {
                this._seqNumberTextAttrs.setValue(new SeqNumberTextAttrs(false, "", this.curPreviewMedia));
            }
        }
    }

    @Nullable
    /* renamed from: Q1, reason: from getter */
    public final LocalMediaInfo getCurPreviewMedia() {
        return this.curPreviewMedia;
    }

    /* renamed from: R1, reason: from getter */
    public final int getCurPreviewMediaLayoutPosition() {
        return this.curPreviewMediaLayoutPosition;
    }

    @NotNull
    public final LiveData<LocalMediaInfo> S1() {
        return this.curPreviewMediaLiveData;
    }

    @NotNull
    public final List<LocalMediaInfo> T1() {
        return this.previewMedia;
    }

    @NotNull
    public final LiveData<LocalMediaInfo> U1() {
        return this.selectMediaLiveData;
    }

    @Nullable
    /* renamed from: W1, reason: from getter */
    public final WinkSelectedMediaViewModel getSelectedMediaViewModel() {
        return this.selectedMediaViewModel;
    }

    @NotNull
    public final LiveData<SeqNumberTextAttrs> X1() {
        return this.seqNumberTextAttrs;
    }

    public final void Z1(@Nullable WinkSelectedMediaViewModel selectedMediaViewModel, @NotNull List<? extends LocalMediaInfo> previewMedia) {
        LiveData<e93.a> Z1;
        Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
        this.selectedMediaViewModel = selectedMediaViewModel;
        this.previewMedia = previewMedia;
        if (selectedMediaViewModel != null && (Z1 = selectedMediaViewModel.Z1()) != null) {
            this._seqNumberTextAttrs.removeSource(Z1);
            MediatorLiveData<SeqNumberTextAttrs> mediatorLiveData = this._seqNumberTextAttrs;
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel$init$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e93.a aVar) {
                    WinkMediaPreviewViewModel.this.c2();
                }
            };
            mediatorLiveData.addSource(Z1, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaPreviewViewModel.a2(Function1.this, obj);
                }
            });
        }
    }

    public final void b2(@NotNull LocalMediaInfo newMediaInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newMediaInfo, "newMediaInfo");
        String str = newMediaInfo.missionID;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && this.curPreviewMedia != null && this.selectedMediaViewModel != null) {
            if (e93.i.G(newMediaInfo)) {
                LocalMediaInfo localMediaInfo = this.curPreviewMedia;
                Intrinsics.checkNotNull(localMediaInfo);
                localMediaInfo.path = newMediaInfo.path;
                LocalMediaInfo localMediaInfo2 = this.curPreviewMedia;
                Intrinsics.checkNotNull(localMediaInfo2);
                localMediaInfo2.extData.clear();
            }
            LocalMediaInfo localMediaInfo3 = this.curPreviewMedia;
            Intrinsics.checkNotNull(localMediaInfo3);
            localMediaInfo3.missionID = newMediaInfo.missionID;
            LocalMediaInfo localMediaInfo4 = this.curPreviewMedia;
            Intrinsics.checkNotNull(localMediaInfo4);
            localMediaInfo4.thumbnailPath = newMediaInfo.thumbnailPath;
            LocalMediaInfo localMediaInfo5 = this.curPreviewMedia;
            Intrinsics.checkNotNull(localMediaInfo5);
            localMediaInfo5.mDuration = newMediaInfo.mDuration;
            HashMap<String, Serializable> hashMap = newMediaInfo.extData;
            if (hashMap != null) {
                LocalMediaInfo localMediaInfo6 = this.curPreviewMedia;
                Intrinsics.checkNotNull(localMediaInfo6);
                localMediaInfo6.extData.putAll(hashMap);
            }
            WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
            if (winkSelectedMediaViewModel != null) {
                Intrinsics.checkNotNull(winkSelectedMediaViewModel);
                winkSelectedMediaViewModel.i2(new e93.h(winkSelectedMediaViewModel.getSelectedMedia()));
            }
            LocalMediaInfo localMediaInfo7 = this.curPreviewMedia;
            Intrinsics.checkNotNull(localMediaInfo7);
            if (localMediaInfo7.selectStatus != 1) {
                this._selectMediaMutableLiveData.setValue(this.curPreviewMedia);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkMediaPreviewViewModel";
    }
}
