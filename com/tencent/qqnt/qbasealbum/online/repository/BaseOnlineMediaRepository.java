package com.tencent.qqnt.qbasealbum.online.repository;

import android.content.Context;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0003 !\"B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J#\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0014H\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0017J\b\u0010\u001c\u001a\u00020\u0004H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository;", "Ljava/io/Serializable;", "Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$c;", "mediaQueryListener", "", "queryMedia", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "", "isOnlineAssetExist", "", "getOnlineAssetPath", "Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$b;", "downloadListener", "downloadOnlineAsset", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "", "mediaInfos", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "callback", "downloadAssetsWithLoadingDialog", "mediaInfo", "downloadAssets", "onClear", "<init>", "()V", "Companion", "a", "b", "c", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class BaseOnlineMediaRepository implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$a;", "", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.online.repository.BaseOnlineMediaRepository$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$b;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository$c;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseOnlineMediaRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* synthetic */ Object downloadOnlineAsset$suspendImpl(BaseOnlineMediaRepository baseOnlineMediaRepository, LocalMediaInfo localMediaInfo, b bVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @MainThread
    public void downloadAssets(@NotNull LocalMediaInfo mediaInfo, @Nullable b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) mediaInfo, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        }
    }

    @MainThread
    public void downloadAssetsWithLoadingDialog(@NotNull Context context, @NotNull List<LocalMediaInfo> mediaInfos, @NotNull Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, mediaInfos, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Nullable
    public Object downloadOnlineAsset(@NotNull LocalMediaInfo localMediaInfo, @NotNull b bVar, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, localMediaInfo, bVar, continuation);
        }
        return downloadOnlineAsset$suspendImpl(this, localMediaInfo, bVar, continuation);
    }

    @NotNull
    public String getOnlineAssetPath(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) localMediaInfo);
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        return "";
    }

    public boolean isOnlineAssetExist(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        return false;
    }

    public void onClear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void queryMedia(@NotNull c mediaQueryListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaQueryListener);
        } else {
            Intrinsics.checkNotNullParameter(mediaQueryListener, "mediaQueryListener");
        }
    }
}
