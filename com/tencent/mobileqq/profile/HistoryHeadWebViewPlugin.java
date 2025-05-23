package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class HistoryHeadWebViewPlugin extends VasWebviewJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    protected String f259773d;

    /* renamed from: e, reason: collision with root package name */
    protected String f259774e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f259775f = false;

    public static void p(Activity activity, int i3, int i16, ArrayList<PicInfo> arrayList, ArrayList<String> arrayList2, boolean z16, String str, int i17) {
        Intent intent = new Intent(activity, (Class<?>) FriendProfilePicBrowserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i16);
        bundle.putBoolean("AVATAR_TO_CIRCLE_PUBLISH_HISTORY", activity.getIntent().getBooleanExtra("AVATAR_TO_CIRCLE_PUBLISH_HISTORY", false));
        bundle.putInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", activity.getIntent().getIntExtra("AVATAR_TO_EXPERIENCE_FROM_TYPE", 0));
        if (arrayList != null) {
            bundle.putParcelableArrayList("picInfos", arrayList);
        }
        if (arrayList2 != null) {
            bundle.putStringArrayList("fileIdList", arrayList2);
        }
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, z16);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("src_id", str);
        }
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i17);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "historyhead";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("historyhead".equals(str2) && "showPicture".equals(str3) && strArr.length == 1) {
            showPicture(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (this.f259775f) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasHistoryHeadDel", this.f259775f);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_historyhead_refresh_numflag", "", 0, bundle), false, true);
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void showPicture(String str) {
        Activity a16;
        int i3;
        int switchRequestCode;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f259773d = jSONObject.optString("setName");
            this.f259774e = jSONObject.optString("delName");
            JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("str_fileids");
            int optInt = jSONObject.optInt("index");
            String optString = jSONObject.optString("srcID");
            int optInt2 = jSONObject.optInt(IProfileCardConst.KEY_FROM_TYPE);
            boolean optBoolean = jSONObject.optBoolean("isNotShowIndex", true);
            if (this.mRuntime.e() == null || this.mRuntime.b() == null || (a16 = this.mRuntime.a()) == null) {
                return;
            }
            if (a16 instanceof BasePluginActivity) {
                a16 = ((BasePluginActivity) a16).getOutActivity();
            }
            Activity activity = a16;
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.f258917e = optJSONArray.get(i16).toString();
                    picInfo.D = "type_history_head_pic";
                    arrayList.add(picInfo);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    arrayList2.add(optJSONArray2.get(i17).toString());
                }
            }
            WebViewProvider f16 = this.mRuntime.f();
            if (activity instanceof af) {
                switchRequestCode = ((af) activity).switchRequestCode(this, (byte) 100);
            } else if (f16 != null) {
                switchRequestCode = f16.switchRequestCode(this, (byte) 100);
            } else {
                i3 = 100;
                p(activity, optInt, optInt2, arrayList, arrayList2, optBoolean, optString, i3);
            }
            i3 = switchRequestCode;
            p(activity, optInt, optInt2, arrayList, arrayList2, optBoolean, optString, i3);
        } catch (JSONException unused) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        final Activity a16;
        if (b16 != 100 || i3 != -1 || this.mRuntime.e() == null || intent == null) {
            return;
        }
        if (intent.hasExtra("setHead_fileid") && !TextUtils.isEmpty(this.f259773d)) {
            String stringExtra = intent.getStringExtra("setHead_fileid");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            callJs(this.f259773d, s.l(stringExtra));
            if (intent.getBooleanExtra("gotoAvatarShare", false)) {
                ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToAvatarShareWindow(this.mRuntime.a(), intent.getBundleExtra("gotoAvatarShareBundle"));
            }
            if (!intent.getBooleanExtra("needFinish", false) || (a16 = this.mRuntime.a()) == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profile.HistoryHeadWebViewPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    a16.finish();
                }
            }, 500L);
            return;
        }
        if (!intent.hasExtra("delHead_fileid") || TextUtils.isEmpty(this.f259774e)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("delHead_fileid");
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        callJs(this.f259774e, s.l(stringExtra2));
        this.f259775f = true;
    }
}
