package com.tencent.mobileqq.mini.entry.newdesktop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "moduleTitle", "getModuleTitle", "setModuleTitle", "moduleType", "", "getModuleType", "()I", "setModuleType", "(I)V", "position", "getPosition", "setPosition", "compareTo", "obj", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PositionItemInfo implements Comparable<Object> {
    private String appId = "";
    private String moduleTitle = "";
    private int moduleType;
    private int position;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo");
        int i3 = this.position;
        int i16 = ((PositionItemInfo) obj).position;
        if (i3 == i16) {
            return 0;
        }
        return i3 > i16 ? 1 : -1;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getModuleTitle() {
        return this.moduleTitle;
    }

    public final int getModuleType() {
        return this.moduleType;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final void setModuleTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moduleTitle = str;
    }

    public final void setModuleType(int i3) {
        this.moduleType = i3;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public String toString() {
        return "index:" + this.position + "-type:" + this.moduleType + "-appId:" + this.appId + "-title:" + this.moduleTitle;
    }
}
