package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService;
import com.tencent.mobileqq.emoticonview.ai.emoticon.AiPanelInfo;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.AIGCEmoji;
import com.tencent.qqnt.kernel.nativeinterface.AIGCEmojiListInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAIGCEmojiListReq;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 H2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001HB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J&\u0010.\u001a\u00020!2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u000f\u00101\u001a\u0004\u0018\u00010%H\u0002\u00a2\u0006\u0002\u00102J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020+H\u0016J\u0006\u00105\u001a\u00020+J\b\u00106\u001a\u000207H\u0016J\u0006\u00108\u001a\u00020!J\u0006\u0010 \u001a\u00020!J\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020!H\u0002J\u0010\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020:2\u0006\u0010=\u001a\u00020\bH\u0002J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020:H\u0016J\u000e\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020'J\b\u0010D\u001a\u00020:H\u0002J\u001a\u0010E\u001a\u00020:2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010F\u001a\u00020:H\u0002J\b\u0010G\u001a\u00020:H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmoticonPanelAIHelper;", "Lcom/tencent/mobileqq/emoticonview/AbstractEmoticonPanelHelper;", "Lcom/tencent/mobileqq/emoticonview/EmoticonPanelController;", "panelController", "(Lcom/tencent/mobileqq/emoticonview/EmoticonPanelController;)V", "adapter", "Lcom/tencent/mobileqq/emoticonview/BaseEmotionAdapter;", "aiPanelInfo", "Lcom/tencent/mobileqq/emoticonview/ai/emoticon/AiPanelInfo;", "getAiPanelInfo", "()Lcom/tencent/mobileqq/emoticonview/ai/emoticon/AiPanelInfo;", "aiPanelInfo$delegate", "Lkotlin/Lazy;", "bannerInfo", "Lcom/tencent/mobileqq/emoticonview/AIEmoticonInfo;", "getBannerInfo", "()Lcom/tencent/mobileqq/emoticonview/AIEmoticonInfo;", "bannerInfo$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "emoticonAIManagerService", "Lcom/tencent/mobileqq/emosm/api/IEmoticonAIManagerService;", "getEmoticonAIManagerService", "()Lcom/tencent/mobileqq/emosm/api/IEmoticonAIManagerService;", "emoticonAIManagerService$delegate", "emotionPanelDataList", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "headerView", "Landroid/view/View;", "isGenerating", "", "lastGetListTime", "", "lastReportBannerEntryType", "", "listView", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelListView;", "needReportBannerImp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "templateSchema", "", "tvAIPageEntry", "Landroid/widget/TextView;", "areListsEquals", "oldData", "newData", "getBannerEntryType", "()Ljava/lang/Integer;", "getHeaderView", "getTag", "getTemplateSchema", "interestedIn", "", "isEmptyList", "loadPicData", "", "needReportCreationImp", "onHeaderLeftAreaClick", "info", "onManagerAreaClick", "onPageSelected", "position", "onShow", "removeHeaderView", "view", "reportAICreationImp", "setListViewAndAdapter", "updateHeader", "updatePanel", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonPanelAIHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String DEFAULT_CONFIG = "\n            {\n            \"main_page\": \"https://qun.qq.com/ai-emoji-store/index.html?_wwv=8192&_wv=16777219&page_from=3\",\n            \"setting_page\": \"https://qun.qq.com/ai-emoji-store/index.html?activity=1&from=1&_wwv=8192&_wv=16777216#/emoji_package\",\n            \"poster_image\": \"https://static-res.qq.com/static-res/aio/emoticon/emoticon_ai_poster_0001.png\",\n            \"poster_page\": \"https://qun.qq.com/ai-emoji-store/index.html?_wwv=8192&_wv=16777219&page_from=3&template_id=10\",\n            \"banner_image\": \"\",\n            \"banner_page\": \"\",\n            \"refresh_time_step\": 3600\n            }\n        ";
    private static final int GET_LIST_INTERVAL = 1000;

    @NotNull
    private static final String HTTPS_PREFIX = "https://";

    @NotNull
    private static final String HTTP_PREFIX = "http://";
    private static final int MAX_PAGE_SIZE = 500;
    private static final int SORT_MODE_BY_PANEL = 1;

    @NotNull
    private static final String TAG = "EmoticonPanelAIHelper";

    @Nullable
    private BaseEmotionAdapter adapter;

    /* renamed from: aiPanelInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiPanelInfo;

    /* renamed from: bannerInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerInfo;

    /* renamed from: emoticonAIManagerService$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy emoticonAIManagerService;

    @Nullable
    private List<? extends EmotionPanelData> emotionPanelDataList;

    @Nullable
    private View headerView;
    private volatile boolean isGenerating;
    private long lastGetListTime;
    private int lastReportBannerEntryType;

    @Nullable
    private EmotionPanelListView listView;

    @NotNull
    private AtomicBoolean needReportBannerImp;

    @NotNull
    private volatile String templateSchema;

    @Nullable
    private TextView tvAIPageEntry;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmoticonPanelAIHelper$Companion;", "", "()V", "DEFAULT_CONFIG", "", "GET_LIST_INTERVAL", "", "HTTPS_PREFIX", "HTTP_PREFIX", "MAX_PAGE_SIZE", "SORT_MODE_BY_PANEL", "TAG", "openURL", "", "context", "Landroid/content/Context;", "url", "requestCode", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void openURL(@NotNull Context context, @NotNull String url, int requestCode) {
            Activity activity;
            boolean startsWith$default;
            boolean startsWith$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, url, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                String lowerCase = url.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
                if (!startsWith$default) {
                    String lowerCase2 = url.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase2, "https://", false, 2, null);
                    if (!startsWith$default2) {
                        Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                        intent.setData(Uri.parse(url));
                        if (!TextUtils.isEmpty(url)) {
                            activity.startActivityForResult(intent, requestCode);
                            return;
                        }
                        return;
                    }
                }
                Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", url);
                activity.startActivityForResult(intent2, requestCode);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonPanelAIHelper(@Nullable EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(EmoticonPanelAIHelper$aiPanelInfo$2.INSTANCE);
            this.aiPanelInfo = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(EmoticonPanelAIHelper$emoticonAIManagerService$2.INSTANCE);
            this.emoticonAIManagerService = lazy2;
            this.templateSchema = "";
            this.needReportBannerImp = new AtomicBoolean(false);
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<AIEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelAIHelper$bannerInfo$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelAIHelper.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIEmoticonInfo invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIEmoticonInfo) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIEmoticonInfo aIEmoticonInfo = new AIEmoticonInfo();
                    EmoticonPanelAIHelper emoticonPanelAIHelper = EmoticonPanelAIHelper.this;
                    aIEmoticonInfo.type = 20;
                    aIEmoticonInfo.itemType = 1;
                    AiPanelInfo aiPanelInfo = emoticonPanelAIHelper.getAiPanelInfo();
                    if (aiPanelInfo != null) {
                        aIEmoticonInfo.url = aiPanelInfo.getBannerImage();
                        aIEmoticonInfo.apngUrl = aiPanelInfo.getBannerApng();
                        aIEmoticonInfo.bannerPageUrl = aiPanelInfo.getBannerPage();
                        aIEmoticonInfo.isApng = aiPanelInfo.isApngBanner();
                    }
                    return aIEmoticonInfo;
                }
            });
            this.bannerInfo = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
    }

    private final boolean areListsEquals(List<? extends EmotionPanelData> oldData, List<? extends EmotionPanelData> newData) {
        if (oldData == null || oldData.size() != newData.size()) {
            return false;
        }
        int size = oldData.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(oldData.get(i3), newData.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private final Integer getBannerEntryType() {
        boolean z16 = true;
        if (isEmptyList()) {
            return 1;
        }
        if (!isEmptyList()) {
            AiPanelInfo aiPanelInfo = getAiPanelInfo();
            if (aiPanelInfo == null || !aiPanelInfo.isBannerConfigValid()) {
                z16 = false;
            }
            if (z16) {
                return 2;
            }
        }
        return null;
    }

    private final AIEmoticonInfo getBannerInfo() {
        return (AIEmoticonInfo) this.bannerInfo.getValue();
    }

    private final View getHeaderView() {
        View findViewById;
        View view = this.headerView;
        if (view == null) {
            view = View.inflate(getContext(), R.layout.f168902h80, null);
            Intrinsics.checkNotNull(view);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.tvAIPageEntry = (TextView) view.findViewById(R.id.f1059267b);
            final AiPanelInfo aiPanelInfo = getAiPanelInfo();
            if (aiPanelInfo != null) {
                View findViewById2 = view.findViewById(R.id.ye7);
                if (findViewById2 != null) {
                    findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            EmoticonPanelAIHelper.getHeaderView$lambda$9$lambda$7(EmoticonPanelAIHelper.this, aiPanelInfo, view2);
                        }
                    });
                }
                if (aiPanelInfo.isSettingPageValid() && (findViewById = view.findViewById(R.id.f107656b0)) != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.h
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            EmoticonPanelAIHelper.getHeaderView$lambda$9$lambda$8(EmoticonPanelAIHelper.this, aiPanelInfo, view2);
                        }
                    });
                }
            }
            this.headerView = view;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHeaderView$lambda$9$lambda$7(EmoticonPanelAIHelper this$0, AiPanelInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.onHeaderLeftAreaClick(info);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHeaderView$lambda$9$lambda$8(EmoticonPanelAIHelper this$0, AiPanelInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.onManagerAreaClick(info);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadPicData$lambda$4(final EmoticonPanelAIHelper this$0, boolean z16, AIGCEmojiListInfo aIGCEmojiListInfo) {
        boolean z17;
        Integer num;
        List<? extends EmotionPanelData> list;
        List<EmotionPanelData> list2;
        IEmoticonAIManagerService emoticonAIManagerService;
        List<EmotionPanelData> list3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aIGCEmojiListInfo == null) {
            QLog.i(TAG, 1, "getAIGCEmojiList emojiListInfo is null");
            return;
        }
        boolean z18 = this$0.isGenerating;
        boolean z19 = aIGCEmojiListInfo.generating;
        boolean z26 = false;
        if (z18 != z19) {
            z17 = true;
        } else {
            z17 = false;
        }
        this$0.isGenerating = z19;
        String str = aIGCEmojiListInfo.templateSchema;
        if (str == null) {
            str = "";
        }
        this$0.templateSchema = str;
        boolean z27 = this$0.isGenerating;
        ArrayList<AIGCEmoji> arrayList = aIGCEmojiListInfo.emojis;
        Integer num2 = null;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.i(TAG, 1, "IGetAIGCEmojiListCallback  generating:" + z27 + " generatingStatusChanged:" + z17 + ", emojiListInfo.size:" + num);
        final ArrayList arrayList2 = new ArrayList();
        Iterator<AIGCEmoji> it = aIGCEmojiListInfo.emojis.iterator();
        while (it.hasNext()) {
            AIGCEmoji next = it.next();
            AIEmoticonInfo aIEmoticonInfo = new AIEmoticonInfo();
            aIEmoticonInfo.type = 20;
            aIEmoticonInfo.url = next.url;
            aIEmoticonInfo.md5 = next.md5;
            aIEmoticonInfo.templateId = next.templateId;
            aIEmoticonInfo.drawableId = R.drawable.j6g;
            aIEmoticonInfo.refId = next.refId;
            arrayList2.add(aIEmoticonInfo);
        }
        AiPanelInfo aiPanelInfo = this$0.getAiPanelInfo();
        if (aiPanelInfo != null && aiPanelInfo.isBannerConfigValid()) {
            z26 = true;
        }
        if (z26) {
            BaseEmotionAdapter baseEmotionAdapter = this$0.adapter;
            if (baseEmotionAdapter != null && (list3 = baseEmotionAdapter.data) != null) {
                list = CollectionsKt___CollectionsKt.drop(list3, 1);
            }
            list = null;
        } else {
            BaseEmotionAdapter baseEmotionAdapter2 = this$0.adapter;
            if (baseEmotionAdapter2 != null) {
                list = baseEmotionAdapter2.data;
            }
            list = null;
        }
        if (this$0.areListsEquals(list, arrayList2) && this$0.emotionPanelDataList != null) {
            if (z17) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonPanelAIHelper.loadPicData$lambda$4$lambda$3(EmoticonPanelAIHelper.this);
                    }
                });
            }
        } else {
            BaseEmotionAdapter baseEmotionAdapter3 = this$0.adapter;
            if (baseEmotionAdapter3 != null && (list2 = baseEmotionAdapter3.data) != null) {
                num2 = Integer.valueOf(list2.size());
            }
            QLog.i(TAG, 1, "data change, old data size:" + num2 + ", new data size:" + arrayList2.size());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.d
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonPanelAIHelper.loadPicData$lambda$4$lambda$2(EmoticonPanelAIHelper.this, arrayList2);
                }
            });
        }
        if (z16 && (emoticonAIManagerService = this$0.getEmoticonAIManagerService()) != null) {
            emoticonAIManagerService.setLastRefreshTimeStamp(System.currentTimeMillis());
        }
        IEmoticonAIManagerService emoticonAIManagerService2 = this$0.getEmoticonAIManagerService();
        if (emoticonAIManagerService2 != null) {
            emoticonAIManagerService2.setForceRequest(aIGCEmojiListInfo.generating);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadPicData$lambda$4$lambda$2(EmoticonPanelAIHelper this$0, ArrayList panelData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(panelData, "$panelData");
        this$0.emotionPanelDataList = panelData;
        this$0.updatePanel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadPicData$lambda$4$lambda$3(EmoticonPanelAIHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseEmotionAdapter baseEmotionAdapter = this$0.adapter;
        if (baseEmotionAdapter != null) {
            baseEmotionAdapter.notifyDataSetChanged();
        }
    }

    private final boolean needReportCreationImp() {
        if (!this.needReportBannerImp.getAndSet(false)) {
            Integer bannerEntryType = getBannerEntryType();
            if (bannerEntryType == null) {
                return false;
            }
            if (bannerEntryType.intValue() == this.lastReportBannerEntryType) {
                return false;
            }
        }
        return true;
    }

    private final void onHeaderLeftAreaClick(AiPanelInfo info) {
        boolean z16 = true;
        QLog.i(TAG, 1, "onHeaderLeftAreaClick - isGenerating\uff1a" + this.isGenerating);
        if (this.isGenerating) {
            if (this.templateSchema.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                INSTANCE.openURL(getContext(), this.templateSchema, BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
            }
        } else if (info.isMainPageValid()) {
            INSTANCE.openURL(getContext(), info.getMainPage(), BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
            IEmoticonAIManagerService emoticonAIManagerService = getEmoticonAIManagerService();
            if (emoticonAIManagerService != null) {
                emoticonAIManagerService.setForceRequest(true);
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800C60B", "0X800C60B", 0, 0, "", "", "", "");
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_emoji_aking_entry");
    }

    private final void onManagerAreaClick(AiPanelInfo info) {
        INSTANCE.openURL(getContext(), info.getSettingPage(), BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY);
        ReportController.o(null, "dc00898", "", "", "0X800C60C", "0X800C60C", 0, 0, "", "", "", "");
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_ai_emoji_manage");
        IEmoticonAIManagerService emoticonAIManagerService = getEmoticonAIManagerService();
        if (emoticonAIManagerService != null) {
            emoticonAIManagerService.setForceRequest(true);
        }
        QLog.i(TAG, 1, "openSettingPage  setForceRequest");
    }

    private final void reportAICreationImp() {
        Integer bannerEntryType;
        if (needReportCreationImp() && (bannerEntryType = getBannerEntryType()) != null) {
            int intValue = bannerEntryType.intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("entry_style", Integer.valueOf(intValue));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_ai_emoji_creation_entrance", hashMap);
            this.lastReportBannerEntryType = intValue;
        }
    }

    private final void updateHeader() {
        EmotionPanelListView emotionPanelListView = this.listView;
        if (emotionPanelListView != null) {
            if (isEmptyList()) {
                removeHeaderView(emotionPanelListView);
                return;
            }
            boolean z16 = false;
            if (this.emotionPanelDataList != null && (!r1.isEmpty())) {
                z16 = true;
            }
            if (z16 && emotionPanelListView.getHeaderViewsCount() == 0) {
                emotionPanelListView.addHeaderView(getHeaderView());
            }
            if (this.isGenerating) {
                TextView textView = this.tvAIPageEntry;
                if (textView != null) {
                    textView.setText(R.string.ypv);
                    return;
                }
                return;
            }
            TextView textView2 = this.tvAIPageEntry;
            if (textView2 != null) {
                textView2.setText(R.string.ypy);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updatePanel() {
        AiPanelInfo aiPanelInfo = getAiPanelInfo();
        boolean z16 = false;
        if (aiPanelInfo != null && aiPanelInfo.isBannerConfigValid()) {
            z16 = true;
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            List<? extends EmotionPanelData> list = this.emotionPanelDataList;
            if (list != null) {
                arrayList.add(getBannerInfo());
                arrayList.addAll(list);
            }
            BaseEmotionAdapter baseEmotionAdapter = this.adapter;
            if (baseEmotionAdapter != null) {
                baseEmotionAdapter.setData(arrayList);
            }
        } else {
            BaseEmotionAdapter baseEmotionAdapter2 = this.adapter;
            if (baseEmotionAdapter2 != 0) {
                baseEmotionAdapter2.setData(this.emotionPanelDataList);
            }
        }
        updateHeader();
        reportAICreationImp();
    }

    @Nullable
    public final AiPanelInfo getAiPanelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AiPanelInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (AiPanelInfo) this.aiPanelInfo.getValue();
    }

    @NotNull
    public final Context getContext() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        EmoticonPanelController emoticonPanelController = (EmoticonPanelController) this.mPanelController;
        if (emoticonPanelController != null) {
            context = emoticonPanelController.context;
        } else {
            context = null;
        }
        if (context == null) {
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            return context2;
        }
        return context;
    }

    @Nullable
    public final IEmoticonAIManagerService getEmoticonAIManagerService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IEmoticonAIManagerService) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (IEmoticonAIManagerService) this.emoticonAIManagerService.getValue();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return TAG;
    }

    @NotNull
    public final String getTemplateSchema() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.templateSchema;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{5, 3};
    }

    public final boolean isEmptyList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        List<? extends EmotionPanelData> list = this.emotionPanelDataList;
        if (list == null || !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean isGenerating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isGenerating;
    }

    public final void loadPicData() {
        long j3;
        final boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        boolean z17 = false;
        if (this.emotionPanelDataList != null && (!r0.isEmpty())) {
            z17 = true;
        }
        if (z17) {
            updatePanel();
        }
        if (System.currentTimeMillis() - this.lastGetListTime < 1000) {
            QLog.i(TAG, 1, "loadPicData too frequent");
            return;
        }
        this.lastGetListTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.n emojiService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getEmojiService();
        GetAIGCEmojiListReq getAIGCEmojiListReq = new GetAIGCEmojiListReq();
        getAIGCEmojiListReq.pageSize = 500;
        getAIGCEmojiListReq.sortMode = 1;
        AiPanelInfo aiPanelInfo = getAiPanelInfo();
        if (aiPanelInfo != null) {
            j3 = aiPanelInfo.getRefreshTimeStep();
        } else {
            j3 = 3600;
        }
        long j16 = j3 * 1000;
        IEmoticonAIManagerService emoticonAIManagerService = getEmoticonAIManagerService();
        if (emoticonAIManagerService != null) {
            z16 = emoticonAIManagerService.getForceRequest(j16);
        } else {
            z16 = true;
        }
        QLog.i(TAG, 1, "getAIGCEmojiList  force:" + z16);
        if (emojiService != null) {
            emojiService.getAIGCEmojiList(getAIGCEmojiListReq, z16, new IGetAIGCEmojiListCallback() { // from class: com.tencent.mobileqq.emoticonview.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback
                public final void onGetAIGCEmojiList(AIGCEmojiListInfo aIGCEmojiListInfo) {
                    EmoticonPanelAIHelper.loadPicData$lambda$4(EmoticonPanelAIHelper.this, z16, aIGCEmojiListInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int position) {
        int findIndexByPanelType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, position);
            return;
        }
        super.onPageSelected(position);
        EmoticonPanelController emoticonPanelController = (EmoticonPanelController) this.mPanelController;
        if (emoticonPanelController != null && (findIndexByPanelType = emoticonPanelController.findIndexByPanelType(20)) == BasePanelModel.sLastSelectedSecondTabIndex) {
            QLog.i(TAG, 1, "page selected with ai emoticon, loadPicData   indexOfAIEmoticon:" + findIndexByPanelType);
            loadPicData();
            com.tencent.mobileqq.aio.utils.b.f194119a.k(EmotionDaTongReportUtil.EM_BAS_AI_EXPRESSION);
            this.needReportBannerImp.set(true);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        int findIndexByPanelType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onShow();
        EmoticonPanelController emoticonPanelController = (EmoticonPanelController) this.mPanelController;
        if (emoticonPanelController != null && (findIndexByPanelType = emoticonPanelController.findIndexByPanelType(20)) == BasePanelModel.sLastSelectedSecondTabIndex) {
            QLog.i(TAG, 1, "show with ai emoticon, loadPicData   indexOfAIEmoticon:" + findIndexByPanelType);
            loadPicData();
            this.needReportBannerImp.set(true);
        }
    }

    public final void removeHeaderView(@NotNull EmotionPanelListView view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        View view2 = this.headerView;
        if (view2 != null) {
            view.removeHeaderView(view2);
        }
    }

    public final void setListViewAndAdapter(@Nullable EmotionPanelListView listView, @Nullable BaseEmotionAdapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listView, (Object) adapter);
            return;
        }
        if (listView == null || adapter == null) {
            QLog.i(TAG, 1, "listView:" + listView + ", adapter:" + adapter);
        }
        this.listView = listView;
        this.adapter = adapter;
    }
}
