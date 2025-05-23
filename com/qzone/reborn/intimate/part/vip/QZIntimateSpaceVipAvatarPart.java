package com.qzone.reborn.intimate.part.vip;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import ij.f;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.at;
import nk.i;
import nk.l;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00020\u00022\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/intimate/part/vip/QZIntimateSpaceVipAvatarPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Ljava/util/HashMap;", "", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "Lkotlin/collections/HashMap;", "vipInfoMap", "L9", "vipBean", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnk/l;", "d", "Lnk/l;", "vipViewModel", "Lnk/at;", "e", "Lnk/at;", "mainTabViewModel", "Lnk/i;", "f", "Lnk/i;", "styleViewModel", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "avatarContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "avatarDecoration", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceVipAvatarPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private l vipViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private at mainTabViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private i styleViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarDecoration;

    private final void J9(QZIntimateSpaceVipInfoBean vipBean) {
        at atVar = this.mainTabViewModel;
        ImageView imageView = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        if (TextUtils.isEmpty(atVar.getMSpaceId()) || TextUtils.isEmpty(vipBean.getMainPageAvatarUrl())) {
            return;
        }
        Option url = Option.obtain().setUrl(vipBean.getMainPageAvatarUrl());
        ImageView imageView2 = this.avatarDecoration;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarDecoration");
        } else {
            imageView = imageView2;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(url.setTargetView(imageView).setRequestWidth(ef.d.b(120)).setRegionHeight(ef.d.b(100)).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans), new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.part.vip.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZIntimateSpaceVipAvatarPart.K9(QZIntimateSpaceVipAvatarPart.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZIntimateSpaceVipAvatarPart this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = null;
        if (!loadState.isFinishSuccess()) {
            ImageView imageView2 = this$0.avatarDecoration;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarDecoration");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(4);
            return;
        }
        ImageView imageView3 = this$0.avatarDecoration;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarDecoration");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(HashMap<String, QZIntimateSpaceVipInfoBean> vipInfoMap) {
        if (vipInfoMap.isEmpty()) {
            return;
        }
        at atVar = this.mainTabViewModel;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        if (vipInfoMap.containsKey(atVar.getMSpaceId())) {
            at atVar3 = this.mainTabViewModel;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            } else {
                atVar2 = atVar3;
            }
            QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = vipInfoMap.get(atVar2.getMSpaceId());
            boolean z16 = false;
            if (qZIntimateSpaceVipInfoBean != null && qZIntimateSpaceVipInfoBean.k()) {
                z16 = true;
            }
            if (!z16 || TextUtils.isEmpty(qZIntimateSpaceVipInfoBean.getMainPageAvatarUrl())) {
                return;
            }
            J9(qZIntimateSpaceVipInfoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026yleViewModel::class.java)");
        this.styleViewModel = (i) viewModel;
        ViewModel viewModel2 = getViewModel(at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        this.mainTabViewModel = (at) viewModel2;
        ViewModel viewModel3 = getViewModel(l.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(QZIntimateM\u2026nfoViewModel::class.java)");
        l lVar = (l) viewModel3;
        this.vipViewModel = lVar;
        at atVar = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
            lVar = null;
        }
        MutableLiveData<HashMap<String, QZIntimateSpaceVipInfoBean>> P1 = lVar.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<HashMap<String, QZIntimateSpaceVipInfoBean>, Unit> function1 = new Function1<HashMap<String, QZIntimateSpaceVipInfoBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.vip.QZIntimateSpaceVipAvatarPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, QZIntimateSpaceVipInfoBean> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, QZIntimateSpaceVipInfoBean> hashMap) {
                if (hashMap == null) {
                    return;
                }
                QZIntimateSpaceVipAvatarPart.this.L9(hashMap);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.vip.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceVipAvatarPart.M9(Function1.this, obj);
            }
        });
        at atVar2 = this.mainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            atVar = atVar2;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function12 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.vip.QZIntimateSpaceVipAvatarPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                l lVar2;
                at atVar3;
                l lVar3;
                l lVar4;
                l lVar5;
                i iVar;
                int state = uIStateData.getState();
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                    QLog.e("QZIntimateManageVipAvatarPart", 1, "handleSpaceInfoRsp error, recode is " + uIStateData.getRetCode());
                    return;
                }
                if (uIStateData.getData() == null) {
                    return;
                }
                lVar2 = QZIntimateSpaceVipAvatarPart.this.vipViewModel;
                l lVar6 = null;
                if (lVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
                    lVar2 = null;
                }
                if (lVar2.getAvatarSetting() == null) {
                    lVar5 = QZIntimateSpaceVipAvatarPart.this.vipViewModel;
                    if (lVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
                        lVar5 = null;
                    }
                    iVar = QZIntimateSpaceVipAvatarPart.this.styleViewModel;
                    if (iVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                        iVar = null;
                    }
                    lVar5.a2(iVar.getStyleResourcesString());
                }
                f fVar = new f();
                atVar3 = QZIntimateSpaceVipAvatarPart.this.mainTabViewModel;
                if (atVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                    atVar3 = null;
                }
                fVar.d(atVar3.getMSpaceId());
                fVar.e(uIStateData.getData().getSpaceType());
                Iterator<T> it = uIStateData.getData().getStMembers().iterator();
                while (it.hasNext()) {
                    fVar.c().add((QZoneBaseMeta$StUser) it.next());
                }
                lVar3 = QZIntimateSpaceVipAvatarPart.this.vipViewModel;
                if (lVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
                    lVar3 = null;
                }
                lVar3.T1(fVar);
                if (mk.d.f416875a.y(Integer.valueOf(uIStateData.getData().getSpaceType()))) {
                    lVar4 = QZIntimateSpaceVipAvatarPart.this.vipViewModel;
                    if (lVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
                    } else {
                        lVar6 = lVar4;
                    }
                    lVar6.R1();
                }
            }
        };
        U1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.vip.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceVipAvatarPart.N9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        View findViewById = rootView.findViewById(R.id.n5n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026e_space_avatar_container)");
        this.avatarContainer = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f20478h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026double_avatar_decoration)");
        this.avatarDecoration = (ImageView) findViewById2;
    }
}
