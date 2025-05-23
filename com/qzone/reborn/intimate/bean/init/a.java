package com.qzone.reborn.intimate.bean.init;

import com.qzone.proxy.feedcomponent.model.RegionData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/a;", "", "", "a", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "spaceId", "b", "setBgImgUrl", RegionData.KEY_BG_IMG_URL, "c", "setPageId", "pageId", "", "d", "Ljava/util/Map;", "()Ljava/util/Map;", "setDaTongPageParamsMap", "(Ljava/util/Map;)V", "daTongPageParamsMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String bgImgUrl = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String pageId = "close_friend_space_id";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> daTongPageParamsMap = new LinkedHashMap();

    /* renamed from: a, reason: from getter */
    public final String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final Map<String, Object> b() {
        return this.daTongPageParamsMap;
    }

    /* renamed from: c, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }
}
