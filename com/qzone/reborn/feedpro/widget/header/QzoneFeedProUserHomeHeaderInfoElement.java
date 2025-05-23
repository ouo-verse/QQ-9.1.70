package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.UserProfile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderInfoElement;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "rsp", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "view", "o", "onInit", "", "k", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "getAvatarView", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "setAvatarView", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "avatarView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "nickName", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeHeaderInfoElement extends d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeHeaderInfoElement(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.avatarView = (QZoneUserAvatarView) containerView.findViewById(R.id.mwd);
        this.nickName = (TextView) containerView.findViewById(R.id.mwf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneFeedProUserHomeHeaderInfoElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) l(com.qzone.reborn.feedpro.viewmodel.m.class);
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(mVar.getHostUin());
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.avatarView;
        if (qZoneUserAvatarView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.i(com.qzone.reborn.feedpro.utils.aa.f54263a, qZoneUserAvatarView2, h().getContext(), 0, true, 2, null);
        }
        TextView textView = this.nickName;
        if (textView != null) {
            textView.setText(mVar.getHostNickname());
        }
        MutableLiveData<wd.h> d26 = mVar.d2();
        LifecycleOwner j3 = j();
        final Function1<wd.h, Unit> function1 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderInfoElement$onInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(wd.h hVar) {
                QzoneFeedProUserHomeHeaderInfoElement.this.q(hVar.getHeadRsp());
            }
        };
        d26.observe(j3, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeHeaderInfoElement.p(Function1.this, obj);
            }
        });
        o(this.avatarView);
    }

    private final void o(View view) {
        if (view != null) {
            fo.c.q(view, "em_qz_avatar", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(GetMainPageHeadRsp rsp) {
        String str;
        if (rsp != null) {
            QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
            if (qZoneUserAvatarView != null) {
                UserProfile userProfile = rsp.userProfile;
                qZoneUserAvatarView.setUser(ef.d.k(userProfile != null ? userProfile.uin : null));
            }
            TextView textView = this.nickName;
            if (textView == null) {
                return;
            }
            UserProfile userProfile2 = rsp.userProfile;
            if (userProfile2 == null || (str = userProfile2.nick) == null) {
                str = "";
            }
            textView.setText(str);
        }
    }
}
