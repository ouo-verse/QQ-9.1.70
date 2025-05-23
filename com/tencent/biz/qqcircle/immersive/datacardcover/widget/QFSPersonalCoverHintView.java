package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverHintView;
import com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import i40.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverHintView;", "Lcom/tencent/biz/qqcircle/immersive/views/QFSFaultHintView;", "", "", "D0", "", NodeProps.VISIBLE, "E0", "", "l0", "m0", "n0", "getLogTag", "text", "B0", "errorMsg", "C0", "Landroid/view/View$OnClickListener;", "E", "Landroid/view/View$OnClickListener;", "getOnTvPushMoreClickListener", "()Landroid/view/View$OnClickListener;", "setOnTvPushMoreClickListener", "(Landroid/view/View$OnClickListener;)V", "onTvPushMoreClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverHintView extends QFSFaultHintView<Object> {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener onTvPushMoreClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverHintView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        TextView textView = this.f90327m;
        if (textView != null) {
            textView.setTextColor(context.getResources().getColor(R.color.qvideo_skin_color_text_secondary));
        }
        TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: k40.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPersonalCoverHintView.A0(QFSPersonalCoverHintView.this, view);
                }
            });
            b.f407181a.d(textView2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(QFSPersonalCoverHintView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.onTvPushMoreClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D0() {
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(h.a(R.string.f189323z3));
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.f158017al3));
            textView.setBackgroundResource(R.drawable.klm);
            E0(true);
        }
    }

    private final void E0(boolean visible) {
        int i3;
        TextView textView = this.C;
        if (textView != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public final void B0(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z16 = true;
        QLog.d("QFSPersonalCoverHintView", 1, "showEmpty ");
        String a16 = h.a(R.string.f189353z6);
        if (text.length() != 0) {
            z16 = false;
        }
        if (z16) {
            text = h.a(R.string.f189343z5);
        }
        w0(a16, text, QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), R.drawable.qvideo_skin_emptystate_img_offline);
        D0();
    }

    public final void C0(@NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.d("QFSPersonalCoverHintView", 1, "showError, errorMsg: " + errorMsg);
        w0(errorMsg, "", QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_offline"), R.drawable.qvideo_skin_emptystate_img_offline);
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverHintView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    @NotNull
    protected String l0() {
        String url = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_offline");
        Intrinsics.checkNotNullExpressionValue(url, "getInstance().getUrl(QCi\u2026_IMG_EMPTY_STATE_OFFLINE)");
        return url;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    @NotNull
    protected String m0() {
        String N1 = c.N1();
        Intrinsics.checkNotNullExpressionValue(N1, "getErrorHintServerException()");
        return N1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    @NotNull
    protected String n0() {
        String O1 = c.O1();
        Intrinsics.checkNotNullExpressionValue(O1, "getErrorHintServerExceptionTitle()");
        return O1;
    }

    public final void setOnTvPushMoreClickListener(@Nullable View.OnClickListener onClickListener) {
        this.onTvPushMoreClickListener = onClickListener;
    }
}
