package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.helpers.e;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.a;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudOfficialaccount$TopUserDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001d\u001eB\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lfeedcloud/FeedCloudOfficialaccount$TopUserDetail;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/a$b;", "holder", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "j0", "", "l0", "Landroid/view/View;", "itemView", "", "position", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "m0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "itemHasShowAnimList", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends ListAdapter<FeedCloudOfficialaccount$TopUserDetail, b> {
    private static final int D = ViewUtils.dip2px(56.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> itemHasShowAnimList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "p", "()Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "setAvatarView", "(Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;)V", "avatarView", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "o", "()Landroid/view/View;", "setApertureView", "(Landroid/view/View;)V", "apertureView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "nicknameTv", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/a;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QCircleAvatarView avatarView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private View apertureView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView nicknameTv;
        final /* synthetic */ a H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull final a aVar, final View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = aVar;
            View findViewById = itemView.findViewById(R.id.vcq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.follow_list_item_avatar)");
            this.avatarView = (QCircleAvatarView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.vcr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026ist_item_avatar_aperture)");
            this.apertureView = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.vcs);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026ollow_list_item_nickname)");
            this.nicknameTv = (TextView) findViewById3;
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.m(a.b.this, aVar, itemView, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, a this$1, View itemView, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition != -1) {
                FeedCloudOfficialaccount$TopUserDetail i06 = a.i0(this$1, adapterPosition);
                FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                feedCloudMeta$StUser.f398463id.set(i06.uin.get());
                e.f84616a.e(itemView, feedCloudMeta$StUser, "14");
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final View getApertureView() {
            return this.apertureView;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final QCircleAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final TextView getNicknameTv() {
            return this.nicknameTv;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull DiffUtil.ItemCallback<FeedCloudOfficialaccount$TopUserDetail> diffCallback) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.itemHasShowAnimList = new ArrayList();
    }

    public static final /* synthetic */ FeedCloudOfficialaccount$TopUserDetail i0(a aVar, int i3) {
        return aVar.getItem(i3);
    }

    private final void j0(b holder, FeedCloudOfficialaccount$TopUserDetail item) {
        boolean z16;
        holder.getNicknameTv().setText(item.nick.get());
        String str = item.avatar_url.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QFSPublicAccountFollowListAdapter", 1, "bindData, avatar_url is empty, nick:" + item.nick.get());
            QCircleAvatarView avatarView = holder.getAvatarView();
            int i3 = D;
            avatarView.setAvatarByUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/general_icon/feed_avatar_nodata.png", new Size(i3, i3));
        } else {
            QCircleAvatarView avatarView2 = holder.getAvatarView();
            String str2 = item.avatar_url.get();
            int i16 = D;
            avatarView2.setAvatarByUrl(str2, new Size(i16, i16));
        }
        if (item.show_aperture.get()) {
            if (this.itemHasShowAnimList.contains(l0(item))) {
                e.f84616a.f(holder.getApertureView(), 2.0f);
                return;
            } else {
                e.f84616a.g(holder.getApertureView(), 2.0f);
                this.itemHasShowAnimList.add(l0(item));
                return;
            }
        }
        e.f84616a.a(holder.getApertureView());
    }

    private final void k0(FeedCloudOfficialaccount$TopUserDetail item, View itemView, int position) {
        String str;
        VideoReport.setElementId(itemView, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_AUTHOR_INFO);
        VideoReport.setElementReuseIdentifier(itemView, item.uin.get());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
        String str2 = item.uin.get();
        Intrinsics.checkNotNullExpressionValue(str2, "item.uin.get()");
        hashMap.put("xsj_target_qq", str2);
        hashMap.put("xsj_index", Integer.valueOf(position + 1));
        if (item.show_aperture.get()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_APERTURE, str);
        VideoReport.setElementParams(itemView, hashMap);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
    }

    private final String l0(FeedCloudOfficialaccount$TopUserDetail item) {
        return item.uin + "-" + item.nick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        int dpToPx;
        int dpToPx2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            dpToPx = ViewUtils.dpToPx(16.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(8.0f);
        }
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            dpToPx2 = ViewUtils.dpToPx(16.0f);
        } else {
            dpToPx2 = ViewUtils.dpToPx(8.0f);
        }
        View view = holder.itemView;
        view.setPadding(dpToPx, view.getPaddingTop(), dpToPx2, holder.itemView.getPaddingBottom());
        FeedCloudOfficialaccount$TopUserDetail item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        j0(holder, item);
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        k0(item, view2, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.g58, parent, false);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }
}
