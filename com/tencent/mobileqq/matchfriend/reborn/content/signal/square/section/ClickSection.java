package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.util.QQToastUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0014J(\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/section/ClickSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "data", "", "w", BdhLogUtil.LogTag.Tag_Conn, "", "isSelf", "v", "D", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "view", "signalInfo", "G", "t", UserInfo.SEX_FEMALE, "y", "", "getViewStubLayoutId", "containerView", "onInitView", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onViewRecycled", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "chatView", "e", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "", "f", "Lkotlin/Lazy;", "u", "()Ljava/lang/String;", "myConstellation", "<init>", "()V", h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ClickSection extends Section<SignalPlazaSvrPB$SignalInfo> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView chatView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SignalPlazaSvrPB$SignalInfo signalInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy myConstellation;

    public ClickSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.ClickSection$myConstellation$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PBStringField pBStringField;
                Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
                String str = null;
                userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
                if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.constellation) != null) {
                    str = pBStringField.get();
                }
                return str == null ? "" : str;
            }
        });
        this.myConstellation = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ClickSection this$0, SignalPlazaSvrPB$SignalInfo data, boolean z16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.v(data, z16);
        VideoReport.setElementId(view, "em_kl_chat");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ClickSection this$0, SignalPlazaSvrPB$SignalInfo data, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.w(data);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.F(it, data);
    }

    private final void C(SignalPlazaSvrPB$SignalInfo data) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(getRootView().getContext(), data.open_id.get(), 10, 11);
        }
    }

    private final void F(View view, SignalPlazaSvrPB$SignalInfo signalInfo) {
        y(view, signalInfo);
        VideoReport.reportEvent("clck", view, null);
    }

    private final void G(final View view, final SignalPlazaSvrPB$SignalInfo signalInfo) {
        if (t(signalInfo)) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.c
            @Override // java.lang.Runnable
            public final void run() {
                ClickSection.H(ClickSection.this, view, signalInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ClickSection this$0, View view, SignalPlazaSvrPB$SignalInfo signalInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(signalInfo, "$signalInfo");
        this$0.y(view, signalInfo);
        VideoReport.reportEvent("imp", view, null);
    }

    private final void s(SignalPlazaSvrPB$SignalInfo data) {
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        iMatchFriendEntryApi.enterMatchFriendAIO(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, getRootView().getContext(), data.open_id.get(), 10, (Bundle) null);
    }

    private final boolean t(SignalPlazaSvrPB$SignalInfo signalInfo) {
        SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = this.signalInfo;
        if (signalPlazaSvrPB$SignalInfo != null) {
            return Intrinsics.areEqual(signalPlazaSvrPB$SignalInfo.open_id.get(), signalInfo.open_id.get());
        }
        return false;
    }

    private final String u() {
        return (String) this.myConstellation.getValue();
    }

    private final void w(SignalPlazaSvrPB$SignalInfo data) {
        if (x()) {
            C(data);
        } else {
            D();
        }
    }

    private final boolean x() {
        SignalPlazaSvrPB$SignalInfo b16 = com.tencent.mobileqq.matchfriend.reborn.content.signal.b.f244871a.b();
        if (b16 != null) {
            return ModelExtKt.q(b16);
        }
        return false;
    }

    private final void y(View view, SignalPlazaSvrPB$SignalInfo signalInfo) {
        VideoReport.setElementId(view, "em_kl_expansion_list_card");
        VideoReport.setElementParam(view, "kl_adjective_id", String.valueOf(ModelExtKt.j(signalInfo)));
        VideoReport.setElementParam(view, "kl_type_id", String.valueOf(ModelExtKt.k(signalInfo)));
        VideoReport.setElementParam(view, "kl_publisher_id", signalInfo.open_id.get().toString());
        VideoReport.setElementParam(view, "kl_online_state", Integer.valueOf(ModelExtKt.s(signalInfo) ? 1 : 0));
        Object[] array = ModelExtKt.o(signalInfo, u()).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        VideoReport.setElementParam(view, "kl_interest_tag", arrays);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.opq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026tranger_square_item_chat)");
        this.chatView = (ImageView) findViewById;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onViewRecycled() {
        String str;
        super.onViewRecycled();
        SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = this.signalInfo;
        if (signalPlazaSvrPB$SignalInfo == null || (str = ModelExtKt.A(signalPlazaSvrPB$SignalInfo)) == null) {
            str = "is null";
        }
        QLog.i("ClickSection", 2, "[onViewRecycled] signalInfo : " + str);
        this.signalInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(final SignalPlazaSvrPB$SignalInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        final boolean u16 = ModelExtKt.u(data);
        ImageView imageView = this.chatView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatView");
            imageView = null;
        }
        imageView.setImageResource(u16 ? R.drawable.f97 : R.drawable.f96);
        ImageView imageView2 = this.chatView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClickSection.A(ClickSection.this, data, u16, view);
            }
        }, 1, null));
        getRootView().setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClickSection.B(ClickSection.this, data, view);
            }
        }, 1, null));
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        G(rootView, data);
        this.signalInfo = data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void v(SignalPlazaSvrPB$SignalInfo data, boolean isSelf) {
        if (isSelf) {
            IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
            ImageView imageView = this.chatView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatView");
                imageView = null;
            }
            iMatchFriendEntryApi.openSignalPublisher(imageView.getContext(), true, data.signal_meta.partner_id.get(), data.signal_meta.partner_adj.partner_adj_id.get());
            return;
        }
        if (x()) {
            s(data);
        } else {
            D();
        }
    }

    private final void D() {
        QQToastUtil.showQQToast(0, R.string.x17);
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        ImageView imageView = this.chatView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatView");
            imageView = null;
        }
        iMatchFriendEntryApi.openSignalPublisher(imageView.getContext(), false);
    }
}
