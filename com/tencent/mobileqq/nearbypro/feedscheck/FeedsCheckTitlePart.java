package com.tencent.mobileqq.nearbypro.feedscheck;

import ab2.a;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.feedscheck.FeedsCheckTitlePart;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.nearbypro.profile.basepart.b;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/FeedsCheckTitlePart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Landroid/view/View$OnClickListener;", "", "J9", "", "I9", "Landroid/view/View;", "titleRoot", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "v", NodeProps.ON_CLICK, "f", "Landroid/view/View;", "titleView", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", h.F, "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "userAvatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "userName", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "greeting", "Ljb2/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljb2/a;", ITVKPlayerEventListener.KEY_USER_INFO, "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedsCheckTitlePart extends e implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private UserProfileData userInfo = new UserProfileData(0, "", "", null, 8, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView userAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView userName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView greeting;

    private final long I9() {
        SelfUserInfo selfUserInfo;
        IMapNearbyDataService f16 = a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            return selfUserInfo.getTid();
        }
        return 0L;
    }

    private final void J9() {
        View view = this.titleView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.vsq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "titleView.findViewById(R.id.greeting)");
        ImageView imageView2 = (ImageView) findViewById;
        this.greeting = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("greeting");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: sa2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedsCheckTitlePart.K9(FeedsCheckTitlePart.this, view2);
            }
        });
        ImageView imageView3 = this.greeting;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("greeting");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(FeedsCheckTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
            } else {
                QRouteApi api = QRoute.api(INearbyProPageRouter.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String longToString = StringUtil.longToString(this$0.userInfo.getTinyId());
                Intrinsics.checkNotNullExpressionValue(longToString, "longToString(userInfo.tinyId)");
                INearbyProPageRouter.a.a((INearbyProPageRouter) api, context, longToString, this$0.userInfo.getNickName(), this$0.userInfo.getAvatarUrl(), 20, 0, 32, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9(View titleRoot) {
        ViewGroup.LayoutParams layoutParams;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (titleRoot != null) {
                layoutParams = titleRoot.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            }
            marginLayoutParams.topMargin = statusBarHeight;
            if (titleRoot != null) {
                titleRoot.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(FeedsCheckTitlePart this$0, UserProfileData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.getTinyId() == 0) {
            this$0.z9().bh();
            s.c("id=0\uff0c\u8bf7\u68c0\u67e5\u7528\u6237\u4fe1\u606f");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.userInfo = it;
        TextView textView = this$0.userName;
        RoundRectImageView roundRectImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userName");
            textView = null;
        }
        textView.setText(com.tencent.mobileqq.nearbypro.utils.h.f253950a.e(it.getNickName(), 20));
        String avatarUrl = it.getAvatarUrl();
        RoundRectImageView roundRectImageView2 = this$0.userAvatar;
        if (roundRectImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAvatar");
        } else {
            roundRectImageView = roundRectImageView2;
        }
        PicLoadUtilsKt.c(avatarUrl, roundRectImageView);
        if (it.getTinyId() != this$0.I9()) {
            this$0.J9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        RoundRectImageView roundRectImageView = this.userAvatar;
        TextView textView = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAvatar");
            roundRectImageView = null;
        }
        if (!Intrinsics.areEqual(v3, roundRectImageView)) {
            TextView textView2 = this.userName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userName");
            } else {
                textView = textView2;
            }
            Intrinsics.areEqual(v3, textView);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View inflate = ((ViewStub) rootView.findViewById(R.id.v19)).inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView.findViewById<Vi\u2026eck_title_stub).inflate()");
        this.titleView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            inflate = null;
        }
        final View findViewById = inflate.findViewById(R.id.t2r);
        if (findViewById != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.FeedsCheckTitlePart$onInitView$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    com.tencent.mobileqq.nearbypro.part.a z95;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    z95 = this.z9();
                    z95.bh();
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.FeedsCheckTitlePart$onInitView$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        View view2 = this.titleView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f115206ve);
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById2;
        roundRectImageView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "titleView.findViewById<R\u2026is@FeedsCheckTitlePart) }");
        this.userAvatar = roundRectImageView;
        View view3 = this.titleView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            view = view3;
        }
        View findViewById3 = view.findViewById(R.id.km_);
        TextView textView = (TextView) findViewById3;
        textView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "titleView.findViewById<T\u2026is@FeedsCheckTitlePart) }");
        this.userName = textView;
        ((b) getViewModel(b.class)).O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedsCheckTitlePart.M9(FeedsCheckTitlePart.this, (UserProfileData) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        View view = this.titleView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            view = null;
        }
        L9(view);
    }
}
