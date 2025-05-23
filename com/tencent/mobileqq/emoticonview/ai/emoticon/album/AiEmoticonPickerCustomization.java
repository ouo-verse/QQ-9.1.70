package com.tencent.mobileqq.emoticonview.ai.emoticon.album;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.emoticonview.ai.emoticon.EnumSerializer;
import com.tencent.mobileqq.emoticonview.ai.emoticon.PicModel;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010!\u001a\u00020 \u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J \u0010\u000b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/album/AiEmoticonPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "", "asyncHandleImage", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckImageResult;", "result", "", "Lcom/tencent/mobileqq/emoticonview/ai/emoticon/PicModel;", "picModelList", "handleUploadResult", "onSelectFinish", "Landroid/content/Intent;", "intent", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "v", "onSendBtnClick", "", "TAG", "Ljava/lang/String;", "", "maxSelectNum", "I", "Landroid/app/Dialog;", "loadingDialog", "Landroid/app/Dialog;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AiEmoticonPickerCustomization extends PickerCustomizationBase<a> {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    @Nullable
    private Dialog loadingDialog;
    private int maxSelectNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonPickerCustomization(@NotNull FragmentActivity activity, @NotNull b<a> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
        } else {
            this.TAG = "AiEmoticonPickerCustomization";
        }
    }

    private final void asyncHandleImage() {
        Dialog dialog;
        Window window;
        boolean z16 = false;
        if (this.loadingDialog == null) {
            Dialog showPersistentLoadingDialog = LoadingUtil.showPersistentLoadingDialog(getActivity(), getActivity().getString(R.string.yof), false, false);
            this.loadingDialog = showPersistentLoadingDialog;
            if (showPersistentLoadingDialog != null && (window = showPersistentLoadingDialog.getWindow()) != null) {
                window.setDimAmount(0.0f);
            }
        }
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null && !dialog2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dialog = this.loadingDialog) != null) {
            dialog.show();
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, this.TAG + "_AI_EMOTICON_UPLOAD_PIC", null, null, null, new AiEmoticonPickerCustomization$asyncHandleImage$1(this, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadResult(CheckImageResult result, List<PicModel> picModelList) {
        boolean z16;
        int i3;
        Dialog dialog;
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (dialog = this.loadingDialog) != null) {
            dialog.dismiss();
        }
        if (result == null) {
            QQToast.makeText(getActivity(), 1, R.string.yoc, 0).show();
            return;
        }
        if (result.code == 0) {
            onSelectFinish(result, picModelList);
            return;
        }
        if (this.maxSelectNum == 2) {
            i3 = R.string.yoe;
        } else {
            i3 = R.string.yod;
        }
        QQToast.makeText(getActivity(), 1, i3, 0).show();
    }

    private final void onSelectFinish(CheckImageResult result, List<PicModel> picModelList) {
        Gson create = new GsonBuilder().registerTypeHierarchyAdapter(Enum.class, new EnumSerializer()).create();
        Bundle bundle = new Bundle();
        bundle.putString("ai_emoticon_choose_pic_result", create.toJson(result));
        bundle.putString("ai_emoticon_choose_pic_path", create.toJson(picModelList));
        getActivity().setResult(-1, new Intent().putExtras(bundle));
        getActivity().finish();
        QAlbumUtil.anim(getActivity(), false, false);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        if (bottomView instanceof ViewGroup) {
            viewGroup = (ViewGroup) bottomView;
        } else {
            viewGroup = null;
        }
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText(context.getString(R.string.b2e));
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(8);
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(8);
        }
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setVisibility(8);
        }
        TextView mediaSizeTv = getMediaSizeTv();
        if (mediaSizeTv != null) {
            mediaSizeTv.setVisibility(8);
        }
        return viewGroup;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.initData(intent);
        if (intent != null) {
            this.maxSelectNum = intent.getIntExtra(AiEmoticonAlbumUtils.MAX_SELECT_NUM, 1);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (getPhotoCommonData().h().size() < this.maxSelectNum) {
            QQToast.makeText(getActivity(), 0, "\u8bf7\u9009\u62e9" + this.maxSelectNum + "\u5f20\u7167\u7247", 0).show();
            return;
        }
        asyncHandleImage();
        ReportController.o(null, "dc00898", "", "", "0X800C608", "0X800C608", 0, 0, "", "", "", "");
    }
}
