package com.tencent.mobileqq.aio.input.at.business;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.list.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupAtInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRemainAtAllTimesOperateCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u000289B\u001d\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J&\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\bH\u0007R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/l;", "Lcom/tencent/mobileqq/aio/input/at/common/list/base/a;", "Lcom/tencent/mobileqq/aio/input/at/business/m;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "Lcom/tencent/mobileqq/aio/input/at/business/l$a;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "t", HippyTKDListViewAdapter.X, "", "", "payloads", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/api/s;", "o", "Landroid/text/SpannableString;", "p", "Ly71/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "items", "", "position", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "w", "v", "Landroid/view/View;", NodeProps.ON_CLICK, "r", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "Lcom/tencent/mobileqq/aio/input/at/business/b;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "e", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "mDelegateListener", "f", "I", "mRemainCount", "", tl.h.F, "Ljava/lang/String;", "mCanNotAtAllMsg", "Lmqq/util/WeakReference;", "i", "Lmqq/util/WeakReference;", "mAtAllHolderRef", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;Lcom/tencent/mobileqq/aio/input/at/common/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l extends com.tencent.mobileqq.aio.input.at.common.list.base.a<m, com.tencent.mobileqq.aio.input.at.common.list.data.b, a> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_AtAllVipGuideyml", version = 1)
    @Nullable
    private static y71.a C;
    private static ArrayList D;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.at.common.j<b> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.at.common.b mDelegateListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mRemainCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mCanNotAtAllMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<a> mAtAllHolderRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001a\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/l$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "E", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "l", "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "headView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "o", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "remainCount", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "vasGuide", "Landroid/view/View;", "I", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/View;", "vasOpenVip", "itemView", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RoundRectImageView headView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final QUICheckBox selectView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView remainCount;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView vasGuide;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final View vasOpenVip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.dvo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_head_image)");
            this.headView = (RoundRectImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f2x);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.multi_select_checkbox)");
            this.selectView = (QUICheckBox) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f110656j4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_remain_count)");
            this.remainCount = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.y_j);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_vas_guide)");
            this.vasGuide = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.y6o);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.iv_open_vip)");
            this.vasOpenVip = findViewById5;
        }

        @NotNull
        public final RoundRectImageView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RoundRectImageView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.headView;
        }

        @NotNull
        public final TextView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.remainCount;
        }

        @NotNull
        public final QUICheckBox o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QUICheckBox) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.selectView;
        }

        @NotNull
        public final ImageView p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ImageView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.vasGuide;
        }

        @NotNull
        public final View q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (View) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.vasOpenVip;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/l$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.business.l$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(yz2.a.class);
        INSTANCE = new Companion(null);
    }

    public l(@NotNull com.tencent.mobileqq.aio.input.at.common.j<b> mDialogContext, @NotNull com.tencent.mobileqq.aio.input.at.common.b mDelegateListener) {
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        Intrinsics.checkNotNullParameter(mDelegateListener, "mDelegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext, (Object) mDelegateListener);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mDelegateListener = mDelegateListener;
        this.mRemainCount = -1;
    }

    private final void A(a holder, List<Object> payloads) {
        Object first;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) payloads);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj : (List) first) {
            if (obj instanceof a.C7256a) {
                if (((a.C7256a) obj).a()) {
                    holder.o().setVisibility(0);
                } else {
                    holder.o().setVisibility(8);
                }
            } else if (obj instanceof a.b) {
                holder.o().setChecked(((a.b) obj).a());
            }
        }
    }

    private final s o() {
        IKernelService iKernelService;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null && (iKernelService = (IKernelService) waitAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    private final SpannableString p() {
        String string = this.mDialogContext.c().getString(R.string.f1624320e);
        Intrinsics.checkNotNullExpressionValue(string, "mDialogContext.getContex\u2026_at_all_remain_count_pre)");
        String valueOf = String.valueOf(this.mRemainCount);
        String string2 = this.mDialogContext.c().getString(R.string.f1624220d);
        Intrinsics.checkNotNullExpressionValue(string2, "mDialogContext.getContex\u2026_at_all_remain_count_end)");
        SpannableString spannableString = new SpannableString(string + valueOf + string2);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4222")), 2, valueOf.length() + 2, 33);
        return spannableString;
    }

    private final y71.a q() {
        if (C == null) {
            r();
        }
        y71.a aVar = C;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    private final void t(m item, a holder) {
        holder.itemView.setOnClickListener(this);
        holder.p().setOnClickListener(this);
        holder.q().setOnClickListener(this);
        QUICheckBox o16 = holder.o();
        if (item.d()) {
            o16.setVisibility(0);
            o16.setChecked(item.g());
        } else {
            o16.setVisibility(8);
            o16.setChecked(false);
        }
        if (this.mRemainCount >= 0) {
            holder.m().setText(p());
            holder.m().setVisibility(0);
            holder.p().setVisibility(0);
        } else {
            holder.m().setVisibility(8);
            holder.p().setVisibility(8);
        }
        if (this.mRemainCount == 0 && q().c()) {
            holder.q().setVisibility(0);
        } else {
            holder.q().setVisibility(8);
        }
        this.mAtAllHolderRef = new WeakReference<>(holder);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.input.at.business.i
            @Override // java.lang.Runnable
            public final void run() {
                l.u(l.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
    }

    private final void x() {
        s o16 = o();
        if (o16 != null) {
            o16.getGroupRemainAtTimes(Long.parseLong(this.mDialogContext.e().a().r().c().j()), new IGetGroupRemainAtAllTimesOperateCallback() { // from class: com.tencent.mobileqq.aio.input.at.business.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRemainAtAllTimesOperateCallback
                public final void onResult(int i3, String str, GroupAtInfo groupAtInfo) {
                    l.y(l.this, i3, str, groupAtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final l this$0, int i3, String str, final GroupAtInfo groupAtInfo) {
        Integer num;
        WeakReference<a> weakReference;
        final a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num2 = null;
        if (groupAtInfo != null) {
            num = Integer.valueOf(groupAtInfo.getRemainAtAllCountForUin());
        } else {
            num = null;
        }
        if (groupAtInfo != null) {
            num2 = Integer.valueOf(groupAtInfo.getRemainAtAllCountForGroup());
        }
        QLog.d("TroopAtAllAdapterDelegate", 1, "errCode=" + i3 + " remainForUin=" + num + " remainForGroup=" + num2);
        if (i3 == 0 && groupAtInfo != null && (weakReference = this$0.mAtAllHolderRef) != null && (aVar = weakReference.get()) != null) {
            aVar.m().post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.at.business.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.z(l.this, groupAtInfo, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(l this$0, GroupAtInfo groupAtInfo, a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.mRemainCount = Math.min(groupAtInfo.getRemainAtAllCountForUin(), groupAtInfo.getRemainAtAllCountForGroup());
        this$0.mCanNotAtAllMsg = groupAtInfo.canNotAtAllMsg;
        it.m().setText(this$0.p());
        it.m().setVisibility(0);
        it.p().setVisibility(0);
        if (this$0.mRemainCount == 0 && this$0.q().c()) {
            it.q().setVisibility(0);
        } else {
            it.q().setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (r0 == true) goto L24;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            boolean z17 = true;
            if (v3.getId() == R.id.y_j) {
                QLog.d("TroopAtAllAdapterDelegate", 1, "onClick|iv_vas_guide");
                y71.a q16 = q();
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                q16.b(context);
            } else if (v3.getId() == R.id.y6o) {
                QLog.d("TroopAtAllAdapterDelegate", 1, "onClick|iv_open_vip");
                y71.a q17 = q();
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                q17.a(context2);
            } else {
                QLog.d("TroopAtAllAdapterDelegate", 1, "onClick|remainCount=" + this.mRemainCount);
                if (this.mRemainCount <= 0) {
                    String str = this.mCanNotAtAllMsg;
                    if (str != null) {
                        if (str.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                    }
                    z17 = false;
                    if (z17) {
                        QQToast.makeText(this.mDialogContext.c(), this.mCanNotAtAllMsg, 0).show();
                    }
                }
                Object tag = v3.getTag(R.id.f82224ga);
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.at.common.list.data.BaseItemData");
                com.tencent.mobileqq.aio.input.at.common.list.data.b bVar = (com.tencent.mobileqq.aio.input.at.common.list.data.b) tag;
                if (bVar.g()) {
                    this.mDelegateListener.a(bVar);
                } else {
                    this.mDelegateListener.b(bVar);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @QAutoInitMethod
    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            C = (y71.a) com.tencent.mobileqq.qroute.utils.b.a(D);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean h(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b item, @NotNull List<com.tencent.mobileqq.aio.input.at.common.list.data.b> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull m item, @NotNull a holder, @NotNull List<Object> payloads) {
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
            t(item, holder);
        } else {
            A(holder, payloads);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.input.at.common.list.base.b
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public a c(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.mDialogContext.c()).inflate(R.layout.hyi, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mDialogContext.getC\u2026em_layout, parent, false)");
        a aVar = new a(inflate);
        aVar.l().setCornerRadiusAndMode(ViewUtils.dip2px(16.0f), 1);
        return aVar;
    }
}
