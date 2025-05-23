package com.qzone.reborn.feedx.part.eventtag;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.ui.widget.a;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;
import qzone.QZoneTagFeedList$ShareTagInfo;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagSharePanelPart;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/common/event/ui/widget/a$b;", "", "initViewModel", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "coverData", "F9", "Landroid/content/Intent;", "data", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "relationType", "X1", "action", "", "args", "handleBroadcastMessage", "H9", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/qzone/common/event/ui/widget/a;", "d", "Lcom/qzone/common/event/ui/widget/a;", "mSharePanel", "e", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "mFeedCoverData", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "f", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mEventTagViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagSharePanelPart extends com.qzone.reborn.base.k implements a.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.common.event.ui.widget.a mSharePanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneTagFeedList$GetTagFeedListHeadRsp mFeedCoverData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxEventTagViewModel mEventTagViewModel;

    private final void E9(Intent data) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (this.mFeedCoverData == null) {
            return;
        }
        Parcelable parcelableExtra = data.getParcelableExtra("comment_panel_result_bean");
        if (parcelableExtra instanceof QZoneCommentPanelResultBean) {
            QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
            String cacheUniKey = qZoneCommentPanelResultBean.getCacheUniKey();
            String inputContent = qZoneCommentPanelResultBean.getInputContent();
            QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp = this.mFeedCoverData;
            Intrinsics.checkNotNull(qZoneTagFeedList$GetTagFeedListHeadRsp);
            String str = qZoneTagFeedList$GetTagFeedListHeadRsp.tag_name.get();
            String str2 = str == null ? "" : str;
            QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp2 = this.mFeedCoverData;
            Intrinsics.checkNotNull(qZoneTagFeedList$GetTagFeedListHeadRsp2);
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo = qZoneTagFeedList$GetTagFeedListHeadRsp2.shareinfo;
            String str3 = (qZoneTagFeedList$ShareTagInfo == null || (pBStringField2 = qZoneTagFeedList$ShareTagInfo.share_intro) == null) ? null : pBStringField2.get();
            String str4 = str3 == null ? "" : str3;
            QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp3 = this.mFeedCoverData;
            Intrinsics.checkNotNull(qZoneTagFeedList$GetTagFeedListHeadRsp3);
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo2 = qZoneTagFeedList$GetTagFeedListHeadRsp3.shareinfo;
            String str5 = (qZoneTagFeedList$ShareTagInfo2 == null || (pBStringField = qZoneTagFeedList$ShareTagInfo2.share_url) == null) ? null : pBStringField.get();
            String str6 = str5 == null ? "" : str5;
            QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp4 = this.mFeedCoverData;
            Intrinsics.checkNotNull(qZoneTagFeedList$GetTagFeedListHeadRsp4);
            PBStringField pBStringField3 = qZoneTagFeedList$GetTagFeedListHeadRsp4.tag_image;
            String str7 = pBStringField3 != null ? pBStringField3.get() : null;
            String str8 = str7 != null ? str7 : "";
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str8);
            QZoneWriteOperationService.v0().i0(null, str6, QZoneShareManager.THIRD_PART_SHARE_APPID, LoginData.getInstance().getUin(), str2, str4, inputContent, arrayList, cacheUniKey, getMainHandler());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(QZoneTagFeedList$GetTagFeedListHeadRsp coverData) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        this.mFeedCoverData = coverData;
        if (coverData != null) {
            com.qzone.common.event.ui.widget.a aVar = new com.qzone.common.event.ui.widget.a(getActivity(), coverData.opmasks.get(), this);
            this.mSharePanel = aVar;
            String str2 = coverData.tag_name.get();
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo = coverData.shareinfo;
            String str3 = null;
            String str4 = (qZoneTagFeedList$ShareTagInfo == null || (pBStringField4 = qZoneTagFeedList$ShareTagInfo.share_intro) == null) ? null : pBStringField4.get();
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "it.shareinfo?.share_intro?.get() ?: \"\"");
            }
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo2 = coverData.shareinfo;
            String str5 = (qZoneTagFeedList$ShareTagInfo2 == null || (pBStringField3 = qZoneTagFeedList$ShareTagInfo2.share_url) == null) ? null : pBStringField3.get();
            if (str5 == null) {
                str5 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "it.shareinfo?.share_url?.get() ?: \"\"");
            }
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo3 = coverData.shareinfo;
            String str6 = (qZoneTagFeedList$ShareTagInfo3 == null || (pBStringField2 = qZoneTagFeedList$ShareTagInfo3.share_pic) == null) ? null : pBStringField2.get();
            if (str6 == null) {
                str6 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "it.shareinfo?.share_pic?.get() ?: \"\"");
            }
            QZoneTagFeedList$ShareTagInfo qZoneTagFeedList$ShareTagInfo4 = coverData.shareinfo;
            if (qZoneTagFeedList$ShareTagInfo4 != null && (pBStringField = qZoneTagFeedList$ShareTagInfo4.sign_ark) != null) {
                str3 = pBStringField.get();
            }
            if (str3 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.shareinfo?.sign_ark?.get() ?: \"\"");
                str = str3;
            }
            aVar.j(str2, str4, str5, str6, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZoneFeedxEventTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFeedxE\u2026TagViewModel::class.java)");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) viewModel;
        this.mEventTagViewModel = qZoneFeedxEventTagViewModel;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w26 = qZoneFeedxEventTagViewModel.w2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit> function1 = new Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagSharePanelPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                invoke2(qZoneTagFeedList$GetTagFeedListHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                QZoneFeedxEventTagSharePanelPart.this.F9(qZoneTagFeedList$GetTagFeedListHeadRsp);
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagSharePanelPart.G9(Function1.this, obj);
            }
        });
    }

    public final void H9() {
        com.qzone.common.event.ui.widget.a aVar = this.mSharePanel;
        if (aVar != null) {
            aVar.i(0);
            aVar.k();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxEventTagSharePanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "open_event_tag_action_panel")) {
            H9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20225 && resultCode == -1 && data != null) {
            E9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
    }

    @Override // com.qzone.common.event.ui.widget.a.b
    public void X1(int relationType) {
    }
}
