package fa1;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZoneNumberUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g implements b {
    @Override // fa1.b
    public int getType() {
        return R.color.darker_gray;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        String subType = colorNote.getSubType();
        if (subType.startsWith("qzone_detail")) {
            try {
                JSONObject jSONObject = new JSONObject(new String(colorNote.getReserve()));
                int i3 = jSONObject.getInt("appid");
                String string = jSONObject.getString(s4.c.CELLID);
                String string2 = jSONObject.getString("subid");
                Long valueOf = Long.valueOf(jSONObject.getLong("uin"));
                String string3 = jSONObject.getString("mainTitle");
                String string4 = jSONObject.getString(QCircleLpReportDc010001.KEY_SUBTYPE);
                Bundle bundle = new Bundle();
                bundle.putString("mainTitle", string3);
                bundle.putString(QCircleLpReportDc010001.KEY_SUBTYPE, string4);
                QZoneHelper.UserInfo.getInstance();
                QZoneHelper.forwardToDetail(context, valueOf.toString(), i3 + "", string, string2, bundle);
                return;
            } catch (JSONException e16) {
                QLog.e("QZoneLauncher", 1, e16, new Object[0]);
                return;
            }
        }
        if (subType.startsWith("qzone_userhome")) {
            try {
                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(context, QZoneNumberUtil.safeParseLong(new JSONObject(new String(colorNote.getReserve())).getString("visitUin"), 0L), false, 0);
                return;
            } catch (JSONException e17) {
                QLog.e("QZoneLauncher", 1, e17, new Object[0]);
                return;
            }
        }
        if (subType.startsWith("qzone_famous_userhome")) {
            try {
                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(context, QZoneNumberUtil.safeParseLong(new JSONObject(new String(colorNote.getReserve())).getString("visitUin"), 0L), true, 0);
            } catch (JSONException e18) {
                QLog.e("QZoneLauncher", 1, e18, new Object[0]);
            }
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
