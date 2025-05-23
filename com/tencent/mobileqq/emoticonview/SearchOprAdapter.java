package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.IOprCallback;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoBannerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchOprAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hideBanner", "", "oprCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IOprCallback;", "(ZLcom/tencent/mobileqq/emoticonview/searchemo/IOprCallback;)V", "createOprView", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "getItemCount", "", "getSearchEmoBannerInfo", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoBannerInfo;", "context", "Landroid/content/Context;", "needShowBannerInfo", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewType", "openURL", "url", "", "Companion", "OprViewHolder", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchOprAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchOprAdapter";
    private final boolean hideBanner;

    @NotNull
    private final IOprCallback oprCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchOprAdapter$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchOprAdapter$OprViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class OprViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OprViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchOprAdapter(boolean z16, @NotNull IOprCallback oprCallback) {
        Intrinsics.checkNotNullParameter(oprCallback, "oprCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), oprCallback);
        } else {
            this.hideBanner = z16;
            this.oprCallback = oprCallback;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View createOprView(final ViewGroup viewGroup) {
        ConstraintLayout constraintLayout;
        boolean z16;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167934e73, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context)\n\u2026el_opr, viewGroup, false)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.du8);
        if (this.hideBanner) {
            inflate.findViewById(R.id.kw_).setVisibility(0);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.f107646az);
        ((TextView) inflate.findViewById(R.id.f107666b1)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchOprAdapter.createOprView$lambda$1$lambda$0(SearchOprAdapter.this, view);
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.f107656b0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchOprAdapter.createOprView$lambda$3$lambda$2(SearchOprAdapter.this, view);
            }
        });
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        final SearchEmoBannerInfo searchEmoBannerInfo = getSearchEmoBannerInfo(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        boolean z17 = true;
        if (!this.hideBanner) {
            if (searchEmoBannerInfo != null && searchEmoBannerInfo.isBannerValid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (roundCornerImageView != null) {
                    roundCornerImageView.setVisibility(0);
                }
                if (roundCornerImageView != null) {
                    roundCornerImageView.setContentDescription(HardCodeUtil.qqStr(R.string.yqc));
                }
                QQPicLoader.f201806a.d().loadImage(Option.obtain().setTargetView(roundCornerImageView).setUrl(searchEmoBannerInfo.getBannerImage()), null);
                if (roundCornerImageView != null) {
                    roundCornerImageView.setCorner(ViewUtils.dip2px(8.0f));
                }
                if (roundCornerImageView != null) {
                    roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.at
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SearchOprAdapter.createOprView$lambda$4(SearchOprAdapter.this, viewGroup, searchEmoBannerInfo, view);
                        }
                    });
                }
                if (searchEmoBannerInfo != null || !searchEmoBannerInfo.isLeftButtonValid()) {
                    z17 = false;
                }
                if (!z17) {
                    if (textView != null) {
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.au
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SearchOprAdapter.createOprView$lambda$5(SearchOprAdapter.this, viewGroup, searchEmoBannerInfo, view);
                            }
                        });
                    }
                } else {
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    if (inflate instanceof ConstraintLayout) {
                        constraintLayout = (ConstraintLayout) inflate;
                    } else {
                        constraintLayout = null;
                    }
                    if (constraintLayout != null) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(constraintLayout);
                        constraintSet.setHorizontalChainStyle(R.id.f107646az, 0);
                        constraintSet.applyTo(constraintLayout);
                    }
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    }
                    if (marginLayoutParams != null) {
                        marginLayoutParams.rightMargin = 0;
                        textView2.setLayoutParams(marginLayoutParams);
                    }
                }
                return inflate;
            }
        }
        if (roundCornerImageView != null) {
            roundCornerImageView.setVisibility(8);
        }
        if (searchEmoBannerInfo != null) {
        }
        z17 = false;
        if (!z17) {
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOprView$lambda$1$lambda$0(SearchOprAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oprCallback.clickEmoticonShop();
        ReportController.o(null, "dc00898", "", "", "0X800C604", "0X800C604", 0, 0, "", "", "", "");
        EmotionDaTongReportUtil.reportQQClick$default(EmotionDaTongReportUtil.INSTANCE, EmotionDaTongReportUtil.EM_BAS_EMOTICON_MALL, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOprView$lambda$3$lambda$2(SearchOprAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oprCallback.clickEmoticonSetting();
        ReportController.o(null, "dc00898", "", "", "0X800C605", "0X800C605", 0, 0, "", "", "", "");
        EmotionDaTongReportUtil.reportQQClick$default(EmotionDaTongReportUtil.INSTANCE, EmotionDaTongReportUtil.EM_BAS_EMOTE_MANAGE, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOprView$lambda$4(SearchOprAdapter this$0, ViewGroup viewGroup, SearchEmoBannerInfo searchEmoBannerInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        this$0.openURL(context, searchEmoBannerInfo.getBannerUrl());
        ReportController.o(null, "dc00898", "", "", "0X800C602", "0X800C602", 0, 0, "", "", "", "");
        EmotionDaTongReportUtil.reportQQClick$default(EmotionDaTongReportUtil.INSTANCE, EmotionDaTongReportUtil.EM_BAS_BANNER, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOprView$lambda$5(SearchOprAdapter this$0, ViewGroup viewGroup, SearchEmoBannerInfo searchEmoBannerInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        this$0.openURL(context, searchEmoBannerInfo.getLeftButtonUrl());
        ReportController.o(null, "dc00898", "", "", "0X800C603", "0X800C603", 0, 0, "", "", "", "");
        EmotionDaTongReportUtil.reportQQClick$default(EmotionDaTongReportUtil.INSTANCE, EmotionDaTongReportUtil.EM_BAS_AI_EXPRESSION, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final SearchEmoBannerInfo getSearchEmoBannerInfo(Context context) {
        boolean z16;
        if (!needShowBannerInfo(context)) {
            return null;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102449", "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        try {
            return (SearchEmoBannerInfo) new Gson().fromJson(loadAsString, SearchEmoBannerInfo.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean needShowBannerInfo(Context context) {
        int i3;
        AIOContact a16;
        if ((context instanceof FragmentActivity) && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a((FragmentActivity) context)) != null) {
            i3 = a16.e();
        } else {
            i3 = 0;
        }
        QLog.i(TAG, 1, "needShowBannerInfo chatType:" + i3);
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        return true;
    }

    private final void openURL(Context context, String url) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            activity.startActivityForResult(intent, 30007);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, position);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, viewType);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new OprViewHolder(createOprView(viewGroup));
    }
}
