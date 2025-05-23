package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.utils.ba;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* loaded from: classes26.dex */
public class TeamPlayerListView extends RecyclerView implements com.tencent.timi.game.team.impl.main.a {
    private static final String H = "TeamPlayerListView";
    private String C;
    private boolean D;
    private final Set<Long> E;
    private final List<e> F;
    private final yh4.a G;

    /* renamed from: f, reason: collision with root package name */
    private GridLayoutManager f379733f;

    /* renamed from: h, reason: collision with root package name */
    private g f379734h;

    /* renamed from: i, reason: collision with root package name */
    private long f379735i;

    /* renamed from: m, reason: collision with root package name */
    private int f379736m;

    /* loaded from: classes26.dex */
    class a implements yh4.a {
        a() {
        }

        @Override // yh4.a
        public void a(@NotNull List<CommonOuterClass$QQUserId> list, @Nullable String str) {
            String str2;
            TeamPlayerListView.this.E.clear();
            Iterator<CommonOuterClass$QQUserId> it = list.iterator();
            while (it.hasNext()) {
                TeamPlayerListView.this.E.add(Long.valueOf(it.next().yes_uid.get()));
            }
            TeamPlayerListView.this.C = str;
            for (e eVar : TeamPlayerListView.this.F) {
                if (TeamPlayerListView.this.E.contains(Long.valueOf(eVar.b().user_id.yes_uid.get()))) {
                    str2 = TeamPlayerListView.this.C;
                } else {
                    str2 = null;
                }
                eVar.c(str2);
            }
            TeamPlayerListView.this.f379734h.w0(TeamPlayerListView.this.F, ((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamPlayerListView.this.f379735i).U());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379739d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f379740e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f379741f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f379742h;

        c(int i3, int i16, float f16, int i17) {
            this.f379739d = i3;
            this.f379740e = i16;
            this.f379741f = f16;
            this.f379742h = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % this.f379739d;
            if (childAdapterPosition == 0) {
                rect.set(this.f379740e, 0, 0, 0);
            } else {
                rect.set((int) (this.f379740e + (childAdapterPosition * ((this.f379741f + this.f379742h) - (ba.getScreenWidth(TeamPlayerListView.this.getContext()) / this.f379739d)))), 0, 0, 0);
            }
        }
    }

    public TeamPlayerListView(Context context) {
        super(context);
        this.E = new ArraySet();
        this.F = new ArrayList();
        this.G = new a();
        init();
    }

    private void O() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.f379733f = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setHasFixedSize(true);
    }

    private void S(int i3) {
        int i16;
        float dp2px;
        int i17;
        int i18;
        if (this.f379736m != i3) {
            this.f379736m = i3;
            if (i3 <= 5) {
                i16 = i3;
            } else {
                i16 = (int) ((i3 / 2.0f) + 0.5d);
            }
            l.i(H, "updateTotalMemberCount newCount= " + i3 + ", curCount= " + this.f379736m + ", spanCount= " + i16);
            if (this.f379733f.getSpanCount() != i16) {
                this.f379733f.setSpanCount(i16);
            }
            if (i16 <= 2) {
                dp2px = ba.dp2px(getContext(), 60.0f);
            } else if (i16 == 3) {
                dp2px = ba.dp2px(getContext(), 40.0f);
            } else {
                dp2px = ba.dp2px(getContext(), 12.0f);
            }
            int i19 = (int) dp2px;
            float dp2px2 = ba.dp2px(getContext(), 69.0f);
            float f16 = i16 * dp2px2;
            int screenWidth = (int) (((ba.getScreenWidth(getContext()) - (i19 * 2)) - f16) / (i16 - 1));
            if (screenWidth < ba.dp2px(getContext(), 1.0f)) {
                i18 = (int) ba.dp2px(getContext(), 1.0f);
                i17 = (int) (((ba.getScreenWidth(getContext()) - f16) - (r3 * r10)) / 2.0f);
            } else {
                i17 = i19;
                i18 = screenWidth;
            }
            if (getItemDecorationCount() > 0) {
                for (int itemDecorationCount = getItemDecorationCount() - 1; itemDecorationCount >= 0; itemDecorationCount--) {
                    removeItemDecorationAt(itemDecorationCount);
                }
            }
            addItemDecoration(new c(i16, i17, dp2px2, i18));
        }
    }

    private void init() {
        O();
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void A(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379735i = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        K(((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379735i).n());
        S(this.F.size());
        g gVar = new g(getContext(), this.f379735i, this.F, ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379735i).U(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379735i).R(), this.D, teamInfoEx);
        this.f379734h = gVar;
        setAdapter(gVar);
        I();
    }

    public void I() {
        YoloRoomUtil.u(this.f379735i, new b());
    }

    public List<e> K(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        String str;
        ArrayList<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> arrayList = new ArrayList();
        for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : list) {
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.status.get() != 2) {
                arrayList.add(yoloRoomOuterClass$YoloRoomSpeakingPosInfo);
            }
        }
        this.F.clear();
        for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo2 : arrayList) {
            boolean contains = this.E.contains(Long.valueOf(yoloRoomOuterClass$YoloRoomSpeakingPosInfo2.user_id.yes_uid.get()));
            List<e> list2 = this.F;
            if (contains) {
                str = this.C;
            } else {
                str = null;
            }
            list2.add(new e(yoloRoomOuterClass$YoloRoomSpeakingPosInfo2, str));
        }
        return this.F;
    }

    public TeamLaneStateView L() {
        return (TeamLaneStateView) findViewWithTag("TeamLaneStateView");
    }

    public void M(TimiGiftController timiGiftController) {
        timiGiftController.G(this.G);
    }

    public void P(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        this.f379734h.t0(concurrentHashMap);
    }

    public void Q(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379734h.x0(commonOuterClass$QQUserId);
    }

    public void R(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        K(list);
        S(this.F.size());
        this.f379734h.w0(this.F, ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379735i).U());
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void i(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx) {
        l.h(H, 1, "updateData teamInfoEx:" + teamInfoEx);
        g gVar = this.f379734h;
        if (gVar != null) {
            gVar.y0(teamInfoEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setVoiceEnable(boolean z16) {
        this.D = z16;
    }

    public TeamPlayerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = new ArraySet();
        this.F = new ArrayList();
        this.G = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp) {
            if (premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.team_list.get().isEmpty()) {
                return;
            }
            List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list = premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.team_list.get();
            if (list.isEmpty()) {
                return;
            }
            List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list2 = list.get(0).user_list.get();
            if (list2.isEmpty()) {
                return;
            }
            TeamPlayerListView.this.f379734h.z0(list2);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
