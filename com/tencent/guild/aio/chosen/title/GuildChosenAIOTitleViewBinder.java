package com.tencent.guild.aio.chosen.title;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.chosen.title.g;
import com.tencent.guild.aio.title.GuildAioTitleBackBtnUIState;
import com.tencent.guild.aio.title.GuildAioTitleMultiSelectUIState;
import com.tencent.guild.aio.title.GuildAioTitleTextUIState;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn0.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001a0\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "Lor0/a;", "", "l1", "i1", "g1", "", GlobalUtil.DEF_STRING, "h1", "selectState", "f1", "isSelectMode", "j1", "o1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "bindViewAndData", "onThemeChanged", "", "Ljava/lang/Class;", "getObserverStates", "state", "k1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvn0/r;", "d", "Lvn0/r;", "mBinding", "e", "Z", "isMultiSelectMode", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenAIOTitleViewBinder extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> implements or0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private r mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isMultiSelectMode;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110122a;

        static {
            int[] iArr = new int[IGuildAioTitleUIState.TYPE.values().length];
            try {
                iArr[IGuildAioTitleUIState.TYPE.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.MULTISELECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.BACKBTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.EMPTY_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f110122a = iArr;
        }
    }

    private final void f1(boolean selectState) {
        if (!selectState) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) mContext).onBackPressed();
        }
    }

    private final void g1() {
        sendIntent(new c.k(false));
        j1(false);
    }

    private final void h1(boolean empty) {
        int i3;
        r rVar = this.mBinding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar = null;
        }
        ImageView imageView = rVar.f442018d;
        if (!empty && !this.isMultiSelectMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        sendIntent(new g.a());
    }

    private final void j1(boolean isSelectMode) {
        int i3;
        r rVar = this.mBinding;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar = null;
        }
        TextView textView = rVar.f442019e;
        int i16 = 0;
        if (isSelectMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        r rVar3 = this.mBinding;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            rVar2 = rVar3;
        }
        ImageView imageView = rVar2.f442018d;
        if (isSelectMode) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    private final void l1() {
        sendIntent(new g.b());
        r rVar = this.mBinding;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar = null;
        }
        rVar.f442020f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.chosen.title.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildChosenAIOTitleViewBinder.m1(GuildChosenAIOTitleViewBinder.this, view);
            }
        });
        r rVar3 = this.mBinding;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar3 = null;
        }
        final ImageView imageView = rVar3.f442018d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.guildChosenMoreImage");
        final long j3 = 200;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.chosen.title.GuildChosenAIOTitleViewBinder$init$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                imageView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.i1();
                final View view = imageView;
                view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.chosen.title.GuildChosenAIOTitleViewBinder$init$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        r rVar4 = this.mBinding;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            rVar2 = rVar4;
        }
        rVar2.f442019e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.chosen.title.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildChosenAIOTitleViewBinder.n1(GuildChosenAIOTitleViewBinder.this, view);
            }
        });
        o1();
        QQGuildThemeManager.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(GuildChosenAIOTitleViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new c.l());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(GuildChosenAIOTitleViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o1() {
        sq0.a aVar = sq0.a.f434200a;
        r rVar = this.mBinding;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar = null;
        }
        RelativeLayout root = rVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        aVar.b(root);
        r rVar3 = this.mBinding;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            rVar3 = null;
        }
        rVar3.f442018d.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.guild_articlemsg_more_icon, Integer.valueOf(aVar.a())));
        r rVar4 = this.mBinding;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            rVar2 = rVar4;
        }
        rVar2.f442020f.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.guild_skin_left_arrow, Integer.valueOf(aVar.a())));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        l1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> getViewModel() {
        return new GuildChosenAIOTitleViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends IGuildAioTitleUIState>> getObserverStates() {
        List<Class<? extends IGuildAioTitleUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAioTitleTextUIState.class, GuildAioTitleMultiSelectUIState.class, GuildAioTitleBackBtnUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull IGuildAioTitleUIState state) {
        GuildChosenAIOTitleViewBinder guildChosenAIOTitleViewBinder;
        Intrinsics.checkNotNullParameter(state, "state");
        r rVar = null;
        if (!state.getResult()) {
            guildChosenAIOTitleViewBinder = this;
        } else {
            guildChosenAIOTitleViewBinder = null;
        }
        if (guildChosenAIOTitleViewBinder != null) {
            return;
        }
        int i3 = b.f110122a[state.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        h1(((GuildAioTitleEmptyDataUIState) state).getCom.tencent.tmassistantbase.util.GlobalUtil.DEF_STRING java.lang.String());
                        return;
                    }
                    return;
                }
                f1(((GuildAioTitleBackBtnUIState) state).getMultistate());
                return;
            }
            boolean isMultiSelectMode = ((GuildAioTitleMultiSelectUIState) state).getIsMultiSelectMode();
            this.isMultiSelectMode = isMultiSelectMode;
            j1(isMultiSelectMode);
            return;
        }
        GuildAioTitleTextUIState guildAioTitleTextUIState = (GuildAioTitleTextUIState) state;
        r rVar2 = this.mBinding;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            rVar = rVar2;
        }
        rVar.f442021g.setText(guildAioTitleTextUIState.getName());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        r g16 = r.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mBinding = g16;
        r rVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        View view = g16.f442016b;
        Intrinsics.checkNotNullExpressionValue(view, "mBinding.fakeStatusBar");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, 0);
        }
        layoutParams.height = ImmersiveUtils.getStatusBarHeight(getMContext());
        view.setLayoutParams(layoutParams);
        r rVar2 = this.mBinding;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            rVar = rVar2;
        }
        RelativeLayout root = rVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this);
    }

    @Override // or0.a
    public void onThemeChanged() {
        o1();
    }
}
