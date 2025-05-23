package com.tencent.timi.game.expand.hall.impl.mic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.timi.game.utils.l;
import fm4.g;
import gh4.e;
import gh4.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import ll4.a;
import nl4.b;
import nl4.d;
import nr2.bh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u0004\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001c\u0010\u001f\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00040\u001cH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u000b0#j\b\u0012\u0004\u0012\u00020\u000b`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010*R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020-`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010/R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0#j\b\u0012\u0004\u0012\u00020-`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006B"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicCardView;", "Landroid/widget/FrameLayout;", "Lnl4/b;", "", "", "itemCount", "itemWidth", "", "d", "e", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "data", "g", h.F, "", "isWhiteListUser", "isSelfOnMic", "c", "k", "j", "i", "l", "", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dataList", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "memberMicLevelList", "a", "f", "I", "mItemLeftMargin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mData", "J", "mRoomId", "Lnl4/d;", "Lnl4/d;", "mMicDataListener", "Ljava/util/HashMap;", "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicItemView;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mItemViewRelationPool", "mItemViewList", "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicApplyEntranceView;", "mApplyHintView", "Lnr2/bh;", "D", "Lnr2/bh;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MicCardView extends FrameLayout implements b {
    private static final int F = com.tencent.timi.game.utils.b.a(16);
    private static final int G = com.tencent.timi.game.utils.b.a(16);
    private static final int H = com.tencent.timi.game.utils.b.a(25);
    private static final int I = com.tencent.timi.game.utils.b.a(54);
    private static final int J = com.tencent.timi.game.utils.b.a(45);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MicApplyEntranceView mApplyHintView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final bh binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mItemLeftMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mMicDataListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, MicItemView> mItemViewRelationPool;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MicItemView> mItemViewList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicCardView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(boolean isWhiteListUser, boolean isSelfOnMic) {
        if (isWhiteListUser && isSelfOnMic) {
            k();
        } else {
            j();
        }
    }

    private final void d(int itemCount, int itemWidth) {
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        int i3 = (appScreenWidth - F) - G;
        int i16 = i3 - (itemCount * itemWidth);
        l.b("MicCardView_", "calItemLeftMargin screenWidth:" + appScreenWidth + ", contentWidth:" + i3 + ", remainWidth:" + i16);
        if (i16 < 0) {
            return;
        }
        int i17 = i16 / 5;
        this.mItemLeftMargin = i17;
        l.a("MicCardView_", 1, "calItemLeftMargin mItemLeftMargin:" + i17);
        int i18 = this.mItemLeftMargin;
        int i19 = H;
        if (i18 > i19) {
            this.mItemLeftMargin = i19;
        }
        l.a("MicCardView_", 1, "calItemLeftMargin final mItemLeftMargin:" + this.mItemLeftMargin);
    }

    private final int e(int itemCount, int itemWidth) {
        int appScreenWidth = (((ScreenUtils.getAppScreenWidth() - F) - G) - (itemWidth * itemCount)) - ((itemCount - 2) * this.mItemLeftMargin);
        l.a("MicCardView_", 1, "calRemainSpace remainSpace:" + appScreenWidth);
        if (appScreenWidth < 0) {
            return 0;
        }
        return appScreenWidth;
    }

    private final void g(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> data) {
        this.mData.clear();
        this.mData.addAll(data);
        l.h("MicCardView_", 1, "refreshDataInner mRoomId:" + this.mRoomId + ", mData size:" + this.mData.size());
        h();
    }

    private final void h() {
        boolean z16;
        boolean z17;
        int coerceAtMost;
        e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 != null) {
            z16 = I0.w1();
        } else {
            z16 = false;
        }
        e I02 = ((f) mm4.b.b(f.class)).I0();
        if (I02 != null) {
            z17 = I02.y4();
        } else {
            z17 = false;
        }
        c(z16, z17);
        l.b("MicCardView_", "data size:" + this.mData.size() + ", view size" + this.mItemViewList.size());
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mData.size(), this.mItemViewList.size());
        this.mItemViewRelationPool.clear();
        boolean z18 = false;
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            MicItemView micItemView = this.mItemViewList.get(i3);
            long j3 = this.mRoomId;
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo = this.mData.get(i3);
            Intrinsics.checkNotNullExpressionValue(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, "mData[i]");
            micItemView.f(j3, i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.mData);
            this.mItemViewList.get(i3).setVisibility(0);
            long j16 = this.mData.get(i3).user_id.uid.get();
            long j17 = this.mData.get(i3).user_id.yes_uid.get();
            if (j16 > 0) {
                HashMap<String, MicItemView> hashMap = this.mItemViewRelationPool;
                String o16 = ((a) mm4.b.b(a.class)).o(j16);
                Intrinsics.checkNotNullExpressionValue(o16, "getService(ILoginCoreSer\u2026signedLongToString(qqUid)");
                MicItemView micItemView2 = this.mItemViewList.get(i3);
                Intrinsics.checkNotNullExpressionValue(micItemView2, "mItemViewList[i]");
                hashMap.put(o16, micItemView2);
            }
            HashMap<String, MicItemView> hashMap2 = this.mItemViewRelationPool;
            String o17 = ((a) mm4.b.b(a.class)).o(j17);
            Intrinsics.checkNotNullExpressionValue(o17, "getService(ILoginCoreSer\u2026ignedLongToString(yesUid)");
            MicItemView micItemView3 = this.mItemViewList.get(i3);
            Intrinsics.checkNotNullExpressionValue(micItemView3, "mItemViewList[i]");
            hashMap2.put(o17, micItemView3);
            if (this.mData.get(i3).user_id.yes_uid.get() != 0) {
                z18 = true;
            }
        }
        MicApplyEntranceView micApplyEntranceView = this.mApplyHintView;
        if (micApplyEntranceView != null) {
            micApplyEntranceView.setData(this.mRoomId);
        }
        if (!z16 && !z18) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private final void i() {
        ((g) mm4.b.b(g.class)).k(this.mRoomId).y(this.mMicDataListener);
        ((g) mm4.b.b(g.class)).k(this.mRoomId).l(this.mMicDataListener);
    }

    private final void j() {
        d(6, I);
        int i3 = 0;
        if (this.mItemViewList.isEmpty()) {
            for (int i16 = 0; i16 < 6; i16++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.mItemViewList.add(new MicItemView(context, null, 0, 6, null));
            }
            while (i3 < 6) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(I, (int) getContext().getResources().getDimension(R.dimen.dfl));
                if (i3 != 0) {
                    layoutParams.leftMargin = this.mItemLeftMargin;
                }
                this.binding.f421034b.addView(this.mItemViewList.get(i3), layoutParams);
                i3++;
            }
        } else {
            while (i3 < 6) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(I, (int) getContext().getResources().getDimension(R.dimen.dfl));
                if (i3 != 0) {
                    layoutParams2.leftMargin = this.mItemLeftMargin;
                }
                this.mItemViewList.get(i3).setLayoutParams(layoutParams2);
                i3++;
            }
        }
        MicApplyEntranceView micApplyEntranceView = this.mApplyHintView;
        if (micApplyEntranceView != null) {
            micApplyEntranceView.setVisibility(8);
        }
        invalidate();
    }

    private final void k() {
        d(7, J);
        if (this.mItemViewList.isEmpty()) {
            for (int i3 = 0; i3 < 6; i3++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.mItemViewList.add(new MicItemView(context, null, 0, 6, null));
            }
            for (int i16 = 0; i16 < 6; i16++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(J, (int) getContext().getResources().getDimension(R.dimen.dfl));
                if (i16 != 0) {
                    layoutParams.leftMargin = this.mItemLeftMargin;
                }
                this.binding.f421034b.addView(this.mItemViewList.get(i16), layoutParams);
            }
        } else {
            for (int i17 = 0; i17 < 6; i17++) {
                MicItemView micItemView = this.mItemViewList.get(i17);
                Intrinsics.checkNotNullExpressionValue(micItemView, "mItemViewList[index]");
                MicItemView micItemView2 = micItemView;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(J, (int) getContext().getResources().getDimension(R.dimen.dfl));
                if (i17 != 0) {
                    layoutParams2.leftMargin = this.mItemLeftMargin;
                }
                micItemView2.setLayoutParams(layoutParams2);
            }
        }
        MicApplyEntranceView micApplyEntranceView = this.mApplyHintView;
        if (micApplyEntranceView == null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.mApplyHintView = new MicApplyEntranceView(context2, null, 0, 6, null);
            int i18 = J;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i18, (int) getContext().getResources().getDimension(R.dimen.dfl));
            layoutParams3.leftMargin = e(7, i18);
            layoutParams3.rightMargin = G;
            this.binding.f421034b.addView(this.mApplyHintView, layoutParams3);
        } else {
            if (micApplyEntranceView != null) {
                micApplyEntranceView.setVisibility(0);
            }
            int i19 = J;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i19, (int) getContext().getResources().getDimension(R.dimen.dfl));
            layoutParams4.leftMargin = e(7, i19);
            layoutParams4.rightMargin = G;
            MicApplyEntranceView micApplyEntranceView2 = this.mApplyHintView;
            if (micApplyEntranceView2 != null) {
                micApplyEntranceView2.setLayoutParams(layoutParams4);
            }
        }
        invalidate();
    }

    private final void l() {
        ((g) mm4.b.b(g.class)).k(this.mRoomId).Q(this.mMicDataListener);
        ((g) mm4.b.b(g.class)).k(this.mRoomId).V(this.mMicDataListener);
    }

    @Override // nl4.b
    public void a(@NotNull ConcurrentHashMap<String, Integer> memberMicLevelList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(memberMicLevelList, "memberMicLevelList");
        if (memberMicLevelList.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Integer> entry : memberMicLevelList.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().intValue() >= 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            MicItemView micItemView = this.mItemViewRelationPool.get(key);
            if (z16 && micItemView != null) {
                micItemView.e();
            }
        }
    }

    @Override // nl4.b
    public void b(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        g(dataList);
    }

    public void f() {
        l();
        Iterator<MicItemView> it = this.mItemViewList.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        MicApplyEntranceView micApplyEntranceView = this.mApplyHintView;
        if (micApplyEntranceView != null) {
            micApplyEntranceView.f();
        }
        this.mItemViewRelationPool.clear();
        ph4.e.f426246a.R(this.mRoomId);
    }

    public final void m(long roomId) {
        long j3 = this.mRoomId;
        if (j3 != 0 && j3 != roomId) {
            l();
        }
        this.mRoomId = roomId;
        i();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
        this.mMicDataListener = new d(this);
        this.mItemViewRelationPool = new HashMap<>();
        this.mItemViewList = new ArrayList<>();
        bh g16 = bh.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }
}
