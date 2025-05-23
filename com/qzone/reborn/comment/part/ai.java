package com.qzone.reborn.comment.part;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import fh.b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b)\u0010*J9\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J(\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/comment/part/ai;", "Lcom/qzone/reborn/base/k;", "Lxc/h;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "shareType", "shareState", "", "", "", "C9", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;ILjava/lang/Integer;)Ljava/util/Map;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "view", "Y5", "P8", "eventId", ICustomDataEditor.STRING_PARAM_5, "", "isPrivate", "isBubble", "isTypeface", "b4", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Ldd/b;", "e", "Ldd/b;", "mInputViewModel", "Ldd/a;", "f", "Ldd/a;", "mDataViewModel", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ai extends com.qzone.reborn.base.k implements xc.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private dd.a mDataViewModel;

    public ai(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final Map<String, Object> C9(BusinessFeedData feedData, int shareType, Integer shareState) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(fh.b.INSTANCE.a(feedData));
        linkedHashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, Integer.valueOf(shareType));
        if (shareState != null) {
            linkedHashMap.put("share_state", shareState);
        }
        return linkedHashMap;
    }

    @Override // xc.h
    public void P8(View view, int shareType, int shareState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.initParams.getIsShare()) {
            dd.a aVar = this.mDataViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
                aVar = null;
            }
            BusinessFeedData value = aVar.j().getValue();
            fo.b bVar = new fo.b();
            bVar.l(C9(value, shareType, Integer.valueOf(shareState)));
            Unit unit = Unit.INSTANCE;
            fo.c.o(view, "em_qz_share_send", bVar);
        }
    }

    @Override // xc.h
    public void Y5(View view, int shareType) {
        Intrinsics.checkNotNullParameter(view, "view");
        dd.a aVar = this.mDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar = null;
        }
        BusinessFeedData value = aVar.j().getValue();
        if (fh.b.INSTANCE.f(value)) {
            fo.c.e("em_qz_share_send", this.initParams.getFromDtPageId(), view, C9(value, shareType, null));
        }
    }

    @Override // xc.h
    public void b4(View view, boolean isPrivate, boolean isBubble, boolean isTypeface) {
        Intrinsics.checkNotNullParameter(view, "view");
        dd.a aVar = this.mDataViewModel;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar = null;
        }
        BusinessFeedData value = aVar.j().getValue();
        b.Companion companion = fh.b.INSTANCE;
        if (companion.f(value)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(companion.a(value));
            hashMap.put("is_private", Integer.valueOf(isPrivate ? 1 : 0));
            dd.b bVar = this.mInputViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar = null;
            }
            hashMap.put("is_pictures", Integer.valueOf(!bl.b(bVar.R1()) ? 1 : 0));
            hashMap.put("is_bubble", Integer.valueOf(isBubble ? 1 : 0));
            hashMap.put("is_typeface", Integer.valueOf(isTypeface ? 1 : 0));
            CommentReplyParam commentReplyParam = this.initParams.getCommentReplyParam();
            if (TextUtils.isEmpty(commentReplyParam != null ? commentReplyParam.getCommentID() : null)) {
                hashMap.put("comment_type", 1);
                if (value != null) {
                    hashMap.put("to_uin", Long.valueOf(value.getUser().uin));
                }
            } else {
                hashMap.put("comment_type", 2);
                CommentReplyParam commentReplyParam2 = this.initParams.getCommentReplyParam();
                if (!TextUtils.isEmpty(commentReplyParam2 != null ? commentReplyParam2.getReplyUin() : null)) {
                    CommentReplyParam commentReplyParam3 = this.initParams.getCommentReplyParam();
                    if (commentReplyParam3 != null) {
                        str = commentReplyParam3.getReplyUin();
                    }
                } else {
                    CommentReplyParam commentReplyParam4 = this.initParams.getCommentReplyParam();
                    if (commentReplyParam4 != null) {
                        str = commentReplyParam4.getCommentUin();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNull(str);
                    hashMap.put("to_uin", str);
                }
            }
            fo.c.e("em_qz_send", "pg_qz_spatial_keyboard", view, hashMap);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, xc.h.class);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        ViewModel viewModel2 = getViewModel(dd.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneInputDataViewModel::class.java)");
        this.mDataViewModel = (dd.a) viewModel2;
    }

    @Override // xc.h
    public void s5(String eventId, View view, int shareType, int shareState) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.initParams.getIsShare()) {
            dd.a aVar = this.mDataViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
                aVar = null;
            }
            Map<String, Object> C9 = C9(aVar.j().getValue(), shareType, Integer.valueOf(shareState));
            C9.put("dt_pgid", this.initParams.getFromDtPageId());
            fo.c.b(eventId, view, "em_qz_share_send", new fo.b().l(C9).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
        }
    }
}
