package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.upload.HWPosterUploader;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bi\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\u001a\u0012#\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\u001a\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R1\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR1\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001f\u0010$R\u001b\u0010(\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b\"\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWUploaderWrapper;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "i", "", "j", "c", "", "a", "I", "d", "()I", "cmd", "", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "g", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "progressCallback", "e", "statusCallback", "Lcom/tencent/mobileqq/troop/homework/common/upload/a;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/troop/homework/common/upload/a;", "itemUploader", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWPosterUploader;", "()Lcom/tencent/mobileqq/troop/homework/common/upload/HWPosterUploader;", "posterUploader", "<init>", "(ILjava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWUploaderWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> progressCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseItem, Unit> statusCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy itemUploader;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy posterUploader;

    public HWUploaderWrapper(int i3, @NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull Function1<? super BaseItem, Unit> progressCallback, @NotNull Function1<? super BaseItem, Unit> statusCallback) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), troopUin, scope, progressCallback, statusCallback);
            return;
        }
        this.cmd = i3;
        this.troopUin = troopUin;
        this.scope = scope;
        this.progressCallback = progressCallback;
        this.statusCallback = statusCallback;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.homework.common.upload.a>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWUploaderWrapper$itemUploader$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWUploaderWrapper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.homework.common.upload.a invoke() {
                Function1 function1;
                Function1 function12;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.homework.common.upload.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                int d16 = HWUploaderWrapper.this.d();
                String h16 = HWUploaderWrapper.this.h();
                function1 = HWUploaderWrapper.this.progressCallback;
                function12 = HWUploaderWrapper.this.statusCallback;
                return new com.tencent.mobileqq.troop.homework.common.upload.a(d16, h16, function1, function12);
            }
        });
        this.itemUploader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HWPosterUploader>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWUploaderWrapper$posterUploader$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWUploaderWrapper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HWPosterUploader invoke() {
                Function1 function1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HWPosterUploader) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                int d16 = HWUploaderWrapper.this.d();
                String h16 = HWUploaderWrapper.this.h();
                CoroutineScope g16 = HWUploaderWrapper.this.g();
                Function1<BaseItem, Unit> function12 = new Function1<BaseItem, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWUploaderWrapper$posterUploader$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) HWUploaderWrapper.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                        invoke2(baseItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull BaseItem item) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) item);
                        } else {
                            Intrinsics.checkNotNullParameter(item, "item");
                            HWUploaderWrapper.this.i(item);
                        }
                    }
                };
                function1 = HWUploaderWrapper.this.progressCallback;
                return new HWPosterUploader(d16, h16, g16, function12, function1);
            }
        });
        this.posterUploader = lazy2;
    }

    private final com.tencent.mobileqq.troop.homework.common.upload.a e() {
        return (com.tencent.mobileqq.troop.homework.common.upload.a) this.itemUploader.getValue();
    }

    private final HWPosterUploader f() {
        return (HWPosterUploader) this.posterUploader.getValue();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            f().e();
            e().b();
        }
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.cmd;
    }

    @NotNull
    public final CoroutineScope g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.scope;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    public boolean i(@NotNull BaseItem item) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof VideoItem) {
            String posterHttpUrl = ((VideoItem) item).getPosterHttpUrl();
            if (posterHttpUrl != null && posterHttpUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                item.setState(UploadOrDownloadState.UPLOADING);
                return f().f((VideoItem) item);
            }
        }
        if (e().c(item)) {
            item.setState(UploadOrDownloadState.UPLOADING);
        } else {
            item.setState(UploadOrDownloadState.UPLOAD_ERR);
        }
        return true;
    }

    public void j(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof VideoItem) {
            f().g((VideoItem) item);
        }
        e().d(item);
    }
}
