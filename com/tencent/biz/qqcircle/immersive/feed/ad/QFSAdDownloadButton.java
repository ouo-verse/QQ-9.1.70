package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSAdDownloadButton;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.views.AdProgressButton;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import com.tencent.richframework.widget.popupwindow.priority.RFWPriorityPopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0002GHB\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AB\u0019\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\b@\u0010DB!\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020\u0014\u00a2\u0006\u0004\b@\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0003J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014R\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0018\u0010/\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "Lcom/tencent/ad/tangram/views/button/IAdAppDownloadButtonView;", "Landroid/widget/RelativeLayout;", "", "d", "Lcom/tencent/mobileqq/ad/views/AdProgressButton$a;", "e", "text", "", "j", "", "i", "g", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "setAd", "prefix", "setPrefixText", "prefixTag", "setPrefixTag", "", "status", "progress", "update", "resId", "setActionBtnLayoutBg", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton$b;", "onClickListener", "setOnAdBtnClickListener", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "f", "width", HippyQQPagView.FunctionName.SET_PROGRESS, "Lcom/tencent/mobileqq/ad/views/AdProgressButton;", "Lcom/tencent/mobileqq/ad/views/AdProgressButton;", "progressBtn", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "pauseBtnLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "btnDownloadContinue", tl.h.F, "btnDownloadCancel", "actionBtnLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "shakeIcon", BdhLogUtil.LogTag.Tag_Conn, "actionBtnTv", "D", "Lcom/tencent/gdtad/aditem/GdtAd;", "E", "I", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "prefixText", "Lcom/tencent/richframework/widget/popupwindow/priority/RFWPriorityPopupWindow;", "G", "Lcom/tencent/richframework/widget/popupwindow/priority/RFWPriorityPopupWindow;", "bubbleTip", "H", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAdDownloadButton extends RelativeLayout implements IAdAppDownloadButtonView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView actionBtnTv;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GdtAd ad;

    /* renamed from: E, reason: from kotlin metadata */
    private int status;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String prefixText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RFWPriorityPopupWindow bubbleTip;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String prefixTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdProgressButton progressBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout pauseBtnLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView btnDownloadContinue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView btnDownloadCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout actionBtnLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView shakeIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton$b;", "", "", "status", "", NodeProps.ON_CLICK, "onCancelClick", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void onCancelClick();

        void onClick(int status);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSAdDownloadButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefixText = "";
        this.prefixTag = "";
        LayoutInflater.from(getContext()).inflate(R.layout.gdt, (ViewGroup) this, true);
        g();
    }

    private final String d() {
        return "QFSAdDownloadButton" + this.prefixTag;
    }

    private final AdProgressButton.a e() {
        AdProgressButton.a aVar = new AdProgressButton.a();
        aVar.f186985a = ViewUtils.dpToPx(14.0f);
        aVar.f186986b = Color.parseColor("#0099FF");
        aVar.f186987c = -1;
        aVar.f186988d = Color.parseColor("#800099FF");
        aVar.f186989e = -1;
        aVar.f186990f = ViewUtils.dpToPx(4.0f);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QFSAdDownloadButton this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdProgressButton adProgressButton = this$0.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.performClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean i() {
        ViewParent parent = getParent();
        if ((parent instanceof ViewGroup) && ((ViewGroup) parent).getVisibility() != 0) {
            return false;
        }
        do {
            parent = parent.getParent();
            if (!(parent instanceof ViewGroup)) {
                break;
            }
        } while (((ViewGroup) parent).getVisibility() == 0);
        if (parent != null && (parent instanceof ViewGroup) && ((ViewGroup) parent).getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void j(String text) {
        int i3;
        TextView textView = this.actionBtnTv;
        if (textView != null) {
            textView.setText(text);
        }
        GdtShakeIconView gdtShakeIconView = this.shakeIcon;
        if (gdtShakeIconView != null) {
            if (Intrinsics.areEqual(this.prefixText, "\u6447\u52a8\u6216\u70b9\u51fb")) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            gdtShakeIconView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(b onClickListener, QFSAdDownloadButton this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view != null) {
            if (view.getId() == R.id.say) {
                onClickListener.onCancelClick();
            } else {
                onClickListener.onClick(this$0.status);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final GdtShakeIconView getShakeIcon() {
        return this.shakeIcon;
    }

    public final void g() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f163989sc4);
        this.pauseBtnLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        this.btnDownloadContinue = (TextView) findViewById(R.id.saz);
        this.btnDownloadCancel = (TextView) findViewById(R.id.say);
        this.progressBtn = (AdProgressButton) findViewById(R.id.f163963sb0);
        this.actionBtnLayout = (LinearLayout) findViewById(R.id.f33240vx);
        this.shakeIcon = (GdtShakeIconView) findViewById(R.id.f38661_k);
        this.actionBtnTv = (TextView) findViewById(R.id.f379918r);
        AdProgressButton adProgressButton = this.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.setParams(e());
        }
        LinearLayout linearLayout2 = this.actionBtnLayout;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSAdDownloadButton.h(QFSAdDownloadButton.this, view);
                }
            });
        }
    }

    public final void setActionBtnLayoutBg(@DrawableRes int resId) {
        LinearLayout linearLayout = this.actionBtnLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(resId);
        }
    }

    public final void setAd(@NotNull GdtAd ad5) {
        Intrinsics.checkNotNullParameter(ad5, "ad");
        this.ad = ad5;
    }

    public final void setOnAdBtnClickListener(@NotNull final b onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSAdDownloadButton.k(QFSAdDownloadButton.b.this, this, view);
            }
        };
        TextView textView = this.btnDownloadContinue;
        if (textView != null) {
            textView.setOnClickListener(onClickListener2);
        }
        TextView textView2 = this.btnDownloadCancel;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener2);
        }
        AdProgressButton adProgressButton = this.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.setOnClickListener(onClickListener2);
        }
    }

    public final void setPrefixTag(@NotNull String prefixTag) {
        Intrinsics.checkNotNullParameter(prefixTag, "prefixTag");
        this.prefixTag = prefixTag;
    }

    public final void setPrefixText(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.prefixText = prefix;
    }

    public final void setProgress(@NotNull String text, int progress, int width) {
        Intrinsics.checkNotNullParameter(text, "text");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
        }
        AdProgressButton adProgressButton = this.progressBtn;
        if (adProgressButton != null) {
            adProgressButton.requestLayout();
        }
        AdProgressButton adProgressButton2 = this.progressBtn;
        if (adProgressButton2 != null) {
            adProgressButton2.setText(text);
        }
        AdProgressButton adProgressButton3 = this.progressBtn;
        if (adProgressButton3 != null) {
            adProgressButton3.setProgress(progress);
        }
    }

    @Override // com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView
    public void update(int status, int progress) {
        String str;
        String str2;
        Long l3;
        GdtAd gdtAd = this.ad;
        if (gdtAd != null) {
            str = gdtAd.getButtonText(status, progress);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String d16 = d();
        String d17 = d();
        GdtAd gdtAd2 = this.ad;
        if (gdtAd2 != null) {
            str2 = gdtAd2.getTraceId();
        } else {
            str2 = null;
        }
        GdtAd gdtAd3 = this.ad;
        if (gdtAd3 != null) {
            l3 = Long.valueOf(gdtAd3.getAId());
        } else {
            l3 = null;
        }
        QLog.d(d16, 4, d17 + " status: " + status + ", text: " + str + ", traceId: " + str2 + ", aid: " + l3);
        this.status = status;
        if (status == 5 && this.bubbleTip == null && i()) {
            QLog.d(d(), 1, "show bubble tip. ");
            this.bubbleTip = mc0.a.d(getContext(), "\u70b9\u51fb\u8fdb\u5ea6\u6761\u53ef\u6682\u505c/\u53d6\u6d88").setAnchor(this.actionBtnLayout).setAlignment(1).setPosition(1).setTouchOutsideDismiss(false).setDismissInterval(-1L).addStatusCallback(new c()).setGroup("download_bubble").setPriority(hashCode());
        }
        if (!i()) {
            RFWPriorityPopupWindow rFWPriorityPopupWindow = this.bubbleTip;
            if (rFWPriorityPopupWindow != null) {
                rFWPriorityPopupWindow.dismiss();
            }
            this.bubbleTip = null;
        }
        if (status != 0 && status != 1 && status != 2 && status != 3) {
            if (status != 5) {
                if (status != 6) {
                    if (status != 7) {
                        if (status == 9) {
                            LinearLayout linearLayout = this.pauseBtnLayout;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            AdProgressButton adProgressButton = this.progressBtn;
                            if (adProgressButton != null) {
                                adProgressButton.setVisibility(8);
                            }
                            LinearLayout linearLayout2 = this.actionBtnLayout;
                            if (linearLayout2 != null) {
                                linearLayout2.setVisibility(0);
                            }
                            j(this.prefixText + str);
                            RFWPriorityPopupWindow rFWPriorityPopupWindow2 = this.bubbleTip;
                            if (rFWPriorityPopupWindow2 != null) {
                                rFWPriorityPopupWindow2.dismiss();
                            }
                            this.bubbleTip = null;
                            return;
                        }
                        return;
                    }
                    LinearLayout linearLayout3 = this.pauseBtnLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                    AdProgressButton adProgressButton2 = this.progressBtn;
                    if (adProgressButton2 != null) {
                        adProgressButton2.setVisibility(8);
                    }
                    LinearLayout linearLayout4 = this.actionBtnLayout;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                    j(this.prefixText + str);
                    RFWPriorityPopupWindow rFWPriorityPopupWindow3 = this.bubbleTip;
                    if (rFWPriorityPopupWindow3 != null) {
                        rFWPriorityPopupWindow3.dismiss();
                    }
                    this.bubbleTip = null;
                    return;
                }
                LinearLayout linearLayout5 = this.pauseBtnLayout;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                AdProgressButton adProgressButton3 = this.progressBtn;
                if (adProgressButton3 != null) {
                    adProgressButton3.setVisibility(8);
                }
                LinearLayout linearLayout6 = this.actionBtnLayout;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                setProgress(str, progress, -1);
                AdProgressButton adProgressButton4 = this.progressBtn;
                if (adProgressButton4 != null) {
                    adProgressButton4.setText("");
                }
                TextView textView = this.btnDownloadContinue;
                if (textView != null) {
                    textView.setText(str);
                }
                RFWPriorityPopupWindow rFWPriorityPopupWindow4 = this.bubbleTip;
                if (rFWPriorityPopupWindow4 != null) {
                    rFWPriorityPopupWindow4.dismiss();
                }
                this.bubbleTip = null;
                return;
            }
            LinearLayout linearLayout7 = this.pauseBtnLayout;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            AdProgressButton adProgressButton5 = this.progressBtn;
            if (adProgressButton5 != null) {
                adProgressButton5.setVisibility(0);
            }
            LinearLayout linearLayout8 = this.actionBtnLayout;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(8);
            }
            setProgress(str, progress, -1);
            return;
        }
        LinearLayout linearLayout9 = this.pauseBtnLayout;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        AdProgressButton adProgressButton6 = this.progressBtn;
        if (adProgressButton6 != null) {
            adProgressButton6.setVisibility(8);
        }
        LinearLayout linearLayout10 = this.actionBtnLayout;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(0);
        }
        j(this.prefixText + str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSAdDownloadButton(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.prefixText = "";
        this.prefixTag = "";
        LayoutInflater.from(getContext()).inflate(R.layout.gdt, (ViewGroup) this, true);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSAdDownloadButton(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.prefixText = "";
        this.prefixTag = "";
        LayoutInflater.from(getContext()).inflate(R.layout.gdt, (ViewGroup) this, true);
        g();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton$c", "Lcom/tencent/richframework/widget/popupwindow/RFWSmartPopupWindow$IStatusCallback;", "", "onDismiss", "onShow", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements RFWSmartPopupWindow.IStatusCallback {
        c() {
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public /* bridge */ /* synthetic */ void onClick(View view) {
            a04.d.a(this, view);
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public void onDismiss() {
            QFSAdDownloadButton.this.bubbleTip = null;
        }

        @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
        public void onShow() {
        }
    }
}
