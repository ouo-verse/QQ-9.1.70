package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;

/* loaded from: classes10.dex */
public class PhotoListCustomizationEmotion extends PickerCustomizationBase<a> {
    static IPatchRedirector $redirector_;

    public PhotoListCustomizationEmotion(@NonNull FragmentActivity fragmentActivity, @NonNull b<a> bVar) {
        super(fragmentActivity, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity, (Object) bVar);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getBottomView(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) viewGroup);
        }
        View bottomView = super.getBottomView(context, viewGroup);
        getMagicBtn().setVisibility(8);
        getQualityCb().setVisibility(8);
        bottomView.findViewById(R.id.f25150a2).setVisibility(8);
        return bottomView;
    }
}
