package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandQuestionUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandQuestionUtils;", "", "uin", "", "needAnswerQuestion", "flag", "", "setAnswerQuestionFlag", "<init>", "()V", "Companion", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandQuestionUtilsImpl implements IExpandQuestionUtils {
    public static final String TAG = "ExpandQuestionUtilsImpl";

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils
    public boolean needAnswerQuestion(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils
    public void setAnswerQuestionFlag(String uin, boolean flag) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }
}
