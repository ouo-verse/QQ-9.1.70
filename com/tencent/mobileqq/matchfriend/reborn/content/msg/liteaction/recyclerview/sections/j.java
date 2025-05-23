package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import android.content.Context;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionDeleteEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionListPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$DeleteInterMsgReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$DeleteInterMsgRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0010\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/j;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "Landroid/view/View;", "mRootView", "onInitView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "inputData", "", "position", "", "", "payload", "y", "", "getViewStubLayoutId", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "f", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "swipeLayout", tl.h.F, "Landroid/view/View;", "deleteButtonView", "<init>", "()V", "i", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SwipeMenuLayout swipeLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View deleteButtonView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("ClickSection", 2, "[SsoDeleteInterMsg] isSuccess=" + z16);
        }
        if (z16 && (obj instanceof byte[])) {
            InteractiveMsgServicePB$DeleteInterMsgRsp interactiveMsgServicePB$DeleteInterMsgRsp = new InteractiveMsgServicePB$DeleteInterMsgRsp();
            try {
                interactiveMsgServicePB$DeleteInterMsgRsp.mergeFrom((byte[]) obj);
                if (interactiveMsgServicePB$DeleteInterMsgRsp.rsp_head.ret_code.get() != 0) {
                    return;
                }
                QLog.i("ClickSection", 1, "[SsoDeleteInterMsg]fail_list=" + interactiveMsgServicePB$DeleteInterMsgRsp.msg_ids_del_failed.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("ClickSection", 2, "[SsoDeleteInterMsg] error: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(j this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z();
    }

    private final void C() {
        if (u.a().b()) {
            return;
        }
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo == null) {
            return;
        }
        int sceneId = getData().getSceneId();
        if (sceneId != 6 && sceneId != 7 && sceneId != 8) {
            com.tencent.mobileqq.matchfriend.reborn.utils.l.g(this.mRootView.getContext(), getData().getUserId(), 9, 8, null, 16, null);
        } else {
            NBPArticleFeedDetailPageSource nBPArticleFeedDetailPageSource = NBPArticleFeedDetailPageSource.INTERACTIVE_NOTIFICATION;
            QQStrangerLiteActionModel data = getData();
            Context context = this.mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            com.tencent.mobileqq.matchfriend.reborn.utils.l.i(nBPArticleFeedDetailPageSource, data, userinfo_miniinfo, context, false, 16, null);
        }
        a82.a aVar = a82.a.f25717a;
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        aVar.b(mRootView, new HashMap<>(), getData());
    }

    private final void w() {
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.x(j.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(j this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    private final void z() {
        SwipeMenuLayout swipeMenuLayout = this.swipeLayout;
        if (swipeMenuLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeLayout");
            swipeMenuLayout = null;
        }
        swipeMenuLayout.h();
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLiteActionDeleteEvent(getPosition()));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        InteractiveMsgServicePB$DeleteInterMsgReq interactiveMsgServicePB$DeleteInterMsgReq = new InteractiveMsgServicePB$DeleteInterMsgReq();
        ArrayList arrayList = new ArrayList();
        arrayList.add(getData().getMsgId());
        interactiveMsgServicePB$DeleteInterMsgReq.msg_ids.set(arrayList);
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.InteractiveMsgSvr.SsoDeleteInterMsg", interactiveMsgServicePB$DeleteInterMsgReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.i
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                j.A(i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerLiteActionModel inputData, int position, List<Object> payload) {
        HashMap hashMap = new HashMap();
        s(position);
        if (inputData == null) {
            return;
        }
        r(inputData);
        if (!getData().getHasRead()) {
            View view = this.mRootView;
            view.setBackground(ResourcesCompat.getDrawable(view.getContext().getResources(), R.drawable.f9e, null));
        } else {
            View view2 = this.mRootView;
            view2.setBackground(ResourcesCompat.getDrawable(view2.getContext().getResources(), R.drawable.qui_common_fill_light_primary_bg_selector, null));
        }
        if (QQStrangerLiteActionListPart.INSTANCE.a(getData().getMsgId(), "pg_kl_new_chat_list")) {
            a82.a aVar = a82.a.f25717a;
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            aVar.c(mRootView, getData(), position, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View mRootView) {
        if (mRootView != null) {
            this.mRootView = mRootView;
            this.swipeLayout = (SwipeMenuLayout) mRootView;
            this.mRootView = mRootView.findViewById(R.id.onu);
            View findViewById = mRootView.findViewById(R.id.onp);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qqs\u2026r_lite_action_delete_btn)");
            this.deleteButtonView = findViewById;
            w();
            View view = this.deleteButtonView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteButtonView");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.B(j.this, view2);
                }
            });
        }
    }
}
