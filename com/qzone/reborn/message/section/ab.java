package com.qzone.reborn.message.section;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import bl.CommonNoticeBean;
import cl.CommonNoticeInteractiveInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.message.common.widget.CommonNoticeInteractiveButton;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014R\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/message/section/ab;", "Lcom/qzone/reborn/message/section/y;", "", "Lcl/c;", "interactiveActions", "", "G", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton;", "interactButton", "O", "P", "M", "H", "K", "L", "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "N", "i", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton;", "firstButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "secondButton", "Ldl/a;", BdhLogUtil.LogTag.Tag_Conn, "Ldl/a;", "commentIoc", "Ldl/b;", "D", "Ldl/b;", "commentLikeIoc", "Ldl/d;", "E", "Ldl/d;", "joinAlbumIoc", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private dl.a commentIoc;

    /* renamed from: D, reason: from kotlin metadata */
    private dl.b commentLikeIoc;

    /* renamed from: E, reason: from kotlin metadata */
    private dl.d joinAlbumIoc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonNoticeInteractiveButton firstButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonNoticeInteractiveButton secondButton;

    private final void G(List<CommonNoticeInteractiveInfo> interactiveActions) {
        Object firstOrNull;
        Object orNull;
        RFWLog.i("QZonePassiveMessageButtonSection", RFWLog.USR, "interactive button size: " + interactiveActions.size());
        CommonNoticeInteractiveButton commonNoticeInteractiveButton = this.firstButton;
        CommonNoticeInteractiveButton commonNoticeInteractiveButton2 = null;
        if (commonNoticeInteractiveButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstButton");
            commonNoticeInteractiveButton = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) interactiveActions);
        commonNoticeInteractiveButton.setData(firstOrNull);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton3 = this.secondButton;
        if (commonNoticeInteractiveButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondButton");
            commonNoticeInteractiveButton3 = null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(interactiveActions, 1);
        commonNoticeInteractiveButton3.setData(orNull);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton4 = this.firstButton;
        if (commonNoticeInteractiveButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstButton");
            commonNoticeInteractiveButton4 = null;
        }
        CommonNoticeInteractiveButton commonNoticeInteractiveButton5 = this.firstButton;
        if (commonNoticeInteractiveButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstButton");
            commonNoticeInteractiveButton5 = null;
        }
        commonNoticeInteractiveButton4.setVisibility(commonNoticeInteractiveButton5.getData() != null ? 0 : 8);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton6 = this.secondButton;
        if (commonNoticeInteractiveButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondButton");
            commonNoticeInteractiveButton6 = null;
        }
        CommonNoticeInteractiveButton commonNoticeInteractiveButton7 = this.secondButton;
        if (commonNoticeInteractiveButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondButton");
            commonNoticeInteractiveButton7 = null;
        }
        commonNoticeInteractiveButton6.setVisibility(commonNoticeInteractiveButton7.getData() == null ? 8 : 0);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton8 = this.firstButton;
        if (commonNoticeInteractiveButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstButton");
            commonNoticeInteractiveButton8 = null;
        }
        O(commonNoticeInteractiveButton8);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton9 = this.secondButton;
        if (commonNoticeInteractiveButton9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondButton");
        } else {
            commonNoticeInteractiveButton2 = commonNoticeInteractiveButton9;
        }
        O(commonNoticeInteractiveButton2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        ho.i.g().b(p(), String.valueOf(gl.c.f402376a.f(((CommonNoticeBean) this.mData).getNotice().getOpUser(), ((CommonNoticeBean) this.mData).getCommonExt())), ((CommonNoticeBean) this.mData).getNotice().getOpUser().getNick());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        if (this.joinAlbumIoc == null) {
            this.joinAlbumIoc = (dl.d) q(dl.d.class);
        }
        dl.d dVar = this.joinAlbumIoc;
        if (dVar != null) {
            Object obj = ((CommonNoticeBean) this.mData).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            if (!(obj instanceof BusinessFeedData)) {
                obj = null;
            }
            dVar.s7((BusinessFeedData) obj, this.mPosition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        if (this.commentLikeIoc == null) {
            this.commentLikeIoc = (dl.b) q(dl.b.class);
        }
        dl.b bVar = this.commentLikeIoc;
        if (bVar != null) {
            bVar.F8((CommonNoticeBean) this.mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        long f16 = gl.c.f402376a.f(((CommonNoticeBean) this.mData).getNotice().getOpUser(), ((CommonNoticeBean) this.mData).getCommonExt());
        if (f16 != 0) {
            ho.i.z().l(p(), f16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        if (this.commentIoc == null) {
            this.commentIoc = (dl.a) q(dl.a.class);
        }
        dl.a aVar = this.commentIoc;
        if (aVar != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            aVar.c7((CommonNoticeBean) mData, this.mPosition);
        }
    }

    private final void O(CommonNoticeInteractiveButton interactButton) {
        String str;
        ViewGroup rootContainer = interactButton.getRootContainer();
        QZoneAsyncTextView rapidReplyText = interactButton.getRapidReplyText();
        CommonNoticeInteractiveInfo data = interactButton.getData();
        if (data == null) {
            RFWLog.e("QZonePassiveMessageButtonSection", RFWLog.USR, "button info is null, cannot report");
            return;
        }
        switch (data.getActionType()) {
            case 1:
                str = "em_qz_reply_button";
                break;
            case 2:
                str = "em_qz_chat";
                break;
            case 3:
                str = "em_qz_like";
                break;
            case 4:
                str = "em_qz_message_button";
                break;
            case 5:
                str = "em_qz_application_approve";
                break;
            case 6:
                str = "em_qz_backstep";
                break;
            case 7:
                str = "em_qz_thanks";
                break;
            case 8:
                str = "em_qz_view";
                break;
            default:
                return;
        }
        w(rootContainer, str);
        if (data.getRapidActionType() == 101) {
            w(rapidReplyText, "em_qz_quick_review_icon");
        }
    }

    private final void P(CommonNoticeInteractiveButton interactButton) {
        interactButton.setOnInteractListener(new CommonNoticeInteractiveButton.a() { // from class: com.qzone.reborn.message.section.z
            @Override // com.qzone.reborn.message.common.widget.CommonNoticeInteractiveButton.a
            public final void a(View view, CommonNoticeInteractiveInfo commonNoticeInteractiveInfo) {
                ab.Q(ab.this, view, commonNoticeInteractiveInfo);
            }
        });
        interactButton.setOnRapidInteractListener(new CommonNoticeInteractiveButton.b() { // from class: com.qzone.reborn.message.section.aa
            @Override // com.qzone.reborn.message.common.widget.CommonNoticeInteractiveButton.b
            public final void a(View view, CommonNoticeInteractiveInfo commonNoticeInteractiveInfo) {
                ab.R(view, commonNoticeInteractiveInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ab this$0, View view, CommonNoticeInteractiveInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        switch (info.getActionType()) {
            case 1:
                this$0.M();
                return;
            case 2:
                this$0.H();
                return;
            case 3:
                this$0.K();
                return;
            case 4:
                this$0.L();
                return;
            case 5:
                this$0.J();
                return;
            case 6:
            case 7:
            case 8:
                this$0.z(view);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(View view, CommonNoticeInteractiveInfo info) {
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(info, "info");
        info.getRapidActionType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n8c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ce_first_interactive_btn)");
        this.firstButton = (CommonNoticeInteractiveButton) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n8m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026e_second_interactive_btn)");
        this.secondButton = (CommonNoticeInteractiveButton) findViewById2;
        CommonNoticeInteractiveButton commonNoticeInteractiveButton = this.firstButton;
        if (commonNoticeInteractiveButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstButton");
            commonNoticeInteractiveButton = null;
        }
        P(commonNoticeInteractiveButton);
        CommonNoticeInteractiveButton commonNoticeInteractiveButton2 = this.secondButton;
        if (commonNoticeInteractiveButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondButton");
            commonNoticeInteractiveButton2 = null;
        }
        P(commonNoticeInteractiveButton2);
        if (gl.c.f402376a.a()) {
            CommonNoticeInteractiveButton commonNoticeInteractiveButton3 = this.firstButton;
            if (commonNoticeInteractiveButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstButton");
                commonNoticeInteractiveButton3 = null;
            }
            commonNoticeInteractiveButton3.getRootContainer().setBackground(ResourcesCompat.getDrawable(p().getResources(), R.drawable.f16185o, null));
            CommonNoticeInteractiveButton commonNoticeInteractiveButton4 = this.secondButton;
            if (commonNoticeInteractiveButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondButton");
                commonNoticeInteractiveButton4 = null;
            }
            commonNoticeInteractiveButton4.getRootContainer().setBackground(ResourcesCompat.getDrawable(p().getResources(), R.drawable.f16185o, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            G(data.getNotice().f());
        }
    }
}
