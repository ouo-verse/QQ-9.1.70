package com.tencent.mobileqq.guild.client.selectaccount;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.db;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 i2\u00020\u0001:\u0001jB\u001f\u0012\u0006\u00104\u001a\u00020/\u0012\u0006\u00107\u001a\u00020/\u0012\u0006\u0010:\u001a\u00020/\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u001eH\u0014J\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010%\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0014J\u0014\u0010(\u001a\u00020\u00022\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&H\u0004J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020)H&J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020#H\u0014J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020-H\u0016R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00107\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u0017\u0010:\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R.\u0010H\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\\\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u00101\u001a\u0004\bY\u00103\"\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R#\u0010f\u001a\n a*\u0004\u0018\u00010`0`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectListDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initData", "", "getCookies", "initView", "", "Dh", "Rh", "xh", "Ah", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "onResult", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "Lcom/google/android/material/bottomsheet/a;", "dialog", "Fh", "onStart", "", "Ih", "Hh", "loadData", "", "Lcom/tencent/mobileqq/guild/client/selectaccount/p;", "data", "Gh", "", "list", "Ch", "", OcrConfig.CHINESE, "info", "Jh", "Landroid/content/DialogInterface;", "onDismiss", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMTitleName", "()Ljava/lang/String;", "mTitleName", "D", "getMClientId", "mClientId", "E", "getMAreaId", "mAreaId", UserInfo.SEX_FEMALE, "[B", "mCookie", "Lcom/tencent/mobileqq/guild/client/selectaccount/PlainListAdapter;", "G", "Lcom/tencent/mobileqq/guild/client/selectaccount/PlainListAdapter;", "mAdapter", "H", "Lkotlin/jvm/functions/Function1;", "getMOnComplete", "()Lkotlin/jvm/functions/Function1;", "Ph", "(Lkotlin/jvm/functions/Function1;)V", "mOnComplete", "Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectZoneDialogFragment;", "I", "Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectZoneDialogFragment;", "getMLastFragment", "()Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectZoneDialogFragment;", "Oh", "(Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectZoneDialogFragment;)V", "mLastFragment", "J", "Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "getMData", "()Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "Nh", "(Lcom/tencent/mobileqq/qqguildsdk/data/dd;)V", "mData", "K", "getMSelectedStr", "Qh", "(Ljava/lang/String;)V", "mSelectedStr", "L", "Landroid/view/View;", "mRootView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "M", "Lkotlin/Lazy;", "Eh", "()Landroidx/recyclerview/widget/RecyclerView;", "mListView", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class GuildClientSelectListDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mTitleName;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mClientId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String mAreaId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private byte[] mCookie;

    /* renamed from: G, reason: from kotlin metadata */
    private PlainListAdapter mAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Function1<? super p, Unit> mOnComplete;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private GuildClientSelectZoneDialogFragment mLastFragment;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private dd mData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String mSelectedStr;

    /* renamed from: L, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy mListView;

    public GuildClientSelectListDialogFragment(@NotNull String mTitleName, @NotNull String mClientId, @NotNull String mAreaId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mTitleName, "mTitleName");
        Intrinsics.checkNotNullParameter(mClientId, "mClientId");
        Intrinsics.checkNotNullParameter(mAreaId, "mAreaId");
        this.mTitleName = mTitleName;
        this.mClientId = mClientId;
        this.mAreaId = mAreaId;
        this.mOnComplete = new Function1<p, Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment$mOnComplete$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull p it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }
        };
        this.mSelectedStr = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment$mListView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                View view;
                view = GuildClientSelectListDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (RecyclerView) view.findViewById(R.id.ts5);
            }
        });
        this.mListView = lazy;
    }

    private final void Ah() {
        Dialog dialog;
        GuildClientSelectZoneDialogFragment guildClientSelectZoneDialogFragment = this.mLastFragment;
        final com.google.android.material.bottomsheet.a aVar = null;
        if (guildClientSelectZoneDialogFragment != null) {
            dialog = guildClientSelectZoneDialogFragment.getDialog();
        } else {
            dialog = null;
        }
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            aVar = (com.google.android.material.bottomsheet.a) dialog;
        }
        if (aVar != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.selectaccount.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildClientSelectListDialogFragment.Bh(com.google.android.material.bottomsheet.a.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(com.google.android.material.bottomsheet.a it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.show();
        it.getBehavior().setState(3);
    }

    private final int Dh() {
        return 246 - bv.c(QBaseActivity.sTopActivity);
    }

    private final RecyclerView Eh() {
        return (RecyclerView) this.mListView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(GuildClientSelectListDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Lh(final Function1<? super dd, Unit> onResult) {
        ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getAppRoleList(this.mClientId, this.mAreaId, this.mCookie, new bf() { // from class: com.tencent.mobileqq.guild.client.selectaccount.f
            @Override // vh2.bf
            public final void a(int i3, String str, String str2, List list, String str3, String str4, int i16, dd ddVar, ArrayList arrayList) {
                GuildClientSelectListDialogFragment.Mh(Function1.this, this, i3, str, str2, list, str3, str4, i16, ddVar, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 onResult, GuildClientSelectListDialogFragment this$0, int i3, String str, String str2, List list, String str3, String str4, int i16, dd ddVar, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.safety.j.d("GuildClientSelectListDialogFragment", "queryData | result: " + i3 + " | errMsg: " + str);
        if (i3 == 0 && i16 == 2 && ddVar != null) {
            onResult.invoke(ddVar);
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), this$0.getResources().getString(R.string.f155721i_), 0).show();
        }
    }

    private final void Rh() {
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        String string = getResources().getString(R.string.f155731ia);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026d_select_zone_list_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.mTitleName}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(format);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        view2.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildClientSelectListDialogFragment.Sh(GuildClientSelectListDialogFragment.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(GuildClientSelectListDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final byte[] getCookies() {
        dd ddVar = this.mData;
        if (ddVar != null) {
            return ddVar.getCookie();
        }
        return null;
    }

    private final void initData() {
        this.mCookie = getCookies();
    }

    private final void initView() {
        Rh();
        Eh().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        PlainListAdapter plainListAdapter = new PlainListAdapter();
        this.mAdapter = plainListAdapter;
        plainListAdapter.u0(new Function1<p, Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull p it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildClientSelectListDialogFragment.this.Jh(it);
            }
        });
        PlainListAdapter plainListAdapter2 = this.mAdapter;
        View view = null;
        if (plainListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter2 = null;
        }
        Gh(plainListAdapter2.getData());
        PlainListAdapter plainListAdapter3 = this.mAdapter;
        if (plainListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter3 = null;
        }
        plainListAdapter3.t0(this.mSelectedStr);
        PlainListAdapter plainListAdapter4 = this.mAdapter;
        if (plainListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter4 = null;
        }
        plainListAdapter4.q0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment$initView$2
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
                GuildClientSelectListDialogFragment.this.loadData();
            }
        });
        PlainListAdapter plainListAdapter5 = this.mAdapter;
        if (plainListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter5 = null;
        }
        plainListAdapter5.p0(Hh());
        PlainListAdapter plainListAdapter6 = this.mAdapter;
        if (plainListAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter6 = null;
        }
        plainListAdapter6.s0(Ih());
        RecyclerView Eh = Eh();
        PlainListAdapter plainListAdapter7 = this.mAdapter;
        if (plainListAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter7 = null;
        }
        Eh.setAdapter(plainListAdapter7);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.guild_select_zone_list_decoration, null));
        Eh().addItemDecoration(dividerItemDecoration);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view2;
        }
        view.findViewById(R.id.xpn).getLayoutParams().height = Dh();
    }

    private final void xh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setState(4);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.selectaccount.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildClientSelectListDialogFragment.yh(GuildClientSelectListDialogFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildClientSelectListDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.Ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ch(@NotNull List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PlainListAdapter plainListAdapter = this.mAdapter;
            if (plainListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                plainListAdapter = null;
            }
            List<p> data = plainListAdapter.getData();
            Object obj = list.get(i3);
            Intrinsics.checkNotNull(obj);
            data.add(zh(obj));
        }
    }

    protected void Fh(@NotNull com.google.android.material.bottomsheet.a dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BottomSheetBehavior<FrameLayout> behavior = dialog.getBehavior();
        behavior.setPeekHeight(0);
        behavior.setState(3);
    }

    protected void Gh(@NotNull List<p> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        dd ddVar = this.mData;
        if (ddVar != null) {
            Intrinsics.checkNotNull(ddVar);
            if (ddVar.a() != null) {
                dd ddVar2 = this.mData;
                Intrinsics.checkNotNull(ddVar2);
                ArrayList<db> a16 = ddVar2.a();
                Intrinsics.checkNotNullExpressionValue(a16, "mData!!.areas");
                Ch(a16);
            }
        }
    }

    protected boolean Hh() {
        dd ddVar = this.mData;
        if (ddVar != null) {
            return ddVar.getIsEnd();
        }
        return true;
    }

    protected boolean Ih() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jh(@NotNull p info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.mOnComplete.invoke(info);
        xh();
    }

    public final void Nh(@Nullable dd ddVar) {
        this.mData = ddVar;
    }

    public final void Oh(@Nullable GuildClientSelectZoneDialogFragment guildClientSelectZoneDialogFragment) {
        this.mLastFragment = guildClientSelectZoneDialogFragment;
    }

    public final void Ph(@NotNull Function1<? super p, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.mOnComplete = function1;
    }

    public final void Qh(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSelectedStr = str;
    }

    public final void loadData() {
        Lh(new GuildClientSelectListDialogFragment$loadData$1(this));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ejj, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.mRootView = inflate;
        initView();
        initData();
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Fh((com.google.android.material.bottomsheet.a) dialog);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        view2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildClientSelectListDialogFragment.Kh(GuildClientSelectListDialogFragment.this, view4);
            }
        });
    }

    @NotNull
    public abstract p zh(@NotNull Object data);
}
