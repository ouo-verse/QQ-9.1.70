package com.tencent.sqshow.zootopia.widget.reddot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.sqshow.zootopia.utils.ae;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 I2\u00020\u0001:\u0001JB\u001d\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001aR\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001e\u00a8\u0006K"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanBaseDotView;", "", "contentText", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", WidgetCacheConstellationData.NUM, "p", "", "isLittle", "o", "Landroid/view/ViewGroup$LayoutParams;", "textRedDotLayoutParams", "width", "padding", "r", DomainData.DOMAIN_NAME, "l", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgv4/e;", "redDotData", "i", "c", "E", "I", "getTextRedDotWidth", "()I", "setTextRedDotWidth", "(I)V", "textRedDotWidth", UserInfo.SEX_FEMALE, "getTextRedDotPadding", "setTextRedDotPadding", "textRedDotPadding", "G", "getTextRedDotMaxWidth", "setTextRedDotMaxWidth", "textRedDotMaxWidth", "H", "portalReddotId", "contentNum", "J", "Ljava/lang/String;", "Landroid/view/View;", "K", "Landroid/view/View;", "littleNormalReddot", "L", "normalReddot", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "textRedDot", "Landroid/widget/FrameLayout;", "N", "Landroid/widget/FrameLayout;", "textRedDotLayout", "Lcom/tencent/image/URLImageView;", "P", "Lcom/tencent/image/URLImageView;", "iconRedDot", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "k", "setStoreType", "storeType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Req, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZPlanRedDotView extends ZPlanBaseDotView {

    /* renamed from: E, reason: from kotlin metadata */
    private int textRedDotWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int textRedDotPadding;

    /* renamed from: G, reason: from kotlin metadata */
    private int textRedDotMaxWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int portalReddotId;

    /* renamed from: I, reason: from kotlin metadata */
    private int contentNum;

    /* renamed from: J, reason: from kotlin metadata */
    private String contentText;

    /* renamed from: K, reason: from kotlin metadata */
    private View littleNormalReddot;

    /* renamed from: L, reason: from kotlin metadata */
    private View normalReddot;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView textRedDot;

    /* renamed from: N, reason: from kotlin metadata */
    private FrameLayout textRedDotLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private URLImageView iconRedDot;

    /* renamed from: Q, reason: from kotlin metadata */
    private int storeType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRedDotView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void q(String contentText) {
        View view = this.normalReddot;
        if (view != null) {
            view.setVisibility(4);
        }
        TextView textView = this.textRedDot;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.textRedDot;
        if (textView2 != null) {
            textView2.setText(contentText);
        }
        TextView textView3 = this.textRedDot;
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.idb);
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.ZPlanBaseDotView
    public void i(gv4.e redDotData) {
        Intrinsics.checkNotNullParameter(redDotData, "redDotData");
        setReddotStatus(redDotData.f403426b);
        int i3 = redDotData.f403426b;
        if (i3 == 0) {
            setVisibility(4);
            return;
        }
        if (i3 == 1) {
            setVisibility(0);
            p(-1);
            return;
        }
        if (i3 == 2) {
            setVisibility(0);
            p(redDotData.f403427c);
            return;
        }
        if (i3 == 3) {
            setVisibility(0);
            String str = redDotData.f403428d;
            Intrinsics.checkNotNullExpressionValue(str, "redDotData.showText");
            q(str);
            return;
        }
        if (i3 == 5) {
            this.storeType = redDotData.f403427c;
            setVisibility(0);
            p(-2);
            return;
        }
        if (i3 != 6) {
            setVisibility(4);
            View view = this.normalReddot;
            if (view != null) {
                view.setVisibility(4);
            }
            View view2 = this.littleNormalReddot;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TextView textView = this.textRedDot;
            if (textView != null) {
                textView.setVisibility(4);
            }
            FrameLayout frameLayout = this.textRedDotLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            URLImageView uRLImageView = this.iconRedDot;
            if (uRLImageView == null) {
                return;
            }
            uRLImageView.setVisibility(8);
            return;
        }
        this.storeType = redDotData.f403427c;
        setVisibility(0);
        m(redDotData.f403429e);
    }

    /* renamed from: k, reason: from getter */
    public final int getStoreType() {
        return this.storeType;
    }

    public final void l() {
        View view = this.normalReddot;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.gravity = 8388691;
        View view2 = this.normalReddot;
        if (view2 == null) {
            return;
        }
        view2.setLayoutParams(layoutParams2);
    }

    public final void m(String url) {
        View view = this.normalReddot;
        if (view != null) {
            view.setVisibility(4);
        }
        TextView textView = this.textRedDot;
        if (textView != null) {
            textView.setVisibility(4);
        }
        URLImageView uRLImageView = this.iconRedDot;
        if (uRLImageView != null) {
            uRLImageView.setVisibility(0);
        }
        if (url != null) {
            ae.INSTANCE.a(this.iconRedDot, url, null, R.drawable.id_);
        }
    }

    public final void setStoreType(int i3) {
        this.storeType = i3;
    }

    public final void setTextRedDotMaxWidth(int i3) {
        this.textRedDotMaxWidth = i3;
    }

    public final void setTextRedDotPadding(int i3) {
        this.textRedDotPadding = i3;
    }

    public final void setTextRedDotWidth(int i3) {
        this.textRedDotWidth = i3;
    }

    public /* synthetic */ ZPlanRedDotView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.ZPlanBaseDotView
    public void c() {
        this.contentNum = -1;
        this.contentText = null;
    }

    public final void n(int num) {
        this.contentText = null;
        this.portalReddotId = -1;
        this.contentNum = num;
        p(num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRedDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textRedDotWidth = Utils.n(14.0f, context.getResources());
        this.textRedDotPadding = Utils.n(4.0f, context.getResources());
        this.textRedDotMaxWidth = Utils.n(24.0f, context.getResources());
        this.portalReddotId = -1;
        this.contentNum = -1;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167426d90, this);
        this.littleNormalReddot = inflate.findViewById(R.id.q5r);
        this.normalReddot = inflate.findViewById(R.id.q_l);
        this.textRedDot = (TextView) inflate.findViewById(R.id.qqc);
        this.textRedDotLayout = (FrameLayout) inflate.findViewById(R.id.qqd);
        this.iconRedDot = (URLImageView) inflate.findViewById(R.id.q0g);
        View view = this.littleNormalReddot;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.normalReddot;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        FrameLayout frameLayout = this.textRedDotLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView = this.textRedDot;
        if (textView != null) {
            textView.setVisibility(4);
        }
        URLImageView uRLImageView = this.iconRedDot;
        if (uRLImageView == null) {
            return;
        }
        uRLImageView.setVisibility(8);
    }

    private final void r(ViewGroup.LayoutParams textRedDotLayoutParams, int width, int padding) {
        if (textRedDotLayoutParams != null) {
            textRedDotLayoutParams.width = width;
        }
        TextView textView = this.textRedDot;
        if (textView != null) {
            textView.setPadding(padding, 0, padding, 0);
        }
    }

    private final void p(int num) {
        if (num > 0) {
            View view = this.normalReddot;
            if (view != null) {
                view.setVisibility(4);
            }
            FrameLayout frameLayout = this.textRedDotLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            TextView textView = this.textRedDot;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.textRedDot;
            if (textView2 != null) {
                textView2.setText(String.valueOf(num));
            }
            FrameLayout frameLayout2 = this.textRedDotLayout;
            ViewGroup.LayoutParams layoutParams = frameLayout2 != null ? frameLayout2.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.width = -2;
            }
            if (num <= 9) {
                s(this, layoutParams, this.textRedDotWidth, 0, 4, null);
                return;
            }
            if (num <= 99) {
                r(layoutParams, -2, this.textRedDotPadding);
                return;
            }
            TextView textView3 = this.textRedDot;
            if (textView3 != null) {
                textView3.setText(getContext().getString(R.string.xsr));
            }
            s(this, layoutParams, this.textRedDotMaxWidth, 0, 4, null);
            return;
        }
        o(num == -2);
    }

    private final void o(boolean isLittle) {
        if (isLittle) {
            View view = this.littleNormalReddot;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.normalReddot;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.normalReddot;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.littleNormalReddot;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        TextView textView = this.textRedDot;
        if (textView != null) {
            textView.setVisibility(4);
        }
        FrameLayout frameLayout = this.textRedDotLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    static /* synthetic */ void s(ZPlanRedDotView zPlanRedDotView, ViewGroup.LayoutParams layoutParams, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 4) != 0) {
                i16 = 0;
            }
            zPlanRedDotView.r(layoutParams, i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateParams");
    }
}
