package com.tencent.biz.qqcircle.beans;

import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010!\u001a\u00020\u0005J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010#\u001a\u00020\u0005J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QCircleTabNameInfo;", "", "tabType", "", "tabName", "", "selectedSubTabType", "selectedSubTabName", "needShowSelectedSubTabName", "", "(ILjava/lang/String;ILjava/lang/String;Z)V", "getNeedShowSelectedSubTabName", "()Z", "setNeedShowSelectedSubTabName", "(Z)V", "getSelectedSubTabName", "()Ljava/lang/String;", "setSelectedSubTabName", "(Ljava/lang/String;)V", "getSelectedSubTabType", "()I", "setSelectedSubTabType", "(I)V", "getTabName", "getTabType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getShowTabName", "hashCode", "toJson", "toString", "Companion", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QCircleTabNameInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_SUB_TAB_TYPE = "subTabType";

    @NotNull
    private static final String KEY_TAB_TYPE = "tabType";

    @NotNull
    private static final String TAG = "QCircleTabNameInfo";
    private boolean needShowSelectedSubTabName;

    @NotNull
    private String selectedSubTabName;
    private int selectedSubTabType;

    @NotNull
    private final String tabName;
    private final int tabType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QCircleTabNameInfo$Companion;", "", "()V", "KEY_SUB_TAB_TYPE", "", "KEY_TAB_TYPE", "TAG", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/biz/qqcircle/beans/QCircleTabNameInfo;", "tabType", "", "tabName", "selectedSubTabType", "selectedSubTabName", "needShowSelectedSubTabName", "", "fromJson", ark.ARKMETADATA_JSON, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ QCircleTabNameInfo create$default(Companion companion, int i3, String str, int i16, String str2, boolean z16, int i17, Object obj) {
            if ((i17 & 16) != 0) {
                z16 = true;
            }
            return companion.create(i3, str, i16, str2, z16);
        }

        @NotNull
        public final QCircleTabNameInfo create(int tabType, @NotNull String tabName) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            return new QCircleTabNameInfo(tabType, tabName, 0, null, false, 28, null);
        }

        @Nullable
        public final QCircleTabNameInfo fromJson(@Nullable String json) {
            boolean z16;
            if (json != null && json.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(json);
                return new QCircleTabNameInfo(jSONObject.optInt("tabType", -1), "", jSONObject.optInt(QCircleTabNameInfo.KEY_SUB_TAB_TYPE, -1), null, false, 24, null);
            } catch (Exception e16) {
                QLog.w(QCircleTabNameInfo.TAG, 1, "fromJson, error ", e16);
                return null;
            }
        }

        Companion() {
        }

        @NotNull
        public final QCircleTabNameInfo create(int tabType, @NotNull String tabName, int selectedSubTabType, @NotNull String selectedSubTabName, boolean needShowSelectedSubTabName) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            Intrinsics.checkNotNullParameter(selectedSubTabName, "selectedSubTabName");
            return new QCircleTabNameInfo(tabType, tabName, selectedSubTabType, selectedSubTabName, needShowSelectedSubTabName);
        }
    }

    public QCircleTabNameInfo(int i3, @NotNull String tabName, int i16, @NotNull String selectedSubTabName, boolean z16) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(selectedSubTabName, "selectedSubTabName");
        this.tabType = i3;
        this.tabName = tabName;
        this.selectedSubTabType = i16;
        this.selectedSubTabName = selectedSubTabName;
        this.needShowSelectedSubTabName = z16;
    }

    public static /* synthetic */ QCircleTabNameInfo copy$default(QCircleTabNameInfo qCircleTabNameInfo, int i3, String str, int i16, String str2, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = qCircleTabNameInfo.tabType;
        }
        if ((i17 & 2) != 0) {
            str = qCircleTabNameInfo.tabName;
        }
        String str3 = str;
        if ((i17 & 4) != 0) {
            i16 = qCircleTabNameInfo.selectedSubTabType;
        }
        int i18 = i16;
        if ((i17 & 8) != 0) {
            str2 = qCircleTabNameInfo.selectedSubTabName;
        }
        String str4 = str2;
        if ((i17 & 16) != 0) {
            z16 = qCircleTabNameInfo.needShowSelectedSubTabName;
        }
        return qCircleTabNameInfo.copy(i3, str3, i18, str4, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTabType() {
        return this.tabType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSelectedSubTabType() {
        return this.selectedSubTabType;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSelectedSubTabName() {
        return this.selectedSubTabName;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getNeedShowSelectedSubTabName() {
        return this.needShowSelectedSubTabName;
    }

    @NotNull
    public final QCircleTabNameInfo copy(int tabType, @NotNull String tabName, int selectedSubTabType, @NotNull String selectedSubTabName, boolean needShowSelectedSubTabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(selectedSubTabName, "selectedSubTabName");
        return new QCircleTabNameInfo(tabType, tabName, selectedSubTabType, selectedSubTabName, needShowSelectedSubTabName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleTabNameInfo)) {
            return false;
        }
        QCircleTabNameInfo qCircleTabNameInfo = (QCircleTabNameInfo) other;
        if (this.tabType == qCircleTabNameInfo.tabType && Intrinsics.areEqual(this.tabName, qCircleTabNameInfo.tabName) && this.selectedSubTabType == qCircleTabNameInfo.selectedSubTabType && Intrinsics.areEqual(this.selectedSubTabName, qCircleTabNameInfo.selectedSubTabName) && this.needShowSelectedSubTabName == qCircleTabNameInfo.needShowSelectedSubTabName) {
            return true;
        }
        return false;
    }

    public final boolean getNeedShowSelectedSubTabName() {
        return this.needShowSelectedSubTabName;
    }

    @NotNull
    public final String getSelectedSubTabName() {
        return this.selectedSubTabName;
    }

    public final int getSelectedSubTabType() {
        return this.selectedSubTabType;
    }

    @NotNull
    public final String getShowTabName() {
        boolean z16;
        if (this.needShowSelectedSubTabName) {
            if (this.selectedSubTabName.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return this.selectedSubTabName;
            }
        }
        return this.tabName;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    public final int getTabType() {
        return this.tabType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.tabType * 31) + this.tabName.hashCode()) * 31) + this.selectedSubTabType) * 31) + this.selectedSubTabName.hashCode()) * 31;
        boolean z16 = this.needShowSelectedSubTabName;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final void setNeedShowSelectedSubTabName(boolean z16) {
        this.needShowSelectedSubTabName = z16;
    }

    public final void setSelectedSubTabName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedSubTabName = str;
    }

    public final void setSelectedSubTabType(int i3) {
        this.selectedSubTabType = i3;
    }

    @NotNull
    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tabType", this.tabType);
        jSONObject.put(KEY_SUB_TAB_TYPE, this.selectedSubTabType);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
        return jSONObject2;
    }

    @NotNull
    public String toString() {
        return "QCircleTabNameInfo(tabType=" + this.tabType + ", tabName=" + this.tabName + ", selectedSubTabType=" + this.selectedSubTabType + ", selectedSubTabName=" + this.selectedSubTabName + ", needShowSelectedSubTabName=" + this.needShowSelectedSubTabName + ")";
    }

    public /* synthetic */ QCircleTabNameInfo(int i3, String str, int i16, String str2, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i17 & 4) != 0 ? -1 : i16, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? false : z16);
    }
}
