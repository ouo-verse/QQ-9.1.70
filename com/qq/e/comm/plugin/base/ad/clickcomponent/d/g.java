package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.al;
import com.qq.e.comm.plugin.k.ax;
import com.qq.e.comm.plugin.k.bb;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventId;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    public static boolean a() {
        return bb.a() && bb.d() >= 620889344 && bb.a(true) && bb.b() >= 671089408;
    }

    private static com.qq.e.comm.plugin.stat.c b() {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("type", 3);
        return cVar;
    }

    public static void a(Context context, ClickInfo clickInfo) {
        if (c.d(clickInfo)) {
            GDTLogger.d("WXCanvasUtil handle, invalid click info params");
        } else {
            a(context, clickInfo.j().optString("wxappid"), clickInfo.d().Q(), clickInfo, false);
        }
    }

    public static int a(Context context, String str, String str2, ClickInfo clickInfo, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        a(4006001, clickInfo, currentTimeMillis, z16);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(4006002, clickInfo, currentTimeMillis, z16);
            if (bb.d() < 620889344) {
                a(LinkReportConstant$EventId.OPENSDK_VERSION_FAILED, clickInfo, currentTimeMillis, z16);
                return -2;
            }
            a(LinkReportConstant$EventId.OPENSDK_VERSION_SUCCESS, clickInfo, currentTimeMillis, z16);
            if (bb.b() < 671089408) {
                a(4006007, clickInfo, currentTimeMillis, z16);
                aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ax.a("\u8bf7\u5148\u5b89\u88c5\u6216\u5347\u7ea7\u5fae\u4fe1");
                    }
                });
                return -3;
            }
            a(4006006, clickInfo, currentTimeMillis, z16);
            GDTLogger.d("jumpToWxCanvas, wxAppId = " + str + ", extInfo = " + str2);
            return a(context, clickInfo, str, str2, currentTimeMillis, z16);
        }
        a(4006003, clickInfo, currentTimeMillis, z16);
        return -1;
    }

    private static int a(Context context, ClickInfo clickInfo, String str, String str2, long j3, boolean z16) {
        Class a16 = al.a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        if (a16 == null) {
            GDTLogger.e("can't get class WXAPIFactory");
        } else {
            Method a17 = al.a(a16, "createWXAPI", Context.class, String.class);
            if (a17 == null) {
                GDTLogger.e("get method createWXAPI() failed");
            } else {
                Object a18 = al.a(a16, a17, context, str);
                if (a18 == null) {
                    GDTLogger.e("invoke method createWXAPI() failed");
                } else {
                    Class a19 = al.a("com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView$Req");
                    if (a19 == null) {
                        GDTLogger.e("can't get class WXOpenBusinessView$Req");
                    } else {
                        Object a26 = al.a(a19);
                        if (a26 == null) {
                            GDTLogger.e("can't new WXOpenBusinessView$Req");
                        } else {
                            Field a27 = al.a(a19, "businessType");
                            if (a27 != null && al.a(a27, a26, "nativeOpenAdCanvas")) {
                                Field a28 = al.a(a19, "extInfo");
                                if (a28 != null && al.a(a28, a26, str2)) {
                                    Method a29 = al.a(a18.getClass(), "sendReq", a19.getSuperclass());
                                    if (a29 == null) {
                                        GDTLogger.e("get method extInfo() failed");
                                    } else {
                                        a(str2, clickInfo);
                                        Object a36 = al.a(a18, a29, a26);
                                        if (a36 instanceof Boolean) {
                                            Boolean bool = (Boolean) a36;
                                            a(bool.booleanValue() ? 4006008 : 4006009, clickInfo, j3, z16);
                                            return bool.booleanValue() ? 0 : -5;
                                        }
                                    }
                                } else {
                                    GDTLogger.e("set field extData failed");
                                }
                            } else {
                                GDTLogger.e("set field businessType failed");
                            }
                        }
                    }
                }
            }
        }
        a(4006011, clickInfo, j3, z16);
        return -4;
    }

    private static void a(String str, ClickInfo clickInfo) {
        JSONObject a16 = y.a();
        y.a(a16, "extInfo", str);
        bb.a(4006068, 3, a(clickInfo, System.currentTimeMillis()), a16, clickInfo != null ? clickInfo.j() : null);
    }

    private static void a(int i3, ClickInfo clickInfo, long j3, boolean z16) {
        if (clickInfo == null || z16) {
            return;
        }
        StatTracer.trackEvent(i3, 3, a(clickInfo, j3), b());
    }

    private static com.qq.e.comm.plugin.stat.b a(ClickInfo clickInfo, long j3) {
        com.qq.e.comm.plugin.stat.b a16 = z.a(clickInfo, (JSONObject) null);
        a16.a(System.currentTimeMillis() - j3);
        a16.a(LinkReportConstant$BizKey.WX_SDK_METHOD, 3);
        return a16;
    }
}
