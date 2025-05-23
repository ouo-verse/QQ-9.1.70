package com.tencent.mobileqq.guild.feed.morepanel.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.core.util.Consumer;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.libra.request.Option;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.EditFeedActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory;
import com.tencent.mobileqq.guild.feed.morepanel.handler.FeedShare2XHSActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ReportFeedHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.s;
import com.tencent.mobileqq.guild.feed.morepanel.handler.t;
import com.tencent.mobileqq.guild.feed.morepanel.handler.u;
import com.tencent.mobileqq.guild.feed.morepanel.handler.w;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl;", "", "a", "b", "OperationListProvider", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMorePanelBusiImpl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0005\u001f$\u001a\n\u0004B\u001f\u0012\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u0002`\u001e\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0014J\u001a\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0015\u001a\u00020\fH\u0004J\u001e\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00030\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0004R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u0002`\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R)\u0010'\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00030\u00030\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\u001f\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "e", "", "channelId", "", "i", "guildId", "d", "setTop", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", tl.h.F, "g", "j", "", "f", "actionId", "", "l", "actionList", "kotlin.jvm.PlatformType", "c", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "k", "()Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "b", "Lkotlin/Lazy;", "()Ljava/util/List;", "secondaryPaths", "operations", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class OperationListProvider implements k.a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private static final a f220379d = new a(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy secondaryPaths;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy operations;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        private static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            a() {
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$b;", "", "Landroid/os/Bundle;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public interface b {
            @NotNull
            Bundle a();
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$c;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public interface c {
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$d;", "", "Lkotlinx/coroutines/CoroutineScope;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public interface d {
            @NotNull
            CoroutineScope a();
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$e;", "", "", "channelId", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public interface e {
            boolean a(@NotNull String channelId);
        }

        public OperationListProvider(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
            lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<ShareActionSheetBuilder.ActionSheetItem>>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl$OperationListProvider$secondaryPaths$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<ShareActionSheetBuilder.ActionSheetItem> invoke() {
                    List<ShareActionSheetBuilder.ActionSheetItem> mutableListOf;
                    Object obj;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ShareActionSheetBuilder.ActionSheetItem.build(2), ShareActionSheetBuilder.ActionSheetItem.build(171), ShareActionSheetBuilder.ActionSheetItem.build(9), ShareActionSheetBuilder.ActionSheetItem.build(10), ShareActionSheetBuilder.ActionSheetItem.build(3));
                    Iterator<T> it = FeedMorePanelBusiImpl.OperationListProvider.this.a().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((ShareActionSheetBuilder.ActionSheetItem) obj).action == 153) {
                            break;
                        }
                    }
                    if (obj != null) {
                        mutableListOf.add(ShareActionSheetBuilder.ActionSheetItem.build(218));
                    }
                    return mutableListOf;
                }
            });
            this.secondaryPaths = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new FeedMorePanelBusiImpl$OperationListProvider$operations$2(this));
            this.operations = lazy2;
        }

        private final boolean d(String guildId, String channelId) {
            AppInterface appInterface;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService == null) {
                return false;
            }
            if (!iGPSService.getGuildPermission(guildId).a(30002) && !iGPSService.getChannelPermission(guildId, channelId).a(30002)) {
                return false;
            }
            return true;
        }

        private final LinkedList<ShareActionSheetBuilder.ActionSheetItem> e() {
            AppInterface appInterface;
            IRuntimeService iRuntimeService;
            int[] j3;
            int[] plus;
            vk1.b j16 = this.panelContext.j();
            String valueOf = String.valueOf(this.panelContext.j().getGuildId());
            String valueOf2 = String.valueOf(this.panelContext.j().getChannelId());
            boolean K = this.panelContext.j().K();
            boolean d16 = d(valueOf, valueOf2);
            String r16 = j16.r();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                str = iGPSService.getSelfTinyId();
            }
            boolean areEqual = Intrinsics.areEqual(r16, str);
            int[] iArr = new int[0];
            if (areEqual) {
                iArr = ArraysKt___ArraysJvmKt.plus(iArr, 94);
            }
            if (ch.m0(valueOf)) {
                iArr = ArraysKt___ArraysJvmKt.plus(iArr, m(!i("")));
                if (K) {
                    iArr = ArraysKt___ArraysJvmKt.plus(iArr, n(!i(valueOf2)));
                }
            }
            if (d16) {
                j3 = g();
            } else if (areEqual) {
                j3 = h();
            } else {
                j3 = j();
            }
            plus = ArraysKt___ArraysJvmKt.plus(iArr, j3);
            if (d16 && !areEqual) {
                plus = ArraysKt___ArraysJvmKt.plus(plus, 11);
            }
            return c(plus);
        }

        private final int[] g() {
            List mutableListOf;
            int[] intArray;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(225, 224, 153, 1, 40);
            intArray = CollectionsKt___CollectionsKt.toIntArray(mutableListOf);
            return intArray;
        }

        private final int[] h() {
            return new int[]{153, 1, 40};
        }

        private final boolean i(String channelId) {
            e eVar = (e) this.panelContext.getApiRouter().b(e.class);
            if (eVar != null) {
                return eVar.a(channelId);
            }
            return false;
        }

        private final int[] j() {
            return new int[]{153, 1, 11};
        }

        private final int m(boolean setTop) {
            if (setTop) {
                return 242;
            }
            return 243;
        }

        private final int n(boolean setTop) {
            if (setTop) {
                return 244;
            }
            return 245;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.k.a
        @NotNull
        public List<ShareActionSheetBuilder.ActionSheetItem> a() {
            return (List) this.operations.getValue();
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.k.a
        @NotNull
        public List<ShareActionSheetBuilder.ActionSheetItem> b() {
            return (List) this.secondaryPaths.getValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public final LinkedList<ShareActionSheetBuilder.ActionSheetItem> c(@NotNull int[] actionList) {
            Intrinsics.checkNotNullParameter(actionList, "actionList");
            LinkedList<ShareActionSheetBuilder.ActionSheetItem> linkedList = new LinkedList<>();
            for (int i3 : actionList) {
                linkedList.add(ShareActionSheetBuilder.ActionSheetItem.build(i3));
            }
            return linkedList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public List<ShareActionSheetBuilder.ActionSheetItem> f() {
            List<ShareActionSheetBuilder.ActionSheetItem> mutableList;
            if (this.panelContext.getExtra().getBoolean("EXTRA_KEY_9090_IMPROVE_SHARE_ACTION", false)) {
                Logger.f235387a.d().i("OperationListProvider", 1, "createOperationList hit 9090 common share");
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) m.f220412a.b(this.panelContext));
                return mutableList;
            }
            LinkedList<ShareActionSheetBuilder.ActionSheetItem> e16 = e();
            switch (this.panelContext.getExtra().getInt("src_business_type", 0)) {
                case 14:
                    e16.add(0, ShareActionSheetBuilder.ActionSheetItem.build(223));
                    break;
                case 15:
                case 16:
                    break;
                default:
                    l(e16, 224);
                    break;
            }
            if (!this.panelContext.getExtra().getBoolean("preserve_edit_action")) {
                l(e16, 94);
            }
            return e16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public final PanelContext<Activity, vk1.b> k() {
            return this.panelContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void l(@NotNull List<ShareActionSheetBuilder.ActionSheetItem> list, int i3) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Iterator<ShareActionSheetBuilder.ActionSheetItem> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().action == i3) {
                    it.remove();
                    return;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0016B\u001f\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$a;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "b", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "w6", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "d", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "", "e", "Ljava/util/List;", "a", "()Ljava/util/List;", "delegateList", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ShareActionSheet.c {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private static final C7746a f220383f = new C7746a(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<x> delegateList;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        private static final class C7746a {
            public /* synthetic */ C7746a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            C7746a() {
            }
        }

        public a(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
            this.delegateList = new ArrayList();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final x b(ShareActionSheetBuilder.ActionSheetItem item) {
            x tVar;
            int i3 = item.action;
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                if (i3 != 39) {
                    if (i3 != 40) {
                        if (i3 != 72 && i3 != 73) {
                            if (i3 != 224) {
                                if (i3 != 225) {
                                    switch (i3) {
                                        case 9:
                                        case 10:
                                            break;
                                        case 11:
                                            return new ReportFeedHandler();
                                        default:
                                            switch (i3) {
                                                case 26:
                                                case 171:
                                                    break;
                                                case 55:
                                                    tVar = new u(null);
                                                    break;
                                                case 94:
                                                    return new EditFeedActionHandler();
                                                case 153:
                                                    return new GenerateFeedSharePictureV2Handler();
                                                case 155:
                                                    return new com.tencent.mobileqq.guild.feed.morepanel.handler.n();
                                                case 179:
                                                case 216:
                                                    return new s();
                                                case 212:
                                                    return new w();
                                                case 218:
                                                    return new FeedShare2XHSActionHandler();
                                                case 235:
                                                    return FeedManageActionHandlerFactory.f220270a.f();
                                                case 240:
                                                    return FeedManageActionHandlerFactory.f220270a.e();
                                                default:
                                                    switch (i3) {
                                                        case 242:
                                                        case 243:
                                                            return FeedManageActionHandlerFactory.f220270a.j(1);
                                                        case 244:
                                                        case 245:
                                                            return FeedManageActionHandlerFactory.f220270a.j(2);
                                                        default:
                                                            Logger logger = Logger.f235387a;
                                                            Logger.b bVar = new Logger.b();
                                                            String str = "matchHandler unexpectedTarget:" + item;
                                                            if (str instanceof String) {
                                                                bVar.a().add(str);
                                                            }
                                                            Iterator<T> it = bVar.a().iterator();
                                                            while (it.hasNext()) {
                                                                Logger.f235387a.d().e("FeedNativeDetailMorePanelClickHandler", 1, (String) it.next(), null);
                                                            }
                                                            QQToastUtil.showQQToast(1, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~");
                                                            return null;
                                                    }
                                            }
                                    }
                                } else {
                                    return FeedManageActionHandlerFactory.f220270a.i();
                                }
                            } else {
                                return FeedManageActionHandlerFactory.f220270a.h();
                            }
                        }
                    } else {
                        return FeedManageActionHandlerFactory.f220270a.g();
                    }
                } else {
                    tVar = new t(null);
                }
                return tVar;
            }
            return new ShareFeedActionHandler();
        }

        @NotNull
        public final List<x> a() {
            return this.delegateList;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(@NotNull View view, @NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            if (FastClickUtils.isFastDoubleClick("FeedNativeDetailMorePanelClickHandler", 500L)) {
                return;
            }
            if (yl1.n.d(false, 0, 3, null)) {
                shareActionSheet.dismiss();
                this.panelContext.f();
                return;
            }
            Iterator<T> it = this.delegateList.iterator();
            while (it.hasNext()) {
                if (((x) it.next()).c(item, this.panelContext, shareActionSheet)) {
                    this.panelContext.f();
                    return;
                }
            }
            x b16 = b(item);
            if (b16 == null) {
                QLog.e("FeedNativeDetailMorePanelClickHandler", 1, "action=" + item.action + ", has no handler!");
                return;
            }
            if (b16.c(item, this.panelContext, shareActionSheet)) {
                this.panelContext.f();
            }
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J,\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002JG\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132-\u0010\u0019\u001a)\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00130\u0016j\u0002`\u0017\u0012\u0004\u0012\u00020\u00060\u0015\u00a2\u0006\u0002\b\u0018H\u0007R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$b;", "", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "scannerResult", "g", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "operationList", "o", "platformList", "p", "Landroid/app/Activity;", "context", "Lvk1/b;", "feed", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "Lkotlin/ExtensionFunctionType;", "paramInit", tl.h.F, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$b$a", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl$b$a */
        /* loaded from: classes13.dex */
        public static final class a implements x {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ScannerResult f220386a;

            a(ScannerResult scannerResult) {
                this.f220386a = scannerResult;
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
            public boolean a(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
                return x.a.b(this, str, panelContext);
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
            public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
                return x.a.c(this, str, panelContext);
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
            public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(panelContext, "panelContext");
                Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
                if (55 != item.action) {
                    return false;
                }
                return new u(this.f220386a).c(item, panelContext, shareActionSheet);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void g(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, ScannerResult scannerResult) {
            a aVar;
            List<x> a16;
            ShareActionSheet.c itemClickListener = launchParam.getItemClickListener();
            if (itemClickListener instanceof a) {
                aVar = (a) itemClickListener;
            } else {
                aVar = null;
            }
            if (aVar != null && (a16 = aVar.a()) != null) {
                a16.add(new a(scannerResult));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(PanelContext this_apply, Object obj) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            new FeedMorePanelUtils.ShareArkInfoInitTask(this_apply).run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Object obj) {
            FeedMorePanelUtils.f220193a.h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.widget.share.ShareActionSheet");
            ((ShareActionSheet) obj).setExtras(BundleKt.bundleOf(TuplesKt.to("no_need_report", Boolean.TRUE)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, Object obj) {
            Intrinsics.checkNotNullParameter(launchParam, "$launchParam");
            Companion companion = FeedMorePanelBusiImpl.INSTANCE;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.widget.share.ShareActionSheet");
            companion.m((ShareActionSheet) obj, launchParam);
        }

        private final void m(final ShareActionSheet shareActionSheet, final com.tencent.mobileqq.guild.feed.morepanel.k launchParam) {
            Object obj;
            final Object n3;
            boolean z16;
            Logger.f235387a.d().i("guild.share.FeedMorePanelBusiImpl", 1, "delayShowQRCode");
            final k.a operationListProvider = launchParam.getOperationListProvider();
            if (operationListProvider == null) {
                return;
            }
            Iterator<T> it = operationListProvider.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ShareActionSheetBuilder.ActionSheetItem) obj).action == 55) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                return;
            }
            vk1.b j3 = launchParam.e().j();
            if (!(j3 instanceof vk1.b) || (n3 = j3.n()) == null) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    FeedMorePanelBusiImpl.Companion.n(n3, launchParam, shareActionSheet, operationListProvider);
                }
            }, 16, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(Object mediaData, com.tencent.mobileqq.guild.feed.morepanel.k launchParam, ShareActionSheet shareActionSheet, k.a operationListProvider) {
            Intrinsics.checkNotNullParameter(mediaData, "$mediaData");
            Intrinsics.checkNotNullParameter(launchParam, "$launchParam");
            Intrinsics.checkNotNullParameter(shareActionSheet, "$shareActionSheet");
            Intrinsics.checkNotNullParameter(operationListProvider, "$operationListProvider");
            Option option = new Option();
            option.setUrl(bm.d(mediaData));
            Logger logger = Logger.f235387a;
            logger.d().i("guild.share.FeedMorePanelBusiImpl", 1, "delayShowQRCode path: " + com.tencent.mobileqq.guild.picload.e.a().c(option));
            ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + com.tencent.mobileqq.guild.picload.e.a().c(option)), (Context) launchParam.e().h(), 1, false);
            logger.d().i("guild.share.FeedMorePanelBusiImpl", 1, "delayShowQRCode scannerResult:" + decodeQQCodeFromFile);
            if (decodeQQCodeFromFile != null && decodeQQCodeFromFile.l()) {
                Companion companion = FeedMorePanelBusiImpl.INSTANCE;
                companion.g(launchParam, decodeQQCodeFromFile);
                companion.p(shareActionSheet, operationListProvider.b(), companion.o(operationListProvider.a()));
                return;
            }
            logger.d().i("guild.share.FeedMorePanelBusiImpl", 1, "delayShowQRCode scannerResult noNeed QRCode");
        }

        private final List<ShareActionSheetBuilder.ActionSheetItem> o(List<? extends ShareActionSheetBuilder.ActionSheetItem> operationList) {
            List<ShareActionSheetBuilder.ActionSheetItem> mutableList;
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) operationList);
            int size = mutableList.size() - 1;
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(55);
            Intrinsics.checkNotNullExpressionValue(build, "build(ActionSheetItem.ACTION_GALLERY_PIC_RECO_QR)");
            mutableList.add(size, build);
            return mutableList;
        }

        private final void p(final ShareActionSheet shareActionSheet, List<? extends ShareActionSheetBuilder.ActionSheetItem> platformList, List<? extends ShareActionSheetBuilder.ActionSheetItem> operationList) {
            shareActionSheet.setActionSheetItems(platformList, operationList);
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                shareActionSheet.updateUI();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedMorePanelBusiImpl.Companion.q(ShareActionSheet.this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(shareActionSheet, "$shareActionSheet");
            shareActionSheet.updateUI();
        }

        @JvmOverloads
        @NotNull
        public final com.tencent.mobileqq.guild.feed.morepanel.k h(@NotNull Activity context, @NotNull vk1.b feed, @NotNull Function2<? super com.tencent.mobileqq.guild.feed.morepanel.k, ? super PanelContext<Activity, vk1.b>, Unit> paramInit) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(paramInit, "paramInit");
            final PanelContext panelContext = new PanelContext(context, feed);
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.e
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    FeedMorePanelBusiImpl.Companion.i(PanelContext.this, obj);
                }
            });
            panelContext.getExtra().putString("big_brother_source_key", "biz_src_jc_qqstation");
            final com.tencent.mobileqq.guild.feed.morepanel.k kVar = new com.tencent.mobileqq.guild.feed.morepanel.k(panelContext);
            paramInit.invoke(kVar, panelContext);
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.f
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    FeedMorePanelBusiImpl.Companion.j(obj);
                }
            });
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.g
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    FeedMorePanelBusiImpl.Companion.k(obj);
                }
            });
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    FeedMorePanelBusiImpl.Companion.l(com.tencent.mobileqq.guild.feed.morepanel.k.this, obj);
                }
            });
            return kVar;
        }

        Companion() {
        }
    }
}
