package com.tencent.sqshow.zootopia.usercenter.friend.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.usercenter.friend.data.FollowStateChangedEvent;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterFollowView;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import su4.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002ABB\u000f\u0012\u0006\u0010.\u001a\u00020+\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0002J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001e\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010\u0016\u001a\u00020\bJ\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011J\u001e\u0010\u001c\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\b\b\u0002\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\bH\u0016J\u001c\u0010'\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\bH\u0016J,\u0010*\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\b2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0014H\u0016R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u0017R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0017R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b$b;", "", "B", "Lsu4/i;", "relationInfo", "holder", "", com.tencent.luggage.wxa.c8.c.G, "justRefreshRelation", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "justRefreshRelationButton", BdhLogUtil.LogTag.Tag_Conn, "y", "", "uin", "w", "", "userList", "newFansNum", "I", "tabType", "name", "J", "", "u", "userRelationInfo", "v", "K", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "H", UserInfo.SEX_FEMALE, "", "payloads", "G", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "e", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "f", h.F, "Ljava/lang/String;", "tabName", "i", "newFanNum", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lid3/d;", "dtReporter", "<init>", "(Landroid/content/Context;)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends RecyclerView.Adapter<C9844b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<i> userList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int tabType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String tabName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int newFanNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u00020\u0019\u00a2\u0006\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR$\u00100\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b/\u0010\u0010\u00a8\u00064"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b$b;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "d", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "c", "()Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "setAvatarView", "(Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;)V", "avatarView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", h.F, "()Landroid/widget/TextView;", "setNickView", "(Landroid/widget/TextView;)V", "nickView", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView;", "f", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView;", "()Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView;", "setButtonView", "(Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView;)V", "buttonView", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "dividerView", "i", "setDividerView2", "dividerView2", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "g", "()Landroid/widget/ImageView;", "setFlagView", "(Landroid/widget/ImageView;)V", "flagView", BdhLogUtil.LogTag.Tag_Conn, "b", "setAvatarBorder", "avatarBorder", "D", "setTitleView", "titleView", "itemView", "<init>", "(Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b;Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.usercenter.friend.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public final class C9844b extends RecyclerView.ViewHolder {

        /* renamed from: C, reason: from kotlin metadata */
        private View avatarBorder;

        /* renamed from: D, reason: from kotlin metadata */
        private TextView titleView;
        final /* synthetic */ b E;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private RoundCornerImageView avatarView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private TextView nickView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private ZPlanUserCenterFollowView buttonView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private View dividerView;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private View dividerView2;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ImageView flagView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9844b(b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
            this.avatarView = (RoundCornerImageView) itemView.findViewById(R.id.pvy);
            this.nickView = (TextView) itemView.findViewById(R.id.pw6);
            this.buttonView = (ZPlanUserCenterFollowView) itemView.findViewById(R.id.pvz);
            this.dividerView = itemView.findViewById(R.id.f163392pw1);
            this.dividerView2 = itemView.findViewById(R.id.f163393pw2);
            this.flagView = (ImageView) itemView.findViewById(R.id.f163394pw3);
            this.avatarBorder = itemView.findViewById(R.id.f163391pw0);
            this.titleView = (TextView) itemView.findViewById(R.id.pwe);
            RoundCornerImageView roundCornerImageView = this.avatarView;
            if (roundCornerImageView != null) {
                roundCornerImageView.setRadius(ViewUtils.dpToPx(22.0f));
            }
        }

        /* renamed from: b, reason: from getter */
        public final View getAvatarBorder() {
            return this.avatarBorder;
        }

        /* renamed from: c, reason: from getter */
        public final RoundCornerImageView getAvatarView() {
            return this.avatarView;
        }

        /* renamed from: d, reason: from getter */
        public final ZPlanUserCenterFollowView getButtonView() {
            return this.buttonView;
        }

        /* renamed from: e, reason: from getter */
        public final View getDividerView() {
            return this.dividerView;
        }

        /* renamed from: f, reason: from getter */
        public final View getDividerView2() {
            return this.dividerView2;
        }

        /* renamed from: g, reason: from getter */
        public final ImageView getFlagView() {
            return this.flagView;
        }

        /* renamed from: h, reason: from getter */
        public final TextView getNickView() {
            return this.nickView;
        }

        /* renamed from: i, reason: from getter */
        public final TextView getTitleView() {
            return this.titleView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/b$c", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView$b;", "", "uin", "", "relation", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ZPlanUserCenterFollowView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f373168a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f373169b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanUserCenterFollowView f373170c;

        c(i iVar, b bVar, ZPlanUserCenterFollowView zPlanUserCenterFollowView) {
            this.f373168a = iVar;
            this.f373169b = bVar;
            this.f373170c = zPlanUserCenterFollowView;
        }

        @Override // com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterFollowView.b
        public void a(long uin, int relation) {
            i iVar = this.f373168a;
            if (iVar.f434792a == uin) {
                iVar.f434796e = relation;
            }
            SimpleEventBus.getInstance().dispatchEvent(new FollowStateChangedEvent(this.f373168a));
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_tab_id", Integer.valueOf(this.f373169b.tabType));
            hashMap.put("zplan_tab_name", this.f373169b.tabName);
            hashMap.put("zplan_follow_status", Integer.valueOf(this.f373168a.f434796e));
            this.f373169b.dtReporter.c("clck", this.f373170c, hashMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/b$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements e<su4.b> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C9844b f373172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f373173f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f373174h;

        d(C9844b c9844b, boolean z16, int i3) {
            this.f373172e = c9844b;
            this.f373173f = z16;
            this.f373174h = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            i[] iVarArr = result.f434771a;
            Intrinsics.checkNotNullExpressionValue(iVarArr, "result.userRelationInfoList");
            if (!(iVarArr.length == 0)) {
                b bVar = b.this;
                i iVar = result.f434771a[0];
                Intrinsics.checkNotNullExpressionValue(iVar, "result.userRelationInfoList[0]");
                bVar.C(iVar, this.f373172e, this.f373173f);
                List<i> A = b.this.A();
                int i3 = this.f373174h;
                i iVar2 = result.f434771a[0];
                Intrinsics.checkNotNullExpressionValue(iVar2, "result.userRelationInfoList[0]");
                A.set(i3, iVar2);
                return;
            }
            QLog.e("ZPlanFriendListAdapter", 1, "getUserInfo error :: userRelationInfoList is empty");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanFriendListAdapter", 1, "getUserInfo error :: error == " + error + " , message == " + message);
        }
    }

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.userList = new ArrayList();
        this.tabName = "";
        this.dtReporter = new id3.d(null, 1, null);
    }

    private final boolean B() {
        return this.newFanNum > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(i relationInfo, C9844b holder, boolean justRefreshRelationButton) {
        y(holder, relationInfo);
        if (justRefreshRelationButton) {
            return;
        }
        String avatarUrl = relationInfo.f434794c;
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
        if (avatarUrl.length() > 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = q.b(R.drawable.ik6);
            obtain.mFailedDrawable = q.b(R.drawable.ik6);
            URLDrawable drawable = URLDrawable.getDrawable(avatarUrl, URLDrawable.URLDrawableOptions.obtain());
            RoundCornerImageView avatarView = holder.getAvatarView();
            if (avatarView != null) {
                avatarView.setImageDrawable(drawable);
            }
        } else {
            RoundCornerImageView avatarView2 = holder.getAvatarView();
            if (avatarView2 != null) {
                avatarView2.setImageResource(R.drawable.ik6);
            }
        }
        String avatarBorder = relationInfo.f434795d;
        Intrinsics.checkNotNullExpressionValue(avatarBorder, "avatarBorder");
        if (avatarBorder.length() > 0) {
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain2.mLoadingDrawable = drawable2;
            obtain2.mFailedDrawable = drawable2;
            URLDrawable drawable3 = URLDrawable.getDrawable(avatarBorder, obtain2);
            View avatarBorder2 = holder.getAvatarBorder();
            if (avatarBorder2 != null) {
                avatarBorder2.setBackground(drawable3);
            }
        } else {
            View avatarBorder3 = holder.getAvatarBorder();
            if (avatarBorder3 != null) {
                avatarBorder3.setBackgroundResource(R.drawable.f159932ij1);
            }
        }
        String str = relationInfo.f434793b;
        TextView nickView = holder.getNickView();
        if (nickView != null) {
            nickView.setText(str);
        }
        boolean z16 = relationInfo.f434797f;
        ImageView flagView = holder.getFlagView();
        if (flagView != null) {
            flagView.setVisibility(z16 ? 0 : 8);
        }
        boolean z17 = holder.getAdapterPosition() != getItemCount() - 1;
        View dividerView = holder.getDividerView();
        if (dividerView != null) {
            dividerView.setVisibility(z17 ? 0 : 8);
        }
        if (holder.getItemViewType() == 3) {
            View dividerView2 = holder.getDividerView2();
            if (dividerView2 != null) {
                dividerView2.setVisibility(0);
            }
            View dividerView3 = holder.getDividerView();
            if (dividerView3 != null) {
                dividerView3.setVisibility(8);
            }
        } else {
            View dividerView22 = holder.getDividerView2();
            if (dividerView22 != null) {
                dividerView22.setVisibility(8);
            }
        }
        w(holder, String.valueOf(relationInfo.f434792a));
    }

    private final boolean D(i relationInfo, boolean justRefreshRelation) {
        String str = relationInfo.f434794c;
        Intrinsics.checkNotNullExpressionValue(str, "relationInfo.avatar");
        return str.length() > 0;
    }

    private final void w(final C9844b holder, final String uin) {
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.friend.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.x(uin, this, holder, view);
            }
        });
        View view = holder.itemView;
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_tab_id", Integer.valueOf(this.tabType));
            hashMap.put("zplan_tab_name", this.tabName);
            id3.d.i(this.dtReporter, view, "em_zplan_friend_area", hashMap, true, true, null, false, false, 224, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(String uin, b this$0, C9844b holder, View view) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (com.tencent.sqshow.zootopia.utils.h.a()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid", uin);
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null) {
            b16 = ZootopiaSource.INSTANCE.g();
        }
        ((IEntryApi) QRoute.api(IEntryApi.class)).startUserCenterFragment(this$0.context, b16, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_tab_id", Integer.valueOf(this$0.tabType));
        hashMap.put("zplan_tab_name", this$0.tabName);
        id3.d dVar = this$0.dtReporter;
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        dVar.c("clck", view2, hashMap);
    }

    private final void y(C9844b holder, i relationInfo) {
        ZPlanUserCenterFollowView buttonView = holder.getButtonView();
        if (buttonView != null) {
            buttonView.setRelation(relationInfo.f434792a, relationInfo.f434796e);
        }
        ZPlanUserCenterFollowView buttonView2 = holder.getButtonView();
        if (buttonView2 != null) {
            buttonView2.setRelationUpdateListener(new c(relationInfo, this, buttonView2));
        }
        ZPlanUserCenterFollowView buttonView3 = holder.getButtonView();
        if (buttonView3 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_tab_id", Integer.valueOf(this.tabType));
            hashMap.put("zplan_tab_name", this.tabName);
            hashMap.put("zplan_follow_status", Integer.valueOf(relationInfo.f434796e));
            id3.d.i(this.dtReporter, buttonView3, "em_zplan_follow", hashMap, true, true, null, false, false, 224, null);
        }
    }

    public final List<i> A() {
        return this.userList;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C9844b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C9844b holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position, payloads);
        if (holder.getItemViewType() == 2) {
            TextView titleView = holder.getTitleView();
            if (titleView == null) {
                return;
            }
            titleView.setText("\u65b0\u589e\u7c89\u4e1d\u00b7" + this.newFanNum);
            return;
        }
        if (B()) {
            position = RangesKt___RangesKt.coerceAtLeast(0, position - 1);
        }
        z(this.userList.get(position), holder, position, payloads != null ? !payloads.isEmpty() : false);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public C9844b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View itemView = LayoutInflater.from(this.context).inflate(R.layout.dh7, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new C9844b(this, itemView);
        }
        View itemView2 = LayoutInflater.from(this.context).inflate(R.layout.dh6, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        return new C9844b(this, itemView2);
    }

    public final void I(List<i> userList, int newFansNum) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        if (Intrinsics.areEqual(this.userList, userList)) {
            return;
        }
        this.userList = userList;
        this.newFanNum = newFansNum;
        notifyDataSetChanged();
    }

    public final void J(int tabType, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.tabType = tabType;
        this.tabName = name;
    }

    public final void K(i userRelationInfo) {
        Intrinsics.checkNotNullParameter(userRelationInfo, "userRelationInfo");
        int size = this.userList.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.userList.get(i3);
            if (iVar.f434792a == userRelationInfo.f434792a) {
                iVar.f434796e = userRelationInfo.f434796e;
                notifyItemChanged(i3, 1);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (B()) {
            return this.userList.size() + 1;
        }
        return this.userList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (!B()) {
            return 1;
        }
        if (position == 0) {
            return 2;
        }
        return position == this.newFanNum ? 3 : 1;
    }

    public final void u(List<i> userList, int newFansNum) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        this.userList.addAll(userList);
        this.newFanNum = newFansNum;
        notifyItemInserted(userList.size());
    }

    public final void v(i userRelationInfo) {
        Intrinsics.checkNotNullParameter(userRelationInfo, "userRelationInfo");
        this.userList.add(0, userRelationInfo);
        notifyItemInserted(0);
    }

    private final void z(i relationInfo, C9844b holder, int pos, boolean justRefreshRelation) {
        if (E(this, relationInfo, false, 2, null)) {
            QLog.i("ZPlanFriendListAdapter", 1, "onBindViewHolder :: data is valid");
            C(relationInfo, holder, justRefreshRelation);
            return;
        }
        QLog.i("ZPlanFriendListAdapter", 1, "onBindViewHolder :: data is invalid");
        RoundCornerImageView avatarView = holder.getAvatarView();
        if (avatarView != null) {
            avatarView.setImageResource(R.drawable.ik6);
        }
        TextView nickView = holder.getNickView();
        if (nickView != null) {
            nickView.setText("");
        }
        lc4.a.f414373a.f(relationInfo.f434792a, new d(holder, justRefreshRelation, pos));
    }

    static /* synthetic */ boolean E(b bVar, i iVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bVar.D(iVar, z16);
    }
}
