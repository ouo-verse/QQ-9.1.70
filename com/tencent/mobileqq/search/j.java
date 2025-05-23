package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class j implements l {

    /* renamed from: a, reason: collision with root package name */
    protected long f283439a;

    /* renamed from: b, reason: collision with root package name */
    protected long f283440b = -1;

    /* renamed from: c, reason: collision with root package name */
    protected long f283441c;

    /* renamed from: d, reason: collision with root package name */
    protected long f283442d;

    /* renamed from: e, reason: collision with root package name */
    public static long f283416e = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: f, reason: collision with root package name */
    public static long f283418f = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: g, reason: collision with root package name */
    public static long f283419g = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: h, reason: collision with root package name */
    public static long f283420h = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: i, reason: collision with root package name */
    public static long f283421i = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: j, reason: collision with root package name */
    public static long f283422j = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: k, reason: collision with root package name */
    public static long f283423k = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: l, reason: collision with root package name */
    public static long f283424l = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: m, reason: collision with root package name */
    public static long f283425m = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: n, reason: collision with root package name */
    public static long f283426n = SearchConfig.fieldNewTroopRemark << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: o, reason: collision with root package name */
    public static long f283427o = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: p, reason: collision with root package name */
    public static long f283428p = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: q, reason: collision with root package name */
    public static long f283429q = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: r, reason: collision with root package name */
    public static long f283430r = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: s, reason: collision with root package name */
    public static long f283431s = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: t, reason: collision with root package name */
    public static long f283432t = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: u, reason: collision with root package name */
    public static long f283433u = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: v, reason: collision with root package name */
    public static long f283434v = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;

    /* renamed from: w, reason: collision with root package name */
    public static long f283435w = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;

    /* renamed from: x, reason: collision with root package name */
    public static long f283436x = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;

    /* renamed from: y, reason: collision with root package name */
    public static long f283437y = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;

    /* renamed from: z, reason: collision with root package name */
    public static long f283438z = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
    public static long A = SearchConfig.indexStartSegmentHit << SearchConfig.contactSearchIndexBaseBit;
    public static long B = SearchConfig.indexSegmentHit << SearchConfig.contactSearchIndexBaseBit;
    public static long C = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
    public static long D = SearchConfig.indexSegmentStartHit << SearchConfig.contactSearchIndexBaseBit;
    public static long E = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
    public static long F = 72057594037927936L;
    public static long G = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
    public static long H = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
    public static long I = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
    public static long J = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
    public static long K = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
    public static long L = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
    public static long M = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
    public static long N = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
    public static long O = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
    public static long P = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
    public static long Q = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
    public static long R = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
    public static long S = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
    public static long T = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
    public static long U = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
    public static long V = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
    public static long W = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
    public static long X = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
    public static long Y = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
    public static long Z = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;

    /* renamed from: a0, reason: collision with root package name */
    public static long f283412a0 = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;

    /* renamed from: b0, reason: collision with root package name */
    public static long f283413b0 = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;

    /* renamed from: c0, reason: collision with root package name */
    public static long f283414c0 = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;

    /* renamed from: d0, reason: collision with root package name */
    public static long f283415d0 = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;

    /* renamed from: e0, reason: collision with root package name */
    public static long f283417e0 = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;

    public static void k() {
        f283416e = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;
        f283418f = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;
        f283419g = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;
        f283420h = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;
        f283421i = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;
        f283422j = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;
        f283423k = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;
        f283424l = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;
        f283425m = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;
        f283427o = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;
        f283428p = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;
        f283429q = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;
        f283430r = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;
        f283431s = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;
        f283432t = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;
        f283433u = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;
        f283434v = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;
        f283435w = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;
        f283436x = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;
        f283437y = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;
        f283438z = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
        A = SearchConfig.indexStartSegmentHit << SearchConfig.contactSearchIndexBaseBit;
        B = SearchConfig.indexStartSegmentHit << SearchConfig.contactSearchIndexBaseBit;
        C = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
        D = SearchConfig.indexSegmentStartHit << SearchConfig.contactSearchIndexBaseBit;
        E = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
        F = 72057594037927936L;
        G = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
        H = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
        I = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
        J = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
        K = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
        L = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
        M = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
        N = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
        O = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
        P = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
        Q = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
        R = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
        S = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
        T = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
        U = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
        V = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
        W = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
        X = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
        Y = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
        Z = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;
        f283412a0 = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;
        f283413b0 = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;
        f283414c0 = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;
        f283415d0 = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;
        f283417e0 = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;
    }

    @Override // com.tencent.mobileqq.search.l
    public void a(long j3) {
        this.f283441c = j3;
    }

    @Override // com.tencent.mobileqq.search.l
    public long b() {
        return this.f283441c;
    }

    @Override // com.tencent.mobileqq.search.l
    public long c() {
        return e();
    }

    public abstract String d();

    public long e() {
        if (this.f283440b == -1) {
            this.f283440b = j();
        }
        return this.f283440b;
    }

    public boolean equals(Object obj) {
        if (this.f283439a == ((j) obj).f283439a) {
            return true;
        }
        return false;
    }

    public abstract String f();

    public abstract String g();

    public abstract Object h();

    public int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        try {
            String d16 = d();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < d16.length(); i3++) {
                char charAt = d16.charAt(i3);
                if (charAt >= '0' && charAt <= '9') {
                    sb5.append(charAt);
                }
            }
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(sb6)) {
                this.f283439a = Long.parseLong(sb6);
            } else {
                this.f283439a = hashCode();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            this.f283439a = hashCode();
        }
    }

    protected long j() {
        return 0L;
    }
}
