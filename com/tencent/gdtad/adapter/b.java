package com.tencent.gdtad.adapter;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements AdBrowserAdapter {
    @Override // com.tencent.ad.tangram.web.AdBrowserAdapter
    @NonNull
    public AdError show(@Nullable AdBrowser.Params params) {
        Intent a16 = com.tencent.gdtad.util.i.a(params);
        if (a16 == null) {
            GdtLog.e("GdtBrowserAdapter", "show error");
            return new AdError(4);
        }
        try {
            GdtLog.i("GdtBrowserAdapter", "show page:" + params.url);
            com.tencent.gdtad.statistics.b.a(params);
            params.activity.get().startActivity(a16);
            if (params.useVerticalTransitionBetweenActivities) {
                params.activity.get().overridePendingTransition(R.anim.f154424l, R.anim.f154442w);
            }
            return new AdError(0);
        } catch (Throwable th5) {
            GdtLog.e("GdtBrowserAdapter", "show", th5);
            return new AdError(202, th5);
        }
    }

    @Override // com.tencent.ad.tangram.web.AdBrowserAdapter
    @NonNull
    @Deprecated
    public AdError showWithoutAd(@Nullable AdBrowser.Params params) {
        if (params != null && params.isValid()) {
            Intent intent = new Intent(params.activity.get(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", params.url);
            if (params.useVerticalTransitionBetweenActivities) {
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            }
            Bundle bundle = params.extrasForIntent;
            if (bundle != null && !bundle.isEmpty()) {
                intent.putExtras(params.extrasForIntent);
            }
            try {
                params.activity.get().startActivity(intent);
                if (params.useVerticalTransitionBetweenActivities) {
                    params.activity.get().overridePendingTransition(R.anim.f154424l, R.anim.f154442w);
                }
                return new AdError(0);
            } catch (Throwable th5) {
                GdtLog.e("GdtBrowserAdapter", "showWithoutAd", th5);
                return new AdError(202, th5);
            }
        }
        GdtLog.e("GdtBrowserAdapter", "showWithoutAd error");
        return new AdError(4);
    }
}
