package com.tencent.mobileqq.wink.picker.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.InitBean;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import com.tencent.mobileqq.wink.view.WinkCompoundButton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "", "initView", "Ai", "", "getLogTag", "", "getContentLayoutId", "Oh", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "hi", "<init>", "()V", "Y", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class UniversalMediaPickerFragment extends WinkMediaPickerMainBaseFragment<InitBean> {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public Map<Integer, View> X = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/picker/InitBean;", "initBean", "Landroid/os/Bundle;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle b(Companion companion, Config config, InitBean initBean, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                initBean = new InitBean(false, null, 3, null);
            }
            return companion.a(config, initBean);
        }

        @NotNull
        public final Bundle a(@NotNull Config config, @Nullable InitBean initBean) {
            Intrinsics.checkNotNullParameter(config, "config");
            Bundle bundle = new Bundle();
            bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", config);
            bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", initBean);
            return bundle;
        }

        Companion() {
        }
    }

    private final void Ai() {
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(Wh().getSelectedMedia()));
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setResult(-1, intent);
        requireActivity.finish();
        requireActivity.overridePendingTransition(0, R.anim.f155066i1);
    }

    private final void initView() {
        requireView().findViewById(R.id.root).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        ((WinkCompoundButton) requireView().findViewById(R.id.ivTitleBtnLeft)).setForegroundResource(R.drawable.qui_close);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public InitBean Oh() {
        return new InitBean(false, null, 3, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.Universal;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public d Zh() {
        return new UniversalMediaPickerFactory(false);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.X.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        Ai();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i8b;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "UniversalMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
    }
}
