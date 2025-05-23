package com.tencent.mobileqq.emoticon.data.provider;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.emoticon.data.ipc.b;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/provider/FavEmoticonDataProvider;", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService;", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "getFavoriteTabInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "getFavoriteEmotions", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "tabType", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "callback", "updateEmoticonInfo", "getEmoticonTabInfo", "Lmqq/util/WeakReference;", "weakAppRuntime", "Lmqq/util/WeakReference;", "<init>", "()V", "Companion", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FavEmoticonDataProvider implements IEmoticonDataService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "FavEmoticonDataProvider";
    private WeakReference<AppRuntime> weakAppRuntime;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/provider/FavEmoticonDataProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.provider.FavEmoticonDataProvider$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/emoticon/data/provider/FavEmoticonDataProvider$b", "Lcom/tencent/mobileqq/emosm/favroaming/o;", "", "a", "notifySyncFail", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IEmoticonDataService.UpdateEmoticonInfoCallback f204762a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FavEmoticonDataProvider f204763b;

        b(IEmoticonDataService.UpdateEmoticonInfoCallback updateEmoticonInfoCallback, FavEmoticonDataProvider favEmoticonDataProvider) {
            this.f204762a = updateEmoticonInfoCallback;
            this.f204763b = favEmoticonDataProvider;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) updateEmoticonInfoCallback, (Object) favEmoticonDataProvider);
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f204762a.onComplete(true, this.f204763b.getFavoriteTabInfo());
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.o
        public void notifySyncFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            IEmoticonDataService.UpdateEmoticonInfoCallback updateEmoticonInfoCallback = this.f204762a;
            List<? extends EmoticonTabInfo> emptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
            updateEmoticonInfoCallback.onComplete(false, emptyList);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/emoticon/data/provider/FavEmoticonDataProvider$c", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$d$b;", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoticons", "", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements b.d.InterfaceC7499b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IEmoticonDataService.UpdateEmoticonInfoCallback f204764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FavEmoticonDataProvider f204765b;

        c(IEmoticonDataService.UpdateEmoticonInfoCallback updateEmoticonInfoCallback, FavEmoticonDataProvider favEmoticonDataProvider) {
            this.f204764a = updateEmoticonInfoCallback;
            this.f204765b = favEmoticonDataProvider;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) updateEmoticonInfoCallback, (Object) favEmoticonDataProvider);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.data.ipc.b.d.InterfaceC7499b
        public void a(boolean result, @NotNull ArrayList<EmoticonInfo> emoticons) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), emoticons);
                return;
            }
            Intrinsics.checkNotNullParameter(emoticons, "emoticons");
            if (result) {
                this.f204764a.onComplete(true, this.f204765b.getFavoriteTabInfo());
                return;
            }
            IEmoticonDataService.UpdateEmoticonInfoCallback updateEmoticonInfoCallback = this.f204764a;
            List<? extends EmoticonTabInfo> emptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
            updateEmoticonInfoCallback.onComplete(false, emptyList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FavEmoticonDataProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<EmoticonInfo> getFavoriteEmotions() {
        if (com.tencent.mobileqq.emoticon.data.ipc.b.INSTANCE.b()) {
            WeakReference<AppRuntime> weakReference = this.weakAppRuntime;
            if (weakReference == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weakAppRuntime");
                weakReference = null;
            }
            AppRuntime appRuntime = weakReference.get();
            if (appRuntime == null) {
                return Collections.emptyList();
            }
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IFavroamingDBManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            return ((IFavroamingDBManagerService) runtimeService).syncGetCustomEmotionInfoShowedInPanel();
        }
        return b.C7498b.INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<EmoticonTabInfo> getFavoriteTabInfo() {
        com.tencent.mobileqq.emoticon.data.api.impl.c cVar = new com.tencent.mobileqq.emoticon.data.api.impl.c(5, "\u6536\u85cf", R.drawable.fo5);
        List<EmoticonInfo> favoriteEmotions = getFavoriteEmotions();
        if (favoriteEmotions != null && (!favoriteEmotions.isEmpty())) {
            for (EmoticonInfo emoticonInfo : favoriteEmotions) {
                if (emoticonInfo.type != 10) {
                    cVar.a().add(emoticonInfo);
                }
            }
        }
        List<EmoticonTabInfo> singletonList = Collections.singletonList(cVar);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(tagInfo)");
        return singletonList;
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    @NotNull
    public List<EmoticonTabInfo> getEmoticonTabInfo(int tabType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, tabType);
        }
        return getFavoriteTabInfo();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            this.weakAppRuntime = new WeakReference<>(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.weakAppRuntime = new WeakReference<>(null);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    public void updateEmoticonInfo(int tabType, @NotNull IEmoticonDataService.UpdateEmoticonInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, tabType, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (com.tencent.mobileqq.emoticon.data.ipc.b.INSTANCE.b()) {
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).triggerToSyncFromServer(new b(callback, this));
        } else {
            b.d.INSTANCE.b(new c(callback, this));
        }
    }
}
