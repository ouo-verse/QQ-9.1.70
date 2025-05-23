package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import mqq.app.AppRuntime;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends Part {

    /* renamed from: d, reason: collision with root package name */
    private VipFullScreenVideoView f76467d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f76468e;

    /* renamed from: f, reason: collision with root package name */
    private m f76469f;

    /* renamed from: h, reason: collision with root package name */
    private int f76470h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76471i;

    private void B9(AppRuntime appRuntime, String str, int i3, int i16) {
        if (VipFunCallUtil.play(getContext(), this.f76467d, str, i3, null, i16, false, appRuntime == null || AVUtil.k(appRuntime.getAccount()))) {
            ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
        }
    }

    public void A9() {
        if (this.f76468e == null) {
            return;
        }
        VideoAppInterface b16 = nw.b.b();
        int a16 = kw.a.a(b16, this.f76469f.getPeerUin(), false, this.f76471i);
        if (a16 != 0) {
            int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            boolean z16 = systemNetwork == 4 || systemNetwork == 1;
            int resourceType = VipFunCallUtil.getResourceType();
            String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(b16, a16, VipFunCallUtil.getResourceType(), null);
            if (TextUtils.isEmpty(resourcePathByUrl)) {
                return;
            }
            this.f76467d = com.tencent.mobileqq.vipav.a.a(getActivity(), this.f76468e, true);
            if (new File(resourcePathByUrl).exists()) {
                B9(b16, resourcePathByUrl, resourceType, a16);
            } else if (z16) {
                this.f76470h = a16;
                kw.a.c(b16, a16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteVipFunVideoPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76468e = (RelativeLayout) view.findViewById(R.id.root_layout);
        m mVar = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, getPartRootView(), null);
        this.f76469f = mVar;
        this.f76471i = mVar.f();
        A9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        try {
            VipFullScreenVideoView vipFullScreenVideoView = this.f76467d;
            if (vipFullScreenVideoView != null) {
                vipFullScreenVideoView.stopPlayback();
                RelativeLayout relativeLayout = this.f76468e;
                if (relativeLayout != null) {
                    relativeLayout.removeAllViews();
                    this.f76468e = null;
                }
                this.f76467d = null;
            }
        } catch (Throwable unused) {
            VipFullScreenVideoView vipFullScreenVideoView2 = this.f76467d;
            if (vipFullScreenVideoView2 != null) {
                vipFullScreenVideoView2.suspend();
                RelativeLayout relativeLayout2 = this.f76468e;
                if (relativeLayout2 != null) {
                    relativeLayout2.removeAllViews();
                    this.f76468e = null;
                }
                this.f76467d = null;
            }
        }
    }

    public void z9(int i3) {
        boolean isDestroyed = getActivity().isDestroyed();
        if (QLog.isColorLevel()) {
            QLog.w("AVInviteVipFunVideoPart", 2, "onPlayAnnimate, id[" + i3 + "], FunCallId[" + this.f76470h + "], isDestroy[" + isDestroyed + "]");
        }
        if (i3 != this.f76470h || isDestroyed) {
            return;
        }
        VideoAppInterface b16 = nw.b.b();
        int resourceType = VipFunCallUtil.getResourceType();
        String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(b16, i3, resourceType, null);
        File file = new File(resourcePathByUrl);
        SessionInfo sessionInfo = this.f76469f.getSessionInfo();
        if (sessionInfo != null) {
            int i16 = sessionInfo.f73035i;
            if (file.exists() && sessionInfo.f73043k != 4 && ((i16 == 1 || i16 == 0) && this.f76468e != null)) {
                if (this.f76467d == null) {
                    this.f76467d = com.tencent.mobileqq.vipav.a.a(getActivity(), this.f76468e, false);
                }
                B9(b16, resourcePathByUrl, resourceType, i3);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AVInviteVipFunVideoPart", 2, "VideoInviteFull onPlayAnnimate finish id:" + i3);
        }
    }

    public static boolean x9(AppRuntime appRuntime, int i3, String str) {
        return (i3 != 4) && !TextUtils.isEmpty(VipFunCallUtil.getResourcePathByUrl(appRuntime, kw.a.b(appRuntime, appRuntime.getCurrentAccountUin(), false, true, str), VipFunCallUtil.getResourceType(), null));
    }
}
