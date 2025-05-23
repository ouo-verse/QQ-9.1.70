package com.tencent.mobileqq.mini.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/model/OpenType;", "", "()V", "ALL_TYPE", "", "", "getALL_TYPE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NAVIGATE_BACK", "NAVIGATE_TO", "REDIRECT_TO", "RE_LAUNCH", "SWITCH_TAB", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class OpenType {
    public static final String NAVIGATE_BACK = "navigateBack";
    public static final String NAVIGATE_TO = "navigateTo";
    public static final String REDIRECT_TO = "redirectTo";
    public static final String RE_LAUNCH = "reLaunch";
    public static final String SWITCH_TAB = "switchTab";
    public static final OpenType INSTANCE = new OpenType();
    private static final String[] ALL_TYPE = {"reLaunch", "navigateTo", "switchTab", "navigateBack", "redirectTo"};

    OpenType() {
    }

    public final String[] getALL_TYPE() {
        return ALL_TYPE;
    }
}
