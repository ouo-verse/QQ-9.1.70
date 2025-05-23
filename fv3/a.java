package fv3;

import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import com.tencent.richframework.preload.activity.BaseActivityPreloadTask;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lfv3/a;", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/QQGalleryActivity;", "a", "Ljava/lang/Class;", "getActivityClass", "()Ljava/lang/Class;", "activityClass", "Ljava/util/HashMap;", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "preloadRes", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "c", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "getExecuteMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "executeMode", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "d", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "getPreloadMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "preloadMode", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "e", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getTargetPreLoader", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "targetPreLoader", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends BaseActivityResPreloadTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<QQGalleryActivity> activityClass = QQGalleryActivity.class;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashMap<PreloadRequest, Integer> preloadRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final BaseActivityPreloadTask.ExecuteMode executeMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final BaseActivityPreloadTask.PreloadMode preloadMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RFWLayoutPreLoader targetPreLoader;

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<PreloadRequest, Integer> getPreloadRes() {
        return this.preloadRes;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public Class<QQGalleryActivity> getActivityClass() {
        return this.activityClass;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public BaseActivityPreloadTask.ExecuteMode getExecuteMode() {
        return this.executeMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public BaseActivityPreloadTask.PreloadMode getPreloadMode() {
        return this.preloadMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    public RFWLayoutPreLoader getTargetPreLoader() {
        return this.targetPreLoader;
    }

    public a() {
        HashMap<PreloadRequest, Integer> hashMap = new HashMap<>();
        hashMap.put(new PreloadRequest(R.layout.f169063hn0, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.hn5, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.f169067hn4, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.hna, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.hn8, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.hn9, "", null, 4, null), 3);
        hashMap.put(new PreloadRequest(R.layout.f168348fq0, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.i3h, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.f168349fq1, "", null, 4, null), 3);
        this.preloadRes = hashMap;
        this.executeMode = BaseActivityPreloadTask.ExecuteMode.AT_ONCE;
        this.preloadMode = BaseActivityPreloadTask.PreloadMode.RECYCLE;
        this.targetPreLoader = ArgusPreloadManager.INSTANCE.getLayoutPreLoader();
    }
}
