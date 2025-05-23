package com.tencent.mobileqq.matchfriend.reborn.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.a;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ac;
import com.tencent.mobileqq.aio.title.ae;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkForegroundDelegate;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerMutualMarkApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerForegroundApiImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerForegroundApi;", "Lcom/tencent/mobileqq/aio/title/ae;", "createFakeMutualMarkData", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "model", "showGainMutualMarkAnimatorView", "Landroid/graphics/Point;", "getAIOTitleMutualMarkLocation", "", "loadingDrawablePath", "updateAIOTitleMutualMark", "aioContext", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkForegroundDelegate;", "foregroundDelegate", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkForegroundDelegate;", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerForegroundApiImpl implements IQQStrangerForegroundApi {
    private static final String TAG = "QQStrangerForegroundApiImpl";
    private a aioContext;
    private final StrangerGainMutualMarkForegroundDelegate foregroundDelegate = new StrangerGainMutualMarkForegroundDelegate();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J*\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerForegroundApiImpl$b", "Lcom/tencent/mobileqq/aio/title/ac;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "defaultIconDrawable", "Lkotlin/Pair;", "", "b", "", "d", "", "c", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "iconUrl", "iconDrawable", "", "f", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements ac {
        b() {
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void a() {
            ac.a.a(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public Pair<String, Drawable> b(Context context, Drawable defaultIconDrawable) {
            Intrinsics.checkNotNullParameter(defaultIconDrawable, "defaultIconDrawable");
            return new Pair<>(null, defaultIconDrawable);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public boolean c() {
            return true;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public float d() {
            return 1.0f;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void e() {
            ac.a.b(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void f(Resources resources, ImageView view, String iconUrl, Drawable iconDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
        }
    }

    private final ae createFakeMutualMarkData() {
        return new ae("", 1, "", new b());
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi
    public Point getAIOTitleMutualMarkLocation() {
        a aVar = this.aioContext;
        if (aVar == null) {
            return null;
        }
        k k3 = aVar.e().k(new AIOTitleEvent.GetMutualMarkLocationEvent(createFakeMutualMarkData()));
        m.b bVar = k3 instanceof m.b ? (m.b) k3 : null;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi
    public void onCreate(a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        this.foregroundDelegate.h(context);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi
    public void showGainMutualMarkAnimatorView(QQStrangerInteractiveMarkModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 4, "showGainMutualMarkAnimatorView");
        }
        this.foregroundDelegate.p(model);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi
    public void updateAIOTitleMutualMark(QQStrangerInteractiveMarkModel model, String loadingDrawablePath) {
        Intrinsics.checkNotNullParameter(model, "model");
        String e16 = com.tencent.mobileqq.matchfriend.reborn.mark.c.e(model);
        if (!URLUtil.isValidUrl(e16)) {
            QLog.e(TAG, 1, "[updateAIOTitleMutualMark] iconUrl invalid.");
            return;
        }
        a aVar = this.aioContext;
        if (aVar != null) {
            com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a.l(model.level, model.subtype);
            aVar.e().h(new AIOTitleEvent.MutualMarkResponseEvent(new ae(e16, 1, com.tencent.mobileqq.matchfriend.reborn.mark.c.c(model), new c(loadingDrawablePath, model, aVar)), null, false));
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi
    public void onDestroy() {
        this.aioContext = null;
        this.foregroundDelegate.i();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J*\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J(\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerForegroundApiImpl$c", "Lcom/tencent/mobileqq/aio/title/ac;", "", "loadingDrawablePath", "Landroid/graphics/drawable/Drawable;", "g", "", "d", "", "c", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "iconUrl", "iconDrawable", "", "f", "Landroid/content/Context;", "context", "defaultIconDrawable", "Lkotlin/Pair;", "b", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements ac {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f244185a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQStrangerInteractiveMarkModel f244186b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f244187c;

        c(String str, QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel, a aVar) {
            this.f244185a = str;
            this.f244186b = qQStrangerInteractiveMarkModel;
            this.f244187c = aVar;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void a() {
            FragmentActivity activity;
            com.tencent.mobileqq.matchfriend.aio.utils.c cVar = com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a;
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = this.f244186b;
            cVar.k(qQStrangerInteractiveMarkModel.level, qQStrangerInteractiveMarkModel.subtype);
            Fragment c16 = this.f244187c.c();
            if (c16 == null || (activity = c16.getActivity()) == null) {
                return;
            }
            ((IQQStrangerMutualMarkApi) QRoute.api(IQQStrangerMutualMarkApi.class)).showMutualDetailDialog(activity, this.f244186b);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public Pair<String, Drawable> b(Context context, Drawable defaultIconDrawable) {
            Intrinsics.checkNotNullParameter(defaultIconDrawable, "defaultIconDrawable");
            return new Pair<>(null, defaultIconDrawable);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public boolean c() {
            return true;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public float d() {
            return 1.0f;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void e() {
            ac.a.b(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void f(Resources resources, ImageView view, String iconUrl, Drawable iconDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            String str = this.f244185a;
            obtain.mRequestWidth = l.b(20);
            obtain.mRequestHeight = l.b(20);
            obtain.mLoadingDrawable = g(str);
            URLDrawable drawable = URLDrawable.getDrawable(iconUrl, obtain);
            view.setScaleType(ImageView.ScaleType.FIT_CENTER);
            view.setImageDrawable(drawable);
        }

        private final Drawable g(String loadingDrawablePath) {
            if (loadingDrawablePath == null || !com.tencent.qqnt.aio.utils.m.f352305a.f(loadingDrawablePath)) {
                return null;
            }
            QLog.i(QQStrangerForegroundApiImpl.TAG, 2, "getLoadingDrawable use loading drawable path: " + loadingDrawablePath);
            return URLDrawable.getFileDrawable(loadingDrawablePath, null);
        }
    }
}
