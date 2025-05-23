package com.tencent.qqnt.emotion.emoreply;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.emoreply.n;
import com.tencent.qqnt.kernel.nativeinterface.EmojiLikesUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u0001:\u0002MNB\u001f\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDetailDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "Mh", "", "Ch", "Dh", "Fh", "Gh", "Eh", "localEmojiId", "emojiType", "", "cookie", "Jh", "Ih", "hideSoftInput", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "getTheme", "onResume", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/aio/emoreply/f;", "E", "Lcom/tencent/qqnt/aio/emoreply/f;", "detailData", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "aioHeader", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "likesListView", "Lcom/tencent/qqnt/emotion/emoreply/n;", "I", "Lcom/tencent/qqnt/emotion/emoreply/n;", "topTabAdapter", "Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter;", "J", "Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter;", "likesListAdapter", "K", "topTabView", "L", "tabClickPosition", "M", "Ljava/lang/String;", "", "N", "Z", "isFirstPage", "Lcom/tencent/qqnt/emotion/emoreply/l;", "P", "Lcom/tencent/qqnt/emotion/emoreply/l;", "mTabOnClickListener", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/aio/emoreply/f;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AIOEmoReplyDetailDialog extends BottomSheetDialogFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.emoreply.f detailData;

    /* renamed from: F, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView aioHeader;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView likesListView;

    /* renamed from: I, reason: from kotlin metadata */
    private n topTabAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private LikesListAdapter likesListAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private RecyclerView topTabView;

    /* renamed from: L, reason: from kotlin metadata */
    private int tabClickPosition;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String cookie;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFirstPage;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final l mTabOnClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDetailDialog$a;", "", "", "CLICK_POS", "Ljava/lang/String;", "EM_BAS_EMOTICON_RESPONSE_DETAILS_PANEL", "REPLY_UIN", "TAG", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDetailDialog$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDetailDialog$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "mLeftSpace", "e", "mStartAndEndSpace", "<init>", "(II)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mLeftSpace;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int mStartAndEndSpace;

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mLeftSpace = i3;
                this.mStartAndEndSpace = i16;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildPosition(view) != 0) {
                outRect.left = this.mLeftSpace;
            } else {
                outRect.left = this.mStartAndEndSpace;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            Intrinsics.checkNotNull(adapter);
            if (adapter.getItemCount() - 1 == parent.getChildAdapterPosition(view)) {
                outRect.right = this.mStartAndEndSpace;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/emotion/emoreply/AIOEmoReplyDetailDialog$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "mLastVisibleItem", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mLastVisibleItem;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f356237f;

        c(LinearLayoutManager linearLayoutManager) {
            this.f356237f = linearLayoutManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDetailDialog.this, (Object) linearLayoutManager);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0) {
                return;
            }
            int i3 = this.mLastVisibleItem + 1;
            LikesListAdapter likesListAdapter = AIOEmoReplyDetailDialog.this.likesListAdapter;
            LikesListAdapter likesListAdapter2 = null;
            if (likesListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                likesListAdapter = null;
            }
            if (i3 == likesListAdapter.getItemCount()) {
                LikesListAdapter likesListAdapter3 = AIOEmoReplyDetailDialog.this.likesListAdapter;
                if (likesListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    likesListAdapter3 = null;
                }
                if (likesListAdapter3.n0()) {
                    n nVar = AIOEmoReplyDetailDialog.this.topTabAdapter;
                    if (nVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
                        nVar = null;
                    }
                    if (nVar.k0().size() > AIOEmoReplyDetailDialog.this.tabClickPosition) {
                        n nVar2 = AIOEmoReplyDetailDialog.this.topTabAdapter;
                        if (nVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
                            nVar2 = null;
                        }
                        n.b bVar = nVar2.k0().get(AIOEmoReplyDetailDialog.this.tabClickPosition);
                        AIOEmoReplyDetailDialog.this.isFirstPage = false;
                        AIOEmoReplyDetailDialog.this.Jh(bVar.b(), bVar.c(), AIOEmoReplyDetailDialog.this.cookie);
                    }
                    LikesListAdapter likesListAdapter4 = AIOEmoReplyDetailDialog.this.likesListAdapter;
                    if (likesListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    } else {
                        likesListAdapter2 = likesListAdapter4;
                    }
                    likesListAdapter2.q0(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            this.mLastVisibleItem = this.f356237f.findLastVisibleItemPosition();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/emotion/emoreply/AIOEmoReplyDetailDialog$d", "Lcom/tencent/qqnt/emotion/emoreply/l;", "", "position", "emojiId", "emojiType", "", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements l {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDetailDialog.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.emoreply.l
        public void a(int position, int emojiId, int emojiType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOEmoReplyDetailDialog.this.tabClickPosition = position;
                LikesListAdapter likesListAdapter = AIOEmoReplyDetailDialog.this.likesListAdapter;
                LikesListAdapter likesListAdapter2 = null;
                if (likesListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    likesListAdapter = null;
                }
                likesListAdapter.s0(new ArrayList(), true);
                AIOEmoReplyDetailDialog.this.isFirstPage = true;
                LikesListAdapter likesListAdapter3 = AIOEmoReplyDetailDialog.this.likesListAdapter;
                if (likesListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    likesListAdapter3 = null;
                }
                likesListAdapter3.r0(true);
                LikesListAdapter likesListAdapter4 = AIOEmoReplyDetailDialog.this.likesListAdapter;
                if (likesListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                } else {
                    likesListAdapter2 = likesListAdapter4;
                }
                likesListAdapter2.q0(false);
                AIOEmoReplyDetailDialog.this.cookie = "";
                AIOEmoReplyDetailDialog aIOEmoReplyDetailDialog = AIOEmoReplyDetailDialog.this;
                aIOEmoReplyDetailDialog.Jh(emojiId, emojiType, aIOEmoReplyDetailDialog.cookie);
                int convertToServer = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(emojiId, emojiType);
                HashMap hashMap = new HashMap();
                hashMap.put("touin", Long.valueOf(AIOEmoReplyDetailDialog.this.msgRecord.senderUin));
                hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, String.valueOf(convertToServer));
                com.tencent.mobileqq.aio.utils.b.q("em_bas_emoticon_response_details_panel", hashMap);
                hashMap.put("click_pos", "1");
                com.tencent.mobileqq.aio.utils.b.l("em_bas_emoticon_response_details_panel", hashMap);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Integer.valueOf(emojiId), Integer.valueOf(emojiType));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoReplyDetailDialog(@NotNull Context mContext, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.aio.emoreply.f detailData) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, msgRecord, detailData);
            return;
        }
        this.mContext = mContext;
        this.msgRecord = msgRecord;
        this.detailData = detailData;
        this.cookie = "";
        this.isFirstPage = true;
        this.mTabOnClickListener = new d();
        hideSoftInput();
    }

    private final int Ch() {
        int a16 = x.a(483.0f);
        if (getContext() != null) {
            return (int) (r1.getResources().getDisplayMetrics().heightPixels * 0.75d);
        }
        return a16;
    }

    private final void Dh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    private final void Eh() {
        this.likesListAdapter = new LikesListAdapter(this.mContext, this.detailData, this.msgRecord.senderUin, new Function0<Unit>() { // from class: com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDetailDialog$initLikesListView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDetailDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AIOEmoReplyDetailDialog.this.dismiss();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.likesListView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.likesListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListView");
            recyclerView3 = null;
        }
        LikesListAdapter likesListAdapter = this.likesListAdapter;
        if (likesListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
            likesListAdapter = null;
        }
        recyclerView3.setAdapter(likesListAdapter);
        RecyclerView recyclerView4 = this.likesListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addOnScrollListener(new c(linearLayoutManager));
    }

    private final void Fh() {
        n nVar = this.topTabAdapter;
        n nVar2 = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
            nVar = null;
        }
        if (nVar.getItemCount() <= this.detailData.b()) {
            return;
        }
        int b16 = this.detailData.b();
        RecyclerView recyclerView = this.topTabView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(b16);
        n nVar3 = this.topTabAdapter;
        if (nVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
        } else {
            nVar2 = nVar3;
        }
        nVar2.n0(b16);
    }

    private final void Gh() {
        View view = this.mRootView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f164202sk0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.aio_tab_top_list)");
        this.topTabView = (RecyclerView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.sil);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.aio_likes_list)");
        this.likesListView = (RecyclerView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.sie);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.aio_header)");
        this.aioHeader = (ImageView) findViewById3;
        if (AccessibilityUtil.j(getContext())) {
            ImageView imageView2 = this.aioHeader;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioHeader");
                imageView2 = null;
            }
            AccessibilityUtil.p(imageView2, HardCodeUtil.qqStr(R.string.f170202in));
            ImageView imageView3 = this.aioHeader;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioHeader");
            } else {
                imageView = imageView3;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.emoreply.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AIOEmoReplyDetailDialog.Hh(AIOEmoReplyDetailDialog.this, view4);
                }
            });
            AccessibilityUtil.n(getView(), false);
        }
        Ih();
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(AIOEmoReplyDetailDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ih() {
        this.topTabAdapter = new n();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.topTabView;
        n nVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.topTabView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabView");
            recyclerView2 = null;
        }
        n nVar2 = this.topTabAdapter;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
            nVar2 = null;
        }
        recyclerView2.setAdapter(nVar2);
        RecyclerView recyclerView3 = this.topTabView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b(x.a(4.0f), x.a(16.0f)));
        n nVar3 = this.topTabAdapter;
        if (nVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
            nVar3 = null;
        }
        nVar3.p0(this.mTabOnClickListener);
        RecyclerView recyclerView4 = this.topTabView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabView");
            recyclerView4 = null;
        }
        recyclerView4.setNestedScrollingEnabled(false);
        n nVar4 = this.topTabAdapter;
        if (nVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
            nVar4 = null;
        }
        n nVar5 = this.topTabAdapter;
        if (nVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTabAdapter");
        } else {
            nVar = nVar5;
        }
        nVar4.q0(nVar.m0(this.detailData.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(int localEmojiId, int emojiType, String cookie) {
        QLog.d("AIOEmoReplyDetailDialog", 2, "sendMsg2GetLikes: localEmojiId:" + localEmojiId + " emojiType:" + emojiType + " cookie:" + cookie);
        int convertToServer = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(localEmojiId, emojiType);
        if (convertToServer < 0) {
            return;
        }
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgEmojiLikesList(i.a(this.msgRecord), this.msgRecord.msgSeq, String.valueOf(convertToServer), emojiType, cookie, false, 20, new IGetMsgEmojiLikesListCallback() { // from class: com.tencent.qqnt.emotion.emoreply.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback
            public final void onGetMsgEmojiLikesList(int i3, String str, ArrayList arrayList, String str2, boolean z16, boolean z17) {
                AIOEmoReplyDetailDialog.Kh(AIOEmoReplyDetailDialog.this, i3, str, arrayList, str2, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(final AIOEmoReplyDetailDialog this$0, final int i3, final String str, final ArrayList arrayList, final String str2, final boolean z16, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AIOEmoReplyDetailDialog", 2, "sendMsg2GetLikes: result:" + i3 + " errMsg:" + str + " nextCookie:" + str2 + " isLastPage:" + z16 + " isFirstPage:" + z17 + " emojiLikesList:" + arrayList.size());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.emotion.emoreply.d
            @Override // java.lang.Runnable
            public final void run() {
                AIOEmoReplyDetailDialog.Lh(i3, this$0, str2, z16, arrayList, z17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(int i3, AIOEmoReplyDetailDialog this$0, String nextCookie, boolean z16, ArrayList emojiLikesList, boolean z17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LikesListAdapter likesListAdapter = null;
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(nextCookie, "nextCookie");
            this$0.cookie = nextCookie;
            if (z16) {
                LikesListAdapter likesListAdapter2 = this$0.likesListAdapter;
                if (likesListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    likesListAdapter2 = null;
                }
                likesListAdapter2.r0(false);
            } else {
                LikesListAdapter likesListAdapter3 = this$0.likesListAdapter;
                if (likesListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
                    likesListAdapter3 = null;
                }
                likesListAdapter3.q0(true);
            }
            LikesListAdapter likesListAdapter4 = this$0.likesListAdapter;
            if (likesListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
            } else {
                likesListAdapter = likesListAdapter4;
            }
            Intrinsics.checkNotNullExpressionValue(emojiLikesList, "emojiLikesList");
            ArrayList arrayList = new ArrayList();
            Iterator it = emojiLikesList.iterator();
            while (it.hasNext()) {
                EmojiLikesUserInfo emojiLikesUserInfo = (EmojiLikesUserInfo) it.next();
                long j3 = emojiLikesUserInfo.tinyId;
                String str2 = emojiLikesUserInfo.nickName;
                Intrinsics.checkNotNullExpressionValue(str2, "it.nickName");
                String str3 = emojiLikesUserInfo.headUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "it.headUrl");
                arrayList.add(new j(false, j3, str2, str3));
            }
            likesListAdapter.s0(arrayList, z17);
            return;
        }
        QLog.d("AIOEmoReplyDetailDialog", 4, "sendMsg2GetLikes Err : " + str);
        QQToast.makeText(this$0.mContext, 1, HardCodeUtil.qqStr(R.string.ypt), 0).show();
        LikesListAdapter likesListAdapter5 = this$0.likesListAdapter;
        if (likesListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
            likesListAdapter5 = null;
        }
        likesListAdapter5.r0(false);
        LikesListAdapter likesListAdapter6 = this$0.likesListAdapter;
        if (likesListAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likesListAdapter");
        } else {
            likesListAdapter = likesListAdapter6;
        }
        likesListAdapter.notifyDataSetChanged();
    }

    private final void Mh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.emotion.emoreply.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AIOEmoReplyDetailDialog.Nh(AIOEmoReplyDetailDialog.this, dialogInterface);
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
    public static final void Nh(AIOEmoReplyDetailDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
    }

    private final void hideSoftInput() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setSoftInputMode(2);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.style.a66;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.dut, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026detail, container, false)");
            this.mRootView = inflate;
            QLog.d("AIOEmoReplyDetailDialog", 4, "onCreateView");
            Gh();
            view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        Mh();
        Fh();
    }
}
