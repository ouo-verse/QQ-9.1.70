package com.qzone.reborn.groupalbum.section.feed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellMediaInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.RoundRectURLImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/groupalbum/section/feed/e;", "Lcom/qzone/reborn/groupalbum/section/feed/n;", "Landroid/content/Context;", "context", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "O", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mAlbumNameTv", "G", "mAlbumTipsTv", "Lcom/tencent/widget/RoundRectURLImageView;", "H", "Lcom/tencent/widget/RoundRectURLImageView;", "mAlbumCover", "I", "Landroid/view/View;", "mUploadBtn", "J", "Z", "hasRight", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends n {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mAlbumNameTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mAlbumTipsTv;

    /* renamed from: H, reason: from kotlin metadata */
    private RoundRectURLImageView mAlbumCover;

    /* renamed from: I, reason: from kotlin metadata */
    private View mUploadBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasRight;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.Q(context);
    }

    private final void Q(final Context context) {
        Dialog createDialog = ActionSheetHelper.createDialog(i(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f132934r);
        actionSheet.addButton(R.string.f132944s);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                e.R(e.this, context, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.S(ActionSheet.this, view);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(e this$0, Context context, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            this$0.N(context);
            actionSheet.dismiss();
        } else {
            if (i3 != 1) {
                return;
            }
            this$0.O(context);
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0059, code lost:
    
        if (r0.getFromArk() == true) goto L14;
     */
    @Override // com.qzone.reborn.groupalbum.section.feed.n, vg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(View containerView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        super.C(containerView);
        this.mAlbumNameTv = (TextView) containerView.findViewById(R.id.f162736jz0);
        this.mAlbumTipsTv = (TextView) containerView.findViewById(R.id.k57);
        RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) containerView.findViewById(R.id.k0k);
        this.mAlbumCover = roundRectURLImageView;
        if (roundRectURLImageView != null) {
            roundRectURLImageView.setRadius(ar.d(4.0f));
        }
        View findViewById = containerView.findViewById(R.id.k58);
        this.mUploadBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.P(e.this, view);
                }
            });
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) r(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel != null) {
            z16 = true;
        }
        z16 = false;
        containerView.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "GroupAlbumFeedDetailTailPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnj;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private final void N(Context context) {
        CellIntimateSpaceInfo cellIntimateSpaceInfo;
        CellMediaInfo cellMediaInfo;
        CellGroupAlbumInfo cellGroupAlbumInfo;
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            if (!this.hasRight) {
                ToastUtil.o(R.string.f133135a, 4);
                return;
            }
            BusinessFeedData businessFeedData = this.f441565h;
            String str = null;
            String str2 = (businessFeedData == null || (cellGroupAlbumInfo = businessFeedData.cellGroupAlbumInfo) == null) ? null : cellGroupAlbumInfo.groupId;
            boolean z16 = false;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            BusinessFeedData businessFeedData2 = this.f441565h;
            if (businessFeedData2 != null && (cellMediaInfo = businessFeedData2.cellMediaInfo) != null) {
                str = cellMediaInfo.albumId;
            }
            if (str == null || str.length() == 0) {
                return;
            }
            CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
            String str3 = this.f441565h.cellMediaInfo.albumId;
            Intrinsics.checkNotNullExpressionValue(str3, "mFeedData.cellMediaInfo.albumId");
            commonAlbumInfo.V(str3);
            String str4 = this.f441565h.cellMediaInfo.albumName;
            Intrinsics.checkNotNullExpressionValue(str4, "mFeedData.cellMediaInfo.albumName");
            commonAlbumInfo.m0(str4);
            String str5 = this.f441565h.cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNullExpressionValue(str5, "mFeedData.cellGroupAlbumInfo.groupId");
            BusinessFeedData businessFeedData3 = this.f441565h;
            GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(str5, (businessFeedData3 == null || (cellIntimateSpaceInfo = businessFeedData3.cellIntimateSpaceInfo) == null) ? -1 : cellIntimateSpaceInfo.spaceType, true, commonAlbumInfo, 5);
            GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) r(GroupAlbumFeedDetailViewModel.class);
            if (groupAlbumFeedDetailViewModel != null && groupAlbumFeedDetailViewModel.getFromArk()) {
                z16 = true;
            }
            if (z16) {
                groupUploadAlbumInitBean.setInsertSpacePage(3);
            }
            ho.i.m().n(context, groupUploadAlbumInitBean);
        }
    }

    private final void O(Context context) {
        CellGroupAlbumInfo cellGroupAlbumInfo;
        CellMediaInfo cellMediaInfo;
        CellGroupAlbumInfo cellGroupAlbumInfo2;
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            if (!this.hasRight) {
                ToastUtil.o(R.string.f133135a, 4);
                return;
            }
            BusinessFeedData businessFeedData = this.f441565h;
            String str = null;
            String str2 = (businessFeedData == null || (cellGroupAlbumInfo2 = businessFeedData.cellGroupAlbumInfo) == null) ? null : cellGroupAlbumInfo2.groupId;
            boolean z16 = true;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            BusinessFeedData businessFeedData2 = this.f441565h;
            String str3 = (businessFeedData2 == null || (cellMediaInfo = businessFeedData2.cellMediaInfo) == null) ? null : cellMediaInfo.albumId;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
            String str4 = this.f441565h.cellMediaInfo.albumId;
            Intrinsics.checkNotNullExpressionValue(str4, "mFeedData.cellMediaInfo.albumId");
            commonAlbumInfo.V(str4);
            String str5 = this.f441565h.cellMediaInfo.albumName;
            Intrinsics.checkNotNullExpressionValue(str5, "mFeedData.cellMediaInfo.albumName");
            commonAlbumInfo.m0(str5);
            BusinessFeedData businessFeedData3 = this.f441565h;
            if (businessFeedData3 != null && (cellGroupAlbumInfo = businessFeedData3.cellGroupAlbumInfo) != null) {
                str = cellGroupAlbumInfo.groupId;
            }
            if (str == null) {
                str = "";
            }
            GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean = new GroupChatHistoryMediaSelectInitBean(str, commonAlbumInfo, 4);
            oi.c m3 = ho.i.m();
            Activity activity2 = i();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            m3.b(activity2, 0, groupChatHistoryMediaSelectInitBean);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        CellMediaInfo cellMediaInfo;
        PictureUrl pictureUrl;
        CellMediaInfo cellMediaInfo2;
        CellMediaInfo cellMediaInfo3;
        CellMediaInfo cellMediaInfo4;
        String str = null;
        String str2 = (feedData == null || (cellMediaInfo4 = feedData.cellMediaInfo) == null) ? null : cellMediaInfo4.albumName;
        boolean z16 = true;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        TextView textView = this.mAlbumNameTv;
        if (textView != null) {
            textView.setText((feedData == null || (cellMediaInfo3 = feedData.cellMediaInfo) == null) ? null : cellMediaInfo3.albumName);
        }
        TextView textView2 = this.mAlbumTipsTv;
        if (textView2 != null) {
            textView2.setText("\u5171" + ((feedData == null || (cellMediaInfo2 = feedData.cellMediaInfo) == null) ? 0 : cellMediaInfo2.albumUploadNum) + "\u4e2a\u5f71\u50cf");
        }
        if (feedData != null && (cellMediaInfo = feedData.cellMediaInfo) != null && (pictureUrl = cellMediaInfo.albumCoverUrl) != null) {
            str = pictureUrl.url;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            RoundRectURLImageView roundRectURLImageView = this.mAlbumCover;
            if (roundRectURLImageView != null) {
                roundRectURLImageView.setImageResource(R.drawable.asd);
            }
        } else {
            RoundRectURLImageView roundRectURLImageView2 = this.mAlbumCover;
            if (roundRectURLImageView2 != null) {
                roundRectURLImageView2.setImageURL(str);
            }
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) r(GroupAlbumFeedDetailViewModel.class);
        this.hasRight = groupAlbumFeedDetailViewModel != null ? groupAlbumFeedDetailViewModel.p2() : false;
        View view = this.mUploadBtn;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }
}
