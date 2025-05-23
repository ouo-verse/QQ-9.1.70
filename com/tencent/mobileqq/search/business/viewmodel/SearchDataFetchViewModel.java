package com.tencent.mobileqq.search.business.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.mobileqq.search.util.p;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItemGroup;
import com.tencent.qqnt.kernel.nativeinterface.UfsRspBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsSearchBusiSortInfo;
import com.tencent.qqnt.kernel.nativeinterface.UfsTabItemGroup;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import lo2.NetSearchTemplateUsedMiniAppItem;
import lo2.ac;
import lo2.ad;
import lo2.ai;
import lo2.am;
import lo2.e;
import lo2.h;
import lo2.m;
import lo2.q;
import lo2.s;
import lo2.v;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xo2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 k2\u00020\u0001:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002Jd\u0010\u001c\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J0\u0010\u001f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0016\u0010\"\u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0013H\u0002J<\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\f\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00132\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0004H\u0002JH\u00101\u001a\u0004\u0018\u0001002\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010/\u001a\u00020.2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0004H\u0002JX\u00104\u001a\u0004\u0018\u0001002\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010/\u001a\u00020.2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020#H\u0002J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105H\u0002J\u001a\u0010:\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020\u0002H\u0002J\u000e\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020;J\u000e\u0010?\u001a\u00020\n2\u0006\u0010<\u001a\u00020>J\u0080\u0001\u0010L\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u00020+0\u00132\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00132\u0006\u0010D\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00022\b\u0010K\u001a\u0004\u0018\u00010\bJ,\u0010N\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020+2\b\u0010M\u001a\u0004\u0018\u00010\u0004JP\u0010S\u001a\u00020\n2\u0006\u0010O\u001a\u00020#2\u0006\u0010,\u001a\u00020+2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00022\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u00160Pj\b\u0012\u0004\u0012\u00020\u0016`Q2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0004J(\u0010V\u001a\u00020\n2\b\u0010T\u001a\u0004\u0018\u00010\u00042\u0006\u0010U\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010\f\u001a\u00020\u0004J\b\u0010W\u001a\u00020\nH\u0014R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020;0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020>0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0017\u0010c\u001a\u00020^8\u0006\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/search/business/viewmodel/SearchDataFetchViewModel;", "Landroidx/lifecycle/ViewModel;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsRspBody;", "rsp", "Landroid/os/Bundle;", "extra", "", "b2", "keyword", "", "isFirstReq", PreDownloadConstants.RPORT_KEY_REQ_TIME, "", "cookie", "isEnd", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsTabItemGroup;", "tabList", "Lcom/tencent/mobileqq/search/model/x;", "result", "subId", "showModelForEntrance", "Lwp2/b;", "sortInfoConfig", "U1", QzoneIPCModule.RESULT_CODE, "errorMsg", "T1", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsSearchBusiSortInfo;", "sortInfo", "S1", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItemGroup;", "items", "from", "", "masks", "traceId", ICustomDataEditor.STRING_ARRAY_PARAM_2, "layoutId", "", "groupMask", "highlightWordList", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Llo2/m;", "X1", "groupName", "groupInfo", "W1", "Landroid/content/Context;", "context", "Q1", "ctx", "number", "d2", "Lcom/tencent/mobileqq/search/business/viewmodel/b;", "ob", "P1", "Lcom/tencent/mobileqq/search/business/viewmodel/a;", "O1", "time", "count", "businessMaskArray", "idList", "fromAction", "", "latitude", "longitude", "isMoreSearch", "hasLocalData", IProfileCardConst.KEY_FROM_TYPE, WadlProxyConsts.EXTRA_DATA, "f2", "sessionInfo", "e2", VipFunCallConstants.KEY_GROUP, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groupResult", "Z1", "cmd", "sendReqTime", "c2", "onCleared", "", "i", "Ljava/util/List;", "uniteSearchResultSuccessObservers", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uniteSearchResultErrorObservers", "Lxo2/c;", BdhLogUtil.LogTag.Tag_Conn, "Lxo2/c;", "getUnifySearchRepo", "()Lxo2/c;", "unifySearchRepo", "D", "Lkotlin/Lazy;", "R1", "()Ljava/lang/String;", "pageSessionId", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDataFetchViewModel extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageSessionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> uniteSearchResultSuccessObservers = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> uniteSearchResultErrorObservers = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c unifySearchRepo = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/business/viewmodel/SearchDataFetchViewModel$a;", "", "Lwp2/b;", "a", "", "MAX_SCORE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final wp2.b a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new wp2.a(28, 10000.0f));
            arrayList.add(new wp2.a(4, 9999.0f));
            arrayList.add(new wp2.a(2, 9998.0f));
            arrayList.add(new wp2.a(6, 9997.0f));
            arrayList.add(new wp2.a(1, 9996.0f));
            arrayList.add(new wp2.a(21, 9995.0f));
            arrayList.add(new wp2.a(0, 9994.0f));
            arrayList.add(new wp2.a(17, 9993.0f));
            arrayList.add(new wp2.a(5, 9992.0f));
            arrayList.add(new wp2.a(3, 9991.0f));
            arrayList.add(new wp2.a(7, 9990.0f));
            arrayList.add(new wp2.a(13, 9989.0f));
            arrayList.add(new wp2.a(11, 9988.0f));
            arrayList.add(new wp2.a(8, 9987.0f));
            arrayList.add(new wp2.a(24, 9986.0f));
            arrayList.add(new wp2.a(9, 9985.0f));
            arrayList.add(new wp2.a(27, 9984.0f));
            arrayList.add(new wp2.a(16, 9983.0f));
            arrayList.add(new wp2.a(23, 9982.0f));
            arrayList.add(new wp2.a(15, 9981.0f));
            arrayList.add(new wp2.a(22, 9980.0f));
            arrayList.add(new wp2.a(26, 9979.0f));
            arrayList.add(new wp2.a(12, 9978.0f));
            arrayList.add(new wp2.a(18, 9977.0f));
            arrayList.add(new wp2.a(25, 9976.0f));
            arrayList.add(new wp2.a(10, 9975.0f));
            arrayList.add(new wp2.a(14, 9974.0f));
            arrayList.add(new wp2.a(19, 9973.0f));
            arrayList.add(new wp2.a(30, 9972.0f));
            arrayList.add(new wp2.a(20, 9971.0f));
            return new wp2.b(arrayList);
        }

        Companion() {
        }
    }

    public SearchDataFetchViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel$pageSessionId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return System.currentTimeMillis() + "_" + ap.f285014a.a();
            }
        });
        this.pageSessionId = lazy;
    }

    private final String Q1(Context context) {
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        int i3 = 4;
        int i16 = 1;
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                i16 = 3;
                if (systemNetwork != 3) {
                    if (systemNetwork != 4) {
                        i3 = 5;
                    }
                } else {
                    i3 = 2;
                }
            }
            i3 = i16;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        return sb5.toString();
    }

    private final wp2.b S1(List<UfsSearchBusiSortInfo> sortInfo) {
        if (sortInfo.isEmpty()) {
            return INSTANCE.a();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float f16 = 10000.0f;
        for (UfsSearchBusiSortInfo ufsSearchBusiSortInfo : sortInfo) {
            arrayList.add(new wp2.a(ufsSearchBusiSortInfo.busiType, f16));
            arrayList2.add(Integer.valueOf(ufsSearchBusiSortInfo.busiType));
            f16 = (-1.0f) + f16;
        }
        if (arrayList2.contains(2) && arrayList2.contains(6) && arrayList2.contains(7) && arrayList2.contains(13)) {
            return new wp2.b(arrayList);
        }
        return INSTANCE.a();
    }

    private final void T1(String keyword, boolean isFirstReq, String reqTime, int resultCode, String errorMsg) {
        QLog.e("QQSearch.Local.SearchDataFetchViewModel", 1, "handleUniteSearchError keyword:" + ag.b(keyword, 0, 1, null) + " isFirstReq:" + isFirstReq + " reqTime:" + reqTime + " resultCode:" + resultCode + " errorMsg:" + errorMsg);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new SearchDataFetchViewModel$handleUniteSearchError$1(this, keyword, isFirstReq, reqTime, resultCode, errorMsg, null), 2, null);
    }

    private final void U1(String keyword, boolean isFirstReq, String reqTime, byte[] cookie, boolean isEnd, List<UfsTabItemGroup> tabList, List<? extends x> result, int subId, boolean showModelForEntrance, wp2.b sortInfoConfig) {
        QLog.e("QQSearch.Local.SearchDataFetchViewModel", 1, "handlerUniteSearchResultSuccess keyword:" + ag.b(keyword, 0, 1, null) + " isFirstReq:" + isFirstReq + " reqTime:" + reqTime + " resultSize:" + result.size());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1(this, keyword, isFirstReq, reqTime, cookie, isEnd, tabList, result, subId, showModelForEntrance, sortInfoConfig, null), 2, null);
    }

    private final m W1(int layoutId, String keyword, long groupMask, List<String> highlightWordList, UfsResultItem item, int from, String traceId, String groupName, UfsResultItemGroup groupInfo) {
        m mVar;
        String str = null;
        if (groupMask == 1100) {
            mVar = new am(keyword, groupMask, highlightWordList, item, from, groupInfo);
        } else if (groupMask == 1110) {
            mVar = new h(keyword, groupMask, highlightWordList, item, from);
        } else {
            mVar = null;
        }
        if (mVar != null) {
            str = mVar.getClass().getSimpleName();
        }
        QLog.d("QQSearch.Local.SearchDataFetchViewModel", 1, "newTemplateByGroupMask:" + str + ",groupMask:" + groupMask);
        return mVar;
    }

    private final m X1(int layoutId, String keyword, long groupMask, List<String> highlightWordList, UfsResultItem item, int from, String traceId) {
        m aiVar;
        String str = null;
        if (layoutId != 6) {
            if (layoutId != 21) {
                if (layoutId != 29) {
                    switch (layoutId) {
                        case 23:
                            aiVar = new ac(keyword, groupMask, highlightWordList, item, from);
                            break;
                        case 24:
                            aiVar = new lo2.ag(keyword, groupMask, highlightWordList, item, from);
                            aiVar.Y = R1();
                            break;
                        case 25:
                            aiVar = new q(keyword, groupMask, highlightWordList, item, from);
                            break;
                        case 26:
                            aiVar = new v(keyword, groupMask, highlightWordList, item, from);
                            break;
                        case 27:
                            aiVar = new NetSearchTemplateUsedMiniAppItem(keyword, groupMask, highlightWordList, item, from);
                            break;
                        default:
                            aiVar = null;
                            break;
                    }
                } else {
                    aiVar = new ad(keyword, groupMask, highlightWordList, item, from, traceId);
                }
            } else {
                aiVar = new s(keyword, groupMask, highlightWordList, item, from);
            }
        } else {
            aiVar = new ai(keyword, groupMask, highlightWordList, item, from);
        }
        if (aiVar != null) {
            str = aiVar.getClass().getSimpleName();
        }
        QLog.d("QQSearch.Local.SearchDataFetchViewModel", 1, "newTemplateByLayoutId:" + str + ",layoutId:" + layoutId);
        return aiVar;
    }

    private final List<x> a2(String keyword, List<UfsResultItemGroup> items, int from, long[] masks, String traceId) {
        boolean z16;
        boolean K0 = SearchUtils.K0(from);
        if (K0) {
            z16 = p.f285069a.d(from);
        } else {
            z16 = true;
        }
        ArrayList<x> arrayList = new ArrayList<>(items.size());
        for (UfsResultItemGroup ufsResultItemGroup : items) {
            long j3 = ufsResultItemGroup.groupMask;
            if (QLog.isColorLevel()) {
                QLog.i("QQSearch.Local.SearchDataFetchViewModel", 1, "parse  group.group_mask:" + j3);
            }
            if (!K0 || !c.INSTANCE.a(j3) || z16) {
                if (!c.INSTANCE.b(j3)) {
                    Z1(ufsResultItemGroup, j3, keyword, from, arrayList, masks, traceId);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(int errCode, String errMsg, UfsRspBody rsp, Bundle extra) {
        boolean z16;
        boolean z17;
        boolean z18;
        String string = extra.getString("keyword", "");
        Intrinsics.checkNotNullExpressionValue(string, "extra.getString(UnifySearchNtRepo.KEY_KEYWORD, \"\")");
        String string2 = extra.getString("traceId", "");
        Intrinsics.checkNotNullExpressionValue(string2, "extra.getString(UnifySea\u2026hNtRepo.KEY_TRACE_ID, \"\")");
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).searchEnginePerfReporterEndStep(string, "netQueryCost");
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).searchEnginePerfReporterStartStep(string, "netUICost");
        String string3 = extra.getString("time", "");
        Intrinsics.checkNotNullExpressionValue(string3, "extra.getString(UnifySearchNtRepo.KEY_TIME, \"\")");
        long[] longArray = extra.getLongArray("masks");
        if (longArray == null) {
            longArray = new long[0];
        }
        long[] jArr = longArray;
        boolean z19 = extra.getBoolean("isFirstReq");
        long j3 = extra.getLong(ISearchReportApi.KEY_SEND_REQ_TIME);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.d("QQSearch.Local.SearchDataFetchViewModel", 2, "handleUnifySearchUniteResult. resultCode=" + errCode + " keyword=" + cq.w(string, 2) + ", costTime=" + currentTimeMillis);
        c2("UnifySearch.Unite", j3, (long) errCode, string);
        if (errCode != 0) {
            T1(string, z19, string3, -1, "");
            return;
        }
        int i3 = rsp.resultCode;
        if (i3 != 0 && i3 < 1000) {
            String str = rsp.errorMsg;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.errorMsg");
            T1(string, z19, string3, i3, str);
            return;
        }
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).searchEnginePerfReporterAddParams(string, "netResultCode", Integer.valueOf(i3));
        byte[] cookie = rsp.cookieTopic;
        byte[] bArr = rsp.searchVer;
        Intrinsics.checkNotNullExpressionValue(bArr, "rsp.searchVer");
        if (bArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            byte[] bArr2 = rsp.searchVer;
            Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.searchVer");
            SearchUtils.p1("UnifySearch.Unite", jArr, new String(bArr2, Charsets.UTF_8));
        }
        if (rsp.isEndTopic == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList<UfsTabItemGroup> tabItemGroups = rsp.tabGroups;
        int i16 = rsp.triggerNetwordNum;
        if (i16 >= 0) {
            d2(BaseApplication.getContext(), i16);
        }
        ArrayList<UfsResultItemGroup> items = rsp.itemGroups;
        int i17 = extra.getInt(IProfileCardConst.KEY_FROM_TYPE);
        Intrinsics.checkNotNullExpressionValue(items, "items");
        List<x> a26 = a2(string, items, i17, jArr, string2);
        ArrayList<UfsSearchBusiSortInfo> arrayList = rsp.searchBusiSortInfos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.searchBusiSortInfos");
        wp2.b S1 = S1(arrayList);
        int i18 = rsp.exhibitionFlags;
        if (!rsp.containMaskedWord && !rsp.isHidePersonGroupSearchNode && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            z18 = true;
        } else {
            z18 = false;
        }
        Intrinsics.checkNotNullExpressionValue(cookie, "cookie");
        Intrinsics.checkNotNullExpressionValue(tabItemGroups, "tabItemGroups");
        U1(string, z19, string3, cookie, z17, tabItemGroups, a26, i18, z18, S1);
    }

    private final void d2(Context ctx, int number) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putInt(AppConstants.Preferences.UNIFY_SEARCH_UNITE_TRIGGER_NUMBER, number);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.setUnifySearchUniteTriggerNum", 2, "setUnifySearchUniteTriggerNum:" + number);
        }
    }

    public final void O1(@NotNull a ob5) {
        Intrinsics.checkNotNullParameter(ob5, "ob");
        if (!this.uniteSearchResultErrorObservers.contains(ob5)) {
            this.uniteSearchResultErrorObservers.add(ob5);
        }
    }

    public final void P1(@NotNull b ob5) {
        Intrinsics.checkNotNullParameter(ob5, "ob");
        if (!this.uniteSearchResultSuccessObservers.contains(ob5)) {
            this.uniteSearchResultSuccessObservers.add(ob5);
        }
    }

    @NotNull
    public final String R1() {
        return (String) this.pageSessionId.getValue();
    }

    public final void Z1(@NotNull UfsResultItemGroup group, long groupMask, @NotNull String keyword, int from, @NotNull ArrayList<x> groupResult, @Nullable long[] masks, @NotNull String traceId) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        boolean z26;
        int i3;
        int i16;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i17;
        ArrayList<String> arrayList3;
        String str2;
        String str3;
        boolean z27;
        boolean z28;
        UfsResultItem ufsResultItem;
        m X1;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(groupResult, "groupResult");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        String groupName = group.groupName;
        ArrayList<String> arrayList4 = group.highlightWordsList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "group.highlightWordsList");
        ArrayList<UfsResultItem> arrayList5 = group.resultItems;
        ArrayList arrayList6 = new ArrayList(arrayList5.size());
        boolean z29 = false;
        if (group.hideTitle != 1 && groupMask != 1110) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str4 = group.groupFooterName;
        String str5 = group.groupFooterJumpUrl;
        long size = arrayList5.size();
        int size2 = arrayList5.size();
        int i18 = 0;
        while (i18 < size2) {
            int i19 = size2;
            UfsResultItem item = arrayList5.get(i18);
            String str6 = str4;
            ArrayList<UfsResultItem> subResultItemList = item.subResultItems;
            boolean z36 = true;
            int size3 = subResultItemList.size() + 1;
            ArrayList arrayList7 = new ArrayList(size3);
            String str7 = PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME;
            Intrinsics.checkNotNullExpressionValue(item, "item");
            arrayList7.add(item);
            Intrinsics.checkNotNullExpressionValue(subResultItemList, "subResultItemList");
            arrayList7.addAll(subResultItemList);
            long j3 = size;
            int i26 = 0;
            while (i26 < size3) {
                UfsResultItem ufsResultItem2 = (UfsResultItem) arrayList7.get(i26);
                String str8 = ufsResultItem2.resultId;
                int i27 = ufsResultItem2.layoutId;
                int i28 = i26;
                if (i27 != 0) {
                    z19 = z36;
                } else {
                    z19 = false;
                }
                String str9 = ufsResultItem2.name;
                ArrayList arrayList8 = arrayList6;
                ArrayList<UfsResultItem> arrayList9 = arrayList5;
                long j16 = ufsResultItem2.groupMask;
                String str10 = str5;
                String str11 = ufsResultItem2.picUrl;
                boolean z37 = z16;
                String str12 = ufsResultItem2.jmpUrl;
                int i29 = i18;
                String str13 = ufsResultItem2.bytesExtension;
                if (z19) {
                    if (groupMask == 1110 || groupMask == 1100) {
                        z28 = z36;
                    } else {
                        z28 = false;
                    }
                    if (z28) {
                        Intrinsics.checkNotNullExpressionValue(ufsResultItem2, str7);
                        Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
                        str = str10;
                        i3 = i28;
                        i16 = size3;
                        i17 = i29;
                        z26 = z37;
                        arrayList = arrayList7;
                        arrayList2 = arrayList8;
                        ufsResultItem = ufsResultItem2;
                        arrayList3 = arrayList4;
                        str2 = groupName;
                        X1 = W1(i27, keyword, groupMask, arrayList4, ufsResultItem2, from, traceId, groupName, group);
                    } else {
                        ufsResultItem = ufsResultItem2;
                        str = str10;
                        z26 = z37;
                        i3 = i28;
                        i16 = size3;
                        arrayList = arrayList7;
                        arrayList2 = arrayList8;
                        i17 = i29;
                        arrayList3 = arrayList4;
                        str2 = groupName;
                        Intrinsics.checkNotNullExpressionValue(ufsResultItem, str7);
                        X1 = X1(i27, keyword, groupMask, arrayList3, ufsResultItem, from, traceId);
                    }
                    if (X1 != null && X1.N()) {
                        X1.f283548i = ufsResultItem.seporatorType;
                        X1.V = z26;
                        X1.Z = i17;
                        arrayList2.add(X1);
                    } else {
                        j3--;
                    }
                } else {
                    str = str10;
                    z26 = z37;
                    i3 = i28;
                    i16 = size3;
                    arrayList = arrayList7;
                    arrayList2 = arrayList8;
                    i17 = i29;
                    arrayList3 = arrayList4;
                    str2 = groupName;
                    if (!SearchUtils.O0(j16)) {
                        QLog.e("QQSearch.Local.SearchDataFetchViewModel", 1, "itemGroupMask is not valid. mask=" + j16);
                    } else if (j16 == 2073745984) {
                        pn2.c cVar = new pn2.c(keyword, str13, -4, str11);
                        cVar.f283548i = ufsResultItem2.seporatorType;
                        arrayList2.add(cVar);
                    } else {
                        str3 = str7;
                        lo2.c cVar2 = new lo2.c(keyword, str8, str9, str11, str12, str13, j16, arrayList3, from);
                        cVar2.f283548i = ufsResultItem2.seporatorType;
                        cVar2.f415198p0 = z26;
                        cVar2.f415203u0 = i17;
                        z27 = z26;
                        cVar2.T = from;
                        arrayList2.add(cVar2);
                        i26 = i3 + 1;
                        z16 = z27;
                        i18 = i17;
                        arrayList6 = arrayList2;
                        str5 = str;
                        arrayList5 = arrayList9;
                        arrayList4 = arrayList3;
                        arrayList7 = arrayList;
                        groupName = str2;
                        str7 = str3;
                        z36 = true;
                        size3 = i16;
                    }
                }
                str3 = str7;
                z27 = z26;
                i26 = i3 + 1;
                z16 = z27;
                i18 = i17;
                arrayList6 = arrayList2;
                str5 = str;
                arrayList5 = arrayList9;
                arrayList4 = arrayList3;
                arrayList7 = arrayList;
                groupName = str2;
                str7 = str3;
                z36 = true;
                size3 = i16;
            }
            i18++;
            str4 = str6;
            size2 = i19;
            size = j3;
        }
        String str14 = str4;
        String str15 = str5;
        boolean z38 = z16;
        ArrayList arrayList10 = arrayList6;
        ArrayList<String> arrayList11 = arrayList4;
        String str16 = groupName;
        if (size > 0) {
            long j17 = group.totalResultCount;
            String str17 = group.moreUrl;
            String str18 = group.moreName;
            if (group.isEnd == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            byte[] bArr = group.sessionInfo;
            Intrinsics.checkNotNullExpressionValue(bArr, "group.sessionInfo");
            String str19 = new String(bArr, Charsets.UTF_8);
            if (group.highlightTitleKeyword == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (group.hideTitleBlankView == 1) {
                z29 = true;
            }
            if (groupMask == 1100) {
                groupResult.add(new e(keyword, groupMask, str16, arrayList10, j17, str17, str18, arrayList11, z38, z18, z29, str14, str15));
                return;
            }
            lo2.b bVar = new lo2.b(keyword, groupMask, str16, arrayList10, j17, str17, str18, arrayList11, z38, z18, z29, str14, str15);
            bVar.S = str19;
            bVar.R = z17;
            bVar.B(from);
            groupResult.add(bVar);
        }
    }

    public final void c2(@Nullable String cmd, long sendReqTime, long resultCode, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.statistics.q d16 = new com.tencent.mobileqq.statistics.q(MobileQQ.sMobileQQ.peekAppRuntime()).i("dc00899").a("grp_search_engineer").f("search_net").d(cmd);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(resultCode);
        long j3 = currentTimeMillis - sendReqTime;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(j3);
        d16.b(sb5.toString(), sb6.toString(), keyword, Q1(null)).g();
    }

    public final void e2(@Nullable String keyword, @Nullable String time, long groupMask, @Nullable String sessionInfo) {
        this.unifySearchRepo.j(keyword, time, groupMask, sessionInfo, new SearchDataFetchViewModel$uniteMoreSearch$1(this));
    }

    public final void f2(@NotNull String keyword, @NotNull String time, int count, @NotNull List<Long> businessMaskArray, @Nullable List<Long> idList, int fromAction, @Nullable byte[] cookie, double latitude, double longitude, boolean isMoreSearch, boolean hasLocalData, int fromType, @Nullable Bundle extraData) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(businessMaskArray, "businessMaskArray");
        this.unifySearchRepo.h(keyword, time, count, businessMaskArray, idList, fromAction, cookie, latitude, longitude, hasLocalData, fromType, extraData, isMoreSearch, new SearchDataFetchViewModel$uniteSearch$1(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.uniteSearchResultSuccessObservers.clear();
        this.uniteSearchResultErrorObservers.clear();
        super.onCleared();
    }
}
