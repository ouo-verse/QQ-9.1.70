package com.huawei.hms.support.feature.request;

import android.os.Bundle;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: classes2.dex */
public interface AuthExtendedParams {
    public static final int FITNESS = 1;
    public static final int GAMES = 3;

    Bundle getExtendedBundle();

    int getExtendedParamType();

    List<Scope> getExtendedScopes();
}
