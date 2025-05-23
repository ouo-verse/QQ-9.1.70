package com.tencent.timi.game.team.impl.setting.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.team.impl.main.LevelSegmentSelectView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigKV;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$ListParam;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamConfigContinuousHolder extends a {
    private Map<String, List<String>> D;
    private List<String> E;
    private TextView F;
    private LevelSegmentSelectView G;

    public TeamConfigContinuousHolder(@NonNull View view) {
        super(view);
        this.D = new HashMap();
        this.E = new ArrayList();
        this.F = (TextView) view.findViewById(R.id.f927858t);
        this.G = (LevelSegmentSelectView) view.findViewById(R.id.f927758s);
    }

    private void q(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem) {
        t();
        List<YesGameInfoOuterClass$GameConfigKV> list = yesGameInfoOuterClass$GameConfigItem.f437255kv.get();
        if (list.isEmpty()) {
            return;
        }
        this.D.clear();
        for (YesGameInfoOuterClass$GameConfigKV yesGameInfoOuterClass$GameConfigKV : list) {
            this.E.add(yesGameInfoOuterClass$GameConfigKV.key.get());
            this.D.put(yesGameInfoOuterClass$GameConfigKV.key.get(), yesGameInfoOuterClass$GameConfigKV.value.get());
        }
        this.G.y(this.E);
        this.G.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.setting.ui.TeamConfigContinuousHolder.2
            @Override // java.lang.Runnable
            public void run() {
                TeamConfigContinuousHolder.this.u();
            }
        });
    }

    private int r(String str) {
        return this.E.indexOf(str);
    }

    private int s(String str) {
        for (String str2 : this.D.keySet()) {
            if (this.D.get(str2).contains(str)) {
                return this.E.indexOf(str2);
            }
        }
        return 0;
    }

    private void t() {
        String str = this.f379675e.f379564i.team_info.main_hue.get();
        String str2 = this.f379675e.f379564i.team_info.unselected_bg_hue.get();
        String str3 = this.f379675e.f379564i.team_info.text_hue.get();
        String str4 = this.f379675e.f379564i.team_info.text_sub_hue.get();
        if (yn4.a.a(str) && yn4.a.a(str2) && yn4.a.a(str3) && yn4.a.a(str4)) {
            this.G.v(str, str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int i3;
        int i16;
        if (l()) {
            if (m()) {
                YesGameInfoOuterClass$GameConfigLinkageOption j3 = j();
                if (j3 == null) {
                    return;
                }
                this.G.setRankMode(r(j3.key.get(0)), r(j3.key.get(r3.size() - 1)), j3.limit.get());
                return;
            }
            this.G.setMatchMode(0, this.D.size() - 1);
            return;
        }
        if (m()) {
            YesGameInfoOuterClass$GameConfigLinkageOption j16 = j();
            if (j16 == null) {
                return;
            }
            List<String> k3 = k();
            int s16 = s(k3.get(0));
            int s17 = s(k3.get(k3.size() - 1));
            int r16 = r(j16.key.get(0));
            int r17 = r(j16.key.get(r1.size() - 1));
            if (s16 < r16) {
                i3 = r16;
            } else {
                i3 = s16;
            }
            if (s17 > r17) {
                i16 = r17;
            } else {
                i16 = s17;
            }
            this.G.setRankMode(i3, i16, r16, r17, j16.limit.get());
            return;
        }
        List<String> k16 = k();
        if (!k16.isEmpty()) {
            this.G.setMatchMode(s(k16.get(0)), s(k16.get(k16.size() - 1)));
        }
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void c(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        super.c(yesGameInfoOuterClass$GameConfigItem, dVar, list, i3);
        d(yesGameInfoOuterClass$GameConfigItem, this.F);
        q(yesGameInfoOuterClass$GameConfigItem);
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void g(YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
        YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam = new YoloRoomOuterClass$ListParam();
        yoloRoomOuterClass$ListParam.index.set(this.C);
        Iterator<String> it = this.G.n().iterator();
        while (it.hasNext()) {
            yoloRoomOuterClass$ListParam.value.addAll(this.D.get(it.next()));
        }
        yoloRoomOuterClass$YoloGameRoomParams.list_param_list.add(yoloRoomOuterClass$ListParam);
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void n(List<YesGameInfoOuterClass$GameConfigLinkageOption> list) {
        super.n(list);
        this.G.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.setting.ui.TeamConfigContinuousHolder.1
            @Override // java.lang.Runnable
            public void run() {
                TeamConfigContinuousHolder.this.u();
            }
        });
    }
}
