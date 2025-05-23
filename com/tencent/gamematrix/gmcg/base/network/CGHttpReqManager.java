package com.tencent.gamematrix.gmcg.base.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.m;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGHttpReqManager {
    private static final int REQ_MAX_RETRIES = 2;
    private static final int REQ_MAX_TIMEOUT_MS = 20000;
    private static final CGSingletonHelper<CGHttpReqManager> sInstance = new CGSingletonHelper<CGHttpReqManager>() { // from class: com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGHttpReqManager create() {
            return new CGHttpReqManager();
        }
    };
    private RequestQueue mRequestQueue;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BitmapCache implements ImageLoader.d {
        private LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10485760) { // from class: com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager.BitmapCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };

        BitmapCache() {
        }

        @Override // com.android.volley.toolbox.ImageLoader.d
        public Bitmap getBitmap(String str) {
            return this.mCache.get(str);
        }

        @Override // com.android.volley.toolbox.ImageLoader.d
        public void putBitmap(String str, Bitmap bitmap) {
            this.mCache.put(str, bitmap);
        }
    }

    public static CGHttpReqManager get() {
        return sInstance.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$cancelAllReq$0(Request request) {
        return true;
    }

    public void cancelAllReq() {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.c(new RequestQueue.c() { // from class: com.tencent.gamematrix.gmcg.base.network.b
                @Override // com.android.volley.RequestQueue.c
                public final boolean a(Request request) {
                    boolean lambda$cancelAllReq$0;
                    lambda$cancelAllReq$0 = CGHttpReqManager.lambda$cancelAllReq$0(request);
                    return lambda$cancelAllReq$0;
                }
            });
        }
    }

    public void cancelReqByTag(Object obj) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGHttpReqManager cancelReqByTag: ");
        if (obj != null) {
            str = obj.toString();
        } else {
            str = "unknown";
        }
        sb5.append(str);
        CGLog.i(sb5.toString());
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null && obj != null) {
            requestQueue.d(obj);
        }
    }

    public ImageLoader getImageLoader() {
        return new ImageLoader(this.mRequestQueue, new BitmapCache());
    }

    public RequestQueue getRequestQueue() {
        return this.mRequestQueue;
    }

    public void init(@NonNull Context context) {
        this.mRequestQueue = m.a(context.getApplicationContext());
    }

    public <T> void newReq(Request<T> request) {
        request.setRetryPolicy(new CGDefaultRetryPolicy());
        request.setShouldRetryConnectionErrors(true);
        request.setShouldRetryServerErrors(true);
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.a(request);
        }
    }
}
