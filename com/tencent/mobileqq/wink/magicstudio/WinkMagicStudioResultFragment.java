package com.tencent.mobileqq.wink.magicstudio;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart;
import com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioResultFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "enableRootViewSetFitsSystemWindows", "", "getContentLayoutId", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "qh", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magiStudioStyle", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "D", "rh", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originImage", "E", "th", "()Z", "isFromCamera", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", UserInfo.SEX_FEMALE, "sh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "resultViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "G", "ph", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "createViewModel", "<init>", "()V", "H", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultFragment extends ImmersivePartFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy magiStudioStyle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy originImage;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFromCamera;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy createViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioResultFragment$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioResultFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkMagicStudioResultFragment a(@Nullable Bundle bundle) {
            WinkMagicStudioResultFragment winkMagicStudioResultFragment = new WinkMagicStudioResultFragment();
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            winkMagicStudioResultFragment.setArguments(bundle2);
            return winkMagicStudioResultFragment;
        }

        Companion() {
        }
    }

    public WinkMagicStudioResultFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioPicStyle>() { // from class: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$magiStudioStyle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final MagicStudioPicStyle invoke() {
                Bundle arguments = WinkMagicStudioResultFragment.this.getArguments();
                return (MagicStudioPicStyle) (arguments != null ? arguments.getSerializable("magic_studio_pic_style") : null);
            }
        });
        this.magiStudioStyle = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LocalMediaInfo>() { // from class: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$originImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final LocalMediaInfo invoke() {
                Bundle arguments = WinkMagicStudioResultFragment.this.getArguments();
                return (LocalMediaInfo) (arguments != null ? arguments.getSerializable("origin_image") : null);
            }
        });
        this.originImage = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$isFromCamera$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Bundle arguments = WinkMagicStudioResultFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean(QQWinkConstants.IS_FROM_CAPTURE) : false);
            }
        });
        this.isFromCamera = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioMultiViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$resultViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioMultiViewModel invoke() {
                return (MagicStudioMultiViewModel) WinkMagicStudioResultFragment.this.getViewModel(MagicStudioMultiViewModel.class);
            }
        });
        this.resultViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment$createViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioCreationViewModel invoke() {
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) WinkMagicStudioResultFragment.this.getViewModel(MagicStudioCreationViewModel.class);
                magicStudioCreationViewModel.u3(true);
                return magicStudioCreationViewModel;
            }
        });
        this.createViewModel = lazy5;
    }

    private final MagicStudioCreationViewModel ph() {
        Object value = this.createViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createViewModel>(...)");
        return (MagicStudioCreationViewModel) value;
    }

    private final MagicStudioPicStyle qh() {
        return (MagicStudioPicStyle) this.magiStudioStyle.getValue();
    }

    private final LocalMediaInfo rh() {
        return (LocalMediaInfo) this.originImage.getValue();
    }

    private final MagicStudioMultiViewModel sh() {
        Object value = this.resultViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-resultViewModel>(...)");
        return (MagicStudioMultiViewModel) value;
    }

    private final boolean th() {
        return ((Boolean) this.isFromCamera.getValue()).booleanValue();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkMagicStudioResultButtonPart(qh(), rh()), new WinkMagicStudioResultPreviewPart(qh(), rh()));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5z;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        WinkMagicStudioUtils.f323888a.c(getActivity(), qh());
        return true;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            sh().m2(qh(), rh());
            MagicStudioCreationViewModel ph5 = ph();
            LocalMediaInfo rh5 = rh();
            if (rh5 != null) {
                str2 = rh5.path;
            } else {
                str2 = null;
            }
            ph5.p3(str2, qh(), th(), null, 1);
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        view.setPadding(0, RFWImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        m83.b bVar = m83.b.f416442a;
        FragmentActivity activity2 = getActivity();
        MagicStudioPicStyle qh5 = qh();
        if (qh5 == null || (str = qh5.getStyleId()) == null) {
            str = "";
        }
        bVar.x(activity2, view, true, str);
    }
}
