package com.tencent.now.od.ui.gift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.now.od.ui.common.widget.RoundImageView;
import com.tencent.now.od.ui.gift.ODGiftPersonsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tl.h;

@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001N\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0003]^_B\u0011\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UB\u001b\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u00a2\u0006\u0004\bT\u0010XB#\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u0012\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\bT\u0010[J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0002R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0018\u00010\u001cR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001f\u0010%\u001a\u00060 R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010+R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010ER$\u0010M\u001a\u00020@2\u0006\u0010I\u001a\u00020@8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bJ\u0010B\"\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006`"}, d2 = {"Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/now/od/ui/gift/a;", "", "roomId", "uid", "", "t0", "Lon3/b;", "game", "setData", "Landroid/view/View;", "getView", "P0", "Lcom/tencent/now/od/ui/gift/b;", "callback", "setUserSelectedCallback", NodeProps.ON_DETACHED_FROM_WINDOW, "Q0", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "d", "Lorg/slf4j/Logger;", "logger", "Lon3/c;", "e", "Lon3/c;", "selectedSeat", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder;", "f", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder;", "selectedViewHolder", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$b;", h.F, "Lkotlin/Lazy;", "O0", "()Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$b;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "personRv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "clickToSelectTargetArea", "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", "giftSelectedUserHead", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "giftSelectedUserName", "E", "presentResultsToChooseArea", UserInfo.SEX_FEMALE, "Lon3/b;", "G", "Lcom/tencent/now/od/ui/gift/b;", "selectedCallback", "", "H", "Ljava/util/List;", "list", "", "I", "Z", "isAniming", "Landroid/animation/AnimatorSet;", "J", "Landroid/animation/AnimatorSet;", "animator", "K", "value", "L", "R0", "(Z)V", "showChoseResult", "com/tencent/now/od/ui/gift/ODGiftPersonsBar$c", "M", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$c;", "meleeVipListObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "b", "PersonViewHolder", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ODGiftPersonsBar extends ConstraintLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private RoundImageView giftSelectedUserHead;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView giftSelectedUserName;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View presentResultsToChooseArea;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private on3.b game;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.now.od.ui.gift.b selectedCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private List<? extends on3.c> list;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isAniming;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet animator;

    /* renamed from: K, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean showChoseResult;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c meleeVipListObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Logger logger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private on3.c selectedSeat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PersonViewHolder selectedViewHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView personRv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View clickToSelectTargetArea;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\t\u001a\u00060\u0007R\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder;", "Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar;", "i0", "getItemCount", "holder", "position", "", "onBindViewHolder", "<init>", "(Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar;)V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List list = ODGiftPersonsBar.this.list;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public PersonViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new PersonViewHolder();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            on3.c cVar;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof PersonViewHolder) {
                List list = ODGiftPersonsBar.this.list;
                if (list != null && (cVar = (on3.c) list.get(position)) != null) {
                    ((PersonViewHolder) holder).n(cVar);
                    return;
                }
                return;
            }
            ODGiftPersonsBar.this.logger.error("holder type is invalid! holder:" + holder);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/now/od/ui/gift/ODGiftPersonsBar$c", "", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c {
        c() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ODGiftPersonsBar(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.logger = LoggerFactory.getLogger("ODGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.now.od.ui.gift.ODGiftPersonsBar$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ODGiftPersonsBar.b invoke() {
                return new ODGiftPersonsBar.b();
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        this.meleeVipListObserver = new c();
        View.inflate(getContext(), R.layout.i3v, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.personRv = recyclerView;
        vn3.a.d(recyclerView, pn3.a.f426525m.b());
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        vn3.a.d(findViewById2, pn3.a.f426521k.b());
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        vn3.a.d(findViewById5, pn3.a.f426523l.b());
        View findViewById6 = findViewById(R.id.f81924fh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.selectArrow)");
        vn3.a.c((ImageView) findViewById6, pn3.a.f426519j.b());
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.od.ui.gift.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ODGiftPersonsBar.A0(ODGiftPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(O0());
        R0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ODGiftPersonsBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R0(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final b O0() {
        return (b) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        long j3;
        on3.c cVar = this.selectedSeat;
        if (cVar != null) {
            cVar.getUser();
        }
        on3.c cVar2 = this.selectedSeat;
        if (cVar2 != null) {
            cVar2.getUser();
        }
        int i3 = 0;
        if (TextUtils.isEmpty(null)) {
            this.giftSelectedUserHead.setVisibility(8);
        } else {
            this.giftSelectedUserHead.setVisibility(0);
            ImageLoader.getInstance().displayImage((String) null, this.giftSelectedUserHead);
        }
        if (TextUtils.isEmpty(null)) {
            this.giftSelectedUserName.setText("\u9009\u62e9\u9001\u793c\u5bf9\u8c61");
        } else {
            this.giftSelectedUserName.setText((CharSequence) null);
        }
        com.tencent.now.od.ui.gift.b bVar = this.selectedCallback;
        if (bVar != null) {
            on3.c cVar3 = this.selectedSeat;
            if (cVar3 != null) {
                j3 = cVar3.h();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            on3.c cVar4 = this.selectedSeat;
            if (cVar4 != null) {
                cVar4.getUser();
            }
            on3.c cVar5 = this.selectedSeat;
            if (cVar5 != null) {
                cVar5.getUser();
            }
            on3.c cVar6 = this.selectedSeat;
            if (cVar6 != null) {
                i3 = cVar6.b();
            }
            int i16 = i3;
            on3.b bVar2 = this.game;
            if (bVar2 != null) {
                bVar2.a();
            }
            bVar.a(j16, "", "", i16, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(boolean z16) {
        int i3;
        this.showChoseResult = z16;
        RecyclerView recyclerView = this.personRv;
        int i16 = 8;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        recyclerView.setVisibility(i3);
        View view = this.presentResultsToChooseArea;
        if (z16) {
            i16 = 0;
        }
        view.setVisibility(i16);
    }

    public final void P0() {
        O0().notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        on3.b bVar = this.game;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void setData(@NotNull on3.b game) {
        Intrinsics.checkNotNullParameter(game, "game");
        this.game = game;
        game.a();
        throw null;
    }

    @Override // com.tencent.now.od.ui.gift.a
    public void setUserSelectedCallback(@NotNull com.tencent.now.od.ui.gift.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.selectedCallback = callback;
    }

    @Override // com.tencent.now.od.ui.gift.a
    public void t0(long roomId, long uid) {
        on3.b bVar;
        this.roomId = roomId;
        if (uid != 0 && (bVar = this.game) != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.now.od.ui.gift.a
    @NotNull
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n \u0011*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "end", "p", "Lon3/c;", "seat", ReportConstant.COSTREPORT_PREFIX, "r", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "personHeadIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "personLabel", "G", "Landroid/view/View;", "headSelectedBg", "H", "nameTv", "I", "Lon3/c;", "curSeat", "<init>", "(Lcom/tencent/now/od/ui/gift/ODGiftPersonsBar;)V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public final class PersonViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView personHeadIv;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView personLabel;

        /* renamed from: G, reason: from kotlin metadata */
        private final View headSelectedBg;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView nameTv;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private on3.c curSeat;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"com/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder$b", "Landroid/util/Property;", "Landroid/view/View;", "", "object", "a", "(Landroid/view/View;)Ljava/lang/Float;", "animView", "value", "", "b", UserInfo.SEX_FEMALE, "w", h.F, "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes22.dex */
        public static final class b extends Property<View, Float> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private float w;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private float h;

            b(Class<Float> cls) {
                super(cls, "");
            }

            @Override // android.util.Property
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(@NotNull View object) {
                Intrinsics.checkNotNullParameter(object, "object");
                return Float.valueOf(object.getRotation());
            }

            public void b(@NotNull View animView, float value) {
                boolean z16;
                Intrinsics.checkNotNullParameter(animView, "animView");
                boolean z17 = true;
                if (this.w == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    float width = (animView.getWidth() / 5.0f) * 2;
                    this.w = width;
                    animView.setPivotX(width);
                }
                if (this.h != 0.0f) {
                    z17 = false;
                }
                if (z17) {
                    float height = animView.getHeight() * 1.0f;
                    this.h = height;
                    animView.setPivotY(height);
                }
                animView.setRotation(value);
            }

            @Override // android.util.Property
            public /* bridge */ /* synthetic */ void set(View view, Float f16) {
                b(view, f16.floatValue());
            }
        }

        public PersonViewHolder() {
            super(View.inflate(ODGiftPersonsBar.this.getContext(), R.layout.fd9, null));
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f2411089);
            this.personHeadIv = imageView;
            this.personLabel = (TextView) this.itemView.findViewById(R.id.f241208_);
            this.headSelectedBg = this.itemView.findViewById(R.id.x7u);
            this.nameTv = (TextView) this.itemView.findViewById(R.id.zlz);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.od.ui.gift.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ODGiftPersonsBar.PersonViewHolder.m(ODGiftPersonsBar.PersonViewHolder.this, r2, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(PersonViewHolder this$0, final ODGiftPersonsBar this$1, View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            on3.c cVar = this$0.curSeat;
            if (cVar != null) {
                long j3 = 0;
                int i3 = 0;
                if (cVar.h() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    cVar = null;
                }
                if (cVar != null && !this$1.isAniming) {
                    this$1.selectedSeat = cVar;
                    PersonViewHolder personViewHolder = this$1.selectedViewHolder;
                    this$1.selectedViewHolder = this$0;
                    com.tencent.now.od.ui.gift.b bVar = this$1.selectedCallback;
                    if (bVar != null) {
                        on3.c cVar2 = this$1.selectedSeat;
                        if (cVar2 != null) {
                            j3 = cVar2.h();
                        }
                        long j16 = j3;
                        on3.c cVar3 = this$1.selectedSeat;
                        if (cVar3 != null) {
                            cVar3.getUser();
                        }
                        on3.c cVar4 = this$1.selectedSeat;
                        if (cVar4 != null) {
                            cVar4.getUser();
                        }
                        on3.c cVar5 = this$1.selectedSeat;
                        if (cVar5 != null) {
                            i3 = cVar5.b();
                        }
                        int i16 = i3;
                        on3.b bVar2 = this$1.game;
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                        bVar.a(j16, "", "", i16, 0L);
                    }
                    if (personViewHolder != null) {
                        personViewHolder.q();
                    }
                    this$0.q();
                    View headSelectedBg = this$0.headSelectedBg;
                    Intrinsics.checkNotNullExpressionValue(headSelectedBg, "headSelectedBg");
                    this$0.p(headSelectedBg, new Function0<Unit>() { // from class: com.tencent.now.od.ui.gift.ODGiftPersonsBar$PersonViewHolder$1$2$1
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
                            ODGiftPersonsBar.this.R0(true);
                            ODGiftPersonsBar.this.P0();
                            ODGiftPersonsBar.this.Q0();
                        }
                    });
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final boolean o(on3.c seat) {
            if (seat.b() == 3) {
                return true;
            }
            return false;
        }

        private final void p(View view, Function0<Unit> end) {
            if (ODGiftPersonsBar.this.isAniming) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.95f, 0.85f, 0.95f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.95f, 0.85f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, new b(Float.TYPE), 0.0f, 25.0f, 0.0f, -8.0f, 8.0f, -3.0f, 3.0f, 0.0f);
            ODGiftPersonsBar oDGiftPersonsBar = ODGiftPersonsBar.this;
            AnimatorSet animatorSet = new AnimatorSet();
            ODGiftPersonsBar oDGiftPersonsBar2 = ODGiftPersonsBar.this;
            animatorSet.setDuration(800L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            animatorSet.addListener(new a(oDGiftPersonsBar2, end));
            animatorSet.start();
            oDGiftPersonsBar.animator = animatorSet;
        }

        private final void r(on3.c seat) {
            boolean z16;
            seat.getUser();
            on3.c cVar = ODGiftPersonsBar.this.selectedSeat;
            if (cVar != null && seat.h() == cVar.h()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.headSelectedBg.setBackgroundResource(R.drawable.lqn);
            } else {
                this.headSelectedBg.setBackgroundResource(0);
            }
        }

        private final void s(on3.c seat) {
            on3.c cVar = ODGiftPersonsBar.this.selectedSeat;
            if (cVar != null) {
                seat.h();
                cVar.h();
            }
            if (o(seat)) {
                this.personLabel.setText("");
                this.personLabel.setVisibility(8);
            } else {
                this.personLabel.setText("" + seat.a());
                this.personLabel.setVisibility(0);
            }
            TextView textView = this.nameTv;
            seat.getUser();
            textView.setText("");
            this.nameTv.setTextColor(-1);
            this.personLabel.setBackgroundResource(R.drawable.lqr);
        }

        public final void n(@Nullable on3.c seat) {
            if (seat != null) {
                on3.c cVar = ODGiftPersonsBar.this.selectedSeat;
                boolean z16 = false;
                if (cVar != null && seat.h() == cVar.h()) {
                    z16 = true;
                }
                if (z16) {
                    ODGiftPersonsBar.this.selectedViewHolder = this;
                }
                this.curSeat = seat;
                r(seat);
                s(seat);
            }
        }

        public final void q() {
            on3.c cVar = this.curSeat;
            if (cVar != null) {
                n(cVar);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/now/od/ui/gift/ODGiftPersonsBar$PersonViewHolder$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes22.dex */
        public static final class a implements Animator.AnimatorListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ODGiftPersonsBar f338618d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f338619e;

            a(ODGiftPersonsBar oDGiftPersonsBar, Function0<Unit> function0) {
                this.f338618d = oDGiftPersonsBar;
                this.f338619e = function0;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animation) {
                this.f338618d.isAniming = false;
                this.f338618d.animator = null;
                this.f338619e.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
                this.f338618d.isAniming = false;
                this.f338618d.animator = null;
                this.f338619e.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animation) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ODGiftPersonsBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.logger = LoggerFactory.getLogger("ODGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.now.od.ui.gift.ODGiftPersonsBar$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ODGiftPersonsBar.b invoke() {
                return new ODGiftPersonsBar.b();
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        this.meleeVipListObserver = new c();
        View.inflate(getContext(), R.layout.i3v, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.personRv = recyclerView;
        vn3.a.d(recyclerView, pn3.a.f426525m.b());
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        vn3.a.d(findViewById2, pn3.a.f426521k.b());
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        vn3.a.d(findViewById5, pn3.a.f426523l.b());
        View findViewById6 = findViewById(R.id.f81924fh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.selectArrow)");
        vn3.a.c((ImageView) findViewById6, pn3.a.f426519j.b());
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.od.ui.gift.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ODGiftPersonsBar.A0(ODGiftPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(O0());
        R0(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ODGiftPersonsBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.logger = LoggerFactory.getLogger("ODGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.now.od.ui.gift.ODGiftPersonsBar$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ODGiftPersonsBar.b invoke() {
                return new ODGiftPersonsBar.b();
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        this.meleeVipListObserver = new c();
        View.inflate(getContext(), R.layout.i3v, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.personRv = recyclerView;
        vn3.a.d(recyclerView, pn3.a.f426525m.b());
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        vn3.a.d(findViewById2, pn3.a.f426521k.b());
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        vn3.a.d(findViewById5, pn3.a.f426523l.b());
        View findViewById6 = findViewById(R.id.f81924fh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.selectArrow)");
        vn3.a.c((ImageView) findViewById6, pn3.a.f426519j.b());
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.od.ui.gift.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ODGiftPersonsBar.A0(ODGiftPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(O0());
        R0(true);
    }
}
