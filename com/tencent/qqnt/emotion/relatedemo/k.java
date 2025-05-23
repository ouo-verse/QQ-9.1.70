package com.tencent.qqnt.emotion.relatedemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002abB!\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010;\u001a\u000206\u0012\b\u0010A\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J*\u0010\u001c\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0014\u0010\u001e\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0018\u0010!\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\rJ\u0012\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\rH\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\rH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0016R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0019\u0010A\u001a\u0004\u0018\u00010<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010FR\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010CR\u0018\u0010L\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010CR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000b0Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006c"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/emotion/relatedemo/k$b;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "Landroid/view/View;", "view", "", "r0", "contentView", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "info", "", "index", "t0", "Lcom/tencent/image/URLImageView;", "l0", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo;", "emotionInfo", "o0", "", "url", "k0", "headerView", "footerView", "", "data", "p0", "getData", "setData", "curFriendUin", "curType", "q0", "v", "", NodeProps.ON_LONG_CLICK, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "position", "m0", "getItemCount", NodeProps.ON_CLICK, "onDismiss", "getItemViewType", "Lcom/tencent/common/app/business/BaseQQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getApp", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/emotion/relatedemo/b;", "D", "Lcom/tencent/qqnt/emotion/relatedemo/b;", "getCallback", "()Lcom/tencent/qqnt/emotion/relatedemo/b;", "callback", "E", "I", "mColumnNum", "", UserInfo.SEX_FEMALE, "mDensity", "G", "mWidthPixels", "H", "Landroid/view/View;", "mHeaderView", "mFooterView", "J", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSearchEmoticonInfo;", "mMenuShowInfo", "K", "Ljava/lang/String;", "mCurFriendUin", "L", "mCurType", "Landroid/widget/PopupWindow;", "M", "Landroid/widget/PopupWindow;", "mTipsPopupWindow", "", "N", "Ljava/util/List;", "mData", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;Lcom/tencent/qqnt/emotion/relatedemo/b;)V", "P", "a", "b", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class k extends RecyclerView.Adapter<b> implements View.OnLongClickListener, View.OnClickListener, PopupWindow.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.emotion.relatedemo.b callback;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mColumnNum;

    /* renamed from: F, reason: from kotlin metadata */
    private float mDensity;

    /* renamed from: G, reason: from kotlin metadata */
    private int mWidthPixels;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View mHeaderView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mFooterView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private RelatedEmoSearchEmoticonInfo mMenuShowInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String mCurFriendUin;

    /* renamed from: L, reason: from kotlin metadata */
    private int mCurType;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private PopupWindow mTipsPopupWindow;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<EmotionPanelData> mData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseQQAppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/k$a;", "", "", "IMG_HEIGHT_SPACE", "I", "ITEM_TYPE_FOOTER", "ITEM_TYPE_HEADER", "ITEM_TYPE_NORMAL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.k$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR,\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/k$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/image/URLImageView;", "E", "[Lcom/tencent/image/URLImageView;", "getContentViews", "()[Lcom/tencent/image/URLImageView;", "setContentViews", "([Lcom/tencent/image/URLImageView;)V", "contentViews", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private URLImageView[] contentViews;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            }
        }

        @Nullable
        public final URLImageView[] getContentViews() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (URLImageView[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.contentViews;
        }

        public final void setContentViews(@Nullable URLImageView[] uRLImageViewArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLImageViewArr);
            } else {
                this.contentViews = uRLImageViewArr;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/qqnt/emotion/relatedemo/k$c", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "progress", "onLoadProgressed", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelatedEmoSearchEmoticonInfo f356384d;

        c(RelatedEmoSearchEmoticonInfo relatedEmoSearchEmoticonInfo) {
            this.f356384d = relatedEmoSearchEmoticonInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) relatedEmoSearchEmoticonInfo);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(@Nullable View view, @Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) drawable);
                return;
            }
            QLog.e("RelatedEmoticonListAdapter", 1, "onLoadCancelled: " + this.f356384d);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(@Nullable View view, @Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, drawable, cause);
                return;
            }
            QLog.e("RelatedEmoticonListAdapter", 1, "onLoadFailed: " + this.f356384d);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(@Nullable View view, @Nullable URLDrawable drawable, @Nullable InterruptedException e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, drawable, e16);
                return;
            }
            QLog.e("RelatedEmoticonListAdapter", 1, "onLoadInterrupted: " + this.f356384d);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(@Nullable View view, @Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, drawable, Integer.valueOf(progress));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(@Nullable View view, @Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) drawable);
                return;
            }
            QLog.i("RelatedEmoticonListAdapter", 2, "onLoadSuccess: " + this.f356384d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull BaseQQAppInterface app, @NotNull Context context, @Nullable com.tencent.qqnt.emotion.relatedemo.b bVar) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, app, context, bVar);
            return;
        }
        this.app = app;
        this.context = context;
        this.callback = bVar;
        this.mColumnNum = 4;
        this.mCurFriendUin = "";
        this.mData = new ArrayList();
        this.mWidthPixels = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    private final void k0(String url) {
        ((IEmosmService) QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(this.context, url);
    }

    private final URLImageView l0(int index) {
        int i3 = (int) (this.mWidthPixels - ((2 * this.mDensity) * (this.mColumnNum - 1)));
        int i16 = this.mColumnNum;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3 / i16, i3 / i16);
        if (index == 0) {
            layoutParams.rightMargin = (int) (1 * this.mDensity);
            layoutParams.leftMargin = 0;
        } else if (index == this.mColumnNum - 1) {
            layoutParams.leftMargin = (int) (1 * this.mDensity);
            layoutParams.rightMargin = 0;
            layoutParams.width = -1;
        } else {
            float f16 = 1;
            float f17 = this.mDensity;
            layoutParams.rightMargin = (int) (f16 * f17);
            layoutParams.leftMargin = (int) (f16 * f17);
        }
        URLImageView uRLImageView = new URLImageView(this.context);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setAdjustViewBounds(false);
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setContentDescription(this.context.getString(R.string.f170795ad1));
        return uRLImageView;
    }

    private final void o0(RelatedEmoSearchEmoticonInfo emotionInfo, int index) {
        String str;
        String str2;
        String str3;
        com.tencent.qqnt.emotion.relatedemo.b bVar = this.callback;
        if (bVar != null) {
            bVar.send(emotionInfo);
        }
        BaseQQAppInterface baseQQAppInterface = this.app;
        String str4 = this.mCurFriendUin;
        int c16 = com.tencent.qqnt.emotion.utils.e.c(this.mCurType);
        int i3 = index + 1;
        String valueOf = String.valueOf(i3);
        NTRelatedEmotionSearchResult.SearchResultItem c17 = emotionInfo.c();
        String str5 = null;
        if (c17 != null) {
            str = c17.a();
        } else {
            str = null;
        }
        NTRelatedEmotionSearchResult.SearchResultItem c18 = emotionInfo.c();
        if (c18 != null) {
            str2 = c18.b();
        } else {
            str2 = null;
        }
        com.tencent.mobileqq.temp.report.a.a(baseQQAppInterface, "dc00898", "", str4, "0X800B117", "0X800B117", c16, 0, "", valueOf, str, str2);
        if (emotionInfo.a() > 0) {
            BaseQQAppInterface baseQQAppInterface2 = this.app;
            String str6 = this.mCurFriendUin;
            int a16 = emotionInfo.a();
            String valueOf2 = String.valueOf(i3);
            NTRelatedEmotionSearchResult.SearchResultItem c19 = emotionInfo.c();
            if (c19 != null) {
                str3 = c19.a();
            } else {
                str3 = null;
            }
            NTRelatedEmotionSearchResult.SearchResultItem c26 = emotionInfo.c();
            if (c26 != null) {
                str5 = c26.b();
            }
            com.tencent.mobileqq.temp.report.a.a(baseQQAppInterface2, "dc00898", "", str6, "0X800B11E", "0X800B11E", a16, 0, "", valueOf2, str3, str5);
        }
    }

    private final void r0(final View view) {
        final LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TextView textView = new TextView(this.context);
        textView.setId(R.id.f164035i0);
        textView.setOnClickListener(this);
        textView.setTextColor(this.context.getResources().getColor(R.color.f158017al3));
        textView.setTextSize(14.0f);
        textView.setGravity(17);
        textView.setText(this.context.getResources().getString(R.string.f207685ao));
        textView.setBackgroundResource(R.drawable.cay);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(ViewUtils.dip2px(65.0f), ViewUtils.dip2px(46.0f)));
        ImageView imageView = new ImageView(this.context);
        imageView.setImageDrawable(this.context.getResources().getDrawable(R.drawable.cau));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(10.0f)));
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = -ViewUtils.dip2px(7.0f);
        layoutParams2.bottomMargin = ViewUtils.dip2px(3.0f);
        imageView.setLayoutParams(layoutParams2);
        PopupWindow popupWindow = new PopupWindow(linearLayout, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(this);
        this.mTipsPopupWindow = popupWindow;
        linearLayout.measure(0, 0);
        view.post(new Runnable() { // from class: com.tencent.qqnt.emotion.relatedemo.i
            @Override // java.lang.Runnable
            public final void run() {
                k.s0(k.this, view, linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(k this$0, View view, LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(linearLayout, "$linearLayout");
        Context context = this$0.context;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            PopupWindow popupWindow = this$0.mTipsPopupWindow;
            if (popupWindow != null) {
                popupWindow.showAtLocation(view, 48, (int) (iArr[0] - (view.getMeasuredWidth() * 1.5f)), iArr[1] - linearLayout.getMeasuredHeight());
            }
        }
    }

    private final void t0(View contentView, EmotionPanelData info, final int index) {
        String str;
        String str2;
        if (!(info instanceof RelatedEmoSearchEmoticonInfo)) {
            QLog.e("RelatedEmoticonListAdapter", 1, "emotionInfo or contentView = null");
            return;
        }
        final RelatedEmoSearchEmoticonInfo relatedEmoSearchEmoticonInfo = (RelatedEmoSearchEmoticonInfo) info;
        NTRelatedEmotionSearchResult.SearchResultItem c16 = relatedEmoSearchEmoticonInfo.c();
        if (c16 != null) {
            str = c16.a();
        } else {
            str = null;
        }
        NTRelatedEmotionSearchResult.SearchResultItem c17 = relatedEmoSearchEmoticonInfo.c();
        if (c17 != null) {
            str2 = c17.b();
        } else {
            str2 = null;
        }
        int a16 = relatedEmoSearchEmoticonInfo.a();
        Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type com.tencent.image.URLImageView");
        URLImageView uRLImageView = (URLImageView) contentView;
        contentView.setTag(relatedEmoSearchEmoticonInfo);
        contentView.setVisibility(0);
        if (QLog.isColorLevel() && !StringUtil.isEmpty(relatedEmoSearchEmoticonInfo.action)) {
            QLog.d("RelatedEmoticonListAdapter", 2, "updateUI info = " + relatedEmoSearchEmoticonInfo.action);
        }
        if (uRLImageView.getTag(R.id.kxb) == info) {
            return;
        }
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.relatedemo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.u0(k.this, relatedEmoSearchEmoticonInfo, index, view);
            }
        });
        uRLImageView.setFocusable(true);
        uRLImageView.setOnLongClickListener(this);
        uRLImageView.setTag(R.id.kxb, info);
        uRLImageView.setVisibility(0);
        uRLImageView.setURLDrawableDownListener(null);
        Drawable drawable = relatedEmoSearchEmoticonInfo.getDrawable(this.context, this.mDensity);
        if (drawable instanceof URLDrawable) {
            uRLImageView.setURLDrawableDownListener(new c(relatedEmoSearchEmoticonInfo));
        }
        uRLImageView.setImageDrawable(drawable);
        int i3 = index + 1;
        com.tencent.mobileqq.temp.report.a.a(this.app, "dc00898", "", this.mCurFriendUin, "0X800B116", "0X800B116", com.tencent.qqnt.emotion.utils.e.c(this.mCurType), 0, "", String.valueOf(i3), str, str2);
        if (a16 > 0) {
            com.tencent.mobileqq.temp.report.a.a(this.app, "dc00898", "", this.mCurFriendUin, "0X800B11D", "0X800B11D", a16, 0, "", String.valueOf(i3), str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(k this$0, RelatedEmoSearchEmoticonInfo emotionInfo, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emotionInfo, "$emotionInfo");
        this$0.o0(emotionInfo, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final List<EmotionPanelData> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int size = this.mData.size();
        int i16 = this.mColumnNum;
        int i17 = size / i16;
        if (size % i16 > 0) {
            i17++;
        }
        int i18 = 0;
        if (this.mHeaderView != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i19 = i17 + i3;
        if (this.mFooterView != null) {
            i18 = 1;
        }
        return i19 + i18;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, position)).intValue();
        }
        if (this.mHeaderView != null && position == 0) {
            return 1;
        }
        if (position == getNUM_BACKGOURND_ICON() - 1 && this.mFooterView != null) {
            return 2;
        }
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        URLImageView uRLImageView;
        URLImageView uRLImageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() != 3) {
            return;
        }
        if (this.mHeaderView != null) {
            position--;
        }
        QLog.d("RelatedEmoticonListAdapter", 2, "getEmotionView position = " + position + "; view from inflater");
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setFocusable(false);
        linearLayout.setClickable(false);
        linearLayout.setDescendantFocusability(262144);
        linearLayout.setFocusableInTouchMode(false);
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(0, ViewUtils.dip2px(2.0f), 0, 0);
        int i3 = this.mColumnNum;
        for (int i16 = 0; i16 < i3; i16++) {
            URLImageView l06 = l0(i16);
            l06.setVisibility(8);
            l06.setFocusable(true);
            l06.setFocusableInTouchMode(true);
            linearLayout.addView(l06);
        }
        holder.setContentViews(new URLImageView[this.mColumnNum]);
        int i17 = this.mColumnNum;
        for (int i18 = 0; i18 < i17; i18++) {
            URLImageView[] contentViews = holder.getContentViews();
            if (contentViews != null) {
                View childAt = linearLayout.getChildAt(i18);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.image.URLImageView");
                contentViews[i18] = (URLImageView) childAt;
            }
        }
        linearLayout.setTag(holder);
        int i19 = this.mColumnNum;
        for (int i26 = 0; i26 < i19; i26++) {
            int i27 = (this.mColumnNum * position) + i26;
            if (i27 > this.mData.size() - 1) {
                URLImageView[] contentViews2 = holder.getContentViews();
                if (contentViews2 != null && (uRLImageView2 = contentViews2[i26]) != null) {
                    uRLImageView2.setTag(null);
                    uRLImageView2.setVisibility(8);
                }
            } else {
                URLImageView[] contentViews3 = holder.getContentViews();
                if (contentViews3 != null && (uRLImageView = contentViews3[i26]) != null) {
                    t0(uRLImageView, this.mData.get(i27), i27);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType == 2 && (view = this.mFooterView) != null) {
                return new b(view);
            }
        } else {
            View view2 = this.mHeaderView;
            if (view2 != null) {
                return new b(view2);
            }
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(new RelatedEmoLinearLayout(context, null, 0, 6, null));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        String str;
        String str2;
        String str3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.f164035i0) {
                QLog.d("RelatedEmoticonListAdapter", 4, " add_to_custom_face ");
                PopupWindow popupWindow = this.mTipsPopupWindow;
                if (popupWindow != null) {
                    boolean z16 = false;
                    if (popupWindow != null && popupWindow.isShowing()) {
                        z16 = true;
                    }
                    if (z16) {
                        RelatedEmoSearchEmoticonInfo relatedEmoSearchEmoticonInfo = this.mMenuShowInfo;
                        if (relatedEmoSearchEmoticonInfo != null) {
                            NTRelatedEmotionSearchResult.SearchResultItem c16 = relatedEmoSearchEmoticonInfo.c();
                            if (c16 != null) {
                                str = c16.b();
                            } else {
                                str = null;
                            }
                            k0(str);
                            BaseQQAppInterface baseQQAppInterface = this.app;
                            String str4 = this.mCurFriendUin;
                            String valueOf = String.valueOf(relatedEmoSearchEmoticonInfo.b() + 1);
                            NTRelatedEmotionSearchResult.SearchResultItem c17 = relatedEmoSearchEmoticonInfo.c();
                            if (c17 != null) {
                                str2 = c17.a();
                            } else {
                                str2 = null;
                            }
                            NTRelatedEmotionSearchResult.SearchResultItem c18 = relatedEmoSearchEmoticonInfo.c();
                            if (c18 != null) {
                                str3 = c18.b();
                            } else {
                                str3 = null;
                            }
                            com.tencent.mobileqq.temp.report.a.a(baseQQAppInterface, "dc00898", "", str4, "0X800B119", "0X800B119", 0, 0, "", valueOf, str2, str3);
                            this.mMenuShowInfo = null;
                        }
                        PopupWindow popupWindow2 = this.mTipsPopupWindow;
                        if (popupWindow2 != null) {
                            popupWindow2.dismiss();
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mTipsPopupWindow = null;
            this.mMenuShowInfo = null;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v3) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3)).booleanValue();
        } else {
            if (v3 instanceof URLImageView) {
                r0(v3);
                Object tag = ((URLImageView) v3).getTag(R.id.kxb);
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.emotion.relatedemo.RelatedEmoSearchEmoticonInfo");
                RelatedEmoSearchEmoticonInfo relatedEmoSearchEmoticonInfo = (RelatedEmoSearchEmoticonInfo) tag;
                this.mMenuShowInfo = relatedEmoSearchEmoticonInfo;
                if (relatedEmoSearchEmoticonInfo != null) {
                    BaseQQAppInterface baseQQAppInterface = this.app;
                    String str2 = this.mCurFriendUin;
                    String valueOf = String.valueOf(relatedEmoSearchEmoticonInfo.b() + 1);
                    NTRelatedEmotionSearchResult.SearchResultItem c16 = relatedEmoSearchEmoticonInfo.c();
                    String str3 = null;
                    if (c16 != null) {
                        str = c16.a();
                    } else {
                        str = null;
                    }
                    NTRelatedEmotionSearchResult.SearchResultItem c17 = relatedEmoSearchEmoticonInfo.c();
                    if (c17 != null) {
                        str3 = c17.b();
                    }
                    com.tencent.mobileqq.temp.report.a.a(baseQQAppInterface, "dc00898", "", str2, "0X800B118", "0X800B118", 0, 0, "", valueOf, str, str3);
                }
            }
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    public final void p0(@Nullable View headerView, @Nullable View footerView, @Nullable List<? extends EmotionPanelData> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, headerView, footerView, data);
            return;
        }
        this.mHeaderView = headerView;
        this.mFooterView = footerView;
        this.mData.clear();
        if (data != null) {
            this.mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public final void q0(@Nullable String curFriendUin, int curType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) curFriendUin, curType);
        } else {
            this.mCurFriendUin = curFriendUin;
            this.mCurType = curType;
        }
    }

    public final void setData(@NotNull List<? extends EmotionPanelData> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            p0(this.mHeaderView, this.mFooterView, data);
        }
    }
}
