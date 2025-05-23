package com.tencent.mobileqq.guild.feed.feedsquare.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010 \u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onResume", "", "D", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;", "getCallBack", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;", "callBack", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "closeTv", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "guideImage", "I", "createTv", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;)V", "J", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedCreateNewSectionFragment extends GuildBaseBottomSheetFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b callBack;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView closeTv;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView guideImage;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView createTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;", "", "", NodeProps.ON_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void onClick();
    }

    public GuildFeedCreateNewSectionFragment(@NotNull String guildId, @NotNull b callBack) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.guildId = guildId;
        this.callBack = callBack;
    }

    private final void initView() {
        View view = this.rootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.x3h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_tv_left_gray)");
        TextView textView2 = (TextView) findViewById;
        this.closeTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeTv");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildFeedCreateNewSectionFragment.sh(GuildFeedCreateNewSectionFragment.this, view2);
            }
        });
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.whr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_guide_image)");
        this.guideImage = (ImageView) findViewById2;
        if (GuildThemeManager.f235286a.b()) {
            ImageView imageView = this.guideImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideImage");
                imageView = null;
            }
            u.q("https://downv6.qq.com/innovate/guild/sfeed/feed_square_reversion_guide_dark.png", imageView, true);
        } else {
            ImageView imageView2 = this.guideImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideImage");
                imageView2 = null;
            }
            u.q("https://downv6.qq.com/innovate/guild/sfeed/feed_square_reversion_guide.png", imageView2, true);
        }
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.wkg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.guild_iv_i_know)");
        TextView textView3 = (TextView) findViewById3;
        this.createTv = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createTv");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildFeedCreateNewSectionFragment.th(GuildFeedCreateNewSectionFragment.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildFeedCreateNewSectionFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(GuildFeedCreateNewSectionFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.callBack.onClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setPeekHeight((int) (bi.c() * 0.8f));
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eqz, container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_layout, container, true)");
        this.rootView = inflate;
        initView();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }
}
