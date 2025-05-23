package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardH5RabbitSpringEmoteOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardH5RabbitSpringEmoteOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mForwardAbilities.add(e.O3);
            this.mForwardAbilities.add(e.P3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void filterRecentForwardList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                RecentUser recentUser = list.get(size);
                int type = recentUser.getType();
                if (type != 0 && type != 1) {
                    list.remove(recentUser);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null) {
                if (this.mForwardAbilities.contains(e.O3) && recentUser.getType() == 0) {
                    arrayList.add(recentUser);
                }
                if (this.mForwardAbilities.contains(e.P3) && recentUser.getType() == 1) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.a
    public boolean isInterceptForwardDialog(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resultRecord)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.a
    public void onListViewItemClicked(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) resultRecord);
            return;
        }
        ReportController.o(this.app, "dc00898", "", "", "friendchoose", "0X8009D93", getForwardSrcBusinessType(), 0, "", "", "", "");
        if (resultRecord == null) {
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        m3.putExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB, true);
        m3.putExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB_SOURCE, "h5_spring_fastvial");
        m3.putExtra("uintype", resultRecord.getUinType());
        m3.putExtra("uin", resultRecord.uin);
        m3.putExtra("uinname", resultRecord.name);
        m3.putExtra("open_chatfragment_withanim", true);
        this.mActivity.startActivity(m3);
    }

    @Override // com.tencent.mobileqq.forward.a
    public void wrapCreateNewChatIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_TROOP, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_DISCUSSION, true);
        }
    }
}
