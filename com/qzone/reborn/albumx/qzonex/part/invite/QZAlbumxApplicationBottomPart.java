package com.qzone.reborn.albumx.qzonex.part.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JoinApprovalStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bf;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxApplicationBottomPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "R9", "initData", "", ViewStickEventHelper.IS_SHOW, "J9", "M9", "", "loginUserStatus", "N9", "S9", "I9", "L9", "K9", "O9", "", "getLogTag", "onInitView", "v", NodeProps.ON_CLICK, "Lnc/bf;", "d", "Lnc/bf;", "inviteViewModel", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "bottomContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "applyTips", "Lcom/tencent/biz/qui/quibutton/QUIButton;", tl.h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "rejectBtn", "i", "agreeBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", ParseCommon.CONTAINER, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxApplicationBottomPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bf inviteViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout bottomContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView applyTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton rejectBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIButton agreeBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View container;

    private final void I9() {
        bf bfVar = this.inviteViewModel;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        bfVar.x2(true);
    }

    private final void J9() {
        fo.b bVar = new fo.b();
        fo.c.o(this.rejectBtn, "em_qz_refuse", bVar);
        fo.c.o(this.agreeBtn, "em_qz_agree", bVar);
    }

    private final void K9() {
        LinearLayout linearLayout = this.bottomContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.applyTips;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.applyTips;
        if (textView2 == null) {
            return;
        }
        textView2.setText(getContext().getText(R.string.f134328i));
    }

    private final void L9() {
        LinearLayout linearLayout = this.bottomContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.applyTips;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        ab.a value = bfVar.c2().getValue();
        if (value == null) {
            return;
        }
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        if (bfVar3.g2().getPageType() == 0) {
            bf bfVar4 = this.inviteViewModel;
            if (bfVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar4;
            }
            if (bfVar2.n2()) {
                if (value.getApprovalStatus() == JoinApprovalStatus.KAPPROVALSTATUSPASSED.ordinal()) {
                    K9();
                } else if (value.getApprovalStatus() == JoinApprovalStatus.KAPPROVALSTATUSREJECTED.ordinal()) {
                    O9();
                } else {
                    L9();
                }
            }
        }
    }

    private final void O9() {
        LinearLayout linearLayout = this.bottomContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.applyTips;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.applyTips;
        if (textView2 == null) {
            return;
        }
        textView2.setText(getContext().getText(R.string.f134368m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9() {
        bf bfVar = this.inviteViewModel;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        bfVar.x2(false);
    }

    private final void initData() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        MutableLiveData<ab.a> c26 = bfVar.c2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<ab.a, Unit> function1 = new Function1<ab.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxApplicationBottomPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ab.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ab.a aVar) {
                boolean isShow;
                boolean isShow2;
                View view;
                View view2;
                isShow = QZAlbumxApplicationBottomPart.this.isShow();
                QLog.i("QZAlbumxApplicationBottomPart", 1, "getInfoRsp  isShow()=" + isShow);
                isShow2 = QZAlbumxApplicationBottomPart.this.isShow();
                if (isShow2) {
                    view2 = QZAlbumxApplicationBottomPart.this.container;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    QZAlbumxApplicationBottomPart.this.M9();
                    return;
                }
                view = QZAlbumxApplicationBottomPart.this.container;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
            }
        };
        c26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxApplicationBottomPart.P9(Function1.this, obj);
            }
        });
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar3;
        }
        MutableLiveData<Integer> h26 = bfVar2.h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxApplicationBottomPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                QZAlbumxApplicationBottomPart qZAlbumxApplicationBottomPart = QZAlbumxApplicationBottomPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumxApplicationBottomPart.N9(it.intValue());
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxApplicationBottomPart.Q9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bf.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxInviteViewModel::class.java)");
        this.inviteViewModel = (bf) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isShow() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 0) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar3;
            }
            if (bfVar2.n2()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxApplicationBottomPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.neb) {
            S9();
        } else if (valueOf != null && valueOf.intValue() == R.id.f18713q) {
            I9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        R9(rootView);
        initData();
        J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(int loginUserStatus) {
        if (loginUserStatus == 4) {
            K9();
        } else if (loginUserStatus != 5) {
            L9();
        } else {
            O9();
        }
    }

    private final void R9(View rootView) {
        this.container = rootView != null ? rootView.findViewById(R.id.f188443) : null;
        this.bottomContainer = rootView != null ? (LinearLayout) rootView.findViewById(R.id.f192557) : null;
        this.applyTips = rootView != null ? (TextView) rootView.findViewById(R.id.f188544) : null;
        this.rejectBtn = rootView != null ? (QUIButton) rootView.findViewById(R.id.neb) : null;
        this.agreeBtn = rootView != null ? (QUIButton) rootView.findViewById(R.id.f18713q) : null;
        QUIButton qUIButton = this.rejectBtn;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(this);
        }
        QUIButton qUIButton2 = this.agreeBtn;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(this);
        }
    }
}
