package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.api.ITroopAvatarLoaderApi;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u0011\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\rH\u0003J\u0019\u0010\u0014\u001a\u00020\u000b2\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0082\bJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0018\u00010\rH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopAvatarLoaderApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopAvatarLoaderApi;", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", "Landroid/content/Context;", "context", "", "headType", "", "uin", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, "", "loadAvatar", "", "Lcom/tencent/qqnt/avatar/layer/d;", "", "layerList", "doHandleLayerList", "Lkotlin/Function0;", "action", "runOnUiThread", "getRequestKey", "Lcom/tencent/mobileqq/troop/api/b;", "callback", "onResult", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "resourceOrganizer", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "Ljava/util/concurrent/ConcurrentHashMap;", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAvatarLoaderApiImpl implements ITroopAvatarLoaderApi, ResourceOrganizer.a {
    static IPatchRedirector $redirector_;

    @NotNull
    private final ConcurrentHashMap<String, Object> observerMap;

    @Nullable
    private ResourceOrganizer resourceOrganizer;

    public TroopAvatarLoaderApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.observerMap = new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void doHandleLayerList(List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        com.tencent.mobileqq.troop.api.b bVar;
        int i3 = 0;
        for (Object obj : layerList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.avatar.layer.d dVar = (com.tencent.qqnt.avatar.layer.d) obj;
            if (dVar.d() instanceof Bitmap) {
                String c16 = dVar.b().c();
                int a16 = dVar.b().a();
                Object d16 = dVar.d();
                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.graphics.Bitmap");
                Bitmap bitmap = (Bitmap) d16;
                if (c16 != null) {
                    Object remove = this.observerMap.remove(getRequestKey(c16, a16));
                    if (remove instanceof com.tencent.mobileqq.troop.api.b) {
                        bVar = (com.tencent.mobileqq.troop.api.b) remove;
                    } else {
                        bVar = null;
                    }
                    if (bVar != null) {
                        bVar.a(c16, bitmap);
                    }
                }
            }
            i3 = i16;
        }
    }

    private final String getRequestKey(String uin, int headType) {
        return uin + "_" + headType;
    }

    static /* synthetic */ void loadAvatar$default(TroopAvatarLoaderApiImpl troopAvatarLoaderApiImpl, Context context, int i3, String str, com.tencent.mobileqq.proavatar.e eVar, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            eVar = null;
        }
        troopAvatarLoaderApiImpl.loadAvatar(context, i3, str, eVar);
    }

    private final void runOnUiThread(final Function0<Unit> action) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            action.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(action) { // from class: com.tencent.mobileqq.troop.api.impl.TroopAvatarLoaderApiImpl$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0<Unit> f294236d;

                {
                    this.f294236d = action;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) action);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f294236d.invoke();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarLoaderApi
    public void loadAvatar(@NotNull Context context, int headType, @NotNull String uin, @NotNull com.tencent.mobileqq.troop.api.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(headType), uin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.observerMap.put(getRequestKey(uin, headType), callback);
        ResourceOrganizer resourceOrganizer = new ResourceOrganizer();
        this.resourceOrganizer = resourceOrganizer;
        resourceOrganizer.t(this);
        loadAvatar(context, headType, uin, com.tencent.mobileqq.proavatar.e.INSTANCE.a(headType, uin));
    }

    @Override // com.tencent.qqnt.avatar.core.ResourceOrganizer.a
    public void onResult(@Nullable final List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerList);
        } else {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                if (layerList != null) {
                    doHandleLayerList(layerList);
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(layerList, this) { // from class: com.tencent.mobileqq.troop.api.impl.TroopAvatarLoaderApiImpl$onResult$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f294235d;
                final /* synthetic */ TroopAvatarLoaderApiImpl this$0;

                {
                    this.f294235d = layerList;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) layerList, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List list = this.f294235d;
                    if (list != null) {
                        this.this$0.doHandleLayerList(list);
                    }
                }
            });
        }
    }

    private final void loadAvatar(Context context, int headType, String uin, com.tencent.mobileqq.proavatar.e config) {
        if (uin == null || uin.length() == 0) {
            return;
        }
        com.tencent.qqnt.avatar.fetch.c buildResourceFetchRequest = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(headType, uin, config);
        ResourceOrganizer resourceOrganizer = this.resourceOrganizer;
        if (resourceOrganizer != null) {
            resourceOrganizer.u(context, buildResourceFetchRequest);
        }
    }
}
