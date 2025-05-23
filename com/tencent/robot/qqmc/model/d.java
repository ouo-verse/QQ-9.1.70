package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/qqmc/model/d;", "", "", "toString", "url", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    @SerializedName("url")
    @NotNull
    private String url = "mqqapi://kuikly/open?src_type=internal&version=1&source=1&target=52&channel=2&page_name=qsearch_detail&querySource=25&user_source=14&hide_tab=1&tab_mask=10&bundle_name=qqsearch&close_self=true";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public String toString() {
        return "url=" + this.url;
    }
}
