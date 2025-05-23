package com.tencent.mobileqq.mini.entry.desktop.item;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class DesktopItemInfo {
    public static final int TYPE_APP_LIST = 6;
    public static final int TYPE_MINI_APP = 2;
    public static final int TYPE_MINI_EMPTY = 3;
    public static final int TYPE_MINI_MODULE_GUIDE = 4;
    public static final int TYPE_MINI_SEARCH = 5;
    public static final int TYPE_MODULE_BANNER = 19;
    public static final int TYPE_MODULE_INFO = 1;
    public static final int TYPE_SPRING_ENTRY = 13;
    public int mModuleType;
    public int requestScene;
    public long requestStartTs;
    public boolean dragEnable = false;
    public boolean dropEnable = false;
    public boolean deleteEnable = false;
    public int visible = 0;
    public boolean isTemp = false;
    private boolean isFixApp = false;

    public Boolean areContentsTheSame(DesktopItemInfo desktopItemInfo) {
        return Boolean.FALSE;
    }

    public Boolean areItemsTheSame(DesktopItemInfo desktopItemInfo) {
        return Boolean.FALSE;
    }

    public Object getChangePayload(DesktopItemInfo desktopItemInfo) {
        return new Object();
    }

    public int getModuleType() {
        return this.mModuleType;
    }

    public abstract int getViewType();

    public boolean isFixApp() {
        return this.isFixApp;
    }

    public void setIsFixApp(boolean z16) {
        this.isFixApp = z16;
    }

    public void setIsTemp(boolean z16) {
        int i3;
        this.isTemp = z16;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        this.visible = i3;
    }
}
