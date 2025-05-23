package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEEditorCommonEditFragment extends AEEditorBaseFragment implements BusinessObserver {
    private static final String I = "AEEditorCommonEditFragment";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AEEditorCommonEditFragment.this.uh();
            AEEditorCommonEditFragment.this.ph().g(AEEditorCommonEditFragment.this.getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ms.a.f(I, "onCreateView");
        return layoutInflater.inflate(th(), viewGroup, false);
    }

    @Override // com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment
    public boolean qh() {
        FragmentActivity activity = getActivity();
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(activity, 230).setTitle(HardCodeUtil.qqStr(R.string.f169885y44)).setMessage(activity.getString(R.string.y46)).setPositiveButton(activity.getString(R.string.f169886y45), new b()).setNegativeButton(activity.getString(R.string.y2a), new a());
        if (negativeButton == null) {
            return true;
        }
        try {
            if (negativeButton.isShowing()) {
                return true;
            }
            negativeButton.show();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    protected abstract int th();

    public void uh() {
        List list;
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(AEEditorConstants.CLIPPED_PIC_INFOS) || (list = (List) arguments.getSerializable(AEEditorConstants.CLIPPED_PIC_INFOS)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((EditorPicInfo) it.next()).picPath);
        }
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.QCIRCLE_PHOTO_PATH_FROM_IMAGE_EDIT, arrayList);
        intent.putExtra(PeakConstants.QCIRCLE_IS_BACK_FROM_IMAGE_EDIT, true);
        getActivity().setResult(-1, intent);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
    }
}
