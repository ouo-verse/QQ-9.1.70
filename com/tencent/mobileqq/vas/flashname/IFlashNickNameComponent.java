package com.tencent.mobileqq.vas.flashname;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.msg.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\"J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H&JG\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H&Jk\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00052#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH&J?\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H&J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "width", "height", "", "colorValue", "", "isSingle", "Landroid/view/View;", "view", "Lx03/b;", "createFlashNickName", "isCenter", "", "playNickCoverAnimation", "animationUrl", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isViewLayoutRightInvoke", "playNickCoverAnimationWithSimpleMode", "loop", "isClipView", "scene", "Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent$a;", "listener", "addNickCover", "removeNickCover", "Lcom/tencent/qqnt/msg/d;", "msg", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "nickCoverKeyWordsDetect", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IFlashNickNameComponent extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent$a;", "", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IFlashNickNameComponent iFlashNickNameComponent, View view, String str, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    function1 = null;
                }
                iFlashNickNameComponent.addNickCover(view, str, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNickCover");
        }
    }

    void addNickCover(@NotNull View view);

    void addNickCover(@NotNull View view, @NotNull String animationUrl, @Nullable Function1<? super View, Boolean> isViewLayoutRightInvoke);

    @NotNull
    x03.b createFlashNickName(int width, int height, @NotNull String colorValue, boolean isSingle, @NotNull View view);

    void nickCoverKeyWordsDetect(@NotNull d msg2, @Nullable com.tencent.aio.api.runtime.a aioContext);

    void playNickCoverAnimation(@NotNull View view, boolean isCenter);

    void playNickCoverAnimation(@NotNull View view, boolean isCenter, @NotNull String animationUrl, int loop, boolean isClipView, @NotNull String scene, @Nullable Function1<? super View, Boolean> isViewLayoutRightInvoke, @Nullable a listener);

    void playNickCoverAnimationWithSimpleMode(@NotNull View view, boolean isCenter, @NotNull String animationUrl, @Nullable Function1<? super View, Boolean> isViewLayoutRightInvoke);

    void removeNickCover(@NotNull View view);
}
