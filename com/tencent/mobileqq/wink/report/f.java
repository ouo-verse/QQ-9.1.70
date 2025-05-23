package com.tencent.mobileqq.wink.report;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/report/f;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "b", "a", "", "entry", "Lfeedcloud/FeedCloudCommon$Entry;", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f326266a = new f();

    f() {
    }

    @Nullable
    public final Map<String, Object> a(@Nullable Activity activity) {
        HashMap hashMap = new HashMap();
        if (activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null) {
            Bundle extras = activity.getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.size() > 0) {
                Bundle extras2 = activity.getIntent().getExtras();
                Intrinsics.checkNotNull(extras2);
                Map map = (Map) extras2.get("key_attrs");
                if (map != null && !map.isEmpty()) {
                    if (map.get("xsj_operation_activity_id") != null && !TextUtils.isEmpty(String.valueOf(map.get("xsj_operation_activity_id")))) {
                        hashMap.put("xsj_operation_activity_id", map.get("xsj_operation_activity_id"));
                    }
                    if (map.get("xsj_material_type") != null && !TextUtils.isEmpty(String.valueOf(map.get("xsj_material_type")))) {
                        hashMap.put("xsj_material_type", map.get("xsj_material_type"));
                    }
                    if (map.get("xsj_material_id") != null && !TextUtils.isEmpty(String.valueOf(map.get("xsj_material_id")))) {
                        hashMap.put("xsj_material_id", map.get("xsj_material_id"));
                    }
                    if (map.get("xsj_resource_type") != null && !TextUtils.isEmpty(String.valueOf(map.get("xsj_resource_type")))) {
                        hashMap.put("xsj_resource_type", map.get("xsj_resource_type"));
                    }
                    if (map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) != null && !TextUtils.isEmpty(String.valueOf(map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE)))) {
                        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                    }
                }
                try {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE));
                    if (activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE) != null) {
                        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
                    }
                    if (hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) == null) {
                        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                    }
                } catch (Exception e16) {
                    QLog.i("WinkMaterialGuideUtils", 1, "getReportArgsFromIntent error " + e16.getMessage());
                    e16.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    @Nullable
    public final Map<String, String> b(@Nullable Activity activity) {
        HashMap hashMap = new HashMap();
        if (activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null) {
            Bundle extras = activity.getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.size() > 0) {
                Bundle extras2 = activity.getIntent().getExtras();
                Intrinsics.checkNotNull(extras2);
                Map map = (Map) extras2.get("key_attrs");
                if (map != null && (!map.isEmpty())) {
                    if (map.get("taskid") != null && !TextUtils.isEmpty((CharSequence) map.get("taskid"))) {
                        hashMap.put("xsj_operation_activity_id", map.get("taskid"));
                    }
                    if (map.get("taskdataid") != null && !TextUtils.isEmpty((CharSequence) map.get("taskdataid"))) {
                        hashMap.put("xsj_taskdataid", map.get("taskdataid"));
                    }
                }
                try {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                } catch (Exception e16) {
                    QLog.i("WinkWangZheReportUtils", 1, "getWangZheReportArgsFromIntent error " + e16.getMessage());
                    e16.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    @Nullable
    public final FeedCloudCommon$Entry c(@NotNull Map.Entry<String, String> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        if (entry.getKey() != null) {
            feedCloudCommon$Entry.key.set(entry.getKey());
        }
        if (entry.getValue() != null) {
            feedCloudCommon$Entry.value.set(entry.getValue());
        }
        return feedCloudCommon$Entry;
    }
}
