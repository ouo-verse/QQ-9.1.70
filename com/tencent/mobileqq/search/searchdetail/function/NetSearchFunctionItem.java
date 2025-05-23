package com.tencent.mobileqq.search.searchdetail.function;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/function/d;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", "toString", "I", "Ljava/lang/String;", "B", "()Ljava/lang/String;", UserInfo.SEX_FEMALE, "(Ljava/lang/String;)V", "text", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "imageUrl", "K", "y", BdhLogUtil.LogTag.Tag_Conn, Utils.KEY_BUSINESS_ID, "L", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", WadlProxyConsts.KEY_JUMP_URL, "<init>", "()V", "M", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.function.d, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchFunctionItem extends QSearchBaseTitleGroupTemplateItem {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String text;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private String imageUrl;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private String fid;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    @NotNull
    private String jumpUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/function/d$a;", "", "Lcom/tencent/mobileqq/search/searchdetail/b;", "c", "", "jsonString", "Lcom/tencent/mobileqq/search/searchdetail/function/d;", "b", "KEY_FID", "Ljava/lang/String;", "KEY_ICON", "KEY_JUMP_URL", "KEY_NAME", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.function.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CommonInfo c() {
            return new CommonInfo("-555", "function", "", 0, "", "", new byte[0], 1000, null, false, false, 1792, null);
        }

        @Nullable
        public final NetSearchFunctionItem b(@NotNull String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            NetSearchFunctionItem netSearchFunctionItem = new NetSearchFunctionItem();
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                String string = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(KEY_NAME)");
                netSearchFunctionItem.F(string);
                String string2 = jSONObject.getString("iconUrl");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(KEY_ICON)");
                netSearchFunctionItem.D(string2);
                String string3 = jSONObject.getString(Utils.KEY_BUSINESS_ID);
                Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(KEY_FID)");
                netSearchFunctionItem.C(string3);
                String string4 = jSONObject.getString(WadlProxyConsts.KEY_JUMP_URL);
                Intrinsics.checkNotNullExpressionValue(string4, "jsonObject.getString(KEY_JUMP_URL)");
                netSearchFunctionItem.E(string4);
                return netSearchFunctionItem;
            } catch (Exception unused) {
                return null;
            }
        }

        Companion() {
        }
    }

    public NetSearchFunctionItem() {
        super(INSTANCE.c(), new SearchTemplate());
        this.text = "";
        this.imageUrl = "";
        this.fid = "";
        this.jumpUrl = "";
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fid = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 16;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem
    @NotNull
    public String toString() {
        return "NetSearchFunctionItem(text='" + this.text + "', imageUrl='" + this.imageUrl + "', fid='" + this.fid + "', jumpUrl='" + this.jumpUrl + "') " + super.toString();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getFid() {
        return this.fid;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }
}
