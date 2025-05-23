package com.tencent.qqguild.directmessage.aio.title;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqguild.directmessage.aio.title.UIState;
import com.tencent.qqguild.directmessage.aio.title.a;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ak;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00130\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u001b\u0012\u0006\b\u0001\u0012\u00020\u001c0\u00010\u00122\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqguild/directmessage/aio/title/a;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "Lor0/a;", "", "h1", "o1", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$TitleState;", "uiState", "p1", ICustomDataEditor.NUMBER_PARAM_1, "l1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "m1", "", "j1", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/qqguild/directmessage/aio/title/TitleViewModel;", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "hostView", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "bindViewAndData", "onThemeChanged", "state", "k1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvp1/ak;", "d", "Lvp1/ak;", "binding", "Lxs3/c;", "e", "Lxs3/c;", "navigateBackBinder", "", "f", "Ljava/lang/Boolean;", "showAddFriend", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e extends com.tencent.aio.base.mvvm.a<a, UIState> implements or0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ak binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private xs3.c navigateBackBinder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean showAddFriend;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xs3.c cVar = this$0.navigateBackBinder;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigateBackBinder");
            cVar = null;
        }
        cVar.c1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(e this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ak akVar = this$0.binding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        TextView textView = akVar.f442245g;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.guildSelectCancelTv");
        if (textView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.h1();
        } else {
            this$0.sendIntent(a.c.f345146d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C9366a.f345144d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h1() {
        sendIntent(new a.ToggleMultiSelect(false));
    }

    private final int j1() {
        if (QQTheme.isVasTheme()) {
            return R.color.qui_common_icon_nav_secondary;
        }
        return R.color.qui_common_icon_primary;
    }

    private final void l1() {
        ak akVar = this.binding;
        ak akVar2 = null;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        ConstraintLayout root = akVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        m1(root);
        ak akVar3 = this.binding;
        if (akVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar3 = null;
        }
        akVar3.f442242d.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.guild_channel_detail_left_back_icon, Integer.valueOf(j1())));
        ak akVar4 = this.binding;
        if (akVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar4 = null;
        }
        akVar4.f442243e.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.qui_chat_settings, Integer.valueOf(j1())));
        ak akVar5 = this.binding;
        if (akVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            akVar2 = akVar5;
        }
        akVar2.f442240b.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.guild_direct_msg_disturb_icon, Integer.valueOf(j1())));
    }

    private final void m1(View rootView) {
        if (QQTheme.isVasTheme()) {
            rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), R.drawable.skin_header_bar_bg, null));
        } else {
            rootView.setBackgroundColor(ie0.a.f().g(getMContext(), R.color.qui_common_bg_bottom_standard, 1000));
        }
    }

    private final void n1() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.b(hashMap);
        ak akVar = this.binding;
        ak akVar2 = null;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        VideoReport.setElementId(akVar.f442242d, "em_return_button_aio_pg");
        ak akVar3 = this.binding;
        if (akVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar3 = null;
        }
        VideoReport.setElementParams(akVar3.f442242d, hashMap);
        ak akVar4 = this.binding;
        if (akVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar4 = null;
        }
        ImageView imageView = akVar4.f442242d;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        ak akVar5 = this.binding;
        if (akVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar5 = null;
        }
        ImageView imageView2 = akVar5.f442242d;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
        ak akVar6 = this.binding;
        if (akVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar6 = null;
        }
        VideoReport.setElementId(akVar6.f442248j, "em_aio_channel_setting");
        ak akVar7 = this.binding;
        if (akVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar7 = null;
        }
        VideoReport.setElementParams(akVar7.f442248j, hashMap);
        ak akVar8 = this.binding;
        if (akVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar8 = null;
        }
        VideoReport.setElementExposePolicy(akVar8.f442248j, exposurePolicy);
        ak akVar9 = this.binding;
        if (akVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar9 = null;
        }
        VideoReport.setElementClickPolicy(akVar9.f442248j, clickPolicy);
        ak akVar10 = this.binding;
        if (akVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar10 = null;
        }
        VideoReport.setElementId(akVar10.f442244f, "em_party_add_friend");
        ak akVar11 = this.binding;
        if (akVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar11 = null;
        }
        Button button = akVar11.f442244f;
        HashMap hashMap2 = new HashMap(hashMap);
        hashMap2.put("sgrp_profile_scene", "0");
        VideoReport.setElementParams(button, hashMap2);
        ak akVar12 = this.binding;
        if (akVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar12 = null;
        }
        VideoReport.setElementExposePolicy(akVar12.f442244f, exposurePolicy);
        ak akVar13 = this.binding;
        if (akVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            akVar2 = akVar13;
        }
        VideoReport.setElementClickPolicy(akVar2.f442244f, clickPolicy);
    }

    private final void o1() {
        boolean z16;
        boolean z17;
        int i3;
        ak akVar = this.binding;
        ak akVar2 = null;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        TextView textView = akVar.f442245g;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.guildSelectCancelTv");
        boolean z18 = true;
        int i16 = 0;
        if (textView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ak akVar3 = this.binding;
        if (akVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar3 = null;
        }
        Button button = akVar3.f442244f;
        Intrinsics.checkNotNullExpressionValue(button, "binding.guildProfileAddFriend");
        if (!z16 && Intrinsics.areEqual(this.showAddFriend, Boolean.TRUE)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        button.setVisibility(i3);
        ak akVar4 = this.binding;
        if (akVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            akVar2 = akVar4;
        }
        ImageView imageView = akVar2.f442243e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildChannelRightDetail");
        if (z16 || this.showAddFriend == null) {
            z18 = false;
        }
        if (!z18) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    private final void p1(UIState.TitleState uiState) {
        boolean z16;
        boolean z17;
        int i3;
        ak akVar = this.binding;
        ak akVar2 = null;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        akVar.f442247i.setText(uiState.getNickName());
        boolean z18 = true;
        int i16 = 0;
        if (uiState.getChannelName().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ak akVar3 = this.binding;
            if (akVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                akVar3 = null;
            }
            akVar3.f442249k.setVisibility(8);
        } else {
            ak akVar4 = this.binding;
            if (akVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                akVar4 = null;
            }
            akVar4.f442249k.setText("\u6765\u81ea\u201c" + uiState.getChannelName() + "\u201d\u9891\u9053");
            if (uiState.getNodeType() == 1) {
                ak akVar5 = this.binding;
                if (akVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    akVar5 = null;
                }
                akVar5.f442249k.setVisibility(8);
            } else {
                ak akVar6 = this.binding;
                if (akVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    akVar6 = null;
                }
                akVar6.f442249k.setVisibility(0);
            }
        }
        ak akVar7 = this.binding;
        if (akVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar7 = null;
        }
        ImageView imageView = akVar7.f442240b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.disturbIcon");
        if (uiState.getNotifyType() != 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        ak akVar8 = this.binding;
        if (akVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            akVar2 = akVar8;
        }
        ImageView imageView2 = akVar2.f442250l;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.tvRobot");
        if (uiState.getNodeType() != 1) {
            z18 = false;
        }
        if (!z18) {
            i16 = 8;
        }
        imageView2.setVisibility(i16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        ak akVar = this.binding;
        ak akVar2 = null;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        Button button = akVar.f442244f;
        Intrinsics.checkNotNullExpressionValue(button, "binding.guildProfileAddFriend");
        button.setVisibility(8);
        ak akVar3 = this.binding;
        if (akVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar3 = null;
        }
        akVar3.f442242d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.title.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.e1(e.this, view);
            }
        });
        ak akVar4 = this.binding;
        if (akVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar4 = null;
        }
        akVar4.f442248j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.title.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.f1(e.this, view);
            }
        });
        ak akVar5 = this.binding;
        if (akVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            akVar2 = akVar5;
        }
        akVar2.f442244f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqguild.directmessage.aio.title.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.g1(e.this, view);
            }
        });
        sendIntent(a.b.f345145d);
        QQGuildThemeManager.c(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends UIState>> getObserverStates() {
        return UIState.INSTANCE.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public TitleViewModel createVM() {
        return new TitleViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        xs3.c cVar = new xs3.c(hostView);
        this.navigateBackBinder = cVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(cVar);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull UIState state) {
        Activity activity;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof UIState.AddFriendState) {
            this.showAddFriend = Boolean.valueOf(((UIState.AddFriendState) state).getShow());
            o1();
            return;
        }
        if (state instanceof UIState.TitleState) {
            p1((UIState.TitleState) state);
            return;
        }
        int i3 = 8;
        ak akVar = null;
        if (state instanceof UIState.NotifyTypeUpdate) {
            ak akVar2 = this.binding;
            if (akVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                akVar = akVar2;
            }
            ImageView imageView = akVar.f442240b;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.disturbIcon");
            boolean z16 = true;
            if (((UIState.NotifyTypeUpdate) state).getNotifyType() == 1) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            return;
        }
        if (state instanceof UIState.TitleMultiSelectState) {
            ak akVar3 = this.binding;
            if (akVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                akVar3 = null;
            }
            TextView textView = akVar3.f442245g;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildSelectCancelTv");
            UIState.TitleMultiSelectState titleMultiSelectState = (UIState.TitleMultiSelectState) state;
            if (titleMultiSelectState.getEnable()) {
                i3 = 0;
            }
            textView.setVisibility(i3);
            o1();
            if (titleMultiSelectState.getFromJubao()) {
                ak akVar4 = this.binding;
                if (akVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    akVar = akVar4;
                }
                akVar.f442245g.setText("\u5b8c\u6210");
                return;
            }
            return;
        }
        if (state instanceof UIState.CloseCurrentPage) {
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            Context mContext = getMContext();
            if (mContext instanceof Activity) {
                activity = (Activity) mContext;
            } else {
                activity = null;
            }
            GuildSplitViewUtils.u(guildSplitViewUtils, activity, false, 2, null);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ak g16 = ak.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.binding = g16;
        l1();
        n1();
        ak akVar = this.binding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            akVar = null;
        }
        ConstraintLayout root = akVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this);
    }

    @Override // or0.a
    public void onThemeChanged() {
        Activity activity;
        l1();
        Context mContext = getMContext();
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        } else {
            activity = null;
        }
        QUIImmersiveHelper.s(activity, true, false);
    }
}
