package com.tencent.biz.qqcircle.comment.wrapper;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfoSet;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.helpers.u;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.viewmodels.n;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class h<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final int f84145g = DisplayUtil.dip2px(RFWApplication.getApplication(), 156.0f);

    /* renamed from: h, reason: collision with root package name */
    private static final int f84146h = DisplayUtil.dip2px(RFWApplication.getApplication(), 117.0f);

    /* renamed from: a, reason: collision with root package name */
    private final View f84147a;

    /* renamed from: b, reason: collision with root package name */
    protected T f84148b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudMeta$StFeed f84149c;

    /* renamed from: d, reason: collision with root package name */
    private View f84150d;

    /* renamed from: e, reason: collision with root package name */
    private ImageFilterView f84151e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f84152f = false;

    public h(@NonNull View view) {
        this.f84147a = view;
    }

    private void d() {
        int i3;
        int i16;
        if (this.f84150d == null) {
            return;
        }
        Size m3 = m();
        if (m3.getWidth() != 0 && m3.getHeight() != 0) {
            float height = m3.getHeight() / m3.getWidth();
            if (height <= 0.85714287f) {
                i3 = f84145g;
            } else {
                i3 = f84146h;
            }
            if (height >= 1.1666666f) {
                i16 = f84145g;
            } else {
                i16 = f84146h;
            }
            QLog.d("CommentPicTag", 4, "picSize: " + m3 + ", scale: " + height + ", width: " + i3 + ", height: " + i16);
            ViewGroup.LayoutParams layoutParams = this.f84150d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            this.f84150d.setLayoutParams(layoutParams);
        }
    }

    private void f() {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f84149c;
        String str2 = "";
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, "image");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f84149c;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null) {
            str2 = feedCloudMeta$StUser.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        VideoReport.setElementId(this.f84151e, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_VIDEO_STYLE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.f84151e, buildElementParams);
    }

    private List<QFSCommentPicInfo> g(r20.a aVar) {
        String K0;
        List<QFSCommentItemInfo> list;
        List<QFSReplyItemInfo> list2;
        ArrayList arrayList = new ArrayList();
        if (aVar != null && aVar.getCommentPartHost() != null && (aVar.getCommentPartHost() instanceof QCircleBaseFragment)) {
            n nVar = (n) ((QCircleBaseFragment) aVar.getCommentPartHost()).getViewModel(n.class);
            UIStateData<List<QFSCommentItemInfo>> value = nVar.c2().getValue();
            FeedCloudMeta$StFeed value2 = nVar.b2().getValue();
            if (value != null && value2 != null && !RFSafeListUtils.isEmpty(value.getData())) {
                list = value.getData();
                K0 = value2.f398449id.get();
            } else {
                List<QFSCommentItemInfo> dataList = aVar.getCmtBlock().getDataList();
                K0 = aVar.getCmtBlock().K0();
                list = dataList;
            }
            if (list == null) {
                QLog.e("CommentPicTag", 1, "[extractPicInfoFromComments] data is empty.");
                return arrayList;
            }
            for (QFSCommentItemInfo qFSCommentItemInfo : list) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
                if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.commentPic.has() && !TextUtils.isEmpty(qFSCommentItemInfo.comment.commentPic.picUrl.get())) {
                    QFSCommentPicInfo qFSCommentPicInfo = new QFSCommentPicInfo(K0, qFSCommentItemInfo.comment.f398447id.get(), "", qFSCommentItemInfo.comment.commentPic.get());
                    qFSCommentPicInfo.setComment(qFSCommentItemInfo.comment);
                    arrayList.add(qFSCommentPicInfo);
                }
                if (qFSCommentItemInfo.comment != null && (list2 = qFSCommentItemInfo.replyItemList) != null && list2.size() != 0) {
                    for (QFSReplyItemInfo qFSReplyItemInfo : qFSCommentItemInfo.replyItemList) {
                        FeedCloudMeta$StReply feedCloudMeta$StReply = qFSReplyItemInfo.reply;
                        if (feedCloudMeta$StReply != null && feedCloudMeta$StReply.replyPic.has() && !TextUtils.isEmpty(qFSReplyItemInfo.reply.replyPic.picUrl.get())) {
                            QFSCommentPicInfo qFSCommentPicInfo2 = new QFSCommentPicInfo(K0, qFSCommentItemInfo.comment.f398447id.get(), qFSReplyItemInfo.reply.f398460id.get(), qFSReplyItemInfo.reply.replyPic.get());
                            qFSCommentPicInfo2.setComment(qFSCommentItemInfo.comment);
                            qFSCommentPicInfo2.setReply(qFSReplyItemInfo.reply);
                            arrayList.add(qFSCommentPicInfo2);
                        }
                    }
                }
            }
            return arrayList;
        }
        QLog.e("CommentPicTag", 1, "[extractPicInfoFromComments] ioc == null");
        return arrayList;
    }

    private void h(View view, OnPromiseResolved<r20.a> onPromiseResolved) {
        RFWIocAbilityProvider.g().getIoc(r20.a.class).originView(view).done(onPromiseResolved).fail(new OnPromiseRejected() { // from class: com.tencent.biz.qqcircle.comment.wrapper.g
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                h.t(str);
            }
        }).run();
    }

    private int j(String str, List<QFSCommentPicInfo> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                FeedCloudMeta$StImage image = list.get(i3).getImage();
                if (image != null && TextUtils.equals(str, image.picUrl.get())) {
                    return i3;
                }
            }
        }
        return 0;
    }

    private QFSTransitionAnimBean o(String str) {
        View view = this.f84150d;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i3 = iArr[0];
            return new QFSTransitionAnimBean().setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.f84150d.getWidth() + i3, iArr[1] + this.f84150d.getHeight())).setImageUrl(str).setScaleType(ImageView.ScaleType.CENTER_CROP).setBackTransition(true);
        }
        return null;
    }

    private void p(@NonNull final String str) {
        h(this.f84147a, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.comment.wrapper.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                h.this.u(str, (r20.a) obj);
            }
        });
    }

    private void r(String str, List<QFSCommentPicInfo> list, String str2) {
        if (this.f84151e == null) {
            QLog.e("CommentPicTag", 1, "[jumpPicPreviewPage] mPicIv == null");
            return;
        }
        if (list != null && list.size() > 0) {
            w(list);
            int j3 = j(str, list);
            QLog.d("CommentPicTag", 1, "[jumpPicPreviewPage] previewIndex: " + j3 + ", picSize: " + list.size() + ", jumpUrl: " + str + ", partHashCode: " + str2);
            QCircleCommentPicLayerBean qCircleCommentPicLayerBean = new QCircleCommentPicLayerBean();
            qCircleCommentPicLayerBean.setStartPreviewIndex(j3);
            qCircleCommentPicLayerBean.setNeedSaveOperate(true);
            qCircleCommentPicLayerBean.setNeedAddImageOperate(true);
            qCircleCommentPicLayerBean.setFromHashCode(str2);
            QFSTransitionAnimBean o16 = o(str);
            if (o16 != null) {
                o16.setCoverDrawable(this.f84151e.getDrawable());
                qCircleCommentPicLayerBean.setTransitionAnimBean(o16);
            }
            com.tencent.biz.qqcircle.launcher.c.s(this.f84151e.getContext(), qCircleCommentPicLayerBean);
            return;
        }
        QLog.e("CommentPicTag", 1, "[jumpPicPreviewPage] picInfoSize is null or empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("CommentPicTag_jumpCommentPicPreview")) {
            if ((this.f84151e.getTag() instanceof String) && !TextUtils.isEmpty((String) this.f84151e.getTag())) {
                String str2 = (String) this.f84151e.getTag();
                this.f84151e.setTag("");
                v(str2);
                p(str2);
            } else if (!TextUtils.isEmpty(str)) {
                p(str);
            } else {
                QCircleToast.o("\u8bc4\u8bba\u5931\u8d25", 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(String str) {
        QLog.e("CommentPicTag", 1, new RuntimeException("[getCommentPartIoc]  error = " + str), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(String str, r20.a aVar) {
        String str2 = "";
        if (aVar != null && aVar.getCommentPartHost() != null) {
            str2 = aVar.getCommentPartHost().hashCode() + "";
        }
        r(str, g(aVar), str2);
        f();
    }

    private void w(List<QFSCommentPicInfo> list) {
        k.a().o("mmkv_key_pic_info_set", new QFSCommentPicInfoSet(list));
    }

    public void e(T t16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f84148b = t16;
        this.f84149c = feedCloudMeta$StFeed;
        if (q()) {
            QLog.d("CommentPicTag", 1, "hasPic: true");
            ViewStub viewStub = (ViewStub) this.f84147a.findViewById(k());
            if (this.f84150d == null && viewStub != null) {
                View inflate = viewStub.inflate();
                this.f84150d = inflate;
                this.f84151e = (ImageFilterView) inflate.findViewById(R.id.f359913c);
            }
            View view = this.f84150d;
            if (view != null && this.f84151e != null) {
                view.setVisibility(0);
                u.f84666a.b(this.f84151e);
                d();
                String n3 = n();
                final String l3 = l();
                QLog.d("CommentPicTag", 1, "loadPicPath: " + n3);
                if (!TextUtils.isEmpty(n3) && !n3.startsWith("http")) {
                    this.f84151e.setTag(n3);
                }
                Option obtain = Option.obtain();
                obtain.setUrl(n3);
                obtain.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
                obtain.setRequestWidth(this.f84150d.getLayoutParams().width);
                obtain.setRequestHeight(this.f84150d.getLayoutParams().height);
                obtain.setTargetView(this.f84151e);
                LibraGroupKey libraGroupKey = new LibraGroupKey(String.valueOf(t16.hashCode()));
                libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
                obtain.setGroupKey(libraGroupKey);
                QCircleFeedPicLoader.g().loadImage(obtain);
                if (this.f84152f) {
                    this.f84151e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.wrapper.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            h.this.s(l3, view2);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        View view2 = this.f84150d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public ImageFilterView i() {
        return this.f84151e;
    }

    protected abstract int k();

    protected abstract String l();

    protected abstract Size m();

    protected abstract String n();

    protected boolean q() {
        return !TextUtils.isEmpty(n());
    }

    protected abstract void v(String str);
}
