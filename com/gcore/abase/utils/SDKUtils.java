package com.gcore.abase.utils;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SDKUtils {
    private static final String GCLOUD_INFO_FILE = "GCloudInfo.json";

    public static List<String> getAllSDKNames(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray names = new JSONObject(getGCloudInfo(context)).getJSONObject("PackageVersions").names();
            for (int i3 = 0; i3 < names.length(); i3++) {
                arrayList.add(names.getString(i3));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    private static String getGCloudInfo(Context context) {
        try {
            return FileUtils.readStreamToString(context.getAssets().open(GCLOUD_INFO_FILE));
        } catch (IOException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String getSDKVersion(Context context, String str) {
        try {
            return new JSONObject(getGCloudInfo(context)).getJSONObject("PackageVersions").getString(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
