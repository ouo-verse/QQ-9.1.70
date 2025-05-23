package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class BottomItem {
    private static final String TAG = "BottomItem";
    public String content;
    public String url;

    public BottomItem() {
    }

    public JSONObject convertToJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", this.content);
            jSONObject.put("url", this.url);
        } catch (JSONException e16) {
            QZLog.e(TAG, "convert json error", e16);
        }
        return jSONObject;
    }

    public BottomItem(String str, String str2) {
        this.content = str;
        this.url = str2;
    }

    public static BottomItem parseFromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BottomItem bottomItem = new BottomItem();
        bottomItem.content = jSONObject.optString("content");
        bottomItem.url = jSONObject.optString("url");
        return bottomItem;
    }

    public static ArrayList<BottomItem> readFromeList(ArrayList<BottomContentItem> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<BottomItem> arrayList2 = new ArrayList<>();
        Iterator<BottomContentItem> it = arrayList.iterator();
        while (it.hasNext()) {
            BottomContentItem next = it.next();
            if (next != null) {
                BottomItem bottomItem = new BottomItem();
                bottomItem.content = next.content;
                bottomItem.url = next.url;
                arrayList2.add(bottomItem);
            }
        }
        return arrayList2;
    }
}
