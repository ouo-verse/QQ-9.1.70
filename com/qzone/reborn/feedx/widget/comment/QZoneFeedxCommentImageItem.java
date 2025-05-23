package com.qzone.reborn.feedx.widget.comment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.feed.business.model.ViewFeedPhotoData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AppSetting;
import gf.k;
import gf.u;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import rk.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxCommentImageItem extends QZoneBaseWidgetView<PictureItem> {

    /* renamed from: e, reason: collision with root package name */
    private RFWSquareImageView f56007e;

    /* renamed from: f, reason: collision with root package name */
    private k f56008f;

    /* renamed from: h, reason: collision with root package name */
    private Comment f56009h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<PictureItem> f56010i;

    /* renamed from: m, reason: collision with root package name */
    private d f56011m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedxCommentImageItem.this.r0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            QZoneFeedxCommentImageItem.this.s0(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements IPicLoadStateListener {
        c() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
                return;
            }
            option.getAnimatable().start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a(View view, int i3);
    }

    public QZoneFeedxCommentImageItem(Context context) {
        super(context);
        v0();
    }

    private void o0() {
        ViewGroup.LayoutParams layoutParams = this.f56007e.getLayoutParams();
        int q06 = q0();
        layoutParams.width = q06;
        layoutParams.height = q06;
        this.f56007e.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Comment comment;
        ViewFeedPhotoData viewFeedPhotoData;
        CellPictureInfo cellPictureInfo;
        Activity c16 = i.c(this);
        if (c16 == null || this.f56010i == null || (comment = this.f56009h) == null || comment.user == null) {
            return;
        }
        CellPictureInfo cellPictureInfo2 = new CellPictureInfo();
        cellPictureInfo2.balbum = false;
        cellPictureInfo2.albumnum = 1;
        cellPictureInfo2.uploadnum = 1;
        cellPictureInfo2.pics = this.f56010i;
        Object I = com.qzone.adapter.feedcomponent.i.H().I(cellPictureInfo2, this.dataPosInList);
        if (!(I instanceof ViewFeedPhotoData) || (cellPictureInfo = (viewFeedPhotoData = (ViewFeedPhotoData) I).pictureInfo) == null || cellPictureInfo.pics == null) {
            return;
        }
        rk.d dVar = new rk.d();
        dVar.v(viewFeedPhotoData.pictureInfo);
        dVar.g(viewFeedPhotoData.curIndex);
        dVar.i(1204);
        dVar.f(this.f56007e);
        if (x.f55790a.d(k0().getPageType())) {
            dVar.s(true);
        }
        ((e) ho.i.t(e.class)).A(c16, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(View view) {
        d dVar = this.f56011m;
        if (dVar != null) {
            dVar.a(view, this.dataPosInList);
        }
    }

    private void u0(PictureItem pictureItem) {
        Option obtain = Option.obtain();
        obtain.setUrl(pictureItem.currentUrl.url);
        obtain.setTargetView(this.f56007e);
        if (this.f56007e.getLayoutParams() != null) {
            obtain.setRequestWidth(this.f56007e.getLayoutParams().width);
            obtain.setRequestHeight(this.f56007e.getLayoutParams().height);
        }
        obtain.setLoadingDrawable(getResources().getDrawable(R.drawable.at8));
        obtain.setFailDrawable(getResources().getDrawable(R.drawable.at_));
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new c());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167263a44;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.widget.QZoneBaseWidgetView
    public k k0() {
        if (this.f56008f == null) {
            this.f56008f = (k) getIocInterface(k.class);
        }
        if (this.f56008f == null && !AppSetting.isDebugVersion()) {
            try {
                return (k) u.class.newInstance();
            } catch (Exception e16) {
                QLog.e("QZoneFeedxCommentImageItem", 1, "getPageTypeIoc  e = " + e16.getMessage());
                return null;
            }
        }
        return this.f56008f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(PictureItem pictureItem, int i3) {
        o0();
        u0(pictureItem);
    }

    protected int q0() {
        if (x.f55790a.c(k0().getPageType())) {
            return ImmersiveUtils.dpToPx(70.0f);
        }
        return ImmersiveUtils.dpToPx(64.0f);
    }

    public void setCommentData(Comment comment) {
        this.f56009h = comment;
    }

    public void setOnImageLongClickListener(d dVar) {
        this.f56011m = dVar;
    }

    public void setPicList(ArrayList<PictureItem> arrayList) {
        this.f56010i = arrayList;
    }

    public void setRoundRect(int i3) {
        this.f56007e.setRoundRect(i3);
    }

    private void v0() {
        RFWSquareImageView rFWSquareImageView = (RFWSquareImageView) findViewById(R.id.mrq);
        this.f56007e = rFWSquareImageView;
        rFWSquareImageView.setRoundRect(DisplayUtil.dip2px(MobileQQ.sMobileQQ, 2.0f));
        this.f56007e.setOnClickListener(new a());
        this.f56007e.setOnLongClickListener(new b());
    }
}
