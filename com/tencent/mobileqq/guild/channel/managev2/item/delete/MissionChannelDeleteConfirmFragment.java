package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/MissionChannelDeleteConfirmFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "Lkotlin/Function0;", "", "onConfirmDelete", "vh", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onResume", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "hintTextView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "guideImage", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "iCancelButton", "H", "iDeleteButton", "I", "Lkotlin/jvm/functions/Function0;", "mConfirmClickFunc", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MissionChannelDeleteConfirmFragment extends GuildBaseBottomSheetFragment {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView hintTextView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView guideImage;

    /* renamed from: G, reason: from kotlin metadata */
    private Button iCancelButton;

    /* renamed from: H, reason: from kotlin metadata */
    private Button iDeleteButton;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> mConfirmClickFunc = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.MissionChannelDeleteConfirmFragment$mConfirmClickFunc$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/MissionChannelDeleteConfirmFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "channelId", "Lkotlin/Function0;", "", "onConfirmDelete", "a", "IMG_URL", "Ljava/lang/String;", "IMG_URL_DARK", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.managev2.item.delete.MissionChannelDeleteConfirmFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull Function0<Unit> onConfirmDelete) {
            FragmentActivity fragmentActivity;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(onConfirmDelete, "onConfirmDelete");
            if (activity != null && !activity.isFinishing()) {
                FragmentManager fragmentManager = null;
                if (activity instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) activity;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    fragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                if (fragmentManager != null) {
                    MissionChannelDeleteConfirmFragment missionChannelDeleteConfirmFragment = new MissionChannelDeleteConfirmFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("guildId", guildId);
                    bundle.putString("channelId", channelId);
                    missionChannelDeleteConfirmFragment.setArguments(bundle);
                    missionChannelDeleteConfirmFragment.vh(onConfirmDelete);
                    com.tencent.mobileqq.guild.base.extension.d.a(missionChannelDeleteConfirmFragment, fragmentManager, "MissionChannelDeleteConfirmFragment");
                }
            }
        }

        Companion() {
        }
    }

    private final void initView() {
        String qqStr = HardCodeUtil.qqStr(R.string.f1503414q);
        View view = this.rootView;
        Button button = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.w3g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_delete_confirm_hint)");
        this.hintTextView = (TextView) findViewById;
        SpannableString spannableString = new SpannableString(qqStr);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3AB0FF")), 6, 10, 33);
        TextView textView = this.hintTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTextView");
            textView = null;
        }
        textView.setText(spannableString);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.w3h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026guild_delete_confirm_img)");
        this.guideImage = (ImageView) findViewById2;
        if (GuildThemeManager.f235286a.b()) {
            ImageView imageView = this.guideImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideImage");
                imageView = null;
            }
            u.q("https://downv6.qq.com/innovate/guild/cover_info/mission_channel_delete_confirm_night.png", imageView, true);
        } else {
            ImageView imageView2 = this.guideImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideImage");
                imageView2 = null;
            }
            u.q("https://downv6.qq.com/innovate/guild/cover_info/mission_channel_delete_confirm.png", imageView2, true);
        }
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.afr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.btn_cancel)");
        Button button2 = (Button) findViewById3;
        this.iCancelButton = button2;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCancelButton");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                MissionChannelDeleteConfirmFragment.th(MissionChannelDeleteConfirmFragment.this, view4);
            }
        });
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.agp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.btn_delete)");
        Button button3 = (Button) findViewById4;
        this.iDeleteButton = button3;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iDeleteButton");
        } else {
            button = button3;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                MissionChannelDeleteConfirmFragment.uh(MissionChannelDeleteConfirmFragment.this, view5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(MissionChannelDeleteConfirmFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(MissionChannelDeleteConfirmFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mConfirmClickFunc.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(Function0<Unit> onConfirmDelete) {
        this.mConfirmClickFunc = onConfirmDelete;
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
        View inflate = inflater.inflate(R.layout.f0a, container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_dialog, container, true)");
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
