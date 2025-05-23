package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.flexbox.FlexboxLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.internal.Internal;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.events.QFSCommentPermissionUserUpdateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSGetRightInfoRequest;
import com.tencent.biz.qqcircle.requests.QFSSetRightInfoRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSSettingCommentPermissionBottomDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.GetRightInfoRsp;
import feedcloud.RightFlag;
import feedcloud.RightInfo;
import feedcloud.SetRightInfoRsp;
import feedcloud.Switch;
import feedcloud.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003FGHB\u001f\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00106\u001a\u000201\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ4\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J4\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\"\u0010!\u001a\u00020\u00062\u0018\b\u0002\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0003H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)`\u001fH\u0016R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "Lcom/tencent/biz/qqcircle/widgets/QFSBaseBottomSheetDialog;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "g0", "o0", "e0", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a0", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "leftString", "", "drawable", "rightFlag", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "b0", "c0", "l0", "k0", "m0", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectUinList", "i0", "Lcom/tencent/biz/qqcircle/events/QFSCommentPermissionUserUpdateEvent;", "event", "d0", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "dismiss", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Lfeedcloud/FeedCloudMeta$StFeed;", "E", "Lfeedcloud/FeedCloudMeta$StFeed;", "getFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Lcooperation/qqcircle/report/QCircleReportBean;", UserInfo.SEX_FEMALE, "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "()Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "Lfeedcloud/RightInfo;", "G", "Lfeedcloud/RightInfo;", "mCurrentRightInfo", "H", "mOriginRightInfo", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "I", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lfeedcloud/FeedCloudMeta$StFeed;Lcooperation/qqcircle/report/QCircleReportBean;)V", "J", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSSettingCommentPermissionBottomDialog extends QFSBaseBottomSheetDialog implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final FeedCloudMeta$StFeed feed;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QCircleReportBean reportBean;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RightInfo mCurrentRightInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RightInfo mOriginRightInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIListItemAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog$b;", "Landroid/view/View$OnClickListener;", "", "c", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "d", "I", "getRightFlag", "()I", "rightFlag", "Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "e", "Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "getBottomDialog", "()Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "bottomDialog", "<init>", "(ILcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int rightFlag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QFSSettingCommentPermissionBottomDialog bottomDialog;

        public b(int i3, @NotNull QFSSettingCommentPermissionBottomDialog bottomDialog) {
            Intrinsics.checkNotNullParameter(bottomDialog, "bottomDialog");
            this.rightFlag = i3;
            this.bottomDialog = bottomDialog;
        }

        private final void c() {
            DialogUtil.createCustomDialog(this.bottomDialog.C, 230, com.tencent.biz.qqcircle.utils.h.a(R.string.f195324ea), com.tencent.biz.qqcircle.utils.h.a(R.string.f195314e_), com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), com.tencent.biz.qqcircle.utils.h.a(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.br
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QFSSettingCommentPermissionBottomDialog.b.d(QFSSettingCommentPermissionBottomDialog.b.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.bs
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QFSSettingCommentPermissionBottomDialog.b.e(dialogInterface, i3);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.bottomDialog.l0(this$0.rightFlag);
            this$0.bottomDialog.m0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            int i3 = this.rightFlag;
            RightFlag rightFlag = RightFlag.RIGHTFLAG_NONE;
            boolean z17 = false;
            if (i3 >= rightFlag.getValue() && com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.e(Switch.PROTECTION.name())) {
                RFWLog.d("QOK-QFSSettingCommentPermissionBottomDialog", RFWLog.USR, "[onItemClick] current enabled one key defend, not selected change, rightFlag: " + this.rightFlag);
                QCircleToast.l(QCircleToast.f91644d, RFWApplication.getApplication().getString(R.string.f183133ic), 0, true, false);
            } else {
                int i16 = this.rightFlag;
                if (i16 == rightFlag.getValue() || i16 == RightFlag.RIGHTFLAG_QQFRIEND.getValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.bottomDialog.l0(this.rightFlag);
                    this.bottomDialog.m0();
                } else {
                    if (i16 == RightFlag.RIGHTFLAG_WHITELIST.getValue() || i16 == RightFlag.RIGHTFLAG_BLACKLIST.getValue()) {
                        z17 = true;
                    }
                    if (z17) {
                        this.bottomDialog.l0(this.rightFlag);
                        QFSSettingCommentPermissionBottomDialog.j0(this.bottomDialog, null, 1, null);
                    } else if (i16 == RightFlag.RIGHTFLAG_NOBODY.getValue()) {
                        c();
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog$c;", "Lcom/tencent/mobileqq/widget/listitem/h;", "Landroid/view/View;", "view", "", "isSelected", "", "a", "Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "getBottomDialog", "()Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;", "bottomDialog", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements com.tencent.mobileqq.widget.listitem.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QFSSettingCommentPermissionBottomDialog bottomDialog;

        public c(@NotNull QFSSettingCommentPermissionBottomDialog bottomDialog) {
            Intrinsics.checkNotNullParameter(bottomDialog, "bottomDialog");
            this.bottomDialog = bottomDialog;
        }

        @Override // com.tencent.mobileqq.widget.listitem.h
        public void a(@NotNull View view, boolean isSelected) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.bottomDialog.o0();
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/biz/qqcircle/widgets/QFSSettingCommentPermissionBottomDialog$d", "Loc0/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "P", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d extends oc0.a<x.b.C8996b, x.c> {

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ int f93423r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i3, x.b.C8996b c8996b, x.c.i iVar) {
            super(c8996b, iVar);
            this.f93423r = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void W(QFSSettingCommentPermissionBottomDialog this$0, int i3, View view) {
            List<String> list;
            boolean z16;
            ArrayList arrayList;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RightInfo rightInfo = this$0.mCurrentRightInfo;
            if (rightInfo != null) {
                list = rightInfo.uids;
            } else {
                list = null;
            }
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                RightInfo rightInfo2 = this$0.mCurrentRightInfo;
                Intrinsics.checkNotNull(rightInfo2);
                arrayList = new ArrayList(rightInfo2.uids);
            } else {
                arrayList = new ArrayList();
            }
            this$0.i0(arrayList);
            this$0.l0(i3);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // oc0.a, com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: P */
        public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            ImageView imageView = (ImageView) view.findViewById(R.id.f44281or);
            if (imageView != null) {
                final QFSSettingCommentPermissionBottomDialog qFSSettingCommentPermissionBottomDialog = QFSSettingCommentPermissionBottomDialog.this;
                final int i3 = this.f93423r;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.bt
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        QFSSettingCommentPermissionBottomDialog.d.W(QFSSettingCommentPermissionBottomDialog.this, i3, view2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: Q */
        public QUISingleLineListItem H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            QUISingleLineListItem H = super.H(parent);
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setId(R.id.f44281or);
            imageView.setImageResource(R.drawable.qui_edit_text_secondary);
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(cx.a(18.0f), cx.a(18.0f));
            layoutParams.b(0.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cx.a(7.0f);
            imageView.setLayoutParams(layoutParams);
            H.c(imageView);
            return H;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSettingCommentPermissionBottomDialog(@NotNull Context context, @NotNull FeedCloudMeta$StFeed feed, @NotNull QCircleReportBean reportBean) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        this.feed = feed;
        this.reportBean = reportBean;
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.gsn, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        g0(rootView);
        setContentView(rootView);
        e0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void R(int rightFlag) {
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMT_FEED_CHOOSE_BUTTON);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_SET_NAME, Integer.valueOf(rightFlag));
        map.put("xsj_feed_id", this.feed.f398449id.get());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.feed.poster.f398463id.get());
        map.put("xsj_custom_pgid", this.reportBean.getDtPageId());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
    }

    private final void S() {
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMT_FEED_SET_PANEL);
        map.put("xsj_feed_id", this.feed.f398449id.get());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.feed.poster.f398463id.get());
        map.put("xsj_custom_pgid", this.reportBean.getDtPageId());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", map);
    }

    private final Group[] a0() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184403ls);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_p\u2026ssage_setting_choose_all)");
        RightFlag rightFlag = RightFlag.RIGHTFLAG_NONE;
        String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1922146w);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_only_qq_friends)");
        RightFlag rightFlag2 = RightFlag.RIGHTFLAG_QQFRIEND;
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1922246x);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_only_some_friends)");
        RightFlag rightFlag3 = RightFlag.RIGHTFLAG_WHITELIST;
        String a19 = com.tencent.biz.qqcircle.utils.h.a(R.string.f195914fw);
        Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qfs_some_people_not_allow_comment)");
        RightFlag rightFlag4 = RightFlag.RIGHTFLAG_BLACKLIST;
        String a26 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188673xb);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qfs_close_comment)");
        RightFlag rightFlag5 = RightFlag.RIGHTFLAG_NOBODY;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(new com.tencent.mobileqq.widget.listitem.x[]{b0(a16, R.drawable.qui_group, rightFlag.getValue(), new b(rightFlag.getValue(), this)), b0(a17, R.drawable.qui_mutual_follow, rightFlag2.getValue(), new b(rightFlag2.getValue(), this)), c0(a18, R.drawable.qui_verified, rightFlag3.getValue(), new b(rightFlag3.getValue(), this)), c0(a19, R.drawable.qui_blacklist, rightFlag4.getValue(), new b(rightFlag4.getValue(), this)), b0(a26, R.drawable.qui_icon_general_closecomment, rightFlag5.getValue(), new b(rightFlag5.getValue(), this))}, 5))};
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c> b0(CharSequence leftString, int drawable, int rightFlag, View.OnClickListener onClickListener) {
        RightFlag rightFlag2;
        boolean z16;
        x.c cVar;
        RightInfo rightInfo = this.mCurrentRightInfo;
        if (rightInfo == null || (rightFlag2 = rightInfo.right_flag) == null) {
            rightFlag2 = RightFlag.RIGHTFLAG_NONE;
        }
        if (rightFlag2.getValue() == rightFlag) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            cVar = new x.c.i(true, new c(this));
        } else {
            cVar = x.c.C8997c.f317072b;
        }
        oc0.a aVar = new oc0.a(new x.b.C8996b(leftString, drawable), cVar);
        aVar.x(onClickListener);
        return aVar;
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c> c0(CharSequence leftString, int drawable, int rightFlag, View.OnClickListener onClickListener) {
        RightFlag rightFlag2;
        boolean z16;
        int i3;
        List<String> list;
        List<User> list2;
        RightInfo rightInfo = this.mCurrentRightInfo;
        if (rightInfo == null || (rightFlag2 = rightInfo.right_flag) == null) {
            rightFlag2 = RightFlag.RIGHTFLAG_NONE;
        }
        if (rightFlag2.getValue() == rightFlag) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(leftString);
            RightInfo rightInfo2 = this.mCurrentRightInfo;
            if (rightInfo2 != null && (list2 = rightInfo2.users) != null && (!list2.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                RightInfo rightInfo3 = this.mCurrentRightInfo;
                Intrinsics.checkNotNull(rightInfo3);
                spannableStringBuilder.append((CharSequence) " \u00b7 ").append((CharSequence) HostEmotionUtil.substring(rightInfo3.users.get(0).nick, 6));
                RightInfo rightInfo4 = this.mCurrentRightInfo;
                if (rightInfo4 != null && (list = rightInfo4.uids) != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
                if (i3 > 1) {
                    spannableStringBuilder.append((CharSequence) getContext().getString(R.string.f19004411, Integer.valueOf(i3)));
                }
            }
            d dVar = new d(rightFlag, new x.b.C8996b(spannableStringBuilder, drawable), new x.c.i(true, new c(this)));
            dVar.x(onClickListener);
            return dVar;
        }
        oc0.a aVar = new oc0.a(new x.b.C8996b(leftString, drawable), new x.c.g("", false, false, 6, null));
        aVar.x(onClickListener);
        return aVar;
    }

    private final void d0(QFSCommentPermissionUserUpdateEvent event) {
        Object first;
        RightInfo.a aVar;
        boolean z16;
        List<String> copyOf;
        List<User> copyOf2;
        Intent intent = event.getIntent();
        if (intent == null) {
            k0();
            return;
        }
        ArrayList<HostSelectMemberUtils.QCircleResultData> resultList = HostSelectMemberUtils.getResultList(intent);
        Intrinsics.checkNotNullExpressionValue(resultList, "resultList");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) resultList);
        HostSelectMemberUtils.QCircleResultData qCircleResultData = (HostSelectMemberUtils.QCircleResultData) first;
        RightInfo rightInfo = this.mCurrentRightInfo;
        if (rightInfo != null) {
            aVar = rightInfo.newBuilder();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new RightInfo.a();
        }
        RightInfo rightInfo2 = this.mCurrentRightInfo;
        if (rightInfo2 != null) {
            List<String> list = rightInfo2.uids;
            boolean z17 = false;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                copyOf = new ArrayList<>();
            } else {
                List<String> list2 = rightInfo2.uids;
                Intrinsics.checkNotNullExpressionValue(list2, "it.uids");
                copyOf = Internal.copyOf(list2);
            }
            Iterator<T> it = resultList.iterator();
            while (it.hasNext()) {
                String str = ((HostSelectMemberUtils.QCircleResultData) it.next()).uin;
                Intrinsics.checkNotNullExpressionValue(str, "result.uin");
                copyOf.add(str);
            }
            aVar.c(copyOf);
            List<User> list3 = rightInfo2.users;
            if (list3 == null || list3.isEmpty()) {
                z17 = true;
            }
            if (z17) {
                copyOf2 = new ArrayList<>();
            } else {
                List<User> list4 = rightInfo2.users;
                Intrinsics.checkNotNullExpressionValue(list4, "it.users");
                copyOf2 = Internal.copyOf(list4);
            }
            String str2 = qCircleResultData.name;
            if (TextUtils.isEmpty(str2)) {
                wq3.i iVar = wq3.i.f446087a;
                String str3 = qCircleResultData.uin;
                Intrinsics.checkNotNullExpressionValue(str3, "firstUser.uin");
                str2 = iVar.a(str3);
            }
            User build = new User.a().c(qCircleResultData.uin).b(str2).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().uid(firstUser.uin).nick(name).build()");
            copyOf2.add(build);
            aVar.d(copyOf2);
        }
        this.mCurrentRightInfo = aVar.build();
        m0();
    }

    private final void e0() {
        this.mOriginRightInfo = new RightInfo.a().b(RightFlag.fromValue(cq.f92752a.e(this.feed))).build();
        k0();
        String str = this.feed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
        VSNetworkHelper.getInstance().sendRequest(new QFSGetRightInfoRequest(str), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.widgets.bq
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QFSSettingCommentPermissionBottomDialog.f0(QFSSettingCommentPermissionBottomDialog.this, baseRequest, z16, j3, str2, (GetRightInfoRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(QFSSettingCommentPermissionBottomDialog this$0, BaseRequest baseRequest, boolean z16, long j3, String str, GetRightInfoRsp getRightInfoRsp) {
        String traceId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = "";
        if (baseRequest == null) {
            traceId = "";
        } else {
            traceId = baseRequest.getTraceId();
        }
        if (baseRequest != null) {
            str2 = baseRequest.getCmd();
        }
        if (z16 && j3 == 0 && getRightInfoRsp != null) {
            boolean z17 = getRightInfoRsp.is_protection_on;
            RFWLog.d("QOK-QFSSettingCommentPermissionBottomDialog", RFWLog.USR, "[initData] isProtectionOn: " + z17 + " | traceId:" + traceId + " | request:" + str2);
            this$0.mOriginRightInfo = getRightInfoRsp.right_info;
            com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.k(Switch.PROTECTION.name(), getRightInfoRsp.is_protection_on, "type_comment_read");
            this$0.k0();
            return;
        }
        RFWLog.w("QOK-QFSSettingCommentPermissionBottomDialog", RFWLog.USR, "[initData] error: retCode=" + j3 + ", errMsg=" + str + ",traceId:" + traceId);
    }

    private final void g0(View rootView) {
        this.mAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, false, 6, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) rootView.findViewById(R.id.f48121z5);
        qUISettingsRecyclerView.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        QUIListItemAdapter qUIListItemAdapter = this.mAdapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qUIListItemAdapter = null;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(ArrayList<String> selectUinList) {
        HostSelectMemberUtils.onCommentPermissionClick(this.C, selectUinList, 258);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j0(QFSSettingCommentPermissionBottomDialog qFSSettingCommentPermissionBottomDialog, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = new ArrayList();
        }
        qFSSettingCommentPermissionBottomDialog.i0(arrayList);
    }

    private final void k0() {
        RightInfo rightInfo;
        RightInfo.a newBuilder;
        RightInfo rightInfo2 = this.mOriginRightInfo;
        if (rightInfo2 != null && (newBuilder = rightInfo2.newBuilder()) != null) {
            rightInfo = newBuilder.build();
        } else {
            rightInfo = null;
        }
        this.mCurrentRightInfo = rightInfo;
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(int rightFlag) {
        this.mCurrentRightInfo = new RightInfo.a().b(RightFlag.fromValue(rightFlag)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        RightFlag rightFlag;
        List<String> list;
        RightInfo rightInfo = this.mCurrentRightInfo;
        if (rightInfo == null || (rightFlag = rightInfo.right_flag) == null) {
            rightFlag = RightFlag.RIGHTFLAG_NONE;
        }
        final int value = rightFlag.getValue();
        String str = this.feed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
        RightInfo rightInfo2 = this.mCurrentRightInfo;
        if (rightInfo2 != null) {
            list = rightInfo2.uids;
        } else {
            list = null;
        }
        QFSSetRightInfoRequest qFSSetRightInfoRequest = new QFSSetRightInfoRequest(str, value, list);
        o0();
        R(value);
        VSNetworkHelper.getInstance().sendRequest(qFSSetRightInfoRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.widgets.bp
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QFSSettingCommentPermissionBottomDialog.n0(QFSSettingCommentPermissionBottomDialog.this, value, baseRequest, z16, j3, str2, (SetRightInfoRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QFSSettingCommentPermissionBottomDialog this$0, int i3, BaseRequest baseRequest, boolean z16, long j3, String str, SetRightInfoRsp setRightInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && j3 == 0 && setRightInfoRsp != null) {
            this$0.feed.right.commentRightFlag.set(i3);
            this$0.mOriginRightInfo = this$0.mCurrentRightInfo;
            QCircleToast.o(cq.f92752a.g(i3), 0);
            if (i3 == RightFlag.RIGHTFLAG_NOBODY.getValue()) {
                if (!QFSBaseCommentPresenter.l(this$0.feed)) {
                    this$0.feed.opMask2.get().add(45);
                    this$0.feed.commentTextInfo.normalCommentBoxDesc.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f188333we));
                }
                this$0.feed.commentCount.set(0);
                this$0.feed.vecComment.clear();
                w20.a.j().initOrUpdateGlobalState((w20.a) new e30.b(this$0.feed), true);
                SimpleEventBus.getInstance().dispatchEvent(new QCircleResetCommentBlockEvent(this$0.feed.f398449id.get()));
                SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentCountUpdateEvent(this$0.feed.f398449id.get(), 0));
            } else if (QFSBaseCommentPresenter.l(this$0.feed)) {
                this$0.feed.opMask2.get().remove((Object) 45);
                this$0.feed.commentTextInfo.normalCommentBoxDesc.set("");
            }
        } else {
            RFWLog.w("QFSSettingCommentPermissionBottomDialog", RFWLog.USR, "[sendSetRightInfoRequest] error: retCode=" + j3 + ", errMsg=" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0);
        }
        this$0.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        QUIListItemAdapter qUIListItemAdapter = this.mAdapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qUIListItemAdapter = null;
        }
        Group[] a06 = a0();
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(a06, a06.length));
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSCommentPermissionUserUpdateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSCommentPermissionUserUpdateEvent) {
            d0((QFSCommentPermissionUserUpdateEvent) event);
        }
    }
}
