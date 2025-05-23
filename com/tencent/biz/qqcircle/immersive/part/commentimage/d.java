package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StUser;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/d;", "Lcom/tencent/biz/qcircleshadow/lib/listener/QCircleFaceBitmapListener;", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/request/Option;", "option", "Landroid/graphics/drawable/Drawable;", "b", "drawable", "", "e", "c", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getFaceBitmap", "Lcom/tencent/libra/LoadState;", "state", "onStateChange", "", "Ljava/lang/String;", "savedId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStopped", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/z;", "f", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "viewHolderRef", "viewHolder", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/part/commentimage/z;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends QCirclePicStateListener implements QCircleFaceBitmapListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String savedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isStopped;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.refresh.c<z> viewHolderRef;

    public d(@NotNull z viewHolder, @NotNull String savedId) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(savedId, "savedId");
        this.savedId = savedId;
        this.isStopped = new AtomicBoolean(false);
        this.viewHolderRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(viewHolder);
    }

    private final Drawable b(Option option) {
        Object animatable;
        Bitmap resultBitMap;
        int a16 = cx.a(20.0f);
        if (option != null && (resultBitMap = option.getResultBitMap()) != null) {
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(RFWApplication.getApplication().getResources(), resultBitMap);
            Intrinsics.checkNotNullExpressionValue(create, "create(RFWApplication.ge\u2026tion().resources, bitmap)");
            create.setBounds(0, 0, a16, a16);
            create.setCircular(true);
            return create;
        }
        if (option != null && (animatable = option.getAnimatable()) != null && (animatable instanceof Drawable)) {
            RoundedDrawable fromDrawable = RoundedDrawable.fromDrawable((Drawable) animatable);
            fromDrawable.setBounds(0, 0, a16, a16);
            fromDrawable.setOval(true);
            return fromDrawable;
        }
        return null;
    }

    private final void e(final Drawable drawable) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(d.this, drawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        if (this$0.isStopped.get()) {
            QLog.d("QFSCommentImageAvatarLoader", 1, "[updateAvatar] loader stopped");
            return;
        }
        z zVar = this$0.viewHolderRef.get();
        Object obj = null;
        if (zVar != null) {
            QFSCommentImageInfo imageInfo = zVar.getImageInfo();
            if (imageInfo != null) {
                obj = imageInfo.l();
            }
            if (Intrinsics.areEqual(obj, this$0.savedId)) {
                zVar.d0(drawable);
            }
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            QLog.w("QFSCommentImageAvatarLoader", 1, "[updateAvatar] no same id");
        }
    }

    public final void c() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        boolean isBlank;
        boolean isBlank2;
        QFSCommentImageInfo imageInfo;
        FeedCloudMeta$StUser q16;
        z zVar = this.viewHolderRef.get();
        if (zVar != null && (imageInfo = zVar.getImageInfo()) != null && (q16 = imageInfo.q()) != null) {
            feedCloudMeta$StUser = q16.get();
        } else {
            feedCloudMeta$StUser = null;
        }
        if (feedCloudMeta$StUser == null) {
            QLog.w("QFSCommentImageAvatarLoader", 1, "[loadImage] invalid poster");
            return;
        }
        String iconUrl = feedCloudMeta$StUser.icon.iconUrl.get();
        QLog.d("QFSCommentImageAvatarLoader", 1, "[load] iconUrl=" + iconUrl);
        Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(iconUrl);
        if (!isBlank) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101721", true);
            Option obtain = Option.obtain();
            String str = feedCloudMeta$StUser.f398463id.get();
            Intrinsics.checkNotNullExpressionValue(str, "poster.id.get()");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if ((true ^ isBlank2) && isSwitchOn) {
                LibraGroupKey libraGroupKey = new LibraGroupKey(feedCloudMeta$StUser.f398463id.get());
                libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
                obtain.setGroupKey(libraGroupKey);
            }
            int a16 = cx.a(20.0f);
            obtain.setUrl(iconUrl);
            obtain.setRequestWidth(a16);
            obtain.setRequestHeight(a16);
            obtain.setFailedDrawableId(R.drawable.f160830com);
            obtain.setLoadingDrawableId(R.drawable.f160830com);
            QCircleFeedPicLoader.g().loadImage(obtain, this);
            return;
        }
        Drawable s16 = QCirclePluginGlobalInfo.s(feedCloudMeta$StUser.f398463id.get(), this);
        if (s16 != null) {
            e(s16);
        }
    }

    public final void d() {
        this.isStopped.set(true);
    }

    @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener
    public void getFaceBitmap(@Nullable Bitmap bitmap) {
        QLog.d("QFSCommentImageAvatarLoader", 1, "[getFaceBitmap]");
        if (this.isStopped.get()) {
            QLog.d("QFSCommentImageAvatarLoader", 1, "[getFaceBitmap] loader stopped");
        } else if (bitmap != null) {
            e(new BitmapDrawable(RFWApplication.getApplication().getResources(), bitmap));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
    public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
        Drawable b16;
        LibraGroupKey libraGroupKey;
        if (QLog.isColorLevel()) {
            if (option != null) {
                libraGroupKey = option.getGroupKey();
            } else {
                libraGroupKey = null;
            }
            QLog.d("QFSCommentImageAvatarLoader", 1, "[onStateChange] state=" + state + ", key=" + libraGroupKey);
        }
        if (this.isStopped.get()) {
            QLog.d("QFSCommentImageAvatarLoader", 1, "[onStateChange] loader stopped");
        } else if (state == LoadState.STATE_SUCCESS && (b16 = b(option)) != null) {
            e(b16);
        }
    }
}
