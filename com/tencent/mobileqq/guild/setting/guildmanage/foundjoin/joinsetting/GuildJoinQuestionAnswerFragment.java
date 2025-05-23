package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinQuestionAnswerFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.QuestionAndAnswerAdapter;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestionItem;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J&\u0010\u0011\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinQuestionAnswerFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "Yh", "Xh", "Ph", "initView", "Zh", "initViewModel", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "rh", "onDestroyView", "", "onBackEvent", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", "T", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", "setting", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter;", "U", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "V", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "mViewModel", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Landroid/widget/LinearLayout;", "X", "Landroid/widget/LinearLayout;", "llPlus", "Y", "Z", "isRightTextEnable", "Lcom/tencent/mobileqq/guild/window/s;", "Lcom/tencent/mobileqq/guild/window/s;", "mSoftKeyboardStateHelper", "<init>", "()V", "a0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJoinQuestionAnswerFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GWGProJoinGuildWordQuestion setting;

    /* renamed from: U, reason: from kotlin metadata */
    private QuestionAndAnswerAdapter adapter;

    /* renamed from: V, reason: from kotlin metadata */
    private q mViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView recyclerview;

    /* renamed from: X, reason: from kotlin metadata */
    private LinearLayout llPlus;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isRightTextEnable;

    /* renamed from: Z, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.window.s mSoftKeyboardStateHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinQuestionAnswerFragment$a;", "", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", "setting", "Landroid/content/Intent;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinQuestionAnswerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String guildId, @NotNull GWGProJoinGuildWordQuestion setting) {
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/GuildJoinQuestionAnswerFragment$b", "Lcom/tencent/mobileqq/guild/window/s$c;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements s.c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildJoinQuestionAnswerFragment this$0) {
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
            LinearLayout linearLayout = GuildJoinQuestionAnswerFragment.this.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            final GuildJoinQuestionAnswerFragment guildJoinQuestionAnswerFragment = GuildJoinQuestionAnswerFragment.this;
            linearLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildJoinQuestionAnswerFragment.b.b(GuildJoinQuestionAnswerFragment.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            LinearLayout linearLayout = GuildJoinQuestionAnswerFragment.this.llPlus;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent Oh(@NotNull String str, @NotNull GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion) {
        return INSTANCE.a(str, gWGProJoinGuildWordQuestion);
    }

    private final void Ph() {
        this.E.setText(R.string.f147120w1);
        this.F.setText(R.string.f155081gj);
        this.F.setVisibility(0);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildJoinQuestionAnswerFragment.Qh(GuildJoinQuestionAnswerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(GuildJoinQuestionAnswerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            q qVar = null;
            if (this$0.isRightTextEnable) {
                QQToast.makeText(this$0.getContext(), 2, "\u4fdd\u5b58\u6210\u529f", 0).show();
                q qVar2 = this$0.mViewModel;
                if (qVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    qVar = qVar2;
                }
                qVar.S1(true);
            } else {
                Context context = this$0.getContext();
                q qVar3 = this$0.mViewModel;
                if (qVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    qVar = qVar3;
                }
                QQToast.makeText(context, qVar.M1(), 0).show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildJoinQuestionAnswerFragment this$0, cf1.b bVar) {
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
    public static final void Sh(GuildJoinQuestionAnswerFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool != null && bool.booleanValue() && this$0.getActivity() != null) {
            InputMethodUtil.hide(this$0.getActivity());
            Intent intent = new Intent();
            GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion = this$0.setting;
            GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion2 = null;
            if (gWGProJoinGuildWordQuestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
                gWGProJoinGuildWordQuestion = null;
            }
            QuestionAndAnswerAdapter questionAndAnswerAdapter = this$0.adapter;
            if (questionAndAnswerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                questionAndAnswerAdapter = null;
            }
            gWGProJoinGuildWordQuestion.setItems(new ArrayList<>(questionAndAnswerAdapter.k0()));
            GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion3 = this$0.setting;
            if (gWGProJoinGuildWordQuestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setting");
            } else {
                gWGProJoinGuildWordQuestion2 = gWGProJoinGuildWordQuestion3;
            }
            intent.putExtra("question_result", gWGProJoinGuildWordQuestion2);
            this$0.requireActivity().setResult(-1, intent);
            this$0.requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildJoinQuestionAnswerFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isRightTextEnable = Intrinsics.areEqual(bool, Boolean.TRUE);
        this$0.Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildJoinQuestionAnswerFragment this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        LinearLayout linearLayout = null;
        if (it.intValue() >= 5) {
            LinearLayout linearLayout2 = this$0.llPlus;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llPlus");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setAlpha(0.3f);
            return;
        }
        LinearLayout linearLayout3 = this$0.llPlus;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llPlus");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildJoinQuestionAnswerFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Xh() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.ypt), "em_sgrp_add_question", null);
    }

    private final void Yh() {
        final String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P.getRootView(), "pg_sgrp_auditset_question");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.P.getRootView(), stringExtra, new HashMap<String, Object>(stringExtra) { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinQuestionAnswerFragment$setDtPage$1
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

    private final void Zh() {
        if (this.isRightTextEnable) {
            this.F.setTextColor(GuildUIUtils.r(getResources().getColor(R.color.qui_common_text_primary)));
        } else {
            this.F.setTextColor(kotlin.g.a(getResources().getColor(R.color.qui_common_text_primary), 30));
        }
    }

    private final void initView() {
        q qVar = this.mViewModel;
        q qVar2 = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar = null;
        }
        this.adapter = new QuestionAndAnswerAdapter(qVar);
        Ph();
        View findViewById = this.P.findViewById(R.id.i4o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recyclerview)");
        this.recyclerview = (RecyclerView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.ypt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.ll_plus)");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        this.llPlus = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llPlus");
            linearLayout = null;
        }
        kotlin.b.b(linearLayout, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinQuestionAnswerFragment$initView$1
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
                QuestionAndAnswerAdapter questionAndAnswerAdapter;
                QuestionAndAnswerAdapter questionAndAnswerAdapter2;
                q qVar3;
                QuestionAndAnswerAdapter questionAndAnswerAdapter3;
                q qVar4;
                QuestionAndAnswerAdapter questionAndAnswerAdapter4;
                RecyclerView recyclerView;
                QuestionAndAnswerAdapter questionAndAnswerAdapter5;
                GuildJoinQuestionAnswerFragment guildJoinQuestionAnswerFragment = GuildJoinQuestionAnswerFragment.this;
                if (com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                    return;
                }
                questionAndAnswerAdapter = guildJoinQuestionAnswerFragment.adapter;
                QuestionAndAnswerAdapter questionAndAnswerAdapter6 = null;
                if (questionAndAnswerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    questionAndAnswerAdapter = null;
                }
                if (questionAndAnswerAdapter.getItemCount() < 5) {
                    questionAndAnswerAdapter2 = guildJoinQuestionAnswerFragment.adapter;
                    if (questionAndAnswerAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        questionAndAnswerAdapter2 = null;
                    }
                    questionAndAnswerAdapter2.j0();
                    qVar3 = guildJoinQuestionAnswerFragment.mViewModel;
                    if (qVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        qVar3 = null;
                    }
                    questionAndAnswerAdapter3 = guildJoinQuestionAnswerFragment.adapter;
                    if (questionAndAnswerAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        questionAndAnswerAdapter3 = null;
                    }
                    qVar3.L1(questionAndAnswerAdapter3.k0().size() - 1);
                    qVar4 = guildJoinQuestionAnswerFragment.mViewModel;
                    if (qVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        qVar4 = null;
                    }
                    questionAndAnswerAdapter4 = guildJoinQuestionAnswerFragment.adapter;
                    if (questionAndAnswerAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        questionAndAnswerAdapter4 = null;
                    }
                    qVar4.Z1(questionAndAnswerAdapter4.k0());
                    recyclerView = guildJoinQuestionAnswerFragment.recyclerview;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
                        recyclerView = null;
                    }
                    questionAndAnswerAdapter5 = guildJoinQuestionAnswerFragment.adapter;
                    if (questionAndAnswerAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        questionAndAnswerAdapter6 = questionAndAnswerAdapter5;
                    }
                    recyclerView.scrollToPosition(questionAndAnswerAdapter6.getItemCount() - 1);
                    return;
                }
                QQToast.makeText(guildJoinQuestionAnswerFragment.getContext(), guildJoinQuestionAnswerFragment.requireContext().getString(R.string.f147100vz), 0).show();
                IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                LinearLayout linearLayout2 = guildJoinQuestionAnswerFragment.llPlus;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llPlus");
                    linearLayout2 = null;
                }
                iGuildDTReportApi.reportDtEventManual(linearLayout2, "em_sgrp_toast", "imp", null);
            }
        });
        Serializable serializableExtra = requireActivity().getIntent().getSerializableExtra("extra_key_guild_join_questions");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion");
        this.setting = (GWGProJoinGuildWordQuestion) serializableExtra;
        QuestionAndAnswerAdapter questionAndAnswerAdapter = this.adapter;
        if (questionAndAnswerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            questionAndAnswerAdapter = null;
        }
        GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion = this.setting;
        if (gWGProJoinGuildWordQuestion == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setting");
            gWGProJoinGuildWordQuestion = null;
        }
        ArrayList<GWGProJoinGuildWordQuestionItem> items = gWGProJoinGuildWordQuestion.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "setting.items");
        questionAndAnswerAdapter.setItems(items);
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
            recyclerView = null;
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
            recyclerView2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 1, false));
        RecyclerView recyclerView3 = this.recyclerview;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerview");
            recyclerView3 = null;
        }
        QuestionAndAnswerAdapter questionAndAnswerAdapter2 = this.adapter;
        if (questionAndAnswerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            questionAndAnswerAdapter2 = null;
        }
        recyclerView3.setAdapter(questionAndAnswerAdapter2);
        q qVar3 = this.mViewModel;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar3 = null;
        }
        QuestionAndAnswerAdapter questionAndAnswerAdapter3 = this.adapter;
        if (questionAndAnswerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            questionAndAnswerAdapter3 = null;
        }
        qVar3.W1(questionAndAnswerAdapter3.k0());
        q qVar4 = this.mViewModel;
        if (qVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar4 = null;
        }
        QuestionAndAnswerAdapter questionAndAnswerAdapter4 = this.adapter;
        if (questionAndAnswerAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            questionAndAnswerAdapter4 = null;
        }
        qVar4.Z1(questionAndAnswerAdapter4.k0());
        q qVar5 = this.mViewModel;
        if (qVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar5 = null;
        }
        qVar5.P1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinQuestionAnswerFragment.Rh(GuildJoinQuestionAnswerFragment.this, (cf1.b) obj);
            }
        });
        q qVar6 = this.mViewModel;
        if (qVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar6 = null;
        }
        qVar6.N1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinQuestionAnswerFragment.Sh(GuildJoinQuestionAnswerFragment.this, (Boolean) obj);
            }
        });
        q qVar7 = this.mViewModel;
        if (qVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar7 = null;
        }
        qVar7.O1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinQuestionAnswerFragment.Th(GuildJoinQuestionAnswerFragment.this, (Boolean) obj);
            }
        });
        q qVar8 = this.mViewModel;
        if (qVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            qVar2 = qVar8;
        }
        qVar2.G.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinQuestionAnswerFragment.Uh(GuildJoinQuestionAnswerFragment.this, (Integer) obj);
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
        com.tencent.mobileqq.guild.window.s sVar = new com.tencent.mobileqq.guild.window.s(requireActivity().getWindow().getDecorView());
        this.mSoftKeyboardStateHelper = sVar;
        sVar.g(new b());
        rh();
        Yh();
        Xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.evi;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        q qVar = this.mViewModel;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qVar = null;
        }
        if (qVar.Q1()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, QQGuildUIUtil.r(R.string.f147050vu), QQGuildUIUtil.r(R.string.f146970vm), QQGuildUIUtil.r(R.string.f147040vt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildJoinQuestionAnswerFragment.Vh(GuildJoinQuestionAnswerFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildJoinQuestionAnswerFragment.Wh(dialogInterface, i3);
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
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
        Zh();
    }
}
