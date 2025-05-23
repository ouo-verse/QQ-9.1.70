package com.tencent.mobileqq.phonecontact.api;

import android.accounts.Account;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.data.d;
import com.tencent.mobileqq.qroute.annotation.Service;
import friendlist.GetOnlineInfoResp;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes16.dex */
public interface IContactSyncService extends IRuntimeService {
    void deleteSyncContact(String str);

    String getMimeTypeByJumpUri(Uri uri);

    String getMobileNoByJumpUri(Uri uri);

    String getNetworkDescription(GetOnlineInfoResp getOnlineInfoResp);

    d getSimplePhoneContactByJumpUri(Uri uri);

    String getStatusDescription(GetOnlineInfoResp getOnlineInfoResp);

    String getSyncAccountUin();

    boolean isSyncContactAllowed();

    boolean isSyncSupportForTheDevice();

    void markAccountDeleteByUser(AppInterface appInterface, Account account);

    void setSyncContactAllowed(boolean z16);

    boolean syncAllContacts(int i3);
}
