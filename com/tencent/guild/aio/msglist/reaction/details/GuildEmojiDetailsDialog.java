package com.tencent.guild.aio.msglist.reaction.details;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.reaction.details.g;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.EmojiLikesUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\u0002HIB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00102R\u0016\u0010=\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/GuildEmojiDetailsDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initView", "Hh", "Fh", "", "serverId", "emojiType", "", "Dh", "Lh", "Ch", "Eh", "localEmojiId", "", "cookie", "Ih", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", "mApp", "D", "Landroid/view/View;", "mRootView", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "mLikesListView", "Lcom/tencent/guild/aio/msglist/reaction/details/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/msglist/reaction/details/g;", "mTopTabAdapter", "Lcom/tencent/guild/aio/msglist/reaction/details/e;", "G", "Lcom/tencent/guild/aio/msglist/reaction/details/e;", "mLikesListAdapter", "H", "mTopTabView", "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;", "I", "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;", "mEmojiDetailsData", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mMsg", "K", "mTabClickPosition", "L", "Ljava/lang/String;", "mCookie", "M", "Z", "isFirstPage", "Lcom/tencent/guild/aio/msglist/reaction/utils/a;", "N", "Lcom/tencent/guild/aio/msglist/reaction/utils/a;", "mTabOnClickListener", "<init>", "()V", "P", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildEmojiDetailsDialog extends BottomSheetDialogFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AppInterface mApp;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView mLikesListView;

    /* renamed from: F, reason: from kotlin metadata */
    private g mTopTabAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private e mLikesListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mTopTabView;

    /* renamed from: I, reason: from kotlin metadata */
    private GuildEmojiDetailsData mEmojiDetailsData;

    /* renamed from: J, reason: from kotlin metadata */
    private MsgRecord mMsg;

    /* renamed from: K, reason: from kotlin metadata */
    private int mTabClickPosition;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String mCookie = "";

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstPage = true;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.reaction.utils.a mTabOnClickListener = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/GuildEmojiDetailsDialog$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;", "detailsData", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.reaction.details.GuildEmojiDetailsDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentActivity activity, @NotNull GuildEmojiDetailsData detailsData, @NotNull MsgRecord msg2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(detailsData, "detailsData");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (detailsData.b() != null && detailsData.b().size() != 0) {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                GuildEmojiDetailsDialog guildEmojiDetailsDialog = new GuildEmojiDetailsDialog();
                guildEmojiDetailsDialog.mMsg = msg2;
                guildEmojiDetailsDialog.mEmojiDetailsData = detailsData;
                supportFragmentManager.beginTransaction().add(guildEmojiDetailsDialog, "GuildEmojiDetailsDialog").commitAllowingStateLoss();
                return;
            }
            QLog.d("GuildEmojiDetailsDialog", 1, "openEmojiDetails fail: detailsData == null or detailsData.getEmojiList() error");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/GuildEmojiDetailsDialog$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "mLeftSpace", "e", "mStartAndEndSpace", "<init>", "(II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mLeftSpace;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int mStartAndEndSpace;

        public b(int i3, int i16) {
            this.mLeftSpace = i3;
            this.mStartAndEndSpace = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildPosition(view) != 0) {
                outRect.left = this.mLeftSpace;
            } else {
                outRect.left = this.mStartAndEndSpace;
            }
            Intrinsics.checkNotNull(parent.getAdapter());
            if (r5.getNUM_BACKGOURND_ICON() - 1 == parent.getChildAdapterPosition(view)) {
                outRect.right = this.mStartAndEndSpace;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/msglist/reaction/details/GuildEmojiDetailsDialog$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "mLastVisibleItem", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mLastVisibleItem;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f111816f;

        c(LinearLayoutManager linearLayoutManager) {
            this.f111816f = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0) {
                return;
            }
            int i3 = this.mLastVisibleItem + 1;
            e eVar = GuildEmojiDetailsDialog.this.mLikesListAdapter;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                eVar = null;
            }
            if (i3 == eVar.getNUM_BACKGOURND_ICON()) {
                e eVar3 = GuildEmojiDetailsDialog.this.mLikesListAdapter;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                    eVar3 = null;
                }
                if (eVar3.getIsCanRefresh()) {
                    g gVar = GuildEmojiDetailsDialog.this.mTopTabAdapter;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
                        gVar = null;
                    }
                    if (gVar.k0().size() > GuildEmojiDetailsDialog.this.mTabClickPosition) {
                        g gVar2 = GuildEmojiDetailsDialog.this.mTopTabAdapter;
                        if (gVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
                            gVar2 = null;
                        }
                        g.b bVar = gVar2.k0().get(GuildEmojiDetailsDialog.this.mTabClickPosition);
                        GuildEmojiDetailsDialog.this.isFirstPage = false;
                        GuildEmojiDetailsDialog.this.Ih(bVar.getEmojiId(), bVar.getEmojiType(), GuildEmojiDetailsDialog.this.mCookie);
                    }
                    e eVar4 = GuildEmojiDetailsDialog.this.mLikesListAdapter;
                    if (eVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                    } else {
                        eVar2 = eVar4;
                    }
                    eVar2.p0(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            this.mLastVisibleItem = this.f111816f.findLastVisibleItemPosition();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/reaction/details/GuildEmojiDetailsDialog$d", "Lcom/tencent/guild/aio/msglist/reaction/utils/a;", "", "position", "emojiId", "emojiType", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.guild.aio.msglist.reaction.utils.a {
        d() {
        }

        @Override // com.tencent.guild.aio.msglist.reaction.utils.a
        public void a(int position, int emojiId, int emojiType) {
            GuildEmojiDetailsDialog.this.mTabClickPosition = position;
            e eVar = GuildEmojiDetailsDialog.this.mLikesListAdapter;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                eVar = null;
            }
            eVar.r0(new ArrayList(), true);
            GuildEmojiDetailsDialog.this.isFirstPage = true;
            e eVar3 = GuildEmojiDetailsDialog.this.mLikesListAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                eVar3 = null;
            }
            eVar3.q0(true);
            e eVar4 = GuildEmojiDetailsDialog.this.mLikesListAdapter;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
            } else {
                eVar2 = eVar4;
            }
            eVar2.p0(false);
            GuildEmojiDetailsDialog.this.mCookie = "";
            GuildEmojiDetailsDialog guildEmojiDetailsDialog = GuildEmojiDetailsDialog.this;
            guildEmojiDetailsDialog.Ih(emojiId, emojiType, guildEmojiDetailsDialog.mCookie);
        }
    }

    private final int Ch() {
        return x.a(482.0f);
    }

    private final boolean Dh(int serverId, int emojiType) {
        e eVar = this.mLikesListAdapter;
        g gVar = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
            eVar = null;
        }
        if (eVar.getNUM_BACKGOURND_ICON() > 1) {
            return false;
        }
        g gVar2 = this.mTopTabAdapter;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
        } else {
            gVar = gVar2;
        }
        gVar.o0(serverId, emojiType);
        return true;
    }

    private final void Eh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    private final void Fh() {
        AppInterface appInterface = this.mApp;
        FragmentActivity activity = getActivity();
        GuildEmojiDetailsData guildEmojiDetailsData = this.mEmojiDetailsData;
        RecyclerView recyclerView = null;
        if (guildEmojiDetailsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiDetailsData");
            guildEmojiDetailsData = null;
        }
        this.mLikesListAdapter = new e(appInterface, activity, guildEmojiDetailsData, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reaction.details.GuildEmojiDetailsDialog$initLikesListView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildEmojiDetailsDialog.this.dismiss();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView2 = this.mLikesListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikesListView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.mLikesListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikesListView");
            recyclerView3 = null;
        }
        e eVar = this.mLikesListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
            eVar = null;
        }
        recyclerView3.setAdapter(eVar);
        RecyclerView recyclerView4 = this.mLikesListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikesListView");
        } else {
            recyclerView = recyclerView4;
        }
        recyclerView.addOnScrollListener(new c(linearLayoutManager));
    }

    private final void Gh() {
        g gVar = this.mTopTabAdapter;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
            gVar = null;
        }
        int num_backgournd_icon = gVar.getNUM_BACKGOURND_ICON();
        GuildEmojiDetailsData guildEmojiDetailsData = this.mEmojiDetailsData;
        if (guildEmojiDetailsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiDetailsData");
            guildEmojiDetailsData = null;
        }
        if (num_backgournd_icon <= guildEmojiDetailsData.e()) {
            return;
        }
        GuildEmojiDetailsData guildEmojiDetailsData2 = this.mEmojiDetailsData;
        if (guildEmojiDetailsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiDetailsData");
            guildEmojiDetailsData2 = null;
        }
        int e16 = guildEmojiDetailsData2.e();
        RecyclerView recyclerView = this.mTopTabView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(e16);
        g gVar3 = this.mTopTabAdapter;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
        } else {
            gVar2 = gVar3;
        }
        gVar2.n0(e16);
    }

    private final void Hh() {
        this.mTopTabAdapter = new g();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.mTopTabView;
        GuildEmojiDetailsData guildEmojiDetailsData = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.mTopTabView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabView");
            recyclerView2 = null;
        }
        g gVar = this.mTopTabAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
            gVar = null;
        }
        recyclerView2.setAdapter(gVar);
        RecyclerView recyclerView3 = this.mTopTabView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b(x.a(7.0f), x.a(16.0f)));
        g gVar2 = this.mTopTabAdapter;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
            gVar2 = null;
        }
        gVar2.q0(this.mTabOnClickListener);
        RecyclerView recyclerView4 = this.mTopTabView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabView");
            recyclerView4 = null;
        }
        recyclerView4.setNestedScrollingEnabled(false);
        g gVar3 = this.mTopTabAdapter;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
            gVar3 = null;
        }
        g gVar4 = this.mTopTabAdapter;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
            gVar4 = null;
        }
        GuildEmojiDetailsData guildEmojiDetailsData2 = this.mEmojiDetailsData;
        if (guildEmojiDetailsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiDetailsData");
        } else {
            guildEmojiDetailsData = guildEmojiDetailsData2;
        }
        gVar3.r0(gVar4.m0(guildEmojiDetailsData.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(final int localEmojiId, final int emojiType, String cookie) {
        final int a16 = ReactionUtilsKt.a(localEmojiId, emojiType);
        if (a16 == -1) {
            return;
        }
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        MsgRecord msgRecord = this.mMsg;
        MsgRecord msgRecord2 = null;
        if (msgRecord == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsg");
            msgRecord = null;
        }
        Contact c16 = com.tencent.guild.aio.util.ex.d.c(msgRecord);
        MsgRecord msgRecord3 = this.mMsg;
        if (msgRecord3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsg");
        } else {
            msgRecord2 = msgRecord3;
        }
        iMsgService.getMsgEmojiLikesList(c16, msgRecord2.msgSeq, String.valueOf(a16), emojiType, cookie, false, 30, new IGetMsgEmojiLikesListCallback() { // from class: com.tencent.guild.aio.msglist.reaction.details.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback
            public final void onGetMsgEmojiLikesList(int i3, String str, ArrayList arrayList, String str2, boolean z16, boolean z17) {
                GuildEmojiDetailsDialog.Jh(GuildEmojiDetailsDialog.this, a16, emojiType, localEmojiId, i3, str, arrayList, str2, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(final GuildEmojiDetailsDialog this$0, final int i3, final int i16, final int i17, final int i18, final String str, final ArrayList arrayList, final String str2, final boolean z16, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.msglist.reaction.details.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildEmojiDetailsDialog.Kh(i18, this$0, str2, arrayList, z17, i3, i16, z16, i17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(int i3, GuildEmojiDetailsDialog this$0, String nextCookie, ArrayList emojiLikesList, boolean z16, int i16, int i17, boolean z17, int i18, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(nextCookie, "nextCookie");
            this$0.mCookie = nextCookie;
            e eVar = this$0.mLikesListAdapter;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                eVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(emojiLikesList, "emojiLikesList");
            ArrayList arrayList = new ArrayList();
            Iterator it = emojiLikesList.iterator();
            while (it.hasNext()) {
                EmojiLikesUserInfo emojiLikesUserInfo = (EmojiLikesUserInfo) it.next();
                com.tencent.mobileqq.guild.emoj.a aVar = new com.tencent.mobileqq.guild.emoj.a();
                aVar.f217864b = emojiLikesUserInfo.tinyId;
                aVar.f217866d = emojiLikesUserInfo.headUrl;
                aVar.f217865c = emojiLikesUserInfo.nickName;
                arrayList.add(aVar);
            }
            eVar.r0(arrayList, z16);
            if (this$0.Dh(i16, i17)) {
                return;
            }
            if (z17) {
                e eVar3 = this$0.mLikesListAdapter;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                    eVar3 = null;
                }
                eVar3.q0(false);
                g gVar = this$0.mTopTabAdapter;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopTabAdapter");
                    gVar = null;
                }
                e eVar4 = this$0.mLikesListAdapter;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
                } else {
                    eVar2 = eVar4;
                }
                gVar.s0(i18, i17, eVar2.getNUM_BACKGOURND_ICON() - 1);
                return;
            }
            e eVar5 = this$0.mLikesListAdapter;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikesListAdapter");
            } else {
                eVar2 = eVar5;
            }
            eVar2.p0(true);
            return;
        }
        QLog.d("GuildEmojiDetailsDialog", 4, "sendMsg2GetLikes Err : " + str);
    }

    private final void Lh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.guild.aio.msglist.reaction.details.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GuildEmojiDetailsDialog.Mh(GuildEmojiDetailsDialog.this, dialogInterface);
            }
        });
        int Ch = Ch();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.getLayoutParams().height = Ch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GuildEmojiDetailsDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Eh();
    }

    private final void initView() {
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f918656b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.tab_top_list)");
        this.mTopTabView = (RecyclerView) findViewById;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        View findViewById2 = view2.findViewById(R.id.yi8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.likes_list)");
        this.mLikesListView = (RecyclerView) findViewById2;
        Hh();
        Fh();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.emb, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026dialog, container, false)");
        this.mRootView = inflate;
        QLog.d("GuildEmojiDetailsDialog", 4, "onCreateView");
        initView();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        Lh();
        Gh();
    }
}
