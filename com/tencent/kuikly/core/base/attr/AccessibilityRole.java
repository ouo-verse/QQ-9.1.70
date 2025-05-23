package com.tencent.kuikly.core.base.attr;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/AccessibilityRole;", "", "roleName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRoleName", "()Ljava/lang/String;", "NONE", "BUTTON", DTConstants.KeyBoardAction.ACTION_SEARCH, "TEXT", "IMAGE", "CHECKBOX", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public enum AccessibilityRole {
    NONE("none"),
    BUTTON("button"),
    SEARCH("search"),
    TEXT("text"),
    IMAGE("image"),
    CHECKBOX(TuxQuestionType.QUESTION_OPTION_CHECKBOX);

    private final String roleName;

    AccessibilityRole(String str) {
        this.roleName = str;
    }

    public final String getRoleName() {
        return this.roleName;
    }
}
