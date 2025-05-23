package com.tencent.superplayer.seamless.ipc;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.superplayer.seamless.ipc.a;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private static volatile j f373967c;

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    Map<String, k> f373968a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Context f373969b;

    j(Context context) {
        this.f373969b = context;
    }

    private boolean a(@Nullable Bundle bundle) {
        if (bundle == null) {
            LogUtil.w("SPIpcSeamlessHelperServer", "JumpSceneParam empty");
            return false;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        if (!bundle.containsKey("param_player_token")) {
            LogUtil.w("SPIpcSeamlessHelperServer", "JumpSceneParam not contains token");
            return false;
        }
        BinderWrapper binderWrapper = (BinderWrapper) bundle.getParcelable("param_player_binder");
        if (binderWrapper != null && binderWrapper.f373957d != null) {
            return true;
        }
        LogUtil.w("SPIpcSeamlessHelperServer", "JumpSceneParam not contains binder proxy");
        return false;
    }

    public static j c(Context context) {
        if (f373967c == null) {
            synchronized (j.class) {
                if (f373967c == null) {
                    f373967c = new j(context);
                }
            }
        }
        return f373967c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(@Nullable Bundle bundle) {
        if (!a(bundle)) {
            return false;
        }
        this.f373968a.put(bundle.getString("param_player_token"), new k(a.AbstractBinderC9875a.j(((BinderWrapper) bundle.getParcelable("param_player_binder")).f373957d)));
        return true;
    }
}
