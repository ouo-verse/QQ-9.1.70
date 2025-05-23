package lo2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0010\u0018\u00002\u00020\u0001B3\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\b\u0010?\u001a\u0004\u0018\u00010#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010=\u001a\u00020\u0002\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0004R\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010,\u001a\u0004\b;\u0010.\"\u0004\b<\u00100\u00a8\u0006B"}, d2 = {"Llo2/g;", "Lcom/tencent/mobileqq/search/model/k;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.LATITUDE_SOUTH, "", "H", "l", "M", "k", "keyword", "", "N", "Landroid/view/View;", "view", "", "v", "L", "", "u", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", ReportConstant.COSTREPORT_PREFIX, "", "r", BdhLogUtil.LogTag.Tag_Req, "B", "U", "Lcom/tencent/common/app/AppInterface;", "X", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;", "Y", "Lcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;", "T", "()Lcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;", "setMiniAppInfo", "(Lcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;)V", "miniAppInfo", "Z", "Ljava/lang/String;", "getKeywords", "()Ljava/lang/String;", "setKeywords", "(Ljava/lang/String;)V", "keywords", "", "a0", "[I", "getMatchResult", "()[I", "setMatchResult", "([I)V", "matchResult", "b0", "getSchema", "setSchema", QZoneDTLoginReporter.SCHEMA, IProfileCardConst.KEY_FROM_TYPE, "entity", "<init>", "(Lcom/tencent/common/app/AppInterface;ILcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends com.tencent.mobileqq.search.model.k {

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private final AppInterface app;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private MiniAppLocalSearchEntity miniAppInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private String keywords;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] matchResult;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String schema;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@Nullable AppInterface appInterface, int i3, @Nullable MiniAppLocalSearchEntity miniAppLocalSearchEntity, @NotNull String keyword, @NotNull String schema) {
        super(appInterface, i3, 0L);
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.app = appInterface;
        this.matchResult = new int[3];
        this.miniAppInfo = miniAppLocalSearchEntity;
        this.keywords = keyword;
        U();
        MiniAppLocalSearchEntity miniAppLocalSearchEntity2 = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity2);
        D(miniAppLocalSearchEntity2.appId);
        this.schema = schema;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public boolean B() {
        boolean equals;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        String str = miniAppLocalSearchEntity.appName;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.keywords)) {
            equals = StringsKt__StringsJVMKt.equals(str, this.keywords, true);
            if (equals) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 6;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @Nullable
    public String K() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: L */
    public String getTitle() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        String str = miniAppLocalSearchEntity.appName;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo!!.appName");
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(@Nullable String keyword) {
        return 0L;
    }

    public final boolean R() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        if ((miniAppLocalSearchEntity.showMask & ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).searchBitUsedBefore()) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public String getUin() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        String str = miniAppLocalSearchEntity.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo!!.appId");
        return str;
    }

    @Nullable
    /* renamed from: T, reason: from getter */
    public final MiniAppLocalSearchEntity getMiniAppInfo() {
        return this.miniAppInfo;
    }

    protected final void U() {
        int i3;
        if (B()) {
            i3 = 3;
        } else {
            i3 = 9;
        }
        C(i3);
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l */
    public String getUin() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        String str = miniAppLocalSearchEntity.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo!!.appId");
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        String str = miniAppLocalSearchEntity.desc;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo!!.desc");
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @Nullable
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: s, reason: from getter */
    public String getKeyword() {
        return this.keywords;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        Intrinsics.checkNotNull(miniAppLocalSearchEntity);
        CharSequence u06 = SearchUtils.u0(miniAppLocalSearchEntity.appName, this.keywords, 10, true);
        Intrinsics.checkNotNullExpressionValue(u06, "getTitleHighLightMatched\u2026L_SUB_LEN, true\n        )");
        return u06;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(@NotNull View view) {
        int i3;
        String str;
        int i16;
        boolean z16;
        int b16;
        Intrinsics.checkNotNullParameter(view, "view");
        if (((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).getLocalSearchManager(this.G) != null) {
            MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
            Intrinsics.checkNotNull(miniAppLocalSearchEntity);
            if (miniAppLocalSearchEntity.showMask == 0) {
                i16 = 1005;
            } else {
                i16 = 1027;
            }
            int i17 = i16;
            MiniAppLocalSearchEntity miniAppLocalSearchEntity2 = this.miniAppInfo;
            Intrinsics.checkNotNull(miniAppLocalSearchEntity2);
            if (miniAppLocalSearchEntity2.miniAppType == 1) {
                if (this.C == 5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    b16 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.b(SearchPageType.PAGE_LOCAL_SEARCH_MINIAPP_MORE, null, 2, null);
                } else {
                    b16 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.b(SearchPageType.PAGE_LOCAL_SEARCH, null, 2, null);
                }
                int i18 = b16;
                String c16 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.c("", 1);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StartupReportKey.SCENE_NOTE, c16);
                com.tencent.mobileqq.search.util.af afVar = com.tencent.mobileqq.search.util.af.f284993a;
                String TAG = com.tencent.mobileqq.search.model.k.W;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                QLog.i("QS." + TAG, 1, "startWxMiniAppByAppId scene=" + i18 + ", node=" + c16, null);
                IWxMiniManager iWxMiniManager = (IWxMiniManager) QRoute.api(IWxMiniManager.class);
                Context context = view.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) context;
                MiniAppLocalSearchEntity miniAppLocalSearchEntity3 = this.miniAppInfo;
                Intrinsics.checkNotNull(miniAppLocalSearchEntity3);
                iWxMiniManager.startWxMiniAppByAppId(activity, miniAppLocalSearchEntity3.appId, "", i18, 0, null, hashMap);
            } else if (!TextUtils.isEmpty(this.schema)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).gotoSchemaUri(view.getContext(), this.schema);
            } else {
                IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                Context context2 = view.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                MiniAppLocalSearchEntity miniAppLocalSearchEntity4 = this.miniAppInfo;
                Intrinsics.checkNotNull(miniAppLocalSearchEntity4);
                iMiniAppService.launchMiniAppById((Activity) context2, miniAppLocalSearchEntity4.appId, null, null, null, null, i17, null);
            }
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            HashMap<com.tencent.mobileqq.search.model.v, SearchUtils.d> hashMap2 = SearchUtils.f284965n;
            if (hashMap2.containsKey(this)) {
                SearchUtils.d dVar = hashMap2.get(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    Intrinsics.checkNotNull(dVar);
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "native");
                } catch (JSONException e16) {
                    QLog.e(com.tencent.mobileqq.search.model.k.W, 2, "e = " + e16);
                }
                ReportModelDC02528 action = new ReportModelDC02528().module("all_result").action("clk_item");
                Intrinsics.checkNotNull(dVar);
                long j3 = dVar.f284977b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                ReportModelDC02528 obj1 = action.obj1(sb5.toString());
                MiniAppLocalSearchEntity miniAppLocalSearchEntity5 = this.miniAppInfo;
                Intrinsics.checkNotNull(miniAppLocalSearchEntity5);
                ReportModelDC02528 ver2 = obj1.obj2(miniAppLocalSearchEntity5.appId).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode()));
                if (R()) {
                    str = "1";
                } else {
                    str = "0";
                }
                com.tencent.mobileqq.search.report.b.h(null, ver2.ver3(str).ver7(jSONObject.toString()).session_id(this.G.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            String str2 = this.L;
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 3, 0, null, null);
            } else {
                MiniAppLocalSearchEntity miniAppLocalSearchEntity6 = this.miniAppInfo;
                Intrinsics.checkNotNull(miniAppLocalSearchEntity6);
                if (miniAppLocalSearchEntity6.appName != null) {
                    MiniAppLocalSearchEntity miniAppLocalSearchEntity7 = this.miniAppInfo;
                    Intrinsics.checkNotNull(miniAppLocalSearchEntity7);
                    if (Intrinsics.areEqual(miniAppLocalSearchEntity7.appName, this.keywords)) {
                        int i19 = this.I;
                        MiniAppLocalSearchEntity miniAppLocalSearchEntity8 = this.miniAppInfo;
                        Intrinsics.checkNotNull(miniAppLocalSearchEntity8);
                        com.tencent.mobileqq.search.report.b.e(null, 0, i19, "0X8009D33", 0, 0, miniAppLocalSearchEntity8.appId, null);
                    }
                }
                int i26 = this.I;
                MiniAppLocalSearchEntity miniAppLocalSearchEntity9 = this.miniAppInfo;
                Intrinsics.checkNotNull(miniAppLocalSearchEntity9);
                com.tencent.mobileqq.search.report.b.e(null, 0, i26, "0X8009D45", 0, 0, miniAppLocalSearchEntity9.appId, null);
            }
        }
        MiniAppLocalSearchEntity miniAppLocalSearchEntity10 = this.miniAppInfo;
        if (miniAppLocalSearchEntity10 != null) {
            Intrinsics.checkNotNull(miniAppLocalSearchEntity10);
            i3 = miniAppLocalSearchEntity10.reportType;
        } else {
            i3 = -1;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniSearch(this.miniAppInfo, 1, true, i3);
    }

    @Override // com.tencent.mobileqq.search.model.z
    @NotNull
    public String z() {
        String str;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.miniAppInfo;
        if (miniAppLocalSearchEntity != null) {
            str = miniAppLocalSearchEntity.appId;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
