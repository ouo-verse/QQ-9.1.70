package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class PublicAccountShowPictureReport {
    public String articleId;
    public String imgCount;
    public boolean isReport;
    public int leave_mode = 2;
    private HashSet<Integer> pic_index_arr;
    public String puin;
    public int slide_number;
    private long time_on_show_end;
    private long time_on_show_start;
    public String uin;

    public void addPicIndex(int i3) {
        if (this.pic_index_arr == null) {
            this.pic_index_arr = new HashSet<>();
        }
        this.pic_index_arr.add(Integer.valueOf(i3));
    }

    public void parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            parse(new JSONObject(str));
        } catch (JSONException unused) {
        }
    }

    public void report(QQAppInterface qQAppInterface) {
        if (!this.isReport) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        HashSet<Integer> hashSet = this.pic_index_arr;
        if (hashSet != null) {
            Iterator<Integer> it = hashSet.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(",");
            }
        }
        ReportController.n(qQAppInterface, "dc00899", IPublicAccountHandler.MAIN_ACTION, this.puin, "0X80066AB", "0X80066AB", this.slide_number - 1, Integer.parseInt(this.imgCount), 0, this.articleId, sb5.toString(), this.leave_mode + "", (this.time_on_show_end - this.time_on_show_start) + "");
    }

    public void reset() {
        this.isReport = false;
        HashSet<Integer> hashSet = this.pic_index_arr;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.leave_mode = 2;
        this.slide_number = 0;
        this.time_on_show_start = 0L;
        this.time_on_show_end = 0L;
    }

    public void showEnd() {
        this.time_on_show_end = System.currentTimeMillis();
    }

    public void showStart() {
        this.time_on_show_start = System.currentTimeMillis();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uin", this.uin);
            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, this.puin);
            jSONObject.put("articleId", this.articleId);
            jSONObject.put("imgCount", this.imgCount);
            jSONObject.put("isReport", this.isReport);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        reset();
        this.uin = jSONObject.optString("uin");
        this.puin = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN);
        this.articleId = jSONObject.optString("articleId");
        this.imgCount = jSONObject.optString("imgCount");
        this.isReport = jSONObject.optBoolean("isReport");
    }
}
