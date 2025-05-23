package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bk extends Part {

    /* renamed from: d, reason: collision with root package name */
    TextView f82953d;

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QQCIRCLE_ENABLE_SHOW_TAB_MODEL, 0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f46701va);
        if (viewStub != null) {
            this.f82953d = (TextView) viewStub.inflate().findViewById(R.id.f46711vb);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        String str;
        super.onPartResume(activity);
        TextView textView = this.f82953d;
        if (textView != null) {
            if (QCirclePluginUtil.isQFSTabNativeFragmentMode(activity)) {
                str = "Fragment\u6a21\u5f0f";
            } else {
                str = "LocalActivity\u6a21\u5f0f";
            }
            textView.setText(str);
        }
    }
}
