package com.tencent.mobileqq.wink.picker.qcircle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerPreviewFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPreviewFragment;", "Landroid/view/View;", "view", "", "Ah", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "<init>", "()V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerPreviewFragment extends WinkMediaPreviewFragment {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public Map<Integer, View> J = new LinkedHashMap();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerPreviewFragment$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "", "previewStartPos", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerPreviewFragment;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QCircleMediaPickerPreviewFragment a(@NotNull List<? extends LocalMediaInfo> previewMedia, int previewStartPos) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            Bundle b16 = WinkMediaPreviewFragment.INSTANCE.b(previewMedia, previewStartPos);
            QCircleMediaPickerPreviewFragment qCircleMediaPickerPreviewFragment = new QCircleMediaPickerPreviewFragment();
            qCircleMediaPickerPreviewFragment.setArguments(b16);
            return qCircleMediaPickerPreviewFragment;
        }

        Companion() {
        }
    }

    private final void Ah(View view) {
        int g16 = ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, 1002);
        View findViewById = view.findViewById(R.id.root);
        if (findViewById != null) {
            findViewById.setBackgroundColor(g16);
        }
        View findViewById2 = view.findViewById(R.id.f123477gr);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(g16);
        }
        View findViewById3 = view.findViewById(R.id.yzh);
        if (findViewById3 != null) {
            findViewById3.setBackgroundColor(g16);
        }
        QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f1172070t);
        if (qUIButton != null) {
            qUIButton.setThemeId(1002);
        }
        QUIButton qUIButton2 = (QUIButton) view.findViewById(R.id.zqm);
        if (qUIButton2 != null) {
            qUIButton2.setThemeId(1002);
        }
        ((ImageView) view.findViewById(R.id.t2c)).setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_chevron_left_icon_navigation_02_selector, R.color.qui_common_icon_nav_secondary, 1002));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.J.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(new WinkMediaPreviewContentPart(wh(), getStartPosition(), false, 4, null));
        spreadBuilder.add(new WinkMediaPreviewActionPart());
        Object[] array = com.tencent.mobileqq.wink.picker.core.c.f324480a.e().g().toArray(new Part[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        spreadBuilder.addSpread(array);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spreadBuilder.toArray(new Part[spreadBuilder.size()]));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g48;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ah(view);
    }
}
