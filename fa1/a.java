package fa1;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements b {
    private void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("jumpto", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
            jSONObject2.put("comic", jSONObject);
        } catch (Exception unused) {
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTER_VIPCOMIC);
        activityURIRequest.extra().putString("options", jSONObject2.toString());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    private void b(Context context, ColorNote colorNote) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
        intent.putExtra("url", colorNote.getSubType());
        intent.putExtra(QCircleLpReportDc010001.KEY_SUBTYPE, colorNote.mSubType);
        intent.putExtra("fragmentStyle", 1);
        intent.putExtra("tabBarStyle", 1);
        intent.putExtra("titleBarStyle", 1);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void c(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("jumpto", "com.qqcomic.reader.VipComicReadingActivityV2");
            jSONObject2.put("comic", jSONObject);
            jSONObject2.put("from", Integer.parseInt("1041001"));
        } catch (Exception unused) {
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTER_VIPCOMIC);
        activityURIRequest.extra().putString("options", jSONObject2.toString());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // fa1.b
    public int getType() {
        return R.id.empty;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        JSONObject jSONObject;
        byte[] reserve;
        try {
            reserve = colorNote.getReserve();
        } catch (JSONException e16) {
            QLog.e("BoodoLauncher", 1, e16, new Object[0]);
            jSONObject = null;
        }
        if (reserve == null) {
            QLog.e("BoodoLauncher", 2, "color note reserve is null");
            return;
        }
        jSONObject = new JSONObject(new String(reserve));
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("colorNoteType", 0);
            if (optInt == 2) {
                b(context, colorNote);
            } else if (optInt == 1) {
                c(context, jSONObject);
            } else if (optInt == 3) {
                a(context, jSONObject);
            }
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
