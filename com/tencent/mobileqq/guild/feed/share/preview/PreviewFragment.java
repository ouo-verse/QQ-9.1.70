package com.tencent.mobileqq.guild.feed.share.preview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.contentshare.widget.BounceScrollView;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/preview/PreviewFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "initView", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Object;", "getShareData", "()Ljava/lang/Object;", "setShareData", "(Ljava/lang/Object;)V", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/d;", "D", "Lcom/tencent/mobileqq/guild/contentshare/d;", "getShareInfo", "()Lcom/tencent/mobileqq/guild/contentshare/d;", "qh", "(Lcom/tencent/mobileqq/guild/contentshare/d;)V", "shareInfo", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PreviewFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int F;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Object shareData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private d shareInfo;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/preview/PreviewFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.share.preview.PreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            Intent intent = new Intent();
            intent.putExtras(bundle);
            Unit unit = Unit.INSTANCE;
            GuildSplitViewUtils.p(guildSplitViewUtils, context, intent, PreviewFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/share/preview/PreviewFragment$b", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "Landroid/view/View;", "Lkotlin/Result;", "result", "", "onResult", "(Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IFeedSharePreviewApi.a<View> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BounceScrollView f223434a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFeedDetailDataParser f223435b;

        b(BounceScrollView bounceScrollView, IFeedDetailDataParser iFeedDetailDataParser) {
            this.f223434a = bounceScrollView;
            this.f223435b = iFeedDetailDataParser;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi.a
        public void onResult(@NotNull Object result) {
            if (Result.m483isSuccessimpl(result)) {
                if (Result.m482isFailureimpl(result)) {
                    result = null;
                }
                View view = (View) result;
                if (view == null) {
                    return;
                }
                view.setScaleX(0.6f);
                view.setScaleY(0.6f);
                Logger logger = Logger.f235387a;
                IFeedDetailDataParser iFeedDetailDataParser = this.f223435b;
                logger.d().i(QPublicBaseFragment.TAG, 1, "onResult: " + iFeedDetailDataParser.getFeedId() + ", " + m.a(view));
                this.f223434a.removeAllViews();
                this.f223434a.addView(view, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/share/preview/PreviewFragment$c", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "Landroid/graphics/Bitmap;", "Lkotlin/Result;", "result", "", "onResult", "(Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements IFeedSharePreviewApi.a<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BounceScrollView f223436a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFeedDetailDataParser f223437b;

        c(BounceScrollView bounceScrollView, IFeedDetailDataParser iFeedDetailDataParser) {
            this.f223436a = bounceScrollView;
            this.f223437b = iFeedDetailDataParser;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi.a
        public void onResult(@NotNull Object result) {
            if (Result.m483isSuccessimpl(result)) {
                if (Result.m482isFailureimpl(result)) {
                    result = null;
                }
                Bitmap bitmap = (Bitmap) result;
                if (bitmap == null) {
                    return;
                }
                Logger logger = Logger.f235387a;
                IFeedDetailDataParser iFeedDetailDataParser = this.f223437b;
                logger.d().i(QPublicBaseFragment.TAG, 1, "onResult: " + iFeedDetailDataParser.getFeedId() + ", " + m.a(bitmap));
                ImageView imageView = new ImageView(this.f223436a.getContext());
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                imageView.setImageBitmap(bitmap);
                this.f223436a.removeAllViews();
                this.f223436a.addView(imageView);
            }
        }
    }

    private final void initData() {
        Bundle bundle = requireArguments().getBundle("guild_content_share_bundle_key");
        if (bundle != null) {
            this.shareData = bundle.getSerializable("guild_content_share_data_key");
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putBoolean("force_bottom_platform_item_name_color_white", bundle.getBoolean("force_bottom_platform_item_name_color_white"));
            }
        }
        xg1.b.f447962a.i(bundle, 1, new PreviewFragment$initData$2(this));
        QLog.i(QPublicBaseFragment.TAG, 1, "onAttach");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        IFeedDetailDataParser iFeedDetailDataParser;
        d dVar = this.shareInfo;
        if (dVar == null) {
            return;
        }
        Object data = dVar.getData();
        if (data instanceof IFeedDetailDataParser) {
            iFeedDetailDataParser = (IFeedDetailDataParser) data;
        } else {
            iFeedDetailDataParser = null;
        }
        if (iFeedDetailDataParser == null) {
            return;
        }
        View requireView = requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.contentshare.widget.BounceScrollView");
        BounceScrollView bounceScrollView = (BounceScrollView) requireView;
        int i3 = F;
        F = i3 + 1;
        if (i3 % 2 == 0) {
            IFeedSharePreviewApi iFeedSharePreviewApi = (IFeedSharePreviewApi) QRoute.api(IFeedSharePreviewApi.class);
            Context context = bounceScrollView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "scrollView.context");
            IGProGuildInfo L = ch.L(dVar.getChannelInfo().getGuildId());
            Intrinsics.checkNotNullExpressionValue(L, "getGuildInfo(shareInfo.channelInfo.guildId)");
            iFeedSharePreviewApi.requestView(context, new IFeedSharePreviewApi.ReqParams(L, iFeedDetailDataParser, dVar.getChannelInfo().getShareUrl(), false), new b(bounceScrollView, iFeedDetailDataParser));
            return;
        }
        IFeedSharePreviewApi iFeedSharePreviewApi2 = (IFeedSharePreviewApi) QRoute.api(IFeedSharePreviewApi.class);
        Context context2 = bounceScrollView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "scrollView.context");
        IGProGuildInfo L2 = ch.L(dVar.getChannelInfo().getGuildId());
        Intrinsics.checkNotNullExpressionValue(L2, "getGuildInfo(shareInfo.channelInfo.guildId)");
        iFeedSharePreviewApi2.requestBitmap(context2, new IFeedSharePreviewApi.ReqParams(L2, iFeedDetailDataParser, dVar.getChannelInfo().getShareUrl(), false), new c(bounceScrollView, iFeedDetailDataParser));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es8;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        initData();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    public final void qh(@Nullable d dVar) {
        this.shareInfo = dVar;
    }
}
