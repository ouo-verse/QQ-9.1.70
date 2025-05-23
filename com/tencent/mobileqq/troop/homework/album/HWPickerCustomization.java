package com.tencent.mobileqq.troop.homework.album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.album.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/album/HWPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelected", "isGesture", "doCheckMediaSelect", "isValidVideo", "photoInfo", "isValidImage", "Lkotlinx/coroutines/Job;", "asyncParseMedia", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "checkMediaSelect", "v", "", "onSendBtnClick", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWPickerCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PickerCustomizationBase<O> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWPickerCustomization(@NotNull FragmentActivity activity, @NotNull b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
        }
    }

    private final Job asyncParseMedia() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HWPickerCustomization$asyncParseMedia$1(this, null), 3, null);
        return launch$default;
    }

    private final boolean doCheckMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        if (!isSelected) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        int mMediaType = mediaInfo.getMMediaType();
        if (mMediaType != 0) {
            if (mMediaType != 1) {
                return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
            }
            if (!isValidVideo(mediaInfo)) {
                return false;
            }
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        if (!isValidImage(mediaInfo)) {
            return false;
        }
        return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
    }

    private final boolean isValidImage(LocalMediaInfo photoInfo) {
        return new a.b().a(photoInfo);
    }

    private final boolean isValidVideo(LocalMediaInfo mediaInfo) {
        return new a.b().b(mediaInfo);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public boolean checkMediaSelect(@NotNull LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, mediaInfo, Boolean.valueOf(isSelected), Boolean.valueOf(isGesture))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return doCheckMediaSelect(mediaInfo, isSelected, isGesture);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setVisibility(8);
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(8);
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(8);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        asyncParseMedia();
        super.onSendBtnClick(v3);
    }
}
