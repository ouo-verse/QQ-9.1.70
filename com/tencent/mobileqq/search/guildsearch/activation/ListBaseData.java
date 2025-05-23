package com.tencent.mobileqq.search.guildsearch.activation;

import com.tencent.aio.widget.textView.param.a;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisOperationHotSearch;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisOperationHotSearchItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0005\u0010\n\u0003B\u0019\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u0082\u0001\u0003\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "", "", "c", "", "a", "I", "()I", "dataType", "", "b", "J", "()J", "id", "<init>", "(IJ)V", "OperationHotSearchItemData", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class ListBaseData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int dataType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b,\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000f\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "Ljava/io/Serializable;", "", "toString", "", "other", "", "equals", "", "hashCode", "word", "Ljava/lang/String;", "getWord", "()Ljava/lang/String;", "setWord", "(Ljava/lang/String;)V", "tagText", "getTagText", "setTagText", "tagColor", "getTagColor", "setTagColor", "tagBgColor", "getTagBgColor", "setTagBgColor", "serialNumUrl", "getSerialNumUrl", "setSerialNumUrl", "jumpType", "I", "getJumpType", "()I", "setJumpType", "(I)V", WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl", "setJumpUrl", "reportData", "getReportData", "setReportData", "isManualOperation", "Z", "()Z", "setManualOperation", "(Z)V", "hotSearchTextId", "getHotSearchTextId", "setHotSearchTextId", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class OperationHotSearchItemData implements Serializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private String hotSearchTextId;
        private boolean isManualOperation;
        private int jumpType;

        @Nullable
        private String jumpUrl;

        @Nullable
        private String reportData;

        @Nullable
        private String serialNumUrl;

        @Nullable
        private String tagBgColor;

        @Nullable
        private String tagColor;

        @Nullable
        private String tagText;

        @Nullable
        private String word;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisOperationHotSearchItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.guildsearch.activation.ListBaseData$OperationHotSearchItemData$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final OperationHotSearchItemData a(@NotNull UfsDisOperationHotSearchItem item) {
                boolean startsWith$default;
                String replaceFirst$default;
                Intrinsics.checkNotNullParameter(item, "item");
                OperationHotSearchItemData operationHotSearchItemData = new OperationHotSearchItemData();
                operationHotSearchItemData.setWord(item.word);
                operationHotSearchItemData.setTagText(item.icons.text);
                operationHotSearchItemData.setTagColor(item.icons.color);
                operationHotSearchItemData.setTagBgColor(item.icons.background);
                operationHotSearchItemData.setSerialNumUrl(item.serialNumUrl);
                operationHotSearchItemData.setJumpType(item.jumpLink.jumpType);
                operationHotSearchItemData.setJumpUrl(item.jumpLink.jumpUrl);
                String jumpUrl = operationHotSearchItemData.getJumpUrl();
                if (jumpUrl != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://ecommerce", false, 2, null);
                    if (startsWith$default) {
                        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(jumpUrl, "mqqapi://ecommerce", "mqqapi://kuikly", false, 4, (Object) null);
                        operationHotSearchItemData.setJumpUrl(replaceFirst$default);
                    }
                }
                byte[] bArr = item.reportData;
                Intrinsics.checkNotNullExpressionValue(bArr, "item.reportData");
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                operationHotSearchItemData.setReportData(new String(bArr, UTF_8));
                operationHotSearchItemData.setManualOperation(item.isManualOperation);
                operationHotSearchItemData.setHotSearchTextId(item.hotSearchTextId);
                return operationHotSearchItemData;
            }

            Companion() {
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OperationHotSearchItemData)) {
                return false;
            }
            OperationHotSearchItemData operationHotSearchItemData = (OperationHotSearchItemData) other;
            if (Intrinsics.areEqual(this.word, operationHotSearchItemData.word) && Intrinsics.areEqual(this.tagText, operationHotSearchItemData.tagText) && Intrinsics.areEqual(this.tagColor, operationHotSearchItemData.tagColor) && Intrinsics.areEqual(this.tagBgColor, operationHotSearchItemData.tagBgColor) && Intrinsics.areEqual(this.serialNumUrl, operationHotSearchItemData.serialNumUrl) && this.jumpType == operationHotSearchItemData.jumpType && Intrinsics.areEqual(this.jumpUrl, operationHotSearchItemData.jumpUrl) && Intrinsics.areEqual(this.reportData, operationHotSearchItemData.reportData) && this.isManualOperation == operationHotSearchItemData.isManualOperation && Intrinsics.areEqual(this.hotSearchTextId, operationHotSearchItemData.hotSearchTextId)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getHotSearchTextId() {
            return this.hotSearchTextId;
        }

        public final int getJumpType() {
            return this.jumpType;
        }

        @Nullable
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @Nullable
        public final String getReportData() {
            return this.reportData;
        }

        @Nullable
        public final String getSerialNumUrl() {
            return this.serialNumUrl;
        }

        @Nullable
        public final String getTagBgColor() {
            return this.tagBgColor;
        }

        @Nullable
        public final String getTagColor() {
            return this.tagColor;
        }

        @Nullable
        public final String getTagText() {
            return this.tagText;
        }

        @Nullable
        public final String getWord() {
            return this.word;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            String str = this.word;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = i3 * 31;
            String str2 = this.tagText;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 31;
            String str3 = this.tagColor;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 31;
            String str4 = this.tagBgColor;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 31;
            String str5 = this.serialNumUrl;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (((i38 + i19) * 31) + this.jumpType) * 31;
            String str6 = this.jumpUrl;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 31;
            String str7 = this.reportData;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int a16 = (((i46 + i27) * 31) + a.a(this.isManualOperation)) * 31;
            String str8 = this.hotSearchTextId;
            if (str8 != null) {
                i28 = str8.hashCode();
            }
            return a16 + i28;
        }

        /* renamed from: isManualOperation, reason: from getter */
        public final boolean getIsManualOperation() {
            return this.isManualOperation;
        }

        public final void setHotSearchTextId(@Nullable String str) {
            this.hotSearchTextId = str;
        }

        public final void setJumpType(int i3) {
            this.jumpType = i3;
        }

        public final void setJumpUrl(@Nullable String str) {
            this.jumpUrl = str;
        }

        public final void setManualOperation(boolean z16) {
            this.isManualOperation = z16;
        }

        public final void setReportData(@Nullable String str) {
            this.reportData = str;
        }

        public final void setSerialNumUrl(@Nullable String str) {
            this.serialNumUrl = str;
        }

        public final void setTagBgColor(@Nullable String str) {
            this.tagBgColor = str;
        }

        public final void setTagColor(@Nullable String str) {
            this.tagColor = str;
        }

        public final void setTagText(@Nullable String str) {
            this.tagText = str;
        }

        public final void setWord(@Nullable String str) {
            this.word = str;
        }

        @NotNull
        public String toString() {
            return "OperationHotSearchItemData(word=" + this.word + ", tagText=" + this.tagText + ", tagColor=" + this.tagColor + ", tagBgColor=" + this.tagBgColor + ", serialNumUrl=" + this.serialNumUrl + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", isManualOperation=" + this.isManualOperation + ", hotSearchTextId=" + this.hotSearchTextId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001\fBM\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\u0004\b&\u0010'J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0010\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "", "other", "", "equals", "", "hashCode", "", "toString", "c", "I", "a", "()I", "dataType", "", "d", "J", "b", "()J", "id", "e", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "title", "f", "picUrl", "getPicJumpType", "picJumpType", h.F, "picJumpUrl", "", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "i", "Ljava/util/List;", "()Ljava/util/List;", "items", "<init>", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "j", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.guildsearch.activation.ListBaseData$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class OperationHotData extends ListBaseData {

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int dataType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String picUrl;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int picJumpType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String picJumpUrl;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<OperationHotSearchItemData> items;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisResult;", "result", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.guildsearch.activation.ListBaseData$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final OperationHotData a(@NotNull UfsDisResult result) {
                boolean startsWith$default;
                String str;
                String replaceFirst$default;
                Intrinsics.checkNotNullParameter(result, "result");
                UfsDisOperationHotSearch ufsDisOperationHotSearch = result.operationHotSearchItems;
                String title = ufsDisOperationHotSearch.title;
                String picUrl = ufsDisOperationHotSearch.picUrl;
                String picJumpUrl = ufsDisOperationHotSearch.picJumpLink.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(picJumpUrl, "picJumpUrl");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(picJumpUrl, "mqqapi://ecommerce", false, 2, null);
                if (startsWith$default) {
                    Intrinsics.checkNotNullExpressionValue(picJumpUrl, "picJumpUrl");
                    replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(picJumpUrl, "mqqapi://ecommerce", "mqqapi://kuikly", false, 4, (Object) null);
                    str = replaceFirst$default;
                } else {
                    str = picJumpUrl;
                }
                int i3 = ufsDisOperationHotSearch.picJumpLink.jumpType;
                ArrayList arrayList = new ArrayList();
                ArrayList<UfsDisOperationHotSearchItem> items = ufsDisOperationHotSearch.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "hotSearch.getItems()");
                for (UfsDisOperationHotSearchItem it : items) {
                    OperationHotSearchItemData.Companion companion = OperationHotSearchItemData.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(companion.a(it));
                }
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
                return new OperationHotData(0, 0L, title, picUrl, i3, str, arrayList, 1, null);
            }

            Companion() {
            }
        }

        public /* synthetic */ OperationHotData(int i3, long j3, String str, String str2, int i16, String str3, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 2 : i3, j3, str, str2, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? null : str3, list);
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: a, reason: from getter */
        public int getDataType() {
            return this.dataType;
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @NotNull
        public final List<OperationHotSearchItemData> d() {
            return this.items;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getPicJumpUrl() {
            return this.picJumpUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OperationHotData)) {
                return false;
            }
            OperationHotData operationHotData = (OperationHotData) other;
            if (getDataType() == operationHotData.getDataType() && getId() == operationHotData.getId() && Intrinsics.areEqual(this.title, operationHotData.title) && Intrinsics.areEqual(this.picUrl, operationHotData.picUrl) && this.picJumpType == operationHotData.picJumpType && Intrinsics.areEqual(this.picJumpUrl, operationHotData.picJumpUrl) && Intrinsics.areEqual(this.items, operationHotData.items)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getPicUrl() {
            return this.picUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int i3;
            int dataType = ((((((((getDataType() * 31) + androidx.fragment.app.a.a(getId())) * 31) + this.title.hashCode()) * 31) + this.picUrl.hashCode()) * 31) + this.picJumpType) * 31;
            String str = this.picJumpUrl;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return ((dataType + i3) * 31) + this.items.hashCode();
        }

        @NotNull
        public String toString() {
            return "OperationHotData(dataType=" + getDataType() + ", id=" + getId() + ", title=" + this.title + ", picUrl=" + this.picUrl + ", picJumpType=" + this.picJumpType + ", picJumpUrl=" + this.picJumpUrl + ", items=" + this.items + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OperationHotData(int i3, long j3, @NotNull String title, @NotNull String picUrl, int i16, @Nullable String str, @NotNull List<OperationHotSearchItemData> items) {
            super(i3, j3, null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            Intrinsics.checkNotNullParameter(items, "items");
            this.dataType = i3;
            this.id = j3;
            this.title = title;
            this.picUrl = picUrl;
            this.picJumpType = i16;
            this.picJumpUrl = str;
            this.items = items;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "", "c", "", "other", "", "equals", "", "hashCode", "toString", "I", "a", "()I", "dataType", "", "d", "J", "b", "()J", "id", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "keyWord", "f", "(I)V", "totalHistoryCount", "<init>", "(IJLjava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.guildsearch.activation.ListBaseData$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchHistoryData extends ListBaseData {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int dataType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String keyWord;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int totalHistoryCount;

        public /* synthetic */ SearchHistoryData(int i3, long j3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 1 : i3, j3, str, (i17 & 8) != 0 ? 0 : i16);
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: a, reason: from getter */
        public int getDataType() {
            return this.dataType;
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        @NotNull
        public String c() {
            return getDataType() + Marker.ANY_NON_NULL_MARKER + getId() + Marker.ANY_NON_NULL_MARKER + this.keyWord;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getKeyWord() {
            return this.keyWord;
        }

        /* renamed from: e, reason: from getter */
        public final int getTotalHistoryCount() {
            return this.totalHistoryCount;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchHistoryData)) {
                return false;
            }
            SearchHistoryData searchHistoryData = (SearchHistoryData) other;
            if (getDataType() == searchHistoryData.getDataType() && getId() == searchHistoryData.getId() && Intrinsics.areEqual(this.keyWord, searchHistoryData.keyWord) && this.totalHistoryCount == searchHistoryData.totalHistoryCount) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.totalHistoryCount = i3;
        }

        public int hashCode() {
            return (((((getDataType() * 31) + androidx.fragment.app.a.a(getId())) * 31) + this.keyWord.hashCode()) * 31) + this.totalHistoryCount;
        }

        @NotNull
        public String toString() {
            return "SearchHistoryData(dataType=" + getDataType() + ", id=" + getId() + ", keyWord=" + this.keyWord + ", totalHistoryCount=" + this.totalHistoryCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchHistoryData(int i3, long j3, @NotNull String keyWord, int i16) {
            super(i3, j3, null);
            Intrinsics.checkNotNullParameter(keyWord, "keyWord");
            this.dataType = i3;
            this.id = j3;
            this.keyWord = keyWord;
            this.totalHistoryCount = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "", "other", "", "equals", "", "hashCode", "", "toString", "c", "I", "a", "()I", "dataType", "", "d", "J", "b", "()J", "id", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "f", "setTotalHistoryCount", "(I)V", "totalHistoryCount", "<init>", "(IJLjava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.guildsearch.activation.ListBaseData$c, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class ShowAllHistoryData extends ListBaseData {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int dataType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int totalHistoryCount;

        public /* synthetic */ ShowAllHistoryData(int i3, long j3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 3 : i3, (i17 & 2) != 0 ? 0L : j3, str, (i17 & 8) != 0 ? 0 : i16);
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: a, reason: from getter */
        public int getDataType() {
            return this.dataType;
        }

        @Override // com.tencent.mobileqq.search.guildsearch.activation.ListBaseData
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: e, reason: from getter */
        public final int getTotalHistoryCount() {
            return this.totalHistoryCount;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowAllHistoryData)) {
                return false;
            }
            ShowAllHistoryData showAllHistoryData = (ShowAllHistoryData) other;
            if (getDataType() == showAllHistoryData.getDataType() && getId() == showAllHistoryData.getId() && Intrinsics.areEqual(this.text, showAllHistoryData.text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((getDataType() * 31) + androidx.fragment.app.a.a(getId())) * 31) + this.text.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowAllHistoryData(dataType=" + getDataType() + ", id=" + getId() + ", text=" + this.text + ", totalHistoryCount=" + this.totalHistoryCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowAllHistoryData(int i3, long j3, @NotNull String text, int i16) {
            super(i3, j3, null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.dataType = i3;
            this.id = j3;
            this.text = text;
            this.totalHistoryCount = i16;
        }
    }

    public /* synthetic */ ListBaseData(int i3, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3);
    }

    /* renamed from: a, reason: from getter */
    public int getDataType() {
        return this.dataType;
    }

    /* renamed from: b, reason: from getter */
    public long getId() {
        return this.id;
    }

    @NotNull
    public String c() {
        return getDataType() + Marker.ANY_NON_NULL_MARKER + getId();
    }

    ListBaseData(int i3, long j3) {
        this.dataType = i3;
        this.id = j3;
    }
}
