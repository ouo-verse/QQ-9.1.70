package com.tencent.qqnt.qbasealbum.album.view;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.view.MediaRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ,2\u00020\u0001:\u0001\u000bB?\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u001e\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/MediaDragSelectHelper;", "Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;", "", "beginIndex", "selectIndex", "", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "isSelect", "a", "onSelectBegin", "onSelectChanged", "onSelectEnd", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "logic", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mediaRecyclerView", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "c", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "", "d", "Ljava/util/List;", "mediaList", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "e", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "f", "I", "maxIndex", "g", "minIndex", tl.h.F, "Z", "isSelected", "<init>", "(Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qqnt/qbasealbum/model/PageType;Ljava/util/List;Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;)V", "i", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MediaDragSelectHelper implements MediaRecyclerView.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> logic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mediaRecyclerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageType pageType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> mediaList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maxIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int minIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/MediaDragSelectHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.view.MediaDragSelectHelper$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MediaDragSelectHelper(@Nullable AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPickerLogic, @NotNull RecyclerView mediaRecyclerView, @NotNull PageType pageType, @NotNull List<LocalMediaInfo> mediaList, @NotNull SelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaRecyclerView, "mediaRecyclerView");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, abstractPickerLogic, mediaRecyclerView, pageType, mediaList, selectedMediaViewModel);
            return;
        }
        this.logic = abstractPickerLogic;
        this.mediaRecyclerView = mediaRecyclerView;
        this.pageType = pageType;
        this.mediaList = mediaList;
        this.selectedMediaViewModel = selectedMediaViewModel;
        this.maxIndex = Integer.MIN_VALUE;
        this.minIndex = Integer.MAX_VALUE;
        this.isSelected = true;
    }

    private final void a(LocalMediaInfo info, boolean isSelect) {
        boolean z16;
        boolean z17;
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPickerLogic = this.logic;
        boolean z18 = false;
        if (abstractPickerLogic != null && !abstractPickerLogic.checkMediaSelect(info, this.isSelected, true)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        com.tencent.qqnt.qbasealbum.base.model.a a16 = QAlbumPickerContext.f361201a.g().a();
        if (info.getSelectStatus() != 2 && info.getSelectStatus() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (info.getSelectStatus() == 1) {
            z18 = true;
        }
        if ((isSelect && z17) || (!isSelect && z18)) {
            a16.a(this.mediaRecyclerView, info, this.pageType, this.selectedMediaViewModel);
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
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull2;
                if (localMediaInfo != null) {
                    a(localMediaInfo, this.isSelected);
                }
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
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) orNull;
                if (localMediaInfo2 != null) {
                    a(localMediaInfo2, this.isSelected);
                }
                if (i3 != selectIndex) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.view.MediaRecyclerView.d
    public void onSelectBegin(final int beginIndex) {
        boolean z16;
        Object orNull;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, beginIndex);
            return;
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPickerLogic = this.logic;
        boolean z17 = true;
        if (abstractPickerLogic != null && (photoCommonData = abstractPickerLogic.getPhotoCommonData()) != null && photoCommonData.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ox3.a.a("MediaDragSelectHelper", new Function0<String>(beginIndex) { // from class: com.tencent.qqnt.qbasealbum.album.view.MediaDragSelectHelper$onSelectBegin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $beginIndex;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$beginIndex = beginIndex;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, beginIndex);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "start select from" + this.$beginIndex;
            }
        });
        this.isSelected = false;
        this.minIndex = beginIndex;
        this.maxIndex = beginIndex;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, beginIndex);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            if (localMediaInfo.getSelectStatus() != 2 && localMediaInfo.getSelectStatus() != 0) {
                z17 = false;
            }
            this.isSelected = z17;
            a(localMediaInfo, z17);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.view.MediaRecyclerView.d
    public void onSelectChanged(final int beginIndex, final int selectIndex) {
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost2;
        Object orNull;
        Object orNull2;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(beginIndex), Integer.valueOf(selectIndex));
            return;
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPickerLogic = this.logic;
        if (abstractPickerLogic != null && (photoCommonData = abstractPickerLogic.getPhotoCommonData()) != null && photoCommonData.l()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ox3.a.a("MediaDragSelectHelper", new Function0<String>(beginIndex, selectIndex) { // from class: com.tencent.qqnt.qbasealbum.album.view.MediaDragSelectHelper$onSelectChanged$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $beginIndex;
            final /* synthetic */ int $selectIndex;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$beginIndex = beginIndex;
                this.$selectIndex = selectIndex;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(beginIndex), Integer.valueOf(selectIndex));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "select from " + this.$beginIndex + " to " + this.$selectIndex;
            }
        });
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(beginIndex, selectIndex);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(beginIndex, selectIndex);
        b(beginIndex, selectIndex);
        for (int i3 = this.minIndex; i3 < coerceAtMost; i3++) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i3);
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull2;
            if (localMediaInfo != null) {
                a(localMediaInfo, !this.isSelected);
            }
        }
        int i16 = coerceAtLeast + 1;
        int i17 = this.maxIndex;
        if (i16 <= i17) {
            while (true) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i16);
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) orNull;
                if (localMediaInfo2 != null) {
                    a(localMediaInfo2, !this.isSelected);
                }
                if (i16 == i17) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        if (selectIndex < beginIndex) {
            this.minIndex = selectIndex;
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.maxIndex, beginIndex);
            this.maxIndex = coerceAtMost2;
        } else {
            this.maxIndex = selectIndex;
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(this.minIndex, beginIndex);
            this.minIndex = coerceAtLeast2;
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.view.MediaRecyclerView.d
    public void onSelectEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ox3.a.a("MediaDragSelectHelper", MediaDragSelectHelper$onSelectEnd$1.INSTANCE);
        this.maxIndex = Integer.MIN_VALUE;
        this.minIndex = Integer.MAX_VALUE;
    }
}
