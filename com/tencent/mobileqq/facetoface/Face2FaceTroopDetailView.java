package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class Face2FaceTroopDetailView extends Face2FaceDetailBaseView implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected e L;
    protected ImageView M;
    protected TextView N;
    protected TextView P;
    protected TextView Q;
    protected Button R;

    public Face2FaceTroopDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f205680d = super.findViewById(R.id.jy6);
        this.f205681e = super.findViewById(R.id.j5y);
        this.N = (TextView) super.findViewById(R.id.k0i);
        this.P = (TextView) super.findViewById(R.id.k1s);
        this.Q = (TextView) super.findViewById(R.id.k0q);
        this.R = (Button) super.findViewById(R.id.f164037i2);
        this.M = (ImageView) this.f205680d;
        this.f205685m = super.findViewById(R.id.i9j);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View view = this.f205685m;
            view.setPadding(BaseAIOUtils.f(10.0f, view.getResources()), BaseAIOUtils.f(15.0f, this.f205685m.getResources()) + ImmersiveUtils.getStatusBarHeight(this.f205685m.getContext()), BaseAIOUtils.f(10.0f, this.f205685m.getResources()), BaseAIOUtils.f(15.0f, this.f205685m.getResources()));
        }
        this.f205685m.setOnClickListener(this);
        super.setOnClickListener(this);
    }

    public void l(int i3, String str, String str2, boolean z16) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onJoinTroopSucc, ret=");
            sb5.append(i3);
            sb5.append(",errInfo=");
            sb5.append(str);
            sb5.append(",troopUin=");
            sb5.append(str2);
            sb5.append(",mUserData.nearbyUin=");
            e eVar = this.L;
            if (eVar != null) {
                str3 = eVar.f205754b;
            } else {
                str3 = null;
            }
            sb5.append(str3);
            QLog.d("Face2FaceTroopDetailView", 2, sb5.toString());
        }
        if (this.J) {
            e eVar2 = this.L;
            if ((eVar2 instanceof c) && str2 != null && str2.equals(eVar2.f205754b)) {
                if (i3 == 0) {
                    setBtnEnabled(false);
                    this.R.setText(R.string.f170922b35);
                    if (!z16) {
                        QQToast.makeText(super.getContext(), 2, HardCodeUtil.qqStr(R.string.f171960mc1), 1).show();
                    }
                    super.b();
                    return;
                }
                if (i3 == -5) {
                    this.K.c((c) this.L);
                    super.b();
                }
                if (!z16) {
                    if (TextUtils.isEmpty(str)) {
                        str = HardCodeUtil.qqStr(R.string.mch);
                    }
                    QQToast.makeText(super.getContext(), 1, str, 1).show();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Face2FaceDetailBaseView.c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view == this.f205685m) {
            super.b();
        } else if (view == this.R && (cVar = this.K) != null) {
            e eVar = this.L;
            if (eVar instanceof c) {
                c cVar2 = (c) eVar;
                cVar.b(cVar2, 1);
                ReportController.o(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, cVar2.f205754b, this.K.getApp().getCurrentAccountUin(), "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setBindData(e eVar, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar, (Object) onClickListener);
            return;
        }
        this.L = eVar;
        QQAppInterface app = this.K.getApp();
        if (eVar instanceof c) {
            c cVar = (c) eVar;
            Bitmap troopFaceBitmap = this.K.getApp().getTroopFaceBitmap(eVar.f205754b, (byte) 3, false, false);
            if (troopFaceBitmap == null) {
                troopFaceBitmap = BaseImageUtil.getDefaultTroopFaceBitmap();
            }
            this.M.setBackgroundDrawable(new BitmapDrawable(troopFaceBitmap));
            this.N.setText(cVar.f205748c);
            this.P.setText("(" + cVar.f205754b + ")");
            String str = cVar.f205750e;
            if (TextUtils.isEmpty(str)) {
                str = cVar.f205749d;
            }
            this.Q.setText(app.getApplication().getString(R.string.b3c, str));
            this.Q.setVisibility(0);
            this.P.setVisibility(0);
            if (this.K.isTroopMember(cVar.f205754b)) {
                setBtnEnabled(false);
                this.R.setText(R.string.f170922b35);
            } else {
                setBtnEnabled(true);
                this.R.setText(R.string.f170921b34);
            }
        } else if (eVar instanceof f) {
            Bitmap faceBitmap = app.getFaceBitmap(eVar.f205754b, (byte) 3, true);
            if (faceBitmap == null) {
                faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            this.M.setBackgroundDrawable(new BitmapDrawable(faceBitmap));
            this.N.setText(((f) eVar).f205755c);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(eVar.f205754b), "Face2FaceTroopDetailView");
            if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                this.P.setText("(" + friendsSimpleInfoWithUid.r() + ")");
                this.P.setVisibility(0);
            } else {
                this.P.setVisibility(8);
            }
            this.Q.setVisibility(8);
            setBtnEnabled(false);
            this.R.setText(R.string.b36);
        }
        this.M.setOnClickListener(onClickListener);
    }

    public void setBtnEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16) {
            this.R.setBackgroundResource(R.drawable.common_btn_blue);
            this.R.setOnClickListener(this);
        } else {
            this.R.setBackgroundResource(R.drawable.cgl);
            this.R.setOnClickListener(null);
        }
    }
}
