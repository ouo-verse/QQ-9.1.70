package dk1;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.preload.activity.BaseActivityPreloadTask;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import com.tencent.richframework.preload.activity.PredictLayoutLoadStrategy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "use Argus-Preload instead")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0010\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010(\u001a\u00020#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Ldk1/a;", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "doAfterActivityCreate", "Ljava/lang/ClassLoader;", "classLoader", "", "activityClassName", "Landroid/content/Intent;", "intent", "", "isTarget", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/activity/QPublicTransFragmentActivity;", "a", "Ljava/lang/Class;", "getActivityClass", "()Ljava/lang/Class;", "activityClass", "Ljava/util/HashMap;", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "preloadRes", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "c", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "getExecuteMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "executeMode", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "d", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "getPreloadMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "preloadMode", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getTargetPreLoader", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "targetPreLoader", "<init>", "()V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends BaseActivityResPreloadTask {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<QPublicTransFragmentActivity> activityClass = QPublicTransFragmentActivity.class;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<PreloadRequest, Integer> preloadRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseActivityPreloadTask.ExecuteMode executeMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseActivityPreloadTask.PreloadMode preloadMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Ldk1/a$a;", "", "", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dk1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (Map.Entry<PreloadRequest, Integer> entry : b().entrySet()) {
                PreloadRequest key = entry.getKey();
                int fillPreloadView = c().fillPreloadView(activity, key, entry.getValue().intValue());
                if (fillPreloadView > 0) {
                    QLog.i("GuildFeedGalleryPreloadTask", 1, "checkAndFillCommentPanelPreloadView resId:" + key.getResId() + " needPreloadCount:" + fillPreloadView);
                }
            }
        }

        @NotNull
        public final Map<PreloadRequest, Integer> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(new PreloadRequest(R.layout.f168073eo0, "", null, 4, null), 1);
            hashMap.put(new PreloadRequest(R.layout.eny, "", null, 4, null), 1);
            return hashMap;
        }

        @NotNull
        public final RFWLayoutPreLoader c() {
            return RFWLayoutPreLoaderFactory.getLayoutLoader(new PredictLayoutLoadStrategy());
        }

        Companion() {
        }
    }

    public a() {
        HashMap<PreloadRequest, Integer> hashMap = new HashMap<>();
        hashMap.put(new PreloadRequest(R.layout.f0x, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.eo6, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.eo7, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.eo9, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.eo8, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.f168077eo4, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.eps, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.enw, "", null, 4, null), 1);
        hashMap.put(new PreloadRequest(R.layout.en6, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.en5, "", null, 4, null), 2);
        hashMap.put(new PreloadRequest(R.layout.f168071en3, "", null, 4, null), 6);
        hashMap.put(new PreloadRequest(R.layout.enk, "", null, 4, null), 6);
        hashMap.put(new PreloadRequest(R.layout.eni, "", null, 4, null), 6);
        hashMap.put(new PreloadRequest(R.layout.enj, "", null, 4, null), 6);
        hashMap.put(new PreloadRequest(R.layout.f168072en4, "", null, 4, null), 6);
        hashMap.putAll(INSTANCE.b());
        this.preloadRes = hashMap;
        this.executeMode = BaseActivityPreloadTask.ExecuteMode.IDLE;
        this.preloadMode = BaseActivityPreloadTask.PreloadMode.RECYCLE;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<PreloadRequest, Integer> getPreloadRes() {
        return this.preloadRes;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask, com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public void doAfterActivityCreate(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            qBaseActivity.isEnableDelegateLayoutInflater = true;
            qBaseActivity.isCloneInflaterInSubThread = true;
        }
        super.doAfterActivityCreate(activity);
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public Class<QPublicTransFragmentActivity> getActivityClass() {
        return this.activityClass;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public BaseActivityPreloadTask.ExecuteMode getExecuteMode() {
        return this.executeMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @NotNull
    public BaseActivityPreloadTask.PreloadMode getPreloadMode() {
        return this.preloadMode;
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityResPreloadTask
    @NotNull
    public RFWLayoutPreLoader getTargetPreLoader() {
        return INSTANCE.c();
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public boolean isTarget(@NotNull ClassLoader classLoader, @NotNull String activityClassName, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(activityClassName, "activityClassName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setExtrasClassLoader(GuildFeedGalleryFragment.class.getClassLoader());
        String stringExtra = intent.getStringExtra("public_fragment_class");
        if (super.isTarget(classLoader, activityClassName, intent) && Intrinsics.areEqual(stringExtra, Reflection.getOrCreateKotlinClass(GuildFeedGalleryFragment.class).getQualifiedName())) {
            return true;
        }
        return false;
    }
}
