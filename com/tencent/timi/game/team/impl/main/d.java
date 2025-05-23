package com.tencent.timi.game.team.impl.main;

import fm4.TeamCreatePageParam;
import fm4.h;
import java.util.List;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigRsp;
import trpc.yes.common.YoloRoomOuterClass$ListParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f379556a;

    /* renamed from: b, reason: collision with root package name */
    public int f379557b;

    /* renamed from: c, reason: collision with root package name */
    public long f379558c;

    /* renamed from: d, reason: collision with root package name */
    public fm4.c f379559d;

    /* renamed from: e, reason: collision with root package name */
    public h f379560e;

    /* renamed from: f, reason: collision with root package name */
    public long f379561f;

    /* renamed from: g, reason: collision with root package name */
    public String f379562g;

    /* renamed from: h, reason: collision with root package name */
    public int f379563h;

    /* renamed from: i, reason: collision with root package name */
    public YesGameInfoOuterClass$GetTeamConfigRsp f379564i;

    /* renamed from: j, reason: collision with root package name */
    public long f379565j;

    /* renamed from: k, reason: collision with root package name */
    public CommonOuterClass$QQUserId f379566k;

    /* renamed from: l, reason: collision with root package name */
    public String f379567l;

    /* renamed from: m, reason: collision with root package name */
    public List<YoloRoomOuterClass$ListParam> f379568m;

    /* renamed from: n, reason: collision with root package name */
    public TeamCreatePageParam f379569n;

    public d(int i3, long j3, String str, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp, List<YoloRoomOuterClass$ListParam> list) {
        this.f379563h = i3;
        this.f379561f = j3;
        this.f379562g = str;
        this.f379568m = list;
        this.f379564i = yesGameInfoOuterClass$GetTeamConfigRsp;
    }

    public static d a(int i3, int i16, long j3, fm4.c cVar, h hVar, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamCreatePageParam teamCreatePageParam, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp) {
        return new d(i3, i16, j3, cVar, hVar, 0L, null, j16, commonOuterClass$QQUserId, str, teamCreatePageParam, yesGameInfoOuterClass$GetTeamConfigRsp);
    }

    public static d b(int i3, long j3, String str, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp, List<YoloRoomOuterClass$ListParam> list) {
        return new d(i3, j3, str, yesGameInfoOuterClass$GetTeamConfigRsp, list);
    }

    public d(int i3, int i16, long j3, fm4.c cVar, h hVar, long j16, String str, long j17, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str2, TeamCreatePageParam teamCreatePageParam, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp) {
        this.f379563h = yesGameInfoOuterClass$GetTeamConfigRsp.game_id.get();
        this.f379556a = i3;
        this.f379557b = i16;
        this.f379558c = j3;
        this.f379559d = cVar;
        this.f379560e = hVar;
        this.f379561f = j16;
        this.f379562g = str;
        this.f379565j = j17;
        this.f379566k = commonOuterClass$QQUserId;
        this.f379567l = str2;
        this.f379569n = teamCreatePageParam;
        this.f379564i = yesGameInfoOuterClass$GetTeamConfigRsp;
    }
}
