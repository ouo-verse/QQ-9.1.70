package com.tencent.shadow.core.runtime.remoteview;

import android.content.Context;
import com.tencent.shadow.core.runtime.ShadowContext;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowRemoteViewCreatorFactory {
    public static ShadowRemoteViewCreator createRemoteViewCreator(Context context) {
        return ((ShadowContext) context).getRemoteViewCreatorProvider().createRemoteViewCreator(context);
    }
}
