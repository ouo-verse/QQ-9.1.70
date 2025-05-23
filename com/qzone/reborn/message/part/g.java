package com.qzone.reborn.message.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/message/part/g;", "Lcom/qzone/reborn/base/k;", "Ldl/g;", "", "I9", "Landroid/app/Dialog;", "J9", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "which", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", com.tencent.luggage.wxa.c8.c.G, "E6", "V0", "isLeftThumb", "t9", "u6", "d", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "curFeedData", "e", "I", "curPosition", "Lhl/a;", "f", "Lhl/a;", "messageViewModel", "Lgf/a;", tl.h.F, "Lgf/a;", "commentIoc", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.base.k implements dl.g {
    private static final String C;
    private static final String D;
    private static final String E;
    private static final String F;

    /* renamed from: m, reason: collision with root package name */
    private static final String f58312m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData curFeedData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private hl.a messageViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private gf.a commentIoc;

    static {
        String a16 = com.qzone.util.l.a(R.string.f169560w94);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026e_list_check_detail_text)");
        f58312m = a16;
        String a17 = com.qzone.util.l.a(R.string.w9_);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_int\u2026_message_list_reply_text)");
        C = a17;
        String a18 = com.qzone.util.l.a(R.string.gei);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(com.tencent.mobile\u2026_close_high_five_message)");
        D = a18;
        String a19 = com.qzone.util.l.a(R.string.geq);
        Intrinsics.checkNotNullExpressionValue(a19, "qqStr(com.tencent.mobile\u2026p_open_high_five_message)");
        E = a19;
        String a26 = com.qzone.util.l.a(R.string.w96);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qzone_int\u2026ge_list_delete_feed_text)");
        F = a26;
    }

    private final void F9(ActionSheet actionSheet, int which) {
        String content = actionSheet.getContent(which);
        if (Intrinsics.areEqual(content, f58312m)) {
            t9(this.curFeedData, false);
            return;
        }
        if (Intrinsics.areEqual(content, C)) {
            u6(this.curFeedData, this.curPosition);
            return;
        }
        if (Intrinsics.areEqual(content, E)) {
            hl.a aVar = this.messageViewModel;
            if (aVar != null) {
                aVar.b2();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(content, D)) {
            hl.a aVar2 = this.messageViewModel;
            if (aVar2 != null) {
                aVar2.P1();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(content, F)) {
            V0(this.curFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(g this$0, BusinessFeedData businessFeedData, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hl.a aVar = this$0.messageViewModel;
        if (aVar != null) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            aVar.S1(activity, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final boolean I9() {
        return QZoneFeedUtil.l(this.curFeedData, 25);
    }

    private final Dialog J9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(f58312m, 1);
            if (com.qzone.reborn.message.data.f.f58260a.d(this.curFeedData)) {
                actionSheet.addButton(C, 1);
            }
            if (I9()) {
                int h16 = u5.c.h("highFiveNotifyStatus", -1);
                if (h16 == 0) {
                    actionSheet.addButton(D, 1);
                } else if (h16 == 1) {
                    actionSheet.addButton(E, 1);
                }
            }
            actionSheet.addButton(F, 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.message.part.f
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    g.K9(g.this, actionSheet, view, i3);
                }
            });
            ef.d.f(actionSheet, getActivity());
        }
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(g this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.F9(this_apply, i3);
        this_apply.dismiss();
    }

    @Override // dl.g
    public void E6(BusinessFeedData feedData, int pos) {
        this.curFeedData = feedData;
        this.curPosition = pos;
        J9();
    }

    @Override // dl.g
    public void V0(final BusinessFeedData feedData) {
        new com.qzone.component.e().g(getActivity(), com.qzone.util.l.a(R.string.w97), com.qzone.util.l.a(R.string.w95), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.message.part.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.G9(g.this, feedData, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.message.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.H9(dialogInterface, i3);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.g.class);
        this.messageViewModel = (hl.a) getViewModel(hl.a.class);
    }

    @Override // dl.g
    public void u6(BusinessFeedData feedData, int pos) {
        if (this.commentIoc == null) {
            this.commentIoc = (gf.a) getIocInterface(gf.a.class);
        }
        com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(feedData);
        bVar.f54740a = pos;
        bVar.f54741b = 4;
        bVar.f54742c = 1;
        gf.a aVar = this.commentIoc;
        if (aVar != null) {
            aVar.f6(bVar);
        }
        gf.a aVar2 = this.commentIoc;
        if (aVar2 != null) {
            aVar2.x1(null);
        }
        gf.a aVar3 = this.commentIoc;
        if (aVar3 != null) {
            aVar3.c1(feedData, null, pos);
        }
    }

    @Override // dl.g
    public void t9(BusinessFeedData feedData, boolean isLeftThumb) {
        int i3;
        String str;
        if ((feedData != null ? feedData.getFeedCommInfoV2() : null) == null) {
            RFWLog.e("QZOldStylePassiveMsgOperateDialogPart", RFWLog.USR, "feedData is null.");
            return;
        }
        if (isLeftThumb) {
            CellLeftThumb leftThumb = feedData.getLeftThumb();
            if (leftThumb == null) {
                return;
            } else {
                i3 = leftThumb.getActionType();
            }
        } else {
            i3 = feedData.getFeedCommInfoV2().actiontype;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (isLeftThumb) {
                        CellLeftThumb leftThumb2 = feedData.getLeftThumb();
                        str = leftThumb2 != null ? leftThumb2.getActionUrl() : null;
                    } else {
                        str = feedData.getFeedCommInfoV2().actionurl;
                    }
                    if (str == null || str.length() == 0) {
                        CellLeftThumb leftThumb3 = feedData.getLeftThumb();
                        str = leftThumb3 != null ? leftThumb3.getActionUrl() : null;
                    }
                    yo.d.c(str, getContext());
                    return;
                }
                if (i3 != 50) {
                    if (i3 != 51) {
                        switch (i3) {
                            case 27:
                            case 28:
                            case 29:
                                break;
                            default:
                                return;
                        }
                    }
                }
            }
            if (feedData.getOriginalInfoSafe() == null || feedData.getOriginalInfoSafe().getUser() == null) {
                return;
            }
            if (feedData.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.o(feedData);
            }
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                ho.i.f().h(getActivity(), feedData, null, 6);
                return;
            }
            ho.c e16 = ho.i.e();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            e16.j(activity, feedData);
            return;
        }
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            ho.i.f().e(getActivity(), feedData, null, 1);
            return;
        }
        ho.c e17 = ho.i.e();
        Intrinsics.checkNotNullExpressionValue(e17, "detail()");
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        ho.c.m(e17, activity2, feedData, 0L, 1, null, null, 32, null);
    }
}
