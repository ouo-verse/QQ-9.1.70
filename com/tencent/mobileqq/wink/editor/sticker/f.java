package com.tencent.mobileqq.wink.editor.sticker;

import android.view.View;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a \u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u001a)\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000e\"\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0006\u001a\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0002\u001a6\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010 \u001a\u00020\u0006\u001a\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0002H\u0002\u001a\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0002H\u0002\u001a\u0010\u0010&\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0006H\u0002\u001a\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0006H\u0002\u001a&\u0010+\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0\u001eH\u0002\u00a8\u0006,"}, d2 = {"Landroid/view/View;", "view", "", "eid", "", DomainData.DOMAIN_NAME, "", "isClick", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "t", "o", ReportConstant.COSTREPORT_PREFIX, "", "kvs", "u", "(Ljava/lang/String;[Ljava/lang/String;)V", "k", "j", "i", "r", "isTimelineMenuShow", "f", "v", "g", "elementId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$c;", "stickerListViewAdapter", "", "stickerTimeType", "isVideoPage", tl.h.F, "p", "type", "e", "d", "b", "isTextSticker", "c", "", "params", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {
    private static final void a(WinkStickerModel winkStickerModel, Map<String, Object> map) {
        String str;
        String str2;
        if (winkStickerModel != null) {
            MetaMaterial material = winkStickerModel.getMaterial();
            boolean z16 = false;
            if (material != null && !m.X(material)) {
                z16 = true;
            }
            String str3 = "";
            String str4 = null;
            if (z16) {
                str2 = "paste";
            } else {
                MetaMaterial material2 = winkStickerModel.getMaterial();
                if (material2 != null) {
                    str = com.tencent.mobileqq.wink.editor.c.o(material2);
                } else {
                    str = null;
                }
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -921884268) {
                        if (hashCode != -907563552) {
                            if (hashCode == 793913343 && str.equals("CATEGORY_TEXT_PATTERN")) {
                                str2 = WinkDaTongReportConstant.ElementParamValue.CHAR_PATTERN;
                            }
                        } else if (str.equals("CATEGORY_TEXT_STYLE")) {
                            str2 = WinkDaTongReportConstant.ElementParamValue.CHAR_FORM;
                        }
                    } else if (str.equals("CATEGORY_TEXT_DECOR")) {
                        str2 = WinkDaTongReportConstant.ElementParamValue.CHAR_ART;
                    }
                }
                str2 = "";
            }
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_ITEM_TYPE, str2);
            MetaMaterial material3 = winkStickerModel.getMaterial();
            if (material3 != null) {
                str4 = material3.f30533id;
            }
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "stickerModel.material?.id ?: \"\"");
                str3 = str4;
            }
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_ITEM_ID, str3);
        }
    }

    private static final String b(boolean z16) {
        if (z16) {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_VIDEO_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_PIC_PAGE;
    }

    private static final String c(boolean z16) {
        if (z16) {
            return WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_FINISH;
        }
        return WinkDaTongReportConstant.ElementId.EM_XSJ_STICKERS_FINISH;
    }

    private static final void d(String str) {
        String str2;
        int hashCode = str.hashCode();
        if (hashCode != -1349088399) {
            if (hashCode != 1696) {
                if (hashCode != 1126940025) {
                    if (hashCode == 1379043793) {
                        str.equals("original");
                    }
                } else if (str.equals("current")) {
                    str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_CURRENT;
                }
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ORIGINAL;
            } else {
                if (str.equals("3s")) {
                    str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_3S;
                }
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ORIGINAL;
            }
        } else {
            if (str.equals("custom")) {
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_CUSTOM;
            }
            str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ORIGINAL;
        }
        WinkDatongCurrentParams.put(str2, 1);
        if (!Intrinsics.areEqual(str2, WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ORIGINAL)) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ADJUST_DURATION, 1);
        }
    }

    private static final void e(String str) {
        String str2;
        int hashCode = str.hashCode();
        if (hashCode != -1349088399) {
            if (hashCode != 1696) {
                if (hashCode != 1126940025) {
                    if (hashCode == 1379043793) {
                        str.equals("original");
                    }
                } else if (str.equals("current")) {
                    str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_CURRENT;
                }
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ORIGINAL;
            } else {
                if (str.equals("3s")) {
                    str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_3S;
                }
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ORIGINAL;
            }
        } else {
            if (str.equals("custom")) {
                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_CUSTOM;
            }
            str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ORIGINAL;
        }
        WinkDatongCurrentParams.put(str2, 1);
        if (!Intrinsics.areEqual(str2, WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ORIGINAL)) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ADJUST_DURATION, 1);
        }
    }

    public static final void f(@NotNull View view, @Nullable WinkStickerModel winkStickerModel, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        a(winkStickerModel, params);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_ITEM_CLICK);
        if (z16) {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ITEM_IS_TIMELINE, 1);
        } else {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ITEM_IS_TIMELINE, 0);
        }
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_ITEM_CLICK);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static final void g(@NotNull View v3, @Nullable WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_TIMELINE_ITEM_CLICK);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        a(winkStickerModel, params);
        VideoReport.setElementParams(v3, params);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("dt_clck", params);
    }

    public static final void h(@NotNull View v3, @Nullable WinkEditorStickerTimelinePart.c cVar, @NotNull Map<String, String> stickerTimeType, boolean z16) {
        List<WinkEditorStickerTimelinePart.b> c16;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(stickerTimeType, "stickerTimeType");
        if (cVar != null && (c16 = cVar.c()) != null) {
            for (WinkEditorStickerTimelinePart.b bVar : c16) {
                VideoReport.setElementId(v3, c(bVar.getIsTextSticker()));
                Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
                Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
                mParams.put("xsj_eid", c(bVar.getIsTextSticker()));
                mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
                mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, b(z16));
                String str = "original";
                if (bVar.getIsTextSticker()) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf((((float) (bVar.getEndTime() - bVar.getStartTime())) / 1000.0f) / 1000.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_USE_DURATION, format);
                    String str2 = stickerTimeType.get(bVar.d());
                    if (str2 == null) {
                        str2 = "original";
                    }
                    mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_USE_TYPE, str2);
                    String str3 = stickerTimeType.get(bVar.d());
                    if (str3 != null) {
                        str = str3;
                    }
                    e(str);
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf((((float) (bVar.getEndTime() - bVar.getStartTime())) / 1000.0f) / 1000.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKERS_USE_DURATION, format2);
                    String str4 = stickerTimeType.get(bVar.d());
                    if (str4 == null) {
                        str4 = "original";
                    }
                    mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKERS_USE_TYPE, str4);
                    String str5 = stickerTimeType.get(bVar.d());
                    if (str5 != null) {
                        str = str5;
                    }
                    d(str);
                }
                VideoReport.reportEvent("ev_xsj_camera_action", v3, mParams);
            }
        }
    }

    public static final void i(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", "em_xsj_delete_button");
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static final void j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_BUTTON);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_BUTTON);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static final void k(@NotNull View view, @NotNull String eid, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        if (z16) {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "click");
        } else {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "exp");
        }
        VideoReport.setElementId(view, eid);
        if (z16) {
            VideoReport.reportEvent("ev_xsj_camera_action", view, params);
        } else {
            VideoReport.reportEvent("ev_xsj_camera_action", view, params);
        }
    }

    public static /* synthetic */ void l(View view, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        k(view, str, z16);
    }

    public static final void m(@NotNull View view, @NotNull String eid, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        if (z16) {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "click");
        } else {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "exp");
        }
        VideoReport.setElementId(view, eid);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static final void n(@NotNull View view, @NotNull String eid) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        VideoReport.setElementId(view, eid);
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public static final void o(@NotNull View view, @NotNull String eid) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        VideoReport.setElementId(view, eid);
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public static final void p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_READ_OVER_BUBBLE);
        map.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_READ_OVER_BUBBLE);
        VideoReport.reportEvent("dt_imp", view, map);
    }

    public static final void q(@NotNull View v3, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(v3, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementParams(v3, buildElementParams);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("dt_clck", v3, buildElementParams);
    }

    public static final void r(@NotNull View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_LENGTH_ADJUST_BUTTON);
        if (z16) {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "click");
        } else {
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "exp");
        }
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_LENGTH_ADJUST_BUTTON);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static final void s(@NotNull View view, @NotNull String eid, @NotNull WinkStickerModel stickerModel) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        MetaMaterial material = stickerModel.getMaterial();
        if (material != null) {
            str = material.f30533id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, str);
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_clck", view, eid, params, null, 16, null);
    }

    public static final void t(@NotNull View view, @NotNull String eid, @NotNull WinkStickerModel stickerModel) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        MetaMaterial material = stickerModel.getMaterial();
        if (material != null) {
            str = material.f30533id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, str);
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp", view, eid, params, null, 16, null);
    }

    public static final void u(@NotNull String eid, @NotNull String... kvs) {
        boolean z16;
        int progressionLastElement;
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(kvs, "kvs");
        Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put("xsj_eid", eid);
        if (kvs.length % 2 == 0) {
            int i3 = 0;
            if (kvs.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16) && (progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, kvs.length - 1, 2)) >= 0) {
                while (true) {
                    params.put(kvs[i3], kvs[i3 + 1]);
                    if (i3 == progressionLastElement) {
                        break;
                    } else {
                        i3 += 2;
                    }
                }
            }
        }
        com.tencent.mobileqq.wink.report.e.f326265a.q("ev_xsj_camera_action", null, eid, null, params);
    }
}
