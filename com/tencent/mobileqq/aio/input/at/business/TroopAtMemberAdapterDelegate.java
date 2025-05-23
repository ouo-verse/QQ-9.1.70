package com.tencent.mobileqq.aio.input.at.business;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.business.n;
import com.tencent.mobileqq.aio.input.at.common.list.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import com.tencent.qqnt.aio.input.api.IInputAtApi;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.robot.api.IRobotAtApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u000245B\u001d\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b1\u00102J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J&\u0010\u001a\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J&\u0010\u001e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/TroopAtMemberAdapterDelegate;", "Lcom/tencent/mobileqq/aio/input/at/common/list/base/a;", "Lcom/tencent/mobileqq/aio/input/at/business/o;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "Lcom/tencent/mobileqq/aio/input/at/business/TroopAtMemberAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", "holder", "", "", "payloads", "", "t", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "nickNameView", "", "uid", "l", "itemData", "", "o", DomainData.DOMAIN_NAME, "items", "", "position", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "r", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/aio/input/at/common/j;", "Lcom/tencent/mobileqq/aio/input/at/business/b;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "e", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "mDelegateListener", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAnonymousApi;", "f", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/aio/adapter/api/IAIOAnonymousApi;", "aioAnonymousApi", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;Lcom/tencent/mobileqq/aio/input/at/common/b;)V", tl.h.F, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TroopAtMemberAdapterDelegate extends com.tencent.mobileqq.aio.input.at.common.list.base.a<o, com.tencent.mobileqq.aio.input.at.common.list.data.b, a> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.at.common.j<b> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.at.common.b mDelegateListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aioAnonymousApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/TroopAtMemberAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "nickNameView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "l", "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "headView", "Landroid/widget/CheckBox;", "G", "Landroid/widget/CheckBox;", "p", "()Landroid/widget/CheckBox;", "selectView", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "leadershipView", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "specialConcernView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView nickNameView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundRectImageView headView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final CheckBox selectView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView leadershipView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView specialConcernView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_name)");
            this.nickNameView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.dvo);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_head_image)");
            this.headView = (RoundRectImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f2x);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.multi_select_checkbox)");
            this.selectView = (CheckBox) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.mde);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_member_leadership)");
            this.leadershipView = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f109246fa);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026v_member_special_concern)");
            this.specialConcernView = (TextView) findViewById5;
        }

        @NotNull
        public final RoundRectImageView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RoundRectImageView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.headView;
        }

        @NotNull
        public final TextView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (TextView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.leadershipView;
        }

        @NotNull
        public final TextView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.nickNameView;
        }

        @NotNull
        public final CheckBox p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CheckBox) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.selectView;
        }

        @NotNull
        public final TextView q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.specialConcernView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/TroopAtMemberAdapterDelegate$b;", "", "", "ROBOT_ICON_HEIGHT_DP", UserInfo.SEX_FEMALE, "ROBOT_ICON_WIDTH_DP", "ROBOT_MARK_PADDING", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.business.TroopAtMemberAdapterDelegate$b, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f189233a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53329);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MemberRole.values().length];
            try {
                iArr[MemberRole.OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemberRole.ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f189233a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAtMemberAdapterDelegate(@NotNull com.tencent.mobileqq.aio.input.at.common.j<b> mDialogContext, @NotNull com.tencent.mobileqq.aio.input.at.common.b mDelegateListener) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        Intrinsics.checkNotNullParameter(mDelegateListener, "mDelegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext, (Object) mDelegateListener);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mDelegateListener = mDelegateListener;
        lazy = LazyKt__LazyJVMKt.lazy(TroopAtMemberAdapterDelegate$aioAnonymousApi$2.INSTANCE);
        this.aioAnonymousApi = lazy;
    }

    private final void l(TextView nickNameView, long uid) {
        int robotDrawableId = m().getRobotDrawableId(String.valueOf(uid));
        if (robotDrawableId != 0) {
            nickNameView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0f));
            Drawable drawable = ResourcesCompat.getDrawable(nickNameView.getContext().getResources(), robotDrawableId, null);
            if (drawable != null) {
                drawable.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
            }
            nickNameView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        nickNameView.setCompoundDrawables(null, null, null, null);
    }

    private final IAIOAnonymousApi m() {
        return (IAIOAnonymousApi) this.aioAnonymousApi.getValue();
    }

    private final void n() {
        QQToastUtil.showQQToastInUiThread(0, "@\u673a\u5668\u4eba\u5df2\u8fbe\u6570\u91cf\u4e0a\u9650");
    }

    private final boolean o(com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        if (!this.mDialogContext.g()) {
            return false;
        }
        QRouteApi api = QRoute.api(IRobotServiceApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotServiceApi::class.java)");
        final IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) api;
        if (!(itemData instanceof o) || !iRobotServiceApi.isRobotUin(String.valueOf(((o) itemData).j().uin)) || ((IInputAtApi) QRoute.api(IInputAtApi.class)).getMatchAtSpanCount(new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.aio.input.at.business.TroopAtMemberAdapterDelegate$interceptOnSelectItem$count$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IRobotServiceApi.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(IRobotServiceApi.this.isRobotUin(it));
            }
        }) < ((IRobotAtApi) QRoute.api(IRobotAtApi.class)).getAtRobotLimit()) {
            return false;
        }
        return true;
    }

    private final void q(o item, a holder) {
        int i3;
        holder.itemView.setOnClickListener(this);
        CheckBox p16 = holder.p();
        if (item.d()) {
            p16.setVisibility(0);
            p16.setChecked(item.g());
        } else {
            p16.setVisibility(8);
            p16.setChecked(false);
        }
        MemberRole memberRole = item.j().role;
        if (memberRole == null) {
            i3 = -1;
        } else {
            i3 = c.f189233a[memberRole.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                holder.m().setVisibility(8);
            } else {
                holder.m().setText(R.string.eml);
                holder.m().setVisibility(0);
                holder.m().getBackground().mutate().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor("#36DACC")));
            }
        } else {
            holder.m().setText(R.string.ems);
            holder.m().setVisibility(0);
            holder.m().getBackground().mutate().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor("#FFD13A")));
        }
        if (item.j().isSpecialConcerned) {
            holder.q().setVisibility(0);
        } else {
            holder.q().setVisibility(8);
        }
        holder.o().setText(AtUtils.f189228a.h(item.j()));
        l(holder.o(), item.j().uin);
        b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
        b.a aVar = new b.a();
        aVar.g(AvatarSizeType.SMALL);
        aVar.b(Integer.valueOf(R.drawable.f160830com));
        com.tencent.qqnt.avatar.e e16 = com.tencent.qqnt.avatar.a.INSTANCE.b(this.mDialogContext.c()).b(holder.l()).e(aVar.a());
        String str = item.j().uid;
        Intrinsics.checkNotNullExpressionValue(str, "item.memberInfo.uid");
        e.a.b(e16, str, item.j().uin, null, 4, null);
    }

    private final void t(a holder, List<Object> payloads) {
        Object first;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) payloads);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj : (List) first) {
            if (obj instanceof a.C7256a) {
                if (((a.C7256a) obj).a()) {
                    holder.p().setVisibility(0);
                } else {
                    holder.p().setVisibility(8);
                }
            } else if (obj instanceof a.b) {
                holder.p().setChecked(((a.b) obj).a());
            } else if (obj instanceof n.c) {
                if (((n.c) obj).a()) {
                    holder.q().setVisibility(0);
                } else {
                    holder.q().setVisibility(8);
                }
            } else if (obj instanceof n.b) {
                holder.o().setText(((n.b) obj).a());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            QLog.d("TroopAtMemberAdapterDelegate", 1, NodeProps.ON_CLICK);
            Object tag = v3.getTag(R.id.f82224ga);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.at.common.list.data.BaseItemData");
            com.tencent.mobileqq.aio.input.at.common.list.data.b bVar = (com.tencent.mobileqq.aio.input.at.common.list.data.b) tag;
            if (bVar.g()) {
                this.mDelegateListener.a(bVar);
            } else if (o(bVar)) {
                n();
            } else {
                this.mDelegateListener.b(bVar);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean h(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b item, @NotNull List<com.tencent.mobileqq.aio.input.at.common.list.data.b> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull o item, @NotNull a holder, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(R.id.f82224ga, item);
        holder.itemView.setTag(R.id.f82234gb, holder);
        if (payloads.isEmpty()) {
            q(item, holder);
        } else {
            t(holder, payloads);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a c(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View contentView = LayoutInflater.from(this.mDialogContext.c()).inflate(R.layout.hyj, parent, false);
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        a aVar = new a(contentView);
        aVar.l().setCornerRadiusAndMode(ViewUtils.dip2px(16.0f), 1);
        aVar.l().setImageDrawable(this.mDialogContext.c().getResources().getDrawable(R.drawable.f160830com));
        return aVar;
    }
}
