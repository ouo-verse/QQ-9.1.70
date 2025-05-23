package m83;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonArray;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.State;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0018\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0003J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J \u0010 \u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!J0\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b)\u0010*J \u0010/\u001a\u00020\u00122\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\b\u0002\u0010.\u001a\u00020\u0012J\u0016\u00100\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+J\u0016\u00101\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+J(\u00104\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0003Jc\u0010<\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010\n2\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020(2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\u0010;\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b<\u0010=J/\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\n2\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b@\u0010AJ2\u0010C\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u00020\u00032\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J2\u0010D\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u00020\u00032\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010F\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nR\u0018\u0010H\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010G\u00a8\u0006K"}, d2 = {"Lm83/b;", "", "", "", "d", "Landroid/content/Intent;", "intent", "", "f", "e", "Landroid/view/View;", "contentView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "view", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isSwitchOn", BdhLogUtil.LogTag.Tag_Conn, "B", DomainData.DOMAIN_NAME, "btnType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "k", h.F, "j", "i", "shareFrom", "pageId", "D", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "agiButtonInfo", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "paramsMap", "a", "pgId", "", "g", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "generateInfos", "forceReport", ReportConstant.COSTREPORT_PREFIX, "b", "c", "picMode", "styleId", HippyTKDListViewAdapter.X, "nextBtn", "loadingNum", "pictureNum", "haveDownloaded", "downloadNum", "regenerateCount", "isShareOriginImage", "y", "(Landroid/view/View;IILjava/lang/String;ILjava/lang/String;ILjava/util/List;Ljava/lang/Boolean;)V", "closeBtn", "loadStatus", "u", "(Landroid/view/View;ILjava/lang/String;Ljava/lang/Integer;)V", "downloadBtn", "w", "v", "p", "o", "Ljava/lang/String;", "pageComeFrom", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f416442a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String pageComeFrom;

    b() {
    }

    private final Map<String, Object> d() {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        String str = pageComeFrom;
        if (str == null) {
            str = "0";
        }
        pairArr[1] = TuplesKt.to("come_from", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final String e() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PICTURE_CHOOSE_PAGE;
    }

    private final void f(Intent intent) {
        pageComeFrom = "0";
        if (intent != null) {
            if (intent.hasExtra("come_from")) {
                pageComeFrom = intent.getStringExtra("come_from");
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            if ((serializableExtra instanceof HashMap) && Intrinsics.areEqual(((Map) serializableExtra).get("fromPage"), "qzoneAIMagicShare")) {
                pageComeFrom = "6";
            }
        }
    }

    public static /* synthetic */ boolean t(b bVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bVar.s(list, z16);
    }

    public final void A(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        e.m(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, null, 12, null);
    }

    public final void B(@NotNull View view, boolean isSwitchOn) {
        String str;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        Pair[] pairArr = new Pair[1];
        if (isSwitchOn) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[0] = TuplesKt.to("op_result", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        e.m(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_SAVE_SHOW_PIC_SWITCH, mutableMapOf, null, 8, null);
    }

    public final void C(@NotNull View view, boolean isSwitchOn) {
        String str;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        Pair[] pairArr = new Pair[1];
        if (isSwitchOn) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[0] = TuplesKt.to("op_result", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        e.h(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_SAVE_SHOW_PIC_SWITCH, mutableMapOf, null, 8, null);
    }

    public final void D(@Nullable String materialId, @NotNull String shareFrom, @NotNull String pageId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(shareFrom, "shareFrom");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("material_id", materialId), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.SHARE_FROM, shareFrom), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, pageId));
        e.r(e.f326265a, WinkDaTongReportConstant.EventId.EV_QZ_AI_PAINT_SHARE, null, null, null, mapOf, 14, null);
    }

    @NotNull
    public final Map<String, Object> a(@Nullable MagicStudioButtonInfo agiButtonInfo, @NotNull Map<String, Object> paramsMap) {
        Object obj;
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        if (agiButtonInfo != null) {
            obj = Integer.valueOf(agiButtonInfo.getActionType());
        } else {
            obj = "";
        }
        paramsMap.put("btn_type", obj);
        return paramsMap;
    }

    @NotNull
    public final String b(@Nullable List<GenerateInfo> generateInfos) {
        boolean z16;
        JsonArray jsonArray = new JsonArray();
        if (generateInfos != null) {
            Iterator<T> it = generateInfos.iterator();
            while (it.hasNext()) {
                String str = ((GenerateInfo) it.next()).e().get(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    jsonArray.add(str);
                }
            }
        }
        String jsonElement = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonArray.toString()");
        return jsonElement;
    }

    @NotNull
    public final String c(@Nullable List<GenerateInfo> generateInfos) {
        String joinToString$default;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (generateInfos != null) {
            Iterator<T> it = generateInfos.iterator();
            while (it.hasNext()) {
                String str = ((GenerateInfo) it.next()).e().get(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.add(str);
                }
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_GENERATE_EFFECT_SEPARATOR, null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public final void g(@NotNull String pgId, @Nullable Integer btnType) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        e eVar = e.f326265a;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, pgId);
        if (btnType == null || (str = btnType.toString()) == null) {
            str = "0";
        }
        pairArr[1] = TuplesKt.to("btn_type", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        e.r(eVar, "ev_qz_button_imp", null, null, null, mapOf, 14, null);
    }

    public final void h(@NotNull View view, @Nullable String materialId) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", materialId));
        e.m(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_PIC, mutableMapOf, null, 8, null);
    }

    public final void i(@NotNull View view, @Nullable String materialId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        if (materialId == null) {
            materialId = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("material_id", materialId));
        e.m(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE, mapOf, null, 8, null);
    }

    public final void j(@NotNull View view, @Nullable String materialId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        if (materialId == null) {
            materialId = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("material_id", materialId));
        e.f(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE, mapOf, null, 8, null);
    }

    public final void k(@NotNull View view, @Nullable String materialId) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", materialId));
        e.f(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_PIC, mutableMapOf, null, 8, null);
    }

    public final void l(@NotNull View contentView, @Nullable Activity activity) {
        Intent intent;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        f(intent);
        e.f326265a.i(contentView, WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL, activity, d());
    }

    public final void m(@Nullable View view, @NotNull String btnType) {
        Intrinsics.checkNotNullParameter(btnType, "btnType");
        if (view != null) {
            Map<String, Object> d16 = d();
            d16.put("btn_type", btnType);
            d16.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL);
            e.m(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_QZ_PRIVILEGE_PRIVACY_POP, d16, null, 8, null);
        }
    }

    public final void n(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        e.f(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_QZ_PRIVILEGE_PRIVACY_POP, null, null, 12, null);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    public final void o(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        e.k(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_QZ_YUANBAO_ENTRANCE, null, null, 12, null);
    }

    public final void p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        e eVar = e.f326265a;
        e.f(eVar, view, WinkDaTongReportConstant.ElementId.EM_QZ_YUANBAO_ENTRANCE, null, null, 12, null);
        eVar.y();
    }

    public final void q(@NotNull View view, @Nullable MagicStudioButtonInfo agiButtonInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        e.m(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_AGAIN_GENERATE_BUTTON, a(agiButtonInfo, new LinkedHashMap()), null, 8, null);
    }

    public final void r(@NotNull View view, @Nullable MagicStudioButtonInfo agiButtonInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        e.f(e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_AGAIN_GENERATE_BUTTON, a(agiButtonInfo, new LinkedHashMap()), null, 8, null);
    }

    public final boolean s(@Nullable List<GenerateInfo> generateInfos, boolean forceReport) {
        int i3;
        Map mapOf;
        if (generateInfos != null) {
            i3 = 0;
            for (GenerateInfo generateInfo : generateInfos) {
                if (generateInfo.getState() == State.Loading) {
                    if (!forceReport) {
                        return false;
                    }
                } else if (generateInfo.getState() == State.Success) {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        e eVar = e.f326265a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PICTURE_CHOOSE_PAGE), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.RESULTS_TYPE, Integer.valueOf(i3)));
        e.r(eVar, WinkDaTongReportConstant.EventId.EV_QZ_AGAIN_GENERATE_RESULT, null, null, null, mapOf, 14, null);
        return true;
    }

    public final void u(@NotNull View closeBtn, int haveDownloaded, @NotNull String downloadNum, @Nullable Integer loadStatus) {
        Intrinsics.checkNotNullParameter(closeBtn, "closeBtn");
        Intrinsics.checkNotNullParameter(downloadNum, "downloadNum");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_HAVE_DOWNLOAD, Integer.valueOf(haveDownloaded));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RESIDUE_DOWNLOAD_NUM, downloadNum);
        if (loadStatus != null) {
            loadStatus.intValue();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.MAGIC_STUDIO_PICTURE_LOAD_STATUS, loadStatus);
        }
        e.k(e.f326265a, closeBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_QUIT, buildElementParams, null, 8, null);
    }

    public final void v(@Nullable View downloadBtn, @NotNull String downloadNum, int loadingNum, int pictureNum, @Nullable String materialId) {
        Intrinsics.checkNotNullParameter(downloadNum, "downloadNum");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RESIDUE_DOWNLOAD_NUM, downloadNum);
        buildElementParams.put("xsj_loading_num", Integer.valueOf(loadingNum));
        buildElementParams.put("xsj_picture_num", Integer.valueOf(pictureNum));
        buildElementParams.put("xsj_material_id", materialId);
        if (downloadBtn != null) {
            e.k(e.f326265a, downloadBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_DOWNLOAD, buildElementParams, null, 8, null);
        }
    }

    public final void w(@Nullable View downloadBtn, @NotNull String downloadNum, int loadingNum, int pictureNum, @Nullable String materialId) {
        Intrinsics.checkNotNullParameter(downloadNum, "downloadNum");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RESIDUE_DOWNLOAD_NUM, downloadNum);
        buildElementParams.put("xsj_loading_num", Integer.valueOf(loadingNum));
        buildElementParams.put("xsj_picture_num", Integer.valueOf(pictureNum));
        buildElementParams.put("xsj_material_id", materialId);
        e.r(e.f326265a, "imp", downloadBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_DOWNLOAD, buildElementParams, null, 16, null);
    }

    public final void x(@Nullable Activity activity, @NotNull View contentView, boolean picMode, @NotNull String styleId) {
        String str;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        HashMap hashMap = new HashMap();
        if (picMode) {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_PICTURE_TAB;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_CHARACTER_TAB;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, str);
        hashMap.put("xsj_material_id", styleId);
        WinkHomeReportHelper.f326257a.c(activity, contentView, e(), hashMap);
    }

    public final void y(@Nullable View nextBtn, int loadingNum, int pictureNum, @Nullable String styleId, int haveDownloaded, @NotNull String downloadNum, int regenerateCount, @Nullable List<GenerateInfo> generateInfos, @Nullable Boolean isShareOriginImage) {
        Intrinsics.checkNotNullParameter(downloadNum, "downloadNum");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Integer valueOf = Integer.valueOf(loadingNum);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_loading_num", valueOf);
        map.put("xsj_picture_num", Integer.valueOf(pictureNum));
        map.put("xsj_custom_pgid", e());
        map.put("dt_pgid", e());
        map.put("xsj_material_id", styleId);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_HAVE_DOWNLOAD, Integer.valueOf(haveDownloaded));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RESIDUE_DOWNLOAD_NUM, downloadNum);
        map.put("xsj_again_generate", Integer.valueOf(regenerateCount));
        map.put("xsj_generate_effect", b(generateInfos));
        if (isShareOriginImage != null) {
            map.put(WinkDaTongReportConstant.ElementParamKey.IS_SHARE_ORIGINAL_PICTURE, Integer.valueOf(!isShareOriginImage.booleanValue() ? 1 : 0));
        }
        WinkHomeReportHelper.f326257a.f(WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_READY_BUTTON, map, nextBtn);
    }

    public final void z(@NotNull View contentView, @Nullable Activity activity) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        e.f326265a.i(contentView, WinkDaTongReportConstant.PageId.PG_QZ_PRIVILEGE_SET, activity, d());
    }
}
