package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.ad;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.GuildJoinTestAdapter;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0014J&\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "di", "ci", "", "color", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "override", "bi", "Th", "initView", "initViewModel", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "rh", "onDestroyView", "onBackEvent", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "T", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "setting", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter;", "U", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "V", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "mViewModel", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Landroid/widget/LinearLayout;", "X", "Landroid/widget/LinearLayout;", "llPlus", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "tvTestStandard", "Z", "llTestStandard", "Landroidx/core/widget/NestedScrollView;", "a0", "Landroidx/core/widget/NestedScrollView;", "scrollview", "Lcom/tencent/mobileqq/guild/window/s;", "b0", "Lcom/tencent/mobileqq/guild/window/s;", "mSoftKeyboardStateHelper", "Landroid/os/Handler;", "c0", "Landroid/os/Handler;", "handler", "<init>", "()V", "d0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJoinTestFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GWGProJoinGuildChoiceQuestion setting;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildJoinTestAdapter adapter;

    /* renamed from: V, reason: from kotlin metadata */
    private q mViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView recyclerview;

    /* renamed from: X, reason: from kotlin metadata */
    private LinearLayout llPlus;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView tvTestStandard;

    /* renamed from: Z, reason: from kotlin metadata */
    private LinearLayout llTestStandard;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private NestedScrollView scrollview;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.window.s mSoftKeyboardStateHelper;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment$a;", "", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "setting", "Landroid/content/Intent;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String guildId, @NotNull GWGProJoinGuildChoiceQuestion setting) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(setting, "setting");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_guild_id", guildId);
            bundle.putSerializable("extra_key_guild_join_questions", setting);
            intent.putExtras(bundle);
            return intent;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment$b", "Lcom/tencent/mobileqq/guild/window/s$c;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements s.c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildJoinTestFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LinearLayout linearLayout = this$0.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardClosed() {
            LinearLayout linearLayout = GuildJoinTestFragment.this.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            final GuildJoinTestFragment guildJoinTestFragment = GuildJoinTestFragment.this;
            linearLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.ab
                @Override // java.lang.Runnable
                public final void run() {
                    GuildJoinTestFragment.b.b(GuildJoinTestFragment.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            LinearLayout linearLayout = GuildJoinTestFragment.this.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment$c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends LinearLayoutManager {
        c(Context context) {
            super(context, 1, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent Sh(@NotNull String str, @NotNull GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion) {
        return INSTANCE.a(str, gWGProJoinGuildChoiceQuestion);
    }

    private final void Th() {
        this.E.setText(R.string.f147210w_);
        this.F.setText(R.string.f155081gj);
        TextView textView = this.F;
        textView.setTextColor(bi(QQGuildUIUtil.i(textView.getContext(), R.color.qui_common_text_primary), 0.3f, true));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildJoinTestFragment.Uh(GuildJoinTestFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildJoinTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            q qVar = this$0.mViewModel;
            q qVar2 = null;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                qVar = null;
            }
            if (Intrinsics.areEqual(qVar.O1().getValue(), Boolean.TRUE)) {
                QQToast.makeText(this$0.getContext(), 2, "\u4fdd\u5b58\u6210\u529f", 0).show();
                q qVar3 = this$0.mViewModel;
                if (qVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    qVar2 = qVar3;
                }
                qVar2.S1(true);
            } else {
                q qVar4 = this$0.mViewModel;
                if (qVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar4 = null;
                }
                if (qVar4.O1().getValue() == null) {
                    q qVar5 = this$0.mViewModel;
                    if (qVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        qVar2 = qVar5;
                    }
                    qVar2.S1(true);
                } else {
                    Context context = this$0.getContext();
                    q qVar6 = this$0.mViewModel;
                    if (qVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        qVar2 = qVar6;
                    }
                    QQToast.makeText(context, qVar2.M1(), 0).show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildJoinTestFragment this$0, cf1.b bVar) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar != null && bVar.f30775b == 0 && ch.p(bVar.f30776c)) {
            ch.u1(this$0.getContext(), bVar.f30774a);
            return;
        }
        if (bVar != null) {
            if (TextUtils.isEmpty(bVar.f30774a)) {
                str = this$0.getResources().getString(R.string.f147080vx);
            } else {
                str = bVar.f30774a;
            }
            SecurityTipHelperKt.N(bVar.f30776c, this$0.getContext(), bVar.f30775b, str, false, null, 48, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        if (r0.getText().toString().length() < 2) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Wh(GuildJoinTestFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool != null && bool.booleanValue() && this$0.getActivity() != null) {
            InputMethodUtil.hide(this$0.getActivity());
            Intent intent = new Intent();
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion = this$0.setting;
            TextView textView = null;
            if (gWGProJoinGuildChoiceQuestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion = null;
            }
            GuildJoinTestAdapter guildJoinTestAdapter = this$0.adapter;
            if (guildJoinTestAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter = null;
            }
            gWGProJoinGuildChoiceQuestion.setItems(new ArrayList<>(guildJoinTestAdapter.getItems()));
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion2 = this$0.setting;
            if (gWGProJoinGuildChoiceQuestion2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion2 = null;
            }
            GuildJoinTestAdapter guildJoinTestAdapter2 = this$0.adapter;
            if (guildJoinTestAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter2 = null;
            }
            gWGProJoinGuildChoiceQuestion2.setNeedAnswerNum(guildJoinTestAdapter2.getItems().size());
            TextView textView2 = this$0.tvTestStandard;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                textView2 = null;
            }
            if (!Intrinsics.areEqual("\u5168\u90e8\u7b54\u5bf9", textView2.getText().toString())) {
                TextView textView3 = this$0.tvTestStandard;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                    textView3 = null;
                }
            }
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion3 = this$0.setting;
            if (gWGProJoinGuildChoiceQuestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion3 = null;
            }
            GuildJoinTestAdapter guildJoinTestAdapter3 = this$0.adapter;
            if (guildJoinTestAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter3 = null;
            }
            gWGProJoinGuildChoiceQuestion3.setPassCorrectNum(guildJoinTestAdapter3.getItems().size());
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion4 = this$0.setting;
            if (gWGProJoinGuildChoiceQuestion4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion4 = null;
            }
            intent.putExtra("choice_result", gWGProJoinGuildChoiceQuestion4);
            TextView textView4 = this$0.tvTestStandard;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
            } else {
                textView = textView4;
            }
            intent.putExtra("choice_standard_result", textView.getText().toString());
            this$0.requireActivity().setResult(-1, intent);
            this$0.requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(GuildJoinTestFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool != null && bool.booleanValue()) {
            TextView textView = this$0.F;
            textView.setTextColor(QQGuildUIUtil.i(textView.getContext(), R.color.qui_common_text_primary));
        } else {
            TextView textView2 = this$0.F;
            textView2.setTextColor(this$0.bi(QQGuildUIUtil.i(textView2.getContext(), R.color.qui_common_text_primary), 0.3f, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GuildJoinTestFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        TextView textView = null;
        if (it.intValue() >= 8) {
            LinearLayout linearLayout = this$0.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            linearLayout.setAlpha(0.3f);
        } else {
            LinearLayout linearLayout2 = this$0.llPlus;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout2 = null;
            }
            linearLayout2.setAlpha(1.0f);
        }
        TextView textView2 = this$0.tvTestStandard;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
        } else {
            textView = textView2;
        }
        textView.setText("\u5168\u90e8\u7b54\u5bf9");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildJoinTestFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final int bi(@ColorInt int color, float alpha, boolean override) {
        int i3 = 255;
        if (!override) {
            i3 = 255 & (color >> 24);
        }
        return (color & 16777215) | (((int) (alpha * i3)) << 24);
    }

    private final void ci() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.ypt), "em_sgrp_add_question", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.yqz), "em_sgrp_pass_test_level", null);
    }

    private final void di() {
        final String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P.getRootView(), "pg_sgrp_auditset_test");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.P.getRootView(), stringExtra, new HashMap<String, Object>(stringExtra) { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment$setDtPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("sgrp_channel_id", stringExtra);
                String currentUserType = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(stringExtra);
                put("sgrp_user_type", currentUserType == null ? "" : currentUserType);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<Object> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Object> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ Object get(String str) {
                return super.get((Object) str);
            }

            public /* bridge */ Object getOrDefault(String str, Object obj) {
                return super.getOrDefault((Object) str, (String) obj);
            }

            public /* bridge */ Object remove(String str) {
                return super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj, obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, Object obj) {
                return super.remove((Object) str, obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        LinearLayout linearLayout;
        GuildJoinTestAdapter guildJoinTestAdapter;
        GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        GuildJoinTestAdapter guildJoinTestAdapter2;
        q qVar;
        GuildJoinTestAdapter guildJoinTestAdapter3;
        Collection collection;
        q qVar2;
        GuildJoinTestAdapter guildJoinTestAdapter4;
        q qVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        q qVar7 = this.mViewModel;
        q qVar8 = null;
        if (qVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar7 = null;
        }
        this.adapter = new GuildJoinTestAdapter(qVar7);
        Th();
        View findViewById = this.P.findViewById(R.id.i4o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recyclerview)");
        this.recyclerview = (RecyclerView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.iil);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.scrollview)");
        this.scrollview = (NestedScrollView) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.ypt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.ll_plus)");
        this.llPlus = (LinearLayout) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.f111846mb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.tv_test_standard)");
        this.tvTestStandard = (TextView) findViewById4;
        View findViewById5 = this.P.findViewById(R.id.yqz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewById(R.id.ll_test_standard)");
        this.llTestStandard = (LinearLayout) findViewById5;
        LinearLayout linearLayout2 = this.llPlus;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llPlus");
            linearLayout2 = null;
        }
        kotlin.b.b(linearLayout2, new GuildJoinTestFragment$initView$1(this));
        Serializable serializableExtra = requireActivity().getIntent().getSerializableExtra("extra_key_guild_join_questions");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion");
        GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion2 = (GWGProJoinGuildChoiceQuestion) serializableExtra;
        this.setting = gWGProJoinGuildChoiceQuestion2;
        if (gWGProJoinGuildChoiceQuestion2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setting");
            gWGProJoinGuildChoiceQuestion2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(gWGProJoinGuildChoiceQuestion2.getItems(), "setting.items");
        if (!r0.isEmpty()) {
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion3 = this.setting;
            if (gWGProJoinGuildChoiceQuestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion3 = null;
            }
            int needAnswerNum = gWGProJoinGuildChoiceQuestion3.getNeedAnswerNum();
            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion4 = this.setting;
            if (gWGProJoinGuildChoiceQuestion4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildChoiceQuestion4 = null;
            }
            if (needAnswerNum != gWGProJoinGuildChoiceQuestion4.getPassCorrectNum()) {
                TextView textView = this.tvTestStandard;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                    textView = null;
                }
                GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion5 = this.setting;
                if (gWGProJoinGuildChoiceQuestion5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setting");
                    gWGProJoinGuildChoiceQuestion5 = null;
                }
                textView.setText("\u7b54\u5bf9" + gWGProJoinGuildChoiceQuestion5.getPassCorrectNum() + "\u9898");
                linearLayout = this.llTestStandard;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llTestStandard");
                    linearLayout = null;
                }
                kotlin.b.b(linearLayout, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment$initView$2

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment$initView$2$a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$c;", "", "correctNum", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes14.dex */
                    public static final class a implements ad.c {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ GuildJoinTestFragment f233867a;

                        a(GuildJoinTestFragment guildJoinTestFragment) {
                            this.f233867a = guildJoinTestFragment;
                        }

                        @Override // com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.ad.c
                        public void a(@NotNull String correctNum) {
                            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion;
                            GuildJoinTestAdapter guildJoinTestAdapter;
                            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion2;
                            q qVar;
                            GuildJoinTestAdapter guildJoinTestAdapter2;
                            TextView textView;
                            GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion3;
                            GuildJoinTestAdapter guildJoinTestAdapter3;
                            Intrinsics.checkNotNullParameter(correctNum, "correctNum");
                            gWGProJoinGuildChoiceQuestion = this.f233867a.setting;
                            TextView textView2 = null;
                            if (gWGProJoinGuildChoiceQuestion == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("setting");
                                gWGProJoinGuildChoiceQuestion = null;
                            }
                            guildJoinTestAdapter = this.f233867a.adapter;
                            if (guildJoinTestAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                guildJoinTestAdapter = null;
                            }
                            gWGProJoinGuildChoiceQuestion.setNeedAnswerNum(guildJoinTestAdapter.getItemCount());
                            if (Intrinsics.areEqual("\u5168\u90e8\u7b54\u5bf9", correctNum)) {
                                gWGProJoinGuildChoiceQuestion3 = this.f233867a.setting;
                                if (gWGProJoinGuildChoiceQuestion3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("setting");
                                    gWGProJoinGuildChoiceQuestion3 = null;
                                }
                                guildJoinTestAdapter3 = this.f233867a.adapter;
                                if (guildJoinTestAdapter3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                    guildJoinTestAdapter3 = null;
                                }
                                gWGProJoinGuildChoiceQuestion3.setPassCorrectNum(guildJoinTestAdapter3.getItemCount());
                            } else {
                                gWGProJoinGuildChoiceQuestion2 = this.f233867a.setting;
                                if (gWGProJoinGuildChoiceQuestion2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("setting");
                                    gWGProJoinGuildChoiceQuestion2 = null;
                                }
                                gWGProJoinGuildChoiceQuestion2.setPassCorrectNum(Integer.parseInt(String.valueOf(correctNum.charAt(2))));
                            }
                            qVar = this.f233867a.mViewModel;
                            if (qVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                qVar = null;
                            }
                            guildJoinTestAdapter2 = this.f233867a.adapter;
                            if (guildJoinTestAdapter2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                guildJoinTestAdapter2 = null;
                            }
                            qVar.X1(guildJoinTestAdapter2.getItems());
                            textView = this.f233867a.tvTestStandard;
                            if (textView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                            } else {
                                textView2 = textView;
                            }
                            textView2.setText(correctNum);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LinearLayout linearLayout3;
                        GuildJoinTestAdapter guildJoinTestAdapter5;
                        TextView textView2;
                        GuildJoinTestAdapter guildJoinTestAdapter6;
                        TextView textView3;
                        GuildJoinTestFragment guildJoinTestFragment = GuildJoinTestFragment.this;
                        if (com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                            return;
                        }
                        linearLayout3 = guildJoinTestFragment.llTestStandard;
                        TextView textView4 = null;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("llTestStandard");
                            linearLayout3 = null;
                        }
                        Context context = linearLayout3.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "llTestStandard.context");
                        guildJoinTestAdapter5 = guildJoinTestFragment.adapter;
                        if (guildJoinTestAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            guildJoinTestAdapter5 = null;
                        }
                        ad adVar = new ad(context, false, guildJoinTestAdapter5.getItemCount(), new a(guildJoinTestFragment));
                        textView2 = guildJoinTestFragment.tvTestStandard;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                            textView2 = null;
                        }
                        if (!Intrinsics.areEqual("\u5168\u90e8\u7b54\u5bf9", textView2.getText())) {
                            guildJoinTestAdapter6 = guildJoinTestFragment.adapter;
                            if (guildJoinTestAdapter6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                guildJoinTestAdapter6 = null;
                            }
                            int itemCount = guildJoinTestAdapter6.getItemCount();
                            textView3 = guildJoinTestFragment.tvTestStandard;
                            if (textView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                            } else {
                                textView4 = textView3;
                            }
                            adVar.p(itemCount - Integer.parseInt(String.valueOf(textView4.getText().charAt(2))));
                        }
                        adVar.m();
                    }
                });
                guildJoinTestAdapter = this.adapter;
                if (guildJoinTestAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildJoinTestAdapter = null;
                }
                gWGProJoinGuildChoiceQuestion = this.setting;
                if (gWGProJoinGuildChoiceQuestion == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setting");
                    gWGProJoinGuildChoiceQuestion = null;
                }
                ArrayList<GWGProJoinGuildChoiceQuestionItem> items = gWGProJoinGuildChoiceQuestion.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "setting.items");
                guildJoinTestAdapter.setItems(items);
                recyclerView = this.recyclerview;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
                    recyclerView = null;
                }
                recyclerView2 = this.recyclerview;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
                    recyclerView2 = null;
                }
                recyclerView.setLayoutManager(new c(recyclerView2.getContext()));
                recyclerView3 = this.recyclerview;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
                    recyclerView3 = null;
                }
                guildJoinTestAdapter2 = this.adapter;
                if (guildJoinTestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildJoinTestAdapter2 = null;
                }
                recyclerView3.setAdapter(guildJoinTestAdapter2);
                qVar = this.mViewModel;
                if (qVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar = null;
                }
                guildJoinTestAdapter3 = this.adapter;
                if (guildJoinTestAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildJoinTestAdapter3 = null;
                }
                collection = CollectionsKt___CollectionsKt.toCollection(guildJoinTestAdapter3.getItems(), new ArrayList());
                qVar.U1((ArrayList) collection);
                qVar2 = this.mViewModel;
                if (qVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar2 = null;
                }
                guildJoinTestAdapter4 = this.adapter;
                if (guildJoinTestAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildJoinTestAdapter4 = null;
                }
                qVar2.X1(guildJoinTestAdapter4.getItems());
                qVar3 = this.mViewModel;
                if (qVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar3 = null;
                }
                qVar3.P1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.w
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildJoinTestFragment.Vh(GuildJoinTestFragment.this, (cf1.b) obj);
                    }
                });
                qVar4 = this.mViewModel;
                if (qVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar4 = null;
                }
                qVar4.N1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.x
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildJoinTestFragment.Wh(GuildJoinTestFragment.this, (Boolean) obj);
                    }
                });
                qVar5 = this.mViewModel;
                if (qVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    qVar5 = null;
                }
                qVar5.O1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.y
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildJoinTestFragment.Xh(GuildJoinTestFragment.this, (Boolean) obj);
                    }
                });
                qVar6 = this.mViewModel;
                if (qVar6 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    qVar8 = qVar6;
                }
                qVar8.H.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.z
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildJoinTestFragment.Yh(GuildJoinTestFragment.this, (Integer) obj);
                    }
                });
            }
        }
        TextView textView2 = this.tvTestStandard;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
            textView2 = null;
        }
        textView2.setText("\u5168\u90e8\u7b54\u5bf9");
        linearLayout = this.llTestStandard;
        if (linearLayout == null) {
        }
        kotlin.b.b(linearLayout, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinTestFragment$initView$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinTestFragment$initView$2$a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/ad$c;", "", "correctNum", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements ad.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildJoinTestFragment f233867a;

                a(GuildJoinTestFragment guildJoinTestFragment) {
                    this.f233867a = guildJoinTestFragment;
                }

                @Override // com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.ad.c
                public void a(@NotNull String correctNum) {
                    GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion;
                    GuildJoinTestAdapter guildJoinTestAdapter;
                    GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion2;
                    q qVar;
                    GuildJoinTestAdapter guildJoinTestAdapter2;
                    TextView textView;
                    GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion3;
                    GuildJoinTestAdapter guildJoinTestAdapter3;
                    Intrinsics.checkNotNullParameter(correctNum, "correctNum");
                    gWGProJoinGuildChoiceQuestion = this.f233867a.setting;
                    TextView textView2 = null;
                    if (gWGProJoinGuildChoiceQuestion == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("setting");
                        gWGProJoinGuildChoiceQuestion = null;
                    }
                    guildJoinTestAdapter = this.f233867a.adapter;
                    if (guildJoinTestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        guildJoinTestAdapter = null;
                    }
                    gWGProJoinGuildChoiceQuestion.setNeedAnswerNum(guildJoinTestAdapter.getItemCount());
                    if (Intrinsics.areEqual("\u5168\u90e8\u7b54\u5bf9", correctNum)) {
                        gWGProJoinGuildChoiceQuestion3 = this.f233867a.setting;
                        if (gWGProJoinGuildChoiceQuestion3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("setting");
                            gWGProJoinGuildChoiceQuestion3 = null;
                        }
                        guildJoinTestAdapter3 = this.f233867a.adapter;
                        if (guildJoinTestAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            guildJoinTestAdapter3 = null;
                        }
                        gWGProJoinGuildChoiceQuestion3.setPassCorrectNum(guildJoinTestAdapter3.getItemCount());
                    } else {
                        gWGProJoinGuildChoiceQuestion2 = this.f233867a.setting;
                        if (gWGProJoinGuildChoiceQuestion2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("setting");
                            gWGProJoinGuildChoiceQuestion2 = null;
                        }
                        gWGProJoinGuildChoiceQuestion2.setPassCorrectNum(Integer.parseInt(String.valueOf(correctNum.charAt(2))));
                    }
                    qVar = this.f233867a.mViewModel;
                    if (qVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        qVar = null;
                    }
                    guildJoinTestAdapter2 = this.f233867a.adapter;
                    if (guildJoinTestAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        guildJoinTestAdapter2 = null;
                    }
                    qVar.X1(guildJoinTestAdapter2.getItems());
                    textView = this.f233867a.tvTestStandard;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                    } else {
                        textView2 = textView;
                    }
                    textView2.setText(correctNum);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinearLayout linearLayout3;
                GuildJoinTestAdapter guildJoinTestAdapter5;
                TextView textView22;
                GuildJoinTestAdapter guildJoinTestAdapter6;
                TextView textView3;
                GuildJoinTestFragment guildJoinTestFragment = GuildJoinTestFragment.this;
                if (com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                    return;
                }
                linearLayout3 = guildJoinTestFragment.llTestStandard;
                TextView textView4 = null;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llTestStandard");
                    linearLayout3 = null;
                }
                Context context = linearLayout3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "llTestStandard.context");
                guildJoinTestAdapter5 = guildJoinTestFragment.adapter;
                if (guildJoinTestAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildJoinTestAdapter5 = null;
                }
                ad adVar = new ad(context, false, guildJoinTestAdapter5.getItemCount(), new a(guildJoinTestFragment));
                textView22 = guildJoinTestFragment.tvTestStandard;
                if (textView22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                    textView22 = null;
                }
                if (!Intrinsics.areEqual("\u5168\u90e8\u7b54\u5bf9", textView22.getText())) {
                    guildJoinTestAdapter6 = guildJoinTestFragment.adapter;
                    if (guildJoinTestAdapter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        guildJoinTestAdapter6 = null;
                    }
                    int itemCount = guildJoinTestAdapter6.getItemCount();
                    textView3 = guildJoinTestFragment.tvTestStandard;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvTestStandard");
                    } else {
                        textView4 = textView3;
                    }
                    adVar.p(itemCount - Integer.parseInt(String.valueOf(textView4.getText().charAt(2))));
                }
                adVar.m();
            }
        });
        guildJoinTestAdapter = this.adapter;
        if (guildJoinTestAdapter == null) {
        }
        gWGProJoinGuildChoiceQuestion = this.setting;
        if (gWGProJoinGuildChoiceQuestion == null) {
        }
        ArrayList<GWGProJoinGuildChoiceQuestionItem> items2 = gWGProJoinGuildChoiceQuestion.getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "setting.items");
        guildJoinTestAdapter.setItems(items2);
        recyclerView = this.recyclerview;
        if (recyclerView == null) {
        }
        recyclerView2 = this.recyclerview;
        if (recyclerView2 == null) {
        }
        recyclerView.setLayoutManager(new c(recyclerView2.getContext()));
        recyclerView3 = this.recyclerview;
        if (recyclerView3 == null) {
        }
        guildJoinTestAdapter2 = this.adapter;
        if (guildJoinTestAdapter2 == null) {
        }
        recyclerView3.setAdapter(guildJoinTestAdapter2);
        qVar = this.mViewModel;
        if (qVar == null) {
        }
        guildJoinTestAdapter3 = this.adapter;
        if (guildJoinTestAdapter3 == null) {
        }
        collection = CollectionsKt___CollectionsKt.toCollection(guildJoinTestAdapter3.getItems(), new ArrayList());
        qVar.U1((ArrayList) collection);
        qVar2 = this.mViewModel;
        if (qVar2 == null) {
        }
        guildJoinTestAdapter4 = this.adapter;
        if (guildJoinTestAdapter4 == null) {
        }
        qVar2.X1(guildJoinTestAdapter4.getItems());
        qVar3 = this.mViewModel;
        if (qVar3 == null) {
        }
        qVar3.P1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinTestFragment.Vh(GuildJoinTestFragment.this, (cf1.b) obj);
            }
        });
        qVar4 = this.mViewModel;
        if (qVar4 == null) {
        }
        qVar4.N1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinTestFragment.Wh(GuildJoinTestFragment.this, (Boolean) obj);
            }
        });
        qVar5 = this.mViewModel;
        if (qVar5 == null) {
        }
        qVar5.O1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinTestFragment.Xh(GuildJoinTestFragment.this, (Boolean) obj);
            }
        });
        qVar6 = this.mViewModel;
        if (qVar6 != null) {
        }
        qVar8.H.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinTestFragment.Yh(GuildJoinTestFragment.this, (Integer) obj);
            }
        });
    }

    private final void initViewModel() {
        String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildCustomTitleBarFragment", 1, "initViewModel get guildId is " + stringExtra);
        }
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(this, q.M).get(q.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ingViewModel::class.java)");
        q qVar = (q) viewModel;
        this.mViewModel = qVar;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar = null;
        }
        qVar.T1(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initViewModel();
        initView();
        this.handler = new Handler(Looper.getMainLooper());
        com.tencent.mobileqq.guild.window.s sVar = new com.tencent.mobileqq.guild.window.s(requireActivity().getWindow().getDecorView());
        this.mSoftKeyboardStateHelper = sVar;
        sVar.g(new b());
        rh();
        di();
        ci();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.evl;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        q qVar = this.mViewModel;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar = null;
        }
        if (qVar.Q1()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, QQGuildUIUtil.r(R.string.f147050vu), QQGuildUIUtil.r(R.string.f146970vm), QQGuildUIUtil.r(R.string.f147040vt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildJoinTestFragment.Zh(GuildJoinTestFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.v
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildJoinTestFragment.ai(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026miss()\n                })");
            createCustomDialog.show();
            return true;
        }
        super.onBackEvent();
        return true;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.tencent.mobileqq.guild.window.s sVar = this.mSoftKeyboardStateHelper;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoftKeyboardStateHelper");
            sVar = null;
        }
        sVar.j();
        Handler handler = this.handler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            handler = null;
        }
        handler.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
