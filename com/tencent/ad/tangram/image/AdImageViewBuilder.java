package com.tencent.ad.tangram.image;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdImageViewBuilder {
    private static volatile AdImageViewBuilder sInstance;
    private WeakReference<AdImageViewAdapter> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Listener {
        void onStopLoad(boolean z16);
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        @Deprecated
        public WeakReference<AdImageViewAdapter.Callback> callback;
        public WeakReference<Context> context;

        @Deprecated
        public String gaussianUrl;

        @Deprecated
        public boolean isHitImageExp;

        @Deprecated
        public boolean isOnlyLoadGaussianUrl;

        @Deprecated
        public WeakReference<Listener> listener;
        public String url;

        public boolean isValid() {
            WeakReference<AdImageViewAdapter.Callback> weakReference;
            WeakReference<Context> weakReference2 = this.context;
            if (weakReference2 != null && weakReference2.get() != null && !TextUtils.isEmpty(this.url) && (weakReference = this.callback) != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }
    }

    AdImageViewBuilder() {
    }

    @Nullable
    private AdImageViewAdapter getAdapter() {
        WeakReference<AdImageViewAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdImageViewBuilder getInstance() {
        if (sInstance == null) {
            synchronized (AdImageViewBuilder.class) {
                if (sInstance == null) {
                    sInstance = new AdImageViewBuilder();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public View buildImageView(Params params) {
        AdImageViewAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.buildImageView(params);
        }
        return null;
    }

    public void setAdapter(WeakReference<AdImageViewAdapter> weakReference) {
        this.adapter = weakReference;
    }

    @Deprecated
    public void buildImageView(Params params, View view) {
        AdImageViewAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.buildImageView(params, view);
        }
    }
}
