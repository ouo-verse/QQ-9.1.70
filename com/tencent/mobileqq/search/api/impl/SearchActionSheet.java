package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchShareInfo;
import com.tencent.mobileqq.search.api.ISearchShareApi;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kn2.e;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001&B!\u0012\u0006\u0010*\u001a\u00020%\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00105\u001a\u000200\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0004H\u0002J&\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\b*\u00020\bH\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002Jr\u0010#\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2`\u0010\"\u001a\\\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001bH\u0002J\u0006\u0010$\u001a\u00020\u0006R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010/\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchActionSheet;", "", "Landroid/view/View;", "view", "", "action", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "uin", "uinType", "nickName", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "type", "r", "j", "k", "d", "e", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", h.F, "g", WadlProxyConsts.CHANNEL, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "code", "msg", "templateData", "platData", "block", "i", ReportConstant.COSTREPORT_PREFIX, "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "f", "()Landroid/app/Activity;", "context", "b", "Landroid/view/View;", "getLogicParentView", "()Landroid/view/View;", "logicParentView", "Lcom/tencent/mobileqq/search/ad;", "c", "Lcom/tencent/mobileqq/search/ad;", "getShareInfo", "()Lcom/tencent/mobileqq/search/ad;", "shareInfo", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/mobileqq/search/ad;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchActionSheet {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View logicParentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchShareInfo shareInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J(\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/search/api/impl/SearchActionSheet$b", "Lkn2/e;", "", "resourceId", "actionId", "templateData", "platData", "", "a", "", "code", "msg", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4<Integer, String, String, String, Unit> f282758a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchActionSheet f282759b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function4<? super Integer, ? super String, ? super String, ? super String, Unit> function4, SearchActionSheet searchActionSheet) {
            this.f282758a = function4;
            this.f282759b = searchActionSheet;
        }

        @Override // kn2.e
        public void a(@NotNull String resourceId, @NotNull String actionId, @NotNull String templateData, @NotNull String platData) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            Intrinsics.checkNotNullParameter(templateData, "templateData");
            Intrinsics.checkNotNullParameter(platData, "platData");
            this.f282758a.invoke(0, "", templateData, platData);
        }

        @Override // kn2.e
        public void b(@NotNull String resourceId, @NotNull String actionId, int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("SearchShare.SearchActionSheet", 1, "share2Guild failed resourceId=" + resourceId + ", code=" + code + " msg=" + msg2);
            this.f282758a.invoke(Integer.valueOf(code), msg2, "", "");
            ToastUtil.a().f(this.f282759b.getContext().getResources().getString(R.string.hiu), 0);
        }
    }

    public SearchActionSheet(@NotNull Activity context, @Nullable View view, @NotNull SearchShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        this.context = context;
        this.logicParentView = view;
        this.shareInfo = shareInfo;
    }

    private final void d() {
        i("copyLink", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$copyLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                String e16;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                boolean z16 = true;
                if (n.e(i3)) {
                    e16 = SearchActionSheet.this.e(platData);
                    if (e16 != null && e16.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    Object systemService = SearchActionSheet.this.getContext().getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("ai_search_url", e16));
                    ToastUtil.a().f("\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f", 0);
                    return;
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "copyLink getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String str) {
        try {
            return new JSONObject(str).optString("url");
        } catch (Exception unused) {
            return null;
        }
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        return arrayList;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    private final void i(String channel, Function4<? super Integer, ? super String, ? super String, ? super String, Unit> block) {
        ((ISearchShareApi) QRoute.api(ISearchShareApi.class)).getShareInfo(MobileQQ.sMobileQQ.waitAppRuntime(), this.shareInfo.getQuestionId(), channel, new b(block, this));
    }

    private final void j() {
        i("copyLink", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$openInQQBrowser$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                String e16;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                boolean z16 = true;
                if (n.e(i3)) {
                    e16 = SearchActionSheet.this.e(platData);
                    if (e16 != null && e16.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(MttLoader.KEY_PID, MttLoader.PID_MOBILE_QQ);
                    hashMap.put(MttLoader.KEY_EUSESTAT, "5");
                    String str = SearchActionSheet.this.getContext().getApplicationInfo().processName;
                    Intrinsics.checkNotNullExpressionValue(str, "context.applicationInfo.processName");
                    hashMap.put("ChannelID", str);
                    hashMap.put("PosID", "0");
                    int loadUrl = MttLoader.loadUrl(SearchActionSheet.this.getContext(), MttLoader.getValidQBUrl(SearchActionSheet.this.getContext(), e16), hashMap, null);
                    if (4 == loadUrl) {
                        String string = SearchActionSheet.this.getContext().getResources().getString(R.string.f169956a1);
                        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.QQbrowserNotInstalled)");
                        QQToast.makeText(SearchActionSheet.this.getContext(), 0, string, 0).show();
                        return;
                    } else if (5 == loadUrl) {
                        String string2 = SearchActionSheet.this.getContext().getResources().getString(R.string.f169955a0);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getString(R.string.QQbrowser)");
                        QQToast.makeText(SearchActionSheet.this.getContext(), 0, string2, 0).show();
                        return;
                    } else {
                        if (loadUrl != 0) {
                            String string3 = SearchActionSheet.this.getContext().getResources().getString(R.string.f169956a1);
                            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026ng.QQbrowserNotInstalled)");
                            QQToast.makeText(SearchActionSheet.this.getContext(), 0, string3, 0).show();
                            return;
                        }
                        return;
                    }
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "openInQQBrowser getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    private final void k() {
        i("copyLink", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$openInSysBrowser$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                String e16;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                boolean z16 = true;
                if (n.e(i3)) {
                    e16 = SearchActionSheet.this.e(platData);
                    if (e16 != null && e16.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    com.tencent.mobileqq.browser.a.f(SearchActionSheet.this.getContext(), e16, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
                    return;
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "openInSysBrowser getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    private final String l(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 72 && i3 != 73) {
                                if (i3 != 171) {
                                    return "0";
                                }
                                return "5";
                            }
                        } else {
                            return "4";
                        }
                    } else {
                        return "3";
                    }
                } else {
                    return "2";
                }
            }
            return "1";
        }
        return "6";
    }

    private final void m(View view, int action) {
        Map<String, Object> mutableMapOf;
        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
        aVar.g(view, "em_share_item");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("share_place", l(action)), TuplesKt.to("qq_eid", "em_share_item"), TuplesKt.to("qq_pgid", this.shareInfo.getPgId()));
        aVar.e("qq_clck", view, mutableMapOf);
    }

    private final void n(final String uin, final int uinType, final String nickName) {
        i("qqFriend", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$shareToFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                if (n.e(i3)) {
                    if (uin.length() == 0) {
                        c.c(c.f282772a, this.getContext(), templateData, null, 4, null);
                        return;
                    } else {
                        c.e(c.f282772a, this.getContext(), uin, uinType, nickName, templateData, null, 32, null);
                        return;
                    }
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "shareToFriend getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    static /* synthetic */ void o(SearchActionSheet searchActionSheet, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = "";
        }
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        searchActionSheet.n(str, i3, str2);
    }

    private final void p() {
        i("qqGuild", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$shareToGuild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                if (n.e(i3)) {
                    c.g(c.f282772a, SearchActionSheet.this.getContext(), templateData, null, 4, null);
                    return;
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "shareToGuild getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    private final void q() {
        i("qzone", new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$shareToQZone$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, String str3) {
                invoke(num.intValue(), str, str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                ArrayList<String> arrayListOf;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                if (n.e(i3)) {
                    ln2.a a16 = ln2.a.INSTANCE.a(platData);
                    if (a16 == null) {
                        return;
                    }
                    com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
                    dVar.n(a16.getDescription());
                    dVar.p(a16.getTitle());
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(a16.getIconUrl());
                    dVar.l(arrayListOf);
                    dVar.o(a16.getJumpUrl());
                    dVar.i(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
                    ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareToQZoneWithLink("", SearchActionSheet.this.getContext(), dVar);
                    return;
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "shareToQZone getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    private final void r(final int type) {
        String str;
        if (type == 9) {
            str = "wechat";
        } else {
            str = "wechatCircle";
        }
        i(str, new Function4<Integer, String, String, String, Unit>() { // from class: com.tencent.mobileqq.search.api.impl.SearchActionSheet$shareToWx$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, String str3, String str4) {
                invoke(num.intValue(), str2, str3, str4);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2, @NotNull String templateData, @NotNull String platData) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(templateData, "templateData");
                Intrinsics.checkNotNullParameter(platData, "platData");
                if (n.e(i3)) {
                    ln2.a a16 = ln2.a.INSTANCE.a(platData);
                    if (a16 == null) {
                        return;
                    }
                    ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareLinkToWeChat("ai_search", type, a16.getJumpUrl(), this.getContext(), String.valueOf(System.currentTimeMillis()), a16.getDescription(), a16.getTitle(), a16.getIconUrl(), null);
                    return;
                }
                QLog.e("SearchShare.SearchActionSheet", 1, "shareToWx getShareInfo failed, code=" + i3 + ", msg=" + msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ShareActionSheet shareActionSheet, SearchActionSheet this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = shareActionSheet.findViewById(R.id.f163935cx);
        if (findViewById != null) {
            VideoReport.setLogicParent(findViewById, this$0.logicParentView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ShareActionSheet shareActionSheet, SearchActionSheet this$0, View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.dismiss();
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 9) {
                                if (i3 != 10) {
                                    if (i3 != 72) {
                                        if (i3 != 73) {
                                            if (i3 == 171) {
                                                this$0.p();
                                            }
                                        }
                                    } else {
                                        String str = actionSheetItem.uin;
                                        Intrinsics.checkNotNullExpressionValue(str, "item.uin");
                                        int i16 = actionSheetItem.uinType;
                                        String str2 = actionSheetItem.label;
                                        Intrinsics.checkNotNullExpressionValue(str2, "item.label");
                                        this$0.n(str, i16, str2);
                                    }
                                } else {
                                    this$0.r(i3);
                                }
                            } else {
                                this$0.r(i3);
                            }
                        } else {
                            this$0.j();
                        }
                    } else {
                        this$0.k();
                    }
                } else {
                    this$0.q();
                }
            }
            o(this$0, null, 0, null, 7, null);
        } else {
            this$0.d();
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.m(view, actionSheetItem.action);
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final Activity getContext() {
        return this.context;
    }

    public final void s() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this.context;
        final ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.context.getIntent().putExtra("big_brother_source_key", "biz_ai_search");
        create.setRowVisibility(0, 0, 0);
        create.setActionSheetItems(h(), g());
        create.setIntentForStartForwardRecentActivity(new Intent());
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.search.api.impl.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SearchActionSheet.t(ShareActionSheet.this, this, dialogInterface);
            }
        });
        create.setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.search.api.impl.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                SearchActionSheet.u(ShareActionSheet.this, this, view, actionSheetItem, shareActionSheet);
            }
        });
        create.show();
    }
}
