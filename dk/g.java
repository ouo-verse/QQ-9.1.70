package dk;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.request.QZoneIntimateGetUserIntimateSpaceByTypeRequest;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import common.config.service.QzoneConfig;
import java.util.List;
import qzone.QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp;
import qzone.QZIntimateProfileReader$SpaceTypeWithJumpUrl;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends ck.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f394014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f394015b;

        a(int i3, Context context) {
            this.f394014a = i3;
            this.f394015b = context;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp qZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp) {
            QLog.d(g.this.c(), 1, "[requestGetUserIntimateSpaceByType] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", traceId: " + baseRequest.getTraceId());
            g.this.g(z16, str, this.f394014a, this.f394015b, qZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp);
        }
    }

    private void i(QZIntimateProfileReader$SpaceTypeWithJumpUrl qZIntimateProfileReader$SpaceTypeWithJumpUrl, Context context, String str, int i3) {
        if (ArrayUtils.isOutOfArrayIndex(0, qZIntimateProfileReader$SpaceTypeWithJumpUrl.uids.get())) {
            QLog.e("QZoneIntimateQueryOpenSpacePageParser", 1, "draft space uid list is empty");
            QQToast.makeText(context, 1, str, 0).show();
            return;
        }
        String str2 = "&from=" + i3;
        String str3 = "&spacetype=" + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_type.get();
        StringBuilder sb5 = new StringBuilder("&uids=");
        List<String> list = qZIntimateProfileReader$SpaceTypeWithJumpUrl.uids.get();
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (!TextUtils.isEmpty(list.get(i16))) {
                sb5.append(list.get(i16));
                if (i16 != list.size() - 1) {
                    sb5.append(",");
                }
            }
        }
        String str4 = "mqzone://arouse/intimate/openspacepage?tabid=mqzone://arouse/intimate/openspacepage?&isdraft=1" + str2 + str3 + ((Object) sb5);
        QLog.i("QZoneIntimateQueryOpenSpacePageParser", 1, "draft space schema is " + str4);
        yo.d.c(str4, context);
    }

    private void j(Context context, int i3, boolean z16) {
        String str;
        String str2 = "uid=" + LoginData.getInstance().getUid();
        String str3 = "&from=" + i3;
        if (z16) {
            str = "&opencreatepage=1";
        } else {
            str = "";
        }
        yo.d.c(QzoneConfig.DEFAULT_INTIMATE_SPACE_MANAGER_PAGE + str2 + str3 + str, context);
    }

    private void k(QZIntimateProfileReader$SpaceTypeWithJumpUrl qZIntimateProfileReader$SpaceTypeWithJumpUrl, Context context, String str, int i3) {
        if (TextUtils.isEmpty(qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_id.get())) {
            QLog.e("QZoneIntimateQueryOpenSpacePageParser", 1, "space id is empty");
            QQToast.makeText(context, 1, str, 0).show();
            return;
        }
        yo.d.c("mqzone://arouse/intimate/openspacepage?tabid=0" + ("&from=" + i3) + ("&spaceid=" + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_id.get()), context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ck.b
    public String c() {
        return "QZoneIntimateQueryOpenSpacePageParser";
    }

    @Override // ck.b
    public void e(Context context, QZoneSchemeBean qZoneSchemeBean) {
        int i3;
        int i16;
        if (qZoneSchemeBean == null || qZoneSchemeBean.getAttrs() == null) {
            return;
        }
        String str = qZoneSchemeBean.getAttrs().get("key_scheme");
        String str2 = qZoneSchemeBean.getAttrs().get("relationtype");
        String str3 = qZoneSchemeBean.getAttrs().get("from");
        String str4 = qZoneSchemeBean.getAttrs().get(QCircleSchemeAttr.AttrDebug.TARGET_SECOND_PAGE);
        RFWLog.d(c(), RFWLog.USR, "[parseScheme] scheme: " + str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            try {
                i3 = Integer.parseInt(str4);
            } catch (NumberFormatException e16) {
                QLog.e(c(), 1, "[parseScheme] targetPage: " + str4 + ", error: " + e16.toString());
                i3 = 0;
            }
            try {
                i16 = Integer.parseInt(str3);
            } catch (Exception e17) {
                QLog.e(c(), 1, "[parseScheme] from: " + str3 + ", error: " + e17.toString());
                i16 = -1;
            }
            l(context, parseInt, i3, str, i16);
        } catch (NumberFormatException e18) {
            QLog.e(c(), 1, "[parseScheme] relationType: " + str2 + ", error: " + e18.toString());
        }
    }

    private void l(Context context, int i3, int i16, String str, int i17) {
        if (context == null) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateGetUserIntimateSpaceByTypeRequest(i3, i16, str), new a(i17, context));
    }

    private boolean h(Context context, List<QZIntimateProfileReader$SpaceTypeWithJumpUrl> list, int i3) {
        if (list != null && list.size() > 0) {
            if (list.get(0) != null) {
                return true;
            }
            j(context, i3, false);
            RFWLog.e(c(), RFWLog.USR, "[requestGetUserIntimateSpaceByType] first info is null");
            return false;
        }
        RFWLog.e(c(), RFWLog.USR, "[requestGetUserIntimateSpaceByType] spaceinfo size is empty");
        j(context, i3, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, String str, int i3, Context context, QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp qZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp) {
        if (z16 && qZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp != null) {
            List<QZIntimateProfileReader$SpaceTypeWithJumpUrl> list = qZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp.spaceinfo.get();
            if (h(context, list, i3)) {
                QZIntimateProfileReader$SpaceTypeWithJumpUrl qZIntimateProfileReader$SpaceTypeWithJumpUrl = list.get(0);
                RFWLog.d(c(), RFWLog.USR, "[requestGetUserIntimateSpaceByType], space_id = " + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_id.get() + ", space_status = " + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_status.get() + ", space_type = " + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_type.get());
                if (qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_status.get() == 3) {
                    i(qZIntimateProfileReader$SpaceTypeWithJumpUrl, context, "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", i3);
                    return;
                }
                if (qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_status.get() == 0) {
                    k(qZIntimateProfileReader$SpaceTypeWithJumpUrl, context, "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", i3);
                    return;
                }
                QLog.e("QZoneIntimateQueryOpenSpacePageParser", 1, "space status is " + qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_status.get());
                j(context, i3, mk.d.f416875a.y(Integer.valueOf(qZIntimateProfileReader$SpaceTypeWithJumpUrl.space_type.get())));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QQToast.makeText(context, 1, str, 0).show();
    }
}
