package com.qzone.reborn.message.part;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import bl.CommonNoticeBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/message/part/k;", "Lcom/qzone/reborn/base/k;", "Ldl/e;", "Landroid/app/Dialog;", "G9", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "which", "", "D9", "Lbl/a;", "noticeBean", "E9", "", "itemContent", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", com.tencent.luggage.wxa.c8.c.G, "K4", "o9", Constants.USER_SET_DEVICE_ID, "Lhl/c;", "d", "Lhl/c;", "messageViewModel", "Ldl/a;", "e", "Ldl/a;", "messageCommentIoc", "f", "Lbl/a;", "curNoticeData", tl.h.F, "I", "curPosition", "", "i", "Z", "isShowReplyButton", "Ldl/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldl/f;", "pageReportIoc", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends com.qzone.reborn.base.k implements dl.e {
    private static final String D;
    private static final String E;
    private static final String F;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private hl.c messageViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private dl.a messageCommentIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonNoticeBean curNoticeData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowReplyButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private dl.f pageReportIoc;

    static {
        String a16 = com.qzone.util.l.a(R.string.f169560w94);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026e_list_check_detail_text)");
        D = a16;
        String a17 = com.qzone.util.l.a(R.string.w9_);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_int\u2026_message_list_reply_text)");
        E = a17;
        String a18 = com.qzone.util.l.a(R.string.w96);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_int\u2026ge_list_delete_feed_text)");
        F = a18;
    }

    private final void D9(ActionSheet actionSheet, int which) {
        String content = actionSheet.getContent(which);
        if (Intrinsics.areEqual(content, D)) {
            E8(this.curNoticeData);
        } else if (Intrinsics.areEqual(content, F)) {
            o9(this.curNoticeData);
        } else if (Intrinsics.areEqual(content, E)) {
            E9(this.curNoticeData);
        }
        String content2 = actionSheet.getContent(which);
        Intrinsics.checkNotNullExpressionValue(content2, "actionSheet.getContent(which)");
        F9(actionSheet, content2);
    }

    private final void F9(ActionSheet actionSheet, String itemContent) {
        int i3;
        Map<String, ? extends Object> mutableMapOf;
        if (Intrinsics.areEqual(itemContent, E)) {
            i3 = 4;
        } else if (!Intrinsics.areEqual(itemContent, F)) {
            return;
        } else {
            i3 = 1;
        }
        gl.b bVar = gl.b.f402374a;
        ViewGroup rootView = actionSheet.getRootView();
        CommonNoticeBean commonNoticeBean = this.curNoticeData;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_type", Integer.valueOf(i3)));
        bVar.f(rootView, "em_qz_operation_panel", commonNoticeBean, mutableMapOf);
    }

    private final Dialog G9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(D, 1);
            if (this.isShowReplyButton) {
                actionSheet.addButton(E, 1);
            }
            actionSheet.addButton(F, 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.message.part.j
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    k.H9(k.this, actionSheet, view, i3);
                }
            });
            dl.f fVar = this.pageReportIoc;
            if (fVar == null) {
                fVar = (dl.f) getIocInterface(dl.f.class);
            }
            this.pageReportIoc = fVar;
            gl.b bVar = gl.b.f402374a;
            ViewGroup rootView = actionSheet.getRootView();
            CommonNoticeBean commonNoticeBean = this.curNoticeData;
            dl.f fVar2 = this.pageReportIoc;
            bVar.h(rootView, "em_qz_operation_panel", commonNoticeBean, (r13 & 8) != 0 ? null : fVar2 != null ? fVar2.O1() : null, (r13 & 16) != 0 ? null : null);
            ef.d.f(actionSheet, getActivity());
        }
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(k this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.D9(this_apply, i3);
        this_apply.dismiss();
    }

    @Override // dl.e
    public void o9(CommonNoticeBean noticeBean) {
        hl.c cVar = this.messageViewModel;
        if (cVar != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            cVar.f2(activity, noticeBean);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.e.class);
        this.messageViewModel = (hl.c) getViewModel(hl.c.class);
    }

    private final void E9(CommonNoticeBean noticeBean) {
        if (noticeBean == null) {
            return;
        }
        if (this.messageCommentIoc == null) {
            this.messageCommentIoc = (dl.a) getIocInterface(dl.a.class);
        }
        dl.a aVar = this.messageCommentIoc;
        if (aVar != null) {
            aVar.c7(noticeBean, this.curPosition);
        }
    }

    @Override // dl.e
    public void E8(CommonNoticeBean noticeBean) {
        if (noticeBean != null && noticeBean.getNotice().getAction().getActionType() == 3) {
            ho.i.q(getActivity(), noticeBean.getNotice().getAction().getSchemaUrl());
        }
    }

    @Override // dl.e
    public void K4(CommonNoticeBean noticeBean, int pos) {
        if (noticeBean == null) {
            return;
        }
        this.curNoticeData = noticeBean;
        this.curPosition = pos;
        this.isShowReplyButton = noticeBean.getNotice().l().contains(1);
        G9();
    }
}
