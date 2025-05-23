package com.tencent.qqnt.chathistory.ui.shortvideo.adapter;

import android.content.Context;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.f;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J6\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010$\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/ChatHistoryShortVideoItemProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "", "position", "Lkotlin/Pair;", "", "", "", "r", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "holder", "", "t", WadlProxyConsts.KEY_JUMP_URL, ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "c", "helper", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "payloads", "p", h.F, "Ljava/lang/String;", "curPageId", "d", "mJumpUrl", "f", "()I", "itemViewType", "<init>", "()V", "e", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoItemProvider extends com.tencent.qqnt.expandRecyclerView.adapter.provider.c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curPageId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mJumpUrl = "";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chathistory/ui/shortvideo/adapter/ChatHistoryShortVideoItemProvider$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null && outline != null) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getResources().getDimensionPixelSize(R.dimen.f158728ni));
            }
        }
    }

    private final String q(View view) {
        boolean z16;
        String str;
        if (view == null || view.getParent() == null) {
            return "";
        }
        if (this.curPageId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                Object parent = view.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                PageInfo pageInfo = VideoReport.getPageInfo((View) parent);
                if (pageInfo != null) {
                    str = pageInfo.getPageId();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                this.curPageId = str;
            } catch (Throwable unused) {
                return "";
            }
        }
        return this.curPageId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, List<Long>> r(CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = data.size() - 1;
        if (position <= size) {
            while (true) {
                com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = data.get(position);
                if (bVar instanceof ChatHistoryShortVideoItemModel) {
                    ChatHistoryShortVideoItemModel chatHistoryShortVideoItemModel = (ChatHistoryShortVideoItemModel) bVar;
                    String m3 = chatHistoryShortVideoItemModel.m();
                    if (m3 != null) {
                        arrayList.add(m3);
                    }
                    arrayList2.add(Long.valueOf(chatHistoryShortVideoItemModel.i()));
                }
                if (position == size) {
                    break;
                }
                position++;
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.tencent.qqnt.expandRecyclerView.adapter.a holder, String jumpUrl) {
        if (TextUtils.isEmpty(this.mJumpUrl)) {
            return;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        Map<String, Object> c16 = companion.a().c();
        if (c16 == null) {
            c16 = new LinkedHashMap<>();
        }
        c16.put("pgid", q(holder.itemView));
        IChatHistoryShortVideoApi iChatHistoryShortVideoApi = (IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class);
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        c16.put("video_id", iChatHistoryShortVideoApi.obtainJumpUrlKeyVal(sMobileQQ, jumpUrl, "xsj_feed_id"));
        IChatHistoryShortVideoApi iChatHistoryShortVideoApi2 = (IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class);
        MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
        c16.put("framer_uin", iChatHistoryShortVideoApi2.obtainJumpUrlKeyVal(sMobileQQ2, jumpUrl, QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN));
        HistoryDtReportHelper a16 = companion.a();
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        a16.m(view, "em_bas_video_card", c16);
    }

    private final void t(com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        if (TextUtils.isEmpty(this.mJumpUrl)) {
            return;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        Map<String, Object> c16 = companion.a().c();
        if (c16 == null) {
            c16 = new LinkedHashMap<>();
        }
        Map<String, Object> map = c16;
        map.put("pgid", q(holder.itemView));
        IChatHistoryShortVideoApi iChatHistoryShortVideoApi = (IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class);
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        map.put("video_id", iChatHistoryShortVideoApi.obtainJumpUrlKeyVal(sMobileQQ, this.mJumpUrl, "xsj_feed_id"));
        IChatHistoryShortVideoApi iChatHistoryShortVideoApi2 = (IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class);
        MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
        map.put("framer_uin", iChatHistoryShortVideoApi2.obtainJumpUrlKeyVal(sMobileQQ2, this.mJumpUrl, QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN));
        HistoryDtReportHelper.p(companion.a(), holder.itemView, "em_bas_video_card", map, null, 8, null);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    @NotNull
    public View c(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new f(context, null, null, false, 14, null).getRoot();
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public int f() {
        return 4;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public void h(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        t(holder);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(item instanceof ChatHistoryShortVideoItemModel)) {
            return;
        }
        ImageView imageView = (ImageView) helper.getView(R.id.f81194di);
        TextView textView = (TextView) helper.getView(R.id.f84764n5);
        RoundRectImageView roundRectImageView = (RoundRectImageView) helper.getView(R.id.f84724n1);
        TextView textView2 = (TextView) helper.getView(R.id.f84734n2);
        RelativeLayout relativeLayout = (RelativeLayout) helper.getView(R.id.f81184dh);
        String m3 = ((ChatHistoryShortVideoItemModel) item).m();
        if (m3 == null) {
            m3 = "";
        }
        this.mJumpUrl = m3;
        relativeLayout.setOutlineProvider(new b());
        relativeLayout.setClipToOutline(true);
        ExtensionsKt.b(this, item, payloads, new ChatHistoryShortVideoItemProvider$convert$2(textView, imageView, roundRectImageView, helper, textView2, this), new Function3<com.tencent.qqnt.expandRecyclerView.adapter.provider.c, ChatHistoryShortVideoItemModel, i, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.adapter.ChatHistoryShortVideoItemProvider$convert$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.c cast, @NotNull ChatHistoryShortVideoItemModel data, @NotNull i map) {
                Intrinsics.checkNotNullParameter(cast, "$this$cast");
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(map, "map");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.expandRecyclerView.adapter.provider.c cVar, ChatHistoryShortVideoItemModel chatHistoryShortVideoItemModel, i iVar) {
                invoke2(cVar, chatHistoryShortVideoItemModel, iVar);
                return Unit.INSTANCE;
            }
        });
    }
}
