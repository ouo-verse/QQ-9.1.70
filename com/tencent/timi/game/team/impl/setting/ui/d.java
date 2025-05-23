package com.tencent.timi.game.team.impl.setting.ui;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.team.impl.main.TeamSelectView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigKV;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$ListParam;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends a implements TeamSelectView.c, TeamSelectView.b {
    private TextView D;
    private TextView E;
    private TeamSelectView F;
    private boolean G;
    private YesGameInfoOuterClass$GameConfigItem H;

    public d(@NonNull View view, boolean z16) {
        super(view);
        int i3;
        this.G = z16;
        this.D = (TextView) view.findViewById(R.id.f9288593);
        TextView textView = (TextView) view.findViewById(R.id.f9287592);
        this.E = textView;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TeamSelectView teamSelectView = (TeamSelectView) view.findViewById(R.id.f9286591);
        this.F = teamSelectView;
        teamSelectView.setMode(z16 ? 1 : 0);
        if (z16) {
            this.F.setOnMultiSelectedListener(this);
        } else {
            this.F.setOnSingleSelectedListener(this);
        }
    }

    private void p(List<TeamSelectView.a> list, YesGameInfoOuterClass$GameConfigKV yesGameInfoOuterClass$GameConfigKV, String str, String str2) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && !TextUtils.isEmpty(str2) && w(str2)) {
            TeamSelectView.a aVar = new TeamSelectView.a(Integer.parseInt(str), str2);
            y(list, yesGameInfoOuterClass$GameConfigKV, aVar);
            boolean z16 = true;
            if (yesGameInfoOuterClass$GameConfigKV.type.get() != 1) {
                z16 = false;
            }
            aVar.f379552e = z16;
            aVar.f379553f = yesGameInfoOuterClass$GameConfigKV;
            list.add(aVar);
        }
    }

    private void q(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem) {
        this.F.g(this.f379675e.f379564i.team_info.main_hue.get(), this.f379675e.f379564i.team_info.text_sub_hue.get(), this.f379675e.f379564i.team_info.selected_bg_hue.get(), this.f379675e.f379564i.team_info.unselected_bg_hue.get());
        ArrayList arrayList = new ArrayList();
        for (YesGameInfoOuterClass$GameConfigKV yesGameInfoOuterClass$GameConfigKV : yesGameInfoOuterClass$GameConfigItem.f437255kv.get()) {
            p(arrayList, yesGameInfoOuterClass$GameConfigKV, yesGameInfoOuterClass$GameConfigKV.value.get(0), yesGameInfoOuterClass$GameConfigKV.key.get());
        }
        v(arrayList);
        this.F.a(arrayList);
    }

    private void r(TextView textView) {
        String str = this.f379675e.f379564i.team_info.text_sub_hue.get();
        if (yn4.a.a(str)) {
            textView.setTextColor(Color.parseColor(str));
        }
    }

    @NonNull
    private YoloRoomOuterClass$ListParam s(List<TeamSelectView.a> list) {
        YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam = new YoloRoomOuterClass$ListParam();
        yoloRoomOuterClass$ListParam.index.set(this.H.index.get());
        ArrayList arrayList = new ArrayList();
        Iterator<TeamSelectView.a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().f379549b));
        }
        yoloRoomOuterClass$ListParam.value.set(arrayList);
        return yoloRoomOuterClass$ListParam;
    }

    @NonNull
    private YoloRoomOuterClass$ListParam t(TeamSelectView.a aVar) {
        YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam = new YoloRoomOuterClass$ListParam();
        if (aVar == null) {
            return yoloRoomOuterClass$ListParam;
        }
        yoloRoomOuterClass$ListParam.index.set(this.H.index.get());
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(aVar.f379549b));
        yoloRoomOuterClass$ListParam.value.set(arrayList);
        return yoloRoomOuterClass$ListParam;
    }

    private void u(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem) {
        this.H = yesGameInfoOuterClass$GameConfigItem;
    }

    private void v(List<TeamSelectView.a> list) {
        boolean z16;
        Iterator<TeamSelectView.a> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().f379551d) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16 && !list.isEmpty()) {
            list.get(0).f379551d = true;
        }
    }

    private boolean w(String str) {
        if (!m()) {
            return true;
        }
        YesGameInfoOuterClass$GameConfigLinkageOption j3 = j();
        if (j3 != null && j3.key.get().contains(str)) {
            return true;
        }
        return false;
    }

    private boolean x(TeamSelectView.a aVar) {
        List<String> k3 = k();
        if (!k3.isEmpty()) {
            Iterator<String> it = k3.iterator();
            while (it.hasNext()) {
                if (aVar.f379549b == Integer.parseInt(it.next())) {
                    aVar.f379551d = true;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void y(List<TeamSelectView.a> list, YesGameInfoOuterClass$GameConfigKV yesGameInfoOuterClass$GameConfigKV, TeamSelectView.a aVar) {
        if (l()) {
            if (z(list, aVar) && this.f379674d != null && yesGameInfoOuterClass$GameConfigKV.linkage.has()) {
                this.f379674d.a(yesGameInfoOuterClass$GameConfigKV.linkage.get(), true);
                return;
            }
            return;
        }
        if (x(aVar) && this.f379674d != null && yesGameInfoOuterClass$GameConfigKV.linkage.has()) {
            this.f379674d.a(yesGameInfoOuterClass$GameConfigKV.linkage.get(), true);
        }
    }

    private boolean z(List<TeamSelectView.a> list, TeamSelectView.a aVar) {
        if (list.isEmpty()) {
            aVar.f379551d = true;
            return true;
        }
        return false;
    }

    @Override // com.tencent.timi.game.team.impl.main.TeamSelectView.c
    public void a(TeamSelectView.a aVar) {
        YesGameInfoOuterClass$GameConfigKV yesGameInfoOuterClass$GameConfigKV = (YesGameInfoOuterClass$GameConfigKV) aVar.f379553f;
        if (this.f379674d != null && yesGameInfoOuterClass$GameConfigKV != null && yesGameInfoOuterClass$GameConfigKV.has()) {
            this.f379674d.a(yesGameInfoOuterClass$GameConfigKV.linkage.get(), false);
        }
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void c(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        super.c(yesGameInfoOuterClass$GameConfigItem, dVar, list, i3);
        u(yesGameInfoOuterClass$GameConfigItem);
        d(yesGameInfoOuterClass$GameConfigItem, this.D);
        r(this.E);
        q(yesGameInfoOuterClass$GameConfigItem);
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void g(YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
        YoloRoomOuterClass$ListParam t16;
        if (this.G) {
            t16 = s(this.F.e());
        } else {
            t16 = t(this.F.d());
        }
        yoloRoomOuterClass$YoloGameRoomParams.list_param_list.add(t16);
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void n(List<YesGameInfoOuterClass$GameConfigLinkageOption> list) {
        super.n(list);
        q(this.H);
    }

    @Override // com.tencent.timi.game.team.impl.main.TeamSelectView.b
    public void b(List<TeamSelectView.a> list) {
    }
}
