package com.qzone.reborn.albumx.common.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rk.QZoneLayerPicOriginState;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0002BCB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0013\u001a\u00020\bH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\u001c\u0010\u001f\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 R$\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/g;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Landroid/view/View$OnClickListener;", "", "isVisible", "", "picId", "", "S9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N9", "G9", "P9", "", "originSize", "J9", "L9", "K9", "onInitView", "M9", "v", NodeProps.ON_CLICK, "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "O9", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "R9", tl.h.F, "Landroid/view/View;", "I9", "()Landroid/view/View;", "setMOriginPicTvRootView", "(Landroid/view/View;)V", "mOriginPicTvRootView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mShowOriginPicTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H9", "Q9", "mOriginPicShowTagView", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/Observer;", "mObserver", "Landroidx/collection/LruCache;", "D", "Landroidx/collection/LruCache;", "mOriginalPicMap", "Luk/g;", "E", "Luk/g;", "mOriginStateViewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class g<T> extends i<T> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final Observer<RFWLayerPicLoadState> mObserver = new b();

    /* renamed from: D, reason: from kotlin metadata */
    private final LruCache<String, Boolean> mOriginalPicMap = new LruCache<>(50);

    /* renamed from: E, reason: from kotlin metadata */
    private uk.g mOriginStateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mOriginPicTvRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mShowOriginPicTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mOriginPicShowTagView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/g$b;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "layerPicLoadState", "", "a", "<init>", "(Lcom/qzone/reborn/albumx/common/layer/part/g;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private final class b implements Observer<RFWLayerPicLoadState> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(RFWLayerPicLoadState layerPicLoadState) {
            RFWLayerPicInfo.RFWPicInfo originPicInfo;
            Intrinsics.checkNotNullParameter(layerPicLoadState, "layerPicLoadState");
            g<T> gVar = g.this;
            if (gVar.mCurrentSelectedItem == null || gVar.getMOriginPicTvRootView() == null || g.this.getMOriginPicShowTagView() == null) {
                return;
            }
            String picId = layerPicLoadState.getPicId();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = g.this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
            String str = null;
            if (Intrinsics.areEqual(picId, layerPicInfo != null ? layerPicInfo.getPicId() : null)) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = g.this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
                RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo2.getLayerPicInfo();
                if ((layerPicInfo2 != null ? layerPicInfo2.getOriginPicInfo() : null) != null) {
                    String url = layerPicLoadState.getSelectedPicInfo().getUrl();
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = g.this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                    RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo3.getLayerPicInfo();
                    if (layerPicInfo3 != null && (originPicInfo = layerPicInfo3.getOriginPicInfo()) != null) {
                        str = originPicInfo.getUrl();
                    }
                    if (Intrinsics.areEqual(url, str)) {
                        if (!layerPicLoadState.getPicLoadState().isFinishSuccess() && !((g) g.this).mOriginalPicMap.snapshot().containsKey(layerPicLoadState.getPicId())) {
                            if (!layerPicLoadState.getPicLoadState().isRunning()) {
                                g.this.S9(false, layerPicLoadState.getPicId());
                                return;
                            }
                            View mOriginPicShowTagView = g.this.getMOriginPicShowTagView();
                            Intrinsics.checkNotNull(mOriginPicShowTagView);
                            if (mOriginPicShowTagView.getVisibility() != 0) {
                                TextView textView = ((g) g.this).mShowOriginPicTv;
                                if (textView != null) {
                                    textView.setText("\u6b63\u5728\u52a0\u8f7d...");
                                }
                                TextView textView2 = ((g) g.this).mShowOriginPicTv;
                                if (textView2 != null) {
                                    textView2.setVisibility(0);
                                }
                                g.this.S9(false, layerPicLoadState.getPicId());
                                return;
                            }
                            return;
                        }
                        pk.b A9 = g.this.A9();
                        if (A9 != null) {
                            A9.v2();
                        }
                        ((g) g.this).mOriginalPicMap.put(layerPicLoadState.getPicId(), Boolean.TRUE);
                        g.this.S9(true, layerPicLoadState.getPicId());
                        TextView textView3 = ((g) g.this).mShowOriginPicTv;
                        if (textView3 == null) {
                            return;
                        }
                        textView3.setVisibility(8);
                        return;
                    }
                }
                g.this.S9(false, layerPicLoadState.getPicId());
                g<T> gVar2 = g.this;
                gVar2.R9(gVar2.mCurrentSelectedItem);
            }
        }
    }

    private final void G9() {
        fo.c.n(this.mShowOriginPicTv, "em_qz_view_original");
        fo.c.n(this.mOriginPicShowTagView, "em_qz_artwork_identification");
    }

    private final void N9(View rootView) {
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1276115, (ViewGroup) null);
        this.mOriginPicTvRootView = inflate;
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.n8s) : null;
        this.mShowOriginPicTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ef.d.b(122);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.mOriginPicTvRootView, layoutParams);
        View view = this.mOriginPicTvRootView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void P9() {
        if (this.mOriginPicTvRootView == null) {
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            if (rFWLayerItemMediaInfo.getLayerPicInfo() != null) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo2.getLayerPicInfo();
                Intrinsics.checkNotNull(layerPicInfo);
                if (layerPicInfo.getOriginPicInfo() != null) {
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                    RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo3.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo2);
                    RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2.getOriginPicInfo();
                    Intrinsics.checkNotNull(originPicInfo);
                    if (!TextUtils.isEmpty(originPicInfo.getUrl())) {
                        K9();
                        RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
                        Intrinsics.checkNotNull(rFWLayerItemMediaInfo4);
                        RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo4.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo3);
                        RFWLayerItemMediaInfo rFWLayerItemMediaInfo5 = this.mCurrentSelectedItem;
                        Intrinsics.checkNotNull(rFWLayerItemMediaInfo5);
                        RFWLayerPicInfo layerPicInfo4 = rFWLayerItemMediaInfo5.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo4);
                        RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo4.getOriginPicInfo();
                        Intrinsics.checkNotNull(originPicInfo2);
                        layerPicInfo3.setCurrentPicInfo(originPicInfo2);
                        if (getMLayerViewModel().mRichMediaInfo.getValue() != null) {
                            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
                            Intrinsics.checkNotNull(value);
                            value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
                            return;
                        }
                        return;
                    }
                }
            }
        }
        View view = this.mOriginPicTvRootView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(boolean isVisible, String picId) {
        View view = this.mOriginPicShowTagView;
        if (view != null) {
            view.setVisibility(isVisible ? 0 : 8);
        }
        QZoneLayerPicOriginState qZoneLayerPicOriginState = new QZoneLayerPicOriginState(picId, isVisible);
        uk.g gVar = this.mOriginStateViewModel;
        if (gVar == null) {
            return;
        }
        gVar.N1(qZoneLayerPicOriginState);
    }

    /* renamed from: H9, reason: from getter */
    protected final View getMOriginPicShowTagView() {
        return this.mOriginPicShowTagView;
    }

    /* renamed from: I9, reason: from getter */
    public final View getMOriginPicTvRootView() {
        return this.mOriginPicTvRootView;
    }

    protected void K9() {
        pk.b A9 = A9();
        if (A9 != null) {
            A9.N2();
        }
    }

    protected void L9() {
        pk.b A9 = A9();
        if (A9 != null) {
            A9.j9();
        }
    }

    protected void M9(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mOriginPicShowTagView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1276014, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = ef.d.b(81);
        layoutParams.rightMargin = ef.d.b(16);
        ((ViewGroup) rootView).addView(this.mOriginPicShowTagView, layoutParams);
        View view = this.mOriginPicShowTagView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    protected boolean O9() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q9(View view) {
        this.mOriginPicShowTagView = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        View view;
        super.handleBroadcastMessage(action, args);
        if (!TextUtils.equals(action, "HIDE_ORIGINAL_PIC_BUTTON") || (view = this.mOriginPicTvRootView) == null || view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.mCurrentSelectedItem != null && v3.getId() == R.id.n8s) {
            P9();
            RFWLog.d(getLogTag(), RFWLog.USR, "origin_btn click");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mOriginStateViewModel = (uk.g) getViewModel(uk.g.class);
        N9(rootView);
        M9(rootView);
        G9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (O9()) {
            View view = this.mOriginPicTvRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mOriginPicShowTagView;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        boolean z16 = false;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.isVideo()) {
            z16 = true;
        }
        if (z16) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, "", this.mObserver);
            View view3 = this.mOriginPicTvRootView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.mOriginPicShowTagView;
            if (view4 == null) {
                return;
            }
            view4.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null) {
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
            if (rFWLayerItemMediaInfo2.getLayerPicInfo() != null) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo3.getLayerPicInfo();
                Intrinsics.checkNotNull(layerPicInfo);
                if (!TextUtils.isEmpty(layerPicInfo.getPicId())) {
                    RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo4);
                    RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo4.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo2);
                    rFWLayerDataCenter.observerGlobalState(RFWLayerPicLoadState.class, layerPicInfo2.getPicId(), this.mObserver);
                    return;
                }
            }
        }
        RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, "", this.mObserver);
        View view5 = this.mOriginPicTvRootView;
        if (view5 == null) {
            return;
        }
        view5.setVisibility(8);
    }

    public final void R9(RFWLayerItemMediaInfo mediaInfo) {
        if ((mediaInfo != null ? mediaInfo.getLayerPicInfo() : null) != null) {
            RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
            Intrinsics.checkNotNull(layerPicInfo);
            if (layerPicInfo.getOriginPicInfo() != null) {
                RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
                Intrinsics.checkNotNull(layerPicInfo2);
                RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2.getOriginPicInfo();
                Intrinsics.checkNotNull(originPicInfo);
                if (!TextUtils.isEmpty(originPicInfo.getUrl())) {
                    View view = this.mOriginPicTvRootView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    L9();
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
                    RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo3);
                    RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo3.getOriginPicInfo();
                    Intrinsics.checkNotNull(originPicInfo2);
                    String J9 = J9(originPicInfo2.getSize());
                    RFWLog.i(getLogTag(), RFWLog.CLR, "photo info origin size " + J9);
                    TextView textView = this.mShowOriginPicTv;
                    if (textView != null) {
                        textView.setText(HardCodeUtil.qqStr(R.string.rhm));
                    }
                    TextView textView2 = this.mShowOriginPicTv;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setVisibility(0);
                    return;
                }
            }
        }
        View view2 = this.mOriginPicTvRootView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView3 = this.mShowOriginPicTv;
        if (textView3 == null) {
            return;
        }
        textView3.setVisibility(8);
    }

    private final String J9(long originSize) {
        long j3 = originSize / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j3 <= 1024) {
            return j3 + "K";
        }
        float f16 = ((float) j3) / 1024.0f;
        if (f16 > 1024.0f) {
            return decimalFormat.format(f16 / 1024.0f) + "G";
        }
        return decimalFormat.format(f16) + "M";
    }
}
