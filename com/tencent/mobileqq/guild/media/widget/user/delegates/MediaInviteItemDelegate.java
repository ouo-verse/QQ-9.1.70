package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.MediaInviteItem;
import tl.h;
import vs1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\u0017\u0012\u0006\u0010#\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u001d\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaInviteItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/e;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaInviteItemDelegate$InviteViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView;", "view", "", "playerColumns", "", "u", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "position", "", "r", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "holder", "", "payloads", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "e", "Ljava/lang/ref/WeakReference;", "fragmentRef", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "f", "weakAdapterRef", h.F, "Z", "mInviteShakeAnimated", "fragment", "adapter", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", "i", "a", "InviteViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaInviteItemDelegate extends BaseMediaItemDelegate<MediaInviteItem, InviteViewHolder> {

    @NotNull
    private static final Lazy<Integer> C;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static boolean f230003m = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Fragment> fragmentRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMediaUserDelegateAdapter> weakAdapterRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mInviteShakeAnimated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaInviteItemDelegate$InviteViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class InviteViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InviteViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaInviteItemDelegate$a;", "", "", "c", "", "sInviteViewHeight$delegate", "Lkotlin/Lazy;", "b", "()I", "sInviteViewHeight", "", "TAG", "Ljava/lang/String;", "USER_TYPE", "", "sSingleColumnInviteCanAnim", "Z", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.user.delegates.MediaInviteItemDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return ((Number) MediaInviteItemDelegate.C.getValue()).intValue();
        }

        public final void c() {
            MediaInviteItemDelegate.f230003m = true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/widget/user/delegates/MediaInviteItemDelegate$b", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$b;", "", NodeProps.ON_CLICK, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildMediaInviteEnhanceView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InviteViewHolder f230007a;

        b(InviteViewHolder inviteViewHolder) {
            this.f230007a = inviteViewHolder;
        }

        @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView.b
        public void onClick() {
            HashMap hashMap = new HashMap();
            hashMap.put("user_type", "1");
            VideoReport.reportEvent("clck", this.f230007a.itemView, hashMap);
            com.tencent.mobileqq.guild.performance.report.e.b("audio_room_invite_button", hashMap, 0, null, 0, null, 60, null);
        }
    }

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.MediaInviteItemDelegate$Companion$sInviteViewHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QQGuildUIUtil.f(200.0f));
            }
        });
        C = lazy;
    }

    public MediaInviteItemDelegate(@NotNull Fragment fragment, @NotNull BaseMediaUserDelegateAdapter adapter) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.fragmentRef = new WeakReference<>(fragment);
        this.weakAdapterRef = new WeakReference<>(adapter);
    }

    private final void u(GuildMediaInviteEnhanceView view, int playerColumns) {
        int l06;
        int i3;
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null) {
            if (playerColumns == 1) {
                l06 = INSTANCE.b();
                i3 = -1;
            } else {
                l06 = baseMediaUserDelegateAdapter.l0();
                i3 = l06;
            }
            view.setWithAndHeight(i3, l06);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaInviteItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MediaInviteItem item, @NotNull InviteViewHolder holder, @NotNull List<Object> payloads) {
        Context context;
        boolean z16;
        boolean z17;
        int i3;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("MediaInviteItemDelegate_enhanceView_bindView");
        super.o(item, holder, payloads);
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null && (holder.itemView instanceof GuildMediaInviteEnhanceView)) {
            int r06 = baseMediaUserDelegateAdapter.r0();
            View view = holder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView");
            u((GuildMediaInviteEnhanceView) view, r06);
            IGProGuildInfo guildInfo = j.a().getGuildInfo();
            IGProChannelInfo channelInfo = j.a().getChannelInfo();
            if (guildInfo != null && channelInfo != null && this.fragmentRef.get() != null) {
                Fragment fragment = this.fragmentRef.get();
                if (fragment != null) {
                    context = fragment.getContext();
                } else {
                    context = null;
                }
                if (context != null) {
                    if (f230003m && holder.getAdapterPosition() <= 1) {
                        IGProChannelInfo channelInfo2 = j.a().getChannelInfo();
                        if (channelInfo2 != null) {
                            i3 = channelInfo2.getChannelMemberMax();
                        } else {
                            i3 = 0;
                        }
                        if (i3 > 1) {
                            z16 = true;
                            if (this.mInviteShakeAnimated && holder.getAdapterPosition() <= 1) {
                                this.mInviteShakeAnimated = true;
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            f230003m = false;
                            View view2 = holder.itemView;
                            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView");
                            GuildMediaInviteEnhanceView guildMediaInviteEnhanceView = (GuildMediaInviteEnhanceView) view2;
                            Fragment fragment2 = this.fragmentRef.get();
                            Intrinsics.checkNotNull(fragment2);
                            Context requireContext = fragment2.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "fragmentRef.get()!!.requireContext()");
                            guildMediaInviteEnhanceView.f(requireContext, guildInfo, channelInfo, r06, z16, z17, new b(holder));
                        }
                    }
                    z16 = false;
                    if (this.mInviteShakeAnimated) {
                    }
                    z17 = false;
                    f230003m = false;
                    View view22 = holder.itemView;
                    Intrinsics.checkNotNull(view22, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView");
                    GuildMediaInviteEnhanceView guildMediaInviteEnhanceView2 = (GuildMediaInviteEnhanceView) view22;
                    Fragment fragment22 = this.fragmentRef.get();
                    Intrinsics.checkNotNull(fragment22);
                    Context requireContext2 = fragment22.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "fragmentRef.get()!!.requireContext()");
                    guildMediaInviteEnhanceView2.f(requireContext2, guildInfo, channelInfo, r06, z16, z17, new b(holder));
                }
            }
        }
        w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public InviteViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        w.b("QGMC.MediaInviteItemDelegate", "MediaInviteItemDelegate.newGuildMediaInviteEnhanceView");
        ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
        e.d dVar = e.d.f443292a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View i3 = viewPoolEngine.i(dVar, context);
        w.a("QGMC.MediaInviteItemDelegate", "MediaInviteItemDelegate.newGuildMediaInviteEnhanceView");
        return new InviteViewHolder(i3);
    }
}
