package com.qzone.reborn.albumx.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.util.m;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import fo.b;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pl.a;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010E\u001a\u00020D\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\nR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "D0", "I0", "S0", "B0", "", "G0", "", "checked", "H0", "U0", "T0", "N0", "O0", "W0", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "E0", "Q0", "P0", "L0", "Landroid/widget/ImageView;", "F0", "getLayoutId", "objData", c.G, "C0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "isVisible", "setLabelAndPlayIconVisibility", "", "e", "Ljava/lang/String;", "TAG", "f", "I", "picSize", "", h.F, UserInfo.SEX_FEMALE, "LONG_PICTURE_RATIO", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "i", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "ivPicImage", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "flPicLabel", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tvLabelText", "E", "ivVideoPlayIcon", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cbOperateSelect", "G", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "operateViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonAlbumDetailPicWidgetView extends QZoneBaseWidgetView<CommonGridItemData> {

    /* renamed from: C, reason: from kotlin metadata */
    private final FrameLayout flPicLabel;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView tvLabelText;

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView ivVideoPlayIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private QUICheckBox cbOperateSelect;

    /* renamed from: G, reason: from kotlin metadata */
    private e operateViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int picSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float LONG_PICTURE_RATIO;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredFrameLayout roundLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivPicImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAlbumDetailPicWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MutableLiveData<Unit> c26;
        MutableLiveData<Boolean> d26;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QZoneIntimateAlbumDetailPicWidgetView";
        this.picSize = G0();
        this.LONG_PICTURE_RATIO = 2.5f;
        View findViewById = findViewById(R.id.n6k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_layout_round_view)");
        this.roundLayout = (RoundCorneredFrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f162747l91);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_image)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivPicImage = imageView;
        View findViewById3 = findViewById(R.id.jbf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fl_pic_label)");
        this.flPicLabel = (FrameLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f162958nj3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_label_text)");
        this.tvLabelText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.lvv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_video_play_icon)");
        this.ivVideoPlayIcon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f19666a);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.cb_operate_select)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById6;
        this.cbOperateSelect = qUICheckBox;
        qUICheckBox.setType(3);
        this.cbOperateSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ba.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                CommonAlbumDetailPicWidgetView.w0(CommonAlbumDetailPicWidgetView.this, compoundButton, z16);
            }
        });
        e E0 = E0();
        this.operateViewModel = E0;
        if (E0 != null && (d26 = E0.d2()) != null) {
            d26.observe(l0(), new Observer() { // from class: ba.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CommonAlbumDetailPicWidgetView.x0(CommonAlbumDetailPicWidgetView.this, (Boolean) obj);
                }
            });
        }
        e eVar = this.operateViewModel;
        if (eVar != null && (c26 = eVar.c2()) != null) {
            c26.observe(l0(), new Observer() { // from class: ba.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CommonAlbumDetailPicWidgetView.y0(CommonAlbumDetailPicWidgetView.this, (Unit) obj);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ba.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonAlbumDetailPicWidgetView.z0(CommonAlbumDetailPicWidgetView.this, view);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ba.k
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean A0;
                A0 = CommonAlbumDetailPicWidgetView.A0(CommonAlbumDetailPicWidgetView.this, view);
                return A0;
            }
        });
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0(CommonAlbumDetailPicWidgetView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Q0()) {
            this$0.L0();
            return true;
        }
        view.setHapticFeedbackEnabled(false);
        return true;
    }

    private final void B0() {
        ViewGroup.LayoutParams layoutParams = this.roundLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.picSize;
        }
        ViewGroup.LayoutParams layoutParams2 = this.roundLayout.getLayoutParams();
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.height = this.picSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D0() {
        MutableLiveData<Boolean> d26;
        QUICheckBox qUICheckBox = this.cbOperateSelect;
        b bVar = new b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 0;
        i3 = 0;
        linkedHashMap.put("check_type", 0);
        bVar.l(linkedHashMap);
        Unit unit = Unit.INSTANCE;
        fo.c.o(qUICheckBox, "em_qz_select_a_single_photo", bVar);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        e eVar = this.operateViewModel;
        if (eVar != null && (d26 = eVar.d2()) != null) {
            i3 = Intrinsics.areEqual(d26.getValue(), Boolean.TRUE);
        }
        linkedHashMap2.put("is_batch_operation", Integer.valueOf(i3));
        fo.c.q(this.ivPicImage, "em_qz_batch_operation_select_photo", linkedHashMap2);
    }

    private final int G0() {
        return (a.f426446a.o(getContext()) - (ImmersiveUtils.dpToPx(3.0f) * 2)) / 3;
    }

    private final void H0(boolean checked) {
        e eVar = this.operateViewModel;
        if (eVar != null) {
            if (checked) {
                eVar.O1(getData().getBatchBean().getTimeId(), getData().f());
            } else {
                eVar.i2(getData().f());
            }
        }
    }

    private final void I0() {
        MutableLiveData<Boolean> d26;
        e eVar = this.operateViewModel;
        if (((eVar == null || (d26 = eVar.d2()) == null) ? false : Intrinsics.areEqual(d26.getValue(), Boolean.TRUE)) && P0()) {
            this.cbOperateSelect.setChecked(!r0.isChecked());
        } else {
            RFWIocAbilityProvider.g().getIoc(l9.a.class).originView(this).done(new OnPromiseResolved() { // from class: ba.l
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    CommonAlbumDetailPicWidgetView.J0(CommonAlbumDetailPicWidgetView.this, (l9.a) obj);
                }
            }).fail(new OnPromiseRejected() { // from class: ba.m
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
                public final void onFail(String str) {
                    CommonAlbumDetailPicWidgetView.K0(CommonAlbumDetailPicWidgetView.this, str);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(CommonAlbumDetailPicWidgetView this$0, l9.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar.A8(this$0.getData().getBatchBean(), this$0.getData().getBatchPos(), this$0.getData().f(), this$0.dataPosInList, this$0.ivPicImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(CommonAlbumDetailPicWidgetView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.TAG, 1, "ICommonAlbumDetailClickIoc getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(CommonAlbumDetailPicWidgetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cbOperateSelect.setChecked(true);
    }

    private final boolean N0() {
        if (aa.e.f(getData().f())) {
            return false;
        }
        return getData().f().getImage().getIsGif();
    }

    private final boolean O0() {
        CommonStPicUrl c16;
        return (aa.e.f(getData().f()) || (c16 = aa.e.c(getData().f())) == null || ((float) c16.getHeight()) <= ((float) c16.getWidth()) * this.LONG_PICTURE_RATIO) ? false : true;
    }

    private final void S0() {
        e eVar;
        if (getData() != null && (eVar = this.operateViewModel) != null) {
            Intrinsics.checkNotNull(eVar);
            if (Intrinsics.areEqual(eVar.d2().getValue(), Boolean.TRUE)) {
                this.cbOperateSelect.setVisibility(0);
                QUICheckBox qUICheckBox = this.cbOperateSelect;
                e eVar2 = this.operateViewModel;
                Intrinsics.checkNotNull(eVar2);
                qUICheckBox.setChecked(eVar2.S1(getData().f()));
                return;
            }
        }
        this.cbOperateSelect.setVisibility(8);
    }

    private final void T0() {
        this.flPicLabel.setVisibility(0);
        if (aa.e.f(getData().f())) {
            this.tvLabelText.setText(nh.c.d((int) getData().f().getVideo().getVideoTime()));
            return;
        }
        if (O0()) {
            this.tvLabelText.setText(l.a(R.string.rhp));
        } else if (N0()) {
            this.tvLabelText.setText(l.a(R.string.rhn));
        } else {
            this.flPicLabel.setVisibility(8);
        }
    }

    private final void U0() {
        CommonStPicUrl c16 = aa.e.c(getData().f());
        if (c16 == null) {
            return;
        }
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(c16.getUrl());
        e16.setTargetView(this.ivPicImage);
        if (this.roundLayout.getLayoutParams() != null) {
            e16.setRequestWidth(this.roundLayout.getLayoutParams().width);
            e16.setRequestHeight(this.roundLayout.getLayoutParams().height);
        }
        if (g.f53821a.b().c0()) {
            e16.setGroupKey(new LibraGroupKey(getData().f().m()));
        }
        m mVar = m.f59551a;
        e16.setLoadingDrawable(mVar.b(getContext()));
        e16.setFailedDrawable(mVar.a(getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: ba.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                CommonAlbumDetailPicWidgetView.V0(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(LoadState loadState, Option option) {
        if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
            return;
        }
        option.getAnimatable().start();
    }

    private final void W0() {
        if (aa.e.f(getData().f())) {
            this.ivVideoPlayIcon.setVisibility(0);
        } else {
            this.ivVideoPlayIcon.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(CommonAlbumDetailPicWidgetView this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H0(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(CommonAlbumDetailPicWidgetView this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(CommonAlbumDetailPicWidgetView this$0, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(CommonAlbumDetailPicWidgetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0();
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract e E0();

    /* renamed from: F0, reason: from getter */
    public final ImageView getIvPicImage() {
        return this.ivPicImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L0() {
        e eVar;
        MutableLiveData<Boolean> d26;
        MutableLiveData<Boolean> d27;
        e eVar2 = this.operateViewModel;
        if (((eVar2 == null || (d27 = eVar2.d2()) == null) ? false : Intrinsics.areEqual(d27.getValue(), Boolean.FALSE)) && (eVar = this.operateViewModel) != null && (d26 = eVar.d2()) != null) {
            d26.postValue(Boolean.TRUE);
        }
        postDelayed(new Runnable() { // from class: ba.n
            @Override // java.lang.Runnable
            public final void run() {
                CommonAlbumDetailPicWidgetView.M0(CommonAlbumDetailPicWidgetView.this);
            }
        }, 200L);
    }

    public boolean P0() {
        return true;
    }

    public boolean Q0() {
        return true;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ciz;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.picSize = G0();
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonGridItemData objData, int pos) {
        if (objData != null) {
            B0();
            U0();
            W0();
            T0();
            S0();
        }
    }

    public final void setLabelAndPlayIconVisibility(boolean isVisible) {
        int i3 = isVisible ? 0 : 4;
        if (O0() || N0()) {
            this.flPicLabel.setVisibility(i3);
        }
        if (aa.e.f(getData().f())) {
            this.ivVideoPlayIcon.setVisibility(i3);
            this.flPicLabel.setVisibility(i3);
        }
    }
}
