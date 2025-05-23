package com.tencent.qqnt.chats.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.api.IAvatarGetterService;
import com.tencent.qqnt.chats.api.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/AvatarGetterServiceImpl;", "Lcom/tencent/qqnt/chats/api/IAvatarGetterService;", "", "initRecentDecoder", "Lcom/tencent/qqnt/chats/api/a$a;", "listener", "registerDecodeComplete", "unRegisterDecodeComplete", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "memoryCacheHighPriority", "Landroid/graphics/drawable/Drawable;", "getDrawable", "", "chatType", "", "uin", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/chats/api/a;", "getterService", "Lcom/tencent/qqnt/chats/api/a;", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AvatarGetterServiceImpl implements IAvatarGetterService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AvatarGetterServiceImpl";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_AvatarGetter.yml", version = 4)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.api.a>> getterServiceClassList;

    @Nullable
    private final com.tencent.qqnt.chats.api.a getterService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000bR<\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/AvatarGetterServiceImpl$a;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/api/a;", "Lkotlin/collections/ArrayList;", "getterServiceClassList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "getGetterServiceClassList$annotations", "()V", "", "TAG", "Ljava/lang/String;", "<init>", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.impl.AvatarGetterServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ArrayList<Class<com.tencent.qqnt.chats.api.a>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AvatarGetterServiceImpl.getterServiceClassList;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.api.a>> arrayList = new ArrayList<>();
        getterServiceClassList = arrayList;
        arrayList.add(com.tencent.mobileqq.activity.home.chats.avatar.e.class);
    }

    public AvatarGetterServiceImpl() {
        Object orNull;
        com.tencent.qqnt.chats.api.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(getterServiceClassList, 0);
            Class cls = (Class) orNull;
            if (cls != null) {
                aVar = (com.tencent.qqnt.chats.api.a) cls.newInstance();
            } else {
                aVar = null;
            }
            this.getterService = aVar;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @NotNull
    public static final ArrayList<Class<com.tencent.qqnt.chats.api.a>> getGetterServiceClassList() {
        return INSTANCE.a();
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    public void create(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
            return;
        }
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            aVar.create(appRuntime);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    @Nullable
    public Drawable getDrawable(@NotNull g item, boolean memoryCacheHighPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, item, Boolean.valueOf(memoryCacheHighPriority));
        }
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            return aVar.getDrawable(item, memoryCacheHighPriority);
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    public void initRecentDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            aVar.initRecentDecoder();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else {
            create(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            destroy();
        }
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    public void registerDecodeComplete(@NotNull a.InterfaceC9560a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            aVar.registerDecodeComplete(listener);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    public void unRegisterDecodeComplete(@NotNull a.InterfaceC9560a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            aVar.unRegisterDecodeComplete(listener);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IAvatarGetterService, com.tencent.qqnt.chats.api.a
    @Nullable
    public Drawable getDrawable(int chatType, @NotNull String uin, boolean memoryCacheHighPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(chatType), uin, Boolean.valueOf(memoryCacheHighPriority));
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.chats.api.a aVar = this.getterService;
        if (aVar != null) {
            return aVar.getDrawable(chatType, uin, memoryCacheHighPriority);
        }
        return null;
    }
}
