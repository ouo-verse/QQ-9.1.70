package la;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.base.view.QZoneAlbumxRoundCornerImageView;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.handpick.RFWPhotoHandpickManager;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001=B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u0014J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\bH\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0014J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010 R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010 R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00106R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010:\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00109\u00a8\u0006>"}, d2 = {"Lla/e;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "Landroid/view/View$OnClickListener;", "data", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfoList", "H", "Landroid/widget/ImageView;", "imgView", "", "path", "G", "Landroid/view/View;", "v", "B", "", "getViewStubLayoutId", "containerView", "onInitView", "", "position", "", "payload", UserInfo.SEX_FEMALE, "getLogTag", NodeProps.ON_CLICK, "e", "Landroid/view/View;", "mMultiPhotoContainer", "Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxRoundCornerImageView;", "f", "Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxRoundCornerImageView;", "mCoverFirstIv", tl.h.F, "mCoverSecondIv", "i", "mCoverThirdIv", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mNameTv", BdhLogUtil.LogTag.Tag_Conn, "mTimeTv", "D", "mNumTv", "E", "mUpdateFlagView", "mMaskView", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "mFailedDrawable", "I", "mContainerHeight", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends com.qzone.reborn.base.l<RFWUploadRecommendInfo> implements View.OnClickListener {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SimpleDateFormat K = new SimpleDateFormat("yyyy-MM");

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTimeTv;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mNumTv;

    /* renamed from: E, reason: from kotlin metadata */
    private View mUpdateFlagView;

    /* renamed from: F, reason: from kotlin metadata */
    private View mMaskView;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable mLoadingDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable mFailedDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private int mContainerHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mMultiPhotoContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxRoundCornerImageView mCoverFirstIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxRoundCornerImageView mCoverSecondIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxRoundCornerImageView mCoverThirdIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mNameTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lla/e$a;", "", "Ljava/text/SimpleDateFormat;", "SDATE_FORMAT", "Ljava/text/SimpleDateFormat;", "a", "()Ljava/text/SimpleDateFormat;", "", "COUNT_LIMIT_3", "I", "", "LEFT_IMG_WIDTH", "D", "MASK_HEIGHT_RATIO", "RIGHT_IMG_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: la.e$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleDateFormat a() {
            return e.K;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"la/e$b", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "queryResult", "", "queryFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements RFWUploadRecommendDirectorV2.QueryCallBack {
        b() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2.QueryCallBack
        public void queryFinish(List<RFWMediaInfo> queryResult) {
            Intrinsics.checkNotNullParameter(queryResult, "queryResult");
            QLog.d(e.this.getTAG(), 1, "[queryMediaListAsync] --> queryFinish");
            e.this.H(queryResult);
        }
    }

    private final void B(final View v3) {
        QLog.d(getTAG(), 1, "[handleMultiPhotoClick]");
        RFWIocAbilityProvider.g().getIoc(ia.a.class).originView(v3).done(new OnPromiseResolved() { // from class: la.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                e.C(v3, this, (ia.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                e.D(e.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(View v3, e this$0, ia.a aVar) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar.N3(v3, this$0.mPosition, (RFWUploadRecommendInfo) this$0.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(e this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleMultiPhotoClick] getIoc error = " + str);
    }

    private final void G(ImageView imgView, String path) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(path);
        e16.setNeedShowLoadingDrawable(false);
        e16.setTargetView(imgView);
        e16.setRequestWidth(imgView.getWidth());
        e16.setRequestHeight(imgView.getHeight());
        e16.setFailedDrawable(this.mFailedDrawable);
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(List<RFWMediaInfo> mediaInfoList) {
        int coerceAtMost;
        ArrayList arrayList = new ArrayList();
        for (Object obj : mediaInfoList) {
            if (true ^ RFWPhotoHandpickManager.INSTANCE.isCoverMedia((RFWMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(arrayList.size(), 3);
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView = null;
            if (i3 == 0) {
                QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView2 = this.mCoverFirstIv;
                if (qZoneAlbumxRoundCornerImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverFirstIv");
                } else {
                    qZoneAlbumxRoundCornerImageView = qZoneAlbumxRoundCornerImageView2;
                }
                G(qZoneAlbumxRoundCornerImageView, ((RFWMediaInfo) arrayList.get(i3)).getMPath());
            } else if (i3 == 1) {
                QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView3 = this.mCoverSecondIv;
                if (qZoneAlbumxRoundCornerImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverSecondIv");
                } else {
                    qZoneAlbumxRoundCornerImageView = qZoneAlbumxRoundCornerImageView3;
                }
                G(qZoneAlbumxRoundCornerImageView, ((RFWMediaInfo) arrayList.get(i3)).getMPath());
            } else if (i3 == 2) {
                QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView4 = this.mCoverThirdIv;
                if (qZoneAlbumxRoundCornerImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverThirdIv");
                } else {
                    qZoneAlbumxRoundCornerImageView = qZoneAlbumxRoundCornerImageView4;
                }
                G(qZoneAlbumxRoundCornerImageView, ((RFWMediaInfo) arrayList.get(i3)).getMPath());
            }
        }
    }

    private final void J(final RFWUploadRecommendInfo data) {
        RFWIocAbilityProvider.g().getIoc(ia.d.class).originView(this.mRootView).done(new OnPromiseResolved() { // from class: la.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                e.K(RFWUploadRecommendInfo.this, this, (ia.d) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                e.L(e.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(RFWUploadRecommendInfo data, e this$0, ia.d dVar) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean a16 = dVar.a(data);
        View view = null;
        if (a16) {
            View view2 = this$0.mUpdateFlagView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpdateFlagView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this$0.mUpdateFlagView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpdateFlagView");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(e this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[updateUpdateFlag] getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(RFWUploadRecommendInfo data, int position, List<Object> payload) {
        RFWClassifyInfo classifyInfo;
        TextView textView = null;
        QLog.d(getTAG(), 1, "[onBindData] position = " + position + ", classifyId = " + ((data == null || (classifyInfo = data.getClassifyInfo()) == null) ? null : classifyInfo.getClassifyId()));
        if (data != null) {
            QZoneUploadRecommendDirector.INSTANCE.a().queryMediaListByClassifyInfo(data.getClassifyInfo(), new b());
            TextView textView2 = this.mNameTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView2 = null;
            }
            textView2.setText(data.getDisplayName());
            if (data.getLastTakePicTime() != 0) {
                TextView textView3 = this.mTimeTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                TextView textView4 = this.mTimeTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView4 = null;
                }
                textView4.setText(K.format(Long.valueOf(data.getLastTakePicTime())));
            } else {
                TextView textView5 = this.mTimeTv;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView5 = null;
                }
                textView5.setVisibility(8);
            }
            if (data.getRecommendCount() > 0) {
                TextView textView6 = this.mNumTv;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                    textView6 = null;
                }
                textView6.setVisibility(0);
                TextView textView7 = this.mNumTv;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                } else {
                    textView = textView7;
                }
                textView.setText(String.valueOf(data.getRecommendCount()));
            } else {
                TextView textView8 = this.mNumTv;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                } else {
                    textView = textView8;
                }
                textView.setVisibility(8);
            }
            J(data);
        }
        A(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendMultiPhotoContentSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.mos) {
            B(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mos);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026recommend_multi_photo_ll)");
        this.mMultiPhotoContainer = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
            findViewById = null;
        }
        findViewById.setOnClickListener(this);
        View view = this.mMultiPhotoContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
            view = null;
        }
        float dip2px = DisplayUtil.dip2px(view.getContext(), 8.0f);
        View findViewById2 = containerView.findViewById(R.id.mor);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026end_multi_photo_first_iv)");
        QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView = (QZoneAlbumxRoundCornerImageView) findViewById2;
        this.mCoverFirstIv = qZoneAlbumxRoundCornerImageView;
        if (qZoneAlbumxRoundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverFirstIv");
            qZoneAlbumxRoundCornerImageView = null;
        }
        qZoneAlbumxRoundCornerImageView.setRadius(dip2px, 0.0f, 0.0f, dip2px);
        View findViewById3 = containerView.findViewById(R.id.mot);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026nd_multi_photo_second_iv)");
        QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView2 = (QZoneAlbumxRoundCornerImageView) findViewById3;
        this.mCoverSecondIv = qZoneAlbumxRoundCornerImageView2;
        if (qZoneAlbumxRoundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSecondIv");
            qZoneAlbumxRoundCornerImageView2 = null;
        }
        qZoneAlbumxRoundCornerImageView2.setRadius(0.0f, dip2px, 0.0f, 0.0f);
        View findViewById4 = containerView.findViewById(R.id.mou);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026end_multi_photo_third_iv)");
        QZoneAlbumxRoundCornerImageView qZoneAlbumxRoundCornerImageView3 = (QZoneAlbumxRoundCornerImageView) findViewById4;
        this.mCoverThirdIv = qZoneAlbumxRoundCornerImageView3;
        if (qZoneAlbumxRoundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverThirdIv");
            qZoneAlbumxRoundCornerImageView3 = null;
        }
        qZoneAlbumxRoundCornerImageView3.setRadius(0.0f, 0.0f, dip2px, 0.0f);
        View findViewById5 = containerView.findViewById(R.id.mov);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_photo_recommend_name_tv)");
        this.mNameTv = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.moz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_photo_recommend_time_tv)");
        this.mTimeTv = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.mol);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026photo_recommend_count_tv)");
        this.mNumTv = (TextView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.f162797mp0);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026to_recommend_update_flag)");
        this.mUpdateFlagView = findViewById8;
        View findViewById9 = containerView.findViewById(R.id.moq);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026hoto_recommend_mask_view)");
        this.mMaskView = findViewById9;
        View view2 = this.mMultiPhotoContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            pl.a aVar = pl.a.f426446a;
            View view3 = this.mMultiPhotoContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
                view3 = null;
            }
            int o16 = aVar.o(view3.getContext());
            View view4 = this.mMultiPhotoContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
                view4 = null;
            }
            double dip2px2 = 2 * (o16 - DisplayUtil.dip2px(view4.getContext(), 36.0f)) * 0.26843657817109146d;
            View view5 = this.mMultiPhotoContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
                view5 = null;
            }
            int dip2px3 = (int) (dip2px2 + DisplayUtil.dip2px(view5.getContext(), 4.0f));
            this.mContainerHeight = dip2px3;
            layoutParams.height = dip2px3;
        }
        View view6 = this.mMaskView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
            view6 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = view6.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = (int) (this.mContainerHeight * 0.36d);
        }
        this.mLoadingDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at_, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqc};
    }

    private final void A(RFWUploadRecommendInfo data) {
        if (data != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cluster_card_ids", data.getClassifyInfo().getClassifyId());
            linkedHashMap.put(IPublicAccountConfigAttr.CARD_STYLE, 1);
            fo.b i3 = new fo.b().l(linkedHashMap).i(data.getClassifyInfo().toString());
            View view = this.mMultiPhotoContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiPhotoContainer");
                view = null;
            }
            fo.c.o(view, "em_qz_single_cluster_card", i3);
        }
    }
}
