package com.tencent.mobileqq.multishare.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/multishare/bean/a;", QCircleAlphaUserReporter.KEY_USER, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "uinType", DomainData.DOMAIN_NAME, "l", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "avatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "name", "G", "arrow", "H", "Lcom/tencent/mobileqq/multishare/bean/a;", "itemView", "<init>", "(Landroid/view/View;)V", "I", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f extends RecyclerView.ViewHolder implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ImageView avatar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView name;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView arrow;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.multishare.bean.a user;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/f$a;", "", "", "CHAT_TYPE_C2C", "I", "CHAT_TYPE_GROUP", "CHAT_TYPE_UNKNOWN", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.widget.f$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.zja);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026e_users_list_item_avatar)");
        this.avatar = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zjb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026are_users_list_item_name)");
        this.name = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.zj_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026re_users_list_item_arrow)");
        this.arrow = (ImageView) findViewById3;
        itemView.setOnClickListener(this);
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        cVar.i(context, itemView);
    }

    private final void m(com.tencent.mobileqq.multishare.bean.a user) {
        com.tencent.mobileqq.multishare.util.d dVar = com.tencent.mobileqq.multishare.util.d.f251801a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        dVar.c(context, user.d(), user.e(), user.b(), this.avatar, "LOAD_SOURCE_RECENT_FRIENDS");
    }

    private final int n(int uinType) {
        if (uinType == 0) {
            return 1;
        }
        if (uinType != 1) {
            return 0;
        }
        return 2;
    }

    private final void o() {
        String d16;
        com.tencent.mobileqq.multishare.bean.a aVar = this.user;
        if (aVar != null) {
            int n3 = n(aVar.e());
            if (n3 == 1) {
                d16 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(aVar.d());
            } else {
                d16 = aVar.d();
            }
            String uid = d16;
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
            Context context = this.avatar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "avatar.context");
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            IAIOStarterApi.a.c(iAIOStarterApi, context, n3, uid, aVar.c(), null, 16, null);
        }
    }

    public final void l(@NotNull com.tencent.mobileqq.multishare.bean.a user) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) user);
            return;
        }
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
        this.name.setText(user.c());
        m(user);
        this.arrow.setVisibility(8);
        this.itemView.setClickable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else if (v3 != null) {
            o();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
