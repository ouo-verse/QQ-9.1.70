package com.tencent.mobileqq.qqshop.publicaccount.menu;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\nH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\fH\u00c6\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "", "tabId", "", "name", "", "linkUrl", "iconUrl", "pv", "sheetList", "", "tabLevel", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/TabLevel;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/qqshop/publicaccount/menu/TabLevel;)V", "getIconUrl", "()Ljava/lang/String;", "getLinkUrl", "getName", "getPv", "getSheetList", "()Ljava/util/List;", "getTabId", "()I", "getTabLevel", "()Lcom/tencent/mobileqq/qqshop/publicaccount/menu/TabLevel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class MenuItem {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String linkUrl;

    @NotNull
    private final String name;

    @NotNull
    private final String pv;

    @NotNull
    private final List<MenuItem> sheetList;
    private final int tabId;

    @NotNull
    private final TabLevel tabLevel;

    public MenuItem(int i3, @NotNull String name, @NotNull String linkUrl, @NotNull String iconUrl, @NotNull String pv5, @NotNull List<MenuItem> sheetList, @NotNull TabLevel tabLevel) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(sheetList, "sheetList");
        Intrinsics.checkNotNullParameter(tabLevel, "tabLevel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), name, linkUrl, iconUrl, pv5, sheetList, tabLevel);
            return;
        }
        this.tabId = i3;
        this.name = name;
        this.linkUrl = linkUrl;
        this.iconUrl = iconUrl;
        this.pv = pv5;
        this.sheetList = sheetList;
        this.tabLevel = tabLevel;
    }

    public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, int i3, String str, String str2, String str3, String str4, List list, TabLevel tabLevel, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = menuItem.tabId;
        }
        if ((i16 & 2) != 0) {
            str = menuItem.name;
        }
        String str5 = str;
        if ((i16 & 4) != 0) {
            str2 = menuItem.linkUrl;
        }
        String str6 = str2;
        if ((i16 & 8) != 0) {
            str3 = menuItem.iconUrl;
        }
        String str7 = str3;
        if ((i16 & 16) != 0) {
            str4 = menuItem.pv;
        }
        String str8 = str4;
        if ((i16 & 32) != 0) {
            list = menuItem.sheetList;
        }
        List list2 = list;
        if ((i16 & 64) != 0) {
            tabLevel = menuItem.tabLevel;
        }
        return menuItem.copy(i3, str5, str6, str7, str8, list2, tabLevel);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.tabId;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.linkUrl;
    }

    @NotNull
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.iconUrl;
    }

    @NotNull
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.pv;
    }

    @NotNull
    public final List<MenuItem> component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.sheetList;
    }

    @NotNull
    public final TabLevel component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TabLevel) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.tabLevel;
    }

    @NotNull
    public final MenuItem copy(int tabId, @NotNull String name, @NotNull String linkUrl, @NotNull String iconUrl, @NotNull String pv5, @NotNull List<MenuItem> sheetList, @NotNull TabLevel tabLevel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (MenuItem) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(tabId), name, linkUrl, iconUrl, pv5, sheetList, tabLevel);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(pv5, "pv");
        Intrinsics.checkNotNullParameter(sheetList, "sheetList");
        Intrinsics.checkNotNullParameter(tabLevel, "tabLevel");
        return new MenuItem(tabId, name, linkUrl, iconUrl, pv5, sheetList, tabLevel);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuItem)) {
            return false;
        }
        MenuItem menuItem = (MenuItem) other;
        if (this.tabId == menuItem.tabId && Intrinsics.areEqual(this.name, menuItem.name) && Intrinsics.areEqual(this.linkUrl, menuItem.linkUrl) && Intrinsics.areEqual(this.iconUrl, menuItem.iconUrl) && Intrinsics.areEqual(this.pv, menuItem.pv) && Intrinsics.areEqual(this.sheetList, menuItem.sheetList) && this.tabLevel == menuItem.tabLevel) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.iconUrl;
    }

    @NotNull
    public final String getLinkUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.linkUrl;
    }

    @NotNull
    public final String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final String getPv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.pv;
    }

    @NotNull
    public final List<MenuItem> getSheetList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.sheetList;
    }

    public final int getTabId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.tabId;
    }

    @NotNull
    public final TabLevel getTabLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TabLevel) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.tabLevel;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return (((((((((((this.tabId * 31) + this.name.hashCode()) * 31) + this.linkUrl.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.pv.hashCode()) * 31) + this.sheetList.hashCode()) * 31) + this.tabLevel.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "MenuItem(tabId=" + this.tabId + ", name=" + this.name + ", linkUrl=" + this.linkUrl + ", iconUrl=" + this.iconUrl + ", pv=" + this.pv + ", sheetList=" + this.sheetList + ", tabLevel=" + this.tabLevel + ")";
    }

    public /* synthetic */ MenuItem(int i3, String str, String str2, String str3, String str4, List list, TabLevel tabLevel, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, (i16 & 32) != 0 ? new ArrayList() : list, tabLevel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, str4, list, tabLevel, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
