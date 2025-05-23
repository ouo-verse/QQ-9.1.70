package com.tencent.qqnt.qbasealbum.preview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseChildFragment;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/QAlbumPreviewChildFragment;", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseChildFragment;", "", "getLogTag", "", "th", "getContentLayoutId", "", "isUseDarkTextStatusBar", "Landroid/content/Context;", "context", "", "onAttach", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "previewMedias", UserInfo.SEX_FEMALE, "Z", "isFirstCreate", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;", "G", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewMode;", "previewMode", "Lcom/tencent/qqnt/qbasealbum/share/a;", "H", "Lkotlin/Lazy;", "yh", "()Lcom/tencent/qqnt/qbasealbum/share/a;", "shareDataViewModel", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "I", "getPreviewViewModel", "()Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "previewViewModel", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "J", "xh", "()Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "<init>", "()V", "K", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class QAlbumPreviewChildFragment extends QAlbumBaseChildFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> previewMedias;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFirstCreate;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private PreviewMode previewMode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareDataViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy previewViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/QAlbumPreviewChildFragment$a;", "", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/QAlbumPreviewChildFragment$b", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends OnBackPressedCallback {
        static IPatchRedirector $redirector_;

        b() {
            super(true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QAlbumPreviewChildFragment.this);
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QAlbumPreviewChildFragment.this.onBackEvent();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QAlbumPreviewChildFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isFirstCreate = true;
        this.previewMode = PreviewMode.NORMAL_MODE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.qbasealbum.share.a>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment$shareDataViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewChildFragment.this);
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
                FragmentActivity requireActivity = QAlbumPreviewChildFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return com.tencent.qqnt.qbasealbum.album.b.h(requireActivity);
            }
        });
        this.shareDataViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PreviewMediaViewModel>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment$previewViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewChildFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PreviewMediaViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.qbasealbum.album.b.c(QAlbumPreviewChildFragment.this) : (PreviewMediaViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.previewViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SelectedMediaViewModel>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment$selectedMediaViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewChildFragment.this);
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
                FragmentActivity requireActivity = QAlbumPreviewChildFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
            }
        });
        this.selectedMediaViewModel = lazy3;
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
        arrayList.add(new PreviewUserInteractionPart(this.previewMedias, this.previewMode, yh(), QAlbumPickerContext.f361201a.d()));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QAlbumChildPreviewFragment";
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment
    public boolean isUseDarkTextStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if (r4 == null) goto L12;
     */
    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseChildFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttach(@NotNull Context context) {
        PreviewMode previewMode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            previewMode = PreviewMode.values()[arguments.getInt("PARAM_PREVIEW_MODE", PreviewMode.NORMAL_MODE.ordinal())];
        }
        previewMode = PreviewMode.NORMAL_MODE;
        this.previewMode = previewMode;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new b());
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

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseChildFragment, com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, androidx.fragment.app.Fragment
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
        final Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPreviewChildFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.datahub.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.datahub.a it) {
                SelectedMediaViewModel xh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof com.tencent.qqnt.qbasealbum.datahub.p) {
                    com.tencent.qqnt.qbasealbum.datahub.p pVar = (com.tencent.qqnt.qbasealbum.datahub.p) it;
                    if (pVar.a().getSelectStatus() == 1) {
                        xh5 = QAlbumPreviewChildFragment.this.xh();
                        xh5.Z1(com.tencent.qqnt.qbasealbum.ktx.b.e(pVar.a()), pVar.a());
                    }
                }
                PreviewContentListenPart previewContentListenPart = (PreviewContentListenPart) com.tencent.qqnt.qbasealbum.ktx.a.a(QAlbumPreviewChildFragment.this, PreviewContentListenPart.class);
                if (previewContentListenPart != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    previewContentListenPart.G9(it);
                }
                PreviewUserInteractionPart previewUserInteractionPart = (PreviewUserInteractionPart) com.tencent.qqnt.qbasealbum.ktx.a.a(QAlbumPreviewChildFragment.this, PreviewUserInteractionPart.class);
                if (previewUserInteractionPart != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    previewUserInteractionPart.ca(it);
                }
            }
        };
        V.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QAlbumPreviewChildFragment.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseChildFragment
    public int th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }
}
