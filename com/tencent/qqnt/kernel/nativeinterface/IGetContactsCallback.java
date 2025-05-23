package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IGetContactsCallback {
    void onResult(int i3, String str, ArrayList<RecentContactInfo> arrayList, ArrayList<Contact> arrayList2);
}
