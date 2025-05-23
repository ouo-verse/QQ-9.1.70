package com.tencent.qqnt.aio.api;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H&J.\u0010\n\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006H&J\u0018\u0010\u000e\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\r0\u0002H&J\u0018\u0010\u000f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\f0\u0002H&J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H&J\b\u0010\u0013\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\f0\u0002H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOUniversalBusinessVB;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "getInputContainerVB", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputAdornApi", "", "enableExpandable", "getInputContainerVBWithAdornApi", "getC2CTempChatAdornApi", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "getTitleVB", "getShortcutBarVB", "inputBarAdornApi", "Lcom/tencent/aio/api/factory/f;", "getDefaultBusinessLevel", "getGroupAIOThirdLevelFactory", "getGroupAIOBottomBarVB", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOUniversalBusinessVB extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ com.tencent.aio.base.mvvm.a a(IAIOUniversalBusinessVB iAIOUniversalBusinessVB, com.tencent.mobileqq.aio.input.adorn.a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iAIOUniversalBusinessVB.getInputContainerVBWithAdornApi(aVar, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInputContainerVBWithAdornApi");
        }
    }

    @NotNull
    com.tencent.mobileqq.aio.input.adorn.a<?> getC2CTempChatAdornApi();

    @NotNull
    com.tencent.aio.api.factory.f getDefaultBusinessLevel(@Nullable com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi);

    @NotNull
    com.tencent.aio.base.mvvm.a<Object, Object> getGroupAIOBottomBarVB();

    @NotNull
    com.tencent.aio.api.factory.f getGroupAIOThirdLevelFactory();

    @NotNull
    com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> getInputContainerVB();

    @NotNull
    com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> getInputContainerVBWithAdornApi(@NotNull com.tencent.mobileqq.aio.input.adorn.a<?> inputAdornApi, boolean enableExpandable);

    @NotNull
    com.tencent.aio.base.mvvm.a<Object, Object> getShortcutBarVB();

    @NotNull
    com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> getTitleVB();
}
