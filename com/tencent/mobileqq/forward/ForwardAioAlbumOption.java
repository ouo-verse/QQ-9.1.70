package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardAioAlbumOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardAioAlbumOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.mSurpportTroopDiscussionTmpConv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mConfirmDialog.setMessage((CharSequence) null);
            this.mConfirmDialog.setMessageCount(this.mForwardText);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.buildForwardAbility();
        if (this.mIntent.getBooleanExtra("k_dataline", true)) {
            this.mForwardAbilities.add(e.S3);
            this.mForwardAbilities.add(e.X3);
            this.mForwardAbilities.add(e.f211017e4);
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
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (this.mForwardText != null) {
                URLDrawableHelper.decodeLocalImage(uRLDrawable, this.app.getCurrentAccountUin(), false);
            } else {
                URLDrawableHelper.decodeLocalImage(uRLDrawable, this.app.getCurrentAccountUin(), true);
            }
        }
        if (drawable == null) {
            return;
        }
        int i3 = ForwardBaseOption.mURLDrawableUrlWidth;
        drawable.setBounds(0, 0, i3, i3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1003 && recentUser.getType() != 10004 && recentUser.getType() != 1008 && recentUser.getType() != 1021 && (recentUser.getType() != 1 || !isHotChat(recentUser.uin))) {
                if (recentUser.getType() != 1006 || isSupportAbility(e.U3)) {
                    if (recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()))) {
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
    public void sendDatalineMultiple(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        ArrayList parcelableArrayList = this.mExtraData.getParcelableArrayList("fileinfo_array");
        if (parcelableArrayList == null) {
            parcelableArrayList = null;
        }
        ArrayList<String> arrayList = (ArrayList) this.mExtraData.get("PhotoConst.PHOTO_PATHS");
        intent.putExtra("dataline_forward_type", 101);
        intent.putExtra("sendMultiple", true);
        if (parcelableArrayList == null) {
            intent.putStringArrayListExtra("dataline_forward_pathlist", arrayList);
        }
    }
}
