package com.tencent.mobileqq.activity.home.chats.api.impl;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.home.chats.NtBasePartFrame;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.activity.home.chats.b;
import com.tencent.mobileqq.activity.home.chats.troophelper.TroopHelperFragment;
import com.tencent.mobileqq.anim.aio.f;
import com.tencent.mobileqq.guildhelper.GuildHelperFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsDataRepoCreator;
import com.tencent.qqnt.chats.biz.main.part.a;
import com.tencent.qqnt.chats.biz.main.part.c;
import com.tencent.qqnt.chats.biz.main.part.d;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJF\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/api/impl/ChatApiImpl;", "Lcom/tencent/mobileqq/activity/home/chats/api/IChatApi;", "Lcom/tencent/biz/richframework/part/Part;", "titlePart", "chatListPart", "miniProgramPart", "", "bizPart", "priorityPart", "Lcom/tencent/mobileqq/activity/home/chats/NtBasePartFrame;", "createFrame", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "createPreloadRepo", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "obtainScope", "Landroid/content/Context;", "context", "", "jumpToTroopHelperFragment", "jumpToGuildHelperFragment", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", BaseConstants.BROADCAST_USERSYNC_ENTER, "overrideActivityAnimation", "<init>", "()V", "Companion", "a", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ChatApiImpl implements IChatApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChatApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/api/impl/ChatApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.api.impl.ChatApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    @NotNull
    public NtBasePartFrame createFrame(@Nullable Part titlePart, @Nullable Part chatListPart, @Nullable Part miniProgramPart, @Nullable List<? extends Part> bizPart, @Nullable List<? extends Part> priorityPart) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        List<? extends Part> list;
        List<? extends Part> list2;
        List<? extends Part> emptyList;
        List<? extends Part> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NtBasePartFrame) iPatchRedirector.redirect((short) 2, this, titlePart, chatListPart, miniProgramPart, bizPart, priorityPart);
        }
        if (titlePart instanceof a) {
            aVar = (a) titlePart;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new com.tencent.mobileqq.activity.home.chats.a();
        }
        if (chatListPart instanceof a) {
            aVar2 = (a) chatListPart;
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            aVar2 = new c();
        }
        a aVar5 = aVar2;
        if (miniProgramPart instanceof a) {
            aVar3 = (a) miniProgramPart;
        } else {
            aVar3 = null;
        }
        if (aVar3 == null) {
            aVar4 = new d();
        } else {
            aVar4 = aVar3;
        }
        if (bizPart == null) {
            bizPart = null;
        }
        if (bizPart == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList2;
        } else {
            list = bizPart;
        }
        if (priorityPart == null) {
            priorityPart = null;
        }
        if (priorityPart == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = priorityPart;
        }
        return new b(aVar, aVar5, aVar4, list, list2);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    @NotNull
    public IRecentContactRepo createPreloadRepo(@NotNull LifecycleCoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scope);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        long currentTimeMillis = System.currentTimeMillis();
        IRecentContactRepo createMainRepo = ((IChatsDataRepoCreator) QRoute.api(IChatsDataRepoCreator.class)).createMainRepo(scope);
        createMainRepo.create();
        QLog.i(TAG, 1, "createPreloadRepo cost: " + (System.currentTimeMillis() - currentTimeMillis));
        return createMainRepo;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    public void jumpToGuildHelperFragment(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            GuildHelperFragment.INSTANCE.a(context);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    public void jumpToTroopHelperFragment(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            TroopHelperFragment.INSTANCE.a(context);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    @NotNull
    public LifecycleCoroutineScope obtainScope(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LifecycleCoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragmentActivity);
        }
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        return LifecycleOwnerKt.getLifecycleScope(fragmentActivity);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.api.IChatApi
    public void overrideActivityAnimation(@NotNull Activity activity, boolean enter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, Boolean.valueOf(enter));
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            f.f194321a.h(activity, enter);
        }
    }
}
