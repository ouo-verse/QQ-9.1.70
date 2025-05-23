package com.tencent.mobileqq.wink.aiavatar.detailpage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarDebugPart;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarFinishEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "qh", "", "needImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "viewModel", "<init>", "()V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMaterialDetailFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @NotNull
    public Map<Integer, View> D = new LinkedHashMap();

    public WinkAIAvatarMaterialDetailFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarMaterialDetailViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarMaterialDetailViewModel invoke() {
                return (WinkAIAvatarMaterialDetailViewModel) WinkAIAvatarMaterialDetailFragment.this.getViewModel(WinkAIAvatarMaterialDetailViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final WinkAIAvatarMaterialDetailViewModel ph() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkAIAvatarMaterialDetailViewModel) value;
    }

    private final void qh() {
        int i3;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (o53.h.f422138a.a(getActivity())) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            activity.setRequestedOrientation(i3);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.D.clear();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkAIAvatarDebugPart(), new WinkAIAvatarMaterialPreviewPart(), new WinkAIAvatarMaterialDetailUIStatePart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i4o;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkAIAvatarFinishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        qh();
        SimpleEventBus.getInstance().registerReceiver(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FragmentActivity activity;
        if (event instanceof WinkAIAvatarFinishEvent) {
            FragmentActivity activity2 = getActivity();
            boolean z16 = false;
            if (activity2 != null && !activity2.isFinishing()) {
                z16 = true;
            }
            if (z16 && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setPadding(0, RFWImmersiveUtils.getStatusBarHeight(), 0, 0);
        ph().Q1(getArguments());
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.a(getActivity(), view, ph());
    }
}
