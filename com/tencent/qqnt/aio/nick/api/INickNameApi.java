package com.tencent.qqnt.aio.nick.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/nick/api/INickNameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEmotionNickName", "", "name", "emoSize", "", "getPurePlainText", "lengthLimit", "", "measureNickName", "", "remarkPriorityFirst", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface INickNameApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ CharSequence a(INickNameApi iNickNameApi, CharSequence charSequence, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iNickNameApi.getPurePlainText(charSequence, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPurePlainText");
        }
    }

    @NotNull
    CharSequence getEmotionNickName(@NotNull CharSequence name, int emoSize);

    @NotNull
    CharSequence getPurePlainText(@NotNull CharSequence name, boolean lengthLimit);

    float measureNickName(@NotNull CharSequence name, int emoSize);

    boolean remarkPriorityFirst();
}
