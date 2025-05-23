package com.tencent.mobileqq.mini.entry.expDesktop.bean;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopAppModuleInfo;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "moduleType", "", "moduleTitle", "", "direction", "aggregate", "(ILjava/lang/String;ILjava/lang/String;)V", "mAggregate", "getMAggregate", "()Ljava/lang/String;", "setMAggregate", "(Ljava/lang/String;)V", "mDirection", "getMDirection", "()I", "setMDirection", "(I)V", "getViewType", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopAppModuleInfo extends DesktopAppModuleInfo {
    private String mAggregate;
    private int mDirection;

    public ExpDesktopAppModuleInfo(int i3, String str, int i16, String str2) {
        super(i3, str);
        this.mDirection = i16;
        this.mAggregate = str2;
    }

    public final String getMAggregate() {
        return this.mAggregate;
    }

    public final int getMDirection() {
        return this.mDirection;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo, com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 1;
    }

    public final void setMAggregate(String str) {
        this.mAggregate = str;
    }

    public final void setMDirection(int i3) {
        this.mDirection = i3;
    }
}
