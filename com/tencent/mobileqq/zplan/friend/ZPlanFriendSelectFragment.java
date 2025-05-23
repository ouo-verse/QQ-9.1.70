package com.tencent.mobileqq.zplan.friend;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.friend.m;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.CharRange;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002}~B\u0007\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010'\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0011H\u0016J&\u0010-\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0013018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010ER\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010HR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010HR\u0016\u0010]\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010LR\u0016\u0010e\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010HR\u0016\u0010q\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010hR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendSelectFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar$a;", "Lcom/tencent/mobileqq/armap/e;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "Landroid/content/Context;", "context", "Ih", "yh", OcrConfig.CHINESE, "initViewModel", "", "selectNum", "Jh", "", "select", "", "uin", "Kh", NodeProps.VISIBLE, "Hh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "letter", "action", "", com.tencent.luggage.wxa.c8.c.G, "p1", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "headPath", "Landroid/graphics/Bitmap;", "head", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "I", "maxSelectNum", "", "D", "Ljava/util/List;", "preselection", "Lcom/tencent/common/app/AppInterface;", "E", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zplan/friend/FriendViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/friend/FriendViewModel;", "friendViewModel", "Lcom/tencent/mobileqq/armap/f;", "G", "Lcom/tencent/mobileqq/armap/f;", "faceDecoder", "H", "Ljava/lang/String;", "meUin", "Lcom/tencent/mobileqq/zplan/friend/c;", "Lcom/tencent/mobileqq/zplan/friend/c;", "meInfo", "J", "Landroid/view/View;", "btnBack", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "titleView", "L", "btnSearch", "M", "btnComplete", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "N", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "indexBar", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "P", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "indexTipsLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "meContainer", BdhLogUtil.LogTag.Tag_Req, "meSelectIndicator", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "meAvatar", "T", "meName", "U", "meProfileImage", "Landroidx/recyclerview/widget/RecyclerView;", "V", "Landroidx/recyclerview/widget/RecyclerView;", "friendListView", "Lcom/tencent/mobileqq/zplan/friend/g;", "W", "Lcom/tencent/mobileqq/zplan/friend/g;", "friendListAdapter", "X", "selectListContainer", "Y", "selectListView", "Lcom/tencent/mobileqq/zplan/friend/m;", "Z", "Lcom/tencent/mobileqq/zplan/friend/m;", "selectListAdapter", "Landroid/app/Dialog;", "a0", "Landroid/app/Dialog;", "progressDialog", "<init>", "()V", "b0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendSelectFragment extends Fragment implements IndexBar.a, com.tencent.mobileqq.armap.e {

    /* renamed from: C, reason: from kotlin metadata */
    private int maxSelectNum = 2;

    /* renamed from: D, reason: from kotlin metadata */
    private List<String> preselection;

    /* renamed from: E, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: F, reason: from kotlin metadata */
    private FriendViewModel friendViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.armap.f faceDecoder;

    /* renamed from: H, reason: from kotlin metadata */
    private String meUin;

    /* renamed from: I, reason: from kotlin metadata */
    private FriendInfo meInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private View btnBack;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: L, reason: from kotlin metadata */
    private View btnSearch;

    /* renamed from: M, reason: from kotlin metadata */
    private View btnComplete;

    /* renamed from: N, reason: from kotlin metadata */
    private IndexBar indexBar;

    /* renamed from: P, reason: from kotlin metadata */
    private IndexBarTipsLayout indexTipsLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private View meContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView meSelectIndicator;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView meAvatar;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView meName;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView meProfileImage;

    /* renamed from: V, reason: from kotlin metadata */
    private RecyclerView friendListView;

    /* renamed from: W, reason: from kotlin metadata */
    private g friendListAdapter;

    /* renamed from: X, reason: from kotlin metadata */
    private View selectListContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private RecyclerView selectListView;

    /* renamed from: Z, reason: from kotlin metadata */
    private m selectListAdapter;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Dialog progressDialog;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendSelectFragment$b;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "target", "", "onMove", "direction", "", "onSwiped", "isItemViewSwipeEnabled", "clearView", "actionState", "onSelectedChanged", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendSelectFragment;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b extends ItemTouchHelper.Callback {
        public b() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            m.a aVar = viewHolder instanceof m.a ? (m.a) viewHolder : null;
            View closeButton = aVar != null ? aVar.getCloseButton() : null;
            if (closeButton == null) {
                return;
            }
            closeButton.setVisibility(0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            FriendViewModel friendViewModel = ZPlanFriendSelectFragment.this.friendViewModel;
            if (friendViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
                friendViewModel = null;
            }
            return friendViewModel.U1(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            m.a aVar = viewHolder instanceof m.a ? (m.a) viewHolder : null;
            View closeButton = aVar != null ? aVar.getCloseButton() : null;
            if (closeButton == null) {
                return;
            }
            closeButton.setVisibility(4);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    public ZPlanFriendSelectFragment() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.preselection = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(ZPlanFriendSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FriendViewModel friendViewModel = this$0.friendViewModel;
        String str = null;
        if (friendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
            friendViewModel = null;
        }
        String str2 = this$0.meUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meUin");
            str2 = null;
        }
        boolean z16 = !friendViewModel.S1(str2);
        String str3 = this$0.meUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meUin");
        } else {
            str = str3;
        }
        this$0.Kh(z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanFriendSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(final ZPlanFriendSelectFragment this$0, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        FragmentTransaction addToBackStack;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanFriendSearchFragment zPlanFriendSearchFragment = new ZPlanFriendSearchFragment();
        zPlanFriendSearchFragment.Bh(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendSelectFragment$initView$2$frag$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String uin) {
                Intrinsics.checkNotNullParameter(uin, "uin");
                ZPlanFriendSelectFragment.this.Kh(true, uin);
            }
        });
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(R.id.pvw, zPlanFriendSearchFragment)) == null || (addToBackStack = add.addToBackStack(null)) == null) {
            return;
        }
        addToBackStack.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ZPlanFriendSelectFragment this$0, View view) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        FriendViewModel friendViewModel = this$0.friendViewModel;
        if (friendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
            friendViewModel = null;
        }
        Iterator<String> it = friendViewModel.Q1().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        jSONObject.put("friendUin", jSONArray);
        boolean z16 = true;
        try {
            ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJo.toString()");
            a.C10063a.b(zPlanLuaBridge, "N2L_SameStyle_OnFriendChoosen", jSONObject2, null, 4, null);
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle_FriendSelect", 1, e16, new Object[0]);
            z16 = false;
        }
        if (!z16 || (activity = this$0.getActivity()) == null) {
            return;
        }
        activity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    public static final void Eh(ZPlanFriendSelectFragment this$0, List list) {
        FriendViewModel friendViewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSameStyle_FriendSelect", 1, "friend list change size = " + list.size());
        this$0.yh();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(list, "list");
        Iterator it = list.iterator();
        while (true) {
            friendViewModel = null;
            if (!it.hasNext()) {
                break;
            }
            FriendInfo friendInfo = (FriendInfo) it.next();
            String uin = friendInfo.getUin();
            ?? r56 = this$0.meUin;
            if (r56 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("meUin");
            } else {
                friendViewModel = r56;
            }
            if (Intrinsics.areEqual(uin, friendViewModel)) {
                this$0.meInfo = friendInfo;
            } else {
                arrayList.add(friendInfo);
            }
        }
        FriendInfo friendInfo2 = this$0.meInfo;
        String profileUrl = friendInfo2 != null ? friendInfo2.getProfileUrl() : null;
        if (profileUrl == null || profileUrl.length() == 0) {
            ImageView imageView = this$0.meProfileImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meProfileImage");
                imageView = null;
            }
            imageView.setImageDrawable(null);
        } else {
            ImageView imageView2 = this$0.meProfileImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meProfileImage");
                imageView2 = null;
            }
            FriendInfo friendInfo3 = this$0.meInfo;
            imageView2.setImageDrawable(URLDrawable.getDrawable(friendInfo3 != null ? friendInfo3.getProfileUrl() : null, URLDrawable.URLDrawableOptions.obtain()));
        }
        g gVar = this$0.friendListAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListAdapter");
            gVar = null;
        }
        gVar.k0(arrayList);
        this$0.Hh(!arrayList.isEmpty());
        FriendViewModel friendViewModel2 = this$0.friendViewModel;
        if (friendViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
        } else {
            friendViewModel = friendViewModel2;
        }
        friendViewModel.T1(this$0.preselection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(ZPlanFriendSelectFragment this$0, List list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "list");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
        QLog.i("ZPlanSameStyle_FriendSelect", 1, "select list change, new list is: [" + joinToString$default + "]");
        g gVar = this$0.friendListAdapter;
        View view = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListAdapter");
            gVar = null;
        }
        gVar.r0(list);
        m mVar = this$0.selectListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectListAdapter");
            mVar = null;
        }
        mVar.l0(list);
        View view2 = this$0.selectListContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectListContainer");
            view2 = null;
        }
        view2.setVisibility(list.isEmpty() ? 8 : 0);
        this$0.Jh(list.size());
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            String uin = ((FriendInfo) it.next()).getUin();
            String str = this$0.meUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meUin");
                str = null;
            }
            if (Intrinsics.areEqual(uin, str)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            TextView textView = this$0.meSelectIndicator;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meSelectIndicator");
                textView = null;
            }
            textView.setText(String.valueOf(i3 + 1));
            TextView textView2 = this$0.meSelectIndicator;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meSelectIndicator");
                textView2 = null;
            }
            textView2.setSelected(true);
        } else {
            TextView textView3 = this$0.meSelectIndicator;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meSelectIndicator");
                textView3 = null;
            }
            textView3.setText("");
            TextView textView4 = this$0.meSelectIndicator;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meSelectIndicator");
                textView4 = null;
            }
            textView4.setSelected(false);
        }
        View view3 = this$0.btnComplete;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
        } else {
            view = view3;
        }
        view.setEnabled(!list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(ZPlanFriendSelectFragment this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.meAvatar;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meAvatar");
            imageView = null;
        }
        ImageView imageView3 = this$0.meAvatar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meAvatar");
        } else {
            imageView2 = imageView3;
        }
        imageView.setImageDrawable(new BitmapDrawable(imageView2.getResources(), bitmap));
    }

    private final void Hh(boolean visible) {
        IndexBarTipsLayout indexBarTipsLayout = null;
        if (visible) {
            IndexBar indexBar = this.indexBar;
            if (indexBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexBar");
                indexBar = null;
            }
            indexBar.setVisibility(0);
            IndexBarTipsLayout indexBarTipsLayout2 = this.indexTipsLayout;
            if (indexBarTipsLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexTipsLayout");
            } else {
                indexBarTipsLayout = indexBarTipsLayout2;
            }
            indexBarTipsLayout.setVisibility(0);
            return;
        }
        IndexBar indexBar2 = this.indexBar;
        if (indexBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
            indexBar2 = null;
        }
        indexBar2.setVisibility(8);
        IndexBarTipsLayout indexBarTipsLayout3 = this.indexTipsLayout;
        if (indexBarTipsLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexTipsLayout");
        } else {
            indexBarTipsLayout = indexBarTipsLayout3;
        }
        indexBarTipsLayout.setVisibility(8);
    }

    private final void Ih(Context context) {
        if (this.progressDialog == null) {
            Dialog dialog = new Dialog(context, R.style.qZoneInputDialog);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.f168383uh);
            this.progressDialog = dialog;
        }
        Dialog dialog2 = this.progressDialog;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    private final void Jh(int selectNum) {
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(R.string.xtc);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026plan_select_friend_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(selectNum), Integer.valueOf(this.maxSelectNum)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        AppInterface appInterface = this.app;
        FriendViewModel friendViewModel = null;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
            appInterface = null;
        }
        ViewModel viewModel = new ViewModelProvider(requireActivity, new n(appInterface)).get(FriendViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026endViewModel::class.java]");
        FriendViewModel friendViewModel2 = (FriendViewModel) viewModel;
        this.friendViewModel = friendViewModel2;
        if (friendViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
            friendViewModel2 = null;
        }
        friendViewModel2.O1().observe(requireActivity(), new Observer() { // from class: com.tencent.mobileqq.zplan.friend.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanFriendSelectFragment.Eh(ZPlanFriendSelectFragment.this, (List) obj);
            }
        });
        FriendViewModel friendViewModel3 = this.friendViewModel;
        if (friendViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
        } else {
            friendViewModel = friendViewModel3;
        }
        friendViewModel.P1().observe(requireActivity(), new Observer() { // from class: com.tencent.mobileqq.zplan.friend.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanFriendSelectFragment.Fh(ZPlanFriendSelectFragment.this, (List) obj);
            }
        });
    }

    private final void yh() {
        Dialog dialog;
        Dialog dialog2 = this.progressDialog;
        boolean z16 = false;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        }
        if (!z16 || (dialog = this.progressDialog) == null) {
            return;
        }
        dialog.dismiss();
    }

    @Override // com.tencent.mobileqq.armap.e
    public void h(String uin, String headPath, final Bitmap head) {
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        boolean z16 = false;
        if (activity2 != null && !activity2.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            String str = this.meUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("meUin");
                str = null;
            }
            if (!Intrinsics.areEqual(uin, str) || (activity = getActivity()) == null) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.friend.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanFriendSelectFragment.Gh(ZPlanFriendSelectFragment.this, head);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void m(boolean touching) {
        IndexBarTipsLayout indexBarTipsLayout = this.indexTipsLayout;
        IndexBar indexBar = null;
        if (indexBarTipsLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexTipsLayout");
            indexBarTipsLayout = null;
        }
        indexBarTipsLayout.setVisibility(touching ? 0 : 4);
        if (touching) {
            return;
        }
        IndexBar indexBar2 = this.indexBar;
        if (indexBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
        } else {
            indexBar = indexBar2;
        }
        indexBar.setChooseIndex(-1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String joinToString$default;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.maxSelectNum = arguments != null ? arguments.getInt("max_select_num") : 1;
        Bundle arguments2 = getArguments();
        com.tencent.mobileqq.armap.f fVar = null;
        List<String> stringArrayList = arguments2 != null ? arguments2.getStringArrayList("pre_selection") : null;
        if (stringArrayList == null) {
            stringArrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.preselection = stringArrayList;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (requireActivity instanceof AppActivity) {
            AppRuntime appRuntime = ((AppActivity) requireActivity).getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) appRuntime;
            this.app = appInterface;
            if (appInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("app");
                appInterface = null;
            }
            String currentAccountUin = appInterface.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            this.meUin = currentAccountUin;
            IQQNonMainProcAvatarLoaderApi iQQNonMainProcAvatarLoaderApi = (IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class);
            AppInterface appInterface2 = this.app;
            if (appInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("app");
                appInterface2 = null;
            }
            com.tencent.mobileqq.armap.f nonMainAppHeadLoader = iQQNonMainProcAvatarLoaderApi.getNonMainAppHeadLoader(appInterface2.getApplicationContext(), 1);
            Intrinsics.checkNotNullExpressionValue(nonMainAppHeadLoader, "api(IQQNonMainProcAvatar\u2026eadType.QQHEAD_TYPE_USER)");
            this.faceDecoder = nonMainAppHeadLoader;
            if (nonMainAppHeadLoader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceDecoder");
                nonMainAppHeadLoader = null;
            }
            nonMainAppHeadLoader.init();
            com.tencent.mobileqq.armap.f fVar2 = this.faceDecoder;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceDecoder");
            } else {
                fVar = fVar2;
            }
            fVar.a(this);
        }
        int i3 = this.maxSelectNum;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.preselection, ",", null, null, 0, null, null, 62, null);
        QLog.i("ZPlanSameStyle_FriendSelect", 1, "select friend with max select num = " + i3 + ", preselection = [" + joinToString$default + "]");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dca, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.armap.f fVar = this.faceDecoder;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceDecoder");
            fVar = null;
        }
        fVar.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel();
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void p1(String letter, int action, float pos) {
        IndexBarTipsLayout indexBarTipsLayout = this.indexTipsLayout;
        RecyclerView recyclerView = null;
        if (indexBarTipsLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexTipsLayout");
            indexBarTipsLayout = null;
        }
        indexBarTipsLayout.setText(letter, pos);
        g gVar = this.friendListAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListAdapter");
            gVar = null;
        }
        int n06 = gVar.n0(letter);
        if (n06 >= 0) {
            RecyclerView recyclerView2 = this.friendListView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendListView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.scrollToPosition(n06);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(boolean select, String uin) {
        List<String> listOf;
        FriendViewModel friendViewModel = null;
        if (select) {
            int i3 = this.maxSelectNum;
            FriendViewModel friendViewModel2 = this.friendViewModel;
            if (friendViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
                friendViewModel2 = null;
            }
            if (i3 > friendViewModel2.R1()) {
                FriendViewModel friendViewModel3 = this.friendViewModel;
                if (friendViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
                } else {
                    friendViewModel = friendViewModel3;
                }
                listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
                friendViewModel.T1(listOf);
                return;
            }
            QQToast.makeText(getContext(), 0, R.string.xtd, 0).show();
            return;
        }
        FriendViewModel friendViewModel4 = this.friendViewModel;
        if (friendViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
        } else {
            friendViewModel = friendViewModel4;
        }
        friendViewModel.W1(uin);
    }

    private final void initView(View rootView) {
        List mutableList;
        int collectionSizeOrDefault;
        View findViewById = rootView.findViewById(R.id.pfa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_back)");
        this.btnBack = findViewById;
        IndexBar indexBar = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanFriendSelectFragment.Bh(ZPlanFriendSelectFragment.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.que);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_title)");
        this.titleView = (TextView) findViewById2;
        Jh(0);
        View findViewById3 = rootView.findViewById(R.id.pgg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.btn_search)");
        this.btnSearch = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSearch");
            findViewById3 = null;
        }
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanFriendSelectFragment.Ch(ZPlanFriendSelectFragment.this, view);
            }
        });
        View findViewById4 = rootView.findViewById(R.id.pfo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.btn_complete)");
        this.btnComplete = findViewById4;
        if (findViewById4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
            findViewById4 = null;
        }
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanFriendSelectFragment.Dh(ZPlanFriendSelectFragment.this, view);
            }
        });
        View findViewById5 = rootView.findViewById(R.id.pw8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.friend_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.friendListView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.friendListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListView");
            recyclerView2 = null;
        }
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
            appInterface = null;
        }
        e eVar = new e(appInterface);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        g gVar = new g(eVar, requireContext, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendSelectFragment$initView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ZPlanFriendSelectFragment zPlanFriendSelectFragment = ZPlanFriendSelectFragment.this;
                FriendViewModel friendViewModel = zPlanFriendSelectFragment.friendViewModel;
                if (friendViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendViewModel");
                    friendViewModel = null;
                }
                zPlanFriendSelectFragment.Kh(!friendViewModel.S1(it), it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        this.friendListAdapter = gVar;
        recyclerView2.setAdapter(gVar);
        View findViewById6 = rootView.findViewById(R.id.qk7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026.selected_list_container)");
        this.selectListContainer = findViewById6;
        View findViewById7 = rootView.findViewById(R.id.qk6);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.selected_list)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById7;
        this.selectListView = recyclerView3;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectListView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView4 = this.selectListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectListView");
            recyclerView4 = null;
        }
        AppInterface appInterface2 = this.app;
        if (appInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app");
            appInterface2 = null;
        }
        e eVar2 = new e(appInterface2);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        m mVar = new m(eVar2, requireContext2, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendSelectFragment$initView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ZPlanFriendSelectFragment.this.Kh(false, it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        this.selectListAdapter = mVar;
        recyclerView4.setAdapter(mVar);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new b());
        RecyclerView recyclerView5 = this.selectListView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectListView");
            recyclerView5 = null;
        }
        itemTouchHelper.attachToRecyclerView(recyclerView5);
        View findViewById8 = rootView.findViewById(R.id.q1t);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.index_view)");
        IndexBar indexBar2 = (IndexBar) findViewById8;
        this.indexBar = indexBar2;
        if (indexBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
            indexBar2 = null;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList(new CharRange(EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'Z'));
        mutableList.add('#');
        List list = mutableList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Character) it.next()).charValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        indexBar2.setLetters((String[]) array);
        IndexBar indexBar3 = this.indexBar;
        if (indexBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
        } else {
            indexBar = indexBar3;
        }
        indexBar.setOnIndexBarTouchListener(this);
        View findViewById9 = rootView.findViewById(R.id.q1s);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.index_tips)");
        this.indexTipsLayout = (IndexBarTipsLayout) findViewById9;
        Hh(false);
        zh(rootView);
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        Ih(requireContext3);
    }

    private final void zh(View rootView) {
        View findViewById = rootView.findViewById(R.id.q8a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<View>(R.id.me_container)");
        this.meContainer = findViewById;
        ImageView imageView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meContainer");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanFriendSelectFragment.Ah(ZPlanFriendSelectFragment.this, view);
            }
        });
        View view = this.meContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meContainer");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.qug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "meContainer.findViewById(R.id.tv_user_name)");
        this.meName = (TextView) findViewById2;
        View view2 = this.meContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meContainer");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.q49);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "meContainer.findViewById(R.id.iv_user_avatar)");
        this.meAvatar = (ImageView) findViewById3;
        View view3 = this.meContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meContainer");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.qu7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "meContainer.findViewById(R.id.tv_select_indicator)");
        this.meSelectIndicator = (TextView) findViewById4;
        View view4 = this.meContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meContainer");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.q4_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "meContainer.findViewById\u2026id.iv_user_profile_image)");
        this.meProfileImage = (ImageView) findViewById5;
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        String str = this.meUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meUin");
            str = null;
        }
        String meUid = iRelationNTUinAndUidApi.getUidFromUin(str);
        TextView textView = this.meName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meName");
            textView = null;
        }
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(meUid, "meUid");
        textView.setText(iFriendsInfoService.getNickWithUid(meUid, "ZPlanSameStyle_FriendSelect"));
        com.tencent.mobileqq.armap.f fVar = this.faceDecoder;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceDecoder");
            fVar = null;
        }
        String str2 = this.meUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meUin");
            str2 = null;
        }
        Bitmap d16 = fVar.d(str2, true, null);
        ImageView imageView2 = this.meAvatar;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("meAvatar");
        } else {
            imageView = imageView2;
        }
        Resources resources = rootView.getResources();
        if (d16 == null) {
            d16 = BaseImageUtil.getDefaultFaceBitmap();
        }
        imageView.setImageDrawable(new BitmapDrawable(resources, d16));
    }
}
