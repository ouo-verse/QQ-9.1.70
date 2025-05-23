package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.util.Pair;
import com.tencent.hippy.qq.module.QQUiModule;
import com.tencent.mobileqq.vas.api.IQQOpenView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/QQOpenViewImpl;", "Lcom/tencent/mobileqq/vas/api/IQQOpenView;", "()V", "openView", "Landroid/util/Pair;", "", "argsJson", "Lorg/json/JSONObject;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "troopMemberInvoke", "Lkotlin/Function0;", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QQOpenViewImpl implements IQQOpenView {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void openView$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IQQOpenView
    @NotNull
    public Pair<Boolean, Boolean> openView(@NotNull JSONObject argsJson, @NotNull Activity activity, @Nullable final Function0<Unit> troopMemberInvoke) {
        Intrinsics.checkNotNullParameter(argsJson, "argsJson");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Pair<Boolean, Boolean> innerOpenView = QQUiModule.innerOpenView(argsJson, activity, null, new QQUiModule.TroopMemberBindServiceCallback() { // from class: com.tencent.mobileqq.vas.api.impl.q
            @Override // com.tencent.hippy.qq.module.QQUiModule.TroopMemberBindServiceCallback
            public final void toBind() {
                QQOpenViewImpl.openView$lambda$0(Function0.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(innerOpenView, "innerOpenView(argsJson, \u2026nvoke?.invoke()\n        }");
        return innerOpenView;
    }
}
