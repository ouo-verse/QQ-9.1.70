package com.tencent.av.chatroom;

import android.text.TextUtils;
import tencent.av.chatroom.chatroom_sso$Msg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static long f73518i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f73519j = 1;

    /* renamed from: k, reason: collision with root package name */
    public static int f73520k = 2;

    /* renamed from: l, reason: collision with root package name */
    public static int f73521l = 3;

    /* renamed from: m, reason: collision with root package name */
    public static int f73522m = 4;

    /* renamed from: a, reason: collision with root package name */
    public ChatRoomInfo f73523a;

    /* renamed from: b, reason: collision with root package name */
    public final long f73524b;

    /* renamed from: c, reason: collision with root package name */
    public final String f73525c;

    /* renamed from: d, reason: collision with root package name */
    public final long f73526d = b();

    /* renamed from: e, reason: collision with root package name */
    public long f73527e;

    /* renamed from: f, reason: collision with root package name */
    public int f73528f;

    /* renamed from: g, reason: collision with root package name */
    public long f73529g;

    /* renamed from: h, reason: collision with root package name */
    private int f73530h;

    public a(ChatRoomInfo chatRoomInfo, long j3, String str, long j16, long j17, int i3) {
        this.f73524b = j3;
        this.f73523a = chatRoomInfo;
        this.f73525c = str;
        this.f73527e = j16;
        this.f73529g = j17;
        this.f73528f = i3;
        if (i3 == f73519j) {
            chatRoomInfo.f73509m++;
        }
        this.f73530h = 0;
    }

    private static long b() {
        long j3 = f73518i + 1;
        f73518i = j3;
        return j3;
    }

    public boolean a() {
        if (this.f73528f == f73520k && this.f73530h < 3 && this.f73529g == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f73529g != Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public boolean d(chatroom_sso$Msg chatroom_sso_msg) {
        if (chatroom_sso_msg == null || this.f73529g != chatroom_sso_msg.msg_id.get() || this.f73524b != chatroom_sso_msg.uin.get() || !TextUtils.equals(this.f73525c, chatroom_sso_msg.f435892msg.get())) {
            return false;
        }
        return true;
    }

    public void e() {
        this.f73530h++;
    }

    public void f(int i3) {
        if (i3 == f73521l) {
            this.f73523a.D++;
        } else if (i3 == f73520k) {
            this.f73523a.C++;
        }
        if (this.f73529g == Long.MIN_VALUE || this.f73528f != f73522m) {
            this.f73528f = i3;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(60);
        sb5.append("ChatRoomMsg{senderUin: ");
        sb5.append(this.f73524b);
        sb5.append(", serverSeq: ");
        sb5.append(this.f73529g);
        sb5.append(", localSeq: ");
        sb5.append(this.f73526d);
        sb5.append(", state: ");
        sb5.append(this.f73528f);
        sb5.append("}");
        return sb5.toString();
    }
}
