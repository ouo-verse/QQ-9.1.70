package nl;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import fj.s;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010-\u00a8\u00061"}, d2 = {"Lnl/l;", "Lnl/b;", "Landroid/view/View$OnClickListener;", "Lkl/a;", "data", "", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/StUser;", "stUser", "D", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "stNotice", UserInfo.SEX_FEMALE, "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "L", "view", NodeProps.ON_CLICK, "", tl.h.F, "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "tvNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "tvTime", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "rootLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends b implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvTime;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup rootLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneNoticeTitleSection";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView tvNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    private final void D(StUser stUser) {
        String a16 = s.f399470a.a(stUser.uin, stUser.nick);
        QZoneNickNameView qZoneNickNameView = this.tvNickName;
        QZoneNickNameView qZoneNickNameView2 = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setRichText(a16);
        QZoneNickNameView qZoneNickNameView3 = this.tvNickName;
        if (qZoneNickNameView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
        } else {
            qZoneNickNameView2 = qZoneNickNameView3;
        }
        x(qZoneNickNameView2, "em_qz_avatar_nickname_area");
    }

    private final void F(Notice stNotice) {
        String f16 = com.qzone.proxy.feedcomponent.util.c.f(stNotice.createTime * 1000, Calendar.getInstance());
        TextView textView = this.tvTime;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView = null;
        }
        textView.setText(f16);
        TextView textView3 = this.tvTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
        } else {
            textView2 = textView3;
        }
        x(textView2, "em_qz_avatar_nickname_area");
    }

    private final void G(kl.a data) {
        ViewGroup viewGroup = this.rootLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(getClickSpaceListener());
    }

    private final void H(StUser stUser) {
        if (TextUtils.isEmpty(stUser.uin)) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        QZoneUserAvatarView qZoneUserAvatarView2 = null;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(ef.d.k(stUser.uin));
        QZoneUserAvatarView qZoneUserAvatarView3 = this.avatarView;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            qZoneUserAvatarView2 = qZoneUserAvatarView3;
        }
        x(qZoneUserAvatarView2, "em_qz_avatar_nickname_area");
    }

    private final void J(final kl.a data) {
        RFWIocAbilityProvider.g().getIoc(il.a.class).originView(this.mRootView).done(new OnPromiseResolved() { // from class: nl.k
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.K(l.this, data, (il.a) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(l this$0, kl.a data, il.a reportIoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(reportIoc, "reportIoc");
        ViewGroup viewGroup = this$0.rootLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            viewGroup = null;
        }
        reportIoc.C1(viewGroup, data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onBindData(kl.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        Notice notice = data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String();
        StUser stUser = notice.opUser;
        G(data);
        Intrinsics.checkNotNullExpressionValue(stUser, "stUser");
        D(stUser);
        H(stUser);
        F(notice);
        J(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n87) {
            long g16 = mk.h.f416877a.g(((kl.a) this.mData).getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().opUser.uid, ((kl.a) this.mData).getStCommonExt());
            if (g16 == 0) {
                g16 = ef.d.k(((kl.a) this.mData).getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().opUser.uin);
            }
            ho.h.b(p(), g16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n87);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_nike_name_tv)");
        this.tvNickName = (QZoneNickNameView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.qzone_user_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nbi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026(R.id.qzone_time_desc_tv)");
        this.tvTime = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n7w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026essage_title_root_layout)");
        this.rootLayout = (ViewGroup) findViewById4;
        QZoneNickNameView qZoneNickNameView = this.tvNickName;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
