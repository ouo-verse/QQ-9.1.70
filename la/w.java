package la;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.reborn.feedx.util.QZoneClickAreaUtils;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nH\u0014J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0014J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00104R\u0018\u00107\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104\u00a8\u0006<"}, d2 = {"Lla/w;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Landroid/view/View$OnClickListener;", "localMediaInfo", "", "P", "info", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "view", BdhLogUtil.LogTag.Tag_Conn, "G", "mData", "", "B", "K", "", "getViewStubLayoutId", "containerView", "onInitView", "data", "", "position", "", "", "payload", "N", "getLogTag", "v", NodeProps.ON_CLICK, "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mContentContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCoverIv", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "mCheckBoxRl", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "i", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mCheckBox", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mSectionSize", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "D", "mFailedDrawable", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class w extends com.qzone.reborn.base.l<LocalMediaInfo> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private Drawable mLoadingDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private Drawable mFailedDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContentContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCoverIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mCheckBoxRl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mCheckBox;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSectionSize;

    private final String B(LocalMediaInfo mData) {
        String debugInfo;
        qa.d dVar = (qa.d) t(qa.d.class);
        RFWMediaInfo h26 = dVar != null ? dVar.h2(mData.path) : null;
        return (h26 == null || (debugInfo = h26.getDebugInfo()) == null) ? "" : debugInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(final View view) {
        String tag = getTAG();
        QUICheckBox qUICheckBox = this.mCheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox = null;
        }
        QLog.d(tag, 1, "[handleCheckBoxClick] check isChecked = " + qUICheckBox.isChecked() + ", selectStatus = " + ((LocalMediaInfo) this.mData).selectStatus);
        RFWIocAbilityProvider.g().getIoc(ia.c.class).originView(view).done(new OnPromiseResolved() { // from class: la.s
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                w.D(view, this, (ia.c) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.t
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                w.F(w.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void D(View view, w this$0, ia.c cVar) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.mPosition;
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        cVar.Q4(view, i3, (LocalMediaInfo) mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(w this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleSinglePhotoClick] getIoc error = " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        String tag = getTAG();
        QUICheckBox qUICheckBox = this.mCheckBox;
        ImageView imageView = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox = null;
        }
        QLog.d(tag, 1, "[handlePicImageClick] check isChecked = " + qUICheckBox.isChecked() + ", selectStatus = " + ((LocalMediaInfo) this.mData).selectStatus);
        String tag2 = getTAG();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        QLog.d(tag2, 4, "[handlePicImageClick] pic debug info: \n" + B((LocalMediaInfo) mData));
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(ia.c.class);
        ImageView imageView2 = this.mCoverIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
        } else {
            imageView = imageView2;
        }
        ioc.originView(imageView).done(new OnPromiseResolved() { // from class: la.q
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                w.H(w.this, (ia.c) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.r
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                w.J(w.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H(w this$0, ia.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mCoverIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
            imageView = null;
        }
        int i3 = this$0.mPosition;
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        cVar.z2(imageView, i3, (LocalMediaInfo) mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(w this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handlePicImageClick] getIoc error = " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        String tag = getTAG();
        QUICheckBox qUICheckBox = this.mCheckBox;
        ImageView imageView = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox = null;
        }
        QLog.d(tag, 1, "[handlePicImageLongClick] check isChecked = " + qUICheckBox.isChecked() + ", selectStatus = " + ((LocalMediaInfo) this.mData).selectStatus);
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(ia.c.class);
        ImageView imageView2 = this.mCoverIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
        } else {
            imageView = imageView2;
        }
        ioc.originView(imageView).done(new OnPromiseResolved() { // from class: la.u
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                w.L(w.this, (ia.c) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.v
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                w.M(w.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void L(w this$0, ia.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mCoverIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
            imageView = null;
        }
        int i3 = this$0.mPosition;
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        cVar.d5(imageView, i3, (LocalMediaInfo) mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(w this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handlePicImageLongClick] getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(w this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
        return true;
    }

    private final void P(LocalMediaInfo localMediaInfo) {
        FrameLayout frameLayout = this.mContentContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout = null;
        }
        TextView textView = (TextView) frameLayout.findViewById(R.id.mpu);
        textView.setText(B(localMediaInfo));
        textView.setVisibility(0);
    }

    private final void Q(LocalMediaInfo info) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(info.path);
        ImageView imageView = this.mCoverIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
            imageView = null;
        }
        e16.setTargetView(imageView);
        e16.setRequestWidth(this.mSectionSize);
        e16.setRequestHeight(this.mSectionSize);
        e16.setLoadingDrawable(this.mLoadingDrawable);
        e16.setFailedDrawable(this.mFailedDrawable);
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
        float f16 = (info.selectStatus == 1 || ea.a.e(info) != -5) ? 1.0f : 0.5f;
        ImageView imageView3 = this.mCoverIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setAlpha(f16);
    }

    private final void R(LocalMediaInfo info) {
        QUICheckBox qUICheckBox = null;
        if (info.selectStatus == 0) {
            QUICheckBox qUICheckBox2 = this.mCheckBox;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            } else {
                qUICheckBox = qUICheckBox2;
            }
            qUICheckBox.setVisibility(8);
            return;
        }
        QUICheckBox qUICheckBox3 = this.mCheckBox;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox3 = null;
        }
        qUICheckBox3.setVisibility(0);
        QUICheckBox qUICheckBox4 = this.mCheckBox;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
        } else {
            qUICheckBox = qUICheckBox4;
        }
        qUICheckBox.setChecked(info.selectStatus == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxMediaListItemContentSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mpj /* 1745224550 */:
                    C(v3);
                    break;
                case R.id.mpk /* 1745224551 */:
                    G();
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mpk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026dia_list_item_content_fl)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.mContentContainer = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        pl.a aVar = pl.a.f426446a;
        FrameLayout frameLayout2 = this.mContentContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout2 = null;
        }
        int o16 = aVar.o(frameLayout2.getContext());
        FrameLayout frameLayout3 = this.mContentContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout3 = null;
        }
        this.mSectionSize = (o16 - DisplayUtil.dip2px(frameLayout3.getContext(), 4.0f)) / 3;
        FrameLayout frameLayout4 = this.mContentContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout4 = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout4.getLayoutParams();
        if (layoutParams != null) {
            int i3 = this.mSectionSize;
            layoutParams.width = i3;
            layoutParams.height = i3;
        }
        FrameLayout frameLayout5 = this.mContentContainer;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentContainer");
            frameLayout5 = null;
        }
        frameLayout5.setOnLongClickListener(new View.OnLongClickListener() { // from class: la.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean O;
                O = w.O(w.this, view);
                return O;
            }
        });
        View findViewById2 = containerView.findViewById(R.id.mpl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026media_list_item_cover_iv)");
        this.mCoverIv = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mpj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026a_list_item_check_box_fl)");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.mCheckBoxRl = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxRl");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(this);
        View findViewById4 = containerView.findViewById(R.id.mpi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026edia_list_item_check_box)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById4;
        this.mCheckBox = qUICheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox = null;
        }
        qUICheckBox.setType(3);
        QUICheckBox qUICheckBox2 = this.mCheckBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox2 = null;
        }
        QUICheckBox qUICheckBox3 = this.mCheckBox;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            qUICheckBox3 = null;
        }
        QZoneClickAreaUtils.a(qUICheckBox2, DisplayUtil.dip2px(qUICheckBox3.getContext(), 4.0f));
        this.mLoadingDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at_, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqa};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(LocalMediaInfo data, int position, List<Object> payload) {
        if (data == null) {
            QLog.e(getTAG(), 1, "[onBindData] data is null, pos = " + position);
        }
        if (data != null) {
            QLog.d(getTAG(), 1, "[onBindData] pos=" + position + ", selectStatus=" + data.selectStatus + ", validStatus=" + ea.a.e(data));
            Q(data);
            R(data);
            if (gd.a.f401926a.c("KEY_SHOW_RECOMMEND_PHOTO_DEBUG_INFO", false)) {
                P(data);
            }
        }
    }
}
