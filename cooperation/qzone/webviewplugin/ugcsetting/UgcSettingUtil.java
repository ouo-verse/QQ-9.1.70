package cooperation.qzone.webviewplugin.ugcsetting;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UgcSettingUtil {
    public static final String KEY_ANSWER = "key_answer";
    public static final String KEY_NICKNAMES = "key_nicknames";
    public static final String KEY_PARSE_JSON_STATUS = "key_parse_json_status";
    public static final String KEY_PERMISSION_CODE = "permission_code";
    public static final String KEY_QUESTION = "key_question";
    public static final String KEY_TAG_INFO = "key_selected_tag";
    public static final String KEY_UGC_SETTING_RAW_JSON = "key_setting_raw_json";
    public static final String KEY_UIN_LIST = "uin_list";
    private static final int PERMISSION_SAFE_FEED = 10;
    private static final int PERMITION_ALBUM_QUESTION = 5;
    private static final int PERMITION_ALL_PUBLIC = 0;
    private static final int PERMITION_BLACKLIST = 4;
    private static final int PERMITION_FRIENDS_CIRCLE = 6;
    private static final int PERMITION_ONLYSELF = 2;
    private static final int PERMITION_QQFRIEND = 1;
    private static final int PERMITION_WHITELIST = 3;
    public static final int UGCFLAG_ALBUM_QUESTION = 9999;
    public static final int UGCFLAG_ALL_PUBLIC = 1;
    public static final int UGCFLAG_BLACKLIST = 128;
    public static final int UGCFLAG_ONLYSELF = 64;
    public static final int UGCFLAG_QQFRIEND = 4;
    public static final int UGCFLAG_SAFE_FEED = 1024;
    public static final int UGCFLAG_SECONDCIRCLE = 512;
    public static final int UGCFLAG_WHITELIST = 16;

    public static String getPrivacyDescriptionForShuoShuo(int i3) {
        if (i3 != 4) {
            if (i3 == 16) {
                return "\u6307\u5b9a\u4eba";
            }
            if (i3 != 64) {
                if (i3 == 128) {
                    return "\u6307\u5b9a\u4eba";
                }
                return "\u516c\u5f00";
            }
            return "\u79c1\u5bc6";
        }
        return "\u597d\u53cb";
    }

    public static String liveUgcSettingToJson(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString(KEY_UGC_SETTING_RAW_JSON);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flag", bundle.getInt("permission_flag"));
            ArrayList<String> stringArrayList = bundle.getStringArrayList("uin_list");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_NICKNAMES);
            if (stringArrayList != null && !stringArrayList.isEmpty()) {
                if (stringArrayList2 != null && stringArrayList2.size() == stringArrayList.size()) {
                    JSONObject jSONObject2 = new JSONObject();
                    int size = stringArrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jSONObject2.put(stringArrayList.get(i3), stringArrayList2.get(i3));
                    }
                    jSONObject.put(SquareJSConst.Params.PARAMS_UIN_LIST, jSONObject2);
                    return jSONObject.toString();
                }
                return jSONObject.toString();
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Bundle parseJson(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(KEY_UGC_SETTING_RAW_JSON, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("id");
            if (i3 != 10) {
                switch (i3) {
                    case 1:
                        bundle.putInt(KEY_PERMISSION_CODE, 4);
                        break;
                    case 2:
                        bundle.putInt(KEY_PERMISSION_CODE, 64);
                        break;
                    case 3:
                        bundle.putInt(KEY_PERMISSION_CODE, 16);
                        break;
                    case 4:
                        bundle.putInt(KEY_PERMISSION_CODE, 128);
                        break;
                    case 5:
                        bundle.putInt(KEY_PERMISSION_CODE, 9999);
                        String optString = jSONObject.optString("question");
                        String optString2 = jSONObject.optString("answer");
                        bundle.putString(KEY_QUESTION, optString);
                        bundle.putString(KEY_ANSWER, optString2);
                        break;
                    case 6:
                        bundle.putInt(KEY_PERMISSION_CODE, 512);
                        break;
                    default:
                        bundle.putInt(KEY_PERMISSION_CODE, 1);
                        break;
                }
            } else {
                bundle.putInt(KEY_PERMISSION_CODE, 1024);
            }
            if (i3 == 3 || i3 == 4) {
                String str2 = "";
                if (jSONObject.has("msg")) {
                    str2 = jSONObject.optString("msg");
                }
                bundle.putString(KEY_TAG_INFO, str2);
                StringBuilder sb5 = new StringBuilder();
                if (i3 == 4) {
                    sb5.append("\u9664\u4e86 ");
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject(SquareJSConst.Params.PARAMS_UIN_LIST);
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator keys = jSONObject2.keys();
                boolean z16 = true;
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    arrayList.add(str3);
                    if (!z16) {
                        sb5.append("\u3001");
                    }
                    if (sb5.length() < 15) {
                        sb5.append(jSONObject2.getString(str3));
                    }
                    z16 = false;
                }
                String sb6 = sb5.toString();
                if (sb6.length() > 15) {
                    sb6 = sb6.substring(0, 15) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                bundle.putStringArrayList("uin_list", arrayList);
                bundle.putString(KEY_NICKNAMES, sb6);
            }
        } catch (Exception e16) {
            bundle.putInt(KEY_PERMISSION_CODE, 1);
            bundle.putString(KEY_PARSE_JSON_STATUS, e16.getMessage());
            e16.printStackTrace();
        }
        return bundle;
    }

    public static Bundle parseLiveJson(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(KEY_UGC_SETTING_RAW_JSON, str);
        StringBuilder sb5 = new StringBuilder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bundle.putInt("permission_flag", jSONObject.getInt("flag"));
            String str2 = "";
            if (jSONObject.has("msg")) {
                str2 = jSONObject.optString("msg");
            }
            bundle.putString(KEY_TAG_INFO, str2);
            JSONObject jSONObject2 = jSONObject.getJSONObject(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator keys = jSONObject2.keys();
            boolean z16 = true;
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                arrayList.add(str3);
                if (!z16) {
                    sb5.append("\u3001");
                }
                if (sb5.length() < 15) {
                    sb5.append(jSONObject2.getString(str3));
                }
                z16 = false;
            }
            String sb6 = sb5.toString();
            if (sb6.length() > 15) {
                sb6 = sb6.substring(0, 15) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            bundle.putStringArrayList("uin_list", arrayList);
            bundle.putString(KEY_NICKNAMES, sb6);
        } catch (Exception e16) {
            bundle.putInt("permission_flag", 1);
            bundle.putString(KEY_PARSE_JSON_STATUS, e16.getMessage());
            e16.printStackTrace();
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005d A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:31:0x0050, B:36:0x005d, B:39:0x0078, B:41:0x0088, B:45:0x0091, B:48:0x009c, B:50:0x00a7, B:52:0x00b7, B:53:0x00c2, B:55:0x00c7), top: B:30:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7 A[Catch: Exception -> 0x00cc, LOOP:0: B:49:0x00a5->B:50:0x00a7, LOOP_END, TryCatch #0 {Exception -> 0x00cc, blocks: (B:31:0x0050, B:36:0x005d, B:39:0x0078, B:41:0x0088, B:45:0x0091, B:48:0x009c, B:50:0x00a7, B:52:0x00b7, B:53:0x00c2, B:55:0x00c7), top: B:30:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String ugcSettingToJson(Bundle bundle) {
        JSONObject jSONObject;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        int size;
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString(KEY_UGC_SETTING_RAW_JSON);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        int i3 = 1;
        int i16 = bundle.getInt(KEY_PERMISSION_CODE, 1);
        try {
            if (i16 != 1) {
                if (i16 != 4) {
                    if (i16 != 16) {
                        if (i16 != 64) {
                            if (i16 != 128) {
                                if (i16 != 512) {
                                    if (i16 != 1024) {
                                        if (i16 == 9999) {
                                            i3 = 5;
                                        }
                                    } else {
                                        i3 = 10;
                                    }
                                } else {
                                    i3 = 6;
                                }
                            } else {
                                i3 = 4;
                            }
                        } else {
                            i3 = 2;
                        }
                    } else {
                        i3 = 3;
                    }
                }
                jSONObject = new JSONObject();
                jSONObject.put("id", i3);
                if (i3 != 3 && i3 != 4) {
                    if (i3 == 5) {
                        jSONObject.put("question", bundle.getString(KEY_QUESTION));
                        jSONObject.put("answer", bundle.getString(KEY_ANSWER));
                    }
                    return jSONObject.toString();
                }
                stringArrayList = bundle.getStringArrayList("uin_list");
                stringArrayList2 = bundle.getStringArrayList(KEY_NICKNAMES);
                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                    if (stringArrayList2 != null && stringArrayList2.size() == stringArrayList.size()) {
                        JSONObject jSONObject2 = new JSONObject();
                        size = stringArrayList.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            jSONObject2.put(stringArrayList.get(i17), stringArrayList2.get(i17));
                        }
                        jSONObject.put(SquareJSConst.Params.PARAMS_UIN_LIST, jSONObject2);
                        return jSONObject.toString();
                    }
                    return jSONObject.toString();
                }
                return jSONObject.toString();
            }
            jSONObject.put("id", i3);
            if (i3 != 3) {
                if (i3 == 5) {
                }
                return jSONObject.toString();
            }
            stringArrayList = bundle.getStringArrayList("uin_list");
            stringArrayList2 = bundle.getStringArrayList(KEY_NICKNAMES);
            if (stringArrayList != null) {
                if (stringArrayList2 != null) {
                    JSONObject jSONObject22 = new JSONObject();
                    size = stringArrayList.size();
                    while (i17 < size) {
                    }
                    jSONObject.put(SquareJSConst.Params.PARAMS_UIN_LIST, jSONObject22);
                    return jSONObject.toString();
                }
                return jSONObject.toString();
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
        i3 = 0;
        jSONObject = new JSONObject();
    }
}
