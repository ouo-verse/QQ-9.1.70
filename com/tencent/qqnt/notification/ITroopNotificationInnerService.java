package com.tencent.qqnt.notification;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bJ\b\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/notification/ITroopNotificationInnerService;", "Lcom/tencent/qqnt/troop/ITroopNotificationRepoApi;", "Lmqq/app/api/IRuntimeService;", "", "initAfterNTCreated", "Lcom/tencent/qqnt/notification/f;", "getLatestMsg", "", "", "", "getFirstPageNotification", "newMsg", "updateNotificationMsg", "msg", "removeNotificationMsg", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "data", "saveNotificationMsg", "destroyNotificationMsg", "clearAllNotification", "category", "", "seq", "getNotificationMsgFromCache", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ITroopNotificationInnerService extends ITroopNotificationRepoApi, IRuntimeService {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int NUM_FIRST_SCREEN = 20;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/notification/ITroopNotificationInnerService$a;", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.ITroopNotificationInnerService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f359782a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62364);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359782a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(62366), (Class<?>) ITroopNotificationInnerService.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f359782a;
        }
    }

    void clearAllNotification();

    void destroyNotificationMsg(@NotNull LifecycleOwner owner);

    @NotNull
    Map<Integer, List<f>> getFirstPageNotification();

    @Nullable
    f getLatestMsg();

    @Nullable
    f getNotificationMsgFromCache(int category, long seq);

    void initAfterNTCreated();

    void removeNotificationMsg(@NotNull f msg2);

    void saveNotificationMsg(@NotNull LifecycleOwner owner, @NotNull List<f> data);

    void updateNotificationMsg(@NotNull f newMsg);
}
