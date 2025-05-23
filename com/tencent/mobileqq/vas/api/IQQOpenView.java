package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IQQOpenView;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "openView", "Landroid/util/Pair;", "", "argsJson", "Lorg/json/JSONObject;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "troopMemberInvoke", "Lkotlin/Function0;", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQOpenView extends QRouteApi {
    @NotNull
    Pair<Boolean, Boolean> openView(@NotNull JSONObject argsJson, @NotNull Activity activity, @Nullable Function0<Unit> troopMemberInvoke);
}
