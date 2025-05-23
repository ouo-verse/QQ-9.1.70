package com.qzone.feed.business.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.reborn.util.k;
import com.qzone.util.ar;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u0000 &2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b$\u0010%J.\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000b\u001a\u00020\nR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u0006'"}, d2 = {"Lcom/qzone/feed/business/model/FeedResourceInfo;", "Ljava/io/Serializable;", "", "urlParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "getSourceMaterialUrl", "getResourceId", "", "getResWidthFromUrl", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "text", "getText", IECSearchBar.METHOD_SET_TEXT, "bgLight", "getBgLight", "setBgLight", "bgDark", "getBgDark", "setBgDark", "textColorLight", "getTextColorLight", "setTextColorLight", "textColorDark", "getTextColorDark", "setTextColorDark", WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl", "setJumpUrl", "<init>", "()V", "Companion", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class FeedResourceInfo implements Serializable {
    public static final String TAG = "FeedResourceInfo";

    @SerializedName("bg_dark")
    private String bgDark;

    @SerializedName("bg_light")
    private String bgLight;

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("mode")
    private String mode;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color_dark")
    private String textColorDark;

    @SerializedName("text_color_light")
    private String textColorLight;

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, Float> a(String urlParams) {
        List split$default;
        List split$default2;
        HashMap<String, Float> hashMap = new HashMap<>();
        if (urlParams == null || urlParams.length() == 0) {
            return hashMap;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) urlParams, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            if (split$default2.size() == 2) {
                try {
                    hashMap.put(split$default2.get(0), Float.valueOf(ef.d.g((String) split$default2.get(1))));
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "error msg in parse resUrl : ", e16);
                }
            }
        }
        return hashMap;
    }

    public final String getBgDark() {
        return this.bgDark;
    }

    public final String getBgLight() {
        return this.bgLight;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getMode() {
        return this.mode;
    }

    public final int getResWidthFromUrl() {
        List split$default;
        HashMap<String, Float> hashMap;
        int f16 = bh.a.f28389a.f();
        String sourceMaterialUrl = getSourceMaterialUrl();
        if (sourceMaterialUrl == null || sourceMaterialUrl.length() == 0) {
            return f16;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) sourceMaterialUrl, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (split$default.size() >= 2) {
            hashMap = a((String) split$default.get(1));
        } else {
            hashMap = new HashMap<>();
        }
        Float f17 = hashMap.get("width");
        if (f17 != null && !Intrinsics.areEqual(f17, 0.0f)) {
            return ar.d(f17.floatValue());
        }
        QLog.e(TAG, 1, "URL no widthParam, width:" + f17 + ", resUrl " + sourceMaterialUrl);
        return f16;
    }

    public final String getResourceId() {
        if (k.f59549a.f()) {
            return this.bgDark;
        }
        return this.bgLight;
    }

    public final String getSourceMaterialUrl() {
        String str;
        if (k.f59549a.f()) {
            str = this.bgDark;
        } else {
            str = this.bgLight;
        }
        String a16 = com.tencent.mobileqq.service.qzone.e.f286406a.a(str);
        if (a16 == null || a16.length() == 0) {
            return null;
        }
        return a16;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColorDark() {
        return this.textColorDark;
    }

    public final String getTextColorLight() {
        return this.textColorLight;
    }

    public final void setBgDark(String str) {
        this.bgDark = str;
    }

    public final void setBgLight(String str) {
        this.bgLight = str;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextColorDark(String str) {
        this.textColorDark = str;
    }

    public final void setTextColorLight(String str) {
        this.textColorLight = str;
    }
}
