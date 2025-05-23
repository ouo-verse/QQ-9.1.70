package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.ark.ark;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "", "()V", "extIds", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionExtID;", "getExtIds", "()Ljava/util/List;", "setExtIds", "(Ljava/util/List;)V", "feedId", "", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "serializedData", "getSerializedData", "setSerializedData", "ufKey", "getUfKey", "setUfKey", "ugcId", "getUgcId", "setUgcId", "toString", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonUnionID {
    private List<CommonUnionExtID> extIds = new ArrayList();
    private String feedId;
    private String serializedData;
    private String ufKey;
    private String ugcId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID$Companion;", "", "", "jsonStr", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "fromJson", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ark.ARKMETADATA_JSON, "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommonUnionID fromJson(String jsonStr) {
            return fromJson(new e(jsonStr));
        }

        Companion() {
        }

        public final CommonUnionID fromJson(e json) {
            CommonUnionID commonUnionID = new CommonUnionID();
            commonUnionID.setUfKey(json.p("ufKey"));
            commonUnionID.setUgcId(json.p("ugcId"));
            commonUnionID.setFeedId(json.p("feedId"));
            b l3 = json.l("extIds");
            if (l3 != null) {
                commonUnionID.setExtIds(new ArrayList());
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    e l16 = l3.l(i3);
                    if (l16 != null) {
                        commonUnionID.getExtIds().add(CommonUnionExtID.INSTANCE.fromJson(l16));
                    }
                }
            }
            return commonUnionID;
        }
    }

    public final List<CommonUnionExtID> getExtIds() {
        return this.extIds;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getSerializedData() {
        return this.serializedData;
    }

    public final String getUfKey() {
        return this.ufKey;
    }

    public final String getUgcId() {
        return this.ugcId;
    }

    public final void setExtIds(List<CommonUnionExtID> list) {
        this.extIds = list;
    }

    public final void setFeedId(String str) {
        this.feedId = str;
    }

    public final void setSerializedData(String str) {
        this.serializedData = str;
    }

    public final void setUfKey(String str) {
        this.ufKey = str;
    }

    public final void setUgcId(String str) {
        this.ugcId = str;
    }

    public String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CommonUnionID@");
        m3.append(hashCode());
        m3.append("(ufKey=");
        m3.append(this.ufKey);
        m3.append(", ugcId=");
        m3.append(this.ugcId);
        m3.append(", feedId=");
        m3.append(this.feedId);
        m3.append(", extIdsSize=");
        m3.append(this.extIds.size());
        m3.append(')');
        return m3.toString();
    }
}
