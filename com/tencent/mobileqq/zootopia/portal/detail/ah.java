package com.tencent.mobileqq.zootopia.portal.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b%\u0010&J(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JB\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J$\u0010\u0016\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J&\u0010\u0018\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000bR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "Lpv4/j;", "reserveItem", "", "", "k", "Landroid/view/View;", "view", "", "mapId", "mapName", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "extras", "", "e", "", "autoReportClick", "autoReportExpose", "b", "g", tl.h.F, "eventId", "position", "j", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lid3/d;", "Lid3/d;", "reportHelper", "<init>", "(Landroid/content/Context;)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ah {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ah$a;", "", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "", "a", "BUTTON_APPOINTED", "I", "BUTTON_CAN_APPOINTMENT", "BUTTON_CLOUD_GAME", "BUTTON_COMPLETE", "BUTTON_INIT", "BUTTON_LOADING", "BUTTON_MAINTENANCE", "BUTTON_PAUSE", "BUTTON_UPDATE", "BUTTON_UPDATE_SYSTEM", "BUTTON_WAITING", "", "DETAIL_PAGE_ID", "Ljava/lang/String;", "EM_ID_BOTTOM_BUTTON", "EM_ID_COVER_TIP", "EM_ID_DOWNLOAD_MANAGER", "EM_ID_EDIT", "EM_ID_GALLERY", "EM_ID_TOP_BUTTON", "EM_PARAMS_GALLERY", "EM_PARAMS_RESERVE_ID", "EM_PARAMS_RESERVE_TYPE", "EM_PARAMS_TOP_BUTTON", "PAGE_PARAMS_MAP_ID", "PAGE_PARAMS_MAP_NAME", "PAGE_PARAMS_TRACE_DETAIL", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.ah$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.ah$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public /* synthetic */ class C9117a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f328736a;

            static {
                int[] iArr = new int[ButtonStatus.values().length];
                try {
                    iArr[ButtonStatus.INIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStatus.WAITING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStatus.LOADING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonStatus.LOADED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ButtonStatus.UPDATE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ButtonStatus.MAINTENANCE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ButtonStatus.PAUSE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ButtonStatus.APPOINTED.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ButtonStatus.CLOUD_GAME.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                f328736a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final int a(ButtonStatus buttonStatus) {
            switch (buttonStatus == null ? -1 : C9117a.f328736a[buttonStatus.ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 7;
                case 3:
                    return 1;
                case 4:
                    return 3;
                case 5:
                    return 4;
                case 6:
                    return 6;
                case 7:
                    return 5;
                case 8:
                    return 2;
                case 9:
                    return 9;
                case 10:
                    return 8;
                case 11:
                    return 11;
                default:
                    return -1;
            }
        }
    }

    public ah(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.reportHelper = new id3.d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map d(ah this$0, View view, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDownloadButton zootopiaDownloadButton = view instanceof ZootopiaDownloadButton ? (ZootopiaDownloadButton) view : null;
        return this$0.k(zootopiaDownloadButton != null ? zootopiaDownloadButton.getStatus() : null, null);
    }

    private final Map<String, Object> k(ButtonStatus buttonStatus, pv4.j reserveItem) {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("zplan_map_infocard_btnstatus", Integer.valueOf(INSTANCE.a(buttonStatus)));
        pairArr[1] = new Pair("zplan_reserver_type", Integer.valueOf(reserveItem != null ? reserveItem.f427618a : 0));
        String str = reserveItem != null ? reserveItem.f427619b : null;
        if (str == null) {
            str = "";
        }
        pairArr[2] = new Pair("zplan_reserver_id", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    public final void e(View view, int mapId, String mapName, ZootopiaSource sourceFrom, Map<String, Object> extras) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        if (view == null) {
            return;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(mapId)), new Pair("zplan_map_name", mapName));
        if (sourceFrom != null) {
            mutableMapOf.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ag.f373258a.d(sourceFrom));
        }
        if (extras != null) {
            mutableMapOf.putAll(extras);
        }
        this.reportHelper.j(this.context, view, "pg_zplan_playground_detail", mutableMapOf);
    }

    public final void g(View view, ButtonStatus buttonStatus, pv4.j reserveItem) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementParams(view, k(buttonStatus, reserveItem));
        this.reportHelper.c("clck", view, k(buttonStatus, reserveItem));
    }

    public final void j(String eventId, View view, int position) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (view == null) {
            return;
        }
        VideoReport.setElementParam(view, "zplan_map_photo_number", String.valueOf(position));
        id3.d dVar = this.reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_photo_number", String.valueOf(position)));
        dVar.c(eventId, view, mutableMapOf);
    }

    public final void b(final View view, boolean autoReportClick, boolean autoReportExpose) {
        String str;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.pfv /* 1997013257 */:
                str = "em_zplan_playground_detail_bottom_enter";
                break;
            case R.id.pfz /* 1997013261 */:
                str = "em_zplan_playground_detail_download";
                break;
            case R.id.f163312pg1 /* 1997013263 */:
                str = "em_zplan_playground_detail_top_enter";
                break;
            case R.id.f163367pr1 /* 1997013668 */:
                str = "em_zplan_xiaowo_cover_editor_btn";
                break;
            case R.id.r0u /* 1997015398 */:
                str = "em_zplan_playground_detail_photo";
                break;
            case R.id.r9j /* 1997015720 */:
                str = "em_zplan_set_cover";
                break;
            default:
                str = "";
                break;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        id3.d.i(this.reportHelper, view, str2, new LinkedHashMap(), autoReportClick, autoReportExpose, null, false, false, 224, null);
        if (view instanceof ZootopiaDownloadButton) {
            VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ag
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str3) {
                    Map d16;
                    d16 = ah.d(ah.this, view, str3);
                    return d16;
                }
            });
        }
    }

    public final void h(View view, ButtonStatus buttonStatus, pv4.j reserveItem) {
        if (view == null) {
            return;
        }
        VideoReport.setElementParams(view, k(buttonStatus, reserveItem));
        this.reportHelper.c("imp", view, k(buttonStatus, reserveItem));
    }

    public static /* synthetic */ void i(ah ahVar, View view, ButtonStatus buttonStatus, pv4.j jVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            jVar = null;
        }
        ahVar.h(view, buttonStatus, jVar);
    }

    public static /* synthetic */ void c(ah ahVar, View view, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        ahVar.b(view, z16, z17);
    }

    public static /* synthetic */ void f(ah ahVar, View view, int i3, String str, ZootopiaSource zootopiaSource, Map map, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            map = null;
        }
        ahVar.e(view, i3, str, zootopiaSource, map);
    }
}
