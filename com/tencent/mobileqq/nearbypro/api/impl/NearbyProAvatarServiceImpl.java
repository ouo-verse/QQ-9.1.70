package com.tencent.mobileqq.nearbypro.api.impl;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import ba2.e;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.nearbypro.api.INearbyProAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011Rh\u0010\u0018\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u00160\u0012j*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/NearbyProAvatarServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProAvatarService;", "", "tid", "", PhotoCategorySummaryInfo.AVATAR_URL, "", "loadImageUrl", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "avatarView", "loadAvatarForTinyId", "Lba2/e;", "nearbyProAvatarProcessor", "Lba2/e;", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "pendingImageViews", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProAvatarServiceImpl implements INearbyProAvatarService {

    @NotNull
    private static final String TAG = "NearbyProAvatarServiceImpl";

    @NotNull
    private final e nearbyProAvatarProcessor = new e();

    @NotNull
    private final HashMap<Long, ArrayList<WeakReference<ImageView>>> pendingImageViews = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadImageUrl(final long tid, final String avatarUrl) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                NearbyProAvatarServiceImpl.loadImageUrl$lambda$1(NearbyProAvatarServiceImpl.this, tid, avatarUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void loadImageUrl$lambda$1(NearbyProAvatarServiceImpl this$0, long j3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<WeakReference<ImageView>> arrayList = this$0.pendingImageViews.get(Long.valueOf(j3));
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class)).loadCommonPic(str, (ImageView) ((WeakReference) it.next()).get(), true, (Drawable) null);
            }
        }
        ArrayList<WeakReference<ImageView>> arrayList2 = this$0.pendingImageViews.get(Long.valueOf(j3));
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProAvatarService
    public void loadAvatarForTinyId(@NotNull View avatarView, long tid) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        if (!this.pendingImageViews.containsKey(Long.valueOf(tid))) {
            this.pendingImageViews.put(Long.valueOf(tid), new ArrayList<>());
        }
        ArrayList<WeakReference<ImageView>> arrayList = this.pendingImageViews.get(Long.valueOf(tid));
        if (arrayList != null) {
            arrayList.add(new WeakReference<>((ImageView) avatarView));
        }
        this.nearbyProAvatarProcessor.d(avatarView, tid, true, new Function2<Long, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.api.impl.NearbyProAvatarServiceImpl$loadAvatarForTinyId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, String str) {
                invoke(l3.longValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, @Nullable String str) {
                NearbyProAvatarServiceImpl.this.loadImageUrl(j3, str);
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
