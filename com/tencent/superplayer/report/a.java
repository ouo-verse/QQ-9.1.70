package com.tencent.superplayer.report;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.SuperPlayerMgr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f373927a = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.superplayer.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9874a implements Comparator<Map.Entry<Integer, Integer>> {
        C9874a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Integer, Integer> entry, Map.Entry<Integer, Integer> entry2) {
            return entry2.getValue().compareTo(entry.getValue());
        }
    }

    public a(Map<String, ISuperPlayer> map, String str) {
        int i3;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ISuperPlayer> entry : map.entrySet()) {
            if (entry.getValue() instanceof SuperPlayerMgr) {
                i3 = ((SuperPlayerMgr) entry.getValue()).getSceneId();
            } else {
                i3 = 200;
            }
            if (hashMap.containsKey(Integer.valueOf(i3))) {
                hashMap.put(Integer.valueOf(i3), Integer.valueOf(((Integer) hashMap.get(Integer.valueOf(i3))).intValue() + 1));
            } else {
                hashMap.put(Integer.valueOf(i3), 1);
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new C9874a());
        int i16 = 0;
        while (i16 < arrayList.size()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("param_instance_scene_top");
            int i17 = i16 + 1;
            sb5.append(i17);
            this.f373927a.put(sb5.toString(), String.valueOf(((Map.Entry) arrayList.get(i16)).getKey()));
            this.f373927a.put("param_instance_cnt_top" + i17, String.valueOf(((Map.Entry) arrayList.get(i16)).getValue()));
            i16 = i17;
        }
        this.f373927a.put("param_sessionid", str);
        this.f373927a.put("param_instance_total_cnt", String.valueOf(map.size()));
    }

    public Map<String, String> a() {
        return this.f373927a;
    }

    public String b() {
        return "SPMemoryEvent";
    }
}
