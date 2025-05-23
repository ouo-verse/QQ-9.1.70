package com.tencent.mobileqq.wink.picker.ae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import d93.c;
import e93.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import w53.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/ae/AESingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "requestCode", "", "Bi", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "imgInfo", "Ci", "Ze", "<init>", "()V", "a0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AESingleMediaPickerFragment extends SingleMediaPickerFragment {
    private final void Bi(final LocalMediaInfo mediaInfo, final int requestCode) {
        int x16 = i.x(mediaInfo);
        Context context = getContext();
        if (context != null) {
            c.INSTANCE.b(context, x16, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.ae.AESingleMediaPickerFragment$returnPicPath$1$1
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
                    AESingleMediaPickerFragment.Di(AESingleMediaPickerFragment.this, mediaInfo, requestCode, null, 4, null);
                }
            });
        }
    }

    private final void Ci(LocalMediaInfo mediaInfo, int requestCode, MagicStudioUploadImgAndStyle imgInfo) {
        Bundle bundle;
        Intent intent;
        Intent intent2;
        Intent intent3 = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER);
        bundle2.putSerializable(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH, mediaInfo);
        if (imgInfo != null) {
            bundle2.putParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_MAGIC_INFO, imgInfo);
            FragmentActivity activity = getActivity();
            Bundle bundle3 = null;
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                bundle = intent2.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
            } else {
                bundle = null;
            }
            if (bundle != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null) {
                    bundle3 = intent.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
                }
                bundle2.putAll(bundle3);
            }
        }
        intent3.putExtras(bundle2);
        String str = mediaInfo.path;
        if (str != null) {
            b.c("AESingleMediaPickerFragment", "return pic path: " + str);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.setResult(requestCode, intent3);
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            activity4.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Di(AESingleMediaPickerFragment aESingleMediaPickerFragment, LocalMediaInfo localMediaInfo, int i3, MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            magicStudioUploadImgAndStyle = null;
        }
        aESingleMediaPickerFragment.Ci(localMediaInfo, i3, magicStudioUploadImgAndStyle);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return;
        }
        Bi(mediaInfo, com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getBusinessRequestCode());
    }
}
