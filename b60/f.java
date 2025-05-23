package b60;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.events.QFSCommentEmojiAddedEvent;
import com.tencent.biz.qqcircle.events.QFSCommentLocateEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.immersive.views.banner.d;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.animation.transition.TransitionDragLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends u implements d.b, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private QFSImageBanner f27983d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.biz.qqcircle.immersive.views.banner.d f27984e;

    /* renamed from: f, reason: collision with root package name */
    private TransitionDragLayout f27985f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleMultiTouchImageView f27986h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleCommentPicLayerBean f27987i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f27988m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements TransitionDragLayout.OnDragListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onDragging() {
            f.this.f27985f.setBackgroundColor(0);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onEndDrag(boolean z16) {
            QLog.d("QFSCommentPicLayerPart", 1, "[onEndDrag] isDragToClose: " + z16);
            if (z16) {
                f.this.G9();
            } else {
                f.this.f27985f.setBackgroundColor(-16777216);
            }
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onStartDrag() {
            f fVar = f.this;
            fVar.f27986h = fVar.I9();
        }
    }

    public f(QCircleCommentPicLayerBean qCircleCommentPicLayerBean) {
        this.f27987i = qCircleCommentPicLayerBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private List<QFSCommentPicInfo> H9() {
        ArrayList arrayList = new ArrayList();
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.f27987i;
        if (qCircleCommentPicLayerBean == null) {
            QLog.e(getTAG(), 1, "[getAdapterData] layerBean == null");
            return arrayList;
        }
        if (qCircleCommentPicLayerBean.getCommentPicInfoList() != null) {
            return this.f27987i.getCommentPicInfoList();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public QCircleMultiTouchImageView I9() {
        com.tencent.biz.qqcircle.immersive.views.banner.d dVar = this.f27984e;
        if (dVar == null) {
            QLog.e("QFSCommentPicLayerPart", 1, "[getCurrentImageView] -> mBannerAdapter == null ");
            return null;
        }
        return dVar.y0();
    }

    private int J9() {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.f27987i;
        if (qCircleCommentPicLayerBean != null) {
            return qCircleCommentPicLayerBean.getStartPreviewIndex();
        }
        return 0;
    }

    private QFSCommentPicInfo K9(int i3) {
        List<QFSCommentPicInfo> list;
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.f27987i;
        if (qCircleCommentPicLayerBean != null) {
            list = qCircleCommentPicLayerBean.getCommentPicInfoList();
        } else {
            list = null;
        }
        if (list == null || i3 < 0 || i3 >= list.size()) {
            return null;
        }
        return list.get(i3);
    }

    private void L9() {
        QFSImageBanner qFSImageBanner = this.f27983d;
        if (qFSImageBanner == null) {
            QLog.e("CommentPicTag", 1, "[handleCommentLocate] mBanner is null");
            return;
        }
        QFSCommentPicInfo K9 = K9(qFSImageBanner.S());
        if (K9 == null) {
            QLog.e("CommentPicTag", 1, "[handleCommentLocate] picInfo is null");
            return;
        }
        if (TextUtils.isEmpty(K9.getFeedId())) {
            QLog.e("CommentPicTag", 1, "[handleCommentLocate] feedId is empty");
            return;
        }
        if (!TextUtils.isEmpty(K9.getCommentId()) && !K9.getCommentId().startsWith("fake")) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSCommentLocateEvent(K9.getFeedId(), K9.getCommentId(), K9.getReplyId()));
            return;
        }
        QLog.e("CommentPicTag", 1, "[handleCommentLocate] comment id: " + K9.getCommentId());
    }

    private void M9(String str) {
        QLog.d("QFSCommentPicLayerPart", 1, "[handleEmojiAddResult] url=" + str);
        QFSCommentPicInfo K9 = K9(0);
        if (K9 == null) {
            return;
        }
        try {
            if (!TextUtils.equals(K9.getFavEmojiUrl(), str)) {
                QLog.i("QFSCommentPicLayerPart", 1, "[handleEmojiAddResult] not the same emoji, =" + K9.getFavEmojiUrl());
                return;
            }
            d.c cVar = (d.c) ((RecyclerView) this.f27983d.X().getChildAt(0)).findViewHolderForAdapterPosition(0);
            if (cVar != null) {
                cVar.l();
            }
        } catch (Exception e16) {
            QLog.e("QFSCommentPicLayerPart", 1, "[handleEmojiAddResult] ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(int i3) {
        QLog.i("QFSCommentPicLayerPart", 1, "[setOnItemClickListener] -> position = " + i3);
        if (!ud2.a.f438849a.a()) {
            G9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(int i3) {
        if (this.f27988m && ud2.a.f438849a.a()) {
            QLog.i("QFSCommentPicLayerPart", 1, "landscape mode has no sheet dialog");
        } else {
            broadcastMessage("comment_show_sheet", K9(this.f27983d.S()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q9(MotionEvent motionEvent, float f16, float f17) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this.f27986h;
        if ((qCircleMultiTouchImageView != null && Math.abs(qCircleMultiTouchImageView.getScale() - 1.0f) > 0.001f) || f16 < Math.abs(f17)) {
            return false;
        }
        return true;
    }

    private void R9() {
        QFSImageBanner qFSImageBanner = this.f27983d;
        if (qFSImageBanner == null) {
            return;
        }
        qFSImageBanner.w0(J9());
    }

    private void S9() {
        QFSImageBanner qFSImageBanner = this.f27983d;
        if (qFSImageBanner == null) {
            return;
        }
        qFSImageBanner.z0(true);
    }

    private void initBanner() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.f27983d == null) {
            QLog.e("QFSCommentPicLayerPart", 1, "[initBanner] -> mBanner == null");
            return;
        }
        if (getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f27988m = z16;
        if (this.f27984e == null) {
            QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.f27987i;
            if (qCircleCommentPicLayerBean != null && !RFSafeListUtils.isEmpty(qCircleCommentPicLayerBean.getCommentPicInfoList())) {
                z17 = this.f27987i.getCommentPicInfoList().get(0).isEmojiPic();
                z18 = this.f27987i.needSaveOperate();
                z19 = this.f27987i.getNeedAddImageOperate();
            } else {
                z17 = false;
                z18 = false;
                z19 = false;
            }
            this.f27984e = new com.tencent.biz.qqcircle.immersive.views.banner.d(z17, this.f27988m, z18, z19);
        }
        this.f27984e.r0(false);
        this.f27984e.setEnableLoop(false);
        this.f27984e.setData(H9());
        this.f27984e.F0(this);
        this.f27983d.setAdapter(this.f27984e);
        this.f27983d.X().setOrientation(1);
        this.f27983d.setOnItemClickListener(new QFSImageBanner.c() { // from class: b60.d
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
            public final void onItemClick(int i3) {
                f.this.N9(i3);
            }
        });
        this.f27983d.setOnItemLongClickListener(new QFSImageBanner.e() { // from class: b60.e
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.e
            public final void onItemLongClick(int i3) {
                f.this.O9(i3);
            }
        });
        R9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.d.b
    public void N0(int i3, QFSCommentPicInfo qFSCommentPicInfo) {
        if (i3 >= 0 && qFSCommentPicInfo != null && qFSCommentPicInfo.getImage() != null) {
            QLog.d("CommentPicTag", 1, "[onAddEmoji] position=" + i3 + ", url=" + qFSCommentPicInfo.getImage().picUrl.get());
            broadcastMessage("comment_pic_fav_emoji", qFSCommentPicInfo);
            return;
        }
        QLog.w("CommentPicTag", 1, "[onAddEmoji] invalid params");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.d.b
    public void Q5(int i3, QFSCommentPicInfo qFSCommentPicInfo) {
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.f27987i;
        if (qCircleCommentPicLayerBean != null && qCircleCommentPicLayerBean.needSaveOperate()) {
            if (i3 >= 0 && qFSCommentPicInfo != null && qFSCommentPicInfo.getImage() != null) {
                QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                ArrayList arrayList = new ArrayList();
                arrayList.add(qFSCommentPicInfo.getImage());
                feedCloudMeta$StFeed.images.set(arrayList);
                feedCloudMeta$StFeed.type.set(2);
                qCircleShareInfo.feed = feedCloudMeta$StFeed;
                qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
                qCircleShareInfo.picDownPos = 0;
                qCircleShareInfo.type = 10;
                broadcastMessage("comment_pic_save", qCircleShareInfo);
                return;
            }
            QLog.w("CommentPicTag", 1, "[onDownload] invalid params");
            return;
        }
        QLog.w("CommentPicTag", 1, "[onDownload] cannot download");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSCommentEmojiAddedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentPicLayerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        L9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f27983d = (QFSImageBanner) view.findViewById(R.id.f359813b);
        ((ImageView) view.findViewById(R.id.f3593137)).setOnClickListener(new View.OnClickListener() { // from class: b60.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.P9(view2);
            }
        });
        initBanner();
        TransitionDragLayout transitionDragLayout = (TransitionDragLayout) view.findViewById(R.id.f3595139);
        this.f27985f = transitionDragLayout;
        transitionDragLayout.setFeatureEnable(true);
        this.f27985f.setEnableDragHorizontal(true);
        this.f27985f.setEnableDragVertical(true);
        this.f27985f.setOnDragListener(new a());
        this.f27985f.setDragInterceptDelegate(new TransitionDragLayout.DragInterceptDelegate() { // from class: b60.c
            @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.DragInterceptDelegate
            public final boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
                boolean Q9;
                Q9 = f.this.Q9(motionEvent, f16, f17);
                return Q9;
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        S9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSCommentEmojiAddedEvent) {
            M9(((QFSCommentEmojiAddedEvent) simpleBaseEvent).getEmojiUrl());
        }
    }
}
