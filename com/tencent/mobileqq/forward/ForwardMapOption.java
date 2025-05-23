package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMapOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardMapOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mConfirmDialog.setMessage(this.mIntent.getStringExtra(AppConstants.Key.FORWARD_LOCATION_STRING));
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void decodeAndSetLocalImage(Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, drawable, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            URLDrawableHelper.decodeLocalImage((URLDrawable) drawable, this.app.getCurrentAccountUin(), true);
        }
        if (drawable == null) {
            return;
        }
        float f16 = this.mDensity;
        drawable.setBounds(0, 0, (int) (264.0f * f16), (int) (f16 * 138.0f));
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1020 && recentUser.getType() != 1008 && recentUser.getType() != 1005 && recentUser.getType() != 1009 && recentUser.getType() != 1021 && recentUser.getType() != 1001 && recentUser.getType() != 10002 && recentUser.getType() != 10004 && recentUser.getType() != 1022 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && (recentUser.getType() != 1 || !isHotChat(recentUser.uin))) {
                if (recentUser.getType() != 1006 || isSupportAbility(e.U3)) {
                    if (recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()))) {
                        if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv) {
                            arrayList.add(recentUser);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean z16 = this.mExtraData.getBoolean("isFromFavorite", false);
        boolean booleanExtra = this.mIntent.getBooleanExtra("isFromFavorites", false);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardMapOption realForwardTo isFromFavorite=" + z16 + "isFromFav=" + booleanExtra);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent.putExtras(this.mExtraData);
        if (!z16 && !booleanExtra) {
            if (this.isFormJump) {
                this.mActivity.startActivity(aliasIntent);
                this.mActivity.setResult(-1, aliasIntent);
                this.mActivity.finish();
                return true;
            }
            super.realForwardTo();
            return true;
        }
        ForwardUtils.w(this.app, this.mActivity, this.mAppContext, aliasIntent, null);
        this.mActivity.setResult(-1, aliasIntent);
        this.mActivity.finish();
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void setDialogPreviewImage(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQCustomDialog);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwwardMapOption", 2, "updateImageView:setDefaultDialogPreviewImage");
        }
        setPreviewImage(l.f(this.mActivity.getResources().getDrawable(R.drawable.b_2), this.mDensity), false, 0);
    }
}
