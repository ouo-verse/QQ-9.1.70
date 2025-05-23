package com.tencent.mobileqq.wink.picker.report;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.report.c;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import e93.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004\u001a>\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004\u001a4\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u001a@\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u001a(\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u001a\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u0011\u001az\u0010&\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00112\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u00112\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001f\u001a\u0010\u0010'\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u001aJ\u0010+\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010*\u001a\u00020\u0011\u001a6\u0010-\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0018\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0007\u001aB\u0010.\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010,\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0002\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u001a\u001e\u00100\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0011\u001a\u0016\u00101\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u00102\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0004\u00a8\u00065"}, d2 = {"Landroid/view/View;", "view", "", "u", "", "elementId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dataId", "t", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedList", "templateName", "templateID", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isFromQZone", "l", "params", "k", "p", "titleLeftBtn", "r", "isFromTemplateColl", ReportConstant.COSTREPORT_PREFIX, "contentView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "pageId", "", "templateParams", "", "isFromPhotosIcon", "hasBanner", "isFromQZonePicker", "customParams", DomainData.DOMAIN_NAME, h.F, "otherParams", IECDtReport.ACTION_IDENTIFIER, "needReportAllExpose", "a", "eventId", "e", "f", "checked", "c", "j", "d", "switchType", "i", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    public static final void a(@Nullable View view, @Nullable String str, @Nullable Map<String, ? extends Object> map, @Nullable String str2, boolean z16) {
        boolean z17;
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            if (z16) {
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            }
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            if (map != null) {
                buildElementParams.putAll(map);
            }
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                VideoReport.setElementReuseIdentifier(view, str2);
            }
            VideoReport.setElementParams(view, buildElementParams);
            return;
        }
        w53.b.f("WinkPhotoListReporter", "dtReportBindViewData view: null");
    }

    public static /* synthetic */ void b(View view, String str, Map map, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        a(view, str, map, str2, z16);
    }

    public static final void c(@NotNull View view, @NotNull String elementId, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("action_type", Integer.valueOf(z16 ? 1 : 0));
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        buildElementParams.put("xsj_eid", elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    public static final void d(@NotNull View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        buildElementParams.put("xsj_eid", elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    @Deprecated(message = "\u7528[dtReportCustomize]")
    public static final void e(@Nullable View view, @Nullable String str, @Nullable Map<String, Object> map) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.f("WinkPhotoListReporter", "dtReportCustomReport eventId: null");
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null) {
            VideoReport.setElementId(view, (String) map.get("xsj_eid"));
            map.put("xsj_topic_id", WinkDatongCurrentParams.get("xsj_topic_id"));
            map.put("xsj_topic_name", WinkDatongCurrentParams.get("xsj_topic_name"));
            map.put("xsj_topic_page_source", WinkDatongCurrentParams.get("xsj_topic_page_source"));
            buildElementParams.putAll(map);
        }
        VideoReport.reportEvent(str, view, buildElementParams);
    }

    public static final void f(@Nullable View view, @NotNull String eventId, @Nullable String str, @Nullable Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (str != null) {
            VideoReport.setElementId(view, str);
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_topic_id", WinkDatongCurrentParams.get("xsj_topic_id"));
        buildElementParams.put("xsj_topic_name", WinkDatongCurrentParams.get("xsj_topic_name"));
        buildElementParams.put("xsj_topic_page_source", WinkDatongCurrentParams.get("xsj_topic_page_source"));
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.reportEvent(eventId, view, buildElementParams);
    }

    public static /* synthetic */ void g(View view, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "ev_xsj_camera_action";
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        if ((i3 & 8) != 0) {
            map = null;
        }
        f(view, str, str2, map);
    }

    public static final void h(@Nullable Activity activity) {
        Uri uri;
        Uri uri2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (activity != null && activity.getIntent() != null) {
            Intent intent = activity.getIntent();
            String str8 = null;
            if (intent != null) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                Intent intent2 = activity.getIntent();
                if (intent2 != null) {
                    uri2 = intent2.getData();
                } else {
                    uri2 = null;
                }
                if (uri2 != null) {
                    str = uri2.getQueryParameter("xsj_operation_activity_id");
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (uri2 != null) {
                        str7 = uri2.getQueryParameter("xsj_operation_activity_id");
                    } else {
                        str7 = null;
                    }
                    WinkDatongCurrentParams.put("xsj_operation_activity_id", str7);
                }
                if (uri2 != null) {
                    str2 = uri2.getQueryParameter("xsj_material_type");
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (uri2 != null) {
                        str6 = uri2.getQueryParameter("xsj_material_type");
                    } else {
                        str6 = null;
                    }
                    WinkDatongCurrentParams.put("xsj_material_type", str6);
                }
                if (uri2 != null) {
                    str3 = uri2.getQueryParameter("xsj_material_id");
                } else {
                    str3 = null;
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (uri2 != null) {
                        str5 = uri2.getQueryParameter("xsj_material_id");
                    } else {
                        str5 = null;
                    }
                    WinkDatongCurrentParams.put("xsj_material_id", str5);
                }
                if (uri2 != null) {
                    str4 = uri2.getQueryParameter("xsj_resource_type");
                } else {
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (uri2 != null) {
                        str8 = uri2.getQueryParameter("xsj_resource_type");
                    }
                    WinkDatongCurrentParams.put("xsj_resource_type", str8);
                }
            }
        }
    }

    public static final void i(@NotNull String switchType) {
        Intrinsics.checkNotNullParameter(switchType, "switchType");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("action_type", switchType);
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_QZ_PREVIEW_SWITCH_PIC, null, buildElementParams);
    }

    public static final void j(@NotNull View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        buildElementParams.put("xsj_eid", elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    @NotNull
    public static final Map<String, Object> k(@NotNull String elementId, @NotNull List<? extends LocalMediaInfo> selectedList, @NotNull Map<String, Object> params) {
        boolean z16;
        int i3;
        Object obj;
        Object obj2;
        HashMap<MediaType, ArrayList<Long>> c16;
        ArrayList<Long> arrayList;
        HashMap<MediaType, ArrayList<Long>> c17;
        ArrayList<Long> arrayList2;
        HashMap<MediaType, ArrayList<Long>> c18;
        ArrayList<Long> arrayList3;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(params, "params");
        AlbumSelectionData b16 = AlbumSelectionData.b();
        List<? extends LocalMediaInfo> list = selectedList;
        ArrayList arrayList4 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
            if (i.I(localMediaInfo) || i.D(localMediaInfo)) {
                z16 = false;
            }
            if (z16) {
                arrayList4.add(next);
            }
        }
        int size = arrayList4.size();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list) {
            if (i.I((LocalMediaInfo) obj3)) {
                arrayList5.add(obj3);
            }
        }
        int size2 = arrayList5.size();
        if ((list instanceof Collection) && list.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it5 = list.iterator();
            i3 = 0;
            while (it5.hasNext()) {
                if ((!i.D((LocalMediaInfo) it5.next())) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, Integer.valueOf(i3));
        params.put("xsj_picture_num", Integer.valueOf(size));
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(size2));
        params.put("xsj_eid", elementId);
        Object obj4 = null;
        if (b16 != null && (c18 = b16.c()) != null && (arrayList3 = c18.get(MediaType.LOCAL_ALL)) != null) {
            obj = Integer.valueOf(arrayList3.size());
        } else {
            obj = null;
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_FROM_ALL_NUM, obj);
        if (b16 != null && (c17 = b16.c()) != null && (arrayList2 = c17.get(MediaType.LOCAL_IMAGE)) != null) {
            obj2 = Integer.valueOf(arrayList2.size());
        } else {
            obj2 = null;
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_FROM_PICTURE_NUM, obj2);
        if (b16 != null && (c16 = b16.c()) != null && (arrayList = c16.get(MediaType.LOCAL_VIDEO)) != null) {
            obj4 = Integer.valueOf(arrayList.size());
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_FROM_VIDEO_NUM, obj4);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj5 : list) {
            if (i.E((LocalMediaInfo) obj5)) {
                arrayList6.add(obj5);
            }
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_FROM_QZONE_ALBUM_NUM, Integer.valueOf(arrayList6.size()));
        b16.d();
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, Integer.valueOf(selectedList.size()));
        WinkDatongCurrentParams.put("xsj_picture_num", Integer.valueOf(size));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(size2));
        String str = (String) WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str);
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        return params;
    }

    @NotNull
    public static final Map<String, Object> l(@NotNull String elementId, boolean z16, @NotNull List<? extends LocalMediaInfo> selectedList) {
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        String str = "0";
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, "0");
        if (z16) {
            str = "1";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, str);
        HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params2, "params");
        params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM));
        mutableMap = MapsKt__MapsKt.toMutableMap(k(elementId, selectedList, params));
        return mutableMap;
    }

    @Nullable
    public static final Map<String, Object> m(@NotNull String elementId, @NotNull List<? extends LocalMediaInfo> selectedList, @NotNull String templateName, @NotNull String templateID) {
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(templateID, "templateID");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_template_id", templateID);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, templateName);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, "1");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, "0");
        mutableMap = MapsKt__MapsKt.toMutableMap(k(elementId, selectedList, params));
        return mutableMap;
    }

    public static final void n(@Nullable View view, @Nullable Activity activity, @NotNull String pageId, boolean z16, @Nullable Map<String, ? extends Object> map, int i3, boolean z17, boolean z18, @Nullable Map<String, ? extends Object> map2) {
        String str;
        String str2;
        Object obj;
        Object obj2;
        String str3;
        String str4;
        Object obj3;
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (view != null && activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
            if (TextUtils.isEmpty(pageId)) {
                str = "WinkPhotoListReporter";
            } else {
                str = pageId;
            }
            VideoReport.setPageId(view, str);
            HashMap hashMap = new HashMap();
            Intent intent = activity.getIntent();
            Bundle bundle = null;
            if (intent != null) {
                str2 = intent.getStringExtra("xsj_ref_pgid");
            } else {
                str2 = null;
            }
            w53.b.a("WinkPhotoListReporter", "[onViewCreated] refPg: " + str2);
            hashMap.put("xsj_ref_pgid", str2);
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str2);
            String str5 = "1";
            if (z16) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, obj);
            if (z17) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_ACTIVITY_CONTENT_FRAME, obj2);
            if (!z18) {
                str5 = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, str5);
            if (z18) {
                WinkContext.Companion companion = WinkContext.INSTANCE;
                HashMap<String, String> r16 = companion.d().r();
                boolean z19 = false;
                if (r16 != null && r16.containsKey("xsj_qzone_entrance_source")) {
                    z19 = true;
                }
                if (z19) {
                    obj3 = companion.d().p("xsj_qzone_entrance_source");
                } else if (WinkDatongCurrentParams.params.containsKey("xsj_qzone_entrance_source")) {
                    obj3 = WinkDatongCurrentParams.params.get("xsj_qzone_entrance_source");
                } else {
                    obj3 = 3;
                }
                hashMap.put("xsj_qzone_entrance_source", obj3);
                HashMap<String, Object> params = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put("xsj_qzone_entrance_source", obj3);
            }
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            if (!TextUtils.isEmpty(companion2.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER))) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TEAM_LEADER, companion2.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER));
            }
            if (i3 > 0) {
                if (i3 == 1) {
                    str4 = WinkDaTongReportConstant.ElementParamValue.XSJ_PHOTOS_ICON;
                } else {
                    str4 = WinkDaTongReportConstant.ElementParamValue.XSJ_PHOTOS_TAB;
                }
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_REF_PG_PGID_LOCATION, str4);
            }
            try {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
                Intent intent2 = activity.getIntent();
                if (intent2 != null) {
                    str3 = intent2.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE);
                } else {
                    str3 = null;
                }
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, str3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            h(activity);
            if (z16 && map != null) {
                hashMap.putAll(map);
            }
            if (map2 != null) {
                hashMap.putAll(map2);
            }
            c cVar = c.f326261a;
            Intent intent3 = activity.getIntent();
            if (intent3 != null) {
                bundle = intent3.getExtras();
            }
            cVar.a(bundle, hashMap);
            try {
                String c16 = WinkContext.INSTANCE.d().getDtParams().c();
                VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(hashMap, c16));
                w53.b.f("WinkPhotoListReporter", "reportDaTongRegister subPage: WinkPhotoListReporter, pageId: " + pageId);
                hashMap.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
                VideoReport.reportEvent("ev_xsj_abnormal_imp", new WinkDTParamBuilder().buildPageParams(hashMap, c16).getBasicParams());
                return;
            } catch (Exception e17) {
                w53.b.f("WinkPhotoListReporter", "videoReport exception:" + e17);
                return;
            }
        }
        w53.b.f("WinkPhotoListReporter", "reportDaTongRegister contentView == null , subPage: " + activity);
    }

    public static /* synthetic */ void o(View view, Activity activity, String str, boolean z16, Map map, int i3, boolean z17, boolean z18, Map map2, int i16, Object obj) {
        int i17;
        boolean z19;
        boolean z26;
        Map map3;
        if ((i16 & 32) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 64) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i16 & 128) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        if ((i16 & 256) != 0) {
            map3 = null;
        } else {
            map3 = map2;
        }
        n(view, activity, str, z16, map, i17, z19, z26, map3);
    }

    public static final void p(@NotNull View view, @Nullable Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (map != null) {
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, "1");
        }
        e(view, "ev_xsj_camera_action", map);
    }

    public static final void q(@Nullable String str) {
        String str2 = (String) WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        if (!TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str2);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", str);
        params.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        e(null, "ev_xsj_camera_action", params);
    }

    public static final void r(@NotNull View titleLeftBtn) {
        boolean z16;
        Intrinsics.checkNotNullParameter(titleLeftBtn, "titleLeftBtn");
        String str = (String) WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
        HashMap hashMap = new HashMap();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str);
        }
        b(titleLeftBtn, "em_xsj_close_button", hashMap, null, false, 24, null);
    }

    public static final void s(@Nullable View view, boolean z16) {
        String str;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CHOSE_MEDIA_RETURN_BUTTON);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, str);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOSE_MEDIA_RETURN_BUTTON);
        e(view, "ev_xsj_camera_action", params);
    }

    public static final void t(@NotNull View view, @NotNull String dataId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_QZONE_ALBUM_ITEM);
        VideoReport.setElementReuseIdentifier(view, dataId);
        VideoReport.setElementParams(view, WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static final void u(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_QZONE_ALBUM_BUTTON);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_QZONE_ALBUM_BUTTON);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }
}
