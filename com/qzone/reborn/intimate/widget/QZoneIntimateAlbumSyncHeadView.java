package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumSyncHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "q0", "o0", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "listUIStateData", "n0", "", "getLayoutId", "data", com.tencent.luggage.wxa.c8.c.G, "bindData", "Lnk/ae;", "e", "Lnk/ae;", "mAlbumViewModel", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mAlbumSyncTipView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumSyncHeadView extends QZoneBaseWidgetView<Object> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ae mAlbumViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumSyncTipView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumSyncHeadView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n48);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_intimate_album_sync_tip)");
        this.mAlbumSyncTipView = (TextView) findViewById;
        q0();
    }

    private final void o0() {
        MutableLiveData<UIStateData<List<QZoneAlbumSyncBean>>> S1;
        ae aeVar = (ae) p(ae.class);
        this.mAlbumViewModel = aeVar;
        if (aeVar == null || (S1 = aeVar.S1()) == null) {
            return;
        }
        S1.observe(l0(), new Observer() { // from class: com.qzone.reborn.intimate.widget.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateAlbumSyncHeadView.p0(QZoneIntimateAlbumSyncHeadView.this, (UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QZoneIntimateAlbumSyncHeadView this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n0(uIStateData);
    }

    private final void q0() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object data, int pos) {
        this.mAlbumSyncTipView.setText(com.qzone.reborn.configx.g.f53821a.h().t());
        o0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cj_;
    }

    private final void n0(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        if ((listUIStateData != null ? listUIStateData.getData() : null) == null) {
            QLog.e("BaseWidgetView", 1, "ui state data is null");
            return;
        }
        int state = listUIStateData.getState();
        if (state == 2 || state == 3) {
            this.mAlbumSyncTipView.setVisibility(new ArrayList(listUIStateData.getData()).size() > 0 ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumSyncHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n48);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_intimate_album_sync_tip)");
        this.mAlbumSyncTipView = (TextView) findViewById;
        q0();
    }
}
