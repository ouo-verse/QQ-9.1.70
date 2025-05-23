package com.tencent.mobileqq.wink.aieliminate.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationScene;
import com.tencent.mobileqq.wink.g;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.render.repository.a;
import d93.c;
import e93.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/aieliminate/picker/AIEliminateSingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/videocut/model/MediaClip;", "Ci", "", "Di", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "mediaInfo", "Ze", "", "enableRootViewSetFitsSystemWindows", "<init>", "()V", "a0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AIEliminateSingleMediaPickerFragment extends SingleMediaPickerFragment {
    private final MediaClip Ci(LocalMediaInfo localMediaInfo) {
        List mutableListOf;
        Object firstOrNull;
        List mutableListOf2;
        Object firstOrNull2;
        if (i.I(localMediaInfo)) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(i.f(localMediaInfo, false));
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a.e(a.f384196a, mutableListOf2, 0.0f, 2, null));
            return (MediaClip) firstOrNull2;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(i.d(localMediaInfo, 2500000L));
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a.e(a.f384196a, mutableListOf, 0.0f, 2, null));
        return (MediaClip) firstOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di(LocalMediaInfo localMediaInfo) {
        MediaClip Ci = Ci(localMediaInfo);
        if (Ci == null) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(Ci);
        Bundle bundle = new Bundle();
        Intent intent = getHostActivity().getIntent();
        if (intent != null) {
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            bundle.putAll(intent.getExtras());
        }
        bundle.putParcelableArrayList("KEY_MEDIA_CLIP", arrayList);
        bundle.putInt("KEY_SELECT_INDEX", 0);
        bundle.putInt("KEY_SCENE", AIEliminationScene.QZONE_HOME_PAGE.getScene());
        g.f322861a.c(getHostActivity(), bundle);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.AIEliminate;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable final LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        int x16 = i.x(mediaInfo);
        Context context = getContext();
        if (context != null) {
            c.INSTANCE.b(context, x16, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aieliminate.picker.AIEliminateSingleMediaPickerFragment$onMediaSelect$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AIEliminateSingleMediaPickerFragment.this.Di(mediaInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.PUBLISHER_TAB_ENTRY_SOURCE, "6");
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity(), "pg_xsj_choose_media_new_page", false, null, 0, false, false, linkedHashMap, 224, null);
    }
}
