package com.tencent.gdtad.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.params.GetUserInfoCallback;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationDialog;
import com.tencent.widget.AuthorizationItem;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtUserInfoAuthorizationHelper {
    public static final String KEY_CITY = "city";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    private static final String TAG = "GdtUserInfoAuthorizationHelper";
    private static volatile GdtUserInfoAuthorizationHelper sInstance;

    @NonNull
    public GdtThirdProcessorProxy thirdProcessorProxy = new GdtThirdProcessorProxy();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface UserInfoCallback {
        void onUserInfo(UserInfoEntity userInfoEntity);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class UserInfoEntity {
        public static final int ERROR_CODE_CANCEL = 2;
        public static final int ERROR_CODE_FAIL = 1;
        public static final int ERROR_CODE_SUCCESS = 0;
        public final String city;
        public int errCode;
        public final String name;
        public final String phone;

        static /* synthetic */ UserInfoEntity access$300() {
            return empty();
        }

        @NonNull
        private static UserInfoEntity empty() {
            return new UserInfoEntity("", "", "", 1);
        }

        public String getInfoByKey(String str) {
            if (TextUtils.equals(str, AuthorizationItem.ITEM_TYPE_USER_NAME.key)) {
                return this.name;
            }
            if (TextUtils.equals(str, AuthorizationItem.ITEM_TYPE_PHONE.key)) {
                return this.phone;
            }
            if (TextUtils.equals(str, AuthorizationItem.ITEM_TYPE_PLACE.key)) {
                return this.city;
            }
            return "";
        }

        @NonNull
        public String toJson(@NonNull List<AuthorizationItem.ItemType> list) {
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < list.size(); i3++) {
                try {
                    String infoByKey = getInfoByKey(list.get(i3).key);
                    if (!TextUtils.isEmpty(infoByKey)) {
                        jSONObject.put(list.get(i3).key, infoByKey);
                    }
                } catch (Exception e16) {
                    QLog.e(GdtUserInfoAuthorizationHelper.TAG, 1, e16, new Object[0]);
                }
            }
            return jSONObject.toString();
        }

        @NonNull
        public String toString() {
            return "UserInfoEntity : [name -> " + this.name + ", phone -> " + this.phone + ", city -> " + this.city + ", errCode -> " + this.errCode + "]";
        }

        UserInfoEntity(String str, String str2, String str3) {
            this(str, str2, str3, 0);
        }

        UserInfoEntity(String str, String str2, String str3, int i3) {
            this.name = str;
            this.phone = str2;
            this.city = str3;
            this.errCode = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Comparator<AuthorizationItem.ItemType> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NonNull AuthorizationItem.ItemType itemType, @NonNull AuthorizationItem.ItemType itemType2) {
            return itemType.typeValue - itemType2.typeValue;
        }
    }

    GdtUserInfoAuthorizationHelper() {
    }

    private boolean checkAuthorize(@NonNull Context context, @NonNull List<AuthorizationItem.ItemType> list) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Iterator<AuthorizationItem.ItemType> it = list.iterator();
        while (it.hasNext()) {
            if (!defaultSharedPreferences.getBoolean(it.next().key, false)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "checkAuthorize user phone not authorize");
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public UserInfoEntity createEntity(String str, String str2, String str3, @NonNull List<AuthorizationItem.ItemType> list) {
        if (!list.contains(AuthorizationItem.ITEM_TYPE_USER_NAME)) {
            str = "";
        }
        if (!list.contains(AuthorizationItem.ITEM_TYPE_PHONE)) {
            str2 = "";
        }
        if (!list.contains(AuthorizationItem.ITEM_TYPE_PLACE)) {
            str3 = "";
        }
        return new UserInfoEntity(str, str2, str3);
    }

    public static GdtUserInfoAuthorizationHelper getInstance() {
        if (sInstance == null) {
            synchronized (GdtUserInfoAuthorizationHelper.class) {
                if (sInstance == null) {
                    sInstance = new GdtUserInfoAuthorizationHelper();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInfoResult(@NonNull Activity activity, boolean z16, @NonNull UserInfoEntity userInfoEntity, @Nullable UserInfoCallback userInfoCallback, @NonNull List<AuthorizationItem.ItemType> list) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleInfoResult: entity -> " + userInfoEntity);
        }
        if (z16) {
            if (checkAuthorize(activity, list)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleInfoResult has authorized, return info direct ");
                }
                if (userInfoCallback != null) {
                    userInfoEntity.errCode = 0;
                    userInfoCallback.onUserInfo(userInfoEntity);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleInfoResult show authorize dialog to authorize user info");
            }
            AuthorizationDialog authorizationDialog = new AuthorizationDialog(activity, userInfoEntity, userInfoCallback, list);
            Window window = authorizationDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.f173293c);
            }
            authorizationDialog.show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleInfoResult get result fail");
        }
        if (userInfoCallback != null) {
            userInfoCallback.onUserInfo(UserInfoEntity.access$300());
        }
        QQToast.makeText(activity, activity.getString(R.string.iii), 0).show();
    }

    private void sortAndDelDuplicateElement(@NonNull List<AuthorizationItem.ItemType> list) {
        HashSet hashSet = new HashSet(list);
        hashSet.remove(AuthorizationItem.ITEM_TYPE_NONE);
        list.clear();
        list.addAll(hashSet);
        Collections.sort(list, new a());
    }

    public void getUserInfo(@Nullable final Activity activity, @Nullable final List<AuthorizationItem.ItemType> list, final UserInfoCallback userInfoCallback) {
        if (list != null) {
            sortAndDelDuplicateElement(list);
        }
        if (activity != null && list != null && list.size() > 0) {
            this.thirdProcessorProxy.gdtGetCurrentUserInfo(new GetUserInfoCallback() { // from class: com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1
                @Override // com.tencent.gdtad.params.GetUserInfoCallback
                public void callback(@NonNull Bundle bundle) {
                    boolean z16;
                    final boolean z17;
                    String string = bundle.getString("name");
                    String string2 = bundle.getString("phone");
                    String string3 = bundle.getString("city");
                    if (QLog.isColorLevel()) {
                        QLog.d(GdtUserInfoAuthorizationHelper.TAG, 2, "getUserInfo : name -> " + string + ", phone -> " + string2 + ", city -> " + string3);
                    }
                    if (list.contains(AuthorizationItem.ITEM_TYPE_USER_NAME) && TextUtils.isEmpty(string)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (list.contains(AuthorizationItem.ITEM_TYPE_PHONE) && TextUtils.isEmpty(string2)) {
                        z16 = false;
                    }
                    if (list.contains(AuthorizationItem.ITEM_TYPE_PLACE) && TextUtils.isEmpty(string3)) {
                        z17 = false;
                    } else {
                        z17 = z16;
                    }
                    final UserInfoEntity createEntity = GdtUserInfoAuthorizationHelper.this.createEntity(string, string2, string3, list);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        GdtUserInfoAuthorizationHelper.this.handleInfoResult(activity, z17, createEntity, userInfoCallback, list);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                GdtUserInfoAuthorizationHelper.this.handleInfoResult(activity, z17, createEntity, userInfoCallback, list);
                            }
                        });
                    }
                }
            });
        }
    }
}
