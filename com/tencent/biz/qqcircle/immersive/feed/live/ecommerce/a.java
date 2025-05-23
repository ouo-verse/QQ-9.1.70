package com.tencent.biz.qqcircle.immersive.feed.live.ecommerce;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0003B1\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0005R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "richText", "b", "getDetailUrl", "detailUrl", "", "c", "I", "getGoodsType", "()I", "goodsType", "d", "getMediaProductId", "mediaProductId", "Lorg/json/JSONObject;", "e", "Lorg/json/JSONObject;", "getReportInfo", "()Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;)V", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String richText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String detailUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int goodsType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mediaProductId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JSONObject reportInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/a$a;", "", "Lorg/json/JSONObject;", "data", "Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/a;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull JSONObject data) {
            int i3;
            String str;
            Intrinsics.checkNotNullParameter(data, "data");
            JSONObject optJSONObject = data.optJSONObject("bubble_info");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(ReportDataBuilder.KEY_PRODUCT_ID);
            String optString = optJSONObject.optString("rich_txt");
            Intrinsics.checkNotNullExpressionValue(optString, "bubbleJson.optString(\"rich_txt\")");
            String optString2 = optJSONObject.optString("detail_url");
            Intrinsics.checkNotNullExpressionValue(optString2, "bubbleJson.optString(\"detail_url\")");
            if (optJSONObject2 != null) {
                i3 = optJSONObject2.optInt("goods_type");
            } else {
                i3 = 0;
            }
            int i16 = i3;
            if (optJSONObject2 != null) {
                str = optJSONObject2.optString("media_product_id");
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            return new a(optString, optString2, i16, str, optJSONObject.optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO));
        }

        Companion() {
        }
    }

    public a(@NotNull String richText, @NotNull String detailUrl, int i3, @NotNull String mediaProductId, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(richText, "richText");
        Intrinsics.checkNotNullParameter(detailUrl, "detailUrl");
        Intrinsics.checkNotNullParameter(mediaProductId, "mediaProductId");
        this.richText = richText;
        this.detailUrl = detailUrl;
        this.goodsType = i3;
        this.mediaProductId = mediaProductId;
        this.reportInfo = jSONObject;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getRichText() {
        return this.richText;
    }
}
