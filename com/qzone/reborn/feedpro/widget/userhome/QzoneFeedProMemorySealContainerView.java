package com.qzone.reborn.feedpro.widget.userhome;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/userhome/QzoneFeedProMemorySealContainerView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "sealOffMemory", "", "s0", "Landroid/view/View;", "view", "q0", "r0", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "data", com.tencent.luggage.wxa.c8.c.G, "n0", "sealOffMemoryInfo", "", "o0", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mMsgText", "f", "Landroid/view/View;", "mSealRootView", h.F, "mSettingText", "<init>", "(Landroid/content/Context;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMemorySealContainerView extends QZoneBaseWidgetView<Integer> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mSealRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mSettingText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMemorySealContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QzoneFeedProMemorySealContainerView this$0, SealOffMemory sealOffMemory, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0(sealOffMemory);
        this$0.q0(this$0.mSettingText);
    }

    private final void s0(SealOffMemory sealOffMemory) {
        RFWLog.d("QzoneFeedProMemorySealContainerView", RFWLog.USR, "onSettingClick:" + sealOffMemory.actionUrl);
        yo.d.c(sealOffMemory.actionUrl, getContext());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public /* bridge */ /* synthetic */ void bindData(Object obj, int i3) {
        n0(((Number) obj).intValue(), i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1301580;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        this.mSealRootView = findViewById(R.id.f162842mx3);
        this.mMsgText = (TextView) findViewById(R.id.f162841mx2);
        TextView textView = (TextView) findViewById(R.id.f162843mx4);
        this.mSettingText = textView;
        if (textView != null) {
            aa.e(aa.f54263a, textView, 0.0f, 1, null);
        }
    }

    private final void q0(View view) {
        if (view != null) {
            fo.c.b("dt_clck", view, "em_qz_pravite_state", null);
        }
    }

    private final void r0(View view) {
        if (view != null) {
            fo.c.r(view, "em_qz_pravite_state", null);
        }
    }

    public final boolean o0(final SealOffMemory sealOffMemoryInfo) {
        if (sealOffMemoryInfo == null) {
            RFWLog.e("QzoneFeedProMemorySealContainerView", RFWLog.USR, "bindData memory info is null");
            View view = this.mSealRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            return false;
        }
        if (sealOffMemoryInfo.type != 1) {
            RFWLog.e("QzoneFeedProMemorySealContainerView", RFWLog.USR, "bindData memory info is private space");
            View view2 = this.mSealRootView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            return false;
        }
        View view3 = this.mSealRootView;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        TextView textView = this.mMsgText;
        if (textView != null) {
            textView.setText(sealOffMemoryInfo.summary);
        }
        TextView textView2 = this.mSettingText;
        if (textView2 != null) {
            textView2.setText(sealOffMemoryInfo.buttonText);
        }
        TextView textView3 = this.mSettingText;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.userhome.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QzoneFeedProMemorySealContainerView.p0(QzoneFeedProMemorySealContainerView.this, sealOffMemoryInfo, view4);
                }
            });
        }
        r0(this.mSettingText);
        return true;
    }

    protected void n0(int data, int pos) {
    }
}
