package com.tencent.gdtad.api.motivevideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveDemoHippyConfigFragment extends QPublicBaseFragment implements View.OnClickListener {
    private CheckBox C;
    private CheckBox D;
    private CheckBox E;
    private CheckBox F;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            GdtLog.d("GdtMotiveDemoHippyConfigFragment", "onClick view is null");
        } else if (view.getId() == R.id.tgl) {
            Intent intent = new Intent();
            intent.putExtra("isDynamic", this.C.isChecked());
            intent.putExtra("isHippyTest", this.D.isChecked());
            intent.putExtra("isJsBundleTest", this.E.isChecked());
            intent.putExtra("isModeTest", this.F.isChecked());
            if (getActivity() != null) {
                getActivity().setResult(-1, intent);
                getActivity().finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ecu, viewGroup, false);
        inflate.findViewById(R.id.tgl).setOnClickListener(this);
        this.C = (CheckBox) inflate.findViewById(R.id.tpl);
        this.D = (CheckBox) inflate.findViewById(R.id.tph);
        this.E = (CheckBox) inflate.findViewById(R.id.tpi);
        this.F = (CheckBox) inflate.findViewById(R.id.tpk);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
