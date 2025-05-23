package com.qzone.reborn.message.section;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J*\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/message/section/p;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/CellLeftThumb;", "leftThumb", "", "B", BdhLogUtil.LogTag.Tag_Conn, "D", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "leftThumbContainer", "i", "Landroid/view/View;", "leftThumbPicContainer", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "leftThumbPic", "picVideoIcon", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "rightTitle", "E", "rightSummary", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView picVideoIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneRichTextView rightTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneRichTextView rightSummary;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout leftThumbContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View leftThumbPicContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView leftThumbPic;

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        dl.g w3 = w();
        if (w3 != null) {
            w3.t9((BusinessFeedData) this.mData, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.leftThumbContainer = (FrameLayout) containerView.findViewById(R.id.n77);
        this.leftThumbPicContainer = containerView.findViewById(R.id.n7g);
        this.leftThumbPic = (ImageView) containerView.findViewById(R.id.n7f);
        this.picVideoIcon = (ImageView) containerView.findViewById(R.id.n7h);
        this.rightTitle = (QZoneRichTextView) containerView.findViewById(R.id.n7o);
        this.rightSummary = (QZoneRichTextView) containerView.findViewById(R.id.n7n);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.G(p.this, view);
            }
        };
        FrameLayout frameLayout = this.leftThumbContainer;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        ImageView imageView = this.leftThumbPic;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        QZoneRichTextView qZoneRichTextView = this.rightTitle;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(onClickListener);
        }
        QZoneRichTextView qZoneRichTextView2 = this.rightSummary;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nnp};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if ((data != null ? data.getLeftThumb() : null) != null) {
            FrameLayout frameLayout = this.leftThumbContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else {
            FrameLayout frameLayout2 = this.leftThumbContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        if (data != null) {
            B(data.getLeftThumb());
            C(data.getLeftThumb());
        }
    }

    private final void B(CellLeftThumb leftThumb) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        String str = (leftThumb == null || (pictureItem = leftThumb.getPictureItem()) == null || (pictureUrl = pictureItem.currentUrl) == null) ? null : pictureUrl.url;
        if (str == null || str.length() == 0) {
            View view = this.leftThumbPicContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            QLog.e("QZOldStylePassiveMsgLeftThumbSection", 1, "[bindLeftPic] bind error, url is invalid.");
            return;
        }
        View view2 = this.leftThumbPicContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        FeedPictureInfo pictureInfo = leftThumb.getPictureInfo();
        if ((pictureInfo != null ? pictureInfo.d() : null) != FeedPictureInfo.ImageType.VIDEO) {
            FeedPictureInfo pictureInfo2 = leftThumb.getPictureInfo();
            if ((pictureInfo2 != null ? pictureInfo2.d() : null) != FeedPictureInfo.ImageType.LEFT_THUMB_VIDEO) {
                ImageView imageView = this.picVideoIcon;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                Option obtain = Option.obtain();
                obtain.setUrl(str);
                obtain.setTargetView(this.leftThumbPic);
                obtain.setLoadingDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at8, null));
                obtain.setFailedDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at_, null));
                com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
            }
        }
        ImageView imageView2 = this.picVideoIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        Option obtain2 = Option.obtain();
        obtain2.setUrl(str);
        obtain2.setTargetView(this.leftThumbPic);
        obtain2.setLoadingDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at8, null));
        obtain2.setFailedDrawable(ResourcesCompat.getDrawable(p().getResources(), R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain2);
    }

    private final void C(CellLeftThumb leftThumb) {
        String parseTitle = leftThumb != null ? leftThumb.getParseTitle() : null;
        String parseSummary = leftThumb != null ? leftThumb.getParseSummary() : null;
        boolean z16 = true;
        if (parseTitle == null || parseTitle.length() == 0) {
            if (parseSummary == null || parseSummary.length() == 0) {
                QZoneRichTextView qZoneRichTextView = this.rightTitle;
                if (qZoneRichTextView == null) {
                    return;
                }
                qZoneRichTextView.setVisibility(8);
                return;
            }
        }
        QZoneRichTextView qZoneRichTextView2 = this.rightTitle;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setVisibility(0);
        }
        if (parseTitle != null && parseTitle.length() != 0) {
            z16 = false;
        }
        if (z16) {
            QZoneRichTextView qZoneRichTextView3 = this.rightSummary;
            if (qZoneRichTextView3 != null) {
                qZoneRichTextView3.setVisibility(8);
            }
            parseTitle = parseSummary;
        } else {
            QZoneRichTextView qZoneRichTextView4 = this.rightSummary;
            if (qZoneRichTextView4 != null) {
                qZoneRichTextView4.setVisibility(0);
            }
        }
        QZoneRichTextView qZoneRichTextView5 = this.rightTitle;
        if (qZoneRichTextView5 != null) {
            qZoneRichTextView5.setRichText(parseTitle);
        }
        QZoneRichTextView qZoneRichTextView6 = this.rightSummary;
        if (qZoneRichTextView6 != null) {
            qZoneRichTextView6.setRichText(parseSummary);
        }
    }
}
