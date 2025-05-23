package nd2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends j {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f419968a = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getGuildTaskProgressStateClass();

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Class intercept(Interceptor.Chain<Class> chain) {
        if (GuildTaskProgressState.TABLE_NAME.equals(a(chain))) {
            return f419968a;
        }
        return chain.proceed();
    }
}
