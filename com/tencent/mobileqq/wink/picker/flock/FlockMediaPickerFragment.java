package com.tencent.mobileqq.wink.picker.flock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b93.OutputData;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.p;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u001d\u0010!\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/flock/FlockMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "", "Ki", "Mi", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaPickerFactory;", "Ji", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "", "getLogTag", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "Z", "Lkotlin/Lazy;", "Hi", "()Landroid/view/View;", "bottomGapView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "a0", "Ii", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "<init>", "()V", "b0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FlockMediaPickerFragment extends UniversalMediaPickerFragment implements FragmentPager.d {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomGapView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/flock/FlockMediaPickerFragment$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/picker/flock/FlockMediaPickerFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.flock.FlockMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FlockMediaPickerFragment a(@Nullable Config config) {
            FlockMediaPickerFragment flockMediaPickerFragment = new FlockMediaPickerFragment();
            flockMediaPickerFragment.setArguments(flockMediaPickerFragment.Eh(config, null));
            return flockMediaPickerFragment;
        }

        Companion() {
        }
    }

    public FlockMediaPickerFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.flock.FlockMediaPickerFragment$bottomGapView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = FlockMediaPickerFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.t9q);
                }
                return null;
            }
        });
        this.bottomGapView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.picker.flock.FlockMediaPickerFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                FragmentActivity requireActivity = FlockMediaPickerFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Hi() {
        return (View) this.bottomGapView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p Ii() {
        return (p) this.mediaPickerUIStateViewModel.getValue();
    }

    private final void Ki() {
        if (Ph().getAttachToWinkHome()) {
            LiveData<e93.a> Z1 = Wh().Z1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.flock.FlockMediaPickerFragment$setBottomGapViewVisibility$1
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
                    p Ii;
                    View Hi;
                    WinkSelectedMediaViewModel Wh;
                    View Hi2;
                    Ii = FlockMediaPickerFragment.this.Ii();
                    if (!Ii.O1()) {
                        Hi2 = FlockMediaPickerFragment.this.Hi();
                        if (Hi2 == null) {
                            return;
                        }
                        Hi2.setVisibility(8);
                        return;
                    }
                    Hi = FlockMediaPickerFragment.this.Hi();
                    if (Hi == null) {
                        return;
                    }
                    Wh = FlockMediaPickerFragment.this.Wh();
                    Hi.setVisibility(Wh.getSelectedMedia().isEmpty() ? 0 : 8);
                }
            };
            Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.flock.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FlockMediaPickerFragment.Li(Function1.this, obj);
                }
            });
        } else {
            View Hi = Hi();
            if (Hi != null) {
                Hi.setVisibility(8);
            }
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady()) {
            Ii().U1(false);
            w53.b.a("FlockMediaPickerFragment", "so\u672a\u5c31\u7eea\uff0c\u4e0d\u5c55\u793a\u5e95\u90e8\u680f");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Mi() {
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.wink.picker.flock.b
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                FlockMediaPickerFragment.Ni(FlockMediaPickerFragment.this);
            }
        });
        Lh().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.flock.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockMediaPickerFragment.Oi(FlockMediaPickerFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(FlockMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildFragmentManager().getBackStackEntryCount() <= 0) {
            this$0.Ii().W1(true);
        } else {
            this$0.Ii().W1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(FlockMediaPickerFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ii().W1(!bool.booleanValue());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    /* renamed from: Ji, reason: merged with bridge method [inline-methods] */
    public UniversalMediaPickerFactory Zh() {
        return new UniversalMediaPickerFactory(false);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.Flock;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String str, boolean z16) {
        FragmentPager.d.a.a(this, str, z16);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        Bundle bundle;
        OutputData.Companion companion = OutputData.INSTANCE;
        List<LocalMediaInfo> selectedMedia2 = Wh().getSelectedMedia();
        Intent intent = getHostActivity().getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        WinkContext.INSTANCE.d().m().k(requireActivity(), companion.b(1L, selectedMedia2, null, bundle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e8p;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FlockMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ii().T1(Wh().Z1());
        Ki();
        Mi();
        q.g(this).U1("\u8bf7\u9009\u62e9" + Nh().getStartCountNum() + "-9\u5f20\u56fe");
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
