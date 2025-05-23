package com.tencent.mobileqq.guild.feed.gallery.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentInputPart;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentPanelPart;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentSpeakPermissionPart;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.h;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.s;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.t;
import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.i;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import gk1.b;
import gk1.c;
import hk1.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/GuildFeedGalleryCommentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lgk1/c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", "ph", "Landroid/os/Bundle;", "outState", "", "removeFragmentState", "rh", "", "getContentLayoutId", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "Lcom/tencent/biz/richframework/part/PartManager;", "getPartManager", "Landroid/view/View;", "contentView", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "args", "setArguments", "onCreate", "onFinish", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/fragment/app/Fragment;", "getFragment", "key", "", "msg", "lh", "action", "I2", "onSaveInstanceState", "Lgk1/b;", BdhLogUtil.LogTag.Tag_Conn, "Lgk1/b;", "getContextProvider", "()Lgk1/b;", "qh", "(Lgk1/b;)V", "contextProvider", "<init>", "()V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentFragment extends QPublicBaseFragment implements c {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b contextProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/GuildFeedGalleryCommentFragment$a;", "Lcom/tencent/biz/richframework/part/PartManager;", "", "Lcom/tencent/biz/richframework/part/Part;", "parts", "", "registerPart", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "showArgs", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "fragment", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends PartManager {
        public a(@Nullable IPartHost iPartHost, @Nullable View view) {
            super(iPartHost, view);
        }

        public final void a(@NotNull GuildFeedGalleryMessage.CommentPanelShowArgs showArgs) {
            Intrinsics.checkNotNullParameter(showArgs, "showArgs");
            for (Part part : this.mParts.values()) {
                if (part instanceof com.tencent.mobileqq.guild.feed.gallery.comment.part.a) {
                    ((com.tencent.mobileqq.guild.feed.gallery.comment.part.a) part).C9(showArgs);
                }
            }
        }

        @Override // com.tencent.biz.richframework.part.PartManager
        public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onPartCreate(activity, savedInstanceState);
            broadcastMessage("message_on_comment_panel_show", new a.ShowCommentPanelArgs(true));
        }

        @Override // com.tencent.biz.richframework.part.PartManager
        public void registerPart(@NotNull List<? extends Part> parts) {
            Fragment fragment;
            Object obj;
            Bundle arguments;
            Intrinsics.checkNotNullParameter(parts, "parts");
            super.registerPart(parts);
            Object obj2 = this.mPartHost;
            GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = null;
            if (obj2 instanceof Fragment) {
                fragment = (Fragment) obj2;
            } else {
                fragment = null;
            }
            if (fragment != null && (arguments = fragment.getArguments()) != null) {
                obj = arguments.getSerializable("init_param");
            } else {
                obj = null;
            }
            if (obj instanceof GuildFeedGalleryMessage.CommentPanelShowArgs) {
                commentPanelShowArgs = (GuildFeedGalleryMessage.CommentPanelShowArgs) obj;
            }
            if (commentPanelShowArgs != null) {
                a(commentPanelShowArgs);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/GuildFeedGalleryCommentFragment$b;", "", "Landroid/os/Bundle;", "bundle", "Lgk1/b;", "contextProvider", "Lgk1/c;", "a", "", "INIT_PARAM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.comment.GuildFeedGalleryCommentFragment$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a(@NotNull Bundle bundle, @Nullable b contextProvider) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            GuildFeedGalleryCommentFragment guildFeedGalleryCommentFragment = new GuildFeedGalleryCommentFragment();
            guildFeedGalleryCommentFragment.setArguments(bundle);
            guildFeedGalleryCommentFragment.qh(contextProvider);
            return guildFeedGalleryCommentFragment;
        }

        Companion() {
        }
    }

    private final CommentFunctionPart ph() {
        Serializable serializable;
        ik1.a aVar = ik1.a.f407902a;
        Bundle arguments = getArguments();
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("init_param");
        } else {
            serializable = null;
        }
        if (serializable instanceof GuildFeedGalleryMessage.CommentPanelShowArgs) {
            commentPanelShowArgs = (GuildFeedGalleryMessage.CommentPanelShowArgs) serializable;
        }
        return new CommentFunctionPart(aVar.a(commentPanelShowArgs));
    }

    private final void removeFragmentState(Bundle outState) {
        if (outState != null) {
            outState.remove("android:viewHierarchyState");
            outState.remove("android:fragments");
            outState.remove("android:support:fragments");
        }
    }

    private final void rh() {
        int i3;
        Map mapOf;
        b bVar = this.contextProvider;
        if (bVar != null) {
            i3 = bVar.getBusinessType();
        } else {
            i3 = 21;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_feed_card_page_source", Integer.valueOf(i3)));
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getView(), "pg_sgrp_forum_comment_float");
        VideoReport.setPageParams(getView(), new PageParams((Map<String, ?>) mapOf));
    }

    @Override // wk1.i
    @Nullable
    public Object I2(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            return partManager.getMessageFromPart(action, msg2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GuildFeedGalleryCommentPanelPart(this.contextProvider));
        arrayList.add(new h(this.contextProvider));
        arrayList.add(new t());
        arrayList.add(new i());
        arrayList.add(new GuildFeedGalleryCommentInputPart());
        arrayList.add(ph());
        arrayList.add(new s(this.contextProvider));
        arrayList.add(new GuildFeedGalleryCommentSpeakPermissionPart(this.contextProvider));
        arrayList.add(new f());
        arrayList.add(new InputSendPart());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f168073eo0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GAL_GuildFeedGalleryCommentFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @Nullable
    public PartManager getPartManager() {
        if (this.mPartManager == null) {
            this.mPartManager = new a(this, getView());
        }
        return this.mPartManager;
    }

    @Override // wk1.i
    public void lh(@NotNull String key, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(key, "key");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.broadcastMessage(key, msg2);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentFragment", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryCommentFragment", 1, "[onCreate] " + this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PartFragmentIOCKt.unregisterIoc(this, wk1.i.class);
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryCommentFragment", 1, "[onDestroy] " + this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryCommentFragment", 1, "[onFinish] " + this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        rh();
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryCommentFragment", 1, "[onResume] " + this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        removeFragmentState(outState);
        removeFragmentState(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        PartFragmentIOCKt.registerIoc(this, this, wk1.i.class);
    }

    public final void qh(@Nullable b bVar) {
        this.contextProvider = bVar;
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(@Nullable Bundle args) {
        a aVar;
        Serializable serializable;
        super.setArguments(args);
        PartManager partManager = this.mPartManager;
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = null;
        if (partManager instanceof a) {
            aVar = (a) partManager;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (args != null) {
                serializable = args.getSerializable("init_param");
            } else {
                serializable = null;
            }
            if (serializable instanceof GuildFeedGalleryMessage.CommentPanelShowArgs) {
                commentPanelShowArgs = (GuildFeedGalleryMessage.CommentPanelShowArgs) serializable;
            }
            if (commentPanelShowArgs != null) {
                aVar.a(commentPanelShowArgs);
            }
        }
    }

    @Override // gk1.c
    @NotNull
    public Fragment getFragment() {
        return this;
    }
}
