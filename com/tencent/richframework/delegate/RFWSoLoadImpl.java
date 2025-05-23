package com.tencent.richframework.delegate;

import androidx.collection.ArrayMap;
import com.tencent.biz.richframework.delegate.ISoLoadDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.richframework.delegate.RFWSoLoadImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/delegate/RFWSoLoadImpl;", "Lcom/tencent/biz/richframework/delegate/ISoLoadDelegate;", "()V", "load", "", "name", "", "onLoadListener", "Lcom/tencent/biz/richframework/delegate/ISoLoadDelegate$OnLoadListener;", "Companion", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RFWSoLoadImpl implements ISoLoadDelegate {

    @NotNull
    private static final Map<String, String> sSoNameMap;

    static {
        ArrayMap arrayMap = new ArrayMap();
        sSoNameMap = arrayMap;
        arrayMap.put("avif", "tencent-avif-v2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void load$lambda$1(String name, ISoLoadDelegate.OnLoadListener onLoadListener, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(name, "$name");
        boolean z16 = false;
        RFWLog.d("RFWSoLoadImpl", RFWLog.USR, "load so:", name, ",result:", Integer.valueOf(i3));
        if (onLoadListener != null) {
            if (i3 == 0) {
                z16 = true;
            }
            onLoadListener.onLoadResult(z16);
        }
    }

    @Override // com.tencent.biz.richframework.delegate.ISoLoadDelegate
    public void load(@NotNull final String name, @Nullable final ISoLoadDelegate.OnLoadListener onLoadListener) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = sSoNameMap.get(name);
        if (str == null) {
            str = name;
        }
        SoLoadManager.getInstance().load(str, new OnLoadListener() { // from class: xz3.a
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                RFWSoLoadImpl.load$lambda$1(name, onLoadListener, i3, loadExtResult);
            }
        });
    }
}
