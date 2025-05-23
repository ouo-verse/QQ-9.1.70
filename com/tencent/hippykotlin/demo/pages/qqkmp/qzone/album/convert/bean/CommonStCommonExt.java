package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;", "", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "mapBytesInfo", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBytesEntry;", "getMapBytesInfo", "()Ljava/util/List;", "setMapBytesInfo", "(Ljava/util/List;)V", ThirdPartyMiniApiImpl.KEY_MAP_INFO, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonEntry;", "getMapInfo", "setMapInfo", "mapUserAccount", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUserAccountEntry;", "getMapUserAccount", "setMapUserAccount", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStCommonExt {
    public static final int $stable = 8;
    private List<CommonEntry> mapInfo = new ArrayList();
    private String attachInfo = "";
    private List<CommonBytesEntry> mapBytesInfo = new ArrayList();
    private List<CommonStUserAccountEntry> mapUserAccount = new ArrayList();

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final List<CommonBytesEntry> getMapBytesInfo() {
        return this.mapBytesInfo;
    }

    public final List<CommonEntry> getMapInfo() {
        return this.mapInfo;
    }

    public final List<CommonStUserAccountEntry> getMapUserAccount() {
        return this.mapUserAccount;
    }

    public final void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public final void setMapBytesInfo(List<CommonBytesEntry> list) {
        this.mapBytesInfo = list;
    }

    public final void setMapInfo(List<CommonEntry> list) {
        this.mapInfo = list;
    }

    public final void setMapUserAccount(List<CommonStUserAccountEntry> list) {
        this.mapUserAccount = list;
    }
}
