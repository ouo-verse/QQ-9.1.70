package com.tencent.mobileqq.search.searchdetail.content.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTopicHeaderItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchEnumJumpType;
import com.tencent.mobileqq.search.searchdetail.content.template.model.a;
import com.tencent.mobileqq.search.searchdetail.content.template.model.k;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.search.util.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchLayOut;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.AppSetting;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u0000 G*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001[B\u0007\u00a2\u0006\u0004\bY\u0010ZJG\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ1\u0010%\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u00052\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0014\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b*\u0010+J4\u0010/\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J(\u00100\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010,2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J/\u00101\u001a\u00020\u001b2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00052\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H&\u00a2\u0006\u0004\b1\u0010&J\u0017\u00102\u001a\u00020\u00052\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b2\u0010+J\n\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010\u0002\u001a\u0002032\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002032\u0006\u0010!\u001a\u00020\u0005H\u0014J\b\u00106\u001a\u000203H\u0004J\"\u00109\u001a\u000203*\u00020\u00072\b\b\u0002\u00107\u001a\u0002032\n\b\u0002\u00108\u001a\u0004\u0018\u000103H\u0004J\"\u0010;\u001a\u000203*\u00020:2\b\b\u0002\u00107\u001a\u0002032\n\b\u0002\u00108\u001a\u0004\u0018\u000103H\u0004J8\u0010A\u001a\u00020\u001b*\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010\n2\u0006\u0010=\u001a\u00020\u00132\u000e\u0010?\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020BH\u0004R\u001a\u0010I\u001a\u00020\u00058\u0014X\u0094D\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010S\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001a\u0010X\u001a\u00020\u00138\u0014X\u0094D\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "T", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchReportSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/g;", "", "jumpType", "Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", CacheTable.TABLE_NAME, "", "", "originExtMap", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/Integer;Lcom/tencent/mobileqq/search/searchdetail/content/model/g;Ljava/util/Map;)Ljava/util/Map;", "", "tabMask", "keyword", "", "J", "", "isInGuildTab", "isGuildIdSearch", "isGuildFeed", "K", "H", "Landroid/view/View;", "containerView", "", "onInitView", "y", "G", "()Ljava/lang/Integer;", "data", "position", "", "", "payload", "U", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;ILjava/util/List;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", "layoutInfo", "L", "D", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;)I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "moreJumpInfo", "extensionMap", "v", "d", HippyTKDListViewAdapter.X, "N", "Lorg/json/JSONObject;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "B", "params", QQBrowserActivity.APP_PARAM, "P", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "elementId", "needAsync", "Lkotlin/Function0;", "elementParams", IECDtReport.ACTION_IDENTIFIER, "V", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "button", "u", "f", "I", BdhLogUtil.LogTag.Tag_Conn, "()I", "cardMargin", tl.h.F, "Landroid/view/View;", UserInfo.SEX_FEMALE, "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "i", "getRealContainerView", "setRealContainerView", "realContainerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "M", "()Z", "overrideBackground", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseSearchTemplateSection<T extends com.tencent.mobileqq.search.searchdetail.content.template.model.a> extends BaseSearchReportSection<T> implements g {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int cardMargin = 8;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View realContainerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean overrideBackground;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection$a;", "", "Lorg/json/JSONObject;", "params", "transferInfoObj", "", "b", "", "transferInfo", "c", "myTransferObj", "curTransferInfo", "d", "", "canJump", "", "cornerTop", "cornerBottom", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/graphics/drawable/Drawable;", "a", "COMMON_CARD_PADDING", UserInfo.SEX_FEMALE, "CORNER_RADIUS", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Drawable a(boolean canJump, float cornerTop, float cornerBottom, @NotNull Resources resources) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return j.f431768a.g(cornerTop, cornerTop, cornerBottom, cornerBottom, resources.getColor(R.color.qui_common_fill_light_secondary));
        }

        public final void b(@NotNull JSONObject params, @NotNull JSONObject transferInfoObj) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(transferInfoObj, "transferInfoObj");
            Iterator keys = transferInfoObj.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "transferInfoObj.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object opt = transferInfoObj.opt(str);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                    if (Intrinsics.areEqual("serial_number", str) || !params.has(str)) {
                        params.put(str, opt);
                    }
                }
            }
        }

        @Nullable
        public final JSONObject c(@NotNull String transferInfo, @NotNull JSONObject params) {
            boolean z16;
            Intrinsics.checkNotNullParameter(transferInfo, "transferInfo");
            Intrinsics.checkNotNullParameter(params, "params");
            String curTransferInfo = params.optString("transfer_info");
            try {
                JSONObject jSONObject = new JSONObject(transferInfo);
                Intrinsics.checkNotNullExpressionValue(curTransferInfo, "curTransferInfo");
                if (curTransferInfo.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    JSONObject jSONObject2 = new JSONObject(curTransferInfo);
                    Iterator keys = jSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "myTransferObj.keys()");
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        Object opt = jSONObject.opt(str);
                        if (opt != null) {
                            Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                            jSONObject2.put(str, opt);
                        }
                    }
                    return jSONObject2;
                }
                return jSONObject;
            } catch (JSONException e16) {
                QLog.e("QQSearch.NetDetail.BaseSearchTemplateSection", 1, "mergeTransferInfo: " + e16.getMessage());
                return null;
            }
        }

        @Nullable
        public final JSONObject d(@NotNull JSONObject myTransferObj, @NotNull String curTransferInfo) {
            boolean z16;
            Intrinsics.checkNotNullParameter(myTransferObj, "myTransferObj");
            Intrinsics.checkNotNullParameter(curTransferInfo, "curTransferInfo");
            if (curTransferInfo.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return myTransferObj;
            }
            try {
                JSONObject jSONObject = new JSONObject(curTransferInfo);
                Iterator keys = myTransferObj.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "myTransferObj.keys()");
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Object opt = myTransferObj.opt(str);
                    if (opt != null) {
                        Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                        jSONObject.put(str, opt);
                    }
                }
                return jSONObject;
            } catch (JSONException e16) {
                if (AppSetting.isDebugVersion()) {
                    QLog.e("QQSearch.NetDetail.BaseSearchTemplateSection", 4, "mergeTransferInfo: " + e16.getMessage());
                    return null;
                }
                return null;
            }
        }

        Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0056, code lost:
    
        if (r5 != false) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, String> H(String keyword, Number tabMask) {
        int i3;
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("search_query_text", keyword);
        jSONObject.put("trace_id", ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getCommonInfo().getTraceId());
        boolean z17 = true;
        jSONObject.put("jump_type", 1);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        linkedHashMap.put("open_group_detail_transInfo", jSONObject2);
        if (new Regex("\\d+").matches(keyword)) {
            int length = keyword.length();
            if (6 <= length && length < 11) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        boolean areEqual = Intrinsics.areEqual((Object) tabMask, (Object) 6L);
        if (z17) {
            if (areEqual) {
                i3 = 1020;
            } else {
                i3 = 1019;
            }
        } else if (areEqual) {
            i3 = 1022;
        } else {
            i3 = 1021;
        }
        linkedHashMap.put("subSourceId", String.valueOf(i3));
        return linkedHashMap;
    }

    private final Map<String, String> J(Number tabMask, String keyword) {
        boolean z16;
        T t16;
        boolean z17;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean areEqual = Intrinsics.areEqual((Object) tabMask, (Object) 3L);
        boolean z18 = true;
        if (new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(keyword)) {
            int length = keyword.length();
            if (5 <= length && length < 14) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                t16 = this.mData;
                if (!(t16 instanceof NetSearchTemplateNineBoxGridItem) && !(t16 instanceof NetSearchFeedCollectionItem)) {
                    z18 = false;
                }
                linkedHashMap.put("guild_sub_source", K(areEqual, z16, z18));
                return linkedHashMap;
            }
        }
        z16 = false;
        t16 = this.mData;
        if (!(t16 instanceof NetSearchTemplateNineBoxGridItem)) {
            z18 = false;
        }
        linkedHashMap.put("guild_sub_source", K(areEqual, z16, z18));
        return linkedHashMap;
    }

    private final String K(boolean isInGuildTab, boolean isGuildIdSearch, boolean isGuildFeed) {
        if (isInGuildTab) {
            if (isGuildIdSearch) {
                if (isGuildFeed) {
                    return "qq_network_search_post_sub_tab_searchid";
                }
                return "qq_network_search_channel_sub_tab_searchid";
            }
            if (isGuildFeed) {
                return "qq_network_search_post_sub_tab_keyword";
            }
            return "qq_network_search_channel_sub_tab_keyword";
        }
        if (isGuildIdSearch) {
            if (isGuildFeed) {
                return "qq_network_search_post_all_tab_searchid";
            }
            return "qq_network_search_channel_all_tab_searchid";
        }
        if (isGuildFeed) {
            return "qq_network_search_post_all_tab_keyword";
        }
        return "qq_network_search_channel_all_tab_keyword";
    }

    public static /* synthetic */ JSONObject R(BaseSearchTemplateSection baseSearchTemplateSection, com.tencent.mobileqq.search.searchdetail.content.model.g gVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                jSONObject = new JSONObject();
            }
            if ((i3 & 2) != 0) {
                jSONObject2 = null;
            }
            return baseSearchTemplateSection.P(gVar, jSONObject, jSONObject2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getReportParams");
    }

    public static /* synthetic */ JSONObject S(BaseSearchTemplateSection baseSearchTemplateSection, SearchReportInfo searchReportInfo, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                jSONObject = new JSONObject();
            }
            if ((i3 & 2) != 0) {
                jSONObject2 = null;
            }
            return baseSearchTemplateSection.Q(searchReportInfo, jSONObject, jSONObject2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getReportParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(String str, Function0 function0, String str2, View this_vr) {
        Intrinsics.checkNotNullParameter(this_vr, "$this_vr");
        if (str != null) {
            VideoReport.setElementId(this_vr, str);
        }
        if (function0 != null) {
            JSONObject jSONObject = (JSONObject) function0.invoke();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                VideoReport.setElementParam(this_vr, str3, jSONObject.get(str3));
            }
        }
        if (str2 != null) {
            VideoReport.setElementReuseIdentifier(this_vr, str2);
        }
        VideoReport.setElementExposePolicy(this_vr, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this_vr, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this_vr, ClickPolicy.REPORT_ALL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w(BaseSearchTemplateSection baseSearchTemplateSection, SearchJump searchJump, com.tencent.mobileqq.search.searchdetail.content.model.g gVar, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            baseSearchTemplateSection.v(searchJump, gVar, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJump");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
    
        if (r7 == true) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, String> z(Integer jumpType, com.tencent.mobileqq.search.searchdetail.content.model.g reportInfo, Map<String, String> originExtMap) {
        String str;
        Number number;
        JSONObject jSONObject;
        String str2;
        boolean isBlank;
        JSONObject jsonReportInfo;
        JSONObject jsonReportInfo2;
        String str3;
        boolean z16;
        c dtReportIoc = getDtReportIoc();
        String str4 = "";
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        c dtReportIoc2 = getDtReportIoc();
        boolean z17 = true;
        if (dtReportIoc2 != null) {
            number = Long.valueOf(dtReportIoc2.getTabMask());
        } else {
            number = 1;
        }
        int type = QSearchEnumJumpType.JUMP_TYPE_GROUP_INFO_CARD.getType();
        if (jumpType == null || jumpType.intValue() != type) {
            int type2 = QSearchEnumJumpType.JUMP_TYPE_GROUP_JOIN.getType();
            if (jumpType == null || jumpType.intValue() != type2) {
                int type3 = QSearchEnumJumpType.JUMP_TYPE_GUILD.getType();
                String str5 = null;
                if (jumpType == null || jumpType.intValue() != type3) {
                    int type4 = QSearchEnumJumpType.JUMP_TYPE_JOIN_GUILD.getType();
                    if (jumpType == null || jumpType.intValue() != type4) {
                        com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getReportInfoWrapper();
                        if (reportInfoWrapper != null) {
                            jSONObject = reportInfoWrapper.getJsonReportInfo();
                        } else {
                            jSONObject = null;
                        }
                        QLog.d("QQSearch.NetDetail.BaseSearchTemplateSection", 4, "jumpType=" + jumpType + " " + jSONObject);
                        if (reportInfo != null && (jsonReportInfo = reportInfo.getJsonReportInfo()) != null) {
                            str2 = jsonReportInfo.optString("sgrp_channel_extension_info", "");
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            str4 = str2;
                        }
                        isBlank = StringsKt__StringsJVMKt.isBlank(str4);
                        if (!(!isBlank)) {
                            return null;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("sgrp_channel_extension_info", str4);
                        return linkedHashMap;
                    }
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                if (originExtMap != null && (str3 = originExtMap.get("guild_sub_source")) != null) {
                    if (str3.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                z17 = false;
                if (z17) {
                    linkedHashMap2.putAll(originExtMap);
                } else {
                    linkedHashMap2.putAll(J(number, str));
                }
                if (reportInfo != null && (jsonReportInfo2 = reportInfo.getJsonReportInfo()) != null) {
                    str5 = jsonReportInfo2.optString("sgrp_channel_extension_info", "");
                }
                if (str5 != null) {
                }
                return linkedHashMap2;
            }
        }
        return H(str, number);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public JSONObject A() {
        if (((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getDocPosition() != -1) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("doc_position", String.valueOf(((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getDocPosition()));
            return jSONObject;
        }
        return null;
    }

    @NotNull
    protected final JSONObject B() {
        long j3;
        String str;
        c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            j3 = dtReportIoc.getTabMask();
        } else {
            j3 = -1;
        }
        c dtReportIoc2 = getDtReportIoc();
        if (dtReportIoc2 == null || (str = dtReportIoc2.getTabName()) == null) {
            str = "";
        }
        JSONObject b16 = s.b(s.f285072a, null, 1, null);
        b16.put("tab_name", str);
        b16.put("tab_mask", j3);
        return b16;
    }

    /* renamed from: C, reason: from getter */
    protected int getCardMargin() {
        return this.cardMargin;
    }

    public int D(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getLayoutInfo().fullWidthLayout) {
            return 0;
        }
        return ViewUtils.f352270a.b(getCardMargin());
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final View getContainerView() {
        return this.containerView;
    }

    @Nullable
    public Integer G() {
        return null;
    }

    public int L(@NotNull SearchLayOut layoutInfo) {
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        return ViewUtils.f352270a.a(layoutInfo.marginTop);
    }

    /* renamed from: M, reason: from getter */
    protected boolean getOverrideBackground() {
        return this.overrideBackground;
    }

    public int N(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return ViewUtils.f352270a.a(16.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public JSONObject O(int position) {
        String str;
        String str2;
        String str3;
        String sugTraceId;
        c dtReportIoc = getDtReportIoc();
        String str4 = "";
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        JSONObject B = B();
        c dtReportIoc2 = getDtReportIoc();
        if (dtReportIoc2 == null || (str2 = Integer.valueOf(dtReportIoc2.getQuerySource()).toString()) == null) {
            str2 = "";
        }
        c dtReportIoc3 = getDtReportIoc();
        if (dtReportIoc3 == null || (str3 = Integer.valueOf(dtReportIoc3.getUserSource()).toString()) == null) {
            str3 = "";
        }
        B.put("search_query_text", str);
        B.put("search_trace_id", ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getCommonInfo().getTraceId());
        B.put("serial_number", position + 1);
        c dtReportIoc4 = getDtReportIoc();
        if (dtReportIoc4 != null && (sugTraceId = dtReportIoc4.getSugTraceId()) != null) {
            str4 = sugTraceId;
        }
        B.put("sug_trace_id", str4);
        B.put("query_source", str2);
        B.put("user_source", str3);
        if (((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getDocPosition() != -1) {
            B.put("doc_position", String.valueOf(((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getDocPosition()));
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JSONObject P(@NotNull com.tencent.mobileqq.search.searchdetail.content.model.g gVar, @NotNull JSONObject params, @Nullable JSONObject jSONObject) {
        String str;
        boolean z16;
        Iterator keys;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        SearchReportInfo searchReportInfo = gVar.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String();
        if (searchReportInfo != null) {
            str = searchReportInfo.getReportInfo();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return params;
        }
        String curTransferInfo = params.optString("transfer_info");
        Companion companion = INSTANCE;
        JSONObject jsonReportInfo = gVar.getJsonReportInfo();
        Intrinsics.checkNotNullExpressionValue(curTransferInfo, "curTransferInfo");
        JSONObject d16 = companion.d(jsonReportInfo, curTransferInfo);
        if (d16 != null) {
            if (jSONObject != null && (keys = jSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object opt = jSONObject.opt(str2);
                    if (opt != null) {
                        Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                        d16.put(str2, opt);
                    }
                }
            }
            params.put("transfer_info", d16);
            INSTANCE.b(params, d16);
        }
        return params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JSONObject Q(@NotNull SearchReportInfo searchReportInfo, @NotNull JSONObject params, @Nullable JSONObject jSONObject) {
        boolean z16;
        Iterator keys;
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        String transferInfo = searchReportInfo.reportInfo;
        Intrinsics.checkNotNullExpressionValue(transferInfo, "transferInfo");
        if (transferInfo.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return params;
        }
        JSONObject c16 = INSTANCE.c(transferInfo, params);
        if (c16 != null) {
            if (jSONObject != null && (keys = jSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Object opt = jSONObject.opt(str);
                    if (opt != null) {
                        Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                        c16.put(str, opt);
                    }
                }
            }
            params.put("transfer_info", c16);
            INSTANCE.b(params, c16);
        }
        return params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public JSONObject T(int position) {
        JSONObject R;
        com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getReportInfoWrapper();
        if (reportInfoWrapper == null || (R = R(this, reportInfoWrapper, O(position), null, 2, null)) == null) {
            return O(position);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final T data, final int position, @Nullable List<Object> payload) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SearchReportInfo searchReportInfo;
        float f16;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        super.onBindData(data, position, payload);
        if (data == null) {
            return;
        }
        View view = this.containerView;
        if (view != null) {
            SearchLayOut layoutInfo = data.getLayoutInfo();
            boolean z16 = layoutInfo.useOneCard;
            boolean isFirstItem = data.getCommonInfo().getIsFirstItem();
            boolean isLastItem = data.getCommonInfo().getIsLastItem();
            int L = L(layoutInfo);
            ViewUtils viewUtils = ViewUtils.f352270a;
            float a16 = viewUtils.a(layoutInfo.topCorner);
            float a17 = viewUtils.a(layoutInfo.bottomCorner);
            if (G() != null) {
                View view2 = this.realContainerView;
                if (view2 != null) {
                    layoutParams2 = view2.getLayoutParams();
                } else {
                    layoutParams2 = null;
                }
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.setMargins(0, L, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                } else {
                    marginLayoutParams3 = null;
                }
                if (marginLayoutParams3 != null) {
                    marginLayoutParams3.setMargins(D(data), 0, D(data), 0);
                }
            } else {
                View view3 = this.realContainerView;
                if (view3 != null) {
                    layoutParams = view3.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(D(data), L, D(data), 0);
                }
            }
            ViewExtKt.d(view, N(data));
            ViewExtKt.e(view, N(data));
            if (!getOverrideBackground()) {
                if (z16) {
                    float f17 = 0.0f;
                    if (isFirstItem) {
                        f16 = viewUtils.a(8.0f);
                    } else {
                        f16 = 0.0f;
                    }
                    if (isLastItem) {
                        f17 = viewUtils.a(8.0f);
                    }
                    Companion companion = INSTANCE;
                    boolean i3 = QSearchDetailUtilKt.i(data.getJumpLink());
                    Resources resources = view.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    view.setBackground(companion.a(i3, f16, f17, resources));
                } else {
                    Companion companion2 = INSTANCE;
                    boolean i16 = QSearchDetailUtilKt.i(data.getJumpLink());
                    Resources resources2 = view.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                    view.setBackground(companion2.a(i16, a16, a17, resources2));
                }
            }
            if (QSearchDetailUtilKt.i(data.getJumpLink())) {
                j.u(j.f431768a, view, "QQSearch.NetDetail.BaseSearchTemplateSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection$onBindData$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection<TT;>;TT;)V */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view4) {
                        invoke2(view4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        BaseSearchTemplateSection.this.d(data.getJumpLink(), data.q());
                    }
                }, 2, null);
            } else {
                view.setOnClickListener(null);
            }
            final com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = data.getReportInfoWrapper();
            if (reportInfoWrapper != null && (searchReportInfo = reportInfoWrapper.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String()) != null) {
                V(view, searchReportInfo.eid, true, new Function0<JSONObject>(this) { // from class: com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection$onBindData$1$2$1$1
                    final /* synthetic */ BaseSearchTemplateSection<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        BaseSearchTemplateSection<T> baseSearchTemplateSection = this.this$0;
                        return baseSearchTemplateSection.P(reportInfoWrapper, baseSearchTemplateSection.O(position), this.this$0.A());
                    }
                }, String.valueOf(searchReportInfo.hashCode()));
                x(data, position, payload);
            }
        }
        x(data, position, payload);
    }

    public void V(@NotNull final View view, @Nullable final String str, boolean z16, @Nullable final Function0<? extends JSONObject> function0, @Nullable final String str2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.base.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseSearchTemplateSection.W(str, function0, str2, view);
            }
        };
        if (z16) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.g
    public void d(@Nullable SearchJump moreJumpInfo, @Nullable Map<String, String> extensionMap) {
        v(moreJumpInfo, ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getReportInfoWrapper(), extensionMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View view;
        this.realContainerView = containerView;
        this.containerView = containerView;
        Integer G = G();
        if (G != null) {
            int intValue = G.intValue();
            if (containerView != null) {
                view = containerView.findViewById(intValue);
            } else {
                view = null;
            }
            this.containerView = view;
        }
        y(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(@NotNull k button) {
        Intrinsics.checkNotNullParameter(button, "button");
        d(button.getJumpInfo(), button.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(@Nullable SearchJump moreJumpInfo, @Nullable com.tencent.mobileqq.search.searchdetail.content.model.g reportInfo, @Nullable Map<String, String> extensionMap) {
        String str;
        long j3;
        boolean z16;
        Map<String, String> map;
        Integer num;
        Map<String, String> map2;
        View view;
        Context context;
        Map<String, String> mutableMap;
        c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        String str2 = str;
        c dtReportIoc2 = getDtReportIoc();
        if (dtReportIoc2 != null) {
            j3 = dtReportIoc2.getTabMask();
        } else {
            j3 = -1;
        }
        long j16 = j3;
        T t16 = this.mData;
        if (t16 == 0) {
            z16 = true;
        } else {
            z16 = t16 instanceof NetSearchTemplateTopicHeaderItem;
        }
        if (z16) {
            com.tencent.mobileqq.guild.report.b.g("functional_qq_search", "QQSearch.NetDetail.BaseSearchTemplateSection");
        }
        if (extensionMap != null) {
            map = MapsKt__MapsKt.toMutableMap(extensionMap);
        } else {
            map = null;
        }
        if (moreJumpInfo != null) {
            num = Integer.valueOf(moreJumpInfo.type);
        } else {
            num = null;
        }
        Map<String, String> z17 = z(num, reportInfo, map);
        if (z17 != null) {
            if (map == null) {
                mutableMap = MapsKt__MapsKt.toMutableMap(z17);
                map2 = mutableMap;
                view = this.containerView;
                if (view == null) {
                    context = view.getContext();
                } else {
                    context = null;
                }
                QSearchDetailUtilKt.g(context, moreJumpInfo, str2, ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getCommonInfo().getTraceId(), j16, map2, getDtReportIoc());
            }
            map.putAll(z17);
        }
        map2 = map;
        view = this.containerView;
        if (view == null) {
        }
        QSearchDetailUtilKt.g(context, moreJumpInfo, str2, ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) this.mData).getCommonInfo().getTraceId(), j16, map2, getDtReportIoc());
    }

    public abstract void x(@NotNull T data, int position, @Nullable List<Object> payload);

    public abstract void y(@Nullable View containerView);
}
