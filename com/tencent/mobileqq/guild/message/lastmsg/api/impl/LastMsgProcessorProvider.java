package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes14.dex */
public class LastMsgProcessorProvider implements Provider<List<e>> {

    /* renamed from: a, reason: collision with root package name */
    private List<e> f230633a;

    public LastMsgProcessorProvider(AppRuntime appRuntime) {
        this.f230633a = new ArrayList<e>(appRuntime) { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.LastMsgProcessorProvider.1
            final /* synthetic */ AppRuntime val$app;

            {
                this.val$app = appRuntime;
                add(new f(appRuntime));
                add(new a(appRuntime));
            }
        };
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<e> get() {
        return this.f230633a;
    }
}
