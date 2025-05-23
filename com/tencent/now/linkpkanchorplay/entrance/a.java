package com.tencent.now.linkpkanchorplay.entrance;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/entrance/a;", "", "", "", "resList", "", "a", "c", "url", "", "b", "", "Ljava/util/List;", "apngResList", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> apngResList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/now/linkpkanchorplay/entrance/a$b", "Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;", "", "url", "Landroid/view/View;", "view", "", "onLoadingStarted", "Lcom/nostra13/universalimageloader/core/assist/FailReason;", "failReason", "onLoadingFailed", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onLoadingComplete", "onLoadingCancelled", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ImageLoadingListener {
        b() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(@Nullable String url, @Nullable View view) {
            LogUtil.e("ApngResLoader", "onLoadingCancelled, url: " + url, new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(@Nullable String url, @Nullable View view, @Nullable Bitmap bitmap) {
            LogUtil.i("ApngResLoader", "onLoadingComplete, url: " + url, new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(@Nullable String url, @Nullable View view, @Nullable FailReason failReason) {
            LogUtil.e("ApngResLoader", "onLoadingFailed, reason: " + failReason + ", url: " + url, new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(@Nullable String url, @Nullable View view) {
            LogUtil.i("ApngResLoader", "onLoadingStarted, url: " + url, new Object[0]);
        }
    }

    public final void a(@NotNull List<String> resList) {
        Intrinsics.checkNotNullParameter(resList, "resList");
        this.apngResList.addAll(resList);
    }

    public final boolean b(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        File file = u0.a.h().getDiskCache().get(url);
        if ((file != null && !TextUtils.isEmpty(file.getAbsolutePath())) || u0.a.h().getMemoryCache().get(url) != null) {
            return true;
        }
        return false;
    }

    public final void c() {
        for (String str : this.apngResList) {
            if (b(str)) {
                LogUtil.i("ApngResLoader", "APNG is ready, url: " + str, new Object[0]);
            } else {
                u0.a.h().loadImage(str, new b());
            }
        }
    }
}
