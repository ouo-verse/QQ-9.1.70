package com.tencent.qqnt.qbasealbum.preview.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010+R*\u00102\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00105R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/QAlbumPreviewMainFragment;", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseFragment;", "", "initData", "", "getStatusBarColor", "", "isUseDarkTextStatusBar", "getContentLayoutId", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "D", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "E", "getPreviewViewModel", "()Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "previewViewModel", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/qqnt/qbasealbum/share/a;", "G", "yh", "()Lcom/tencent/qqnt/qbasealbum/share/a;", "shareDataViewModel", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "previewMedias", "", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "I", "Ljava/util/List;", "selectedMedia", "J", "previewStartPos", "K", "Z", "isFirstCreate", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QAlbumPreviewMainFragment extends QAlbumBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy previewViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String businessName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareDataViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> previewMedias;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<SelectMediaInfo> selectedMedia;

    /* renamed from: J, reason: from kotlin metadata */
    private int previewStartPos;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFirstCreate;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/QAlbumPreviewMainFragment$a", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends OnBackPressedCallback {
        static IPatchRedirector $redirector_;

        a() {
            super(true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QAlbumPreviewMainFragment.this.onBackEvent();
            }
        }
    }

    public QAlbumPreviewMainFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        List<SelectMediaInfo> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SelectedMediaViewModel>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment$selectedMediaViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SelectedMediaViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (SelectedMediaViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity requireActivity = QAlbumPreviewMainFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    return com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
                }
            });
            this.selectedMediaViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PreviewMediaViewModel>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment$previewViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final PreviewMediaViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.qbasealbum.album.b.c(QAlbumPreviewMainFragment.this) : (PreviewMediaViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.previewViewModel = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.qbasealbum.share.a>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment$shareDataViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.qqnt.qbasealbum.share.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.qbasealbum.share.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity requireActivity = QAlbumPreviewMainFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    return com.tencent.qqnt.qbasealbum.album.b.h(requireActivity);
                }
            });
            this.shareDataViewModel = lazy3;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.selectedMedia = emptyList;
            this.isFirstCreate = true;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void initData() {
        ArrayList<LocalMediaInfo> arrayList;
        int i3;
        ArrayList<LocalMediaInfo> e16;
        int collectionSizeOrDefault;
        ArrayList<LocalMediaInfo> a16;
        PreviewInitBean N1 = yh().N1();
        String str = null;
        if (N1 != null && (a16 = N1.a()) != null) {
            arrayList = new ArrayList<>(a16);
        } else {
            arrayList = null;
        }
        this.previewMedias = arrayList;
        if (N1 != null) {
            i3 = N1.c();
        } else {
            i3 = 0;
        }
        this.previewStartPos = i3;
        if (N1 != null && (e16 = N1.e()) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                arrayList2.add(SelectMediaInfo.INSTANCE.a((LocalMediaInfo) it.next(), com.tencent.qqnt.qbasealbum.model.a.f361348a.a()));
            }
            this.selectedMedia = arrayList2;
        }
        if (N1 != null) {
            str = N1.b();
        }
        this.businessName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectedMediaViewModel xh() {
        return (SelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    private final com.tencent.qqnt.qbasealbum.share.a yh() {
        return (com.tencent.qqnt.qbasealbum.share.a) this.shareDataViewModel.getValue();
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new PreviewContentListenPart());
        arrayList.add(new PreviewUserInteractionPart(this.previewMedias, PreviewMode.DIRECT_MODE, yh(), this.businessName));
        Part q16 = com.tencent.qqnt.qbasealbum.inject.g.f361234b.q();
        if (q16 != null) {
            arrayList.add(q16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.ft_;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment
    public int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment
    public boolean isUseDarkTextStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new a());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        HashMap<String, String> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!isAdded()) {
            return true;
        }
        LocalMediaDataHub.INSTANCE.a().m0();
        Intent intent = new Intent();
        AlbumResult albumResult = new AlbumResult();
        albumResult.l(false);
        albumResult.m(yh().O1());
        albumResult.o(new ArrayList(xh().getSelectedMedia()));
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a16 = CustomizationFacade.f361084a.a();
        if (a16 != null) {
            hashMap = a16.c();
        } else {
            hashMap = null;
        }
        albumResult.n(hashMap);
        Unit unit = Unit.INSTANCE;
        Intent putExtra = intent.putExtra("ALBUM_RESULT", albumResult);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(AlbumR\u2026a?.editPathMap\n        })");
        ox3.a.a("QBaseAlbum.MediaEdit", QAlbumPreviewMainFragment$onBackEvent$1.INSTANCE);
        for (LocalMediaInfo localMediaInfo : xh().getSelectedMedia()) {
            localMediaInfo.setSelectStatus(2);
            com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, 0);
        }
        requireActivity().setResult(-1, putExtra);
        requireActivity().finish();
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        initData();
        xh().c2(20);
        xh().b2(0);
        xh().T1(this.selectedMedia);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroy();
        LocalMediaDataHub.INSTANCE.a().e0();
        for (LocalMediaInfo localMediaInfo : xh().getSelectedMedia()) {
            localMediaInfo.setSelectStatus(2);
            com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, 0);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        setStatusBarTextColor();
        if (this.isFirstCreate) {
            this.isFirstCreate = false;
        } else {
            LocalMediaDataHub.INSTANCE.a().j0();
        }
        AbstractGifImage.resumeAll();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(R.color.black));
        LiveData<com.tencent.qqnt.qbasealbum.datahub.a> V = LocalMediaDataHub.INSTANCE.a().V();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.datahub.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.datahub.a it) {
                ArrayList arrayList;
                SelectedMediaViewModel xh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof com.tencent.qqnt.qbasealbum.datahub.p) {
                    com.tencent.qqnt.qbasealbum.datahub.p pVar = (com.tencent.qqnt.qbasealbum.datahub.p) it;
                    if (pVar.a().getSelectStatus() == 1) {
                        xh5 = QAlbumPreviewMainFragment.this.xh();
                        xh5.Z1(com.tencent.qqnt.qbasealbum.ktx.b.e(pVar.a()), pVar.a());
                    }
                    arrayList = QAlbumPreviewMainFragment.this.previewMedias;
                    if (arrayList != null) {
                        arrayList.remove(pVar.a());
                    }
                }
                PreviewContentListenPart previewContentListenPart = (PreviewContentListenPart) com.tencent.qqnt.qbasealbum.ktx.a.a(QAlbumPreviewMainFragment.this, PreviewContentListenPart.class);
                if (previewContentListenPart != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    previewContentListenPart.G9(it);
                }
                PreviewUserInteractionPart previewUserInteractionPart = (PreviewUserInteractionPart) com.tencent.qqnt.qbasealbum.ktx.a.a(QAlbumPreviewMainFragment.this, PreviewUserInteractionPart.class);
                if (previewUserInteractionPart != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    previewUserInteractionPart.ca(it);
                }
            }
        };
        V.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QAlbumPreviewMainFragment.onViewCreated$lambda$2(Function1.this, obj);
            }
        });
        LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1 = xh().S1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function12 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment$onViewCreated$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewMainFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                int i3 = 0;
                if (it instanceof com.tencent.qqnt.qbasealbum.select.model.f) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    QAlbumPreviewMainFragment qAlbumPreviewMainFragment = QAlbumPreviewMainFragment.this;
                    for (Object obj : ((com.tencent.qqnt.qbasealbum.select.model.f) it).a()) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                        localMediaInfo.setSelectStatus(1);
                        com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, i3);
                        i3 = i16;
                    }
                    PreviewUserInteractionPart previewUserInteractionPart = (PreviewUserInteractionPart) com.tencent.qqnt.qbasealbum.ktx.a.a(qAlbumPreviewMainFragment, PreviewUserInteractionPart.class);
                    if (previewUserInteractionPart != null) {
                        previewUserInteractionPart.ta();
                        return;
                    }
                    return;
                }
                if (it instanceof com.tencent.qqnt.qbasealbum.select.model.i) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    for (Object obj2 : ((com.tencent.qqnt.qbasealbum.select.model.i) it).a()) {
                        int i17 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        com.tencent.qqnt.qbasealbum.ktx.b.s((LocalMediaInfo) obj2, i3);
                        i3 = i17;
                    }
                    return;
                }
                if (it instanceof com.tencent.qqnt.qbasealbum.select.model.b) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    com.tencent.qqnt.qbasealbum.select.model.b bVar = (com.tencent.qqnt.qbasealbum.select.model.b) it;
                    bVar.a().setSelectStatus(1);
                    com.tencent.qqnt.qbasealbum.ktx.b.s(bVar.a(), bVar.b());
                    return;
                }
                if (it instanceof com.tencent.qqnt.qbasealbum.select.model.h) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    com.tencent.qqnt.qbasealbum.select.model.h hVar = (com.tencent.qqnt.qbasealbum.select.model.h) it;
                    hVar.b().setSelectStatus(2);
                    for (Object obj3 : hVar.c()) {
                        int i18 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        com.tencent.qqnt.qbasealbum.ktx.b.s((LocalMediaInfo) obj3, i3);
                        i3 = i18;
                    }
                }
            }
        };
        S1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QAlbumPreviewMainFragment.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
    }
}
