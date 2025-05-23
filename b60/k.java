package b60;

import android.app.Dialog;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lb60/k;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/beans/QFSCommentPicInfo;", "info", "", "D9", "", "B9", "A9", "Landroid/view/View;", "view", "", "text", "C9", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "G9", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "layerBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k extends u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleCommentPicLayerBean layerBean;

    public k(@Nullable QCircleCommentPicLayerBean qCircleCommentPicLayerBean) {
        this.layerBean = qCircleCommentPicLayerBean;
    }

    private final boolean A9(QFSCommentPicInfo info) {
        boolean z16;
        boolean isBlank;
        String favEmojiUrl = info.getFavEmojiUrl();
        if (!ud2.a.f438849a.a()) {
            return false;
        }
        if (favEmojiUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(favEmojiUrl);
            if (!isBlank) {
                z16 = false;
                if (z16 && !RFWFileUtils.isLocalPath(favEmojiUrl)) {
                    return true;
                }
            }
        }
        z16 = true;
        return z16 ? false : false;
    }

    private final boolean B9(QFSCommentPicInfo info) {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.layerBean;
        if (qCircleCommentPicLayerBean != null && qCircleCommentPicLayerBean.needSaveOperate() && info.hasMaskPic()) {
            return true;
        }
        return false;
    }

    private final void C9(View view, String text) {
        if (view != null) {
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_LARGE_PIC_PAGE);
            params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
            params.put("xsj_item_name", text);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", view, params);
        }
    }

    private final void D9(final QFSCommentPicInfo info) {
        if (info == null) {
            QLog.w("QFSCommentPicSheetPart", 1, "[showActionSheet] invalid info");
            return;
        }
        if (!B9(info) && !A9(info)) {
            QLog.w("QFSCommentPicSheetPart", 1, "[showActionSheet] none menu can show");
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (B9(info)) {
            actionSheet.addButton(new ActionMenuItem(com.tencent.biz.qqcircle.utils.h.a(R.string.f194974dc), 100, 0), 0);
        }
        if (A9(info)) {
            actionSheet.addButton(new ActionMenuItem(com.tencent.biz.qqcircle.utils.h.a(R.string.f1901641c), 101, 0), 0);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: b60.i
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                k.E9(ActionSheet.this, this, info, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: b60.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.F9(k.this, actionSheet, view);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(ActionSheet actionSheet, k this$0, QFSCommentPicInfo qFSCommentPicInfo, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionMenuItem actionMenuItem = actionSheet.getActionMenuItem(i3);
        if (actionMenuItem != null) {
            int i16 = actionMenuItem.action;
            if (i16 == 100) {
                String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194974dc);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_save_pic)");
                this$0.C9(view, a16);
                actionSheet.dismiss();
                this$0.broadcastMessage("comment_pic_save", this$0.G9(qFSCommentPicInfo));
                return;
            }
            if (i16 == 101) {
                String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1901641c);
                Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_fav_emoji)");
                this$0.C9(view, a17);
                actionSheet.dismiss();
                this$0.broadcastMessage("comment_pic_fav_emoji", qFSCommentPicInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(k this$0, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.cancel)");
        this$0.C9(view, a16);
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final QCircleShareInfo G9(QFSCommentPicInfo info) {
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        ArrayList arrayList = new ArrayList();
        FeedCloudMeta$StImage image = info.getImage();
        Intrinsics.checkNotNullExpressionValue(image, "info.getImage()");
        arrayList.add(image);
        feedCloudMeta$StFeed.images.set(arrayList);
        feedCloudMeta$StFeed.type.set(2);
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.picDownPos = 0;
        qCircleShareInfo.type = 10;
        return qCircleShareInfo;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        boolean z16;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual("comment_show_sheet", action)) {
            if (args == null) {
                z16 = true;
            } else {
                z16 = args instanceof QFSCommentPicInfo;
            }
            if (z16) {
                D9((QFSCommentPicInfo) args);
            }
        }
    }
}
