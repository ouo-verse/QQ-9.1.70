package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imsdk.BaseConstants;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelAIHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.ai.emoticon.AiPanelInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0015\u0018\u0000 >2\u00020\u0001:\u0002=>BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0016J.\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0016J\"\u0010*\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010!J\u0012\u0010+\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010!H\u0002J\b\u0010,\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020#H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J,\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u0002082\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u00109\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020\u001aH\u0002J\u001a\u0010;\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010<H\u0002R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmotionAIAdapter;", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter;", "app", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "interactionListener", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "context", "Landroid/content/Context;", "columnNum", "", "panelType", VasReportUtils.BUSINESS_TYPE_EMOTION, "callback", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "(Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;Landroid/content/Context;IIILcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "contentHeight", "helper", "Lcom/tencent/mobileqq/emoticonview/EmoticonPanelAIHelper;", "getInteractionListener", "()Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "interceptListener", "com/tencent/mobileqq/emoticonview/EmotionAIAdapter$interceptListener$1", "Lcom/tencent/mobileqq/emoticonview/EmotionAIAdapter$interceptListener$1;", "downloadPreviewResource", "", "url", "", "getAIView", "Landroid/widget/RelativeLayout;", "isBanner", "", "getCount", "getEmotionView", "Landroid/view/View;", "viewHolder", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter$ViewHolder;", "position", "convertView", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "getGeneratingView", "getItemViewType", "getNormalView", "getPosterView", "getViewTypeCount", "isShowRedDot", "info", "Lcom/tencent/mobileqq/emoticonview/AIEmoticonInfo;", "newHolder", "reportAICreationClick", "type", "updateBannerCache", "updateBannerView", "contentView", com.tencent.luggage.wxa.ye.m.NAME, "view", "Landroid/widget/ImageView;", "isApng", "apngUrl", "updateUI", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "AIEmoticonViewHolder", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmotionAIAdapter extends BaseEmotionAdapter {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int DT_ENTRY_TYPE_CREATED = 2;
    public static final int DT_ENTRY_TYPE_NO_CREATE = 1;
    public static final int IMG_BORDER_HEIGHT = 64;
    public static final int IMG_HEIGHT = 60;

    @NotNull
    private static final String LABEL_IMAGE_URL = "https://downv6.qq.com/shadow_qqcamera/AIEmoticon/ai_emoticon_banner_reddot.png";

    @NotNull
    private static final String TAG = "EmotionAIAdapter";
    public static final int TYPE_CONTAIN_BANNER = 1;
    public static final int TYPE_GENERATING = 3;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_POSTER = 2;
    private int contentHeight;

    @Nullable
    private EmoticonPanelAIHelper helper;

    @Nullable
    private final IPanelInteractionListener interactionListener;

    @NotNull
    private final EmotionAIAdapter$interceptListener$1 interceptListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmotionAIAdapter$AIEmoticonViewHolder;", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter$ViewHolder;", "()V", "contentViews", "", "Landroid/widget/RelativeLayout;", "getContentViews", "()[Landroid/widget/RelativeLayout;", "setContentViews", "([Landroid/widget/RelativeLayout;)V", "[Landroid/widget/RelativeLayout;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AIEmoticonViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;

        @Nullable
        private RelativeLayout[] contentViews;

        public AIEmoticonViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final RelativeLayout[] getContentViews() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RelativeLayout[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.contentViews;
        }

        public final void setContentViews(@Nullable RelativeLayout[] relativeLayoutArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) relativeLayoutArr);
            } else {
                this.contentViews = relativeLayoutArr;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmotionAIAdapter$Companion;", "", "()V", "DT_ENTRY_TYPE_CREATED", "", "DT_ENTRY_TYPE_NO_CREATE", "IMG_BORDER_HEIGHT", "IMG_HEIGHT", "LABEL_IMAGE_URL", "", "TAG", "TYPE_CONTAIN_BANNER", "TYPE_GENERATING", "TYPE_NORMAL", "TYPE_POSTER", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.mobileqq.emoticonview.EmotionAIAdapter$interceptListener$1] */
    public EmotionAIAdapter(@Nullable IEmoticonMainPanelApp iEmoticonMainPanelApp, @Nullable IPanelInteractionListener iPanelInteractionListener, @Nullable Context context, int i3, int i16, int i17, @Nullable EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.interactionListener = iPanelInteractionListener;
        this.interceptListener = new IEmoticonPanelLinearLayoutHelper.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionAIAdapter$interceptListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper.OnClickListener
            public boolean shouldInterceptClickEvent(@Nullable View view, @Nullable EmoticonInfo info) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) info)).booleanValue();
                }
                if (view == null || info == null || ((AIEmoticonInfo) info).itemType != 1) {
                    return false;
                }
                return true;
            }
        };
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(iPanelInteractionListener);
        if (emoticonMainPanel != null) {
            this.helper = (EmoticonPanelAIHelper) emoticonMainPanel.getEmoController().getHelper(13);
        }
    }

    private final void downloadPreviewResource(String url) {
        Option url2 = Option.obtain().setUrl(url);
        if (!FileUtils.fileExistsAndNotEmpty(((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader().getPicLocalPath(url2))) {
            ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader().download(url2, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.t
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    EmotionAIAdapter.downloadPreviewResource$lambda$13(loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadPreviewResource$lambda$13(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e(TAG, 1, "updateImageView state:" + loadState + "  listenerOption:" + option);
        }
    }

    private final RelativeLayout getAIView(boolean isBanner) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setGravity(17);
        float f16 = 64;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.density * f16)));
        if (isBanner) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.e6v, (ViewGroup) null);
            ((RoundCorneredLinearLayout) inflate.findViewById(R.id.f164081sg1)).setRadius(ViewUtils.dip2px(8.0f));
            float f17 = this.density;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f16 * f17), (int) (f16 * f17));
            layoutParams.addRule(13, -1);
            relativeLayout.addView(inflate, layoutParams);
        } else {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setId(R.id.sfz);
            float f18 = 60;
            float f19 = this.density;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f18 * f19), (int) (f18 * f19));
            layoutParams2.addRule(13, -1);
            layoutParams2.addRule(12, -1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(false);
            relativeLayout.addView(imageView, layoutParams2);
        }
        if (AppSetting.f99565y) {
            relativeLayout.setFocusable(true);
            relativeLayout.setContentDescription(this.mContext.getString(R.string.f208995e8));
        }
        return relativeLayout;
    }

    private final View getGeneratingView(View convertView) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.e6w, (ViewGroup) null);
            Intrinsics.checkNotNull(convertView);
            convertView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((ImageView) convertView.findViewById(R.id.y5e)).setImageDrawable(LoadingUtil.getLoadingDrawable(this.mContext, 2));
            convertView.findViewById(R.id.yef).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmotionAIAdapter.getGeneratingView$lambda$3(EmotionAIAdapter.this, view);
                }
            });
            convertView.findViewById(R.id.f112156n6).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmotionAIAdapter.getGeneratingView$lambda$4(EmotionAIAdapter.this, view);
                }
            });
        }
        int height = getCurrentListView().getHeight();
        if (height > 0 && height != this.contentHeight) {
            this.contentHeight = height;
            ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.AbsListView.LayoutParams");
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) layoutParams;
            layoutParams2.height = this.contentHeight;
            convertView.setLayoutParams(layoutParams2);
        }
        return convertView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGeneratingView$lambda$3(EmotionAIAdapter this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "generating click template schema");
        EmoticonPanelAIHelper.Companion companion = EmoticonPanelAIHelper.INSTANCE;
        Context mContext = this$0.mContext;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        EmoticonPanelAIHelper emoticonPanelAIHelper = this$0.helper;
        if (emoticonPanelAIHelper == null || (str = emoticonPanelAIHelper.getTemplateSchema()) == null) {
            str = "";
        }
        companion.openURL(mContext, str, BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGeneratingView$lambda$4(EmotionAIAdapter this$0, View view) {
        String str;
        AiPanelInfo aiPanelInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "generating click home page");
        EmoticonPanelAIHelper.Companion companion = EmoticonPanelAIHelper.INSTANCE;
        Context mContext = this$0.mContext;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        EmoticonPanelAIHelper emoticonPanelAIHelper = this$0.helper;
        if (emoticonPanelAIHelper == null || (aiPanelInfo = emoticonPanelAIHelper.getAiPanelInfo()) == null || (str = aiPanelInfo.getMainPage()) == null) {
            str = "";
        }
        companion.openURL(mContext, str, BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View getPosterView(View convertView) {
        View view;
        boolean z16;
        if (convertView == null) {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            imageView.setContentDescription(this.mContext.getString(R.string.ypy));
            EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
            view = imageView;
            if (emoticonPanelAIHelper != null) {
                final AiPanelInfo aiPanelInfo = emoticonPanelAIHelper.getAiPanelInfo();
                view = imageView;
                if (aiPanelInfo != null) {
                    String posterImage = aiPanelInfo.getPosterImage();
                    if (aiPanelInfo.getPosterApng().length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    updateImageView(imageView, posterImage, z16, aiPanelInfo.getPosterApng());
                    view = imageView;
                    if (aiPanelInfo.isPosterPageValid()) {
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.z
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                EmotionAIAdapter.getPosterView$lambda$2$lambda$1(EmotionAIAdapter.this, aiPanelInfo, view2);
                            }
                        });
                        view = imageView;
                    }
                }
            }
        }
        int height = getCurrentListView().getHeight();
        if (height > 0 && height != this.contentHeight) {
            this.contentHeight = height;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.AbsListView.LayoutParams");
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) layoutParams;
            layoutParams2.height = this.contentHeight;
            view.setLayoutParams(layoutParams2);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPosterView$lambda$2$lambda$1(EmotionAIAdapter this$0, AiPanelInfo info, View view) {
        IEmoticonAIManagerService emoticonAIManagerService;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        EmoticonPanelAIHelper.Companion companion = EmoticonPanelAIHelper.INSTANCE;
        Context mContext = this$0.mContext;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        companion.openURL(mContext, info.getPosterPage(), BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
        EmoticonPanelAIHelper emoticonPanelAIHelper = this$0.helper;
        if (emoticonPanelAIHelper != null && (emoticonAIManagerService = emoticonPanelAIHelper.getEmoticonAIManagerService()) != null) {
            emoticonAIManagerService.setForceRequest(true);
        }
        this$0.reportAICreationClick(1);
        QLog.i(TAG, 1, "onPosterClick");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean isShowRedDot(AIEmoticonInfo info) {
        String str;
        boolean z16;
        AiPanelInfo aiPanelInfo;
        AiPanelInfo aiPanelInfo2;
        EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
        if (emoticonPanelAIHelper != null && (aiPanelInfo2 = emoticonPanelAIHelper.getAiPanelInfo()) != null) {
            str = aiPanelInfo2.getBannerRedDotImage();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        EmoticonPanelAIHelper emoticonPanelAIHelper2 = this.helper;
        if (emoticonPanelAIHelper2 != null && (aiPanelInfo = emoticonPanelAIHelper2.getAiPanelInfo()) != null && !Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerRedDotUrl(), aiPanelInfo.getBannerRedDotImage())) {
            return true;
        }
        if (Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerPageUrl(), info.bannerPageUrl) && ((!info.isApng || Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerImageUrl(), info.apngUrl)) && (info.isApng || Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerImageUrl(), info.url)))) {
            return false;
        }
        return true;
    }

    private final void reportAICreationClick(int type) {
        HashMap hashMap = new HashMap();
        hashMap.put("entry_style", Integer.valueOf(type));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_ai_emoji_creation_entrance", hashMap);
    }

    private final void updateBannerCache(AIEmoticonInfo info) {
        AiPanelInfo aiPanelInfo;
        EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
        if (emoticonPanelAIHelper != null && (aiPanelInfo = emoticonPanelAIHelper.getAiPanelInfo()) != null && !Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerRedDotUrl(), aiPanelInfo.getBannerRedDotImage())) {
            EmoticonUtils.setEmoAIItemBannerRedDotUrl(aiPanelInfo.getBannerRedDotImage());
        }
        if (!Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerPageUrl(), info.bannerPageUrl)) {
            EmoticonUtils.setEmoAIItemBannerPageUrl(info.bannerPageUrl);
        }
        if (!info.isApng && !Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerImageUrl(), info.url)) {
            EmoticonUtils.setEmoAIItemBannerImageUrl(info.url);
        }
        if (info.isApng && !Intrinsics.areEqual(EmoticonUtils.getEmoAIItemBannerImageUrl(), info.apngUrl)) {
            EmoticonUtils.setEmoAIItemBannerImageUrl(info.apngUrl);
        }
    }

    private final void updateBannerView(RelativeLayout contentView, final AIEmoticonInfo info) {
        String str;
        AiPanelInfo aiPanelInfo;
        final ImageView labelView = (ImageView) contentView.findViewById(R.id.f164080sg0);
        if (isShowRedDot(info)) {
            Intrinsics.checkNotNullExpressionValue(labelView, "labelView");
            EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
            if (emoticonPanelAIHelper == null || (aiPanelInfo = emoticonPanelAIHelper.getAiPanelInfo()) == null || (str = aiPanelInfo.getBannerRedDotImage()) == null) {
                str = LABEL_IMAGE_URL;
            }
            updateImageView$default(this, labelView, str, false, null, 12, null);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.u
            @Override // java.lang.Runnable
            public final void run() {
                EmotionAIAdapter.updateBannerView$lambda$8(EmotionAIAdapter.this, info);
            }
        }, 16, null, true);
        contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionAIAdapter.updateBannerView$lambda$9(labelView, this, info, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBannerView$lambda$8(EmotionAIAdapter this$0, AIEmoticonInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.updateBannerCache(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBannerView$lambda$9(ImageView imageView, EmotionAIAdapter this$0, AIEmoticonInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        EmoticonPanelAIHelper.Companion companion = EmoticonPanelAIHelper.INSTANCE;
        Context mContext = this$0.mContext;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        String str = info.bannerPageUrl;
        Intrinsics.checkNotNullExpressionValue(str, "info.bannerPageUrl");
        companion.openURL(mContext, str, BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
        this$0.reportAICreationClick(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0063, code lost:
    
        if (r4.isEmptyList() == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateImageView(ImageView view, String url, boolean isApng, String apngUrl) {
        boolean z16;
        if (isApng) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mRequestWidth = view.getWidth();
            obtain.mRequestHeight = view.getHeight();
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(drawable);
            apngOptions.setRequestWidth(view.getWidth());
            apngOptions.setRequestHeight(view.getHeight());
            view.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(TAG, apngUrl, apngOptions));
            return;
        }
        Option url2 = Option.obtain().setTargetView(view).setUrl(url);
        EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
        if (emoticonPanelAIHelper != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            url2.setLoadingDrawable(new ColorDrawable(0));
            url2.setFailedDrawable(new ColorDrawable(0));
        }
        QQPicLoader.f201806a.d().loadImage(url2, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.aa
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                EmotionAIAdapter.updateImageView$lambda$12(loadState, option);
            }
        });
    }

    static /* synthetic */ void updateImageView$default(EmotionAIAdapter emotionAIAdapter, ImageView imageView, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        emotionAIAdapter.updateImageView(imageView, str, z16, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateImageView$lambda$12(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e(TAG, 1, "updateImageView state:" + loadState + "  listenerOption:" + option);
        }
    }

    private final void updateUI(RelativeLayout contentView, EmotionPanelData info) {
        final AIEmoticonInfo aIEmoticonInfo;
        contentView.setTag(info);
        contentView.setVisibility(0);
        ImageView emoticonImg = (ImageView) contentView.findViewById(R.id.sfz);
        if (emoticonImg.getTag(R.id.kxb) == info) {
            return;
        }
        emoticonImg.setTag(R.id.kxb, info);
        emoticonImg.setVisibility(0);
        if (info instanceof AIEmoticonInfo) {
            aIEmoticonInfo = (AIEmoticonInfo) info;
        } else {
            aIEmoticonInfo = null;
        }
        if (aIEmoticonInfo != null) {
            if (aIEmoticonInfo.itemType == 1) {
                Intrinsics.checkNotNullExpressionValue(emoticonImg, "emoticonImg");
                String str = aIEmoticonInfo.url;
                Intrinsics.checkNotNullExpressionValue(str, "it.url");
                boolean z16 = aIEmoticonInfo.isApng;
                String str2 = aIEmoticonInfo.apngUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "it.apngUrl");
                updateImageView(emoticonImg, str, z16, str2);
                updateBannerView(contentView, aIEmoticonInfo);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(emoticonImg, "emoticonImg");
            String str3 = aIEmoticonInfo.url;
            Intrinsics.checkNotNullExpressionValue(str3, "it.url");
            updateImageView$default(this, emoticonImg, str3, false, null, 8, null);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.w
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionAIAdapter.updateUI$lambda$7$lambda$6(EmotionAIAdapter.this, aIEmoticonInfo);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$7$lambda$6(EmotionAIAdapter this$0, AIEmoticonInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        String str = it.url;
        Intrinsics.checkNotNullExpressionValue(str, "it.url");
        this$0.downloadPreviewResource(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
        boolean z16 = false;
        if (emoticonPanelAIHelper != null && emoticonPanelAIHelper.isEmptyList()) {
            z16 = true;
        }
        if (z16) {
            return 1;
        }
        return super.getCount();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    @NotNull
    public View getEmotionView(@Nullable BaseEmotionAdapter.ViewHolder viewHolder, int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, viewHolder, Integer.valueOf(position), convertView, parent);
        }
        int itemViewType = getItemViewType(position);
        if (itemViewType != 2) {
            if (itemViewType != 3) {
                return getNormalView(viewHolder, position, convertView);
            }
            return getGeneratingView(convertView);
        }
        return getPosterView(convertView);
    }

    @Nullable
    public final IPanelInteractionListener getInteractionListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPanelInteractionListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.interactionListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        boolean z16;
        boolean z17;
        AiPanelInfo aiPanelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, position)).intValue();
        }
        EmoticonPanelAIHelper emoticonPanelAIHelper = this.helper;
        boolean z18 = true;
        if (emoticonPanelAIHelper != null && emoticonPanelAIHelper.isEmptyList()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            EmoticonPanelAIHelper emoticonPanelAIHelper2 = this.helper;
            if (emoticonPanelAIHelper2 == null || !emoticonPanelAIHelper2.isGenerating()) {
                z18 = false;
            }
            if (z18) {
                return 3;
            }
            return 2;
        }
        EmoticonPanelAIHelper emoticonPanelAIHelper3 = this.helper;
        if (emoticonPanelAIHelper3 != null && (aiPanelInfo = emoticonPanelAIHelper3.getAiPanelInfo()) != null && aiPanelInfo.isBannerConfigValid()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && position == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r14v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r14v5, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup, com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout] */
    @NotNull
    public final View getNormalView(@Nullable BaseEmotionAdapter.ViewHolder viewHolder, int position, @Nullable View convertView) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        int i3;
        boolean z16;
        boolean z17;
        AIEmoticonInfo aIEmoticonInfo;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, viewHolder, Integer.valueOf(position), convertView);
        }
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.EmotionAIAdapter.AIEmoticonViewHolder");
        AIEmoticonViewHolder aIEmoticonViewHolder = (AIEmoticonViewHolder) viewHolder;
        View view = convertView;
        if (convertView == null) {
            EmoticonPanelLinearLayout view2 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (view2 == 0) {
                view2 = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.interactionListener), -1);
                view2.setPanelType(7);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                view2.setOrientation(0);
                if (position == 0) {
                    i3 = 12;
                } else {
                    i3 = 6;
                }
                float f16 = this.density;
                view2.setPadding(0, (int) (i3 * f16), 0, (int) (6 * f16));
                if (getItemViewType(position) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int i16 = this.columnNum;
                for (int i17 = 0; i17 < i16; i17++) {
                    int i18 = (this.columnNum * position) + i17;
                    if (i18 < this.data.size() && z16) {
                        EmotionPanelData emotionPanelData = this.data.get(i18);
                        if (emotionPanelData instanceof AIEmoticonInfo) {
                            aIEmoticonInfo = (AIEmoticonInfo) emotionPanelData;
                        } else {
                            aIEmoticonInfo = null;
                        }
                        if (aIEmoticonInfo != null && aIEmoticonInfo.itemType == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            z17 = true;
                            RelativeLayout aIView = getAIView(z17);
                            aIView.setVisibility(8);
                            aIView.setFocusable(true);
                            aIView.setFocusableInTouchMode(true);
                            view2.addView(aIView);
                        }
                    }
                    z17 = false;
                    RelativeLayout aIView2 = getAIView(z17);
                    aIView2.setVisibility(8);
                    aIView2.setFocusable(true);
                    aIView2.setFocusableInTouchMode(true);
                    view2.addView(aIView2);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + position + "; view from cache");
            }
            EmoticonPanelLinearLayout emoticonPanelLinearLayout = view2;
            emoticonPanelLinearLayout.setCallBack(this.callback);
            emoticonPanelLinearLayout.setInterceptListener(this.interceptListener);
            recycleView(this.panelType, view2);
            ViewGroup viewGroup = view2;
            aIEmoticonViewHolder.setContentViews(new RelativeLayout[this.columnNum]);
            int i19 = this.columnNum;
            for (int i26 = 0; i26 < i19; i26++) {
                RelativeLayout[] contentViews = aIEmoticonViewHolder.getContentViews();
                if (contentViews != null) {
                    View childAt = viewGroup.getChildAt(i26);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.RelativeLayout");
                    contentViews[i26] = (RelativeLayout) childAt;
                }
            }
            emoticonPanelLinearLayout.setTag(aIEmoticonViewHolder);
            view = view2;
        }
        int i27 = this.columnNum;
        for (int i28 = 0; i28 < i27; i28++) {
            int i29 = (this.columnNum * position) + i28;
            if (i29 > this.data.size() - 1) {
                RelativeLayout[] contentViews2 = aIEmoticonViewHolder.getContentViews();
                if (contentViews2 != null) {
                    relativeLayout2 = contentViews2[i28];
                } else {
                    relativeLayout2 = null;
                }
                if (relativeLayout2 != null) {
                    relativeLayout2.setTag(null);
                }
                RelativeLayout[] contentViews3 = aIEmoticonViewHolder.getContentViews();
                if (contentViews3 != null) {
                    relativeLayout3 = contentViews3[i28];
                } else {
                    relativeLayout3 = null;
                }
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                }
            } else {
                RelativeLayout[] contentViews4 = aIEmoticonViewHolder.getContentViews();
                if (contentViews4 != null && (relativeLayout = contentViews4[i28]) != null) {
                    updateUI(relativeLayout, this.data.get(i29));
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return 4;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    @NotNull
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new AIEmoticonViewHolder();
    }
}
