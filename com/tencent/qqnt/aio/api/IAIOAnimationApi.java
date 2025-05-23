package com.tencent.qqnt.aio.api;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOAnimationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onAIOAnimationEnd", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/tencent/qqnt/aio/api/IAIOAnimationApi$AnimationScene;", "onAIOAnimationStart", "AnimationScene", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOAnimationApi extends QRouteApi {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOAnimationApi$AnimationScene;", "", "(Ljava/lang/String;I)V", "AIO_ENTER", "AIO_EXIT", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class AnimationScene {
        private static final /* synthetic */ AnimationScene[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AnimationScene AIO_ENTER;
        public static final AnimationScene AIO_EXIT;

        private static final /* synthetic */ AnimationScene[] $values() {
            return new AnimationScene[]{AIO_ENTER, AIO_EXIT};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50476);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            AIO_ENTER = new AnimationScene("AIO_ENTER", 0);
            AIO_EXIT = new AnimationScene("AIO_EXIT", 1);
            $VALUES = $values();
        }

        AnimationScene(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static AnimationScene valueOf(String str) {
            return (AnimationScene) Enum.valueOf(AnimationScene.class, str);
        }

        public static AnimationScene[] values() {
            return (AnimationScene[]) $VALUES.clone();
        }
    }

    void onAIOAnimationEnd(@Nullable FragmentActivity activity, @NotNull AnimationScene scene);

    void onAIOAnimationStart(@Nullable FragmentActivity activity, @NotNull AnimationScene scene);
}
