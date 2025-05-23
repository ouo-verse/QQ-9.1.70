package com.tencent.av.ui.part.invite;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends Part {

    /* renamed from: d, reason: collision with root package name */
    private TextView f76443d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76444e = null;

    /* renamed from: f, reason: collision with root package name */
    private m f76445f;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        TextView textView;
        QLog.d("AVInviteComeFromInfoPart", 1, "onInitView begin.");
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteComeFromInfoPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76443d = (TextView) view.findViewById(R.id.a2k);
        this.f76444e = (TextView) view.findViewById(R.id.a2_);
        m mVar = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, getPartRootView(), null);
        this.f76445f = mVar;
        boolean c16 = mVar.c();
        String x95 = x9(this.f76445f.getSessionInfo(), c16);
        if (this.f76444e != null && !TextUtils.isEmpty(x95)) {
            this.f76444e.setVisibility(0);
            this.f76444e.setText(x95);
            ba.setAccText(this.f76444e, x95);
            if (c16 && (textView = this.f76443d) != null) {
                textView.setVisibility(4);
            }
        }
        TextView textView2 = this.f76444e;
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
        TextView textView3 = this.f76443d;
        if (textView3 != null) {
            textView3.setTextColor(-1);
            this.f76443d.setText(R.string.ie6);
            if (this.f76445f.f()) {
                this.f76443d.setText(R.string.dls);
            }
        }
        QLog.d("AVInviteComeFromInfoPart", 1, "onInitView " + this.f76445f.f());
    }

    String x9(SessionInfo sessionInfo, boolean z16) {
        String str = "";
        if (sessionInfo == null) {
            return "";
        }
        int i3 = sessionInfo.f73067q;
        String str2 = sessionInfo.f73103z;
        VideoAppInterface b16 = nw.b.b();
        int i16 = 7;
        if (i3 != 0) {
            if (i3 == 1004) {
                String string = getActivity().getString(R.string.deq);
                if (b16 != null) {
                    string = string + b16.G(3000, str2, null);
                }
                str = string;
                i16 = 2;
            } else if (i3 == 1006) {
                str = getActivity().getString(R.string.den);
                i16 = 3;
            } else if (i3 == 1010) {
                str = getActivity().getString(R.string.deo);
                i16 = 6;
            } else if (i3 == 1021) {
                str = getActivity().getString(R.string.dem);
                i16 = 4;
            } else if (i3 == 10002) {
                str = getActivity().getString(R.string.f171128cd3);
            } else if (i3 == 1000) {
                String string2 = getActivity().getString(R.string.deq);
                if (b16 != null) {
                    string2 = string2 + b16.G(1, str2, null);
                }
                str = string2;
                i16 = 1;
            } else if (i3 != 1001) {
                i16 = 99;
            } else {
                str = getActivity().getString(R.string.der);
                i16 = 5;
            }
        } else if (z16) {
            str = getActivity().getString(R.string.dep);
            com.tencent.av.screenshare.c.i(sessionInfo.f73030h, 1, "getComeFromInfo");
        } else {
            i16 = 0;
        }
        this.f76445f.g(i16);
        return str;
    }
}
