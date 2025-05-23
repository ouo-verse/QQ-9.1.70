package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.List;
import xt1.l;
import xt1.n;
import xt1.o;
import xt1.p;
import xt1.q;
import xt1.r;
import xt1.s;
import xt1.t;
import xt1.u;
import xt1.v;
import xt1.w;
import xt1.x;
import xt1.y;
import xt1.z;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgSummaryDecodersApiImpl implements IGuildMsgSummaryDecodersApi {
    List<com.tencent.imcore.message.decoder.j> mMessageDecoders;

    private void registerDecoders() {
        ArrayList arrayList = new ArrayList();
        this.mMessageDecoders = arrayList;
        arrayList.add(new z());
        this.mMessageDecoders.add(new xt1.g());
        this.mMessageDecoders.add(new p());
        this.mMessageDecoders.add(new o());
        this.mMessageDecoders.add(new n());
        this.mMessageDecoders.add(new xt1.h());
        this.mMessageDecoders.add(new r());
        this.mMessageDecoders.add(new s());
        this.mMessageDecoders.add(new xt1.d());
        this.mMessageDecoders.add(new xt1.a());
        this.mMessageDecoders.add(new y());
        this.mMessageDecoders.add(new x());
        this.mMessageDecoders.add(new t());
        this.mMessageDecoders.add(new xt1.e());
        this.mMessageDecoders.add(new u());
        this.mMessageDecoders.add(new v());
        this.mMessageDecoders.add(new q());
        this.mMessageDecoders.add(new w());
        this.mMessageDecoders.add(new xt1.j());
        this.mMessageDecoders.add(new xt1.b());
        this.mMessageDecoders.add(new l());
        this.mMessageDecoders.add(new xt1.f());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi
    public CharSequence decodeMsg(MsgAbstract msgAbstract, String str) {
        return iu1.b.f408754a.b(msgAbstract, str);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi
    public synchronized List<com.tencent.imcore.message.decoder.j> getMsgSummaryDecoders() {
        if (this.mMessageDecoders == null) {
            registerDecoders();
        }
        return this.mMessageDecoders;
    }
}
