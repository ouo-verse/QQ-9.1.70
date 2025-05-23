package com.tencent.mobileqq.activity.home.chats.avatar;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.api.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b(\u0010)J4\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J,\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/avatar/e;", "Lcom/tencent/qqnt/chats/api/a;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "chatType", "", "uin", "", "memoryCacheHighPriority", "", "vipPendantId", "Landroid/graphics/drawable/Drawable;", "oldDrawable", "a", "Lmqq/app/AppRuntime;", "appRuntime", "", OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "getDrawable", "initRecentDecoder", "Lcom/tencent/qqnt/chats/api/a$a;", "listener", "registerDecodeComplete", "unRegisterDecodeComplete", "remainingTasks", "type", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "Lcom/tencent/mobileqq/activity/recent/i;", "d", "Lcom/tencent/mobileqq/activity/recent/i;", "recentDecoder", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements com.tencent.qqnt.chats.api.a, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i recentDecoder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<a.InterfaceC9560a> callbackList;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.callbackList = new CopyOnWriteArrayList<>();
        }
    }

    private final Drawable a(int chatType, String uin, boolean memoryCacheHighPriority, long vipPendantId, Drawable oldDrawable) {
        i iVar = this.recentDecoder;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentDecoder");
            iVar = null;
        }
        i iVar2 = iVar;
        if (chatType == 10022) {
            chatType = 1008;
        }
        return iVar2.i(chatType, uin, memoryCacheHighPriority, vipPendantId, oldDrawable);
    }

    @Override // com.tencent.qqnt.chats.api.a
    public void create(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (appRuntime instanceof QQAppInterface) {
            this.recentDecoder = new i((QQAppInterface) appRuntime, this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        i iVar = this.recentDecoder;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentDecoder");
            iVar = null;
        }
        iVar.r();
    }

    @Override // com.tencent.qqnt.chats.api.a
    @Nullable
    public Drawable getDrawable(@NotNull g item, boolean memoryCacheHighPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, item, Boolean.valueOf(memoryCacheHighPriority));
        }
        Intrinsics.checkNotNullParameter(item, "item");
        int c16 = com.tencent.nt.adapter.session.c.c(item.n());
        String a16 = b.f182877a.a(item);
        if (!item.y().n() && item.y().o()) {
            i3 = item.y().i() > 0 ? item.y().i() : item.y().f();
        }
        return a(c16, a16, memoryCacheHighPriority, i3, item.g().b());
    }

    @Override // com.tencent.qqnt.chats.api.a
    public void initRecentDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(remainingTasks), Integer.valueOf(type), uin, avatar);
            return;
        }
        Iterator<T> it = this.callbackList.iterator();
        while (it.hasNext()) {
            ((a.InterfaceC9560a) it.next()).onDecodeTaskCompleted(remainingTasks, type, uin, avatar);
        }
    }

    @Override // com.tencent.qqnt.chats.api.a
    public void registerDecodeComplete(@NotNull a.InterfaceC9560a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.callbackList.add(listener);
        }
    }

    @Override // com.tencent.qqnt.chats.api.a
    public void unRegisterDecodeComplete(@NotNull a.InterfaceC9560a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.callbackList.remove(listener);
        }
    }

    @Override // com.tencent.qqnt.chats.api.a
    @Nullable
    public Drawable getDrawable(int chatType, @NotNull String uin, boolean memoryCacheHighPriority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), uin, Boolean.valueOf(memoryCacheHighPriority));
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return a(chatType, uin, memoryCacheHighPriority, 0L, null);
    }
}
