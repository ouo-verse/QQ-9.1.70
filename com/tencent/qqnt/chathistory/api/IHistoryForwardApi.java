package com.tencent.qqnt.chathistory.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IHistoryForwardApi;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chathistory/api/a;", SessionDbHelper.SESSION_ID, "", "tabCategory", "Landroid/os/Bundle;", "bundle", "", "jumpHistoryTab", "TabCategory", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface IHistoryForwardApi {

    /* compiled from: P */
    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IHistoryForwardApi$TabCategory;", "", "Companion", "a", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TabCategory {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int Date = 5;
        public static final int Document = 4;
        public static final int Link = 3;
        public static final int Media = 1;
        public static final int ShortVideo = 6;
        public static final int Sticker = 2;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IHistoryForwardApi$TabCategory$a;", "", "<init>", "()V", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chathistory.api.IHistoryForwardApi$TabCategory$a, reason: from kotlin metadata */
        /* loaded from: classes23.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f353276a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39086);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f353276a = new Companion();
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
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39089), (Class<?>) TabCategory.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f353276a;
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IHistoryForwardApi iHistoryForwardApi, Context context, com.tencent.qqnt.chathistory.api.a aVar, int i3, Bundle bundle, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    bundle = null;
                }
                iHistoryForwardApi.jumpHistoryTab(context, aVar, i3, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jumpHistoryTab");
        }
    }

    void jumpHistoryTab(@NotNull Context context, @NotNull com.tencent.qqnt.chathistory.api.a session, int tabCategory, @Nullable Bundle bundle);
}
