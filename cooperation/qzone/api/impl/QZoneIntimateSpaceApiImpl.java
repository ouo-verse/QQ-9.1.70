package cooperation.qzone.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.business.tianshu.k;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.event.QZoneDestroyIntimateBubbleEvent;
import com.qzone.reborn.intimate.request.QZoneIntimateRedDotReaderRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import yo.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneIntimateSpaceApiImpl implements IQZoneIntimateSpaceApi {
    public static final String URL_QUERY_SPLITTER = "?";

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public void dispatchDestroyIntimateBubbleEvent() {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneDestroyIntimateBubbleEvent());
    }

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public BaseRequest getRedDotReaderRequest(long j3, boolean z16, int i3, String str) {
        return new QZoneIntimateRedDotReaderRequest(j3, z16, i3, str);
    }

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public int handleScheme(String str, Context context, String str2) {
        return d.d(str, context, str2);
    }

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public int handleSchemeWithSpaceId(String str, String str2, Context context, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        StringBuilder sb5 = new StringBuilder(str);
        if (str.contains(URL_QUERY_SPLITTER)) {
            sb5.append("&space_id=");
            sb5.append(str2);
        } else {
            sb5.append("?space_id=");
            sb5.append(str2);
        }
        return d.d(sb5.toString(), context, str3);
    }

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public boolean isPartnerSpaceEntranceSwitchOpen() {
        return g.f53821a.b().a0();
    }

    @Override // cooperation.qzone.api.IQZoneIntimateSpaceApi
    public void releaseGuideBubbleResources(Runnable runnable) {
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        k.i().j();
    }
}
