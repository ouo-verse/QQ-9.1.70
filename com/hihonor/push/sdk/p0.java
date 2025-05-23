package com.hihonor.push.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p0 implements Callable<List<HonorPushDataMsg>> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f36419a;

    public p0(Context context) {
        this.f36419a = context;
    }

    @Override // java.util.concurrent.Callable
    public List<HonorPushDataMsg> call() throws Exception {
        ArrayList<ContentValues> parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putString("pkg_name", this.f36419a.getPackageName());
        Bundle call = this.f36419a.getContentResolver().call(Uri.parse("content://com.hihonor.android.pushagent.provider.MessageBoxProvider/"), "query_unread_msg", "", bundle);
        ArrayList arrayList = new ArrayList();
        if (call != null && (parcelableArrayList = call.getParcelableArrayList("messages")) != null) {
            for (ContentValues contentValues : parcelableArrayList) {
                JSONObject jSONObject = new JSONObject();
                for (String str : contentValues.keySet()) {
                    jSONObject.put(str, contentValues.get(str));
                }
                HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
                honorPushDataMsg.setData(jSONObject.toString());
                honorPushDataMsg.setType(1);
                arrayList.add(honorPushDataMsg);
            }
        }
        return arrayList;
    }
}
