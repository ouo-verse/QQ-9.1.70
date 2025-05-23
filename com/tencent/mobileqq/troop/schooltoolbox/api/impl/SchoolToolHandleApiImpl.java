package com.tencent.mobileqq.troop.schooltoolbox.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolHandleApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/api/impl/SchoolToolHandleApiImpl;", "Lcom/tencent/mobileqq/troop/schooltoolbox/api/ISchoolToolHandleApi;", "()V", "handlerAppAction", "", "context", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "troopUin", "", "appId", "", "appUrl", "from", "", "redPoint", "isGuildApp", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SchoolToolHandleApiImpl implements ISchoolToolHandleApi {
    @Override // com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolHandleApi
    public void handlerAppAction(Context context, Activity activity, String troopUin, long appId, String appUrl, int from, int redPoint, boolean isGuildApp) {
        r.f(TroopUtils.f(), context, activity, troopUin, appId, appUrl, from, redPoint, isGuildApp, true);
    }
}
