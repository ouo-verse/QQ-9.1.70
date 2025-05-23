package com.tencent.qqnt.chats.biz.guildhelper;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.api.IGuildFolderGuideApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.main.api.IMainChatGuildManager;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guildhelper/GuildFolderGuideHelper;", "", "", h.F, "", "source", "r", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "uiState", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "f", "filteredItems", "v", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Landroid/content/Context;", "context", "k", "g", "t", "d", "Landroid/content/Intent;", "intent", "j", "", "b", "J", "startTimeInMills", "c", "Z", "needGuildFolderGuideFlag", "Ljava/lang/String;", "scene", "preGuildHelperMsgTime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "guildHelperInfo", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "contextRef", "Lcom/tencent/qqnt/chats/api/IGuildFolderGuideApi;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/qqnt/chats/api/IGuildFolderGuideApi;", "routeApi", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildFolderGuideHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long startTimeInMills;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean needGuildFolderGuideFlag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long preGuildHelperMsgTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static RecentContactInfo guildHelperInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Context> contextRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy routeApi;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFolderGuideHelper f354289a = new GuildFolderGuideHelper();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String scene = "";

    static {
        Lazy lazy;
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.chatType = 60;
        guildHelperInfo = recentContactInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildFolderGuideApi>() { // from class: com.tencent.qqnt.chats.biz.guildhelper.GuildFolderGuideHelper$routeApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildFolderGuideApi invoke() {
                return (IGuildFolderGuideApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildFolderGuideApi.class);
            }
        });
        routeApi = lazy;
    }

    GuildFolderGuideHelper() {
    }

    private final void e() {
        QLog.i("GuildFolderGuideHelper", 4, "[doGuildFolderGuideAction] do it! scene=" + scene);
        if (Intrinsics.areEqual(scene, IGuildFolderGuideApi.SCENE_SETTING)) {
            ((IMainChatGuildManager) QRoute.api(IMainChatGuildManager.class)).scrollToGuildHelper();
        } else if (l()) {
            p();
        } else {
            s();
        }
    }

    private final List<g> f(a.b uiState) {
        boolean z16;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> d16 = uiState.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : d16) {
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((g) obj2).n() == 60) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj2);
            }
        }
        v(arrayList2, uiState);
        return arrayList2;
    }

    private final void h() {
        ((IMainChatGuildManager) QRoute.api(IMainChatGuildManager.class)).findGuildHelper(new Function1<RecentContactInfo, Unit>() { // from class: com.tencent.qqnt.chats.biz.guildhelper.GuildFolderGuideHelper$getGuildHelperMsgTime$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
                if (recentContactInfo != null) {
                    GuildFolderGuideHelper.guildHelperInfo = recentContactInfo;
                    GuildFolderGuideHelper.preGuildHelperMsgTime = recentContactInfo.getMsgTime();
                }
                QLog.i("GuildFolderGuideHelper", 4, "[startGuildFolderGuide] findGuildHelper\uff0crecentContactInfo?.msgTime=" + (recentContactInfo != null ? Long.valueOf(recentContactInfo.getMsgTime()) : null));
            }
        });
    }

    private final IGuildFolderGuideApi i() {
        return (IGuildFolderGuideApi) routeApi.getValue();
    }

    private final boolean l() {
        return ((IChatsUtil) QRoute.api(IChatsUtil.class)).isInVisibleIndex(60, "", "");
    }

    private final boolean m() {
        long currentTimeMillis = System.currentTimeMillis() - startTimeInMills;
        if (currentTimeMillis > 3000) {
            QLog.i("GuildFolderGuideHelper", 1, "[isTimeOut] return because time out, totalTime=" + currentTimeMillis);
            return true;
        }
        return false;
    }

    private final void o() {
        needGuildFolderGuideFlag = false;
        preGuildHelperMsgTime = 0L;
        scene = "";
    }

    private final void p() {
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).chatsHighLightItem(60, "", "");
        q();
    }

    private final void q() {
        if (i().alwaysShowInDebug()) {
            return;
        }
        if (i().isShowGuildFolderGuide(scene)) {
            QLog.d("GuildFolderGuideHelper", 4, "[setMMKV] return, mmkv.isShowGuildFolderGuide=true");
        } else {
            QLog.d("GuildFolderGuideHelper", 4, "[setMMKV] do mmkv.setShowGuildFolderGuide !");
            i().setShowGuildFolderGuide(IGuildFolderGuideApi.SCENE_MSG_LIST);
        }
    }

    private final void r(String source) {
        scene = source;
        needGuildFolderGuideFlag = true;
        startTimeInMills = System.currentTimeMillis();
    }

    private final void s() {
        FragmentActivity fragmentActivity;
        Context g16 = g();
        if (g16 != null) {
            FragmentManager fragmentManager = null;
            if (g16 instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) g16;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                fragmentManager = fragmentActivity.getSupportFragmentManager();
            }
            if (fragmentManager != null) {
                ((IGuildFolderGuideApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildFolderGuideApi.class)).showGuildFolderGuideDialog(IGuildFolderGuideApi.SCENE_MSG_LIST, "", fragmentManager, new GuildFolderGuideHelper$showGuildFolderGuideDialog$1$1$1(f354289a));
            }
        }
    }

    public static /* synthetic */ void u(GuildFolderGuideHelper guildFolderGuideHelper, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = IGuildFolderGuideApi.SCENE_MSG_LIST;
        }
        guildFolderGuideHelper.t(str);
    }

    private final void v(List<g> filteredItems, a.b uiState) {
        if (QLog.isDevelopLevel()) {
            QLog.i("GuildFolderGuideHelper", 4, "[filterGuildHelperItems] guildHelper isEmpty = " + filteredItems.isEmpty() + ", uiState=" + uiState.h());
            if (!filteredItems.isEmpty()) {
                QLog.d("GuildFolderGuideHelper", 4, "[checkScrollToGuildHelper] guildHelper = " + filteredItems.get(0).s().getMsgTime());
            }
        }
    }

    public final void d(@NotNull a.b uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (!needGuildFolderGuideFlag) {
            return;
        }
        if (m()) {
            o();
            return;
        }
        if (Intrinsics.areEqual(scene, IGuildFolderGuideApi.SCENE_SETTING)) {
            e();
            o();
            return;
        }
        List<g> f16 = f(uiState);
        if (!(!f16.isEmpty()) || f16.get(0).s().getMsgTime() <= preGuildHelperMsgTime) {
            return;
        }
        e();
        o();
    }

    @Nullable
    public final Context g() {
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void j(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("REQUEST_SCROLL_GUILD_HELPER_SCENE");
        if (stringExtra != null) {
            if (Intrinsics.areEqual(stringExtra, IGuildFolderGuideApi.SCENE_MSG_LIST)) {
                ((IMainChatGuildManager) QRoute.api(IMainChatGuildManager.class)).scrollToGuildHelper();
            } else {
                f354289a.t(stringExtra);
            }
        }
    }

    public final void k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        contextRef = new WeakReference<>(context);
    }

    public final void t(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (needGuildFolderGuideFlag) {
            QLog.d("GuildFolderGuideHelper", 4, "[startGuildFolderGuide] return because existing tasks are in queue!");
        } else {
            r(source);
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
    }
}
