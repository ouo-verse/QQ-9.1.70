package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0003J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/aw;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", "", "y", HippyTKDListViewAdapter.X, "w", "v", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "", NodeProps.VISIBLE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "type", "e", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "d", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "mVerticalBottomAvatarController", "G", "mVerticalBottomContentController", "H", "verticalWidgetAdvSmallCardController", "I", "verticalBigCardController", "Landroid/view/GestureDetector;", "J", "Landroid/view/GestureDetector;", "mGestureDetector", "Landroid/content/Context;", "context", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;)V", "K", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class aw extends com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b {

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> mVerticalBottomAvatarController;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> mVerticalBottomContentController;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> verticalWidgetAdvSmallCardController;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> verticalBigCardController;

    /* renamed from: J, reason: from kotlin metadata */
    private GestureDetector mGestureDetector;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/holder/aw$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDoubleTap", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            return super.onDoubleTap(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalVideoOnlyAvatarBottomItemView", "itemView onSingleTapConfirmed");
            aw.this.z();
            return super.onSingleTapConfirmed(e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/holder/aw$c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/ai$c;", "", "b", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements ai.c {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai.c
        public void a() {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalVideoOnlyAvatarBottomItemView", "onBigCardHide");
            aw.this.A(true);
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai.c
        public void b() {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalVideoOnlyAvatarBottomItemView", "onBigCardShow");
            aw.this.A(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(Context context, au holder) {
        super(context, holder);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    private final void t() {
        if (this.D == null) {
            return;
        }
        this.mGestureDetector = new GestureDetector(this.D.getContext(), new b());
        this.D.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.av
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u16;
                u16 = aw.u(aw.this, view, motionEvent);
                return u16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(aw this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetector gestureDetector = this$0.mGestureDetector;
        if (gestureDetector == null) {
            return true;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void v() {
        int i3 = this.f82126m.i();
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.seb);
        ai aiVar = new ai(this.C, this.f82126m, i3);
        aiVar.r(viewStub);
        aiVar.J(new c());
        this.verticalBigCardController = aiVar;
        b(aiVar);
    }

    private final void w() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1181173_);
        Context mContext = this.C;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        au mHolder = this.f82126m;
        Intrinsics.checkNotNullExpressionValue(mHolder, "mHolder");
        aj ajVar = new aj(mContext, mHolder);
        ajVar.r(viewStub);
        this.verticalWidgetAdvSmallCardController = ajVar;
        b(ajVar);
    }

    private final void x() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11807736);
        n nVar = new n(this.C, this.f82126m);
        nVar.r(viewStub);
        this.mVerticalBottomContentController = nVar;
        b(nVar);
    }

    private final void y() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11808737);
        k kVar = new k(this.C, this.f82126m);
        kVar.r(viewStub);
        this.mVerticalBottomAvatarController = kVar;
        b(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (i() instanceof ah) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> i3 = i();
            Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemVideoAreaController");
            ((ah) i3).F();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        y();
        x();
        w();
        v();
        t();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int type) {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.mVerticalBottomAvatarController;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemBottomAvatarController");
        ((k) bVar).D(null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: q */
    public void setData(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        super.setData(itemData);
    }

    public final void A(boolean visible) {
        int i3 = visible ? 0 : 8;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.verticalWidgetAdvSmallCardController;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.l(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }
}
