package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "", WidgetCacheConstellationData.NUM, "I", "getNum", "()I", "setNum", "(I)V", "liked", "getLiked", "setLiked", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStMediaLike {
    public static final int $stable = 8;
    private String key = "";
    private int liked;
    private int num;

    public final String getKey() {
        return this.key;
    }

    public final int getLiked() {
        return this.liked;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setLiked(int i3) {
        this.liked = i3;
    }

    public final void setNum(int i3) {
        this.num = i3;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.v("key", this.key);
        eVar.t(WidgetCacheConstellationData.NUM, this.num);
        eVar.t("liked", this.liked);
        return eVar;
    }
}
