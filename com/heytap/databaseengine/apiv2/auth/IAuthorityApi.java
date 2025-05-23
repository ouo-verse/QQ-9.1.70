package com.heytap.databaseengine.apiv2.auth;

import android.app.Activity;
import com.heytap.databaseengine.apiv2.HResponse;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IAuthorityApi {
    void request(Activity activity, HResponse<AuthResult> hResponse);

    void request(Activity activity, String str, HResponse<AuthResult> hResponse);

    void revoke(HResponse<List<Object>> hResponse);

    void valid(HResponse<List<String>> hResponse);
}
