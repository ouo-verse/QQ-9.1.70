package com.qzone.reborn.message.section;

import android.graphics.Paint;
import android.view.View;
import bl.CommonNoticeBean;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/message/section/as;", "Lcom/qzone/reborn/message/section/y;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", QCircleAlphaUserReporter.KEY_USER, "", "H", "Lbl/f;", UinConfigManager.KEY_ADS, "G", "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "K", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "tvNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class as extends y {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView tvNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    private final void G(bl.f notice) {
        if (notice.getOpUser().getNick().length() == 0) {
            return;
        }
        Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        QZoneNickNameView qZoneNickNameView = null;
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (com.qzone.reborn.message.data.f.f58260a.c(businessFeedData)) {
            QZoneNickNameView qZoneNickNameView2 = this.tvNickName;
            if (qZoneNickNameView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
                qZoneNickNameView2 = null;
            }
            qZoneNickNameView2.setMaxWidth(com.qzone.reborn.util.r.f59560a.e(130));
        } else {
            QZoneNickNameView qZoneNickNameView3 = this.tvNickName;
            if (qZoneNickNameView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
                qZoneNickNameView3 = null;
            }
            qZoneNickNameView3.setMaxWidth(com.qzone.reborn.util.r.f59560a.e(175));
        }
        QZoneNickNameView qZoneNickNameView4 = this.tvNickName;
        if (qZoneNickNameView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView4 = null;
        }
        Paint paint = qZoneNickNameView4.getPaint();
        if (paint != null) {
            paint.setShader(null);
        }
        QZoneNickNameView qZoneNickNameView5 = this.tvNickName;
        if (qZoneNickNameView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView5 = null;
        }
        int color = qZoneNickNameView5.getResources().getColor(R.color.qui_common_text_secondary);
        QZoneNickNameView qZoneNickNameView6 = this.tvNickName;
        if (qZoneNickNameView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
        } else {
            qZoneNickNameView = qZoneNickNameView6;
        }
        qZoneNickNameView.setData(businessFeedData, color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(CommonStUser user) {
        long f16 = gl.c.f402376a.f(user, ((CommonNoticeBean) this.mData).getCommonExt());
        if (f16 == 0) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(f16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        if (com.qzone.reborn.util.e.c("QZonePassiveMessageTitleSectionnickName", 2000L)) {
            RFWLog.i("QZonePassiveMessageTitleSection", RFWLog.USR, "[handleNickNameClick] too fast click, cancel");
        } else {
            ho.h.b(p(), gl.c.f402376a.f(((CommonNoticeBean) this.mData).getNotice().getOpUser(), ((CommonNoticeBean) this.mData).getCommonExt()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(as this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(as this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.qzone_user_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n87);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026(R.id.qzone_nike_name_tv)");
        this.tvNickName = (QZoneNickNameView) findViewById2;
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        QZoneNickNameView qZoneNickNameView = null;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                as.L(as.this, view);
            }
        });
        QZoneNickNameView qZoneNickNameView2 = this.tvNickName;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
        } else {
            qZoneNickNameView = qZoneNickNameView2;
        }
        qZoneNickNameView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                as.M(as.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8q};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            H(data.getNotice().getOpUser());
            G(data.getNotice());
        }
    }
}
