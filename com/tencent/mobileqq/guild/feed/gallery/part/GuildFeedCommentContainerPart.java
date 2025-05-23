package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalCommentsUpdatedEvent;
import com.tencent.mobileqq.guild.feed.gallery.comment.GuildFeedGalleryCommentFragment;
import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedCommentContainerPart$iCommentContextProvider$2;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedCommentContainerPart$messageDelegate$2;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import hk1.a;
import java.io.Serializable;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\n*\u0002;A\b&\u0018\u0000 H2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010(\u001a\u00020\u001c\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001cH&J\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0004H\u0004R\u0017\u0010(\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", ViewStickEventHelper.IS_SHOW, "", "N9", "", "msg", "L9", "J9", "args", "O9", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "newInitBean", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", "E9", "", "action", "handleBroadcastMessage", "getMessage", "", "F9", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "dismissCommentPanel", "d", "I", "H9", "()I", "mBusinessType", "e", "Z", "K9", "()Z", "setCommentPanelShow", "(Z)V", "isCommentPanelShow", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedExternalCommentsUpdatedEvent;", "f", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedExternalCommentsUpdatedEvent;", "lastCommentsUpdatedEvent", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "initBean", "Lgk1/c;", "i", "Lgk1/c;", "iCommentFragmentProvider", "com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$iCommentContextProvider$2$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$iCommentContextProvider$2$a;", "iCommentContextProvider", "com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$messageDelegate$2$a", BdhLogUtil.LogTag.Tag_Conn, "I9", "()Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$messageDelegate$2$a;", "messageDelegate", "<init>", "(I)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildFeedCommentContainerPart extends com.tencent.mobileqq.guild.feed.part.d {

    @NotNull
    private static final HashSet<String> E;

    @NotNull
    private static final HashSet<String> F;

    @NotNull
    private static final HashSet<String> G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy messageDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mBusinessType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isCommentPanelShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedExternalCommentsUpdatedEvent lastCommentsUpdatedEvent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildGalleryCommentPanelParams initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gk1.c iCommentFragmentProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iCommentContextProvider;

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("message_modify_bottom_interact_data");
        hashSet.add("message_comment_panel_height_change_even");
        hashSet.add("message_comment_panel_start_open_even");
        hashSet.add("message_comment_panel_close_event");
        hashSet.add("message_on_comment_content_change");
        E = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("message_get_comment_cache_recycled_info");
        hashSet2.add("message_get_feed_position_event");
        F = hashSet2;
        G = new HashSet<>();
    }

    public GuildFeedCommentContainerPart(int i3) {
        Lazy lazy;
        Lazy lazy2;
        this.mBusinessType = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedCommentContainerPart$iCommentContextProvider$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedCommentContainerPart$iCommentContextProvider$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$iCommentContextProvider$2$a", "Lgk1/b;", "Lwk1/i;", "a", "()Lwk1/i;", "msgDelegate", "", "getBusinessType", "()I", "businessType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements gk1.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildFeedCommentContainerPart f219638a;

                a(GuildFeedCommentContainerPart guildFeedCommentContainerPart) {
                    this.f219638a = guildFeedCommentContainerPart;
                }

                @Override // gk1.b
                @NotNull
                public wk1.i a() {
                    GuildFeedCommentContainerPart$messageDelegate$2.a I9;
                    I9 = this.f219638a.I9();
                    return I9;
                }

                @Override // gk1.b
                public int getBusinessType() {
                    return this.f219638a.getMBusinessType();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedCommentContainerPart.this);
            }
        });
        this.iCommentContextProvider = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedCommentContainerPart$messageDelegate$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedCommentContainerPart$messageDelegate$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart$messageDelegate$2$a", "Lwk1/i;", "", "action", "", "msg", "", "lh", "I2", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.i {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedCommentContainerPart f219639d;

                a(GuildFeedCommentContainerPart guildFeedCommentContainerPart) {
                    this.f219639d = guildFeedCommentContainerPart;
                }

                @Override // wk1.i
                @Nullable
                public Object I2(@NotNull String action, @Nullable Object msg2) {
                    HashSet hashSet;
                    Object broadcastGetMessage;
                    Intrinsics.checkNotNullParameter(action, "action");
                    hashSet = GuildFeedCommentContainerPart.F;
                    if (hashSet.contains(action) && (broadcastGetMessage = this.f219639d.broadcastGetMessage(action, msg2)) != null) {
                        return broadcastGetMessage;
                    }
                    return null;
                }

                @Override // wk1.i
                public void lh(@NotNull String action, @Nullable Object msg2) {
                    HashSet hashSet;
                    Intrinsics.checkNotNullParameter(action, "action");
                    hashSet = GuildFeedCommentContainerPart.E;
                    if (hashSet.contains(action)) {
                        this.f219639d.broadcastMessage(action, msg2);
                    }
                    switch (action.hashCode()) {
                        case -768227392:
                            if (action.equals("message_comment_panel_close_event")) {
                                this.f219639d.N9(false);
                                this.f219639d.J9();
                                return;
                            }
                            return;
                        case 1546149375:
                            if (action.equals("message_comment_panel_start_open_even")) {
                                this.f219639d.N9(true);
                                return;
                            }
                            return;
                        case 1893112894:
                            if (action.equals("message_on_comment_content_change")) {
                                this.f219639d.L9(msg2);
                                return;
                            }
                            return;
                        case 1994817324:
                            action.equals("message_modify_bottom_interact_data");
                            return;
                        default:
                            return;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedCommentContainerPart.this);
            }
        });
        this.messageDelegate = lazy2;
    }

    private final GuildFeedCommentContainerPart$iCommentContextProvider$2.a G9() {
        return (GuildFeedCommentContainerPart$iCommentContextProvider$2.a) this.iCommentContextProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedCommentContainerPart$messageDelegate$2.a I9() {
        return (GuildFeedCommentContainerPart$messageDelegate$2.a) this.messageDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        GuildFeedExternalCommentsUpdatedEvent guildFeedExternalCommentsUpdatedEvent = this.lastCommentsUpdatedEvent;
        if (guildFeedExternalCommentsUpdatedEvent != null) {
            bl.c().b(guildFeedExternalCommentsUpdatedEvent, true);
        }
        this.lastCommentsUpdatedEvent = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(Object msg2) {
        GuildFeedExternalCommentsUpdatedEvent guildFeedExternalCommentsUpdatedEvent;
        if (msg2 instanceof GuildFeedExternalCommentsUpdatedEvent) {
            guildFeedExternalCommentsUpdatedEvent = (GuildFeedExternalCommentsUpdatedEvent) msg2;
        } else {
            guildFeedExternalCommentsUpdatedEvent = null;
        }
        if (guildFeedExternalCommentsUpdatedEvent != null) {
            this.lastCommentsUpdatedEvent = guildFeedExternalCommentsUpdatedEvent;
        }
    }

    private final boolean M9(GuildGalleryCommentPanelParams newInitBean) {
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams;
        if (this.iCommentFragmentProvider != null && (guildGalleryCommentPanelParams = this.initBean) != null) {
            Intrinsics.checkNotNull(guildGalleryCommentPanelParams);
            if (Intrinsics.areEqual(guildGalleryCommentPanelParams.getFeedId(), newInitBean.getFeedId())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(boolean isShow) {
        this.isCommentPanelShow = isShow;
    }

    private final void O9(Object args) {
        if (!(args instanceof GuildFeedGalleryMessage.CommentPanelShowArgs)) {
            return;
        }
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = (GuildFeedGalleryMessage.CommentPanelShowArgs) args;
        GuildGalleryCommentPanelParams initBean = commentPanelShowArgs.getInitBean();
        QLog.i("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "showCommentPanel args:" + args);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentTransaction beginTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "context as FragmentActiv\u2026anager.beginTransaction()");
        Fragment fragment = null;
        if (!M9(initBean) && !commentPanelShowArgs.getReopen()) {
            gk1.c cVar = this.iCommentFragmentProvider;
            if (cVar != null) {
                fragment = cVar.getFragment();
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("init_param", (Serializable) args);
                fragment.setArguments(bundle);
            }
            gk1.c cVar2 = this.iCommentFragmentProvider;
            if (cVar2 != null) {
                cVar2.lh("message_on_comment_panel_show", new a.ShowCommentPanelArgs(false));
                return;
            }
            return;
        }
        gk1.c cVar3 = this.iCommentFragmentProvider;
        if (cVar3 != null) {
            cVar3.lh("message_on_comment_panel_pre_destroy", null);
        }
        this.initBean = initBean;
        GuildFeedGalleryCommentFragment.Companion companion = GuildFeedGalleryCommentFragment.INSTANCE;
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("init_param", (Serializable) args);
        Unit unit = Unit.INSTANCE;
        this.iCommentFragmentProvider = companion.a(bundle2, G9());
        int F9 = F9();
        gk1.c cVar4 = this.iCommentFragmentProvider;
        Intrinsics.checkNotNull(cVar4);
        beginTransaction.replace(F9, cVar4.getFragment(), "GuildFeedCommentFragment");
        beginTransaction.commitAllowingStateLoss();
    }

    public final boolean E9() {
        Fragment fragment;
        gk1.c cVar = this.iCommentFragmentProvider;
        QPublicBaseFragment qPublicBaseFragment = null;
        if (cVar != null) {
            fragment = cVar.getFragment();
        } else {
            fragment = null;
        }
        if (fragment instanceof QPublicBaseFragment) {
            qPublicBaseFragment = (QPublicBaseFragment) fragment;
        }
        if (qPublicBaseFragment == null || !qPublicBaseFragment.onBackEvent()) {
            return false;
        }
        return true;
    }

    public abstract int F9();

    /* renamed from: H9, reason: from getter */
    public final int getMBusinessType() {
        return this.mBusinessType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K9, reason: from getter */
    public final boolean getIsCommentPanelShow() {
        return this.isCommentPanelShow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dismissCommentPanel() {
        QLog.i("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "dismissCommentPanel");
        gk1.c cVar = this.iCommentFragmentProvider;
        if (cVar != null) {
            cVar.lh("message_on_comment_panel_dismiss", null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        gk1.c cVar;
        if (action != null && G.contains(action) && (cVar = this.iCommentFragmentProvider) != null) {
            cVar.lh(action, args);
        }
        if (Intrinsics.areEqual(action, "message_on_comment_panel_show")) {
            O9(args);
        } else if (Intrinsics.areEqual(action, "message_on_comment_panel_dismiss")) {
            dismissCommentPanel();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Fragment fragment;
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
        gk1.c cVar = this.iCommentFragmentProvider;
        if (cVar != null && (fragment = cVar.getFragment()) != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QLog.w("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "[onPartCreate]");
        PartIOCKt.registerIoc(this, new gk1.a(this), xj1.a.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        QLog.w("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "[onPartDestroy]");
        PartIOCKt.unregisterIoc(this, xj1.a.class);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        QLog.w("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "[onPartPause]");
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QLog.w("Guild_Feed_GAL_GuildFeedCommentContainerPart", 1, "[onPartResume]");
    }
}
