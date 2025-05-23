package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\"\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/GXHSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/setting/processor/a;", "", "Bh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "vb", "", "isVisible", "na", "onDestroyView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onAccountChanged", "onPostThemeChanged", "onResume", "Lcom/tencent/mobileqq/vas/GXHSettingProvider;", "J", "Lcom/tencent/mobileqq/vas/GXHSettingProvider;", "configProvider", "K", "Z", "splitViewMode", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class GXHSettingFragment extends BaseSettingFragment implements com.tencent.mobileqq.setting.processor.a {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GXHSettingProvider configProvider = new GXHSettingProvider();

    /* renamed from: K, reason: from kotlin metadata */
    private boolean splitViewMode;

    private final void Bh() {
        GXHSettingProvider gXHSettingProvider = this.configProvider;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        gXHSettingProvider.l(requireContext, this);
        MutableLiveData<Group[]> j3 = this.configProvider.j();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Group[], Unit> function1 = new Function1<Group[], Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingFragment$createConfigs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Group[] groupArr) {
                invoke2(groupArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Group[] groupArr) {
                QUIListItemAdapter th5;
                if (groupArr == null || (th5 = GXHSettingFragment.this.th()) == null) {
                    return;
                }
                th5.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
            }
        };
        j3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.vas.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GXHSettingFragment.Ch(Function1.this, obj);
            }
        });
        this.configProvider.q(this);
        this.configProvider.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.setting.processor.a
    public void na(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            th5.m0(config, isVisible);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        super.onAccountChanged();
        this.configProvider.n();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.configProvider.o(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.configProvider.r(this);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        this.configProvider.p();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        VideoReport.setPageId(view, "pg_bas_dressvip_set");
        Bundle arguments = getArguments();
        boolean z16 = false;
        if (arguments != null) {
            z16 = arguments.getBoolean("main_setting_split_view_mode", false);
        }
        this.splitViewMode = z16;
        setTitle("\u4e2a\u6027\u88c5\u626e\u4e0e\u7279\u6743\u5916\u663e");
        Bh();
    }

    @Override // com.tencent.mobileqq.setting.processor.a
    public void vb(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            th5.l0(config);
        }
    }
}
