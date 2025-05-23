package com.qzone.reborn.message.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import bl.CommonNoticeBean;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/message/part/s;", "Lcom/qzone/reborn/base/k;", "Ldl/e;", "", "J9", "Landroid/app/Dialog;", "L9", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "which", "", "F9", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "I9", "V0", "", "itemContent", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lbl/a;", "noticeBean", com.tencent.luggage.wxa.c8.c.G, "K4", "o9", Constants.USER_SET_DEVICE_ID, "d", "Lbl/a;", "curNoticeBean", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "curFeedData", "f", "I", "curPosition", "Lhl/d;", tl.h.F, "Lhl/d;", "passiveMsgViewModel", "Ldl/f;", "i", "Ldl/f;", "pageReportIoc", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class s extends com.qzone.reborn.base.k implements dl.e {
    private static final String C;
    private static final String D;
    private static final String E;
    private static final String F;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonNoticeBean curNoticeBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData curFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private hl.d passiveMsgViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dl.f pageReportIoc;

    static {
        String a16 = com.qzone.util.l.a(R.string.rfh);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_feedx_menu_check_dress)");
        C = a16;
        String a17 = com.qzone.util.l.a(R.string.gei);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(com.tencent.mobile\u2026_close_high_five_message)");
        D = a17;
        String a18 = com.qzone.util.l.a(R.string.geq);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(com.tencent.mobile\u2026p_open_high_five_message)");
        E = a18;
        String a19 = com.qzone.util.l.a(R.string.w96);
        Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qzone_int\u2026ge_list_delete_feed_text)");
        F = a19;
    }

    private final void F9(ActionSheet actionSheet, int which) {
        String content = actionSheet.getContent(which);
        if (Intrinsics.areEqual(content, C)) {
            I9(this.curFeedData);
        } else if (Intrinsics.areEqual(content, D)) {
            hl.d dVar = this.passiveMsgViewModel;
            if (dVar != null) {
                dVar.P1();
            }
        } else if (Intrinsics.areEqual(content, E)) {
            hl.d dVar2 = this.passiveMsgViewModel;
            if (dVar2 != null) {
                dVar2.b2();
            }
        } else if (Intrinsics.areEqual(content, F)) {
            V0(this.curFeedData);
        }
        String content2 = actionSheet.getContent(which);
        Intrinsics.checkNotNullExpressionValue(content2, "actionSheet.getContent(which)");
        K9(actionSheet, content2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(s this$0, BusinessFeedData businessFeedData, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hl.d dVar = this$0.passiveMsgViewModel;
        if (dVar != null) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            dVar.S1(activity, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void I9(BusinessFeedData feedData) {
        if (!NetworkUtil.isNetSupport(getActivity())) {
            c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
        } else {
            if (feedData == null) {
                return;
            }
            long j3 = feedData.owner_uin;
            if (j3 == 0) {
                j3 = feedData.getUser().uin;
            }
            vo.c.E(getActivity(), j3, "default");
        }
    }

    private final boolean J9() {
        return QZoneFeedUtil.l(this.curFeedData, 25);
    }

    private final void K9(ActionSheet actionSheet, String itemContent) {
        int i3;
        Map<String, ? extends Object> mutableMapOf;
        if (Intrinsics.areEqual(itemContent, C)) {
            i3 = 3;
        } else {
            if (Intrinsics.areEqual(itemContent, E) ? true : Intrinsics.areEqual(itemContent, D)) {
                i3 = 2;
            } else if (!Intrinsics.areEqual(itemContent, F)) {
                return;
            } else {
                i3 = 1;
            }
        }
        gl.b bVar = gl.b.f402374a;
        ViewGroup rootView = actionSheet.getRootView();
        CommonNoticeBean commonNoticeBean = this.curNoticeBean;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_type", Integer.valueOf(i3)));
        bVar.f(rootView, "em_qz_operation_panel", commonNoticeBean, mutableMapOf);
    }

    private final Dialog L9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(C, 1);
            if (J9()) {
                int h16 = u5.c.h("highFiveNotifyStatus", -1);
                if (h16 == 0) {
                    actionSheet.addButton(D, 1);
                } else if (h16 == 1) {
                    actionSheet.addButton(E, 1);
                }
            }
            actionSheet.addButton(F, 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.message.part.r
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    s.M9(s.this, actionSheet, view, i3);
                }
            });
            dl.f fVar = this.pageReportIoc;
            if (fVar == null) {
                fVar = (dl.f) getIocInterface(dl.f.class);
            }
            this.pageReportIoc = fVar;
            gl.b bVar = gl.b.f402374a;
            ViewGroup rootView = actionSheet.getRootView();
            CommonNoticeBean commonNoticeBean = this.curNoticeBean;
            dl.f fVar2 = this.pageReportIoc;
            bVar.h(rootView, "em_qz_operation_panel", commonNoticeBean, (r13 & 8) != 0 ? null : fVar2 != null ? fVar2.O1() : null, (r13 & 16) != 0 ? null : null);
            ef.d.f(actionSheet, getActivity());
        }
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(s this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.F9(this_apply, i3);
        this_apply.dismiss();
    }

    private final void V0(final BusinessFeedData feedData) {
        new com.qzone.component.e().g(getActivity(), com.qzone.util.l.a(R.string.w97), com.qzone.util.l.a(R.string.w95), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.message.part.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                s.G9(s.this, feedData, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.message.part.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                s.H9(dialogInterface, i3);
            }
        });
    }

    @Override // dl.e
    public void K4(CommonNoticeBean noticeBean, int pos) {
        bl.f notice;
        this.curNoticeBean = noticeBean;
        if (noticeBean == null || (notice = noticeBean.getNotice()) == null) {
            return;
        }
        Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData == null) {
            return;
        }
        this.curFeedData = businessFeedData;
        this.curPosition = pos;
        L9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.e.class);
        this.passiveMsgViewModel = (hl.d) getViewModel(hl.d.class);
    }

    @Override // dl.e
    public void E8(CommonNoticeBean noticeBean) {
        if (noticeBean == null) {
            return;
        }
        bl.f notice = noticeBean.getNotice();
        Object obj = noticeBean.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData == null) {
            return;
        }
        int actionType = notice.getAction().getActionType();
        if (actionType == 1) {
            ho.c e16 = ho.i.e();
            Intrinsics.checkNotNullExpressionValue(e16, "detail()");
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ho.c.m(e16, activity, businessFeedData, 0L, 1, null, null, 32, null);
            return;
        }
        if (actionType != 2) {
            if (actionType != 3) {
                return;
            }
            yo.d.c(notice.getAction().getSchemaUrl(), getContext());
        } else {
            if (businessFeedData.getOriginalInfoSafe() == null || businessFeedData.getOriginalInfoSafe().getUser() == null) {
                return;
            }
            if (businessFeedData.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.o(businessFeedData);
            }
            ho.c e17 = ho.i.e();
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            e17.j(activity2, businessFeedData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dl.e
    public void o9(CommonNoticeBean noticeBean) {
        bl.f notice;
        if (noticeBean != null && (notice = noticeBean.getNotice()) != null) {
            Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            r0 = obj instanceof BusinessFeedData ? obj : null;
        }
        V0(r0);
    }
}
