package com.tencent.mobileqq.multishare.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.multishare.p007const.MultiShareSelectStatus;
import com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\b\u0016\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0004J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bH\u0004J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0004J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001fH\u0004J\b\u0010#\u001a\u00020\u0003H\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\"\u0010.\u001a\u00020'8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010L\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010V\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001f0P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bW\u0010S\u001a\u0004\bX\u0010UR#\u0010`\u001a\n [*\u0004\u0018\u00010Z0Z8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R(\u0010f\u001a\b\u0012\u0004\u0012\u00020\t0a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010S\u001a\u0004\bc\u0010U\"\u0004\bd\u0010eR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010S\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart;", "Lcom/tencent/biz/richframework/part/Part;", "Li92/b;", "", "initView", "N9", "A9", "", "G9", "Lcom/tencent/mobileqq/multishare/action/c;", QCircleAlphaUserReporter.KEY_USER, "", "O9", "L9", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "C9", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "X9", "M9", "", "B9", com.tencent.luggage.wxa.c8.c.G, "isSelected", "o4", "W9", "userItem", "Lcom/tencent/mobileqq/multishare/bean/a;", "Y9", "bean", "P9", "f2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "J9", "()Landroidx/recyclerview/widget/RecyclerView;", "S9", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "e", "Landroid/view/View;", "E9", "()Landroid/view/View;", "Q9", "(Landroid/view/View;)V", "dividerView", "Lcom/tencent/mobileqq/multishare/adapter/b;", "f", "Lcom/tencent/mobileqq/multishare/adapter/b;", "K9", "()Lcom/tencent/mobileqq/multishare/adapter/b;", "V9", "(Lcom/tencent/mobileqq/multishare/adapter/b;)V", "userAdapter", "Lcom/tencent/mobileqq/multishare/adapter/a;", tl.h.F, "Lcom/tencent/mobileqq/multishare/adapter/a;", "F9", "()Lcom/tencent/mobileqq/multishare/adapter/a;", "R9", "(Lcom/tencent/mobileqq/multishare/adapter/a;)V", "extraAdapter", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "i", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "editText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isSelecting", "()Z", "U9", "(Z)V", "", "Lcom/tencent/mobileqq/multishare/item/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "I9", "()Ljava/util/List;", "recentUserItems", "D", "D9", "chosenUserItems", "Lcom/tencent/mobileqq/multishare/viewmodel/a;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/multishare/viewmodel/a;", "multiShareViewModel", "", UserInfo.SEX_FEMALE, "getSelectedUserList", "T9", "(Ljava/util/List;)V", "selectedUserList", "G", "selectedUserItems", "<init>", "()V", "H", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class MultiShareRecentFriendsPart extends Part implements i92.b {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.item.a> recentUserItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.bean.a> chosenUserItems;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy multiShareViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.multishare.action.c> selectedUserList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.item.a> selectedUserItems;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View dividerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.mobileqq.multishare.adapter.b userAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.mobileqq.multishare.adapter.a extraAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIMultiLineInputView editText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSelecting;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart$a;", "", "", "ITEM_BOTTOM_MARGIN", UserInfo.SEX_FEMALE, "ITEM_HORIZONTAL_MARGIN", "", "MAX_CHOSEN_COUNT", "I", "OVER_SIZE", "", "TAG", "Ljava/lang/String;", "USER_ITEM_AVATAR_HEIGHT", "USER_ITEM_GAP_MARGIN", "USER_ITEM_LABEL_LINE_SPACE", "USER_ITEM_LABEL_LINE_SPACE_MULT", "USER_ITEM_LABEL_MAX_LINES", "USER_ITEM_LABEL_TEXT_SIZE", "USER_ITEM_WIDTH", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
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
            outRect.right = cx.a(8.0f);
            outRect.left = cx.a(8.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart$c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/multishare/part/MultiShareRecentFriendsPart$d", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements RecentContactListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiShareRecentFriendsPart.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MultiShareRecentFriendsPart this$0, List validUserList) {
            List list;
            List listOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(validUserList, "$validUserList");
            if (this$0.I9().size() <= 0) {
                this$0.J9().setVisibility(8);
                this$0.E9().setVisibility(8);
                return;
            }
            this$0.M9();
            this$0.J9().setVisibility(0);
            this$0.E9().setVisibility(0);
            this$0.J9().getLayoutParams().height = this$0.B9();
            this$0.J9().scrollToPosition(0);
            com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.i(context, this$0.J9());
            com.tencent.mobileqq.multishare.adapter.b K9 = this$0.K9();
            list = CollectionsKt___CollectionsKt.toList(this$0.I9());
            K9.setItems(list);
            if (validUserList.size() > 15) {
                com.tencent.mobileqq.multishare.adapter.a F9 = this$0.F9();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.multishare.item.b());
                F9.setItems(listOf);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> recentUserList) {
            List<com.tencent.mobileqq.multishare.bean.a> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentUserList);
                return;
            }
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            final ArrayList arrayList = new ArrayList();
            for (RecentUser recentUser : recentUserList) {
                String str = recentUser.uin;
                Intrinsics.checkNotNullExpressionValue(str, "recentUser.uin");
                int i3 = recentUser.type;
                String str2 = recentUser.displayName;
                Intrinsics.checkNotNullExpressionValue(str2, "recentUser.displayName");
                com.tencent.mobileqq.multishare.item.a aVar = new com.tencent.mobileqq.multishare.item.a(str, i3, str2);
                aVar.j(recentUser.lastmsgtime);
                if (!TextUtils.isEmpty(recentUser.troopUin)) {
                    String str3 = recentUser.troopUin;
                    Intrinsics.checkNotNullExpressionValue(str3, "recentUser.troopUin");
                    aVar.h(str3);
                }
                arrayList.add(aVar);
            }
            if (arrayList.size() > 15) {
                MultiShareRecentFriendsPart.this.I9().addAll(arrayList.subList(0, 15));
            } else {
                MultiShareRecentFriendsPart.this.I9().addAll(arrayList);
            }
            MultiShareRecentFriendsPart.this.A9();
            Handler mainHandler = MultiShareRecentFriendsPart.this.getMainHandler();
            final MultiShareRecentFriendsPart multiShareRecentFriendsPart = MultiShareRecentFriendsPart.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.multishare.part.g
                @Override // java.lang.Runnable
                public final void run() {
                    MultiShareRecentFriendsPart.d.b(MultiShareRecentFriendsPart.this, arrayList);
                }
            });
            if (!MultiShareRecentFriendsPart.this.D9().isEmpty()) {
                MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1 = MultiShareRecentFriendsPart.this.H9().L1();
                list = CollectionsKt___CollectionsKt.toList(MultiShareRecentFriendsPart.this.D9());
                L1.postValue(list);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareRecentFriendsPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.recentUserItems = new ArrayList();
        this.chosenUserItems = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.multishare.viewmodel.a>() { // from class: com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart$multiShareViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiShareRecentFriendsPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.multishare.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.multishare.viewmodel.a) MultiShareRecentFriendsPart.this.getViewModel(com.tencent.mobileqq.multishare.viewmodel.a.class) : (com.tencent.mobileqq.multishare.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.multiShareViewModel = lazy;
        this.selectedUserList = new ArrayList();
        this.selectedUserItems = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A9() {
        if (this.recentUserItems.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends com.tencent.mobileqq.multishare.action.c> it = this.selectedUserList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.multishare.action.c next = it.next();
            int size = this.recentUserItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(this.recentUserItems.get(i3).f(), next.f())) {
                    arrayList2.add(Integer.valueOf(i3));
                }
            }
        }
        int size2 = this.recentUserItems.size();
        for (int i16 = 0; i16 < size2; i16++) {
            if (!arrayList2.contains(Integer.valueOf(i16))) {
                arrayList.add(this.recentUserItems.get(i16));
            }
        }
        this.recentUserItems.clear();
        this.recentUserItems.addAll(arrayList);
        this.recentUserItems.addAll(0, this.selectedUserItems);
    }

    private final ArrayList<ResultRecord> C9() {
        if (this.chosenUserItems.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        for (com.tencent.mobileqq.multishare.bean.a aVar : this.chosenUserItems) {
            arrayList.add(new ResultRecord(aVar.d(), aVar.c(), aVar.e(), aVar.b()));
        }
        return arrayList;
    }

    private final String G9() {
        Iterator<com.tencent.mobileqq.multishare.item.a> it = this.recentUserItems.iterator();
        String str = "";
        while (it.hasNext()) {
            String e16 = it.next().e();
            if (e16.length() > str.length()) {
                str = e16;
            }
        }
        return str;
    }

    private final void L9(com.tencent.mobileqq.multishare.action.c user) {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        IPartHost partHost = getPartHost();
        MultiShareBottomDialogFragment multiShareBottomDialogFragment2 = null;
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            sh5.b(activity, user);
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment2 = (MultiShareBottomDialogFragment) partHost2;
        }
        if (multiShareBottomDialogFragment2 != null) {
            multiShareBottomDialogFragment2.dismiss();
        }
    }

    private final void N9() {
        this.selectedUserItems.clear();
        for (com.tencent.mobileqq.multishare.action.c cVar : this.selectedUserList) {
            this.selectedUserItems.add(new com.tencent.mobileqq.multishare.item.a(cVar.f(), cVar.g(), cVar.e()));
            com.tencent.mobileqq.multishare.bean.a Y9 = Y9(cVar);
            Y9.f("LOAD_SOURCE_ICON_LIST_INIT");
            this.chosenUserItems.add(Y9);
        }
    }

    private final boolean O9(com.tencent.mobileqq.multishare.action.c user) {
        if ((!this.chosenUserItems.isEmpty()) && user.g() == 10027) {
            return true;
        }
        return false;
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.f791048v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lti_share_recent_friends)");
        S9((RecyclerView) findViewById);
        View findViewById2 = getPartRootView().findViewById(R.id.ziv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.multi_share_divider)");
        Q9(findViewById2);
        c cVar = new c(getContext());
        cVar.setOrientation(0);
        J9().setLayoutManager(cVar);
        V9(new com.tencent.mobileqq.multishare.adapter.b());
        R9(new com.tencent.mobileqq.multishare.adapter.a());
        J9().setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{K9(), F9()}));
        J9().addItemDecoration(new b());
    }

    private final void z9() {
        if (this.editText == null) {
            this.editText = (QUIMultiLineInputView) getPartRootView().findViewById(R.id.zix);
        }
        QUIMultiLineInputView qUIMultiLineInputView = this.editText;
        if (qUIMultiLineInputView != null) {
            qUIMultiLineInputView.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        TextView textView = new TextView(getContext());
        textView.setMaxLines(2);
        textView.setLineSpacing(cx.a(5.0f), 1.0f);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LinearLayout.LayoutParams(cx.a(52.0f), -2));
        textView.setText(G9());
        textView.measure(View.MeasureSpec.makeMeasureSpec(cx.a(52.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getMeasuredHeight() + cx.a(76.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<com.tencent.mobileqq.multishare.bean.a> D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.chosenUserItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View view = this.dividerView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dividerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.multishare.adapter.a F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.multishare.adapter.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        com.tencent.mobileqq.multishare.adapter.a aVar = this.extraAdapter;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extraAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tencent.mobileqq.multishare.viewmodel.a H9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.multishare.viewmodel.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return (com.tencent.mobileqq.multishare.viewmodel.a) this.multiShareViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<com.tencent.mobileqq.multishare.item.a> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.recentUserItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RecyclerView J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.multishare.adapter.b K9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.multishare.adapter.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.mobileqq.multishare.adapter.b bVar = this.userAdapter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        int size = this.selectedUserItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            W9(i3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P9(@NotNull com.tencent.mobileqq.multishare.bean.a bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bean);
            return;
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (this.chosenUserItems.isEmpty()) {
            return;
        }
        String d16 = bean.d();
        int size = this.chosenUserItems.size();
        int i3 = -1;
        for (int i16 = 0; i16 < size; i16++) {
            if (Intrinsics.areEqual(d16, this.chosenUserItems.get(i16).d())) {
                i3 = i16;
            }
        }
        if (i3 >= 0) {
            this.chosenUserItems.remove(i3);
        }
    }

    protected final void Q9(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.dividerView = view;
        }
    }

    protected final void R9(@NotNull com.tencent.mobileqq.multishare.adapter.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.extraAdapter = aVar;
        }
    }

    protected final void S9(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.recyclerView = recyclerView;
        }
    }

    public final void T9(@NotNull List<? extends com.tencent.mobileqq.multishare.action.c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selectedUserList = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U9(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isSelecting = z16;
        }
    }

    protected final void V9(@NotNull com.tencent.mobileqq.multishare.adapter.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.userAdapter = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W9(int pos, boolean isSelected) {
        MultiShareSelectStatus multiShareSelectStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(pos), Boolean.valueOf(isSelected));
            return;
        }
        if (pos > this.recentUserItems.size() - 1) {
            QLog.d("MultiShareRecentFriendsPart", 1, "[updateItemSelectedStatus] out of index.");
            return;
        }
        if (!this.isSelecting) {
            Iterator<com.tencent.mobileqq.multishare.item.a> it = this.recentUserItems.iterator();
            while (it.hasNext()) {
                it.next().k(MultiShareSelectStatus.SELECTING);
            }
            this.isSelecting = true;
        }
        com.tencent.mobileqq.multishare.item.a aVar = this.recentUserItems.get(pos);
        if (isSelected) {
            multiShareSelectStatus = MultiShareSelectStatus.SELECTED;
        } else {
            multiShareSelectStatus = MultiShareSelectStatus.SELECTING;
        }
        aVar.k(multiShareSelectStatus);
    }

    protected void X9() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        j92.e eVar = null;
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null) {
            eVar = multiShareBottomDialogFragment.uh();
        }
        com.tencent.mobileqq.multishare.util.f.f251809a.g(eVar, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.multishare.bean.a Y9(@Nullable com.tencent.mobileqq.multishare.action.c userItem) {
        String str;
        String str2;
        String str3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.mobileqq.multishare.bean.a) iPatchRedirector.redirect((short) 23, (Object) this, (Object) userItem);
        }
        if (userItem != null) {
            String f16 = userItem.f();
            int g16 = userItem.g();
            String e16 = userItem.e();
            str3 = userItem.d();
            str = f16;
            i3 = g16;
            str2 = e16;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            i3 = 0;
        }
        return new com.tencent.mobileqq.multishare.bean.a(str, i3, str2, str3, null, 16, null);
    }

    @Override // i92.b
    public void f2() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        MultiShareBottomDialogFragment multiShareBottomDialogFragment2 = null;
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            sh5.d(C9());
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment2 = (MultiShareBottomDialogFragment) partHost2;
        }
        if (multiShareBottomDialogFragment2 != null) {
            multiShareBottomDialogFragment2.dismiss();
        }
    }

    @Override // i92.b
    public void o4(@NotNull com.tencent.mobileqq.multishare.action.c user, int pos, boolean isSelected) {
        List list;
        List<com.tencent.mobileqq.multishare.bean.a> list2;
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        List list3;
        List list4;
        List list5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, user, Integer.valueOf(pos), Boolean.valueOf(isSelected));
            return;
        }
        Intrinsics.checkNotNullParameter(user, "user");
        if (user.g() == 10027 && this.chosenUserItems.isEmpty()) {
            L9(user);
            return;
        }
        com.tencent.mobileqq.multishare.bean.a Y9 = Y9(user);
        if (isSelected) {
            if (O9(user)) {
                com.tencent.mobileqq.multishare.util.c.f251800a.m(getActivity());
                com.tencent.mobileqq.multishare.adapter.b K9 = K9();
                list5 = CollectionsKt___CollectionsKt.toList(this.recentUserItems);
                K9.setItems(list5);
                z9();
                QLog.d("MultiShareRecentFriendsPart", 1, "[onUserClick] selected multi guild disable.");
                return;
            }
            if (this.chosenUserItems.size() >= 9) {
                com.tencent.mobileqq.multishare.util.c.f251800a.k(getActivity());
                com.tencent.mobileqq.multishare.adapter.b K92 = K9();
                list4 = CollectionsKt___CollectionsKt.toList(this.recentUserItems);
                K92.setItems(list4);
                z9();
                QLog.d("MultiShareRecentFriendsPart", 1, "[onUserClick] chosen users over size.");
                return;
            }
            this.chosenUserItems.add(Y9);
        } else {
            P9(Y9);
        }
        if (this.chosenUserItems.isEmpty()) {
            Iterator<com.tencent.mobileqq.multishare.item.a> it = this.recentUserItems.iterator();
            while (it.hasNext()) {
                it.next().k(MultiShareSelectStatus.UNSELECTED);
            }
            com.tencent.mobileqq.multishare.adapter.b K93 = K9();
            list3 = CollectionsKt___CollectionsKt.toList(this.recentUserItems);
            K93.setItems(list3);
            this.isSelecting = false;
        } else {
            W9(pos, isSelected);
            com.tencent.mobileqq.multishare.adapter.b K94 = K9();
            list = CollectionsKt___CollectionsKt.toList(this.recentUserItems);
            K94.setItems(list);
        }
        MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1 = H9().L1();
        list2 = CollectionsKt___CollectionsKt.toList(this.chosenUserItems);
        L1.postValue(list2);
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            sh5.a(user, isSelected);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        initView();
        N9();
        X9();
        RFWIocAbilityProvider.g().registerIoc(rootView, this, i92.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        this.chosenUserItems.clear();
        this.recentUserItems.clear();
    }
}
