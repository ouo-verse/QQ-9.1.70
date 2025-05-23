package com.qzone.reborn.albumx.qzonex.part.layer;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\"\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/g;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "", "M9", "", "I9", "commentCount", "S9", "J9", "K9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "R9", "Lcom/qzone/reborn/albumx/common/bean/d;", "H9", "Lbb/c;", "commentInfo", "L9", "T9", "U9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onActivityResult", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "commentNum", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "commentIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "commentInput", "Loc/u;", BdhLogUtil.LogTag.Tag_Conn, "Loc/u;", "operateViewModel", "Loc/p;", "D", "Loc/p;", "commentViewModel", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends b {

    /* renamed from: C, reason: from kotlin metadata */
    private oc.u operateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private oc.p commentViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView commentNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView commentIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView commentInput;

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        if (r1 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.qzone.reborn.albumx.common.bean.d H9() {
        String str;
        String str2;
        String str3;
        String str4;
        String uploadUid;
        com.qzone.reborn.albumx.common.bean.d dVar = new com.qzone.reborn.albumx.common.bean.d();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        dVar.n(x95 != null ? x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String() : false);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        String str5 = "";
        if (x96 == null || (str = x96.getUin()) == null) {
            str = "";
        }
        dVar.k(str);
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str2 = x97.getAlbumId()) == null) {
            str2 = "";
        }
        dVar.h(str2);
        QZAlbumxLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str3 = x98.getBatchId()) == null) {
            str3 = "";
        }
        dVar.i(str3);
        QZAlbumxLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str4 = x99.getLLoc()) == null) {
            str4 = "";
        }
        dVar.l(str4);
        QZAlbumxLayerExtraInfoBean x910 = x9();
        if (x910 == null || (uploadUid = x910.getAlbumCreatorUin()) == null) {
            QZAlbumxLayerExtraInfoBean x911 = x9();
            uploadUid = x911 != null ? x911.getUploadUid() : null;
        }
        str5 = uploadUid;
        dVar.m(str5);
        QZAlbumxLayerExtraInfoBean x912 = x9();
        dVar.j(x912 != null ? x912.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() : 0L);
        return dVar;
    }

    private final int I9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getCommentNum();
        }
        return 0;
    }

    private final void J9() {
        broadcastMessage(CommonLayerCommentPanelPart.INSTANCE.a(), null);
    }

    private final void K9() {
        ho.i.c().p(new QZoneCommentPanelParams.a().y(256).q(cd.c.j(false, null, 3, null)).getParams(), getActivity(), H9());
    }

    private final void L9(bb.c commentInfo) {
        boolean equals$default;
        boolean equals$default2;
        if (x9() != null) {
            QZAlbumxLayerExtraInfoBean x95 = x9();
            equals$default = StringsKt__StringsJVMKt.equals$default(x95 != null ? x95.getUin() : null, commentInfo.getUin(), false, 2, null);
            if (equals$default) {
                QZAlbumxLayerExtraInfoBean x96 = x9();
                equals$default2 = StringsKt__StringsJVMKt.equals$default(x96 != null ? x96.getLLoc() : null, commentInfo.getLloc(), false, 2, null);
                if (equals$default2) {
                    S9(commentInfo.getCommentNum());
                    T9(commentInfo);
                    U9(commentInfo);
                }
            }
        }
    }

    private final void M9() {
        MutableLiveData<bb.c> j3;
        this.operateViewModel = (oc.u) getViewModel(oc.u.class);
        oc.p pVar = (oc.p) getViewModel(oc.p.class);
        this.commentViewModel = pVar;
        if (pVar == null || (j3 = pVar.j3()) == null) {
            return;
        }
        j3.observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.N9(g.this, (bb.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(g this$0, bb.c cVar) {
        boolean equals$default;
        boolean equals$default2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.x9() != null) {
            QZAlbumxLayerExtraInfoBean x95 = this$0.x9();
            equals$default = StringsKt__StringsJVMKt.equals$default(x95 != null ? x95.getUin() : null, cVar.getUin(), false, 2, null);
            if (equals$default) {
                QZAlbumxLayerExtraInfoBean x96 = this$0.x9();
                equals$default2 = StringsKt__StringsJVMKt.equals$default(x96 != null ? x96.getLLoc() : null, cVar.getLloc(), false, 2, null);
                if (equals$default2) {
                    bb.c cVar2 = new bb.c(cVar.getAction());
                    cVar2.h(cVar.getUin());
                    cVar2.g(cVar.getLloc());
                    if (cVar.getAction() == 1) {
                        cVar2.d(this$0.I9() + cVar.getCommentNum());
                    } else if (cVar.getAction() == 2) {
                        cVar2.d(this$0.I9() - cVar.getCommentNum());
                    } else {
                        cVar2.d(cVar.getCommentNum());
                    }
                    this$0.L9(cVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9(QZoneCommentPanelResultBean commentResultBean) {
        com.qzone.reborn.albumx.common.bean.d H9 = H9();
        ff.a aVar = ff.a.f398543a;
        Comment c16 = aVar.c(commentResultBean);
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        String uin = x95.getUin();
        Intrinsics.checkNotNull(uin);
        Comment a16 = aVar.a(c16, uin);
        oc.p pVar = this.commentViewModel;
        if (pVar != null) {
            pVar.T1(H9, a16, commentResultBean.g());
        }
    }

    private final void S9(int commentCount) {
        TextView textView = this.commentNum;
        if (textView == null) {
            return;
        }
        if (commentCount > 0) {
            String p16 = tk.h.p(commentCount);
            TextView textView2 = this.commentNum;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(p16);
            TextView textView3 = this.commentNum;
            Intrinsics.checkNotNull(textView3);
            textView3.setContentDescription(com.qzone.util.l.a(R.string.s3x) + p16);
            return;
        }
        Intrinsics.checkNotNull(textView);
        textView.setText(com.qzone.util.l.a(R.string.s3x));
        TextView textView4 = this.commentNum;
        Intrinsics.checkNotNull(textView4);
        textView4.setContentDescription(com.qzone.util.l.a(R.string.s3x));
    }

    private final void T9(bb.c commentInfo) {
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            QZAlbumxLayerExtraInfoBean x95 = x9();
            if (TextUtils.equals(mediaId, x95 != null ? x95.getLLoc() : null) && (rFWLayerItemMediaInfo.getExtraData() instanceof QZAlbumxLayerExtraInfoBean)) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean");
                QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = (QZAlbumxLayerExtraInfoBean) extraData;
                qZAlbumxLayerExtraInfoBean.C(commentInfo.getCommentNum());
                rFWLayerItemMediaInfo.setExtraData(qZAlbumxLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    private final void U9(bb.c commentInfo) {
        oc.a E;
        hb.c cVar = (hb.c) PartIOCKt.getIocInterface(this, hb.c.class);
        if (cVar == null || (E = cVar.E()) == null) {
            return;
        }
        E.a2(commentInfo.getLloc(), commentInfo.getCommentNum());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null || (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) == null || requestCode != 256) {
            return;
        }
        R9(qZoneCommentPanelResultBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        M9();
        this.commentIcon = rootView != null ? (ImageView) rootView.findViewById(R.id.f199876) : null;
        this.commentNum = rootView != null ? (TextView) rootView.findViewById(R.id.f200078) : null;
        this.commentInput = rootView != null ? (TextView) rootView.findViewById(R.id.f199977) : null;
        ImageView imageView = this.commentIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.O9(g.this, view);
                }
            });
        }
        TextView textView = this.commentNum;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.P9(g.this, view);
                }
            });
        }
        TextView textView2 = this.commentInput;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.Q9(g.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        String tag = getTAG();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        QLog.e(tag, 1, "handleCommentListResponse  lloc=" + (x95 != null ? x95.getLLoc() : null));
        S9(I9());
    }
}
