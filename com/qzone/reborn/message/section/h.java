package com.qzone.reborn.message.section;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.message.adapter.QZonePassiveMessageCommentImageAdapter;
import com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u0004*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/message/section/h;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "D", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "Lcom/qzone/publish/ui/model/QzoneSuperPersonalFontData$SuperFontInfo;", "superFontInfo", "Lcom/qzone/publish/ui/model/QzoneBarrageEffectData$BarrageEffectInfo;", "barrageInfo", "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, tl.h.F, "Landroid/view/View;", "contentContainer", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "messageRichText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "settingGuideText", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "picsContentView", "Lcom/qzone/reborn/message/adapter/QZonePassiveMessageCommentImageAdapter;", "Lcom/qzone/reborn/message/adapter/QZonePassiveMessageCommentImageAdapter;", "picsContentAdapter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView picsContentView;

    /* renamed from: D, reason: from kotlin metadata */
    private QZonePassiveMessageCommentImageAdapter picsContentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View contentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView messageRichText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView settingGuideText;

    private final void C(BusinessFeedData feedData) {
        ArrayList<PictureItem> f16 = QZonePassiveMessageFeedPreprocessor.f58250a.f(feedData);
        if (f16 == null || f16.isEmpty()) {
            RecyclerView recyclerView = this.picsContentView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = this.picsContentView;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (this.picsContentAdapter == null) {
            QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter = new QZonePassiveMessageCommentImageAdapter();
            qZonePassiveMessageCommentImageAdapter.m0(0);
            qZonePassiveMessageCommentImageAdapter.l0(com.qzone.reborn.util.r.f59560a.e(70));
            this.picsContentAdapter = qZonePassiveMessageCommentImageAdapter;
            RecyclerView recyclerView3 = this.picsContentView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(qZonePassiveMessageCommentImageAdapter);
            }
        }
        QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter2 = this.picsContentAdapter;
        if (qZonePassiveMessageCommentImageAdapter2 != null) {
            qZonePassiveMessageCommentImageAdapter2.setDatas(f16);
        }
        Comment comment = new Comment();
        comment.user = new User(LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""));
        QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter3 = this.picsContentAdapter;
        if (qZonePassiveMessageCommentImageAdapter3 != null) {
            qZonePassiveMessageCommentImageAdapter3.i0(comment);
        }
    }

    private final void D(BusinessFeedData feedData) {
        CharSequence trim;
        String e16 = com.qzone.reborn.feedx.util.n.e(feedData);
        if (e16 == null) {
            e16 = "";
        }
        if (e16.length() == 0) {
            QZoneRichTextView qZoneRichTextView = this.messageRichText;
            if (qZoneRichTextView == null) {
                return;
            }
            qZoneRichTextView.setVisibility(8);
            return;
        }
        QZoneRichTextView qZoneRichTextView2 = this.messageRichText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setVisibility(0);
        }
        QZoneRichTextView qZoneRichTextView3 = this.messageRichText;
        if (qZoneRichTextView3 != null) {
            CellSummary cellSummaryV2 = feedData.getCellSummaryV2();
            QzoneSuperPersonalFontData.SuperFontInfo superFontInfo = cellSummaryV2 != null ? cellSummaryV2.superFontInfo : null;
            CellSummary cellSummaryV22 = feedData.getCellSummaryV2();
            B(qZoneRichTextView3, superFontInfo, cellSummaryV22 != null ? cellSummaryV22.barrageEffectInfo : null);
        }
        if (com.qzone.reborn.message.data.f.f58260a.e(feedData)) {
            QZoneRichTextView qZoneRichTextView4 = this.messageRichText;
            if (qZoneRichTextView4 != null) {
                qZoneRichTextView4.setLineSpace(com.qzone.reborn.util.r.f59560a.e(2));
            }
            QZoneRichTextView qZoneRichTextView5 = this.settingGuideText;
            if (qZoneRichTextView5 != null) {
                qZoneRichTextView5.setLineSpace(com.qzone.reborn.util.r.f59560a.e(2));
            }
            QZoneRichTextView qZoneRichTextView6 = this.settingGuideText;
            if (qZoneRichTextView6 != null) {
                qZoneRichTextView6.setVisibility(0);
            }
            trim = StringsKt__StringsKt.trim((CharSequence) QZonePassiveMessageFeedPreprocessor.f58250a.c(feedData.getCellSummaryV2()));
            String obj = trim.toString();
            QZoneRichTextView qZoneRichTextView7 = this.settingGuideText;
            if (qZoneRichTextView7 != null) {
                qZoneRichTextView7.setRichText(obj);
            }
        } else {
            QZoneRichTextView qZoneRichTextView8 = this.messageRichText;
            if (qZoneRichTextView8 != null) {
                qZoneRichTextView8.setLineSpace(com.qzone.reborn.util.r.f59560a.e(3));
            }
            QZoneRichTextView qZoneRichTextView9 = this.settingGuideText;
            if (qZoneRichTextView9 != null) {
                qZoneRichTextView9.setLineSpace(com.qzone.reborn.util.r.f59560a.e(3));
            }
            QZoneRichTextView qZoneRichTextView10 = this.settingGuideText;
            if (qZoneRichTextView10 != null) {
                qZoneRichTextView10.setVisibility(8);
            }
        }
        QZoneRichTextView qZoneRichTextView11 = this.messageRichText;
        if (qZoneRichTextView11 != null) {
            qZoneRichTextView11.setRichText(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dl.g w3 = this$0.w();
        if (w3 != null) {
            w3.t9((BusinessFeedData) this$0.mData, false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.contentContainer = containerView.findViewById(R.id.nbf);
        this.messageRichText = (QZoneRichTextView) containerView.findViewById(R.id.nbg);
        this.settingGuideText = (QZoneRichTextView) containerView.findViewById(R.id.n7p);
        QZoneRichTextView qZoneRichTextView = this.messageRichText;
        Float valueOf = Float.valueOf(16.0f);
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.G(h.this, view);
                }
            });
            com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
            qZoneRichTextView.setTextSize(rVar.d(valueOf));
            qZoneRichTextView.setPadding(0, 0, 0, 0);
            qZoneRichTextView.setLineSpace(rVar.e(3));
            qZoneRichTextView.setTextColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_primary, null));
            qZoneRichTextView.setTextColorLink(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null));
        }
        QZoneRichTextView qZoneRichTextView2 = this.settingGuideText;
        if (qZoneRichTextView2 != null) {
            com.qzone.reborn.util.r rVar2 = com.qzone.reborn.util.r.f59560a;
            qZoneRichTextView2.setTextSize(rVar2.d(valueOf));
            qZoneRichTextView2.setPadding(0, 0, 0, 0);
            qZoneRichTextView2.setLineSpace(rVar2.e(3));
            qZoneRichTextView2.setTextColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_primary, null));
            qZoneRichTextView2.setTextColorLink(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null));
        }
        RecyclerView recyclerView = (RecyclerView) containerView.findViewById(R.id.n9e);
        this.picsContentView = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext(), 0, false));
    }

    private final void B(QZoneRichTextView qZoneRichTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        qZoneRichTextView.setMaxLine(-1);
        QZoneFeedxViewUtils.j(qZoneRichTextView, null);
        qZoneRichTextView.setTextColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_primary, null));
        qZoneRichTextView.setTextColorLink(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null));
        qZoneRichTextView.setBarrageEffect(barrageEffectInfo != null, barrageEffectInfo);
        QZoneFeedxViewUtils.j(qZoneRichTextView, superFontInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nnf};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            D(data);
            C(data);
            QZoneRichTextView qZoneRichTextView = this.messageRichText;
            if (!(qZoneRichTextView != null && qZoneRichTextView.getVisibility() == 0)) {
                RecyclerView recyclerView = this.picsContentView;
                if (!(recyclerView != null && recyclerView.getVisibility() == 0)) {
                    View view = this.contentContainer;
                    if (view == null) {
                        return;
                    }
                    view.setVisibility(8);
                    return;
                }
            }
            View view2 = this.contentContainer;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(0);
        }
    }
}
