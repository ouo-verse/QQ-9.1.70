package com.qzone.reborn.albumx.common.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/h;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "G9", "onInitView", "D9", "v", NodeProps.ON_CLICK, "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "", "F9", tl.h.F, "Landroid/view/View;", "mOriginVideoRootView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mShowOriginVideoTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMOriginVideoShowTagView", "()Landroid/view/View;", "H9", "(Landroid/view/View;)V", "mOriginVideoShowTagView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class h<T> extends i<T> implements View.OnClickListener {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mOriginVideoRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mShowOriginVideoTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mOriginVideoShowTagView;

    private final void E9(View rootView) {
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1276317, (ViewGroup) null);
        this.mOriginVideoRootView = inflate;
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.n8u) : null;
        this.mShowOriginVideoTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ef.d.b(165);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.mOriginVideoRootView, layoutParams);
    }

    private final void G9() {
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            String str = null;
            if ((rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getLayerVideoInfo() : null) != null) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
                if (rFWLayerItemMediaInfo2 != null && (layerVideoInfo = rFWLayerItemMediaInfo2.getLayerVideoInfo()) != null) {
                    str = layerVideoInfo.getVideoOriginUrl();
                }
                if (str == null) {
                    return;
                }
                HashSet<String> a16 = n9.a.f419499a.a();
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
                RFWLayerVideoInfo layerVideoInfo2 = rFWLayerItemMediaInfo3.getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo2);
                a16.add(layerVideoInfo2.getPlayId());
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo4);
                RFWLayerVideoInfo layerVideoInfo3 = rFWLayerItemMediaInfo4.getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo3);
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo5 = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo5);
                RFWLayerVideoInfo layerVideoInfo4 = rFWLayerItemMediaInfo5.getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo4);
                String videoOriginUrl = layerVideoInfo4.getVideoOriginUrl();
                Intrinsics.checkNotNull(videoOriginUrl);
                layerVideoInfo3.setCurrentVideoUrl(videoOriginUrl);
                if (getMLayerViewModel().mRichMediaInfo.getValue() != null) {
                    UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
                    Intrinsics.checkNotNull(value);
                    value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                    getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
                }
            }
        }
    }

    protected void D9(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mOriginVideoShowTagView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1276216, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = ef.d.b(124);
        layoutParams.rightMargin = ef.d.b(16);
        ((ViewGroup) rootView).addView(this.mOriginVideoShowTagView, layoutParams);
    }

    protected boolean F9() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H9(View view) {
        this.mOriginVideoShowTagView = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "HIDE_ORIGINAL_PIC_BUTTON")) {
            View view = this.mOriginVideoRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mOriginVideoShowTagView;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (this.mCurrentSelectedItem != null && v3.getId() == R.id.n8u) {
            G9();
            RFWLog.d(getLogTag(), RFWLog.USR, "origin_video_btn click");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        E9(rootView);
        D9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        RFWLayerVideoInfo layerVideoInfo;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (F9()) {
            View view = this.mOriginVideoRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mOriginVideoShowTagView;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if ((rFWLayerItemMediaInfo == null || rFWLayerItemMediaInfo.isVideo()) ? false : true) {
            View view3 = this.mOriginVideoRootView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.mOriginVideoShowTagView;
            if (view4 == null) {
                return;
            }
            view4.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null) {
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
            if (rFWLayerItemMediaInfo2.getLayerVideoInfo() != null) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
                if (!TextUtils.isEmpty((rFWLayerItemMediaInfo3 == null || (layerVideoInfo = rFWLayerItemMediaInfo3.getLayerVideoInfo()) == null) ? null : layerVideoInfo.getVideoOriginUrl())) {
                    View view5 = this.mOriginVideoRootView;
                    if (view5 != null) {
                        view5.setVisibility(0);
                    }
                    HashSet<String> a16 = n9.a.f419499a.a();
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo4);
                    RFWLayerVideoInfo layerVideoInfo2 = rFWLayerItemMediaInfo4.getLayerVideoInfo();
                    Intrinsics.checkNotNull(layerVideoInfo2);
                    if (!a16.contains(layerVideoInfo2.getPlayId())) {
                        TextView textView = this.mShowOriginVideoTv;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        View view6 = this.mOriginVideoShowTagView;
                        if (view6 == null) {
                            return;
                        }
                        view6.setVisibility(8);
                        return;
                    }
                    TextView textView2 = this.mShowOriginVideoTv;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    View view7 = this.mOriginVideoShowTagView;
                    if (view7 == null) {
                        return;
                    }
                    view7.setVisibility(0);
                    return;
                }
            }
        }
        View view8 = this.mOriginVideoRootView;
        if (view8 != null) {
            view8.setVisibility(8);
        }
        View view9 = this.mOriginVideoShowTagView;
        if (view9 == null) {
            return;
        }
        view9.setVisibility(8);
    }
}
