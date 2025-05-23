package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasFriendInfoHippyHelper {

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ChooseFriendReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private Promise f309450d;

        public ChooseFriendReceiver(Promise promise, Handler handler) {
            super(handler);
            this.f309450d = promise;
        }

        public void a(Promise promise) {
            this.f309450d = promise;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (i3 == 0 && bundle != null) {
                JSONObject b16 = VasFriendInfoHippyHelper.b(null, bundle.getStringArrayList("choose_friend_uins"), bundle.getStringArrayList("choose_friend_phones"), bundle.getStringArrayList("choose_friend_names"), null, bundle.getStringArrayList("choose_friend_group_uins"), bundle.getStringArrayList("choose_friend_group_names"), bundle.getIntegerArrayList("choose_friend_group_counts"), bundle.getIntegerArrayList("choose_friend_group_types"));
                if (b16 != null) {
                    try {
                        b16.put("dialog_input_callback", bundle.getString("emsg"));
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    this.f309450d.resolve(d.a(i3, "success", b16));
                    return;
                }
                return;
            }
            this.f309450d.reject(d.a(i3, "resultData is null", null));
        }
    }

    public static void a(Intent intent, Promise promise) {
        if (intent == null) {
            return;
        }
        try {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() != 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                String stringExtra = intent.getStringExtra("group_uin");
                String stringExtra2 = intent.getStringExtra("group_name");
                int intExtra = intent.getIntExtra("group_type", 0);
                int intExtra2 = intent.getIntExtra("group_member_type", 0);
                if (stringExtra != null) {
                    arrayList.add(stringExtra);
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                    arrayList2.add(stringExtra2);
                    arrayList3.add(Integer.valueOf(intExtra));
                    arrayList4.add(Integer.valueOf(intExtra2));
                }
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    arrayList5.add(resultRecord.uin);
                    arrayList6.add("");
                    arrayList7.add(resultRecord.name);
                    arrayList8.add(Integer.valueOf(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.i("VasFriendInfoHippyHelper", 2, "doChooseFriendResult...");
                }
                JSONObject b16 = b(intent, arrayList5, arrayList6, arrayList7, arrayList8, arrayList, arrayList2, arrayList4, arrayList3);
                QLog.i("VasFriendInfoHippyHelper", 2, "doChooseFriendResult: " + b16);
                if (b16 != null) {
                    promise.resolve(d.a(0, "success", b16));
                    return;
                }
                return;
            }
            promise.reject(d.a(-1, "friendsList is empty", null));
            if (QLog.isColorLevel()) {
                QLog.i("VasFriendInfoHippyHelper", 2, "friendsList is empty");
            }
        } catch (Exception e16) {
            promise.reject(d.a(-1, e16.toString(), null));
        }
    }

    protected static JSONObject b(Intent intent, List<String> list, List<String> list2, List<String> list3, List<Integer> list4, List<String> list5, List<String> list6, List<Integer> list7, List<Integer> list8) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            f(list, list2, list3, list4, jSONArray2);
            if (list5 != null && list6 != null && list7 != null && list8 != null) {
                jSONArray = g(list5, list6, list7, list8);
            } else {
                jSONArray = null;
            }
            jSONObject.put("friends", jSONArray2);
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put("groups", jSONArray);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VasFriendInfoHippyHelper", 2, jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void c(HippyMap hippyMap, Promise promise, Activity activity) {
        Activity h16 = h(activity);
        if (h16 != null && hippyMap != null && hippyMap.size() > 0) {
            if (hippyMap.getBoolean("isMulti")) {
                d(hippyMap, promise, h16);
                return;
            } else {
                e(promise, h16, hippyMap);
                return;
            }
        }
        promise.reject(d.a(-1, "params is empty", null));
    }

    private static void d(HippyMap hippyMap, Promise promise, Activity activity) {
        int i3;
        int i16;
        int i17;
        int i18;
        String str;
        int i19 = hippyMap.getInt("limitNum");
        if (i19 < 1) {
            promise.reject(d.a(-1, "maxNum shoude more than 1", null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        HippyMap map = hippyMap.getMap("from_group");
        int i26 = 0;
        if (map != null && map.size() > 0) {
            String string = hippyMap.getString("group_uin");
            int i27 = hippyMap.getInt("group_type");
            int i28 = hippyMap.getInt("enable_select_all");
            int i29 = hippyMap.getInt("enable_show_myself");
            int i36 = hippyMap.getInt("enable_show_myself_first");
            int i37 = hippyMap.getInt("forbid_only_choose_myself");
            HippyArray array = hippyMap.getArray("group_members");
            if (array != null && array.size() > 0) {
                while (i26 < array.size()) {
                    String string2 = array.getString(i26);
                    if (!TextUtils.isEmpty(string2)) {
                        arrayList.add(string2);
                    }
                    i26++;
                }
            }
            i26 = i27;
            i18 = i37;
            i17 = i36;
            i3 = i29;
            i16 = i28;
            str = string;
        } else {
            i3 = 1;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            str = null;
        }
        Intent startSelectMemberActivityIntentForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(activity);
        i(i19, str, i26, arrayList, i16, i3, i17, i18, startSelectMemberActivityIntentForJsPlugin);
        activity.startActivityForResult(startSelectMemberActivityIntentForJsPlugin, 49);
    }

    private static void e(Promise promise, Activity activity, HippyMap hippyMap) {
        boolean z16;
        boolean z17;
        boolean z18;
        ChooseFriendReceiver chooseFriendReceiver = new ChooseFriendReceiver(promise, new Handler());
        chooseFriendReceiver.a(promise);
        Parcel obtain = Parcel.obtain();
        boolean z19 = false;
        chooseFriendReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        OaidMonitor.parcelRecycle(obtain);
        String string = hippyMap.getString("title");
        if (TextUtils.isEmpty(string)) {
            string = HardCodeUtil.qqStr(R.string.uxw);
        }
        String string2 = hippyMap.getString("dialog_sub_title");
        String string3 = hippyMap.getString("dialog_input");
        int i3 = hippyMap.getInt("type");
        if ((i3 & 1) == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if ((i3 & 2) == 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if ((i3 & 12) == 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if ((i3 & 32) != 0) {
            z19 = true;
        }
        int i16 = hippyMap.getInt("business_type");
        int i17 = hippyMap.getInt("business_sub_type");
        ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 15);
        intent.putExtra("choose_friend_title", string);
        intent.putExtra("choose_friend_dialog_sub_title", string2);
        intent.putExtra("choose_friend_dialog_input", string3);
        intent.putExtra("choose_friend_is_qqfriends", z16);
        intent.putExtra("choose_friend_is_contacts", z17);
        intent.putExtra("choose_friend_is_groupchats", z18);
        intent.putExtra("choose_friend_is_create_group_chat", z19);
        intent.putExtra("choose_friend_callback", resultReceiver);
        intent.putExtra("choose_friend_businessType", i16);
        intent.putExtra("choose_friend_businessSubType", i17);
        activity.startActivityForResult(intent, 50);
    }

    private static void f(List<String> list, List<String> list2, List<String> list3, List<Integer> list4, JSONArray jSONArray) throws JSONException {
        String str;
        String str2;
        if (list != null && list2 != null && list3 != null) {
            for (int i3 = 0; i3 < list.size() && i3 < list2.size() && i3 < list3.size(); i3++) {
                String str3 = "";
                if (TextUtils.isEmpty(list.get(i3))) {
                    str = "";
                } else {
                    str = list.get(i3);
                }
                if (TextUtils.isEmpty(list2.get(i3))) {
                    str2 = "";
                } else {
                    str2 = list2.get(i3);
                }
                if (!TextUtils.isEmpty(list3.get(i3))) {
                    str3 = list3.get(i3);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uin", str);
                jSONObject.put("phone", str2);
                jSONObject.put("name", str3);
                if (list4 != null && list4.size() > i3) {
                    jSONObject.put("type", list4.get(i3));
                } else {
                    jSONObject.put("type", 1);
                }
                jSONArray.mo162put(jSONObject);
            }
        }
    }

    @NotNull
    private static JSONArray g(List<String> list, List<String> list2, List<Integer> list3, List<Integer> list4) throws JSONException {
        String str;
        int i3;
        int i16;
        JSONArray jSONArray = new JSONArray();
        for (int i17 = 0; i17 < list.size() && i17 < list2.size() && i17 < list3.size() && i17 < list4.size(); i17++) {
            String str2 = "";
            if (TextUtils.isEmpty(list.get(i17))) {
                str = "";
            } else {
                str = list.get(i17);
            }
            if (!TextUtils.isEmpty(list2.get(i17))) {
                str2 = list2.get(i17);
            }
            if (list3.get(i17) != null) {
                i3 = list3.get(i17).intValue();
            } else {
                i3 = 0;
            }
            if (list4.get(i17) != null) {
                i16 = list4.get(i17).intValue();
            } else {
                i16 = 0;
            }
            if (i16 == 4 || i16 == 8) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uin", str);
                jSONObject.put("name", str2);
                jSONObject.put("type", i16);
                jSONObject.put("count", i3);
                jSONArray.mo162put(jSONObject);
            }
        }
        return jSONArray;
    }

    private static Activity h(Activity activity) {
        while (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        return activity;
    }

    private static void i(int i3, String str, int i16, ArrayList<String> arrayList, int i17, int i18, int i19, int i26, Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i3);
        intent.addFlags(67108864);
        if (!TextUtils.isEmpty(str) && (i16 == 4 || i16 == 8)) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 32);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, false);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, true);
            intent.putExtra("group_uin", str);
            if (i17 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, z16);
            if (i18 != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, z17);
            if (i19 != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_IS_PUT_MYSELF_FIRST, z18);
            if (i26 != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_IS_FORBID_ONLY_CHOOSE_MYSELF, z19);
            if (arrayList.size() > 0) {
                if (arrayList.size() > i3) {
                    for (int size = arrayList.size() - 1; size >= i3; size--) {
                        arrayList.remove(size);
                    }
                }
                intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS, arrayList);
            }
            if (i16 == 4) {
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, false);
                return;
            } else {
                if (i16 == 8) {
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, false);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, true);
                    return;
                }
                return;
            }
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
    }
}
