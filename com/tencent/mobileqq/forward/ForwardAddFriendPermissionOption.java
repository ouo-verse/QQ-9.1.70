package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes12.dex */
public class ForwardAddFriendPermissionOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.matchfriend.utils.d f210551d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f210552e;

    public ForwardAddFriendPermissionOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        ArrayList<String> stringArrayListExtra = this.mIntent.getStringArrayListExtra("only_chat_uins");
        this.f210552e = stringArrayListExtra;
        if (stringArrayListExtra == null) {
            this.f210552e = new ArrayList<>();
        }
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(this.mAppContext);
        this.f210551d = dVar;
        dVar.c("pg_only_chatadd", null);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_only_chat_add");
        dVar.b(arrayList);
        dVar.i(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mForwardAbilities.add(e.N3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        if (this.app != null && (activity = this.mActivity) != null) {
            if (!NetworkUtil.isNetSupport(activity)) {
                QQToastUtil.showQQToast(1, R.string.f171002mk);
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
            HashMap hashMap = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashMap.put("to_uin", (String) it.next());
                this.f210551d.e("em_only_chat_add", hashMap);
            }
            ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class, "")).setBatchFriendPermission(arrayList, 1);
            showProgressDialog(R.string.cpr);
        }
    }
}
