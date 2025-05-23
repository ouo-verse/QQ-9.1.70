package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationEmotion extends PreviewCustomizationBase<a> {
    static IPatchRedirector $redirector_;

    public PhotoPreviewCustomizationEmotion(@NonNull FragmentActivity fragmentActivity, @NonNull b<a> bVar) {
        super(fragmentActivity, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity, (Object) bVar);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    @Nullable
    public View getBottomView(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) viewGroup);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dwz, viewGroup, false);
        setSendBtn((Button) inflate.findViewById(R.id.utu));
        getSendBtn().setText("\u4e0a\u4f20");
        return inflate;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
