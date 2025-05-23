package com.tencent.mobileqq.aio.panel.photo;

import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.panel.photo.g;
import com.tencent.mobileqq.album.media.AIOMediaRepository;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ab;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$sendSelectMediaInfo$2", f = "PhotoPanelVM.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class PhotoPanelVM$sendSelectMediaInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $quality;
    int label;
    final /* synthetic */ PhotoPanelVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPanelVM$sendSelectMediaInfo$2(PhotoPanelVM photoPanelVM, boolean z16, Continuation<? super PhotoPanelVM$sendSelectMediaInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = photoPanelVM;
        this.$quality = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, photoPanelVM, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PhotoPanelVM$sendSelectMediaInfo$2(this.this$0, this.$quality, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object obj2;
        a aVar;
        int collectionSizeOrDefault;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (8 == this.this$0.C()) {
                    List<LocalMediaInfo> G = this.this$0.G();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = G.iterator();
                    while (true) {
                        boolean z17 = false;
                        String str = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        String path = ((LocalMediaInfo) next).getPath();
                        if (path != null) {
                            str = path;
                        }
                        if (com.tencent.qqnt.aio.element.file.util.a.e(str) == 0) {
                            z17 = true;
                        }
                        if (z17) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() >= 4) {
                        List<LocalMediaInfo> G2 = this.this$0.G();
                        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList();
                        for (Object obj3 : G2) {
                            String path2 = ((LocalMediaInfo) obj3).getPath();
                            if (path2 == null) {
                                path2 = "";
                            }
                            if (com.tencent.qqnt.aio.element.file.util.a.e(path2) != 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                arrayList2.add(obj3);
                            }
                        }
                        PhotoPanelVM photoPanelVM = this.this$0;
                        for (LocalMediaInfo localMediaInfo : arrayList2) {
                            QLog.d("PhotoPanelVM", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + localMediaInfo.getPath());
                            IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                            String j3 = ((com.tencent.aio.api.runtime.a) photoPanelVM.getMContext()).g().r().c().j();
                            String path3 = localMediaInfo.getPath();
                            Intrinsics.checkNotNull(path3);
                            iMyComputerHelpApi.myComputerSendFileFromPhoto(j3, path3);
                        }
                        QLog.d("PhotoPanelVM", 1, "sendSelectMediaInfo myComputerSendMultiFileFromPhoto: " + this.this$0.G().size());
                        IMyComputerHelpApi iMyComputerHelpApi2 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                        String j16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g().r().c().j();
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            String path4 = ((LocalMediaInfo) it5.next()).getPath();
                            Intrinsics.checkNotNull(path4);
                            arrayList3.add(path4);
                        }
                        iMyComputerHelpApi2.myComputerSendMultiFileFromPhoto(j16, arrayList3);
                    } else {
                        List<LocalMediaInfo> G3 = this.this$0.G();
                        PhotoPanelVM photoPanelVM2 = this.this$0;
                        for (LocalMediaInfo localMediaInfo2 : G3) {
                            QLog.d("PhotoPanelVM", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + localMediaInfo2.getPath());
                            IMyComputerHelpApi iMyComputerHelpApi3 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                            String j17 = ((com.tencent.aio.api.runtime.a) photoPanelVM2.getMContext()).g().r().c().j();
                            String path5 = localMediaInfo2.getPath();
                            Intrinsics.checkNotNull(path5);
                            iMyComputerHelpApi3.myComputerSendFileFromPhoto(j17, path5);
                        }
                    }
                    this.this$0.repository.c();
                    this.this$0.y();
                    return Unit.INSTANCE;
                }
                List<LocalMediaInfo> G4 = this.this$0.G();
                PhotoPanelVM photoPanelVM3 = this.this$0;
                boolean z18 = this.$quality;
                Iterator<T> it6 = G4.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        obj2 = it6.next();
                        if (ab.a(photoPanelVM3.C(), (LocalMediaInfo) obj2, z18)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                if (obj2 == null) {
                    AIOMediaRepository aIOMediaRepository = this.this$0.repository;
                    this.label = 1;
                    obj = aIOMediaRepository.f(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    List<LocalMediaInfo> G5 = this.this$0.G();
                    PhotoPanelVM photoPanelVM4 = this.this$0;
                    boolean z19 = this.$quality;
                    for (final LocalMediaInfo localMediaInfo3 : G5) {
                        if (!ab.a(photoPanelVM4.C(), localMediaInfo3, z19)) {
                            aVar = photoPanelVM4.mPhotoPanel;
                            aVar.v0(new g.h(localMediaInfo3, true));
                        } else {
                            ox3.a.a("PhotoPanelVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$sendSelectMediaInfo$2$6$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final String invoke() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                    }
                                    return "sendSelectMediaInfo transFileToSend " + LocalMediaInfo.this.getPath();
                                }
                            });
                            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) photoPanelVM4.getMContext()).e();
                            String path6 = localMediaInfo3.getPath();
                            Intrinsics.checkNotNull(path6);
                            e16.h(new AIOMsgSendEvent.FileSendEvent(path6));
                        }
                    }
                    this.this$0.repository.c();
                    this.this$0.y();
                    return Unit.INSTANCE;
                }
            }
            List list = (List) obj;
            QLog.d("PhotoPanelVM", 1, "sendSelectMediaInfo selectMd5Result-> " + list);
            ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e().h(new AIOMsgSendEvent.MediaSendEvent(list, this.$quality, false, false, 12, null));
            this.this$0.repository.c();
            this.this$0.y();
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PhotoPanelVM$sendSelectMediaInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
