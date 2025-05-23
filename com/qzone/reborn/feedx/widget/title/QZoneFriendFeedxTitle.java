package com.qzone.reborn.feedx.widget.title;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.AccessibilityUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import rn.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001AB'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u000b\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00105R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00107R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00107\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;", "Lcom/qzone/reborn/feedx/widget/title/QZoneBaseFeedxTitle;", "Lcom/qzone/reborn/feedx/widget/f$c;", "", "V", "U", "", BdhLogUtil.LogTag.Tag_Req, "P", "isBlack", "N", "", DomainData.DOMAIN_NAME, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W", "T", c.f123400v, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "scrollY", ExifInterface.LATITUDE_SOUTH, "E", UserInfo.SEX_FEMALE, "show", "b0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "text", "setLeftTitleText", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "O", "()Landroid/widget/TextView;", "setMLeftTitle", "(Landroid/widget/TextView;)V", "mLeftTitle", "Landroid/view/ViewGroup;", "J", "Landroid/view/ViewGroup;", "mQZMEntranceRoot", "K", "mQZMEntranceContainer", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mQZMRedDot", "M", "mEntranceIcon", "mQZMPassiveRedDot", "Lcom/qzone/reborn/qzmoment/itemview/QZMTitleBarEntranceManager;", "Lcom/qzone/reborn/qzmoment/itemview/QZMTitleBarEntranceManager;", "mQZMEntranceManager", "Landroid/view/View;", "Landroid/view/View;", "mQZMEntranceMappingRoot", "Z", "mHideQZMBubbleView", "mIsCenterTitleInitVisible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFriendFeedxTitle extends QZoneBaseFeedxTitle {

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mLeftTitle;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup mQZMEntranceRoot;

    /* renamed from: K, reason: from kotlin metadata */
    private ViewGroup mQZMEntranceContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView mQZMRedDot;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView mEntranceIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mQZMPassiveRedDot;

    /* renamed from: P, reason: from kotlin metadata */
    private QZMTitleBarEntranceManager mQZMEntranceManager;

    /* renamed from: Q, reason: from kotlin metadata */
    private View mQZMEntranceMappingRoot;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean mHideQZMBubbleView;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsCenterTitleInitVisible;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFriendFeedxTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void P() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hkh, (ViewGroup) this, false);
        this.mQZMEntranceMappingRoot = inflate;
        if (inflate != null) {
            inflate.measure(0, 0);
        }
        QZMTitleBarEntranceManager qZMTitleBarEntranceManager = this.mQZMEntranceManager;
        if (qZMTitleBarEntranceManager != null) {
            qZMTitleBarEntranceManager.K(this.mQZMEntranceMappingRoot);
        }
    }

    private final boolean R() {
        return g.d() && !QZoneApiProxy.needShowQzoneFrame(getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private final void U() {
        this.mQZMEntranceManager = new QZMTitleBarEntranceManager();
        P();
        QZMTitleBarEntranceManager qZMTitleBarEntranceManager = this.mQZMEntranceManager;
        if (qZMTitleBarEntranceManager != null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            qZMTitleBarEntranceManager.L((Activity) context, this.mQZMEntranceRoot, this.mEntranceIcon, this.mQZMRedDot, this.mQZMPassiveRedDot);
        }
    }

    private final void V() {
        if (R()) {
            ViewGroup viewGroup = this.mQZMEntranceRoot;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            ViewGroup viewGroup2 = this.mQZMEntranceContainer;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            U();
            return;
        }
        ViewGroup viewGroup3 = this.mQZMEntranceRoot;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(8);
        }
        ViewGroup viewGroup4 = this.mQZMEntranceContainer;
        if (viewGroup4 == null) {
            return;
        }
        viewGroup4.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public void E() {
        super.E();
        this.mLeftTitle.setTextColor(q());
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public void F() {
        super.F();
        this.mLeftTitle.setTextColor(r());
    }

    /* renamed from: O, reason: from getter */
    public final TextView getMLeftTitle() {
        return this.mLeftTitle;
    }

    public final void Q() {
        RFWLog.d("QZoneFriendFeedxTitle", RFWLog.USR, "is moment entrance enable " + R());
        View inflate = ((ViewStub) findViewById(R.id.mkx)).inflate();
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mQZMEntranceRoot = (ViewGroup) inflate;
        this.mQZMEntranceContainer = (ViewGroup) findViewById(R.id.mka);
        this.mEntranceIcon = (ImageView) findViewById(R.id.f162751lp2);
        this.mQZMRedDot = (ImageView) findViewById(R.id.mkc);
        this.mQZMPassiveRedDot = (TextView) findViewById(R.id.mkb);
        N(false);
        V();
        AccessibilityUtil.s(this.mEntranceIcon, l.a(R.string.f133205h));
    }

    public final void T() {
        QZMTitleBarEntranceManager qZMTitleBarEntranceManager;
        if (!R() || (qZMTitleBarEntranceManager = this.mQZMEntranceManager) == null) {
            return;
        }
        qZMTitleBarEntranceManager.C();
    }

    public final void W() {
        if (R()) {
            QZMTitleBarEntranceManager qZMTitleBarEntranceManager = this.mQZMEntranceManager;
            if (qZMTitleBarEntranceManager != null) {
                qZMTitleBarEntranceManager.P(true);
            }
            QZMTitleBarEntranceManager qZMTitleBarEntranceManager2 = this.mQZMEntranceManager;
            if (qZMTitleBarEntranceManager2 != null) {
                qZMTitleBarEntranceManager2.onResume();
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle, com.qzone.reborn.feedx.widget.f.c
    public void b0(boolean show) {
        super.b0(show);
        if (QZoneFeedxViewUtils.i(getContext())) {
            if (!this.mIsCenterTitleInitVisible && getMTitleName().getVisibility() == 0) {
                this.mIsCenterTitleInitVisible = true;
            }
            if (this.mIsCenterTitleInitVisible) {
                if (show) {
                    getMTitleName().setVisibility(8);
                } else {
                    getMTitleName().setVisibility(0);
                }
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public int n() {
        return R.layout.ciq;
    }

    public final void setLeftTitleText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mLeftTitle.setText(text);
    }

    public final void setMLeftTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mLeftTitle = textView;
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public void z() {
        super.z();
        QZMTitleBarEntranceManager qZMTitleBarEntranceManager = this.mQZMEntranceManager;
        if (qZMTitleBarEntranceManager != null) {
            qZMTitleBarEntranceManager.B();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFriendFeedxTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFriendFeedxTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void N(boolean isBlack) {
        if (isBlack) {
            com.tencent.mobileqq.qzone.picload.c.a().m(this.mEntranceIcon, l());
        } else {
            com.tencent.mobileqq.qzone.picload.c.a().m(this.mEntranceIcon, m());
        }
    }

    public final void S(int scrollY) {
        if (scrollY == 0 || this.mHideQZMBubbleView) {
            return;
        }
        this.mHideQZMBubbleView = true;
        QZMTitleBarEntranceManager qZMTitleBarEntranceManager = this.mQZMEntranceManager;
        if (qZMTitleBarEntranceManager != null) {
            qZMTitleBarEntranceManager.E();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFriendFeedxTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mjd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qz_feedx_title_left)");
        this.mLeftTitle = (TextView) findViewById;
        getMTitleName().setText(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FRIENDFEED_TITLE, QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE));
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public void A(int alpha) {
        N(alpha >= 125);
    }
}
