package com.qzone.reborn.message.section;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bl.CommonNoticeBean;
import bl.CommonStRichMsg;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.message.adapter.QZonePassiveMessageCommentImageAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J*\u0010\u0013\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/message/section/al;", "Lcom/qzone/reborn/message/section/y;", "", "Lbl/h;", "noticeMessage", "", UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "D", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "mCommentPictureGrid", "Lcom/qzone/reborn/message/adapter/QZonePassiveMessageCommentImageAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/message/adapter/QZonePassiveMessageCommentImageAdapter;", "mCommentImageAdapter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class al extends y {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mCommentPictureGrid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZonePassiveMessageCommentImageAdapter mCommentImageAdapter;

    private final void F(List<CommonStRichMsg> noticeMessage) {
        Object lastOrNull;
        int collectionSizeOrDefault;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) noticeMessage);
        CommonStRichMsg commonStRichMsg = (CommonStRichMsg) lastOrNull;
        List<CommonStMedia> b16 = commonStRichMsg != null ? commonStRichMsg.b() : null;
        List<CommonStMedia> list = b16;
        if (list == null || list.isEmpty()) {
            RecyclerView recyclerView = this.mCommentPictureGrid;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = this.mCommentPictureGrid;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (this.mCommentImageAdapter == null) {
            QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter = new QZonePassiveMessageCommentImageAdapter();
            this.mCommentImageAdapter = qZonePassiveMessageCommentImageAdapter;
            RecyclerView recyclerView3 = this.mCommentPictureGrid;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(qZonePassiveMessageCommentImageAdapter);
            }
        }
        QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter2 = this.mCommentImageAdapter;
        if (qZonePassiveMessageCommentImageAdapter2 != null) {
            List<CommonStMedia> list2 = b16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(com.qzone.reborn.message.data.e.C((CommonStMedia) it.next()));
            }
            qZonePassiveMessageCommentImageAdapter2.setDatas(arrayList);
        }
        Comment comment = new Comment();
        comment.user = new User(LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""));
        QZonePassiveMessageCommentImageAdapter qZonePassiveMessageCommentImageAdapter3 = this.mCommentImageAdapter;
        if (qZonePassiveMessageCommentImageAdapter3 != null) {
            qZonePassiveMessageCommentImageAdapter3.i0(comment);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        RecyclerView recyclerView = (RecyclerView) containerView.findViewById(R.id.mim);
        this.mCommentPictureGrid = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext(), 0, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            F(data.getNotice().h());
        }
    }
}
