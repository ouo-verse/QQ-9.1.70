package com.tencent.mobileqq.wink.publish.viewmodel;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class m extends BaseViewModel {
    public static final String D = UploadConstants.TAG + "PublishFriendsViewModel";

    /* renamed from: i, reason: collision with root package name */
    MutableLiveData<List<Friends>> f326053i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    MutableLiveData<Friends> f326054m = new MutableLiveData<>();
    MutableLiveData<List<SoftReference<Drawable>>> C = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            List<Friends> M1 = m.this.M1(eIPCResult.data.getString(QQWinkConstants.PUBLISH_KEY_FRIENDSLIST));
            if (M1 != null && M1.size() > 0) {
                m.this.f326053i.postValue(M1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Friends> M1(String str) {
        w53.b.f(D, "fetchMyFriends result:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("uin");
                    if (!TextUtils.isEmpty(optString)) {
                        Friends friends = new Friends();
                        friends.uin = optString;
                        friends.remark = jSONObject.optString("remark");
                        friends.name = jSONObject.optString("name");
                        arrayList.add(friends);
                    }
                }
            }
        } catch (Exception e16) {
            w53.b.d(D, "convertToFriends error", e16);
        }
        return arrayList;
    }

    public void N1() {
        w53.b.f(D, "start fetchMyFriends");
        QIPCClientHelper.getInstance().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_GET_FRIENDS, null, new a());
    }

    public MutableLiveData<List<Friends>> O1() {
        return this.f326053i;
    }

    public MutableLiveData<List<SoftReference<Drawable>>> P1() {
        return this.C;
    }

    public MutableLiveData<Friends> Q1() {
        return this.f326054m;
    }

    public void R1(Friends friends) {
        this.f326054m.postValue(friends);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return D;
    }
}
