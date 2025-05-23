package com.tencent.icgame.game.liveroom.impl.room.payguide.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DialogShowValModel implements Serializable {
    public String curDate;
    public int hasShowCount;

    public static DialogShowValModel getModel(String str) {
        DialogShowValModel dialogShowValModel = new DialogShowValModel();
        if (TextUtils.isEmpty(str)) {
            return dialogShowValModel;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            dialogShowValModel.curDate = jSONObject.optString("curDate");
            dialogShowValModel.hasShowCount = jSONObject.optInt("hasShowCount", 0);
        } catch (JSONException e16) {
            QLog.i("ICGameDialogShowValModel", 1, "DialogShowValModel JSONException e" + e16);
        }
        return dialogShowValModel;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("curDate", this.curDate);
            jSONObject.put("hasShowCount", this.hasShowCount);
        } catch (JSONException e16) {
            QLog.i("ICGameDialogShowValModel", 1, "toString JSONException e" + e16);
        }
        QLog.i("ICGameDialogShowValModel", 1, "toString jsonObject.toString()" + jSONObject.toString());
        return jSONObject.toString();
    }
}
