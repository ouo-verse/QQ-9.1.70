package com.tencent.mobileqq.wink.picker.qzone;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b93.OutputData;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneMediaPickerViewModelProviderKt;
import com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qzonehub.api.events.QZoneLocalPhotoRecommendScanFinishEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J \u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J \u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050-0,H\u0016R\u001d\u00103\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Oi", "Qi", "Ji", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "", "getLogTag", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "hi", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "X", "Lkotlin/Lazy;", "Mi", "()Landroid/view/View;", "qZoneBottomGapView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "Y", "Ki", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "Z", "Li", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", "a0", "Ni", "()Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", "qZoneSelectedMediaViewModel", "b0", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "pagerCallback", "<init>", "()V", "c0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPickerFragment extends WinkMediaPickerMainBaseFragment<QZoneInitBean> implements FragmentPager.d, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy qZoneBottomGapView;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qZoneSelectedMediaViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FragmentPager.b pagerCallback;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPickerFragment$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "qZoneInitBean", "Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPickerFragment;", "a", "", "DEFAULT_NEXT_STEP_MAX_MEDIA_NUM", "I", "DEFAULT_VIDEO_TEMPLATE_MAX_MEDIA_NUM", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QZoneMediaPickerFragment a(@Nullable Config config, @Nullable QZoneInitBean qZoneInitBean) {
            QZoneMediaPickerFragment qZoneMediaPickerFragment = new QZoneMediaPickerFragment();
            qZoneMediaPickerFragment.setArguments(qZoneMediaPickerFragment.Eh(config, qZoneInitBean));
            return qZoneMediaPickerFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qzone/QZoneMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return QZoneMediaPickerFragment.this.Wh().getSelectedMedia();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QZoneMediaPickerFragment.this.Li().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QZoneMediaPickerFragment.this.Li().f();
        }
    }

    public QZoneMediaPickerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$qZoneBottomGapView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QZoneMediaPickerFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.f29540lx);
                }
                return null;
            }
        });
        this.qZoneBottomGapView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.picker.core.viewmodel.p>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.picker.core.viewmodel.p invoke() {
                FragmentActivity requireActivity = QZoneMediaPickerFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(com.tencent.mobileqq.wink.picker.core.viewmodel.q.e(QZoneMediaPickerFragment.this));
            }
        });
        this.nextStepHelper = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QZoneSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$qZoneSelectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QZoneSelectedMediaViewModel invoke() {
                QZoneMediaPickerFragment qZoneMediaPickerFragment = QZoneMediaPickerFragment.this;
                return QZoneMediaPickerViewModelProviderKt.getWinkQZoneSelectedViewModel(qZoneMediaPickerFragment, qZoneMediaPickerFragment.Ph());
            }
        });
        this.qZoneSelectedMediaViewModel = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.picker.core.viewmodel.p Ki() {
        return (com.tencent.mobileqq.wink.picker.core.viewmodel.p) this.mediaPickerUIStateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Li() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Mi() {
        return (View) this.qZoneBottomGapView.getValue();
    }

    private final QZoneSelectedMediaViewModel Ni() {
        return (QZoneSelectedMediaViewModel) this.qZoneSelectedMediaViewModel.getValue();
    }

    private final void Oi() {
        if (Ph().getAttachToWinkHome()) {
            LiveData<e93.a> Z1 = Wh().Z1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$setBottomGapViewVisibility$1
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
                    com.tencent.mobileqq.wink.picker.core.viewmodel.p Ki;
                    View Mi;
                    View Mi2;
                    Ki = QZoneMediaPickerFragment.this.Ki();
                    if (!Ki.O1()) {
                        Mi2 = QZoneMediaPickerFragment.this.Mi();
                        if (Mi2 == null) {
                            return;
                        }
                        Mi2.setVisibility(8);
                        return;
                    }
                    Mi = QZoneMediaPickerFragment.this.Mi();
                    if (Mi == null) {
                        return;
                    }
                    Mi.setVisibility(QZoneMediaPickerFragment.this.Wh().getSelectedMedia().isEmpty() ? 0 : 8);
                }
            };
            Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneMediaPickerFragment.Pi(Function1.this, obj);
                }
            });
        } else {
            View Mi = Mi();
            if (Mi != null) {
                Mi.setVisibility(8);
            }
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady()) {
            Ki().U1(false);
            w53.b.a("QZoneMediaPickerFragment", "so\u672a\u5c31\u7eea\uff0c\u4e0d\u5c55\u793a\u5e95\u90e8\u680f");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Qi() {
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.h
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                QZoneMediaPickerFragment.Ri(QZoneMediaPickerFragment.this);
            }
        });
        Lh().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaPickerFragment.Si(QZoneMediaPickerFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(QZoneMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildFragmentManager().getBackStackEntryCount() <= 0) {
            this$0.Ki().W1(true);
        } else {
            this$0.Ki().W1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(QZoneMediaPickerFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ki().W1(!bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        HashMap hashMap;
        Config copy;
        boolean startsWith$default;
        MediaInfo mediaInfo;
        PicInfo picInfo;
        Intrinsics.checkNotNullParameter(config, "config");
        Serializable serializableExtra = getHostActivity().getIntent().getSerializableExtra("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO");
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        List<MediaInfo> alreadySelectedMedia = config.getAlreadySelectedMedia();
        if (alreadySelectedMedia.isEmpty()) {
            List<String> alreadySelectedMediaPath = config.getAlreadySelectedMediaPath();
            ArrayList arrayList = new ArrayList();
            for (String str : alreadySelectedMediaPath) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
                if (startsWith$default) {
                    if (hashMap != null) {
                        picInfo = (PicInfo) hashMap.get(str);
                    } else {
                        picInfo = null;
                    }
                    if (picInfo == null) {
                        mediaInfo = null;
                    } else {
                        mediaInfo = a.f325177a.c(picInfo, MediaType.QZONE_IMAGE);
                    }
                } else {
                    mediaInfo = new MediaInfo(MediaType.LOCAL_ALL, null, 0, 0, str, null, null, 0, 0, null, null, 0L, 4078, null);
                }
                if (mediaInfo != null) {
                    arrayList.add(mediaInfo);
                }
            }
            alreadySelectedMedia = arrayList;
        }
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : null, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : alreadySelectedMedia, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : null, (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    /* renamed from: Ji, reason: merged with bridge method [inline-methods] */
    public QZoneInitBean Oh() {
        return new QZoneInitBean(true, 0, 1000, true, 0, 35, 0, false, null, false, false, false, false, 8128, null);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pagerCallback = callback;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.QZone;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String str, boolean z16) {
        FragmentPager.d.a.a(this, str, z16);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.d Zh() {
        return new QZoneMediaPickerFactory(Ph(), n.f325197a.m(getContext()));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        boolean z16 = false;
        assembleParts.add(new WinkMediaPickerNextStepDialogPart(new b(), false, 2, null));
        if (Ph().getTopBannerTextContent().length() > 0) {
            z16 = true;
        }
        if (z16) {
            assembleParts.add(new com.tencent.mobileqq.wink.picker.qzone.part.a());
        }
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        String str;
        Bundle bundle = null;
        String str2 = null;
        if (Ni().getCurSelectedSize() > Ph().getNextStepMaxMediaNum()) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.f174522w3);
            } else {
                str = null;
            }
            int nextStepMaxMediaNum = Ph().getNextStepMaxMediaNum();
            Context context2 = getContext();
            if (context2 != null) {
                str2 = context2.getString(R.string.f174512w2);
            }
            QQToast.makeText(getContext(), str + nextStepMaxMediaNum + str2, 0).show();
            return;
        }
        Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l(WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, false, Wh().getSelectedMedia());
        if (l3 != null) {
            l3.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        }
        com.tencent.mobileqq.wink.picker.report.a.e(null, "ev_xsj_camera_action", l3);
        OutputData.Companion companion = OutputData.INSTANCE;
        List<LocalMediaInfo> selectedMedia2 = Wh().getSelectedMedia();
        Intent intent = getHostActivity().getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        WinkContext.INSTANCE.d().m().k(requireActivity(), companion.b(1L, selectedMedia2, null, bundle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hl6;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneLocalPhotoRecommendScanFinishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        String str;
        String str2 = null;
        if (Ni().getCurSelectedSize() > Ph().getVideoTemplateMaxMediaNum()) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.f174492w0);
            } else {
                str = null;
            }
            int videoTemplateMaxMediaNum = Ph().getVideoTemplateMaxMediaNum();
            Context context2 = getContext();
            if (context2 != null) {
                str2 = context2.getString(R.string.f174512w2);
            }
            QQToast.makeText(getContext(), str + videoTemplateMaxMediaNum + str2, 0).show();
            return;
        }
        Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l(WinkDaTongReportConstant.ElementId.EM_XSJ_AUTO_VIDEO_BUTTON, false, Wh().getSelectedMedia());
        if (l3 != null) {
            l3.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        }
        com.tencent.mobileqq.wink.picker.report.a.e(null, "ev_xsj_camera_action", l3);
        w53.b.f("QZoneMediaPickerFragment", "performClickNextStep invoke, selectedMedia.size=" + Wh().getSelectedMedia().size() + ", useVideoTemplate=true");
        WinkMediaPickerNextStepHelper Li = Li();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        WinkMediaPickerNextStepHelper.i(Li, hostActivity, Nh().getLocalMediaTabType(), Wh().getSelectedMedia(), true, null, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$onVideoTemplateClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                invoke2(mediaPickerOutput);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MediaPickerOutput it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Activity hostActivity2 = QZoneMediaPickerFragment.this.getHostActivity();
                Intrinsics.checkNotNullExpressionValue(hostActivity2, "hostActivity");
                Intent intent = QZoneMediaPickerFragment.this.getHostActivity().getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
                com.tencent.mobileqq.wink.picker.g.d(hostActivity2, intent, it);
            }
        }, 48, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Li().p();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QZoneLocalPhotoRecommendScanFinishEvent) {
            w53.b.f("QZoneMediaPickerFragment", "onReceiveEvent QZoneLocalPhotoRecommendScanFinishEvent");
            if (getActivity() != null && !requireActivity().isDestroyed() && isAdded()) {
                Wh().i2(new e93.h(Wh().getSelectedMedia()));
            }
            if (getActivity() != null && !requireActivity().isDestroyed() && isAdded()) {
                Wh().i2(new e93.h(Wh().getSelectedMedia()));
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        LiveData<String> isFirstFetchDoneLiveData;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ki().T1(Wh().Z1());
        Oi();
        Qi();
        FragmentActivity requireActivity = requireActivity();
        if (Ph().getAttachToWinkHome()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity, "pg_xsj_choose_media_new_page", false, null, i3, false, false, null, TroopInfo.PAY_PRIVILEGE_ALL, null);
        setStatusBarTextColor();
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), ContextCompat.getColor(requireActivity(), R.color.qvideo_skin_color_bg_default));
        }
        WinkLocalMediaViewModel localMediaViewModel = getLocalMediaViewModel();
        if (localMediaViewModel != null && (isFirstFetchDoneLiveData = localMediaViewModel.isFirstFetchDoneLiveData()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment$onViewCreated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    FragmentPager.b bVar;
                    bVar = QZoneMediaPickerFragment.this.pagerCallback;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            };
            isFirstFetchDoneLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneMediaPickerFragment.onViewCreated$lambda$2(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
