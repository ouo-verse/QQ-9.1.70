package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.upload.b;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.troop_homework.TroopHomeworkHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0006\u0018\u0000 +2\u00020\u0001:\u0001\u001bB4\u0012\u0006\u0010\u001f\u001a\u00020\u0011\u0012#\u0010(\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00130 \u00a2\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J;\u0010\u0016\u001a\u00020\u00132'\u0010\u0015\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010\u00a2\u0006\u0002\b\u0014H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR4\u0010(\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00130 8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWVideoCompressHelper;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "outVideoPath", "com/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWVideoCompressHelper$createProgressListener$1", "e", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWVideoCompressHelper$createProgressListener$1;", "Landroid/content/Context;", "context", "path", "Lcom/tencent/mobileqq/troop/homework/common/upload/b;", "progressListener", "", "d", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", h.F, "(Lkotlin/jvm/functions/Function2;)V", "", "f", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/ParameterName;", "name", "b", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "updateCallback", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWVideoCompressHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> updateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWVideoCompressHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWVideoCompressHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HWVideoCompressHelper(@NotNull CoroutineScope scope, @NotNull Function1<? super BaseItem, Unit> updateCallback) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) updateCallback);
        } else {
            this.scope = scope;
            this.updateCallback = updateCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(Context context, String path, String outVideoPath, b progressListener) {
        return TroopHomeworkHelper.e(context, path, outVideoPath, progressListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWVideoCompressHelper$createProgressListener$1] */
    public final HWVideoCompressHelper$createProgressListener$1 e(final VideoItem item, final String outVideoPath) {
        return new b(item, outVideoPath) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWVideoCompressHelper$createProgressListener$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ VideoItem f296748b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f296749c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f296748b = item;
                this.f296749c = outVideoPath;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, HWVideoCompressHelper.this, item, outVideoPath);
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.common.upload.b
            public void onFail() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                } else {
                    HWVideoCompressHelper hWVideoCompressHelper = HWVideoCompressHelper.this;
                    hWVideoCompressHelper.h(new HWVideoCompressHelper$createProgressListener$1$onFail$1(this.f296748b, hWVideoCompressHelper, null));
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.common.upload.b
            public void onProgress(int progress) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, progress);
                } else {
                    HWVideoCompressHelper hWVideoCompressHelper = HWVideoCompressHelper.this;
                    hWVideoCompressHelper.h(new HWVideoCompressHelper$createProgressListener$1$onProgress$1(this.f296748b, progress, hWVideoCompressHelper, null));
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.common.upload.b
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    HWVideoCompressHelper hWVideoCompressHelper = HWVideoCompressHelper.this;
                    hWVideoCompressHelper.h(new HWVideoCompressHelper$createProgressListener$1$onSuccess$1(this.f296748b, this.f296749c, hWVideoCompressHelper, null));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain(), null, block, 2, null);
    }

    @Nullable
    public final Object f(@NotNull VideoItem videoItem, @NotNull Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoItem, (Object) continuation);
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return Boxing.boxBoolean(false);
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new HWVideoCompressHelper$doCompress$2(videoItem, this, baseApplication, null), continuation);
    }

    @NotNull
    public final Function1<BaseItem, Unit> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function1) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.updateCallback;
    }
}
