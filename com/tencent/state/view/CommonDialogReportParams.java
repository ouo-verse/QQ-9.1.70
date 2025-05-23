package com.tencent.state.view;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\n\u00a2\u0006\u0002\u0010\u0012J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006H\u00c6\u0003J9\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u00c6\u0003J\u0083\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000628\b\u0002\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0007H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016RA\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/view/CommonDialogReportParams;", "", "elementId", "", "clickButtonKey", "clickButtonValue", "", "", QQBrowserActivity.APP_PARAM, "onBeforeInit", "Lkotlin/Function2;", "Landroid/app/Dialog;", "Lkotlin/ParameterName;", "name", "dialog", "Landroid/view/View;", "view", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "getClickButtonKey", "()Ljava/lang/String;", "getClickButtonValue", "()Ljava/util/Map;", "getElementId", "getExtraParams", "getOnBeforeInit", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonDialogReportParams {
    private final String clickButtonKey;
    private final Map<Integer, String> clickButtonValue;
    private final String elementId;
    private final Map<String, Object> extraParams;
    private final Function2<Dialog, View, Unit> onBeforeInit;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonDialogReportParams(String elementId, String clickButtonKey, Map<Integer, String> clickButtonValue, Map<String, ? extends Object> extraParams, Function2<? super Dialog, ? super View, Unit> onBeforeInit) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(clickButtonKey, "clickButtonKey");
        Intrinsics.checkNotNullParameter(clickButtonValue, "clickButtonValue");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        Intrinsics.checkNotNullParameter(onBeforeInit, "onBeforeInit");
        this.elementId = elementId;
        this.clickButtonKey = clickButtonKey;
        this.clickButtonValue = clickButtonValue;
        this.extraParams = extraParams;
        this.onBeforeInit = onBeforeInit;
    }

    /* renamed from: component1, reason: from getter */
    public final String getElementId() {
        return this.elementId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClickButtonKey() {
        return this.clickButtonKey;
    }

    public final Map<Integer, String> component3() {
        return this.clickButtonValue;
    }

    public final Map<String, Object> component4() {
        return this.extraParams;
    }

    public final Function2<Dialog, View, Unit> component5() {
        return this.onBeforeInit;
    }

    public final CommonDialogReportParams copy(String elementId, String clickButtonKey, Map<Integer, String> clickButtonValue, Map<String, ? extends Object> extraParams, Function2<? super Dialog, ? super View, Unit> onBeforeInit) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(clickButtonKey, "clickButtonKey");
        Intrinsics.checkNotNullParameter(clickButtonValue, "clickButtonValue");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        Intrinsics.checkNotNullParameter(onBeforeInit, "onBeforeInit");
        return new CommonDialogReportParams(elementId, clickButtonKey, clickButtonValue, extraParams, onBeforeInit);
    }

    public final String getClickButtonKey() {
        return this.clickButtonKey;
    }

    public final Map<Integer, String> getClickButtonValue() {
        return this.clickButtonValue;
    }

    public final String getElementId() {
        return this.elementId;
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final Function2<Dialog, View, Unit> getOnBeforeInit() {
        return this.onBeforeInit;
    }

    public int hashCode() {
        String str = this.elementId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clickButtonKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<Integer, String> map = this.clickButtonValue;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, Object> map2 = this.extraParams;
        int hashCode4 = (hashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Function2<Dialog, View, Unit> function2 = this.onBeforeInit;
        return hashCode4 + (function2 != null ? function2.hashCode() : 0);
    }

    public String toString() {
        return "CommonDialogReportParams(elementId=" + this.elementId + ", clickButtonKey=" + this.clickButtonKey + ", clickButtonValue=" + this.clickButtonValue + ", extraParams=" + this.extraParams + ", onBeforeInit=" + this.onBeforeInit + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonDialogReportParams)) {
            return false;
        }
        CommonDialogReportParams commonDialogReportParams = (CommonDialogReportParams) other;
        return Intrinsics.areEqual(this.elementId, commonDialogReportParams.elementId) && Intrinsics.areEqual(this.clickButtonKey, commonDialogReportParams.clickButtonKey) && Intrinsics.areEqual(this.clickButtonValue, commonDialogReportParams.clickButtonValue) && Intrinsics.areEqual(this.extraParams, commonDialogReportParams.extraParams) && Intrinsics.areEqual(this.onBeforeInit, commonDialogReportParams.onBeforeInit);
    }

    public static /* synthetic */ CommonDialogReportParams copy$default(CommonDialogReportParams commonDialogReportParams, String str, String str2, Map map, Map map2, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = commonDialogReportParams.elementId;
        }
        if ((i3 & 2) != 0) {
            str2 = commonDialogReportParams.clickButtonKey;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            map = commonDialogReportParams.clickButtonValue;
        }
        Map map3 = map;
        if ((i3 & 8) != 0) {
            map2 = commonDialogReportParams.extraParams;
        }
        Map map4 = map2;
        if ((i3 & 16) != 0) {
            function2 = commonDialogReportParams.onBeforeInit;
        }
        return commonDialogReportParams.copy(str, str3, map3, map4, function2);
    }
}
