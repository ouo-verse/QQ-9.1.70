package com.tencent.mobileqq.vas.lovechat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.m;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0002\u0019\u001aB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/LoveChatBgDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "", HippyTKDListViewAdapter.X, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/m;", "callback", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "K", "I", "itemId", "L", "Z", "fastLoad", "Lcom/tencent/mobileqq/vas/lovechat/LoveChatBgDrawable$a;", "M", "Lcom/tencent/mobileqq/vas/lovechat/LoveChatBgDrawable$a;", "data", "<init>", "(I)V", "N", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class LoveChatBgDrawable extends AbsAsyncDrawable {
    private static final com.tencent.mobileqq.vas.lovechat.a P = (com.tencent.mobileqq.vas.lovechat.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.lovechat.a.class);

    @NotNull
    private static final SparseArray<a> Q = new SparseArray<>();

    /* renamed from: K, reason: from kotlin metadata */
    private final int itemId;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean fastLoad;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private a data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/LoveChatBgDrawable$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "path", "", "b", "Z", "()Z", "isLongBg", "<init>", "(Ljava/lang/String;Z)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isLongBg;

        public a(@NotNull String path, boolean z16) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
            this.isLongBg = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsLongBg() {
            return this.isLongBg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/lovechat/LoveChatBgDrawable$c", "Lcom/tencent/vas/update/callback/listener/IUpdateListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "onProgress", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements IUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f309995b;

        c(m mVar) {
            this.f309995b = mVar;
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (LoveChatBgDrawable.this.x()) {
                this.f309995b.onLoadSucceed();
            }
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onProgress(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }
    }

    public LoveChatBgDrawable(int i3) {
        a aVar;
        this.itemId = i3;
        this.data = new a("", false);
        M(new Function0<FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.lovechat.LoveChatBgDrawable.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FastDynamicDrawable invoke() {
                return com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(LoveChatBgDrawable.this.data.getPath()).i("RECENT").a();
            }
        });
        SparseArray<a> sparseArray = Q;
        synchronized (sparseArray) {
            aVar = sparseArray.get(i3, null);
        }
        if (aVar != null) {
            this.data = aVar;
            this.fastLoad = true;
            y(false);
            return;
        }
        y(true);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float intrinsicWidth = getIntrinsicWidth() * (canvas.getHeight() / getIntrinsicHeight());
        float width = canvas.getWidth() - intrinsicWidth;
        if (this.data.getIsLongBg() && width < 0.0f) {
            Drawable o16 = o();
            if (o16 != null) {
                o16.setBounds(new Rect(0, 0, (int) intrinsicWidth, canvas.getHeight()));
                canvas.save();
                canvas.translate(width, 0.0f);
                o16.draw(canvas);
                canvas.restore();
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public void n(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.vas.lovechat.a aVar = P;
        aVar.addUpdateListener(new c(callback));
        aVar.startDownload(this.itemId);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public boolean x() {
        if (this.fastLoad) {
            return true;
        }
        com.tencent.mobileqq.vas.lovechat.a aVar = P;
        if (aVar.isFileExists(this.itemId)) {
            String str = aVar.e(this.itemId).toString();
            this.data = new a(str, aVar.h(str));
            SparseArray<a> sparseArray = Q;
            synchronized (sparseArray) {
                sparseArray.put(this.itemId, this.data);
                Unit unit = Unit.INSTANCE;
            }
            this.fastLoad = true;
            return true;
        }
        return false;
    }
}
