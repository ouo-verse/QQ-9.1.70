package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.albumx.qzone.event.QZoneAlbumxMediaListTitleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListTitlePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "O9", "initViewModel", "L9", "Q9", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "v", NodeProps.ON_CLICK, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "mOperateRl", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mBackIconIv", "f", "mOperateRightLl", tl.h.F, "mCancelOperateRl", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mCancelOperateLeftTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCancelOperateRightTv", BdhLogUtil.LogTag.Tag_Conn, "mDisplayTitleName", "", "D", "Z", "mIsAllSelectMode", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", "E", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", "mInitBean", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "mSelectViewModel", "G", "Ljava/lang/String;", "mSelectAllRightTxt", "H", "mCancelSelectAllRightTxt", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListTitlePart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mDisplayTitleName;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsAllSelectMode;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneAlbumxMediaListInitBean mInitBean;

    /* renamed from: F, reason: from kotlin metadata */
    private MediaSelectedViewModel mSelectViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private String mSelectAllRightTxt;

    /* renamed from: H, reason: from kotlin metadata */
    private String mCancelSelectAllRightTxt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mOperateRl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mBackIconIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mOperateRightLl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mCancelOperateRl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mCancelOperateLeftTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mCancelOperateRightTv;

    public QZoneAlbumxMediaListTitlePart() {
        String a16 = com.qzone.util.l.a(R.string.jii);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_select_all)");
        this.mSelectAllRightTxt = a16;
        String a17 = com.qzone.util.l.a(R.string.f134428s);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_albumx_cancel_select_all)");
        this.mCancelSelectAllRightTxt = a17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        QLog.d(getTAG(), 1, "[enableSelectMode]");
        SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumxMediaListTitleEvent(1));
    }

    private final void M9() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O9() {
        LiveData<UIStateData<List<LocalMediaInfo>>> f26 = ((qa.d) getViewModel(qa.d.class)).f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<? extends LocalMediaInfo>>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListTitlePart$mockSelectAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends LocalMediaInfo>> uIStateData) {
                invoke2((UIStateData<List<LocalMediaInfo>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> uIStateData) {
                QLog.d(QZoneAlbumxMediaListTitlePart.this.getTAG(), 1, "mock select all mode");
                QZoneAlbumxMediaListTitlePart.this.L9();
                QZoneAlbumxMediaListTitlePart.this.Q9();
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListTitlePart.P9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        QLog.d(getTAG(), 1, "[triggerSelectAll]");
        TextView textView = null;
        if (this.mIsAllSelectMode) {
            TextView textView2 = this.mCancelOperateRightTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRightTv");
            } else {
                textView = textView2;
            }
            textView.setText(this.mSelectAllRightTxt);
            SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumxMediaListTitleEvent(4));
        } else {
            TextView textView3 = this.mCancelOperateRightTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRightTv");
            } else {
                textView = textView3;
            }
            textView.setText(this.mCancelSelectAllRightTxt);
            SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumxMediaListTitleEvent(3));
        }
        this.mIsAllSelectMode = !this.mIsAllSelectMode;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(MediaSelectedViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(MediaSelectedViewModel::class.java)");
        MediaSelectedViewModel mediaSelectedViewModel = (MediaSelectedViewModel) viewModel;
        this.mSelectViewModel = mediaSelectedViewModel;
        if (mediaSelectedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectViewModel");
            mediaSelectedViewModel = null;
        }
        LiveData<Boolean> W1 = mediaSelectedViewModel.W1();
        Fragment hostFragment = getHostFragment();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListTitlePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v20, types: [android.view.ViewGroup] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                TextView textView;
                String str;
                ViewGroup viewGroup3;
                ?? r65;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                TextView textView2 = null;
                if (it.booleanValue()) {
                    viewGroup3 = QZoneAlbumxMediaListTitlePart.this.mOperateRl;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOperateRl");
                        viewGroup3 = null;
                    }
                    viewGroup3.setVisibility(8);
                    r65 = QZoneAlbumxMediaListTitlePart.this.mCancelOperateRl;
                    if (r65 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRl");
                    } else {
                        textView2 = r65;
                    }
                    textView2.setVisibility(0);
                    return;
                }
                viewGroup = QZoneAlbumxMediaListTitlePart.this.mOperateRl;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOperateRl");
                    viewGroup = null;
                }
                viewGroup.setVisibility(0);
                viewGroup2 = QZoneAlbumxMediaListTitlePart.this.mCancelOperateRl;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRl");
                    viewGroup2 = null;
                }
                viewGroup2.setVisibility(8);
                textView = QZoneAlbumxMediaListTitlePart.this.mCancelOperateRightTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRightTv");
                } else {
                    textView2 = textView;
                }
                str = QZoneAlbumxMediaListTitlePart.this.mSelectAllRightTxt;
                textView2.setText(str);
                QZoneAlbumxMediaListTitlePart.this.mIsAllSelectMode = false;
            }
        };
        W1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxMediaListTitlePart.N9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxMediaListTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            int id5 = v3.getId();
            if (id5 != R.id.mq5) {
                switch (id5) {
                    case R.id.mpz /* 1745224566 */:
                        M9();
                        break;
                    case R.id.f162802mq0 /* 1745224567 */:
                        M9();
                        break;
                    case R.id.f162803mq1 /* 1745224568 */:
                        Q9();
                        break;
                }
            } else {
                L9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mq7);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.mOperateRl = viewGroup;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperateRl");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        View findViewById2 = rootView.findViewById(R.id.mpz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026lbumx_title_back_icon_iv)");
        ImageView imageView = (ImageView) findViewById2;
        this.mBackIconIv = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackIconIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View findViewById3 = rootView.findViewById(R.id.mq5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026x_title_operate_right_ll)");
        ViewGroup viewGroup3 = (ViewGroup) findViewById3;
        this.mOperateRightLl = viewGroup3;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperateRightLl");
            viewGroup3 = null;
        }
        viewGroup3.setOnClickListener(this);
        View findViewById4 = rootView.findViewById(R.id.f162804mq2);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup4 = (ViewGroup) findViewById4;
        this.mCancelOperateRl = viewGroup4;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRl");
            viewGroup4 = null;
        }
        viewGroup4.setVisibility(8);
        View findViewById5 = rootView.findViewById(R.id.f162802mq0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026cel_operate_left_text_tv)");
        TextView textView = (TextView) findViewById5;
        this.mCancelOperateLeftTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateLeftTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById6 = rootView.findViewById(R.id.f162803mq1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026el_operate_right_text_tv)");
        TextView textView2 = (TextView) findViewById6;
        this.mCancelOperateRightTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelOperateRightTv");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById7 = rootView.findViewById(R.id.f162805mq3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026tle_display_name_text_tv)");
        TextView textView3 = (TextView) findViewById7;
        this.mDisplayTitleName = textView3;
        QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = this.mInitBean;
        if (qZoneAlbumxMediaListInitBean != null) {
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDisplayTitleName");
                textView3 = null;
            }
            textView3.setText(qZoneAlbumxMediaListInitBean.getMediaDisplayName());
        }
        initViewModel();
        ViewGroup viewGroup5 = this.mOperateRightLl;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperateRightLl");
        } else {
            viewGroup2 = viewGroup5;
        }
        fo.c.n(viewGroup2, WinkDaTongReportConstant.ElementId.EM_QZ_SELECT_PICTURE);
        O9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        this.mInitBean = serializableExtra instanceof QZoneAlbumxMediaListInitBean ? (QZoneAlbumxMediaListInitBean) serializableExtra : null;
    }
}
