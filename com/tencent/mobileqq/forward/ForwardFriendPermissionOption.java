package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class ForwardFriendPermissionOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f210659d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.matchfriend.utils.d f210660e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f210661d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f210662e;

        a(ActionSheet actionSheet, List list) {
            this.f210661d = actionSheet;
            this.f210662e = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardFriendPermissionOption.this, actionSheet, list);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            Activity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                ForwardFriendPermissionOption forwardFriendPermissionOption = ForwardFriendPermissionOption.this;
                if (forwardFriendPermissionOption.app != null && (activity = forwardFriendPermissionOption.mActivity) != null) {
                    if (!NetworkUtil.isNetSupport(activity)) {
                        QQToastUtil.showQQToast(1, R.string.f171002mk);
                        this.f210661d.dismiss();
                        return;
                    }
                    ((IFriendHandlerService) ForwardFriendPermissionOption.this.app.getRuntimeService(IFriendHandlerService.class, "")).setBatchFriendPermission(this.f210662e, 0);
                }
                ForwardFriendPermissionOption.this.showProgressDialog(R.string.cpr);
                this.f210661d.dismiss();
            }
        }
    }

    public ForwardFriendPermissionOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        ArrayList<String> stringArrayListExtra = this.mIntent.getStringArrayListExtra("only_chat_uins");
        this.f210659d = stringArrayListExtra;
        if (stringArrayListExtra == null) {
            this.f210659d = new ArrayList<>();
        }
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(this.mAppContext);
        this.f210660e = dVar;
        dVar.c("pg_only_chatremove", null);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_only_chatremove_complete");
        dVar.b(arrayList);
        dVar.i(null);
    }

    private void m(List<String> list) {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            String string = this.mActivity.getString(R.string.f2042352c);
            String string2 = this.mActivity.getString(R.string.f2042252b);
            ActionSheet create = ActionSheet.create(this.mActivity);
            create.setMainTitle(string);
            create.setRoundCornerTop(true);
            create.addButton(string2, 3);
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new a(create, list));
            create.show();
            create.setTitleSize(12);
            return;
        }
        QLog.e("ForwardFriendPermissionOption", 1, "mActivity is null or isFinishing");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<ResultRecord> parcelableArrayList = bundle.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayList != null) {
            for (ResultRecord resultRecord : parcelableArrayList) {
                if (!TextUtils.isEmpty(resultRecord.uin)) {
                    arrayList.add(resultRecord.uin);
                }
            }
        } else {
            String string = bundle.getString("uin");
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        QLog.d("ForwardFriendPermissionOption", 1, "buildForwardDialog set size:" + arrayList.size());
        HashMap hashMap = new HashMap();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            hashMap.put("to_uin", it.next());
            this.f210660e.e("em_only_chatremove_complete", hashMap);
        }
        m(arrayList);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f210659d.iterator();
        while (it.hasNext()) {
            String next = it.next();
            RecentUser recentUser = new RecentUser();
            recentUser.uin = next;
            recentUser.type = 0;
            arrayList.add(recentUser);
        }
        QLog.d("ForwardFriendPermissionOption", 1, "ForwardFriendPermissionOption getList size:" + arrayList.size());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String stringExtra = this.mIntent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_TITLE);
        if (TextUtils.isEmpty(stringExtra)) {
            return "\u9009\u62e9\u597d\u53cb";
        }
        return stringExtra;
    }

    public ArrayList<String> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f210659d;
    }
}
