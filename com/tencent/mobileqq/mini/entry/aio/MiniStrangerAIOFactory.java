package com.tencent.mobileqq.mini.entry.aio;

import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.DynamicPicHelper;
import com.tencent.mobileqq.aio.helper.MsgReadedHelper;
import com.tencent.mobileqq.aio.helper.MsgRelevantHelper;
import com.tencent.mobileqq.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.aio.helper.ad;
import com.tencent.mobileqq.aio.helper.at;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import com.tencent.qqnt.aio.factory.d;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import ol3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/aio/MiniStrangerAIOFactory;", "Lcom/tencent/qqnt/aio/factory/d;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniStrangerAIOFactory extends d {
    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    public f buildBusinessLevel() {
        return ((IAIOFactoryExtApi) QRoute.api(IAIOFactoryExtApi.class)).buildBusinessLevelCompactInputHeight(new f() { // from class: com.tencent.mobileqq.mini.entry.aio.MiniStrangerAIOFactory$buildBusinessLevel$1
            @Override // com.tencent.aio.api.factory.f
            public a<Object, Object> buildBottomBarVB() {
                return f.a.a(this);
            }

            @Override // com.tencent.aio.api.factory.f
            public List<a<? extends b, ? extends MviUIState>> buildBusinessVB() {
                return f.a.b(this);
            }

            @Override // com.tencent.aio.api.factory.f
            public a<Object, Object> buildShortcutBarVB() {
                return f.a.d(this);
            }

            @Override // com.tencent.aio.api.factory.f
            public a<Object, ? extends TitleUIState> buildTitleVB() {
                return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getTitleVB();
            }

            @Override // com.tencent.aio.api.factory.f
            public a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
                return f.a.f(this);
            }

            @Override // com.tencent.aio.api.factory.h
            public com.tencent.aio.api.b getLayoutDelegate() {
                return f.a.g(this);
            }

            @Override // com.tencent.aio.api.factory.f
            public MiniAIOInputContainerVB buildInputVB() {
                return new MiniAIOInputContainerVB();
            }
        });
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    public com.tencent.aio.api.help.d buildHelperProvider() {
        return new com.tencent.aio.api.help.d() { // from class: com.tencent.mobileqq.mini.entry.aio.MiniStrangerAIOFactory$buildHelperProvider$1
            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
            public h[] getLifeCycleHelper(com.tencent.aio.api.help.a aVar) {
                return d.a.b(this, aVar);
            }

            @Override // com.tencent.aio.api.help.d
            public Map<String, Function0<h>> getLifeCycleHelperCreator(com.tencent.aio.api.help.a aVar) {
                return d.a.c(this, aVar);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
            public com.tencent.aio.main.businesshelper.e[] getNormalHelper(com.tencent.aio.api.help.a aVar) {
                return d.a.e(this, aVar);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
            public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(com.tencent.aio.api.help.a aVar) {
                return d.a.f(this, aVar);
            }

            @Override // com.tencent.aio.api.help.d
            public h[] getLifeCycleHelper() {
                return new h[]{new com.tencent.mobileqq.aio.helper.provider.b(), new DynamicPicHelper(), new t(), new MsgReadedHelper(), new com.tencent.mobileqq.aio.reserve1.toptip.d(), new MultiForwardHelper(), new MsgRelevantHelper(), new at(), new MiniTempChatHelper(), new ad()};
            }

            @Override // com.tencent.aio.api.help.d
            public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
                return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getNormalHelper();
            }
        };
    }
}
