package lo2;

import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.SearchDetailModule;
import com.tencent.qqnt.kernel.nativeinterface.UfsLabel;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsSearchMiniAppItem;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\u0006\u00107\u001a\u000206\u0012\u0010\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u00109\u001a\u00020\u000e\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001dR\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Llo2/ak;", "Llo2/p;", "", "c0", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d0", "Lcom/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity;", "b0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", "v", "", "nSource", UserInfo.SEX_FEMALE, "", "N", "", "u", "t", "X", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsLabel;", "Z", "", "y", "toString", "Ljava/lang/String;", "cover", "name", "desc", "e0", WadlProxyConsts.KEY_JUMP_URL, "f0", "classification", "g0", "appId", "h0", "I", "showMask", "i0", "miniAppType", "j0", MiniChatConstants.MINI_APP_ICON_URL, "k0", "Ljava/util/List;", "labels", "Llo2/g;", "l0", "Llo2/g;", "miniAppMode", "keyword", "", "parentGroupMask", "highLightWordList", "from", "<init>", "(Ljava/lang/String;JLjava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItem;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lo2.ak, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateUsedMiniAppItem extends p {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cover;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String name;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String desc;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String jumpUrl;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String classification;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String appId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata and from toString */
    private int showMask;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata and from toString */
    private int miniAppType;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String miniAppIconUrl;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<UfsLabel> labels;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g miniAppMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateUsedMiniAppItem(@Nullable String str, long j3, @Nullable List<String> list, @NotNull UfsResultItem item, int i3) {
        super(str, j3, list, item, i3);
        Intrinsics.checkNotNullParameter(item, "item");
        this.miniAppIconUrl = "";
        d0(item);
    }

    private final void c0() {
        AppInterface appInterface;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity = new MiniAppLocalSearchEntity(this.appId, this.name, this.cover, this.desc, this.showMask, this.miniAppType, this.K, this.miniAppIconUrl);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        AppInterface appInterface2 = appInterface;
        int i3 = this.R;
        String keyword = this.N;
        Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
        String jumpUrl = this.K;
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        this.miniAppMode = new g(appInterface2, i3, miniAppLocalSearchEntity, keyword, jumpUrl);
        if (appInterface2 != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateDataDbFromNetResultInLocalSearchManager(miniAppLocalSearchEntity);
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    public void F(int nSource) {
        super.F(nSource);
        g gVar = this.miniAppMode;
        if (gVar != null) {
            gVar.F(nSource);
        }
    }

    @Override // lo2.m
    public boolean N() {
        if (!TextUtils.isEmpty(this.cover) && !TextUtils.isEmpty(this.name)) {
            return true;
        }
        return false;
    }

    @Override // lo2.p
    @Nullable
    /* renamed from: X, reason: from getter */
    public String getCover() {
        return this.cover;
    }

    @Override // lo2.p
    @Nullable
    public List<UfsLabel> Z() {
        return this.labels;
    }

    @NotNull
    public final MiniAppLocalSearchEntity b0() {
        MiniAppLocalSearchEntity miniAppInfo;
        g gVar = this.miniAppMode;
        if (gVar == null || (miniAppInfo = gVar.getMiniAppInfo()) == null) {
            return new MiniAppLocalSearchEntity();
        }
        return miniAppInfo;
    }

    public final void d0(@NotNull UfsResultItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        UfsSearchMiniAppItem ufsSearchMiniAppItem = item.layoutContentObject.searchMiniAppLayoutContent;
        if (ufsSearchMiniAppItem != null) {
            this.cover = ufsSearchMiniAppItem.cover;
            this.name = ufsSearchMiniAppItem.name;
            this.desc = ufsSearchMiniAppItem.desc;
            this.jumpUrl = ufsSearchMiniAppItem.jumpUrl;
            this.classification = ufsSearchMiniAppItem.classification;
            this.appId = ufsSearchMiniAppItem.appid;
            this.showMask = ufsSearchMiniAppItem.showMask;
            this.miniAppType = ufsSearchMiniAppItem.miniappType;
            this.labels = ufsSearchMiniAppItem.labels;
            String str = ufsSearchMiniAppItem.miniIconUrl;
            Intrinsics.checkNotNullExpressionValue(str, "miniAppItem.miniIconUrl");
            this.miniAppIconUrl = str;
            c0();
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    @Nullable
    /* renamed from: t */
    public CharSequence getSubTitle() {
        return this.desc;
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateUsedMiniAppItem(name=" + this.name + ", desc=" + this.desc + ", appId=" + this.appId + ", showMask=" + this.showMask + ", miniAppType=" + this.miniAppType + ")";
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    @Nullable
    /* renamed from: u */
    public CharSequence getTitle() {
        return this.name;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        g gVar;
        if (view != null && (gVar = this.miniAppMode) != null) {
            gVar.v(view);
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    @NotNull
    public Map<String, String> y() {
        int a16;
        String str;
        Map<String, String> y16 = super.y();
        if (y16 == null) {
            y16 = new LinkedHashMap<>();
        }
        if (a0()) {
            a16 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.a(SearchPageType.PAGE_LOCAL_SEARCH_MINIAPP_MORE, SearchDetailModule.MODULE_UNKNOWN);
        } else {
            a16 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.a(SearchPageType.PAGE_LOCAL_SEARCH, SearchDetailModule.MODULE_UNKNOWN);
        }
        y16.put("host_scene", String.valueOf(a16));
        if (this.miniAppType == 1) {
            str = "1";
        } else {
            str = "2";
        }
        y16.put("result_source", str);
        return y16;
    }

    @Override // com.tencent.mobileqq.search.model.z
    @NotNull
    public String z() {
        String z16;
        g gVar = this.miniAppMode;
        if (gVar == null || (z16 = gVar.z()) == null) {
            return "";
        }
        return z16;
    }
}
