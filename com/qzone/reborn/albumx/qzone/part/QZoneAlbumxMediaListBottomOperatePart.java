package com.qzone.reborn.albumx.qzone.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.base.media.view.MediaRecyclerView;
import com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBottomOperatePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "U9", "initViewModel", "Landroid/view/View;", "v", "Y9", "ba", "V9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", NodeProps.ON_CLICK, "", "getLogTag", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "mFastUploadLl", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mFastUploadTextTv", "f", "mDoubleOperateLl", tl.h.F, "mLeftOperateLl", "i", "mRightOperateLl", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mDoubleOperateMakeVideoIv", BdhLogUtil.LogTag.Tag_Conn, "mDoubleOperateMakeVideoTv", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;", "D", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;", "mMediaRecyclerView", "", "E", "I", "mDoubleOperateBottomMargin", UserInfo.SEX_FEMALE, "mFastOperateBottomMargin", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "G", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "mSelectViewModel", "Lqa/d;", "H", "Lqa/d;", "mMediaViewModel", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListBottomOperatePart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mDoubleOperateMakeVideoTv;

    /* renamed from: D, reason: from kotlin metadata */
    private MediaRecyclerView mMediaRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private int mDoubleOperateBottomMargin;

    /* renamed from: F, reason: from kotlin metadata */
    private int mFastOperateBottomMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private MediaSelectedViewModel mSelectViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private qa.d mMediaViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mFastUploadLl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mFastUploadTextTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mDoubleOperateLl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLeftOperateLl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mRightOperateLl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mDoubleOperateMakeVideoIv;

    private final void U9() {
        ViewGroup viewGroup = this.mFastUploadLl;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastUploadLl");
            viewGroup = null;
        }
        fo.c.n(viewGroup, WinkDaTongReportConstant.ElementId.EM_XSJ_QZONE_UPLOAD_ALBUM);
        ViewGroup viewGroup3 = this.mRightOperateLl;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightOperateLl");
            viewGroup3 = null;
        }
        fo.c.n(viewGroup3, WinkDaTongReportConstant.ElementId.EM_XSJ_QZONE_UPLOAD_ALBUM);
        ViewGroup viewGroup4 = this.mLeftOperateLl;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftOperateLl");
        } else {
            viewGroup2 = viewGroup4;
        }
        fo.c.n(viewGroup2, "em_qz_make_a_video");
    }

    private final void V9(final View v3) {
        MediaSelectedViewModel mediaSelectedViewModel = this.mSelectViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        List<LocalMediaInfo> selectedMedia = mediaSelectedViewModel.getSelectedMedia();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = selectedMedia.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = ((LocalMediaInfo) next).path;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 35) {
            ToastUtil.s(BaseApplication.getContext().getString(R.string.jfq, 35), 0);
        } else {
            RFWIocAbilityProvider.g().getIoc(ia.b.class).originView(v3).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzone.part.u
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    QZoneAlbumxMediaListBottomOperatePart.X9(v3, (ia.b) obj);
                }
            }).fail(new OnPromiseRejected() { // from class: com.qzone.reborn.albumx.qzone.part.v
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
                public final void onFail(String str2) {
                    QZoneAlbumxMediaListBottomOperatePart.W9(QZoneAlbumxMediaListBottomOperatePart.this, str2);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZoneAlbumxMediaListBottomOperatePart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleMakeVideoClick] getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(View v3, ia.b bVar) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        bVar.D0(v3);
    }

    private final void Y9(final View v3) {
        RFWIocAbilityProvider.g().getIoc(ia.b.class).originView(v3).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzone.part.s
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneAlbumxMediaListBottomOperatePart.Z9(v3, (ia.b) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.qzone.reborn.albumx.qzone.part.t
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                QZoneAlbumxMediaListBottomOperatePart.aa(QZoneAlbumxMediaListBottomOperatePart.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(View v3, ia.b bVar) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        bVar.b7(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QZoneAlbumxMediaListBottomOperatePart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleUploadAllPhotoClick] getIoc error = " + str);
    }

    private final void ba(final View v3) {
        RFWIocAbilityProvider.g().getIoc(ia.b.class).originView(v3).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzone.part.q
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneAlbumxMediaListBottomOperatePart.ca(v3, (ia.b) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.qzone.reborn.albumx.qzone.part.r
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                QZoneAlbumxMediaListBottomOperatePart.da(QZoneAlbumxMediaListBottomOperatePart.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(View v3, ia.b bVar) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        bVar.w7(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(QZoneAlbumxMediaListBottomOperatePart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleUploadSelectedPhotoClick] getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(MediaSelectedViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(MediaSelectedViewModel::class.java)");
        MediaSelectedViewModel mediaSelectedViewModel = (MediaSelectedViewModel) viewModel;
        this.mSelectViewModel = mediaSelectedViewModel;
        qa.d dVar = null;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        LiveData<Boolean> W1 = mediaSelectedViewModel.W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBottomOperatePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                MediaRecyclerView mediaRecyclerView;
                FrameLayout.LayoutParams layoutParams;
                int i3;
                ViewGroup viewGroup3;
                ViewGroup viewGroup4;
                MediaRecyclerView mediaRecyclerView2;
                int i16;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    viewGroup3 = QZoneAlbumxMediaListBottomOperatePart.this.mFastUploadLl;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFastUploadLl");
                        viewGroup3 = null;
                    }
                    viewGroup3.setVisibility(8);
                    viewGroup4 = QZoneAlbumxMediaListBottomOperatePart.this.mDoubleOperateLl;
                    if (viewGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateLl");
                        viewGroup4 = null;
                    }
                    viewGroup4.setVisibility(0);
                    mediaRecyclerView2 = QZoneAlbumxMediaListBottomOperatePart.this.mMediaRecyclerView;
                    if (mediaRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
                        mediaRecyclerView2 = null;
                    }
                    ViewGroup.LayoutParams layoutParams2 = mediaRecyclerView2.getLayoutParams();
                    layoutParams = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams != null) {
                        i16 = QZoneAlbumxMediaListBottomOperatePart.this.mDoubleOperateBottomMargin;
                        layoutParams.bottomMargin = i16;
                        return;
                    }
                    return;
                }
                viewGroup = QZoneAlbumxMediaListBottomOperatePart.this.mFastUploadLl;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFastUploadLl");
                    viewGroup = null;
                }
                viewGroup.setVisibility(0);
                viewGroup2 = QZoneAlbumxMediaListBottomOperatePart.this.mDoubleOperateLl;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateLl");
                    viewGroup2 = null;
                }
                viewGroup2.setVisibility(8);
                mediaRecyclerView = QZoneAlbumxMediaListBottomOperatePart.this.mMediaRecyclerView;
                if (mediaRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaRecyclerView");
                    mediaRecyclerView = null;
                }
                ViewGroup.LayoutParams layoutParams3 = mediaRecyclerView.getLayoutParams();
                layoutParams = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams != null) {
                    i3 = QZoneAlbumxMediaListBottomOperatePart.this.mFastOperateBottomMargin;
                    layoutParams.bottomMargin = i3;
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBottomOperatePart.ea(Function1.this, obj);
            }
        });
        MediaSelectedViewModel mediaSelectedViewModel2 = this.mSelectViewModel;
        if (mediaSelectedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel2 = null;
        }
        LiveData<List<LocalMediaInfo>> S1 = mediaSelectedViewModel2.S1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends LocalMediaInfo>, Unit> function12 = new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBottomOperatePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends LocalMediaInfo> list) {
                ArrayList arrayList;
                ImageView imageView;
                TextView textView;
                ImageView imageView2;
                TextView textView2;
                TextView textView3 = null;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (Object obj : list) {
                        String str = ((LocalMediaInfo) obj).path;
                        if (!(str == null || str.length() == 0)) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    QZoneAlbumxMediaListBottomOperatePart qZoneAlbumxMediaListBottomOperatePart = QZoneAlbumxMediaListBottomOperatePart.this;
                    if (arrayList.size() > 35) {
                        imageView2 = qZoneAlbumxMediaListBottomOperatePart.mDoubleOperateMakeVideoIv;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateMakeVideoIv");
                            imageView2 = null;
                        }
                        imageView2.setImageResource(R.drawable.f163362);
                        textView2 = qZoneAlbumxMediaListBottomOperatePart.mDoubleOperateMakeVideoTv;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateMakeVideoTv");
                        } else {
                            textView3 = textView2;
                        }
                        textView3.setTextColor(qZoneAlbumxMediaListBottomOperatePart.getContext().getColor(R.color.qui_common_icon_secondary));
                        return;
                    }
                    imageView = qZoneAlbumxMediaListBottomOperatePart.mDoubleOperateMakeVideoIv;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateMakeVideoIv");
                        imageView = null;
                    }
                    imageView.setImageResource(R.drawable.qui_play_circle);
                    textView = qZoneAlbumxMediaListBottomOperatePart.mDoubleOperateMakeVideoTv;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateMakeVideoTv");
                    } else {
                        textView3 = textView;
                    }
                    textView3.setTextColor(qZoneAlbumxMediaListBottomOperatePart.getContext().getColor(R.color.qui_common_text_primary));
                }
            }
        };
        S1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBottomOperatePart.ga(Function1.this, obj);
            }
        });
        ViewModel viewModel2 = getViewModel(qa.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneAlbumx\u2026istViewModel::class.java)");
        qa.d dVar2 = (qa.d) viewModel2;
        this.mMediaViewModel = dVar2;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaViewModel");
        } else {
            dVar = dVar2;
        }
        LiveData<List<LocalMediaInfo>> g26 = dVar.g2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends LocalMediaInfo>, Unit> function13 = new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBottomOperatePart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends LocalMediaInfo> list) {
                MediaSelectedViewModel mediaSelectedViewModel3;
                int coerceAtMost;
                TextView textView;
                TextView textView2;
                TextView textView3 = null;
                if (list.size() <= 1) {
                    textView2 = QZoneAlbumxMediaListBottomOperatePart.this.mFastUploadTextTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFastUploadTextTv");
                    } else {
                        textView3 = textView2;
                    }
                    textView3.setText(com.qzone.util.l.a(R.string.je9));
                    return;
                }
                String a16 = com.qzone.util.l.a(R.string.jk7);
                int size = list.size() - 1;
                mediaSelectedViewModel3 = QZoneAlbumxMediaListBottomOperatePart.this.mSelectViewModel;
                if (mediaSelectedViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
                    mediaSelectedViewModel3 = null;
                }
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(size, mediaSelectedViewModel3.getMaxSelectMediaSize());
                textView = QZoneAlbumxMediaListBottomOperatePart.this.mFastUploadTextTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFastUploadTextTv");
                } else {
                    textView3 = textView;
                }
                if (list.size() > 1) {
                    a16 = a16 + " (" + coerceAtMost + "\u5f20)";
                }
                textView3.setText(a16);
            }
        };
        g26.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListBottomOperatePart.ha(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxMediaListBottomOperatePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mo9 /* 1745224502 */:
                    Y9(v3);
                    break;
                case R.id.moa /* 1745224504 */:
                    V9(v3);
                    break;
                case R.id.mob /* 1745224505 */:
                    ba(v3);
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026mx_bottom_fast_upload_ll)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.mFastUploadLl = viewGroup;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastUploadLl");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        View findViewById2 = rootView.findViewById(R.id.mo_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ttom_fast_upload_text_tv)");
        this.mFastUploadTextTv = (TextView) findViewById2;
        ViewGroup viewGroup3 = this.mFastUploadLl;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastUploadLl");
            viewGroup3 = null;
        }
        viewGroup3.setOnClickListener(this);
        View findViewById3 = rootView.findViewById(R.id.mo6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026bottom_double_operate_ll)");
        ViewGroup viewGroup4 = (ViewGroup) findViewById3;
        this.mDoubleOperateLl = viewGroup4;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoubleOperateLl");
            viewGroup4 = null;
        }
        viewGroup4.setVisibility(8);
        View findViewById4 = rootView.findViewById(R.id.moa);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026x_bottom_operate_left_ll)");
        ViewGroup viewGroup5 = (ViewGroup) findViewById4;
        this.mLeftOperateLl = viewGroup5;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftOperateLl");
            viewGroup5 = null;
        }
        viewGroup5.setOnClickListener(this);
        View findViewById5 = rootView.findViewById(R.id.mob);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_bottom_operate_right_ll)");
        ViewGroup viewGroup6 = (ViewGroup) findViewById5;
        this.mRightOperateLl = viewGroup6;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightOperateLl");
        } else {
            viewGroup2 = viewGroup6;
        }
        viewGroup2.setOnClickListener(this);
        View findViewById6 = rootView.findViewById(R.id.mo7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026le_operate_make_video_iv)");
        this.mDoubleOperateMakeVideoIv = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.mo8);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026le_operate_make_video_tv)");
        this.mDoubleOperateMakeVideoTv = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.nf_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.rv_media_list)");
        this.mMediaRecyclerView = (MediaRecyclerView) findViewById8;
        this.mDoubleOperateBottomMargin = ar.d(90.0f);
        this.mFastOperateBottomMargin = ar.d(77.0f);
        initViewModel();
        U9();
    }
}
