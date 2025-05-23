package com.tencent.mobileqq.wink.aigc.newtest;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.utils.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/MaliSingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "Ci", "Ze", "<init>", "()V", "b0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MaliSingleMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f317897a0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/aigc/newtest/MaliSingleMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/utils/j$a;", "", "hasFace", "isLegal", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements j.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f317899b;

        b(LocalMediaInfo localMediaInfo) {
            this.f317899b = localMediaInfo;
        }

        @Override // com.tencent.mobileqq.wink.utils.j.a
        public void a(boolean hasFace, boolean isLegal) {
            if (hasFace && isLegal) {
                MaliSingleMediaPickerFragment.this.Ci(this.f317899b);
            } else if (!hasFace) {
                QQToast.makeText(MaliSingleMediaPickerFragment.this.getContext(), R.string.f241357rn, 0).show();
            } else {
                QQToast.makeText(MaliSingleMediaPickerFragment.this.getContext(), R.string.f240447p7, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ci(LocalMediaInfo mediaInfo) {
        int businessRequestCode = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getBusinessRequestCode();
        com.tencent.xaction.log.b.a("MaliSingleMediaPickerFragment", 1, "[onMediaSelect] url=" + mediaInfo.path + ", requestCode=" + businessRequestCode);
        Intent intent = new Intent();
        intent.putExtra(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER);
        Intrinsics.checkNotNull(mediaInfo, "null cannot be cast to non-null type android.os.Parcelable");
        intent.putExtra(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH, (Parcelable) mediaInfo);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            QQToast.makeText(getContext(), 1, "\u5f02\u5e38\u7167\u7247", 0).show();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        j.i(str, true, new b(mediaInfo));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f317897a0.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
