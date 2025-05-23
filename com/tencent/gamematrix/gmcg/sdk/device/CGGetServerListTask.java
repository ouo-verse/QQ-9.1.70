package com.tencent.gamematrix.gmcg.sdk.device;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGetServerListTask extends AsyncTask<Void, Integer, List<String>> {
    private static final String HttpMethod = "GET";
    private String mReqTag;
    private GetServerListResultListener mResultListener;
    private String mUrlAddress;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetServerListResultListener {
        void onServerListGot(String str, List<String> list, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CGGetServerListTask(String str, String str2, GetServerListResultListener getServerListResultListener) {
        this.mReqTag = str;
        this.mResultListener = getServerListResultListener;
        this.mUrlAddress = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public List<String> doInBackground(Void... voidArr) {
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrlAddress).openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            bufferedReader.close();
            try {
                JSONObject jSONObject = new JSONObject(sb5.toString());
                if (Integer.parseInt(jSONObject.getString("ret")) == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("gateway");
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        JSONArray jSONArray = jSONObject2.getJSONArray(keys.next().toString());
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("ip");
                            int i16 = jSONObject3.getInt("kcpPort");
                            for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                                arrayList.add(jSONArray2.getString(i17) + ":" + i16);
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            GetServerListResultListener getServerListResultListener = this.mResultListener;
            if (getServerListResultListener != null) {
                getServerListResultListener.onServerListGot(this.mReqTag, arrayList, false);
            }
            return arrayList;
        } catch (IOException e17) {
            e17.printStackTrace();
            GetServerListResultListener getServerListResultListener2 = this.mResultListener;
            if (getServerListResultListener2 != null) {
                getServerListResultListener2.onServerListGot(this.mReqTag, null, false);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(List<String> list) {
        GetServerListResultListener getServerListResultListener = this.mResultListener;
        if (getServerListResultListener != null) {
            getServerListResultListener.onServerListGot(this.mReqTag, list, true);
        }
    }
}
