package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class i extends b {

    /* renamed from: e, reason: collision with root package name */
    private int f387903e = 0;

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8 A[Catch: Exception -> 0x0165, TryCatch #1 {Exception -> 0x0165, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:17:0x003e, B:20:0x012c, B:23:0x0145, B:25:0x0049, B:26:0x0066, B:28:0x0083, B:35:0x00a6, B:36:0x00b9, B:37:0x00c4, B:39:0x00ce, B:41:0x00db, B:45:0x00e8, B:46:0x0110, B:48:0x0122, B:49:0x015c, B:30:0x0089, B:32:0x00a2), top: B:2:0x0006, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110 A[Catch: Exception -> 0x0165, TryCatch #1 {Exception -> 0x0165, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:17:0x003e, B:20:0x012c, B:23:0x0145, B:25:0x0049, B:26:0x0066, B:28:0x0083, B:35:0x00a6, B:36:0x00b9, B:37:0x00c4, B:39:0x00ce, B:41:0x00db, B:45:0x00e8, B:46:0x0110, B:48:0x0122, B:49:0x015c, B:30:0x0089, B:32:0x00a2), top: B:2:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent b(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        String packageName;
        Intent a16;
        int a17;
        try {
            packageName = context.getPackageName();
        } catch (Exception e16) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e16.getMessage());
            this.f387903e = 2159;
        }
        if (insideNotificationItem != null && !TextUtils.isEmpty(packageName)) {
            u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType \uff1a\uff1a" + insideNotificationItem.getSkipType());
            int skipType = insideNotificationItem.getSkipType();
            boolean z16 = true;
            if (skipType == 1) {
                a16 = a(insideNotificationItem.getParams(), packageName, context);
            } else if (skipType == 2) {
                String skipContent = insideNotificationItem.getSkipContent();
                if (!TextUtils.isEmpty(skipContent)) {
                    String lowerCase = skipContent.toLowerCase();
                    if (!lowerCase.startsWith("http://")) {
                        if (lowerCase.startsWith("https://")) {
                        }
                    }
                    if (!z16) {
                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(skipContent));
                        intent.setFlags(268435456);
                        a(intent, insideNotificationItem.getParams());
                        u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(skipContent)));
                        a16 = intent;
                    } else {
                        u.c(context, " \u8df3\u8f6c\u53c2\u6570\u4e0d\u5408\u6cd5\uff0c\u6253\u5f00\u7f51\u9875\u5730\u5740\u4e0d\u7b26\u5408\u8981\u6c42 \u901a\u77e5\u672a\u5c55\u793a 2157");
                        u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");
                        this.f387903e = 2157;
                        a16 = null;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else if (skipType == 3) {
                String skipContent2 = insideNotificationItem.getSkipContent();
                u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient \uff1a\uff1a" + insideNotificationItem.getSkipContent());
                if (notifyArriveCallbackByUser.getIntent() != null) {
                    u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");
                    try {
                        a16 = notifyArriveCallbackByUser.getIntent();
                        a16.setSelector(null);
                        a16.setFlags(335544320);
                        b(a16, insideNotificationItem.getParams());
                        a17 = a(a16, packageName);
                    } catch (Exception e17) {
                        u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(skipContent2)), e17);
                        this.f387903e = 2158;
                    }
                    if (a17 > 0) {
                        this.f387903e = a17;
                        a16 = null;
                    }
                } else {
                    u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null \u6839\u636eskipcontent\u751f\u6210\u8df3\u8f6c\u53c2\u6570 ");
                    a16 = a(skipContent2, packageName, insideNotificationItem, context);
                }
            } else if (skipType != 4) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");
                this.f387903e = 2159;
                a16 = null;
            } else {
                String skipContent3 = insideNotificationItem.getSkipContent();
                u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient \uff1a\uff1a" + insideNotificationItem.getSkipContent());
                a16 = a(skipContent3, packageName, insideNotificationItem, context);
            }
            if (a16 != null) {
                a16.putExtra("vivo_push_messageId", b());
                a16.putExtra("command_type", "reflect_receiver");
                b.a(a16, context);
                this.f387903e = 0;
                return a16;
            }
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + insideNotificationItem.getSkipType());
            return null;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");
        this.f387903e = 2159;
        return null;
    }

    @Override // com.vivo.push.util.b
    protected final int a() {
        return this.f387903e;
    }

    @Override // com.vivo.push.util.b
    protected final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.util.b
    public final PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setPackage(str2);
            parseUri.setFlags(335544320);
            a(parseUri, insideNotificationItem.getParams());
            int a16 = a(parseUri, str2);
            if (a16 <= 0) {
                return parseUri;
            }
            this.f387903e = a16;
            u.c(context, " \u843d\u5730\u9875\u672a\u627e\u5230\uff0c\u901a\u77e5\u4e0d\u5c55\u793a\uff1a  " + this.f387903e);
            return null;
        } catch (Exception e16) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e16);
            this.f387903e = 2158;
            return null;
        }
    }

    private static Intent a(Map<String, String> map, String str, Context context) {
        ComponentName componentName;
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(50);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(str)) {
                        u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        a(intent, map);
                        return intent;
                    }
                }
            }
        } catch (Exception e16) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e16);
        }
        try {
            intent = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e17) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e17.getMessage());
        }
        return intent;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int a(Intent intent, String str) {
        int a16 = a(intent);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(a16)));
        if (a16 != 0) {
            return a16;
        }
        int b16 = b(intent, str);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(b16)));
        if (b16 != 0) {
            return b16;
        }
        return 0;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.f387889c.getPackageManager(), 65536) != null) {
            return 0;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        u.c(this.f387889c, " \u8df3\u8f6c\u53c2\u6570\u5bf9\u5e94\u7684Activity\u627e\u4e0d\u5230 \u901a\u77e5\u4e0d\u5c55\u793a   2162");
        return 2162;
    }

    private static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                u.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                u.a(this.f387889c, " \u8df3\u8f6c\u53c2\u6570\u5bf9\u5e94\u7684\u5305\u540d\u4e0d\u662f\u5f53\u524d\u5e94\u7528\u5305\u540d    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e16) {
                u.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e16.getMessage());
                return 2158;
            }
        }
        StringBuilder sb5 = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb5.append(obj);
        sb5.append(" mPkgName = ");
        sb5.append(str);
        u.a("AndroidTwelveNotifyClickIntentParam", sb5.toString());
        return 2158;
    }
}
