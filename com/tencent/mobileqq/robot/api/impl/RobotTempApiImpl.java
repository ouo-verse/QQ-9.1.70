package com.tencent.mobileqq.robot.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.robot.api.IRobotTempApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/robot/api/impl/RobotTempApiImpl;", "Lcom/tencent/mobileqq/robot/api/IRobotTempApi;", "()V", "hasSetCustomChatBackground", "", "context", "Landroid/content/Context;", "myUin", "", "friendUin", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class RobotTempApiImpl implements IRobotTempApi {
    @Override // com.tencent.mobileqq.robot.api.IRobotTempApi
    public boolean hasSetCustomChatBackground(Context context, String myUin, String friendUin) {
        String e16 = t.e(context, myUin, friendUin);
        return (e16 == null || Intrinsics.areEqual(e16, "null")) ? false : true;
    }
}
