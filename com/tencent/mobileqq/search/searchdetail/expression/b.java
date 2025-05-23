package com.tencent.mobileqq.search.searchdetail.expression;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchExpressionTemplateItem;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import hp2.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002\u0015\u000eB#\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u0018\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R<\u0010-\u001a\u001c\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0006\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/expression/b;", "", "Landroid/widget/ImageView;", "imageVIew", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchPicture;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "expressionInfo", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/c;", "data", "d", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/search/searchdetail/expression/b$b;", "b", "e", "", "column", "f", h.F, "Lhp2/k;", "a", "Lhp2/k;", "binding", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "Lkotlin/jvm/functions/Function1;", "jumpCallback", "", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "Ljava/util/List;", "views", "I", "columnCount", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/c;", "currentData", "Lkotlin/Function3;", "Landroid/view/View;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "", "Lkotlin/jvm/functions/Function3;", "getReportProvider", "()Lkotlin/jvm/functions/Function3;", "g", "(Lkotlin/jvm/functions/Function3;)V", "reportProvider", "<init>", "(Lhp2/k;Lkotlin/jvm/functions/Function1;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<SearchJump, Unit> jumpCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ImageFilterView> views;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int columnCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NetSearchExpressionTemplateItem currentData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function3<? super View, ? super SearchReportInfo, ? super String, Unit> reportProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0082\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\u000b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/expression/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "md5", "b", "d", "url", "c", "getThumbMd5", "thumbMd5", "getThumbUrl", "thumbUrl", "e", "getSrcDesc", "srcDesc", "f", "srcPackName", "g", "srcWebUrl", h.F, "getSrcIconUrl", "srcIconUrl", "i", "getImgOther", "imgOther", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.expression.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class ExpressionInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String md5;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String thumbMd5;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String thumbUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String srcDesc;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String srcPackName;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String srcWebUrl;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String srcIconUrl;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String imgOther;

        public ExpressionInfo() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMd5() {
            return this.md5;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getSrcPackName() {
            return this.srcPackName;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSrcWebUrl() {
            return this.srcWebUrl;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExpressionInfo)) {
                return false;
            }
            ExpressionInfo expressionInfo = (ExpressionInfo) other;
            if (Intrinsics.areEqual(this.md5, expressionInfo.md5) && Intrinsics.areEqual(this.url, expressionInfo.url) && Intrinsics.areEqual(this.thumbMd5, expressionInfo.thumbMd5) && Intrinsics.areEqual(this.thumbUrl, expressionInfo.thumbUrl) && Intrinsics.areEqual(this.srcDesc, expressionInfo.srcDesc) && Intrinsics.areEqual(this.srcPackName, expressionInfo.srcPackName) && Intrinsics.areEqual(this.srcWebUrl, expressionInfo.srcWebUrl) && Intrinsics.areEqual(this.srcIconUrl, expressionInfo.srcIconUrl) && Intrinsics.areEqual(this.imgOther, expressionInfo.imgOther)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((this.md5.hashCode() * 31) + this.url.hashCode()) * 31) + this.thumbMd5.hashCode()) * 31) + this.thumbUrl.hashCode()) * 31) + this.srcDesc.hashCode()) * 31) + this.srcPackName.hashCode()) * 31) + this.srcWebUrl.hashCode()) * 31) + this.srcIconUrl.hashCode()) * 31) + this.imgOther.hashCode();
        }

        @NotNull
        public String toString() {
            return "ExpressionInfo(md5=" + this.md5 + ", url=" + this.url + ", thumbMd5=" + this.thumbMd5 + ", thumbUrl=" + this.thumbUrl + ", srcDesc=" + this.srcDesc + ", srcPackName=" + this.srcPackName + ", srcWebUrl=" + this.srcWebUrl + ", srcIconUrl=" + this.srcIconUrl + ", imgOther=" + this.imgOther + ")";
        }

        public ExpressionInfo(@NotNull String md5, @NotNull String url, @NotNull String thumbMd5, @NotNull String thumbUrl, @NotNull String srcDesc, @NotNull String srcPackName, @NotNull String srcWebUrl, @NotNull String srcIconUrl, @NotNull String imgOther) {
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(thumbMd5, "thumbMd5");
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            Intrinsics.checkNotNullParameter(srcDesc, "srcDesc");
            Intrinsics.checkNotNullParameter(srcPackName, "srcPackName");
            Intrinsics.checkNotNullParameter(srcWebUrl, "srcWebUrl");
            Intrinsics.checkNotNullParameter(srcIconUrl, "srcIconUrl");
            Intrinsics.checkNotNullParameter(imgOther, "imgOther");
            this.md5 = md5;
            this.url = url;
            this.thumbMd5 = thumbMd5;
            this.thumbUrl = thumbUrl;
            this.srcDesc = srcDesc;
            this.srcPackName = srcPackName;
            this.srcWebUrl = srcWebUrl;
            this.srcIconUrl = srcIconUrl;
            this.imgOther = imgOther;
        }

        public /* synthetic */ ExpressionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) == 0 ? str9 : "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull k binding, @NotNull Function1<? super SearchJump, Unit> jumpCallback) {
        List<ImageFilterView> listOf;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.binding = binding;
        this.jumpCallback = jumpCallback;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageFilterView[]{binding.f405678c, binding.f405679d, binding.f405680e, binding.f405681f});
        this.views = listOf;
        this.columnCount = 3;
    }

    private final ExpressionInfo b(JSONObject data) {
        String md5 = data.optString("md5", "");
        String url = data.optString("url", "");
        String thumbMd5 = data.optString("thumb_md5", "");
        String thumbUrl = data.optString(FacadeCacheData.THUMB_URL, "");
        String srcDesc = data.optString("src_desc", "");
        String srcPackName = data.optString("src_pack_name", "");
        String srcWebUrl = data.optString("src_web_url", "");
        String srcIconUrl = data.optString("src_icon_url", "");
        String imgOther = data.optString("img_other", "");
        Intrinsics.checkNotNullExpressionValue(md5, "md5");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Intrinsics.checkNotNullExpressionValue(thumbMd5, "thumbMd5");
        Intrinsics.checkNotNullExpressionValue(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullExpressionValue(srcDesc, "srcDesc");
        Intrinsics.checkNotNullExpressionValue(srcPackName, "srcPackName");
        Intrinsics.checkNotNullExpressionValue(srcWebUrl, "srcWebUrl");
        Intrinsics.checkNotNullExpressionValue(srcIconUrl, "srcIconUrl");
        Intrinsics.checkNotNullExpressionValue(imgOther, "imgOther");
        return new ExpressionInfo(md5, url, thumbMd5, thumbUrl, srcDesc, srcPackName, srcWebUrl, srcIconUrl, imgOther);
    }

    private final void c(ImageView imageVIew, SearchPicture item) {
        o oVar = o.f284545a;
        String str = item.picLink;
        Intrinsics.checkNotNullExpressionValue(str, "item.picLink");
        o.g(oVar, "QQSearch.NetDetail.ExpressionCard", imageVIew, str, null, 8, null);
    }

    private final void d(SearchPicture expressionInfo, NetSearchExpressionTemplateItem data) {
        e(expressionInfo, data);
    }

    private final void e(SearchPicture expressionInfo, NetSearchExpressionTemplateItem data) {
        if (expressionInfo.jumpLink == null) {
            QLog.e("QQSearch.NetDetail.ExpressionCard", 1, "jump but jumpInfo is null");
            return;
        }
        ExpressionInfo b16 = b(new JSONObject(expressionInfo.jumpLink.stringExtension));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("emt_name", b16.getMd5());
        jSONObject.put("emt_oriMd5", b16.getMd5());
        jSONObject.put("emt_oriUrl", b16.getUrl());
        jSONObject.put("emt_type", 3);
        jSONObject.put("emt_packCoverUrl", expressionInfo.picLink);
        jSONObject.put("emt_webUrl", b16.getSrcWebUrl());
        jSONObject.put("emt_packName", b16.getSrcPackName());
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).iniSdkConfig();
        IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
        if (qqApi != null) {
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "methodArgs.toString()");
            qqApi.openSearchEmoticonPage(context, jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, SearchPicture searchPicture, NetSearchExpressionTemplateItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.d(searchPicture, data);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void f(int column) {
        int size = this.views.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 >= column) {
                this.views.get(i3).setVisibility(8);
            } else {
                this.views.get(i3).setVisibility(0);
            }
        }
        this.columnCount = column;
        if (column == 4) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setPadding(root.getPaddingLeft(), root.getPaddingTop(), root.getPaddingRight(), e.c(16.0f));
            return;
        }
        ConstraintLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        root2.setPadding(root2.getPaddingLeft(), root2.getPaddingTop(), root2.getPaddingRight(), 0);
    }

    public final void g(@Nullable Function3<? super View, ? super SearchReportInfo, ? super String, Unit> function3) {
        this.reportProvider = function3;
    }

    public final void h(@NotNull final NetSearchExpressionTemplateItem data) {
        Object orNull;
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        int i3 = this.columnCount;
        for (int i16 = 0; i16 < i3; i16++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(data.y(), i16);
            final SearchPicture searchPicture = (SearchPicture) orNull;
            if (searchPicture == null) {
                this.views.get(i16).setVisibility(4);
            } else {
                this.views.get(i16).setVisibility(0);
                ImageFilterView imageFilterView = this.views.get(i16);
                Intrinsics.checkNotNullExpressionValue(imageFilterView, "views[i]");
                SearchPicture searchPicture2 = data.y().get(i16);
                Intrinsics.checkNotNullExpressionValue(searchPicture2, "data.emotionList[i]");
                c(imageFilterView, searchPicture2);
                Function3<? super View, ? super SearchReportInfo, ? super String, Unit> function3 = this.reportProvider;
                if (function3 != null) {
                    ImageFilterView imageFilterView2 = this.views.get(i16);
                    Intrinsics.checkNotNullExpressionValue(imageFilterView2, "views[i]");
                    SearchReportInfo searchReportInfo = data.y().get(i16).reportInfo;
                    Intrinsics.checkNotNullExpressionValue(searchReportInfo, "data.emotionList[i].reportInfo");
                    function3.invoke(imageFilterView2, searchReportInfo, data.getCommonInfo().getItemId());
                }
                this.views.get(i16).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.expression.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.i(b.this, searchPicture, data, view);
                    }
                });
            }
        }
    }
}
