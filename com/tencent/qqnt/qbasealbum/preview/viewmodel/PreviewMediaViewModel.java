package com.tencent.qqnt.qbasealbum.preview.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ox3.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020&0*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "mediaLayoutPos", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "L1", "Landroid/view/View;", "v", "N1", "", "checkAnySelection", "M1", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "i", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "getSelectedMediaViewModel", "()Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "R1", "(Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;)V", "selectedMediaViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "P1", "()I", "setCurPreviewMediaLayoutPosition", "(I)V", "curPreviewMediaLayoutPosition", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "O1", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "curPreviewMedia", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel$b;", "D", "Landroidx/lifecycle/MutableLiveData;", "_seqNumberTextAttrsMutableLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "seqNumberTextAttrsLiveData", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PreviewMediaViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo curPreviewMedia;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _seqNumberTextAttrsMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> seqNumberTextAttrsLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curPreviewMediaLayoutPosition;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isChecked", "Ljava/lang/String;", "()Ljava/lang/String;", "numberText", "<init>", "(ZLjava/lang/String;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isChecked;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String numberText;

        public b(boolean z16, @NotNull String numberText) {
            Intrinsics.checkNotNullParameter(numberText, "numberText");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), numberText);
            } else {
                this.isChecked = z16;
                this.numberText = numberText;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.numberText;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isChecked;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.isChecked == bVar.isChecked && Intrinsics.areEqual(this.numberText, bVar.numberText)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.isChecked;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.numberText.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SeqNumberTextAttrs(isChecked=" + this.isChecked + ", numberText=" + this.numberText + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PreviewMediaViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._seqNumberTextAttrsMutableLiveData = mutableLiveData;
        this.seqNumberTextAttrsLiveData = mutableLiveData;
    }

    public final void L1(int mediaLayoutPos, @Nullable final LocalMediaInfo media) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, mediaLayoutPos, (Object) media);
            return;
        }
        a.c("PreviewMediaViewModel", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel$changeCurrentPreviewMedia$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "changeCurrentPreviewMedia media: " + LocalMediaInfo.this;
            }
        });
        if (media == null) {
            return;
        }
        this.curPreviewMediaLayoutPosition = mediaLayoutPos;
        this.curPreviewMedia = media;
        int i3 = 0;
        if (media.getSelectStatus() == 1) {
            int e16 = com.tencent.qqnt.qbasealbum.ktx.b.e(media);
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            if (selectedMediaViewModel != null) {
                i3 = selectedMediaViewModel.Q1();
            }
            this._seqNumberTextAttrsMutableLiveData.setValue(new b(true, String.valueOf(e16 + i3 + 1)));
            return;
        }
        this._seqNumberTextAttrsMutableLiveData.setValue(new b(false, ""));
    }

    public final boolean M1(@NotNull View v3, boolean checkAnySelection) {
        boolean z16;
        List<LocalMediaInfo> selectedMedia;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, v3, Boolean.valueOf(checkAnySelection))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (checkAnySelection) {
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            if (selectedMediaViewModel != null && (selectedMedia = selectedMediaViewModel.getSelectedMedia()) != null && selectedMedia.size() == 0) {
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
        if (localMediaInfo.getSelectStatus() != 1) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.h(localMediaInfo) == 0) {
                com.tencent.qqnt.qbasealbum.base.model.a a16 = QAlbumPickerContext.f361201a.g().a();
                PageType pageType = PageType.LOCAL_ALL;
                SelectedMediaViewModel selectedMediaViewModel2 = this.selectedMediaViewModel;
                Intrinsics.checkNotNull(selectedMediaViewModel2);
                a16.a(v3, localMediaInfo, pageType, selectedMediaViewModel2);
            } else {
                com.tencent.qqnt.qbasealbum.filter.b bVar = com.tencent.qqnt.qbasealbum.filter.b.f361200a;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                bVar.a(context, com.tencent.qqnt.qbasealbum.ktx.b.h(localMediaInfo));
                return z17;
            }
        }
        z17 = false;
        return z17;
    }

    public final int N1(@NotNull View v3) {
        SelectedMediaViewModel selectedMediaViewModel;
        boolean z16;
        int i3;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3)).intValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.curPreviewMedia != null && (selectedMediaViewModel = this.selectedMediaViewModel) != null) {
            Intrinsics.checkNotNull(selectedMediaViewModel);
            AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = CustomizationFacade.f361084a.c();
            if (c16 != null && c16.checkMediaSelect(this.curPreviewMedia)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.qqnt.qbasealbum.base.model.a a16 = QAlbumPickerContext.f361201a.g().a();
                LocalMediaInfo localMediaInfo = this.curPreviewMedia;
                Intrinsics.checkNotNull(localMediaInfo);
                i3 = a16.a(v3, localMediaInfo, PageType.LOCAL_ALL, selectedMediaViewModel);
            } else {
                i3 = 0;
            }
            MutableLiveData<b> mutableLiveData = this._seqNumberTextAttrsMutableLiveData;
            if (i3 == 1) {
                bVar = new b(true, String.valueOf(selectedMediaViewModel.getSelectedMedia().size() + selectedMediaViewModel.Q1()));
            } else {
                bVar = new b(false, "");
            }
            mutableLiveData.setValue(bVar);
            return i3;
        }
        return 2;
    }

    @Nullable
    public final LocalMediaInfo O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.curPreviewMedia;
    }

    public final int P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.curPreviewMediaLayoutPosition;
    }

    @NotNull
    public final LiveData<b> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.seqNumberTextAttrsLiveData;
    }

    public final void R1(@Nullable SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectedMediaViewModel);
        } else {
            this.selectedMediaViewModel = selectedMediaViewModel;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "PreviewMediaViewModel";
    }
}
