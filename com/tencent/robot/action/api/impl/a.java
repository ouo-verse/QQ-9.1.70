package com.tencent.robot.action.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n14.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/action/api/impl/a;", "Ln14/d;", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "", "a", "", "getType", "()I", "type", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements d {
    @Override // n14.d
    public boolean a(@NotNull Uri scheme) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String path = scheme.getPath();
        if (path != null && path.equals("/inlinecmd")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String scheme2 = scheme.getScheme();
            if (scheme2 != null && scheme2.equals(SchemaUtils.SCHEMA_MQQAPI)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String host = scheme.getHost();
                if (host != null && host.equals("aio")) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && scheme.getBooleanQueryParameter(BaseConstants.BROADCAST_USERSYNC_ENTER, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // n14.d
    public int getType() {
        return 2;
    }
}
