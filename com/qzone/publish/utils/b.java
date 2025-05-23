package com.qzone.publish.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.ai;
import com.qzone.util.am;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import ho.i;
import org.json.JSONArray;
import org.json.JSONObject;
import x6.e;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f52148b;

    /* renamed from: a, reason: collision with root package name */
    private static final String f52147a = "[{\n\t\"type\": \"word\",\n\t\"text\": \"\u5206\u4eab\u65b0\u9c9c\u4e8b...\"\n}, {\n\t\"type\": \"icon\",\n\t\"text\": \"\u7167\u7247\",\n\t\"subaction_portal\": \"5\",\n\t\"pic_url\": \"https://tianshu.gtimg.cn/tianshu/1611049900435.png\",\n\t\"jump_url\": \"{\\\"moodList\\\":\\\"choosePicture\\\"}\"\n}, {\n\t\"type\": \"icon\",\n\t\"text\": \"\u89c6\u9891\",\n\t\"subaction_portal\": \"6\",\n\t\"pic_url\": \"https://tianshu.gtimg.cn/tianshu/1611049963398.png\",\n\t\"jump_url\": \"mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzoneMoodList&uin=&appid=406&widgetid=&shareto=2\"\n}, {\n\t\"type\": \"icon\",\n\t\"text\": \"\u5199\u8bf4\u8bf4\",\n\t\"subaction_portal\": \"62\",\n\t\"pic_url\": \"https://tianshu.gtimg.cn/tianshu/1623915323174.png\",\n\t\"jump_url\": \"mqzone://arouse/writemood\"\n}, {\n\t\"type\": \"icon\",\n\t\"text\": \"\u7b7e\u5230\",\n\t\"subaction_portal\": \"63\",\n\t\"pic_url\": \"https://tianshu.gtimg.cn/tianshu/1623915334669.png\",\n\t\"jump_url\": \"" + i() + "\"\n}]";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f52149c = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f52150d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q5.c f52151e;

        a(Activity activity, q5.c cVar) {
            this.f52150d = activity;
            this.f52151e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePermission.requestStoragePermission(this.f52150d, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                eo.c.f396879a.b();
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.t0(1);
                Boolean bool = Boolean.FALSE;
                qZonePublishMoodInitBean.R0(bool);
                qZonePublishMoodInitBean.v0(bool);
                qZonePublishMoodInitBean.C0("shuoshuoFeeds");
                qZonePublishMoodInitBean.O0(22);
                i.w().c(this.f52150d, qZonePublishMoodInitBean);
                if (!b.f52148b) {
                    ToastUtil.u(this.f52150d.getText(R.string.gll), 3);
                    b.f52148b = true;
                }
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 5, 2);
                b.m(this.f52151e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.publish.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0448b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f52152d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q5.c f52153e;

        ViewOnClickListenerC0448b(Activity activity, q5.c cVar) {
            this.f52152d = activity;
            this.f52153e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePermission.requestStoragePermission(this.f52152d, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                eo.c.f396879a.b();
                ag.A(this.f52152d, this.f52153e.f428371a, 8);
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 6, 2);
                b.m(this.f52153e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f52154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q5.c f52155e;

        c(Activity activity, q5.c cVar) {
            this.f52154d = activity;
            this.f52155e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.f()) {
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.t0(11);
                Boolean bool = Boolean.FALSE;
                qZonePublishMoodInitBean.R0(bool);
                qZonePublishMoodInitBean.v0(bool);
                qZonePublishMoodInitBean.C0("shuoshuoFeeds");
                qZonePublishMoodInitBean.O0(22);
                i.w().c(this.f52154d, qZonePublishMoodInitBean);
            } else {
                ToastUtil.o(R.string.glh, 4);
            }
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 7, 2);
            b.m(this.f52155e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements ai.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f52156a;

        d(e eVar) {
            this.f52156a = eVar;
        }

        @Override // com.qzone.util.ai.b
        public void a(boolean z16, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                x6.e h16 = b.h(b.f52147a);
                if (h16 != null) {
                    h16.f447270a = true;
                    this.f52156a.a(h16);
                    return;
                }
                return;
            }
            if (this.f52156a != null) {
                x6.e h17 = b.h(b.f52147a);
                x6.e h18 = b.h(str);
                if (h18 != null && h17 != null && !TextUtils.isEmpty(h18.f447271b)) {
                    h17.f447274e = str2;
                    h17.f447271b = h18.f447271b;
                }
                this.f52156a.a(h17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface e {
        void a(x6.e eVar);
    }

    public static boolean f() {
        QZoneVideoCommonUtils.VideoSupport recordSupport = QZoneVideoCommonUtils.getRecordSupport();
        QZoneVideoCommonUtils.VideoSupport trimSupport = QZoneVideoCommonUtils.getTrimSupport();
        if (recordSupport.isAvailable() && trimSupport.isAvailable()) {
            return ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 0);
        }
        QZLog.i("MoodQuickEntryUtils", "canShowToolBarAddGifIcon: record or trim not available");
        return false;
    }

    public static View.OnClickListener g(Activity activity, q5.c cVar) {
        return new a(activity, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x6.e h(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            x6.e eVar = new x6.e();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("type");
                if (!TextUtils.isEmpty(optString)) {
                    if ("word".equals(optString)) {
                        eVar.f447271b = jSONObject.optString("text");
                    } else {
                        if (!"icon".equals(optString) && !"apng".equals(optString)) {
                            boolean z16 = true;
                            if ("event_video".equals(jSONObject.optString("type"))) {
                                if (jSONObject.optInt("event_video", 1) != 1) {
                                    z16 = false;
                                }
                                eVar.f447273d = z16;
                            } else {
                                QZLog.e("MoodQuickEntryUtils", 2, "parse mood list Json Error the type ", optString, " not support ");
                            }
                        }
                        e.a aVar = new e.a();
                        aVar.f447275a = optString;
                        aVar.f447276b = jSONObject.optString("text");
                        aVar.f447277c = jSONObject.optString("pic_url");
                        aVar.f447278d = jSONObject.optString("jump_url");
                        aVar.f447280f = jSONObject.optInt("subaction_portal");
                        aVar.f447279e = jSONObject.optInt("is_ad");
                        eVar.f447272c.add(aVar);
                    }
                }
            }
            return eVar;
        } catch (Throwable th5) {
            QZLog.e("MoodQuickEntryUtils", "parse mood list Json Error: ", th5);
            return null;
        }
    }

    private static String i() {
        String l06 = QZoneConfigHelper.l0();
        return !TextUtils.isEmpty(l06) ? l06 : "https://h5.qzone.qq.com/check_in/index.html?_wv=3&_wwv=1";
    }

    public static void j(e eVar) {
        ai.b(2653, new d(eVar));
    }

    public static View.OnClickListener k(Activity activity, q5.c cVar) {
        return new ViewOnClickListenerC0448b(activity, cVar);
    }

    public static View.OnClickListener l(Activity activity, q5.c cVar) {
        return new c(activity, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(q5.c cVar) {
        if (!f52149c || cVar == null || cVar.f428377g != 1 || am.h(cVar.f428378h)) {
            return;
        }
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(cVar.f428378h, LoginData.getInstance().getUinString());
        f52149c = false;
    }
}
