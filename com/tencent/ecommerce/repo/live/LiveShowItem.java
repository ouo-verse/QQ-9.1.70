package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import com.tencent.ecommerce.repo.live.LiveProduct;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\nB5\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u0016\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/repo/live/r;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/live/p;", "a", "Lcom/tencent/ecommerce/repo/live/p;", "b", "()Lcom/tencent/ecommerce/repo/live/p;", "setMainCover", "(Lcom/tencent/ecommerce/repo/live/p;)V", "mainCover", "d", "setTitleIcon", "titleIcon", "", "Lcom/tencent/ecommerce/repo/live/HotLabel;", "c", "Ljava/util/List;", "()Ljava/util/List;", "setLabelList", "(Ljava/util/List;)V", "labelList", "Lcom/tencent/ecommerce/repo/live/q$b;", "Lcom/tencent/ecommerce/repo/live/q$b;", "()Lcom/tencent/ecommerce/repo/live/q$b;", "setPrice", "(Lcom/tencent/ecommerce/repo/live/q$b;)V", "price", "<init>", "(Lcom/tencent/ecommerce/repo/live/p;Lcom/tencent/ecommerce/repo/live/p;Ljava/util/List;Lcom/tencent/ecommerce/repo/live/q$b;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.r, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LiveShowItem {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private LivePicInfo mainCover;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private LivePicInfo titleIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<HotLabel> labelList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private LiveProduct.Price price;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/r$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/repo/live/r;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.r$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveShowItem a(JSONObject json) {
            if (json == null) {
                return null;
            }
            JSONObject optJSONObject = json.optJSONObject("main_cover");
            JSONObject optJSONObject2 = json.optJSONObject("title_icon");
            JSONObject optJSONObject3 = json.optJSONObject("price");
            JSONArray optJSONArray = json.optJSONArray("hot_labels");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (!(obj instanceof JSONObject)) {
                        obj = null;
                    }
                    arrayList.add(HotLabel.INSTANCE.a((JSONObject) obj));
                }
            }
            return new LiveShowItem(new LivePicInfo(optJSONObject), new LivePicInfo(optJSONObject2), arrayList, new LiveProduct.Price(optJSONObject3));
        }
    }

    public LiveShowItem(LivePicInfo livePicInfo, LivePicInfo livePicInfo2, List<HotLabel> list, LiveProduct.Price price) {
        this.mainCover = livePicInfo;
        this.titleIcon = livePicInfo2;
        this.labelList = list;
        this.price = price;
    }

    public final List<HotLabel> a() {
        return this.labelList;
    }

    /* renamed from: b, reason: from getter */
    public final LivePicInfo getMainCover() {
        return this.mainCover;
    }

    /* renamed from: c, reason: from getter */
    public final LiveProduct.Price getPrice() {
        return this.price;
    }

    /* renamed from: d, reason: from getter */
    public final LivePicInfo getTitleIcon() {
        return this.titleIcon;
    }

    public int hashCode() {
        LivePicInfo livePicInfo = this.mainCover;
        int hashCode = (livePicInfo != null ? livePicInfo.hashCode() : 0) * 31;
        LivePicInfo livePicInfo2 = this.titleIcon;
        int hashCode2 = (hashCode + (livePicInfo2 != null ? livePicInfo2.hashCode() : 0)) * 31;
        List<HotLabel> list = this.labelList;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        LiveProduct.Price price = this.price;
        return hashCode3 + (price != null ? price.hashCode() : 0);
    }

    public String toString() {
        return "LiveShowItem(mainCover=" + this.mainCover + ", titleIcon=" + this.titleIcon + ", labelList=" + this.labelList + ", price=" + this.price + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveShowItem)) {
            return false;
        }
        LiveShowItem liveShowItem = (LiveShowItem) other;
        return Intrinsics.areEqual(this.mainCover, liveShowItem.mainCover) && Intrinsics.areEqual(this.titleIcon, liveShowItem.titleIcon) && Intrinsics.areEqual(this.labelList, liveShowItem.labelList) && Intrinsics.areEqual(this.price, liveShowItem.price);
    }
}
