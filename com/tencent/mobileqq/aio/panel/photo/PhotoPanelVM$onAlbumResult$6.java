package com.tencent.mobileqq.aio.panel.photo;

import android.text.TextUtils;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ab;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onAlbumResult$6", f = "PhotoPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class PhotoPanelVM$onAlbumResult$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AlbumResult $albumResult;
    final /* synthetic */ List<LocalMediaInfo> $selectList;
    int label;
    final /* synthetic */ PhotoPanelVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPanelVM$onAlbumResult$6(PhotoPanelVM photoPanelVM, List<LocalMediaInfo> list, AlbumResult albumResult, Continuation<? super PhotoPanelVM$onAlbumResult$6> continuation) {
        super(2, continuation);
        this.this$0 = photoPanelVM;
        this.$selectList = list;
        this.$albumResult = albumResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, photoPanelVM, list, albumResult, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PhotoPanelVM$onAlbumResult$6(this.this$0, this.$selectList, this.$albumResult, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        List list2;
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                if (8 == this.this$0.C()) {
                    List<LocalMediaInfo> list3 = this.$selectList;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = list3.iterator();
                    while (true) {
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
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            arrayList2.add(next);
                        }
                    }
                    if (arrayList2.size() >= 4) {
                        List<LocalMediaInfo> G = this.this$0.G();
                        ArrayList<LocalMediaInfo> arrayList3 = new ArrayList();
                        for (Object obj2 : G) {
                            String path2 = ((LocalMediaInfo) obj2).getPath();
                            if (path2 == null) {
                                path2 = "";
                            }
                            if (com.tencent.qqnt.aio.element.file.util.a.e(path2) != 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                arrayList3.add(obj2);
                            }
                        }
                        PhotoPanelVM photoPanelVM = this.this$0;
                        for (LocalMediaInfo localMediaInfo : arrayList3) {
                            QLog.d("PhotoPanelVM", 1, "onAlbumResult myComputerSendFileFromPhoto: " + localMediaInfo.getPath());
                            IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                            String j3 = ((com.tencent.aio.api.runtime.a) photoPanelVM.getMContext()).g().r().c().j();
                            String path3 = localMediaInfo.getPath();
                            Intrinsics.checkNotNull(path3);
                            iMyComputerHelpApi.myComputerSendFileFromPhoto(j3, path3);
                        }
                        QLog.d("PhotoPanelVM", 1, "onAlbumResult myComputerSendMultiFileFromPhoto: " + this.$selectList.size());
                        IMyComputerHelpApi iMyComputerHelpApi2 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                        String j16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g().r().c().j();
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            String path4 = ((LocalMediaInfo) it5.next()).getPath();
                            Intrinsics.checkNotNull(path4);
                            arrayList4.add(path4);
                        }
                        iMyComputerHelpApi2.myComputerSendMultiFileFromPhoto(j16, arrayList4);
                    } else {
                        List<LocalMediaInfo> list4 = this.$selectList;
                        PhotoPanelVM photoPanelVM2 = this.this$0;
                        for (LocalMediaInfo localMediaInfo2 : list4) {
                            QLog.d("PhotoPanelVM", 1, "onAlbumResult myComputerSendFileFromPhoto: " + localMediaInfo2.getPath());
                            IMyComputerHelpApi iMyComputerHelpApi3 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                            String j17 = ((com.tencent.aio.api.runtime.a) photoPanelVM2.getMContext()).g().r().c().j();
                            String path5 = localMediaInfo2.getPath();
                            Intrinsics.checkNotNull(path5);
                            iMyComputerHelpApi3.myComputerSendFileFromPhoto(j17, path5);
                        }
                    }
                } else {
                    for (LocalMediaInfo localMediaInfo3 : this.$selectList) {
                        if (ab.a(this.this$0.C(), localMediaInfo3, this.$albumResult.g())) {
                            ox3.a.a("PhotoPanelVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onAlbumResult$6.5
                                static IPatchRedirector $redirector_;

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
                                    return "onAlbumResult transFileToSend: " + LocalMediaInfo.this.getPath();
                                }
                            });
                            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e();
                            String path6 = localMediaInfo3.getPath();
                            Intrinsics.checkNotNull(path6);
                            e16.h(new AIOMsgSendEvent.FileSendEvent(path6));
                        } else {
                            arrayList.add(WrapLocalMediaInfoKt.d(WrapLocalMediaInfoKt.j(localMediaInfo3)));
                        }
                    }
                }
                if (!TextUtils.isEmpty(this.$albumResult.a())) {
                    ox3.a.c("PhotoPanelVM", new Function0<String>(arrayList) { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onAlbumResult$6.6
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ List<com.tencent.mobileqq.album.media.c> $pickResultList;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$pickResultList = arrayList;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) arrayList);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "onAlbumResult real send MixEvent. list:" + this.$pickResultList.size();
                        }
                    });
                    com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e();
                    list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                    boolean g16 = this.$albumResult.g();
                    String a16 = this.$albumResult.a();
                    Intrinsics.checkNotNull(a16);
                    e17.h(new AIOMsgSendEvent.SendAlbumMixEvent(list2, g16, a16));
                } else if (!arrayList.isEmpty()) {
                    ox3.a.c("PhotoPanelVM", new Function0<String>(arrayList) { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onAlbumResult$6.7
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ List<com.tencent.mobileqq.album.media.c> $pickResultList;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$pickResultList = arrayList;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) arrayList);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "onAlbumResult real send mediaEvent. list:" + this.$pickResultList.size();
                        }
                    });
                    com.tencent.mvi.base.route.j e18 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e();
                    list = CollectionsKt___CollectionsKt.toList(arrayList);
                    e18.h(new AIOMsgSendEvent.SendAlbumMediaEvent(list, this.$albumResult.g(), this.$albumResult.f()));
                }
                ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PhotoPanelVM", false, 2, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PhotoPanelVM$onAlbumResult$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
