package com.tencent.mobileqq.wink.picker.qcircle.templatelibrary;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart;
import com.tencent.mobileqq.wink.picker.qcircle.part.z;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/templatelibrary/TemplateLibMediaPreviewFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPreviewFragment;", "", "getLogTag", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "<init>", "()V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TemplateLibMediaPreviewFragment extends WinkMediaPreviewFragment {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public Map<Integer, View> J = new LinkedHashMap();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/templatelibrary/TemplateLibMediaPreviewFragment$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "", "previewStartPos", "Lcom/tencent/mobileqq/wink/picker/qcircle/templatelibrary/TemplateLibMediaPreviewFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.TemplateLibMediaPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TemplateLibMediaPreviewFragment a(@NotNull List<? extends LocalMediaInfo> previewMedia, int previewStartPos) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            Bundle b16 = WinkMediaPreviewFragment.INSTANCE.b(previewMedia, previewStartPos);
            TemplateLibMediaPreviewFragment templateLibMediaPreviewFragment = new TemplateLibMediaPreviewFragment();
            templateLibMediaPreviewFragment.setArguments(b16);
            return templateLibMediaPreviewFragment;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.J.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkMediaPreviewContentPart(wh(), getStartPosition(), false, 4, null), new z());
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "TemplateLibMediaPreviewFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
