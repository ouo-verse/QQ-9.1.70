package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.util.o;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkLaucherImpl implements IQQWinkLaucher {
    public static final String TAG = "QQWinkLaucherImpl";

    private void ensureWinkContext(Intent intent) {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext a16 = companion.a(intent);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, a16.getTraceId());
        companion.o(a16);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public void jumpToWinkAIAvatarMainFragment(Context context, Intent intent) {
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
        ensureWinkContext(intent);
        com.tencent.mobileqq.wink.f.q(context, intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public void jumpToWinkEditor(@NonNull Context context, @NonNull Bundle bundle) {
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.f.v(context, bundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public void jumpToWinkEditorWithCompressMedia(@NonNull Context context, @NonNull Bundle bundle, com.tencent.mobileqq.wink.api.b bVar) {
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.f.x(context, bundle, bVar);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public void jumpToWinkPreview(Context context, Bundle bundle) {
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.f.B(context, bundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public void jumpToWinkTemplateFeed(Context context, Intent intent) {
        ensureWinkContext(intent);
        com.tencent.mobileqq.wink.f.p(context, intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLaucher
    public boolean preloadWebView(String str, boolean z16) {
        return o.a(str, z16);
    }

    private void ensureWinkContext(Bundle bundle) {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext b16 = companion.b(bundle);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, b16.getTraceId());
        companion.o(b16);
    }
}
