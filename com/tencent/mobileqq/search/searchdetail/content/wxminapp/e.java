package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/e;", "", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "page", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/SearchDetailModule;", "module", "", "a", "", "clickId", "miniAppType", "c", "", "tabMask", "wxMiniAppType", "d", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f284377a = new e();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284378a;

        static {
            int[] iArr = new int[SearchPageType.values().length];
            try {
                iArr[SearchPageType.PAGE_NET_SEARCH_DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchPageType.PAGE_NET_SEARCH_MINI_APP_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SearchPageType.PAGE_NET_SEARCH_MINI_GAME_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SearchPageType.PAGE_LOCAL_SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SearchPageType.PAGE_LOCAL_SEARCH_MINIAPP_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f284378a = iArr;
        }
    }

    e() {
    }

    @JvmStatic
    public static final int a(@NotNull SearchPageType page, @NotNull SearchDetailModule module) {
        String str;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(module, "module");
        SearchPageType searchPageType = SearchPageType.PAGE_NET_SEARCH_MINI_APP_MORE;
        String str2 = QQHealthReportApiImpl.MSG_EXPOSE_KEY;
        if (page == searchPageType) {
            QRouteApi api = QRoute.api(IWxMiniHostSceneManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWxMiniHostSceneManager::class.java)");
            return ((IWxMiniHostSceneManager) api).combine("104", "30", QQHealthReportApiImpl.MSG_EXPOSE_KEY, 0);
        }
        int[] iArr = a.f284378a;
        int i3 = iArr[page.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    af afVar = af.f284993a;
                    QLog.w("QS.SearchMiniAppOpenHelper", 1, "getMiniAppHostScene error page=" + page + ", module=" + module, null);
                    str = "";
                } else {
                    str = "18";
                }
            } else {
                str = "17";
            }
        } else {
            str = "16";
        }
        int i16 = iArr[page.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4 && i16 != 5) {
                        af afVar2 = af.f284993a;
                        QLog.w("QS.SearchMiniAppOpenHelper", 1, "getMiniAppHostScene error page=" + page + ", module=" + module, null);
                        str2 = "";
                    }
                } else {
                    str2 = "006";
                }
            } else {
                str2 = "005";
            }
        } else {
            str2 = module.getValue();
        }
        QRouteApi api2 = QRoute.api(IWxMiniHostSceneManager.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IWxMiniHostSceneManager::class.java)");
        return ((IWxMiniHostSceneManager) api2).combine("103", str, str2, 0);
    }

    public static /* synthetic */ int b(SearchPageType searchPageType, SearchDetailModule searchDetailModule, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            searchDetailModule = SearchDetailModule.MODULE_UNKNOWN;
        }
        return a(searchPageType, searchDetailModule);
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull String clickId, int miniAppType) {
        int i3;
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        int i16 = 0;
        if (miniAppType == 3) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        f fVar = new f();
        fVar.getSearchInfo().b(clickId);
        if (i3 != 0) {
            i16 = 4;
        }
        fVar.getSearchInfo().a(i16);
        fVar.b(i3);
        String encode = URLEncoder.encode(op2.a.e(fVar, "{}"));
        Intrinsics.checkNotNullExpressionValue(encode, "encode(QQSearchWXAdGsonU\u2026oString(sceneNode, \"{}\"))");
        return encode;
    }

    public final int d(long tabMask, int wxMiniAppType) {
        SearchDetailModule searchDetailModule;
        if (tabMask == 7) {
            searchDetailModule = SearchDetailModule.SEARCH_DETAIL_MODULE_MINI_APP_TAB;
        } else if (wxMiniAppType != 1) {
            if (wxMiniAppType != 2) {
                if (wxMiniAppType != 3) {
                    searchDetailModule = SearchDetailModule.MODULE_UNKNOWN;
                } else {
                    searchDetailModule = SearchDetailModule.SEARCH_DETAIL_MODULE_ALL_TAB_MINI_AD;
                }
            } else {
                searchDetailModule = SearchDetailModule.SEARCH_DETAIL_MODULE_ALL_TAB_MINI_GAME;
            }
        } else {
            searchDetailModule = SearchDetailModule.SEARCH_DETAIL_MODULE_ALL_TAB_MINI_APP;
        }
        return a(SearchPageType.PAGE_NET_SEARCH_DETAIL, searchDetailModule);
    }
}
