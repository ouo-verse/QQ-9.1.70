package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/d;", "", "", "clickId", "Ljava/lang/String;", "getClickId", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "", VasWebviewConstants.KEY_ADTAG, "I", "getAdTag", "()I", "a", "(I)V", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {

    @SerializedName("ad_tag")
    private int adTag;

    @SerializedName("clickid")
    @NotNull
    private String clickId = "";

    public final void a(int i3) {
        this.adTag = i3;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clickId = str;
    }
}
