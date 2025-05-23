package com.tencent.biz.qqcircle.immersive.part.teenmode;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f88335d;

    private void x9(View view) {
        ViewStub viewStub;
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || (viewStub = (ViewStub) view.findViewById(R.id.f55392hs)) == null) {
            return;
        }
        ImageView imageView = (ImageView) viewStub.inflate().findViewById(R.id.f55382hr);
        this.f88335d = imageView;
        imageView.setOnClickListener(this);
    }

    private void z9() {
        broadcastMessage("qfs_open_teen_mode_window", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTeenModeSwitchPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f55382hr) {
            z9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        x9(view);
    }
}
