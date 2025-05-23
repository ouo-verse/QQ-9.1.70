package com.tencent.mobileqq.flock.publish.viewmodel;

import android.content.Intent;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishBaseViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Intent;", "i", "Landroid/content/Intent;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "N1", "()I", "from", "Ly45/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "M1", "()Ly45/b;", "feedDetail", "Lb55/g;", "D", "O1", "()Lb55/g;", "tagInfo", "<init>", "(Landroid/content/Intent;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FlockPublishBaseViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedDetail;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy tagInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Intent intent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int from;

    public FlockPublishBaseViewModel(@NotNull Intent intent) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.intent = intent;
        this.from = intent.getIntExtra("key_flock_from", 0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<y45.b>() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishBaseViewModel$feedDetail$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishBaseViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final y45.b invoke() {
                Intent intent2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (y45.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                intent2 = FlockPublishBaseViewModel.this.intent;
                byte[] byteArrayExtra = intent2.getByteArrayExtra("key_flock_detail_feed");
                if (byteArrayExtra == null) {
                    return null;
                }
                try {
                    return y45.b.d(byteArrayExtra);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
        this.feedDetail = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b55.g>() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishBaseViewModel$tagInfo$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishBaseViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final b55.g invoke() {
                Intent intent2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (b55.g) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                intent2 = FlockPublishBaseViewModel.this.intent;
                byte[] byteArrayExtra = intent2.getByteArrayExtra("key_flock_feed_tag");
                if (byteArrayExtra == null) {
                    return null;
                }
                try {
                    return b55.g.d(byteArrayExtra);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
        this.tagInfo = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final y45.b M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (y45.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (y45.b) this.feedDetail.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.from;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final b55.g O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b55.g) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (b55.g) this.tagInfo.getValue();
    }
}
