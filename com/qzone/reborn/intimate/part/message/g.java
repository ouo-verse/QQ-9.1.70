package com.qzone.reborn.intimate.part.message;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.k;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ay;
import qj.i;
import qj.j;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZIntimateSpaceReader$StPattonAction;
import qzone.QZoneBaseMeta$StFeed;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/intimate/part/message/g;", "Lcom/qzone/reborn/base/k;", "Lqj/j;", "Lqj/i;", "", "initViewModel", "Lcom/qzone/reborn/message/data/a;", "data", "", "position", "K9", "Landroid/app/Dialog;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "D9", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "which", "F9", "H9", "", "E9", "G9", "onInitView", "messageBean", "S5", "i3", "Lnk/ay;", "d", "Lnk/ay;", "mMessageViewModel", "Lqj/h;", "e", "Lqj/h;", "mMessageCommentIoc", "f", "Lcom/qzone/reborn/message/data/a;", "mCurMessageData", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", h.F, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mCurFeedData", "i", "I", "mMessagePosition", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mShowReplyButton", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends k implements j, i {
    private static final String D;
    private static final String E;
    private static final String F;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ay mMessageViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private qj.h mMessageCommentIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.message.data.a mCurMessageData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mCurFeedData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mMessagePosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mShowReplyButton;

    static {
        String a16 = l.a(R.string.f169560w94);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026e_list_check_detail_text)");
        D = a16;
        String a17 = l.a(R.string.w9_);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_int\u2026_message_list_reply_text)");
        E = a17;
        String a18 = l.a(R.string.w96);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_int\u2026ge_list_delete_feed_text)");
        F = a18;
    }

    private final void D9(View rootView, Map<String, ? extends Object> pageParams) {
        VideoReport.setPageId(rootView, "pg_qz_buddy_space_message_settings");
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_ALL);
        VideoReport.setPageParams(rootView, new fo.a().d("QZoneIntimateMessageOperateDialogPart", pageParams));
    }

    private final List<String> E9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_qz_view_details_button");
        if (this.mShowReplyButton) {
            arrayList.add("em_qz_reply_button");
        }
        arrayList.add(WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE);
        return arrayList;
    }

    private final void F9(ActionSheet actionSheet, int which) {
        String content = actionSheet.getContent(which);
        if (Intrinsics.areEqual(content, D)) {
            i3(this.mCurMessageData);
            return;
        }
        if (Intrinsics.areEqual(content, E)) {
            G9();
            return;
        }
        if (Intrinsics.areEqual(content, F)) {
            ay ayVar = this.mMessageViewModel;
            if (ayVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMessageViewModel");
                ayVar = null;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ayVar.P1(activity, this.mCurMessageData);
        }
    }

    private final void G9() {
        if (this.mCurMessageData == null) {
            return;
        }
        if (this.mMessageCommentIoc == null) {
            this.mMessageCommentIoc = (qj.h) getIocInterface(qj.h.class);
        }
        qj.h hVar = this.mMessageCommentIoc;
        if (hVar != null) {
            hVar.J5(this.mCurMessageData, this.mMessagePosition);
        }
    }

    private final void H9(ActionSheet actionSheet) {
        int size = E9().size();
        LinearLayout linearLayout = actionSheet.mContentContainer;
        if (linearLayout.getChildCount() < size) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            fo.c.n(linearLayout.getChildAt(i3), E9().get(i3));
        }
    }

    private final Dialog I9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(D, 1);
            if (this.mShowReplyButton) {
                actionSheet.addButton(E, 1);
            }
            actionSheet.addButton(F, 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.intimate.part.message.f
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    g.J9(g.this, actionSheet, view, i3);
                }
            });
            ef.d.f(actionSheet, getActivity());
            LinearLayout linearLayout = actionSheet.mContentContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "this.mContentContainer");
            D9(linearLayout, null);
            H9(actionSheet);
        }
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(g this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.F9(this_apply, i3);
        this_apply.dismiss();
    }

    private final void K9(com.qzone.reborn.message.data.a data, int position) {
        this.mCurMessageData = data;
        this.mMessagePosition = position;
        oj.a aVar = oj.a.f423008a;
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = data.getStNotice().feed.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StFeed, "data.stNotice.feed.get()");
        this.mCurFeedData = aVar.B(qZoneBaseMeta$StFeed, data.getStCommonExt());
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(ay.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ageViewModel::class.java)");
        this.mMessageViewModel = (ay) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, j.class);
        registerIoc(this, i.class);
        initViewModel();
    }

    @Override // qj.j
    public void S5(com.qzone.reborn.message.data.a messageBean, int position) {
        if (messageBean == null) {
            return;
        }
        K9(messageBean, position);
        this.mShowReplyButton = messageBean.getStNotice().op_mask.get().contains(1);
        I9();
    }

    @Override // qj.i
    public void i3(com.qzone.reborn.message.data.a messageBean) {
        PBStringField pBStringField;
        PBEnumField pBEnumField;
        if (messageBean == null) {
            return;
        }
        QZIntimateSpaceReader$StNotice stNotice = messageBean.getStNotice();
        QZIntimateSpaceReader$StPattonAction qZIntimateSpaceReader$StPattonAction = stNotice.action;
        String str = null;
        Integer valueOf = (qZIntimateSpaceReader$StPattonAction == null || (pBEnumField = qZIntimateSpaceReader$StPattonAction.action_type) == null) ? null : Integer.valueOf(pBEnumField.get());
        if (valueOf != null && valueOf.intValue() == 1) {
            QZIntimateSpaceReader$StPattonAction qZIntimateSpaceReader$StPattonAction2 = stNotice.action;
            if (qZIntimateSpaceReader$StPattonAction2 != null && (pBStringField = qZIntimateSpaceReader$StPattonAction2.schema_url) != null) {
                str = pBStringField.get();
            }
            yo.d.b(getActivity(), new yo.g(str));
        }
    }
}
