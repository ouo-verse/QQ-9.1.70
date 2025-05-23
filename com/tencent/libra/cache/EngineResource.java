package com.tencent.libra.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class EngineResource<Z> implements Resource<Z> {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("EngineResource");
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private Map<String, Object> mExtraData;
    private final Resource<Z> resource;

    /* renamed from: z, reason: collision with root package name */
    private Z f118632z;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    @SuppressLint({"RestrictedApi"})
    public EngineResource(Resource<Z> resource, boolean z16, boolean z17, Key key, ResourceListener resourceListener) {
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isMemoryCacheable = z16;
        this.isRecyclable = z17;
        this.key = key;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    public static <Z> EngineResource<Z> obtain(@NonNull EngineResource<Z> engineResource, Resource<Z> resource) {
        EngineResource<Z> engineResource2 = new EngineResource<>(resource, ((EngineResource) engineResource).isMemoryCacheable, ((EngineResource) engineResource).isRecyclable, ((EngineResource) engineResource).key, ((EngineResource) engineResource).listener);
        ((EngineResource) engineResource2).acquired = ((EngineResource) engineResource).acquired;
        ((EngineResource) engineResource2).isRecycled = ((EngineResource) engineResource).isRecycled;
        return engineResource2;
    }

    public synchronized void acquire() {
        if (!this.isRecycled) {
            this.acquired++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Z get() {
        return this.resource.get();
    }

    @NonNull
    public synchronized Map<String, Object> getExtraData() {
        if (this.mExtraData == null) {
            this.mExtraData = new ConcurrentHashMap();
        }
        return this.mExtraData;
    }

    public int getReferenceCount() {
        return this.acquired;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource<Z> getResource() {
        return this.resource;
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.tencent.libra.cache.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    @Override // com.tencent.libra.cache.Resource
    public synchronized void recycle() {
        if (this.acquired <= 0) {
            if (!this.isRecycled) {
                this.isRecycled = true;
                if (this.isRecyclable) {
                    this.resource.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public void release() {
        boolean z16;
        synchronized (this) {
            if (this.acquired <= 0) {
                RFWLog.fatal(TAG, RFWLog.USR, new IllegalStateException("Cannot release a recycled or not yet acquired resource"));
            }
            z16 = true;
            int i3 = this.acquired - 1;
            this.acquired = i3;
            if (i3 != 0) {
                z16 = false;
            }
        }
        if (z16) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
