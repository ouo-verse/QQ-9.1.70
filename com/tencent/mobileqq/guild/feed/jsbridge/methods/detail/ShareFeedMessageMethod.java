package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedShareSuccessEvent;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ShareFeedMessageMethod extends b {

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private static class InvokeResult {

        @SerializedName("ret")
        public int code;

        InvokeResult() {
        }

        public static InvokeResult create(int i3) {
            InvokeResult invokeResult = new InvokeResult();
            invokeResult.code = i3;
            return invokeResult;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    private long r(String str) {
        String g16 = g(str);
        if (!TextUtils.isEmpty(g16)) {
            try {
                return Long.parseLong(g16);
            } catch (NumberFormatException unused) {
                QLog.d("ShareFeedMessageMethod", 1, "[getArgLongValue] key = " + str + ", value = " + g16);
                return -1L;
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "shareFeedMessage";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        String str4;
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        GuildFeedArkShareInfo s16 = com.tencent.mobileqq.guild.feed.share.v.s(g("shareInfo"));
        s16.M(g("channel_id"));
        s16.d0(g("guild_id"));
        s16.p0(g("shareTitle"));
        s16.h0(g("shareDesc"));
        s16.o0(g("shareImgUrl"));
        s16.b0(g("feedId"));
        long r16 = r("posterTinyId");
        if (r16 != -1) {
            s16.j0(r16);
        }
        long r17 = r(WadlProxyConsts.CREATE_TIME);
        if (r17 != -1) {
            s16.Z(r17);
        }
        if (b("needOpenWeb")) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        s16.g0(str4);
        l3.showShare(this.f423064e.mRuntime.a(), s16);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedShareSuccessEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedShareSuccessEvent) {
            i(InvokeResult.create(1).toJson());
        }
    }
}
